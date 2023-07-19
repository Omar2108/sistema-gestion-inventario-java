/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LENOVO
 */
public class ImportarExcel {

    private final Cls_Productos CP;

    public ImportarExcel() {
        CP = new Cls_Productos();
    }

    public void importarExcel(String ruta) throws FileNotFoundException, IOException {

        FileInputStream archivo = new FileInputStream(ruta);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        XSSFSheet hoja = libro.getSheetAt(0);

        int numero_filas = hoja.getLastRowNum();

        for (int i = 1; i <= numero_filas; i++) {
            Row fila = hoja.getRow(i);

           int respuesta = CP.registrarProducto(fila.getCell(0).getStringCellValue(), fila.getCell(1).getStringCellValue());
            if (respuesta > 0) {
                if (CP.verificarCodigoInventario(fila.getCell(0).getStringCellValue()) == 0) {
                    CP.insertarProductoInventario(fila.getCell(0).getStringCellValue());
                }
                
            }
        }

        JOptionPane.showMessageDialog(null, "¡Datos registrados con exitos!.");

    }

}
