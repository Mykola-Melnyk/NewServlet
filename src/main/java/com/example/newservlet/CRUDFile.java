package com.example.newservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

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
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><pre><h1>");
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile + fileName)) {
            int dataByte;
            while ((dataByte = fileInputStream.read()) != -1) {
                writer.print((char) dataByte);
            }
            writer.println("</h1></pre></body></html>");
        } catch (FileNotFoundException fnfe) {
            writer.print("<h1>File doesn't exist</h1>");
            writer.println("</h1></body></html>");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        fileName = request.getPathInfo();
        File file = new File(pathToFile + fileName);
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        if (file.createNewFile()) {
            System.out.println("File " + file.getName() + " created.");
            writer.println("<h1>File " + file.getName() + " created.</h1>");
        } else {
            System.out.println("File " + file.getName() + " already exists.");
            writer.println("<h1>File " + file.getName() + " already exists.</h1>");
        }
        writer.println("</body></html>");
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
