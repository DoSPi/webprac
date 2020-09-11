<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Clients</title>
    </head>
    	
    <body>
    <a href="<c:url value='/'/>">root</a>
	    <table id="ClientsTable">
		    <tr>
		        <th>ID</th>
		        <th>Name</th>
		        <th>Address</th>
		        <th>Email</th>
		        <th>Phone number</th>
		    </tr>
		 <tr>
            <td><input type="text" id="id" onkeyup="Filter(0, id)" ></td>
            <td><input type="text" id="name" onkeyup="Filter(1, id)" ></td>
        </tr>
		    <c:forEach items="${clientsList}" var="client" varStatus="status">
		        <tr>
		            <td>${client.client_id}</td>
		            <td>${client.name}</td>
		            <td>${client.address}</td>
		            <td>${client.email}</td>
		            <td>${client.phone_number}</td>
		        </tr>
		    </c:forEach>
		</table>
    </body>
    <script>
    function Filter(id, input) {
        var filter, table, tr, td, i, txtValue;
        filter = document.getElementById(input).value.toUpperCase();
        table = document.getElementById("ClientsTable");
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
