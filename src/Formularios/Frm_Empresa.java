package Formularios;

import Clases.Cls_Empresa;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class Frm_Empresa extends javax.swing.JInternalFrame {

    private Cls_Empresa CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;

    public Frm_Empresa() {
        initComponents();
        CP = new Cls_Empresa();
        columnModel = jtb_empresa.getColumnModel();
        listar();
        iniciar();
    }

    private void listar() {
        jtb_empresa.setModel(CP.getDatosEmpresa());
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(190);
    }

    private void iniciar() {
        txt_nit.setEnabled(false);
        txt_telefono.setEnabled(false);
        txt_email.setEnabled(false);
        txt_direccion.setEnabled(false);
        txt_nombre.setEnabled(false);
        txt_nit.requestFocus();
        jdc_fecha.setEnabled(false);
        jbt_guardar.setEnabled(false);
        bt_actualizar.setEnabled(false);
        bt_eliminar.setEnabled(false);
    }

    private void activar() {

        txt_nit.setEnabled(true);
        txt_telefono.setEnabled(true);
        txt_email.setEnabled(true);
        txt_direccion.setEnabled(true);
        txt_nombre.setEnabled(true);
        jdc_fecha.setEnabled(true);
        jbt_guardar.setEnabled(true);
        txt_nit.requestFocus();
        jbt_guardar.setEnabled(true);
    }

    private void limpiar() {
        txt_nit.setText("");
        txt_direccion.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_email.setText("");
        jdc_fecha.setDate(null);
        txt_nit.requestFocus();
        jtb_empresa.clearSelection();
    }

    private void guardar() {

        if (num == 0) {

            try {

                if (txt_nit.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el numero de NIT de la empresa");
                } else if (txt_direccion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar la direccion de la empresa");
                } else if (txt_telefono.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el numero de telefono de la empresa");
                } else if (txt_nombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la empresa");
                } else if (txt_email.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el correo electronico de la empresa");
                } else {

                    String nit = txt_nit.getText();
                    String direccion = txt_direccion.getText();
                    String telefono = txt_telefono.getText();
                    String nombre = txt_nombre.getText();
                    String email = txt_email.getText();
                    Date fechaa = jdc_fecha.getDate();
                    long d = fechaa.getTime();
                    java.sql.Date fecha_sql = new java.sql.Date(d);

                    int respuesta = CP.registrarEmpresa(nit, fecha_sql, email, direccion, nombre, telefono);
                    if (respuesta > 0) {

                        listar();
                        limpiar();
                        iniciar();
                        bt_actualizar.setEnabled(false);
                    }
                }

            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {

            String nit_old = txt_nit.getText();
            String direccion2 = txt_direccion.getText();
            String telefono2 = txt_telefono.getText();
            String nombre2 = txt_nombre.getText();
            String email2 = txt_email.getText();

            int respuesta = CP.actualizarEmpresa(nit_old, email2, direccion2, nombre2, telefono2);
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
        txt_nit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_empresa = new javax.swing.JTable();
        bt_nuevo = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bt_actualizar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Empresa");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NIT Empresa *");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Direccion");

        txt_direccion.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        txt_nombre.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Razon Social *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Telefono *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha *");

        jdc_fecha.setDateFormatString("yyyy/MM/dd");

        jtb_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_empresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_empresa);

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
        jbt_guardar.setText("Registrar Empresa");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Empresa");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información, relacionada con su empresa.");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addGap(52, 52, 52)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txt_email)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))))
                .addContainerGap(64, Short.MAX_VALUE))
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
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_nit)
                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_direccion)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_empresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_empresaMouseClicked
        bt_actualizar.setEnabled(true);
        bt_eliminar.setEnabled(true);

        int row = jtb_empresa.getSelectedRow();
        txt_nit.setText(jtb_empresa.getValueAt(row, 0).toString());
        txt_email.setText(jtb_empresa.getValueAt(row, 2).toString());
        txt_direccion.setText(jtb_empresa.getValueAt(row, 3).toString());
        txt_nombre.setText(jtb_empresa.getValueAt(row, 4).toString());
        txt_telefono.setText(jtb_empresa.getValueAt(row, 5).toString());

    }//GEN-LAST:event_jtb_empresaMouseClicked

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        jbt_guardar.setEnabled(true);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void jbt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_guardarActionPerformed
        guardar();

    }//GEN-LAST:event_jbt_guardarActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        num = 1;
        activar();
        bt_actualizar.setEnabled(false);
        jbt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        int fila = jtb_empresa.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Empresa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (CP.eliminarEmpresa(jtb_empresa.getValueAt(jtb_empresa.getSelectedRow(), 0).toString()) > 0) {
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_guardar;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JTable jtb_empresa;
    public static javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    public static javax.swing.JTextField txt_nit;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
