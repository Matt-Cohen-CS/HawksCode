package edu.monmouth.hawkscode.web.cs175;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.monmouth.hawkscode.domain.WebCompiler;
import edu.monmouth.hawkscode.web.MainController;

@Controller
public class CS175PostController 
{
	/**
	 * @param compiler  our WebCompiler class
	 * @param baseCode  reference to the baseCode we wrote for the challenge
	 * @param className name of the file that we are going to compile
	 * @return
	 * @throws FileNotFoundException
	 */
	
	@Autowired
	private MainController mc;
	
	private String populateChallenge(ModelMap model, String header, String description, String userInput) {
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		model.put("userInput", userInput);
		return "b-challenge";
	}
	private String populateChallenge(ModelMap model, String header, String description, String userInput, String boilerplate) {
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		model.put("boilerplate", boilerplate);
		model.put("userInput", userInput);
		return "b-challenge";
	}
	private String setCompiler(WebCompiler compiler, ModelMap model, String baseCodePath, String className)
			throws FileNotFoundException {
		InputStream baseCode = getClass().getClassLoader().getResourceAsStream(baseCodePath);
		List<String> output = runCompiler(compiler, baseCode, className);
		model.put("outList", output);
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
				if(temp.contains("/usr/share/tomcat/dump/")) {
					temp = temp.replace("/usr/share/tomcat/dump/", "");
				}
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
	   return setCompiler(compiler, model, "static/COURSE/CHALLENGE.txt"
				   , "CHALLENGE.java");
	 */
	
	// *********************************************
	// ************************ PRIMITIVE DATA TYPES
	// *********************************************

	/* Boolean */ 
	@PostMapping(value = "/home/cs175/Primitive Data Types/boolean/Declare Boolean")
	public String declareBooleanPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException{
		   String header = "Delclare a boolean Variable"; 
		   String description = "<div> \r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare a <samp>boolean</samp> called <i>myBol</i> and set its value to <samp>true</samp>.\r\n" + 
		   		"		</div> ";
			String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/boolean/DeclareBoolean.txt",
					"DeclareBoolean.java");
			     		return mc.CheckAndUpdateChallenge(("DeclareBoolean"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Primitive Data Types/boolean/Declare Print Boolean")
	public String declarePrintBooleanPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Print a boolean Variable"; 
		   String description = "<div class=\"introduction\">\r\n" + 
		   		"			<p class=\"topic-description\">\r\n" + 
		   		"				<h4>Description:</h4> \r\n" + 
		   		"				<p><samp>System.out.println();</b> might look intimidating to a new Java programmer, but it has a simple function. It is simply a way to tell Java to print the variable between the parentheses to the computer's terminal or console followed by a new line. We will unpack why it has to be written this way and how it works in future sections.  But for now, if you'd like your program to provide the user with output, use <samp>System.out.println();</samp>.</p>\r\n" + 
		   		"		\r\n" + 
		   		"			<p>EXAMPLE:</p>\r\n" + 
		   		"			<pre> \r\n" + 
		   		"			boolean running = true;\r\n" + 
		   		"			System.out.println( running );\r\n" + 
		   		"\r\n" + 
		   		"			System.out.println( \"true\" );\r\n" + 
		   		"			</pre>\r\n" + 
		   		"		</div> \r\n" + 
		   		"		\r\n" + 
		   		"		<div> \r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <samp>boolean</samp> called <i>myBol</i> and set its value to <samp>true</samp>. Using a print statement, \r\n" + 
		   		"			print the value of myBol using its variable name. <br/>"
		   		+ "         You should see the printed value to the right of the input window under <b>Output</b>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/boolean/DeclarePrintBoolean.txt",
					"DeclarePrintBoolean.java");
			     		return mc.CheckAndUpdateChallenge(("DeclarePrintBoolean"), "cs175", compiler, model);

	}
	
	/* Char */ 
	@PostMapping(value = "/home/cs175/Primitive Data Types/char/Declare Char")
	public String declareCharPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Declare a char Variable"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare a <samp>char</samp> called <i>myChar</i> and set its value to <samp>'A'</samp>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/char/DeclareChar.txt",
					"DeclareChar.java");
			     		return mc.CheckAndUpdateChallenge(("DeclareChar"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Primitive Data Types/char/Declare Print Char")
	public String declarePrintCharPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Print a char Variable"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <samp>char</samp> called <i>myChar</i> and set its value to <samp>'A'</samp>. Using a print statement, \r\n" + 
		   		"			print the variable using the variable name. Again, the value of the variable should be visible on"
		   		+ "         the right under <b>Output</b>.\r\n" + 
		   		"		</div>";		   
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/char/DeclarePrintChar.txt",
					"DeclarePrintChar.java");
			     		return mc.CheckAndUpdateChallenge(("DeclarePrintChar"), "cs175", compiler, model);

	}
	
