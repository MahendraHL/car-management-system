<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Admin</title>
    <style>
        /* Basic reset for margin and padding */
        body, h2 {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
        }
        /* Body style */
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            text-align: center;
            padding: 20px;
        }
        /* Welcome header */
        h2 {
            color: #333;
            font-size: 32px;
            margin-bottom: 40px;
            font-weight: bold;
            letter-spacing: 1px;
        }
        /* Button container */
        .button-container {
            display: flex;
            justify-content: center;
            gap: 25px;
            flex-wrap: wrap;  /* To handle wrapping on small screens */
        }
        /* Button styles */
        button {
            padding: 15px 30px;
            font-size: 18px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            box-shadow: 0 4px 6px rgba(0, 123, 255, 0.3);
        }
        /* Button hover effect */
        button:hover {
            background-color: #0056b3;
            transform: translateY(-3px);
            box-shadow: 0 6px 10px rgba(0, 123, 255, 0.5);
        }
        /* Link removal for anchor */
        a {
            text-decoration: none;
        }
        /* Responsive design */
        @media (max-width: 600px) {
            h2 {
                font-size: 28px;
                margin-bottom: 20px;
            }
            .button-container {
                flex-direction: column;
                align-items: center;
            }
            button {
                font-size: 16px;
                width: 90%;
                margin-bottom: 15px;
            }
        }
    </style>
</head>
<body>
    <h2>Welcome Admin</h2>
    <div class="button-container">
        <a href="car.jsp">
            <button>Add Cars</button>
        </a>

    <form action="viewAllCars" method="get">
    <a href="viewcars.jsp">
        <button>View Cars</button>
    </a>
    </form>
    </div>
</body>
</html>