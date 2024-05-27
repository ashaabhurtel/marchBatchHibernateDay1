<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Login Form</h2>
    <form action="loginValidate" method="post">
        <div class="form-group">
            <label for="emailId">Email Address:</label>
            <input type="email" class="form-control" id="emailId" name="emailId" placeholder="Enter email address" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-secondary">Reset</button>
        <a href="register"><button type="button" class="btn btn-warning">SignUp</button></a>
    </form>
    <p>${message}</p>
</div>
</body>
</html>
    