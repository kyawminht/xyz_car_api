<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Search</title>
</head>
<body>
    <h2>Car Search</h2>
    <form action="/api/cars/search" method="get">
        Make: <input type="text" name="make"><br>
        Model: <input type="text" name="model"><br>
        Registration: <input type="text" name="registration"><br>
        Price Range: <input type="number" name="minPrice" placeholder="Min Price"> - 
                     <input type="number" name="maxPrice" placeholder="Max Price"><br>
        <button type="submit">Search</button>
    </form>

    <h3>Search Results</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Make</th>
                <th>Model</th>
                <th>Registration</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the search results and display them in the table -->
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.registration}</td>
                    <td>${car.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
