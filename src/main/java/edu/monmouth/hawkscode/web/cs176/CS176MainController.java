package edu.monmouth.hawkscode.web.cs176;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CS176MainController {
	
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
	
	public void populateTopics(ModelMap model, String header, String description, String path,
			List<String> challenges) {
		model.put("path", path);
		model.put("header", header);
		model.put("description", description);
		model.put("challenges", challenges);
	}
	
	// **********************************************
	// ********* OBJECT ORIENTED PROGRAMMING ********
	// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming") 
	public String objectOrientedProgramming(ModelMap model) {
		String header = "Object Oriented Programming";
		String description = "<p>Object Oriented Programming uses the concepts of \"objects\" that contain data in the form of fields, and code, in the form of functions. The object's functions are used to access and modify the data fields of the object.</p>"; 
		String path = "/home/cs176/Object Oriented Programming";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Access Modifiers");
		challenges.add("Static");
		challenges.add("Overloading");
		challenges.add("Inheritance");
		challenges.add("Nested Classes");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
		// **********************************************
		// ************* ACCESS MODIFIERS ***************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers")
	public String accessModifiers(ModelMap model) {
		String header = "Object Oriented Programming - Access Modifiers";
		String description = "<p>Access Modifiers are an essential part of object oriented programming in Java that we see everywhere in Java code. They allow us to restrict the scope of our classes, constructors, variables, methods, and instance variables.</p>";
		String path = "/home/cs176/Object Oriented Programming/Access Modifiers";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Private");
		challenges.add("Public");
		challenges.add("Protected");
		challenges.add("Default");
		challenges.add("Projects");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects")
	public String accessModifiersProjects(ModelMap model) {
		String header = "Object Oriented Programming - Access Modifiers Projects";
		String description = "<p>We will be creating a \"Shop Program\" that simulates the transactions of item purchases at a real store. You have already worked on one of the classes needed to complete this program: the CashRegister class. There is also an Item class which you will be working on for the next few challenges.</p>"+
							"<p>Before diving into coding this program, we will be planning out our program using a simple UML diagram. It might seem impractical to manage your code as you go through your courses because the projects are not that large. But project planning will prove to be an invaluable skill throughout your developer career.</p>"+
							"<p>Before clicking on \"Shop UML Diagram\", we suggest you take 5-10 minutes to first decide what classes, fields, methods, etc. you think the Shop Program needs to be a complete program.</p>";
		String path = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Shop UML Diagram");
		challenges.add("Shop Part 1");
		challenges.add("Shop Part 2");
		challenges.add("Shop Part 3");

		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop UML Diagram")
	public String accessModifiersProjectsShopUML(ModelMap model) {
		String header = "Shop UML Diagram";
		String description = 
				"<p>This diagram will serve as the guide for our final program. Also, using what we know now, this program isn't very useful. Currently, customers can only purchase one type of item at a time. Towards the end of this project, we will use arrays to store different types of objects to make this program more realistic.</p>"+
				"<pre>" +
				"-------------------------------\n"+
				"|            Item             |\n"+
				"|-----------------------------|\n"+
				"|-description:String          |\n"+
				"|-itemNumber:int              |\n"+
				"|-cost:double                 |\n"+
				"|-----------------------------|\n"+
				"|+setCost(cost: double):void  |\n"+
				"|+getCost():double            |\n"+
				"|+Item(description:String,    |\n"+
				"|itemNumber:int, cost:double) |\n"+
				"-------------------------------\n\n"+
				"---------------------------\n"+
				"|       CashRegister      |\n"+
				"|-------------------------|\n"+
				"|-item: Item              |\n"+
				"|-TAX_RATE: double        |\n"+
				"|-quantity: int           |\n"+
				"|-subTotal: double        |\n"+
				"|-------------------------|\n"+
				"|+getSubtotal():double    |\n"+
				"|+getTax():double         |\n"+
				"|+getTotal():double       |\n"+
				"|+CashRegister(item:Item, |\n"+
				"|quantity:int)            |\n"+
				"---------------------------\n"+
				"</pre>";
		
		String path = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop UML Diagram";

		List<String> challenges = new LinkedList<>();

		populateTopics(model, header, description, path, challenges);
		return "b-topics";
	}
		// **********************************************
		// ***************** STATIC *********************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Static")
	public String staticKeyword(ModelMap model) {
		String header = "Object Oriented Programming - Static";
		String description = "<p>The static keyword is used in Java to make variables and methods belong to a class rather than an instance of a class. Doing so can make our programs more memory efficient.</p>"; 
		String path = "/home/cs176/Object Oriented Programming/Static";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Static Variables");
		challenges.add("Static Methods");
		challenges.add("Static Blocks");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
		// **********************************************
		// *************** OVERLOADING ******************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Overloading")
	public String overloading(ModelMap model) {
		String header = "Object Oriented Programming - Overloading";
		String description = "<p>Overloading is a technique we use in Java to make several methods or constructors with the same name but with different parameters.</p>";
		String path = "/home/cs176/Object Oriented Programming/Overloading";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Overloading Methods");
		challenges.add("Overloading Constructors");
		challenges.add("Using This");
		challenges.add("This With Methods");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
		// **********************************************
		// *************** INHERITANCE ******************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Inheritance")
	public String inheritance(ModelMap model) {
		String header = "Object Oriented Programming - Inheritance";
		String description = "<p>Inheritance is one of the most important concepts in Object Oriented Programming. It's what allows us to reuse code and override methods so that runtime polymorphism can be achieved.</p>";
		String path = "/home/cs176/Object Oriented Programming/Inheritance";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Extends");
		challenges.add("Overriding");
		challenges.add("Super");
		challenges.add("Polymorphism");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	

	
	
	// **********************************************
	// ****************** ARRAYS ********************
	// **********************************************
	@GetMapping(value = "/home/cs176/Arrays")
	public String arrays(ModelMap model) {
		String header = "Arrays";
		String description = "<p>Data structures are what enable you to create more powerful applications. Data structures are organized collections of data. The most basic data structure that is built into every programming language is the array. In this section, you will learn all about arrays in Java.</p>";
		String path = "/home/cs176/Arrays";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Instantiating Arrays");
		challenges.add("Getting Array Values");
		challenges.add("Setting Array Values");
		challenges.add("Array Literals");
		challenges.add("Array Bounds And Length");
		challenges.add("Multidimensional Arrays");
		challenges.add("Projects");
		challenges.add("Array Lists");
//		challenges.add("arraysFromFiles");
//		challenges.add("quizzes");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	@GetMapping(value = "/home/cs176/Arrays/Projects")
	public String arraysProjects(ModelMap model) {
		String header = "Arrays - Projects";
		String description = "";
		String path = "/home/cs176/Arrays/Projects";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Updated UML Diagram");
		challenges.add("Shop Part 4");
		challenges.add("Shop Part 5");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs176/Arrays/Projects/Updated UML Diagram")
	public String arraysProjectsUpdatedUML(ModelMap model) {
		String header = "Shop Program Updated UML Diagram";
		String description = "<p>It has been a while, so here is the UML diagram to remind you the layout of our Shop program. Also, we moved quantity from CashRegister to Item, which makes sense since CashRegister will now be working with arrays of Item objects. The getQuantity method has also been added to the Item class.</p>"+
						"<pre>" +
						"-------------------------------\n"+
						"|            Item             |\n"+
						"|-----------------------------|\n"+
						"|-description:String          |\n"+
						"|-itemNumber:int              |\n"+
						"|-cost:double                 |\n"+
						"|-quantity: int               |\n"+
						"|-----------------------------|\n"+
						"|+setCost(cost: double):void  |\n"+
						"|+getCost():double            |\n"+
						"|+getQuantity():int           |\n"+
						"|+Item(description:String,    |\n"+
						"|itemNumber:int, cost:double, |\n"+
						"|quantity:int)                |\n"+
						"-------------------------------\n\n"+
						"------------------------------\n"+
						"|         CashRegister       |\n"+
						"|----------------------------|\n"+
						"|-items: Item[]              |\n"+
						"|-TAX_RATE: double           |\n"+
						"|-subTotal: double           |\n"+
						"|----------------------------|\n"+
						"|+getSubtotal():double       |\n"+
						"|+getTax():double            |\n"+
						"|+getTotal():double          |\n"+
						"|+CashRegister()             |\n"+
						"|+CashRegister(items:Item[]) |\n"+
						"------------------------------\n"+
						"</pre>";
		
		String path = "/home/cs176/Arrays/Projects/Updated UML Diagram";
		
		List<String> challenges = new LinkedList<>();
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	/*
	@GetMapping(value = "/home/cs176/arrays/quizzes")
	public String arrayQuizzes(ModelMap model) {
		String header = "Array - Quizzes";
		String description = "<p>It's time to put what you've learned into practice! Don't feel bad if you're not able to pass some of these the first time. Remember: failure is a part of learning. If you need to repeat some of the earlier challenges, please feel free to do so.";
		String path = "/home/cs176/arrays/quizzes";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("arraysQuiz");
		challenges.add("arrayListsQuiz");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	*/
		// **********************************************
		// **************** ARRAY LISTS *****************
		// **********************************************
	@GetMapping(value = "/home/cs176/Arrays/Array Lists")
	public String arrayLists(ModelMap model) {
		String header = "Arrays - Array Lists";
		String description = "<p>After doing the last several challenges, we see that arrays are a powerful and simple way of working with collections of data in Java. However, the drawback of using arrays is that we can't increase the size of our arrays as our program is running.</p>"+
						"<p>Luckily for us, the developers who work on Java have provided us with a class called ArrayList that allow us to create dynamic arrays.</p>"+
						"<p>If you recall, we can get other people's code by using \"import\" statements\":</p>"+
						"<pre>import java.util.ArrayList; // The ArrayList class</pre>"+
						"<p>An ArrayList is basically a resizable array. Start with the first challenge below and work your way through the other challenges to learn more about ArrayLists.</p>";
		String path = "/home/cs176/Arrays/Array Lists";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Creating Array Lists");
		challenges.add("Adding Items");
		challenges.add("Getting Items");
		challenges.add("Changing Items");
		challenges.add("Removing Items");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	

	
	// **********************************************
	// ******* ADVANCED LOOPING CHALLENGES **********
	// **********************************************
	@GetMapping(value = "/home/cs176/Advanced Looping")
	public String advancedLooping(ModelMap model) {
		String header = "Advanced Looping";
		String description = "<p>In this section, you will learn how to loop through arrays to perform certain tasks.</p>";
		String path = "/home/cs176/Advanced Looping";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("For Loop Array");
		challenges.add("While Loop Array");
		challenges.add("Max In Array");
		challenges.add("Average Of Array");
		challenges.add("Enhanced For Loop");
		challenges.add("Projects");
//		challenges.add("quizzes");

		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Projects")
	public String advancedLoopingProjects(ModelMap model) {
		String header = "Advanced Looping - Projects";
		String description = "";
		String path = "/home/cs176/Advanced Looping/Projects";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Shop UML Diagram");
		challenges.add("Shop Part 6");
		challenges.add("Shop Part 7");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/Shop UML Diagram")
	public String advancedLoopingProjectsUML(ModelMap model) {
		String header = "Shop UML Diagram";
		String description = "<p>Here is just a reminder on what the Shop Program looks like.</p>"+
				"<pre>" +
				"-------------------------------\n"+
				"|            Item             |\n"+
				"|-----------------------------|\n"+
				"|-description:String          |\n"+
				"|-itemNumber:int              |\n"+
				"|-cost:double                 |\n"+
				"|-quantity: int               |\n"+
				"|-----------------------------|\n"+
				"|+setCost(cost: double):void  |\n"+
				"|+getCost():double            |\n"+
				"|+getQuantity():int           |\n"+
				"|+Item(description:String,    |\n"+
				"|itemNumber:int, cost:double, |\n"+
				"|quantity:int)                |\n"+
				"-------------------------------\n\n"+
				"------------------------------\n"+
				"|         CashRegister       |\n"+
				"|----------------------------|\n"+
				"|-items: Item[]              |\n"+
				"|-TAX_RATE: double           |\n"+
				"|-subTotal: double           |\n"+
				"|----------------------------|\n"+
				"|+getSubtotal():double       |\n"+
				"|+getTax():double            |\n"+
				"|+getTotal():double          |\n"+
				"|+CashRegister()             |\n"+
				"|+CashRegister(items:Item[]) |\n"+
				"------------------------------\n"+
				"</pre>";
		String path = "/home/cs176/Advanced Looping/Projects/Shop UML Diagram";
		
		List<String> challenges = new LinkedList<>();
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	
	/*
	@GetMapping(value = "/home/cs176/advancedLooping/quizzes")
	public String advancedLoopingQuizzes(ModelMap model) {
		String header = "Advanced Looping - Quizzes";
		String description = "";
		String path = "/home/cs176/advancedLooping/quizzes";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("conditionalLogic");
		challenges.add("userInput");
//		conditionalLogic - Create an array out of another array using conditional logic
//		userInput - Arrays with user input (While Loop)
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	*/
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	
	
	// **********************************************
	// ************* EXCEPTION HANDLING *************
	// **********************************************
	@GetMapping(value = "/home/cs176/Exception Handling")
	public String exceptionHandling(ModelMap model) {
		String header = "Exception Handling";
		String description = "<p>In Java, all exceptions are represented by classes. When an exception occurs in Java, an object of some type of exception class is generated. Throwable is the superclass of all errors and exceptions in the Java language. Throwable has two subclasses: Error and Exception. We'll mainly be concering ourselves with the Exception class and how we can handle it.</p>";
		String path = "/home/cs176/Exception Handling";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Try And Catch");
		challenges.add("Custom Exceptions");
		challenges.add("Throw");
		challenges.add("Throws");
		challenges.add("Finally");
		
		populateTopics(model, header, description, path, challenges);

		return "b-topics";
	}
	// **********************************************
	// **********************************************
	// **********************************************
}
