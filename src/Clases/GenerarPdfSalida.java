/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Formularios.Frm_Principal.cargo;
import static Formularios.Frm_Principal.usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class GenerarPdfSalida {
    
     public void crearPdf(String numFact,String codigoP, String descripcion, Integer cantidad, Integer precioU, int identify ) {

        try {
            Date date = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String fecha = formato.format(calendar.getTime()).toString();
            String fec = fecha.replaceAll("[^\\w+]", "");

            FileOutputStream archivo;
            File file = new File("C:\\System-inventory\\Reporte-pdf\\reporte-salida-" +numFact+"-"+ fec + ".pdf");

            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);

            doc.open();
            Image img = Image.getInstance("C:\\System-inventory\\logo.jpg");
            Paragraph fech = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fech.add(Chunk.NEWLINE);
            fech.add("Recibo Salida Nº: " + numFact + "\n" + "Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] columnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(columnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);
            encabezado.addCell("");

            Cls_Empresa empresa = new Cls_Empresa();
            Object[] datos = empresa.getEmpresa();

            encabezado.addCell(datos[4].toString() + "\n" + datos[0].toString() + "\n" + datos[3].toString() + "\n" + datos[2].toString() + "\n" + datos[5].toString());
            encabezado.addCell(fech);
            doc.add(encabezado);

            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos Generales del cliente " + "\n\n");
            cli.setAlignment(Element.ALIGN_CENTER);
            doc.add(cli);

            PdfPTable tablaCli = new PdfPTable(5);
            tablaCli.setWidthPercentage(100);
            tablaCli.getDefaultCell().setBorder(0);
            float[] columnaCli = new float[]{30f, 50f, 30f, 40f, 50f};
            tablaCli.setWidths(columnaCli);
            tablaCli.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell cli1 = new PdfPCell(new Phrase("Cedula/NIT", negrita));
            PdfPCell cli2 = new PdfPCell(new Phrase("Razon Social", negrita));
            PdfPCell cli3 = new PdfPCell(new Phrase("Telefono", negrita));
            PdfPCell cli4 = new PdfPCell(new Phrase("Direccion", negrita));
            PdfPCell cli5 = new PdfPCell(new Phrase("Email", negrita));

            cli1.setBorder(0);
            cli2.setBorder(0);
            cli3.setBorder(0);
            cli4.setBorder(0);
            cli5.setBorder(0);
            
            cli1.setBackgroundColor(BaseColor.GRAY);
            cli2.setBackgroundColor(BaseColor.GRAY);
            cli3.setBackgroundColor(BaseColor.GRAY);
            cli4.setBackgroundColor(BaseColor.GRAY);
            cli5.setBackgroundColor(BaseColor.GRAY);
            
            tablaCli.addCell(cli1);
            tablaCli.addCell(cli2);
            tablaCli.addCell(cli3);
            tablaCli.addCell(cli4);
            tablaCli.addCell(cli5);

            
            Cls_Salida salida = new Cls_Salida();          
            Object[] datosCli = salida.getCliente(identify);
            
            tablaCli.addCell(datosCli[0].toString());
            tablaCli.addCell(datosCli[1].toString());
            tablaCli.addCell(datosCli[3].toString());
            tablaCli.addCell(datosCli[2].toString());
            tablaCli.addCell(datosCli[4].toString());

            doc.add(tablaCli);
            
            //detalle
            
             Paragraph detalle = new Paragraph();
            detalle.add(Chunk.NEWLINE);
            detalle.add("DETALLE " + "\n\n");
            detalle.setAlignment(Element.ALIGN_CENTER);
            doc.add(detalle);
            
            
            PdfPTable tablaDetalle = new PdfPTable(5);
            tablaDetalle.setWidthPercentage(100);
            tablaDetalle.getDefaultCell().setBorder(0);
            float[] columnaDetalle = new float[]{ 20f, 60f, 20f, 40f, 40f};
            tablaDetalle.setWidths(columnaDetalle);
            tablaDetalle.setHorizontalAlignment(Element.ALIGN_LEFT);

            
            PdfPCell deta2 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell deta3 = new PdfPCell(new Phrase("Descripción", negrita));
            PdfPCell deta4 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell deta5 = new PdfPCell(new Phrase("Precio U.", negrita));
            PdfPCell deta6 = new PdfPCell(new Phrase("Total.", negrita));
          

            
            deta2.setBorder(0);
            deta3.setBorder(0);
            deta4.setBorder(0);
            deta5.setBorder(0);
            deta6.setBorder(0);
            
            
            deta2.setBackgroundColor(BaseColor.GRAY);
            deta3.setBackgroundColor(BaseColor.GRAY);
            deta4.setBackgroundColor(BaseColor.GRAY);
            deta5.setBackgroundColor(BaseColor.GRAY);
            deta6.setBackgroundColor(BaseColor.GRAY);

            
            tablaDetalle.addCell(deta2);
            tablaDetalle.addCell(deta3);
            tablaDetalle.addCell(deta4);
            tablaDetalle.addCell(deta5);
            tablaDetalle.addCell(deta6);

            DecimalFormat df = new DecimalFormat("#,###");
            
            String format1 = df.format(Integer.valueOf(precioU.toString().replace(".", "").replace(",", "")));
               
            Integer total = precioU * cantidad;
            
            String format2 = df.format(Integer.valueOf(total.toString().replace(".", "").replace(",", "")));
           
            tablaDetalle.addCell(codigoP);
            tablaDetalle.addCell(descripcion);
            tablaDetalle.addCell(cantidad.toString());
            tablaDetalle.addCell(format1);
            tablaDetalle.addCell(format2);

            doc.add(tablaDetalle);
            
             Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total Salida: " + format2 +"\n\n");
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Elaborado por: " + usuario.getText() +"\n");
            firma.add("Cargo: " + cargo.getText() +"\n\n");
            firma.add("Firma: " +"\n\n");
            firma.add("----------------------------------------------------" +"\n\n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
           
            doc.close();
            archivo.close();
            
            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
}
