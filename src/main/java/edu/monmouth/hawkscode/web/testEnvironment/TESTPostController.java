package edu.monmouth.hawkscode.web.testEnvironment;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.monmouth.hawkscode.domain.WebCompiler;

@Controller
public class TESTPostController 
{
	/**
	 * @param compiler  our WebCompiler class
	 * @param baseCode  reference to the baseCode we wrote for the challenge
	 * @param className name of the file that we are going to compile
	 * @return
	 * @throws FileNotFoundException
	 */
	
	private String setCompiler(WebCompiler compiler, ModelMap model, String baseCodePath, String className) throws FileNotFoundException 
	{
		InputStream baseCode = getClass().getClassLoader().getResourceAsStream(baseCodePath);
		List<String> output = runCompiler(compiler, baseCode, className);
		model.put("outList", output);
		String userInput = compiler.getUserInput();
		model.put("codeWritten", userInput);
		return "b-challenge";
	}
	
	private List<String> runCompiler(WebCompiler compiler,  InputStream baseCode, String className) throws FileNotFoundException 
	{
		System.out.println(compiler.getUserInput());
		compiler.setCodeInputStream(baseCode);
		int success = compiler.webCompile(className);
		List<String> output = new LinkedList<>();
		if (success != 0) {// failed to compile
			Scanner scan = new Scanner(compiler.getErrorMessages());
			while (scan.hasNext()) {
				String temp = scan.nextLine();
				output.add(temp);
			}
			scan.close();
			// model.put("errorOutList", errorOutput);
		} else {
			output = compiler.getMainOutput();
		}
		return output;
	}
	
	private String populateChallenge(ModelMap model, String header, String description) 
	{
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		return "b-challenge";
	}
	
	/*
	   String header = ""; 
	   String description = "";
	   populateChallenge(model, header, description);
	 */

	@PostMapping(value = "/testEnvironment/JustAMain/CodingSpace")
	public String testMainPost(@ModelAttribute WebCompiler compiler, ModelMap model)throws FileNotFoundException 
	{
		String header = "Test Environment: Main";
		String description = "";
		populateChallenge(model, header, description);
		return setCompiler(compiler, model, "static/testEnvironment/JustAMain/CodingSpace.txt", 
				"CodingSpace.java");
	}
}
