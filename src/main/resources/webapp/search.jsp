<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Car Search</title>
</head>
<body>

<h2>Car Search</h2>

<form action="/api/cars/search" method="get">
    <label for="make">Make:</label>
    <input type="text" id="make" name="make">
    <br>
    <label for="model">Model:</label>
    <input type="text" id="model" name="model">
    <br>
    <label for="registration">Registration:</label>
    <input type="text" id="registration" name="registration">
    <br>
    <label for="minPrice">Min Price:</label>
    <input type="number" id="minPrice" name="minPrice">
    <br>
    <label for="maxPrice">Max Price:</label>
    <input type="number" id="maxPrice" name="maxPrice">
    <br>
    <button type="submit">Search</button>
</form>

</body>
</html>

