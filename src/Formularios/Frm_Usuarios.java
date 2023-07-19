package Formularios;

import Clases.Cls_Usuarios;
import Clases.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class Frm_Usuarios extends javax.swing.JInternalFrame {

    private Cls_Usuarios CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;

    public Frm_Usuarios() {
        initComponents();
        CP = new Cls_Usuarios();
        columnModel = jtb_usuario.getColumnModel();
        listar();
        iniciar();
    }

    private void listar() {
        jtb_usuario.setModel(CP.getDatosUsuarios());
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
    }

    private void iniciar() {
        txt_usuario.setEnabled(false);
        txt_clave.setEnabled(false);
        txt_cargo.setEnabled(false);
        txt_email.setEnabled(false);
        txt_nombre.setEnabled(false);
        txt_usuario.requestFocus();
        jbt_guardar.setEnabled(false);
        bt_actualizar.setEnabled(false);
        bt_eliminar.setEnabled(false);

    }

    private void activar() {

        txt_usuario.setEnabled(true);
        txt_clave.setEnabled(true);
        txt_cargo.setEnabled(true);
        txt_email.setEnabled(true);
        txt_nombre.setEnabled(true);
        jbt_guardar.setEnabled(true);
        txt_usuario.requestFocus();
        jbt_guardar.setEnabled(true);
    }

    private void limpiar() {
        txt_usuario.setText("");
        txt_clave.setText("");
        txt_nombre.setText("");
        txt_cargo.setText("");
        txt_email.setText("");
        txt_usuario.requestFocus();
        jtb_usuario.clearSelection();
    }

    private void guardar() throws SQLException {

        if (num == 0) {
            String user = txt_usuario.getText();
            String clave = txt_clave.getText();
            String cargo = txt_cargo.getText();
            String nombre = txt_nombre.getText();
            String email = txt_email.getText();

            if (user.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de usuario");
            } else if (clave.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una clave");
            } else if (cargo.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar su cargo");
            } else if (nombre.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar su nombre");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar su correo electronico");
            } else {

                ResultSet result = CP.getUsuario(user);
                result.next();
                if (result.getInt(1) <= 0) {
                    
                    int respuesta = CP.registrarUsuario(user, clave, nombre, email, cargo);
                    if (respuesta > 0) {

                        listar();
                        limpiar();
                        iniciar();
                        bt_actualizar.setEnabled(false);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "¡El usuario ya se encuentra registrado, intentelo de nuevo!");
                }

            }

        } else {
            int row = jtb_usuario.getSelectedRow();
            int id = Integer.parseInt(jtb_usuario.getValueAt(row, 0).toString());
            String usuario = txt_usuario.getText();
            String clave2 = txt_clave.getText();
            String cargo2 = txt_cargo.getText();
            String nombre2 = txt_nombre.getText();
            String email2 = txt_email.getText();

            int respuesta = CP.actualizarUsuario(usuario, clave2, nombre2, email2, cargo2, id);
            if (respuesta > 0) {
                listar();
                limpiar();
                iniciar();
                num = 0;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_usuario = new javax.swing.JTable();
        bt_nuevo = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bt_actualizar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_clave = new javax.swing.JPasswordField();

        setClosable(true);
        setResizable(true);
        setTitle("Usuarios");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Usuario*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre del usuario *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cargo *");

        jtb_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_usuario);

        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_nuevo.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setBorderPainted(false);
        bt_nuevo.setContentAreaFilled(false);
        bt_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });

        jbt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_grabar.png"))); // NOI18N
        jbt_guardar.setText("Registrar Usuario");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Usuarios");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información, relacionada con el usuario a registrar.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Email *");

        bt_actualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_modificar.png"))); // NOI18N
        bt_actualizar.setText("Modificar");
        bt_actualizar.setBorderPainted(false);
        bt_actualizar.setContentAreaFilled(false);
        bt_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarActionPerformed(evt);
            }
        });

        bt_eliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_eliminar.png"))); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setBorderPainted(false);
        bt_eliminar.setContentAreaFilled(false);
        bt_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Clave*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(bt_nuevo)
                .addGap(47, 47, 47)
                .addComponent(jbt_guardar)
                .addGap(46, 46, 46)
                .addComponent(bt_actualizar)
                .addGap(56, 56, 56)
                .addComponent(bt_eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel4)
                                        .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_clave, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txt_nombre))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_guardar)
                    .addComponent(bt_actualizar)
                    .addComponent(bt_nuevo)
                    .addComponent(bt_eliminar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_usuarioMouseClicked
        bt_actualizar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        int row = jtb_usuario.getSelectedRow();
        Util ut = new Util();
        String pass = "";
        try {
            pass = ut.Desencriptar(jtb_usuario.getValueAt(row, 2).toString());

        } catch (Exception ex) {
            Logger.getLogger(Frm_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        txt_usuario.setText(jtb_usuario.getValueAt(row, 1).toString());
        txt_clave.setText(pass);
        txt_nombre.setText(jtb_usuario.getValueAt(row, 3).toString());
        txt_email.setText(jtb_usuario.getValueAt(row, 4).toString());
        txt_cargo.setText(jtb_usuario.getValueAt(row, 5).toString());

    }//GEN-LAST:event_jtb_usuarioMouseClicked

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        jbt_guardar.setEnabled(true);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void jbt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_guardarActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jbt_guardarActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        num = 1;
        activar();
        bt_actualizar.setEnabled(false);
        jbt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        int fila = jtb_usuario.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (CP.eliminarUsuario(jtb_usuario.getValueAt(jtb_usuario.getSelectedRow(), 0).toString()) > 0) {
                    listar();
                    limpiar();
                    bt_eliminar.setEnabled(false);
                    bt_actualizar.setEnabled(false);
                    jbt_guardar.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_bt_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_guardar;
    private javax.swing.JTable jtb_usuario;
    public static javax.swing.JTextField txt_cargo;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
