<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.pls.cms.model.Car" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Car</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            width: 50%;
            margin: auto;
        }
        label, input, button {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        // JavaScript to show alert on form submission
        function showSuccessMessage(event) {
            alert("Car details edited successfully!");
        }
    </script>
</head>
<body>
    <h1>Edit Car</h1>
    <form action="updateCar" method="post" onsubmit="showSuccessMessage(event)">
        <input type="hidden" name="carId" value="<%= request.getParameter("carId") %>">

        <label for="carName">Name:</label>
        <input type="text" name="carName" id="carName" value="<%= request.getParameter("carName") %>" required>

        <label for="carType">Type:</label>
        <input type="text" name="carType" id="carType" value="<%= request.getParameter("carType") %>" required>

        <label for="description">Description:</label>
        <input type="text" name="description" id="description" value="<%= request.getParameter("description") %>" required>

        <label for="brand">Brand:</label>
        <input type="text" name="brand" id="brand" value="<%= request.getParameter("brand") %>" required>

        <label for="model">Model:</label>
        <input type="text" name="model" id="model" value="<%= request.getParameter("model") %>" required>

        <label for="price">Price:</label>
        <input type="text" name="price" id="price" value="<%= request.getParameter("price") %>" required>

        <button type="submit">Save Changes</button>
    </form>
</body>
</html>
