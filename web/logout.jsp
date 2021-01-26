<%-- 
    Document   : logout
    Created on : 10/01/2021, 18:39:16
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-image:url('https://image.freepik.com/free-photo/businessman-making-goodbye-sign_254268-27.jpg');
                
            }
        </style>
    </head>
    <body>
        <%--    <% String name=(String)session.getAttribute("myName");%> --%>
         <h1>You're logged out now!!!!</h1>
         <div class="returnHomeButton">
            <button> <a href="index.html"> return to login page</a></button>
        </div>
         
    </body>
</html>
