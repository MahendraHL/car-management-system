<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Car Search Results</title>
</head>
<body>

<h2>Search Results</h2>

<form action="searchCar" method="get">
    <label for="carName">Car Name:</label>
    <input type="text" id="carName" name="carName" value="${param.carName}">

    <label for="model">Model:</label>
    <input type="text" id="model" name="model" value="${param.model}">

    <label for="brand">Brand:</label>
    <input type="text" id="brand" name="brand" value="${param.brand}">

    <button type="submit">Search</button>
</form>

<table border="1">
    <thead>
        <tr>
            <th>Car Name</th>
            <th>Model</th>
            <th>Brand</th>
            <th>Description</th>
            <th>Price</th>
            <th>Car Type</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.carName}</td>
                <td>${car.model}</td>
                <td>${car.brand}</td>
                <td>${car.description}</td>
                <td>${car.price}</td>
                <td>${car.carType}</td>
                <td>
                    <a href="purchasePage.jsp?carId=${car.carId}">Purchase</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
