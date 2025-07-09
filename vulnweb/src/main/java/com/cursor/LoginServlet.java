package com.cursor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:hsqldb:mem:vulndb;shutdown=true";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASS = "sa";

    @Override
    public void init() throws ServletException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(50), password VARCHAR(50))");
            stmt.execute("INSERT INTO users VALUES ('admin', 'admin')");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter();
             Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            Statement stmt = conn.createStatement();
            // VULNERABLE: Directly concatenating user input
            String sql = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                out.println("<h3>Login successful! Welcome, " + username + "</h3>");
            } else {
                out.println("<h3>Login failed!</h3>");
            }
            out.println("<a href='login.jsp'>Back to Login</a>");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
} 