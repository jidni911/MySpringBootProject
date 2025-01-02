<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>

    <div class="container mt-5">
        <h1 class="mb-4">Welcome to the Simple JSP Page!</h1>
		
		<!-- Search Form -->
		        <form action="${pageContext.request.contextPath}/search" method="get" class="mb-4">
		            <div class="row">
		                <div class="col-md-3">
		                    <input type="text" name="name" class="form-control" placeholder="Search by Name" >
		                </div>
		                <div class="col-md-3">
		                    <input type="number" name="id" class="form-control" placeholder="Search by ID" >
		                </div>
		                <div class="col-md-3">
		                    <input type="text" name="dob" class="form-control" placeholder="Search by Date of Birth (yyyy-MM-dd)" >
		                </div>
		                <div class="col-md-3">
		                    <input type="number" name="salary" class="form-control" placeholder="Search by Salary" >
		                </div>
		            </div>
		            <button type="submit" class="btn btn-primary mt-3">Search</button>
		        </form>

        <!-- Using JSP Expression Language (EL) to display the current date and time -->
        <p>Current Date and Time: <%= new java.util.Date() %></p>

        <!-- Example of displaying a dynamic value from a Java variable -->
        <%
            String greetingMessage = "Hello, this is a simple JSP page!";
            out.println("<p>" + greetingMessage + "</p>");
        %>

        <!-- Table displaying employee data -->
        <table class="table table-bordered table-striped">
            <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date of Birth</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${empList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.dob}</td>
                        <td>${user.salary}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit/${user.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete/${user.id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Add new employee link -->
        <a href="${pageContext.request.contextPath}/add" class="btn btn-success mt-3">Add New Employee</a>

        <p class="mt-4">Thank you for visiting!</p>
    </div>

</body>
</html>
