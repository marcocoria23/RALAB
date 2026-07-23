/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.BD.federal;

import Bean_Procedures_Federal.BeanIndividual;
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
public class ReadCSV_Individual_Fed {

    public static String impErro = "", RutaT = "";
    public static int TotalRegistros = 0;
    public static boolean borra_ruta = false;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    OracleConexionRalFed conexion = new OracleConexionRalFed();
    Convertir_utf8 conUTF8 = new Convertir_utf8();

    public void IN_INDIVIDUAL(String Ruta) throws Exception {

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
                if (numeroColumnas == 68) {
                    System.out.println("+hellooou+" + numeroColumnas);
                    cargando cargar = new cargando();
                    ArrayList<BeanIndividual> ad = new ArrayList<>();
                    for (CSVRecord record : csvParser) {
                        if (detectarCharsetFed.esFilaVacia(record, "TMP_FED_INDIVIDUAL")) {
                            continue;
                        }
                        TotalRegistros++;
                        BeanIndividual c = new BeanIndividual();
                        c.NOMBRE_ORGANO_JURIS(record.get(0));
                        c.ID_ORGANOJ(record.get(1));
                        c.CLAVE_EXPEDIENTE(record.get(2));
                        c.FECHA_APERTURA_EXPED(record.get(3));
                        c.ID_TIPO_ASUNTO(record.get(4));
                        c.ID_NAT_CONFLICTO(record.get(5));
                        c.RAMA_INVOLUC(record.get(6));
                        c.CLAVE_ENTIDAD_ORG(record.get(7));
                        c.CLAVE_ENTIDAD_PAT(record.get(8));
                        c.CLAVE_MUN_PAT(record.get(9));
                        c.PREG_SUBCONTRATACION(record.get(10));
                        c.PREG_SUSPENSION_TRABAJADOR(record.get(11));
                        c.PREG_SUSPENSION_PATRON(record.get(12));
                        c.PREG_INDEMNIZACION_PATRON(record.get(13));
                        c.PREG_AUTORIZACION_LABORAR(record.get(14));
                        c.PREG_RECONOCIMIENTO_TRABAJO(record.get(15));
                        c.PREG_CAPACITACION(record.get(16));
                        c.PREG_ADIESTRAMIENTO(record.get(17));
                        c.PREG_NULIDAD_CLAUSULA_CONTRA(record.get(18));
                        c.PREG_CONDICIONES_TRABAJO(record.get(19));
                        c.PREG_HORAS_EXTRA(record.get(20));
                        c.PREG_HABITACION(record.get(21));
                        c.PREG_CREDITOS(record.get(22));
                        c.PREG_CAPACITACION_ADIESTRAMI(record.get(23));
                        c.PREG_PRIMA_ANTIGUEDAD(record.get(24));
                        c.PREG_REGLAMENTO_INTER_TRABAJO(record.get(25));
                        c.PREG_RENTA_MAX_HAB_TRABAJADOR(record.get(26));
                        c.PREG_OBLIGA_DERIV_RENTA_HAB(record.get(27));
                        c.PREG_COBRO_PRESTA_SALARIO(record.get(28));
                        c.PREG_ALOJAMIENTO(record.get(29));
                        c.PREG_SALARIO_BASE_COTIZACION(record.get(30));
                        c.PREG_INCAPACI_PERMA_PARCIAL(record.get(31));
                        c.PREG_MUERTE(record.get(32));
                        c.PREG_PENSION_ASCENDENCIA(record.get(33));
                        c.PREG_PENSION_GARANTIZADA(record.get(34));
                        c.PREG_INCRE_PENSION(record.get(35));
                        c.PREG_INDEMNIZACION_GLOBAL(record.get(36));
                        c.PREG_ASISTENCIA_MEDICA(record.get(37));
                        c.PREG_APARATOS_PROT_ORTOP(record.get(38));
                        c.PREG_RIESGOS_SALARIO_BASE(record.get(39));
                        c.PREG_RIESGOS_PAGO_INDEMNIZA(record.get(40));
                        c.PREG_RIESGO_OPOSICION_DESIG(record.get(41));
                        c.PREG_DESIGNACION_FALLECIDO(record.get(42));
                        c.PREG_DESIGNACION_DESAPARECIDO(record.get(43));
                        c.PREG_INCOMPETENCIA(record.get(44));
                        c.ID_TIPO_INCOMPETENCIA(record.get(45));
                        c.FECHA_PRESENTACION(record.get(46));
                        c.PREG_CONSTANCIA(record.get(47));
                        c.PREG_EXCEP_CONCILIA(record.get(48));
                        c.PREG_PREVENCION(record.get(49));
                        c.ID_ESTATUS_DEMANDA(record.get(50));
                        c.ID_CAUSA_IMP_DEM(record.get(51));
                        c.FECHA_ADM_DEMANDA(record.get(52));
                        c.CANT_ACTORES(record.get(53));
                        c.CANT_DEMANDADOS(record.get(54));
                        c.PREG_TRAMITACION_DEPURACION(record.get(55));
                        c.FECHA_DEPURACION(record.get(56));
                        c.PREG_AUD_PRELIM_CELEBR(record.get(57));
                        c.FECHA_AUDIENCIA_PRELIM(record.get(58));
                        c.PREG_CELEBRA_AUD_JUICIO(record.get(59));
                        c.FECHA_AUD_JUICIO(record.get(60));
                        c.ID_ESTATUS_EXPED(record.get(61));
                        c.FECHA_ULT_ACT_PROC(record.get(62));
                        c.ID_FASE_SOL_EXPED(record.get(63));
                        c.ID_FORMA_SOLUCION(record.get(64));
                        c.FECHA_DICTO_SOLUCION(record.get(65));
                        c.FECHA_SENTENCIA(record.get(66));
                        c.ID_SENTIDO_SENTEN(record.get(67));
                        ad.add(c);
                    }
                    System.out.println("entro 1");
                    if (TotalRegistros > 0) {
                        if (Inserta == true) {
                            cargar.setVisible(true);
                            con = OracleDAOFactoryFED.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_FED_INDIVIDUAL", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_FED_INDIVIDUAL", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORCSV.Individual(?))}");
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
                    JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo T.2.1_esp_indiv.csv no coincide con la bd Oracle");
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
                            "Tabla: TMP_FED_INDIVIDUAL\n"
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
