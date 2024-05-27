 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject1web.resources;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.mavenproject1web.resources.Student;

/**
 *
 * @author CHRISTIAN
 */
@WebServlet(name = "ViewServlet", urlPatterns = {"/view.html"})
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Student> students = new ArrayList<>();
        
        try(Connection con = DatabaseUtil.getConnection()){
            String sql = "SELECT * FROM student";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                students.add(new Student(id, name, email, gender));
                
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        request.setAttribute("allStudents", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
}
    @Override 
    public String getServletInfo() {
        return "Short description";
    }
}
