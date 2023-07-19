/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.aspose.barcode.License;
import com.aspose.barcode.barcoderecognition.BarCodeReader;
import com.aspose.barcode.barcoderecognition.BarCodeResult;
import com.aspose.barcode.barcoderecognition.DecodeType;
import com.aspose.barcode.generation.BarCodeImageFormat;
import com.aspose.barcode.generation.BarcodeGenerator;
import com.aspose.barcode.generation.EncodeTypes;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public class CodigoBarra {

    public static void createCode(String text) throws WriterException, IOException {

        int width = 600;
        int height = 400;

        String ruta = "C:\\System-inventory\\CodeBar\\Output_Code.png";

        String imageFormat = "png"; // "jpeg" "gif" "tiff"

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.CODE_128, width, height);
        FileOutputStream outputStream = new FileOutputStream(new File(ruta));
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, outputStream);

    }
    
    public static void createCodeQR(String text) throws WriterException, IOException {

        int width = 600;
        int height = 400;

        String ruta = "C:\\System-inventory\\CodeBar\\Output_QR_Code.png";

        String imageFormat = "png"; // "jpeg" "gif" "tiff"

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        FileOutputStream outputStream = new FileOutputStream(new File(ruta));
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, outputStream);

    }

    /**
     *
     * @param pathname
     * @return
     * @throws FormatException
     * @throws ChecksumException
     * @throws NotFoundException
     * @throws IOException
     */
    public static String readBarcode(String pathname) throws FormatException, ChecksumException, NotFoundException, IOException {

        InputStream qrInputStream = new FileInputStream(pathname);
        BufferedImage qrBufferedImage = ImageIO.read(qrInputStream);
        if (qrBufferedImage == null) {
            throw new RuntimeException("No se pudo leer o decodificar imagen " + pathname);
        }

        LuminanceSource source = new BufferedImageLuminanceSource(qrBufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        Result stringBarCode = reader.decode(bitmap);

        return stringBarCode.getText();
    }

    public String readCode(String pathname) {

        License JavaBarCodeLicense = new License();
        try {
            JavaBarCodeLicense.setLicense("Aspose.Total.lic");
        } catch (Exception ex) {
            Logger.getLogger(CodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Instantiate BarCodeReader to load the Barcode image and types of Barcodes to identify
        BarCodeReader BarcodeReader = new BarCodeReader(pathname, DecodeType.ALL_SUPPORTED_TYPES);

        String result = "";
        // Read Barcode information
        for (BarCodeResult codeResult : BarcodeReader.readBarCodes()) {
            result = codeResult.getCodeText();
        }

        return result;
    }

    public void writeCode(String text) throws IOException {

        String ruta = "C:\\System-inventory\\CodeBar\\Output_Code.png";
        BarcodeGenerator generator = new BarcodeGenerator(EncodeTypes.CODE_128, text);
        // establecer resolución
        generator.getParameters().setResolution(400);
        // generar código de barras
        generator.save(ruta);

    }

    public void writeCodeQR(String text) throws IOException {

        String ruta = "C:\\System-inventory\\CodeBar\\Output_QR_Code.png";
        // Set Aspose.Barcode license before generating QR code using Aspose.Barcode for Java
        License JavaBarCodeLicense = new License();
        try {
            JavaBarCodeLicense.setLicense("Aspose.BarCode.lic");
        } catch (Exception ex) {
            Logger.getLogger(CodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Initialize an object of BarCodeGenerator class
        // Specify Barcode Encode Type as QR
        BarcodeGenerator GenerateQRCode = new BarcodeGenerator(EncodeTypes.QR);

        // Set text to be encoded as generated QR code
        GenerateQRCode.setCodeText(text);

        // Save the generated QR code in PNG image format
        // Aspose.Barcode API supports multiple image formats for saving the output QR code
        GenerateQRCode.save(ruta, BarCodeImageFormat.PNG);
    }

}
