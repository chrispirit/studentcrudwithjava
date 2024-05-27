<%-- 
    Document   : index
    Created on : May 23, 2024, 11:16:26 PM
    Author     : CHRISTIAN
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.mavenproject1web.resources.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Students</title>
        <link rel="stylesheet" href="./style2.css">

    </head>
    <body>
       <section>
            <div class="head">
                <p>List of student</p>
            </div>
            <div class="add">
                <div id="myBtna" class="btn-add">
                    Add Student
                </div>
            </div>
            <div class="table">
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>EMAIL</th>
                        <th>GENDER</th>
                        <th>ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${allStudents}">
                    <tr>
                        <td><c:out value="${student.id}"/></td> 
                        <td><c:out value="${student.username}"/></td>
                        <td><c:out value="${student.email}"/></td>
                        <td><c:out value="${student.gender}"/></td>
                        <td>
                            <div id="action">
                                <div class="btn-update myBtn" data-id="${student.id}"
                                     data-gender="${student.gender}"
                                     data-email="${student.email}"
                                     data-name="${student.username}">
                                        Update
                                    </div>
                                    <div class="btn-delete">
                                        <form action="delete" method="post">
                                            <input type="hidden" name="id" value="${student.id}">
                                            <button class="btn-delete" type="submit">Delete</button>
                                        </form>
                                    </div>
                            </div>
                                            
                        </td>
                    </tr>
                    </c:forEach>
                    
                    <c:if test="${empty allStudents}">
                        <tr><td colspan="5">No student available</td></tr>
                    </c:if>
                </tbody>
                </table>
            </div>
        </section>
                
        <!-- The Modal -->
        <div id="myModal" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>Update Student</p>
                <form action="update" method="post">
                    
                    <input type="hidden" name="id" id="studentId"/>
                    <div class="inputbox">
                        <label>Name</label>
                        <input type="text" name="name" id="studentName" required placeholder="Change your name"/>
                    </div>
                    <div class="inputbox">
                        <label>Gender</label>
                        <select required name="gender" id="studentGender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                    <button class="btn">Modify</button>
                </form>
            </div>
        
        </div>
        <div id="myModala" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
            <span class="close1">&times;</span>
            <p>Add Student</p>
            <form action="register" method="post">
                
                
                <div class="inputbox">
                    <label>Name</label>
                    <input type="text" name= "username" required placeholder="Enter your name"/>
                </div>
                <div class="inputbox">
                    <label>Email</label>
                    <input type="email" name="email" required placeholder="Enter your email"/>
                </div>
                <div class="inputbox">
                    <label>Password</label>
                    <input type="password" name="password" required placeholder="Enter your password"/>
                </div>

                <div class="inputbox">
                    <label>Gender</label>
                    <select name="gender">
                        <option>Male</option>
                        <option>Female</option>
                    </select>
                </div>
                <button class="btn">Create</button>
            </form>
            </div>
        
        </div>
        <script>
                // Get the modal
                var modal = document.getElementById("myModal");
                var modala = document.getElementById("myModala");

    // Get the button that opens the modal
                
                var btn = document.getElementsByClassName("myBtn");
                var btna = document.getElementById("myBtna");
                
                console.log("Found ", btn.length, " btn of same class");
                
                for(var i = 0; i < btn.length; i++){
                    console.log("btn modal click initialized");
                    btn[i].addEventListener('click', function(){
                        
                        var id = this.getAttribute('data-id');
                        var name = this.getAttribute('data-name');
                        var gender = this.getAttribute('data-gender');

                        document.getElementById('studentId').value = id;
                        document.getElementById('studentName').value = name;
                        document.getElementById('studentGender').value = gender;
                        
                        console.log("click btn ", i);
                        modal.style.display = "block";
                        console.log("open modal");
                    })
                }
                  
                if (btna) {
                    btna.onclick = function() {
                        modala.style.display = "block";
                    };
                }                          
                
                
            document.addEventListener("DOMContentLoaded", function() {


    // Get the <span> element that closes the modal
                var span = document.getElementsByClassName("close")[0];
                var spana = document.getElementsByClassName("close1")[0];

                // When the user clicks on <span> (x), close the modal
                // Null check for span
                
                if (span) {
                    span.onclick = function() {
                        modal.style.display = "none";
                    };
                }

                // Null check for spana
                if (spana) {
                    spana.onclick = function() {
                        modala.style.display = "none";
                    };
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                    if (event.target == modala) {
                        modala.style.display = "none";
                    }
                };
            });

            </script>
            
    </body>
</html>
