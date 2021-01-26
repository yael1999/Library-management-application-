<%-- 
    Document   : main.jsp
    Created on : 03/01/2021, 22:24:55
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Library</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .vertical-menu a {
  width: 200px; /* Set a width if you like */
}
body{
    background-image:url('http://3.bp.blogspot.com/-Nn_iIBCSEG0/VNyNgHDNIoI/AAAAAAAAAms/3GOGTRekLKU/s1600/Beautiful%2BBooks%2B5.jpg');
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
  background-color: #663046; /* Add a grape color to the "active/current" link */
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
 <%-- <a href="returnBook.jsp">Return</a>--%>
  <a href="returnServlet">Return</a>
   <a href="logoutServlet">Log Out</a>
  
</div>
        <br>
       <% String name=(String)session.getAttribute("myName");%>
       <header class="h1" style="color:white;font-size:50px;background-color: #663046; ">Welcome to our library!,<%=name%></header>
        <br>
        <header class="h2" style="color:white;font-size:30px;background-color: #663046; ">What would you like to do?</header>
        <br>
        <div class="vertical-menu">
            <a href="#"
               class="active">Home</a>
               <%--  <a href="addBookOrStudent.html">Add student or book</a> --%>
             <a href="borrowBook.jsp">Borrow book</a> 
             <a href="searchBook.jsp">Search book</a>
             <a href="returnServlet">Return book</a> 
        </div>
      
        
    </body>
</html>

