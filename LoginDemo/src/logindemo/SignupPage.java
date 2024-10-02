/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindemo;

import java.awt.Color;
import java.awt.Container;
import java.sql.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pranav Sopan Chaugul
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        Container c=getContentPane();
        c.setBackground(new Color(0,153,153));
        
        initComponents();
    }
    public boolean validation()
    {
        String fname,lname,username,password,conpass,address;
        Date dob;
        fname=txtfname.getText();
        lname=txtlname.getText();
        username=txtusername.getText();
        password=txtpassword.getText();
        conpass=txtconpassword.getText();
        dob=txtdob.getDate();
        address=txtaddress.getText();
        if(fname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter First nmae.");
            return false;
        }
        if(lname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Last nmae.");
            return false;
        }
        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter username.");
            return false;
        }
        if(password.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter password.");
            return false;
        }
        if(conpass.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Confirm Password.");
            return false;
        }
        if(dob==null)
        {
            JOptionPane.showMessageDialog(this,"Please enter date.");
            return false;
        }
        if(address.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter address.");
            return false;
        }
        if(!password.equals(conpass))
        {
            lbl_error.setText("Password not match!!");
            return false;
        }
        else
        {
            lbl_error.setText("");
        }
        return true;
    }
    public void insertintoDB()
    {
        String fname,lname,username,password,conpass,address;
        String dob;
        fname=txtfname.getText();
        lname=txtlname.getText();
        username=txtusername.getText();
        password=txtpassword.getText();
        conpass=txtconpassword.getText();
        address=txtaddress.getText();
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        dob=dateformat.format(txtdob.getDate());
        
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/signupdemo");
            Statement st=con.createStatement();
            String sql="insert into signup values('"+fname+"','"+lname+"','"+username+"','"+password+"','"+dob+"','"+address+"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(this,"Account created");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtconpassword = new javax.swing.JTextField();
        bttback = new javax.swing.JButton();
        bttsignup = new javax.swing.JButton();
        txtdob = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        lbl_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SignUp");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 3));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        txtfname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 280, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("D.O.B:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        txtlname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 280, 30));

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 280, 30));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 280, 30));

        txtconpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtconpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtconpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 280, 30));

        bttback.setBackground(new java.awt.Color(0, 153, 153));
        bttback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bttback.setForeground(new java.awt.Color(255, 255, 255));
        bttback.setText("Back");
        bttback.setActionCommand("Back");
        bttback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttbackMouseClicked(evt);
            }
        });
        bttback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttbackActionPerformed(evt);
            }
        });
        jPanel1.add(bttback, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 100, -1));

        bttsignup.setBackground(new java.awt.Color(0, 153, 153));
        bttsignup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bttsignup.setForeground(new java.awt.Color(255, 255, 255));
        bttsignup.setText("SignUp");
        bttsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttsignupActionPerformed(evt);
            }
        });
        jPanel1.add(bttsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 100, -1));
        jPanel1.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 280, 30));

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 280, -1));

        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 580));

        setSize(new java.awt.Dimension(1034, 713));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlnameActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtconpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconpasswordActionPerformed

    private void bttbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttbackActionPerformed

    private void bttsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttsignupActionPerformed
      if(validation()==true)
      {
          insertintoDB();
      }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_bttsignupActionPerformed

    private void bttbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttbackMouseClicked
        // TODO add your handling code here:
        LoginPage l1=new LoginPage();
        l1.show();
    }//GEN-LAST:event_bttbackMouseClicked

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttback;
    private javax.swing.JButton bttsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtconpassword;
    private com.toedter.calendar.JDateChooser txtdob;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables

    private void SimpleDateFormat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
