<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Purchase Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
        .message {
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            text-align: center;
        }
        .message.success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .message.error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Car</h2>

        <!-- Display success or error message -->
        <%
            String message = (String) request.getAttribute("message");
            String messageType = (String) request.getAttribute("messageType");
            if (message != null && messageType != null) {
        %>
            <div class="message <%= messageType %>">
                <%= message %>
            </div>
        <%
            }
        %>

        <form action="addCar" method="post">
            <div class="form-group">
                <label for="carId">Car ID:</label>
                <input type="number" id="carId" name="carId" placeholder="Enter the car Id" required>
            </div>

            <div class="form-group">
                <label for="carname">Car Name:</label>
                <input type="text" id="carname" name="carname" placeholder="Enter Car Name" required>
            </div>

            <div class="form-group">
                <label for="carType">Car Type:</label>
                <input type="text" id="carType" name="carType" placeholder="Enter Car Type" required>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" placeholder="Enter car Description" required>
            </div>

            <div class="form-group">
                <label for="brand">Car Brand:</label>
                <input type="text" id="brand" name="brand" placeholder="Enter Car Brand" required>
            </div>

            <div class="form-group">
                <label for="model">Car Model:</label>
                <input type="text" id="model" name="model" placeholder="Enter Year Car of manufactured" required>
            </div>

            <div class="form-group">
                <label for="price">Car Price:</label>
                <input type="text" id="price" name="price" placeholder="Enter Car Price" required>
            </div>

            <div class="form-group">
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>
