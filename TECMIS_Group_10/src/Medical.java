
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Medical {
    
        private String reg_no=null;
        private String subject_code=null;
        private String attendance_type=null;
        private String session_no;

   
    public String getReg_no() {
        return reg_no;
    }

   
    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    
    public String getSubject_code() {
        return subject_code;
    }

    
    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

   
    public String getAttendance_type() {
        return attendance_type;
    }

    
    public void setAttendance_type(String attendance_type) {
        this.attendance_type = attendance_type;
    }

    
    public String getSession_no() {
        return session_no;
    }

    
    public void setSession_no(String session_no) {
        this.session_no = session_no;
    }
    
    void addMedical()
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="INSERT INTO medical VALUES('"+getReg_no()+"','"+getSubject_code()+"','"+getAttendance_type()+"','"+getSession_no()+"',1)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Data is added successfully!..");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    void updateMedical(String reg)
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="UPDATE medical SET subject_code='"+getSubject_code()+"',type='"+getAttendance_type()+"',session='"+getSession_no()+"' WHERE reg_no='"+getReg_no()+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Data Update Successfully!..");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void removeMedical(String reg)
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="DELETE from medical where reg_no='"+reg+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Data Remove Successfully!..");
        } catch (Exception e) {
        }
    }        
}
