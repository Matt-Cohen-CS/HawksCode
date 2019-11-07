package edu.monmouth.hawkscode.web.cs205;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import edu.monmouth.hawkscode.domain.WebCompiler;
import edu.monmouth.hawkscode.web.MainController;

@Controller
public class CS205GetController 
{
	@Autowired
	private MainController mc;
	
	private Map<String, String> ch = new LinkedHashMap<String, String>();
	
	private String populateChallenge(ModelMap model, String header, String description) 
	{
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		return "b-challenge";
	}
	
	private String populateChallenge(ModelMap model, String header, String description, boolean isChallengeCompleted) {
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		model.put("isChallengeCompleted", isChallengeCompleted);
		return "b-challenge";
	}
	private String populateChallenge(ModelMap model, String header, String description, String boilerplate, boolean isChallengeCompleted) {
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		model.put("boilerplate", boilerplate);
		model.put("isChallengeCompleted", isChallengeCompleted);
		return "b-challenge";
	}
		
	/*
	   String header = ""; 
	   String description = "";
	   return populateChallenge(model, header, description);
	 */

	// *********************************************
	// ************************************ CLASS II
	// *********************************************
	@GetMapping(value = "/home/cs205/Class II/Interface")
	public String classInterface(ModelMap model)
	{
		   String header = "Implement an Interface Challenge"; 
		   String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>One important characteristic of Java is its inability to have multiple inheritance. "
					+ "What this means is one class inheriting multiple classes. "
					+ "A great way around this is interfaces, every class has the ability to implement multiple interfaces. "
					+ "What exactly is an interface though? An interface is a perfect blueprint of what a class should do. "
					+ "All methods in an interface must be abstract, public, and final. "
					+ "Moreover, all methods in an interface are undefined because their purpose is to be defined by the "
					+ "classes that implement the interface. Many crucial Java classes implement many interfaces, "
					+ "the most common being is List which all Java collections framework implement. Interfaces are a great technique"
					+ " to control multiple classes where each class must posses the same characteristics.</p>"	
					+"<p>EXAMPLE:</p>"		
					+"<pre>public class MyClass implements List{\n" + 
					"			//Define all abstract methods in List\n" + 
					"}\n</pre>"	
					+"</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>In this challenge, implement the interface CodingIsFun, this class has two methods, one is \n" + 
					"<pre>int stressLevel(int a);\n another is\n String howManyLines(int myLines);</pre>\n" + 
					"Name your class MyCode and "
					+ "implement the method stressLevel by ensuring any number passed in will be multiplied by three and then returned. In the howManyLines method"
					+ " concatenate a phrase that describes how many lines are in the code.</p>"
					+ "</div>";
			String boilerplate ="class MyCode implements CodingIsFun {\n"
					 + "}";
			return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Interface", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Class II/Abstract")
	public String classAbstract(ModelMap model)
	{
		   String header = "Abstract Class Challenge"; 
		   String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>Abstract classes in Java are bases for other classes to inherit and define. "
					+ "An abstract class cannot be instantiated and every method that is abstract cannot be defined. "
					+ "To declare an abstract class you must use the keyword abstract. "
					+ "Moreover, to declare an abstract method you must write the method template out and use a semi "
					+ "colon instead of a body.</p>"	
					+"<p>EXAMPLE:</p>"		
					+"<pre>public abstract class Hello{\n" + 
					"\n" + 
					"		public abstract void sayHello();\n" + 
					"}\n" + 
					"</pre>"
					+ "<p>When you think of abstract classes there are common characteristics. For one, abstract classes cannot be insantiated, two, "
					+ "abstract classes can have implemented and unimplemented methods, three, any class with one or more abstract/unimplemented methods must"
					+ "be declared as abstract. Inheriting an abstract class is through the keyword extends just like regular inheritance; however, all un"
					+ "implemented methods must be defined by the subclass. So when should you use an"
					+ " abstract class? Abstract classes are perfect for project based coding. For example, imagine you are working with a team where you want"
					+ " to create a Java application to control the heating in buildings. If every team member were to focus on a different"
					+ " type of building there is the potential for every class to have different terminology or different characteristics for any"
					+ " specified building. Abstract classes allow for common methods and a general blueprint of what every building show have."
					+ " In the abstract class you can have an unimplemented method called walls, and an unimplemented called temperatureGauge. When another class extends"
					+ " the abstract class it must implement both walls and temperatureGauge methods.</p>"	
					+"</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>In your challenge, extend an abstract class called HotDogs that has two abstract methods: \n" + 
					"<pre>public abstract ArrayList<String> condiments();\n" + 
					"	  public abstract int numberOfDogs(ArrayList<Integer> a);</pre>\n" + 
					"Make your class name MyDogs and in the condiments method return an ArrayList of Strings that has a list of condiments. "
					+ "Moreover, in the numberOfDogs method take the parameter and add "
					+ "5 to each element in the List and then return the final number of all elements added together. \n" + 
					"</p>"
					+ "</div>";
		   String boilerplate = "class MyDogs extends HotDogs{"
			   		+ "\n"
			   		+ "//Insert Code BELOW\n"
			   		+ "}";
			return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Abstract", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Class II/Enum")
	public String classEnum(ModelMap model)
	{
		   String header = "ENUMERATORS!!!"; 
		   String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>Enums or enumerators are for representing a group of constants. "
					+ "Every enum constant by default is public, static and final. "
					+ "An enum \"class\" is when you use the keyword enum.</p>"	
					+"<p>EXAMPLE:</p>"		
					+"<pre>"
					+ "enum Emotions {\n" + 
					"HAPPY, GLAD, SAD;\n" + 
					"\n"
					+ "public static Emotions getEmotions(Emotions d){"
					+ "\nreturn d;"
					+ "}\n}"
					+ 
					"</pre>"	
					+"</div>"
					+"<p>The enum Emotions has 3 constants, HAPPY, SAD AND GLAD. To invoke these constants you must create an enum object and call the constant. \n" + 
					"Emotions myDailyEmotion = Emotions.HAPPY;\n" + 
					"Another cool ability of enum is its ability to create methods as well. Meaning, within your enum \"class\" you can create methods using your enum constants.\n" + 
					"</p>"
					+"<div><h4>Challenge:</h4>"
					+"<p>For your challenge, create an enum \"class\" called Directions that has the constants of the "
					+ "four cardinal directions (North, South, East and West). "
					+ "Next, create a method inside the enum class called checkDirections that accepts your enum Object and returns the "
					+ "String representation of the opposite direction, ensure the method is static; for example, if given NORTH return SOUTH.toString(). "
					+ "How you will check for the enum Object is up to you, but the best way would be a switch/case because "
					+ "you have four defined constants; however, the implementation is on you.  </p>"
					+ "</div>";
			return populateChallenge(model, header, description, mc.isChallengeCompleted("Enum", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Class II/Generic")
	public String classGeneric(ModelMap model)
	{
		   String header = "Not so Generic Challenge!"; 
		   String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>Generics were introduced in Java to ensure compile time safety. When you write \n" + 
					"<pre>List myList = new ArrayList();\n" + 
					"myList.add(5);\n" + 
					"myList.add(\"Hello World\");\n</pre>" + 
					"The ArrayList is allowing both a String and an Integer Object. "
					+ "The myList instantiation above is actually short for \n" + 
					"<pre>List<Object> myList = new ArrayList<Object>(); \n</pre>" + 
					"This is because the way the List interface was created is with the ability to accept <E>. "
					+ "E is short for element but has a deeper meaning of Generics.\n"
					+ "Generics allow for the ability to accept any parameterized type. "
					+ "In better terms you can pass an Object of various types. But how does Java know 5, and â€œHello Worldâ€� "
					+ "are Objects? This can be explained by auto-boxing. String, however, is an Object so this conversion "
					+ "does not happen, but the integer 5 is not and must be converted to its wrapper class. "
					+ "In essence Objects of many types can be accepted through generics, but what if we could explicitly "
					+ "state what type parameter our list can take. Our ArrayList can be a huge problem when trying to "
					+ "use the data and will require typecasting if the data is to be further manipulated. "
					+ "This can easily be achieved by expressing a type in the argument. For example,\n" + 
					"<pre>List<Integer> myList = new ArrayList<Integer>(); \n" + 
					"myList.add(\"Hello\") // compile error (red squiggly lines in Eclipse)\n</pre>" + 
					"In this declaration youâ€™re telling Java you are only allowing the Object type of Integer to be inserted "
					+ "in your List and this ensures compile time safety. "
					+ "\nUnderstanding generics is immensely important because it allows code reuse by making code more "
					+"\"generic\". Moreover, it eliminates the need for typecasting and ensures stronger checks on "
					+ "types at compile time.\n" 
					+ "</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>For your challenge, declare an ArrayList called myList that only allows Strings as an input. Next, create an ArrayList called myList2 that only accepts Objects. \n" + 
					"For best coding practice always \"code to the interface\" meaning, \n" + 
					"<pre>List<> abc = new ArrayList<>();\n" + 
					"List being the interface of ArrayList. \n</pre>" + 
					"</p>"
					+ "</div>";
			return populateChallenge(model, header, description, mc.isChallengeCompleted("Generic", "cs205"));
	}
	
	// *********************************************
	// ************************** BINARY SEARCH TREE
	// *********************************************
	@GetMapping(value = "/home/cs205/Binary Search Tree/Binary Tree Constructor")
	public String binaryTreeCreation(ModelMap model)
	{
		 String header = "Binary Construct Challenge"; 
		 String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>In Java there are two implementations of a Binary Search Tree within the Collections interface. They\n" + 
					" are TreeSet and TreeMap. They each function like a red-black tree and each have their own uses. In these\n" + 
					" challenges you will focus on TreeSet. The TreeSet constructor is as follows<pre>\n" + 
					" TreeSet<> myTreeSet = new TreeSet<>();</pre>\n" + 
					" One cool feature of the TreeSet constructor is its ability to accept a data structure from the Collections\"\n" + 
					" interface; for example, if you have a LinkedList of Strings called myList you can create a TreeSet using the TreeSet contructor\"\n" + 
					"</p><pre>TreeSet<String> myTreeSet = new TreeSet<String>(myList);</pre>"	
					+"<div><h4>Challenge:</h4>"
					+"<p>In your challenge, create two TreeSets one that accepts only Integer values and another that accepts only"
					+ " String values name them myIntSet and myStrSet respectively. "
					+ "Lastly, put the ArrayList listForSet in the TreeSet myStrSet.</p>"
					+ "</div>";
		   String boilerplate = "List<String> listForSet = new ArrayList<String>();\n"
		   		+ "listForSet.add(\"first\");\n"
		   		+ "listForSet.add(\"second\");\n"
		   		+ "\\Insert Constructors BELOW\n";
			return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("BinaryTreeConstructor", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Binary Search Tree/Binary Search")
	public String binarySearch(ModelMap model)
	{
		 String header = "Binary Search Challenge"; 
		 String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>Searching for a particular value in a TreeSet is fairly simple. The TreeSet class has a method called contains(Object obj)"
					+ " this method will return true if a particular type is present in the set. Moreover, you can use "
					+ " an enhanced for loop that will parse through each element in the set, which you can exploit to search for a "
					+ " particular element. For some additional help the constructor will be below to assist you. "
					+ " The TreeSet constructor is as follows<pre> \n"
					+ "	TreeSet<> myTreeSet = new TreeSet<>();</pre>\n"
					+ " One cool feature of the TreeSet constructor is its ability to accept a data structure from the Collections"
					+ " interface; for example, if you have a LinkedList of Strings called myList you can create a TreeSet with each element in the List"
					+ " <pre>TreeSet<String> myTreeSet = new TreeSet<String>(myList);</pre></p>"	
					+"<p>EXAMPLE:</p>"		
					+"<pre>"
					+"</pre>"	
					+"</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>In your challenge, create a TreeSet call myTreeSet that has 10 String elements in it and at least one element assigned to"
					+ " \"Hello\". Next, create a String called myStr and assign the value \"\". Next, create an Iterator called myIt that is assigned to myTreeSet.iterator(). Finally, search for the element"
					+ " Hello by using an enhanced for loop and assign myStr to the element if it is Hello."
					+ "</p>"
					+ "</div>";
		 String boilerplate = "//Create the TreeSet BELOW"
			   		+ "\n//Create the String and Iterator BELOW"
			   		+ "\n"
			   		+ "while(myIt.hasNext()){\n"
			   		+ "		System.out.println(myIt.next());\n"
			   		+ "}\n"
			   		+ "for(String element : myTreeSet){"
			   		+ "\n		//TO DO"
			   		+ "\n}";
			return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("BinarySearch", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Binary Search Tree/Binary Insertion")
	public String binaryInsertion(ModelMap model)
	{
		
		   String header = "Binary Insertion Challenge"; 
		   String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>In Java there are two implementations of a Binary Search Tree within the Collections interface. They"
					+ " are TreeSet and TreeMap. They each function like a red-black tree and each have their own uses. In these"
					+ " challenges you will focus on TreeSet. The TreeSet constructor is as follows<pre> \n"
					+ "	TreeSet<> myTreeSet = new TreeSet<>();</pre>\n"
					+ " One cool feature of the TreeSet constructor is its ability to accept a data structure from the Collections"
					+ " interface; for example, if you have a LinkedList of Strings called myList you can create a TreeSet using the TreeSet contructor"
					+ " <pre>TreeSet<String> myTreeSet = new TreeSet<String>(myList);</p>"	
					+"<p>EXAMPLE:</p>"		
					+"<pre>"
					+"</pre>"	
					+"</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>In your challenge, create a Integer TreeSet called myTree and use the add method to add 5 elements to it. "
					+ " Ensure the number 5 is one of those elements."
					+ "</p>"
					+ "</div>";
		   String boilerplate = "TreeSet<Integer>...//TO DO";
		   return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("BinaryInsertion", "cs205"));
	}

	// *********************************************
	// ********************************* LINKED LIST
	// *********************************************
	@GetMapping(value = "/home/cs205/Linked List/Singly Linked List/Singly Linked List V1")
	public String singlyLinkedListV1(ModelMap model)
	{
		String header = "Singly Linked List Version 1";
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Using the instantiated Linked List and the precreated Node reference, create a Singly Linked List.<br> \r\n" + 
				"			Declare three <b>Node</b> references; <br><i>head</i>, <i>second</i> and <i>third</i>. \r\n" + 
				"			\r\n" + 
				"			<br>Set the data value of <i>head</i> to 11.\r\n" + 
				"			<br>Set the data value of <i>second</i> to 12. \r\n" + 
				"			<br>Set the data value of <i>third</i> to 13. \r\n" + 
				"			\r\n" + 
				"			<br>Link the three <b>Node</b> references to one another; head to second, second to third.\r\n" + 
				"			\r\n" + 
				"			HINT: <i>if you need help refer to the Linked List explanation</i>\r\n" + 
				"		</div>";
		
		String boilerplate = "public class SinglyLinkedListV1 \r\n" + 
				"{\r\n" + 
				"	Node head; \r\n" + 
				"	\r\n" + 
				"	static class Node\r\n" + 
				"	{\r\n" + 
				"		int data; \r\n" + 
				"		Node next; \r\n" + 
				"		Node (int d) \r\n" + 
				"		{\r\n" + 
				"			data = d; next = null; \r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"		\r\n" + 
				"	public static void main(String [] args)\r\n" + 
				"	{	\r\n" + 
				"		SinglyLinkedListV1 mylist = new SinglyLinkedListV1();\r\n" + 
				"				\r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"		// WRITE CODE HERE \r\n" + 
				"		 \r\n" + 
				"		// *******************************************\r\n" + 
				"	}\r\n" + 
				"}"; 
		
		mc.addChallenge("SinglyLinkedListV1", "cs205", 3);
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("SinglyLinkedListV1", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Linked List/Singly Linked List/Singly Linked List V2")
	public String singlyLinkedListV2(ModelMap model)
	{
		String header = "Singly Linked List Version 2";
		String description = "";
	
		String boilerplate = "public class SinglyLinkedListV2 \r\n" + 
				"{\r\n" + 
				"	public static void main(String[] args) \r\n" + 
				"	{\r\n" + 
				"		LinkedList<String> list = new LinkedList<String>(); \r\n" + 
				"			\r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"		// WRITE CODE HERE \r\n" + 
				"		 \r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"		SinglyLinkedListV2.printListForward(list); \r\n" + 
				"	}\r\n" + 
				"}"; 
		
		mc.addChallenge("SinglyLinkedListV2", "cs205", 3);
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("SinglyLinkedListV2", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Linked List/Doubly Linked List/Doubly Linked List V1")
	public String doublyLinkedListV1(ModelMap model)
	{
		String header = "Doubly Linked List Version 1";
		String description = "<div>\r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Using the instantiated Linked List and the precreated Node reference, create a Doubly Linked List. <br> \r\n" + 
				"			Declare three <b>Node</b> references; <br><i>head</i>, <i>second</i> and <i>third</i>. \r\n" + 
				"			\r\n" + 
				"			<br>Set the data value of <i>head</i> to 11.\r\n" + 
				"			<br>Set the data value of <i>second</i> to 12. \r\n" + 
				"			<br>Set the data value of <i>third</i> to 13. \r\n" + 
				"			\r\n" + 
				"			<br>Link the three <b>Node</b> references to one another; head next to second, second next to third, new Node previous to head, head previous to second, second preious to third. \r\n" + 
				"			\r\n" + 
				"			HINT: <i>if you need help refer to the Linked List explanation</i>\r\n" + 
				"		</div>";

		String boilerplate = "public class DoublyLinkedListV1 \r\n" + 
				"{\r\n" + 
				"	Node head; \r\n" + 
				"	\r\n" + 
				"	static class Node\r\n" + 
				"	{\r\n" + 
				"		int data; \r\n" + 
				"		Node next; \r\n" + 
				"		Node prev; \r\n" + 
				"		Node (int d) \r\n" + 
				"		{\r\n" + 
				"			data = d; next = null; prev = null; \r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	public static void main(String [] args)\r\n" + 
				"	{	\r\n" + 
				"		DoublyLinkedListV1 mylist = new DoublyLinkedListV1();\r\n" + 
				"			\r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"		// WRITE CODE HERE \r\n" + 
				"		 \r\n" + 
				"		// *******************************************\r\n" + 
				"				\r\n" + 
				"	}\r\n" + 
				"}"; 
		
		mc.addChallenge("DoublyLinkedListV1", "cs205", 3);
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("DoublyLinkedListV1", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Linked List/Doubly Linked List/Doubly Linked List V2")
	public String doublyLinkedListV2(ModelMap model)
	{
		String header = "Doubly Linked List Version 2";
		String description=""; 
		
		String boilerplate = "public class DoublyLinkedListV2 \r\n" + 
				"{\r\n" + 
				"	public static void main(String[] args) \r\n" + 
				"	{\r\n" + 
				"		LinkedList<String> list = new LinkedList<String>(); \r\n" + 
				"		\r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"		// WRITE CODE HERE \r\n" + 
				"		 \r\n" + 
				"		// *******************************************\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"}";
		
		mc.addChallenge("DoublyLinkedListV2", "cs205", 3);
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("DoublyLinkedListV2", "cs205"));
	}
	
	// *********************************************
	// ***************************************** MAP
	// *********************************************
	@GetMapping(value = "/home/cs205/Map/Linked HashMap Data Structure")
	public String linkedHashMap(ModelMap model)
	{
		String header = "LinkedHashMap Challenge";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"<h4>Description:</h4>"	
				+"<p>A LinkedHashMap is a HashMap where all of the entries maintain a doubly-linkedList. One key benefit of"
				+ " a LinkedHashMap over a regular HashMap is the ordering. Linked Hash Maps by default maintain an insertion order, meaning"
				+ " the Maps order is dependent on when the entries were inserted. Moreover, another cool feature is the ability to change"
				+ " the ordering to accessOrder. This order will order the Map by when the entries were last accessed which is very crucial"
				+ " and some applications like caches. A LinkedHashMap still has buckets and still hashes every Key, this Map extends HashMap,"
				+ " so every method provided in HashMap is able to be used in LinkedHashMap. The main takeaway is the ordering of the Map,"
				+ " the ability to change the ordering, and the LinkedList maintained in every entry.</p>"	
				+"<p>EXAMPLE:</p>"		
				+"<pre>"
				+ "LinkedHashMap &lt;Key, Value&gt; myLHM = new LinkedHashMap &lt;Key, Value&gt;();"
				+ "\nmyLHM.put(key,value);"
				+ "\nmyLHM.remove(key); // removes the Mapping of the Key"
				+"</pre>"	
				+"</div>"	   				
				+"<div><h4>Challenge:</h4>"
				+"<p>In your challenge, construct a LinkedHashMap called myLHM that has the Key type of String, and value type of Integer."
				+ " Next, put the key of \"dog\" with the value of 25 and the key of \"cat\" with that value of 0. Finally, create a String"
				+ " called myGuess that is assigned to the first Key of the Map.</p>"
				+ "</div>";
		return populateChallenge(model, header, description, mc.isChallengeCompleted("LinkedHashMapDataStructure", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Map/TreeMap Data Structure")
	public String treeMap(ModelMap model)
	{
		String header = "TreeMap challenge";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"<h4>Description:</h4>"	
				+"<p>TreeMaps are an abstract data type that uses the natural ordering of its keys to sort the Map. The constructor we will focus on is "
				+ "TreeMap &lt;Key, Value&gt; myFirstTree = new TreeMap &lt;Key,Value&gt;();. The Map below illustrates the construction of a TreeMap"
				+ " and how the tree uses the natural ordering of its Keys to sort itself.</p>"	
				+"<p>EXAMPLE:</p>"		
				+"<pre> TreeMap &lt;Integer, Object&gt; myTree = new TreeMap &lt;Integer, Object&gt;()\n"
				+ "		myTree.put(3,null);\n"
				+ "		myTree.put(4,null);\n"
				+ "		myTree.put(2,null);\n"
				+ "Internal of TreeMap:  [root: 3,null]\n"
				+ "		    	||	||\n"
				+ "	  	    [2,null]  [4,null]"
						
				+"</pre>"
				+ "<p>The TreeMap works exactly like a tree, but stores both Keys and values. From the ordering above you can see greater Keys"
				+ "	will be mapped to the right of the root, and lesser Keys to the left. This may seem to be fairly obvious, but the TreeMap"
				+ " is using the compareTo() method to compare each Key and derive the position of the Key from the root."
				+ " Luckily, the natural ordering of Integers is already defined and easily understandable, but if you were to Map the Key of an Object"
				+ "	you created, the compareTo() method deriving from the Comparable interface, must be implemented using your implementation for accurate"
				+ " ordering.</p>"	
				+"</div>"	   				
				+"<div><h4>Challenge:</h4>"
				+"<p>In your challenge, create a TreeMap called myTree, that uses an Integer for both Key and Value. Next, using the"
				+ " put() method and a loop create a key-Value for 50 keys where the first key is 1, the second key is 2 and so on until"
				+ " the last key is 50. Next, ensure the last key(50) has the value of 100. Finally, create an ArrayList called myList"
				+ " and assign every value from TreeMap into the list, HINT: there is an easy way to do this by using the values() method"
				+ " in TreeMap.</p>"
				+ "</div>";
		return populateChallenge(model, header, description, mc.isChallengeCompleted("TreeMapDataStructure", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Map/HashMap Data Structure")
	public String hashMap(ModelMap model)
	{
		String header = "HashMap Challenge";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"<h4>Description:</h4>"	
				+"<p>HashMaps are a great abstract data structure to use for Key-Value representation. There are a few different ways of "
				+ " constructing a HashMap, but in these challenges you will focus on the HashMap&lt;Key,Value&gt; mapName = new HashMap&lt;Key,Value&gt;(); constructor."
				+ " \nHashMaps work by the principle"
				+ " of Hashing. The Key is used to determine what the hash will be. Hashing is deriving an integer form from a given Object. Hashes are fixed in size and must be repeatable"
				+ " meaning if we pass a key of \"Hello\" it should return the same Hash value every time. Once a Hash value is created"
				+ " the hash and value is then stored in a bucket. The bucket (sometimes refered to as bins) is an index of the internal table which is an Array."
				+ " What bin is picked by the HashMap is not neccesary to know, but it is crucial to understand that the hash determines what bin is picked. Moreover,"
				+ " two unique hashes can share the same bin and this is why a LinkedList or BinarySearchTree is used inside the bucket to store the elements."
				+ " Which data structure is used depends on a certain threshold, starting with a LinkedList and depending on the size of the List it will convert the List to a BinarySearchTree."
				+ " Take this example, lets say you just have n elements inside your HashMap. Every elements' hash has the chance to be stored inside the same bin even if they are all unique."
				+ " If the bin is a LinkedList, searching for a hash (if you use the get(Key) method, this will convert the Key to a hash and then the Key will be searched and the value stored with the hash will be returned)"
				+ " will have the time-complexity of Big O(n). If you wanted to search for the last element, if the bins stored the hashes inside of a LinkedList, this could be burdensome."
				+ " However, if the List were a BinarySearchTree this will reduce the time-complexity of searching to Big O(log n). This will improve effeciency tremendously, and "
				+ "is exactly why Hash Maps store their hashes, after a certain threshold, inside BinarySearchTrees instead of LinkedLists. </p>"	
				+"<p>EXAMPLE:</p>"		
				+"<pre>"
				+ "Map&lt;String, Integer&gt; myHM = new HashMap&lt;String, Integer&gt;();\n"
				+ "										myHm.put(\"Hello\", 6);\n"
				+ "											||\n"
				+ "Value is Hashed:	     						 Hash Value of \"Hello\" is x, assigned bucket. \n"
				+ "											||\n"
				+ "Hash Map table:             					 [bucket-1], [bucket-2], [bucket-3], [bucket...]	\n"
				+ "								      ||	  ||	     ||	        ||\n"
				+ "Inside List or Tree:       					 (\"Hello\", 6) (key, value) (key, value) (key, value)\n"
				+"</pre>"	
				+"</div>"	   				
				+"<div><h4>Challenge:</h4>"
				+"<p>In your challenge, construct a HashMap called myFirstMap that has the Key type of String and the Value type of Integer."
				+ " Next, using the put() method, put the Key of \"M\" and value of 5 in the HashMap. </p>"
				+ "</div>";
		return populateChallenge(model, header, description, mc.isChallengeCompleted("HashMapDataStructure", "cs205"));
	}
		@GetMapping(value = "/home/cs205/Binary Search Tree/Tree Traversal/Preorder")
	
	// *********************************************
	// *********************************** RECURSION
	// *********************************************
	/* Tree Traversal */ 
		
	public String preOrder(ModelMap model)
	{
		String header = "Preorder Traversal";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Using Preorder Traversal, what is the order of the tree? Write your answer below separated by commas. \r\n" + 
				"			<br>** For this challenge you have 3 attempts.\r\n" + 
				"			<pre> \r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 59 |<br/>" + 
	            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 72 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 65 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|120 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 25 |&nbsp;&nbsp;&nbsp;&nbsp;| 07 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;| 28 |&nbsp;&nbsp;&nbsp;| 52 |&nbsp;&nbsp;&nbsp;| 10 |&nbsp;&nbsp;&nbsp;&nbsp;| 21 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"			</pre>\r\n" + 
				"		</div>";
		return populateChallenge(model, header, description);
	}
		
	@GetMapping(value = "/home/cs205/Binary Search Tree/Tree Traversal/Inorder")
	public String inOrder(ModelMap model)
	{
		String header = "Inorder Traversal";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Using Inorder Traversal, what is the order of the tree? Write your answer below separated by commas. \r\n" + 
				"			<br>** For this challenge you have 3 attempts.\r\n" + 
				"			<pre> \r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 59 |<br/>" + 
	            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 72 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 65 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|120 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 25 |&nbsp;&nbsp;&nbsp;&nbsp;| 07 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;| 28 |&nbsp;&nbsp;&nbsp;| 52 |&nbsp;&nbsp;&nbsp;| 10 |&nbsp;&nbsp;&nbsp;&nbsp;| 21 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"			</pre>\r\n" +
				"		</div>";
		return populateChallenge(model, header, description);
	}
	
	@GetMapping(value = "/home/cs205/Binary Search Tree/Tree Traversal/Postorder")
	public String postOrder(ModelMap model)
	{
		String header = "Postorder Traversal";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Using Postorder Traversal, what is the order of the tree? Write your answer below separated by commas.\r\n" + 
				"			<br>** For this challenge you have 3 attempts.\r\n" + 
				"			<pre> \r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 59 |<br/>" + 
	            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 72 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 65 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|120 |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 25 |&nbsp;&nbsp;&nbsp;&nbsp;| 07 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;| 28 |&nbsp;&nbsp;&nbsp;| 52 |&nbsp;&nbsp;&nbsp;| 10 |&nbsp;&nbsp;&nbsp;&nbsp;| 21 |<br/>" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+----+<br/>" + 
				"			</pre>\r\n" +
				"		</div>";
		return populateChallenge(model, header, description);
	}
	
	/* Factorial */
	@GetMapping(value = "/home/cs205/Recursion/Factorial")
	public String factorial(ModelMap model)
	{
		String header = "Factorial";
	    String description = 
				   "<div class=\"introduction\">\r\n" + 
					"<p class=\"topic-description\">\r\n" + 
					"<h4>Description:</h4>"	
					+"<p>In the topics section of Recursion, factorial is the example given to showcase the uses of a recursive"
					+ " algorithm. A factorial is a function which will multiply the number by every number before it. So if given"
					+ " 6 a factorial function would look like; 6 x 5 x 4 x 3 x 2 x 1 = 720.</p>"		
					+"</div>"	   				
					+"<div><h4>Challenge:</h4>"
					+"<p>In your challenge, create a recursive method called factorial that is identical to the one given in the example"
					+ " section on the Recursion topics page."
					+ "</p>"
					+ "</div>";
		return populateChallenge(model, header, description, mc.isChallengeCompleted("Factorial", "cs205"));
	}
	
	// *********************************************
	// ****************************** BIG O NOTATION
	// *********************************************
	
	/*
	 * @GetMapping(value = "/home/cs205/Sort/MergeSort") public String
	 * mergeSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 * 
	 * @GetMapping(value = "/home/cs205/Sort/HeapSort") public String
	 * heapSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 * 
	 * @GetMapping(value = "/home/cs205/Sort/QuickSort") public String
	 * quickSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 * 
	 * @GetMapping(value = "/home/cs205/Sort/BubbleSort") public String
	 * bubbleSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 * 
	 * @GetMapping(value = "/home/cs205/Sort/InsertionSort") public String
	 * insertionSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 * 
	 * @GetMapping(value = "/home/cs205/Sort/SelectionSort") public String
	 * selectionSort(ModelMap model) { String header = ""; String description = "";
	 * return populateChallenge(model, header, description); }
	 */
	
	/* Questions */ 
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 1")
	public String oOne(ModelMap model)
	{			
		String header = "Big O Notation - Question 1";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			Java arrays allow the user to directly access its elements by the index of the array.  When an array is instantiated"
				+ "          the indecies act as variables.\r\n" + 
				"			<br>In Big O Notation, what is the average runtime for getting a value from an array?"
				+ "<br/><br/> Please submit your answer between the double quotes of the String we declare called answer. "
				+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
				"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		   		
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question1", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 2")
	public String oLogn(ModelMap model)
	{			
		String header = "Big O Notation - Question 2";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below?</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void messageLoop(int n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;for(int i = 0; i < n; i++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"I am currently at: \" + i);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question2", "cs205"));

	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 3")
	public String oN(ModelMap model)
	{			
		String header = "Big O Notation - Question 3";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below?</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void messageLoop(int[] n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;int i = n.length;<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;while(i > 0){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"I am currently at: \" + i);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i = i / 2;<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question3", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 4")
	public String oNlogn(ModelMap model)
	{			
		String header = "Big O Notation - Question 4";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below? <br/><br/>"
				+ "         Note this one looks very similar to Question 5, but there is one key difference that gives these"
				+ "         two questions different answers.</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void function(int n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;for(int i = 0; i < n; i++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(int j = 0; i < 8; j++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"i: \" + i);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"j: \" + j);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question4", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 5")
	public String oNtwo(ModelMap model)
	{			
		String header = "Big O Notation - Question 5";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below? <br/><br/>"
				+ "         Note this one looks very similar to Question 4, but there is one key difference that gives these"
				+ "         two questions different answers.</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void function(int n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;for(int i = 0; i < n; i++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(int j = 0; i < n; j++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"i: \" + i);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"j: \" + j);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question5", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 6")
	public String oTwon(ModelMap model)
	{			
		String header = "Big O Notation - Question 6";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below?</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void function(int n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;for(int i = 0; i < n; i++){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;function(n-1);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\"";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question6", "cs205"));
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions/Question 7")
	public String oFactorial(ModelMap model)
	{			
		String header = "Big O Notation - Question 7";
		String description = "<div> \r\n" + 
				"			<h4>Challenge:</h4>\r\n" + 
				"			<p>In Big O Notation, what is the average runtime for the method defined below?</p> \r\n" + 
				"			<pre>\r\n"
				+ "public void fibonacci(int n){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;if(n < 2){<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return 1;<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;} else{<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return fibonacci(n-2) + fibonacci(n-1);<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;}<br/>"
				+ "}<br/> </pre>"   
								
+ " Please submit your answer between the double quotes of the String we declare called answer. "
+ " String answer = \"Answer HERE\". The expected format is BigO(1), BigO(logn), BigO(n), BigO(nlogn), BigO(n^2), BigO(2^n), or BigO(n!)\r\n" + 
"		</div>";
		String boilerplate = "//Answer below\n"
				+ "String answer = \"\";";
		return populateChallenge(model, header, description, boilerplate, mc.isChallengeCompleted("Question7", "cs205"));
	}
	
	// *********************************************
	// *********************** TESTING AND DEBUGGING
	// *********************************************
	/*
	 * @GetMapping(value = "/home/cs205/TestingAndDebuging/ErrorMessage") public
	 * String errorMessage(ModelMap model) { String header = ""; String description
	 * = ""; return populateChallenge(model, header, description,
	 * mc.isChallengeCompleted("ErrorMessage", "cs205")); }
	 * 
	 * @GetMapping(value = "/home/cs205/TestingAndDebuging/Exceptions") public
	 * String exceptions(ModelMap model) { String header = ""; String description =
	 * ""; return populateChallenge(model, header, description,
	 * mc.isChallengeCompleted("Exceptions", "cs205")); }
	 * 
	 * @GetMapping(value = "/home/cs205/TestingAndDebuging/Assertions") public
	 * String assertions(ModelMap model) { String header = ""; String description =
	 * ""; return populateChallenge(model, header, description,
	 * mc.isChallengeCompleted("Assertions", "cs205")); }
	 */
}
