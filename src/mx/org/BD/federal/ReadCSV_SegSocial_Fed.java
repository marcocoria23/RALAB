/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.BD.federal;

import Bean_Procedures_Federal.BeanSegSocial;
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
public class ReadCSV_SegSocial_Fed {

    public static String impErro = "", RutaT = "";
    public static int TotalRegistros = 0;
    public static boolean borra_ruta = false;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    OracleConexionRalFed conexion = new OracleConexionRalFed();
    Convertir_utf8 conUTF8 = new Convertir_utf8();

    public void IN_SEG_SOCIAL(String Ruta) throws Exception {

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
                if (numeroColumnas == 90) {
                    System.out.println("+hellooou+" + numeroColumnas);
                    cargando cargar = new cargando();
                    ArrayList<BeanSegSocial> ad = new ArrayList<>();
                    for (CSVRecord record : csvParser) {
                        if (detectarCharsetFed.esFilaVacia(record, "TMP_FED_SEG_SOCIAL")) {
                            continue;
                        }
                        TotalRegistros++;
                        BeanSegSocial c = new BeanSegSocial();
                        c.NOMBRE_ORGANO_JURIS(record.get(0));
                        c.ID_ORGANOJ(record.get(1));
                        c.CLAVE_EXPEDIENTE(record.get(2));
                        c.FECHA_APERTURA_EXPEDIENTE(record.get(3));
                        c.ID_TIPO_ASUNTO(record.get(4));
                        c.ID_NAT_CONFLICTO(record.get(5));
                        c.RAMA_INVOLUC(record.get(6));
                        c.ENTIDAD_CLAVE_ORG(record.get(7));
                        c.ENTIDAD_CLAVE(record.get(8));
                        c.MUNICIPIO_CLAVE(record.get(9));
                        c.PREG_PRIMADOMINICAL(record.get(10));
                        c.PREG_COMISIONES(record.get(11));
                        c.PREG_PRESTACIONESENESPECIE(record.get(12));
                        c.PREG_GRATIFICACIONES(record.get(13));
                        c.PREG_BONOS(record.get(14));
                        c.PREG_CREDITOS(record.get(15));
                        c.PREG_RECONOCIMIENTODEANTIGUEDA(record.get(16));
                        c.PREG_INSCRIPCIONENELIMSS(record.get(17));
                        c.PREG_INSCRIPCIONENINFONAVIT(record.get(18));
                        c.PREG_BAJAENELIMSS(record.get(19));
                        c.PREG_BAJAENELINFONAVIT(record.get(20));
                        c.PREG_CUOTASOBREROPATRONALES(record.get(21));
                        c.PREG_RIESGOSDETRABAJO(record.get(22));
                        c.PREG_PREVENCIONDERIESGOSDETRAB(record.get(23));
                        c.PREG_ENFERMEDADES(record.get(24));
                        c.PREG_MATERNIDAD(record.get(25));
                        c.PREG_INVALIDEZ(record.get(26));
                        c.PREG_VIDA(record.get(27));
                        c.PREG_RETIRO(record.get(28));
                        c.PREG_CESANTIAENEDADAVANZADA(record.get(29));
                        c.PREG_VEJEZ(record.get(30));
                        c.PREG_GUARDERIA(record.get(31));
                        c.PREG_PRESTACIONESSOCIALES(record.get(32));
                        c.PREG_SALARIOBASEDECOTIZACION(record.get(33));
                        c.PREG_INCAPACIDADTEMPORAL(record.get(34));
                        c.PREG_INCAPACIDADPERMANENTETOTA(record.get(35));
                        c.PREG_INCAPACIDADPERMANENTEPARC(record.get(36));
                        c.PREG_MUERTE(record.get(37));
                        c.PREG_PENSIONPORINVALIDEZ(record.get(38));
                        c.PREG_PENSIONPORVIUDEZ(record.get(39));
                        c.PREG_PENSIONPORORFANDAD(record.get(40));
                        c.PREG_PENSIONPORASCENDENCIA(record.get(41));
                        c.PREG_PENSIONGARANTIZADA(record.get(42));
                        c.PREG_INCREMENTODEPENSION(record.get(43));
                        c.PREG_INDEMNIZACIONGLOBAL(record.get(44));
                        c.PREG_RECONOCIMIENTODEBENEFICIA(record.get(45));
                        c.PREG_ASISTENCIAMEDICAQUIRURGIC(record.get(46));
                        c.PREG_SERVICIODEHOSPITALIZACION(record.get(47));
                        c.PREG_APARATOSDEPROTESISYORTOPE(record.get(48));
                        c.PREG_REHABILITACION(record.get(49));
                        c.PREG_ASISTENCIAOBSTETRICA(record.get(50));
                        c.PREG_CANASTILLA(record.get(51));
                        c.PREG_SUBSIDIOENDINERO(record.get(52));
                        c.PREG_CONSERVACIONDEDERECHO(record.get(53));
                        c.PREG_ASIGNACIONESFAMILIARES(record.get(54));
                        c.PREG_AYUDAASISTENCIAL(record.get(55));
                        c.PREG_RETIRODEFONDOSDELACUENTAI(record.get(56));
                        c.PREG_APORTACIONESVOLUNTARIASAL(record.get(57));
                        c.PREG_CONTINUACIONVOLUNTARIAALR(record.get(58));
                        c.PREG_INCORPORACIONVOLUNTARIAAL(record.get(59));
                        c.PREG_APORTACIONESALINFONAVIT(record.get(60));
                        c.PREG_DESCUENTOSDESTINADOSALPAG(record.get(61));
                        c.PREG_RIESGOSDETRABAJOSALARIOB(record.get(62));
                        c.PREG_DESIGNACIONDEBENEFICIARIO(record.get(63));
                        c.PREG_ADMINISTRADORASDEFONDOSPA(record.get(64));
                        c.PREG_PRESTDESEGURIDADSODEC(record.get(65));
                        c.PREG_PRESTDESEGURIDADSOLEY(record.get(66));
                        c.PREG_LIBERACIONDECREDITOHIPOTE(record.get(67));
                        c.PREG_INCOMPETENCIA(record.get(68));
                        c.ID_TIPO_INCOMPETENCIA(record.get(69));
                        c.FECHA_PRESENTACION(record.get(70));
                        c.PREG_CONSTANCIA(record.get(71));
                        c.PREG_EXCEP_CONCILIA(record.get(72));
                        c.PREG_PREVENCION(record.get(73));
                        c.ID_ESTATUS_DEMANDA(record.get(74));
                        c.ID_CAUSA_IMP_DEM(record.get(75));
                        c.FECHA_ADM_DEMANDA(record.get(76));
                        c.CANT_ACTORES(record.get(77));
                        c.CANT_DEMANDADOS(record.get(78));
                        c.PREG_AUD_PRELIM_CELEBR(record.get(79));
                        c.FECHA_AUDIENCIA_PRELIM(record.get(80));
                        c.PREG_CELEBRA_AUD_JUICIO(record.get(81));
                        c.FECHA_AUD_JUICIO(record.get(82));
                        c.ID_ESTATUS_EXPED(record.get(83));
                        c.FECHA_ULT_ACT_PROC(record.get(84));
                        c.ID_FASE_SOL_EXPED(record.get(85));
                        c.ID_FORMA_SOLUCION(record.get(86));
                        c.FECHA_DICTO_SOLUCION(record.get(87));
                        c.FECHA_SENTENCIA(record.get(88));
                        c.ID_SENTIDO_SENTEN(record.get(89));
                        ad.add(c);
                    }
                    System.out.println("entro 1");
                    if (TotalRegistros > 0) {
                        if (Inserta == true) {
                            cargar.setVisible(true);
                            con = OracleDAOFactoryFED.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_FED_SEG_SOCIAL", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_FED_SEG_SOCIAL", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORCSV.Seg_Social(?))}");
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
                    JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo T.5.1_seg_soc.csv no coincide con la bd Oracle");
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
                            "Tabla: TMP_FED_SEG_SOCIAL\n"
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
