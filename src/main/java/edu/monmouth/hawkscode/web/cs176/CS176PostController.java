package edu.monmouth.hawkscode.web.cs176;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.monmouth.hawkscode.domain.WebCompiler;
import edu.monmouth.hawkscode.web.MainController;

@Controller
public class CS176PostController {

	@Autowired
	private MainController mc;
	
	// **********************************************
	// *** OBJECT ORIENTED PROGRAMMING CHALLENGES ***
	// **********************************************
	
		// **********************************************
		// ************* ACCESS MODIFIERS ***************
		// **********************************************
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Private")
	public String privateAccessModifier(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Private", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Public")
	public String publicAccessModifier(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Public", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Protected")
	public String protectedAccessModifier(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Protected", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Default")
	public String defaultAccessModifier(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Default", "cs176");
	}
	
	// **********************************************
	// ********* ACCESS MODIFIERS PROJECTS **********
	// **********************************************
//	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/BasketballPlayer Part 1")
//	public String basketballPlayerPart1(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 1", "cs176");
//	}
//	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/BasketballPlayer Part 2")
//	public String basketballPlayerPart2(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 2", "cs176");
//	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 1")
	public String shopPart1(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 1", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 2")
	public String shopPart2(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 2", "cs176");
	}	
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Access Modifiers/Projects/Shop Part 3")
	public String shopPart3(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 3", "cs176");
	}
		// **********************************************
		// ***************** STATIC *********************
		// **********************************************
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Variables")
	public String staticVariables(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Static Variables", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Methods")
	public String staticMethods(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Static Methods", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Static/Static Blocks")
	public String staticBlocks(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Static Blocks", "cs176");
	}
		// **********************************************
		// *************** OVERLOADING ******************
		// **********************************************
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Overloading Methods")
	public String overloadingMethods(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Overloading Methods", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Overloading Constructors")
	public String overloadingConstructors(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Overloading Constructors", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Overloading/Using This")
	public String usingThis(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Using This", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Overloading/This With Methods")
	public String thisWithMethods(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "This With Methods", "cs176");
	}
	
		// **********************************************
		// *************** INHERITANCE ******************
		// **********************************************
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Extends")
	public String extendsKeyword(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Extends", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Overriding")
	public String overriding(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Overriding", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Super")
	public String superKeyword(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Super", "cs176");
	}
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Inheritance/Polymorphism")
	public String polymorphism(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Polymorphism", "cs176");
	}
		// **********************************************
		// ************** NESTED CLASSES ****************
		// **********************************************
	@PostMapping(value = "/home/cs176/Object Oriented Programming/Nested Classes")
	public String nestedClasses(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Nested Classes", "cs176");
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	
	
	// **********************************************
	// ************* ARRAYS CHALLENGES **************
	// **********************************************
	@PostMapping(value = "/home/cs176/Arrays/Instantiating Arrays")
	public String intArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Instantiating Arrays", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Getting Array Values")
	public String gettingArrayValues(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Getting Array Values", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Setting Array Values")
	public String settingArrayValues(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Setting Array Values", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Literals")
	public String arrayLiteral(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Array Literals", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Bounds And Length")
	public String arrayBoundsAndLength(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Array Bounds and Length", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Multidimensional Arrays")
	public String multidimensionalArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Multidimensional Arrays", "cs176");
	}
	// **********************************************
	// ************** ARRAY PROJECTS ****************
	// **********************************************
//	@PostMapping(value = "/home/cs176/Arrays/Projects/BasketballPlayer Part 3")
//	public String basketballPlayerPart3(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 3", "cs176");
//	}
	@PostMapping(value = "/home/cs176/Arrays/Projects/Shop Part 4")
	public String shopPart4(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 4", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Projects/Shop Part 5")
	public String shopPart5(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 5", "cs176");
	}
		// **********************************************
		// **************** ARRAY LISTS *****************
		// **********************************************
	@PostMapping(value = "/home/cs176/Arrays/Array Lists/Creating Array Lists")
	public String creatingArrayLists(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Creating Array Lists", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Lists/Adding Items")
	public String addingItems(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Adding Items", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Lists/Getting Items")
	public String gettingItems(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Getting Items", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Lists/Changing Items")
	public String changingItems(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Changing Items", "cs176");
	}
	@PostMapping(value = "/home/cs176/Arrays/Array Lists/Removing Items")
	public String removingItems(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Removing Items", "cs176");
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	
	
	// **********************************************
	// ******* ADVANCED LOOPING CHALLENGES **********
	// **********************************************
	@PostMapping(value = "/home/cs176/Advanced Looping/For Loop Array")
	public String forLoopArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "For Loop Array", "cs176");
	}
	@PostMapping(value = "/home/cs176/Advanced Looping/While Loop Array")
	public String whileLoopArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "While Loop Array", "cs176");
	}
	@PostMapping(value = "/home/cs176/Advanced Looping/Max In Array")
	public String maxInArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Max In Array", "cs176");
	}
	@PostMapping(value = "/home/cs176/Advanced Looping/Average Of Array")
	public String averageOfArray(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Average Of Array", "cs176");
	}
	@PostMapping(value = "/home/cs176/Advanced Looping/Enhanced For Loop")
	public String enhancedForLoop(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Enhanced For Loop", "cs176");
	}
	
		// **********************************************
		// ********** ADVANCED LOOPING PROJECTS**********
		// **********************************************
//	@PostMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 4")
//	public String basketballPlayerPart4(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 4", "cs176");
//	}
//	@PostMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 5")
//	public String basketballPlayerPart5(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 5", "cs176");
//	}
//	@PostMapping(value = "/home/cs176/Advanced Looping/Projects/BasketballPlayer Part 6")
//	public String basketballPlayerPart6(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
//		return mc.postMapping(compiler, model, "BasketballPlayer Part 6", "cs176");
//	}
	@PostMapping(value = "/home/cs176/Advanced Looping/Projects/Shop Part 6")
	public String shopPart6(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 6", "cs176");
	}
	@PostMapping(value = "/home/cs176/Advanced Looping/Projects/Shop Part 7")
	public String shopPart7(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Shop Part 7", "cs176");
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
	
	// **********************************************
	// ******* EXCEPTION HANDLING CHALLENGES ********
	// **********************************************
	@PostMapping(value = "/home/cs176/Exception Handling/Try And Catch")
	public String tryAndCatch(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Try and Catch", "cs176");
	}
	@PostMapping(value = "/home/cs176/Exception Handling/Custom Exceptions")
	public String customExceptions(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Custom Exceptions", "cs176");
	}
	@PostMapping(value = "/home/cs176/Exception Handling/Throw")
	public String throwKeyword(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Throw", "cs176");
	}
	@PostMapping(value = "/home/cs176/Exception Handling/Throws")
	public String throwsKeyword(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Throws", "cs176");
	}
	@PostMapping(value = "/home/cs176/Exception Handling/Finally")
	public String finallyBlock(@ModelAttribute WebCompiler compiler, ModelMap model) throws FileNotFoundException {
		return mc.postMapping(compiler, model, "Finally", "cs176");
	}
	// **********************************************
	// **********************************************
	// **********************************************
	
}
