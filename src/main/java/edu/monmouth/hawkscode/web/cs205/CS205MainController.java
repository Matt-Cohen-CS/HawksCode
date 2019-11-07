package edu.monmouth.hawkscode.web.cs205;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CS205MainController 
{
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

	public void populateTopics(ModelMap model,  String path, String header, String description, List<String> challenges, List<String> links) 
	{
		model.put("path", path);
		model.put("header", header);
		model.put("description", description);
		model.put("challenges", challenges);
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
		
	// *********************************************
	// ************************************ CLASS II
	// *********************************************
	@GetMapping(value = "/home/cs205/Class II")
	public String classII(ModelMap model)
	{
		String path = "/home/cs205/Class II";
		
		String header = "Classes Part Two";
		String description = "In the first section of Classes you learned the importance of creating a class and setting up the g"
				+ "etters and setters for your instance variables. In this section you will learn different functionalities that classes can do"
				+ " like implementing an interface, abstract classes, generics, and enum. Each of these challenges are more of a learning mechanism"
				+ " than a hard test. To fully understand Java, one most fully understand the capibilities of classes. Each class has built in functions"
				+ " and abilities you must understand and learn how to use effectively.";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Interface"); 
		challenges.add("Abstract"); 
		challenges.add("Enum"); 
		challenges.add("Generic"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// ************************** BINARY SEARCH TREE
	// *********************************************
	@GetMapping(value = "/home/cs205/Binary Search Tree")
	public String binarySearchTree(ModelMap model)
	{
		String path = "/home/cs205/Binary Search Tree";
		
		String header = "Binary Search Trees";
		String description = "<div class=\"introduction\">\n" + 
				"			<p class=\"topic-description\">\n" + 
				  "There are many different situations where a Computer Scientist would need to store their"
				+ " data in a data structure that is not a list or an array. A Binary Search Tree or BST is one of these alternatives."
				+ " <br/><br/>"
				+ " BST's are non-linear. Binary search trees have nodes, much like a linked list.  But instead of references to"
				+ " the next node in the list (and the previous node for doubly linked lists), BSTs have references to a 'left' and a "
				+ " 'right' node.  It is frequently said that nodes in a BST have a 'left' and a 'right' child. <br/><br/>"
				+ " A special property of a BST is the amount of relationship each node can have. Binary being the key term,"
				+ " permits two relationships for each node. This means any node on a BST can have at a maximum two children."
				+ " Moreover, the relationship of a BST is based off of the compareTo() method, but in simple terms a node if it is greater"
				+ " than the root and parent node will go to the right otherwise if it is less than the root and parent the node will go "
				+ " to the left. <br/><br/>A perfectly balanced/full, sorted BST has the run-time complexity of Big O(log n) when searching and inserting. "
				+ " A balanced tree must be 'full'; meaning that every parent node has two children OR it belongs to the second to last "
				+ " 'row' of the tree.  The tree below is not full, since the node 'Emma' does not have a left child.  If 'Landon' were the "
				+ " left child of 'Emma', the tree would be considered full.  Also notice that the tree is not ordered alphabetically.  Unless"
				+ " it is ordered in some other manner, the runtime of the search and insert operations will not be O(logn)."
				+ " </p>"
				+ 
				"<pre><br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| Dave |<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+-------+&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| Trish |&nbsp;&nbsp;&nbsp;&nbsp;| Emma |<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+-------+&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+-----+&nbsp;&nbsp;&nbsp;+-----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| Ann |&nbsp;&nbsp;&nbsp;| Joe |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| Matt |<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+-----+&nbsp;&nbsp;&nbsp;+-----+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;+------+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+------+&nbsp;&nbsp;&nbsp;&nbsp;+--------+<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;| Todd |&nbsp;&nbsp;&nbsp;| Ty |&nbsp;&nbsp;&nbsp;&nbsp;|Linda |&nbsp;&nbsp;&nbsp;&nbsp;| Landon |<br/>" 
				+ "&nbsp;&nbsp;&nbsp;&nbsp;+------+&nbsp;&nbsp;&nbsp;+----+&nbsp;&nbsp;&nbsp;&nbsp;+------+&nbsp;&nbsp;&nbsp;&nbsp;+--------+</pre>" + 
				  ""
				  + "<p> The runtime of the search and  insert functions of a balanced and sorted BST is the reason why they are used quite frequently in certain"
				+ " applications. If the BST is not properly sorted, the worst case scenario for running these methods is Big O(n).  A BST needs to be both"
				+ " full and sorted in order to have its most efficient runtimes.</p>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Binary Search"); 
		challenges.add("Binary Insertion"); 
		challenges.add("Binary Tree Constructor");
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// ********************************* LINKED LIST
	// *********************************************
	@GetMapping(value = "/home/cs205/Linked List")
	public String linkedList(ModelMap model)
	{
		String path = "/home/cs205/Linked List";
		
		String header = "Linked List";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				<h4>Description:</h4> \r\n" + 
				"				<p> \r\n" + 
				"					The ArrayList object (in a very simple sense) can be thought of as a wrapper for a Java array.  On the other hand, a Linked List is not backed by an array, it relies on an inner node object. "
				+ " These inner Node objects allow a more dynamic list to be created.  Since arrays can never change size, ArrayLists must recreate their internal array if a user adds more elements than the array can store.  LinkedLists"
				+ " are convinient since they do not have this downside.  <br/><br/>"
				+ " A Node object will contain instance variables associated with the data they store (e.g. a number, or a String) and a reference to the next (and/or previous) Node in the list.  It will also have"
				+ " getter and setter methods for the data and the variables that reference other Nodes. <br/><br/>"
				+ " Typically, a LinkedList will have at least one instance variable declaring a Node (typically called head).  Doubly LinkedLists will have an instance variable called tail, which is "
				+ " a reference to the last Node in the list. <br/><br/>"
				+ " The power of a LinkedList is in its Node structure.  It only requires us to keep track of the head Node of this list.  When we add new Nodes to the end of the list we use the reference to"
				+ " the head Node, and use the Node class's getNextNode method to repeatedly work our way down the list to the last element.  We then set the last elements next Node as the Node we want to add."
				+ "<br/><br/>" 
				+ 
				"In class, you will be responsible for knowing how to create your own LinkedList and Node classes that work together.  Although in practice, you will be using the LinkedList class from Java Collections Framework. <br/><br/>"
				+ "There are two types of linked list, Singly LinkedLists and Doubly LinkedLists. The Nodes in a  Singly LinkedList only have a reference to the next Node in the List, while the Nodes in a Doubly LinkedList have references"
				+ " to the next and previous elements in the list. <br/><br/>" 
				+ 
			    
				"		<div class=\"sections\"> \r\n" + 
				"		<b>HOW TO CREATE A LINKED LIST</b>\r\n" + 
				"		<section class=\"test\" style=\"float: left; width: 34.4em; height: 22em; padding: 1em; align-content: center; overflow: auto\">\r\n" + 
				"<pre> \r\n" + 
				"VERSION 1 - MANUALLY CREATED | <b>SINGLY LINKED LIST</b>: \r\n" + 
				"\r\n" + 
				"To create a Linked List from scratch a Node reference has to\r\n" + 
				"be created.\r\n" + 
				"To do this 1) reference to the first Node or the head has to be made \r\n" + 
				"within the class and 2) a static subclass called Node has to be created \r\n" + 
				"that defines what the Node can do. \r\n" + 
				"\r\n" + 
				"For a Singly Linked List specifically a method called <i>next</i> is \r\n" + 
				"created to allow for a neighbor Node to be next to a pre-existing Node \r\n" + 
				"to allow the list to be connected on the right side. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b>\r\n" + 
				"	public class SinglyLinkedListV1 \r\n" + 
				"	{\r\n" + 
				"		Node head; \r\n" + 
				"\r\n" + 
				"		static class Node\r\n" + 
				"		{\r\n" + 
				"			int data; // takes in numerical data\r\n" + 
				"			Node next; // has a Node next to it (the right) \r\n" + 
				"			Node (int d) \r\n" + 
				"			{\r\n" + 
				"				data = d; next = null; \r\n" + 
				"			}\r\n" + 
				"		}\r\n" + 
				"	} \r\n" + 
				"\r\n" + 
				"Once the Node reference is created then its contents and its neighbors \r\n" + 
				"can be added. To begin creating a Singly Linked List you first have to \r\n" + 
				"instantiate the LinkedList within the main method. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b>\r\n" + 
				"	public static void main(String [] args)\r\n" + 
				"	{	\r\n" + 
				"		SinglyLinkedListV1 mylist = new SinglyLinkedListV1();\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"When declaring the first Node manually a reference to the \r\n" + 
				"Linked List name has to be made and the method <i>.head</i> is used. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> mylist.head = new Node(1); \r\n" + 
				"\r\n" + 
				"To create a neighbor for the first Node the Node reference is called \r\n" + 
				"and the name of the second Node and so on.  \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> Node second = new Node(2); \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+--head---+      +-second--+      \r\n" + 
				"|  1 |    |      |  2 |    | \r\n" + 
				"+---------+      +---------+      \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"Currently there is no data within each Node. To add data to the you \r\n" + 
				"would call the Node name and type <i>.data</i>= (data). \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	mylist.head.data = 10; \r\n" + 
				"	second.data = 20; \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+--head---+      +-second--+      \r\n" + 
				"|  1 | 10 |      |  2 | 20 | \r\n" + 
				"+---------+      +---------+ \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"To connect each Node the <i>.next</i> method created within the static \r\n" + 
				"Node class is used. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> mylist.head.next = second; \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+--head---+      +-second--+      \r\n" + 
				"|  1 | 10 | ---> |  2 | 20 | \r\n" + 
				"+---------+      +---------+ 	\r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"VERSION 1 - MANUALLY CREATED | <b>DOUBLY LINKED LIST</b>: \r\n" + 
				"\r\n" + 
				"The key difference between a Singly Linked List and a Doubly Linked List\r\n" + 
				"is the ability for the Linked List to go forwards and backwards when \r\n" + 
				"searching for information. The method called <i>prev</i> is created to allow \r\n" + 
				"for this, which allows for a neighbor Node to be next to a pre-existing \r\n" + 
				"Node to allow the list to be connected on the left side.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b>\r\n" + 
				"	public class SinglyLinkedListV1 \r\n" + 
				"	{\r\n" + 
				"		Node head; \r\n" + 
				"\r\n" + 
				"		static class Node\r\n" + 
				"		{\r\n" + 
				"			int data; // takes in numerical data\r\n" + 
				"			Node next; // has a Node next to it (the right) \r\n" + 
				"			Node prev; // has a Node next to it (the left) \r\n" + 
				"			Node (int d) \r\n" + 
				"			{\r\n" + 
				"				data = d; next = null; \r\n" + 
				"			}\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"Once the Node reference is created the same steps to create a Singly Linked \r\n" + 
				"List are followed. Within the main method the Linked List is instantiated \r\n" + 
				"and the Node references are created.  \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b>\r\n" + 
				"	public static void main(String [] args)\r\n" + 
				"	{	\r\n" + 
				"		DoublyLinkedListV1 mylist = new DoublyLinkedListV1();\r\n" + 
				"		mylist.head = new Node(1); \r\n" + 
				"		Node second = new Node(2); \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"To add data within each Node the same steps are followed as if this was a \r\n" + 
				"Singly Linked List. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	mylist.head.data = 10; \r\n" + 
				"	second.data = 20; \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+--head---+      +-second--+      \r\n" + 
				"|  1 | 10 |      |  2 | 20 | \r\n" + 
				"+---------+      +---------+ \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"When linking the Nodes to one another, this is where Singly Linked Lists and \r\n" + 
				"Doubly Linked List differ. For a Doubly Linked List Nodes have to be connected \r\n" + 
				"both on the left and right sides of each Node.  \r\n" + 
				"\r\n" + 
				"When declaring the head Node a null (empty) Node is placed previous to it to \r\n" + 
				"indicate this is the beginning of the list and that nothing exists before this\r\n" + 
				"point in the list. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> mylist.head.prev = new Node(0); \r\n" + 
				"\r\n" + 
				"Then all other Nodes are linked accordingly. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b>\r\n" + 
				"mylist.head.next = second;\r\n" + 
				"second.prev = mylist.head; \r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"<i>n = next | p = prev</i> \r\n" + 
				"\r\n" + 
				"+--head---+ -n-> +-second--+      \r\n" + 
				"|  1 | 10 |      |  2 | 20 | \r\n" + 
				"+---------+ <-p- +---------+\r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"</pre>\r\n" + 
				"	</section>\r\n" + 
				"	<section class=\"test\" style=\"float: right; width: 34.4em; height: 22em; padding: 1em; align-content: center; overflow: auto;\">\r\n" + 
				"<pre> \r\n" + 
				"VERSION 2 - JAVA COLLECTIONS | <b>SINGLY &#38; DOUBLY LINKED LIST</b>: \r\n" + 
				"\r\n" + 
				"When creating a Linked List using Java Collections the same process is used \r\n" + 
				"for both Singly and Doubly Linked List.\r\n" + 
				"\r\n" + 
				"1) The LinkedList has to be instantiated within the main method. Also when \r\n" + 
				"creating the linked list the variable type it contains has to be declared. \r\n" + 
				"In this case itâ€™s string variables. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	public class SinglyLinkedListV2 \r\n" + 
				"	{\r\n" + 
				"		public static void main(String[] args) \r\n" + 
				"		{\r\n" + 
				"			LinkedList<String> mylist = new LinkedList<String>(); \r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"2) Elements can now be added. To do this a reference to the next node does \r\n" + 
				"not need to be created this is taken care of by Java Collections. \r\n" + 
				"\r\n" + 
				"â–¶If a Node is created with a position and content the Node within the \r\n" + 
				"Linked List will go in the position it is allocated for even if it is\r\n" + 
				"written out of order within the code.\r\n" + 
				"\r\n" + 
				"<i>Linked List Name</i>.add(<i>position</i>, <i>content</i>); \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	mylist.add(1, \"First\");\r\n" + 
				"	mylist.add(3, \"Third\");\r\n" + 
				"	mylist.add(2, \"Second\"); \r\n" + 
				"\r\n" + 
				"	OUTPUT: [Frist, Second, Third]\r\n" + 
				"	\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+-----------+      +------------+      +-----------+\r\n" + 
				"| 1 | First | ---> | 2 | Second | ---> | 3 | Third |\r\n" + 
				"+-----------+      +------------+      +-----------+\r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"â–¶If a Node is created with just content, the Linked List will populate \r\n" + 
				"the Nodes in whatever order the Nodes we write in within the code. \r\n" + 
				"\r\n" + 
				"<i>Linked List Name</i>.add(<i>content</i>); \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	mylist.add(\"First\");\r\n" + 
				"	mylist.add(\"Third\");\r\n" + 
				"	mylist.add(\"Second\");\r\n" + 
				"	\r\n" + 
				"	OUTPUT: [Frist, Third, Second]\r\n" + 
				"	\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+-----------+      +-----------+      +------------+\r\n" + 
				"| 1 | First | ---> | 2 | Third | ---> | 3 | Second |\r\n" + 
				"+-----------+      +-----------+      +------------+\r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"â–¶ Nodes can also be declared within the First and Last positions of the \r\n" + 
				"Linked List without a position being declared. \r\n" + 
				"\r\n" + 
				"<b>EXAMPLE CODE:</b> \r\n" + 
				"	mylist.addFrist(\"First\"); \r\n" + 
				"	mylist.addLast(\"Second\");\r\n" + 
				"	\r\n" + 
				"	mylist.add(\"Third\"); \r\n" + 
				"	mylist.add(\"Fourth\"); \r\n" + 
				"	\r\n" + 
				"	OUTPUT: [Frist, Third, Fourth, Second]\r\n" + 
				"	\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"\r\n" + 
				"+-----------+      +-----------+     +------------+      +------------+\r\n" + 
				"| 1 | First | ---> | 2 | Third | --->| 3 | Fourth | ---> | 4 | Second |\r\n" + 
				"+-----------+      +-----------+     +------------+      +------------+\r\n" + 
				"\r\n" + 
				"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\r\n" + 
				"</pre>\r\n" + 
				"	</section>		\r\n" + 
				"	</div> <!-- end div class =\"section\" -->";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Singly Linked List"); 
		challenges.add("Doubly Linked List"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs205/Linked List/Singly Linked List")
	public String singlyLinkedList(ModelMap model)
	{
		String path = "/home/cs205/Linked List/Singly Linked List";
		
		String header = "Singly Linked List";
		String description = "";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Singly Linked List V1"); 
		//challenges.add("SinglyLinkedListV2"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs205/Linked List/Doubly Linked List")
	public String doublyLinkedList(ModelMap model)
	{
		String path = "/home/cs205/Linked List/Doubly Linked List";
		
		String header = "Doubly Linked List";
		String description = "";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Doubly Linked List V1"); 
		//challenges.add("DoublyLinkedListV2"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// **************************************** SORT
	// *********************************************
//	@GetMapping(value = "/home/cs205/Sort")
//	public String sort(ModelMap model)
//	{
//		String path = "/home/cs205/Sort";
//		
//		String header = "";
//		String description = "";
//		
//		List<String> challenges = new LinkedList<>();
//		challenges.add("MergeSort"); 
//		challenges.add("HeapSort"); 
//		challenges.add("QuickSort"); 
//		challenges.add("BubbleSort"); 
//		challenges.add("InsertionSort"); 
//		challenges.add("SelectionSort"); 
//		
//		List<String> links = new LinkedList<>();
//		
//		populateTopics(model, path, header, description, challenges, links);
//		return "b-topics";
//	}
//	
	// *********************************************
	// ***************************************** MAP
	// *********************************************
	@GetMapping(value = "/home/cs205/Map")
	public String map(ModelMap model)
	{
		String path = "/home/cs205/Map";
		
		String header = "I'm the Map!";
		String description = "<div class=\"introduction\">\n" + 
				"			<p class=\"topic-description\">\n" + 
					"Maps in Java do not"
				+ " function so similarly to a generic Map you might have seen. Maps are used for key-value representation and allow the"
				+ " <i>Mapping</i> of keys to values. Each Map we will discuss either implement Map or SortedMap (implement in Java is a specific term,"
				+ " any time this comes up in documentation it usually refers to interfaces) there are 3 we will discuss and each function"
				+ " differently then the rest. The first we will look at is TreeMap, Tree Maps are sorted in ascending"
				+ " order based on the natural ordering of the keys (natural ordering is based on the Comparable interface and the implementation of"
				+ " the compareTo() method). The next Map we will discuss is HashMap, Hash Maps are not ordered and a HashMap stores Key-Values based on the Hashing of Keys (this will be explained more in the challenge). "
				+ " The last Map is the LinkedHashMap, just as its name suggests LinkedHashMap is"
				+ " very similar to HashMap. This Maps' main difference is that it orders by insertion. Moreover, like the HashMap, each Key is given a hash."
				+ " In the challenges we will discuss how each Map/SortedMap works internally and go over crucial details to understand. "
				+ "One other point to recognize between"
				+ " each of the Maps is the time-complexity or Big O. Both HashMap and LinkedHashMap are Big O(1) for lookup and insertion while TreeMap"
				+ " is Big O(log n). The main points of Maps is to understand Key-Value relationships, each of these Maps have distinctions and"
				+ " depending on the work you are doing, one Map may be best to use rather than another.</p>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Linked HashMap Data Structure");
		challenges.add("TreeMap Data Structure"); 
		challenges.add("HashMap Data Structure"); 

		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// *********************************** RECURSION
	// *********************************************
	@GetMapping(value = "/home/cs205/Recursion")
	public String recursion(ModelMap model)
	{
		String path = "/home/cs205/Recursion";
		
		String header = "Recursive Algorithms";
		String description = "<div class=\"introduction\">\n" + 
				"			<p class=\"topic-description\">\n" + 
				"				<h4>Description:</h4> \r\n" + "Recursion is a very dicey subject in the Computer Science world. Some will stand by its every use"
				+ " while others will hate if it is ever used, but one thing is constant, recursion is something every Computer Scientist"
				+ "should know. So what is it? Recursion, in Java terms, is when a method calls on itself. This may seem daunting "
				+ "but is actually a very simple concept. For example,"
				+ "<pre>public int factorial(int n)\n{"
				+ "	if(n<=1){\n"
				+ "    return 1;\n"
				+ "}"
				+ "else{\n"
				+ "    return n*factorial(n-1);\n"
				+ "}\n"
				+ "}</pre>"
				+ "\nIn the above code the method factorial is a recursive algorithm to compute the factorial of a number."
				+ " Every recursive algorithm has a base case, in the case above it is if the number is less than or equal to one."
				+ " This base case is used to represent the problem in smaller terms that every number will inevitably reach to."
				+ " So, if given the number 5, eventually the n-1 will make n, 1 and the algorithm will hault. Bases cases are ext"
				+ " remely important to control a recursive algorithm and they help prevent stack overflow errors, which is the main"
				+ " issue with recursion. StackOverFlowErrors occur when the JVM stack cannot allocate anymore memory."
				+ " To reduce this possibility, limit your use of recursion"
				+ " to problems that have a finite possibility. For example, tree traversal is a great example of the benefits of recursion."
				+ " This case has a finite possibility(the size of the tree) and recursion is one of the best solutions to solving your problem."
				+ " In the example above, recursion is a great choice to find the factorial of a number; however, if given a large enough"
				+ " number you have the risk of a StackOverFlowError. </p>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Tree Traversal"); 
		challenges.add("Factorial"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs205/Recursion/Tree Traversal")
	public String treeTraversal(ModelMap model)
	{
		String path = "/home/cs205/Recursion/Tree Traversal";
		
		String header = "Tree Traversal";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				<h4>Description:</h4> \r\n" + 
				"				<p> \r\n" + 
				"					Unlike linear methods which only have one way of traversing through a sorted list of elements, Tree have multiple ways to traverse through a sorted list of elements. To traverse through a tree, Tree Traversal, there are three methods used, Inorder Traversal, Preorder Traversal, and Postorder Traversal. \r\n" + 
				"\r\n" + 
				"					<p class=\"description\" style=\"margin-left: 2em\">\r\n" + 
				"						HINT: When traversing through a Binary Search Tree (BST) it is common to start from the top left and work you way through the elements within the tree. Another thing to remember is to picture three symbols representing Preorder (left), Inorder (middle), and Postorder (right) at the top of each Node. Draw a line to connect the dots of each kind.\r\n" + 
				"					</p>\r\n" + 
				"			\r\n" + 
				"					<p class=\"description\">\r\n" + 
				"						> Left: left of the tree <br>\r\n" + 
				"						> Root: the 1st number (Node) within the tree where all the elements stem from.  <br>\r\n" + 
				"						> Right: right of the tree\r\n" + 
				"					</p>\r\n" + 
				"				</p> \r\n" + 
				"			\r\n" + 
				"				<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					Preorder Traversal:\r\n" + 
				"				</b>[ root to left to right ] Used to recreate the BST from root element to children elements.\r\n" + 
				"\r\n" + 
				"				<br> <b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					Inorder Traversal:\r\n" + 
				"				</b>[ left to root to right ] When traversing through a BST using the Inorder method do note that the numbers will not appear in sequential order.\r\n" + 
				"		\r\n" + 
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					Postorder Traversal:\r\n" + 
				"				</b>[ left to right to root ] Used to delete/print the tree from children elements to parent elements.\r\n" + 
				"			</p> \r\n" + 
				"		</div> \r\n" + 
				"";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Inorder"); 
		challenges.add("Preoder"); 
		challenges.add("Postorder"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// ****************************** BIG O NOTATION
	// *********************************************
	@GetMapping(value = "/home/cs205/Big O Notation")
	public String bigONotation(ModelMap model)
	{
		String path = "/home/cs205/Big O Notation";
		
		String header = "Big O Notation";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				<h4>Description:</h4> \r\n" + 
				"				<p> \r\n" + 
				"					Big O is a way for programmers and developers to understand how long an algorithm will take to run. Typically, Big O is used to evaluate how efficient an algorithm is compared to others. We review eight types of run times which are denoted in an algebraic format.  Technically there are more than 8, but"
				+ " these are the most common ones you will encounter. This format is called Big O Notation."
				+ "                 <br/><br/>  Typically, Big O format has a variable, called n.  This n is to represent the size of the data structure that is used during the algorithm.  So if we have an algorithm that runs in O(n) time (linear time), then we can say that increasing the size of our data structure will "
				+ "                 increase the runtime of the algorithm in a linear fashion.  The algorithm might take 3 times longer, or even 1000 times longer, but both cases are slower by a linear degree.  This is one of the most difficult concepts to grasp as an undergraduate, so we will break it down a bit further. Let us"
				+ "                 think of a quick 'real world' example.  <br/><br/>Imagine we are at a super market with a list of groceries we would like to get. We can evaluate the runtime of the most effective way to select the "
				+ "items we want based off the size of our list (n).  <br/><br/>If we walked into the store and all of the items on our list magically appeared in our cart, our runtime of getting our items would be constant O(1)--"
				+ " i.e. increasing the size of our list will not tremendously increase the runtime of our shopping experience. <br/><br/>"
				+ " Now imagine shopping the 'traditional' way, where you look at the item at the top of your list, walk to its location in the store, and put it in your cart.  This would have a runtime of O(n)--linear time.  <br/><br/>To draw on our previous point imagine we have 4 items in our list, and it takes 3 minutes to get each of those items for a total of 12 "
				+ " minutes in the store.  If we increase the size of our list to 8, we have a total store time of 24 minutes.  If we had increased our list to 1000 items, then we would have a store time of 3000 minutes. We can see how increasing the size of our list increases the runtime of our shopping experience by a linear amount.  If it took us 1000 minutes to get each of the 4 items (total 4000 minutes), and we then increased the size of our"
				+ " list to 8 (total 8,000 minutes), our algorithm would still be considered to have a linear running time since an increase in the size of the list increases the runtime by a linear amount.  While 12 minutes in store is significantly less time than 4000 minutes, the two algorithms are considered to have the same Big O runtime due to how the"
				+ " additional items in our list increase our time in the store by a linear amount. <br/><br/>"
				+ " Finally, imagine we shop in a very peculiar manner.  Say that for each item on our list we walk to its place in the store and put it in our basket as normal, but before we go to the next item in our list we go outside and walk around the perimeter of the store an amount of times equal to the amount of items on the list. <br/><br/>If we have 4 items on our list"
				+ ", and it takes 3 minutes to walk the perimeter of the store (for simplicity we reduce the time it takes to walk to the item to 0), then we would have 48 minutes of store time.  We break this down by noticing we have 4 items on our list and for each of those items we have to walk around the store 4 times at 3 minutes each.  Thus, we have 4 * 4 * 3 or 3(4<sup>2</sup>)."
				+ " Now imagine we increase the amount of items on our list to 8--for each of the 8 items, we walk around the store 8 times at 3 minutes each.  Thus we have 8 * 8 * 3, or 3(8)<sup>2</sup>, for a total of 192 minutes.  We call this case of runtime O(n<sup>2</sup>).  <br/><br/>Finally, imagine we had increased the the number of items on our list to 1000 for our O(n<sup>2</sup>) shopping time.  We would spend 3(1000<sup>2</sup>)"
				+ ", or 3,000,000 minutes in the store!  Compare this to when we had 1000 items in our list for the O(n) algorithm, which took 3,000 minutes.  This is 5.7 years compared to 50 hours!!!  The importance of Big O runtimes should be clear! <br/><br/> Below, we detail the different classes of Big O runtimes: <br/><br/>"
				+ "\r\n </p>" + 
				"			     \r\n" +
				
				"				<b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(1): \r\n" + 
				"				</b> "
				+ "             <p class=\"description\" style=\"margin-left: 7em\"> Runtime is constant. This is the quickest running algorithm--its run time does not depend on the size of the data structure you are working with.  An example of this is getting an element from a Java array. \r\n" + 
				"\r\n           </p>" + 		
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(log n):\r\n" + 
				"				</b>"
				+ "				<p class=\"description\" style=\"margin-left: 7em\"> Logarithmic runtime.  This is quicker than linear time.  Typically, these algorithms only use a subsection of the data structure you are working with. An example of this is searching for a value in a Binary Search Tree.\r\n" + 
				"\r\n </p>" + 
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(n):\r\n" + 
				"				</b> "
				+ " <p class=\"description\" style=\"margin-left: 7em\"> Linear runtime. An example of this is searching for an element in a Linked List.\r\n" + 
				"\r\n </p>" + 
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(n log n):\r\n" + 
				"				</b> "
				+ "<p class=\"description\" style=\"margin-left: 7em\"> The most efficient sorting algorithms are in this runtime.  An example of this Merge Sort and Quick Sort.  \r\n" + 
				"\r\n </p>" + 
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(n<sup>2</sup>):\r\n" + 
				"				</b> "
				+ "<p class=\"description\" style=\"margin-left: 7em\"> One of the slower Big O run times. An example of this is an Bubble Sort and Insertion Sort. \r\n" + 
				"				\r\n </p>" + 
				"<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
						"					O(n<sup>3</sup>):\r\n" + 
						"				</b> "
						+ "<p class=\"description\" style=\"margin-left: 7em\"> Some algorithms that operate on matrices are in O(n<sup>3</sup>) time. "
						+ "  Algorithms where the exponent is greater than 3 are uncommon.\r\n" + 
						"				\r\n </p>" +
				"				<br><b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(2<sup>n</sup>):\r\n" + 
				"				</b> <p class=\"description\" style=\"margin-left: 7em\"> This is dangerous; one of the worst possible run times. Some recursive algorithms run at this time.\r\n" + 
				"			\r\n </p>" + 
				"				<br> <b class=\"section\" style=\"margin-left: 5em\">\r\n" + 
				"					O(n!):\r\n" + 
				"				</b> <p class=\"description\" style=\"margin-left: 7em\"> This is the worst possible run time. The traveling salesman is an example of an algorithm with this runtime.  \r\n" + 
				"			</p> \r\n" + 
				"		</div>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Sort");
		challenges.add("Big O Notation Questions");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Sort")
	public String bigONotationSort(ModelMap model)
	{
		String path = "/home/cs205/Big O Notation/Sort";
		
		String header = "Sort";
		String description = "<div class=\"introduction\">\r\n" + 
				"			\r\n" + 
				"				<p class=\\\"topic-description\\\">\r\n" + 
				"				 \r\n" + 
				"				"
				+ "Sorting data is a very important computer science problem.  While it sounds trivial, many sorting algorithms would take an"
				+ " incredibly long time to complete with large data sets.  Companies like Google and Facebook deal with trillons of bits of "
				+ " data each day, and sorting through this data quickly is key to have their sites both popular and usable."
				+ "Here, we discuss the most popular sorting algorithms.  We do not offer challenges to write your own sorting algorithms"
				+ " , this code will be provided or assigned as homework by your instructor.</p>" + 
				"			    \r\n" + 
				"			<b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"				Merge Sort: " + 
				"			</b>\r\n" + 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" + 
				"				 Similar to Quick Sort, a Merge Sort is a recursive algorithm that separates the list into two halves until it is reduced to its base units.  When the recursive calls return, a "
				+ "              merge step is initiated, which sorts the smaller halves, not the entire list at once. The ending result is a sorted list of elements. " + 
				"			</p>\r\n" +
				
				"			</p> \r\n" + 
				"		 \r\n" + 
				"		" + 
				"			\r\n" + 
				"				\r\n" + 
				"					\r\n" + 
				"			    <b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"					Heap Sort: \r\n" + 
				"				</b>"
				+ 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" +
				"				Heap Sort is a two step algorithm.  First, it creates a heap out of the list of values that you are sorting.  Then it will swap the minimum or maximum (depending on if you want to sort in decending or ascending order)"
				+ "             of the heap to the end of the list.  This process repeats until the list is sorted.\r\n" + 
				"				\r\n" + 
				"				Big O Notation: O(n log n)\r\n" + 
				"				</p>\r\n" + 
				"			\r\n" + 
				"			" + 
				"				<b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"					Quick Sort: \r\n" + 
				"				</b>"
				+ 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" +
				"				Quick Sort is similar to Merge Sort. Instead of splitting the array down the middle though, a pivot point is selected and the list is separated at that point. Selecting a pivot point is still an active topic of"
				+ "             research.  Having the pivot be different than the center of the list can potentially have the algorithm run faster on partially sorted lists.  However, this can also make the worst case runtime of the algorithm "
				+ "             to be O(n<sup>2</sup>).  However, most implementations of Quick Sort run at O(n log n)." + 
				"				\r\n" + 
				"				Big O Notation: O(n log n)\r\n" + 
				"				</p>\r\n" + 
				"			" + 
				"				<b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"					Buble Sort: \r\n" + 
				"				</b>"
				+ 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" +
				"				Bubble Sort is the simplest sorting method. Bubble Sort looks at the first element in the list and swaps it with the next element"
				+ "            in the list if the first element is larger (or smaller if you are sorting in descending order). Then the second and third elements are compared in the"
				+ "            same way.  This process continues until the largest (or smallest) element is in the last position of the list. The first element of the list is then compared"
				+ "            to the second element again and the process is repeated until a sorted list remains. \r\n" + 
				"				\r\n" + 
				"				Big O Notation: O(n^2)\r\n" + 
				"				</p>\r\n" + 
				"			\r\n" + 
				"			 \r\n" + 
				"				<b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"					Insertion Sort: \r\n" + 
				"				</b>"
				+ 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" +
				"				Within Insertion Sort, starting from the first element within the array, each element is compared to the next element to the right of it. If the element A is smaller than the element B (which is to the right of element A) then element A remains in its position in the array, if the element A is larger than element B then element A moved to the right of element B. This process is repeated until the entire list has been checked.\r\n" + 
				"				\r\n" + 
				"				Big O Notation: O(n^2)\r\n" + 
				"				</p>\r\n" + 
				"		" + 
				"				<b class=\"section\" style=\"margin-left: 4em\">\r\n" + 
				"					 Selection Sort: \r\n" + 
				"				</b>"
				+ 
				"			<p class=\"description\" style=\"margin-left: 6em\">\r\n" +
				"				Within Selection Sort the smallest element is found and placed at the beginning of the array. This process is repeated until all the elements are sorted.\r\n" + 
				"				\r\n" + 
				"				Big O Notation: O(n^2)\r\n" + 
				"				</p>\r\n" + 
				"			\r\n" + 
				"		</div>";
		
		List<String> challenges = new LinkedList<>();
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	@GetMapping(value = "/home/cs205/Big O Notation/Big O Notation Questions")
	public String  bigONotationQuetions(ModelMap model)
	{
		String path = "/home/cs205/Big O Notation/Big O Notation Questions";
		
		String header = "Big O Notation Questions";
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				<h4>Description:</h4> \r\n" + 
				"				<p>These question give you code snippets.  It is your job to determine their"
				+ " Big O runtime.</p> \r\n" + 
				"		</div>";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("Question 1"); 
		challenges.add("Question 2"); 
		challenges.add("Question 3"); 
		challenges.add("Question 4"); 
		challenges.add("Question 5"); 
		challenges.add("Question 6"); 
		challenges.add("Question 7"); 
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}
	
	// *********************************************
	// *********************** TESTING AND DEBUGGING
	// *********************************************
	/*
	 * @GetMapping(value = "/home/cs205/TestingAndDebuging") public String
	 * testingAndDebugging(ModelMap model) { String path =
	 * "/home/cs205/TestingAndDebuging";
	 * 
	 * String header = ""; String description = "";
	 * 
	 * List<String> challenges = new LinkedList<>(); challenges.add("ErrorMessage");
	 * challenges.add("Exceptions"); challenges.add("Assertions");
	 * 
	 * List<String> links = new LinkedList<>();
	 * 
	 * populateTopics(model, path, header, description, challenges, links); return
	 * "b-topics"; }
	 */
	
}
