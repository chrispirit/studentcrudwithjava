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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        
        PrintWriter out = response.getWriter();

        Connection con = null;
        PreparedStatement ps = null;

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "");
             String sql = "UPDATE student SET name = ?, gender = ?, email= ? WHERE id = ?";
                ps = con.prepareStatement(sql);
                
                ps.setString(1, username);
                ps.setString(2, gender);
                ps.setString(3, email);
                ps.setInt(4, id);
                
                int result = ps.executeUpdate();

                if (result > 0){
                    response.sendRedirect("view.html");
                }else {
                    out.println("Error in updating please try again!");
                }
            }
         catch (Exception e ){
             e.printStackTrace();
             out.println("Error:" +e.getMessage());
         } finally {
            try{
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public String getServletInfo(){
        return "Update student servlet";
    }

    

}

