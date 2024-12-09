<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <style>
        /* Basic reset for margin and padding */
        body, h1, p {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Body style */
        body {
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Form container */
        .login-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        /* Form title */
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Input fields */
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        /* Button style */
        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Label style */
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
            color: #555;
        }

        /* Responsive design */
        @media (max-width: 600px) {
            .login-container {
                width: 90%;
                padding: 20px;
            }

            button {
                font-size: 14px;
            }

            input[type="text"], input[type="password"] {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Admin Login</h1>
        <form action="adminlogin" method="post">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email" placeholder="Enter your email" required>

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" required>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
