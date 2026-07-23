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
                System.out.println("numcol" + numeroColumnas);
                if (numeroColumnas == 28) {
                    System.out.println("+hellooou+" + numeroColumnas);
                    cargando cargar = new cargando();
                    ArrayList<BeanHuelga> ad = new ArrayList<>();
                    for (CSVRecord record : csvParser) {
                        if (detectarCharsetFed.esFilaVacia(record, "TMP_FED_HUELGA")) {
                            continue;
                        }
                        TotalRegistros++;
                        BeanHuelga c = new BeanHuelga();
                        c.NOMBRE_ORGANO_JURIS(record.get(0));
                        c.ID_ORGANOJ(record.get(1));
                        c.CLAVE_EXPEDIENTE(record.get(2));
                        c.FECHA_PRESENTACION(record.get(3));
                        c.FECHA_APERTURA_EXPEDIENTE(record.get(4));
                        c.ID_TIPO_ASUNTO(record.get(5));
                        c.RAMA_INVOLUC(record.get(6));
                        c.ENTIDAD_CLAVE_ORG(record.get(7));
                        c.ENTIDAD_CLAVE(record.get(8));
                        c.MUNICIPIO_CLAVE(record.get(9));
                        c.PREG_FIRMADECONTRATO(record.get(10));
                        c.PREG_REVISIONDECONTRATO(record.get(11));
                        c.PREG_REVISIONDESALARIOS(record.get(12));
                        c.PREG_CUMPLIMIENTODECONTRATO(record.get(13));
                        c.PREG_EQUILIBRIODELOSFACTORES(record.get(14));
                        c.PREG_HUELGA(record.get(15));
                        c.PREG_PARTICIPACIONDEUTILIDADES(record.get(16));
                        c.PREG_INCOMPETENCIA(record.get(17));
                        c.ID_TIPO_INCOMPETENCIA(record.get(18));
                        c.CANT_ACTORES(record.get(19));
                        c.CANT_DEMANDADOS(record.get(20));
                        c.ID_ESTATUS_EXPED(record.get(21));
                        c.FECHA_ULT_ACT_PROC(record.get(22));
                        c.ID_FASE_SOL_EXPED(record.get(23));
                        c.ID_FORMA_SOLUCION(record.get(24));
                        c.FECHA_DICTO_SOLUCION(record.get(25));
                        c.PREG_ESTALLAMIENTO(record.get(26));
                        c.FECHA_ESTALLAMIENTO(record.get(27));
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
