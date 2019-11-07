package edu.monmouth.hawkscode.web;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.monmouth.hawkscode.domain.Challenge;
import edu.monmouth.hawkscode.domain.ChallengeRepository;
import edu.monmouth.hawkscode.domain.Course;
import edu.monmouth.hawkscode.domain.CourseRepository;
import edu.monmouth.hawkscode.domain.User;
import edu.monmouth.hawkscode.domain.UserRepository;
import edu.monmouth.hawkscode.domain.WebCompiler;
import edu.monmouth.hawkscode.service.ChallengeService;
import edu.monmouth.hawkscode.service.CourseService;
import edu.monmouth.hawkscode.service.UserService;
import edu.monmouth.hawkscode.web.cs176.CS176ChallengeText;

@Controller
@ComponentScan(basePackages = "org.pac4j.springframework.component")
public class MainController {
	
	@Autowired
	private ProfileManager<CommonProfile> profileManager;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired 
	private ChallengeService challengeService;
	
	@Autowired
	private CS176ChallengeText cs176ChallengeText;
	
	public void populateCourse(ModelMap model,String header, String description, String path,List<String> topics){
		String userID = getUserID();
		//userID = "Welcome, " + userID;
		userID = userID; 
		model.put("userID", userID);
		model.put("path", path);
		model.put("header", header);
		model.put("description", description);
		model.put("topics",topics);
	}

	public void createUser(String id) {
		User user = new User(id);
		if(userService.getUserById(id) == null) {
			// Save the new user
			userService.add(user);
		}
		
		// Save courses to new user
		String[] courseNames = {"cs175", "cs176", "cs205"};
		for(String courseName: courseNames) 
			addCourse(courseName);
	}

	public void addChallenge(String name, String courseName, int points) {
		String id = getUserID();
		createUser(id);
		Course course = getCourse(courseName);
		Challenge challenge = challengeService.getByNameAndCourse(name, course);
		if(challenge == null) {
			challengeService.add(new Challenge(name, false, course, points));
		}
	}
	public void addCourse(String courseName) {
		User user = new User(getUserID());
		if(courseService.getByNameAndUser(courseName, user) == null) {
			courseService.add(new Course(courseName, user));
		}
	}
	private List<String> getChallengeNamesWithCompletion(String courseName) {
		Course course = getCourse(courseName);
		List<Challenge> challenges = challengeService.getByCourse(course);
		List<String> challengeNamesWithCompletion = new ArrayList<String>();
		
		if(challenges.isEmpty()) {
			challengeNamesWithCompletion.add("<p>You have not attempted any challenges for this course! Visit a challenge page to track your progress.</p>");
		}
		
		for(Challenge c: challenges) {
			if(c.isCompleted())
				challengeNamesWithCompletion.add("<p><i class='fas fa-check' style='color: #77dd77;'></i> " + c.getName() + " " + c.getPoints() + "/" + c.getPoints() + " earned.</p>");
			else
				challengeNamesWithCompletion.add("<p><i class='fas fa-times' style='color: #ff6961;'></i> " +  c.getName() + " 0/" + c.getPoints() + " earned.</p>");
		}
		return challengeNamesWithCompletion;

	}
	private Course getCourse(String courseName) {
		return courseService.getByNameAndUser(courseName, userService.getUserById(getUserID()));
	}

	private int getCoursePointsForCompletedChallenges(String courseName) {
		Course course = getCourse(courseName);
		List<Challenge> challenges = challengeService.getByCourse(course);
		int points = 0;
		for(Challenge c: challenges) {
			if(c.isCompleted())
				points += c.getPoints();
		}
		return points;
	}
 	private int getTotalCoursePoints(String courseName) {
		Course course = getCourse(courseName);
		List<Challenge> challenges = challengeService.getByCourse(course);
		int totalPoints = 0;
		for(Challenge c: challenges) {
			totalPoints += c.getPoints();
		}
		return totalPoints;
	}

