package examples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.*;
import java.util.*;

// libraries for parsing and manipulating XML file
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



/**
 * Servlet implementation class readXMLfile
 */
@WebServlet("/readXMLfile")
public class readXMLfile extends HttpServlet
{

   public readXMLfile()
   {
        super();
        // TODO Auto-generated constructor stub
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      // String datafile = "/Applications/apache/webapps/cs4640/WEB-INF/data/product.xml";    // put in tomcat directly

      String datafile = "~/apacke-tomcat-8.5.29/webapps/HoosAround/WEB-INF/data/product.xml";  // put in eclipse
      // Note: my project is cs4640s18, my workspace is in /Users/up3f/classes/
      //       the data file product.xml is in cs4640s18 project, WebContent/WEB-INF/data/ folder
      // Since my workspace is not in eclipse's default workspace, an absolute path is needed
      // If your workspace is in eclipse, you may simply use a relative path
      //    for example, cs4640s18/WebContent/WEB-INF/data/product.xml

      print_data(datafile, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      doGet(request, response);
   }


   private void print_data(String fname, HttpServletResponse response) throws ServletException, IOException
   {
      response.setContentType ("TEXT/HTML");
      PrintWriter out = response .getWriter ();

      try {
         Document doc = create_DOM_from_file(fname);

         out.println("Root element :" + doc.getDocumentElement().getNodeName());

         NodeList nList = doc.getElementsByTagName("product");
         for (int i = 0; i < nList.getLength(); i++)
         {
            Node nd = nList.item(i);
            out.println("<br />&nbsp;&nbsp; Current element: " + nd.getNodeName());

            // check if nd is an XML element, get values of its attributes and children
            if (nd.getNodeType() == Node.ELEMENT_NODE)
            {
               Element ele = (Element)nd;

               // access attribute's value
               out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; product id : " + ele.getAttribute("id"));

               // access element's value
               out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; product id : " + ele.getElementsByTagName("name").item(0).getTextContent());
               out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; product id : " + ele.getElementsByTagName("price").item(0).getTextContent());

            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


   // create a DOM object
   private Document create_DOM_from_file(String fname) throws Exception
   {
      try {
         File datafile = new File(fname);
         DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
         Document doc = dbuilder.parse(datafile);
         doc.getDocumentElement().getNodeName();
         doc.getElementsByTagName("name");
         return doc;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
}
