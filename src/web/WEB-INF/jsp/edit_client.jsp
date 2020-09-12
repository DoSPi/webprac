  <%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Edit account</title>
    </head>
    	
    <body>
    	<a href="<c:url value='/'/>">root</a>
    	<form:form modelAttribute="account" method="POST">
    		<table>
    	 		<form:input type="hidden" path="account_id" value="${account.account_id}"/>
    	 		<tr>
    	 			<td> kek</td>
    		 		<td><form:input type="text" path="client.name" value="${account.client.name}"/></td>
    		 	</tr>
    		 </table>
    	</form:form>
    </body>
</html>
