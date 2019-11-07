package edu.monmouth.hawkscode.web.testEnvironment;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TESTMainController 
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
	
	@GetMapping(value = "/testEnvironment/JustAMain")
	public String testEnvironment(ModelMap model)
	{
		String path = "/testEnvironment/JustAMain";
		
		String header = "Test Environment: Main";
		String description = "";
		
		List<String> challenges = new LinkedList<>();
		challenges.add("CodingSpace");
		
		List<String> links = new LinkedList<>();
		
		populateTopics(model, path, header, description, challenges, links);
		return "b-topics";
	}	
	
}
