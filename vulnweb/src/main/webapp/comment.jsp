<html>
<head>
    <title>Comment - XSS Demo</title>
</head>
<body>
    <h2>Leave a Comment (Vulnerable to XSS)</h2>
    <form method="post" action="comment">
        <label>Name: <input type="text" name="name" /></label><br/>
        <label>Comment: <textarea name="comment"></textarea></label><br/>
        <input type="submit" value="Post Comment" />
    </form>
    <p>Try: <code>&lt;script&gt;alert('XSS')&lt;/script&gt;</code> as a comment.</p>
    <a href="index.jsp">Back to Home</a>
</body>
</html> 