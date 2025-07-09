<html>
<head>
    <title>Login - SQL Injection Demo</title>
</head>
<body>
    <h2>Login (Vulnerable to SQL Injection)</h2>
    <form method="post" action="login">
        <label>Username: <input type="text" name="username" /></label><br/>
        <label>Password: <input type="password" name="password" /></label><br/>
        <input type="submit" value="Login" />
    </form>
    <p>Try: <code>' OR '1'='1</code> as username or password.</p>
    <a href="index.jsp">Back to Home</a>
</body>
</html> 