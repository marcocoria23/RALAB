/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.BD.federal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class detectarCharsetFed {

    public static Charset detectarCharset(String rutaArchivo) throws IOException {
        // Revisar si tiene BOM UTF-8
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(rutaArchivo))) {
            byte[] bom = new byte[3];
            if (bis.read(bom) == 3) {
                if ((bom[0] & 0xFF) == 0xEF
                        && (bom[1] & 0xFF) == 0xBB
                        && (bom[2] & 0xFF) == 0xBF) {
                    System.out.println("Archivo UTF-8 con BOM");
                    return StandardCharsets.UTF_8;
                }
            }
        }

        // Intentar leer como UTF-8
        try {
            Files.readString(new File(rutaArchivo).toPath(), StandardCharsets.UTF_8);
            System.out.println("Archivo UTF-8 sin BOM");
            return StandardCharsets.UTF_8;
        } catch (MalformedInputException ex) {
            System.out.println("Archivo Windows-1252");
            return Charset.forName("windows-1252");
        }
    }

    public static boolean esFilaVacia(CSVRecord record, String tabla) {

        for (String valor : record) {
            if (valor != null && !valor.trim().isEmpty()) {
                return false;
            }
        }
        System.out.println("Tabla: " + tabla + " | Fila completamente vacía en CSV: " + record.getRecordNumber());
        
        return true;
    }

}
