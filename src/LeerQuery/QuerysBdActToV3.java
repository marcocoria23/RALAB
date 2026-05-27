/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionDesarrollo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QuerysBdActToV3 {

    OracleConexionDesarrollo conexionDes = new OracleConexionDesarrollo();

    ResultSet resul;
    String sql = "";
    ArrayList<ArrayList<String>> arrayList;

    public ArrayList<ArrayList<String>> DBO_TO_V3_TR_CONTROL_EXPEDIENTEJL(String cveEntidad, String periodo, String cveOrgano) throws SQLException {
        conexionDes = conexionDes.Conectar();
        arrayList = new ArrayList<>();

        String sql = "WITH BASE AS (    \n"
                + "    select \n"
                + "        GEN.ID_GENERAL,\n"
                + "        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS,\n"
                + "        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO,\n"
                + "        ORG.SEDE_ORGANOJ AS SEDE,\n"
                + "        GEN.TOTAL_JUECES AS JUECES_LABORAL_TOTAL,\n"
                + "        GEN.SUBTOTAL_JUEZ_H AS JUECES_LABORAL_SUB_HOM,\n"
                + "        GEN.SUBTOTAL_JUEZ_M AS JUECES_LABORAL_SUB_MUJ,\n"
                + "        GEN.JUEZ_INDIVIDUA_H AS JUECES_LABORAL_INDIV_HOM,\n"
                + "        GEN.JUEZ_INDIVIDUAL_M AS JUECES_LABORAL_INDIV_MUJ,\n"
                + "        GEN.JUEZ_COLECTIVO_H AS JUECES_LABORAL_COLEC_HOM,\n"
                + "        GEN.JUEZ_COLECTIVO_M AS JUECES_LABORAL_COLEC_MUJ,\n"
                + "        GEN.JUEZ_MIXTO_H AS JUECES_LABORAL_MIX_HOM,\n"
                + "        GEN.JUEZ_MIXTOS_M AS JUECES_LABORAL_MIX_MUJ,\n"
                + "        ORG.HR_ATENCION AS HORARIO,\n"
                + "        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE,\n"
                + "        TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE,\n"
                + "        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE,\n"
                + "        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE,\n"
                + "        ORG.COLONIA AS COLONIA_NOMBRE,\n"
                + "        ORG.LATITUD AS LATITUD_ORG,\n"
                + "        ORG.LONGITUD AS LONGITUD_ORG,\n"
                + "        ORG.ID_CIRCUNSCRIPCION AS CIRCUNS_ORG_JUR,\n"
                + "        ORG.ID_JURISDICCION AS JURISDICCION,\n"
                + "        GEN.TOTAL_ORDINARIO AS ORDINARIO,\n"
                + "        GEN.TOTAL_INDIVIDUAL AS ESPECIAL_INDIVI,\n"
                + "        GEN.TOTAL_COLECTIVO AS ESPECIAL_COLECT,\n"
                + "        GEN.TOTAL_HUELGA AS HUELGA,\n"
                + "        GEN.TOTAL_COL_NAT_ECON AS COL_NATU_ECONOMICA,\n"
                + "        GEN.TOTAL_PARAPROCESAL AS PARAP_VOLUNTARIO,\n"
                + "        GEN.TOTAL_TERCERIAS AS TERCERIAS,\n"
                + "        GEN.TOTAL_PREF_CRED AS PREF_CREDITO,\n"
                + "        GEN.TOTAL_EJECUCION AS EJECUCION,\n"
                + "        GEN.PERIODO\n"
                + "    FROM TR_GENERAL GEN \n"
                + "    INNER JOIN TR_ORGANOJ ORG\n"
                + "        ON GEN.ID_ORGANOJ = ORG.ID_ORGANOJ\n"
                + "        AND GEN.PERIODO = ORG.PERIODO\n"
                + "    LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO\n"
                + "        ON TC_ENT_MPIO.ID_ENT_MPIO = ORG.ID_ENT_MPIO\n"
                + "),\n"
                + "ESPECIFIQUE_CIRCUNSTANCIA AS (\n"
                + "    SELECT\n"
                + "        ORGANO AS ID_ORGANOJ,\n"
                + "        PERIODO,\n"
                + "        MAX(\n"
                + "            CASE \n"
                + "                WHEN NEMONICO_CATALOGO = 'TC_CIRCUNSCRIPCION'\n"
                + "                 AND ID_OTRO_ESPECIFIQUE = '4'\n"
                + "                 AND TRIM(UPPER(PROCEDIMIENTO))='CONTROL'\n"
                + "                THEN ESPECIFIQUE\n"
                + "            END\n"
                + "        ) AS OTRO_ESP_CIRCUNS\n"
                + "    FROM TR_ESPECIFIQUE\n"
                + "    GROUP BY\n"
                + "        ORGANO,\n"
                + "        PERIODO\n"
                + ")\n"
                + "SELECT \n"
                + "    B.ID_GENERAL,\n"
                + "    B.NOMBRE_ORGANO_JURIS,\n"
                + "    B.CLAVE_ORGANO,\n"
                + "    B.SEDE,\n"
                + "    B.JUECES_LABORAL_TOTAL,\n"
                + "    B.JUECES_LABORAL_SUB_HOM,\n"
                + "    B.JUECES_LABORAL_SUB_MUJ,\n"
                + "    B.JUECES_LABORAL_INDIV_HOM,\n"
                + "    B.JUECES_LABORAL_INDIV_MUJ,\n"
                + "    B.JUECES_LABORAL_COLEC_HOM,\n"
                + "    B.JUECES_LABORAL_COLEC_MUJ,\n"
                + "    B.JUECES_LABORAL_MIX_HOM,\n"
                + "    B.JUECES_LABORAL_MIX_MUJ,\n"
                + "    B.HORARIO,\n"
                + "    B.ENTIDAD_CLAVE,\n"
                + "    B.ENTIDAD_NOMBRE,\n"
                + "    B.MUNICIPIO_CLAVE,\n"
                + "    B.MUNICIPIO_NOMBRE,\n"
                + "    B.COLONIA_NOMBRE,\n"
                + "    B.LATITUD_ORG,\n"
                + "    B.LONGITUD_ORG,\n"
                + "    CONVER_V3_GEN_NI_9(B.CIRCUNS_ORG_JUR) AS CIRCUNS_ORG_JUR,\n"
                + "    EC.OTRO_ESP_CIRCUNS,\n"
                + "    B.JURISDICCION,\n"
                + "    B.ORDINARIO,\n"
                + "    B.ESPECIAL_INDIVI,\n"
                + "    B.ESPECIAL_COLECT,\n"
                + "    B.HUELGA,\n"
                + "    B.COL_NATU_ECONOMICA,\n"
                + "    B.PARAP_VOLUNTARIO,\n"
                + "    B.TERCERIAS,\n"
                + "    B.PREF_CREDITO,\n"
                + "    B.EJECUCION,\n"
                + "    B.PERIODO\n"
                + "FROM BASE B\n"
                + "LEFT JOIN ESPECIFIQUE_CIRCUNSTANCIA EC\n"
                + "    ON EC.ID_ORGANOJ = B.CLAVE_ORGANO \n"
                + "    AND EC.PERIODO = B.PERIODO\n"
                + " WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='" + cveEntidad + "' AND B.PERIODO='" + periodo + "') OR (B.CLAVE_ORGANO='" + cveOrgano + "' AND B.PERIODO='" + periodo + "')";

        try {
            Statement stmt = conexionDes.getConexion().createStatement();
            System.out.println("ASqllll" + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna   
                fila.add(resul.getString(12)); // Añadir la décima columna   
                fila.add(resul.getString(13)); // Añadir la décima columna   
                fila.add(resul.getString(14)); // Añadir la décima columna   
                fila.add(resul.getString(15)); // Añadir la décima columna   
                fila.add(resul.getString(16)); // Añadir la décima columna   
                fila.add(resul.getString(17)); // Añadir la décima columna   
                fila.add(resul.getString(18)); // Añadir la décima columna   
                fila.add(resul.getString(19)); // Añadir la décima columna   
                fila.add(resul.getString(20)); // Añadir la décima columna   
                fila.add(resul.getString(21)); // Añadir la décima columna   
                fila.add(resul.getString(22)); // Añadir la décima columna   
                fila.add(resul.getString(23)); // Añadir la décima columna   
                fila.add(resul.getString(24)); // Añadir la décima columna   
                fila.add(resul.getString(25)); // Añadir la décima columna   
                fila.add(resul.getString(26)); // Añadir la décima columna   
                fila.add(resul.getString(27)); // Añadir la décima columna   
                fila.add(resul.getString(28)); // Añadir la décima columna   
                fila.add(resul.getString(29)); // Añadir la décima columna   
                fila.add(resul.getString(30)); // Añadir la décima columna   
                fila.add(resul.getString(31)); // Añadir la décima columna   
                fila.add(resul.getString(32)); // Añadir la décima columna   
                fila.add(resul.getString(33)); // Añadir la décima columna   
                fila.add(resul.getString(34)); // Añadir la décima columna   
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_AUDIENCIAS" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionDes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrayList;
    }

    public ArrayList<ArrayList<String>> V3_TR_AUDIENCIASJL(String cveEntidad, String periodo, String cveOrgano) throws SQLException {
        conexionDes = conexionDes.Conectar();
        arrayList = new ArrayList<>();

        String sql = "WITH BASE AS ( \n"
                + "    SELECT  \n"
                + "        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n"
                + "        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n"
                + "        EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n"
                + "        EXP.ID_TIPO_EXPEDIENTE AS TIPO_PROCED, \n"
                + "        AUD.ID_AUDIENCIA, \n"
                + "        CASE WHEN EXP.ID_TIPO_EXPEDIENTE = 1 THEN AUD.ID_TIPO_AUDIENCIA ELSE NULL END AS ORDINARIO_TA, \n"
                + "        CASE WHEN EXP.ID_TIPO_EXPEDIENTE = 2 THEN AUD.ID_TIPO_AUDIENCIA ELSE NULL END AS ESPECIAL_INDIVI_TA, \n"
                + "        CASE WHEN EXP.ID_TIPO_EXPEDIENTE = 3 THEN AUD.ID_TIPO_AUDIENCIA ELSE NULL END AS ESPECIAL_COLECT_TA, \n"
                + "        CASE WHEN EXP.ID_TIPO_EXPEDIENTE = 4 THEN AUD.ID_TIPO_AUDIENCIA ELSE NULL END AS HUELGA_TA, \n"
                + "        CASE WHEN EXP.ID_TIPO_EXPEDIENTE = 5 THEN AUD.ID_TIPO_AUDIENCIA ELSE NULL END AS COL_NATU_ECONOMICA_TA, \n"
                + "        AUD.FECHA_CELEBRACION AS FECHA_AUDIEN_CELEBRADA, \n"
                + "        AUD.INICIO, \n"
                + "        AUD.CONCLUSION AS CONCLU, \n"
                + "        EXP.COMENTARIOS, \n"
                + "        EXP.PERIODO \n"
                + "    FROM TR_EXPEDIENTE EXP  \n"
                + "    INNER JOIN TR_ORGANOJ ORG \n"
                + "        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n"
                + "        AND EXP.PERIODO = ORG.PERIODO \n"
                + "    INNER JOIN TR_AUDIENCIA AUD \n"
                + "        ON EXP.ID_EXPEDIENTE = AUD.ID_EXPEDIENTE \n"
                + "        AND EXP.ID_ORGANOJ = AUD.ID_ORGANOJ \n"
                + "        AND EXP.PERIODO = AUD.PERIODO \n"
                + "    WHERE ID_TIPO_EXPEDIENTE IN (1,2,3,4,5) \n"
                + "), \n"
                + "ESPECIFIQUE_TIPO_AUDIENCIA AS ( \n"
                + "    SELECT \n"
                + "        CLAVE_EXPEDIENTE, \n"
                + "        ORGANO AS ID_ORGANOJ, \n"
                + "        PERIODO, \n"
                + "        ID_ACT_DEM_AUD, \n"
                + "        MAX( \n"
                + "            CASE  \n"
                + "                WHEN NEMONICO_CATALOGO = 'TC_TIPO_AUDIENCIA' \n"
                + "                 AND ID_OTRO_ESPECIFIQUE = '3' \n"
                + "                 AND TRIM(UPPER(PROCEDIMIENTO))='AUDIENCIAS' \n"
                + "                THEN ESPECIFIQUE \n"
                + "            END \n"
                + "        ) AS ESP_OTRO_AUDIENCIA \n"
                + "    FROM TR_ESPECIFIQUE \n"
                + "    GROUP BY \n"
                + "        CLAVE_EXPEDIENTE, \n"
                + "        ORGANO, \n"
                + "        PERIODO, \n"
                + "        ID_ACT_DEM_AUD \n"
                + ") \n"
                + "SELECT  \n"
                + "    B.NOMBRE_ORGANO_JURIS, \n"
                + "    B.CLAVE_ORGANO, \n"
                + "    B.EXPEDIENTE_CLAVE, \n"
                + "    B.TIPO_PROCED, \n"
                + "    B.ID_AUDIENCIA, \n"
                + "    CONVER_V3_TIPO_AUDIENCIA(B.ORDINARIO_TA) AS ORDINARIO_TA, \n"
                + "    CONVER_V3_TIPO_AUDIENCIA(B.ESPECIAL_INDIVI_TA) AS ESPECIAL_INDIVI_TA, \n"
                + "    CONVER_V3_TIPO_AUDIENCIA(B.ESPECIAL_COLECT_TA) AS ESPECIAL_COLECT_TA, \n"
                + "    CONVER_V3_TIPO_AUDIENCIA(B.HUELGA_TA) AS HUELGA_TA, \n"
                + "    CONVER_V3_TIPO_AUDIENCIA(B.COL_NATU_ECONOMICA_TA) AS COL_NATU_ECONOMICA_TA, \n"
                + "    CASE  \n"
                + "        WHEN B.ORDINARIO_TA = 3 THEN ETA.ESP_OTRO_AUDIENCIA \n"
                + "        WHEN B.ESPECIAL_INDIVI_TA = 3 THEN ETA.ESP_OTRO_AUDIENCIA \n"
                + "        WHEN B.ESPECIAL_COLECT_TA = 3 THEN ETA.ESP_OTRO_AUDIENCIA \n"
                + "        WHEN B.HUELGA_TA = 3 THEN ETA.ESP_OTRO_AUDIENCIA \n"
                + "        WHEN B.COL_NATU_ECONOMICA_TA = 3 THEN ETA.ESP_OTRO_AUDIENCIA \n"
                + "        ELSE NULL \n"
                + "    END AS ESP_OTRO_AUDIENCIA, \n"
                + "    B.FECHA_AUDIEN_CELEBRADA, \n"
                + "    B.INICIO, \n"
                + "    B.CONCLU, \n"
                + "    B.COMENTARIOS, \n"
                + "    B.PERIODO \n"
                + "FROM BASE B  \n"
                + "LEFT JOIN ESPECIFIQUE_TIPO_AUDIENCIA ETA \n"
                + "    ON ETA.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n"
                + "    AND ETA.ID_ORGANOJ = B.CLAVE_ORGANO \n"
                + "    AND ETA.PERIODO = B.PERIODO    \n"
                + "    AND ETA.ID_ACT_DEM_AUD = B.ID_AUDIENCIA \n"
                + "     WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='" + cveEntidad + "' AND B.PERIODO='" + periodo + "' ) OR (B.CLAVE_ORGANO='" + cveOrgano + "' AND B.PERIODO='" + periodo + "' ) \n";

        try {
            Statement stmt = conexionDes.getConexion().createStatement();
            System.out.println(sql);
            resul = stmt.executeQuery(sql);
            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                arrayList.add(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_AUDIENCIASJLpendiente" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionDes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

   public ArrayList<ArrayList<String>> V3_TR_ORDINARIOJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT  \n" +
        "EXP.ID_EXPEDIENTE, \n" +
        "EXP.PERIODO, \n" +
        "ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
        "POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
        "EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
        "EXP.FECHA_APERTURA_EXPED AS FECHA_APERTURA_EXPEDIENTE, \n" +
        "EXP.ID_TIPO_ASUNTO AS TIPO_ASUNTO, \n" +
        "EXP.ID_NAT_CONFLICTO AS NAT_CONFLICTO, \n" +
        "EXP.PREG_TRAB_CONTR_ESCRI AS CONTRATO_ESCRITO, \n" +
        "EXP.ID_TIPO_CONTRATO AS TIPO_CONTRATO, \n" +
        "EXP.RAMA_INVOLUC AS RAMA_INDUS_INVOLUCRADA, \n" +
        "TC_SEC.SECTOR, \n" +
        "TC_SEC.SUBSECTOR, \n" +
        "TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
        "TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE, \n" +
        "TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
        "TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
        "EXP.PREG_OUTSOURCING AS SUBCONTRATACION, \n" +
        "EXP.PREG_APL_CIR_VIN_MOT_CONF AS CIRCUNS_MOTIVO_CONFL, \n" +
        "EXP.MOTIVO_CONF_COLECTIVO, \n" +
        "EXP.PREG_INCOMPETENCIA, \n" +
        "EXP.ID_TIPO_INCOMPETENCIA AS TIPO_INCOMPETENCIA, \n" +
        "EXP.FECHA_PRESENT_DEMANDA AS FECHA_PRES_DEMANDA, \n" +
        "EXP.PREG_CONST_CONCILIAC AS CONSTANCIA_CONS_EXPEDIDA, \n" +
        "EXP.CLAVE_CONST_CONCILIAC AS CONSTANCIA_CLAVE, \n" +
        "EXP.PREG_ASUNTO_VINC_CONCIL_P AS ASUN_EXCEP_CONCILIACION, \n" +
        "EXP.PREG_FORMULO_DEMANDA AS PREVE_DEMANDA, \n" +
        "EXP.PREG_DESAHOGO_DEMANDA AS DESAHOGO_PREV_DEMANDA, \n" +
        "EXP.ID_ESTATUS_DEMANDA AS ESTATUS_DEMANDA, \n" +
        "EXP.ID_CAUSA_IMP_ADM_DEMANDA AS CAU_IMPI_ADMI_DEMANDA, \n" +
        "EXP.FECHA_ADM_DEMANDA AS FECHA_ADMI_DEMANDA, \n" +
        "EXP.CANT_ACTORES AS CANTIDAD_ACTORES, \n" +
        "EXP.CANT_DEMANDADOS AS CANTIDAD_DEMANDADOS, \n" +
        "EXP.PREG_AUD_PRELIM_CELEBR AS AUDIENCIA_PRELIM, \n" +
        "EXP.FECHA_AUDIENCIA_PRELIM AS FECHA_AUDIENCIA_PRELIM, \n" +
        "EXP.PREG_CELEBRA_AUD_JUICIO AS AUDIENCIA_JUICIO, \n" +
        "EXP.FECHA_AUD_JUICIO AS FECHA_AUDIENCIA_JUICIO, \n" +
        "EXP.ID_ESTATUS_EXPED AS ESTATUS_EXPEDIENTE, \n" +
        "EXP.FECHA_ULT_ACT_PROC AS FECHA_ACTO_PROCESAL, \n" +
        "EXP.ID_FASE_SOL_EXPED AS FASE_SOLI_EXPEDIENTE, \n" +
       "CASE WHEN EXP.ID_FASE_SOL_EXPED=9 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCIONFE, \n" +
       "CASE WHEN EXP.ID_FASE_SOL_EXPED=9 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_DICTO_RESOLUCIONFE, \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=9 THEN EXP.MONTO_SOLUCION ELSE NULL END AS MONTO_SOLUCIONFE,  \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=1 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCIONAP, \n" +
       "CASE WHEN EXP.ID_FASE_SOL_EXPED=1 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_DICTO_RESOLUCIONAP, \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=1 THEN EXP.MONTO_SOLUCION ELSE NULL END AS MONTO_SOLUCIONAP,      \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCIONAJ, \n" +
       "CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_DICTO_RESOLUCIONAJ, \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.ID_TIPO_SENTENCIA ELSE NULL END AS TIPO_SENTENCIAAJ, \n" +
        "CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.MONTO_SOLUCION ELSE NULL END AS MONTO_SOLUCIONAJ, \n" +
        "EXP.COMENTARIOS \n" +
        
        
    "FROM TR_EXPEDIENTE EXP  \n" +
    "INNER JOIN TR_ORGANOJ ORG \n" +
        "ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TC_SECTOR_SBSTOR TC_SEC \n" +
        "ON TC_SEC.ID_SECTOR_SBSTOR = EXP.ID_SECTOR_SBTOR \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 1 \n" +
"), \n" +
 
"MOTIVOS AS ( \n" +
    "SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_MOTIVO_CONFLICTO, \n" +
            "1 AS EXISTE_MOTIVO \n" +
        "FROM TR_EXP_MOTIVO_CONF \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_MOTIVO) \n" +
        "FOR ID_MOTIVO_CONFLICTO IN ( \n" +
            "1 AS DESPIDO, \n" +
            "2 AS RESCISION_RL, \n" +
            "3 AS TERMINACION_RESCISION_RL, \n" +
            "4 AS VIOLACION_CONTRATO, \n" +
            "5 AS RIESGO_TRABAJO, \n" +
            "6 AS REVISION_CONTRATO, \n" +
            "7 AS PART_UTILIDADES, \n" +
            "8 AS OTRO_MOTIV_CONFLICTO \n" +
        ") \n" +
    ") \n" +
"), \n" +
 
"CIRCUNSTANCIAS AS ( \n" +
    "SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_CIRCUNS_MOT_CONF, \n" +
            "1 AS EXISTE_CIRCUNST \n" +
        "FROM TR_EXP_CIRCUNST \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_CIRCUNST) \n" +
        "FOR ID_CIRCUNS_MOT_CONF IN ( \n" +
            "1 AS DETERM_EMPLEO_EMBARAZO, \n" +
            "2 AS DETERM_EMPLEO_EDAD, \n" +
            "3 AS DETERM_EMPLEO_GENERO, \n" +
            "4 AS DETERM_EMPLEO_ORIEN_SEX, \n" +
            "5 AS DETERM_EMPLEO_DISCAPACIDAD, \n" +
            "6 AS DETERM_EMPLEO_SOCIAL, \n" +
            "7 AS DETERM_EMPLEO_ORIGEN, \n" +
            "8 AS DETERM_EMPLEO_RELIGION, \n" +
            "9 AS DETERM_EMPLEO_MIGRA, \n" +
           "10 AS OTRO_DISCRIMINACION, \n" +
           "11 AS TRATA_LABORAL, \n" +
           "12 AS TRABAJO_FORZOSO, \n" +
           "13 AS TRABAJO_INFANTIL, \n" +
           "14 AS HOSTIGAMIENTO, \n" +
           "15 AS ACOSO_SEXUAL \n" +
        ") \n" +
    ") \n" +
"), \n" +
 
"CONCEPTO_RECLAMADO AS ( \n" +
    "SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_CONCEPTO_RECLAM, \n" +
            "1 AS EXISTE_CONCEPTO_RECLAM \n" +
        "FROM TR_EXP_CONCEPTO_RECLAM \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_CONCEPTO_RECLAM) \n" +
        "FOR ID_CONCEPTO_RECLAM IN ( \n" +
            "1 AS PAGO_PRESTACIONES, \n" +
            "2 AS INDEMNIZACION, \n" +
            "3 AS REINSTALACION, \n" +
            "4 AS SALARIO_RETENIDO, \n" +
            "5 AS AUMENTO_SALARIO, \n" +
            "6 AS DERECHO_ASCENSO, \n" +
            "7 AS DERECHO_PREFERENCIA, \n" +
            "8 AS DERECHO_ANTIGUEDAD, \n" +
            "9 AS OTRO_CONCEPTO \n" +
        ") \n" +
    ") \n" +
"), \n" +
"PRESTACION AS ( \n" +
    "SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_PRESTACION, \n" +
            "1 AS EXISTE_PRESTACION \n" +
        "FROM TR_EXP_PRESTACION \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_PRESTACION) \n" +
        "FOR ID_PRESTACION IN ( \n" +
            "1 AS AGUINALDO, \n" +
            "2 AS VACACIONES, \n" +
            "3 AS PRIMA_VACACIONAL, \n" +
            "4 AS PRIMA_ANTIGUEDAD, \n" +
            "5 AS OTRO_TIPO_PREST \n" +
        ") \n" +
    ") \n" +
"), \n" +
"ESPECIFIQUE AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_CONFLICTO' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '8' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_CONFLICTO \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
 
"ESPECIFIQUE_DISCRIMINACION AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_CONFLICTO_CIRCUNST' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '10' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_DISCRIMI \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
"ESPECIFIQUE_CONCEPTO_RECLAMADO AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_CONCEPTO_RECLAMADO' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_RECLAMADO \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"),ESPECIFIQUE_PRESTACION AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_PRESTACION' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '5' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_PRESTACION \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"),ESPECIFIQUE_TIPO_INCOMPETENCIA AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_INCOMPETENCIA' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '4' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_INCOMPETENCIA \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"),ESPECIFIQUE_FORMA_SOLUCION AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_FORMA_SOLUCION' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ORDINARIO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_FORMA_SOLUCION \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
") \n" +
"SELECT \n" +
    "B.NOMBRE_ORGANO_JURIS, \n" +
    "B.CLAVE_ORGANO, \n" +
    "B.EXPEDIENTE_CLAVE, \n" +
    "B.FECHA_APERTURA_EXPEDIENTE, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_ASUNTO) AS TIPO_ASUNTO, \n" +
    "CONVER_V3_NAT_CONFLICTO(B.NAT_CONFLICTO) AS NAT_CONFLICTO, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.CONTRATO_ESCRITO) AS CONTRATO_ESCRITO, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_CONTRATO)AS TIPO_CONTRATO, \n" +
    "B.RAMA_INDUS_INVOLUCRADA, \n" +
    "CONVER_V3_SECTOR(B.SECTOR) AS SECTOR, \n" +
   "CONVER_V3_SUBSECTOR(B.SECTOR,B.SUBSECTOR) AS SUBSECTOR, \n" +
    "B.ENTIDAD_CLAVE, \n" +
    "B.ENTIDAD_NOMBRE, \n" +
    "B.MUNICIPIO_CLAVE, \n" +
    "B.MUNICIPIO_NOMBRE, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.SUBCONTRATACION) AS SUBCONTRATACION, \n" +
    "M.DESPIDO, \n" +
    "M.RESCISION_RL, \n" +
    "M.TERMINACION_RESCISION_RL, \n" +
    "M.VIOLACION_CONTRATO, \n" +
    "M.RIESGO_TRABAJO, \n" +
    "M.REVISION_CONTRATO, \n" +
    "M.PART_UTILIDADES, \n" +
    "M.OTRO_MOTIV_CONFLICTO, \n" +
    "E.OTRO_ESP_CONFLICTO, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.CIRCUNS_MOTIVO_CONFL) AS CIRCUNS_MOTIVO_CONFL, \n" +
    "C.DETERM_EMPLEO_EMBARAZO, \n" +
    "C.DETERM_EMPLEO_EDAD, \n" +
    "C.DETERM_EMPLEO_GENERO, \n" +
    "C.DETERM_EMPLEO_ORIEN_SEX, \n" +
    "C.DETERM_EMPLEO_DISCAPACIDAD, \n" +
    "C.DETERM_EMPLEO_SOCIAL, \n" +
    "C.DETERM_EMPLEO_ORIGEN, \n" +
    "C.DETERM_EMPLEO_RELIGION, \n" +
    "C.DETERM_EMPLEO_MIGRA, \n" +
    "C.OTRO_DISCRIMINACION, \n" +
    "ED.OTRO_ESP_DISCRIMI, \n" +
    "C.TRATA_LABORAL, \n" +
    "C.TRABAJO_FORZOSO, \n" +
    "C.TRABAJO_INFANTIL, \n" +
    "C.HOSTIGAMIENTO, \n" +
    "C.ACOSO_SEXUAL, \n" +
    "CR.PAGO_PRESTACIONES, \n" +
    "CR.INDEMNIZACION, \n" +
    "CR.REINSTALACION, \n" +
    "CR.SALARIO_RETENIDO, \n" +
    "CR.AUMENTO_SALARIO, \n" +
    "CR.DERECHO_ASCENSO, \n" +
    "CR.DERECHO_PREFERENCIA, \n" +
    "CR.DERECHO_ANTIGUEDAD, \n" +
    "CR.OTRO_CONCEPTO, \n" +
    "ECR.OTRO_ESP_RECLAMADO, \n" +
    "PR.AGUINALDO, \n" +
    "PR.VACACIONES, \n" +
    "PR.PRIMA_VACACIONAL, \n" +
    "PR.PRIMA_ANTIGUEDAD, \n" +
    "PR.OTRO_TIPO_PREST, \n" +
    "EPRE.OTRO_ESP_PRESTACION, \n" +
    "B.MOTIVO_CONF_COLECTIVO AS MOTIVO_CONFLICTO_COLECT, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.PREG_INCOMPETENCIA)    AS INCOMPETENCIA, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_INCOMPETENCIA) AS TIPO_INCOMPETENCIA, \n" +
    "ETINCOM.OTRO_ESP_INCOMPETENCIA, \n" +
    "B.FECHA_PRES_DEMANDA, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.CONSTANCIA_CONS_EXPEDIDA) AS CONSTANCIA_CONS_EXPEDIDA, \n" +
    "B.CONSTANCIA_CLAVE, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE( B.ASUN_EXCEP_CONCILIACION) AS ASUN_EXCEP_CONCILIACION, \n" +
     "CONVER_V3_RESPUESTA_SIMPLE(B.PREVE_DEMANDA) AS PREVE_DEMANDA, \n" +
     "CONVER_V3_RESPUESTA_SIMPLE(B.DESAHOGO_PREV_DEMANDA) AS DESAHOGO_PREV_DEMANDA, \n" +
     "CONVER_V3_GEN_NI_9(B.ESTATUS_DEMANDA) AS ESTATUS_DEMANDA, \n" +
    "CONVER_V3_GEN_NI_9(B.CAU_IMPI_ADMI_DEMANDA) AS CAU_IMPI_ADMI_DEMANDA, \n" +
    "B.FECHA_ADMI_DEMANDA, \n" +
    "B.CANTIDAD_ACTORES, \n" +
    "B.CANTIDAD_DEMANDADOS, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.AUDIENCIA_PRELIM) AS AUDIENCIA_PRELIM, \n" +
    "B.FECHA_AUDIENCIA_PRELIM, \n" +
    "CONVER_V3_RESPUESTA_SIMPLE(B.AUDIENCIA_JUICIO) AS AUDIENCIA_JUICIO, \n" +
    "B.FECHA_AUDIENCIA_JUICIO, \n" +
    "CONVER_V3_ESTATUS_EXPEDIENTE(B.ESTATUS_EXPEDIENTE) AS ESTATUS_EXPEDIENTE, \n" +
    "B.FECHA_ACTO_PROCESAL, \n" +
    "CONVER_V3_GEN_NI_99(B.FASE_SOLI_EXPEDIENTE) AS FASE_SOLI_EXPEDIENTE, \n" +
    "CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCIONFE) AS FORMA_SOLUCIONFE, \n" +
    "CASE WHEN B.FASE_SOLI_EXPEDIENTE=9 THEN ESFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS OTRO_ESP_SOLUCIONFE, \n" +
    "B.FECHA_DICTO_RESOLUCIONFE, \n" +
    "B.MONTO_SOLUCIONFE, \n" +
     
    "CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCIONAP) AS FORMA_SOLUCIONAP, \n" +
    "CASE WHEN B.FASE_SOLI_EXPEDIENTE=1 THEN ESFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS OTRO_ESP_SOLUCIONAP, \n" +
    "B.FECHA_DICTO_RESOLUCIONAP, \n" +
    "B.MONTO_SOLUCIONAP, \n" +
     
    "CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCIONAJ) AS FORMA_SOLUCIONAJ, \n" +
    "CASE WHEN B.FASE_SOLI_EXPEDIENTE=2 THEN ESFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS OTRO_ESP_SOLUCIONAJ, \n" +
    "B.FECHA_DICTO_RESOLUCIONAJ, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_SENTENCIAAJ)TIPO_SENTENCIAAJ, \n" +
    "B.MONTO_SOLUCIONAJ, \n" +
    "B.COMENTARIOS, \n" +
     
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN MOTIVOS M  \n" +
    "ON M.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND M.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE E \n" +
    "ON E.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND E.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND E.PERIODO = B.PERIODO \n" +
 "LEFT JOIN ESPECIFIQUE_DISCRIMINACION ED \n" +
    "ON ED.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND ED.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ED.PERIODO = B.PERIODO      \n" +
"LEFT JOIN CIRCUNSTANCIAS C \n" +
    "ON C.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND C.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND C.PERIODO = B.PERIODO \n" +
    "LEFT JOIN CONCEPTO_RECLAMADO CR \n" +
    "ON CR.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND CR.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND CR.PERIODO = B.PERIODO \n" +
     "LEFT JOIN ESPECIFIQUE_CONCEPTO_RECLAMADO ECR \n" +
    "ON ECR.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND ECR.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ECR.PERIODO = B.PERIODO    \n" +
     "LEFT JOIN PRESTACION PR \n" +
    "ON PR.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND PR.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND PR.PERIODO = B.PERIODO \n" +
    "LEFT JOIN ESPECIFIQUE_PRESTACION EPRE \n" +
    "ON EPRE.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND EPRE.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EPRE.PERIODO = B.PERIODO    \n" +
    "LEFT JOIN ESPECIFIQUE_TIPO_INCOMPETENCIA ETINCOM \n" +
    "ON ETINCOM.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND ETINCOM.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ETINCOM.PERIODO = B.PERIODO \n" +
     "LEFT JOIN ESPECIFIQUE_FORMA_SOLUCION ESFS \n" +
    "ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
    "AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ESFS.PERIODO = B.PERIODO \n" +
    "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;
    try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();

                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        fila.add(resul.getString(34)); 
                        fila.add(resul.getString(35));
                        fila.add(resul.getString(36));
                        fila.add(resul.getString(37));
                        fila.add(resul.getString(38));
                        fila.add(resul.getString(39));
                        fila.add(resul.getString(40));
                        fila.add(resul.getString(41));
                        fila.add(resul.getString(42));
                        fila.add(resul.getString(43));
                        fila.add(resul.getString(44));
                        fila.add(resul.getString(45));
                        fila.add(resul.getString(46));
                        fila.add(resul.getString(47));
                        fila.add(resul.getString(48));
                        fila.add(resul.getString(49));
                        fila.add(resul.getString(50));
                        fila.add(resul.getString(51));
                        fila.add(resul.getString(52));
                        fila.add(resul.getString(53));
                        fila.add(resul.getString(54));
                        fila.add(resul.getString(55));
                        fila.add(resul.getString(56));
                        fila.add(resul.getString(57));
                        fila.add(resul.getString(58));
                        fila.add(resul.getString(59));
                        fila.add(resul.getString(60));
                        fila.add(resul.getString(61));
                        fila.add(resul.getString(62));
                        fila.add(resul.getString(63));
                        fila.add(resul.getString(64));
                        fila.add(resul.getString(65));
                        fila.add(resul.getString(66));
                        fila.add(resul.getString(67));
                        fila.add(resul.getString(68));
                        fila.add(resul.getString(69));
                        fila.add(resul.getString(70));
                        fila.add(resul.getString(71));
                        fila.add(resul.getString(72));
                        fila.add(resul.getString(73));
                        fila.add(resul.getString(74));
                        fila.add(resul.getString(75));
                        fila.add(resul.getString(76));
                        fila.add(resul.getString(77));
                        fila.add(resul.getString(78));
                        fila.add(resul.getString(79));
                        fila.add(resul.getString(80));
                        fila.add(resul.getString(81));
                        fila.add(resul.getString(82));
                        fila.add(resul.getString(83));
                        fila.add(resul.getString(84));
                        fila.add(resul.getString(85));
                        fila.add(resul.getString(86));
                        fila.add(resul.getString(87));
                        fila.add(resul.getString(88));
                        fila.add(resul.getString(89));
                        fila.add(resul.getString(90));
                        fila.add(resul.getString(91));
                        fila.add(resul.getString(92));
                        fila.add(resul.getString(93));
                        fila.add(resul.getString(94));
                        fila.add(resul.getString(95));
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_ORDINARIOJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }    
    

public ArrayList<ArrayList<String>> V3_TR_PART_ACT_ORDINARIOJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS (\n" +
"SELECT\n" +
"    ORG.NOMBRE_ORGANOJ   AS NOMBRE_ORGANO_JURIS,\n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO,\n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE,\n" +
"    ACT.ID_ACTOR,\n" +
"    ACT.ID_TIPO_ACTOR    AS ACTOR,\n" +
"    ACT.ID_DEFENSA       AS DEFENSA_ACT,\n" +
"    ACT.ID_SEXO          AS SEXO,\n" +
"    ACT.EDAD             AS EDAD,\n" +
"    ACT.ID_OCUPACION     AS OCUPACION,\n" +
"    ACT.NSS              AS NSS,\n" +
"    ACT.CURP             AS CURP,\n" +
"    ACT.RFC              AS RFC_TRABAJADOR,\n" +
"    ACT.ID_JORNADA       AS JORNADA,\n" +
"    ACT.NOMBRE_SINDICATO,\n" +
"    ACT.REGISTRO_ASO_SINDICAL,\n" +
"    ACT.ID_TIPO_SINDICATO AS TIPO_SINDICATO,\n" +
"    ACT.PREG_SIND_PERT_ORG_O AS ORG_OBRERA,\n" +
"    ACT.ID_ORG_OBR AS NOMBRE_ORG_OBRERA,\n" +
"    ACT.TOTAL_TRAB_INVOL AS CANT_TRABAJA_INV,\n" +
"    ACT.CANT_TRAB_INVOL_H AS HOMBRES,\n" +
"    ACT.CANT_TRAB_INVOL_M AS MUJERES,\n" +
"    ACT.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO,\n" +
"    ACT.COMENTARIOS,\n" +
    "EXP.PERIODO\n" +
"FROM\n" +
         "TR_EXPEDIENTE EXP\n" +
    "INNER JOIN TR_ORGANOJ   ORG ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ\n" +
                                 "AND EXP.PERIODO = ORG.PERIODO\n" +
    "INNER JOIN TR_EXP_ACTOR TRAC ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE\n" +
"                                    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ\n" +
                                    "AND EXP.PERIODO = TRAC.PERIODO\n" +
    "INNER JOIN TR_ACTOR     ACT ON ACT.ID_ACTOR = TRAC.ACTORES_ID\n" +
"                               AND TRAC.ID_ORGANOJ = ACT.ID_ORGANOJ\n" +
                               "AND ACT.PERIODO = TRAC.PERIODO\n" +
  "WHERE EXP.ID_TIPO_EXPEDIENTE=1                               \n" +
"\n" +
"), \n" +
"ESPECIFIQUE_SINDICATO AS (\n" +
    "SELECT\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO AS ID_ORGANOJ,\n" +
"        PERIODO,\n" +
"        ID_ACT_DEM_AUD,\n" +
        "MAX(\n" +
            "CASE \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO'\n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6'\n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR ORDINARIO'\n" +
                "THEN ESPECIFIQUE\n" +
            "END\n" +
          ") AS OTRO_ESP_SINDICATO\n" +
"    FROM TR_ESPECIFIQUE\n" +
    "GROUP BY\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO,\n" +
"        PERIODO,\n" +
"        ID_ACT_DEM_AUD\n" +
        "), \n" +
"ESPECIFIQUE_OBRERA AS (\n" +
    "SELECT\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO AS ID_ORGANOJ,\n" +
"        PERIODO,\n" +
"        ID_ACT_DEM_AUD,\n" +
        "MAX(\n" +
            "CASE \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR'\n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8'\n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR ORDINARIO'\n" +
                "THEN ESPECIFIQUE\n" +
            "END\n" +
          ") AS OTRO_ESP_OBRERA\n" +
"    FROM TR_ESPECIFIQUE\n" +
    "GROUP BY\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO,\n" +
"        PERIODO,\n" +
"        ID_ACT_DEM_AUD\n" +
"        )\n" +
        "SELECT \n" +
   "B.NOMBRE_ORGANO_JURIS,\n" +
"    B.CLAVE_ORGANO,\n" +
"    B.EXPEDIENTE_CLAVE,\n" +
    "B.ID_ACTOR,\n" +
"   CONVER_V3_GEN_NI_99(B.ACTOR) AS ACTOR,\n" +
   "CONVER_V3_GEN_NI_9(B.DEFENSA_ACT) AS DEFENSA_ACT,\n" +
"    CONVER_V3_GEN_NI_9(B.SEXO) AS SEXO,\n" +
"    B.EDAD,\n" +
"    CONVER_V3_GEN_NI_999(B.OCUPACION) AS OCUPACION,\n" +
"    B.NSS,\n" +
"    B.CURP,\n" +
"    B.RFC_TRABAJADOR,\n" +
"    CONVER_V3_GEN_NI_9(B.JORNADA) AS JORNADA,\n" +
"    B.NOMBRE_SINDICATO,\n" +
"    B.REGISTRO_ASO_SINDICAL,\n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SINDICATO) AS TIPO_SINDICATO,\n" +
"    ESFS.OTRO_ESP_SINDICATO,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(B.ORG_OBRERA) AS ORG_OBRERA,\n" +
"    CONVER_V3_GEN_NI_9(B.NOMBRE_ORG_OBRERA) AS NOMBRE_ORG_OBRERA,\n" +
"    ESO.OTRO_ESP_OBRERA,\n" +
"    B.CANT_TRABAJA_INV,\n" +
"    B.HOMBRES,\n" +
"    B.MUJERES,\n" +
"    B.NO_IDENTIFICADO,\n" +
"    B.COMENTARIOS,\n" +
    "B.PERIODO\n" +
"FROM BASE B\n" +
     "LEFT JOIN ESPECIFIQUE_SINDICATO ESFS\n" +
"    ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE\n" +
"    AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO\n" +
"    AND ESFS.PERIODO = B.PERIODO\n" +
    "AND ESFS.ID_ACT_DEM_AUD=B.ID_ACTOR\n" +
     "LEFT JOIN ESPECIFIQUE_OBRERA ESO\n" +
"    ON ESO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE\n" +
"    AND ESO.ID_ORGANOJ = B.CLAVE_ORGANO\n" +
"    AND ESO.PERIODO = B.PERIODO\n" +
"    AND ESO.ID_ACT_DEM_AUD=B.ID_ACTOR\n" +
    "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"')\n" ;
    try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }                               
                               

                               

public ArrayList<ArrayList<String>> V3_TR_PART_DEM_ORDINARIOJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT \n" +
"    ORG.NOMBRE_ORGANOJ   AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    DEM.ID_DEMANDADO, \n" +
"    DEM.ID_TIPO_DEMANDADO   AS DEMANDADO, \n" +
"    DEM.ID_DEFENSA       AS DEFENSA_DEM, \n" +
    "DEM.ID_TIPO_PATRON          AS TIPO, \n" +
     "DEM.RFC AS RFC_PATRON, \n" +
"    DEM.RAZON_SOCIAL             AS RAZON_SOCIAL_EMPR, \n" +
"    DEM.CALLE, \n" +
"    DEM.NUM_EXTERIOR              AS N_EXT, \n" +
"    DEM.NUM_INTERIOR             AS N_INT, \n" +
"    DEM.COLONIA              , \n" +
"    DEM.CP       , \n" +
"    TCMPIO.ENTIDAD AS ENTIDAD_NOMBRE_EMPR, \n" +
"    TCMPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE_EMPR, \n" +
"    TCMPIO.MUNICIPIO AS MUNICIPIO_NOMBRE_EMPR, \n" +
"    TCMPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE_EMPR, \n" +
"    DEM.LATITUD AS LATITUD_EMPR ,  \n" +
"    DEM.LONGITUD AS LONGITUD_EMPR,   \n" +
"    DEM.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM \n" +
         "TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ   ORG ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
                                 "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TR_EXP_DEMANDADO TRAC ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"                                    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
                                    "AND EXP.PERIODO = TRAC.PERIODO \n" +
    "INNER JOIN TR_DEMANDADO DEM ON DEM.ID_DEMANDADO = TRAC.ID_DEMANDADO \n" +
"                               AND TRAC.ID_ORGANOJ = DEM.ID_ORGANOJ \n" +
                               "AND DEM.PERIODO = TRAC.PERIODO \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TCMPIO ON TCMPIO.ID_ENT_MPIO=DEM.ID_ENT_MPIO \n" +
  "WHERE EXP.ID_TIPO_EXPEDIENTE=1                                \n" +
"    ) \n" +
    "SELECT  \n" +
   "B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
    "B.ID_DEMANDADO, \n" +
"  CONVER_V3_GEN_NI_9(B.DEMANDADO)AS DEMANDADO, \n" +
  "CONVER_V3_GEN_NI_9(B.DEFENSA_DEM) AS DEFENSA_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO) AS TIPO, \n" +
"    B.RFC_PATRON, \n" +
"    B.RAZON_SOCIAL_EMPR, \n" +
"    B.CALLE, \n" +
"    B.N_EXT, \n" +
"    B.N_INT, \n" +
"    B.COLONIA              , \n" +
"    B.CP       , \n" +
"    B.ENTIDAD_NOMBRE_EMPR, \n" +
"    B.ENTIDAD_CLAVE_EMPR, \n" +
"    B.MUNICIPIO_NOMBRE_EMPR, \n" +
"    B.MUNICIPIO_CLAVE_EMPR, \n" +
"    B.LATITUD_EMPR ,  \n" +
"    B.LONGITUD_EMPR,   \n" +
"    B.COMENTARIOS, \n" +
"    B.PERIODO \n" +
    "FROM BASE B \n" +
     "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;
     
                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }                               
                               
                               
public ArrayList<ArrayList<String>>  V3_TR_INDIVIDUAL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH base AS (\n" +
    "SELECT\n" +
"        exp.id_expediente,\n" +
"        exp.periodo,\n" +
"        org.nombre_organoj            AS nombre_organo_juris,\n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO,\n" +
"        exp.clave_expediente          AS expediente_clave,\n" +
"        exp.fecha_apertura_exped      AS fecha_apertura_expediente,\n" +
"        exp.id_tipo_asunto            AS tipo_asunto,\n" +
"        exp.id_nat_conflicto          AS nat_conflicto,\n" +
"        exp.preg_trab_contr_escri     AS contrato_escrito,\n" +
"        exp.id_tipo_contrato          AS tipo_contrato,\n" +
"        exp.rama_involuc              AS rama_indus_involucrada,\n" +
"        tc_sec.sector                 AS sector_rama,\n" +
"        tc_sec.subsector              AS subsector_rama,\n" +
"        tc_ent_mpio.clave_entidad     AS entidad_clave,\n" +
"        tc_ent_mpio.entidad           AS entidad_nombre,\n" +
"        tc_ent_mpio.clave_municipio   AS municipio_clave,\n" +
"        tc_ent_mpio.municipio         AS municipio_nombre,\n" +
"        exp.preg_outsourcing          AS subcontratacion,\n" +
"        exp.preg_incompetencia,\n" +
"        exp.id_tipo_incompetencia     AS tipo_incompetencia,\n" +
"        exp.fecha_present_demanda     AS fecha_pres_demanda,\n" +
"        exp.preg_const_conciliac      AS constancia_cons_expedida,\n" +
"        exp.clave_const_conciliac     AS constancia_clave,\n" +
"        exp.preg_asunto_vinc_concil_p AS asun_excep_conciliacion,\n" +
"        exp.preg_formulo_demanda      AS preve_demanda,\n" +
"        exp.preg_desahogo_demanda     AS desahogo_prev_demanda,\n" +
"        exp.id_estatus_demanda        AS estatus_demanda,\n" +
"        exp.id_causa_imp_adm_demanda  AS cau_impi_admi_demanda,\n" +
"        exp.fecha_adm_demanda         AS fecha_admi_demanda,\n" +
"        exp.cant_actores              AS cantidad_actores,\n" +
"        exp.cant_demandados           AS cantidad_demandados,\n" +
"        exp.preg_auto_depuracion_tram AS tramitacion_depuracion,\n" +
"        exp.fecha_auto_depuracion     AS fecha_depuracion,\n" +
"        exp.preg_aud_prelim_celebr    AS audiencia_prelim,\n" +
"        exp.fecha_audiencia_prelim,\n" +
"        exp.preg_celebra_aud_juicio   AS audiencia_juicio,\n" +
"        exp.fecha_aud_juicio          AS fecha_audiencia_juicio,\n" +
"        exp.id_estatus_exped          AS estatus_expediente,\n" +
"        exp.fecha_ult_act_proc        AS fecha_acto_procesal,\n" +
"        exp.id_fase_sol_exped         AS fase_soli_expediente,\n" +
"        \n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 3 THEN\n" +
                "exp.id_forma_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS forma_solucionad,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 3 THEN\n" +
                "exp.fecha_dicto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS fecha_dicto_resolucion_ad,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 3 THEN\n" +
                "exp.id_tipo_sentencia\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS tipo_sentencia_ad,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 3 THEN\n" +
                "exp.monto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS monto_solucion_ad,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 4 THEN\n" +
                "exp.id_forma_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS forma_solucion_ta,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 4 THEN\n" +
                "exp.fecha_dicto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS fecha_resolucion_ta,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 4 THEN\n" +
                "exp.id_tipo_sentencia\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS tipo_sentencia_ta,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 4 THEN\n" +
                "exp.monto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS monto_solucion_ta,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 1 THEN\n" +
                "exp.id_forma_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS forma_solucion_ap,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 1 THEN\n" +
                "exp.fecha_dicto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS fecha_dicto_resolucion_ap,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 1 THEN\n" +
                "exp.monto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS monto_solucion_ap,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 2 THEN\n" +
                "exp.id_forma_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS forma_solucion_aj,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 2 THEN\n" +
                "exp.fecha_dicto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS fecha_dicto_resolucion_aj,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 2 THEN\n" +
                "exp.id_tipo_sentencia\n" +
            "ELSE\n" +
                "NULL\n" +
"        END                           AS tipo_sentencia_aj,\n" +
        "CASE\n" +
            "WHEN exp.id_fase_sol_exped = 2 THEN\n" +
                "exp.monto_solucion\n" +
            "ELSE\n" +
                "NULL\n" +
        "END                           AS monto_solución_aj,\n" +
"    \n" +
"    \n" +
"    \n" +
"     \n" +
        "exp.comentarios\n" +
    "FROM\n" +
             "tr_expediente exp\n" +
        "INNER JOIN tr_organoj       org ON exp.id_organoj = org.id_organoj\n" +
                                     "AND exp.periodo = org.periodo\n" +
"        INNER JOIN tc_sector_sbstor tc_sec ON tc_sec.id_sector_sbstor = exp.id_sector_sbtor\n" +
        "LEFT JOIN tc_entidad_mpio  tc_ent_mpio ON tc_ent_mpio.id_ent_mpio = exp.id_ent_mpio\n" +
    "WHERE\n" +
        "exp.id_tipo_expediente = 2\n" +
"), \n" +
"motivos AS (\n" +
    "SELECT\n" +
        "*\n" +
    "FROM\n" +
        "(\n" +
            "SELECT\n" +
"                id_expediente,\n" +
"                id_organoj,\n" +
"                periodo,\n" +
"                id_motivo_conflicto,\n" +
                "1 AS existe_motivo\n" +
            "FROM\n" +
                "tr_exp_motivo_conf\n" +
        ") PIVOT (\n" +
"            MAX(existe_motivo)\n" +
"            FOR id_motivo_conflicto\n" +
"            IN ( 9 AS indole_trabajo, 10 AS prestacion_fp, 11 AS arrendam_trab, 12 AS capacitacion, 13 AS antiguedad, 14 AS prima_antiguedad\n" +
"            , 15 AS convenio_trab, 16 AS designacion_trab_falle, 17 AS designacion_trab_act_delic, 18 AS terminacion_lab, 19 AS recuperacion_carga\n" +
"            , 20 AS gastos_traslados, 21 AS indemnizacion, 22 AS pago_indemnizacion, 23 AS desacuerdo_medicos, 24 AS cobro_prestaciones\n" +
            ", 25 AS conf_seguro_social, 26 AS otro_conf )\n" +
        ")\n" +
"), especifique AS (\n" +
    "SELECT\n" +
"        clave_expediente,\n" +
"        organo AS id_organoj,\n" +
"        periodo,\n" +
        "MAX(\n" +
            "CASE\n" +
                "WHEN nemonico_catalogo = 'TC_MOTIVO_CONFLICTO'\n" +
"                     AND id_otro_especifique = '26'\n" +
"                     AND TRIM(upper(procedimiento)) = 'ESPECIAL INDIVIDUAL\n" +
                     "' THEN\n" +
                    "especifique\n" +
            "END\n" +
        ")      AS otro_esp_conf\n" +
    "FROM\n" +
        "tr_especifique\n" +
    "GROUP BY\n" +
"        clave_expediente,\n" +
"        organo,\n" +
        "periodo\n" +
"), especifique_tipo_incompetencia AS (\n" +
    "SELECT\n" +
"        clave_expediente,\n" +
"        organo AS id_organoj,\n" +
"        periodo,\n" +
        "MAX(\n" +
            "CASE\n" +
                "WHEN nemonico_catalogo = 'TC_INCOMPETENCIA'\n" +
"                     AND id_otro_especifique = '4'\n" +
                     "AND procedimiento = 'ESPECIAL INDIVIDUAL' THEN\n" +
                    "especifique\n" +
            "END\n" +
        ")      AS otro_esp_incomp\n" +
    "FROM\n" +
        "tr_especifique\n" +
    "GROUP BY\n" +
"        clave_expediente,\n" +
"        organo,\n" +
        "periodo\n" +
"), especifique_forma_solucion AS (\n" +
    "SELECT\n" +
"        clave_expediente,\n" +
"        organo AS id_organoj,\n" +
"        periodo,\n" +
        "MAX(\n" +
            "CASE\n" +
                "WHEN nemonico_catalogo = 'TC_FORMA_SOLUCION'\n" +
"                     AND id_otro_especifique = '9'\n" +
                     "AND procedimiento = 'ESPECIAL INDIVIDUAL' THEN\n" +
                    "especifique\n" +
            "END\n" +
        ")      AS otro_esp_forma_solucion\n" +
    "FROM\n" +
        "tr_especifique\n" +
    "GROUP BY\n" +
"        clave_expediente,\n" +
"        organo,\n" +
        "periodo\n" +
")\n" +
"SELECT\n" +
"    b.nombre_organo_juris,\n" +
"    b.clave_organo,\n" +
"    b.expediente_clave,\n" +
    "b.fecha_apertura_expediente,\n" +
     "CONVER_V3_GEN_NI_9(b.tipo_asunto) AS tipo_asunto,\n" +
"    CONVER_V3_NAT_CONFLICTO(b.nat_conflicto) AS nat_conflicto,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.contrato_escrito) AS contrato_escrito,\n" +
"    CONVER_V3_GEN_NI_9(b.tipo_contrato) AS tipo_contrato,\n" +
"    b.rama_indus_involucrada,\n" +
"    CONVER_V3_SECTOR(b.sector_rama) AS sector_rama,\n" +
"    CONVER_V3_SUBSECTOR(b.sector_rama,b.subsector_rama) AS subsector_rama,\n" +
"    b.entidad_clave,\n" +
"    b.entidad_nombre,\n" +
"    b.municipio_clave,\n" +
"    b.municipio_nombre,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.subcontratacion) AS subcontratacion,\n" +
"    m.indole_trabajo,\n" +
"    m.prestacion_fp,\n" +
"    m.arrendam_trab,\n" +
"    m.capacitacion,\n" +
"    m.antiguedad,\n" +
"    m.prima_antiguedad,\n" +
"    m.convenio_trab,\n" +
"    m.designacion_trab_falle,\n" +
"    m.designacion_trab_act_delic,\n" +
"    m.terminacion_lab,\n" +
"    m.recuperacion_carga,\n" +
"    m.gastos_traslados,\n" +
"    m.indemnizacion,\n" +
"    m.pago_indemnizacion,\n" +
"    m.desacuerdo_medicos,\n" +
"    m.cobro_prestaciones,\n" +
"    m.conf_seguro_social,\n" +
"    m.otro_conf,\n" +
    "e.OTRO_ESP_CONF,\n" +

"    CONVER_V3_RESPUESTA_SIMPLE(b.preg_incompetencia) AS preg_incompetencia,\n" +
"    CONVER_V3_GEN_NI_9(b.tipo_incompetencia) AS tipo_incompetencia,   \n" +
"    etincom.OTRO_ESP_INCOMP,\n" +
"    b.fecha_pres_demanda,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.constancia_cons_expedida) AS constancia_cons_expedida,\n" +
"    b.constancia_clave,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.asun_excep_conciliacion) AS asun_excep_conciliacion,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.preve_demanda) AS preve_demanda,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.desahogo_prev_demanda) AS desahogo_prev_demanda,\n" +
"    CONVER_V3_GEN_NI_9(b.estatus_demanda) AS estatus_demanda,\n" +
"    CONVER_V3_GEN_NI_9(b.cau_impi_admi_demanda) AS cau_impi_admi_demanda,\n" +
"    b.fecha_admi_demanda,\n" +
"    b.cantidad_actores,\n" +
"    b.cantidad_demandados,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.tramitacion_depuracion) AS tramitacion_depuracion,\n" +
"    b.fecha_depuracion,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.audiencia_prelim) AS audiencia_prelim,\n" +
"    b.fecha_audiencia_prelim,\n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.audiencia_juicio) AS audiencia_juicio,\n" +
"    b.fecha_audiencia_juicio,\n" +
"    CONVER_V3_ESTATUS_EXPEDIENTE(b.estatus_expediente) AS estatus_expediente,\n" +
"    b.fecha_acto_procesal,\n" +
"    CONVER_V3_GEN_NI_99(b.fase_soli_expediente) AS fase_soli_expediente,\n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 3 THEN\n" +
"            CONVER_V3_FORMA_SOLUCION(b.forma_solucionad)\n" +
            
        "ELSE\n" +
            "NULL\n" +
    "END AS forma_solucionad,\n" +
     "CASE\n" +
        "WHEN b.fase_soli_expediente = 3 THEN\n" +
"            esfs.OTRO_ESP_FORMA_SOLUCION\n" +
            
        "ELSE\n" +
            "NULL\n" +
"    END AS OTRO_ESP_FORMA_SOLUCION_AD,\n" +
"    \n" +
"    \n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 3 THEN\n" +
            "b.fecha_dicto_resolucion_ad\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS fecha_dicto_resolucion_ad,\n" +
"    \n" +
      
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 3 THEN\n" +
            "CONVER_V3_GEN_NI_9(b.tipo_sentencia_ad)\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS tipo_sentencia_ad,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 3 THEN\n" +
            "b.monto_solucion_ad\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS monto_solucion_ad,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 4 THEN\n" +
            "CONVER_V3_FORMA_SOLUCION(b.forma_solucion_ta)\n" +
        "ELSE\n" +
            "NULL\n" +
    "END AS forma_solucion_ta,\n" +
"        CASE\n" +
        "WHEN b.fase_soli_expediente = 4 THEN\n" +
            "esfs.OTRO_ESP_FORMA_SOLUCION\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS OTRO_ESP_SOLUCION_TA,\n" +
"    \n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 4 THEN\n" +
            "b.fecha_resolucion_ta\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS fecha_resolucion_ta,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 4 THEN\n" +
            "CONVER_V3_GEN_NI_9(b.tipo_sentencia_ta)\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS tipo_sentencia_ta,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 4 THEN\n" +
            "b.monto_solucion_ta\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS monto_solucion_ta,\n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 1 THEN\n" +
           "CONVER_V3_FORMA_SOLUCION( b.forma_solucion_ap)\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS forma_solucion_ap,\n" +
"    \n" +
     "CASE\n" +
        "WHEN b.fase_soli_expediente = 1 THEN\n" +
            "esfs.OTRO_ESP_FORMA_SOLUCION\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS OTRO_ESP_SOLUCION_AP,\n" +
"    \n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 1 THEN\n" +
            "b.fecha_dicto_resolucion_ap\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS fecha_dicto_resolucion_ap,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 1 THEN\n" +
            "b.monto_solucion_ap\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS monto_solucion_ap,\n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 2 THEN\n" +
           "CONVER_V3_FORMA_SOLUCION( b.forma_solucion_aj)\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS forma_solucion_aj,\n" +
"    \n" +
     "CASE\n" +
        "WHEN b.fase_soli_expediente = 2 THEN\n" +
            "esfs.OTRO_ESP_FORMA_SOLUCION\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS OTRO_ESP_SOLUCION_AJ,\n" +
"    \n" +
"    \n" +
"    \n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 2 THEN\n" +
            "b.fecha_dicto_resolucion_aj\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS fecha_dicto_resolucion_aj,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 2 THEN\n" +
            "CONVER_V3_GEN_NI_9(b.tipo_sentencia_aj)\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS tipo_sentencia_aj,\n" +
    "CASE\n" +
        "WHEN b.fase_soli_expediente = 2 THEN\n" +
            "b.monto_solución_aj\n" +
        "ELSE\n" +
            "NULL\n" +
"    END AS monto_solución_aj,\n" +
"    b.comentarios,\n" +
    "b.periodo\n" +
"FROM\n" +
"    base                           b\n" +
    "LEFT JOIN motivos                        m ON m.id_expediente = b.id_expediente\n" +
"                           AND m.id_organoj = b.clave_organo\n" +
                           "AND m.periodo = b.periodo\n" +
    "LEFT JOIN especifique                    e ON e.clave_expediente = b.expediente_clave\n" +
"                               AND e.id_organoj = b.clave_organo\n" +
                               "AND e.periodo = b.periodo\n" +
    "LEFT JOIN especifique_tipo_incompetencia etincom ON etincom.clave_expediente = b.expediente_clave\n" +
"                                                        AND etincom.id_organoj = b.clave_organo\n" +
                                                        "AND etincom.periodo = b.periodo\n" +
    "LEFT JOIN especifique_forma_solucion     esfs ON esfs.clave_expediente = b.expediente_clave\n" +
"                                                 AND esfs.id_organoj = b.clave_organo\n" +
                                                 "AND esfs.periodo = b.periodo\n" +

     "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"')\n" ;
      try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        fila.add(resul.getString(34)); 
                        fila.add(resul.getString(35));
                        fila.add(resul.getString(36));
                        fila.add(resul.getString(37));
                        fila.add(resul.getString(38));
                        fila.add(resul.getString(39));
                        fila.add(resul.getString(40));
                        fila.add(resul.getString(41));
                        fila.add(resul.getString(42));
                        fila.add(resul.getString(43));
                        fila.add(resul.getString(44));
                        fila.add(resul.getString(45));
                        fila.add(resul.getString(46));
                        fila.add(resul.getString(47));
                        fila.add(resul.getString(48));
                        fila.add(resul.getString(49));
                        fila.add(resul.getString(50));
                        fila.add(resul.getString(51));
                        fila.add(resul.getString(52));
                        fila.add(resul.getString(53));
                        fila.add(resul.getString(54));
                        fila.add(resul.getString(55));
                        fila.add(resul.getString(56));
                        fila.add(resul.getString(57));
                        fila.add(resul.getString(58));
                        fila.add(resul.getString(59));
                        fila.add(resul.getString(60));
                        fila.add(resul.getString(61));
                        fila.add(resul.getString(62));
                        fila.add(resul.getString(63));
                        fila.add(resul.getString(64));
                        fila.add(resul.getString(65));
                        fila.add(resul.getString(66));
                        fila.add(resul.getString(67));
                        fila.add(resul.getString(68));
                        fila.add(resul.getString(69));
                        fila.add(resul.getString(70));
                        fila.add(resul.getString(71));
                        fila.add(resul.getString(72));
                        fila.add(resul.getString(73));
                        fila.add(resul.getString(74));
                        fila.add(resul.getString(75));
                        fila.add(resul.getString(76));
                        fila.add(resul.getString(77));
                        fila.add(resul.getString(78));
                        fila.add(resul.getString(79));
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }




public ArrayList<ArrayList<String>> V3_TR_PART_ACT_INDIVITUAL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "SELECT  \n" +
"    ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    ACT.ID_ACTOR, \n" +
"    CONVER_V3_GEN_NI_99(ACT.ID_TIPO_ACTOR) AS ACTOR, \n" +
"    CONVER_V3_GEN_NI_9(ACT.ID_DEFENSA) AS DEFENSA_ACT, \n" +
"    CONVER_V3_GEN_NI_9(ACT.ID_SEXO) as sexo, \n" +
"    act.edad, \n" +
"    CONVER_V3_GEN_NI_999(ACT.ID_OCUPACION) as ocupacion, \n" +
"    act.NSS, \n" +
"    ACT.CURP, \n" +
"    act.rfc as RFC_TRABAJADOR, \n" +
    "CONVER_V3_GEN_NI_9(ACT.ID_JORNADA) as JORNADA, \n" +
     "ACT.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM TR_EXPEDIENTE EXP \n" +
" \n" +
"    INNER JOIN TR_EXP_ACTOR TRAC  \n" +
"    ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
    "AND TRAC.PERIODO = EXP.PERIODO \n" +
" \n" +
" \n" +
"INNER JOIN TR_ACTOR ACT  \n" +
"    ON ACT.ID_ACTOR = TRAC.ACTORES_ID \n" +
"    AND ACT.ID_ORGANOJ = TRAC.ID_ORGANOJ \n" +
    "AND ACT.PERIODO = TRAC.PERIODO \n" +
" \n" +
"INNER JOIN TR_ORGANOJ ORG  \n" +
"    ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
    "AND EXP.PERIODO = ORG.PERIODO \n" +
" \n" +
"WHERE EXP.ID_TIPO_EXPEDIENTE = 2 \n" +
"AND  (SUBSTR(ORG.ID_ORGANOJ,0,2)=''"+cveEntidad+"'' AND EXP.PERIODO='"+periodo+"') OR (ORG.ID_ORGANOJ='"+cveOrgano+"'  AND EXP.PERIODO=''"+periodo+"'') \n" ;

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_ACT_INDIVITUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }


public ArrayList<ArrayList<String>>  V3_TR_PART_DEM_INDIVIDUAL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "SELECT  \n" +
"    ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    DEM.id_demandado, \n" +
"    CONVER_V3_GEN_NI_9(DEM.ID_TIPO_DEMANDADO) AS DEMANDADO, \n" +
"    CONVER_V3_GEN_NI_9(DEM.ID_DEFENSA) AS DEFENSA_DEM, \n" +
"    CONVER_V3_GEN_NI_9(DEM.ID_TIPO_PATRON) AS TIPO, \n" +
"    DEM.RFC AS RFC_PATRON, \n" +
"    DEM.RAZON_SOCIAL AS RAZON_SOCIAL_EMPR, \n" +
"    DEM.CALLE AS CALLE, \n" +
"    DEM.NUM_EXTERIOR AS N_EXT, \n" +
"    DEM.NUM_INTERIOR AS N_INT, \n" +
"    DEM.COLONIA AS COLONIA, \n" +
"    DEM.CP AS CP, \n" +
"    DEM.ID_ENT_MPIO AS ENTIDAD_NOMBRE_EMPR, \n" +
"    TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
"    TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
"    TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
"    DEM.LATITUD AS LATITUD_EMPR, \n" +
"    DEM.LONGITUD AS LONGITUD_EMPR, \n" +
"    DEM.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM TR_EXPEDIENTE EXP \n" +
"INNER JOIN TR_ORGANOJ ORG  \n" +
"    ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
    "AND EXP.PERIODO = ORG.PERIODO \n" +
"INNER JOIN TR_EXP_DEMANDADO TRAC  \n" +
"    ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
    "AND TRAC.PERIODO = EXP.PERIODO \n" +
"INNER JOIN TR_DEMANDADO DEM  \n" +
"    ON DEM.ID_DEMANDADO = TRAC.ID_DEMANDADO \n" +
"    AND DEM.ID_ORGANOJ = TRAC.ID_ORGANOJ \n" +
"    AND DEM.PERIODO = TRAC.PERIODO \n" +
"    LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
    "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
"WHERE EXP.ID_TIPO_EXPEDIENTE = 2 \n" +
"AND  (SUBSTR(ORG.ID_ORGANOJ,0,2)=''"+cveEntidad+"'' AND EXP.PERIODO='"+periodo+"') OR (ORG.ID_ORGANOJ='"+cveOrgano+"'  AND EXP.PERIODO=''"+periodo+"'') \n" ;
  try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_DEM_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }

public ArrayList<ArrayList<String>>  V3_TR_COLECTIVO (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT \n" +
"        EXP.ID_EXPEDIENTE, \n" +
"        EXP.PERIODO, \n" +
"        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"        EXP.FECHA_APERTURA_EXPED AS FECHA_APERTURA_EXPEDIENTE, \n" +
"        EXP.ID_TIPO_ASUNTO AS TIPO_ASUNTO, \n" +
"        EXP.ID_NAT_CONFLICTO AS NAT_CONFLICTO, \n" +
"        EXP.RAMA_INVOLUC AS RAMA_INDUS_INVOLUCRAD, \n" +
"        TC_SEC.SECTOR, \n" +
"        TC_SEC.SUBSECTOR, \n" +
"        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
"        TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE, \n" +
"        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
"        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
"        EXP.PREG_INCOMPETENCIA, \n" +
"        EXP.ID_TIPO_INCOMPETENCIA AS TIPO_INCOMPETENCIA, \n" +
"        EXP.FECHA_PRESENT_DEMANDA AS FECHA_PRES_DEMANDA, \n" +
"        EXP.PREG_CONST_CONCILIAC AS CONSTANCIA_CONS_EXPEDIDA, \n" +
"        EXP.CLAVE_CONST_CONCILIAC AS CONSTANCIA_CLAVE, \n" +
"        EXP.PREG_ASUNTO_VINC_CONCIL_P AS ASUN_EXCEP_CONCILIACION, \n" +
"        EXP.PREG_FORMULO_DEMANDA AS PREVE_DEMANDA, \n" +
"        EXP.PREG_DESAHOGO_DEMANDA AS DESAHOGO_PREV_DEMANDA, \n" +
"        EXP.ID_ESTATUS_DEMANDA AS ESTATUS_DEMANDA, \n" +
"        EXP.FECHA_ADM_DEMANDA AS FECHA_ADMISION_DEMANDA, \n" +
"        EXP.CANT_ACTORES AS CANTIDAD_ACTORES, \n" +
"        EXP.CANT_DEMANDADOS AS CANTIDAD_DEMANDADOS, \n" +
"        EXP.PREG_AUTO_DEPURACION_TRAM AS TRAMITACION_DEPURACION, \n" +
"        EXP.FECHA_AUTO_DEPURACION AS FECHA_DEPURACION, \n" +
"        EXP.PREG_CELEBRA_AUD_JUICIO AS AUDIENCIA_JUICIO, \n" +
"        EXP.FECHA_AUD_JUICIO AS FECHA_AUDIENCIA_JUICIO,  \n" +
"        EXP.ID_ESTATUS_EXPED AS ESTATUS_EXPEDIENTE, \n" +
"        EXP.FECHA_ULT_ACT_PROC AS FECHA_ACTO_PROCESAL, \n" +
        "EXP.ID_FASE_SOL_EXPED AS FASE_SOLI_EXPEDIENTE, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCION_AD, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_DICTO_RESOLUCION_AD, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.ID_TIPO_SENTENCIA ELSE NULL END AS TIPO_SENTENCIA_AD, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=2 THEN EXP.MONTO_SOLUCION ELSE NULL END AS MONTO_SOLUCION_AD,  \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=3 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCION_AJ, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=3 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_RESOLUCION_AJ, \n" +
"            CASE WHEN EXP.ID_FASE_SOL_EXPED=3 THEN EXP.ID_TIPO_SENTENCIA ELSE NULL END AS TIPO_SENTENCIA_AJ, \n" +
            "CASE WHEN EXP.ID_FASE_SOL_EXPED=3 THEN EXP.MONTO_SOLUCION ELSE NULL END AS MONTO_SOLUCIÓN_AJ, \n" +
        "EXP.COMENTARIOS \n" +
"    FROM TR_EXPEDIENTE EXP  \n" +
    "INNER JOIN TR_ORGANOJ ORG \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TC_SECTOR_SBSTOR TC_SEC \n" +
        "ON TC_SEC.ID_SECTOR_SBSTOR = EXP.ID_SECTOR_SBTOR \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 3 \n" +
"), \n" +
" \n" +
"MOTIVOS AS ( \n" +
"    SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
"            ID_EXPEDIENTE, \n" +
"            ID_ORGANOJ, \n" +
"            PERIODO, \n" +
"            ID_MOTIVO_CONFLICTO, \n" +
            "1 AS EXISTE_MOTIVO \n" +
        "FROM TR_EXP_MOTIVO_CONF \n" +
"    ) \n" +
    "PIVOT ( \n" +
"        MAX(EXISTE_MOTIVO) \n" +
        "FOR ID_MOTIVO_CONFLICTO IN ( \n" +
"            27 AS DECLARACION_PERDIDA_MAY, \n" +
"            28 AS SUSPENSION_TMP, \n" +
"            29 AS TERMINACION_TRAB, \n" +
"            30 AS CONTRATACION_COLECTIVA, \n" +
"            31 AS OMISIONES_REGLAMENTO, \n" +
"            32 AS REDUCCION_PERSONAL, \n" +
"            33 AS VIOLA_DERECHOS, \n" +
"            34 AS ELECCION_SINDICALES, \n" +
"            35 AS SANCION_SINDICALES, \n" +
            "36 AS OTRO_CONFLICTO \n" +
        ") \n" +
    ") \n" +
"), \n" +
"SUSPENCION AS ( \n" +
"    SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
"            ID_EXPEDIENTE, \n" +
"            ID_ORGANOJ, \n" +
"            PERIODO, \n" +
"            ID_TIPO_SUSPENSION, \n" +
            "1 AS EXISTE_SUSPENSION \n" +
        "FROM TR_EXP_SUSPENSION \n" +
"    ) \n" +
    "PIVOT ( \n" +
"        MAX(EXISTE_SUSPENSION) \n" +
        "FOR ID_TIPO_SUSPENSION IN ( \n" +
"            1 AS NO_IMPUTABLE_ST, \n" +
"            2 AS INCAPACIDAD_FISICA_ST, \n" +
"            3 AS FALTA_MATERIA_PRIM_ST, \n" +
            "4 AS FALTA_MINISTRACION_ST \n" +
        ") \n" +
    ") \n" +
"), \n" +
"TERMINACION AS ( \n" +
"    SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
"            ID_EXPEDIENTE, \n" +
"            ID_ORGANOJ, \n" +
"            PERIODO, \n" +
"            ID_TIPO_TERMINACION, \n" +
            "1 AS EXISTE_TERMINACION \n" +
        "FROM TR_EXP_TERMINACION \n" +
"    ) \n" +
    "PIVOT ( \n" +
"        MAX(EXISTE_TERMINACION) \n" +
        "FOR ID_TIPO_TERMINACION IN ( \n" +
"            1 AS FUERZA_MAYOR_TC, \n" +
"            2 AS INCAPACIDAD_FISICA_TC, \n" +
"            3 AS QUIEBRA_LEGAL_TC, \n" +
            "4 AS AGOTAMIENTO_MATERIA_TC \n" +
        ") \n" +
    ") \n" +
"), \n" +
"VIOLACIONES AS ( \n" +
"    SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
"            ID_EXPEDIENTE, \n" +
"            ID_ORGANOJ, \n" +
"            PERIODO, \n" +
"            ID_TIPO_VIOL_DH, \n" +
            "1 AS EXISTE_VIOL_DH \n" +
        "FROM TR_EXP_VIOLACION \n" +
"    ) \n" +
    "PIVOT ( \n" +
"        MAX(EXISTE_VIOL_DH) \n" +
        "FOR ID_TIPO_VIOL_DH IN ( \n" +
"            1 AS LIBERTAD_ASOCIACION, \n" +
"            2 AS LIBERTAD_SINDICAL, \n" +
"            3 AS DERECHO_COLECTIVA, \n" +
            "4 AS OTRO_COLECTIVA \n" +
        ") \n" +
    ") \n" +
"), \n" +
"ESPECIFIQUE_CONFLICTO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_CONFLICTO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '36' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ESPECIAL COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_CONFLICTO \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
"ESPECIFIQUE_VIOLACION AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_VIOLACION_DH' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '4' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ESPECIAL COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_COLECTIVA \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_TIPO_INCOMPETENCIA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_INCOMPETENCIA' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '4' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ESPECIAL COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_INCOMP \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_FORMA_SOLUCION AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_FORMA_SOLUCION' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ESPECIAL COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_FORMA_SOLUCION \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
") \n" +
"SELECT \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.FECHA_APERTURA_EXPEDIENTE, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_ASUNTO) AS TIPO_ASUNTO, \n" +
"    CONVER_V3_NAT_CONFLICTO(B.NAT_CONFLICTO) AS NAT_CONFLICTO, \n" +
"    CONVER_V3_SECTOR(B.SECTOR) AS SECTOR, \n" +
"    CONVER_V3_SUBSECTOR(B.SECTOR,B.SUBSECTOR) AS SUBSECTOR, \n" +
"    B.ENTIDAD_CLAVE, \n" +
"    B.ENTIDAD_NOMBRE, \n" +
"    B.MUNICIPIO_CLAVE, \n" +
"    B.MUNICIPIO_NOMBRE, \n" +
"    M.DECLARACION_PERDIDA_MAY, \n" +
"    M.SUSPENSION_TMP, \n" +
"    M.TERMINACION_TRAB, \n" +
"    M.CONTRATACION_COLECTIVA, \n" +
"    M.OMISIONES_REGLAMENTO, \n" +
"    M.REDUCCION_PERSONAL, \n" +
"    M.VIOLA_DERECHOS, \n" +
"    M.ELECCION_SINDICALES, \n" +
"    M.SANCION_SINDICALES, \n" +
"    M.OTRO_CONFLICTO, \n" +
"    EC.OTRO_ESP_CONFLICTO, \n" +
"    SUS.NO_IMPUTABLE_ST, \n" +
"    SUS.INCAPACIDAD_FISICA_ST, \n" +
"    SUS.FALTA_MATERIA_PRIM_ST, \n" +
"    SUS.FALTA_MINISTRACION_ST, \n" +
"    TER.FUERZA_MAYOR_TC, \n" +
"    TER.INCAPACIDAD_FISICA_TC, \n" +
"    TER.QUIEBRA_LEGAL_TC, \n" +
"    TER.AGOTAMIENTO_MATERIA_TC, \n" +
"    VIO.LIBERTAD_ASOCIACION, \n" +
"    VIO.LIBERTAD_SINDICAL, \n" +
"    VIO.DERECHO_COLECTIVA, \n" +
"    VIO.OTRO_COLECTIVA, \n" +
"    EV.OTRO_ESP_COLECTIVA, \n" +
"    CONVER_V3_GEN_NI_9(B.PREG_INCOMPETENCIA) AS PREG_INCOMPETENCIA, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_INCOMPETENCIA) AS TIPO_INCOMPETENCIA, \n" +
"    ETI.OTRO_ESP_INCOMP, \n" +
"    B.FECHA_PRES_DEMANDA, \n" +
"    CONVER_V3_GEN_NI_9(B.CONSTANCIA_CONS_EXPEDIDA) AS CONSTANCIA_CONS_EXPEDIDA, \n" +
"    B.CONSTANCIA_CLAVE, \n" +
"    CONVER_V3_GEN_NI_9(B.ASUN_EXCEP_CONCILIACION) AS ASUN_EXCEP_CONCILIACION, \n" +
"    CONVER_V3_GEN_NI_9(B.PREVE_DEMANDA) AS PREVE_DEMANDA, \n" +
"    CONVER_V3_GEN_NI_9(B.DESAHOGO_PREV_DEMANDA) AS DESAHOGO_PREV_DEMANDA, \n" +
"    CONVER_V3_GEN_NI_9(B.ESTATUS_DEMANDA) AS ESTATUS_DEMANDA, \n" +
"    B.FECHA_ADMISION_DEMANDA, \n" +
"    B.CANTIDAD_ACTORES, \n" +
"    B.CANTIDAD_DEMANDADOS, \n" +
"    CONVER_V3_GEN_NI_9(B.TRAMITACION_DEPURACION) AS TRAMITACION_DEPURACION, \n" +
"    B.FECHA_DEPURACION, \n" +
"    CONVER_V3_GEN_NI_9(B.AUDIENCIA_JUICIO) AS AUDIENCIA_JUICIO, \n" +
"    B.FECHA_AUDIENCIA_JUICIO,  \n" +
"    CONVER_V3_GEN_NI_9(B.ESTATUS_EXPEDIENTE) AS ESTATUS_EXPEDIENTE, \n" +
"    B.FECHA_ACTO_PROCESAL, \n" +
"    CONVER_V3_GEN_NI_99(B.FASE_SOLI_EXPEDIENTE) AS FASE_SOLI_EXPEDIENTE, \n" +
"    CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCION_AD) AS FORMA_SOLUCION_AD, \n" +
"    CASE WHEN B.FASE_SOLI_EXPEDIENTE = 3 THEN EFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS OTRO_ESP_SOLUCION_AD, \n" +
"    B.FECHA_DICTO_RESOLUCION_AD, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SENTENCIA_AD) AS TIPO_SENTENCIA_AD, \n" +
"    B.MONTO_SOLUCION_AD,  \n" +
"    CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCION_AJ) AS FORMA_SOLUCION_AJ, \n" +
"    CASE WHEN B.FASE_SOLI_EXPEDIENTE = 2 THEN EFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS OTRO_ESP_SOLUCION_AJ, \n" +
"    B.FECHA_RESOLUCION_AJ, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SENTENCIA_AJ) AS TIPO_SENTENCIA_AJ, \n" +
"    B.MONTO_SOLUCIÓN_AJ, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN MOTIVOS M  \n" +
"    ON M.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"    AND M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND M.PERIODO = B.PERIODO \n" +
"LEFT JOIN SUSPENCION SUS \n" +
"    ON SUS.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"    AND SUS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND SUS.PERIODO = B.PERIODO \n" +
"LEFT JOIN TERMINACION TER \n" +
"    ON TER.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"    AND TER.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND TER.PERIODO = B.PERIODO      \n" +
"LEFT JOIN VIOLACIONES VIO \n" +
"    ON VIO.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"    AND VIO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND VIO.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_CONFLICTO EC \n" +
"    ON EC.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND EC.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EC.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_VIOLACION EV \n" +
"    ON EV.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND EV.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EV.PERIODO = B.PERIODO    \n" +
"LEFT JOIN ESPECIFIQUE_TIPO_INCOMPETENCIA ETI \n" +
"    ON ETI.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ETI.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ETI.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_FORMA_SOLUCION EFS \n" +
"    ON EFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND EFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EFS.PERIODO = B.PERIODO    \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"')\n";

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        fila.add(resul.getString(34)); 
                        fila.add(resul.getString(35));
                        fila.add(resul.getString(36));
                        fila.add(resul.getString(37));
                        fila.add(resul.getString(38));
                        fila.add(resul.getString(39));
                        fila.add(resul.getString(40));
                        fila.add(resul.getString(41));
                        fila.add(resul.getString(42));
                        fila.add(resul.getString(43));
                        fila.add(resul.getString(44));
                        fila.add(resul.getString(45));
                        fila.add(resul.getString(46));
                        fila.add(resul.getString(47));
                        fila.add(resul.getString(48));
                        fila.add(resul.getString(49));
                        fila.add(resul.getString(50));
                        fila.add(resul.getString(51));
                        fila.add(resul.getString(52));
                        fila.add(resul.getString(53));
                        fila.add(resul.getString(54));
                        fila.add(resul.getString(55));
                        fila.add(resul.getString(56));
                        fila.add(resul.getString(57));
                        fila.add(resul.getString(58));
                        fila.add(resul.getString(59));
                        fila.add(resul.getString(60));
                        fila.add(resul.getString(61));
                        fila.add(resul.getString(62));
                        fila.add(resul.getString(63));
                        fila.add(resul.getString(64));
                        fila.add(resul.getString(65));
                        fila.add(resul.getString(66));
                        fila.add(resul.getString(67));
                        fila.add(resul.getString(68));
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_COLECTIVO" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }

public ArrayList<ArrayList<String>> V3_TR_PART_ACT_COLECTIVOJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT  \n" +
"    ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO,\n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    ACT.ID_ACTOR, \n" +
"    ACT.ID_TIPO_ACTOR AS ACTOR, \n" +
"    ACT.ID_DEFENSA AS DEFENSA_ACT, \n" +
"    ACT.NOMBRE_SINDICATO AS NOMBRE_SINDICATO, \n" +
"    ACT.REGISTRO_ASO_SINDICAL AS REG_ASOC_SINDICAL, \n" +
"    ACT.ID_TIPO_SINDICATO AS TIPO_SINDICATO, \n" +
"    ACT.PREG_SIND_PERT_ORG_O AS ORG_OBRERA, \n" +
"    ACT.ID_ORG_OBR AS NOMBRE_ORG_OBRERA, \n" +
"    ACT.TOTAL_TRAB_INVOL AS CANT_TRABAJA_INV, \n" +
"    ACT.CANT_TRAB_INVOL_H AS HOMBRES, \n" +
"    ACT.CANT_TRAB_INVOL_M AS MUJERES, \n" +
"    ACT.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO, \n" +
"    ACT.ID_TIPO_PATRON AS TIPO, \n" +
"    ACT.RFC AS RFC_PATRON, \n" +
"    ACT.RAZON_SOCIAL AS RAZON_SOCIAL_EMPR, \n" +
"    ACT.CALLE AS CALLE, \n" +
"    ACT.NUM_EXTERIOR AS N_EXT, \n" +
"    ACT.NUM_INTERIOR AS N_INT, \n" +
"    ACT.COLONIA AS COLONIA, \n" +
"    ACT.CP AS CP, \n" +
"    ACT.ID_ENT_MPIO AS ENTIDAD_NOMBRE_EMPR, \n" +
"    TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
"    TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
"    TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
"    ACT.LATITUD AS LATITUD_EMPR, \n" +
"    ACT.LONGITUD AS LONGITUD_EMPR, \n" +
"    ACT.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM TR_EXPEDIENTE EXP \n" +
"INNER JOIN TR_ORGANOJ ORG  \n" +
"    ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
    "AND EXP.PERIODO = ORG.PERIODO \n" +
"INNER JOIN TR_EXP_ACTOR TRAC  \n" +
"    ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
    "AND TRAC.PERIODO = EXP.PERIODO \n" +
"INNER JOIN TR_ACTOR ACT  \n" +
"    ON ACT.ID_ACTOR = TRAC.ACTORES_ID \n" +
"    AND ACT.ID_ORGANOJ = TRAC.ID_ORGANOJ \n" +
    "AND ACT.PERIODO = TRAC.PERIODO \n" +
"LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
    "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
"WHERE EXP.ID_TIPO_EXPEDIENTE = 3 \n" +
"), \n" +
"ESPECIFIQUE_SINDICATO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_SINDICATO \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
"),  \n" +
"ESPECIFIQUE_OBRERA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_OBRERA \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
") \n" +
"SELECT  \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.ID_ACTOR, \n" +
"    B.ACTOR, \n" +
"    B.DEFENSA_ACT, \n" +
"    B.NOMBRE_SINDICATO, \n" +
"    B.REG_ASOC_SINDICAL, \n" +
"    B.TIPO_SINDICATO, \n" +
"    ESFS.OTRO_ESP_SINDICATO, \n" +
"    B.ORG_OBRERA, \n" +
"    B.NOMBRE_ORG_OBRERA, \n" +
"    ESO.OTRO_ESP_OBRERA, \n" +
"    B.CANT_TRABAJA_INV, \n" +
"    B.HOMBRES, \n" +
"    B.MUJERES, \n" +
"    B.NO_IDENTIFICADO, \n" +
"    B.TIPO, \n" +
"    B.RFC_PATRON, \n" +
"    B.RAZON_SOCIAL_EMPR, \n" +
"    B.CALLE, \n" +
"    B.N_EXT, \n" +
"    B.N_INT, \n" +
"    B.COLONIA, \n" +
"    B.CP, \n" +
"    B.ENTIDAD_NOMBRE_EMPR, \n" +
"    B.ENTIDAD_CLAVE, \n" +
"    B.MUNICIPIO_NOMBRE, \n" +
"    B.MUNICIPIO_CLAVE, \n" +
"    B.LATITUD_EMPR, \n" +
"    B.LONGITUD_EMPR, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN ESPECIFIQUE_SINDICATO ESFS \n" +
"    ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESFS.PERIODO = B.PERIODO \n" +
    "AND ESFS.ID_ACT_DEM_AUD=B.ID_ACTOR \n" +
"LEFT JOIN ESPECIFIQUE_OBRERA ESO \n" +
"    ON ESO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESO.PERIODO = B.PERIODO    \n" +
    "AND ESO.ID_ACT_DEM_AUD=B.ID_ACTOR \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;
try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33));
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }

