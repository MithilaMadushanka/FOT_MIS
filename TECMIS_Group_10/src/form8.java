
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
public class form8 extends javax.swing.JFrame {

    public String regno_to=null;
    public form8() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAdminUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_dean = new javax.swing.JButton();
        txtAdminPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        message2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("SignIn");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("User Name  :");

        txtAdminUserName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtAdminUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtAdminUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminUserNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Password   :");

        jButton2.setBackground(new java.awt.Color(102, 0, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setName("exit"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_dean.setBackground(new java.awt.Color(102, 0, 255));
        btn_dean.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_dean.setForeground(new java.awt.Color(255, 255, 255));
        btn_dean.setText("Sign In");
        btn_dean.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_dean.setBorderPainted(false);
        btn_dean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dean.setFocusPainted(false);
        btn_dean.setFocusable(false);
        btn_dean.setName("exit"); // NOI18N
        btn_dean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deanActionPerformed(evt);
            }
        });

        txtAdminPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtAdminPassword.setMinimumSize(new java.awt.Dimension(6, 25));
        txtAdminPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminPasswordActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.gif"))); // NOI18N

        message.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 51, 51));

        message2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_dean, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtAdminUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(message2)
                            .addComponent(message))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdminUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dean, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(message)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(message2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 730));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue-tie-dye-background-1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //when user click exit button
        form2 f2=new form2();
        f2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_deanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deanActionPerformed
        // loggin with admin account
        
        String un=txtAdminUserName.getText();
        String pwd=txtAdminPassword.getText();
        
       if(un.equals("")|| pwd.equals("")){
           //JOptionPane.showMessageDialog(null,"You have to fill both text feild!");
           message2.setText("You have to fill both fields!..");
       }
       else{
            ResultSet rs=null;
            //check whether admin is in or not within a database
           try{
               Connection con=MyConnection.getConnection();
               String sql="SELECT *FROM user WHERE user_name='"+un+"' AND password='"+pwd+"' and user_type='Admin' LIMIT 1";
               PreparedStatement ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               if(rs.next())
               {
                   form9 f9=new form9();
                   f9.setVisible(true);
                   this.setVisible(false);
               }
               else{
                    //JOptionPane.showMessageDialog(null, "Invalid User Please try again!..");
                    message.setText("The user is Invalid.. Please try again");
               }
           }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
           } 
           
           //check whether Technical officer is in or not within a database
           try{
               Connection con=MyConnection.getConnection();
               String sql="SELECT *FROM user WHERE user_name='"+un+"' AND password='"+pwd+"' and user_type='Technical Officer' LIMIT 1";
               PreparedStatement ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               if(rs.next())
               {
                   regno_to=rs.getString("reg_no");
                   TechnicalOfficer to=new TechnicalOfficer();
                   to.setRegNo2(regno_to);
                   
                   form16 f16=new form16();
                   f16.setVisible(true);
                   this.setVisible(false);
               }
               else{
                   // JOptionPane.showMessageDialog(null, "Invalid User Please try again!..");
                   message.setText("The user is Invalid.. Please try again");
               }
           }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, e);
           }
           
           //check whether Student is in or not whithing a database
           
           try {
               Connection con=MyConnection.getConnection();
               String sql="SELECT *FROM user WHERE user_name='"+un+"' AND password='"+pwd+"' AND user_type='Student' LIMIT 1";
               PreparedStatement ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               if(rs.next())
               {
                   String s_reg=rs.getString("reg_no");
                   Student stu=new Student();
                   stu.setReg(s_reg);
                   
                   form23 f23=new form23();
                   f23.setVisible(true);
                   this.setVisible(false);
               }
                else{
                   // JOptionPane.showMessageDialog(null, "Invalid User Please try again!..");
                   message.setText("The user is Invalid.. Please try again");
               }
           } catch (Exception e) {
           }
           
           //Check whether Lecture is in or not withing a database
           
            try {
               Connection con=MyConnection.getConnection();
               String sql="SELECT *FROM user WHERE user_name='"+un+"' AND password='"+pwd+"' AND user_type='Lecture' LIMIT 1";
               PreparedStatement ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               if(rs.next())
               {
                   String s_reg=rs.getString("reg_no");
                   Lecture lec=new Lecture();
                   lec.setReg(s_reg);
                   
                   form26 f26=new form26();
                   f26.setVisible(true);
                   this.setVisible(false);
               }
                else{
                   // JOptionPane.showMessageDialog(null, "Invalid User Please try again!..");
                   message.setText("The user is Invalid.. Please try again");
               }
           } catch (Exception e) {
           }
       } 
    }//GEN-LAST:event_btn_deanActionPerformed

    private void txtAdminUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminUserNameActionPerformed

    private void txtAdminPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dean;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel message;
    private javax.swing.JLabel message2;
    private javax.swing.JPasswordField txtAdminPassword;
    private javax.swing.JTextField txtAdminUserName;
    // End of variables declaration//GEN-END:variables
}
