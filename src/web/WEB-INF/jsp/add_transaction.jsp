    <%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Add Department</title>
    </head>
    	
    <body>
    	<a href="<c:url value='/'/>">root</a>
    	<form:form modelAttribute="transaction" method="POST">
            <table>
                 <tr>
                     <td>Account Id</td>
                     <td><form:input type="text" path="account.account_id"/></td>
                 </tr>
                    <tr>
                     <td>Value</td>
                     <td><form:input type="text" path="value"/></td>
                 </tr>
                 <tr>
                      <td>Details</td>
                     <td><form:input type="text" path="details"/></td>
                 </tr>
                 <tr>
                     <td colspan="2">
                        <input type="submit" value="Add" />
                     </td>
             </table>
        </form:form>
    </body>
</html>