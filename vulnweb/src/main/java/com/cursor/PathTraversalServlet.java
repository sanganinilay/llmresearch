package com.cursor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/readfile")
public class PathTraversalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filePath = req.getParameter("path");
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        if (filePath == null || filePath.isEmpty()) {
            out.println("Usage: /readfile?path=<file_path>");
            return;
        }
        // VULNERABLE: No validation or sanitization of the file path (Directory Traversal)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            out.println("File not found: " + filePath);
        } catch (IOException e) {
            out.println("Error reading file: " + e.getMessage());
        }
    }
} 