public ArrayList<ArrayList<String>>  V3_TR_PART_DEM_COLECTIVOJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT  \n" +
"    ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    DEM.ID_DEMANDADO, \n" +
"    DEM.ID_TIPO_DEMANDADO AS DEMANDADO, \n" +
"    DEM.ID_DEFENSA AS DEFENSA_DEM, \n" +
"    DEM.NOMBRE_SINDICATO AS NOMBRE_SINDICATO_DEM, \n" +
"    DEM.REG_ASOC_SINDICATO AS REG_ASOC_SINDICAL_DEM, \n" +
"    DEM.ID_TIPO_SINDICATO AS TIPO_SINDICATO_DEM, \n" +
"    DEM.PREG_SIND_PERT_ORG_OBR AS ORG_OBRERA_DEM, \n" +
"    DEM.ID_ORG_OBR AS NOMBRE_ORG_OBRERA_DEM, \n" +
"    DEM.TRAB_INVOL_TOT AS CANT_TRABAJA_INV_DEM, \n" +
"    DEM.CANT_TRAB_INVOL_H AS HOMBRES_DEM, \n" +
"    DEM.CANT_TRAB_INVOL_M AS MUJERES_DEM, \n" +
"    DEM.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO_DEM, \n" +
"    DEM.ID_TIPO_PATRON AS TIPO_DEM_PAT, \n" +
"    DEM.RFC AS RFC_PATRON_DEM, \n" +
"    DEM.RAZON_SOCIAL AS RAZON_SOCIAL_EMPR_DEM, \n" +
"    DEM.CALLE AS CALLE, \n" +
"    DEM.NUM_EXTERIOR AS N_EXT, \n" +
"    DEM.NUM_INTERIOR AS N_INT, \n" +
"    DEM.COLONIA AS COLONIA, \n" +
"    DEM.CP AS CP, \n" +
"    DEM.ID_ENT_MPIO AS ENTIDAD_NOMBRE_EMPR, \n" +
"    TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
"    TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
"    TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
"    DEM.LATITUD AS LATITUD_EMPR, \n" +
"    DEM.LONGITUD AS LONGITUD_EMPR, \n" +
"    DEM.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM TR_EXPEDIENTE EXP \n" +
"INNER JOIN TR_ORGANOJ ORG  \n" +
"    ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
    "AND EXP.PERIODO = ORG.PERIODO \n" +