	// ********************************
	// **** Get Controller Methods ****
	// ********************************
	public String populateChallenge(ModelMap model, String header, String description, String boilerplate, boolean isChallengeCompleted) {
		WebCompiler compiler = new WebCompiler();
		model.put("textInput", compiler);
		model.put("header", header);
		model.put("description", description);
		model.put("boilerplate", boilerplate);
		model.put("isChallengeCompleted", isChallengeCompleted);
		return "b-challenge";
	}
	public String getMapping(ModelMap model, String challengeName, String courseName, int points) {
		addChallenge(challengeName, courseName, points);
		String description = "";
		String boilerplate = "";
		String header = "";
		Map<String, String> challengeText;
		switch(courseName) {
		case "cs176":
			challengeText = cs176ChallengeText.challengeText(challengeName);
			header = challengeText.get("header");
			description = challengeText.get("description");
			boilerplate = challengeText.get("boilerplate");
			break;
		}
		return populateChallenge(model, header, description, boilerplate, isChallengeCompleted(challengeName, courseName));
	}
	public boolean isChallengeCompleted(String challengeName, String courseName) {
		Course course = getCourse(courseName);
		return challengeService.getByNameAndCourseAndIsCompleted(challengeName, course, true) != null;
	}
	
	// *********************************
	// **** Post Controller Methods ****
	// *********************************
	public String populateChallenge(ModelMap model, String header, String description, String userInput, String boilerplate) {
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
	/**
	 * 
	 * @param compiler  our WebCompiler class
	 * @param baseCode  reference to the baseCode we wrote for the challenge
	 * @param className name of the file that we are going to compile
	 * @return
	 * @throws FileNotFoundException
	 */
	private List<String> runCompiler(WebCompiler compiler, InputStream baseCode, String className)
			throws FileNotFoundException {
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
	public String postMapping(@ModelAttribute WebCompiler compiler, ModelMap model, String challengeName, String courseName) throws FileNotFoundException {
		String header = "";
		String description = "";
		String userInput = compiler.getUserInput();
		String boilerplate = "";
		String filePath = "";
		String javaClass = "";
		Map<String, String> challengeText;
		
		switch(courseName) {
		case "cs176":
			challengeText = cs176ChallengeText.challengeText(challengeName);
			header = challengeText.get("header");
			description = challengeText.get("description");
			boilerplate = challengeText.get("boilerplate");
			filePath = challengeText.get("filePath");
			break;
		}
		javaClass = getJavaClass(filePath);

		populateChallenge(model, header, description, userInput, boilerplate);
		setCompiler(compiler, model, filePath, javaClass);
		return CheckAndUpdateChallenge(challengeName, courseName, compiler, model);
	}
	public String getJavaClass(String filePath) {
		String javaClass = "";
		Pattern pattern = Pattern.compile("([^/]+$)");
		Matcher matcher = pattern.matcher(filePath);
		if(matcher.find()) javaClass = matcher.group(1);
		return javaClass.replace(".txt", ".java");
	}
	public String CheckAndUpdateChallenge(String challengeName, String courseName, WebCompiler compiler, ModelMap model) {
	   // Searches through challengeRepository for a specific challengeName, User, and isCompleted = {true, false}
		Course course = getCourse(courseName);
		Challenge challenge = challengeService.getByNameAndCourseAndIsCompleted(challengeName, course, false);

	   if(challenge != null) {
		   // Get the main output from web compiler
		   String outputToCheck = "";
		   if(compiler.getMainOutput() != null) {
			   outputToCheck = compiler.getMainOutput().toString();
		   }
		   // Check main output for "Congratulations"
		   if(outputToCheck.contains("Congratulations")) {
			   // If yes, set the challenge's completion to true
			   challenge.setCompleted(true);
			   // Add points to user
			   int points = challenge.getPoints();
			   addPoints(points, courseName);
			   // Save it to reflect changes in the database
			   challengeService.add(challenge);
			   model.put("isChallengeCompleted", true);
			   model.put("score", points);
		   }
	   } else {
		   model.put("isChallengeCompleted", true);
	   }
	   
	   return "b-challenge";
	}
	public void addPoints(int points, String courseName) {
		User user = userService.getUserById(getUserID());
		user.addToScore(points);
		courseService.getByNameAndUser(courseName, user).addToPoints(points);
	}
	// *************************************************************
	
	public String getUserID() {
		String userID = "Error retrieving profile";
		Optional<CommonProfile> profile = profileManager.get(true);
		if(profile.isPresent()) {
			//System.out.println("profile not null"); //testing purposes
			CommonProfile prof = profile.get();
			userID = prof.getId();
			/*
			Map<String, Object> attributes = prof.getAuthenticationAttributes();
			Set<String> attributeNames = attributes.keySet();
			for(String s : attributeNames) {
				System.out.println(s);
			}
			*/
		}else {
			System.out.println("profile null");
		}
		return userID;
		//return "s1110080";
	}
	
	
	@GetMapping(value = "/")
	public String toFederatedServer() {
		return "b-login";
	}
	
//	@RequestMapping(value = "/{hc-sp-metadata.xml}", method = RequestMethod.GET)
//	@ResponseBody
//	public FileSystemResource getFile(@PathVariable("hc-sp-metadata.xml") String fileName) {
//	    return new FileSystemResource("/usr/share/tomcat/temp/hc-sp-metadata.xml"); 
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		String userID = getUserID();

		// Creates new user
		createUser(userID);

		// Get all challenges and their completion = {true, false}
		List<String> cs175ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs175"); 
		List<String> cs176ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs176"); 
		List<String> cs205ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs205"); 
		
		// Get points for user and their courses
		int userPoints = userService.getUserById(userID).getScore();

		String cs175Header = "CS175";
		String cs176Header = "CS176";
		String cs205Header = "CS205";
		
		List<String> courses = new LinkedList<>();		
		//userID = "Welcome, " + userID + ". Your points: " + userPoints;
		userID = userID; 
		model.put("userID", userID);
		courses.add("CS_175");
		courses.add("CS_176");
		courses.add("CS_205");
		courses.add("TEST_Environment");
		model.put("courses", courses);
		model.put("cs175Challenges", cs175ChallengeNamesWithCompletion);
		model.put("cs176Challenges", cs176ChallengeNamesWithCompletion);
		model.put("cs205Challenges", cs205ChallengeNamesWithCompletion);
		model.put("cs175Header", cs175Header);
		model.put("cs176Header", cs176Header);
		model.put("cs205Header", cs205Header);
		return "b-index";
	}
	
	@GetMapping(value = "/home/help")
	public String help() {
		return "b-help";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping(value = "/home/profile")
	public String profile(ModelMap model) {
		String userID = getUserID();

		// Creates new user
		createUser(userID);

		// Get all challenges and their completion = {true, false}
		List<String> cs175ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs175"); 
		List<String> cs176ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs176"); 
		List<String> cs205ChallengeNamesWithCompletion = getChallengeNamesWithCompletion("cs205"); 
		
		// Get points for user and their courses
		// TOTAL USER POINTS 
//		int userPoints = userService.getUserById(userID).getScore();
		
		int earnedCS175Points = getCoursePointsForCompletedChallenges("cs175");
		int earnedCS176Points = getCoursePointsForCompletedChallenges("cs176");
		int earnedCS205Points = getCoursePointsForCompletedChallenges("cs205");
		int totalCS175Points = getTotalCoursePoints("cs175");
		int totalCS176Points = getTotalCoursePoints("cs176");
		int totalCS205Points = getTotalCoursePoints("cs205");

		
		model.put("cs175Challenges", cs175ChallengeNamesWithCompletion);
		model.put("cs176Challenges", cs176ChallengeNamesWithCompletion);
		model.put("cs205Challenges", cs205ChallengeNamesWithCompletion);
		
		return "b-profile";
	}
	
	@GetMapping(value = "/home/testEnvironment")
	public String testEnvironment(ModelMap model)
	{
		
		String header = "Testing Environment"; 
		String description = "HELLO EARL"; 
		String path = "/testEnvironment"; 
		
		List<String> topics = new LinkedList<>(); //For linking to topic pages, see course.html
		topics.add("JustAMain");
		
		populateCourse(model, header, description, path, topics);	
		return "b-course"; 
	}
	
	@GetMapping(value = "/home/cs175")
	public String cs175(ModelMap model)
	{
		String header = "CS 175"; 
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				CS 175 - Introdution to Computer Science I <br>\r\n" + 
				"				An introduction to the basic concepts of program development in a modern object-oriented language; problem-solving methods and algorithm development; basic primitive and object data types; language syntax; style and documentation; and coding and testing of programs. \r\n" + 
				"			</p>\r\n" + 
				"		</div>";
		String path="/home/cs175";
		List<String> topics = new LinkedList<>(); //For linking to topic pages, see course.html
		topics.add("Primitive Data Types");
		topics.add("String I");
		topics.add("Basic Operators");
		topics.add("Casting And Converting");
		//topics.add("Static I");
		topics.add("Using Methods");
		topics.add("Objects and Classes");
		topics.add("Writing Methods");
		topics.add("Control Flow Statements");
		topics.add("More Methods"); 
		topics.add("File");
		topics.add("Design Document");
		/*
		 * new ordering to iron out
		 * Primitive data types
		 * string i 
		 * basic operators -> add String concatenation?
		 * casting and converting
		 * Classes and objects -> combine Objects and Class I -> calculator class? basketball player class
		 * Methods i
		 * Static i
		 * 
		 * 
		 */
		
		populateCourse(model, header, description, path, topics);	
		return "b-course"; 
	}

	@GetMapping(value = "/home/cs176")
	public String cs176(ModelMap model)
	{
		String header = "CS 176"; 
		String description = "<div class=\"introduction\">\r\n" + 
				"			<p class=\"topic-description\">\r\n" + 
				"				CS 176 - Introdution to Computer Science II <br>\r\n" + 
				"				An introduction to basic data structures, exception handling in Java, and basic Object-oriented programming concepts in Java. All code should be reusable, extendable, easy to read and easily maintainable. The object-oriented programming paradigm will enable you to accomplish these goals when creating large-scale applications. Data structures help to create more powerful and useful applications. \r\n" + 
				"               <p>NOTE: You may occasionally see class declarations prefixed with the word \"static\": </p>\r\n"+
				"               <pre>static class MyClass...</pre>\r\n"+
				"               <p>For now, pretend that the class is in its own Java file and prefixed with the word \"public\" instead. We have to do this simply because of the way the website is setup; we can only check one Java file at a time.</p>"+
				"			</p>\r\n" + 
				"		</div>";
		String path="/home/cs176";
		List<String> topics = new LinkedList<>(); //For linking to topic pages, see course.html
		topics.add("Object Oriented Programming");
		topics.add("Arrays");
		topics.add("Advanced Looping");
		topics.add("Exception Handling");
		populateCourse(model, header, description, path, topics);	
		return "b-course"; 
	}
	
	@GetMapping(value= "/home/cs205")
	public String cs205(ModelMap model){
		String header = "CS 205";
		String description = "<div class=\"introduction\">\r\n" + 
				"<p class=\"topic-description\">\r\n" + 
				"CS 205 - Data Structures and Algorithms <br>\r\n" + 
				"An introduction to the organization/usage of the Java Collections Framework and other Java based utilities.\r\n"
			   +"In these challenges you will focus on: the importance of the efficiency of algorithms, new data structures to easily"
			   + " manipulate and store your data, and the combining of the two."
			   + "</p>\r\n" + 
				"</div>";
		String path = "/home/cs205";
		List<String> topics = new LinkedList<>(); //For linking to topic pages, see course.html
		topics.add("Big O Notation");
		topics.add("Class II");
		topics.add("Linked List");
		topics.add("Binary Search Tree");
		topics.add("Map");
		topics.add("Recursion");
		//topics.add("TestingAndDebugging");
		populateCourse(model, header, description, path, topics);
		return "b-course";
	}
	
	@GetMapping(value = "/error_page")
	public String error(ModelMap model)
	{
		return "b-error_page";
	}
}
