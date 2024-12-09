<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.pls.cms.model.Car" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Search</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="text"] {
            padding: 8px;
            width: 250px;
            margin-bottom: 20px;
        }
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h1>Search Cars</h1>

    <!-- Search Form -->
    <form action="searchCar" method="get">
        <input type="text" name="searchTerm" placeholder="Search by car name, model or brand" value="${param.searchTerm}" />
        <button type="submit">Search</button>
    </form>

    <!-- Displaying Search Results -->
    <c:if test="${not empty cars}">
        <h2>Search Results</h2>
        <table>
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
                            <!-- Purchase Button with link to the purchase page -->
                            <a href="purchase?carId=${car.carId}">
                                <button>Purchase</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- No Cars Found Message -->
    <c:if test="${empty cars}">
        <p>No cars found based on your search criteria.</p>
    </c:if>

</body>
</html>
