
package com.scs.model;

/**
 *
 * @author HP
 */

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
public class Student {
    private String id;
    private String names;
    private String password;
    
    private String db_url="jdbc:postgresql://localhost:5432/student_conduct_system";
    private String db_username="postgres";
    private String db_password="AUCA@2022";

    public Student() {
    }

    public Student(String id, String names, String password) {
        this.id = id;
        this.names = names;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Saving Student
    
    public String saveStudent(Student thestudent){
        try {
            //Register Driver
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="insert into student_register(id,names,password)"+
                    "values('"+thestudent.getId()+"','"+thestudent.getNames()+"','"+thestudent.getPassword()+"')";
            int rows = st.executeUpdate(sql);
            if(rows > 1){
                conn.close();
                return "confirmation";
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "student_register";
    }
    
    public List<Student> getAllStudent(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="select * from student_register";
            ResultSet result = st.executeQuery(sql);
            List<Student> studentData = new ArrayList<>();
            while(result.next()){
                Student stu = new Student();
                stu.setId(result.getString(1));
                stu.setNames(result.getString(2));
                stu.setPassword(result.getString(3));
                studentData.add(stu);
            }
            conn.close();
             return studentData;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public String findStudentById(String id){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="select * from student_register where id='"+id+"'";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                Student stu = new Student();
                stu.setId(result.getString(1));
                stu.setNames(result.getString(2));
                stu.setPassword(result.getString(3));
                
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                Map<String , Object> requestMap = externalContext.getRequestMap();
                requestMap.put("student", stu);
            }
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "updatestudent";
    }
    
     public String updateStudent(Student student){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="update student_register set names='"+student.getNames()+"' , password='"+student.getPassword()+"' where student_id='"+student.getId()+"'";
            int row = st.executeUpdate(sql);
            if(row >=1){
                return "student_register";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "student_register";
    }
     public String deleteStudent(String id){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
            Statement st = conn.createStatement();
            String sql ="delete from student_register where id='"+id+"'";
            int row = st.executeUpdate(sql);
            if(row >=1){
                return "student_register";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "student_register";
    }
}
