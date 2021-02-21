
/*date :26/07/2019 created*/
/* @author Mithila
 This is a user classes class which have all user classess*/

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

 
public class User {
         private String user_type=null;
         private String full_name=null;
         private String reg_no=null;
         private String email=null;
         private String contact_no=null;
         private String dep=null;
         private String user_name=null;
         private String password=null;
         private byte[] image=null;
         
         //byte[] picture;
         
         // set the values to attributes
        void setUserType(String user_type)
        {
            this.user_type=user_type;
        }
        void setFullName(String name)
        {
            full_name=name;
        }
        void setRegNo(String reg)
        {
            reg_no=reg;
        }
        void setEmail(String email)
        {
            this.email=email;
        }
        void setContact(String contact)
        {
            contact_no=contact;
        }
        void setDep(String dep)
        {
            this.dep=dep;
        }
        void setUserName(String user_name)
        {
            this.user_name=user_name;
        }
        void setPassword(String password)
        {
            this.password=password;
        }
        void setPicture(byte[] picture)
        {
            this.image=picture;
        } 
        
        //get the values from attributes
        
        String getUserType()
        {
            return user_type;
        }
        String getFullName()
        {
            return full_name;
        } 
        String getRegNo()
        {
            return reg_no;
        }
        String getEmail()
        {
            return email;
        }
        String getContact()
        {
            return contact_no;
        }
        String getdep()
        {
            return dep;
        }
        String getUserName()
        {
            return user_name;
        }
        String getPassword()
        {
            return password;
        }
        byte[] getPicture()
        {
            return image;
        }
}

class Admin extends User
{        
         int  isValid(){
             
             int status=0;
             if(getUserType().equals("")||getFullName().equals("")||getRegNo().equals("")||getEmail().equals("")||getContact().equals("")||getdep().equals("")||getUserName().equals("")||getPassword().equals("")){
                 JOptionPane.showMessageDialog(null, "You should have to fill each records!!.....");
                 status=1;
                 
             }
             else{
                 addUserAccount();
                 status=0;
             }
             return status;
         }
         void addUserAccount(){
             try{
                 Connection con=MyConnection.getConnection();
                 String sql="insert into user(reg_no,user_type,full_name,email,contact_no,dept,user_name,password,image) values('"+getRegNo()+"','"+getUserType()+"','"+getFullName()+"','"+getEmail()+"','"+getContact()+"','"+getdep()+"','"+getUserName()+"','"+getPassword()+"','"+getPicture()+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null,"Data added sucessfull");
                 
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null,e);
             }
         }
         ResultSet updateUserAccount(String reg_no){
             ResultSet rs=null;
             
             //Find the user which he/she within Database and pass to value to textfeilds
                 try{
                     Connection con=MyConnection.getConnection();
                     String sql="SELECT *FROM user WHERE reg_no='"+reg_no+"' LIMIT 1";
                     PreparedStatement ps=con.prepareStatement(sql);
                     rs=ps.executeQuery();
                    
                    
                 }
                 catch(Exception e){
                     JOptionPane.showMessageDialog(null,"User Not Found!..");
                 }
             
             return rs;
         }
         void updateUserAccountAddData()
         {
             // In here actually update the data you changed
             try{
                 Connection con=MyConnection.getConnection();
                 String sql="UPDATE user SET reg_no='"+getRegNo()+"',user_type='"+getUserType()+"',full_name='"+getFullName()+"',email='"+getEmail()+"',contact_no='"+getContact()+"',dept='"+getdep()+"',user_name='"+getUserName()+"',password='"+getPassword()+"',image='"+getPicture()+"' WHERE reg_no='"+getRegNo()+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.executeQuery();
                 JOptionPane.showMessageDialog(null, "Data Update Successfully!..");
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Unable to update data!..!..");
             }
         }
         void removeUserAccount(String reg_no){
             try{
                 Connection con=MyConnection.getConnection();
                 String sql="Delete from user WHERE reg_no='"+reg_no+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.executeQuery();
                 JOptionPane.showMessageDialog(null, "Data removed Successfully!..");
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Unable to Remove data!..!..");
             }
         }
        /* public String getImgPath(String reg_no)
         {
             String regno=null;
              try {
                        Connection con=MyConnection.getConnection();
                        String sql="select image from user where reg_no='"+reg_no+"'";
                        PreparedStatement ps=con.prepareStatement(sql);
                        ResultSet rs=ps.executeQuery();
                        Blob b =rs.getBlob("image");
                        regno=rs.getString("reg_no");
                        FileOutputStream fos = new FileOutputStream("C:\\Users\\Mithila\\Documents\\NetBeansProjects\\TECMIS_Group_10\\src\\user_image"+regno+".jpg");
                        int len=(int)b.length();
                        byte[] buf=b.getBytes(1, len);
                        fos.write(buf, 0, len);
                        return regno;
             } catch (Exception e) {
             }
                return "-1";    
         }   */     
         
         void addTimeTableET1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level1_et(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }        
         
         void updateTimeTableET1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level1_et set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         } 
         
         void addTimeTableBST1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level1_bst(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
         void updateTimeTableBST1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level1_bst set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         } 
          void addTimeTableICT1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level1_ict(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
          void updateTimeTableICT1(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level1_ict set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         } 
           void addTimeTableET2(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level2_et(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
         void updateTimeTableET2(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level2_et set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
          void addTimeTableICT2(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level2_ict(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
          void updateTimeTableICT2(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level2_ict set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         } 
           void addTimeTableET3(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level3_et(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
          void updateTimeTableET3(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level3_et set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         } 
            void addTimeTableICT3(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="insert into timetable_level3_ict(time,monday,tuesday,wensday,thursday,friday)values('"+time+"','"+monday+"','"+tuesday+"','"+wensday+"','"+thursday+"','"+friday+"')";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is added Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }
         
          void updateTimeTableICT3(String time,String monday,String tuesday,String wensday,String thursday,String friday)
         {
             try {
                 Connection con=MyConnection.getConnection();
                 String sql="update timetable_level3_ict set monday='"+monday+"',tuesday='"+tuesday+"',wensday='"+wensday+"',thursday='"+thursday+"',friday='"+friday+"' where time='"+time+"'";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.execute();
                 JOptionPane.showMessageDialog(null, "Data is update Successfully!...");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
         }    
}

class TechnicalOfficer extends User
{
    private static String reg_no=null;
    void setRegNo2(String rno)
    {
        reg_no=rno;
    }
    String getRegNo2()
    {
        return reg_no;
    }        
    ResultSet showDetails(String reg)
    {
        ResultSet rs=null;
        try {
            Connection con=MyConnection.getConnection();
            String sql="select *from user where reg_no='"+reg+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    
    ResultSet seeNotification()
    {
        ResultSet rs=null;
        try {
            Connection con=MyConnection.getConnection();
            String sql="select *from notification";
            PreparedStatement ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        } catch (Exception e) {
            
        }
        return rs;
    }        
}

class Student extends User
{
    private static String reg=null;
    
    void setReg(String regno)
    {
        this.reg=regno;
    }
    String getReg()
    {
        return reg;
    }        
}

class Lecture extends User
{
    private static String reg=null;
    
    void setReg(String reg)
    {
        this.reg=reg;
    }
    
    String getReg()
    {
        return reg;
    }       
}