"INNER JOIN TR_EXP_DEMANDADO TRDEM \n" +
"    ON TRDEM.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"    AND TRDEM.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
    "AND TRDEM.PERIODO = EXP.PERIODO \n" +
"INNER JOIN TR_DEMANDADO DEM  \n" +
"    ON DEM.ID_DEMANDADO = TRDEM.ID_DEMANDADO \n" +
"    AND DEM.ID_ORGANOJ = TRDEM.ID_ORGANOJ \n" +
    "AND DEM.PERIODO = TRDEM.PERIODO \n" +
"LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
    "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
"WHERE EXP.ID_TIPO_EXPEDIENTE = 3 \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_SINDICATO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='DEMANDADO COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_SINDICATO_DEM \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
"),  \n" +
"ESPECIFIQUE_OBRERA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='DEMANDADO COLECTIVO' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_OBRERA_DEM \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
") \n" +
"SELECT  \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.ID_DEMANDADO, \n" +
"    CONVER_V3_GEN_NI_9(B.DEMANDADO) AS DEMANDADO, \n" +
"    CONVER_V3_GEN_NI_9(B.DEFENSA_DEM) AS DEFENSA_DEM, \n" +
"    B.NOMBRE_SINDICATO_DEM, \n" +
"    B.REG_ASOC_SINDICAL_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SINDICATO_DEM) AS TIPO_SINDICATO_DEM, \n" +
"    ESFS.OTRO_ESP_SINDICATO_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.ORG_OBRERA_DEM) AS ORG_OBRERA_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.NOMBRE_ORG_OBRERA_DEM) AS NOMBRE_ORG_OBRERA_DEM, \n" +
"    ESO.OTRO_ESP_OBRERA_DEM, \n" +
"    B.CANT_TRABAJA_INV_DEM, \n" +
"    B.HOMBRES_DEM, \n" +
"    B.MUJERES_DEM, \n" +
"    B.NO_IDENTIFICADO_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_DEM_PAT) AS TIPO_DEM_PAT, \n" +
"    B.RFC_PATRON_DEM, \n" +
"    B.RAZON_SOCIAL_EMPR_DEM, \n" +
"    B.CALLE, \n" +
"    B.N_EXT, \n" +
"    B.N_INT, \n" +
"    B.COLONIA, \n" +
"    B.CP, \n" +
"    B.ENTIDAD_NOMBRE_EMPR, \n" +
"    B.ENTIDAD_CLAVE, \n" +
"    B.MUNICIPIO_NOMBRE, \n" +
"    B.MUNICIPIO_CLAVE, \n" +
"    B.LATITUD_EMPR, \n" +
"    B.LONGITUD_EMPR, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN ESPECIFIQUE_SINDICATO ESFS \n" +
"    ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESFS.PERIODO = B.PERIODO \n" +
    "AND ESFS.ID_ACT_DEM_AUD=B.DEMANDADO \n" +