	/* Integer */ 
	@PostMapping(value = "/home/cs175/Primitive Data Types/Numerical Primitives/Declare Integer")
	public String declareIntegerPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Declare an int Variable"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare an <samp>int</samp> variable called <i>myInt</i> and set its value to <samp>7</samp>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/numericalPrimitives/DeclareInteger.txt",
					"DeclareInteger.java");
			     		return mc.CheckAndUpdateChallenge(("DeclareInteger"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Primitive Data Types/Numerical Primitives/Declare Print Integer")
	public String declarePrintIntegerPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Print an int Variable"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare an <samp>int</samp> variable called <i>myInt</i> and set its value to <samp>7</samp>. Using a print statement, \r\n" + 
		   		"			print the variable value using the variable name.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();
		   populateChallenge(model, header, description, userInput);
		   setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/numericalPrimitives/DeclarePrintInteger.txt",
					"DeclarePrintInteger.java");
			     		return mc.CheckAndUpdateChallenge(("DeclarePrintInteger"), "cs175", compiler, model);

	}
	
	/* Numeric Primitives */ 
	@PostMapping(value = "/home/cs175/Primitive Data Types/Numerical Primitives/Declare Numerical Primitives")
	public String declareNumericalPrimitivesPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Declare Other Numeric Variables"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>			\r\n" + 
		   		"			Declare a <samp>byte</samp> called <i>myByte</i> and set its value to <samp>38</samp>. \r\n" + 
		   		"			\r\n" + 
		   		"			Declare a <samp>short</samp> called <i>myShort</i> and set its value to  <samp>123</samp>. \r\n" + 
		   		"			\r\n" + 
		   		"			Declare a <samp>long</samp> called <i>myLong</i> and set its value to <samp>-456</samp>. \r\n" + 
		   		"			\r\n" + 
		   		"			Declare a <samp>float</samp> called <i>myFloat</i> and set its value  to <samp>123456789</samp>. \r\n" + 
		   		"			\r\n" + 
		   		"			Declare a <samp>double</samp> called <i>myDou</i> and set its value to <samp>1.23</samp>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/numericalPrimitives/DeclareNumericalPrimitives.txt",
					"DeclareNumericalPrimitives.java");
			     		return mc.CheckAndUpdateChallenge(("DeclareNumericalPrimitives"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Primitive Data Types/Numerical Primitives/Declare Print Numerical Primitives")
	public String declarePrintNumericalPrimitivesPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Print Other Numeric Variables"; 
		   String description = "<div class=\"introduction\"> \r\n" + 
		   		"			<p class=\"topic-description\">\r\n" + 
		   		"			The plus sign is used within a print statement to separate variables. This is needed in order to have  multiple variables be strung together to create a readable sentence. \r\n" + 
		   		"			</p>\r\n" + 
		   		"			\r\n" + 
		   		"			<p>EXAMPLE:</p>\r\n" + 
		   		"			<pre>\r\n" + 
		   		"			String oil = \"butter\"; \r\n" + 
		   		"			String milk = \"cheese\"; \r\n" + 
		   		"			\r\n" + 
		   		"			System.out.println(oil +  milk);\r\n" + 
		   		"			CONSOLE: buttercheese\r\n" + 
		   		"			</pre>\r\n" + 
		   		"			\r\n" + 
		   		"			If a space is needed between two variables a (\" \") has to be placed. \r\n" + 
		   		"\r\n" + 
		   		"			<p>EXAMPLE:</p>\r\n" + 
		   		"			<pre>\r\n" + 
		   		"			String oil = \"butter\"; \r\n" + 
		   		"			String milk = \"cheese\"; \r\n" + 
		   		"			\r\n" + 
		   		"			System.out.println(oil +  \" \" + milk); \r\n" + 
		   		"			CONSOLE: butter cheese\r\n" + 
		   		"			</pre>\r\n" + 
		   		"		</div>\r\n" + 
		   		"		<div>\r\n" + 
		   		"			<h4>Challenge:</h4>			\r\n" + 
		   		"			Declare a <samp>byte</samp> called <i>myByte</i> and set its value to <samp>38</samp>. Declare a <samp>short</samp> called <i>myShort</i> and set its value to  <samp>123</samp>. Declare a <samp>long</samp>called <i>myLong</i> and set its value to <samp>-456</samp>. Declare a <samp>float</samp> called <i>myFloat</i> and set its  value to <samp>123456789</samp>. Declare a <samp>double</samp> called <i>myDou</i> and set its value to <samp>1.23</samp>.\r\n" + 
		   		"			\r\n" + 
		   		"			Print the value of each variable within a print statement by using the variable name.\r\n" + 
		   		"			Use ( + \" | \" + ) to separate each variable  name within the print statement. \r\n" + 
		   		"		</div>";		   
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/PrimitiveDataTypes/numericalPrimitives/DeclarePrintNumericalPrimitives.txt",
					"DeclarePrintNumericalPrimitives.java");
			     		return mc.CheckAndUpdateChallenge(("DeclarePrintNumericalPrimitives"), "cs175", compiler, model);

	}
	
	// *********************************************
	// ************************************ STRING I
	// *********************************************
	@PostMapping(value = "/home/cs175/String I/Declare String")
	public String declareStringPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Declare a String"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <samp>String</samp> called <i>str</i> and set its value to <samp>\"Hello World\"</samp>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StringI/DeclareString.txt",
					"DeclareString.java");
			     		return mc.CheckAndUpdateChallenge(("DeclareString"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/String I/Declare Print String")
	public String declarePrintStringPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Print a String"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <samp>String</samp> called <i>str</i> and set its value to <samp>\"Hello World\"</samp>. Using a print statement, \r\n" + 
		   		"			print the value of the variable <i>str</i>.\r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StringI/DeclarePrintString.txt",
					"DeclarePrintString.java");
			     		return mc.CheckAndUpdateChallenge(("DeclarePrintString"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/String I/String Literal")
	public String stringLiteralPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "String Literal vs. String Object"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Description:</h4>\r\n" + 
		   		"			The <samp>String \"Hello, World!!!\"</samp> is an example of a <samp>String</samp> literal.  It is a literal value that can be used and manipulated or set as a value to a <samp>String</samp> variable.  All the primitives we have worked "
		   		+ "with so far are set using literal values.  <samp>Strings</samp> are Objects though, so they can also be instantiated using the <samp>new</samp> keyword like all other Objects.  To instantiate a <samp>String</samp> Object without using literals, a programmer has to use the <samp>new String();</samp> notation in place of the literal. \r\n"
		   		+ " A <samp>String</samp> variable or literal can be within the parantheses." + 
		   		"		</div>\r\n" + 
		   		"		<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare two <samp>String</samp> variables called <i>str1</i> and <i>str2</i>. Set <i>str1</i> to the value of <samp>\"blue\"</samp> and set \r\n" + 
		   		"			<i>str2</i> to a <samp>new String();</samp> with the value of <i>str1</i>. \r\n" + 
		   		"		</div>";
		   String userInput = compiler.getUserInput();

			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StringI/StringLiteral.txt",
					"StringLiteral.java");
			     		return mc.CheckAndUpdateChallenge(("StringLiteral"), "cs175", compiler, model);

	}
	
	// *********************************************
	// ***************************** BASIC OPERATORS
	// *********************************************
	
	/* Boolean Expressions: Greater Than */ 
	@PostMapping(value = "/home/cs175/Basic Operators/Boolean Operators/Greater Than")
	public String greaterThanPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "Greater Than"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare two <samp>int</samp> variables called <i>numOne</i> and <i>numTwo</i>. Declare a <samp>boolean</samp> variable called <i>greaterThan</i>. \r\n" + 
		   		"			Set the value of <i>numOne</i> to <samp>3</samp>, set the value of <i>numTwo</i> to <samp>8</samp> and set the value of <i>lessThan</i> to <i>numOne</i>  \r\n" + 
		   		"			\"greater than\" <i>numTwo</i>. Print the variable <i>greaterThan</i>.\r\n" + 
		   		"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/BooleanOperators/GreaterThan.txt",
				"GreaterThan.java");
		     		return mc.CheckAndUpdateChallenge(("GreaterThan"), "cs175", compiler, model);

	}
	
	/* Boolean Expressions: Less Than */ 
	@PostMapping(value = "/home/cs175/Basic Operators/Boolean Operators/Less Than")
	public String lessThanPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "Less Than"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare two <samp>int</samp> variables called <i>numOne</i> and <i>numTwo</i>. Declare a <samp>boolean</samp> variable called <i>lessThan</i>. \r\n" + 
		   		"			Set the value of <i>numOne</i> to <samp>3</samp>, set the value of <i>numTwo</i> to <samp>8</samp>, and set the value of <i>greaterThan</i> to  \r\n" + 
		   		"			<i>numOne</i> \"less than\" <i>numTwo</i>. Print the variable <i>greaterThan</i>.\r\n" + 
		   		"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/BooleanOperators/LessThan.txt",
				"LessThan.java");
		     		return mc.CheckAndUpdateChallenge(("LessThan"), "cs175", compiler, model);

	}
	
	/* Logical Operators: Boolean EQUALS TO */ 
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean Equals To")
	public String booleanEqualsToPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "EQUALS TO"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare three <samp>boolean</samp> variables named <i>A</i>, <i>B</i>, and <i>boolEquals</i>. Set <i>A</i> to the value of <samp>true</samp>. \r\n" + 
		   		"			Set <i>B</i> to the value of <samp>false</samp>. Using the sign ( <samp>==</samp> ), set <i>boolEquals</i> to the value of <i>A</i> EQUALS TO <i>B</i>. Print out the value of <i>boolEquals</i>.\r\n" + 
		   		"		</div>";		   
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanEqualsTo.txt",
				"BooleanEqualsTo.java");
		     		return mc.CheckAndUpdateChallenge(("BooleanEqualsTo"), "cs175", compiler, model);

	}	
	
	/* Logical Operators: Boolean AND */
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean And")
	public String booleanAndPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "Boolean AND"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <samp>boolean</samp> variables named <i>A</i>, <i>B</i> and <i>boolAnd</i>. Set <i>A</i> to the value of <samp>true</samp>. \r\n" + 
		   		"			Set <i>B</i> to the value of <samp>false</samp>. Using the sign ( <samp>&&</samp> ), set <i>boolAnd</i> to the value of <i>A</i> AND <i>B</i>. Print out the value of <i>boolAnd</i>.\r\n" + 
		   		"		</div>";		   
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanAnd.txt",
				"BooleanAnd.java");
		     		return mc.CheckAndUpdateChallenge(("FirstClass"), "cs175", compiler, model);

	}
	
	/* Logical Operators: Boolean OR */
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean Or")
	public String booleanOrPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		 String header = "Boolean OR"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <samp>boolean</samp> variables named <i>A</i>, <i>B</i> and <i>boolOr</i>. Set <i>A</i> to the value of <samp>true</samp>. \r\n" + 
		   		"			Set <i>B</i> to the value of <samp>false</samp>. Using the sign ( <samp>||</samp> ), set <i>boolOr</i> to the value of <i>A</i> OR <i>B</i>. Print out the value of <i>boolOr</i>.\r\n" + 
		   		"		</div>";		
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanOr.txt",
				"BooleanOr.java");
		     		return mc.CheckAndUpdateChallenge(("BooleanOr"), "cs175", compiler, model);

	}
	
	/* Logical Operators: Boolean XOR */
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean XOr")
	public String booleanXOrPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Boolean XOR"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <samp>boolean</samp> variables named <i>A</i>, <i>B</i> and <i>boolXOr</i>. Set <i>A</i> to the value of <samp>true</samp>. \r\n" + 
		   		"			Set <i>B</i> to the value of <samp>false</samp>. Using the sign ( ^ ), set <i>boolXOr</i> to the value of <i>A</i> XOR <i>B</i>. Print out the value of <i>boolXOr</i>.\r\n" + 
		   		"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanXOr.txt",
				"BooleanXOr.java");
		     		return mc.CheckAndUpdateChallenge(("BooleanXOr"), "cs175", compiler, model);

	}
	
	/* Logical Operators: Boolean NOT */
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean Not")
	public String booleanNotPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Boolean NOT"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare two <samp>boolean</samp> variables named <i>A</i> and <i>boolNot</i>. Set <i>A</i> to the value of <samp>true</samp>. \r\n" + 
		   		"			Using the sign ( ! ), set <i>boolNot</i> to the value of NOT <i>A</i>. Print out the value of <i>boolNot</i>.\r\n" + 
		   		"		</div>";		
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanNot.txt",
				"BooleanNot.java");
		     		return mc.CheckAndUpdateChallenge(("BooleanNot"), "cs175", compiler, model);

	}
	
	/* Logical Operators: Boolean NOT EQUALS */
	@PostMapping(value = "/home/cs175/Basic Operators/Logical Operators/Boolean Not Equals")
	public String booleanNotEqualsPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "Boolean NOT EQUALS"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <samp>boolean</samp> variables named <i>A</i>, <i>B</i> and <i>boolNotEquals</i>. Set <i>A</i> to the value of <samp>true</samp>. Set <i>B</i> to the value of <samp>false</samp>. Using the sign ( != ), set <i>boolNotEquals</i> to the value of <i>A</i> NOT EQUALS <i>B</i>. Print out the value of <i>boolNotEquals</i>.\r\n" + 
		   		"		</div>";		   
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/LogicalOperators/BooleanNotEquals.txt",
				"BooleanNotEquals.java");
		     		return mc.CheckAndUpdateChallenge(("BooleanNotEquals"), "cs175", compiler, model);

	}
		
	/* Numerical Operators: Addition */
	@PostMapping(value = "/home/cs175/Basic Operators/Numerical Operators/Addition Int")
	public String addIntPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		   String header = "Addition"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <b>int</b> variables called <i>numOne</i>, <i>numTwo</i> and <i>add</i>. Set the  \r\n" + 
		   		"			value of <i>numOne</i> to 10, set the value of <i>numTwo</i> to 11 and set the value of <i>add</i> \r\n" + 
		   		"			to <i>numOne</i> plus <i>numTwo</i> using the addition operator.\r\n" + 
		   		"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/NumericalOperators/AdditionInt.txt",
				"AdditionInt.java");
		     		return mc.CheckAndUpdateChallenge(("AdditionInt"), "cs175", compiler, model);

	}
	
	/* Numerical Operators: Subtraction */
	@PostMapping(value = "/home/cs175/Basic Operators/Numerical Operators/Subtraction Int")
	public String subtractIntPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		   String header = "Subtratcion"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare three <b>int</b> variables called <i>numOne</i>, <i>numTwo</i> and <i>suctract</i>. Set the value of <i>numOne</i> to 31, set the value of <i>numTwo</i> to 10 and set the value of <i>suctract</i>  \r\n" + 
		   		"			to <i>numOne</i> minus <i>numTwo</i> using the subtraction operator.\r\n" + 
		   		"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/NumericalOperators/SubtractionInt.txt",
				"SubtractionInt.java");
		     		return mc.CheckAndUpdateChallenge(("SubtractionInt"), "cs175", compiler, model);

	}

	/* Numerical Operators: Multiplication */
	@PostMapping(value = "/home/cs175/Basic Operators/Numerical Operators/Multiplication Int")
	public String multiplyIntPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Multiplication";
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4> \r\n" + 
				"			Declare three <b>int</b> variables called <i>numOne</i>, <i>numTwo</i> and <i>multiply</i>. Set the value of <i>numOne</i> to 7, set the value of <i>numTwo</i> to 3 and set the value of <i>multiply</i> to <i>numOne</i> \r\n" + 
				"			multiplied by <i>numTwo</i> using the multiplication operator.\r\n" + 
				"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/NumericalOperators/MultiplicationInt.txt",
				"MultiplicationInt.java");
		     		return mc.CheckAndUpdateChallenge(("MultiplicationInt"), "cs175", compiler, model);

	}
	
	/* Numerical Operators: Division */
	@PostMapping(value = "/home/cs175/Basic Operators/Numerical Operators/Division Int")
	public String divideIntPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Division";
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4> \r\n" + 
				"			Declare three <b>int</b> variables called <i>numOne</i>, <i>numTwo</i> and <i>divide</i>. Set the value of <i>numOne</i> to 63, set the value of <i>numTwo</i> to 3 and set the value of <i>divide</i> to <i>numOne</i>  divided by <i>numTwo</i>.\r\n" + 
				"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/NumericalOperators/DivisionInt.txt",
				"DivisionInt.java");
		     		return mc.CheckAndUpdateChallenge(("DivisionInt"), "cs175", compiler, model);

	}
	
	/* Numerical Operators: Equation */
	@PostMapping(value = "/home/cs175/Basic Operators/Numerical Operators/Equation Int")
	public String equationIntPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Equation";
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4> \r\n" + 
				"			Declare four <b>int</b> variables called <i>numOne</i>, <i>numTwo</i>, <i>numThree</i> and <i>equation</i>.  \r\n" + 
				"			Set the value of <i>numOne</i> to 5, set the value of <i>numTwo</i> to 4, set the value of <i>numThree</i> to 1  \r\n" + 
				"			and set the value of <i>equation</i> to <i>numOne</i> multiplied by <i>numTwo</i> plus <i>numThree</i>.\r\n" + 
				"		</div>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/BasicOperators/NumericalOperators/EquationInt.txt",
				"EquationInt.java");
		     		return mc.CheckAndUpdateChallenge(("EquationInt"), "cs175", compiler, model);

	}


	// *********************************************
	// ********************** CASTING AND CONVERTING
	// *********************************************
	@PostMapping(value = "/home/cs175/Casting And Converting/Int To String")
	public String intToStringPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Int to String Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Casting an int to a String is something that might happen periodically throughout your CS carrer. Although, "
				+ "the cast uses a seemingly complex syntax it is fairly simple once you understand.</p>"
				+"<div class='code'>String str1 = \" \";<br />int myInt = 5;<br />str1 = Integer.toString(myInt);</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Create an int variable called x and assign the variable the value" + 
				" 10.  Next create a String variable called xConvert that casts the int" + 
				" variable x to a String variable.</p>"
				+"<p>First, set x to 10 and set xConvert to \" \"</p>"
				+"<p>Next, cast x to xConvert using the syntax Integer.toString(variable)</p>" ;
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/CastingAndConverting/IntToString.txt",
				"IntToString.java");
		     		return mc.CheckAndUpdateChallenge(("IntToString"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Casting And Converting/Double To String")
	public String doubleToStringPost(@ModelAttribute WebCompiler compiler, ModelMap model)
			throws FileNotFoundException {
		String header = "Double to String Challenge";
		String description ="<br /><h4>Description:</h4>"+ 
				 "<p>Much like the int, double can periodically be casted to a String throughout your CS career. This cast"
				 + " is very similar to the int and will have only one slight change.</p>"
				+"<div class='code'>myString = Double.toString(myDouble)</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Declare an double variable named a and assign it the value of 5." + 
				" Next, declare a String variable named str and assign it the value of \" \"." + 
				" Then use Double.toString() to cast 'a' to a String.</p>"
				+"<p>First, set a to 5 and set str to \" \"</p>"
				+"<p>Next, cast a to str by using Double.toString(variable)</p>";  
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/CastingAndConverting/DoubleToString.txt",
				"DoubleToString.java");
		     		return mc.CheckAndUpdateChallenge(("DoubleToString"), "cs175", compiler, model);
	}

	@PostMapping(value = "/home/cs175/Casting And Converting/Double To Int")
	public String intToDoublePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Integer to Double Challenge";
		String description = "<p>Declare a <samp>double</samp> named <i>myDouble</i> and assign it the value" + 
				" of <samp>5.5</samp>. Next, declare an <samp>int</samp> named <i>myInt</i> and assign it the value"
				+ " of <i>myDouble</i> using casting.  Print out the values of <i>myInt</i> and <i>myDouble</i>. Reflect on how their values differ.";		
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/CastingAndConverting/DoubleToInt.txt",
				"DoubleToInt.java");
		     		return mc.CheckAndUpdateChallenge(("DoubleToInt"), "cs175", compiler, model);

	}
	
	// *********************************************
	// ************************************ STATIC I
	// *********************************************
	
	/* Boolean */ 
	@PostMapping(value = "/home/cs175/StaticI/DefaultBoolean")
	public String defaultBooleanPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Static Boolean"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <b>static Boolean</b> called <i>myBol</i> and DO NOT set its value.\r\n" + 
		   		"			To do this you would have to declare Boolean', NOT the 'boolean'. The reason for this will be explained in a later chapter. \r\n" + 
		   		"		</div> ";
		   
		   String userInput = compiler.getUserInput();
			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StaticI/DefaultBoolean.txt",
					"DefaultBoolean.java");
			     		return mc.CheckAndUpdateChallenge(("DefaultBoolean"), "cs175", compiler, model);

	}
	
	/* Char */ 
	@PostMapping(value = "/home/cs175/StaticI/DefaultChar")
	public String defaultCharPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Static Char"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <b>static Charset</b> called <i>mychar</i> and DO NOT set its value.\r\n" + 
		   		"			To do this you would have to declare 'Charset', NOT the 'char'. The reason for this will be explained in a later chapter. \r\n" + 
		   		"		</div>";
		   
		   String userInput = compiler.getUserInput();
			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StaticI/DefaultChar.txt",
					"DefaultChar.java");
			     		return mc.CheckAndUpdateChallenge(("DefaultChar"), "cs175", compiler, model);

	}
	
	/* Integer */
	@PostMapping(value = "/home/cs175/StaticI/DefaultInteger")
	public String defaultIntegerPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		   String header = "Static Integer"; 
		   String description = "<div>\r\n" + 
		   		"			<h4>Challenge:</h4> \r\n" + 
		   		"			Declare a <b>static Integer</b> called <i>myInt</i> and DO NOT set its value.\r\n" + 
		   		"			To do this you would have to declare 'Integerâ€™, NOT the 'intâ€™. The reason for this will be explained in a later chapter. \r\n" + 
		   		"		</div>";
		   
		   String userInput = compiler.getUserInput();
			populateChallenge(model, header, description, userInput);
			setCompiler(compiler, model, "static/cs175/StaticI/DefaultInteger.txt",
					"DefaultInteger.java");
			     		return mc.CheckAndUpdateChallenge(("DefaultInteger"), "cs175", compiler, model);

	}
	
	/* Numeric */ 
	@PostMapping(value = "/home/cs175/StaticI/DefaultNumericalPrimitives")
	public String defaultNumericalPrimitivesPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Static Other Numericals"; 
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4> \r\n" + 
				"			Declare a <b>static Byte</b> called <i>myByte</i>. \r\n" + 
				"			\r\n" + 
				"			Declare a <b>static Short</b> called <i>myShort</i>. \r\n" + 
				"			\r\n" + 
				"			Declare a <b>static Long</b> called <i>myLong</i>. \r\n" + 
				"			\r\n" + 
				"			Declare a <b>static Float</b> called <i>myFloat</i>. \r\n" + 
				"			\r\n" + 
				"			Declare a <b>static Double</b> called <i>myDouble</i>. \r\n" + 
				"			\r\n" + 
				"			DO NOT set their values. \r\n" + 
				"			\r\n" + 
				"			To do this you would have to declare the uppercase forms of these primitive data types. Such as â€˜Byteâ€™ not â€˜byteâ€™, â€˜Shortâ€™ not â€˜shortâ€™, â€˜Longâ€™ not â€˜long, â€˜Floatâ€™ not â€˜float, and â€˜Doubleâ€™ not â€˜doubleâ€™. The reason for this will be explained in a later chapter.\r\n" + 
				"		</div>";
		   
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StaticI/DefaultNumericalPrimitives.txt",
				"DefaultNumericalPrimitives.java");
		     		return mc.CheckAndUpdateChallenge(("DefaultNumericalPrimitives"), "cs175", compiler, model);

	}
	
	/* String */ 
	@PostMapping(value = "/home/cs175/StaticI/DefaultString")
	public String defaultStringPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException
	{
		String header = "Static String"; 
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Declare a <b>static String</b> called <i>str</i> and DO NOT set its value.\r\n" + 
				"		</div>";
		   
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StaticI/DefaultString.txt",
				"DefaultString.java");
		     		return mc.CheckAndUpdateChallenge(("DefaultString"), "cs175", compiler, model);

	}
	
	// *********************************************
	// ************************************ OBJECT I
	// *********************************************
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Create a Book")
	public String createABook(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Create a Book";
		String description = "<br /><h4>Description:</h4>"+ 
				  "<p>We have already completed part of the Book class, which defined 4 variables we want to have for each"
				  + " book, and getter and setter methods to set and retrieve the values of these variables.  But how do we create "
				  + " a book, set its values, and retrieve its values?<br/><br/>"
				  + " Recall when we instantiated primitives we used the literal (e.g. 12, true, 'a') values of the primitive to set its values."
				  + " Objects, such as Book, do not have literal values like this.  We also saw in the String I section that we can declare a String using both"
				  + " a literal value and using the new keyword.  We will use this new keyword to declare a new Book object, and then set its values. <br/><br/>"
				  + " The syntax for using new to create a new object is below: </p>"
				  + "<pre>&lt;type&gt; &lt;variable name&gt; = new &lt;type&gt;();</pre><br/>"
				  + "<p>For Example:</p>"
				  + "<pre> String myString = new String();</pre><br/>"
				  + "<p></p>"
				  + "<h4>Challenge:</h4>\r\n" + 
				  "		<p>Create an instance of the book class called theStand. </p> ";
		
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/CreateABook.txt",
				"CreateABook.java");
		return mc.CheckAndUpdateChallenge(("CreateABook"), "cs175", compiler, model);
	} 
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Using Getters and Setters")
	public String usingGettersAndSetters(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Using Getters and Setters";
		String description = "<br /><h4>Description:</h4>"+ 
				  "<p>We have seen how to write getter and setter methods in the classes section.  Now it is time"
				  + " to use them to set the variables of our newly created Book object! Recall that so far Book class has the following lines of code "
				  + " : <br/></p>"
				  + " <pre>public class Book { <br/>"
				  + "&nbsp;&nbsp;&nbsp;&nbsp;public String name;<br/>"
				  + "&nbsp;&nbsp;&nbsp;&nbsp;public String author;<br/>"
				  + "&nbsp;&nbsp;&nbsp;&nbsp;public int pages;<br/>"
				  + "&nbsp;&nbsp;&nbsp;&nbsp;public double price;<br/>"
				  + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;//getters and setters not shown <br/>}</pre>"
				  + "<p>Recall that when we wrote the getter and setter method for the price vairable we called them getPrice and setPrice respectively."
				  + " This is the standard convention when naming getters and setters for a variable.  For this challenge, we have wrote the other"
				  + " getter and setter methods for you, it is just your job to use them!</p>"
				  + "<h4>Challenge:</h4>\r\n" + 
				  "		<p>Create an instance of the book class called theGallicWars. Then use setter methods to set the variables as follows: </p>"
				  + "<ul>"
				  + "<li>name: \"The Gallic Wars\"</li>"
				  + "<li>author: \"Julius Caesar\"</li>"
				  + "<li>pages: 901</li>"
				  + "<li>price: 2.99</li>"
				  + "</ul>"
				  + "<p>Finally, declare an int variable called pageNumber and use the getter method for pages to instantiate its value.</p>";			
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/UsingGettersAndSetters.txt",
				"UsingGettersAndSetters.java");
		return mc.CheckAndUpdateChallenge(("UsingGettersAndSetters"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Object Eq")
	public String objEquivelancePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Object Equivalence";
		String description = "<br /><h4>Description:</h4>"+ 
				  "<p> As you may have already noticed the equals() method in the String class is not equivalent to the logical operation ==." 
			    + " Why is this? If you were to create an instance of a class you create and use the equals() method then the equals() method and == logical operator"
			    + " function identically. You may have already discussed in class that when you set two Objects equal"
			    + " to one another their actual location in memory are equal. However, that does not explain why the equals() method and the == operator"
			    + " function the way they do. An even stranger question would be why is the equals() method a method within every class"
			    + " ? \n\n\n\n\nThe easiest answer is inheritance (You will learn more about this in CS176), every class in Java inherits the Object class java.lang.Object. Within" 
			    + " the object class is the equals() method for comparing two Objects. The internal code for the Object equals() method just compares Object memory locations" 
			    + " , so if you were to view this code it would look like, public boolean equals(Object obj){return this==obj}. If the code from the Object equals() method is a bit confusing"
			    + " lets break it down. All this code is doing is checking if they are the same exact Object. So if you have two Objects you instantiated both with the \"new\" keyword"
			    + " and they both have no value or a default value, and they are from the same class the equals() method would return false. But, if you set the Objects equal to one another"
			    + " they are now the same exact Object and point to the same location in memory so the equals() method would return true. Hopefully, this helped you better understand"
			    + " what is going on when you use the equals() method or the logical operator == when you compare Objects, in Data Structures you will"
			    + " create your own version of the equals() method by overriding the java.lang.Objects equals() method.\n</p>"
				+" <div class='code'>MyClass obj = new MyClass()<br />MyClass obj1 = new MyClass()\n</div><br />"
				+" <br /><h4>Challenge:</h4>"
				+" <p>\nFor your challenge, create 2 instances of the class ObjectEq"
				+" and name them instance1 and instance2. Next, in an if statement, set the condition to instance1.equals(instance2) || instance1 == instance2."
				+" Within the if statement print \"They are equal!\". Next, after the if statement, assign instance1 to instance2 (instance1 = instance2)."
				+" Do the same if statement as above but within the if statement print \"Now they are really equal\". Run your code. Think back to what was stated in the description"
				+" and hopefully this will explain the functionality of the == operator and the equals() method.</p>"
				+" <p>First, instantiate instance1 and instance2 to the class ObjectEq.</p>"
				+" <p>Next, create an if statement with the condition of instance1.equals(instance2) || instance1 == instance2. In the body print \"They are equal!\"</p>"
				+" <p>Next, set instance1 to equal instance2.</p>"
				+" <p>Next, use the same if statement but in the body print \"Now they are really equal\"</p>";	
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/ObjectEq.txt",
				"ObjectEq.java");
		     		return mc.CheckAndUpdateChallenge(("ObjectEq"), "cs175", compiler, model);

	} 
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Constructors")
	public String constructorsPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Construct a class Challenge!";
		String description = "<h4>Description:</h4> \r\n" + 
				"		<p>\r\n" + 
				"			"
				+ "     Using setter methods to instantiate variables for a given object is useful"
				+ " because it implements the concept of encapsulation.  But it would be helpful "
				+ " not to have to rely on using these methods whenever you create a new object.  "
				+ " Constructors allow programmers to create an object and set the values of its"
				+ " variables in potentially one line of code. <br/><br/>"
				+ " Technically, constructors are methods.  Their method definition though is a bit"
				+ " different that what we are used to though. Below is the basic formula: </p><br/>"
				+ "<pre>&lt;access modifier&gt; &lt;class name&gt;(&lt;input parameters&gt;)  </pre>"
				+ "<p>For example:</p><br/>"
				+ "<pre>public Book() { <br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;//method body goes here<br/>"
				+ "}</pre><br/>"
				+ "<p>Notice that we do not have to specify a return type.  This is because it is "
				+ "implied that when we use the new keyword to create a Book object using this "
				+ "constructor we will be returning a Book! All constructors return an instance"
				+ " of the class they belong to. <br/><br/>"
				+ " A constructor with no inputs is called the default constructor.  Notice in the "
				+ "previous challenges that we did not write a default construtor, but were still able"
				+ " to call the <samp>new Book()</samp> method to create a Book object.  This is because"
				+ " Java will automatically create a default constructor for objects if no constructors defined.<br/><br/>"
				+ " Finally, constructors can accept input parameters, and these input parameters can then "
				+ " be used to set the values of the variables. <br/><br/>"
				+ " For example: <br/> </p>"
				+ " <pre>public class Person {<br/><br/>"
				+ " &nbsp;&nbsp;&nbsp;&nbsp;String name;<br/><br/>"
				+ " &nbsp;&nbsp;&nbsp;&nbsp;public Person(String newName){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name = newName;<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}"
				+ "</pre>"
				+  
				"		<br><h4>Challenge:</h4>\r\n" + 
				"		<p>For your challenge, Create a constructor for the Book class that takes in four input parameters.  Recall"
				+ " that Book has 4 instance variables associated with it, namely String name, String author, int pages, and double"
				+ " price. The value of the each parameter in you constructor should be set to each of these variables"
				+ " respectively. </p>\r\n" + 
				"		<p>Remember the access specifier for constructors must be public and the name must match the class (Book).</p>";	
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/ConstructorsTest.txt",
				"ConstructorsTest.java");
		     		return mc.CheckAndUpdateChallenge(("Constructors"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Declare Object")
	public String declareObjectsIPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Instantiate an Object Challenge!";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>The first Object you most likely manipulated and used to model real-world things" + 
				 " was the String. When you instantiate a String you are actually creating a new Object." + 
				 " String is unique meaning you do not need to explicitly write new each time you instantiate a new String." + 
				 " So how can we create ObjectsI of other data types, but are primitives? Every primitive data type in Java" + 
				 " has a Wrapper class (More details will be given in CS176).</p>"
				+"<div class='code'>Integer myInt = new Integer(299)</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, simply declare a new Object of the Integer wrapper class called myFirstInt "
				+ "and give it the value of 5.</p>"
				+"<p>Remember the access specifier for constructors must be public and the name must match the class.</p>";	
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/DeclareObject.txt",
				"DeclareObjects.java");
		     		return mc.CheckAndUpdateChallenge(("DeclareObject"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Objects and Classes/Objects/Declare Object WNew")
	public String declareObjectWNewPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Construct a your Object Challenge!";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Recall in the previous challenge when you created a constructor for the class Constructors " + 
				 "that had an integer as a parameter. This constructor will now allow you to initialize"
				 + " an Object of Constructors type that takes an int as its paramater.</p>"
				+"<div class='code'>MyClass varName = new MyClass(DataType variable)</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, create an Object of the Constructors class called myObj that uses" + 
				" your constructor and has an initial value of 10.</p>"
				+"<p>First, Instantiate an Object of the type Constructors with 10 as its parameter</p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/Objects/DeclareObjectWNew.txt",
				"Constructors.java");
		     		return mc.CheckAndUpdateChallenge(("DeclareObjectWNew"), "cs175", compiler, model);

	}
	
	// *********************************************
	// *********************************** STRING II
	// *********************************************
	@PostMapping(value = "/home/cs175/Using Methods/String charAt")
	public String stringCharAtPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "charAt() Method"; 
		String description = "<div>\r\n"
		   		+ "         <h4>Description:</h4>"
		   		+ "         <p> The method charAt() has the following method header: </p>"
		   		+ "         <pre>public char charAt(int index)</pre>" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a <b>String</b> variable named <i>str1</i>. Set the value of <i>str1</i> to \"Hello World\".\r\n" + 
		   		"			Declare a <b>char</b> variable named <i>str2</i>. Using the charAt() method, set the value of <i>str2</i>\r\n" + 
		   		"			to 'r' from the value of <i>str1</i>. Print the value of <i>str2</i>. \r\n" + 
		   		"		</div>";
	   String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StringII/StringCharAt.txt",
				"StringCharAt.java");
		     		return mc.CheckAndUpdateChallenge(("StringCharAt"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Using Methods/String Concatenate")
	public String stringConcatenateAtPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Concatenation"; 
		   String description = "<div>\r\n"
		   		+ "          <h4>Description:</h4>"
		   		+ "          <p>There are two ways to concatenate (combine) Strings.  The + operator can be used to "
		   		+ "          combine two String literals or variables together.  But since Strings are also objects, they"
		   		+ "          can be combined using concat method which has the following method header:</p>"
		   		+ "          <pre> public String concat(String str) </pre>" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare four <b>String</b> variables named <i>str1</i>, <i>str2</i>, <i>str3</i>, and <i>str4</i>. Set the value of <i>str1</i> to “Hello”. Set the value of <i>str2</i>to “World”. Set the value of <i>str3</i> to <i>str1 + ‘ ’ + str2</i>. "
		   		+ "         Set the value of str4 to the value of using the concat method on str1 using str3 as an input parameter. Print the value of <i>str3</i> and str4.\r\n" + 
		   		"		</div>";
	   String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StringII/StringConcatenate.txt",
				"StringConcatenate.java");
		     		return mc.CheckAndUpdateChallenge(("StringConcatenate"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Using Methods/String Equal")
	public String stringEqualPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = ".equals() Method"; 
		   String description = "<div class=\"introduction\">\r\n" + 
		   		"			<p class=\"topic-description\">\r\n" + 
		   		"				We have previously seen the == operator for primitive data types, that checks to see if"
		   		+ "             two primitives have the same value.  However, this is not as simple for Object variables. "
		   		+ "             == checks if two literal values are equal, but for Objects it will check if the two "
		   		+ "             Objects refer to the same location in memory.  The .equals() method can work around"
		   		+ "             this shortcoming of the == by checking if the two objects hold the same value, rather than point to the same location in memory" + 
		   		"			</p>\r\n" + 
		   		"		</div>\r\n" + 
		   		"		<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare two <b>String</b> variables called <i>str1</i> and <i>str2</i> using the new keyword. Set the value for <i>str1</i> to \"HelloWorld\" and the value for <i>str2</i> to \"HelloWorld\". "
		   		+ "         Using the <b>.equals()</b> within a print statement, check if <i>str1</i> is equal to <i>str2</i>. Also using a pring statement"
		   		+ "         see if str1 == str2.\r\n" + 
		   		"\r\n" + 
		   		"		</div>";
	   String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StringII/StringEqual.txt",
				"StringEqual.java");
		     		return mc.CheckAndUpdateChallenge(("StringEqual"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Using Methods/String SubString")
	public String stringSubStringPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "substring() Method"; 
		   String description = "<div class=\"introduction\">\r\n" + 
		   		"			<p class=\"topic-description\">\r\n" + 
		   		"				The .subString() method within Java is a method within the String class which can be used to break up Strings by each letter.  \r\n" + 
		   		"			</p>\r\n" + 
		   		"		<p>EXAMPLE:</p>\r\n" + 
		   		"		<pre>	\r\n" + 
		   		"		String str = “Hello”; \r\n" + 
		   		"		str.substring(1);\r\n" + 
		   		"		</pre>\r\n" + 
		   		"		<p>OUTPUT:</p> \r\n" + 
		   		"		<pre> \r\n" + 
		   		"		ello \r\n" + 
		   		"		</pre>\r\n" + 
		   		"		</div>\r\n" + 
		   		"		<div>\r\n" + 
		   		"			<h4>Challenge:</h4>\r\n" + 
		   		"			Declare a two <b>String</b> variables named <i>str1</i> and <i>str2</i>. Set the value for <i>str1</i> to ‘Hello World'. "
		   		+ "Using the .substring();  method,set the value of <i>str2</i> to 'World' from <i>str1</i>. Print the value of the variable <i>str2</i>.\r\n" + 
		   		"		</div>";
	   String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/StringII/StringSubString.txt",
				"StringSubString.java");
		     		return mc.CheckAndUpdateChallenge(("StringSubString"), "cs175", compiler, model);

	}	
	
	// *********************************************
	// ************************************ METHOD I
	// *********************************************
	@PostMapping(value = "/home/cs175/Writing Methods/Logical And Method")
	public String logicalAnd(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Logical AND Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's AND logical operator is &&. This logical operator will be true if and only if both values are true "
				 + " else it will return false.</p>"
				+"<div class='code'><pre>"
								+"public boolean logic(boolean a, boolean b){"
								+ "			\n//BODY"
								+ "			\nreturn boolean;<br />"
								+ "}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Write a method called logicalAnd that accepts two booleans as a parameter and returns a boolean\n" + 
				" that is the logical AND of the parameters.</p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/LogicalAndMethod.txt",
				"LogicalAnd.java");
		     		return mc.CheckAndUpdateChallenge(("LogicalAndMethod"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Writing Methods/Logical Or Method")
	public String logicalOr(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Logical OR Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's OR logical operator is ||. This logical operator will be true if and only if either of the values are true "
				 + " else it will return false.</p>"
				+"<div class='code'><pre>"
				+ "	public boolean logic(boolean a, boolean b){<br />"
				+ "		//BODY<br />"
				+ "		return boolean;<br />"
				+ "	}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Write a method called logicalOr that accepts two booleans as a parameter and returns a boolean\n" + 
				" that is the logical OR of the parameters.</p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/LogicalOrMethod.txt",
				"LogicalOrMethod.java");
		     		return mc.CheckAndUpdateChallenge(("LogicalOrMethod"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Writing Methods/Logical Not Method")
	public String logicalNot(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Logical NOT Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's NOT logical operator is !. This logical operator will be true if and only the value is false "
				 + " else it will return false.</p>"
				+"<div class='code'><pre>"
								+"public boolean logic(boolean a){<br />"
								+ "	//BODY<br />"
								+ "	return boolean;<br />"
								+ "}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Write a method called logicalNot that accepts one boolean as a " + 
				"parameter and returns the logical NOT of the parameter.</p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/LogicalNotMethod.txt",
				"LogicalNotMethod.java");
		     		return mc.CheckAndUpdateChallenge(("LogicalNotMethod"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Writing Methods/Less Than Method")
	public String intMethod(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Less than Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's less than operator is <. This operator will return true if the value to the left of the operator " + 
				 "is less than the right or false otherwise.</p>"
				+"<div class='code'><pre>"
								+"public int method(int a, int b){<br />"
								+ "	//BODY<br />"
								+ "	return int;<br />"
								+ "}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Create a method that accepts two integers and returns the lesser value." + 
				" The method name must be logicalLess." + 
				" Within the method and if/else statement may be required.</p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/LessThanMethod.txt",
				"LessThanMethod.java");
		     		return mc.CheckAndUpdateChallenge(("LessThanMethod"), "cs175", compiler, model);

	}

	@PostMapping(value = "/home/cs175/Writing Methods/Greater Than Method")
	public String greaterMethod(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Greater Than Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's greater than operator is >. This operator will return true if the value to the left of the operator"
				 + " is greater than the right and false if its not.</p>"
				+"<div class='code'><pre>"
								+"public int method(int a, int b){<br />"
								+ "		//BODY<br />"
								+ "		return int;<br />"
								+ "}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Create a method that accepts two integers and returns the greater variable. "
				+ "The method name must be logicalGreater. "
				+ "Within the method and if/else statement may be required. </p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/GreaterThanMethod.txt",
				"GreaterThanMethod.java");
		     		return mc.CheckAndUpdateChallenge(("GreaterThanMethod"), "cs175", compiler, model);

	}
	
	@PostMapping(value = "/home/cs175/Writing Methods/Logical Equals Method")
	public String logicalEqualsPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Logical Equals Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java's equals operator is ==. This operator will return true if the value on the left is equivelant to the"
				 + " value on the right and false otherwise.</p>"
				+"<div class='code'><pre>"
								+"public boolean logic(boolean a, boolean b){<br />"
								+ "	//BODY<br />"
								+ "	return boolean;<br />"
								+ "}</pre>"
				+ "</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Create a method called logicalEquals that accepts two integers as inputs and checks if they are equal "
				+ "to each other. Return either true if they are equals or false if they are not. </p>"; 
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsI/LogicalEqualsMethod.txt",
				"LogicalEqualsMethod.java");
		     		return mc.CheckAndUpdateChallenge(("LogicalEqualsMethod"), "cs175", compiler, model);

	}

	// *********************************************
	// ************************************** CLASSI
	// *********************************************
	@PostMapping(value = "/home/cs175/Objects and Classes/Classes/The Hard Way")
	public String theHardWayPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "The Hard Way";
		String description = "<br/><h4>Description:</h4>"
				+ "<p> We first showed you what it would be like to program a situation without objects.  Then over the course of "
				+ " the next several challenges, we show you how to model the same situation with objects!</p>"
				+ "<br/>"
				+ "<h4>Challenge:</h4>"
				+ "<p>Imagine that we are the owners of a book store and that we would like to start keeping a record of the books "
				+ " in our shop. Create the following 8 variables:<br/>"
				+ " <ul>"
				+ " <li>A String called book0Name with value \"The Gallic Wars\"</li>"
				+ " <li>A String called book0Author with value \"Julius Caesar\" </li>"
				+ " <li>An int called book0ID with value 901</li>"
				+ " <li>A double called book0Price with value 2.99</li>"
				+ " <li>A String called book1Name with value \"The Stand\"</li>"
				+ " <li>A String called book1Author with value \"Stephen King \"</li>"
				+ " <li>An int called book1ID with value 501</li>"
				+ " <li>A double called book1Price with value 14.99</li>"
				+ " </ul>"
				+ "</p>";
		String userInput = compiler.getUserInput();
  		populateChallenge(model, header, description, userInput);
  		setCompiler(compiler, model, "static/cs175/ClassI/TheHardWay.txt",
  				"TheHardWay.java");
  		return mc.CheckAndUpdateChallenge(("TheHardWay"), "cs175", compiler, model);
	}
	
	 @PostMapping(value = "/home/cs175/Objects and Classes/Classes/Math Class")
     public String mathClassPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
             String header = "Create a Class Challenge!";
             String description ="<br /><h4>Description:</h4>"+
                              "<p>The Math class in Java is a very interesting class that may seem confusing to new users at first, but"
                              + " once an understanding of the class will be very easy for someone to understand. Unlike how you usually "
                              + "declare methods or classes in Java the Math classes' methods are all static. Static method allow us"
                              + " to use methods within a class without creating an instance of that class first. That is because"
                              + " static methods are associated with the class not an instance of that class.<br /></p>"
                              +"<div class='code'>double myVar = Math.PI;</div><br />"
                             +"<br /><h4>Challenge:</h4>"
                             +"<p>For your challenge, declare a double variable call pi that is equal to Math.PI. This will demonstrate the "
                             + "capabilities of the Math class and the ability to not instantiate the class before you utilize its methods.</p>"
                             +"<p>First, create the instance variable pi that is an double.</p>"
                             +"<p>Next, set pi to Math.PI</p>";
            String userInput = compiler.getUserInput();
     		populateChallenge(model, header, description, userInput);
     		setCompiler(compiler, model, "static/cs175/ClassI/MathClass.txt",
     				"MathClass.java");
     		return mc.CheckAndUpdateChallenge(("MathClass"), "cs175", compiler, model);

     }
	 
     @PostMapping(value = "/home/cs175/Objects and Classes/Classes/Getters and Setters")
     public String getterAndSetterClassPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
 		String header = "Getters and Setters!";
 		String description ="<br /><h4>Description:</h4>"+ 
 				 "<p>In the previous challenge we declared a class called Book with 4 variables (name, author, pages, and price).  We declared these"
 				 + " variables private, so that they cannot be directly accessed outside of the Book.java file.  This is a common practice for new"
 				 + " programmers to follow, and it is typically standard for most cases we encounter in 175.  But if these variables cannot be accessed,"
 				 + "  then how will we be able to set and use their values?  The answer is with 'getters and setters'. <br/><br/>"
 				 + "Getters and setters in Java are crucial in extracting data from instance variables of a class.  The purpose of"
 				 + " having getters and setters is so users can still access and modify the values of the variables of a class, without having direct access"
 				 + " to them.  This concept is called encapsulation (or data hiding). <br/><br/>"
 				 + "It seems a bit redundent to do it this way, but there are instances where having encapsulation in your program can prevent users from"
 				 + " changing certain variables.  It also makes your code easier to use. <br /><br/>"
 				 + " "
 				 + " Getters and setters are methods, and we have seen how to use some methods in the Using Methods section.  There, we also gave a brief introduction on how to write a method "
 				 + " definition and where the method's programming logic should be. <br/><br/>"
 				 + " "
 				 + " Basically, a getter just returns the value of an instance variable, and a setter sets the value of an instance variable without returning"
 				 + " anything.  In this case the return type in the method definition is void."
 				 + ""
 				 +""
 				 + "</p>"
 				+"<br /><h4>Challenge:</h4>"
 				+"<p>For your challenge, create getter and setter methods for the price variable."
 				+ " The names for these methods should be "
 				+ "getPrice and setPrice respectively.  This is the standard convention for naming getters and setters based on the variable name.</p>";
 		String boilerplate = "public class Book{\n"
 				+ "    private String name;\n"
 				+ "    private String author;\n"
 				+ "    private int ID;\n"
 				+ "    private double price;\n"
 				+ "\n\n//ENTER CODE BELOW\n\n\n\n"
 				+ ""
 				+ "}";
             String userInput = compiler.getUserInput();
     		populateChallenge(model, header, description, userInput, boilerplate);
     		setCompiler(compiler, model, "static/cs175/ClassI/GettersAndSettersTest.txt",
     				"GettersAndSettersTest.java");
     		return mc.CheckAndUpdateChallenge(("GettersAndSetters"), "cs175", compiler, model);

     }
     
     @PostMapping(value = "/home/cs175/Objects and Classes/Classes/First Class")
     public String FirstClassPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
 		String header = "Create a Class Challenge!";
 		String description ="<br /><h4>Description:</h4>"+ 
 				 "<p>The last challenge (The Hard Way) was meant to show you how disorganized things can get with primitives and Strings alone.  Imagine if we had"
 				 + " to define 100 or even 1000 books this way!  Not only is the program cluttered, but the only way one can tell that the data referring to books is related"
 				 + " is in our variable names.  As we previously stated, the class will allow us to keep our data neat and organized. <br/> </br>"
 				 + "To create a class in Java the only syntax needed is the access specifier (public), the keyword class, and then"
 				 + " the name you would like to call your class with standard convention of capitalizing the first letter of every word"
 				 + " in your class name with no whitespace in between words.  For example, we give you the class definition of a class we called Hello World. "
 				 + " <br /></p>"
 				 +"<div class='code'><pre>public class HelloWorld {"
 				 + ""
 				 + "							}</pre> </div><br />"
 				 + "<p>Note that the name of the file should be HelloWorld.java.  The class will not correctly compile otherwise. If we wanted our class"
 				 + " to have variables associated with it, we would put them below the class definition, but above the closing curly brace ('}') character.</p><br/>"
 				+"<br /><h4>Challenge:</h4>"
 				+"<p>For your challenge, create your first class by using the public class syntax followed by the class name of"
 				+ " Book.  Below the class definition, declare, but don't instantiate (give a value to) the following 4 variables:</p> "
 				+ " <ul>"
 				+ "  <li>A private String called name</li>"
 				+ "  <li>A private String called author</li>"
 				+ "  <li>A private int called ID</li>"
 				+ "  <li>A private double called price</li>"
 				+ "</ul><br/><br/> <p>This is an important start to our program organization.  The lines of"
 				+ " code tell Java that we are going to want a new type of object called Book.  Each Book object "
 				+ " that we create will be able to hold data for each of the variables that we defined.  Finally, the word "
 				+ " private before our variable names prevents any other class from directly accessing these values.  We touch"
 				+ "  more on this feature in CS 176.</p>"; 
             String userInput = compiler.getUserInput();
     		populateChallenge(model, header, description, userInput);
     		setCompiler(compiler, model, "static/cs175/ClassI/FirstClassTest.txt",
     				"FirstClassTest.java");
     		return mc.CheckAndUpdateChallenge(("FirstClass"), "cs175", compiler, model);
     }
     
	// *********************************************
	// ******************************** CONTROL FLOW
	// *********************************************
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare DBreak")
   	public String declareDBreakPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Do While loop with break statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>A do-while loop is designed to execute at least once before checking the conditional statement.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare integers a, b, sum, and counter. Set a=2, set b=5. Write a do loop that is set to "
				+ "add integers a and b while counter is < -5000. "
				+ "Within the do section assign sum the value of sum+a+b. "
				+ "Next, set newSum to the value of sum, then write an if-statement that checks if sum == 7 {break;}. "
				+ "Finally, within the do set sum to sum + 1000. After the do-while, print out sum and newSum. "
				+ "What do you think the values of sum and newSum will be? Do you think they’ll be the same or different?</p>"+
				"<p>HINT: do-while loops are designed to run at least once regardless of the condition set in the While part of the loop. Whatever you write within the Do statement will run once. A Break statement uses the keyword break in Java. In this statement, java will “break” you out of any loop and go to the next statement.\n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareDBreak.txt",
				"DeclareDBreak.java");
		return mc.CheckAndUpdateChallenge(("DeclareDBreak"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare DContinue")
   	public String declareDContinuePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Do While loop with an continue statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>A do-while loop is designed to execute at least once before checking the conditional statement.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer named i, set it equal to 1. Create a do-while loop. "
				+ "In the do section, simply print i. Then write a statement incrementing i by 1. "
				+ "Write 3 If statements. In the first one, check if i == 3 {continue;}. "
				+ "Second one, if i == 3 {print (“Congrats you did it right”)}. Lastly, if i == 4 {print (“Congrats you did it right”)}. "
				+ "Then close with the while statement that checks the condition (i < 10). "
				+ "See what prints out. You have two print statements, but only one will print. Why? "
				+ "What do you think the continue statement did for your if statements?</p>"+
				"<p>HINT: Continue is a keyword in Java that is used to\"continue\" on to the next statement. "
				+ "In a do-while loop, a continue will immediately check the while condition. \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareDContinue.txt",
				"DeclareDContinue.java");
		return mc.CheckAndUpdateChallenge(("Getting Array Values"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare Do")
 	public String declareDoPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
 	{
 		String header = "Do While loop";
 		String description = "<br /><h4>Description:</h4>"+ 
 				 "<p>The do loop in Java is meant for situations in which you want the code to execute at least once before going through the condition associated with the loop.</p>"
 				+"<br /><h4>Challenge:</h4>"
 				+"<p>Declare an integer int1 = 1. Declare an integer int2 = 2. Declare an integer called product set equal to 0. Write a do-while loop that first says int1=int1*int2 then sets product=int1. Check if the variable product is less than 20. Let the program run until the variable product is greater than or equal to 20.</p>"+
 				"<p>HINT: the numbers in sequential order will go something like this: 2,4,8,16,32. (Since number 16 is NOT greater than 20, the loop goes one more time around, doubling to 32 at which point it checks that product is now greater than 20 and cuts out of the loop.</p>";
 		
 		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareDo.txt",
				"DeclareDo.java");
		return mc.CheckAndUpdateChallenge(("DeclareDo"), "cs175", compiler, model);
 	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare DReturn")
   	public String declareDReturnPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Do While loop with return statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Execute Do loops with return statements.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Write a method called doLoop. In the parenthesis, set an int called sum. Declare two integers name a and b. Set a=2, set b=5. Declare an integer named counter = 0. "
				+ "Write a do/while loop that adds a+b while  counter is < 5. Write a return statement for sum.</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareDReturn.txt",
				"DeclareDReturn.java");
		return mc.CheckAndUpdateChallenge(("DeclareDReturn"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare FBreak")
   	public String declareFBreakPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "For loop with break statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Execute a for loop with a break statement.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Create a for loop that is set to increment from 1 to 10. Declare an integer i=1. Code a break statement at the appropriate interval in the loop to only print the numbers 1-7.</p>"+
				"<p>HINT: use an if statement nested in the for loop to test when i==8{break;} \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareFBreak.txt",
				"DeclareFBreak.java");
		return mc.CheckAndUpdateChallenge(("DeclareFBreak"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare FContinue")
   	public String declareFContinuePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "For loop with continue statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Execute For loops with a continue statement.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Create a for loop that is set to decrement from 10 to 1. Declare an integer myInt=1. Declare and integer newInt=0. Code a continue statement at the appropriate interval in the loop to only print the numbers 1,2,3,4,6,7,8,9,10.</p>"+
				"<p>HINT: inside the if statement, before “continue;” put the statement “newInt = myInt;”. \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareFContinue.txt",
				"DeclareFContinue.java");
		return mc.CheckAndUpdateChallenge(("Getting Array Values"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare For")
   	public String declareForPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Practice with For Loops";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Execute For loops.</p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare a String named str outside of a for loop. "
				+ "Assign the text \"Hello World\" to the string. Using the for loop, make the text print out 5 times.</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareFor.txt",
				"DeclareFor.java");
		return mc.CheckAndUpdateChallenge(("DeclareFor"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare FReturn")
   	public String declareFReturnPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "For loop with return statement";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Return a value processed through a for-loop <p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Create a method called forLoop that takes in an integer and will return an integer. "
				+ "Inside the method declare an integer called myVar and set it to 5. "
				+ "Next, create a for loop that will add myVar to the passed in integer "
				+ "(The integer the method is given as a parameter, name it myVar1). "
				+ "Add myVar to myVar1 10 times. return myVar1.</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareFReturn.txt",
				"DeclareFReturn.java");
		return mc.CheckAndUpdateChallenge(("DeclareFReturn"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare If")
   	public String declareIfPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "If statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Practice with If statements<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer called score. Use an if statement to determine if score is greater than 75, if score is greater than 75 output “Congrats! You passed.”</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareIf.txt",
				"DeclareIf.java");
		return mc.CheckAndUpdateChallenge(("DeclareIf"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare If Else")
   	public String declareIfElsePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "If-else statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Practice with If-else statements<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer called score. Use an If-Else statement, to check if score is greater than 75. If score is greater than 75 output “Congrats! You passed.” If score is less that 75, output “Sorry! Try again.”</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareIfElse.txt",
				"DeclareIfElse.java");
		return mc.CheckAndUpdateChallenge(("DeclareIfElse"), "cs175", compiler, model);
   	}
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare Nested If Else")
   	public String declareNestedIfElsePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Nested if-else statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Practice with nested if/if-else statements<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer called score. Using a nested If statement, check if score is greater than 90. "
				+ "If score is greater than 90, output “Congrats! You got an A.” If score is greater than 75 but less than 90, output “Congrats! You passed.” If score is less than 75, output “Sorry! Try Again.”</p>"+
				"<p> \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareNestedIfElse.txt",
				"DeclareNestedIfElse.java");
		return mc.CheckAndUpdateChallenge(("DeclareNestedIfElse"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare SBreak")
   	public String declareSBreakPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Switch case statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Switch case statements with break<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Similar to the Declare Switch example, write a program using switch statements that assigns the day of the week based on which number is assigned to the variable day. Use int day for number 1-7, use String dayName for each day of week, initialize it to “”. This time, put break statements in between. Also, write the statement default: dayName=”Invalid Day”; Break; This will be a catch all for any number not between 1 and 7.</p>"+
				"<p>HINT: You will need to make separate “cases” for every day of the week. You will have cases 1-7. Make Sunday #1, Monday #2 and so on. Notice what will print when you write the print statement for dayName. Notice now what happens when including the break statements. Compare it to what happened with the DeclareSwitch problem. Do you recall what the output gave you? \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareSBreak.txt",
				"DeclareSBreak.java");
		return mc.CheckAndUpdateChallenge(("DeclareSBreak"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare SReturn")
   	public String declareSReturnPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Switch case statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Switch case statements with return<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Write a method called gimmeADay that accepts an int and returns a string. Within this method, you are trying to differentiate between days of the week where 1=Sunday, 2=Monday and so on.</p>"+
				"<p>HINT: You might be thinking you should use 8 seperate if-statements to check the value and return the day. A general rule of thumb, if you have more than 3 if statements, you should use switch cases that work exactly like if-statements but are designed perfectly for this scenario. \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareSReturn.txt",
				"DeclareSReturn.java");
		return mc.CheckAndUpdateChallenge(("DeclareSReturn"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare Switch")
   	public String declareSwitchPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "Switch case statements";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Practice with switch case statements<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Write a program using switch statements that assigns the day of the week based on which number "
				+ "is assigned to the variable day. Use int day for number 1-7, use String dayName for each day of the week, "
				+ "initialize it to \"\".</p>"+
				"<p>HINT: You will need to make separate \"cases\" for every day of the week. "
				+ "You will have cases 1-7. Make Sunday #1, Monday #2 and so on, do not put break statements in between. "
				+ "Also, write the statement default: dayName=\"Invalid Day\"; Break; "
				+ "This will be a catch all for any number not between 1 and 7. "
				+ "Notice what will print when you write the print statement for dayName. "
				+ "What happens if you take the last case statement out? Will the output be different?\n" + 
				" \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareSwitch.txt",
				"DeclareSwitch.java");
		return mc.CheckAndUpdateChallenge(("DeclareSwitch"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare WBreak")
   	public String declareWBreakPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "While loops";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>While loop using break<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer named a and set the value to 10. Declare an integer called counter and set it to 1. Use a while loop to increment counter 5 times while the condition is true. Once the condition is false, use a break statement to “break” out of the loop. Then return the concatenated phrase ““Sum is “+ variable”” so that all 5 sum totals will print in sequential order.</p>"+
				"<p>HINT: the break statement should be nested within the while loop in an if statement.\n" + 
				" \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareWBreak.txt",
				"DeclareWBreak.java");
		return mc.CheckAndUpdateChallenge(("DeclareWBreak"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare WContinue")
   	public String declareWContinuePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "While loops";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>While loop using continue<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer named counter and set it equal to 10. Use a while loop to DECREMENT the counter from 10 to 0. Use a continue statement to skip the number 5 when the counter gets to it. Output the result using a Print statement.</p>"+
				"<p>HINT: the continue statement should be nested within the while loop in an if statement.\n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareWContinue.txt",
				"DeclareWContinue.java");
		return mc.CheckAndUpdateChallenge(("DeclareWContinue"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare While")
   	public String declareWhilePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "While loops";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Practice using While loops<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Building on your knowledge of if Statements, "
				+ "you can test if the statement is true within a while loop and set a counter that will "
				+ "automatically increment so that you can’t get stuck within an infinite loop.</p>"+
				"<p>Declare int counter = 1. While counter less 5, increment counter. "
				+ "Print out the concatenated statement (\"counter is\"+ counter) using the current counter variable. "
				+ "Once counter = 5, Print \"Done.\"\n" + 
				" \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareWhile.txt",
				"DeclareWhile.java");
		return mc.CheckAndUpdateChallenge(("DeclareWhile"), "cs175", compiler, model);
   	}
    
    @PostMapping(value = "/home/cs175/Control Flow Statements/Declare WReturn")
   	public String declareWReturnPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException  
   	{
    	String header = "While loops";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>While loops with return<p>"
				+"<br /><h4>Challenge:</h4>"
				+"<p>Declare an integer named a and set the value to 10. "
				+ "Declare an int called counter and set it to 1. Use a while loop to increment a by counter 5 times. "
				+ "Increment counter by one each time you increase a by counter. "
				+ "Your while loop should look similar to this while(counter<5){//BODY}</p>"+
				"<p>int a = 10;\n" + 
				"int counter =1;\n" + 
				"while(counter<5){\n" + 
				"a = counter + a;\n" + 
				"counter++;\n" + 
				"}\n" + 
				"return counter + a;\n" + 
				"\n" + 
				" \n" + 
				"</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/ControlFlowStatements/DeclareWReturn.txt",
				"DeclareWReturn.java");
		return mc.CheckAndUpdateChallenge(("DeclareWReturn"), "cs175", compiler, model);
   	}
    
	// *********************************************
	// *********************************** METHOD II
	// *********************************************
	@PostMapping(value = "/home/cs175/More Methods/Boolean Method")
	public String booleanMethodPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Declaring an boolean method Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Boolean is a powerful primitive data type in Java that can set conditions for your code. </p>"
				+"<div class='code'><pre>public boolean myBolMethod(boolean a){"
				+ "//body"
				+ "}</pre></div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Declare a method called booleanMethod that takes an boolean" + 
				 " as a parameter and returns the inverse of that boolean(Hint: Not is a" + 
				 " logical operator that switches a condition from true to false or from false to true). </p>"
				+"<p>First, create the method booleanMethod that accepts a boolean value.</p>"
				+"<p>Next, return the inverse of the given boolean value.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsII/BooleanMethod.txt",
				"BooleanMethod.java");
		return mc.CheckAndUpdateChallenge(("BooleanMethod"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/More Methods/Int Method")
	public String intMethodPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Int Method";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Java allows for the implementation of a plethora of different method types."
				 + " In this challenge you will be focusing on returning and accepting integers. Ensure your"
				 + " access specifier is public and the data type is an int.</p>"
				+"<div class='code'><pre>public int myIntMethod(int a, int b){"
				+ "//Body"
				+ "}</pre></div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Declare a method called intMethod that takes in two int " + 
				 "parameters and returns the difference.</p>"
				+"<p>First, create the method intMethod that has two paramaters and returns an int.</p>"
				+"<p>Next, subtract the first integer from the second and then return the difference.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsII/IntMethod.txt",
				"IntMethod.java");
		return mc.CheckAndUpdateChallenge(("IntMethod"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/More Methods/String Duplicates")
	public String stringDuplicatesPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "String Duplicates Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Checking for similarities in a String is a concept you will use for your entire coding career."
				 + " The String class has many methods that allow the user to test the String. The methods one could use"
				 + " to check what each letter/symbol/number a String contains is the charAt() method. This method returns the "
				 + " Unicode number of the specific letter/number/symbol which allows you to check each index for similarities. The Unicode "
				 + "number for A is 65 and for a is 97. B is 66 and b is 98, and so on until Z & z.</p>"
				+"<div class='code'>public String myString(String a){return a;}</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Declare a method called stringMorpher that accepts one String as a parameter." + 
				" Remove all duplicate letters/numbers/symbols in the String" + 
				" Return the String without any duplicates. Capitalization does not matter. Example, str = \\\"aAb )\\\" return \\\"b )</p>"
				+"<p>First, declare a method called stringMorpher that returns a String and accepts a String.</p>"
				+"<p>Next, remove all duplicate letters/numbers/symbols from the String you accepted and return the modified String.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsII/StringDuplicates.txt",
				"StringDuplicates.java");
		return mc.CheckAndUpdateChallenge(("StringDuplicates"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/More Methods/Void Method")
	public String voidMethodPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Declaring an void method Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>Void in Java is used to indicate that the method has no return type. Having no return type"
				 + " means at method declaration you write public void instead of public dataType.</p>"
				+"<div class='code'>public void methodName(){}</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Declare a method called noReturn that does not take any " + 
				 "parameters and does not return anything.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsII/VoidMethod.txt",
				"VoidMethod.java");
		return mc.CheckAndUpdateChallenge(("VoidMethod"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/More Methods/Logical All")
	public String logicalAllPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		String header = "Logical all Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>In previous challenges you used logical operators like >,< or ==. This challenge"
				 + " will test what you have learned in one long condition that uses almost all of your logical operator"
				 + " knowledge.</p>"
				+"<div class='code'>public int myMethod(int a, int b){//BODY}</div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Write a method called logicalAll that accepts four integers as " + 
				 "parameters and returns an int. Next, create 4 local variables that are integers called myLoc1, " + 
				 "myLoc2, myLoc3, and myLoc4 assign the value 0,1,2,3 respectively " + 
				 "Next, check whether the values passed in are equal and if so return myLoc1. " + 
				 "Also, check whether the first parameter is greater than the second " + 
				 "OR if the first paramter is less than the second, if so return myLoc2. " + 
				 "Finally, check whether the first parameter and the " + 
				 "second paramter are divisible by 2 and if so return myLoc3. " + 
				 "If none of these conditions are true return myLoc4.</p>"
				+"<p>First, create the method logicalAll that has four int parameter and returns an int.</p>"
				+"<p>Next, set myLoc1,2,3,4 to 0,1,2,3 respectively.</p>"
				+"<p>Finally, given the conditions above either return myLoc1,2,3, or myLoc4.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/MethodsII/LogicalAll.txt",
				"LogicalAll.java");
		return mc.CheckAndUpdateChallenge(("LogicalAll"), "cs175", compiler, model);
	}
	
	// *********************************************
	// **************************************** FILE
	// *********************************************
	@PostMapping(value = "/home/cs175/File/Import A File")
	public String importFileMethodPost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Importing a File Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>One of the coolest things you can do with Java is work with other files from your system. Importing a file is very"
				 + " simple, but might take a little bit of practice and file management skills to fully understand it. To import a file"
				 + " you must know the file path, if working with Windows the file path usually looks similar to this; C:\\Documents\\CoolFiles\\MyFile.txt	"
				 + ". However, to make this process even simpler you can actually add txt files (text files) to your Java project and the"
				 + " only path you need to know is the files name. There are many options you can use in Java to read/write to a file, but the easiest"
				 + " for beginners is the File class. </p>"
				+"<div class='code'><pre>File myFile = new File(\"pathName\");</pre></div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, Create a File object called toRead and set its pathName to work.txt.</p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/File/ImportAFile.txt",
				"ImportAFile.java");
		return mc.CheckAndUpdateChallenge(("ImportAFile"), "cs175", compiler, model);
	}
	
	@PostMapping(value = "/home/cs175/File/Read A File")
	public String readAFilePost(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException 
	{
		String header = "Reading data from a File Challenge";
		String description = "<br /><h4>Description:</h4>"+ 
				 "<p>In the previous challenge you create a File called toRead and set that file to work.txt. The next step is to"
				 + " read whats inside the File. The work.txt is already created and once you read it you will be able to take a look"
				 + " at whats inside. To read a File you must first create a Scanner Object, the parameter for the Scanner Object"
				 + " will be the File you created previously (Although, you do not see the toRead variable you created previously just know its there and set the parameter to toRead). "
				 + " To actual continuously print out the data you will need to create a while loop that loops through the Scanner Object until it reaches the end. "
				 + "The Scanner Class has a few built in methods like hasNextLine() and nextLine() that will assist you in this.</p>"
				+"<div class='code'><pre>Scanner in = new Scanner(fileName);\n"
				+ "						 \nwhile(in.hasNextLine())\n{"
				+ "						\n&nbspString toBePrinted = in.nextLine();"
				+ "						 \n&nbspSystem.out.println(toBePrinted);"
				+ "\n}</pre></div><br />"
				+"<br /><h4>Challenge:</h4>"
				+"<p>For your challenge, print the previous File toRead by using a while loop and the Scanner class, make the variable name for Scanner to in. NOTE: When "
				+ "you read a File using a while loop it does have the potential to throw a FileNotFoundException, which is a checked exception, exception handeling"
				+ " will be in a later challenge just understand if you were to do this on your own you would need to handle the exception, the exception has been handled for you in this challenge. </p>";
		String userInput = compiler.getUserInput();
		populateChallenge(model, header, description, userInput);
		setCompiler(compiler, model, "static/cs175/File/ReadAFile.txt",
				"ReadAFile.java");
		return mc.CheckAndUpdateChallenge(("ReadAFile"), "cs175", compiler, model);
	}
}
