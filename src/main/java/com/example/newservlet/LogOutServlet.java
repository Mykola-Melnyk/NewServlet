package com.example.newservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class LogOutServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String logout = request.getHeader("logout");
        System.out.println(logout);
        if (Objects.equals(logout, "true")) {
            session.invalidate();
            System.out.println("Logged out successfully!");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Logged out. " + "</h1>");
            out.println("</body></html>");
        }
    }
}
