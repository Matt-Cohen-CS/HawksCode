package edu.monmouth.hawkscode.web.cs176;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CS176ChallengeText {
	
	public Map<String, String> challengeText(String challengeName) {
		Map<String, String> challengeText = new HashMap<String, String>();
		String header = "";
		String description = "";
		String boilerplate = "";
		String filePath = "";
		switch(challengeName) {
		
		// **********************************************
		// *** OBJECT ORIENTED PROGRAMMING CHALLENGES ***
		// **********************************************
			// **********************************************
			// ************* ACCESS MODIFIERS ***************
			// **********************************************
		case "Private":
			header = "Private Access Modifier";
			description = "<br /><h4>Description:</h4>"+
					"<p>Any methods or instance variables declared as \"private\" in a class will not be accessible to any other classes. Here is what the current file looks like:</p>"+
					"<pre>// Private.java<br />"+
					"class A {\n"+
					"    private int a;\n"+
					"    private void display() {\n"+
					"        System.out.println(\"Hello from class A.\");\n"+
					"    }\n"+
					"}\n\n"+
					"class B {\n"+
					"    public static void main(String[] args) {\n"+
					"        A obj = new A();\n"+
					"        obj.display(); // ERROR\n"+
					"        obj.a = 1; // ERROR\n"+
					"    }\n"+
					"}</pre>"+
					"<p>As you can see, we cannot call the method \"display\" or change the \"a\" variable from the \"A\" object because they are declared as \"private\". We can only do so from within the \"A\" class.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created a class called \"CashRegister\".</p>"+
					"<p>It is your task to create two private instance variables. All CashRegister objects must have at least an item to purchase and the item quantity.</p>"+
					"<p>NOTE: The Item class has been created for you. Simply declare it as an instance variable.</p>";
			boilerplate = "static class CashRegister {\n"+
					 "    // ENTER CODE BELOW\n\n\n\n"+
					 "    // DON'T CHANGE THIS CODE\n"+
					 "    public CashRegister(Item item, int quantity) {\n"+
					 "        this.item = item;\n"+
					 "        this.quantity = quantity;\n"+
					 "    }\n"+
					 "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/Private.txt";
			break;
		case "Public":
			header = "Public Access Modifier";
			description = "<br /><h4>Description:</h4>"+
						"<p>The public access modifier makes it so that classes, methods, or instance variables are accessible by any other code in your program:</p>"+
						"<pre>// Public.java\n"+
						"class A {\n"+
						"    public int a;\n"+
						"}\n\n"+
						"class B {\n"+
						"    public static void main(String[] args) {\n"+
						"        A obj = new A();\n"+
						"        obj.a = 1;\n"+
						"    }\n"+
						"}</pre>"+
						"<p>However, it is usually not a good idea to make all your variables and methods public. When working with classes, you should try to use the most restrictive level of classes that makes sense for your variables and methods.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, we have expanded upon the CashRegister class. Create public getter methods for getting the sales tax and the total. We will be worrying about getting the subtotal in a later challenge, but for now create the getTotal method which will return the subtotal plus the sales tax, and the getTax method which will return the sales tax times the subtotal.</p>";
			boilerplate = "static class CashRegister {\n"+
						 "    private Item item;\n"+
						 "    private int quantity;\n"+
						 "    private final double SALES_TAX = 0.06625;\n"+
						 "    private double subTotal;\n\n"+
						 "    public CashRegister() {\n"+
						 "        quantity = 0;\n"+
						 "        subTotal = 0;\n"+
						 "    }\n\n"+
						 "    public CashRegister(Item item, int quantity) {\n"+
						 "        this.item = item;\n"+
						 "        this.quantity = quantity;\n"+
						 "    }\n\n"+
						 "    // ENTER CODE BELOW\n\n\n\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/Public.txt";
			break;
		case "Protected":
			header = "Protected Access Modifier";
			description = "<br /><h4>Description:</h4>"+
						"<p>The next access modifier we will be covering in this section is \"protected\". Also, we need to have a brief word on \"packaging\" in Java in order to fully understand access modifiers.</p>"+
						"<p>Packages in Java are basically responsible for grouping related classes. You can think of it like a folder in a file directory. These are useful for organizing larger programs with many classes.</p>"+
						"<p>In previous challenges, we learned how the private access modifier makes our methods and instance variables inaccessible to other classes and public makes them accessible from everywhere. When using the private access modifier, our variables and methods are not only inaccessible from other classes but also from any package. Public makes variables and methods available to all classes and all packages.</p>"+
						"<p>Protected makes variables and methods accessible within the same package or subclasses in any package. We haven't covered subclasses yet but that's coming up in the \"inheritance\" section.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, create a protected instance variable for the Student class called \"name\".</p>";
			boilerplate = "static class Student {\n"+
						 "    // ENTER CODE BELOW\n\n\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/Protected.txt";
			break;
		case "Default":
			header = "Default Access Modifier";
			description = "<br /><h4>Description:</h4>"+
					"<p>The last access modifier we will be looking at in this section is the default access modifier. Using the default access modifier is simple, we basically don't declare an access modifier:</p>"+
					"<pre>// Default.java<br />"+
					"class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;int a;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;void display() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello from class A.\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class B {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A obj = new A();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;obj.display();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;obj.a = 1;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>What this does is make our variables and methods accessible from classes only within the same package. It's more restricting than public and protected but less restricting than private.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, declare an instance variable \"name\" with the default access modifier for the class Student.</p>";
			boilerplate = "static class Student {\n"+
						 "    // ENTER CODE BELOW\n\n\n\n"+
						 "    // DON'T CHANGE THIS CODE\n"+
						 "    public Student(String name) {\n"+
						 "        this.name = name;\n"+
						 "    }\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/Default.txt";
			break;
			// **********************************************
			// ********* ACCESS MODIFIERS PROJECTS **********
			// **********************************************
//		case "BasketballPlayer Part 1":
//			header = "BasketballPlayer Part 1 - Creating the class";
//			description = "<br /><h4>Description:</h4>"+
//					"<p>To get more practice accessing and changing private instance variables using setter and getter methods, you will implement the BasketballPlayer class yourself.</p>"+
//					"<br /><h4>Challenge:</h4>"+
//					"<p>For your challenge, create the private fields \"team\" and \"name\" and create public getter and setter methods for both. Also create a constructor that sets the fields when instantiating an object of the class.</p>";
//			boilerplate = "static class BasketballPlayer {\n"+
//						 "    // ENTER CODE BELOW\n\n\n\n"+
//						 "}";
//			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/projects/BasketballPlayerPart1.txt";
//			break;
//		case "BasketballPlayer Part 2":
//			header = "BasketballPlayer Part 2 - Creating the object";
//			description = "<br /><h4>Challenge:</h4>"+
//						"<p>Using the BasketballPlayer class that you implemented during the last challenge, create a BasketballPlayer object called \"jr\" and set the name to be \"JR\" and team to be \"Hawks\". You may use the constructor or the setter methods to do this.</p>";
//			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/projects/BasketballPlayerPart2.txt";
//			break;
		case "Shop Part 1":
			header = "Shop Part 1 - Creating the Item Class";
			description = "<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, create the Item class yourself. Here is the layout of the Item class again:</p>"+
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
						"-------------------------------</pre>";
			boilerplate = "static class Item {\n"+
						  "    // ENTER CODE BELOW\n\n\n\n"+
						  "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/projects/ShopPart1.txt";
			break;
		case "Shop Part 2":
			header = "Shop Part 2 - Getting the subtotal";
			description = "<br /><h4>Description:</h4>"+
						"<p>Now that we can get the cost of our items, we can now get the subtotal in our CashRegister class. The subtotal is simply the quantity times the item's cost. Also, notice that we changed the getTax and getTotal methods. This is so that we can correctly get the tax and total.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, create the getSubtotal method.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						  "static class CashRegister {\n"+
						  "    private Item item;\n"+
						  "    private int quantity;\n"+
						  "    private final double SALES_TAX = 0.06625;\n"+
						  "    private double subTotal;\n\n"+
						  "    public CashRegister() {\n"+
						  "        quantity = 0;\n"+
						  "        subTotal = 0;\n"+
						  "    }\n\n"+
						  "    public CashRegister(Item item, int quantity) {\n"+
						  "        this.item = item;\n"+
						  "        this.quantity = quantity;\n"+
						  "    }\n\n"+
						  "    public double getTax() {\n"+
						  "        return SALES_TAX * getSubtotal();\n"+
						  "    }\n\n"+
						  "    // ENTER CODE BELOW\n\n\n\n"+
						  "    public double getTotal() {\n"+
						  "        return getSubtotal() + getTax();\n"+
						  "    }\n"+
						  "}";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/projects/ShopPart2.txt";
			break;
		case "Shop Part 3":
			header = "Shop Part 3 - Testing our program";
			description = "<br /><h4>Description:</h4>"+
					"<p>Now that the Item and CashRegister classes are completed, you must test your classes.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, create an Item object using whatever description, item number, and variable name you'd like, but set it's cost to 10. Next, create a CashRegister object with the name \"myCashRegister\" and set it's constructor arguments to be the Item object you created and 5 as it's quantity. Then print the subtotal and total of myCashRegister.</p>";
			filePath = "static/cs176/objectOrientedProgramming/accessModifiers/projects/ShopPart3.txt";
			break;
			// **********************************************
			// ***************** STATIC *********************
			// **********************************************
		case "Static Variables":
			header = "Static Variables";
			description = "<p>When a variable is declared static, it can be accessed before any objects of its class are created, and without any reference to an object:</p>"+
					"<pre>// Static.java<br />"+
					"class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;static int a;<br />"+
					"}<br /><br />"+
					"class B {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A.a = 5;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(A.a) // 5<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>A time when static might be useful is when you have a property that is common to all objects.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created a class \"StaticVariable\". Create a static field for \"counter\". Counter will be of type int.</p>";
			boilerplate = "static class StaticVariable {\n"+
						 "    // ENTER CODE BELOW\n"+
						 "\n"+
						 "\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/staticModifier/StaticVariables.txt";
			break;
		case "Static Methods":
			header= "Static Methods";
			description = "<p>Methods declared as static are known \"static methods\". Like static variables, static methods belongs to the class rather than the object of a class.</p>"+
					"<pre>// Static.java<br />"+
					"class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;static void display() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello from A class\");<br />"+
					"}<br /><br />"+
					"class B {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A.display(); // \"Hello from A class\"<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created a class called \"StaticMethod\" with a static field \"counter\". Create a static method called \"increaseCounter\" that increments the counter by 1. This static method will return void.</p>";
			boilerplate = "static class StaticMethod {\n"+
						 "    static int counter;\n"+
						 "    // ENTER CODE BELOW\n"+
						 "\n"+
						 "\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/staticModifier/StaticMethods.txt";
			break;
		case "Static Blocks":
			header = "Static Blocks";
			description = "<br /><h4>Description:</h4>"+
					"<p>The last use of the static keyword we will look at are static blocks, and they look something like this:</p>"+
					"<pre>// Static.java<br />"+
					"class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;static int a;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;static {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a = 10;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Inside static block\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;} <br />"+
					"}</pre>"+
					"<p>A static block is executed when a class is first loaded:</p>"+
					"<pre>class B {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(A.a);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"Inside static block<br />"+
					"10</pre>"+
					"<p>A time when we might use static blocks is when we need to initialize static variables for a class before making an object.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created a class called \"StaticBlock\". There is one field called \"numbers\" that is a List. We haven't covered Lists in Java yet because they are covered in CS205, but for now all you need to know is that you can call the \".add()\" method to add items to it. Using a static block, add the numbers 10, 20, and 30 in that order to the List called \"numbers\".</p>";
			boilerplate = "static class StaticBlock {\n"+
						 "    public static List<Integer> numbers = new LinkedList<>();\n\n"+
						 "    // ENTER CODE BELOW\n"+
						 "\n"+
						 "\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/staticModifier/StaticBlocks.txt";
			break;
			// **********************************************
			// *************** OVERLOADING ******************
			// **********************************************
		case "Overloading Methods":
			header = "Overloading Methods";
			description = "<br /><h4>Description:</h4>"+
					"<p>Method overloading is a handy technique for when you want different versions of the same method:</p>"+
					"<pre>class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void sayHello() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello Anonymous.\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void sayHello(String name) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello \" + name + \".\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void sayHello(String name, String timeOfDay) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello \" + name + \", how are you this \" + timeOfDay + \"?\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class B {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A a = new A();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.sayHello();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.sayHello(\"Joe\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.sayHello(\"Joe\", \"evening\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"Hello Anonymous.<br />"+
					"Hello Joe.<br />"+
					"Hello Joe, how are you this evening?</pre>"+
					"<p>So how does this work? In Java and other programming languages, there is something called method signatures that are part of method declarations. The method signature includes the name of the method and the type of its parameters. The method signatures of the example above are: sayHello(), sayHello(String), and sayHello(String, String). The compiler sees this and is able to decide which method to run based on how many arguments we passed to the method.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, you will be creating 2 overloaded methods for the class below. The method must either set counter to 0 when the parameter is empty or set counter to an argument that is passed in. The methods must be called \"setCounter\".</p>";
			boilerplate = "static class OverloadingMethod {\n"+
						 "    private int counter;\n\n"+
						 "    // ENTER CODE BELOW\n"+
						 "\n"+
						 "\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/overloading/OverloadingMethods.txt";
			break;
		case "Overloading Constructors":
			header = "Overloading Constructors";
			description = "<br /><h4>Description:</h4>"+
					"<p>We can overload constructors the same way we overload methods:</p>"+
					"<pre>class A {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private int i;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String s;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private boolean b;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public A() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.i = 0;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.s = \"\";<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.b = false;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public A(int i) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.i = i;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.s = \"\";<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.b = false;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public A(int i, String s) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.i = i;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.s = s;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.b = false;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public A(int i, String s, boolean b) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.i = i;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.s = s;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.b = b;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>This allows us to initialize objects in different ways.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, create overloaded constructors for all the instance variables in class \"OverloadingConstructor\".</p>";
			boilerplate = "static class OverloadingConstructor {\n"+
						 "    private int i;\n"+
						 "    private String s;\n\n"+
						 "    // ENTER CODE BELOW\n"+
						 "\n"+
						 "\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/overloading/OverloadingConstructors.txt";
			break;
		case "Using This":
			header = "Using \"this\" with class constructors";
			description = "<br /><h4>Description:</h4>"+
					   "<p>As you may know, it is better not to repeat yourself when programming because it makes your project harder to maintain as it grows in size. You already know how to reuse methods in other files by creating objects, but you may have noticed that overloading constructors and methods have repetitive code in them.</p>"+
					   "<p>There is actually a way to make it so that we don't repeat ourselves simply by using the \"this\" keyword. You have probably seen \"this\" floating around in these challenges. The \"this\" keyword simply refers to the class you are currently working in. It's the same as using  an object, except you are using the current class. Here's how you can make your overloaded constructors less repetitive using \"this\":</p>"+
					   "<pre>class Student {<br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;private String name;<br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;private String id;<br/><br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;public Student() {<br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this(\"\", \"\");<br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;public Student(String name) {<br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this(\"name\", \"\");<br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;public Student(String name, String id) {<br/>"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.name = name;<br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.team = team;<br />"+
					   "&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					   "}</pre>"+
					   "<p>As you can see, the last constructor with all our fields as parameters acts as the \"template\" for our other constructors. When we call this(\"\", \"\") in the first constructor, we are actually calling the last constructor and setting the name and team to whatever we like. It makes sense to set the name and id to blank when no arguments are passed in, so we set them to empty strings. In the second constructor, we call the last constructor again but set the name to an argument we pass in.</p>"+
					   "<br /><h4>Challenge:</h4>"+
					   "<p>For your challenge, create overloaded constructors for the BasketballPlayer class using the \"this\" keyword.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						"static class BasketballPlayer {\n"+
						"    private String name;\n"+
						"    private String team;\n\n"+
						"    // ENTER CODE BELOW\n\n\n\n"+
						"}";
			filePath = "static/cs176/objectOrientedProgramming/overloading/UsingThis.txt";
			break;
		case "This With Methods":
			header = "Using \"this\" with class methods";
			description = "<br /><h4>Description:</h4>"+
					"<p>Just like how you can use \"this\" with constructors, you can do the same with methods:</p>"+
					"<pre>class Student {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private int credits;<br /><br/>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void addCredits() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.addCredits(1);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void addCredits(int amount) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;credits += amount;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>In the second method, we are adding an argument \"amount\" to the Student's credits. In the first method, we are calling the second method but we pass in 1 credit as an argument.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, create two methods for BasketballPlayer both called \"addPoints\". One of the methods will add a single point when no arguments are passed in and the other will add an argument we pass in to the player's points.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						"static class BasketballPlayer {\n"+
						"    private int points;\n\n"+
						"    public BasketballPlayer(int points) {\n"+
						"        this.points = points;\n"+
						"    }\n\n"+
						"    // ENTER CODE BELOW\n\n\n\n"+
						"}";
			filePath = "static/cs176/objectOrientedProgramming/overloading/ThisWithMethods.txt";
			break;
			// **********************************************
			// *************** INHERITANCE ******************
			// **********************************************
		case "Extends":
			header = "The extends keyword";
			description = "<br /><h4>Description:</h4>"+
					"<p>In order to inherit from a class, we use the \"extends\" keyword:</p>"+
					"<pre>class Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String name;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String gender;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private int age;<br /><br />"+
					"}<br /><br />"+
					"class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;...<br />"+
					"}</pre>"+
					"<p>Whenever you see the extends keyword in a class declaration, then the class is said to have an \"IS-A\" relationship. In our example, we say a GuitarPlayer IS-A Musician.</p>"+
					"<p>We refer to GuitarPlayer as the subclass or child class, and Musician as the superclass or parent class. When we inherit from another class, we get that class's instance variables and methods. Let's say that a GuitarPlayer has additional fields that are unique only to them. For example, maybe a GuitarPlayer has a band that they play in. We can any additional fields we want to GuitarPlayer: </p>"+
					"<pre>class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String bandName;<br />"+
					"}</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created the classes \"Athlete\" and \"BasketballPlayer\". It is your task to make the BasketballPlayer class inherit from Athlete with some additional fields: league and gamesPlayed.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "static class Athlete {\n"+
						 "    private String name;\n"+
						 "    private String gender;\n"+
						 "    private int age;\n\n"+
						 "    public Athlete(String name, String gender, int age) {\n"+
						 "        this.name = name;\n"+
						 "        this.gender = gender;\n"+
						 "        this.age = age;\n"+
						 "    }\n"+
						 "}\n\n"+
						 "// ENTER CODE BELOW\n"+
						 "static class BasketballPlayer {\n\n\n\n"+
						 "    // DON'T CHANGE THIS CODE\n"+
						 "    public BasketballPlayer(String name, String gender, int age, String league, int gamesPlayed) {\n"+
						 "        super(name, gender, age);\n"+
						 "        this.league = league;\n"+
						 "        this.gamesPlayed = gamesPlayed;\n"+
						 "    }\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/inheritance/Inheritance.txt";
			break;
		case "Overriding":
			header = "Overriding";
			description = "<br /><h4>Description:</h4>"+
					"<p>Method overriding in Java is the act of declaring the same method from a superclass with some different implementation:</p>"+
					"<pre>class Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;protected int count;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void display(int count) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Look at me! I'm a musician!\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.count = count;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;// Same method from \"Musician\" but different<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void display(int count) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Look at me! I'm a guitar player!\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.count += count;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>This only works if you have a subclass that is inheriting a method from a superclass, and you have the same method signatures. If you remember the concept of method signatures from the \"OverloadingMethods\" lesson, then you'll see that these two methods have the same signatures. Overriding is different from overloading because we have the same signatures, which is the name of our method and the type of its parameters.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created the classes \"Athlete\" and \"BasketballPlayer\". It is your task to override the method \"setCount\" to instead subtract by the parameter \"count\".</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "static class Athlete {\n"+
						 "    protected int count;\n\n"+
						 "    public void setCount(int count) {\n"+
						 "        this.count = count;\n"+
						 "    }\n\n"+
						 "    public int getCount() {\n"+
						 "        return this.count;\n"+
						 "    }\n"+
						 "}\n\n"+
						 "static class BasketballPlayer extends Athlete {\n\n"+
						 "    // ENTER CODE BELOW\n\n\n\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/inheritance/Overriding.txt";
			break;
		case "Super":
			header = "The super keyword";
			description = "<br /><h4>Description:</h4>"+
					"<p>The super keyword in Java is used to refer to parent class objects, and you may have seen it in some previous challenges:</p>"+
					"<pre>class Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String name;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String gender;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private int age;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public Musician(String name, String gender, int age) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.name = name;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.gender = gender;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.age = age;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String bandName;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public GuitarPlayer(String name, String gender, int age, String bandName) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;super(name, gender, age);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.bandName = bandName;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>We use super here to access the parent class constructor. This example only shows one of the uses of super. We can also use super with methods and variables:</p>"+
					"<pre>class Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;int count;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void display() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;count = 5;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Musician\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;int count;<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void display() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"GuitarPlayer\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;count = 3;<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;super.display(); // Calls the display method from Musician<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(super.count); // Prints count from Musician<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class Main {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GuitarPlayer obj = new GuitarPlayer();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;obj.display();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"GuitarPlayer<br />"+
					"Musician<br />"+
					"5</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, create a constructor for BasketballPlayer that uses all the instance variables from Athlete as well as BasketballPlayer's instance variables.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "static class Athlete {\n"+
						 "    private String name;\n"+
						 "    private String gender;\n"+
						 "    private int age;\n\n"+
						 "    public Athlete(String name, String gender, int age) {\n"+
						 "        this.name = name;\n"+
						 "        this.gender = gender;\n"+
						 "        this.age = age;\n"+
						 "    }\n"+
						 "}\n\n"+
						 "static class BasketballPlayer extends Athlete {\n"+
						 "    private String league;\n"+
						 "    private int gamesPlayed;\n\n"+
						 "    // ENTER CODE BELOW\n\n\n\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/inheritance/Super.txt";
			break;
		case "Polymorphism":
			header = "Polymorphism";
			description = "<br /><h4>Description:</h4>"+
					"<p>The term polymorphism means the condition of having many forms. In Java, it means the exact same thing. Our objects can have many forms. Inheritance allows us to inherit instance variables and methods from other classes, and polymorphism uses those methods to perform different actions:</p>"+
					"<pre>class Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void playInstrument() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"The instrument makes a sound.\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class GuitarPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void playInstrument() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"The guitar goes: wahwahwahwah.\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class BassPlayer extends Musician {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public void playInstrument() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"The bass goes: dundundundun\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class Main {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Musician musician = new Musician(); // Create a Musician object<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Musician guitarist = new GuitarPlayer(); // Create a GuitarPlayer object<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Musician bassist = new BassPlayer(); // Create a BassPlayer object<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;musician.playInstrument();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;guitarist.playInstrument();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bassist.playInstrument();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"The instrument makes a sound.<br />"+
					"The guitar goes: wahwahwahwah.<br />"+
					"The bass goes: dundundundun.</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created 3 classes: Athlete, BasketballPlayer, and BaseballPlayer. Here is what the main method looks like:</p>"+
					"<pre>class Main {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Athlete athlete = new Athlete();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Athlete basketballPlayer = new BasketballPlayer();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Athlete baseballPlayer = new BaseballPlayer();<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>It is your task to make getSport() return \"basketball\" when the Athlete is a BasketballPlayer, and \"baseball\" when the Athlete is a BaseballPlayer.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "static class Athlete {\n"+
						 "    public String getSport() {\n"+
						 "        return \"\";\n"+
						 "    }\n"+
						 "}\n\n"+
						 "// ENTER CODE BELOW\n"+
						 "static class BasketballPlayer extends Athlete {\n"+
						 "    public String getSport() {\n"+
						 "        return \"\";\n"+
						 "    }\n"+
						 "}\n\n"+
						 "static class BaseballPlayer extends Athlete {\n"+
						 "    public String getSport() {\n"+
						 "        return \"\";\n"+
						 "    }\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/inheritance/Polymorphism.txt";
			break;
			// **********************************************
			// ************** NESTED CLASSES ****************
			// **********************************************
		case "Nested Classes": 
			header = "Nested Classes";
			description = "<br /><h4>Description:</h4>"+
					"<p>In Java, we can create classes within other classes, known as \"Nested Classes\". The reasoning behind doing so is that it allows you to group classes together if they're not being used anywhere else. This increases the use of encapsulation and makes your code easier to read and maintain:</p>"+
					"<pre>class OuterClass {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;private String message = \"Hello!\";<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;class InnerClass {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public void display() {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(message);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"class Main {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OuterClass outerObj = new OuterClass();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OuterClass.InnerClass innerObj = outerObj.new InnerClass();<br /><br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;innerObj.display();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"Hello!</pre>"+
					"<p>Static nested classes work similarly except we don't have to instantiate the outer class first. If InnerClass was static, we would instantiate it like this:</p>"+
					"<pre>OuterClass.InnerClass innerObj = new OuterClass.InnerClass();</pre>"+
					"<p>When working with nested classes, we refer to static nested classes as just \"static nested classes\", and non-static nested classes as \"inner classes\".</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created a class \"Player\". It is your task to create an inner class called \"Status\" with these fields: health, gold, and experience. Then create a Status constructor to initialize these fields.</p>"+
					"<p>NOTE: The inner class will not be static. All fields in Statistics will be of the type int.</p>";
			boilerplate = "static class Player {\n"+
						 "// DON'T CHANGE THIS CODE\n"+
						 "    private Inventory inventory;\n"+
						 "    private Equipment equipment;\n\n"+
						 "    // ENTER CODE BELOW\n\n\n\n"+
						 "}";
			filePath = "static/cs176/objectOrientedProgramming/NestedClasses.txt";
			break;
			// **********************************************
			// **********************************************
			// **********************************************
			
		// **********************************************
		// ************* ARRAY CHALLENGES ***************
		// **********************************************	
		case "Instantiating Arrays":
			header = "Instantiating Arrays";
			description = "<br /><h4>Description:</h4>"+ 
					 "<p>An array declaration uses square brackets([]) to tell Java that it is an array. The general form of an array declaration is:</p>"+
					 "<pre>type varName[];</pre>"+
					 "<p>OR</p>"+
					 "<pre>type[] varName;</pre>"+
					 "<p>Use whichever you prefer, we'll be using the second one throughout this section. To instantiate it, you must use the \"new\" keyword and then the type with square brackets again.</p>"+
					 "<pre>type[] varName = new type[size];</pre>"+
					 "<p>If I were to create an array of chars with a size of 10, it would look like the following:</p>"+
					 "<pre>char[] charArray = new char[10];</pre>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>For your challenge, declare and instantiate an array of ints, doubles, Strings, and Objects.</p>"+
					 "<p>NOTE: the variables must be called intArray, doubleArray, stringArray, and objectArray and their sizes must be greater than 0.</p>";
			filePath =  "static/cs176/arrays/InstantiatingArrays.txt";
			break;
		case "Getting Array Values":
			header = "Getting Array Values";
			description = "<br /><h4>Description:</h4>"+   
					 "<p>In order to get a value from an array, you need to specify the index of the array in square brackets([]):</p>"+
					 "<pre>int[] ourArray = {1, 2, 3};<br />"+
					 "int first = ourArray[0]; // Gets the first value from the array<br />"+
					 "System.out.println(first); // 1</pre>"+
					 "<p>Arrays use \"zero-based indexing\", which means that they start at 0.</p>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>For your challenge, get the third value from the array of friends:</p>"+
					 "<pre>String[] friends = {...};</pre>"+
					 "<p>We have hidden the items from you for testing purposes. Store the third value in a variable called \"third\".</p>"+
					 "<p>NOTE: Arrays always start at 0.</p>";
			filePath = "static/cs176/arrays/GettingArrayValues.txt";
			break;
		case "Setting Array Values":
			header = "Setting Array Values";
			description = "<br /><h4>Description:</h4>"+   
					 "<p>Once you instantiate your array, you can give values to it. Say we have an array with a size of 3: </p>"+
					 "<pre>int[] ourArray = new int[3];</pre>"+
					 "<p>If we want to set the first element of the array, we get the first index and then assign a value to it:</p>"+
					 "<pre>ourArray[0] = 5; // First index</pre>"+
					 "<p>Remember that arrays always start at 0. We can set the second and third values like this:</p>"+
					 "<pre>ourArray[1] = 10; // Second index<br />"+
					 "ourArray[2] = 15; // Third value</pre>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>For your challenge, we created an array of type double with a size of 3:</p>"+
					 "<pre>double[] newArray = new double[3];</pre>"+
					 "<p>Assign three values greater than 0 to \"newArray\"</p>";
			filePath = "static/cs176/arrays/SettingArrayValues.txt";
			break;
		case "Array Literals":
			header = "Array Literals";
			description = "<br /><h4>Description:</h4>"+  
					 "<p>There is another way of creating arrays that immediately set the values. These are called \"Array Literals\". Array literals look like this:</p>"+
					 "<pre>int[] ourArray = {1, 2, 3, 4};</pre>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>Create an array literal of 5 of your favorite things. Call this array \"myFaves\". The array will be of type String.</p>";
			filePath = "static/cs176/arrays/ArrayLiterals.txt";
			break;
		case "Array Bounds and Length":
			header = "Array Bounds and the \"Length\" Property";
			description = "<br /><h4>Description:</h4>"+ 
					 "<p>It is important to note that arrays in Java have a set size. If you try to set or get a value from an array that is \"out of bounds\", you will get an error:</p>"+
					 "<pre>int[] ourArray = {5, 10, 15, 20, 25};<br />"+
					 "ourArray[99] = 5; // ERROR</pre>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>For your challenge, we have created an array called \"sports\":</p>"+
					 "<pre>String[] sports = {\"Baseball\", \"Basketball\", \"Football\", \"...\", \"...\"};</pre>"+
					 "<p>We have hidden some of the items from you for testing purposes.</p>"+
					 "<p>Trying to get an index like -1 will result in Java throwing \"ArrayIndexOutOfBoundsException\" class. This is a common error when working with arrays.</p>"+
					 "<p>It is your task to get the last element of the sports array and store it in a variable called \"last\". There is a shortcut to do this using the \"length\" property:</p>"+
					 "<pre>int[] ourArray = {1, 2, 3};<br />"+
					 "int lastElement = ourArray.length - 1;<br />"+
					 "System.out.println(lastElement); // 3</pre>"+
					 "<p>\".length\" returns the size of the array and because arrays start at 0, you subtract by 1 to get the index.</p>";
			filePath = "static/cs176/arrays/ArrayBoundsAndLength.txt";
			break;
		case "Multidimensional Arrays":
			header = "Multidimensional Arrays";
			description =  "<br /><h4>Description:</h4>"+
					 "<p>We have only been working with one-dimensional arrays so far, but there are also \"Multidimensional Arrays\" which are basically arrays of arrays:</p>"+
					 "<pre>int[][] ourMatrix = new int[2][4]; // a 2D array or matrix<br />"+
					 "int[][][] our3DArray = new int[5][6][4]; // a 3D array</pre>"+
					 "<p>When the size of the rows and columns are different, it is known as a \"Jagged Array\". When getting values from 2D arrays, the first set of brackets refers to the outermost array, and each additional pair refers to the next level of entries inside.</p>"+
					 "<pre>int[][] ourMatrix = {<br />"+
					 "&nbsp;&nbsp;&nbsp;&nbsp;{1, 2, 3, 4},<br />"+
					 "&nbsp;&nbsp;&nbsp;&nbsp;{5, 6, 7, 8},<br />"+
					 "}<br />"+
					 "int oneToFour = ourMatrix[0]; // equals [1, 2, 3, 4]<br />"+
					 "int three = ourMatrix[0][2]; // equals 3</pre>"+
					 "<br /><h4>Challenge:</h4>"+
					 "<p>For your challenge, create a 2D array called \"myMatrix\" with 3 rows and 6 columns.";
			filePath = "static/cs176/arrays/MultidimensionalArrays.txt";
			break;
			// **********************************************
			// ************** ARRAY PROJECTS ****************
			// **********************************************
//		case "BasketballPlayer Part 3":
//			header = "BasketballPlayer Part 3 - Array of objects";
//			description = "<p>For your challenge, we have created the Team and BasketballPlayer class. The constructor for Team takes in a single parameter which is an array of BasketballPlayer objects. It is your task to create three BasketballPlayer objects and then create an array containing the three objects. Then, create a Team object called \"myTeam\" with the array of players as an argument.</p>"+
//					 "<p>NOTE: You may leave the arguments for the BasketballPlayer object constructors blank, or set with a name.</p>";
//			filePath = "static/cs176/arrays/projects/BasketballPlayerPart3.txt";
//			break;
		case "Shop Part 4":
			header = "Shop Part 4 - Changing the CashRegister Class";
			description = "<br /><h4>Description:</h4>"+
						"<p>We've made some changes to the CashRegister class. We've removed the quantity field from CashRegister which now belongs to the Item class. We've also removed the getSubtotal method because getting the subtotal requires us to know how to loop through an array. This will be covered in the \"Advanced Looping\" section and you will be finishing the Shop program in that section.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, change the CashRegister class so that CashRegister objects receive an array of Item objects rather than just one Item object. Here is the layout of the new CashRegister class again:</p>"+
						"<pre>" +
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
						"</pre>"+
						"<p>NOTE: Don't worry about the getSubtotal method, we will be implementing that in a later challenge.</p>";
			boilerplate = "static class CashRegister {\n"+
						  "    private Item item;\n"+
						  "    private final double SALES_TAX = 0.06625;\n"+
						  "    private double subTotal;\n\n"+
						  "    public CashRegister() {\n"+
						  "        subTotal = 0;\n"+
						  "    }\n\n"+
						  "    public CashRegister(Item item) {\n"+
						  "        this.item = item;\n"+
						  "    }\n\n"+
						  "    public double getTax() {\n"+
						  "        return SALES_TAX * subTotal;\n"+
						  "    }\n\n"+
						  "    public double getTotal() {\n"+
						  "        return subTotal + getTax();\n"+
						  "    }\n"+
						  "}";
			filePath = "static/cs176/arrays/projects/ShopPart4.txt";
			break;
		case "Shop Part 5":
			header = "Shop Part 5 - Testing the program";
			description = "<br /><h4>Challenge:</h4>"+
							"<p>Now, you must test your program. Create an array with three Item objects, and then create a CashRegister object called \"myCashRegister\" with its constructor argument set to the array of Item objects.</p>"+
							"<p>NOTE: You may leave the constructor arguments for your Item objects empty.</p>";
			filePath = "static/cs176/arrays/projects/ShopPart5.txt";
			break;
			// **********************************************
			// **************** ARRAY LISTS *****************
			// **********************************************
		case "Creating Array Lists":
			header = "Creating Array Lists";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>Creating an ArrayList is different from declaring and instantiating an array. Since ArrayList is a class, we must create an object:</p>"+
					"<pre>ArrayList&lt;Integer&gt; intArrayList = new ArrayList&lt;Integer&gt;();</pre>"+
					"<p>This syntax is very similar to the usual object instantiation in Java, with one minor difference. We put the type of data we want to put in the ArrayList in angle brackets (<>). This is known as a \"generic\" in Java which won't be covered until CS205, but for now just think of it as setting the type of the ArrayList as you would with an array.</p>"+
					"<p>Also, with ArrayLists we must use \"reference types\" instead of primitive types. A reference type is simply a data type that's based on a class rather than one of the primitive types. In our example, you can see we used the \"Integer\" class that Java provides. There are also classes for Double, Boolean, etc.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have already imported the ArrayList class. Create an ArrayList of the type String and call it \"stringArrayList\".</p>";
			filePath = "static/cs176/arrays/arrayLists/CreatingArrayLists.txt";
			break;
		case "Adding Items":
			header = "Adding Items to Array Lists";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>Now that we know how to create ArrayLists, we can start working with data. The most basic operation we can do with an ArrayList is adding an item:</p>"+
					"<pre>ArrayList&lt;String&gt; stringArrayList = new ArrayList&lt;String&gt;();<br />"+
					"stringArrayList.add(\"Example string\");</pre>"+
					"<p>We can also get the size of the ArrayList with the \".size()\" method:</p>"+
					"<pre>System.out.println(stringArrayList.size()); // 1</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have already imported ArrayList and created an ArrayList called \"myNums\":</p>"+
					"<pre>ArrayList&lt;Integer&gt; myNums = new ArrayList&lt;Integer&gt;();</pre>"+
					"<p>Add the numbers: 1, 2, 3, 4 and 5 to the ArrayList in that order. Bonus points if you use a For loop.</p>";
			filePath = "static/cs176/arrays/arrayLists/AddingItems.txt";
			break;
		case "Getting Items":
			header = "Getting Items from Array Lists";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>The next ArrayList operation we will be looking at is getting items using the \".get()\" method:</p>"+
					"<pre>ArrayList&lt;Integer&gt; myNums = new ArrayList&lt;Integer&gt;();<br />"+
					"myNums.add(0);<br />"+
					"myNums.add(1);<br />"+
					"...<br />"+
					"System.out.println(myNums.get(2)); // 2</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have already imported the ArrayList class and have created an ArrayList called \"mystery\":</p>"+
					"<p>The contents of the ArrayList are unknown to you, it is your task to get the last item of this ArrayList and assign it to a String \"lastItem\".</p>"+
					"<pre>ArrayList&lt;String&gt; mystery = new ArrayList&lt;String&gt;();</pre>"+
					"<p>NOTE: You must use the \".size()\" method and remember that arrays use \"zero-based indexing\", this includes ArrayLists as well.</p>";
			filePath = "static/cs176/arrays/arrayLists/GettingItems.txt";
			break;
		case "Changing Items":
			header = "Changing Items in an Array List";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>Another operation we can do with ArrayLists is changing items at certain indexes using the \".set()\" method:</p>"+
					"<pre>ArrayList&lt;Integer&gt; testScores = new ArrayList&lt;Integer&gt;();<br />"+
					"testScores.add(89);<br />"+
					"...<br />"+
					"testScores.set(0, 100); // Changes the item at index 0 to 100</pre>"+
					"<p>With loops, we can efficiently change the contents of an ArrayList without having to write repetitive code:</p>"+
					"<pre>public void applyCurve(ArrayList&lt;Integer&gt; testScores) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;for(int i = 0; i < testScores.size(); i++) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int currentTestScore = testScores.get(i);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;testScores.set(i, currentTestScore + 10);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>What the code above is doing is adding a curve of 10 points to every score in the \"testScores\" ArrayList. Hopefully you can see how using data structures can be useful when writing larger applications. We haven't covered looping through arrays at this point, which is why we made your challenge simpler than the example above. You will get some practice looping through arrays in the upcoming \"advanced looping\" section.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have already imported the ArrayList class and created an ArrayList called \"bookPrices\".</p>"+
					"<pre>ArrayList&lt;Double&gt; bookPrices = new ArrayList&lt;Double&gt;();</pre>"+
					"<p>We then added some items to the ArrayList. It is your task to apply a 15% discount to books over $60. We have also created a method and a For loop to get you started.</p>";
			boilerplate = "public void applyDiscount(ArrayList<Double> bookPrices) {\n"+
						 "    for(int i = 0; i < bookPrices.size(); i++) {\n"+
						 "        // ENTER CODE BELOW\n\n\n\n"+
						 "    }\n\n"+
						 "    // DON'T CHANGE THIS LINE\n"+
						 "    test(bookPrices); // TESTING YOUR CODE\n"+
						 "}";
			filePath = "static/cs176/arrays/arrayLists/ChangingItems.txt";
			break;
		case "Removing Items":
			header = "Removing Items from an Array List";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>The final ArrayList operation we will be covering is removing items with the \".remove()\" method:</p>"+
					"<pre>ArrayList&lt;String&gt; reasonsToCode = new ArrayList&lt;String&gt;();<br />"+
					"reasonsToCode.add(\"It is fun.\");<br />"+
					"reasonsToCode.add(\"You can create cool things.\");<br />"+
					"reasonsToCode.add(\"Change the world.\");<br />"+
					"reasonsToCode.add(\"I only want money!!!\");<br />"+
					"<br />"+
					"reasonsToCode.remove(3); // Removes the fourth item</pre>"+
					"<p>In some cases, you might want to remove all the elements in an ArrayList. In that case, you would use the \".clear()\" method:</p>"+
					"<pre>reasonsToCode.clear();</pre>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>Your challenge is pretty similar to the last one, except this time you are removing items based on some condition. For your challenge, we have already imported the ArrayList class and created an ArrayList called \"emails\":</p>"+
					"<pre>ArrayList&lt;String&gt; emails = new ArrayList&lt;String&gt;();</pre>"+
					"<p>Then we added some emails to the ArrayList. We also created a method and For loop to get you started.</p>"+
					"<p>It is your task to check for empty Strings in the ArrayList and remove them.</p>";
			boilerplate = "public void removeEmptyEmails(ArrayList<String> emails) {\n"+
						 "    for(int i = 0; i < emails.size(); i++) {\n"+
						 "        // ENTER CODE BELOW\n\n\n\n"+
						 "    }\n\n"+
						 "    // DON'T CHANGE THIS LINE\n"+
						 "    test(emails); // TESTING YOUR CODE\n"+
						 "}";
			filePath = "static/cs176/arrays/arrayLists/RemovingItems.txt";
			break;
		// **********************************************
		// **********************************************
		// **********************************************
			
		// **********************************************
		// ******* ADVANCED LOOPING CHALLENGES **********
		// **********************************************	
		case "For Loop Array":
			header = "Looping through an Array - For Loop";
			description = "<br /><h4>Description:</h4>"+
					 "<p>Since you already know how to use \"for loops\", how to get an element out of an array, and how to get the length of an array, you now have a good basis for learning how to loop through an array. If you need to review \"for loops\", go back to the CS 175 section and look for \"for loops\". If you need to review the length property, go back to the CS 176 section, click on \"arrays\" and then \"arrayBoundsAndLength\". One of the most common use cases of a for loop is to loop through an array. Here is an example of how to print the contents of an array:</p>"+
		 			 "<pre>String[] groceries = {\"Milk\", \"Eggs\", \"Bread\"};<br />"+
		 			 "for(int i = 0; i < groceries.length; i++) {<br />"+
		 			 "&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(groceries[i]);<br />"+
		 			 "}<br />"+
		 			 "<br />"+
		 			 "OUTPUT:<br />"+
		 			 "Milk<br />"+
		 			 "Eggs<br />"+
		 			 "Bread</pre>"+
		 			 "<p>As you can see, we iterate with the For loop up to groceries.length, ensuring that we stay within the array's bounds. Using the length property also allows us to create more maintainable code because if we decided to add another item to our array, the For loop stays the same.</p>"+
		 			 "<br /><h4>Challenge:</h4>"+
		 			 "<p>For your challenge, we have created an array called \"myNums\":</p>"+
		 			 "<pre>double[] myNums = {...};</pre>"+
		 			 "<p>For testing purposes, we have hidden the numbers from you. We have also provided a method called \"resetPi\".</p>"+
		 			 "<p>It is your task to look through the array \"myNums\", and set any value equal to pi to 0.</p>"+
		 			 "<p>NOTE: You should use Math.PI for this challenge.</p>";
			boilerplate = "public void resetPi(double[] myNums) {\n"+
				 		"    // ENTER CODE BELOW\n\n\n\n\n\n"+
				 		"    // DON'T CHANGE THIS LINE\n"+
				 		"    test(myNums); // TESTING YOUR CODE\n"+
			 			"}";
			filePath = "static/cs176/advancedLooping/ForLoopArray.txt";
			break;
		case "While Loop Array":
			header = "Looping through an Array - While Loop";
			description = "<br /><h4>Description:</h4>"+
					"<p>You can also implement the same logic from last challenge's example with while loops:</p>"+
					"<pre>String[] groceries = {\"Milk\", \"Eggs\", \"Bread\"};<br />"+
					"<br />"+
					"int i = 0;<br />"+
					"while(i < groceries.length) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(groceries[i]);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;i++;<br />"+
					"}<br />"+
					"<br />"+
		 			"OUTPUT:<br />"+
		 			"Milk<br />"+
		 			"Eggs<br />"+
		 			"Bread</pre>"+
					"<p>As you can see, there is a bit more work required than if we used a For Loop. This type of while loop is quite common which is why we use for loops to write shorter and more readable code. The only time we might use a while loop with an array is when we need to get user input, as we will explore in later challenges.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, you will implement the same code from last challenge but this time using a While loop. we have created an array called \"myNums\":</p>"+
					"<pre>double[] myNums = {...};</pre>"+
					"<p>For testing purposes, we have hidden the numbers from you. It is your task to look through the array \"myNums\", and set any value equal to pi to 0.</p>"+
					"<p>NOTE: You should use Math.PI for this challenge.</p>";		
			filePath = "static/cs176/advancedLooping/WhileLoopArray.txt";
			break;
		case "Max In Array":
			header = "Getting the Max Value in an Array";
			description = "<br /><h4>Description:</h4>"+
					"<p>It is a common exercise to find the max value in an array when you are first starting to learn how to loop through arrays.</p>"+
					"<p>To find the max value in an array, you must first create a variable outside of the loop that will hold the max value. This will usually start at 0 or at the first value in the array. Next, for each iteration of the loop, you are checking if the value of the array at that iteration is greater than max. If so, assign that value to max.</p>"+
					"<p>No code example this time, see if you can use the explanation we just gave you and convert it into code.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created an array called \"myNums\":</p>"+
					"<pre>double[] myNums = {...};</pre>"+
					"<p>For testing purposes, we have hidden the numbers from you. It is your task to find the max value in this array using a loop.</p>"+
					"<p>NOTE: The name of your max variable must be called \"max\" and it must be a double.</p>";
			filePath = "static/cs176/advancedLooping/MaxInArray.txt";
			break;
		case "Average Of Array":
			header = "Getting the Average Value in an Array";
			description = "<br /><h4>Description:</h4>"+
					"<p>This challenge will combine some of the concepts you've learned in previous lessons and help you retain what you've learned so far about arrays and loops.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created an array called \"testScores\":</p>"+
					"<pre>int[] testScores = {...};</pre>"+
					"<p>There are some test scores in the array, and it is your task to write a method that returns the average of the test scores. If you need a refresher on writing methods, go back to the CS 175 section and look for \"Methods\". The method will be a public method that returns an int.</p>"+
					"<p>NOTE: the method must be called \"average\", return an int, and be public. It will take an array of ints as its only parameter.</p>";
			filePath = "static/cs176/advancedLooping/AverageOfArray.txt";
			break;
		case "Enhanced For Loop":
			header = "Using Enhanced For Loop";
			description ="<br /><h4>Description:</h4>"+ 
					"<p>There is another way of writing For Loops in Java called \"Enhanced For Loops\":</p>"+
					"<pre>int[] testScores = {90, 89, 78, 94, 53};<br /><br />"+
					"for(int score: testScores) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(score);<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"90<br />"+
					"89<br />"+
					"78<br />"+
					"94<br />"+
					"53</pre>"+
					"<p>This is the same as writing:</p>"+
					"<pre>for(int score = 0; score < testScores.length; score++) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(testScores[score]);<br />"+
					"}</pre>"+
					"<p>They are alternatively known as \"For Each Loops\" in other programming languages because they iterate through each item in a collection.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, convert the following For loop into an Enhanced For loop:</p>"+
					"<pre>for(int score = 0; score < testScores.length; score++) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;total += testScores[score];<br />"+
					"}</pre>"+
					"<p>NOTE: we're not going to test if you're using an Enhanced For loop or not, but it is something you should know about and you might like it better than using a For loop in some cases.</p>";
			filePath = "static/cs176/advancedLooping/EnhancedForLoop.txt";
			break;
			// **********************************************
			// ********** ADVANCED LOOPING PROJECTS**********
			// **********************************************
//		case "BasketballPlayer Part 4":
//			header = "BasketballPlayer Part 4 - The BasketballPlayer Class";
//			description = "<br /><h4>Description:</h4>"+ 
//					"<p>You will use what you've learned in the last couple of sections to complete the Basketball program. The end goal is a program that can calculate a team's statistics from its players at the end of a game. We first need to do some setup with the BasketballPlayer class. We want to be able to calculate a team's total points, rebounds, and assists from its players which requires us to first get each player's points, rebounds, and assists.</p>"+
//					"<br /><h4>Challenge:</h4>"+
//					"<p>We've created the class and fields, it is your task to create the getter methods for the fields.</p>";
//			
//			boilerplate = "// DON'T CHANGE THIS CODE\n"+
//						 "static class BasketballPlayer {\n"+
//						 "    private int points;\n"+
//						 "    private int rebounds;\n"+
//						 "    private int assists;\n\n"+
//						 "    public BasketballPlayer(int points, int rebounds, int assists) {\n"+
//						 "        this.points = points;\n"+
//						 "        this.rebounds = rebounds;\n"+
//						 "        this.assists = assists;\n"+
//						 "    }\n\n"+
//						 "    public double getPoints() {\n"+
//						 "        // ENTER CODE BELOW\n\n"+
//						 "    }\n\n"+
//						 "    public double getRebounds() {\n"+
//						 "        // ENTER CODE BELOW\n\n"+
//						 "    }\n\n"+
//						 "    public double getAssists() {\n"+
//						 "        // ENTER CODE BELOW\n\n"+
//						 "    }\n\n"+
//						 "}";
//			filePath =  "static/cs176/advancedLooping/projects/BasketballPlayerPart4.txt";
//			break;
//		case "BasketballPlayer Part 5":
//			header = "BasketballPlayer Part 5 - The Team Class";
//			description = "<br /><h4>Description:</h4>"+ 
//					"<p>Now we can move on to the Team class. For our program, we want to be able to get the total points, rebounds, and assists after a game by getting those statistics from our player objects.</p>"+
//					"<br /><h4>Challenge:</h4>"+
//					"<p>This challenge might be harder than anything you've done so far, which is why we've implemented the first method for you. It is your task to create the other two methods needed for the Team class.</p>";
//			boilerplate = "// DON'T CHANGE THIS CODE\n"+
//						 "static class Team {\n"+
//						 "    private BasketballPlayer[] players;\n\n"+
//						 "    public Team(BasketballPlayer[] players) {\n"+
//						 "        this.players = players;\n"+
//						 "    }\n\n"+
//						 "    public double totalPoints() {\n"+
//						 "        double teamPoints = 0;\n"+
//						 "        for(int i = 0; i < players.length; i++) {\n"+
//						 "            teamPoints += players[i].getPoints();\n"+
//						 "        }\n"+
//						 "        return teamPoints;\n"+
//						 "    }\n\n"+
//						 "    public double totalRebounds() {\n"+
//						 "        // ENTER CODE BELOW\n\n"+
//						 "    }\n\n"+
//						 "    public double totalAssists() {\n"+
//						 "        // ENTER CODE BELOW\n\n"+
//						 "    }\n"+
//						 "}";
//			filePath = "static/cs176/advancedLooping/projects/BasketballPlayerPart5.txt";
//			break;
//		case "BasketballPlayer Part 6":
//			header = "BasketballPlayer Part 6 - Finishing Up";
//			description = "<br /><h4>Challenge:</h4>"+
//					"<p>Finally, it is time to create our team. You can create as many player objects as you like but they must have only the number of points, rebounds, and assists as arguments. Afterwards, you must create an array of type BasketballPlayer and put your player objects in the array. Finally, create a Team object called \"myTeam\" with your array of players as a constructor argument.</p>";
//			filePath = "static/cs176/advancedLooping/projects/BasketballPlayerPart6.txt";
//			break;
		case "Shop Part 6":
			header = "Shop Part 6 - Calculating the subtotal";
			description = "<br /><h4>Description:</h4>"+
						"<p>Now that you know how to loop through an array, we can finally complete our Shop program! Getting the subtotal is the trickiest part to implement in the CashRegister class. Although, it's nothing that you haven't seen already.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>For your challenge, create the getSubtotal() method. For the getSubtotal method, you're going to first create a variable to hold the total. Then loop through the CashRegister's array of items, and get the cost of each item times the item's quantity which gets added to the total. Finally, return the total.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						  "static class CashRegister {\n"+
						  "    private Item[] items;\n"+
						  "    private final double SALES_TAX = 0.06625;\n"+
						  "    private double subTotal;\n\n"+
						  "    public CashRegister() {\n"+
						  "        subTotal = 0;\n"+
						  "    }\n\n"+
						  "    public CashRegister(Item[] items) {\n"+
						  "        this.items = items;\n"+
						  "    }\n\n"+
						  "    public double getTax() {\n"+
						  "        return SALES_TAX * getSubtotal();\n"+
						  "    }\n\n"+
						  "    // ENTER CODE BELOW\n\n\n\n"+
						  "    public double getTotal() {\n"+
						  "        return getSubtotal() + getTax();\n"+
						  "    }\n"+
						  "}";
			filePath = "static/cs176/advancedLooping/projects/ShopPart6.txt";
			break;
		case "Shop Part 7":
			header = "Shop Part 7 - Finishing up";
			description = "<br /><h4>Description:</h4>"+
						"<p>As you might have expected, you must now test your program.</p>"+
						"<br /><h4>Challenge:</h4>"+
						"<p>Create an array of Item objects, the number of items can be anything you like. Each Item must have a description, item number, cost, and quantity. Then, create a CashRegister object called \"myCashRegister\" with the array of Item objects as it's constructor argument. Then, print the subtotal and total in any format that you like.</p>";
			filePath = "static/cs176/advancedLooping/projects/ShopPart7.txt";
			break;
		// **********************************************
		// **********************************************
		// **********************************************
			
		// **********************************************
		// ******* EXCEPTION HANDLING CHALLENGES ********
		// **********************************************
		case "Try and Catch":
			header = "Try and Catch";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>In Java, all exceptions are represented by classes. When an exception occurs in Java, an object of some type of exception class is generated. It is recommended to look through Java's documentation for the Throwable class and its subclasses to see what exceptions can occur in your programs. Throwable is the superclass of all errors and exceptions in the Java language.</p>"+
					"<p>A way that we can \"catch\" these exceptions that Java throws is through a try, catch block. Consider the following code:</p>"+
					"<pre>String[] groceries = {\"Milk\", \"Eggs\", \"Bread\"};<br />"+
					"System.out.println(groceries[10]);</pre>"+
					"<p>If you remember one of the lessons from \"arrays\", you'll know that this will result in an exception being thrown, or more accurately, Java generating an IndexOutOfBoundsException object. With a try, catch block, we can put the code that might generate an error within a try block, and the code to run when the exception occurs within a catch block:</p>"+
					"<pre>String[] groceries = {\"Milk\", \"Eggs\", \"Bread\"};<br />"+
					"try {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(groceries[10]);<br />"+
					"} catch(IndexOutOfBoundsException e) { // The type of exception and the object name<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Something went wrong.\");<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"Something went wrong.</pre>"+
					"<p>Now, the program will continue to run even when an exception occurs.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, we have created code that will result in an exception being thrown. Use \"try catch\" to print a custom error message when the exception occurs.</p>"+
					"<p>NOTE: Our compiler might complain about using java.lang.System, so System.out.println() probably won't work. In that case, just leave the catch block empty.</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "int[] myNums = {1, 2, 3};\n\n"+
						 "// ENTER CODE BELOW\n"+
						 "myNums[10] = 10; // PUT THIS IN A TRY BLOCK";
			filePath = "static/cs176/exceptionHandling/TryAndCatch.txt";
			break;
		case "Custom Exceptions":
			header = "Custom Exceptions";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>In Java, there are two types of exceptions you should know about: checked and unchecked. Checked exceptions are checked at compile time and represent a problem that the user knows can happen. Checked exceptions must be checked either with a try, catch block or a throws clause which we will talk about in an upcoming lesson. Checked exceptions extend the Exception class.</p>"+
					"<p>Unchecked exceptions are not checked by the compiler and represent unexpected problems at runtime. Unchecked exceptions do not force the user to check for them and are usually caused by bad code. We saw last lesson how we can catch the IndexOutOfBoundsException object but it is usually better to fix the code that is causing the exception. Unchecked exceptions extend the RuntimeException class.</p>"+
					"<p>Since Exception and RuntimeException are Java classes, it is easy to create our own custom exceptions that are meaningful. To create a checked exception, we extend the Exception class and override the desired constructors. All of Exception's constructors are listed in Java documentation.</p>"+
					"<pre>class MyException extends Exception {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;public MyException(String message) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;super(message);<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>We can then throw the exception where we expect it may occur. For your challenge, create the custom checked exception \"ListItemNotFoundException\" with the constructor that takes in a String for the exception message.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, create the custom checked exception \"ListItemNotFoundException\". </p>";
			boilerplate = "static class ListItemNotFoundException {\n\n\n\n"+
					 	"}";
			filePath = "static/cs176/exceptionHandling/CustomExceptions.txt";
			break;
		case "Throw":
			header = "Throw";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>We saw in the previous lesson how we can extend either the Exception or RuntimeException classes to create our own exceptions. In order to actually throw the exception, we can use the throw keyword:</p>"+
					"<pre>try {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;if(!desiredResult) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;throw new MyException(\"This is an example\");<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"} catch(MyException e) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();<br />"+
					"}</pre>"+
					"<p>As you can see, the throw keyword lets us throw our custom exception anywhere in the program. It can also throw any checked or unchecked exceptions.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, you will throw the ListItemNotFoundException you created when the list item is not found.</p>";
			boilerplate = "try {\n"+
					 "    // DON'T CHANGE THIS LINE\n"+
					 "    if(itemNotFound) {\n"+
					 "        // ENTER CODE BELOW\n\n"+
					 "    }\n"+
					 "} catch() {\n\n"+
					 "}";
			filePath = "static/cs176/exceptionHandling/Throw.txt";
			break;
		case "Throws":
			header = "Throws";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>The throws keyword is used in the signature of a method to indicate that the method might throw an exception:</p>"+
					"<pre>static void myMethod() throws MyException {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;...<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;throw new MyException();<br />"+
					"}<br /><br />"+
					"public static void main(String[] args) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;try {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;myMethod();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;} catch(MyException e) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.printStackTrace();<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;}<br />"+
					"}</pre>"+
					"<p>When we want to call the method anywhere in our code, we must either wrap the method in a try, catch block or make the method that we are calling the method from also throw the exception.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, change the method signature below so that it throws the ListItemNotFoundException class you created, and then make it throw the exception.</p>";
			boilerplate = "public void searchList() {\n\n\n"+
						"}";
			filePath = "static/cs176/exceptionHandling/Throws.txt";
			break;
		case "Finally":
			header = "Finally";
			description = "<br /><h4>Description:</h4>"+ 
					"<p>In Java, we can have multiple catch statements:</p>"+
					"<pre>try {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;...<br />"+
					"} catch(ExceptionType1 exObj1) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;...<br />"+
					"} catch(ExceptionType2 exObj2) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;...<br />"+
					"}</pre>"+
					"<p>But in some cases, we want a way to execute code whether an exception is handled or not. We can do that with a finally block:</p>"+
					"<pre>try {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;throw new MyException();<br />"+
					"} catch(MyException e) {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Caught exception.\");<br />"+
					"} finally {<br />"+
					"&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Final block will always be executed.\");<br />"+
					"}<br /><br />"+
					"OUTPUT:<br />"+
					"Caught exception.<br />"+
					"Final block will always be executed.</pre>"+
					"<p>The finally block is also useful for preventing resource leaks, it is a good practice to put cleanup code in a finally block.</p>"+
					"<br /><h4>Challenge:</h4>"+
					"<p>For your challenge, add a finally block after the try block that closes the scanner object. If you don't remember how to do that, the method is just \".close()\";</p>";
			boilerplate = "// DON'T CHANGE THIS CODE\n"+
						 "try {\n"+
						 "    scanner.nextLine();\n"+
						 "}\n"+
						 "// ENTER CODE BELOW\n\n";
			filePath = "static/cs176/exceptionHandling/Finally.txt";
			break;
			// **********************************************
			// **********************************************
			// **********************************************
		}
		challengeText.put("header", header);
		challengeText.put("description", description);
		challengeText.put("boilerplate", boilerplate);
		challengeText.put("filePath", filePath);
		
		return challengeText;
	}
	
}
