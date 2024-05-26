
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject1web.resources;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author CHRISTIAN
 */
@WebServlet(name = "RegisterServlets", urlPatterns = {"/register"})
public class RegisterServlets extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        
        if (username == null || email == null) {
            out.println("One of the parameters is missing. Please fill out the form completely.");
            return;
        }

        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentdb","root","");
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name, email, password, gender) VALUES(?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            

            int result = ps.executeUpdate();
            if(result > 0){
                response.sendRedirect("index.jsp");
            }else {
                out.println("Error in registration. Please try again!");
            }
            con.close();
        } catch (Exception e){
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }

    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Register Servlet";
    }
}// </editor-fold>


