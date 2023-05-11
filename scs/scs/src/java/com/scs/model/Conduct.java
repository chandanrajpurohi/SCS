package com.scs.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
public class Conduct {
    
    private String id;
    private String names;
    private String conduct;
    private String comment;
    
    private String db_url = "jdbc:postgresql://localhost:5432/student_conduct_system";
    private String db_username = "postgres";
    private String db_password = "AUCA@2022";

    public Conduct() {
    }

    public Conduct(String id, String names, String conduct, String comment) {
        this.id = id;
        this.names = names;
        this.conduct = conduct;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
   public String student_register(Conduct thesearch) {
         
    try {
        // Register Driver
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student_register WHERE id='" + thesearch.getId()+ "'");
        if (rs.next()) {
            readFromDatabase(thesearch.getId()); // Call readFromDatabase with searched ID
        } 
        else {
            FacesMessage msg = new FacesMessage("Wrong Student ID");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return "student_conduct";
}

    
    public void readFromDatabase(String id) {
    try (             
        Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT names FROM student_register WHERE id='" + id + "'")) {

        if (rs.next()) {
            setNames(rs.getString("names"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public String saveConduct(Conduct thestudent){
        try {
            //Register Driver
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="insert into conduct(id,conduct,comment)"+
                    "values('"+thestudent.getId()+"','"+thestudent.getConduct()+"','"+thestudent.getComment()+"')";
            int rows = st.executeUpdate(sql);
            if(rows > 1){
                conn.close();
                return "confirmation";
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "home";
    }

}
