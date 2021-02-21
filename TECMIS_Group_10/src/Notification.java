
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
public class Notification {
        private String notification_id=null;
        private String date=null;
        private String notification=null;
        private String publisher=null;
        
        //setting values to the variables
        
        void setNotificationId(String notification_id)
        {
            this.notification_id=notification_id;
        }
        
        void setDate(String date)
        {
            this.date=date;
        }
        
        void setNotification(String notification)
        {
            this.notification=notification;
        } 
        
        void setPublisher(String publisher)
        {
            this.publisher=publisher;
        }    
        
        //getting values from variable 
        
        String getNotificationId()
        {
            return this.notification_id;
        }
        String getDate()
        {
            return this.date;
        }
        
        String getNotification()
        {
            return this.notification;
        }
        String getPublisher()
        {
            return this.publisher;
        }

        void addNotification()
        {
            if(getNotificationId().equals("")||getDate().equals("")||getNotification().equals("")||getPublisher().equals(""))
            {
                JOptionPane.showMessageDialog(null,"You have to fill each field!..");
            }
            else{
                try{
                    Connection con=MyConnection.getConnection();
                    String sql="INSERT INTO notification VALUES('"+getNotificationId()+"','"+getDate()+"','"+getNotification()+"','"+getPublisher()+"')";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Data added Successfully!..");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }    
            }
        }
        ResultSet searchNotification(String noti_id)
        {
            ResultSet rs=null;
            try{
                Connection con=MyConnection.getConnection();
                String sql="SELECT *FROM notification WHERE notification_id='"+noti_id+"' LIMIT 1";
                PreparedStatement ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            return rs;
        } 
        void updateNotification()
        {
            if(getNotificationId().equals("")||getDate().equals("")||getNotification().equals("")||getPublisher().equals(""))
            {
                JOptionPane.showMessageDialog(null, "You have to fill each fields!..");
            }
            else
            {
                try{
                    Connection con=MyConnection.getConnection();
                    String sql="UPDATE notification SET notification_id='"+getNotificationId()+"',date='"+getDate()+"',notification='"+getNotification()+"',publisher='"+getPublisher()+"' WHERE notification_id='"+getNotificationId()+"'";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Data Update Successfully!..");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }    
            }
        }

        void removeNotification(String noti_id)
        {
            if(getNotificationId().equals("")||getDate().equals("")||getNotification().equals("")||getPublisher().equals(""))
            {
                JOptionPane.showMessageDialog(null, "You have to fill each fields!..");
            }
            else
            {
                try{
                    Connection con=MyConnection.getConnection();
                    String sql="DELETE FROM notification WHERE notification_id='"+noti_id+"'";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Data Removed Successfully!..");
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }   
            }
        }        
}
