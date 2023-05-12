package Formularios;

import Clases.Cls_Salida;
import Clases.CurrencyCellRenderer;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Frm_Salida extends javax.swing.JInternalFrame {

    private final Cls_Salida CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;

    public Frm_Salida() {
        initComponents();
        CP = new Cls_Salida();
        columnModel = jtb_salida.getColumnModel();
        listar();
        iniciar();
    }

    private void listar() {
        jtb_salida.setModel(CP.getDatosSalida());
        columnModel.getColumn(3).setPreferredWidth(250);
        jtb_salida.getColumnModel().getColumn(5).setCellRenderer(new CurrencyCellRenderer());
        jtb_salida.getColumnModel().getColumn(6).setCellRenderer(new CurrencyCellRenderer());
        jtb_salida.getColumnModel().getColumn(7).setCellRenderer(new CurrencyCellRenderer());
    }

    private void iniciar() {
        txt_nfactura1.setEnabled(false);
        txt_cantidad.setEnabled(false);
        txt_precio.setEnabled(false);
        txt_nfactura1.requestFocus();
        jdc_fecha.setEnabled(false);
        jbt_buscar.setEnabled(false);
        jbt_guardar.setEnabled(false);
    }

    private void activar() {
        String datosSalida = CP.getFacturaSalida();
        int numFact = Integer.parseInt(datosSalida) + 1;
        String numFac = Integer.toString(numFact);
        txt_nfactura1.setText(numFac);
        System.out.println("valor de txt_nfactura1: " + txt_nfactura1.getText());

        txt_cantidad.setEnabled(true);
        txt_precio.setEnabled(true);
        jdc_fecha.setEnabled(true);
        jbt_buscar.setEnabled(true);
        jbt_guardar.setEnabled(true);
        jdc_fecha.requestFocus();
        jbt_guardar.setEnabled(true);
    }

    private void limpiar() {
        txt_nfactura1.setText("");
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        jdc_fecha.setDate(null);
        txt_nfactura1.requestFocus();
        jtb_salida.clearSelection();
    }

    private void guardar() {
        try {

            if ("".equals(txt_precio.getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el precio del producto");
            } else if ("".equals(txt_cantidad.getText())) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad que sale del producto");
            } else if (txt_codigo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto");
            } else {

                String nfac = txt_nfactura1.getText();
                String codigo = txt_codigo.getText();
                int cantidad = Integer.parseInt(txt_cantidad.getText());
                int precio = Integer.parseInt(txt_precio.getText());
                int total = precio * cantidad;
                Date fechaa = jdc_fecha.getDate();
                long d = fechaa.getTime();
                java.sql.Date fecha_sql = new java.sql.Date(d);

                int stock = CP.verificarStock(codigo);

                if (cantidad > stock) {
                    JOptionPane.showMessageDialog(null, "¡No hay stock suficiente!");
                    txt_cantidad.setText("");
                    txt_cantidad.requestFocus();
                } else {
                    if (num == 0) {
                        int respuesta = CP.registrarSalida(nfac, codigo, fecha_sql, cantidad, precio, total);
                        if (respuesta > 0) {
                            listar();
                            limpiar();
                            iniciar();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_salida = new javax.swing.JTable();
        jbt_buscar = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nfactura1 = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Número de Factura *");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código del Producto *");

        txt_codigo.setEditable(false);

        txt_descripcion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción del Producto *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cantidad *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha *");

        jdc_fecha.setDateFormatString("yyyy/MM/dd");

        jtb_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_salidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_salida);

        jbt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_consultas.png"))); // NOI18N
        jbt_buscar.setBorderPainted(false);
        jbt_buscar.setContentAreaFilled(false);
        jbt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_buscarActionPerformed(evt);
            }
        });

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
        jbt_guardar.setText("Registrar Salida");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Salida de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información respectiva para la salida de los productos.");

        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precioKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Precio Unitario Producto *");

        txt_nfactura1.setBackground(new java.awt.Color(0, 153, 153));
        txt_nfactura1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_nfactura1.setForeground(new java.awt.Color(255, 255, 255));
        txt_nfactura1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nfactura1.setToolTipText("");
        txt_nfactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nfactura1ActionPerformed(evt);
            }
        });

        btnReporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(bt_nuevo)
                        .addGap(54, 54, 54)
                        .addComponent(jbt_guardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_nfactura1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel5)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel8)))))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nfactura1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_nuevo)
                            .addComponent(jbt_guardar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void jtb_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_salidaMouseClicked

    }//GEN-LAST:event_jtb_salidaMouseClicked

    private void jbt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_buscarActionPerformed
        enviar = 1;

        Frm_BuscarProductos C = new Frm_BuscarProductos();
        Frm_Principal.escritorio.add(C);
        Dimension desktopSize = Frm_Principal.escritorio.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_jbt_buscarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        jbt_guardar.setEnabled(true);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void jbt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_guardarActionPerformed
        guardar();

    }//GEN-LAST:event_jbt_guardarActionPerformed

    private void txt_nfactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nfactura1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel datosSalida = CP.getDatosSalida();
        System.out.println(datosSalida.toString());
        String nFactura = datosSalida.getColumnName(1);

        int num = Integer.parseInt(nFactura) + 1;
        String numFac = Integer.toString(num);
        txt_nfactura1.setText(numFac);
    }//GEN-LAST:event_txt_nfactura1ActionPerformed

    private void txt_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyReleased
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#,###");

        if (txt_precio.getText().length() >= 1) {

            txt_precio.setText(df.format(Integer.valueOf(txt_precio.getText().replace(".", "").replace(",", ""))));

        }
    }//GEN-LAST:event_txt_precioKeyReleased

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:

        JFileChooser seleccionar = new JFileChooser();
        int opcion = seleccionar.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String ruta = seleccionar.getSelectedFile().getAbsolutePath();
            String nombrereporte = ruta + ".xlsx";
            String nombrehoja = "Inventario";
            XSSFWorkbook libroinventario = new XSSFWorkbook();
            XSSFSheet hojainventario = libroinventario.createSheet(nombrehoja);

            String[] titulos = new String[]{"# FACTURA", "FECHA SALIDA", "CODIGO PRODUCTO", "DESCRIPCION", "CANTIDAD SALIDA", "PRECIO UNITARIO", "TOTAL", "GANANCIA ESTIMADA"};

            Font fontcabecera = libroinventario.createFont();
            fontcabecera.setBold(true);
            fontcabecera.setColor(IndexedColors.WHITE.getIndex());

            CellStyle cscabecera = libroinventario.createCellStyle();
            cscabecera.setBorderBottom(BorderStyle.THIN);
            cscabecera.setBorderLeft(BorderStyle.THIN);
            cscabecera.setBorderRight(BorderStyle.THIN);
            cscabecera.setBorderTop(BorderStyle.THIN);
            cscabecera.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            cscabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cscabecera.setFont(fontcabecera);

            CellStyle cscontenido = libroinventario.createCellStyle();
            cscontenido.setBorderBottom(BorderStyle.THIN);
            cscontenido.setBorderLeft(BorderStyle.THIN);
            cscontenido.setBorderRight(BorderStyle.THIN);
            cscontenido.setBorderTop(BorderStyle.THIN);

            XSSFRow titulo = hojainventario.createRow(0);
            for (int i = 0; i < titulos.length; i++) {
                XSSFCell celda = titulo.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(cscabecera);
            }
            int filacontenido = 1;
            for (int i = 0; i < jtb_salida.getRowCount(); i++) {
                XSSFRow contenido = hojainventario.createRow(filacontenido);
                filacontenido++;
                for (int j = 0; j < jtb_salida.getColumnCount(); j++) {
                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(jtb_salida.getValueAt(i, j).toString());
                    celda.setCellStyle(cscontenido);
                }

            }

            hojainventario.autoSizeColumn(0);
            hojainventario.autoSizeColumn(1);
            hojainventario.autoSizeColumn(2);
            hojainventario.autoSizeColumn(3);
            hojainventario.autoSizeColumn(4);
            hojainventario.autoSizeColumn(5);
            hojainventario.autoSizeColumn(6);
            try (OutputStream archivo = new FileOutputStream(nombrereporte)) {
                libroinventario.write(archivo);
                JOptionPane.showMessageDialog(null, "¡Reporte generado, con exito!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JButton btnReporte;
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
    private javax.swing.JButton jbt_buscar;
    private javax.swing.JButton jbt_guardar;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JTable jtb_salida;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nfactura1;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
