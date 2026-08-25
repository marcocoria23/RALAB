/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.BD.federal;

import Bean_Procedures_Federal.BeanHuelga;
import Conexion.OracleConexionRalFed;
import Conexion.OracleDAOFactoryFED;
import Screen_laborales.cargando;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.BD.Convertir_utf8;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ReadCSV_Huelga_Fed {

    public static String impErro = "", RutaT = "";
    public static int TotalRegistros = 0;
    public static boolean borra_ruta = false;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    OracleConexionRalFed conexion = new OracleConexionRalFed();
    Convertir_utf8 conUTF8 = new Convertir_utf8();
    
     private String sinNull(String valor) {
    return valor == null || valor.equalsIgnoreCase("NULL") ? "" : valor;
}

    public void IN_HUELGA(String Ruta) throws Exception {

        String rutaArchivoCSV = Ruta;
        ArrayList<String[]> Array;
        Array = new ArrayList();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        TotalRegistros = 0;
        boolean Inserta = true;
        con = OracleDAOFactoryFED.creaConexion();
        System.out.println("Conexion existosa: FEDERAL");

        try {
            Charset charset = detectarCharsetFed.detectarCharset(rutaArchivoCSV);
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(rutaArchivoCSV), charset)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                int numeroColumnas = 0;
                CSVRecord firstRecord = csvParser.iterator().next();
                numeroColumnas = firstRecord.size();
                System.out.println("numcol " + numeroColumnas);
                if (numeroColumnas == 28) {
                    System.out.println("+hellooou+" + numeroColumnas);
                    cargando cargar = new cargando();
                    ArrayList<BeanHuelga> ad = new ArrayList<>();
                    int filaDebug = 0;  
                    for (CSVRecord record : csvParser) {
                        filaDebug++;
                        if (detectarCharsetFed.esFilaVacia(record, "TMP_FED_HUELGA")) {
                            continue;
                        }
                        if (record.size() != 28) {
                            System.out.println("FILA " + filaDebug + " tiene " + record.size() + " columnas:");
                            for (int i = 0; i < record.size(); i++) {
                                System.out.println("  Col[" + i + "] = " + record.get(i));
                            }
                            continue; // saltamos esta fila para que no truene el record.get(27) más abajo
                        }
                        TotalRegistros++;
                        BeanHuelga c = new BeanHuelga();
                        c.NOMBRE_ORGANO_JURIS(sinNull(record.get(0)));
                        c.ID_ORGANOJ(sinNull(record.get(1)));
                        c.CLAVE_EXPEDIENTE(sinNull(record.get(2)));
                        c.FECHA_PRESENTACION(sinNull(record.get(3)));
                        c.FECHA_APERTURA_EXPEDIENTE(sinNull(record.get(4)));
                        c.ID_TIPO_ASUNTO(sinNull(record.get(5)));
                        c.RAMA_INVOLUC(sinNull(record.get(6)));
                        c.ENTIDAD_CLAVE_ORG(sinNull(record.get(7)));
                        c.ENTIDAD_CLAVE(sinNull(record.get(8)));
                        c.MUNICIPIO_CLAVE(sinNull(record.get(9)));
                        c.PREG_FIRMADECONTRATO(sinNull(record.get(10)));
                        c.PREG_REVISIONDECONTRATO(sinNull(record.get(11)));
                        c.PREG_REVISIONDESALARIOS(sinNull(record.get(12)));
                        c.PREG_CUMPLIMIENTODECONTRATO(sinNull(record.get(13)));
                        c.PREG_EQUILIBRIODELOSFACTORES(sinNull(record.get(14)));
                        c.PREG_HUELGA(sinNull(record.get(15)));
                        c.PREG_PARTICIPACIONDEUTILIDADES(sinNull(record.get(16)));
                        c.PREG_INCOMPETENCIA(sinNull(record.get(17)));
                        c.ID_TIPO_INCOMPETENCIA(sinNull(record.get(18)));
                        c.CANT_ACTORES(sinNull(record.get(19)));
                        c.CANT_DEMANDADOS(sinNull(record.get(20)));
                        c.ID_ESTATUS_EXPED(sinNull(record.get(21)));
                        c.FECHA_ULT_ACT_PROC(sinNull(record.get(22)));
                        c.ID_FASE_SOL_EXPED(sinNull(record.get(23)));
                        c.ID_FORMA_SOLUCION(sinNull(record.get(24)));
                        c.FECHA_DICTO_SOLUCION(sinNull(record.get(25)));
                        c.PREG_ESTALLAMIENTO(sinNull(record.get(26)));
                        c.FECHA_ESTALLAMIENTO(sinNull(record.get(27)));
                        ad.add(c);
                    }
                    System.out.println("entro 1");
                    if (TotalRegistros > 0) {
                        if (Inserta == true) {
                            cargar.setVisible(true);
                            con = OracleDAOFactoryFED.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_FED_HUELGA", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_FED_HUELGA", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORCSV.Huelga(?))}");
                            System.out.println("entro 6");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("entro 7");
                            st.setArray(2, array_to_pass);
                            System.out.println("entro 8");
                            st.execute();
                            System.out.println("entro 9");
                            cargar.setVisible(false);
                        } else {
                            cargar.setVisible(false);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo T.4.1_huelga.csv no coincide con la bd Oracle");
                }
            } catch (IOException e) {
                System.out.println("++" + e);
            } finally {
                try {
                    array_to_pass = null;
                    structs = null;
                    descriptor = null;
                    if (con != null) {
                        System.out.println("cierraaa");
                        con.close();
                        con = null;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Tabla: TMP_FED_HUELGA\n"
                            + "[actualiza]: " + ex.getLocalizedMessage(),
                            "Error SQL",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
