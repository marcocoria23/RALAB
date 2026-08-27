/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.BD.federal;

import Bean_Procedures_Federal.BeanOrdinario;
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
public class ReadCSV_Ordinario_Fed {

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
     
    public void IN_ORDINARIO(String Ruta) throws Exception {

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
                int ajuste = 0;
                if (numeroColumnas == 86) {
                    ajuste = -2;
                }
                System.out.println("Número columnas: " + numeroColumnas);
                System.out.println("Ajuste: " + ajuste);
                if (numeroColumnas == 86 || numeroColumnas == 88) {
                    System.out.println("+hellooou+" + numeroColumnas);
                    cargando cargar = new cargando();
                    ArrayList<BeanOrdinario> ad = new ArrayList<>();
                    for (CSVRecord record : csvParser) {
                        if (detectarCharsetFed.esFilaVacia(record, "TMP_FED_ORDINARIO")) {
                            continue;
                        }
                        TotalRegistros++;
                        BeanOrdinario c = new BeanOrdinario();
                       c.NOMBRE_ORGANO_JURIS(sinNull(record.get(0)));
                        c.ID_ORGANOJ(sinNull(record.get(1)));
                        c.CLAVE_EXPEDIENTE(sinNull(record.get(2)));
                        c.FECHA_APERTURA_EXPED(sinNull(record.get(3)));
                        c.ID_TIPO_ASUNTO(sinNull(record.get(4)));
                        c.ID_NAT_CONFLICTO(sinNull(record.get(5)));
                        c.RAMA_INVOLUC(sinNull(record.get(6)));

                        if (numeroColumnas == 88) {
                            c.SECTOR(sinNull(record.get(7)));
                            c.SUBSECTOR(sinNull(record.get(8)));
                        } else {
                            c.SECTOR(null);
                            c.SUBSECTOR(null);
                        }

                        c.CLAVE_ENTIDAD_ORG(sinNull(record.get(9 + ajuste)));
                        c.CLAVE_ENTIDAD_PAT(sinNull(record.get(10 + ajuste)));
                        c.CLAVE_ENTIDAD_MUN(sinNull(record.get(11 + ajuste)));
                        c.PREG_SUBCONTRATACION(sinNull(record.get(12 + ajuste)));
                        c.PREG_SALARIOS_VEN(sinNull(record.get(13 + ajuste)));
                        c.PREG_REINSTALACION(sinNull(record.get(14 + ajuste)));
                        c.PREG_PAGO_INDEM(sinNull(record.get(15 + ajuste)));
                        c.PREG_TERMINA_RELA_LAB(sinNull(record.get(16 + ajuste)));
                        c.PREG_DEPOSITO_INDEM(sinNull(record.get(17 + ajuste)));
                        c.PREG_RESPONS_CONFLIC(sinNull(record.get(18 + ajuste)));
                        c.PREG_NULIDAD_RENUN(sinNull(record.get(19 + ajuste)));
                        c.PREG_RESOSITO_RESPO(sinNull(record.get(20 + ajuste)));
                        c.PREG_RELA_TRAB(sinNull(record.get(21 + ajuste)));
                        c.PREG_NULIDAD_LIQUI(sinNull(record.get(22 + ajuste)));
                        c.PREG_RATIF_CONVEN(sinNull(record.get(23 + ajuste)));
                        c.PREG_RESPONS_PATRON(sinNull(record.get(24 + ajuste)));
                        c.PREG_VACACIONES(sinNull(record.get(25 + ajuste)));
                        c.PREG_PRIMA_VACACIONAL(sinNull(record.get(26 + ajuste)));
                        c.PREG_AGUINALDO(sinNull(record.get(27 + ajuste)));
                        c.PREG_SALARIO(sinNull(record.get(28 + ajuste)));
                        c.PREG_PRIMA_ANTIGUEDAD(sinNull(record.get(29 + ajuste)));
                        c.PREG_HORAS_EXTRA(sinNull(record.get(30 + ajuste)));
                        c.PREG_RECONO_ANTIGUEDAD(sinNull(record.get(31 + ajuste)));
                        c.PREG_DIAS_DESCANSO(sinNull(record.get(32 + ajuste)));
                        c.PREG_DERECHO_PREF(sinNull(record.get(33 + ajuste)));
                        c.PREG_BONOS(sinNull(record.get(34 + ajuste)));
                        c.PREG_GRATIFICA(sinNull(record.get(35 + ajuste)));
                        c.PREG_OCUPACION_VACAN(sinNull(record.get(36 + ajuste)));
                        c.PREG_COMISIONES(sinNull(record.get(37 + ajuste)));
                        c.PREG_DESCUENTO(sinNull(record.get(38 + ajuste)));
                        c.PREG_ASCENSO(sinNull(record.get(39 + ajuste)));
                        c.PREG_DESCANSO(sinNull(record.get(40 + ajuste)));
                        c.PREG_RECIBO_PAGO(sinNull(record.get(41 + ajuste)));
                        c.PREG_AFILACION(sinNull(record.get(42 + ajuste)));
                        c.PREG_ESCUELAS(sinNull(record.get(43 + ajuste)));
                        c.PREG_PROPINA(sinNull(record.get(44 + ajuste)));
                        c.PREG_INVENCIONES(sinNull(record.get(45 + ajuste)));
                        c.PREG_RELACION_TRAB(sinNull(record.get(46 + ajuste)));
                        c.PREG_DIVERSO_DOC(sinNull(record.get(47 + ajuste)));
                        c.PREG_BASE_ANTIGUEDAD(sinNull(record.get(48 + ajuste)));
                        c.PREG_RENIVELACION(sinNull(record.get(49 + ajuste)));
                        c.PREG_SUSTI_PATRON(sinNull(record.get(50 + ajuste)));
                        c.PREG_MUERTE(sinNull(record.get(51 + ajuste)));
                        c.PREG_INCRE_PENSION(sinNull(record.get(52 + ajuste)));
                        c.PREG_RETIRO(sinNull(record.get(53 + ajuste)));
                        c.PREG_VIDA(sinNull(record.get(54 + ajuste)));
                        c.PREG_ENFERMEDADES(sinNull(record.get(55 + ajuste)));
                        c.PREG_VEJEZ(sinNull(record.get(56 + ajuste)));
                        c.PREG_RETORNO_PUESTO(sinNull(record.get(57 + ajuste)));
                        c.PREG_PAGO_SALARIO(sinNull(record.get(58 + ajuste)));
                        c.PREG_TRAB_CONS(sinNull(record.get(59 + ajuste)));
                        c.PREG_ANT_PRE(sinNull(record.get(60 + ajuste)));
                        c.PREG_LABORES_PEL(sinNull(record.get(61 + ajuste)));
                        c.PREG_DESCANSO_SEMANAS(sinNull(record.get(62 + ajuste)));
                        c.PREG_PRORROGA(sinNull(record.get(63 + ajuste)));
                        c.PREG_ALIMENTACION(sinNull(record.get(64 + ajuste)));
                        c.PREG_ACTOS(sinNull(record.get(65 + ajuste)));
                        c.PREG_INCOMPETENCIA(sinNull(record.get(66 + ajuste)));
                        c.ID_TIPO_INCOMPETENCIA(sinNull(record.get(67 + ajuste)));
                        c.FECHA_PRESENTACION(sinNull(record.get(68 + ajuste)));
                        c.PREG_CONSTANCIA(sinNull(record.get(69 + ajuste)));
                        c.PREG_EXCEP_CONCILIA(sinNull(record.get(70 + ajuste)));
                        c.PREG_PREVENCION(sinNull(record.get(71 + ajuste)));
                        c.ID_ESTATUS_DEMANDA(sinNull(record.get(72 + ajuste)));
                        c.ID_CAUSA_IMP_DEM(sinNull(record.get(73 + ajuste)));
                        c.FECHA_ADM_DEMANDA(sinNull(record.get(74 + ajuste)));
                        c.CANT_ACTORES(sinNull(record.get(75 + ajuste)));
                        c.CANT_DEMANDADOS(sinNull(record.get(76 + ajuste)));
                        c.PREG_AUD_PRELIM_CELEBR(sinNull(record.get(77 + ajuste)));
                        c.FECHA_AUDIENCIA_PRELIM(sinNull(record.get(78 + ajuste)));
                        c.PREG_CELEBRA_AUD_JUICIO(sinNull(record.get(79 + ajuste)));
                        c.FECHA_AUD_JUICIO(sinNull(record.get(80 + ajuste)));
                        c.ID_ESTATUS_EXPED(sinNull(record.get(81 + ajuste)));
                        c.FECHA_ULT_ACT_PROC(sinNull(record.get(82 + ajuste)));
                        c.ID_FASE_SOL_EXPED(sinNull(record.get(83 + ajuste)));
                        c.ID_FORMA_SOLUCION(sinNull(record.get(84 + ajuste)));
                        c.FECHA_DICTO_SOLUCION(sinNull(record.get(85 + ajuste)));
                        c.FECHA_SENTENCIA(sinNull(record.get(86 + ajuste)));
                        c.ID_SENTIDO_SENTEN(sinNull(record.get(87 + ajuste)));
                        ad.add(c);
                    }
                    System.out.println("entro 1");
                    if (TotalRegistros > 0) {
                        if (Inserta == true) {
                            cargar.setVisible(true);
                            con = OracleDAOFactoryFED.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_FED_ORDINARIO", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_FED_ORDINARIO", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORCSV.Ordinario(?))}");
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
                    JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo T.1.1_ordinario.csv no coincide con la bd Oracle");
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
                            "Tabla: TMP_FED_ORDINARIO\n"
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
