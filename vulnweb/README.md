# vulnweb

A deliberately vulnerable Java web application for demonstrating and testing common web security flaws, specifically SQL Injection and Cross-Site Scripting (XSS).

## Features
- Simple login form vulnerable to SQL Injection
- Comment or message form vulnerable to XSS
- File read endpoint vulnerable to Path Traversal (Directory Traversal)

## Usage
This project is for educational and testing purposes only. Do not deploy in production environments.

### Path Traversal Vulnerability
This app includes a deliberately vulnerable endpoint for demonstrating directory traversal attacks:

- **Endpoint:** `/readfile?path=<file_path>`
- **Description:** Reads and returns the contents of any file on the server specified by the `path` parameter, with no validation or sanitization. This is vulnerable to directory traversal (e.g., `../../etc/passwd`).
- **Example:** `http://localhost:8080/readfile?path=../../etc/passwd`

**Warning:** This is intentionally insecure and should only be used in a safe, isolated environment for educational purposes.

## Getting Started
- Build and run with Maven or your preferred Java IDE.
- Access the app in your browser at `http://localhost:8080/` (default).

## Author
Generated via prompting to Cursor. 