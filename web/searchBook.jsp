<%-- 
    Document   : searchBook
    Created on : 04/01/2021, 14:04:14
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <link rel="stylesheet" type="text/css" href="search.css" >
    </head>
    <body>
         <div class="topnav">
  <a  href="main.jsp">Home</a>
  <a href="borrowBook.jsp">Borrow</a>
  <a class="active" href="searchBook.jsp">Search</a>
  <a href="returnServlet">Return</a>
   <a href="logoutServlet">Log Out</a>
   </div>
   
        <% String name=(String)session.getAttribute("myName");%>
        <header  id="header">Let's search a book for you!, <%= name%> </header>

        <form method="post" action="searchServlet">
        <h1>
             <label  class="input" for="desc">Enter description</label>
             <input type="text" id="desc" name="desc"><br><br>
              <br>
        <input type="submit" value="submit">
        </h1>
        
         </form>
        
        <br>
         <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
    </body>
</html>

