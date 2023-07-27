package com.example.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value="/myJsonServlet", loadOnStartup=1)
public class MyJsonServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the JSON data from the request body
        BufferedReader reader = request.getReader();
        StringBuilder requestData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestData.append(line);
        }
        reader.close();

        // Parse the JSON data
        JSONObject jsonData = new JSONObject(requestData.toString());

        // Retrieve values from JSON
        String username = jsonData.getString("username");
        String password = jsonData.getString("password");

        // Set the content type of the response to JSON
        response.setContentType("application/json");

        PrintWriter writer = response.getWriter();
        writer.println(createJsonStringFromMap(username, password));
//        writer.println(createJsonStringManually(username, password));
        writer.close();
    }

    private String createJsonStringFromMap(String username, String password){
        JSONObject credentials = new JSONObject(){{
            put("message", "Thank you for sharing your credentials");
            put("username", username);
            put("password", password);
        }};
        return credentials.toString();
    }

    private String createJsonStringManually(String username, String password){
        return String.format(
                """ 
                {
                    \"message\": \"Thank you for sharing your credentials\",
                    \"username\": \"%s\",
                    \"password\": \"%s\"
                }
                """, username, password
        );
    }

}
