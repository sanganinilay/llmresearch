package com.cursor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private static final List<String> comments = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String comment = req.getParameter("comment");
        // VULNERABLE: Directly storing and displaying user input
        comments.add("<b>" + name + ":</b> " + comment);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>All Comments (Vulnerable to XSS)</h3>");
        for (String c : comments) {
            out.println("<div>" + c + "</div>");
        }
        out.println("<a href='comment.jsp'>Back to Comment Form</a>");
    }
} 