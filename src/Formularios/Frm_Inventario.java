package Formularios;

import Clases.Cls_Inventario;
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


public class Frm_Inventario extends javax.swing.JInternalFrame {
    private final Cls_Inventario CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;
    
    public Frm_Inventario() {
        initComponents();
        CP = new Cls_Inventario();
        columnModel = jtb_inventario.getColumnModel();
        listar();
    }
    
    private void listar(){
        jtb_inventario.setModel(CP.getDatosInventario());
        columnModel.getColumn(1).setPreferredWidth(400);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_inventario = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtb_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_inventario);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Inventario de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Entrada, Salida y Stock de Productos.");

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
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(495, 495, 495)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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

    private void jtb_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_inventarioMouseClicked

    }//GEN-LAST:event_jtb_inventarioMouseClicked

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:

         JFileChooser seleccionar = new JFileChooser();
        int opcion = seleccionar.showSaveDialog(null);
        if(opcion == JFileChooser.APPROVE_OPTION){
            String ruta = seleccionar.getSelectedFile().getAbsolutePath();
            String nombrereporte = ruta+".xlsx";
            String nombrehoja = "Inventario";
            XSSFWorkbook libroinventario = new XSSFWorkbook();
            XSSFSheet hojainventario = libroinventario.createSheet(nombrehoja);
            
            String [] titulos = new String[]{"CODIGO", "DESCRIPCION", "CANTIDAD ENTRADA", "CANTIDAD SALIDA", "EXISTENCIA"};
            
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
            for(int i=0;i<titulos.length;i++){
                XSSFCell celda = titulo.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(cscabecera);
            }
            int filacontenido = 1;
            for(int i = 0;i<jtb_inventario.getRowCount();i++){
                XSSFRow contenido = hojainventario.createRow(filacontenido);
                filacontenido++;
                for(int j=0;j<jtb_inventario.getColumnCount();j++){
                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(jtb_inventario.getValueAt(i, j).toString());
                    celda.setCellStyle(cscontenido);
                }
                    
            }
            
            hojainventario.autoSizeColumn(0);
            hojainventario.autoSizeColumn(1);
            hojainventario.autoSizeColumn(2);
            hojainventario.autoSizeColumn(3);
            hojainventario.autoSizeColumn(4);
            try(OutputStream archivo = new FileOutputStream(nombrereporte)){
                libroinventario.write(archivo);
                JOptionPane.showMessageDialog(null, "¡Reporte generado, con exito!");
            }catch(IOException ex){
                ex.printStackTrace();
            }
                
        }
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_inventario;
    // End of variables declaration//GEN-END:variables
}
