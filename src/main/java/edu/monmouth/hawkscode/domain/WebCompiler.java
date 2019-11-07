package edu.monmouth.hawkscode.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * A simple web-based compiler for the HawksCode online tutoring platform.
 * Typical usage of this class is within @PostMapping methods of Controller
 * classes.
 * 
 * When a user is on a Challenge Page, they are able to enter code into a text
 * box to solve a specific problem.  This code will then be compiled and tested
 * by an instance of this class.  
 * 
 * @author Todd A. Qualiano
 */
public class WebCompiler {

	private String userInput;
	private File errorMessages;
	private List<String> mainOutput;
	private InputStream codeInputStream;
	private boolean forSystemOut; //Matt code to iron out
	//private boolean forToString;
	
	public List<String> getMainOutput() {
		return this.mainOutput;
	}
	
	public void setMainOutput(List<String> mainOutput) {
		this.mainOutput = mainOutput;
	}

	public String getUserInput() {
		return this.userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public void setCodeInputStream(InputStream codeInputStream) {
		this.codeInputStream = codeInputStream;
	}

	public File getErrorMessages() {
		return this.errorMessages;
	}
	
	public void setForSystemOut(boolean forSystemOut) {
		this.forSystemOut=forSystemOut;
	}

	public boolean getForSystemOut() {
		return this.forSystemOut;
	}
	/*	 Some methods from Matt to iron out in future.
	public boolean getForToString() {
		return forToString;
	}
	
	public void setForToString(boolean forToString) {
		this.forToString = forToString;
	}
		*/


	/**
	 * Combines userInput and baseCode.  The baseCode is predefined code written by
	 * the authors of HawksCode.monmouth.edu which will test the correctness of the
	 * userInput.  
	 * 
	 * Once the variables are combined, this method will compile the combined code.
	 * If the compilation fails, there is assumed to be errors in the userInput and
	 * the output of the Java compiler will become visible to them. If the compilation
	 * is successful, this method will invoke runCode().
	 * 
	 * @param fileName Name of the .java file we will Compile then Execute
	 * @return 0 if the compilation was a success, non-zero if compilation failed
	 * @throws FileNotFoundException
	 */
	public int webCompile(String fileName) throws FileNotFoundException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		String theClass = ".class";
		// DEPLOYMENT

		this.errorMessages = new File("/usr/share/tomcat/dump/errors.txt");
		fileName = "/usr/share/tomcat/dump/" + fileName;

//		 // PRODUCTION
		this.errorMessages = new File("errrorMessages.txt");
	
		File compileMe = new File(fileName);
		Scanner scan = new Scanner(this.codeInputStream);
		PrintWriter compileWriter = new PrintWriter(compileMe);

		while (scan.hasNextLine()) {
			String line = scan.nextLine().replaceAll("^\\s+", ""); // removes leading whitespace
			if (line.equals("//INJECT HERE")) {
				compileWriter.println(this.userInput);
			} else {
				compileWriter.println(line);
			}
		}
		scan.close();
		compileWriter.flush();
		compileWriter.close();
	
		FileOutputStream errorOutput = new FileOutputStream(errorMessages.getAbsolutePath());
		int success = compiler.run(null, null, errorOutput, compileMe.getAbsolutePath());
		if (success == 0) {// compiled with no errors
			//System.out.println("Compileut Successful!!\nCalling temp()");
			if(securityCheck(userInput)) {
        		//System.out.println("Security issue detected");
        		LinkedList<String> secIssue = new LinkedList<>();
        		secIssue.add("One or more of the classes you've used are not needed to complete this challenge.");
        		secIssue.add("Try using a simpler approach.");
        		this.mainOutput = secIssue;
        		return success; 
        	}
        	else{
        		runCode(fileName);
        		}
			String fileWithClass = fileName.substring(0,fileName.length()-5);
        	fileWithClass = fileWithClass + theClass;
        	File compileClass = new File(fileWithClass); //Deletes the .class file 
        	if (compileClass.exists()) {
        		compileClass.delete();
        		}
		} else {
			//System.out.println("Compiled with errors! See ErrorMessages.txt");
		}
		compileMe.delete(); //Deletes the .java file   
		//errorMessages.delete(); //Throws error for some reason.
		return success;
	}

	/**
	 * This method will run the combined baseCode and userInput file.  It creates
	 * a new Process to act as the execution environment for the new Java code. This
	 * Process has at most 5 seconds to execute before forcible termination of the
	 * process is enforced.
	 * 
	 * The baseCode will evaluate the correctness of the userInput and return a score.
	 * Users will see how many test methods they passed.
	 * 
	 * @param fileName Name of the file to execute
	 */
	public boolean securityCheck(String str) {
		boolean detected = false;
		List<String> lines = new LinkedList<String>(); // Used to check for Java.lang classes
		lines.add("Process");
		//lines.add("Class");
		lines.add("System");
		lines.add("ClassLoader");
		lines.add("Compiler");
		lines.add("Package");
		lines.add("package");
		lines.add("ProcessBuilder");
		lines.add("Runtime");
		lines.add("RuntimePermissions");
		lines.add("SecurityManager");
		lines.add("Thread");
		lines.add("ThreadGroup");
		lines.add("ThreadLocal");
		lines.add("InheritableThreadLocal");
		lines.add("import");
		StringTokenizer sToken = new StringTokenizer(str);	
		while(sToken.hasMoreTokens()) {
			String check = sToken.nextToken();
			for (int i =0; i<lines.size();i++) {
				if(check.contains(lines.get(i))) {
					if(check.contains("System.out.print")) {
						this.forSystemOut = true;
					} else {
						detected = true;
					}
					
				}
				
				/*
				if (check.contains("toString")) {
					setForToString(true);
					
				}*/
				// Runtime, System
			}// End of for loop
		}// End of while loop
		if (this.forSystemOut && detected) {
			return true;
		}
		else if(detected) {
			return true;
		}else {
			return false;
		}
	}
	
	
	private void runCode(String fileName) {
		Process javaProcess = null;
		BufferedReader inStream = null;
		System.out.println("Invoking 'java " + fileName + "' command");
		boolean success = true;
		try {
			String toExecute = "java " + fileName;
			long patience = 5000; // five second time limit
			long startTime = System.currentTimeMillis();
			javaProcess = Runtime.getRuntime().exec(toExecute);
			while (javaProcess.isAlive()) {
				if (((System.currentTimeMillis() - startTime) > patience) && javaProcess.isAlive()) {
					// print to catalina.out tomcat log
					//System.out.println("Java process took longer than " + "5 seconds to run...");
					//System.out.println("Auto shutdown...");
					javaProcess.destroyForcibly();
					success = false;
				}
			}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		try {
			if (success) {
				inStream = new BufferedReader(new InputStreamReader(javaProcess.getInputStream()));
				Stream<String> lines = inStream.lines();
				this.mainOutput = lines.collect(Collectors.toList());

			} else {
				//print for user
				String temp0 = "Process ran longer than 5 seconds and was forcibly destroyed.";
				String temp1 = "This may mean that your code has an infinite loop or a control"
						+ "flow mechanism that is taking too long to complete.";
				String temp2 = "Please check code for errors and try again!";
				List<String> loopOut = new LinkedList<>();
				loopOut.add(temp0);
				loopOut.add(temp1);
				loopOut.add(temp2);
				this.mainOutput = loopOut;
			}
		} catch (Exception e) {
			System.err.println("Error on inStream.readLine()");
			e.printStackTrace();
		}
		
	}
	
}