"LEFT JOIN ESPECIFIQUE_OBRERA ESO \n" +
"    ON ESO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESO.PERIODO = B.PERIODO  \n" +
    "AND ESO.ID_ACT_DEM_AUD=B.DEMANDADO \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;


                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_DEM_COLECTIVOJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }









public ArrayList<ArrayList<String>>  V3_TR_HUELGAJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT  \n" +
"        EXP.ID_EXPEDIENTE, \n" +
"        EXP.PERIODO, \n" +
"        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"        EXP.FECHA_APERTURA_EXPED AS FECHA_APERTURA_EXPEDIENTE, \n" +
"        EXP.ID_TIPO_ASUNTO AS TIPO_ASUNTO, \n" +
"        EXP.RAMA_INVOLUC AS RAMA_INDUS_INVOLUCRADA, \n" +
"        TC_SEC.SECTOR AS SECTOR_RAMA, \n" +
"        TC_SEC.SUBSECTOR AS SUBSECTOR_RAMA, \n" +
"        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
"        TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE, \n" +
"        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
"        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE,  \n" +
"        EXP.PREG_INCOMPETENCIA, \n" +
"        EXP.ID_TIPO_INCOMPETENCIA AS TIPO_INCOMPETENCIA, \n" +
"        EXP.FECHA_PLIEGO_PETICION AS FECHA_PRESENTA_PETIC, \n" +
"        EXP.CANT_ACTORES AS CANTIDAD_ACTORES, \n" +
"        EXP.CANT_DEMANDADOS AS CANTIDAD_DEMANDADOS, \n" +
"        EXP.PREG_HUELGA_EMPLAZAM AS EMPLAZAMIENTO_HUELGA, \n" +
"        EXP.FECHA_HUELGA_EMPLAZAM AS FECHA_EMPLAZAMIENTO, \n" +
"        EXP.PREG_PREHUELGA AS PREHUELGA, \n" +
"        EXP.PREG_AUDIENCIA_CONCIL AS AUDIENCIA_CONCILIACION, \n" +
"        EXP.FECHA_AUDIENCIA_CONCIL AS FECHA_AUDIENCIA, \n" +
"        EXP.PREG_HUELGA_ESTALLA AS ESTALLAMIENTO_HUELGA, \n" +
"        EXP.ID_HUELGA_LICITUD AS DECLARA_LICITUD_HUELGA, \n" +
"        EXP.ID_HUELGA_EXISTENCIA AS DECLARA_EXISTEN_HUELGA, \n" +
"        EXP.ID_ESTATUS_EXPED AS ESTATUS_EXPEDIENTE, \n" +
"        EXP.FECHA_ULT_ACT_PROC AS FECHA_ACTO_PROCESAL, \n" +
"        EXP.ID_FASE_SOL_EXPED AS FASE_SOLI_EXPEDIENTE, \n" +
"        CASE WHEN EXP.ID_FASE_SOL_EXPED=5 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCION_EMPLAZ, \n" +
"        CASE WHEN EXP.ID_FASE_SOL_EXPED=5 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_RESOLU_EMPLAZ, \n" +
"        EXP.PORCENT_SOLICITADO AS INCREMENTO_SOLICITADO, \n" +
"        EXP.PORCENT_OTORGADO AS INCREMENTO_OTORGADO, \n" +
"        CASE WHEN EXP.ID_FASE_SOL_EXPED=7 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCION_HUELGA, \n" +
"        CASE WHEN EXP.ID_FASE_SOL_EXPED=7 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_RESOLU_HUELGA, \n" +
"        CASE WHEN EXP.ID_FASE_SOL_EXPED=7 THEN EXP.ID_TIPO_SENTENCIA ELSE NULL END AS TIPO_SENTENCIA, \n" +
"        EXP.FECHA_HUELGA_ESTALLA AS FECHA_ESTALLAM_HUELGA, \n" +
"        EXP.FECHA_HUELGA_LEVANTAM AS FECHA_LEVANT_HUELGA, \n" +
"        EXP.HUELGA_DIAS AS DIAS_HUELGA, \n" +
"        EXP.MONTO_SOLUCION AS MONTO_ESTIPULADO, \n" +
"        EXP.PORCENT_SALARIOS_CAIDOS AS SALARIOS_CAIDOS, \n" +
        "EXP.COMENTARIOS    \n" +
