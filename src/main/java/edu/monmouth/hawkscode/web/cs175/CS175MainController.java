package edu.monmouth.hawkscode.web.cs175;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CS175MainController {
	/*
	 * FORMULA FOR CHALLENGE CREATION:
	 * 
	 * 1. In this folder find the section the challenge should exist in (e.g. Method I, Control Flow Statements,
	 * etc.).  If the section does not yet exist, create it and the description of the section. 
	 * 
	 * 2. Add the name of the challenge to the List<String> challenges object.
	 * 
	 * 3. Write the @GetMapping for the challenge in the CS175GetController. Note: the value of this annotation
	 * should be the same as the String name you added for the challenge in step 2. This involves writing a 
	 * challenge description and a challenge header
	 * 
	 * 4. Write the @PostMapping with the same value as the @GetMapping.
	 * 
	 * 5. Create a .txt file in the folder corresponding to the challenge section. This path in the eclipse 
	 * project has root path src/main/resources/static/cs175.
	 * 
	 * 6. Populate the .txt file with base code.  This involves code that will reasonably test to see if the
	 * student followed the directions of the challenge properly. 
	 */

	public void populateTopics(ModelMap model,  String path, String header, String description, List<String> challenges, List<String> links) {
		model.put("path", path);
		model.put("header", header);
		model.put("description", description);
		model.put("challenges", challenges);
		model.put("links", links);
	}
	public void populateTopics(ModelMap model,  String path, String header, String description, List<String> links) {
		model.put("path", path);
		model.put("header", header);
		model.put("description", description);
		model.put("links", links);
	}
	/*
	 	String path = ""; 
	 	
	 	String header = ""; 
	 	String description = ""; 
	 	
	 	List<String> challenges = new LinkedList<>();
	 	List<String> links = new LinkedList<>();
	 	
	 	populateTopics(model, path, header, description, challenges, links);
	 	return "b-topics";
	 */
	
	/* ******** TOPICS ******** TOPICS ******** TOPICS ******** TOPICS ******** TOPICS ******** */
		
	// *********************************************
	// ************************ PRIMITIVE DATA TYPES 
	// *********************************************
	@GetMapping(value = "/home/cs175/Primitive Data Types")
	public String primitiveDataTypes(ModelMap model){
		String path = "/home/cs175/Primitive Data Types";
		
		String header = "Primitive Data Types";
		String description = "		<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"Primitive data types are often considered one of the building blocks of the Java Language due to their simplicity and ease of use.  There are 8 primitive"
				+ " data types (<samp>boolean</samp>, <samp>char</samp>, <samp>byte</samp>, <samp>int</samp>, <samp>short</samp>, <samp>long</samp>, <samp>float</samp>, and <samp>double</samp>). <br/>  Primitive data types are useful to store and manipulate"
				+ " simple, raw data values (literals). Raw data values are simply literal values of a certain type (e.g. <samp>12</samp>, <samp>'a'</samp>, or <samp>true</samp>). The primitive data types are not considered to be Objects because they are declared and used differently.  \r\n" + 
				"			<br/><br/>"
				+ " This section covers defining and declaring the eight primitives. Declaring primitives follows a basic formula:</p> <br/>"
				+ " <pre>&lt;type&gt; &lt;variable name&gt;;</pre><br/>"
				+ " <p class=\\\"topic-description\\\">"
				+ " For example if we wanted to declare a <samp>boolean</samp> variable called test we would write: </p><br/> "
				+ " <pre>boolean test;</pre><br/>"
				+ " <p class=\\\"topic-description\\\">"
				+ "Setting a variable equal to a value is called instantiation. This can be done in the same line we declare a variable, or"
				+ " in a new line.  Both are frequently used by programmers and are seen below following the first example. <br/><br/>"
				+ " One line: </p>"
				+ " <pre>boolean test = true;</pre><br/>"
				+ " <p class=\\\"topic-description\\\">"
				+ " Two lines: </p>"
				+ " <pre>\r\n<br/>\r\n boolean test; <br/> "
				+ " test = true;</pre>"
				+ "\r\n" + 
				"		</div>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("boolean");
		challenges.add("char");
		challenges.add("Numerical Primitives");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Primitive Data Types/boolean")
	public String primitiveDataTypesBoolean(ModelMap model)
	{
		String path = "/home/cs175/Primitive Data Types/boolean";
		
		String header = "boolean";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				The <samp>boolean</samp> primitive data type can have a value of either <samp>true</samp> or <samp>false</samp>.  It's as "
				+ "simple as that!  Typically, <samp>boolean</samp> variables are used for control flow statements that you will "
				+ "learn about later on in CS175.\r\n" + 
				"			</p>\r\n" + 
				"		</div>";
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Declare Boolean");
		challenges.add("Declare Print Boolean");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path,header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Primitive Data Types/char")
	public String primitiveDataTypesChar(ModelMap model)
	{
		String header = "char";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				A <samp>char</samp> is a primitive data type that represents a single character. Raw values"
				+ " of chars are surrounded by single quotes (e.g. <samp>'a'</samp>). Note that these characters are case sensitive, thus <samp>'a'</samp> is different than <samp>'A'</samp>.\r\n" + 
				"			</p>\r\n" + 
				"		</div>";

		String path = "/home/cs175/Primitive Data Types/char";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Declare Char");
		challenges.add("Declare Print Char");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Primitive Data Types/Numerical Primitives")
	public String primitiveDataTypesNumericalPrimitives(ModelMap model)
	{
		String path = "/home/cs175/Primitive Data Types/Numerical Primitives";
		
		String header = "Numerical Primitives";
		String description = "<div class=\"introduction\"> \r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				The first two primitive data types we looked at (<samp>boolean</samp> and <samp>char</samp>) are not considered to be numeric.  It goes "
				+ "without saying that their values do not represent numbers.  The six other primitive types are all numeric, their differences being "
				+ "the range of values that they can hold.\r\n" + 
				"			 Numerical primitives consist of <samp>int</samp>, <samp>byte</samp>, <samp>short</samp>, <samp>long</samp>, <samp>float</samp>, and <samp>double</samp>.\r\n" + 
				"			</p> \r\n" + 
				"			\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				int:\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				 An <samp>int</samp> value is a 32-bit signed integer (a whole number that is either positive, negative or 0). \r\n" + 
				"				 The <samp>int</samp> has a minimum value of -2<sup>31</sup> and a maximum value of 2<sup>31</sup>-1 (or -2,147,483,648 to 2,147,483,647) inclusive.  "
				+ "             This primitive is the most widely used numeric primitive because it only uses 4 bytes of memory and has a wide range of possible values.  Unless a programmer"
				+ "              is working with extremely large numbers, they do not have to worry about exceeding the minimum or maximum values of <samp>int</samp> when manipulating them.\r\n" + 
				"			</p>\r\n" + 
				"			\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				byte:\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				A <samp>byte</samp> value is a 8-bit signed integer with a  \r\n" + 
				"				minimum value of -128 and a maximum value of 127 inclusive.  The <samp>byte</samp> is an uncommon data type due to its small range of possible values."
				+ "             Typically bytes can be used if you are not going to modify the value with addition, subtraction, multiplication, or division and are concerned about"
				+ "             memory issues in giant enterprise applications.\r\n " + 
				"			</p>\r\n" + 
				"\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				short:\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				A <samp>short</samp> value is a 16-bit signed integer with a \r\n" + 
				"			    minimum value of -32,768 and a maximum value of 32,767 inclusive. It is not commonly used for the same reasons that"
				+ "             <samp>byte</samp> is not commonly used.\r\n" + 
				"			</p>\r\n" + 
				"\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				long:\r\n" + 
				"			</b> \r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				A <samp>long</samp> value 64-bit signed integer. The <samp>long</samp> \r\n" + 
				"				has a minimum value of -2<sup>63</sup> and a maximum value of 2<sup>63</sup>-1 (or -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807) inclusive. "
				+ "             This primitive is used when working with extremely small or large numbers that are outside of the scope of <samp>int</samp>.\r\n" + 
				"			</p> \r\n" + 
				"\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				float:\r\n" + 
				"			</b> \r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				A <samp>float</samp> value is a 32-bit floating point number (or decimal). The range of possible values it can hold are 7 significant"
				+ "             decimal digits.  They are used to represent non-integer rational numbers such as bank account balances. \r\n" + 
				"			</p>\r\n" + 
				"\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				double:\r\n" + 
				"			</b> \r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\"> \r\n" + 
				"				A <samp>double</samp> value is a 64-bit floating point number (or decimal).  The range of possible values it can hold are 15 significant\r\n" + 
				"				              decimal digits.  It is used to represent"
				+ "             non-integer rational numbers.\r\n" + 
				"			</p>\r\n" + 
				"		</div>";	
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Declare Integer");
		challenges.add("Declare Print Integer");
		challenges.add("Declare Numerical Primitives");
		challenges.add("Declare Print Numerical Primitives");
		
		List<String> links = new LinkedList<>();
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ************************************ STRING I 
	// *********************************************
	
	@GetMapping(value = "/home/cs175/String I")
	public String stringI(ModelMap model)
	{
		String path = "/home/cs175/String I";
		
		String header = "String I";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				A <samp>String</samp> is a sequence of characters enclosed within double quotation marks (e.g. <samp>\"Hello, World!!!\"</samp>).  They are typically used for describing data not easily captured"
				+ " by the primitives (e.g. names, addresses, company name, etc.) and displaying messages to the user. In fact, the text you are reading right now is a Java <samp>String</samp> object that we have"
				+ " rendered into an HTML view!! <br/><br/> <samp>Strings</samp> are Objects not primitive data types.  However, they "
				+ "can be declared similarly to primitive data types and are typically learned with primitives.  They can also be declared like any other Object using the <samp>new</samp> keyword, which is not"
				+ " the case for primitives.</p>\r\n" + 
				"		</div>";
				
		List<String> challenges = new LinkedList<>();
		challenges.add("Declare String");
		challenges.add("Declare Print String");
		challenges.add("String Literal");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ***************************** BASIC OPERATORS 
	// *********************************************

	@GetMapping(value = "/home/cs175/Basic Operators")
	public String basicOerators(ModelMap model)
	{
		String path = "/home/cs175/Basic Operators";
		
		String header = "Basic Operators";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				Basic Operators are symbols that are used to manipulate the values of primitive or <samp>String</samp> variables.  They are often considered to be 'sytactic sugar', meaning that they"
				+ "             are built in Java constructs designed to make the language easier to use. <br/><br/> Certain numerical variables"
				+ "             can be combined using simple mathematical operations.  There is also built in functionality to combine <samp>boolean</samp> values using the"
				+ "             traditional logical operators. Basic Operators can be used to create complex conditions to test for certain cases." + 
				"			</p>\r\n" + 
				"		</div>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Boolean Operators");
		challenges.add("Logical Operators");
		challenges.add("Numerical Operators");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Basic Operators/Boolean Operators")
	public String basicOeratorsBooleanOperators(ModelMap model)
	{
		String path = "/home/cs175/Basic Operators/Boolean Operators";
		
		String header = "Boolean Operators";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				Boolean operators are used to compare the value of two numeric variables to return <samp>boolean</samp> values depending"
				+ "             on whether the condition they are testing is logically satisfied or not.  \r\n" + 
				"				This section introduces you to two Boolean operators Greater Than ( > ) and Less Than ( < ). \r\n" + 
				"			</p>\r\n" + 
				"		</div>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Greater Than");
		challenges.add("Less Than");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Basic Operators/Logical Operators")
	public String basicOeratorsLogicalOperators(ModelMap model)
	{
		String path = "/home/cs175/Basic Operators/Logical Operators";
		Object a = new Object();
		String header = "Logical Operators";
		String description = "<div class=\"introduction\">\r\n" + 
				"		<p class=\"topic-description\">\r\n" + 
				"			Logical Operators combine <samp>boolean</samp> values to return <samp>boolean</samp> values. \r\n" + 
				"			\r\n" + 
				"			These operators are EQUALS TO ( == ), AND ( & ), OR ( | ), \r\n" + 
				"			XOR ( ^ ), NOT ( ! ), NOT EQUALS ( != ), SHORT CIRCUIT \r\n" + 
				"			AND ( && ), and SHORT CIRCUIT OR ( || ).<br/><br/>" +
							"The difference between & and && (and of course | and ||) is that the SHORT CIRCUIT "
							+ "version will not test the right hand side if the condition is already satisfied by the left hand side."
							+ "  <br/><br/>For example, if we want to test <samp>false & true</samp>, Java will look at the value of both sides before returning <samp>false</samp>."
							+ "  If we want to test <samp>false && true</samp>, Java will only look at the value of the left hand side since that value is <samp>false</samp>. "
							+ "It does not matter what the value on the right hand side is since we are evaluating the Logical AND." +
				"		</p>\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				EQUALS TO ( == ): 		\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				Returns <samp>true</samp> if the two values are the same.  This operator can be used with other primitive variables"
				+ "             and values but should not be used with Objects.\r\n" + 
				"			</p>\r\n" + 
				"			<!-- **************************************** --> \r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				 AND ( & ) / SHORT CIRCUIT AND ( && ):\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				Returns <samp>true</samp> if the two <samp>boolean</samp> expressions are <samp>true</samp> otherwise returns <samp>false</samp>. SHORT CIRCUIT AND should be "
				+ "             used rather than the simple AND. \r\n" + 
				"			</p>\r\n" + 
				"			<!-- **************************************** --> \r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				OR ( | ) / Boolean SHORT CIRCUIT OR ( || ):\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				Inclusive OR operator. Returns <samp>false</samp> if both <samp>boolean</samp> expressions are <samp>false</samp>, otherwise returns <samp>true</samp>. SHORT CIRCUIT OR should be \r\n" + 
				"				              used rather than the simple OR.\r\n" + 
				"			</p>\r\n" + 
				"			<!-- **************************************** --> \r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				XOR( ^ ): 		\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				 Exclusive OR operator. Returns <samp>true</samp> if both <samp>boolean</samp> expressions are different, otherwise returns <samp>false</samp>.\r\n" + 
				"			</p>\r\n" + 
				"			<!-- **************************************** --> \r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				NOT ( ! ): 		\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				Changes the value of a <samp>true</samp> to a <samp>false</samp> and vice versa.\r\n" + 
				"			</p>\r\n" + 
				"			<!-- **************************************** --> 			\r\n" + 
				"			<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"				NOT EQUAL( != ): 		\r\n" + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 7em\">\r\n" + 
				"				Returns <samp>true</samp> if two <samp>boolean</samp> expressions are NOT the same. This operator can be used for numerical primitives as well.\r\n" + 
				"			</p>\r\n" + 
				"			\r\n" + 
				"		<p>EXAMPLE:</p>\r\n" + 
				"		<pre>\r\n" + 
				"	    boolean A = true;\r\n" + 
				"		boolean B = false; \r\n" + 
				"		\r\n" + 
				"		System.out.println(\"[Boolean Equals To] A == B: \" + (A == B) ); \r\n" + 
				"		System.out.println(\"[Boolean And] A && B: \" + (A &&; B)); \r\n" + 
				"		System.out.println(\"[Boolean Or] A | B: \" + (A | B)); \r\n" + 
				"		System.out.println(\"[Boolean XOr] - A ^ B: \" + (A ^ B)); \r\n" + 
				"		System.out.println(\"[Boolean Not] !A: \" + (!A)); \r\n" + 
				"		System.out.println(\"[Boolean Not Equal ]A != B: \" + (A != B)); \r\n" + 
				"		</pre>\r\n" + 
				"		<p>OUTPUT:</p>\r\n" + 
				"		<pre>\r\n" + 
				"		[Boolean Equals To] A == B: false\r\n" + 
				"		[Boolean And] A && B: false\r\n" + 
				"		[Boolean Or] A | B: true\r\n" + 
				"		[Boolean XOr] A ^ B: true\r\n" + 
				"		[Boolean Not] !A: false\r\n" + 
				"		[Boolean Not Equals] A != B: true\r\n" + 
				"		</pre> \r\n" + 
				"		</div>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Boolean Equals To");
		challenges.add("Boolean And");
		challenges.add("Boolean Or");
		challenges.add("Boolean XOr");
		challenges.add("Boolean Not"); 
		challenges.add("Boolean Not Equals");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs175/Basic Operators/Numerical Operators")
	public String basicOeratorsNumericalOperators(ModelMap model)
	{
		String path = "/home/cs175/Basic Operators/Numerical Operators";
		
		String header = "Numerical Operators";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				Within Numerical Operators you are introduced to the basic operations of elementary arithmetic used in mathematical equations. " + 
				"			</p>\r\n" + 
				"		</div>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Addition Int");
		challenges.add("Subtraction Int");
		challenges.add("Multiplication Int");
		challenges.add("Division Int");
		challenges.add("Equation Int");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ********************** CASTING AND CONVERTING 
	// *********************************************
	// TODO: look over this to make sure it is update with your material 
	
	@GetMapping(value = "/home/cs175/Casting And Converting")
	public String castingAndConverting(ModelMap model)
	{
		String path = "/home/cs175/Casting And Converting";
		
		String header = "Casting And Converting";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"Casting is when you declare a variable of one type to have a different type. \r\n" + 
				"A common use of this functionality is changing of your variable from an <samp>int</samp> to a <samp>String</samp> \r\n" + 
				"or vice versa. <br/><br/>"
				+ "There are some different types of casting and converting that we cover in this section."
				+ " The first and simplest is automatic or widening conversion. It occurs between the numerical primitive data types when a"
				+ " numerical primitive of a smaller size (in bytes) is used to declare a numerical primitive of a larger size (in bytes).  Essentially, "
				+ "the primitive of the smaller size is widened to the larger type without losing the integrity of the value of the smaller type.  No new"
				+ " Java syntax is required to perform this change! <br/><br/>"
				+ " The second type is narrowing conversion, the opposite of widening conversion, which is when a numerical primitive of a "
				+ " larger type is used to declare a numerical primitive of a smaller type.  This conversion might result in some loss of information and Java will"
				+ " throw an error if you do not use the proper casting and converting syntax. <br/><br/>Java has built in syntax for casting by using "  + 
				"				the parenthesis. <br/><br/> "
				+ "For example: </p></br>"
				+ "  <pre>int x = 120;</pre>"
				+ "  <pre>byte y = x;</pre>"
				+ "<p class=\"topic-description\">"
				+ " Will produce a compile time error since you are trying to cast the larger <samp>int</samp> to a smaller <samp>byte</samp>.  However, you can cast the variable <samp>x</samp> in the declaration seen below"
				+ " to properly convert <samp>x</samp> into a <samp>byte</samp>.<br/></p>"
				
				+ "  <pre>int x = 120;</pre>"
				+ "  <pre>byte y = (byte) x;</pre><br/>"
				+ " <p class=\"topic-description\">"
				+ " The third type of conversion we discuss in this section is type conversion in expressions.  This is another type of automatic conversion when using "
				+ " the arithmetic operators between numerical primitives that we have previously discussed. When using these operators, the types of the variables in the "
				+ " expression are automatically converted to int, unless you use a type larger (in bytes) than int (long, float, or double).  In this case the type of the variables "
				+ "will be converted to the largest type variable in the expression.<br/>"
				+ " For example: </p></br>"
				+ " <pre>byte x = 120;</pre> "
				+ " <pre>byte y = 120;</pre> "
				+ " <pre>byte z = x + y;</pre> "
				+ "<p class=\"topic-description\">"
				+ " will throw an error since the '+' operator automatically converts the <samp>byte</samp> variables to <samp>int</samp> variables, thus <samp>z</samp> is an <samp>int</samp> variable. To get around this, we either have to declare"
				+ " <samp>z</samp> an <samp>int</samp> or cast the expression to <samp>byte</samp> like so: </p><br/>"
				+ " <pre>byte z = (byte) x + y;</pre>"
				+ " <p class=\"topic-description\">"
				+ "Some data types cannot be easily converted \r\n" + 
				"to another, like the above example; however, mostly all converting of \r\n" + 
				"numerical data types can use the simple paranthesis built in function to \r\n" + 
				"change.  <br/><br/>"
				+ " We discuss another type of conversion within the challenges of this section.  These are special cases"
				+ " involving converting numericals to and from <samp>Strings</samp>.  They will have a syntax that we revisit in other sections, but it is"
				+ " good to be introduced to them here without getting bogged down by additional detail."
				+ "<br/><br/>Although, casting is an easy to use way to change a primitive data \r\n" + 
				"type to another, it is recommended to only use casting when absolutely \r\n" + 
				"neccessary. It is best practice to avoid casting. <br> \r\n" + 
				"</p>\r\n" + 
				"		</div>";
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Double To Int");
		challenges.add("Double To String");
		challenges.add("Int To String");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ************************************ STATIC I 
	// *********************************************

	@GetMapping(value = "/home/cs175/Static I")
	public String staticI(ModelMap model)
	{
		String path = "/home/cs175/Static I";
		
		String header = "Static I";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				Within Java programming there are class members called static variables. Static variables are all instances of the variable <br> will be set to the initial declaration of the variable. \r\n" + 
				"			</p>\r\n" + 
				"		</div>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Default Boolean");
		challenges.add("Default Char");
		challenges.add("Default String");
		challenges.add("Default Integer");
		challenges.add("Default Numerical Primitives");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// *********************************** OBJECTS I 
	// *********************************************
	// TODO: look over this to make sure it is update with your material
	
	@GetMapping(value = "/home/cs175/Objects and Classes/Objects")
	public String objects(ModelMap model)
	{
		String path = "/home/cs175/Objects and Classes/Objects";
		
		String header = "Objects";
		String description = "<div class=\"introduction\">\r\n" + 
				  "<p class=\"topic-description\">\r\n" + 
				  "In the Classes section, we discussed how difficult it would be to use primitive data types and Strings to try and model "
				  + "some real world situation.  We then modeled a blueprint for Book objects, which gave us a way to organize 4 variables "
				  + "related to books (author, title, ID, and price). Finally, we discussed 'getter and setter' methods which allowed us to"
				  + " access these variables.<br/><br/>"
				  + "We now begin our discussion of Objects!  In this section we will see several ways we can create a new Book and populate"
				  + " its variables.<br/><br/>"
				+ "An Object is an instance of a class that allows the for the instantiation and manipulation of the data and attributes contained within that class. "
				+ "Each Object that is declared is unique, meaning they are part of the same class and can manipulate the methods "
				+ "and data within that class, but their manipulation will only be contained within that Object.</p>\r\n</div>";
		List<String> challenges = new LinkedList<>();
		challenges.add("Create a Book");
		challenges.add("Using Getters and Setters");
		challenges.add("Constructors");
		//challenges.add("Default Constructors");
		challenges.add("Declare Object");
		challenges.add("Declare Object WNew");
		challenges.add("Object Eq");
	
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
		// *********************************** OBJECTS AND CLASSES.  NEW COMBO 
		// *********************************************
		// TODO: look over this to make sure it is update with your material
		
		@GetMapping(value = "/home/cs175/Objects and Classes")
		public String objectsAndClasses(ModelMap model)
		{
			String path = "/home/cs175/Objects and Classes";
			
			String header = "Objects and Classes";
			String description = "<div class=\"introduction\">\r\n" + 
					  "<p class=\"topic-description\">\r\n"
					  + "Objects and classes are two different concepts in Java, but they are hard to talk about seperately.  Being an Object Oriented Programming Language, Java"
					  + " utilizes objects as its primary vehicle for data manipulation.  We saw how primitive data types can be declared, used, and manipulated in the previous sections,"
					  + " but the primitives can only describe very basic situations.  <br/><br/>Objects allow for more complex situations to be described.  Typically, they contain several values"
					  + " all described by a single variable.  These values can be manipulated and accessed with methods (think of them as functions)." + 
					  "  <br/><br/>Classes are the starting point for creating Objects in Java.  Classes are informally known as the blueprint for objects.  This allows for many objects of the same"
					  + "  type to be defined, each containing different values for their variables.  We start by discussing Classes, and then discuss Object instantiation and usage."
					+ "</p>\r\n</div>";
			List<String> challenges = new LinkedList<>();
			challenges.add("Classes");
			challenges.add("Objects");
			
			List<String> links = new LinkedList<>();
			
			populateTopics(model, path, header, description, challenges,links);
			return "b-topics";
		}
	
	// *********************************************
	// *********************************** STRING II 
	// *********************************************
	
	@GetMapping(value = "/home/cs175/Using Methods")
	public String stringII(ModelMap model)
	{
		String path = "/home/cs175/Using Methods";
		
		String header = "Using Methods";
		String description = "<div class=\"introduction\">\r\n" + 
				  "<p class=\"topic-description\">\r\n"
				  + "Although they can be declared with literal values like primitives, Strings are objects.  While there"
				  + " are some basic operators that we can use to manipulate primitives, primitives are very limited in the"
				  + " ways they can be manipulated.  Objects on the other hand typically use methods as the primary vehicle "
				  + " for manipulating data.  At their most basic, methods can be thought of as functions.<br/><br/>"
				  + " While the basic operators are a built in Java functionality (the compiler treats the operator symbols as special entities)"
				  + ", methods are always written out in Java by a programmer.  The "
				  + " methods we use in this section are all part of the String class, "
				  + " meaning that they operate on String objects.<br/><br/>"
				  + " Methods must be defined before they are used.  All the methods we use in this section have already been "
				  + " defined by the developers of Java, but we will introduce how to define a method and then how to use that "
				  + " method.<br/><br/>"
				  + " The basic form of a method definition is seen below: </p><br/>"
				  + " <pre>&lt;access modifier&gt; &lt;return type&gt; &lt;methodName&gt;(&lt;input parameters (could be more than one)&gt;);</pre><br/>"
				  + "<p>For example, let's look at the method definition of the pre-written method <samp>replace()</samp> for the String class.</p><br/>"
				  + " <pre>public String replace(char oldChar, char newChar){ <br/> &nbsp;&nbsp;&nbsp;&nbsp;//method body goes here <br/> }</pre>"
				  + "<p> The keyword <samp>public</samp> is the access modifier.  There will be more on this in CS 176, but this basically says that"
				  + " all other classes can use this method.<br/>"
				  + " The next word String specifies that when this method finishes executing, it will return a String to the user.<br/>"
				  + " The word replace is the name of the method.  Finally, char oldChar and char newChar define the input parameters required to run"
				  + " the method.  Both of the input parameter need to be of type char, and the variable names of the input parameters are used to execute"
				  + " the method. <br/>"
				  + " Finally, the comment block shows us where the body of the method goes.  Within the set of the curly braces will "
				  + " be all the logic needed to execute the method.  We choose not to show the details of the method body because typically"
				  + " programmers are only given the method definition to work with! This continues the importance of encapsulation.  When using a"
				  + " method that you did write, such as replace(), it only is important to know the name of the method, the value it will return"
				  + " and the input parameters it takes! When writing your own methods, you need to fill in the body with your own logic.<br/><br/>"
				  + " Basically, this method will return a new String object with all the chars that equal oldChar replaced with the char newChar.<br/><br/>"
				  + "To use this method, we need a String for it to operate on.  We do this using the dot operator. <br/><br/>"
				  + "For example:</p>"
				  + "<pre>String myString = \"bring\";<br/>"
				  + "String replacedString = myString.replace('b', 't');<br/>"
				  + "System.out.println(myString);<br/>"
				  + "System.out.println(replacedString);<br/> </pre>"
				  + "<p> will output:</p>"
				  + "<pre> bring<br/>"
				  + "tring<br/>"
				  + "</pre>"
				+ "</p>\r\n</div>";
			
		List<String> challenges = new LinkedList<>();
		challenges.add("String charAt");
		challenges.add("String Concatenate");
		challenges.add("String Equal");
		challenges.add("String SubString");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ************************************ METHOD I  
	// *********************************************
	// TODO: look over this to make sure it is update with your material 

	@GetMapping(value = "/home/cs175/Writing Methods")
	public String methodsI(ModelMap model)
	{
		String path = "/home/cs175/Writing Methods";
		
		String header = "Writing Methods";
		String description = "<p>"
				+ "We have briefly discussed how to use methods, how to write method headers, and how to write constructor"
				+ " methods.  This section will revisit some of these topics, but with a focus on writing our own methods. "
				+ "<br/><br/>"
				+ "Methods in Java are ways to define actions. Methods allow reuse and once defined"
				+ " can be performed an unlimited amount of times to complete the action the method was designed for. Method syntax"
				+ " in Java has 4 parts: an access specifier, a return type, a method name, and paramaters. For example: </p><pre>"
				+ "				public void myVoid(){<br />"
				+ "					//Body<br />"
				+ "					//No return <br />"
				+ "				}</pre>"
				+ "<p>The method above, myVoid, is a public method (meaning it can be accessed by any class), its datatype is"
				+ " void (meaning it does not return any value upon its completion), its method name is myVoid, and it has no parameters. Another common type of method"
				+ " is a method with a return type. Methods with a return type must return that type of data."
				+ "</p><pre>"
				+ "				public double myDouble(double a, int b){<br />"
				+ "					//Body<br />"
				+ "					return double;<br />"
				+ "				}</pre>"
				+ "<p>The method above (myDouble) is a public method, its return type is double (this indicates you must return a double)"
				+ " and its variable name is myDouble. The method above also must be passed a double and an int, in that order. Although, this method "
				+ " must return a double, you can allow your method to accept any type of data and in any quantity as parameters.<br /> <br />When"
				+ " creating \"good\" methods there are some standards you should always try to keep in mind.  The main thing to keep in"
				+ " mind when writing methods is to limit each method to one specific task.  Do not try to write an entire complex program"
				+ " with only one or two methods. <br/><br/> Another common practice is to "
				+ " only allow a maximum of three parameters/values. While there are many methods contain 4 or more paramerters, methods with three"
				+ " or less parameters tend to be simpler.  Another common practice is"
				+ " to name your method appropriate to the action it performs. Finally, you should only use recursion if and only if you have"
				+ " to (recursion is having a method to call on itself). <br/><br/> Mastering method creation in Java is the first step"
				+ " in fully understanding the language. These challenges are designed to give you a basic idea of what method creation"
				+ " should look like in Java which should help you throughout your Computer Science career! </p>";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Greater Than Method");
		challenges.add("Less Than Method");
		challenges.add("Logical And Method");
		challenges.add("Logical Equals Method");
		challenges.add("Logical Not Method");
		challenges.add("Logical Or Method");

		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ************************************* CLASS I
	// *********************************************

	@GetMapping(value = "/home/cs175/Objects and Classes/Classes")
	public String classI(ModelMap model)
	{
		String path = "/home/cs175/Objects and Classes/Classes";
		
		String header = "Classes";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				As previously stated, Classes are informally regarded as the blueprint for Objects. They are used to define types of data and ways to manipulate "
				+ "  that data.  Each Class is given its own file (there are instances where there are Classes nested within one another, but that is beyond the scope of this discussion).  "
				+ "  A Class is an abstraction of a certain type of data that Java programmers want to define.  <br/><br/> For example, say we would like to make an application designed to model a shopping mall.  We "
				+ "  would like to have data about each shop within the mall. Each shop has a name, a size, and an amount of money they pay monthly to the property owner (rent).  "
				+ "  The programmer of our application would like to keep all these variables neatly organized for each shop within the mall, which would be an extremely difficult to do with primitives alone.  Thus, programmers"
				+ "  favor using the more complex Object for this case.  <br/><br/>"
				+ "  This is where the power of the Class comes in. The programmer sees the need to keep the three variables associated with each mall shop as a singular entity.  They also notice that the three variables"
				+ "  can be used to define many mall shops.  Thus, the programmer will decide to make a Shop class, so that they can use it as a blueprint to define the many shops within the mall.  <br/><br/> "
				+ "  Below is a class file that describes the variables defining a shop within a mall.  We use the '//' to make notes within the 'file' below.  These are comments and are"
				+ "  meant to be read by humans.  It has no impact on the program, and the Java compiler will not read them. <br/>"
				+ "  <pre>"
				+ "  // this file is called Shop.java to match the name of the class Shop <br/>"
				+ "  // the name of a class (class definition) must match the name of the file it is in. <br>"
				+ "  public class Shop{<br />"
				+ "  <br/>"
				+ "  //below are the variables we discussed before that define a shop. <br/>"
				+ "  // these are called instance variables or fields. <br/>"
				+ "  &nbsp;&nbsp;&nbsp;&nbsp;private String name;<br />"
				+ "  &nbsp;&nbsp;&nbsp;&nbsp;private int size;<br/>"
				+ "  &nbsp;&nbsp;&nbsp;&nbsp;private double rent;<br />"
				+ "  }<br /></pre> <br/>"
				+ "  Notice how the variables are not initialized to any value.  This is so we can define any mall Shop using this blueprint.  Each class you write will have the two"
				+ "  basic elements (and some more discussed later).  The first is the class definition.  For our purposes in CS175, all classes will have public preceeding the word"
				+ " class.  Simply put, this tells Java that other files in our program can use this class."
				+ "  \r\n" + 
				"			</p>\r\n" + 
				"		</div>";		
			
		List<String> challenges = new LinkedList<>();
		challenges.add("The Hard Way");
		challenges.add("First Class");
		challenges.add("Getters and Setters");
		challenges.add("Math Class");
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// ******************************** CONTROL FLOW
	// *********************************************

	@GetMapping(value = "/home/cs175/Control Flow Statements")
	public String controlFlowStatements(ModelMap model)
	{
		String path = "/home/cs175/Control Flow Statements";
		
		String header = "Control Flow Statements";
		String description = "This helps with the flow of your code!";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Declare If");
		challenges.add("Declare If Else");
		challenges.add("Declare Nested If Else");
		challenges.add("Declare While");
		challenges.add("Declare WReturn");
		challenges.add("Declare WBreak");
		challenges.add("Declare WContinue");
		challenges.add("Declare For");
		challenges.add("Declare FReturn");
		challenges.add("Declare FBreak");
		challenges.add("Declare FContinue");
		challenges.add("Declare Do");
		challenges.add("Declare DReturn");
		challenges.add("Declare DBreak");
		challenges.add("Declare DContinue");
		//challenges.add("Declare Switch");
		//challenges.add("Declare SReturn");
		challenges.add("Declare SBreak");
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	
	// *********************************************
	// *********************************** METHOD II
	// *********************************************
	// TODO: look over this to make sure it is update with your material
	
	@GetMapping(value = "/home/cs175/More Methods")
	public String methodsII(ModelMap model)
	{
		String path = "/home/cs175/More Methods";
		String header = "More Methods!";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"A more difficult set of methods that should challenge you on Strings, logic, numerics and of course creating methods.\r\n" + 
				"</p>\r\n" + 
				"</div>";		
		List<String> challenges = new LinkedList<>();
		challenges.add("Boolean Method");
		challenges.add("Int Method");
		challenges.add("Void Method");
		challenges.add("Logical All");
		challenges.add("String Duplicates");
		List<String> links = new LinkedList<>();
		populateTopics(model,path , header,description,  challenges, links);		
		return "b-topics";
	}
	// *********************************************
	// **************************************** FILE
	// *********************************************
	// TODO: look over this to make sure it is update with your material
	
	@GetMapping(value = "/home/cs175/File")
	public String file(ModelMap model)
	{
		String path = "/home/cs175/File";
		
		String header = "File";
		String description = "Using external files is a skill that every programmer should have.  Java has a very"
				+ " simple to use File class.  The class has methods to declare a File object based off of an existing"
				+ " file, create a new file in the filesystem, delete files, examine the file's metadata, and so much"
				+ " more.  This section introduces you to the two most important aspects of using files. ";	
			
		List<String> challenges = new LinkedList<>();
		challenges.add("Import A File");
		challenges.add("Read A File");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges,links);
		return "b-topics";
	}
	@GetMapping(value = "/home/cs175/Design Document")
	public String designDoc(ModelMap model){
		String path = "/home/cs175/Design Document";
		
		String header = "Working With A Design Document";
		String description = "<br /><h4>Project Idea: Build Your Own Burger Application</h4>"+ 
				 "<p>"
				 + "This excercise is to get students to start thinking about how to implement the design process when building any computer application/program. "
				 + " These key concepts are covered in later Computer Science classes as students progress through the program but it "
				 + " can be helpful to start thinking of ways to plan, design, test and deploy an application early on in your computer science journey."
				 + "</p>"
				 
				 +"<h5>" 
				 +"Who is the application for?"
				 +"</h5>"
				 +"<p>" 
				 +"Considering the 'Build Your Own Burger' Application, who are you building this application for? Were you hired by a small business?"
				 + " What information does the business want you to consider about their customer base i.e. who will be using the app?"
				 +"</p>"
				 
				+"<h5>" 
				+"What does the application do"
				+"</h5>"
				+"<p>" 
				 +"After discerning who the application is being built for, what expectations does the business have for the application's functionality?"
				 + " Do they want an application that stores customer information? Do they want an application that keeps track of the most popular burger toppings?"
				 +" What are the 'Must Haves' and the 'Nice to Have' features given to you by the business?"
				 +"</p>"
					
				+"<h5>" 
				+"What techonologies are used? (ex: languages, frameworks etc)"
				+"</h5>"
				+"<p>" 
				 +"Next, depending on what the business needs are, what are the languages you'll need to use for the project? Do they want a web-based"
				 + " application? Do they want a mobile application? What are the tools you'll need to complete the project?"
				 +"</p>"
					
				+"<h5>" 
				+"Use-case examples"
				+"</h5>"
				+"<p>" 
				 +"Use case examples are helpful in 'walking through' a typical scenario of a person using the application."
				 +" Imagine yourself as the customer using the Build Your Own Burger Application and how it'll be used from start to finish."
				 +" Step one: first make an account. Step two: Sign in with the account credentials. Step three: What does the customer page look like?"
				 +" Step four: How do they order their burger? What information does the Build Your Own Burger App have to process along the way? What feedback will the app"
				 +" give the customer throughout the process? Finally how does the process end?"
				 +"</p>"
				
				+"<h5>" 
				+"Use-case Diagrams"
				+"</h5>"
				+"<p>" 
				 +"Using the use-case example from above, can you imagine a diagram of a customer interacting with the Build Your Own Burger application?"
				 +" Normally, depending on the size and purpose of the application, anywhere from three to a dozen use case scenarios and diagrams can be drawn."
				 +"</p>"
				
				+"<h5>" 
				+"List of Milestones"
				+"</h5>"
				+"<p>" 
				 +"Milestones throughout the design process are important. Many times, developing these applications can take months or years "
				 +" to development. The milestones are a rough estimate of where along the timeline things need to happen to further the"
				 + " project along."
				 +"</p>"
				
				+"<h5>" 
				+"Testing and Deployment"
				+"</h5>"
				+"<p>" 
				 +" The last phase of software development is testing and finally deployment. There will always be errors and bugs"
				 + " in your code that will need to be ironed out before deploying- leave plenty of time for this step!"
				 +"</p>";
		
		List<String> challenges = new LinkedList<>();
		
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, links);
		return "b-topics2";
	}
}