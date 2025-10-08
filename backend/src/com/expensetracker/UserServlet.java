package com.expensetracker;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle user registration (sample logic)
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expense_db", "root", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/SmartExpenseTracker/frontend/index.html");
    }
}