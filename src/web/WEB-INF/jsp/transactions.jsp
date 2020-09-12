 <%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Transactions</title>
    </head>
    	
    <body>
    <a href="<c:url value='/'/>">root</a>
      <a href="./add_transaction">Add Transaction</a>
	    <table id="transactionsTable">
		    <tr>
		        <th>Id</th>
		        <th>Account Id</th>
		        <th>Date</th>
		        <th>Value</th>
		        <th>Details</th>
		    </tr>
		 <tr>
            <td><input type="text" id="id" onkeyup="Filter(0, id)" ></td>
            <td><input type="text" id="account_id" onkeyup="Filter(1, id)" ></td>
            <td><input type="text" id="date" onkeyup="Filter(2, id)" ></td>
        </tr>
		    <c:forEach items="${transactionsList}" var="transaction" varStatus="status">
		        <tr>
		            <td>${transaction.transaction_id}</td>
		         	<td>${transaction.account.account_id}</td>
		            <td>${transaction.date}</td>
		            <td>${transaction.value}</td>
		            <td>${transaction.details}</td>
		        </tr>
		    </c:forEach>
		</table>
    </body>
    <script>
    function Filter(id, input) {
        var filter, table, tr, td, i, txtValue;
        filter = document.getElementById(input).value.toUpperCase();
        table = document.getElementById("transactionsTable");
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
