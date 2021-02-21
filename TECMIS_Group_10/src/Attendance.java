
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Attendance {
       private String reg_no=null;
       private String subject_code=null;
       private String session_no=null;
       private String type=null;
       private String status=null;

    Connection con=MyConnection.getConnection();
    public String getReg_no() {
        return reg_no;
    }

    /**
     * @param reg_no the reg_no to set
     */
    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    /**
     * @return the subject_code
     */
    public String getSubject_code() {
        return subject_code;
    }

    /**
     * @param subject_code the subject_code to set
     */
    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    /**
     * @return the session_no
     */
    public String getSession_no() {
        return session_no;
    }

    /**
     * @param session_no the session_no to set
     */
    public void setSession_no(String session_no) {
        this.session_no = session_no;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
       
    void addAttendance()
    {
           try {
               Connection con=MyConnection.getConnection();
               String sql="INSERT INTO attendance VALUES('"+getReg_no()+"','"+getSubject_code()+"','"+getSession_no()+"','"+getType()+"','"+getStatus()+"')";
               PreparedStatement ps=con.prepareStatement(sql);
               ps.execute();
               JOptionPane.showMessageDialog(null, "Data added Successfully!.");
           } catch (SQLException ex) {
               Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    void updateAttendance()
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="UPDATE attendance SET subject_code='"+getSubject_code()+"',session_no='"+getSession_no()+"',type='"+getType()+"',status='"+getStatus()+"' WHERE reg_no='"+getReg_no()+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Update Successfully!..");
        } catch (Exception e) {
        }
    }
    void removeAttendance()
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="DELETE FROM attendance WHERE reg_no='"+getReg_no()+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Data Removed Successfully!..");
        } catch (Exception e) {
        }
    }
    
    String getEligibility(String reg,String sub_code)
    {
        //get medical
        //getEligibility Theory
        //getEligibility Practical
        //get Total Eligibility
        
        String theory=getEligibilityTheory(reg,sub_code);
        String practical=getEligibilityPractical(reg,sub_code);
        return getTotalEligibility(theory,practical);
        // add to data base
    } 
    
    int getMedicalTheory(String reg,String sub_code)
    {
        int m=0;
        try {
            String sql="SELECT *FROM medical WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Theory'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                return 1;
                
            }
            updateMediTheory(reg,sub_code);
        } catch (Exception e) {
        }
        return m;
    }
    
    int getMedicalPractical(String reg,String sub_code)
    {
        int m=0;
        try {
            String sql="SELECT *FROM medical WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Practical'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                return 1;
                
            }
            updateMediPractical(reg,sub_code);
        } catch (Exception e) {
        }
        return m;
    }
    void updateMediTheory(String reg, String sub_code) {
        try {
            String sql="UPDATE medical SET status=0 WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Theory'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     void updateMediPractical(String reg, String sub_code) {
        try {
            String sql="UPDATE medical SET status=0 WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Practical'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    String getEligibilityTheory(String reg,String sub_code)
    {
        String msg=null;
        int count=0,total=0;
        float result=0;
        
        try {
            String sql="SELECT COUNT(reg_no) from attendance WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Theory' and status=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                count=Integer.parseInt(rs.getString("COUNT(reg_no)"));
                
            }
            
            total=count+getMedicalTheory(reg,sub_code);
            result=(float)total/15*100;
            //System.out.println(result);
            return getResult(result);
        } catch (Exception e) {
        }
        return msg;
    }        
    
    String getEligibilityPractical(String reg,String sub_code)
    {
        String msg=null;
        int count=0,total=0;
        float result=0;
        
        try {
            String sql="SELECT COUNT(reg_no) from attendance WHERE reg_no='"+reg+"' AND subject_code='"+sub_code+"' AND type='Practical' and status=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                count=Integer.parseInt(rs.getString("COUNT(reg_no)"));
            }
            
            total=count+getMedicalTheory(reg,sub_code);
            result=(float)total/15*100;
            System.out.println(result);
            return getResult(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return msg;
    } 
    String getResult(float result) {
        
        String re=null;
        if(result>=80)
            re="Eligible";
        if(result<80)
            re="Not Eligible";
        return re;    
    }
    
    String getTotalEligibility(String theory,String practical)
    {
        if(theory.equals("Eligible") && practical.equals("Eligible"))
            return "Eligible";
        else
            return "Not Eligible";
    }

    String getCAEligibility(String reg, String sub_code) {
        Marks mar=new Marks();
        double quiz=0,ass=0,mid=0,total=0;
        
        quiz=mar.getQuizMarks(reg, sub_code);
        ass=mar.getAssessmentMarks(reg, sub_code);
        mid=mar.getMidMarks(reg, sub_code);
        
        total=quiz+ass+mid;
        //System.out.println(total);
        if(total>=12)
            return "Eligible";
        else
            return "Not Eligible";
    }

    String getCAEligibility2(String reg, String sub_code) {
        Marks mar=new Marks();
        double quiz=0,ass=0,mid=0,total=0;
        
        quiz=mar.getQuiz2(reg, sub_code);
        ass=mar.getAssessment2(reg, sub_code);
        mid=mar.getMidMarks(reg, sub_code);
     
         total=quiz+ass+mid;
         if(total>=12)
            return "Eligible";
        else
            return "Not Eligible";
    }

    void addCA(String reg, String sub_code, String Ele) {
        Connection con=MyConnection.getConnection();
        try {
            String sql="INSERT INTO ca_eligible VALUES('"+reg+"','"+sub_code+"','"+Ele+"')";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("ok");
        } catch (Exception e) { 
        }
    }
    
    
}
