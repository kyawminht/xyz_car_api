<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Car for Sale</title>
</head>
<body>
    <h2>Post Car for Sale</h2>
    <form action="/api/cars/post" method="post">
        Make: <input type="text" name="make" required><br>
        Model: <input type="text" name="model" required><br>
        Registration: <input type="text" name="registration" required><br>
        Price: <input type="number" name="price" required><br>
        <!-- Add more fields as needed -->
        <button type="submit">Post for Sale</button>
    </form>
</body>
</html>
