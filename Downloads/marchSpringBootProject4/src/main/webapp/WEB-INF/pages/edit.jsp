<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Edit Employee Details</h2>
    <form action="updateEmployee" method="post">
        <div class="form-group">
            <input type="hidden" name="employeeId" value="${employeeDTO.employeeId}">
            <label for="employeeName">Employee Name:</label>
            <input type="text" class="form-control" id="employeeName" name="employeeName" value="${employeeDTO.employeeName}" required>
        </div>
        <div class="form-group">
            <label for="salary">Salary:</label>
            <input type="number" class="form-control" id="salary" name="salary" value="${employeeDTO.salary}" required>
        </div>
        <div class="form-group">
            <label for="emailId">Email Address:</label>
            <input type="email" class="form-control" id="emailId" name="emailId" value="${employeeDTO.emailId}" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="${employeeDTO.password}" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
