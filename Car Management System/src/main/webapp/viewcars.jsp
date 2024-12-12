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
            background-color: #f4f4f4;
        }

        /* Styling the login button */
        .login-btn {
            position: fixed; /* Fixed to the top-right corner */
            top: 10px;
            right: 10px;
            padding: 10px 20px;
            background-color: #007BFF; /* Blue color */
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        .login-btn:hover {
            background-color: #0056b3;
        }

        /* Add margin to the page content to make space for the button */
        .content {
            margin-top: 60px; /* Adjust this based on the height of the button */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        input[type="text"] {
            padding: 8px;
            width: 250px;
            margin-bottom: 20px;
            border-radius: 4px;
        }

        button {
            padding: 10px 15px;
            background-color: #007BFF; /* Blue color */
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Media Queries for responsiveness */
        @media (max-width: 768px) {
            table {
                width: 100%;
                font-size: 14px;
            }

            input[type="text"] {
                width: 100%;
                padding: 10px;
            }

            .login-btn {
                top: 10px;
                right: 10px;
                font-size: 14px;
                padding: 8px 16px;
            }

            .content {
                margin-top: 70px; /* Adjust space for the button */
            }
        }

        @media (max-width: 480px) {
            button {
                padding: 8px 12px;
                font-size: 14px;
            }x

            .login-btn {
                top: 10px;
                right: 10px;
                font-size: 14px;
                padding: 8px 16px;
            }

            table th, table td {
                font-size: 12px;
                padding: 8px;
            }
        }
    </style>
</head>
<body>

    <h1>View Cars</h1>

    <!-- Displaying Search Results -->
    <%
        List<Car> cars = (List<Car>) request.getAttribute("getCars");
        if (cars != null && !cars.isEmpty()) {
    %>
   <table>
       <thead>
           <tr>
               <th>Car Id</th>
               <th>Car Name</th>
               <th>Model</th>
               <th>Brand</th>
               <th>Car Type</th> <!-- Car Type Column -->
               <th>Description</th> <!-- Description Column -->
               <th>Price</th>
               <th>Action</th>
           </tr>
       </thead>
       <tbody>
           <% for (Car car : cars) { %>
               <tr>
                   <td><%= car.getCarId() %></td>
                   <td><%= car.getCarName() %></td>
                   <td><%= car.getModel() %></td>
                   <td><%= car.getBrand() %></td>
                   <td><%= car.getCarType() %></td> <!-- Correctly display Car Type -->
                   <td><%= car.getDescription() %></td> <!-- Correctly display Description -->
                   <td><%= car.getPrice() %></td>
                  <td>
                      <!-- Edit Car Button -->
                      <a href="editcar.jsp?carId=<%= car.getCarId() %>&carName=<%= car.getCarName() %>&model=<%= car.getModel() %>&brand=<%= car.getBrand() %>&carType=<%= car.getCarType() %>&description=<%= car.getDescription() %>&price=<%= car.getPrice() %>">
                          <button>Edit</button>
                      </a>


                       <!-- Delete Car Button -->
                       <a href="deleteCar?carId=<%= car.getCarId() %>" onclick="return confirm('Are you sure you want to delete this car?');">
                           <button>Delete</button>
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
