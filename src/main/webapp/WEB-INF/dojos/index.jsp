<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<title>Dojos</title>
	</head>
	<body>
		<div id="dojos">
		    <h1>Dojos</h1>		    
		    <!-- for loop to create all the links -->
		    <c:forEach begin="1" end="${totalPages}" var="index">
		        <a href="/pages/${index}">${index}</a>
		    </c:forEach>
		    <table class="table">
		        <thead>
		        	<th>Dojo</th>
		            <th>First Name</th>
		            <th>Last Name</th>
		        </thead>
		        <tbody>
		            <!--  we have to call the .content method to actually get the dojos inside the Page iterable -->
		            <c:forEach var="dojo" items="${dojos.content}">                 
		            <tr>
		                <td><c:out value="${dojo[0].getName()}"></c:out></td>
		                <td><c:out value="${dojo[1].getfirstName()}"></c:out></td>
		                <td><c:out value="${dojo[1].getlastName()}"></c:out></td>
		            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>
	</body>
</html>