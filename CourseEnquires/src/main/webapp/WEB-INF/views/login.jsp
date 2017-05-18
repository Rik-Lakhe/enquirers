<%-- 
    Document   : login
    Created on : May 16, 2017, 4:31:34 PM
    Author     : LAKHE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="assets/css/system.css">-->
        <link href="${pageContext.request.contextPath}/assets/css/system.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>login page</h1>
        <h2>Spring custom login page</h2>
        <form method="post">
            <div>
                <label>User Name</label>
                <input type="text" name="username" required="required"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" required="required"/>
            </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Save</button>
        </form>
            
            <img src="${pageContext.request.contextPath}/assets/img/rain.jpg" />
            
                <c:if test="${param.error!=null}">
                    <div style="color:red">error!!!</div>
                </c:if>
            
    </body>
</html>
