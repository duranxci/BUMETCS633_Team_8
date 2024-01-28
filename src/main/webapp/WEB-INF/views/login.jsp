<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BudgetBuddy - Login</title>
    <style>
		body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    color: white;
		}

		header {
		    background-color: #333;
		    color: white;
		    padding: 10px;
		    text-align: center;
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

		h1 {
		    text-align: center;
		    margin-top: 50px;
		}

		section {
		    text-align: center;
		    margin: 20px;
		}

		form {
		    background-color: white;
		    border-radius: 5px;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
		    padding: 20px;
		    max-width: 400px;
		    margin: 0 auto;
		    display: flex;
		    justify-content: flex-start;
		    align-items: center;
		    flex-direction: column;
		}

		label {
		    display: block;
		    margin-bottom: 5px;
		    font-weight: bold;
		}

		input[type="text"],
		input[type="email"],
		input[type="password"] {
		    width: 100%;
		    padding: 10px;
		    margin-bottom: 10px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		}

		button {
		    padding: 10px 20px;
		    background-color: #007acc;
		    color: white;
		    border: none;
		    cursor: pointer;
		    border-radius: 5px;
		}

		button:hover {
		    background-color: #005fbb;
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

		/* Additional styles for the background image */
		body {
		    background-image: url('/images/Budget-Calculator.jpg');
		    background-size: cover;
		    background-position: center;
		    background-attachment: fixed;
		}
      
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="/budgetbuddy" style="color: white;">Home</a></li>
                <li><a href="/budgetbuddy/login" style="color: white;">Login</a></li>
                <li><a href="/budgetbuddy/register" style="color: white;">Register</a></li>
            </ul>
        </nav>
    </header>

    <h1>Login to BudgetBuddy</h1>

    <section>
        <form id="loginForm">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit">Login</button>
        </form>
    </section>

    <section>
        <p>Don't have an account? <a href="/budgetbuddy/register">Register here</a></p>
        
    </section>
</body>
<footer>
    &copy; 2024 BudgetBuddy
</footer>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function setJwtInCookie(jwtResponse) {
        console.log("Token: " + jwtResponse['token'] + " Expiry: " + jwtResponse['expiry']);
        document.cookie = "jwtToken=" + jwtResponse['token'] + "; expires=" + jwtResponse['expiry'];
    }
    $(document).ready(function() {
        $('#loginForm').submit(function(event) {
            event.preventDefault();
            const formData = {
                username: $('input[name="username"]').val().toLowerCase(),
                password: $('input[name="password"]').val(),
            };

            $.ajax({
                type: 'POST',
                url: '/api/login',
                contentType: 'application/json',
                data: JSON.stringify(formData),
                success: function(response) {
                    console.log(response)
                    setJwtInCookie(response);
                    alert("Authentication passed successfully, redirect to your dashboard.");
                    window.location.replace("/BudgetBuddy/dashboard");
                },
                error: function(error) {
                    alert("Authentication failed, please try again");
                    console.error('Login failed:', error);
                }
            });
        });
    });
</script>
</html>