"    FROM TR_EXPEDIENTE EXP  \n" +
    "INNER JOIN TR_ORGANOJ ORG \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TC_SECTOR_SBSTOR TC_SEC \n" +
        "ON TC_SEC.ID_SECTOR_SBSTOR = EXP.ID_SECTOR_SBTOR \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 4 \n" +
"), \n" +
" \n" +
"MOTIVO_HUELGA AS ( \n" +
"    SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
"            ID_EXPEDIENTE, \n" +
"            ID_ORGANOJ, \n" +
"            PERIODO, \n" +
"            ID_HUELGA_MOTIVO, \n" +
            "1 AS EXISTE_MOTIVO \n" +
        "FROM TR_EXP_MOTIVO_HUELGA \n" +
"    ) \n" +
    "PIVOT ( \n" +
"        MAX(EXISTE_MOTIVO) \n" +
        "FOR ID_HUELGA_MOTIVO IN ( \n" +
"            1 AS FIRMA_CONTRATO, \n" +
"            2 AS REVISION_CONTRATO, \n" +
"            3 AS INCUMPLIM_CONTRATO, \n" +
"            4 AS REVISION_SALARIO, \n" +
"            5 AS REPARTO_UTILIDADES, \n" +
"            6 AS APOYO_OTRA_HUELGA, \n" +
"            7 AS DESEQUILIBRIO_FAC_PROD, \n" +
            "8 AS OTRO_MOTIVO \n" +
        ") \n" +
    ") \n" +
