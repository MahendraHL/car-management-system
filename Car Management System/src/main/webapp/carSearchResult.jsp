<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pls.cms.model.Car" %>

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
         <input type="text" name="searchTerm" placeholder="Search by car name, model or brand"
                   value="<%= (request.getParameter("searchTerm") != null) ? request.getParameter("searchTerm") : "" %>" />
            <button type="submit">Search</button>
    </form>

    <!-- Displaying Search Results -->
    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null && !cars.isEmpty()) {
    %>
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
                <% for (Car car : cars) { %>
                    <tr>
                        <td><%= car.getCarName() %></td>
                        <td><%= car.getModel() %></td>
                        <td><%= car.getBrand() %></td>
                        <td><%= car.getDescription() %></td>
                        <td><%= car.getPrice() %></td>
                        <td><%= car.getCarType() %></td>
                        <td>
                            <a href="purchase?carId=<%= car.getCarId() %>">
                                <button>Purchase</button>
                            </a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <%
        } else {
    %>
        <p>No cars found based on your search criteria.</p>
    <%
        }
    %>

</body>
</html>
