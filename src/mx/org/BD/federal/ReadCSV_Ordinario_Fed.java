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
                        c.NOMBRE_ORGANO_JURIS(record.get(0));
                        c.ID_ORGANOJ(record.get(1));
                        c.CLAVE_EXPEDIENTE(record.get(2));
                        c.FECHA_APERTURA_EXPED(record.get(3));
                        c.ID_TIPO_ASUNTO(record.get(4));
                        c.ID_NAT_CONFLICTO(record.get(5));
                        c.RAMA_INVOLUC(record.get(6));
                        if (numeroColumnas == 88) {
                            c.SECTOR(record.get(7));
                            c.SUBSECTOR(record.get(8));
                        } else {
                            c.SECTOR(null);
                            c.SUBSECTOR(null);
                        }
                        c.CLAVE_ENTIDAD_ORG(record.get(9 + ajuste));
                        c.CLAVE_ENTIDAD_PAT(record.get(10 + ajuste));
                        c.CLAVE_ENTIDAD_MUN(record.get(11 + ajuste));
                        c.PREG_SUBCONTRATACION(record.get(12 + ajuste));
                        c.PREG_SALARIOS_VEN(record.get(13 + ajuste));
                        c.PREG_REINSTALACION(record.get(14 + ajuste));
                        c.PREG_PAGO_INDEM(record.get(15 + ajuste));
                        c.PREG_TERMINA_RELA_LAB(record.get(16 + ajuste));
                        c.PREG_DEPOSITO_INDEM(record.get(17 + ajuste));
                        c.PREG_RESPONS_CONFLIC(record.get(18 + ajuste));
                        c.PREG_NULIDAD_RENUN(record.get(19 + ajuste));
                        c.PREG_RESOSITO_RESPO(record.get(20 + ajuste));
                        c.PREG_RELA_TRAB(record.get(21 + ajuste));
                        c.PREG_NULIDAD_LIQUI(record.get(22 + ajuste));
                        c.PREG_RATIF_CONVEN(record.get(23 + ajuste));
                        c.PREG_RESPONS_PATRON(record.get(24 + ajuste));
                        c.PREG_VACACIONES(record.get(25 + ajuste));
                        c.PREG_PRIMA_VACACIONAL(record.get(26 + ajuste));
                        c.PREG_AGUINALDO(record.get(27 + ajuste));
                        c.PREG_SALARIO(record.get(28 + ajuste));
                        c.PREG_PRIMA_ANTIGUEDAD(record.get(29 + ajuste));
                        c.PREG_HORAS_EXTRA(record.get(30 + ajuste));
                        c.PREG_RECONO_ANTIGUEDAD(record.get(31 + ajuste));
                        c.PREG_DIAS_DESCANSO(record.get(32 + ajuste));
                        c.PREG_DERECHO_PREF(record.get(33 + ajuste));
                        c.PREG_BONOS(record.get(34 + ajuste));
                        c.PREG_GRATIFICA(record.get(35 + ajuste));
                        c.PREG_OCUPACION_VACAN(record.get(36 + ajuste));
                        c.PREG_COMISIONES(record.get(37 + ajuste));
                        c.PREG_DESCUENTO(record.get(38 + ajuste));
                        c.PREG_ASCENSO(record.get(39 + ajuste));
                        c.PREG_DESCANSO(record.get(40 + ajuste));
                        c.PREG_RECIBO_PAGO(record.get(41 + ajuste));
                        c.PREG_AFILACION(record.get(42 + ajuste));
                        c.PREG_ESCUELAS(record.get(43 + ajuste));
                        c.PREG_PROPINA(record.get(44 + ajuste));
                        c.PREG_INVENCIONES(record.get(45 + ajuste));
                        c.PREG_RELACION_TRAB(record.get(46 + ajuste));
                        c.PREG_DIVERSO_DOC(record.get(47 + ajuste));
                        c.PREG_BASE_ANTIGUEDAD(record.get(48 + ajuste));
                        c.PREG_RENIVELACION(record.get(49 + ajuste));
                        c.PREG_SUSTI_PATRON(record.get(50 + ajuste));
                        c.PREG_MUERTE(record.get(51 + ajuste));
                        c.PREG_INCRE_PENSION(record.get(52 + ajuste));
                        c.PREG_RETIRO(record.get(53 + ajuste));
                        c.PREG_VIDA(record.get(54 + ajuste));
                        c.PREG_ENFERMEDADES(record.get(55 + ajuste));
                        c.PREG_VEJEZ(record.get(56 + ajuste));
                        c.PREG_RETORNO_PUESTO(record.get(57 + ajuste));
                        c.PREG_PAGO_SALARIO(record.get(58 + ajuste));
                        c.PREG_TRAB_CONS(record.get(59 + ajuste));
                        c.PREG_ANT_PRE(record.get(60 + ajuste));
                        c.PREG_LABORES_PEL(record.get(61 + ajuste));
                        c.PREG_DESCANSO_SEMANAS(record.get(62 + ajuste));
                        c.PREG_PRORROGA(record.get(63 + ajuste));
                        c.PREG_ALIMENTACION(record.get(64 + ajuste));
                        c.PREG_ACTOS(record.get(65 + ajuste));
                        c.PREG_INCOMPETENCIA(record.get(66 + ajuste));
                        c.ID_TIPO_INCOMPETENCIA(record.get(67 + ajuste));
                        c.FECHA_PRESENTACION(record.get(68 + ajuste));
                        c.PREG_CONSTANCIA(record.get(69 + ajuste));
                        c.PREG_EXCEP_CONCILIA(record.get(70 + ajuste));
                        c.PREG_PREVENCION(record.get(71 + ajuste));
                        c.ID_ESTATUS_DEMANDA(record.get(72 + ajuste));
                        c.ID_CAUSA_IMP_DEM(record.get(73 + ajuste));
                        c.FECHA_ADM_DEMANDA(record.get(74 + ajuste));
                        c.CANT_ACTORES(record.get(75 + ajuste));
                        c.CANT_DEMANDADOS(record.get(76 + ajuste));
                        c.PREG_AUD_PRELIM_CELEBR(record.get(77 + ajuste));
                        c.FECHA_AUDIENCIA_PRELIM(record.get(78 + ajuste));
                        c.PREG_CELEBRA_AUD_JUICIO(record.get(79 + ajuste));
                        c.FECHA_AUD_JUICIO(record.get(80 + ajuste));
                        c.ID_ESTATUS_EXPED(record.get(81 + ajuste));
                        c.FECHA_ULT_ACT_PROC(record.get(82 + ajuste));
                        c.ID_FASE_SOL_EXPED(record.get(83 + ajuste));
                        c.ID_FORMA_SOLUCION(record.get(84 + ajuste));
                        c.FECHA_DICTO_SOLUCION(record.get(85 + ajuste));
                        c.FECHA_SENTENCIA(record.get(86 + ajuste));
                        c.ID_SENTIDO_SENTEN(record.get(87 + ajuste));
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
