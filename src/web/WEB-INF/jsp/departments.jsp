  <%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>departments</title>
    </head>
    	
    <body>
    <a href="<c:url value='/'/>">root</a>
	    <table id="departmentsTable">
		    <tr>
		        <th>Name</th>
		        <th>Address</th>
		    </tr>
		    <c:forEach items="${departmentsList}" var="department" varStatus="status">
		        <tr>
		            <td>${department.name}</td>
		            <td>${department.address}</td>
		        </tr>
		    </c:forEach>
		</table>
    </body>
</html>
