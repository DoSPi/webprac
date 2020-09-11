 <%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Accounts</title>
    </head>
    	
    <body>
    <a href="<c:url value='/'/>">root</a>
	    <table id="AccountsTable">
		    <tr>
		        <th>ID</th>
		        <th>Type</th>
		        <th>Department</th>
		        <th>Client ID</th>
		        <th>Balance</th>
		        <th>Opening date </th>
		        <th>Target ID</th>
		        <th>Closed</th>
		    </tr>
		 <tr>
            <td><input type="text" id="id" onkeyup="Filter(0, id)" ></td>
            <td><input type="text" id="type" onkeyup="Filter(1, id)" ></td>
            <td><input type="text" id="department" onkeyup="Filter(2, id)"></td>
        </tr>
		    <c:forEach items="${accountsList}" var="account" varStatus="status">
		        <tr>
		            <td>${account.account_id}</td>
		            <td>${account.type.name}</td>
		            <td>${account.department.name}</td>
		            <td>${account.client.client_id}</td>
		            <td>${account.balance}</td>
		            <td>${account.date}</td>
		            <td>${account.payment_account.account_id}</td>
		            <td>${account.closed}</td>
		        </tr>
		    </c:forEach>
		</table>
    </body>
    <script>
    function Filter(id, input) {
        var filter, table, tr, td, i, txtValue;
        filter = document.getElementById(input).value.toUpperCase();
        table = document.getElementById("AccountsTable");
        tr = table.getElementsByTagName("tr");
        for (i = 2; i < tr.length; ++i) {
            td = tr[i].getElementsByTagName("td")[id];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</html>
