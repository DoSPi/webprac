<%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Bank</title>
    </head>
    <body>
    	<header>
		    <h1>Bank</h1>
		    <a href="<c:url value='/'/>">root</a>
		    <a href="clients">Clients</a>
		    <a href="accounts">Accounts</a>
		    <a href="departments">Departments</a>
		    <a href="transactions">Transactions</a>
		</header> 
    	
    </body>
</html>