"), \n" +
"ESPECIFIQUE_MOTIVO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_HUELGA' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='HUELGA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS ESPECIFIQUE_MOTIVO \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"),ESPECIFIQUE_TIPO_INCOMPETENCIA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_INCOMPETENCIA' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '4' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='HUELGA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_INCOMPETENCIA \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"),ESPECIFIQUE_FORMA_SOLUCION AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_FORMA_SOLUCION' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='HUELGA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS OTRO_ESP_FORMA_SOLUCION \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
") \n" +
"SELECT \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.FECHA_APERTURA_EXPEDIENTE, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_ASUNTO) AS TIPO_ASUNTO, \n" +
"    B.RAMA_INDUS_INVOLUCRADA, \n" +
"    CONVER_V3_SECTOR(B.SECTOR_RAMA) AS SECTOR_RAMA, \n" +
"    CONVER_V3_SUBSECTOR(B.SECTOR_RAMA,B.SUBSECTOR_RAMA) AS SUBSECTOR_RAMA, \n" +
"    B.ENTIDAD_CLAVE, \n" +
"    B.ENTIDAD_NOMBRE, \n" +
"    B.MUNICIPIO_CLAVE, \n" +
"    B.MUNICIPIO_NOMBRE, \n" +
"    M.FIRMA_CONTRATO, \n" +
"    M.REVISION_CONTRATO, \n" +
"    M.INCUMPLIM_CONTRATO, \n" +
"    M.REVISION_SALARIO, \n" +
"    M.REPARTO_UTILIDADES, \n" +
"    M.APOYO_OTRA_HUELGA, \n" +
"    M.DESEQUILIBRIO_FAC_PROD, \n" +
"    M.OTRO_MOTIVO, \n" +
"    E.ESPECIFIQUE_MOTIVO, \n" +
"    CONVER_V3_GEN_NI_9(B.PREG_INCOMPETENCIA) AS INCOMPETENCIA, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_INCOMPETENCIA) AS TIPO_INCOMPETENCIA, \n" +
"    ETINCOM.OTRO_ESP_INCOMPETENCIA, \n" +
"    B.FECHA_PRESENTA_PETIC, \n" +
"    B.CANTIDAD_ACTORES, \n" +
"    B.CANTIDAD_DEMANDADOS, \n" +
"    CONVER_V3_GEN_NI_9(B.EMPLAZAMIENTO_HUELGA) AS EMPLAZAMIENTO_HUELGA, \n" +
"    B.FECHA_EMPLAZAMIENTO, \n" +
"    CONVER_V3_GEN_NI_9(B.PREHUELGA) AS PREHUELGA, \n" +
"    CONVER_V3_GEN_NI_9(B.AUDIENCIA_CONCILIACION) AS AUDIENCIA_CONCILIACION, \n" +
"    B.FECHA_AUDIENCIA, \n" +
"    CONVER_V3_GEN_NI_9(B.ESTALLAMIENTO_HUELGA) AS ESTALLAMIENTO_HUELGA, \n" +
"    CONVER_V3_GEN_NI_9(B.DECLARA_LICITUD_HUELGA) AS DECLARA_LICITUD_HUELGA, \n" +
"    CONVER_V3_GEN_NI_9(B.DECLARA_EXISTEN_HUELGA) AS DECLARA_EXISTEN_HUELGA, \n" +
"    CONVER_V3_GEN_NI_9(B.ESTATUS_EXPEDIENTE) AS ESTATUS_EXPEDIENTE, \n" +
"    B.FECHA_ACTO_PROCESAL, \n" +
"    CONVER_V3_GEN_NI_99(B.FASE_SOLI_EXPEDIENTE) AS FASE_SOLI_EXPEDIENTE, \n" +
"    CONVER_V3_GEN_NI_9(B.FORMA_SOLUCION_EMPLAZ) AS FORMA_SOLUCION_EMPLAZ, \n" +
"    CASE WHEN B.FASE_SOLI_EXPEDIENTE=5 THEN ESFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS ESPECIFI_FORMA_EMPLAZ, \n" +
"    B.FECHA_RESOLU_EMPLAZ, \n" +
"    B.INCREMENTO_SOLICITADO, \n" +
"    B.INCREMENTO_OTORGADO, \n" +
"    CONVER_V3_GEN_NI_9(B.FORMA_SOLUCION_HUELGA) AS FORMA_SOLUCION_HUELGA, \n" +
"    CASE WHEN B.FASE_SOLI_EXPEDIENTE=7 THEN ESFS.OTRO_ESP_FORMA_SOLUCION ELSE NULL END AS ESPECIFI_FORMA_HUELGA, \n" +
"    B.FECHA_RESOLU_HUELGA, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SENTENCIA) AS TIPO_SENTENCIA, \n" +
"    B.FECHA_ESTALLAM_HUELGA, \n" +
"    B.FECHA_LEVANT_HUELGA, \n" +
"    B.DIAS_HUELGA, \n" +
"    B.MONTO_ESTIPULADO, \n" +
"    B.SALARIOS_CAIDOS, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN MOTIVO_HUELGA M  \n" +
"    ON M.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"    AND M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND M.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_MOTIVO E \n" +
"    ON E.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND E.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND E.PERIODO = B.PERIODO \n" +
"    LEFT JOIN ESPECIFIQUE_TIPO_INCOMPETENCIA ETINCOM \n" +
"    ON ETINCOM.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ETINCOM.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ETINCOM.PERIODO = B.PERIODO \n" +
     "LEFT JOIN ESPECIFIQUE_FORMA_SOLUCION ESFS \n" +
"    ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESFS.PERIODO = B.PERIODO \n" +
    "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;



                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();

                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        fila.add(resul.getString(34)); 
                        fila.add(resul.getString(35));
                        fila.add(resul.getString(36));
                        fila.add(resul.getString(37));
                        fila.add(resul.getString(38));
                        fila.add(resul.getString(39));
                        fila.add(resul.getString(40));
                        fila.add(resul.getString(41));
                        fila.add(resul.getString(42));
                        fila.add(resul.getString(43));
                        fila.add(resul.getString(44));
                        fila.add(resul.getString(45));
                        fila.add(resul.getString(46));
                        fila.add(resul.getString(47));
                        fila.add(resul.getString(48));
                        fila.add(resul.getString(49));
                        fila.add(resul.getString(50));
                        fila.add(resul.getString(51));
                        fila.add(resul.getString(52));
                        fila.add(resul.getString(53));
                        fila.add(resul.getString(54)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_HUELGAJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }

   public ArrayList<ArrayList<String>>  V3_TR_PART_ACT_HUELGAJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT \n" +
"    ORG.NOMBRE_ORGANOJ   AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    ACT.ID_ACTOR, \n" +
"    ACT.ID_TIPO_ACTOR    AS ACTOR, \n" +
"    ACT.ID_DEFENSA       AS DEFENSA_ACT, \n" +
"    ACT.NOMBRE_SINDICATO AS NOMBRE_SINDICATO, \n" +
"    ACT.REGISTRO_ASO_SINDICAL AS REG_ASOC_SINDICAL, \n" +
"    ACT.ID_TIPO_SINDICATO AS TIPO_SINDICATO, \n" +
"    ACT.PREG_SIND_PERT_ORG_O AS ORG_OBRERA, \n" +
"    ACT.ID_ORG_OBR AS NOMBRE_ORG_OBRERA, \n" +
"    ACT.TOTAL_TRAB_INVOL AS CANT_TRABAJA_INV, \n" +
"    ACT.CANT_TRAB_INVOL_H AS HOMBRES, \n" +
"    ACT.CANT_TRAB_INVOL_M AS MUJERES, \n" +
"    ACT.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO, \n" +
"    ACT.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM \n" +
         "TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ   ORG ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
                                 "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TR_EXP_ACTOR TRAC ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"                                    AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
                                    "AND EXP.PERIODO = TRAC.PERIODO \n" +
    "INNER JOIN TR_ACTOR     ACT ON ACT.ID_ACTOR = TRAC.ACTORES_ID \n" +
"                               AND TRAC.ID_ORGANOJ = ACT.ID_ORGANOJ \n" +
                               "AND ACT.PERIODO = TRAC.PERIODO \n" +
  "WHERE EXP.ID_TIPO_EXPEDIENTE=4                               \n" +
" \n" +
"),  \n" +
"ESPECIFIQUE_SINDICATO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR HUELGA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_SINDICATO \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD \n" +
        "),  \n" +
"ESPECIFIQUE_OBRERA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='ACTOR HUELGA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
          ") AS OTRO_ESP_OBRERA \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD \n" +
        ") \n" +
"SELECT  \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.ID_ACTOR, \n" +
"    CONVER_V3_GEN_NI_99(B.ACTOR) AS ACTOR, \n" +
"    CONVER_V3_GEN_NI_9(B.DEFENSA_ACT) AS DEFENSA_ACT, \n" +
"    B.NOMBRE_SINDICATO, \n" +
"    B.REG_ASOC_SINDICAL, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SINDICATO) AS TIPO_SINDICATO, \n" +
"    ESFS.OTRO_ESP_SINDICATO, \n" +
"    CONVER_V3_GEN_NI_9(B.ORG_OBRERA) AS ORG_OBRERA, \n" +
"    CONVER_V3_GEN_NI_9(B.NOMBRE_ORG_OBRERA) AS NOMBRE_ORG_OBRERA, \n" +
"    ESO.OTRO_ESP_OBRERA, \n" +
"    B.CANT_TRABAJA_INV, \n" +
"    B.HOMBRES, \n" +
"    B.MUJERES, \n" +
"    B.NO_IDENTIFICADO, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN ESPECIFIQUE_SINDICATO ESFS \n" +
"    ON ESFS.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESFS.PERIODO = B.PERIODO \n" +
    "AND ESFS.ID_ACT_DEM_AUD = B.ID_ACTOR \n" +
"LEFT JOIN ESPECIFIQUE_OBRERA ESO \n" +
"    ON ESO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ESO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ESO.PERIODO = B.PERIODO   \n" +
    "AND ESO.ID_ACT_DEM_AUD = B.ID_ACTOR \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"')";

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_INDIVIDUAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }


    public ArrayList<ArrayList<String>>  V3_TR_PART_DEM_HUELGAJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT \n" +
"    ORG.NOMBRE_ORGANOJ   AS NOMBRE_ORGANO_JURIS, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"    DEM.ID_DEMANDADO, \n" +
"    DEM.ID_TIPO_DEMANDADO   AS DEMANDADO, \n" +
"    DEM.ID_DEFENSA       AS DEFENSA_DEM, \n" +
"    DEM.ID_TIPO_PATRON          AS TIPO, \n" +
"    DEM.RFC AS RFC_PATRON, \n" +
"    DEM.RAZON_SOCIAL             AS RAZON_SOCIAL_EMPR, \n" +
"    DEM.CALLE, \n" +
"    DEM.NUM_EXTERIOR              AS N_EXT, \n" +
"    DEM.NUM_INTERIOR             AS N_INT, \n" +
"    DEM.COLONIA              , \n" +
"    DEM.CP       , \n" +
"    TCMPIO.ENTIDAD AS ENTIDAD_NOMBRE_EMPR, \n" +
"    TCMPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE_EMPR, \n" +
"    TCMPIO.MUNICIPIO AS MUNICIPIO_NOMBRE_EMPR, \n" +
"    TCMPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE_EMPR, \n" +
"    DEM.LATITUD AS LATITUD_EMPR ,  \n" +
"    DEM.LONGITUD AS LONGITUD_EMPR,   \n" +
"    DEM.COMENTARIOS, \n" +
    "EXP.PERIODO \n" +
"FROM \n" +
         "TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ   ORG  \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TR_EXP_DEMANDADO TRAC  \n" +
"        ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"        AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = TRAC.PERIODO \n" +
    "INNER JOIN TR_DEMANDADO DEM  \n" +
"        ON DEM.ID_DEMANDADO = TRAC.ID_DEMANDADO \n" +
"        AND TRAC.ID_ORGANOJ = DEM.ID_ORGANOJ \n" +
        "AND DEM.PERIODO = TRAC.PERIODO \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TCMPIO  \n" +
        "ON TCMPIO.ID_ENT_MPIO=DEM.ID_ENT_MPIO \n" +
  "WHERE EXP.ID_TIPO_EXPEDIENTE=4                              \n" +
    ") \n" +
"SELECT  \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.ID_DEMANDADO, \n" +
"    CONVER_V3_GEN_NI_9(B.DEMANDADO) AS DEMANDADO, \n" +
"    CONVER_V3_GEN_NI_9(B.DEFENSA_DEM) AS DEFENSA_DEM, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO) AS TIPO, \n" +
"    B.RFC_PATRON, \n" +
"    B.RAZON_SOCIAL_EMPR, \n" +
"    B.CALLE, \n" +
"    B.N_EXT, \n" +
"    B.N_INT, \n" +
"    B.COLONIA              , \n" +
"    B.CP       , \n" +
"    B.ENTIDAD_NOMBRE_EMPR, \n" +
"    B.ENTIDAD_CLAVE_EMPR, \n" +
"    B.MUNICIPIO_NOMBRE_EMPR, \n" +
"    B.MUNICIPIO_CLAVE_EMPR, \n" +
"    B.LATITUD_EMPR ,  \n" +
"    B.LONGITUD_EMPR,   \n" +
"    B.COMENTARIOS, \n" +
"    B.PERIODO \n" +
"    FROM BASE B \n" +
    "WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_DEM_HUELGAJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    public ArrayList<ArrayList<String>>  V3_TR_COLECT_ECONOMJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
"SELECT  \n" +
    "EXP.ID_EXPEDIENTE, \n" +
    "EXP.PERIODO, \n" +
    "ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
    "POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
    "EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
    "EXP.FECHA_APERTURA_EXPED AS FECHA_APERTURA_EXPEDIENTE, \n" +
    "EXP.ID_TIPO_ASUNTO AS TIPO_ASUNTO, \n" +
    "EXP.ID_NAT_CONFLICTO AS NAT_CONFLICTO, \n" +
    "EXP.RAMA_INVOLUC AS RAMA_INDUS_INVOLUCRADA, \n" +
    "TC_SEC.SECTOR AS SECTOR_RAMA, \n" +
    "TC_SEC.SUBSECTOR AS SUBSECTOR_RAMA, \n" +
    "TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE, \n" +
    "TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE, \n" +
    "TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE, \n" +
    "TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE, \n" +
    "EXP.PREG_INCOMPETENCIA AS INCOMPETENCIA, \n" +
    "EXP.ID_TIPO_INCOMPETENCIA AS TIPO_INCOMPETENCIA, \n" +
    "EXP.FECHA_PRESENT_DEMANDA AS FECHA_PRES_DEMANDA, \n" +
    "EXP.PREG_CONST_CONCILIAC AS CONSTANCIA_CONS_EXPEDIDA, \n" +
    "EXP.CLAVE_CONST_CONCILIAC AS CONSTANCIA_CLAVE, \n" +
    "EXP.PREG_ASUNTO_VINC_CONCIL_P AS ASUN_EXCEP_CONCILIACION, \n" +
    "EXP.PREG_FORMULO_DEMANDA AS PREVE_DEMANDA, \n" +
    "EXP.PREG_DESAHOGO_DEMANDA AS DESAHOGO_PREV_DEMANDA, \n" +
    "EXP.ID_ESTATUS_DEMANDA AS ESTATUS_DEMANDA, \n" +
    "EXP.FECHA_ADM_DEMANDA AS FECHA_ADMISION_DEMANDA, \n" +
    "EXP.CANT_ACTORES AS CANTIDAD_ACTORES, \n" +
    "EXP.CANT_DEMANDADOS AS CANTIDAD_DEMANDADOS, \n" +
    "EXP.PREG_AUDIENCIA_COL_NAT_ECO AS AUDIENCIA_ECONOM, \n" +
    "EXP.FECHA_AUDIENCIA_COL_NAT_ECO AS FECHA_AUDIENCIA_ECONOM, \n" +
    "EXP.ID_ESTATUS_EXPED AS ESTATUS_EXPEDIENTE, \n" +
    "EXP.FECHA_ULT_ACT_PROC AS FECHA_ACTO_PROCESAL, \n" +
    "EXP.ID_FASE_SOL_EXPED AS FASE_SOLI_EXPEDIENTE, \n" +
    "CASE WHEN EXP.ID_FASE_SOL_EXPED = 8 THEN EXP.ID_FORMA_SOLUCION ELSE NULL END AS FORMA_SOLUCION, \n" +
    "CASE WHEN EXP.ID_FASE_SOL_EXPED = 8 THEN EXP.FECHA_DICTO_SOLUCION ELSE NULL END AS FECHA_RESOLUCION, \n" +
    "CASE WHEN EXP.ID_FASE_SOL_EXPED = 8 THEN EXP.ID_TIPO_SENTENCIA ELSE NULL END AS TIPO_SENTENCIA, \n" +
    "EXP.COMENTARIOS \n" +
"FROM TR_EXPEDIENTE EXP  \n" +
    "INNER JOIN TR_ORGANOJ ORG \n" +
        "ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TC_SECTOR_SBSTOR TC_SEC \n" +
        "ON TC_SEC.ID_SECTOR_SBSTOR = EXP.ID_SECTOR_SBTOR \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 5 \n" +
"), \n" +
" \n" +
"MOTIVOS AS ( \n" +
"SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_MOTIVO_CONFLICTO, \n" +
            "1 AS EXISTE_MOTIVO \n" +
        "FROM TR_EXP_MOTIVO_CONF \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_MOTIVO) \n" +
        "FOR ID_MOTIVO_CONFLICTO IN ( \n" +
            "37 AS MODIF_CONDICIONES, \n" +
            "38 AS NUEVAS_CONDICIONES, \n" +
            "39 AS SUSPENSION_TEMPORAL, \n" +
            "40 AS TERMINACION_COLECTIVA, \n" +
            "41 AS OTRO_MOTIVO_ECONOM \n" +
        ") \n" +
    ") \n" +
"), \n" +
" \n" +
"SUSPENCION AS ( \n" +
"SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_TIPO_SUSPENSION, \n" +
            "1 AS EXISTE_TIPO_SUSPENSION \n" +
        "FROM TR_EXP_SUSPENSION \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_TIPO_SUSPENSION) \n" +
        "FOR ID_TIPO_SUSPENSION IN ( \n" +
            "5 AS EXCESO_PRODUCCION, \n" +
            "6 AS INCOSTEABILIDAD, \n" +
            "7 AS FALTA_FONDOS \n" +
        ") \n" +
    ") \n" +
"), \n" +
"EFECTO_SENTENCIA AS (   \n" +
"SELECT * \n" +
    "FROM ( \n" +
        "SELECT  \n" +
            "ID_EXPEDIENTE, \n" +
            "ID_ORGANOJ, \n" +
            "PERIODO, \n" +
            "ID_EFECTO_SENTENCIA, \n" +
            "1 AS EXISTE_EFECTO_SENTENCIA \n" +
        "FROM TR_EXP_EFECTOS_SENTENCIA \n" +
    ") \n" +
    "PIVOT ( \n" +
        "MAX(EXISTE_EFECTO_SENTENCIA) \n" +
        "FOR ID_EFECTO_SENTENCIA IN ( \n" +
            "1 AS AUMENTO_PERSONAL, \n" +
            "2 AS DISMINUCION_PERSONAL, \n" +
            "3 AS AUMENTO_JORNADALAB, \n" +
            "4 AS DISMINUCION_JORNADALAB, \n" +
            "5 AS AUMENTO_SEMANA, \n" +
            "6 AS DISMINUCION_SEMANA, \n" +
            "7 AS AUMENTO_SALARIOS,  \n" +
            "8 AS DISMINUCION_SALARIOS,  \n" +
            "9 AS OTRO_TIPO \n" +
        ") \n" +
    ") \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_MOTIVOS AS ( \n" +
