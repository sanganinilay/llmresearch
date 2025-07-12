<html>
<head>
    <title>Path Manipulation Demo (Directory Traversal)</title>
</head>
<body>
    <h1>Path Manipulation (Directory Traversal)</h1>
    <form method="get" action="/vulnweb/readfile">
        <label for="path">File Path:</label>
        <input type="text" id="path" name="path" size="50" placeholder="e.g. ../../etc/passwd" required />
        <button type="submit">Read File</button>
    </form>
    <p><a href="index.jsp">Back to Home</a></p>
    <p><strong>Warning:</strong> This page demonstrates a directory traversal vulnerability. Do not use in production.</p>
</body>
</html> 