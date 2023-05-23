package Formularios;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;

public final class Frm_Principal extends javax.swing.JFrame {

    public Frm_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(true);
        txt_menu.requestFocus();
        getIconImage();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/cheque.png"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_menu = new javax.swing.JLabel();
        btn_empresa = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        usuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(112, 145, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1150, 760));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de Gestion de Inventario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 100));

        txt_menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_menu.setForeground(new java.awt.Color(255, 255, 255));
        txt_menu.setText("MENU PRINCIPAL");
        txt_menu.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(txt_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        btn_empresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_empresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empresa.jpg"))); // NOI18N
        btn_empresa.setText("Empresa");
        btn_empresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_empresa.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empresaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 230, 40));
        btn_empresa.getAccessibleContext().setAccessibleDescription("");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrar.png"))); // NOI18N
        jButton3.setText("Entradas");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 230, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/venta.png"))); // NOI18N
        jButton4.setText("Salidas");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 230, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.png"))); // NOI18N
        jButton5.setText("Inventario");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jButton5PropertyChange(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 230, 40));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.png"))); // NOI18N
        jButton6.setText("Inventario");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jButton6PropertyChange(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 230, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paquete.png"))); // NOI18N
        jButton2.setText("Productos");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 40));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paquete.png"))); // NOI18N
        jButton7.setText("Productos");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 40));

        btn_usuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paquete.png"))); // NOI18N
        btn_usuarios.setText("Usuarios");
        btn_usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_usuarios.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 230, 40));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 1050, 760));

        usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 200, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, -1));

        label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Cargo: ");
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, -1, -1));

        cargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cargo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 40, 100, 20));

        jButton1.setBackground(new java.awt.Color(112, 145, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 40, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empresaActionPerformed
        Frm_Empresa f = new Frm_Empresa();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_btn_empresaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Frm_Entrada f = new Frm_Entrada();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Frm_Salida f = new Frm_Salida();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Frm_Inventario f = new Frm_Inventario();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButton5PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5PropertyChange

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButton6PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6PropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Frm_Productos f = new Frm_Productos();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
        // TODO add your handling code here:
        Frm_Usuarios f = new Frm_Usuarios();
        escritorio.add(f);
        f.show();
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_empresa;
    public static javax.swing.JButton btn_usuarios;
    public static javax.swing.JLabel cargo;
    public static javax.swing.JPanel contenedor;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel txt_menu;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

}
