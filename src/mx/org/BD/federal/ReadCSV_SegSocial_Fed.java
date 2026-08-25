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

    private String sinNull(String valor) {
    return valor == null || valor.equalsIgnoreCase("NULL") ? "" : valor;
}
    
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
                        c.NOMBRE_ORGANO_JURIS(sinNull(record.get(0)));
                        c.ID_ORGANOJ(sinNull(record.get(1)));
                        c.CLAVE_EXPEDIENTE(sinNull(record.get(2)));
                        c.FECHA_APERTURA_EXPEDIENTE(sinNull(record.get(3)));
                        c.ID_TIPO_ASUNTO(sinNull(record.get(4)));
                        c.ID_NAT_CONFLICTO(sinNull(record.get(5)));
                        c.RAMA_INVOLUC(sinNull(record.get(6)));
                        c.ENTIDAD_CLAVE_ORG(sinNull(record.get(7)));
                        c.ENTIDAD_CLAVE(sinNull(record.get(8)));
                        c.MUNICIPIO_CLAVE(sinNull(record.get(9)));
                        c.PREG_PRIMADOMINICAL(sinNull(record.get(10)));
                        c.PREG_COMISIONES(sinNull(record.get(11)));
                        c.PREG_PRESTACIONESENESPECIE(sinNull(record.get(12)));
                        c.PREG_GRATIFICACIONES(sinNull(record.get(13)));
                        c.PREG_BONOS(sinNull(record.get(14)));
                        c.PREG_CREDITOS(sinNull(record.get(15)));
                        c.PREG_RECONOCIMIENTODEANTIGUEDA(sinNull(record.get(16)));
                        c.PREG_INSCRIPCIONENELIMSS(sinNull(record.get(17)));
                        c.PREG_INSCRIPCIONENINFONAVIT(sinNull(record.get(18)));
                        c.PREG_BAJAENELIMSS(sinNull(record.get(19)));
                        c.PREG_BAJAENELINFONAVIT(sinNull(record.get(20)));
                        c.PREG_CUOTASOBREROPATRONALES(sinNull(record.get(21)));
                        c.PREG_RIESGOSDETRABAJO(sinNull(record.get(22)));
                        c.PREG_PREVENCIONDERIESGOSDETRAB(sinNull(record.get(23)));
                        c.PREG_ENFERMEDADES(sinNull(record.get(24)));
                        c.PREG_MATERNIDAD(sinNull(record.get(25)));
                        c.PREG_INVALIDEZ(sinNull(record.get(26)));
                        c.PREG_VIDA(sinNull(record.get(27)));
                        c.PREG_RETIRO(sinNull(record.get(28)));
                        c.PREG_CESANTIAENEDADAVANZADA(sinNull(record.get(29)));
                        c.PREG_VEJEZ(sinNull(record.get(30)));
                        c.PREG_GUARDERIA(sinNull(record.get(31)));
                        c.PREG_PRESTACIONESSOCIALES(sinNull(record.get(32)));
                        c.PREG_SALARIOBASEDECOTIZACION(sinNull(record.get(33)));
                        c.PREG_INCAPACIDADTEMPORAL(sinNull(record.get(34)));
                        c.PREG_INCAPACIDADPERMANENTETOTA(sinNull(record.get(35)));
                        c.PREG_INCAPACIDADPERMANENTEPARC(sinNull(record.get(36)));
                        c.PREG_MUERTE(sinNull(record.get(37)));
                        c.PREG_PENSIONPORINVALIDEZ(sinNull(record.get(38)));
                        c.PREG_PENSIONPORVIUDEZ(sinNull(record.get(39)));
                        c.PREG_PENSIONPORORFANDAD(sinNull(record.get(40)));
                        c.PREG_PENSIONPORASCENDENCIA(sinNull(record.get(41)));
                        c.PREG_PENSIONGARANTIZADA(sinNull(record.get(42)));
                        c.PREG_INCREMENTODEPENSION(sinNull(record.get(43)));
                        c.PREG_INDEMNIZACIONGLOBAL(sinNull(record.get(44)));
                        c.PREG_RECONOCIMIENTODEBENEFICIA(sinNull(record.get(45)));
                        c.PREG_ASISTENCIAMEDICAQUIRURGIC(sinNull(record.get(46)));
                        c.PREG_SERVICIODEHOSPITALIZACION(sinNull(record.get(47)));
                        c.PREG_APARATOSDEPROTESISYORTOPE(sinNull(record.get(48)));
                        c.PREG_REHABILITACION(sinNull(record.get(49)));
                        c.PREG_ASISTENCIAOBSTETRICA(sinNull(record.get(50)));
                        c.PREG_CANASTILLA(sinNull(record.get(51)));
                        c.PREG_SUBSIDIOENDINERO(sinNull(record.get(52)));
                        c.PREG_CONSERVACIONDEDERECHO(sinNull(record.get(53)));
                        c.PREG_ASIGNACIONESFAMILIARES(sinNull(record.get(54)));
                        c.PREG_AYUDAASISTENCIAL(sinNull(record.get(55)));
                        c.PREG_RETIRODEFONDOSDELACUENTAI(sinNull(record.get(56)));
                        c.PREG_APORTACIONESVOLUNTARIASAL(sinNull(record.get(57)));
                        c.PREG_CONTINUACIONVOLUNTARIAALR(sinNull(record.get(58)));
                        c.PREG_INCORPORACIONVOLUNTARIAAL(sinNull(record.get(59)));
                        c.PREG_APORTACIONESALINFONAVIT(sinNull(record.get(60)));
                        c.PREG_DESCUENTOSDESTINADOSALPAG(sinNull(record.get(61)));
                        c.PREG_RIESGOSDETRABAJOSALARIOB(sinNull(record.get(62)));
                        c.PREG_DESIGNACIONDEBENEFICIARIO(sinNull(record.get(63)));
                        c.PREG_ADMINISTRADORASDEFONDOSPA(sinNull(record.get(64)));
                        c.PREG_PRESTDESEGURIDADSODEC(sinNull(record.get(65)));
                        c.PREG_PRESTDESEGURIDADSOLEY(sinNull(record.get(66)));
                        c.PREG_LIBERACIONDECREDITOHIPOTE(sinNull(record.get(67)));
                        c.PREG_INCOMPETENCIA(sinNull(record.get(68)));
                        c.ID_TIPO_INCOMPETENCIA(sinNull(record.get(69)));
                        c.FECHA_PRESENTACION(sinNull(record.get(70)));
                        c.PREG_CONSTANCIA(sinNull(record.get(71)));
                        c.PREG_EXCEP_CONCILIA(sinNull(record.get(72)));
                        c.PREG_PREVENCION(sinNull(record.get(73)));
                        c.ID_ESTATUS_DEMANDA(sinNull(record.get(74)));
                        c.ID_CAUSA_IMP_DEM(sinNull(record.get(75)));
                        c.FECHA_ADM_DEMANDA(sinNull(record.get(76)));
                        c.CANT_ACTORES(sinNull(record.get(77)));
                        c.CANT_DEMANDADOS(sinNull(record.get(78)));
                        c.PREG_AUD_PRELIM_CELEBR(sinNull(record.get(79)));
                        c.FECHA_AUDIENCIA_PRELIM(sinNull(record.get(80)));
                        c.PREG_CELEBRA_AUD_JUICIO(sinNull(record.get(81)));
                        c.FECHA_AUD_JUICIO(sinNull(record.get(82)));
                        c.ID_ESTATUS_EXPED(sinNull(record.get(83)));
                        c.FECHA_ULT_ACT_PROC(sinNull(record.get(84)));
                        c.ID_FASE_SOL_EXPED(sinNull(record.get(85)));
                        c.ID_FORMA_SOLUCION(sinNull(record.get(86)));
                        c.FECHA_DICTO_SOLUCION(sinNull(record.get(87)));
                        c.FECHA_SENTENCIA(sinNull(record.get(88)));
                        c.ID_SENTIDO_SENTEN(sinNull(record.get(89)));
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
