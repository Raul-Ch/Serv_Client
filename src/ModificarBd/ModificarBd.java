/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModificarBd;


import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.xdevapi.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author raulr
 */
public class ModificarBd extends javax.swing.JFrame {

    /**
     * Creates new form ModificarBd
     */
    public ModificarBd() {
        initComponents();
        
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/comunicacion_servidor","root","");
            java.sql.Statement Sent = conexion.createStatement();
            ResultSet rs = Sent.executeQuery("select * from paquetes");
            while (rs.next()) {
                this.Paquetes.addItem(String.valueOf(rs.getInt("Paquete")));   
            }
        } catch (Exception e) {
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

        NombreAlumno_TxtField_S = new javax.swing.JTextField();
        ApellidoAlumno_TxtField_S = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Paquetes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombreAlumno_TxtField_S.setBackground(new java.awt.Color(153, 255, 255));
        NombreAlumno_TxtField_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAlumno_TxtField_SActionPerformed(evt);
            }
        });
        getContentPane().add(NombreAlumno_TxtField_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 40));

        ApellidoAlumno_TxtField_S.setBackground(new java.awt.Color(153, 255, 255));
        ApellidoAlumno_TxtField_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoAlumno_TxtField_SActionPerformed(evt);
            }
        });
        getContentPane().add(ApellidoAlumno_TxtField_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, 40));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("ALUMNO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, 40));

        Paquetes.setFont(new java.awt.Font("Tw Cen MT", 2, 24)); // NOI18N
        Paquetes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paquetes" }));
        Paquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaquetesActionPerformed(evt);
            }
        });
        getContentPane().add(Paquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 290, 50));

        jButton1.setText("Modificar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com_images/FondoDif.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreAlumno_TxtField_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAlumno_TxtField_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAlumno_TxtField_SActionPerformed

    private void ApellidoAlumno_TxtField_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoAlumno_TxtField_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoAlumno_TxtField_SActionPerformed

    private void PaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaquetesActionPerformed

        try {
            java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/comunicacion_servidor","root","");
            java.sql.Statement sent1 = con1.createStatement();
            //Rellenar Campos
            java.sql.ResultSet rs1 = sent1.executeQuery("select * from paquetes where Paquete= '"+this.Paquetes.getSelectedItem()+"'");
            rs1.next();
            NombreAlumno_TxtField_S.setText(rs1.getString("Alumno_Nombre"));
            ApellidoAlumno_TxtField_S.setText(rs1.getString("Alumno_Apellido"));

            /*  if (con1 != null) {
                Mensajes_Cliente.showMessageDialog(null, "Conectado correctamente a la base de datos");
            }*/
        } catch (Exception e) {
        }
    }//GEN-LAST:event_PaquetesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            //Alumno modificar
        try {
            java.sql.Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/comunicacion_servidor","root","");
            java.sql.Statement sent2 = con2.createStatement();
            ResultSet rs = sent2.executeQuery("select * from paquetes ");
            //java.sql.ResultSet rs2 = sent2.executeQuery("select * from paquetes ");
            rs.next();
            PreparedStatement pst = con2.prepareStatement("UPDATE paquetes SET Alumno_Nombre= '"+NombreAlumno_TxtField_S.getText()+"',Alumno_Apellido='"+ApellidoAlumno_TxtField_S.getText()+"'where Paquete= '"+this.Paquetes.getSelectedItem()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nombre Actualizado");
            // UPDATE paquetes SET Alumno_Nombre= '"+NombreAlumno_TxtField_S.getText()+"',Alumno_Apellido='"+ApellidoAlumno_TxtField_S.getText()+"'where Paquete= '"+this.Paquetes.getSelectedItem()+"'");
        } catch (SQLException e) {
        }




        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(ModificarBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarBd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoAlumno_TxtField_S;
    private javax.swing.JTextField NombreAlumno_TxtField_S;
    private javax.swing.JComboBox<String> Paquetes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
