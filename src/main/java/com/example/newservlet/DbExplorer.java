package com.example.newservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "DbExplorer", value = "/tables")
public class DbExplorer extends HttpServlet {
    private String pathToFiles;

    public void init() {
        pathToFiles = this.getClass()
                .getClassLoader()
                .getResource("db/")
                .getPath();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String[] dbFiles = new File(pathToFiles).list();
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        for (String file : dbFiles) {
           writer.println("<h1>*" + file + "</h1>");
        }
        writer.println("</body></html>");

    }

    public void destroy() {

    }

}
