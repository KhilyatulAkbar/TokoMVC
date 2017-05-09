/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pack.control.login_koneksi;
import tokomvc.TokoMVC;

/**
 *
 * @author user
 */
public class login extends javax.swing.JFrame {

    static String user;

    /**
     * Creates new form login
     */
    public login() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SignIn = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();
        SignUp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        SignIn.setText("SIGN IN");
        SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInActionPerformed(evt);
            }
        });
        jPanel2.add(SignIn);
        SignIn.setBounds(10, 11, 360, 50);

        EXIT.setText("EXIT");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });
        jPanel2.add(EXIT);
        EXIT.setBounds(190, 70, 180, 50);

        SignUp.setText("SIGN UP");
        SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpActionPerformed(evt);
            }
        });
        jPanel2.add(SignUp);
        SignUp.setBounds(10, 70, 170, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 150, 380, 130);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 70, 110, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 30, 110, 30);
        jPanel3.add(txtnama);
        txtnama.setBounds(120, 30, 250, 30);
        jPanel3.add(txtpass);
        txtpass.setBounds(120, 70, 250, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 11, 380, 130);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        setSize(new java.awt.Dimension(416, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInActionPerformed
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, txtnama.getText());
            ps.setString(2, txtpass.getText());
            ResultSet result =ps.executeQuery();
            if(result.next()){
                new home().show();
                user = txtnama.getText();//perlu deklarasi user diclass utama.
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                txtpass.setText("");
                txtnama.requestFocus();
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Gagal!");
    }//GEN-LAST:event_SignInActionPerformed
    }
    
    private void SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpActionPerformed
        String username = txtnama.getText();
        String password = txtpass.getText();

        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_akun(username, password) VALUES('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat anda berhasil Sign Up");
        }catch (Exception t){
            JOptionPane.showMessageDialog(null,"Mohon maaf ulangi lagi prosedur");
        }
    }//GEN-LAST:event_SignUpActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
            Object[] options = { "Yes", "No"};
            int optionss = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin Ingin Keluar?", "Konfirmasi",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
            
            if (optionss == 0){
                dispose();
            }
            
            else
            {
                
            }
    }//GEN-LAST:event_EXITActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EXIT;
    private javax.swing.JButton SignIn;
    private javax.swing.JButton SignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
