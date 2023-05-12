package Formularios;

import Clases.Cls_BuscarProductos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Frm_BuscarProductos extends javax.swing.JInternalFrame {
    private final Cls_BuscarProductos CP;
    TableColumnModel columnModel;
    
    DefaultTableModel DT = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };
    
    public Frm_BuscarProductos() {
        initComponents();
        CP = new Cls_BuscarProductos();
        columnModel = tabla.getColumnModel();
        listar();
    }
    
    private void listar(){
        tabla.setModel(CP.getDatosProductos());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_busqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrb_nombre = new javax.swing.JRadioButton();
        jrb_codigo = new javax.swing.JRadioButton();
        txt_busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Lista de Productos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Búsqueda por:");

        jrb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        bg_busqueda.add(jrb_nombre);
        jrb_nombre.setText("Descripción");

        jrb_codigo.setBackground(new java.awt.Color(255, 255, 255));
        bg_busqueda.add(jrb_codigo);
        jrb_codigo.setText("Código");

        txt_busqueda.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_busquedaCaretUpdate(evt);
            }
        });
        txt_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busquedaActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jrb_codigo)
                        .addGap(2, 2, 2)
                        .addComponent(jrb_nombre)
                        .addGap(2, 2, 2)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(jrb_codigo)
                    .addComponent(jrb_nombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_busquedaCaretUpdate
        if(jrb_nombre.isSelected()){
            String inf = txt_busqueda.getText();
            tabla.setModel(CP.getDatoP(1,inf));
        }
        
        if(jrb_codigo.isSelected()){
            String inf = txt_busqueda.getText();
            tabla.setModel(CP.getDatoP(2,inf));
        }
        
        if(txt_busqueda.getText().isEmpty()){
            tabla.setModel(CP.getDatosProductos());
        }
    }//GEN-LAST:event_txt_busquedaCaretUpdate

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if(Frm_Entrada.enviar == 1){
            int row = tabla.getSelectedRow();
            Frm_Entrada.txt_codigo.setText(tabla.getValueAt(row, 0).toString());
            Frm_Entrada.txt_descripcion.setText(tabla.getValueAt(row, 1).toString());
            Frm_Entrada.txt_cantidad.requestFocus();
            Frm_Entrada.enviar = 0;
            this.dispose();
        }
        
        else if(Frm_Salida.enviar == 1){
            int row = tabla.getSelectedRow();
            Frm_Salida.txt_codigo.setText(tabla.getValueAt(row, 0).toString());
            Frm_Salida.txt_descripcion.setText(tabla.getValueAt(row, 1).toString());
            Frm_Salida.txt_cantidad.requestFocus();
            Frm_Salida.enviar = 0;
            this.dispose();
        }
        
    }//GEN-LAST:event_tablaMouseClicked

    private void txt_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_nombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
