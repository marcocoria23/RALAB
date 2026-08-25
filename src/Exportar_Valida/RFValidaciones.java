/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exportar_Valida;

import static Exportar_Valida.V3validaciones.SaveFileTo;
import Screen_laborales.PValidacion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import mx.org.query.federal.VOQFAudiencias;
import mx.org.querys.VOQFDesgloses;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class RFValidaciones {

    ArrayList<String[]> ArrayResult;
    String[] parts;
    String parts0 = "", parts1 = "", parts2 = "", partsfechas = "", Texto = "", Texto1 = "", Con1 = "", Con2 = "";
    Progreso pro = new Progreso();
    JFrame f = new JFrame("Progreso Exporta .xls");

    public void Valida_LaboralesFED() throws SQLException, IOException, ParseException {

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = f.getContentPane();
        JProgressBar progressBar = new JProgressBar();
        progressBar.removeAll();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Cargando...");
        progressBar.setBorder(border);
        content.add(progressBar, BorderLayout.CENTER);
        f.setSize(300, 100);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String encabezado = "Fecha Generacion Doc.: " + dtf.format(LocalDateTime.now());

        HSSFWorkbook libro = new HSSFWorkbook();

        HSSFCellStyle estiloCelda0 = libro.createCellStyle();
        HSSFCellStyle estiloCelda2 = libro.createCellStyle();

        HSSFFont fuente0 = libro.createFont();
        fuente0.setFontHeightInPoints((short) 12);
        fuente0.setColor(HSSFColor.WHITE.index);
        fuente0.setFontName(fuente0.FONT_ARIAL);
        fuente0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        estiloCelda0.setFont(fuente0);
        estiloCelda0.setWrapText(true);
        estiloCelda0.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda0.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda0.setFillForegroundColor(HSSFColor.DARK_BLUE.index);
        estiloCelda0.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle estiloCelda1 = libro.createCellStyle();
        HSSFFont fuente2 = libro.createFont();
        fuente2.setFontHeightInPoints((short) 10);
        fuente2.setColor(HSSFColor.WHITE.index);
        fuente2.setFontName(fuente2.FONT_ARIAL);
        fuente2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        estiloCelda1.setFont(fuente2);
        estiloCelda1.setWrapText(true);
        estiloCelda1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda1.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda1.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
        estiloCelda1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        estiloCelda1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        estiloCelda1.setBottomBorderColor((short) 8);
        estiloCelda1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda1.setLeftBorderColor((short) 8);
        estiloCelda1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda1.setRightBorderColor((short) 8);
        estiloCelda1.setBorderTop(HSSFCellStyle.BORDER_THIN);
        estiloCelda1.setTopBorderColor((short) 8);
        estiloCelda1.setWrapText(true);

        HSSFCellStyle PAmarillo = libro.createCellStyle();
        PAmarillo.setFillForegroundColor(HSSFColor.YELLOW.index);
        PAmarillo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        PAmarillo.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        PAmarillo.setBottomBorderColor((short) 8);
        PAmarillo.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        PAmarillo.setLeftBorderColor((short) 8);
        PAmarillo.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        PAmarillo.setRightBorderColor((short) 8);
        PAmarillo.setBorderTop(HSSFCellStyle.BORDER_THIN);
        PAmarillo.setTopBorderColor((short) 8);
        PAmarillo.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFCellStyle estiloCeldabordes0 = libro.createCellStyle();
        estiloCeldabordes0.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        estiloCeldabordes0.setBottomBorderColor((short) 8);
        estiloCeldabordes0.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCeldabordes0.setLeftBorderColor((short) 8);
        estiloCeldabordes0.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCeldabordes0.setRightBorderColor((short) 8);
        estiloCeldabordes0.setBorderTop(HSSFCellStyle.BORDER_THIN);
        estiloCeldabordes0.setTopBorderColor((short) 8);
        estiloCeldabordes0.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        HSSFFont fuente1 = libro.createFont();
        fuente1.setFontHeightInPoints((short) 11);
        fuente1.setFontName(fuente1.FONT_ARIAL);
        //fuente1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        estiloCeldabordes0.setFont(fuente1);
        estiloCeldabordes0.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        estiloCelda2.setFont(fuente1);
        estiloCelda2.setWrapText(true);
        estiloCelda2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        estiloCelda2.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
        estiloCelda2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        estiloCelda2.setBottomBorderColor((short) 8);
        estiloCelda2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda2.setLeftBorderColor((short) 8);
        estiloCelda2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda2.setRightBorderColor((short) 8);
        estiloCelda2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        estiloCelda2.setTopBorderColor((short) 8);
        estiloCelda2.setWrapText(true);

        HSSFSheet hojaresumenval = libro.createSheet("Resumen_Validacion");
        hojaresumenval.setColumnWidth((short) 0, (short) 9000);
        hojaresumenval.setColumnWidth((short) 1, (short) 3000);
        hojaresumenval.setColumnWidth((short) 3, (short) 10000);

        HSSFSheet hoja0 = libro.createSheet("Desgloses");
        hoja0.setColumnWidth((short) 0, (short) 1500);
        hoja0.setColumnWidth((short) 1, (short) 4000);
        hoja0.setColumnWidth((short) 2, (short) 4000);
        hoja0.setColumnWidth((short) 3, (short) 4000);
        hoja0.setColumnWidth((short) 4, (short) 4000);
        hoja0.setColumnWidth((short) 5, (short) 4000);
        hoja0.setColumnWidth((short) 6, (short) 4000);
        hoja0.setColumnWidth((short) 7, (short) 4000);
        hoja0.setColumnWidth((short) 8, (short) 4000);
        hoja0.setColumnWidth((short) 9, (short) 4000);
        hoja0.setColumnWidth((short) 10, (short) 4000);
        hoja0.setColumnWidth((short) 11, (short) 4000);
        hoja0.setColumnWidth((short) 12, (short) 4000);
        hoja0.setColumnWidth((short) 13, (short) 4000);
        hoja0.setColumnWidth((short) 14, (short) 4250);
        hoja0.setColumnWidth((short) 15, (short) 4250);
        hoja0.setColumnWidth((short) 16, (short) 4000);
        hoja0.setColumnWidth((short) 17, (short) 4000);
        hoja0.setColumnWidth((short) 18, (short) 4000);
        hoja0.setColumnWidth((short) 19, (short) 4000);
        hoja0.setColumnWidth((short) 20, (short) 4000);
        hoja0.setColumnWidth((short) 21, (short) 4000);

        HSSFSheet hojaControl_expe = libro.createSheet("ControlExpediente");
        hojaControl_expe.setColumnWidth((short) 0, (short) 6000);
        hojaControl_expe.setColumnWidth((short) 1, (short) 6000);
        hojaControl_expe.setColumnWidth((short) 2, (short) 10000);
        hojaControl_expe.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaAudiencias = libro.createSheet("Audiencias");
        hojaAudiencias.setColumnWidth((short) 0, (short) 6000);
        hojaAudiencias.setColumnWidth((short) 1, (short) 6000);
        hojaAudiencias.setColumnWidth((short) 2, (short) 10000);
        hojaAudiencias.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaOrdinario = libro.createSheet("Ordinario");
        hojaOrdinario.setColumnWidth((short) 0, (short) 6000);
        hojaOrdinario.setColumnWidth((short) 1, (short) 6000);
        hojaOrdinario.setColumnWidth((short) 2, (short) 10000);
        hojaOrdinario.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaIndividual = libro.createSheet("Individual");
        hojaIndividual.setColumnWidth((short) 0, (short) 6000);
        hojaIndividual.setColumnWidth((short) 1, (short) 6000);
        hojaIndividual.setColumnWidth((short) 2, (short) 10000);
        hojaIndividual.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaColectivo = libro.createSheet("Colectivo");
        hojaColectivo.setColumnWidth((short) 0, (short) 6000);
        hojaColectivo.setColumnWidth((short) 1, (short) 6000);
        hojaColectivo.setColumnWidth((short) 2, (short) 10000);
        hojaColectivo.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaHuelga = libro.createSheet("Huelga");
        hojaHuelga.setColumnWidth((short) 0, (short) 6000);
        hojaHuelga.setColumnWidth((short) 1, (short) 6000);
        hojaHuelga.setColumnWidth((short) 2, (short) 10000);
        hojaHuelga.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaSegSoc = libro.createSheet("Seg_Social");
        hojaSegSoc.setColumnWidth((short) 0, (short) 6000);
        hojaSegSoc.setColumnWidth((short) 1, (short) 6000);
        hojaSegSoc.setColumnWidth((short) 2, (short) 10000);
        hojaSegSoc.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaColecEconom = libro.createSheet("Colect_Econom");
        hojaColecEconom.setColumnWidth((short) 0, (short) 6000);
        hojaColecEconom.setColumnWidth((short) 1, (short) 6000);
        hojaColecEconom.setColumnWidth((short) 2, (short) 10000);
        hojaColecEconom.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaParapro = libro.createSheet("Paraprocesal");
        hojaParapro.setColumnWidth((short) 0, (short) 6000);
        hojaParapro.setColumnWidth((short) 1, (short) 6000);
        hojaParapro.setColumnWidth((short) 2, (short) 10000);
        hojaParapro.setColumnWidth((short) 3, (short) 6000);

        HSSFSheet hojaEjecu = libro.createSheet("Ejecucion");
        hojaEjecu.setColumnWidth((short) 0, (short) 6000);
        hojaEjecu.setColumnWidth((short) 1, (short) 6000);
        hojaEjecu.setColumnWidth((short) 2, (short) 10000);
        hojaEjecu.setColumnWidth((short) 3, (short) 6000);

        PValidacion val = new PValidacion();

        ResumenFED(libro, hojaresumenval, estiloCelda0, estiloCeldabordes0, encabezado, estiloCelda1);
        Desgloses(libro, hoja0, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_ControlExpediente(libro, hojaControl_expe, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        Despliega_Audiencias(libro, hojaAudiencias, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        /*Despliega_Ordinario(libro, hojaOrdinario, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_Individual(libro, hojaIndividual, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_Colectivo(libro, hojaColectivo, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_Huelga(libro, hojaHuelga, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_SegSoc(libro, hojaSegSoc, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_Colect_Econom(libro, hojaColecEconom, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_ParaprocesalNE(libro, hojaParapro, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);
        Despliega_Ejecucion(libro, hojaEjecu, hojaresumenval, estiloCelda0, estiloCelda1, estiloCeldabordes0, PAmarillo, progressBar);*/

        SaveFileTo(libro, progressBar, f);
    }

    public void ResumenFED(HSSFWorkbook libro, HSSFSheet hojaresumenval, HSSFCellStyle estiloCelda0, HSSFCellStyle estiloCeldabordes0, String encabezado, HSSFCellStyle estiloCelda1) {

        PValidacion validacion = new PValidacion();
        HSSFRow row0 = hojaresumenval.createRow((short) 0);
        HSSFCell celda0 = row0.createCell((short) 0);
        celda0.setCellStyle(estiloCelda0);
        celda0.setCellType(HSSFCell.CELL_TYPE_STRING);
        String titulo0 = "Resumen Validacion";
        HSSFRichTextString texto0 = new HSSFRichTextString((titulo0));
        hojaresumenval.addMergedRegion(new Region(0, (short) 0, 0, (short) 1));
        celda0.setCellValue(texto0);
        row0.setHeight((short) 350);

        HSSFRow fila3 = hojaresumenval.createRow(0);//FILA
        HSSFCell celda3 = fila3.createCell((short) 3);//COLUMNA    
        HSSFRichTextString texto3 = new HSSFRichTextString(encabezado);
        celda3.setCellValue(texto3);
        fila3.setHeight((short) 350);

        HSSFRow fila30 = hojaresumenval.createRow(1);//FILA
        HSSFCell celda30 = fila30.createCell((short) 0);//COLUMNA
        celda30.setCellStyle(estiloCelda1);
        celda30.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt30 = "Procedimiento";
        HSSFRichTextString texto30 = new HSSFRichTextString(txt30);
        celda30.setCellValue(texto30);
        fila30.setHeight((short) 450);

        HSSFRow fila31 = hojaresumenval.createRow(1);//FILA
        HSSFCell celda31 = fila31.createCell((short) 1);//COLUMNA
        celda31.setCellStyle(estiloCelda1);
        celda31.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt31 = "Inconsistencia";
        HSSFRichTextString texto31 = new HSSFRichTextString(txt31);
        celda31.setCellValue(texto31);
        fila31.setHeight((short) 450);

        HSSFRow fila1 = hojaresumenval.createRow(2);//FILA
        HSSFCell celda1 = fila1.createCell((short) 0);//COLUMNA
        celda1.setCellStyle(estiloCeldabordes0);
        celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt0 = "Ordinario";
        HSSFRichTextString texto1 = new HSSFRichTextString(txt0);
        celda1.setCellValue(texto1);
        fila1.setHeight((short) 300);

        HSSFRow fila2 = hojaresumenval.createRow(2);//FILA
        HSSFCell celda2 = fila2.createCell((short) 1);//COLUMNA
        celda2.setCellStyle(estiloCeldabordes0);

        HSSFRow fila4 = hojaresumenval.createRow(3);//FILA
        HSSFCell celda4 = fila4.createCell((short) 0);//COLUMNA
        celda4.setCellStyle(estiloCeldabordes0);
        celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt4 = "Individual";
        HSSFRichTextString texto4 = new HSSFRichTextString(txt4);
        celda4.setCellValue(texto4);
        fila4.setHeight((short) 300);

        HSSFRow fila5 = hojaresumenval.createRow(3);//FILA
        HSSFCell celda5 = fila5.createCell((short) 1);//COLUMNA
        celda5.setCellStyle(estiloCeldabordes0);

        HSSFRow fila6 = hojaresumenval.createRow(4);//FILA
        HSSFCell celda6 = fila6.createCell((short) 0);//COLUMNA
        celda6.setCellStyle(estiloCeldabordes0);
        celda6.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt6 = "Colectivo";
        HSSFRichTextString texto6 = new HSSFRichTextString(txt6);
        celda6.setCellValue(texto6);
        fila6.setHeight((short) 300);

        HSSFRow fila7 = hojaresumenval.createRow(4);//FILA
        HSSFCell celda7 = fila7.createCell((short) 1);//COLUMNA
        celda7.setCellStyle(estiloCeldabordes0);

        HSSFRow filaA10 = hojaresumenval.createRow(5);//FILA
        HSSFCell celdaA10 = filaA10.createCell((short) 0);//COLUMNA
        celdaA10.setCellStyle(estiloCeldabordes0);
        celdaA10.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txtA10 = "Huelga";
        HSSFRichTextString textoA10 = new HSSFRichTextString(txtA10);
        celdaA10.setCellValue(textoA10);
        filaA10.setHeight((short) 300);

        HSSFRow filaA11 = hojaresumenval.createRow(5);//FILA
        HSSFCell celdaA11 = filaA11.createCell((short) 1);//COLUMNA
        celdaA11.setCellStyle(estiloCeldabordes0);

        HSSFRow fila9 = hojaresumenval.createRow(6);//FILA
        HSSFCell celda9 = fila9.createCell((short) 0);//COLUMNA
        celda9.setCellStyle(estiloCeldabordes0);
        celda9.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt9 = "Paraprocesal";
        HSSFRichTextString texto9 = new HSSFRichTextString(txt9);
        celda9.setCellValue(texto9);
        fila9.setHeight((short) 300);

        HSSFRow fila20 = hojaresumenval.createRow(6);//FILA
        HSSFCell celda20 = fila20.createCell((short) 1);//COLUMNA
        celda20.setCellStyle(estiloCeldabordes0);

        HSSFRow fila13 = hojaresumenval.createRow(7);//FILA
        HSSFCell celda13 = fila13.createCell((short) 0);//COLUMNA
        celda13.setCellStyle(estiloCeldabordes0);
        celda13.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt13 = "Ejecucion";
        HSSFRichTextString texto13 = new HSSFRichTextString(txt13);
        celda13.setCellValue(texto13);
        fila13.setHeight((short) 300);

        HSSFRow fila14 = hojaresumenval.createRow(7);//FILA
        HSSFCell celda14 = fila14.createCell((short) 1);//COLUMNA
        celda14.setCellStyle(estiloCeldabordes0);

        HSSFRow fila15 = hojaresumenval.createRow(8);//FILA
        HSSFCell celda15 = fila15.createCell((short) 0);//COLUMNA
        celda15.setCellStyle(estiloCeldabordes0);
        celda15.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt15 = "Colect_Econom";
        HSSFRichTextString texto15 = new HSSFRichTextString(txt15);
        celda15.setCellValue(texto15);
        fila15.setHeight((short) 300);

        HSSFRow fila16 = hojaresumenval.createRow(8);//FILA
        HSSFCell celda16 = fila16.createCell((short) 1);//COLUMNA
        celda16.setCellStyle(estiloCeldabordes0);

        HSSFRow fila17 = hojaresumenval.createRow(9);//FILA
        HSSFCell celda17 = fila17.createCell((short) 0);//COLUMNA
        celda17.setCellStyle(estiloCeldabordes0);
        celda17.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt17 = "SegSocial";
        HSSFRichTextString texto17 = new HSSFRichTextString(txt17);
        celda17.setCellValue(texto17);
        fila17.setHeight((short) 300);

        HSSFRow fila18 = hojaresumenval.createRow(9);//FILA
        HSSFCell celda18 = fila18.createCell((short) 1);//COLUMNA
        celda18.setCellStyle(estiloCeldabordes0);
    }

    public void Desgloses(HSSFWorkbook libro, HSSFSheet hoja0, HSSFCellStyle estiloCelda0, HSSFCellStyle estiloCelda1, HSSFCellStyle estiloCeldabordes0, HSSFCellStyle PAmarillo, JProgressBar progressBar) {
        int fila = 3;
        VOQFDesgloses Desgloses = new VOQFDesgloses();
        Border border = BorderFactory.createTitledBorder("Cargando...Desgloses");
        progressBar.setBorder(border);
        progressBar.setValue(2);
        HSSFRow row0 = hoja0.createRow((short) 1);
        HSSFCell celda0 = row0.createCell((short) 1);
        celda0.setCellStyle(estiloCelda0);
        celda0.setCellType(HSSFCell.CELL_TYPE_STRING);
        String titulo0 = " DESGLOSE POR PROCEDIMIENTO";
        HSSFRichTextString texto0 = new HSSFRichTextString((titulo0));
        celda0.setCellValue(texto0);
        row0.setHeight((short) 600);
        hoja0.addMergedRegion(new Region(1, (short) 1, 1, (short) 19));

        ArrayResult = Desgloses.Desglose_Ordinario();
        HSSFRow fila2 = hoja0.createRow(2);//FILA
        HSSFCell celda2 = fila2.createCell((short) 1);//COLUMNA B
        celda2.setCellStyle(estiloCelda1);
        celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt2 = "ORDINARIO";
        HSSFRichTextString texto2 = new HSSFRichTextString(txt2);
        celda2.setCellValue(texto2);
        fila2.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 1);//COLUMNA B
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        HSSFRow fila3 = hoja0.createRow(2);//FILA
        HSSFCell celda3 = fila3.createCell((short) 2);//COLUMNA C
        celda3.setCellStyle(estiloCelda1);
        celda3.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt3 = "DESGLOSE ORDINARIO";
        HSSFRichTextString texto3 = new HSSFRichTextString(txt3);
        celda3.setCellValue(texto3);
        fila3.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 2);//COLUMNA C
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_Individual();
        HSSFRow fila4 = hoja0.createRow(2);//FILA
        HSSFCell celda4 = fila4.createCell((short) 3);//COLUMNA D
        celda4.setCellStyle(estiloCelda1);
        celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt4 = "INDIVIDUAL";
        HSSFRichTextString texto4 = new HSSFRichTextString(txt4);
        celda4.setCellValue(texto4);
        fila4.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 3);//COLUMNA D
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila24 = hoja0.createRow(2);//FILA
        HSSFCell celda24 = fila24.createCell((short) 4);//COLUMNA E
        celda24.setCellStyle(estiloCelda1);
        celda24.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt24 = "DESGLOSE INDIVIDUAL";
        HSSFRichTextString texto24 = new HSSFRichTextString(txt24);
        celda24.setCellValue(texto24);
        fila24.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 4);//COLUMNA E
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_Colectivo();
        HSSFRow fila5 = hoja0.createRow(2);//FILA
        HSSFCell celda5 = fila5.createCell((short) 5);//COLUMNA F
        celda5.setCellStyle(estiloCelda1);
        celda5.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt5 = "COLECTIVO";
        HSSFRichTextString texto5 = new HSSFRichTextString(txt5);
        celda5.setCellValue(texto5);
        fila5.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 5);//COLUMNA F
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila6 = hoja0.createRow(2);//FILA
        HSSFCell celda6 = fila6.createCell((short) 6);//COLUMNA G
        celda6.setCellStyle(estiloCelda1);
        celda6.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt6 = "DESGLOSE COLECTIVO";
        HSSFRichTextString texto6 = new HSSFRichTextString(txt6);
        celda6.setCellValue(texto6);
        fila6.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 6);//COLUMNA G
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_Huelga();
        HSSFRow fila7 = hoja0.createRow(2);//FILA
        HSSFCell celda7 = fila7.createCell((short) 7);//COLUMNA H
        celda7.setCellStyle(estiloCelda1);
        celda7.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt7 = "HUELGA";
        HSSFRichTextString texto7 = new HSSFRichTextString(txt7);
        celda7.setCellValue(texto7);
        fila7.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 7);//COLUMNA H
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila8 = hoja0.createRow(2);//FILA
        HSSFCell celda8 = fila8.createCell((short) 8);//COLUMNA I
        celda8.setCellStyle(estiloCelda1);
        celda8.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt8 = "DESGLOSE HUELGA";
        HSSFRichTextString texto8 = new HSSFRichTextString(txt8);
        celda8.setCellValue(texto8);
        fila8.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 8);//COLUMNA I
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_ColectivoEconomico();
        HSSFRow fila11 = hoja0.createRow(2);//FILA
        HSSFCell celda11 = fila11.createCell((short) 9);//COLUMNA J
        celda11.setCellStyle(estiloCelda1);
        celda11.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt11 = "COLEC ECONOM";
        HSSFRichTextString texto11 = new HSSFRichTextString(txt11);
        celda11.setCellValue(texto11);
        fila11.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 9);//COLUMNA J
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila12 = hoja0.createRow(2);//FILA
        HSSFCell celda12 = fila12.createCell((short) 10);//COLUMNA K
        celda12.setCellStyle(estiloCelda1);
        celda12.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt12 = "DESGLOSE COLEC ECONOM";
        HSSFRichTextString texto12 = new HSSFRichTextString(txt12);
        celda12.setCellValue(texto12);
        fila12.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 10);//COLUMNA K
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_Huelga();
        HSSFRow fila13 = hoja0.createRow(2);//FILA
        HSSFCell celda13 = fila13.createCell((short) 11);//COLUMNA L
        celda13.setCellStyle(estiloCelda1);
        celda13.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt13 = "HUELGA";
        HSSFRichTextString texto13 = new HSSFRichTextString(txt13);
        celda13.setCellValue(texto13);
        fila13.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 11);//COLUMNA L
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila14 = hoja0.createRow(2);//FILA
        HSSFCell celda14 = fila14.createCell((short) 12);//COLUMNA M
        celda14.setCellStyle(estiloCelda1);
        celda14.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt14 = "DESGLOSE HUELGA";
        HSSFRichTextString texto14 = new HSSFRichTextString(txt14);
        celda14.setCellValue(texto14);
        fila14.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 12);//COLUMNA M
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_SegSocial();
        HSSFRow fila15 = hoja0.createRow(2);//FILA
        HSSFCell celda15 = fila15.createCell((short) 13);//COLUMNA N
        celda15.setCellStyle(estiloCelda1);
        celda15.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt15 = "SEGSOCIAL";
        HSSFRichTextString texto15 = new HSSFRichTextString(txt15);
        celda15.setCellValue(texto15);
        fila15.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 13);//COLUMNA N
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila16 = hoja0.createRow(2);//FILA
        HSSFCell celda16 = fila16.createCell((short) 14);//COLUMNA O
        celda16.setCellStyle(estiloCelda1);
        celda16.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt16 = "DESGLOSE SEGSOCIAL";
        HSSFRichTextString texto16 = new HSSFRichTextString(txt16);
        celda16.setCellValue(texto16);
        fila16.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 14);//COLUMNA O
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_ColectivoEconomico();
        HSSFRow fila17 = hoja0.createRow(2);//FILA
        HSSFCell celda17 = fila17.createCell((short) 15);//COLUMNA P
        celda17.setCellStyle(estiloCelda1);
        celda17.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt17 = "COLECT ECONOM";
        HSSFRichTextString texto17 = new HSSFRichTextString(txt17);
        celda17.setCellValue(texto17);
        fila17.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 15);//COLUMNA P
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila18 = hoja0.createRow(2);//FILA
        HSSFCell celda18 = fila18.createCell((short) 16);//COLUMNA Q
        celda18.setCellStyle(estiloCelda1);
        celda18.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt18 = "DESGLOSE COLECT ECONOM";
        HSSFRichTextString texto18 = new HSSFRichTextString(txt18);
        celda18.setCellValue(texto18);
        fila18.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 16);//COLUMNA Q
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        ArrayResult = Desgloses.Desglose_Paraprocesal();
        HSSFRow fila19 = hoja0.createRow(2);//FILA
        HSSFCell celda19 = fila19.createCell((short) 17);//COLUMNA R
        celda19.setCellStyle(estiloCelda1);
        celda19.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt19 = "PARAPROCESAL";
        HSSFRichTextString texto19 = new HSSFRichTextString(txt19);
        celda19.setCellValue(texto19);
        fila19.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila23 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda23 = fila23.createCell((short) 17);//COLUMNA R
            celda23.setCellStyle(estiloCeldabordes0);
            celda23.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt23 = Arrays.toString(ArrayResult.get(i));
            txt23 = txt23.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt23.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda23.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto23 = new HSSFRichTextString(parts0);
            celda23.setCellValue(texto23);
            fila23.setHeight((short) 300);
        }

        HSSFRow fila20 = hoja0.createRow(2);//FILA
        HSSFCell celda20 = fila20.createCell((short) 18);//COLUMNA S
        celda20.setCellStyle(estiloCelda1);
        celda20.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt20 = "DESGLOSE PARAPROCESAL";
        HSSFRichTextString texto20 = new HSSFRichTextString(txt20);
        celda20.setCellValue(texto20);
        fila20.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 18);//COLUMNA S
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
            fila++;
        }

        ArrayResult = Desgloses.Desglose_Ejecucion();
        HSSFRow fila21 = hoja0.createRow(2);//FILA
        HSSFCell celda21 = fila21.createCell((short) 19);//COLUMNA T
        celda21.setCellStyle(estiloCelda1);
        celda21.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt21 = "EJECUCION";
        HSSFRichTextString texto21 = new HSSFRichTextString(txt21);
        celda21.setCellValue(texto21);
        fila21.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila22 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda22 = fila22.createCell((short) 19);//COLUMNA T
            celda22.setCellStyle(estiloCeldabordes0);
            celda22.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts0 = parts[0].trim();
            parts1 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda22.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto22 = new HSSFRichTextString(parts0);
            celda22.setCellValue(texto22);
            fila22.setHeight((short) 300);
        }

        HSSFRow fila25 = hoja0.createRow(2);//FILA
        HSSFCell celda25 = fila25.createCell((short) 20);//COLUMNA U
        celda25.setCellStyle(estiloCelda1);
        celda25.setCellType(HSSFCell.CELL_TYPE_STRING);
        String txt25 = "DESGLOSE EJECUCION";
        HSSFRichTextString texto25 = new HSSFRichTextString(txt25);
        celda25.setCellValue(texto25);
        fila25.setHeight((short) 500);

        for (int i = 0; i < ArrayResult.size(); i++) {
            HSSFRow fila26 = hoja0.createRow(3 + i);//FILA
            HSSFCell celda26 = fila26.createCell((short) 20);//COLUMNA U
            celda26.setCellStyle(estiloCeldabordes0);
            celda26.setCellType(HSSFCell.CELL_TYPE_STRING);
            String txt22 = Arrays.toString(ArrayResult.get(i));
            txt22 = txt22.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            parts = txt22.split(",");
            parts1 = parts[0].trim();
            parts0 = parts[1].trim();
            if (!parts0.equals(parts1)) {
                celda26.setCellStyle(PAmarillo);
            }
            //System.out.println(Arrays.toString(ArrayResult.get(i)));
            HSSFRichTextString texto26 = new HSSFRichTextString(parts0);
            celda26.setCellValue(texto26);
            fila26.setHeight((short) 300);
            fila++;
        }

        progressBar.setValue(5);
    }

    public void Despliega_ControlExpediente(HSSFWorkbook libro, HSSFSheet hojaControl_expe, HSSFCellStyle estiloCelda0, HSSFCellStyle estiloCelda1, HSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {
        //V3Control_expediente CE = new V3Control_expediente();
        int conEnc = 1, conDat = 2, coni = 1;

        Border border = BorderFactory.createTitledBorder("Cargando...Control Expediente");
        progressBar.setBorder(border);
        HSSFRow row0 = hojaControl_expe.createRow((short) 0);//Fila
        HSSFCell celda0 = row0.createCell((short) 0);//Coumna
        celda0.setCellStyle(estiloCelda0);
        celda0.setCellType(HSSFCell.CELL_TYPE_STRING);
        String titulo0 = " PROCEDIMIENTO CONTROL EXPEDIENTE ";
        HSSFRichTextString texto0 = new HSSFRichTextString((titulo0));
        hojaControl_expe.addMergedRegion(new Region(0, (short) 0, 0, (short) 3));
        celda0.setCellValue(texto0);
        row0.setHeight((short) 600);

        progressBar.setValue(10);
    }

    public void Despliega_Audiencias(HSSFWorkbook libro, HSSFSheet hojaAudiencias, HSSFCellStyle estiloCelda0, HSSFCellStyle estiloCelda1, HSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {
        VOQFAudiencias VOQF_Audiencias = new VOQFAudiencias();

        Border border = BorderFactory.createTitledBorder("Cargando...Audiencias");
        progressBar.setBorder(border);
        int conEnc = 1, conDat = 2, coni = 1;

        HSSFRow row0 = hojaAudiencias.createRow((short) 0);//Fila
        HSSFCell celda0 = row0.createCell((short) 0);//Coumna
        celda0.setCellStyle(estiloCelda0);
        celda0.setCellType(HSSFCell.CELL_TYPE_STRING);
        String titulo0 = " PROCEDIMIENTO AUDIENCIAS ";
        HSSFRichTextString texto0 = new HSSFRichTextString((titulo0));
        hojaAudiencias.addMergedRegion(new Region(0, (short) 0, 0, (short) 3));
        celda0.setCellValue(texto0);
        row0.setHeight((short) 600);

        ArrayResult = VOQF_Audiencias.Aud_Ordinario();
        if (ArrayResult.size() > 0) {
            System.out.println("contador Encabezado: " + conEnc + " Contador Datos: " + conDat);
            HSSFRow fila00 = hojaAudiencias.createRow(2);
            HSSFCell celda00 = fila00.createCell((short) 1);

            // ENCABEZADOS
            HSSFRow filaEncabezado = hojaAudiencias.createRow(conEnc);
            filaEncabezado.setHeight((short) 600);

            HSSFCell celda1 = filaEncabezado.createCell((short) 0);
            celda1.setCellStyle(estiloCelda1);
            celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda1.setCellValue(new HSSFRichTextString("CLAVE DEL ORGANO"));

            HSSFCell celda2 = filaEncabezado.createCell((short) 1);
            celda2.setCellStyle(estiloCelda1);
            celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue(new HSSFRichTextString("CLAVE DEL EXPEDIENTE"));

            HSSFCell celda5 = filaEncabezado.createCell((short) 2);
            celda5.setCellStyle(estiloCelda1);
            celda5.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda5.setCellValue(new HSSFRichTextString("OBSERVACIONES"));

            HSSFCell celda5A = filaEncabezado.createCell((short) 3);
            celda5A.setCellStyle(estiloCelda1);
            celda5A.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda5A.setCellValue(new HSSFRichTextString("TOTAL DE CASOS"));

            // AGRUPAR EXPEDIENTES POR ID_ORGANOJ
            Map<String, List<String>> expedientesPorOrgano = new LinkedHashMap<>();

            // GUARDAR LA OBSERVACION DE CADA ORGANO
            Map<String, String> observacionPorOrgano = new LinkedHashMap<>();

            if (ArrayResult.size() < 2500) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String[] datos = (String[]) ArrayResult.get(i);

                    String idOrgano = datos[0];
                    String claveExpediente = datos[1];
                    String estatusBusqueda = datos[2];

                    expedientesPorOrgano.computeIfAbsent(idOrgano, k -> new ArrayList<String>()).add(claveExpediente);
                    observacionPorOrgano.put(idOrgano, estatusBusqueda);
                }
            } else {
                String[] datos = (String[]) ArrayResult.get(0);
                expedientesPorOrgano.put("General", Arrays.asList("General"));
                observacionPorOrgano.put("General", datos[2]);
            }
            // CREAR FILAS POR CADA ID_ORGANOJ
            int filaActual = conEnc + 1;
            for (Map.Entry<String, List<String>> entry : expedientesPorOrgano.entrySet()) {
                String idOrgano = entry.getKey();
                List<String> expedientes = entry.getValue();
                String textoExpedientes = String.join(" , ", expedientes);

                String observacion = observacionPorOrgano.get(idOrgano);
                String totalCasos;
                if (idOrgano.equals("General")) {
                    totalCasos = String.valueOf(ArrayResult.size());
                } else {
                    totalCasos = String.valueOf(expedientes.size());
                }

                HSSFRow filaDatos = hojaAudiencias.createRow(filaActual);
                filaDatos.setHeight((short) 300);

                HSSFCell celdaOrgano = filaDatos.createCell((short) 0);
                celdaOrgano.setCellStyle(estiloCeldabordes0);
                celdaOrgano.setCellType(HSSFCell.CELL_TYPE_STRING);
                celdaOrgano.setCellValue(
                        new HSSFRichTextString(idOrgano)
                );

                HSSFCell celdaExpediente = filaDatos.createCell((short) 1); // EXPEDIENTES
                celdaExpediente.setCellStyle(estiloCeldabordes0);
                celdaExpediente.setCellType(HSSFCell.CELL_TYPE_STRING);
                celdaExpediente.setCellValue(
                        new HSSFRichTextString(textoExpedientes)
                );

                HSSFCell celdaObs = filaDatos.createCell((short) 2); // OBSERVACION
                celdaObs.setCellStyle(estiloCeldabordes0);
                celdaObs.setCellType(HSSFCell.CELL_TYPE_STRING);
                celdaObs.setCellValue(
                        new HSSFRichTextString(observacion)
                );

                HSSFCell celdaTotal = filaDatos.createCell((short) 3); // TOTAL DE CASOS
                celdaTotal.setCellStyle(estiloCeldabordes0);
                celdaTotal.setCellType(HSSFCell.CELL_TYPE_STRING);
                celdaTotal.setCellValue(
                        new HSSFRichTextString(totalCasos)
                );

                filaActual++;
            }
            coni = expedientesPorOrgano.size();
            System.out.println("contador i: " + coni);
            conEnc = conEnc + coni + 1;
            conDat = conDat + coni + 1;
            coni = 1;
            System.out.println("contador i: " + conEnc + " " + conDat + " " + ArrayResult.size());
        }

        progressBar.setValue(15);
    }

}
