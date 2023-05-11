/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scs.model;

/**
 *
 * @author HP
 */
import java.io.Serializable;
import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String db_url="jdbc:postgresql://localhost:5432/student_conduct_system";
    private String db_username="postgres";
    private String db_password="AUCA@2022";
    private String id;
    private String password;
    private boolean loggedIn;
    private String studentId; // new property

    // getters and setters for id, password, loggedIn, and studentId

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
    

    public String login() {
        try  {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student_register WHERE id = ? AND password = ?");
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                loggedIn = true;
                studentId = rs.getString("id"); // set the studentId property
                return "student_info";
            } else {
                FacesMessage msg = new FacesMessage("Wrong Email Or PassWord?");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return null;
            }
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("An error occurred while logging in"));
            return null;
        }
    }

    public String logout() {
        loggedIn = false;
        return "login?faces-redirect=true";
    }

    // getters and setters for db_url, db_username, and db_password

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
