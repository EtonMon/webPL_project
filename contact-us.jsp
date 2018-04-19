<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>My Matches</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  <link rel="stylesheet" href="resources/css/styles.css?v=1.0">

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
    body{background-color: LightBlue}
  </style>
  
</head>

<body>
    <%@ page language="java" %>
    <%@ page import = "java.util.Date" %>
    <%@ page import = "beans.ContactMsg" %>
    <%@ page session = "true" %>
    
    <script src="resources/js/scripts.js"></script>
    <nav>
        <ul>
            <li><a href="index.html">HoosAround</a></li>
            <li><a href="match-me.html">Match Me</a></li>
            <li><a href="my-matches.html">My Matches</a></li>
            <li style="float:right"><a href="http://localhost:8080/HoosAround/session"><img src="http://www.freeiconspng.com/uploads/profile-icon-9.png" width=20 height=20></a></li>
            <li style="float:right"><a href="http://localhost:8080/HoosAround/session">My Profile</a></li>
        </ul>
    </nav>
    <% if (request.getMethod().equals("GET")) { %>
        From: <%=request.getSession().getAttribute("name") %>
        <br>
        Date: <%= new Date() %>
        <br>
        <!--Message-->
        <form id="messageForm" action="contact-us.jsp" method="POST">
            <div class="form-group">
                <label for="message">Message</label>
                <textarea class="form-control" rows="5" id="message" name = "message"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    <% }
    else { %>
        <jsp:useBean id='contactmsg' scope='session' class='beans.ContactMsg' />
        <% String name = (String) request.getSession().getAttribute("name"); %>
        <jsp:setProperty name='contactmsg' property='from' value="<%=name %>"/>
        <% Date date = new Date(); %>
        <jsp:setProperty name='contactmsg' property='date' value="<%=date %>"/>
        <% String message = (String) request.getParameter("message"); %>
        <jsp:setProperty name='contactmsg' property='message' value="<%=message %>"/>
        <p><%=message %></p> 
        <!-- <jsp:forward page='contact-form-confirm.jsp'/> -->
    <% } %>





</body>
</html>
