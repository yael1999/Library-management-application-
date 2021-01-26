<%-- 
    Document   : displayBorrowedBooks
    Created on : 04/01/2021, 16:47:46
    Author     : יעל כץ
--%>

<%@page import="MODEL.hashala"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            body {
                margin: 0;
            }
           
                  .vertical-menu a {
  width: 200px; /* Set a width if you like */
}
.vertical-menu a {
  background-color: #eee; /* Grey background color */
  color: black; /* Black text color */
  display: block; /* Make the links appear below each other */
  padding: 12px; /* Add some padding */
  text-decoration: none; /* Remove underline from links */
}

.vertical-menu a:hover {
  background-color: #ccc; /* Dark grey background on mouse-over */
}

.vertical-menu a.active {
  background-color: #000099; /* Add a blue color to the "active/current" link */
  color: white;
}
.h1{
    width: 40%
}
.h2{
    width: 30%
}
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #660033;
  color: white;
}

         

        </style>

    </head>
    <body>
        <div class="topnav">
  <a href="main.jsp">Home</a>
  <a href="borrowBook.jsp">Borrow</a>
  <a href="searchBook.jsp">Search</a>
  <a  class="active" href="returnServlet">Return</a>
   <a href="logoutServlet">Log Out</a>
   </div>
           <% String name=(String)session.getAttribute("myName");%>
           <h1>Hi,<%=name%></h1>
        <h2>Borrowed books are:</h2>
        <form method="get" action="returnServlet2">
          <%
            //  ArrayList<String>list=(ArrayList<String>)session.getAttribute("booktodisplay");
            List<hashala>list=(List<hashala>)session.getAttribute("borrowedBooks");
              for(int i=0;i<list.size();i++){
                %>
                <input type="checkbox" name="names" value="<%=list.get(i)%>" id="ch<%=i%>"><%=list.get(i)%> <br>
                <%
                    }
                %>
                 <input type="submit">
        </form>
                 <br>
                 <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
       
    </body>
</html>