"SELECT \n" +
    "CLAVE_EXPEDIENTE, \n" +
    "ORGANO AS ID_ORGANOJ, \n" +
    "PERIODO, \n" +
    "MAX( \n" +
        "CASE  \n" +
            "WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_CONFLICTO' \n" +
            "AND ID_OTRO_ESPECIFIQUE = '41' \n" +
            "AND TRIM(UPPER(PROCEDIMIENTO)) = 'COLECTIVO DE NATURALEZA ECONÃ“MICA' \n" +
            "THEN ESPECIFIQUE \n" +
        "END \n" +
    ") AS ESPECIFIQUE_ECONOM \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_INCOMPETENCIA AS ( \n" +
"SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_INCOMPETENCIA' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '4' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='COLECTIVO DE NATURALEZA ECONÃ“MICA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS ESPECIFIQUE_INCOMP \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
" \n" +
"ESPECIFIQUE_FORMA_SOLUCION AS ( \n" +
    "SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_FORMA_SOLUCION' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='COLECTIVO DE NATURALEZA ECONÃ“MICA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS ESPECIFIQUE_FORMA \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
"ESPECIFIQUE_SENTENCIA AS ( \n" +
"SELECT \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO AS ID_ORGANOJ, \n" +
        "PERIODO, \n" +
        "MAX( \n" +
            "CASE  \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_SENTENCIA_EFECTO' \n" +
                 "AND ID_OTRO_ESPECIFIQUE = '9' \n" +
                 "AND TRIM(UPPER(PROCEDIMIENTO))='COLECTIVO DE NATURALEZA ECONÃ“MICA' \n" +
                "THEN ESPECIFIQUE \n" +
            "END \n" +
        ") AS ESPECIFIQUE_TIPO \n" +
    "FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
        "CLAVE_EXPEDIENTE, \n" +
        "ORGANO, \n" +
        "PERIODO \n" +
") \n" +
"SELECT  \n" +
    "B.NOMBRE_ORGANO_JURIS, \n" +
    "B.CLAVE_ORGANO, \n" +
    "B.EXPEDIENTE_CLAVE, \n" +
    "B.FECHA_APERTURA_EXPEDIENTE, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_ASUNTO) AS TIPO_ASUNTO, \n" +
    "CONVER_V3_GEN_NI_9(B.NAT_CONFLICTO) AS NAT_CONFLICTO, \n" +
    "B.RAMA_INDUS_INVOLUCRADA, \n" +
    "CONVER_V3_SECTOR(B.SECTOR_RAMA) AS SECTOR_RAMA, \n" +
    "CONVER_V3_SUBSECTOR(B.SECTOR_RAMA,B.SUBSECTOR_RAMA) AS SUBSECTOR_RAMA, \n" +
    "B.ENTIDAD_CLAVE, \n" +
    "B.ENTIDAD_NOMBRE, \n" +
    "B.MUNICIPIO_CLAVE, \n" +
    "B.MUNICIPIO_NOMBRE, \n" +
    "M.MODIF_CONDICIONES, \n" +
    "M.NUEVAS_CONDICIONES, \n" +
    "M.SUSPENSION_TEMPORAL, \n" +
    "M.TERMINACION_COLECTIVA, \n" +
    "M.OTRO_MOTIVO_ECONOM, \n" +
    "EM.ESPECIFIQUE_ECONOM, \n" +
    "S.EXCESO_PRODUCCION, \n" +
    "S.INCOSTEABILIDAD, \n" +
    "S.FALTA_FONDOS, \n" +
    "CONVER_V3_GEN_NI_9(B.INCOMPETENCIA) AS INCOMPETENCIA, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_INCOMPETENCIA) AS TIPO_INCOMPETENCIA, \n" +
    "EI.ESPECIFIQUE_INCOMP, \n" +
    "B.FECHA_PRES_DEMANDA, \n" +
    "CONVER_V3_GEN_NI_9(B.CONSTANCIA_CONS_EXPEDIDA) AS CONSTANCIA_CONS_EXPEDIDA, \n" +
    "B.CONSTANCIA_CLAVE, \n" +
    "CONVER_V3_GEN_NI_9(B.ASUN_EXCEP_CONCILIACION) AS ASUN_EXCEP_CONCILIACION, \n" +
    "CONVER_V3_GEN_NI_9(B.PREVE_DEMANDA) AS PREVE_DEMANDA, \n" +
    "CONVER_V3_GEN_NI_9(B.DESAHOGO_PREV_DEMANDA) AS DESAHOGO_PREV_DEMANDA, \n" +
    "CONVER_V3_GEN_NI_9(B.ESTATUS_DEMANDA) AS ESTATUS_DEMANDA, \n" +
    "B.FECHA_ADMISION_DEMANDA, \n" +
    "B.CANTIDAD_ACTORES, \n" +
    "B.CANTIDAD_DEMANDADOS, \n" +
    "CONVER_V3_GEN_NI_9(B.AUDIENCIA_ECONOM) AS AUDIENCIA_ECONOM, \n" +
    "B.FECHA_AUDIENCIA_ECONOM, \n" +
    "CONVER_V3_GEN_NI_9(B.ESTATUS_EXPEDIENTE) AS ESTATUS_EXPEDIENTE, \n" +
    "B.FECHA_ACTO_PROCESAL, \n" +
    "CONVER_V3_GEN_NI_99(B.FASE_SOLI_EXPEDIENTE) AS FASE_SOLI_EXPEDIENTE, \n" +
    "CONVER_V3_FORMA_SOLUCION(B.FORMA_SOLUCION) AS FORMA_SOLUCION, \n" +
    "EFS.ESPECIFIQUE_FORMA, \n" +
    "B.FECHA_RESOLUCION, \n" +
    "CONVER_V3_GEN_NI_9(B.TIPO_SENTENCIA) AS TIPO_SENTENCIA, \n" +
    "ES.AUMENTO_PERSONAL, \n" +
    "ES.DISMINUCION_PERSONAL, \n" +
    "ES.AUMENTO_JORNADALAB, \n" +
    "ES.DISMINUCION_JORNADALAB, \n" +
    "ES.AUMENTO_SEMANA, \n" +
    "ES.DISMINUCION_SEMANA, \n" +
    "ES.AUMENTO_SALARIOS, \n" +
    "ES.DISMINUCION_SALARIOS, \n" +
    "ES.OTRO_TIPO, \n" +
    "ES.ESPECIFIQUE_TIPO, \n" +
    "B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN MOTIVOS M  \n" +
    "ON M.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND M.PERIODO = B.PERIODO \n" +
"LEFT JOIN SUSPENCION S \n" +
    "ON S.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND S.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND S.PERIODO = B.PERIODO \n" +
"LEFT JOIN EFECTO_SENTENCIA ES \n" +
    "ON ES.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
    "AND ES.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ES.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_MOTIVOS EM \n" +
    "ON em.clave_expediente = B.EXPEDIENTE_CLAVE \n" +
    "AND EM.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EM.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_INCOMPETENCIA EI \n" +
    "ON EI.clave_expediente = B.EXPEDIENTE_CLAVE \n" +
    "AND EI.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EI.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_FORMA_SOLUCION EFS \n" +
    "ON EFS.clave_expediente = B.EXPEDIENTE_CLAVE \n" +
    "AND EFS.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND EFS.PERIODO = B.PERIODO \n" +
"LEFT JOIN ESPECIFIQUE_SENTENCIA ES \n" +
    "ON ES.clave_expediente = B.EXPEDIENTE_CLAVE \n" +
    "AND ES.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND ES.PERIODO = B.PERIODO \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"') \n" ;



                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        fila.add(resul.getString(34)); 
                        fila.add(resul.getString(35));
                        fila.add(resul.getString(36));
                        fila.add(resul.getString(37));
                        fila.add(resul.getString(38));
                        fila.add(resul.getString(39));
                        fila.add(resul.getString(40));
                        fila.add(resul.getString(41));
                        fila.add(resul.getString(42));
                        fila.add(resul.getString(43));
                        fila.add(resul.getString(44));
                        fila.add(resul.getString(45));
                        fila.add(resul.getString(46));
                        fila.add(resul.getString(47));
                        fila.add(resul.getString(48));
                        fila.add(resul.getString(49));
                        fila.add(resul.getString(50));
                        fila.add(resul.getString(51));
                        fila.add(resul.getString(52));
                        fila.add(resul.getString(53));
                        fila.add(resul.getString(54));
                        fila.add(resul.getString(55));
                        fila.add(resul.getString(56));
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_COLECT_ECONOMJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }


    public ArrayList<ArrayList<String>>  V3_TR_PART_ACT_COLECT_ECONOMJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT \n" +
"        ORG.NOMBRE_ORGANOJ         AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE       AS EXPEDIENTE_CLAVE, \n" +
"        ACT.ID_ACTOR, \n" +
"        ACT.ID_TIPO_ACTOR          AS ACTOR, \n" +
"        ACT.ID_DEFENSA             AS DEFENSA_ACT, \n" +
"        ACT.NOMBRE_SINDICATO, \n" +
"        ACT.REGISTRO_ASO_SINDICAL AS REG_ASOC_SINDICAL, \n" +
"        ACT.ID_TIPO_SINDICATO AS TIPO_SINDICATO, \n" +
"        ACT.PREG_SIND_PERT_ORG_O AS ORG_OBRERA, \n" +
"        ACT.ID_ORG_OBR AS NOMBRE_ORG_OBRERA, \n" +
"        ACT.TOTAL_TRAB_INVOL AS CANT_TRABAJA_INV, \n" +
"        ACT.CANT_TRAB_INVOL_H AS HOMBRES, \n" +
"        ACT.CANT_TRAB_INVOL_M AS MUJERES, \n" +
"        ACT.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO, \n" +
"        ACT.ID_TIPO_PATRON AS TIPO, \n" +
"        ACT.RFC AS RFC_PATRON, \n" +
"        ACT.RAZON_SOCIAL AS RAZON_SOCIAL_EMPR, \n" +
"        ACT.CALLE AS CALLE, \n" +
"        ACT.NUM_EXTERIOR AS N_EXT, \n" +
"        ACT.NUM_INTERIOR AS N_INT, \n" +
"        ACT.COLONIA AS COLONIA, \n" +
"        ACT.CP AS CP, \n" +
"        ACT.ID_ENT_MPIO AS ENTIDAD_NOMBRE_EMPR, \n" +
"        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE_EMPR, \n" +
"        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE_EMPR, \n" +
"        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE_EMPR, \n" +
"        ACT.LATITUD AS LATITUD_EMPR, \n" +
"        ACT.LONGITUD AS LONGITUD_EMPR, \n" +
"        ACT.COMENTARIOS, \n" +
        "EXP.PERIODO \n" +
"    FROM TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ ORG  \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TR_EXP_ACTOR TRAC  \n" +
"        ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"        AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = TRAC.PERIODO \n" +
    "INNER JOIN TR_ACTOR ACT  \n" +
"        ON ACT.ID_ACTOR = TRAC.ACTORES_ID \n" +
"        AND TRAC.ID_ORGANOJ = ACT.ID_ORGANOJ \n" +
        "AND ACT.PERIODO = TRAC.PERIODO \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 5 \n" +
"), \n" +
"ESPECIFIQUE_SINDICATO   AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO   AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX(CASE \n" +
            "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6' \n" +
"                 AND TRIM(UPPER(PROCEDIMIENTO)) = 'ACTOR COLECTIVO DE NATURALEZA ' \n" +
                 "THEN ESPECIFIQUE \n" +
        "END) AS OTRO_ESP_SINDICATO \n" +
    "FROM \n" +
        "TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
"),       \n" +
"ESPECIFIQUE_OBRERA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO   AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX(CASE \n" +
            "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
"                 AND TRIM(UPPER(PROCEDIMIENTO) ) = 'ACTOR COLECTIVO DE NATURALEZA '  \n" +
                 "THEN ESPECIFIQUE \n" +
        "END) AS OTRO_ESP_OBRERA \n" +
    "FROM \n" +
        "TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
") \n" +
"SELECT  \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.ID_ACTOR, \n" +
"    CONVER_V3_GEN_NI_99(B.ACTOR) AS ACTOR, \n" +
"    CONVER_V3_GEN_NI_9(B.DEFENSA_ACT) AS DEFENSA_ACT, \n" +
"    B.NOMBRE_SINDICATO, \n" +
"    B.REG_ASOC_SINDICAL, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO_SINDICATO) AS TIPO_SINDICATO, \n" +
"    ES.OTRO_ESP_SINDICATO, \n" +
"    CONVER_V3_GEN_NI_9(B.ORG_OBRERA) AS ORG_OBRERA, \n" +
"    CONVER_V3_GEN_NI_9(B.NOMBRE_ORG_OBRERA) AS NOMBRE_ORG_OBRERA, \n" +
"    EO.OTRO_ESP_OBRERA, \n" +
"    B.CANT_TRABAJA_INV, \n" +
"    B.HOMBRES, \n" +
"    B.MUJERES, \n" +
"    B.NO_IDENTIFICADO, \n" +
"    CONVER_V3_GEN_NI_9(B.TIPO) AS TIPO, \n" +
"    B.RFC_PATRON, \n" +
"    B.RAZON_SOCIAL_EMPR, \n" +
"    B.CALLE, \n" +
"    B.N_EXT, \n" +
"    B.N_INT, \n" +
"    B.COLONIA, \n" +
"    B.CP, \n" +
"    B.ENTIDAD_NOMBRE_EMPR, \n" +
"    B.ENTIDAD_CLAVE_EMPR, \n" +
"    B.MUNICIPIO_NOMBRE_EMPR, \n" +
"    B.MUNICIPIO_CLAVE_EMPR, \n" +
"    B.LATITUD_EMPR, \n" +
"    B.LONGITUD_EMPR, \n" +
"    B.COMENTARIOS, \n" +
    "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN ESPECIFIQUE_SINDICATO ES \n" +
"    ON ES.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ES.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ES.PERIODO = B.PERIODO \n" +
    "AND ES.ID_ACT_DEM_AUD=B.ID_ACTOR \n" +
"LEFT JOIN ESPECIFIQUE_OBRERA EO \n" +
"    ON EO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND EO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND EO.PERIODO = B.PERIODO \n" +
    "AND EO.ID_ACT_DEM_AUD=B.ID_ACTOR \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2) = '"+cveEntidad+"' AND B.PERIODO = '"+periodo+"' ) OR ( B.CLAVE_ORGANO = '"+cveOrgano+"' AND B.PERIODO = '"+periodo+"') \n";

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_ACT_COLECT_ECONOMJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }


public ArrayList<ArrayList<String>>  V3_TR_PART_DEM_COLECT_ECONOMJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT \n" +
"        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"        DEM.ID_DEMANDADO, \n" +
"        DEM.ID_TIPO_DEMANDADO AS DEMANDADO, \n" +
"        DEM.ID_DEFENSA AS DEFENSA_DEM, \n" +
"        DEM.NOMBRE_SINDICATO AS NOMBRE_SINDICATO_DEM, \n" +
"        DEM.REG_ASOC_SINDICATO AS REG_ASOC_SINDICAL_DEM, \n" +
"        DEM.ID_TIPO_SINDICATO AS TIPO_SINDICATO_DEM, \n" +
"        DEM.PREG_SIND_PERT_ORG_OBR AS ORG_OBRERA_DEM, \n" +
"        DEM.ID_ORG_OBR AS NOMBRE_ORG_OBRERA_DEM, \n" +
"        DEM.TRAB_INVOL_TOT AS CANT_TRABAJA_INV_DEM, \n" +
"        DEM.CANT_TRAB_INVOL_H AS HOMBRES_DEM, \n" +
"        DEM.CANT_TRAB_INVOL_M AS MUJERES_DEM, \n" +
"        DEM.CANT_TRAB_INVOL_NI AS NO_IDENTIFICADO_DEM, \n" +
"        DEM.ID_TIPO_PATRON AS TIPO_DEM_PAT, \n" +
"        DEM.RFC AS RFC_PATRON_DEM, \n" +
"        DEM.RAZON_SOCIAL AS RAZON_SOCIAL_EMPR_DEM, \n" +
"        DEM.CALLE AS CALLE, \n" +
"        DEM.NUM_EXTERIOR AS N_EXT, \n" +
"        DEM.NUM_INTERIOR AS N_INT, \n" +
"        DEM.COLONIA AS COLONIA, \n" +
"        DEM.CP AS CP, \n" +
"        DEM.ID_ENT_MPIO AS ENTIDAD_NOMBRE_EMPR, \n" +
"        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE_EMPR, \n" +
"        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE_EMPR, \n" +
"        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE_EMPR, \n" +
"        DEM.LATITUD AS LATITUD_EMPR, \n" +
"        DEM.LONGITUD AS LONGITUD_EMPR, \n" +
"        DEM.COMENTARIOS AS COMENTARIOS, \n" +
        "EXP.PERIODO  \n" +
"    FROM TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ ORG  \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "INNER JOIN TR_EXP_DEMANDADO TRAC  \n" +
"        ON TRAC.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n" +
"        AND TRAC.ID_ORGANOJ = EXP.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = TRAC.PERIODO \n" +
    "INNER JOIN TR_DEMANDADO DEM  \n" +
"        ON DEM.ID_DEMANDADO = TRAC.ID_DEMANDADO \n" +
"        AND TRAC.ID_ORGANOJ = DEM.ID_ORGANOJ \n" +
        "AND DEM.PERIODO = TRAC.PERIODO \n" +
    "LEFT JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO  \n" +
        "ON TC_ENT_MPIO.ID_ENT_MPIO = DEM.ID_ENT_MPIO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 5 \n" +
"),   \n" +
"ESPECIFIQUE_SINDICATO   AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO   AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX(CASE \n" +
            "WHEN NEMONICO_CATALOGO = 'TC_SINDICATO' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '6' \n" +
"                 AND TRIM(UPPER(PROCEDIMIENTO)) = 'DEMANDADO COLECTIVO DE NATURALEZA ' \n" +
                 "THEN ESPECIFIQUE \n" +
        "END) AS OTRO_ESP_SINDICATO_DEM \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
"),       \n" +
"ESPECIFIQUE_OBRERA AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO   AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
"        ID_ACT_DEM_AUD, \n" +
        "MAX(CASE \n" +
            "WHEN NEMONICO_CATALOGO = 'TC_ORG_OBR' \n" +
"                 AND ID_OTRO_ESPECIFIQUE = '8' \n" +
"                 AND TRIM(UPPER(PROCEDIMIENTO) ) = 'DEMANDADO COLECTIVO DE NATURALEZA '  \n" +
                 "THEN ESPECIFIQUE \n" +
        "END) AS OTRO_ESP_OBRERA_DEM \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
"        PERIODO, \n" +
        "ID_ACT_DEM_AUD \n" +
") \n" +
"SELECT  \n" +
"        B.NOMBRE_ORGANO_JURIS, \n" +
"        B.CLAVE_ORGANO, \n" +
"        B.EXPEDIENTE_CLAVE, \n" +
"        B.ID_DEMANDADO, \n" +
"        CONVER_V3_GEN_NI_9(B.DEMANDADO) AS DEMANDADO, \n" +
"        CONVER_V3_GEN_NI_9(B.DEFENSA_DEM) AS DEFENSA_DEM, \n" +
"        B.NOMBRE_SINDICATO_DEM, \n" +
"        B.REG_ASOC_SINDICAL_DEM, \n" +
"        CONVER_V3_GEN_NI_9(B.TIPO_SINDICATO_DEM) AS TIPO_SINDICATO_DEM, \n" +
"        ES.OTRO_ESP_SINDICATO_DEM, \n" +
"        CONVER_V3_GEN_NI_9(B.ORG_OBRERA_DEM) AS ORG_OBRERA_DEM, \n" +
"        CONVER_V3_GEN_NI_9(B.NOMBRE_ORG_OBRERA_DEM) AS NOMBRE_ORG_OBRERA_DEM, \n" +
"        EO.OTRO_ESP_OBRERA_DEM, \n" +
"        B.CANT_TRABAJA_INV_DEM, \n" +
"        B.HOMBRES_DEM, \n" +
"        B.MUJERES_DEM, \n" +
"        B.NO_IDENTIFICADO_DEM, \n" +
"        B.TIPO_DEM_PAT, \n" +
"        B.RFC_PATRON_DEM, \n" +
"        B.RAZON_SOCIAL_EMPR_DEM, \n" +
"        B.CALLE, \n" +
"        B.N_EXT, \n" +
"        B.N_INT, \n" +
"        B.COLONIA, \n" +
"        B.CP, \n" +
"        B.ENTIDAD_NOMBRE_EMPR, \n" +
"        B.ENTIDAD_CLAVE_EMPR, \n" +
"        B.MUNICIPIO_NOMBRE_EMPR, \n" +
"        B.MUNICIPIO_CLAVE_EMPR, \n" +
"        B.LATITUD_EMPR, \n" +
"        B.LONGITUD_EMPR, \n" +
"        B.COMENTARIOS, \n" +
        "B.PERIODO \n" +
