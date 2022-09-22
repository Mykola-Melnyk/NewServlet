package com.example.newservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CRUDFile", value = "/table/*")
public class CRUDFile extends HttpServlet {
    private String pathToFile;
    private String fileName;

    public void init() {
        pathToFile = this.getClass()
                .getClassLoader()
                .getResource("db/")
                .getPath();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        fileName = request.getPathInfo();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        fileName = request.getPathInfo();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        fileName = request.getPathInfo();
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        fileName = request.getPathInfo();
        File file = new File(pathToFile + fileName);
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        if (file.delete()) {
            System.out.println("File " + file.getName() + " deleted.");
            writer.println("<h1>File " + file.getName() + " deleted.</h1>");
        } else {
            System.out.println("File " + file.getName() + " not found.");
            writer.println("<h1>File " + file.getName() + " not found.</h1>");
        }
        writer.println("</body></html>");
    }

    public void destroy() {
    }
}
