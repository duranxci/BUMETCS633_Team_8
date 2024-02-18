<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('/images/Budget-Calculator management.webp');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            color: white;
        }
        header {
            background-color: #333;
            color: white;
            padding: 2px;
            text-align: center;
            width: 100%;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        nav ul li {
            margin: 0 20px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 18px;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
	        <h1>User Dashboard</h1>
			
        }
        .content {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            color: #333;
        }
        .btn-primary {
            display: block;
            width: 100%;
            padding: 10px 0;
            background-color: #0052a3;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 18px;
            text-decoration: none;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        .btn-primary:hover {
            background-color: #003366;
        }
        form {
            margin-top: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 8px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
		footer {
		    background-color: #333;
		    color: white;
		    text-align: center;
		    padding: 10px;
		    position: absolute;
		    bottom: 0;
		    width: 100%;
		}
    </style>
</head>
<body>
    <header>
        <div>
            BudgetBuddy
        </div>
        <nav>
            <ul>
                <li><a href="/budgetbuddy">Home</a></li>
                <li><a href="/budgetbuddy/login">Login</a></li>
                <li><a href="/budgetbuddy/register">Register</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1>User Dashboard</h1>
        <div class="content">
            <h2>Add  Expenses</h2>
			<form action="/budgetbuddy/addexpenses" method="post">
			    <label for="incomeAmount">Amount:</label>
			    <input type="text" id="incomeAmount" name="amount" placeholder="Enter amount">
			    <label for="incomeCategory">Category:</label>
			    <input type="text" id="incomeCategory" name="category" placeholder="Enter category">
			    <button class="btn-primary" type="submit">Submit</button>
			</form>
        </div>
    </div>
</body>

<footer>
    &copy; 2024 BudgetBuddy.
</footer>
</html>