"FROM BASE B \n" +
"LEFT JOIN ESPECIFIQUE_SINDICATO ES \n" +
"    ON ES.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND ES.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND ES.PERIODO = B.PERIODO \n" +
    "AND ES.ID_ACT_DEM_AUD=B.ID_DEMANDADO \n" +
"LEFT JOIN ESPECIFIQUE_OBRERA EO \n" +
"    ON EO.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"    AND EO.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND EO.PERIODO = B.PERIODO \n" +
    "AND EO.ID_ACT_DEM_AUD=B.ID_DEMANDADO \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2) = '"+cveEntidad+"' AND B.PERIODO = '"+periodo+"' ) OR ( B.CLAVE_ORGANO = '"+cveOrgano+"' AND B.PERIODO = '"+periodo+"') \n" ;


                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                        fila.add(resul.getString(21)); 
                        fila.add(resul.getString(22)); 
                        fila.add(resul.getString(23)); 
                        fila.add(resul.getString(24)); 
                        fila.add(resul.getString(25)); 
                        fila.add(resul.getString(26)); 
                        fila.add(resul.getString(27)); 
                        fila.add(resul.getString(28)); 
                        fila.add(resul.getString(29)); 
                        fila.add(resul.getString(30)); 
                        fila.add(resul.getString(31)); 
                        fila.add(resul.getString(32)); 
                        fila.add(resul.getString(33)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PART_DEM_COLECT_ECONOMJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }

    public ArrayList<ArrayList<String>> V3_TR_PARAPROCESAL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH base AS ( \n" +
    "SELECT \n" +
"        exp.id_expediente, \n" +
"        exp.periodo, \n" +
"        org.nombre_organoj            AS nombre_organo_juris, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        exp.clave_expediente          AS expediente_clave, \n" +
"        exp.fecha_apertura_exped      AS fecha_apertura_expediente, \n" +
"        exp.rama_involuc              AS rama_indus_involucrada, \n" +
"        tc_sec.sector                 AS sector_rama, \n" +
"        tc_sec.subsector              AS subsector_rama, \n" +
"        exp.preg_incompetencia as INCOMPETENCIA, \n" +
"        exp.id_tipo_incompetencia     AS tipo_incompetencia, \n" +
"        exp.FECHA_PRESENT_PROMO as FECHA_PRESENTA_SOLI, \n" +
"        exp.FECHA_ADMISION_PROMO as FECHA_ADMISION_SOLI, \n" +
        "exp.ID_PROMOVENTE as PROMOVENTE, \n" +
" \n" +
"        exp.id_estatus_exped          AS estatus_expediente, \n" +
"        exp.FECHA_CONCLUY_EXPED as FECHA_CONCLUSION_EXPE, \n" +
        "exp.comentarios \n" +
    "FROM \n" +
             "tr_expediente exp \n" +
        "INNER JOIN tr_organoj       org ON exp.id_organoj = org.id_organoj \n" +
                                     "AND exp.periodo = org.periodo \n" +
        "INNER JOIN tc_sector_sbstor tc_sec ON tc_sec.id_sector_sbstor = exp.id_sector_sbtor \n" +
    "WHERE \n" +
        "exp.id_tipo_expediente = 6 \n" +
"),  \n" +
"motivo_soli AS ( \n" +
            "SELECT \n" +
"                id_expediente, \n" +
"                id_organoj, \n" +
"                periodo, \n" +
"                ID_MOTIVO_SOL_PROMO AS MOTIVO_SOLICITUD, \n" +
                "1 AS existe_motivo \n" +
            "FROM \n" +
                "tr_exp_motivo_solic \n" +
        "WHERE ID_MOTIVO_SOL_PROMO IN (1,2,3,4,5,6,7,8,9,10,11,14) \n" +
"),  \n" +
"ESPECIFIQUE_MOTIVO AS ( \n" +
"SELECT \n" +
"    CLAVE_EXPEDIENTE, \n" +
"    ORGANO AS ID_ORGANOJ, \n" +
"    PERIODO, \n" +
    "MAX( \n" +
        "CASE  \n" +
"            WHEN NEMONICO_CATALOGO = 'TC_MOTIVO_SOLIC_PROM' \n" +
"            AND ID_OTRO_ESPECIFIQUE = '19' \n" +
"            AND TRIM(UPPER(PROCEDIMIENTO)) = 'PARAPROCESAL O VOLUNTARIO' \n" +
            "THEN ESPECIFIQUE \n" +
        "END \n" +
"    ) AS ESPECIFIQUE_MOTIVO \n" +
"    FROM TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
"), \n" +
"especifique_tipo_incompetencia AS ( \n" +
    "SELECT \n" +
"        clave_expediente, \n" +
"        organo AS id_organoj, \n" +
"        periodo, \n" +
        "MAX( \n" +
            "CASE \n" +
                "WHEN nemonico_catalogo = 'TC_INCOMPETENCIA' \n" +
"                     AND id_otro_especifique = '6' \n" +
                     "AND procedimiento = 'PARAPROCESAL O VOLUNTARIO' THEN \n" +
                    "especifique \n" +
            "END \n" +
        ")      AS otro_esp_incomp \n" +
    "FROM \n" +
        "tr_especifique \n" +
    "GROUP BY \n" +
"        clave_expediente, \n" +
"        organo, \n" +
        "periodo \n" +
"),  \n" +
"especifique_promoven AS ( \n" +
    "SELECT \n" +
"        clave_expediente, \n" +
"        organo AS id_organoj, \n" +
"        periodo, \n" +
        "MAX( \n" +
            "CASE \n" +
                "WHEN nemonico_catalogo = 'TC_PROMOVENTE' \n" +
"                     AND id_otro_especifique = '5' \n" +
"                     AND procedimiento = 'PARAPROCESAL O VOLUNTARIO'  \n" +
                     "THEN \n" +
                    "especifique \n" +
            "END \n" +
        ")      AS ESPECIFIQUE_PROMOVENTE \n" +
    "FROM \n" +
        "tr_especifique \n" +
    "GROUP BY \n" +
"        clave_expediente, \n" +
"        organo, \n" +
        "periodo \n" +
") \n" +
"SELECT \n" +
"    b.nombre_organo_juris, \n" +
"    b.clave_organo, \n" +
"    b.expediente_clave, \n" +
"    b.fecha_apertura_expediente, \n" +
"    b.rama_indus_involucrada, \n" +
"    CONVER_V3_SECTOR(b.sector_rama) AS sector_rama, \n" +
"    CONVER_V3_SUBSECTOR(b.sector_rama,b.subsector_rama) AS subsector_rama, \n" +
"    CONVER_V3_MOTIVO_SOLICITUD(m.MOTIVO_SOLICITUD) as MOTIVO_SOLICITUD, \n" +
"    EM.ESPECIFIQUE_MOTIVO, \n" +
"    CONVER_V3_RESPUESTA_SIMPLE(b.INCOMPETENCIA) AS INCOMPETENCIA, \n" +
"    CONVER_V3_GEN_NI_9(b.tipo_incompetencia) AS tipo_incompetencia, \n" +
"    etincom.otro_esp_incomp, \n" +
"    b.FECHA_PRESENTA_SOLI, \n" +
"    b.FECHA_ADMISION_SOLI, \n" +
"    CONVER_V3_GEN_NI_9(b.promovente) AS promovente, \n" +
"    esfs.ESPECIFIQUE_PROMOVENTE, \n" +
"    CONVER_V3_GEN_NI_9(b.estatus_expediente) AS estatus_expediente, \n" +
"    b.FECHA_CONCLUSION_EXPE, \n" +
"    b.comentarios, \n" +
    "b.periodo \n" +
"FROM \n" +
"    base b \n" +
"    LEFT JOIN motivo_soli m ON m.id_expediente = b.id_expediente AND m.id_organoj = b.clave_organo AND m.periodo = b.periodo  \n" +
"    LEFT JOIN ESPECIFIQUE_MOTIVO EM ON EM.clave_expediente = b.expediente_clave AND EM.id_organoj = b.clave_organo AND EM.periodo = b.periodo \n" +
"    LEFT JOIN especifique_tipo_incompetencia etincom ON etincom.clave_expediente = b.expediente_clave AND etincom.id_organoj = b.clave_organo AND etincom.periodo = b.periodo \n" +
    "LEFT JOIN especifique_promoven esfs ON esfs.clave_expediente = b.expediente_clave AND esfs.id_organoj = b.clave_organo AND esfs.periodo = b.periodo \n" +
"WHERE \n" +
    "( substr(b.clave_organo, 0, 2) = ''"+cveEntidad+"'' \n" +
      "AND b.periodo = ''"+periodo+"'' ) \n" +
    "OR ( b.clave_organo = '"+cveOrgano+"' \n" +
         "AND b.periodo = ''"+periodo+"'') \n" ;
         try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        fila.add(resul.getString(15)); 
                        fila.add(resul.getString(16)); 
                        fila.add(resul.getString(17)); 
                        fila.add(resul.getString(18)); 
                        fila.add(resul.getString(19)); 
                        fila.add(resul.getString(20)); 
                     
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PARAPROCESAL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }



public ArrayList<ArrayList<String>>  V3_TR_TERCERIASJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "SELECT \n" +
"    org.nombre_organoj              AS nombre_organo_juris, \n" +
"    POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"    exp.clave_expediente            AS expediente_clave, \n" +
"    exp.clave_cuaderno_incid        AS clave_incidental, \n" +
"    exp.fecha_present_incidente     AS fecha_incidente, \n" +
"    exp.fecha_apert_cuader_incid    AS fecha_apertura_incidental, \n" +
"    CONVER_V3_GEN_NI_9(exp.id_tipo_incidente)           AS tipo_incidente, \n" +
"    CONVER_V3_GEN_NI_9(exp.preg_fecha_celebr_audiencia) AS celebracion_audiencia, \n" +
"    exp.fecha_audiencia, \n" +
"    CONVER_V3_GEN_NI_9(exp.id_estatus_exped)            AS estatus_expediente, \n" +
"    CONVER_V3_SENTENCIA_INCIDENTAL(exp.id_tipo_sentencia)           AS sentencia_incidental, \n" +
"    exp.fecha_dicto_solucion        AS fecha_resolucion, \n" +
"    exp.comentarios, \n" +
    "exp.periodo \n" +
"FROM tr_expediente exp \n" +
"    INNER JOIN tr_organoj org  \n" +
"    ON exp.id_organoj = org.id_organoj  \n" +
    "AND exp.periodo = org.periodo \n" +
"WHERE exp.id_tipo_expediente = 7 \n" +
"AND  (SUBSTR(exp.ID_ORGANOJ,0,2)=''"+cveEntidad+"'' AND exp.PERIODO='"+periodo+"') OR (exp.ID_ORGANOJ='"+cveOrgano+"' AND exp.PERIODO=''"+periodo+"'') \n" ;

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_TERCERIASJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }




public ArrayList<ArrayList<String>> V3_TR_EJECUCIONJL (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT \n" +
"        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE AS EXPEDIENTE_CLAVE, \n" +
"        EXP.FECHA_APERTURA_EXPED AS FECHA_APERTURA_EXPEDIENTE, \n" +
"        EXP.FECHA_PRES_EJECU_SENT AS FECHA_PRESENTACION, \n" +
"        EXP.ID_ESTATUS_EXPED AS ESTATUS_EXPEDIENTE, \n" +
"        EXP.FECHA_CONCLUY_EXPED AS FECHA_CONCLUSION_EXPE, \n" +
"        EXP.ID_FASE_CONCL_EJEC AS FASE_CONCLUSION, \n" +
"        exp.COMENTARIOS AS COMENTARIOS, \n" +
        "EXP.PERIODO  \n" +
"    FROM TR_EXPEDIENTE EXP \n" +
    "INNER JOIN TR_ORGANOJ ORG  \n" +
"        ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
        "AND EXP.PERIODO = ORG.PERIODO \n" +
    "WHERE EXP.ID_TIPO_EXPEDIENTE = 9 \n" +
"), \n" +
"MOTIVOS AS ( \n" +
    "SELECT \n" +
"        ID_EXPEDIENTE, \n" +
"        ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "ID_MOTIVO_SOL_PROMO AS MOTIVO_SOLICITUD_EJ \n" +
"    FROM TR_EXP_MOTIVO_SOLIC \n" +
    "WHERE ID_MOTIVO_SOL_PROMO IN (15,16,17,18,19) \n" +
") \n" +
"SELECT  \n" +
"        b.NOMBRE_ORGANO_JURIS, \n" +
"        b.CLAVE_ORGANO, \n" +
"        b.EXPEDIENTE_CLAVE, \n" +
"        b.FECHA_APERTURA_EXPEDIENTE, \n" +
"        M.MOTIVO_SOLICITUD_EJ, \n" +
"        b.FECHA_PRESENTACION, \n" +
"        b.ESTATUS_EXPEDIENTE, \n" +
"        b.FECHA_CONCLUSION_EXPE, \n" +
"        b.FASE_CONCLUSION, \n" +
"        b.COMENTARIOS, \n" +
        "b.PERIODO  \n" +
"FROM BASE B \n" +
"LEFT JOIN MOTIVOS M  \n" +
"    ON M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
    "AND M.PERIODO = B.PERIODO \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2) = '"+cveEntidad+"' AND B.PERIODO = '"+periodo+"' ) OR ( B.CLAVE_ORGANO = '"+cveOrgano+"' AND B.PERIODO = '"+periodo+"' ) \n" ;

                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_EJECUCIONJL" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }



    public ArrayList<ArrayList<String>> V3_TR_PREF_CREDITO (String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
         conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();

          String sql = "WITH BASE AS ( \n" +
    "SELECT \n" +
"        EXP.ID_EXPEDIENTE, \n" +
"        ORG.NOMBRE_ORGANOJ        AS NOMBRE_ORGANO_JURIS, \n" +
"        POSTGRES_CLAVE_ORGANO_7_DIGITOS_INV (ORG.ID_ORGANOJ) AS CLAVE_ORGANO, \n" +
"        EXP.CLAVE_EXPEDIENTE      AS EXPEDIENTE_CLAVE, \n" +
"        EXP.FECHA_APERTURA_EXPED  AS FECHA_APERTURA_EXPEDIENTE, \n" +
"        EXP.FECHA_PRES_EJECU_SENT AS FECHA_PRESENTACION, \n" +
"        EXP.FECHA_ADMISION_PROMO  AS FECHA_ADMISION_SOLI, \n" +
"        EXP.ID_PROMOVENTE         AS PROMOVENTE, \n" +
"        EXP.ID_ESTATUS_EXPED      AS ESTATUS_EXPEDIENTE, \n" +
"        EXP.FECHA_DICTO_SOLUCION  AS FECHA_RESOLUCION, \n" +
"        ORG.PERIODO, \n" +
        "EXP.COMENTARIOS \n" +
    "FROM \n" +
             "TR_EXPEDIENTE EXP \n" +
        "INNER JOIN TR_ORGANOJ ORG ON EXP.ID_ORGANOJ = ORG.ID_ORGANOJ \n" +
                                     "AND EXP.PERIODO = ORG.PERIODO \n" +
    "WHERE \n" +
        "EXP.ID_TIPO_EXPEDIENTE = 8 \n" +
"), MOTIVO_SOLICITUD AS ( \n" +
    "SELECT \n" +
        "* \n" +
    "FROM \n" +
        "( \n" +
            "SELECT \n" +
"                ID_EXPEDIENTE, \n" +
"                ID_ORGANOJ, \n" +
"                PERIODO, \n" +
"                ID_MOTIVO_SOL_PROMO, \n" +
                "1 AS EXISTE_MOTIVO \n" +
            "FROM \n" +
                "TR_EXP_MOTIVO_SOLIC \n" +
        ") PIVOT ( \n" +
"            MAX(EXISTE_MOTIVO) \n" +
"            FOR ID_MOTIVO_SOL_PROMO \n" +
            "IN (  \n" +
"                12 AS AVISO_ORGANO_JURIS,  \n" +
                "13 AS AVISO_AUTORIDAD_ADMIN  \n" +
            ") \n" +
        ") \n" +
"), ESPECIFIQUE_MOTIVO AS ( \n" +
    "SELECT \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO AS ID_ORGANOJ, \n" +
"        PERIODO, \n" +
        "MAX( \n" +
            "CASE \n" +
                "WHEN NEMONICO_CATALOGO = 'TC_PROMOVENTE' \n" +
"                     AND ID_OTRO_ESPECIFIQUE = '5' \n" +
                     "AND TRIM(UPPER(PROCEDIMIENTO)) = 'PREF_CREDITO' THEN \n" +
                    "ESPECIFIQUE \n" +
            "END \n" +
        ")      AS ESPECIFIQUE \n" +
    "FROM \n" +
        "TR_ESPECIFIQUE \n" +
    "GROUP BY \n" +
"        CLAVE_EXPEDIENTE, \n" +
"        ORGANO, \n" +
        "PERIODO \n" +
") \n" +
"SELECT \n" +
"    B.NOMBRE_ORGANO_JURIS, \n" +
"    B.CLAVE_ORGANO, \n" +
"    B.EXPEDIENTE_CLAVE, \n" +
"    B.FECHA_APERTURA_EXPEDIENTE, \n" +
"    CONVER_V3_MOTIVO_GEN(M.AVISO_ORGANO_JURIS) AS AVISO_ORGANO_JURIS, \n" +
"    CONVER_V3_MOTIVO_GEN(M.AVISO_AUTORIDAD_ADMIN) AS AVISO_ORGANO_JURIS, \n" +
"    B.FECHA_PRESENTACION, \n" +
"    B.FECHA_ADMISION_SOLI, \n" +
"    CONVER_V3_GEN_NI_9(B.PROMOVENTE) AS PROMOVENTE, \n" +
"    EM.ESPECIFIQUE, \n" +
"    CONVER_V3_GEN_NI_9(B.ESTATUS_EXPEDIENTE) AS ESTATUS_EXPEDIENTE, \n" +
"    B.FECHA_RESOLUCION, \n" +
"    B.COMENTARIOS, \n" +
    "b.periodo \n" +
"FROM \n" +
"    BASE               B \n" +
    "LEFT JOIN MOTIVO_SOLICITUD   M ON M.ID_EXPEDIENTE = B.ID_EXPEDIENTE \n" +
"                                    AND M.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
                                    "AND M.PERIODO = B.PERIODO \n" +
    "LEFT JOIN ESPECIFIQUE_MOTIVO EM ON EM.CLAVE_EXPEDIENTE = B.EXPEDIENTE_CLAVE \n" +
"                                       AND EM.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
                                       "AND EM.PERIODO = B.PERIODO \n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2) = '"+cveEntidad+"' AND B.PERIODO = '"+periodo+"' ) OR ( B.CLAVE_ORGANO = '"+cveOrgano+"' AND B.PERIODO = '"+periodo+"' ) \n" ;


                     try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); 
                        fila.add(resul.getString(2)); 
                        fila.add(resul.getString(3)); 
                        fila.add(resul.getString(4)); 
                        fila.add(resul.getString(5)); 
                        fila.add(resul.getString(6)); 
                        fila.add(resul.getString(7)); 
                        fila.add(resul.getString(8)); 
                        fila.add(resul.getString(9)); 
                        fila.add(resul.getString(10)); 
                        fila.add(resul.getString(11)); 
                        fila.add(resul.getString(12)); 
                        fila.add(resul.getString(13)); 
                        fila.add(resul.getString(14)); 
                        arrayList.add(fila); 
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla V3_TR_PREF_CREDITO" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }



}
