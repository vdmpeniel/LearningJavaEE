package com.example.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get query parameters from the URL
        String name = request.getParameter("name");
        String userAgent = request.getHeader("User-Agent");

        // Generate the response content
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println(
                 "<h1> Http Handling!</h1>" +
                 "<p>" +
                    "<b>Method:</b> GET" + "<br>" +
                    "<b>Name</b>: " + name + "<br>" +
                    "<b>Header User-Agent:</b> " + userAgent +
                 "</p>"
        );
        writer.println("</body></html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get form data from the POST request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Generate the response content
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println(
                "<h1> Thank you for sharing your credentials</h1>" +
                "<p>" +
                    "<b>Username:</b> " + username + "<br>" +
                    "<b>Password</b>: " + password + "<br>" +
                "</p>"
        );
        writer.println("</body></html>");
        writer.close();
    }
}