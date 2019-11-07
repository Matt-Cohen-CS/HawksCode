package edu.monmouth.hawkscode.web.testEnvironment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import edu.monmouth.hawkscode.domain.WebCompiler;

@Controller
public class TESTGetController 
{
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
	   return populateChallenge(model, header, description);
	 */
	
	@GetMapping(value = "/testEnvironment/JustAMain/CodingSpace")
	public String testMain(ModelMap model) 
	{
		   String header = "Test Environment: Main"; 
		   String description = "";
		   return populateChallenge(model, header, description);
	}
}
