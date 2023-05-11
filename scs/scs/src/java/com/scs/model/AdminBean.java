/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scs.model;

import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class AdminBean {
     private String id;
    private String password;
    private boolean loggedIn;

    // Getters and setters for email and password

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getDb_username() {
        return db_username;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }
   

    // This method is called when the user submits the form
     private String db_url="jdbc:postgresql://localhost:5432/student_conduct_system";
    private String db_username="postgres";
    private String db_password="AUCA@2022";
    public String login() {
        
        // Connect to the database and check if the user is eligible
        try  {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE id = ? AND password = ?");
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // User is eligible, set loggedIn to true and redirect to the home page
                loggedIn = true;
                return "home";
            } else {
                // User is not eligible, show an error message and stay on the login page
                FacesMessage msg = new FacesMessage("Wrong Email Or PassWord?");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return null;
            }
        } catch (SQLException e) {
            // An error occurred while connecting to the database, show an error message and stay on the login page
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("An error occurred while logging in"));
            return null;
        }
    }

    // This method is called when the user logs out
    public String logout() {
        // Set loggedIn to false and redirect to the login page
        loggedIn = false;
        return "login?faces-redirect=true";
    }

    // This method returns a connection to the database
    private Connection getConnection() throws SQLException {
        // Replace with your own code to create a connection to the database
        return null;
    }
}
