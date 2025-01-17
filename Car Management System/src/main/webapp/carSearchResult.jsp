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
         /* Styling the login button */
                .login-btn {
                    position: fixed; /* Fixed to the top-right corner */
                    top: 10px;
                    right: 10px;
                    padding: 10px 20px;
                    background-color: #4CAF50;
                    color: white;
                    border: none;
                    cursor: pointer;
                    font-size: 16px;
                }

                .login-btn:hover {
                    background-color: #45a049;
                }

                /* Add margin to the page content to make space for the button */
                .content {
                    margin-top: 60px; /* Adjust this based on the height of the button */
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

 <a href="AdminLogin.jsp">
        <button class="login-btn">Login</button>
    </a>

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
                       <a href="purchaseCarForm.jsp?carId=<%= car.getCarId() %>">
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
