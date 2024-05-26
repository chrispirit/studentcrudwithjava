/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1web.resources;

/**
 *
 * @author CHRISTIAN
 */
public class Student {
    private int id;
    private String username;
    private String email;
    private String gender;
    
    public Student() {}
    
    public Student(int id1, String username, String email, String gender) {
        super();
        this.id = id1;
        this.username = username;
        this.email = email;
        this.gender = gender;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    
}
