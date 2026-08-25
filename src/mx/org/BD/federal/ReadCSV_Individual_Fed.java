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
    
      private String sinNull(String valor) {
    return valor == null || valor.equalsIgnoreCase("NULL") ? "" : valor;
}

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
                       c.NOMBRE_ORGANO_JURIS(sinNull(record.get(0)));
                        c.ID_ORGANOJ(sinNull(record.get(1)));
                        c.CLAVE_EXPEDIENTE(sinNull(record.get(2)));
                        c.FECHA_APERTURA_EXPED(sinNull(record.get(3)));
                        c.ID_TIPO_ASUNTO(sinNull(record.get(4)));
                        c.ID_NAT_CONFLICTO(sinNull(record.get(5)));
                        c.RAMA_INVOLUC(sinNull(record.get(6)));
                        c.CLAVE_ENTIDAD_ORG(sinNull(record.get(7)));
                        c.CLAVE_ENTIDAD_PAT(sinNull(record.get(8)));
                        c.CLAVE_MUN_PAT(sinNull(record.get(9)));
                        c.PREG_SUBCONTRATACION(sinNull(record.get(10)));
                        c.PREG_SUSPENSION_TRABAJADOR(sinNull(record.get(11)));
                        c.PREG_SUSPENSION_PATRON(sinNull(record.get(12)));
                        c.PREG_INDEMNIZACION_PATRON(sinNull(record.get(13)));
                        c.PREG_AUTORIZACION_LABORAR(sinNull(record.get(14)));
                        c.PREG_RECONOCIMIENTO_TRABAJO(sinNull(record.get(15)));
                        c.PREG_CAPACITACION(sinNull(record.get(16)));
                        c.PREG_ADIESTRAMIENTO(sinNull(record.get(17)));
                        c.PREG_NULIDAD_CLAUSULA_CONTRA(sinNull(record.get(18)));
                        c.PREG_CONDICIONES_TRABAJO(sinNull(record.get(19)));
                        c.PREG_HORAS_EXTRA(sinNull(record.get(20)));
                        c.PREG_HABITACION(sinNull(record.get(21)));
                        c.PREG_CREDITOS(sinNull(record.get(22)));
                        c.PREG_CAPACITACION_ADIESTRAMI(sinNull(record.get(23)));
                        c.PREG_PRIMA_ANTIGUEDAD(sinNull(record.get(24)));
                        c.PREG_REGLAMENTO_INTER_TRABAJO(sinNull(record.get(25)));
                        c.PREG_RENTA_MAX_HAB_TRABAJADOR(sinNull(record.get(26)));
                        c.PREG_OBLIGA_DERIV_RENTA_HAB(sinNull(record.get(27)));
                        c.PREG_COBRO_PRESTA_SALARIO(sinNull(record.get(28)));
                        c.PREG_ALOJAMIENTO(sinNull(record.get(29)));
                        c.PREG_SALARIO_BASE_COTIZACION(sinNull(record.get(30)));
                        c.PREG_INCAPACI_PERMA_PARCIAL(sinNull(record.get(31)));
                        c.PREG_MUERTE(sinNull(record.get(32)));
                        c.PREG_PENSION_ASCENDENCIA(sinNull(record.get(33)));
                        c.PREG_PENSION_GARANTIZADA(sinNull(record.get(34)));
                        c.PREG_INCRE_PENSION(sinNull(record.get(35)));
                        c.PREG_INDEMNIZACION_GLOBAL(sinNull(record.get(36)));
                        c.PREG_ASISTENCIA_MEDICA(sinNull(record.get(37)));
                        c.PREG_APARATOS_PROT_ORTOP(sinNull(record.get(38)));
                        c.PREG_RIESGOS_SALARIO_BASE(sinNull(record.get(39)));
                        c.PREG_RIESGOS_PAGO_INDEMNIZA(sinNull(record.get(40)));
                        c.PREG_RIESGO_OPOSICION_DESIG(sinNull(record.get(41)));
                        c.PREG_DESIGNACION_FALLECIDO(sinNull(record.get(42)));
                        c.PREG_DESIGNACION_DESAPARECIDO(sinNull(record.get(43)));
                        c.PREG_INCOMPETENCIA(sinNull(record.get(44)));
                        c.ID_TIPO_INCOMPETENCIA(sinNull(record.get(45)));
                        c.FECHA_PRESENTACION(sinNull(record.get(46)));
                        c.PREG_CONSTANCIA(sinNull(record.get(47)));
                        c.PREG_EXCEP_CONCILIA(sinNull(record.get(48)));
                        c.PREG_PREVENCION(sinNull(record.get(49)));
                        c.ID_ESTATUS_DEMANDA(sinNull(record.get(50)));
                        c.ID_CAUSA_IMP_DEM(sinNull(record.get(51)));
                        c.FECHA_ADM_DEMANDA(sinNull(record.get(52)));
                        c.CANT_ACTORES(sinNull(record.get(53)));
                        c.CANT_DEMANDADOS(sinNull(record.get(54)));
                        c.PREG_TRAMITACION_DEPURACION(sinNull(record.get(55)));
                        c.FECHA_DEPURACION(sinNull(record.get(56)));
                        c.PREG_AUD_PRELIM_CELEBR(sinNull(record.get(57)));
                        c.FECHA_AUDIENCIA_PRELIM(sinNull(record.get(58)));
                        c.PREG_CELEBRA_AUD_JUICIO(sinNull(record.get(59)));
                        c.FECHA_AUD_JUICIO(sinNull(record.get(60)));
                        c.ID_ESTATUS_EXPED(sinNull(record.get(61)));
                        c.FECHA_ULT_ACT_PROC(sinNull(record.get(62)));
                        c.ID_FASE_SOL_EXPED(sinNull(record.get(63)));
                        c.ID_FORMA_SOLUCION(sinNull(record.get(64)));
                        c.FECHA_DICTO_SOLUCION(sinNull(record.get(65)));
                        c.FECHA_SENTENCIA(sinNull(record.get(66)));
                        c.ID_SENTIDO_SENTEN(sinNull(record.get(67)));
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
