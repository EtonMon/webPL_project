<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP examples</title>
</head>

<!--Requirements (3): <jsp:include>
<jsp:useBean>
<jsp:setProperty>
<jsp:getProperty>
<jsp:forward>
<jsp:param> !-->

<!--Use Two: Declaration
Scriptlet
Expression !-->

<!--Implement at least one type of JSP directive elements
Page directive such as
  <%@ page contentType = "text/html" %>
  <%@ page import = "java.util.*" %>
  <%@ page import = "myPackage.*" %>     // to import Java classes or Java beans
  <%@ page language = "java" %>
Note: any other JSP directives are acceptable !-->


<body>

    <!-- 1. JSP directives .. info sent to the container  -->
   <!-- page directive -->
   <%@ page language="java" %>
   <!-- <%@ page import = "myPackage.*" %>     // to import Java classes or Java beans -->

   <!-- Include directive: either static or dynamic. For example,
     <%@ include file="created_by.html" %>   // static
     <%@ include file="date.jsp" %>          // dynamic -->





     <!-- 2. JSP scripts -->
        <!--    there are 3 kinds of scripting elements -->
        <!--    reminder: it's Java, we need to follow Java syntax for declaration and scriptlets -->
        <!-- 2.1 declaration .. declare variables or functions -->



        <!-- 2.2 scriptlet .. block of Java code
             this is where we can access servlet implicit objects (must use these names/spelling)
             - request (HttpServletRequest object)
             - response (HttpServletResponse object)
             - out (PrintWriter, for producing HTML document)
        -->





        <!-- 2.3 expression .. evaluated and replaced with string value -->









        <!-- 3. JSP actions .. tags to change behavior of web app -->
      <!--    dynamically create content
              has the form of a markup element
                - opening tag and possibly including attributes
                - action body (content)
                - closing tag
              represent program code that gernerate markup
           **no space in the JSP action tag name
      -->


      <!-- forward action without parameter passing -->



      <!-- forward action with parameter passing -->





      <!-- scriptlet to redirect without parameter passing,
           use sendRedirect() of the servlet response object -->




      <!-- scriptlet to redirect with parameter passing,
           use sendRedirect() of the servlet response object -->




      <!-- include action (dynamic) without parameter passing -->
      <!-- imagine including header (and navigation) to the page -->


      <br/><br/>
      <div align="middle">
      <h1>Title of the Page</h1>
      <p>Content of your page</p>
      </div>
      <br/><br/>



      <!-- include action (dynamic) with parameter passing -->




      <br/><br/>
      <!-- static include action with parameter passing -->




   <!-- (dynamic) include directive vs. (dynamic) include action
           - both produce the same html output
       include directive
           - include content at translation time (when converting jsp to java)
           - thus, load the content once
           - if the included file is changed, the change does not reflect the main jsp page
             (because the included jsp is already translated, loaded, and put into the main jsp)
       include action
           - include content at runtime
           - thus, load the content everytime the main jsp is run
           - if the included file is changed, the change reflects the main jsp page
             (because the included get loaded everyime the main jsp is run)
   -->

   <!-- observe page source, notice that we won't see jsp or java code -->























</body>
</html>
