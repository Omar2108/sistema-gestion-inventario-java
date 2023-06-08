/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conectar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class ImportarExportarDB {

    public void exportarDB() {

        String backus = "";
        Date date = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String fecha = formato.format(calendar.getTime()).toString();
        String fec = fecha.replaceAll("[^\\w+]", "");

        try {
            //backus = "C:\\xampp\\mysql\\bin\\mysqldump -v --opt --events --routines --triggers --default-character-set=utf8 -u" + user + " -B " + db ;
            backus = "C:\\xampp\\mysql\\bin\\mysqldump -v --opt --events --routines --triggers --default-character-set=utf8 -u" + Conectar.getUSER() + " -B " + Conectar.getDB();
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(backus);
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\LENOVO\\Documents\\ReportesDB\\dbinventario_" + fec + ".sql");
            // FileOutputStream fos = new FileOutputStream(nombredb);
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            fos.close();
            JOptionPane.showMessageDialog(null, "¡Se respaldo la base de datos, de forma correcta!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }

    public void importarDB(String ruta) {
        String backus = "";
       
        try {
            Process p = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysql -u " + Conectar.getUSER() + " " + Conectar.getDB());
            OutputStream is = p.getOutputStream();
            FileInputStream fos = new FileInputStream(ruta);

            byte[] buffer = new byte[1000];
            int leido = fos.read(buffer);
            while (leido > 0) {
                is.write(buffer, 0, leido);
                leido = fos.read(buffer);
            }
            is.flush();
            is.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Se restauro de forma correcta, la base de datos");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
