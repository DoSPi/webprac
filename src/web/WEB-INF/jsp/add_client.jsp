   <%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Edit Client</title>
    </head>
    	
    <body>
    	<a href="<c:url value='/'/>">root</a>
    	<form:form modelAttribute="client" method="POST">
    	    <form:input type="hidden" path="client_id" value="${client_id}"/>
            <table>
                 <tr>
                     <td>Name</td>
                     <td><form:input type="text" path="name"/></td>
                 </tr>
                                   <tr>
                     <td>Address</td>
                     <td><form:input type="text" path="address"/></td>
                 </tr>
                 <tr>
                 <td>Email</td>
                     <td><form:input type="text" path="email"/></td>
                 </tr>
                 <tr>
                 <td>Phone Number</td>
                     <td><form:input type="text" path="phone_number"/></td>
                 </tr>
                 <tr>
                     <td colspan="2">
                        <input type="submit" id="add" value="Add" />
                     </td>
             </table>
        </form:form>
    </body>
</html>
