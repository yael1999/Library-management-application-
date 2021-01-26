<%-- 
    Document   : borrowResult
    Created on : 12/01/2021, 22:59:32
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
               .vertical-menu a {
  width: 200px; /* Set a width if you like */
}
            body{
                <%--    background-image:url('http://2.bp.blogspot.com/-dsZ9XYOD1rc/VNyNXIF4PwI/AAAAAAAAAl8/uvfcXhaeXxE/s1600/Beautiful%2BBooks%2B2.jpg'); --%>
                background-image:url('https://image.freepik.com/free-photo/back-school-concept-books-colored-pencils-clock_155003-3672.jpg');
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
  <a class="active" href="main.jsp">Home</a>
  <a href="borrowBook.jsp">Borrow</a>
  <a href="searchBook.jsp">Search</a>
  <a href="returnServlet">Return</a>
   <a href="logoutServlet">Log Out</a>
   </div>
   <br>
         <% String resultF=(String)session.getAttribute("resultF");%>
          <% String resultS=(String)session.getAttribute("resultS");%>
          <%String m="";
          if(resultF==null){ %>
               <li><%=resultS%></li>
          <%  }
          else{ %>
           <li><%=resultF%></li>
           <%
          }
         %>
         
         <br>
        <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
         
    </body>
</html>
