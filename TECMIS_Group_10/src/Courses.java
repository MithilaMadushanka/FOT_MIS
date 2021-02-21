
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mithila
 */
public class Courses {
        private String course_code=null;
        private String course_title=null;
        private String course_co=null;
        private String dep=null;
        
        // Here setting the values to attributes
        void setCourseCode(String course_code)
        {
            this.course_code=course_code;
        }
        void setCourseTitle(String course_title)
        {
            this.course_title=course_title;
        }
        void setCourseCo(String course_co)
        {
            this.course_co=course_co;
        }
        void setDep(String dep)
        {
            this.dep=dep;
        }

        //getting values from attributes
        
        public String getCourseCode()
        {
            return course_code;
        } 
        public String getCourseTitle()
        {
            return course_title;
        }
        public String getCourseCo()
        {
            return course_co;
        }
        public String getDep()
        {
            return dep;
        }
        
        void addCourse()
         {
             Courses cor=new Courses();
             if(getCourseCode().equals("")||getCourseTitle().equals("")||getCourseCo().equals("")||getDep().equals(""))
             {
                 JOptionPane.showMessageDialog(null, "You have to fill each feilds!..");
             }
             else{
                 try{
                     Connection con=MyConnection.getConnection();
                     String sql="INSERT INTO courses(course_code,course_title,course_co,department) VALUES('"+getCourseCode()+"','"+getCourseTitle()+"','"+getCourseCo()+"','"+getDep()+"')";
                     PreparedStatement ps=con.prepareStatement(sql);
                     ps.execute();
                     JOptionPane.showMessageDialog(null, "Data Added Successfully!.."); 
                 }catch(Exception e){
                     JOptionPane.showMessageDialog(null,e);
                 }
             }
         }
        ResultSet updateCourse(String course_code){
             ResultSet rs=null;
             
             //Find the user which he/she within Database and pass to value to textfeilds
                 try{
                     Connection con=MyConnection.getConnection();
                     String sql="SELECT *FROM courses WHERE course_code='"+course_code+"' LIMIT 1";
                     PreparedStatement ps=con.prepareStatement(sql);
                     rs=ps.executeQuery();
                    
                    
                 }
                 catch(Exception e){
                     JOptionPane.showMessageDialog(null,"User Not Found!..");
                 }
             
             return rs;
         }
        void updateCourseData(String cource_code)
         {
             // In here actually update the data you changed
             if(getCourseCode().equals("")||getCourseTitle().equals("")||getCourseCo().equals("")||getDep().equals(""))
             {
                 JOptionPane.showMessageDialog(null, "You have to fill each blanks...");
             }    
             else{
                  try{
                 Connection con=MyConnection.getConnection();
                 String sql="UPDATE courses SET course_code='"+getCourseCode()+"',course_title='"+getCourseTitle()+"',course_co='"+getCourseCo()+"',department='"+getDep()+"' WHERE course_code='"+cource_code+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data Update Successfully!..");
                 }
                  catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
                 }
             }
         }
        void removeCourseData(String cource_code)
         {
             // In here actually update the data you changed
             if(getCourseCode().equals("")||getCourseTitle().equals("")||getCourseCo().equals("")||getDep().equals(""))
             {
                 JOptionPane.showMessageDialog(null, "You have to fill each blanks...");
             }    
             else{
                  try{
                 Connection con=MyConnection.getConnection();
                 String sql="DELETE FROM courses WHERE course_code='"+course_code+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data removed Successfully!..");
                 }
                  catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
                 }
             }
         }
         
}
