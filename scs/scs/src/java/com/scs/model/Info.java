
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
public class Info {
    private String id;
    private String conduct;
    private String comment;
    
    private String db_url="jdbc:postgresql://localhost:5432/student_conduct_system";
    private String db_username="postgres";
    private String db_password="AUCA@2022";

    public Info() {
    }

    public Info(String id, String conduct, String comment) {
        this.id = id;
        this.conduct = conduct;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public List<Info> getAllStudent(String studentId){
    try{
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conn = DriverManager.getConnection(db_url,db_username,db_password);
        PreparedStatement st = conn.prepareStatement("SELECT * FROM conduct WHERE id = ?");
        st.setString(1, studentId);
        ResultSet result = st.executeQuery();
        List<Info> studentData = new ArrayList<>();
        while(result.next()){
            Info stu = new Info();
            stu.setId(result.getString(1));
            stu.setConduct(result.getString(2));
            stu.setComment(result.getString(3));
            studentData.add(stu);
        }
        conn.close();
         return studentData;
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return null;
}

}
