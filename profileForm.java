import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //if this doesn't work we need a .xml file
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("");
public class profileForm extends HttpServlet {

	String url = "file:///C:/Users/Student/Documents/Spring%202018/CS%204640%20PL%20for%20Web%20Apps/webPL_project/myProfile.html";
	String nameError = ""; //put these empty strings into the html so we can return html with the errors
	String majorError = "";
	String hobbiesError = "";
	String yearError = "";
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)//doPost for form validation 
            throws ServletException, IOException 
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   
   String name = request.getParameter("name");
   String major = request.getParameter("major");
   String hobbies = request.getParameter("hobbies");
   String year = request.getParameter("year"); 
  
   //each of these if's are to check if the field is filled out, if not we can print
   //separate error messages for each and display those messages next to the fields themselves
   if (name.length() == 0){
	   nameError = "Please Enter Your Name Correctly";
   }
   if (major == "Please Select a Major"){
	   majorError = "Please Select Your Major";
   }
   if (hobbies.length() == 0){
	   hobbiesError = "Tell Us What Makes You Fun!";
   }
   if (year == ""){
	   yearError = "What Year Do You Graduate?";
   }
   
   out.close();
}
   
	private void fillOutForm(PrintWriter out) 
	{
		String htmlHead = 
			"<html>"+
			"<head>"+
			"	<title>My Profile</title>" +
			
			"</head>";
		
		String htmlBody = 
			"<body>"+
			"<form action='" + url + "' method='post' onsubmit='return (validateInput())' >" +
			"<label>Full Name</label>"+ nameError + //by putting this concat with the error it will display here
			"<input type='text' id='fullName' name='fullName'> <br/>"+
			"<label>Major</label>" + majorError +
			"<select name='major'> <br/>"+ //changed this field to a dropdown selection box
		    "  <option value=''>Please Select a Major</option>"+
		    "  <option value='CS'>Computer Science</option>"+
		    "  <option value='CPE'>Computer Engineering</option>"+
		    "  <option value='EE'>Electrical Engineering</option>"+
		    "  <option value='ME'>Mechanical Engineering</option>"+
		    "  <option value='BME'>Biomedical Engineering</option>"+
		    "  <option value='CE'>Civil Engineering</option>"+
		    "  <option value='AE'>Aerospace Engineering</option>"+
		    "  <option value='SE'>Systems Engineering</option>"+
		    "</select><br/>"+
		    "<label>Favorite Hobbies</label>" + hobbiesError +
		    "<input type='text' name='favoriteHobbies'><br/>"+ //need to change for text box format
		    "<label>Year</label>" + yearError + "<br/>" +
		    "<input type='radio' name='year' value='1st'>1st Year<br>"+
		    "<input type='radio' name='year' value='2nd'> 2nd Year<br>"+
		    "<input type='radio' name='year' value='3rd'> 3rd Year <br>"+
		    "<input type='radio; name='year' value='4th'> 4th Year <br>"+
			"</body>"+
			"</html>";
		
		String htmlAll = htmlHead + htmlBody;
		out.println(htmlAll);		
	}
   
}