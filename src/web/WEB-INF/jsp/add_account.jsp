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
                 <tr>
                     <td>Client Id</td>
                     <td><form:input type="text" path="client.client_id"/></td>
                 </tr>
                                   <tr>
                     <td>Payment Account Id</td>
                     <td><form:input type="text" path="payment_account.account_id"/></td>
                 </tr>
                 <tr>
                 <td>Type  Id</td>
                     <td><form:input type="text" path="type.type_id"/></td>
                 </tr>
                  <tr>
                 <tr>
                     <td colspan="2">
                        <input type="submit" value="Add" />
                     </td>
             </table>
        </form:form>
    </body>
</html>
