package Formularios;

import Clases.Cls_Entrada;
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

public class Frm_Entrada extends javax.swing.JInternalFrame {

    private final Cls_Entrada CP;
    public static int enviar = 0;
    TableColumnModel columnModel;
    int num = 0;

    public Frm_Entrada() {
        initComponents();
        CP = new Cls_Entrada();
        columnModel = jtb_entrada.getColumnModel();
        listar();
        iniciar();
    }

    private void listar() {
        jtb_entrada.setModel(CP.getDatosEntradas());
        columnModel.getColumn(3).setPreferredWidth(350);
        jtb_entrada.getColumnModel().getColumn(5).setCellRenderer(new CurrencyCellRenderer());
        jtb_entrada.getColumnModel().getColumn(6).setCellRenderer(new CurrencyCellRenderer());
    }

    private void iniciar() {
        txt_nfactura.setEnabled(false);
        txt_precio.setEnabled(false);
        txt_cantidad.setEnabled(false);
        jdc_fecha.setEnabled(false);
        jbt_buscar.setEnabled(false);
        jbt_guardar.setEnabled(false);

    }

    private void activar() {
        String datosEntradas = CP.getFactura();
        System.out.println("consulta " + datosEntradas);
        int numFact = Integer.parseInt(datosEntradas) + 1;
        String numFac = Integer.toString(numFact);
        txt_nfactura.setText(numFac);

        txt_precio.setEnabled(true);
        txt_cantidad.setEnabled(true);
        jdc_fecha.setEnabled(true);
        jbt_buscar.setEnabled(true);
        jbt_guardar.setEnabled(true);
        txt_precio.setEnabled(true);
        jdc_fecha.requestFocus();
        jbt_guardar.setEnabled(true);
    }

    private void limpiar() {
        txt_precio.setText("");
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_precio.setText("");
        txt_nfactura.requestFocus();
        jtb_entrada.clearSelection();
    }

    private void guardar() {

        if ("".equals(txt_precio.getText())) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio del producto");
        } else if ("".equals(txt_cantidad.getText())) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad que entra del producto");
        } else if (txt_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto");
        } else {
            
            String nfac = txt_nfactura.getText();
            String codigo = txt_codigo.getText();
            int cantidad = Integer.parseInt(txt_cantidad.getText());
            Date fechaa = jdc_fecha.getDate();
            int precio = Integer.parseInt(txt_precio.getText());
            int total = Integer.parseInt(txt_precio.getText()) * Integer.parseInt(txt_cantidad.getText());
            long d = fechaa.getTime();
            java.sql.Date fecha_sql = new java.sql.Date(d);

            if (num == 0) {
                int respuesta = CP.registrarEntrada(nfac, codigo, fecha_sql, cantidad, precio, total);
                if (respuesta > 0) {
                    listar();
                    limpiar();
                    iniciar();
                }
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_entrada = new javax.swing.JTable();
        jbt_buscar = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nfactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setTitle("Entrada");
        setMaximumSize(new java.awt.Dimension(1000, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Número de Factura *");

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precioKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código del Producto *");

        txt_codigo.setEditable(false);

        txt_descripcion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción del Producto *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cantidad *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Entrada*");

        jdc_fecha.setDateFormatString("yyyy/MM/dd");

        jtb_entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_entrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_entradaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_entrada);

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
        jbt_guardar.setText("Registrar Entrada");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Entrada de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información respectiva para la entrada de los productos.");

        txt_nfactura.setBackground(new java.awt.Color(0, 153, 153));
        txt_nfactura.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_nfactura.setForeground(new java.awt.Color(255, 255, 255));
        txt_nfactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nfacturaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Precio Unitario Producto *");

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
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jbt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_nfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addGap(73, 73, 73)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(bt_nuevo)
                        .addGap(93, 93, 93)
                        .addComponent(jbt_guardar)
                        .addGap(211, 211, 211))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbt_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cantidad)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_guardar)
                    .addComponent(bt_nuevo)
                    .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(21, 21, 21))
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

    private void jtb_entradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_entradaMouseClicked

    }//GEN-LAST:event_jtb_entradaMouseClicked

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

    private void txt_nfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nfacturaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel datosEntradas = CP.getDatosEntradas();
        System.out.println(datosEntradas.toString());
        String nFactura = datosEntradas.getColumnName(1);

        int num = Integer.parseInt(nFactura) + 1;
        String numFac = Integer.toString(num);
        txt_nfactura.setText(numFac);
    }//GEN-LAST:event_txt_nfacturaActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

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

            String[] titulos = new String[]{"# FACTURA", "FECHA ENTRADA", "CODIGO PRODUCTO", "DESCRIPCION", "CANTIDAD ENTRADA", "PRECIO UNITARIO", "TOTAL"};

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
            for (int i = 0; i < jtb_entrada.getRowCount(); i++) {
                XSSFRow contenido = hojainventario.createRow(filacontenido);
                filacontenido++;
                for (int j = 0; j < jtb_entrada.getColumnCount(); j++) {
                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(jtb_entrada.getValueAt(i, j).toString());
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
    private javax.swing.JTable jtb_entrada;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nfactura;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

}
