package edu.monmouth.hawkscode.web.cs176;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import edu.monmouth.hawkscode.web.MainController;

@Controller
public class CS176GetController {
	
	@Autowired
	private MainController mc;

	
	// **********************************************
	// *** OBJECT ORIENTED PROGRAMMING CHALLENGES ***
	// **********************************************
		// **********************************************
		// ************* ACCESS MODIFIERS ***************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Private")
	public String privateAccessModifier(ModelMap model) {
		return mc.getMapping(model, "Private", "cs176", 5);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Public")
	public String publicAccessModifier(ModelMap model) {
		return mc.getMapping(model, "Public", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Protected")
	public String protectedAccessModifier(ModelMap model) {
		return mc.getMapping(model, "Protected", "cs176", 5);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Default")
	public String defaultAccessModifier(ModelMap model) { 
		return mc.getMapping(model, "Default", "cs176", 5);
	}
		// **********************************************
		// ********* ACCESS MODIFIERS PROJECTS **********
		// **********************************************
//	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/BasketballPlayer Part 1")
//	public String basketballPlayerPart1(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 1", "cs176", 20);
//	}
//	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/BasketballPlayer Part 2")
//	public String basketballPlayerPart2(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 2", "cs176", 10);
//	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 1")
	public String shopPart1(ModelMap model) {
		return mc.getMapping(model, "Shop Part 1", "cs176", 20);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 2")
	public String shopPart2(ModelMap model) {
		return mc.getMapping(model, "Shop Part 2", "cs176", 10);
	}	
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 3")
	public String shopPart3(ModelMap model) {
		return mc.getMapping(model, "Shop Part 3", "cs176", 10);
	}
		// **********************************************
		// ***************** STATIC *********************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Variables")
	public String staticVariables(ModelMap model) {
		return mc.getMapping(model, "Static Variables", "cs176", 5);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Methods")
	public String staticMethods(ModelMap model) {
		return mc.getMapping(model, "Static Methods", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Blocks")
	public String staticBlocks(ModelMap model) {
		return mc.getMapping(model, "Static Blocks", "cs176", 9);
	}
		// **********************************************
		// *************** OVERLOADING ******************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Overloading Methods")
	public String overloadingMethods(ModelMap model) {
		return mc.getMapping(model, "Overloading Methods", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Overloading Constructors")
	public String overloadingConstructors(ModelMap model) {
		return mc.getMapping(model, "Overloading Constructors", "cs176", 11);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Using This")
	public String usingThis(ModelMap model) {
		return mc.getMapping(model, "Using This", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Overloading/This With Methods")
	public String thisWithMethods(ModelMap model) {
		return mc.getMapping(model, "This With Methods", "cs176", 7);
	}
	
		// **********************************************
		// *************** INHERITANCE ******************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Extends")
	public String extendsKeyword(ModelMap model) {
		return mc.getMapping(model, "Extends", "cs176", 9);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Overriding")
	public String overriding(ModelMap model) {
		return mc.getMapping(model, "Overriding", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Super")
	public String superKeyword(ModelMap model) {
		return mc.getMapping(model, "Super", "cs176", 9);
	}
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Polymorphism")
	public String polymorphism(ModelMap model) {
		return mc.getMapping(model, "Polymorphism", "cs176", 9);
	}
		// **********************************************
		// ************** NESTED CLASSES ****************
		// **********************************************
	@GetMapping(value = "/home/cs176/Object Oriented Programming/Nested Classes")
	public String nestedClasses(ModelMap model) {
		return mc.getMapping(model, "Nested Classes", "cs176", 11);
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	
	
	// **********************************************
	// ************* ARRAY CHALLENGES ***************
	// **********************************************
	@GetMapping(value = "/home/cs176/Arrays/Instantiating Arrays")
	public String instantiatingArrays(ModelMap model) {
		return mc.getMapping(model, "Instantiating Arrays", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Getting Array Values")
	public String gettingArrayValues(ModelMap model) {
		return mc.getMapping(model, "Getting Array Values", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Setting Array Values")
	public String settingArrayValues(ModelMap model) {
		return mc.getMapping(model, "Setting Array Values", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Literals")
	public String arrayLiteral(ModelMap model) {
		return mc.getMapping(model, "Array Literals", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Bounds And Length")
	public String arrayBoundsAndLength(ModelMap model) {
		return mc.getMapping(model, "Array Bounds and Length", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Multidimensional Arrays")
	public String multidimensionalArray(ModelMap model) {
		return mc.getMapping(model, "Multidimensional Arrays", "cs176", 7);
	}
		// **********************************************
		// ************** ARRAY PROJECTS ****************
		// **********************************************
//	@GetMapping(value = "/home/cs176/Arrays/Projects/BasketballPlayer Part 3")
//	public String basketballPlayerPart3(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 3", "cs176", 20);
//	}
	@GetMapping(value = "/home/cs176/Arrays/Projects/Shop Part 4")
	public String shopPart4(ModelMap model) {
		return mc.getMapping(model, "Shop Part 4", "cs176", 10);
	}
	@GetMapping(value = "/home/cs176/Arrays/Projects/Shop Part 5")
	public String shopPart5(ModelMap model) {
		return mc.getMapping(model, "Shop Part 5", "cs176", 10);
	}
	
		// **********************************************
		// **************** ARRAY LISTS *****************
		// **********************************************
	@GetMapping(value = "/home/cs176/Arrays/Array Lists/Creating Array Lists")
	public String creatingArrayLists(ModelMap model) {
		return mc.getMapping(model, "Creating Array Lists", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Lists/Adding Items")
	public String addingItems(ModelMap model) {
		return mc.getMapping(model, "Adding Items", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Lists/Getting Items")
	public String gettingItems(ModelMap model) {
		return mc.getMapping(model, "Getting Items", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Lists/Changing Items")
	public String changingItems(ModelMap model) {
		return mc.getMapping(model, "Changing Items", "cs176", 13);
	}
	@GetMapping(value = "/home/cs176/Arrays/Array Lists/Removing Items")
	public String removingItems(ModelMap model) {
		return mc.getMapping(model, "Removing Items", "cs176", 11);
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	
	
	
	// **********************************************
	// ******* ADVANCED LOOPING CHALLENGES **********
	// **********************************************
	@GetMapping(value = "/home/cs176/Advanced Looping/For Loop Array")
	public String forLoopArray(ModelMap model) {
		return mc.getMapping(model, "For Loop Array", "cs176", 9);
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/While Loop Array")
	public String whileLoopArray(ModelMap model) {
		return mc.getMapping(model, "While Loop Array", "cs176", 9);
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Max In Array")
	public String maxInArray(ModelMap model) {
		return mc.getMapping(model, "Max In Array", "cs176", 11);
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Average Of Array")
	public String averageOfArray(ModelMap model) {
		return mc.getMapping(model, "Average Of Array", "cs176", 13);
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Enhanced For Loop")
	public String enhancedForLoop(ModelMap model) {
		return mc.getMapping(model, "Enhanced For Loop", "cs176", 9);
	}
		// **********************************************
		// ********** ADVANCED LOOPING PROJECTS**********
		// **********************************************
//	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 4")
//	public String basketballPlayerPart4(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 4", "cs176", 10);
//	}
//	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 5")
//	public String basketballPlayerPart5(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 5", "cs176", 30);
//	}
//	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 6")
//	public String basketballPlayerPart6(ModelMap model) {
//		return mc.getMapping(model, "BasketballPlayer Part 6", "cs176", 20);
//	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/Shop Part 6")
	public String shopPart6(ModelMap model) {
		return mc.getMapping(model, "Shop Part 6", "cs176", 30);
	}
	@GetMapping(value = "/home/cs176/Advanced Looping/Projects/Shop Part 7")
	public String shopPart7(ModelMap model) {
		return mc.getMapping(model, "Shop Part 7", "cs176", 20);
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	

	// **********************************************
	// ******* EXCEPTION HANDLING CHALLENGES ********
	// **********************************************
	@GetMapping(value = "/home/cs176/Exception Handling/Try And Catch")
	public String tryAndCatch(ModelMap model) {
		return mc.getMapping(model, "Try and Catch", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Exception Handling/Custom Exceptions")
	public String customExceptions(ModelMap model) {
		return mc.getMapping(model, "Custom Exceptions", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Exception Handling/Throw")
	public String throwKeyword(ModelMap model) {
		return mc.getMapping(model, "Throw", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Exception Handling/Throws")
	public String throwsKeyword(ModelMap model) {
		return mc.getMapping(model, "Throws", "cs176", 7);
	}
	@GetMapping(value = "/home/cs176/Exception Handling/Finally")
	public String finallyBlock(ModelMap model) {
		return mc.getMapping(model, "Finally", "cs176", 7);
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
}
