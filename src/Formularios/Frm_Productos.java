package Formularios;

import Clases.Cls_Empresa;
import Clases.Cls_Productos;
import Clases.ImportarExcel;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Frm_Productos extends javax.swing.JInternalFrame {

    private final Cls_Productos CP;
    TableColumnModel columnModel;
    int num = 0;

    public Frm_Productos() {
        initComponents();
        CP = new Cls_Productos();
        columnModel = jtb_productos.getColumnModel();
        listar();
        iniciar();
        bt_actualizar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar() {
        jtb_productos.setModel(CP.getDatosProductos());
        columnModel.getColumn(1).setPreferredWidth(600);
    }

    private void iniciar() {
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
    }

    private void activar() {
        txt_codigo.setEnabled(true);
        txt_descripcion.setEnabled(true);
        txt_codigo.requestFocus();
    }

    private void limpiar() {
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_codigo.requestFocus();
        jtb_productos.clearSelection();
    }

    private void guardar() {
        String codigo = txt_codigo.getText();
        String descripcion = txt_descripcion.getText();

        if (num == 0) {

            if (codigo.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto");
            } else if (descripcion.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la descripcion del producto");
            } else {
                int respuesta = CP.registrarProducto(codigo, descripcion);
                if (respuesta > 0) {
                    if (CP.verificarCodigoInventario(codigo) == 0) {
                        CP.insertarProductoInventario(codigo);
                    }

                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");

                    listar();
                    limpiar();
                    iniciar();
                    bt_actualizar.setEnabled(false);
                }

            }

        } else {
            int row = jtb_productos.getSelectedRow();
            String codigo_old = jtb_productos.getValueAt(row, 0).toString();

            int respuesta = CP.actualizarProducto(codigo, descripcion, codigo_old);
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
        txt_codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();
        bt_guardar = new javax.swing.JButton();
        bt_actualizar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código de Producto *");

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_productos);

        bt_guardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_grabar.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.setBorderPainted(false);
        bt_guardar.setContentAreaFilled(false);
        bt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

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

        bt_nuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Descripción *");

        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Registro de Productos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Llene la información respectiva de los productos.");

        btnReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnImportar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImportar.setText("Importar Excel");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(bt_nuevo)
                        .addGap(36, 36, 36)
                        .addComponent(bt_guardar)
                        .addGap(50, 50, 50)
                        .addComponent(bt_actualizar)
                        .addGap(50, 50, 50)
                        .addComponent(bt_eliminar)
                        .addGap(135, 135, 135))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_guardar)
                    .addComponent(bt_actualizar)
                    .addComponent(bt_eliminar)
                    .addComponent(bt_nuevo)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        guardar();

    }//GEN-LAST:event_bt_guardarActionPerformed

    private void jtb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_productosMouseClicked
        bt_actualizar.setEnabled(true);
        bt_eliminar.setEnabled(true);

        int row = jtb_productos.getSelectedRow();
        txt_codigo.setText(jtb_productos.getValueAt(row, 0).toString());
        txt_descripcion.setText(jtb_productos.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jtb_productosMouseClicked

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        int fila = jtb_productos.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (CP.eliminarProducto(jtb_productos.getValueAt(jtb_productos.getSelectedRow(), 0).toString()) > 0) {
                    listar();
                    limpiar();
                    bt_eliminar.setEnabled(false);
                    bt_actualizar.setEnabled(false);
                    bt_guardar.setEnabled(false);
                }
            }

        }
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        bt_guardar.setEnabled(true);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        num = 1;
        activar();
        bt_actualizar.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:

        Cls_Empresa datosEmpresa = new Cls_Empresa();
        Object[] datos = datosEmpresa.getEmpresa();

        JFileChooser seleccionar = new JFileChooser();
        int opcion = seleccionar.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String ruta = seleccionar.getSelectedFile().getAbsolutePath();
            String nombrereporte = ruta + ".xlsx";
            String nombrehoja = "Productos";

            XSSFWorkbook libroProductos = new XSSFWorkbook();
            XSSFSheet hojaProductos = libroProductos.createSheet(nombrehoja);

            String[] titulos = new String[]{"CODIGO", "DESCRIPCION"};

            Font fontcabecera = libroProductos.createFont();
            fontcabecera.setBold(true);
            fontcabecera.setColor(IndexedColors.WHITE.getIndex());

            CellStyle cscabecera = libroProductos.createCellStyle();
            cscabecera.setBorderBottom(BorderStyle.THIN);
            cscabecera.setBorderLeft(BorderStyle.THIN);
            cscabecera.setBorderRight(BorderStyle.THIN);
            cscabecera.setBorderTop(BorderStyle.THIN);
            cscabecera.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            cscabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cscabecera.setFont(fontcabecera);

            CellStyle cscontenido = libroProductos.createCellStyle();
            cscontenido.setBorderBottom(BorderStyle.THIN);
            cscontenido.setBorderLeft(BorderStyle.THIN);
            cscontenido.setBorderRight(BorderStyle.THIN);
            cscontenido.setBorderTop(BorderStyle.THIN);

            CellStyle csEncabezado = libroProductos.createCellStyle();
            csEncabezado.setFont(fontcabecera);
            csEncabezado.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
            csEncabezado.setFillForegroundColor(IndexedColors.WHITE.getIndex());

            XSSFRow primeraFila = hojaProductos.createRow(1);
            XSSFRow segundaFila = hojaProductos.createRow(2);
            XSSFRow terceraFila = hojaProductos.createRow(3);
            XSSFRow cuartaFila = hojaProductos.createRow(4);
            XSSFRow quintaFila = hojaProductos.createRow(5);

            XSSFCell nombreEmpresa = primeraFila.createCell(0);
            XSSFCell nit = segundaFila.createCell(0);
            XSSFCell direccion = terceraFila.createCell(0);
            XSSFCell email = cuartaFila.createCell(0);
            XSSFCell telefono = quintaFila.createCell(0);

            nombreEmpresa.setCellStyle(cscabecera);
            nit.setCellStyle(cscabecera);
            direccion.setCellStyle(cscabecera);
            email.setCellStyle(cscabecera);
            telefono.setCellStyle(cscabecera);

            XSSFCell primeraCelda = primeraFila.createCell(1);
            XSSFCell segundaCelda = segundaFila.createCell(1);
            XSSFCell terceraCelda = terceraFila.createCell(1);
            XSSFCell cuartaCelda = cuartaFila.createCell(1);
            XSSFCell quintaCelda = quintaFila.createCell(1);

            primeraCelda.setCellStyle(cscontenido);
            segundaCelda.setCellStyle(cscontenido);
            terceraCelda.setCellStyle(cscontenido);
            cuartaCelda.setCellStyle(cscontenido);
            quintaCelda.setCellStyle(cscontenido);

            nombreEmpresa.setCellValue("Nombre Empresa: ");
            nit.setCellValue("Nit Empresa: ");
            direccion.setCellValue("Direccion Empresa: ");
            email.setCellValue("Email Empresa: ");
            telefono.setCellValue("Telefono Empresa: ");

            primeraCelda.setCellValue(datos[4].toString());
            segundaCelda.setCellValue(datos[0].toString());
            terceraCelda.setCellValue(datos[3].toString());
            cuartaCelda.setCellValue(datos[2].toString());
            quintaCelda.setCellValue(datos[5].toString());

            XSSFRow titulo = hojaProductos.createRow(7);
            for (int i = 0; i < titulos.length; i++) {
                XSSFCell celda = titulo.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(cscabecera);
            }
            int filacontenido = 8;
            for (int i = 0; i < jtb_productos.getRowCount(); i++) {
                XSSFRow contenido = hojaProductos.createRow(filacontenido);
                filacontenido++;
                for (int j = 0; j < jtb_productos.getColumnCount(); j++) {
                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(jtb_productos.getValueAt(i, j).toString());
                    celda.setCellStyle(cscontenido);
                }

            }

            hojaProductos.autoSizeColumn(0);
            hojaProductos.autoSizeColumn(1);

            try (OutputStream archivo = new FileOutputStream(nombrereporte)) {
                libroProductos.write(archivo);
                JOptionPane.showMessageDialog(null, "¡Reporte generado, con exito!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // TODO add your handling code here:
        
        ImportarExcel importar = new ImportarExcel();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        try {
            importar.importarExcel(ruta);
        } catch (IOException ex) {
            Logger.getLogger(Frm_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_productos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
