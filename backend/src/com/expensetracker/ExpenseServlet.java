package com.expensetracker;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle adding a new expense (sample logic)
        String category = request.getParameter("category");
        double amount = Double.parseDouble(request.getParameter("amount");
        String user = request.getParameter("user");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expense_db", "root", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO expenses (user, category, amount) VALUES (?, ?, ?)");
            ps.setString(1, user);
            ps.setString(2, category);
            ps.setDouble(3, amount);
            ps.executeUpdate();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/SmartExpenseTracker/frontend/index.html");
    }
}