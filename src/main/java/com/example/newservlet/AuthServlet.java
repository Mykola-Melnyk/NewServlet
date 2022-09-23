package com.example.newservlet;

import java.io.*;
import java.util.Objects;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "authServlet", value = "/authServlet")
public class AuthServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String hardLogin = "admin";
        String hardPassword = "s3cr3t";
        String myLogin = request.getHeader("login");
        String myPassword = request.getHeader("password");
        System.out.println(myLogin + " " + myPassword);
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        if (Objects.equals(hardLogin, myLogin) && Objects.equals(hardPassword, myPassword)) {
            System.out.println("Login successful!");
            writer.println("<h1>Login successful</h1>");
            session.setAttribute("login", myLogin);
            session.setAttribute("password", myPassword);
        } else {
            System.out.println("Wrong credentials!");
            writer.println("<h1>Wrong credentials!!!</h1>");
        }
        writer.println("</body></html>");
    }

    public void destroy() {
    }
}