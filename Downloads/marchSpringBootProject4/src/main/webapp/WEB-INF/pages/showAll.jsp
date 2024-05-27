<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show All Records</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>All Employee Records</h2>

    <form action="fetchAllRecords" method="get">
        <div class="form-group">
            <label for="sortOption">Sort By:</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="sortByName" name="sortBy" value="name" checked>
                <label class="form-check-label" for="sortByName">Name</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="sortByID" name="sortBy" value="id">
                <label class="form-check-label" for="sortByID">ID</label>
            </div>
            <button type="submit" class="btn btn-primary">Apply</button>
        </div>
    </form>

    <table class="table table-hover">
        <thead>
            <tr bgcolor="yellow">
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Salary</th>
                <th>Email address</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employeeDtoList}" var="employee">
                <tr bgcolor="pink">
                    <td>${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.emailId}</td>
                    <td>${employee.password}</td>
                    <td>
                        <a href="editEmployee?employeeId=${employee.employeeId}" class="btn btn-primary">Edit</a>
                        <a href="deleteEmployee?employeeId=${employee.employeeId}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
