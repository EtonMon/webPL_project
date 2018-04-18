/**
 * code for servlet lify cycle
 *  - modified from "Professional Java Server Programming", Patzer et al.,
 *    Edition J2EE, Ch 9, pg 401
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servletSession extends HttpServlet
{
   // Location of servlet.
   // static String url = "http://labunix03.cs.virginia.edu:8080/up3f/examples.servletSession";   // labunix
   static String url = "http://localhost:8080/HoosAround/session";
   // note: domain="localhost:8080", path="/cs4640s18/", servlet="examples.servletSession"

   // to access the servlet
   // (local)
   //    http://localhost:8080/cs4640s18/examples.servletSession
   // (labunix03)
   //    http://labunix03:8080/up3f/examples.servletSession

   // Important note: labunix does not support servlet annotation and thus using @WebServlet does not work
   // You need to manually do servlet mapping using web.xml file

   String msg = "";

   public void doGet(HttpServletRequest request,HttpServletResponse response)
   throws ServletException,IOException
   {
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     HttpSession session = request.getSession();

     String action = request.getParameter("action");
     if (action != null && action.equals("invalidate"))
     {  // Called from the invalidate button, kill the session
        // get session, then invalidate it
   	 // HttpSession session = request.getSession();
        session.invalidate();

        String x = "";
        x+="<html lang='en'>"+
        "<head>"+
          "<meta charset='utf-8'>"+

          "<title>My Matches</title>"+
          "<meta name='description' content='The HTML5 Herald'>"+
          "<meta name='author' content='SitePoint'>"+

          "<link rel='stylesheet' href='resources/css/styles.css?v=1.0'>"+

          "<!--[if lt IE 9]>"+
            "<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js'></script>"+
          "<![endif]-->"+

          "<!-- Latest compiled and minified CSS -->"+
          "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+

          "<!-- jQuery library -->"+
          "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>"+

          "<!-- Latest compiled JavaScript -->"+
          "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+

        "</head>"+

        "<body>"+
          "<script src='resources/js/scripts.js'></script>"+
          "<nav>"+
            "<ul>"+
              "<li><a href='index.html'>HoosAround</a></li>"+
              "<li><a href='match-me.html'>Match Me</a></li>"+
              "<li><a href='my-matches.html'>My Matches</a></li>"+
              "<li style='float:right'><a class = 'current' href='http://localhost:8080/HoosAround/session'><img src='http://www.freeiconspng.com/uploads/profile-icon-9.png' width=20 height=20></a></li>"+
              "<li style='float:right'><a href='http://localhost:8080/HoosAround/session'>My Profile</a></li>"+
            "</ul>"+
          "</nav>";
         out.println(x);
        out.println("  <div>");
        out.println("    You have succesfully logged out <br/><br/>");
        out.println("  </div>");
        out.println("</body>");
        out.println("</html>");
     }
     else if(session.getAttribute("name")==null){
       String x = "";
       x+="<html lang='en'>"+
       "<head>"+
         "<meta charset='utf-8'>"+

         "<title>My Matches</title>"+
         "<meta name='description' content='The HTML5 Herald'>"+
         "<meta name='author' content='SitePoint'>"+

         "<link rel='stylesheet' href='resources/css/styles.css?v=1.0'>"+

         "<!--[if lt IE 9]>"+
           "<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js'></script>"+
         "<![endif]-->"+

         "<!-- Latest compiled and minified CSS -->"+
         "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+

         "<!-- jQuery library -->"+
         "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>"+

         "<!-- Latest compiled JavaScript -->"+
         "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+

       "</head>"+

       "<body>"+
         "<script src='resources/js/scripts.js'></script>"+
         "<nav>"+
           "<ul>"+
             "<li><a href='index.html'>HoosAround</a></li>"+
             "<li><a href='match-me.html'>Match Me</a></li>"+
             "<li><a href='my-matches.html'>My Matches</a></li>"+
             "<li style='float:right'><a class = 'current' href='http://localhost:8080/HoosAround/session'><img src='http://www.freeiconspng.com/uploads/profile-icon-9.png' width=20 height=20></a></li>"+
             "<li style='float:right'><a href='http://localhost:8080/HoosAround/session'>My Profile</a></li>"+
           "</ul>"+
         "</nav>";

         x+="<p>You do not have a profile. Sign up </p><a href='signup.html'>here</a>";

         x+="</body>"+
         "</html>";
         out.println(x);

     }
     else
     {
        // get session
    	 // HttpSession session = request.getSession();

       String x = "";
       x+="<html lang='en'>"+
       "<head>"+
         "<meta charset='utf-8'>"+

         "<title>My Matches</title>"+
         "<meta name='description' content='The HTML5 Herald'>"+
         "<meta name='author' content='SitePoint'>"+

         "<link rel='stylesheet' href='resources/css/styles.css?v=1.0'>"+

         "<!--[if lt IE 9]>"+
           "<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js'></script>"+
         "<![endif]-->"+

         "<!-- Latest compiled and minified CSS -->"+
         "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+

         "<!-- jQuery library -->"+
         "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>"+

         "<!-- Latest compiled JavaScript -->"+
         "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+

       "</head>"+

       "<body>"+
         "<script src='resources/js/scripts.js'></script>"+
         "<nav>"+
           "<ul>"+
             "<li><a href='index.html'>HoosAround</a></li>"+
             "<li><a href='match-me.html'>Match Me</a></li>"+
             "<li><a href='my-matches.html'>My Matches</a></li>"+
             "<li style='float:right'><a class = 'current' href='http://localhost:8080/HoosAround/session'><img src='http://www.freeiconspng.com/uploads/profile-icon-9.png' width=20 height=20></a></li>"+
             "<li style='float:right'><a href='http://localhost:8080/HoosAround/session'>My Profile</a></li>"+
           "</ul>"+
         "</nav>";
        out.println(x);

        out.println("  <div>");

        out.println("    <h2>" + session.getAttribute("name") + "'s Profile</h2>");

        out.println("<p>Major: </p>" + session.getAttribute("major") + "</p>");
        out.println("<p>Hobbies: </p>" + session.getAttribute("hobbies") + "</p>");
        out.println("<p>Year: </p>" + session.getAttribute("year") + "</p>");

        out.println("<br/><br/><a href=\"contact-us.jsp\">Need help? Contact us</a>");

        out.println("<br/><br/><a href=\"" + url + "?action=invalidate\">Logout</a>");

        //out.println("<br/><br/><a href=\"http://localhost/cs4640s18/php-servlet/contact_us.php\">Contact us</a>");

        out.println("  </div>");
        out.println("</body>");
        out.println("</html>");
     }
     // doPost(request, response);
     out.close();
   }


   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String name = request.getParameter("name");
      String major = request.getParameter("major");
      String hobbies = request.getParameter("hobbies");
      String year = request.getParameter("year");

      request.getSession().setAttribute("name", name);
      request.getSession().setAttribute("major", major);
      request.getSession().setAttribute("hobbies", hobbies);
      request.getSession().setAttribute("year", year);

      String x = "";
      x+="<html lang='en'>"+
      "<head>"+
        "<meta charset='utf-8'>"+

        "<title>My Matches</title>"+
        "<meta name='description' content='The HTML5 Herald'>"+
        "<meta name='author' content='SitePoint'>"+

        "<link rel='stylesheet' href='resources/css/styles.css?v=1.0'>"+

        "<!--[if lt IE 9]>"+
          "<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js'></script>"+
        "<![endif]-->"+

        "<!-- Latest compiled and minified CSS -->"+
        "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+

        "<!-- jQuery library -->"+
        "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>"+

        "<!-- Latest compiled JavaScript -->"+
        "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"+

      "</head>"+

      "<body>"+
        "<script src='resources/js/scripts.js'></script>"+
        "<nav>"+
          "<ul>"+
            "<li><a href='index.html'>HoosAround</a></li>"+
            "<li><a href='match-me.html'>Match Me</a></li>"+
            "<li><a href='my-matches.html'>My Matches</a></li>"+
            "<li style='float:right'><a class = 'current' href='http://localhost:8080/HoosAround/session'><img src='http://www.freeiconspng.com/uploads/profile-icon-9.png' width=20 height=20></a></li>"+
            "<li style='float:right'><a href='http://localhost:8080/HoosAround/session'>My Profile</a></li>"+
          "</ul>"+
        "</nav>";
      out.println(x);

      out.println("<br/><br/>Thanks for submitting your profile, " + name + "<br/>");
      out.println("<a href =" + url + ">View Profile</a>");
//      if (username != null && email != null && comment != null)
//      {
//         doGet(request, response);       // submit more comment?
//      }
//      else
//      {
//         msg = "Please enter your information";
//         doGet(request, response);
//      }
//

      out.println("</body>");
      out.println("</html>");
      out.close();
   }


//  Instead of mixing html in java (refer to out.println() in doGet()),
//  some developers prefer to separate them as much as possible.
//  You may comment the out.println() in doGet() and have doGet() call other java functions
//  to do create the html document (for example, call printHTML() below)
//
//   private void printHTML(PrintWriter out)
//   {
//      String str_head =
//         "<html>" +
//         "<head>" +
//         "  <title>Servlet example</title>" +
//         "  <link rel=stylesheet href='styles/example-style.css' type='text/css'>" +
//         "</head>";
//
//      String str_body =
//         "<body>" +
//         "  <div>" +
//         "    <h1>Servlet example</h1>";
//
//         if (msg.length() > 0)
//            str_body = str_body + "<br/>" + "<span class='msg'>" + msg + "</span> <br/><br/>";
//
//         str_body +=
//            "    <form action='" + url + "' method='post' onsubmit='return (validateInput())' >" +
//            "      <label>Name: </label>" +
//            "      <input type='text' id='user' name='username' autofocus /> <br/>" +
//            "      <label>Email: </label>" +
//            "      <input type='text' id='email' name='emailaddr'  /> <br/>" +
//            "      <label>Comment: </label>" +
//            "      <textarea rows='5' cols='40' id='comment' name='comment'></textarea> <br/>" +
//            "      <input type='submit' value='Submit comment' />" +
//            "    </form>" +
//            "  </div>" +
//            "</body>" +
//            "</html>";
//
//      String str_html = str_head + "<br/>" + str_body;
//      out.println(str_html);
//   }
//

   // private void printConfirmation(String name, PrintWriter out)
   // {
   //    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   //    Date date = new Date();
   //
   //    out.println("<br/><br/>Thanks for submitting your profile, " + name + "<br/>");
   // }

}
