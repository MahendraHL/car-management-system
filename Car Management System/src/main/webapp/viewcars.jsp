<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pls.cms.model.Car" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Cars</title>
    <style>
        /* Body styling */
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            background-color: #f4f7fa;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #007BFF;
            margin-bottom: 20px;
        }

        /* Table styling */
        table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        td button {
            background-color: #28a745; /* Green color for Edit and Delete buttons */
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        td button:hover {
            background-color: #218838;
        }

        td form button {
            background-color: #dc3545; /* Red color for Delete button */
        }

        td form button:hover {
            background-color: #c82333;
        }

        /* Form styling for search or other actions */
        .action-buttons {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .action-buttons form input[type="text"] {
            padding: 8px 16px;
            font-size: 14px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }

        .action-buttons form button {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .action-buttons form button:hover {
            background-color: #0056b3;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            table {
                font-size: 14px;
            }

            .action-buttons form input[type="text"] {
                width: 100%;
                padding: 10px;
            }

            .action-buttons form button {
                width: 100%;
            }
        }

        @media (max-width: 480px) {
            th, td {
                font-size: 12px;
                padding: 10px;
            }
        }
    </style>
</head>
<body>

    <h1>View Cars</h1>

    <c:if test="${not empty deleteMessage}">
            <div class="alert">
                <p>${deleteMessage}</p>
            </div>
        </c:if>

    <!-- Displaying Search Results -->
    <%
        List<Car> cars = (List<Car>) request.getAttribute("getCars");
        if (cars != null && !cars.isEmpty()) {
    %>

    <!-- Table of cars -->
    <table>
        <thead>
            <tr>
                <th>Car Id</th>
                <th>Car Name</th>
                <th>Model</th>
                <th>Brand</th>
                <th>Car Type</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (Car car : cars) { %>
                <tr>
                    <td><%= car.getCarId() %></td>
                    <td><%= car.getCarName() %></td>
                    <td><%= car.getModel() %></td>
                    <td><%= car.getBrand() %></td>
                    <td><%= car.getCarType() %></td>
                    <td><%= car.getDescription() %></td>
                    <td><%= car.getPrice() %></td>
                    <td>
                        <!-- Edit Car Button -->
                        <form action="editcar.jsp" method="get" style="display:inline;">
                            <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                            <button type="submit">Edit</button>
                        </form>
                        <!-- Delete Car Button -->
                        <form action="deleteCar" method="POST" onsubmit="return confirm('Are you sure you want to delete this car?');" style="display:inline;">
                            <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <% } else { %>
        <p>No cars found based on your search criteria.</p>
    <% } %>

</body>
</html>
