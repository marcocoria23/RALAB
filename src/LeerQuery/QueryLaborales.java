package LeerQuery;

import Conexion.OracleConexion;
import Conexion.OracleConexionDesarrollo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEJANDRO.CASTILLO
 */
public class QueryLaborales {
    
    OracleConexion conexion  = new OracleConexion(); 
    OracleConexionDesarrollo conexionDes  = new OracleConexionDesarrollo(); 
    
    
    ResultSet resul;
    String sql = "";
    ArrayList<ArrayList<String>> arrayList;
      
    public ArrayList<ArrayList<String>> DBO_Tr_Expedientes(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "SELECT \n" +
"   ID_EXPEDIENTE.NEXTVAL AS id_expediente,\n" +
"    id_tipo_expediente,\n" +
"    id_organoj, \n" +
"    clave_expediente, \n" +
"    clave_cuaderno_incid,\n" +
"    to_char( fecha_present_incidente , 'dd/MM/yyyy' ) fecha_present_incidente ,\n" +
"    to_char( fecha_apert_cuader_incid , 'dd/MM/yyyy' ) fecha_apert_cuader_incid ,\n" +
"    id_tipo_incidente,\n" +
"    to_char( fecha_apertura_exped,  'dd/MM/yyyy' ) fecha_apertura_exped , \n" +
"    id_tipo_asunto,\n" +
"    id_nat_conflicto,\n" +
"    preg_trab_contr_escri,\n" +
"    id_tipo_contrato,\n" +
"    rama_involuc,\n" +
"    id_sector_sbtor,\n" +
"    to_char( fecha_pres_ejecu_sent,   'dd/MM/yyyy' )  fecha_pres_ejecu_sent , \n" +
"    id_ent_mpio,\n" +
"    preg_outsourcing,\n" +
"    preg_apl_cir_vin_mot_conf,\n" +
"    preg_prestacion,\n" +
"    preg_fecha_celebr_audiencia ,\n" +
"    to_char( fecha_audiencia ,   'dd/MM/yyyy' ) fecha_audiencia ,-- \n" +
"    motivo_conf_colectivo,\n" +
"    preg_incompetencia,\n" +
"    id_tipo_incompetencia,\n" +
"    to_char( fecha_pliego_peticion,   'dd/MM/yyyy' )  fecha_pliego_peticion , -- \n" +
"    to_char ( fecha_present_demanda ,   'dd/MM/yyyy' ) fecha_present_demanda ,\n" +
"    to_char (  fecha_present_promo,   'dd/MM/yyyy' ) fecha_present_promo ,  \n" +
"    to_char ( fecha_admision_promo,   'dd/MM/yyyy' ) fecha_admision_promo , \n" +
"    id_promovente, \n" +
"    preg_const_conciliac,\n" +
"    clave_const_conciliac,\n" +
"    preg_asunto_vinc_concil_p,\n" +
"    preg_formulo_demanda,\n" +
"    preg_desahogo_demanda,\n" +
"    id_estatus_demanda,\n" +
"    id_causa_imp_adm_demanda,\n" +
"    to_char (  fecha_adm_demanda,   'dd/MM/yyyy' ) fecha_adm_demanda , \n" +
"    cant_actores,\n" +
"    cant_demandados,\n" +
"    preg_huelga_emplazam,\n" +
"    to_char ( fecha_huelga_emplazam,   'dd/MM/yyyy' ) fecha_huelga_emplazam ,   \n" +
"    preg_prehuelga,\n" +
"    preg_audiencia_concil,\n" +
"     to_char (  fecha_audiencia_concil,   'dd/MM/yyyy' ) fecha_audiencia_concil, \n" +
"    preg_huelga_estalla,\n" +
"    id_huelga_licitud,\n" +
"    id_huelga_existencia,\n" +
"    preg_auto_depuracion_tram,\n" +
"     to_char ( fecha_auto_depuracion ,   'dd/MM/yyyy' ) fecha_auto_depuracion , \n" +
"    preg_aud_prelim_celebr,\n" +
"     to_char (  fecha_audiencia_prelim, 'dd/MM/yyyy' )  fecha_audiencia_prelim ,  \n" +
"    preg_celebra_aud_juicio,\n" +
"    to_char (  fecha_aud_juicio,   'dd/MM/yyyy' )  fecha_aud_juicio ,  \n" +
"    preg_audiencia_col_nat_eco,\n" +
"    to_char ( fecha_audiencia_col_nat_eco, 'dd/MM/yyyy' )  fecha_audiencia_col_nat_eco ,   \n" +
"    id_estatus_exped,\n" +
"    to_char ( fecha_concluy_exped,  'dd/MM/yyyy' )   fecha_concluy_exped ,  \n" +
"    to_char ( fecha_ult_act_proc ,   'dd/MM/yyyy' )   fecha_ult_act_proc ,         \n" +
"    id_fase_sol_exped,\n" +
"    to_char ( fecha_concl_ejec,      'dd/MM/yyyy' )   fecha_concl_ejec , \n" +
"    id_fase_concl_ejec,\n" +
"    \n" +
"    -- Columna combinada para id_forma_solucion\n" +
"    id_forma_solucion,\n" +
"    \n" +
"    -- Columna combinada para fecha_dicto_solucion_u\n" +
"    to_char (  fecha_dicto_solucion,     'dd/MM/yyyy' ) fecha_dicto_solucion , \n" +
"    \n" +
"      CASE WHEN  REGEXP_LIKE (porcent_solicitado, '[^0-9.]') then NULL ELSE porcent_solicitado END porcent_solicitado,\n" +
"      CASE WHEN  REGEXP_LIKE (porcent_otorgado, '[^0-9.]') then NULL ELSE porcent_otorgado END porcent_otorgado,\n" +
"    POSTGRES_NI9(id_tipo_sentencia) AS id_tipo_sentencia,\n" +
"   to_char (  fecha_huelga_estalla,  'dd/MM/yyyy' ) fecha_huelga_estalla , \n" +
"   to_char (   fecha_huelga_levantam,  'dd/MM/yyyy' ) fecha_huelga_levantam , \n" +
"    huelga_dias,\n" +
"    CASE WHEN  REGEXP_LIKE (monto_solucion, '[^0-9.]') then NULL ELSE monto_solucion END monto_solucion,\n" +
"   CASE WHEN  REGEXP_LIKE (porcent_salarios_caidos, '[^0-9.]') then NULL ELSE porcent_salarios_caidos END porcent_salarios_caidos, \n" +
"     CASE WHEN  REGEXP_LIKE (monto_solucion, '[^0-9.]') then 'MONTO_SOLUCION:'||monto_solucion||' ,'||REGEXP_REPLACE(REPLACE(REPLACE(COMENTARIOS, CHR(10), ''), CHR(13), ''), '\\s+', ' ')    \n" +
"     WHEN REGEXP_LIKE (porcent_salarios_caidos, '[^0-9.]') then 'porcent_salarios_caidos:'||porcent_salarios_caidos||' ,'||REGEXP_REPLACE(REPLACE(REPLACE(COMENTARIOS, CHR(10), ''), CHR(13), ''), '\\s+', ' ')    \n" +
"      WHEN REGEXP_LIKE (porcent_solicitado, '[^0-9.]') then 'porcent_solicitado:'||porcent_solicitado||' ,'||REGEXP_REPLACE(REPLACE(REPLACE(COMENTARIOS, CHR(10), ''), CHR(13), ''), '\\s+', ' ')   \n" +
"       WHEN REGEXP_LIKE (porcent_otorgado, '[^0-9.]') then 'porcent_otorgado:'||porcent_otorgado||' ,'||REGEXP_REPLACE(REPLACE(REPLACE(COMENTARIOS, CHR(10), ''), CHR(13), ''), '\\s+', ' ')   \n" +
"     ELSE REGEXP_REPLACE(REPLACE(REPLACE(COMENTARIOS, CHR(10), ''), CHR(13), ''), '\\s+', ' ')   END Comentarios, \n" +
"    -- Columna del periodo tomada directamente de la tabla\n" +
"    PERIODO AS periodo\n" +
"   \n" +
"FROM\n" +
"(\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    1 AS id_tipo_expediente,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente, \n" +
"    NULL AS clave_cuaderno_incid,\n" +
"    NULL AS fecha_present_incidente,\n" +
"    NULL AS fecha_apert_cuader_incid,\n" +
"    NULL AS id_tipo_incidente,\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    CASE WHEN TIPO_ASUNTO = 9 THEN -1 ELSE TIPO_ASUNTO END AS id_tipo_asunto,\n" +
"    CASE WHEN NAT_CONFLICTO = 9 THEN -1 ELSE NAT_CONFLICTO END AS id_nat_conflicto,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONTRATO_ESCRITO) AS preg_trab_contr_escri,\n" +
"    CASE WHEN TIPO_CONTRATO = 9 THEN -1 ELSE TIPO_CONTRATO END AS id_tipo_contrato,\n" +
"    RAMA_INDUS_INVOLUCRADA AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA) AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(SUBCONTRATACION) AS preg_outsourcing,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CIRCUNS_MOTIVO_CONFL) AS preg_apl_cir_vin_mot_conf,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PAGO_PRESTACIONES) AS preg_prestacion,\n" +
"    NULL AS preg_fecha_celebr_audiencia,\n" +
"    NULL AS fecha_audiencia,-- \n" +
"    MOTIVO_CONFLICTO_COLECT AS motivo_conf_colectivo,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(INCOMPETENCIA) AS preg_incompetencia,\n" +
"    CASE WHEN TIPO_INCOMPETENCIA = 9 THEN -1 ELSE TIPO_INCOMPETENCIA END AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,-- \n" +
"    FECHA_PRES_DEMANDA AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo, \n" +
"    NULL AS fecha_admision_promo,\n" +
"    NULL AS id_promovente, \n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONSTANCIA_CONS_EXPEDIDA) AS preg_const_conciliac,\n" +
"    CONSTANCIA_CLAVE AS clave_const_conciliac,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(ASUN_EXCEP_CONCILIACION) AS preg_asunto_vinc_concil_p,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PREVE_DEMANDA) AS preg_formulo_demanda,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(DESAHOGO_PREV_DEMANDA) AS preg_desahogo_demanda,\n" +
"    CASE WHEN ESTATUS_DEMANDA = 9 THEN -1 ELSE ESTATUS_DEMANDA END AS id_estatus_demanda,\n" +
"    CASE WHEN CAU_IMP_ADM_DEMANDA = 9 THEN -1 ELSE CAU_IMP_ADM_DEMANDA END AS id_causa_imp_adm_demanda,\n" +
"    FECHA_ADMI_DEMANDA AS fecha_adm_demanda,\n" +
"    CANTIDAD_ACTORES AS cant_actores,\n" +
"    CANTIDAD_DEMANDADOS AS cant_demandados,\n" +
"    NULL  AS preg_huelga_emplazam,\n" +
"    NULL  AS fecha_huelga_emplazam,\n" +
"    NULL  AS preg_prehuelga,\n" +
"    NULL  AS preg_audiencia_concil,\n" +
"    NULL  AS fecha_audiencia_concil,\n" +
"    NULL  AS preg_huelga_estalla,\n" +
"    NULL  AS id_huelga_licitud,\n" +
"    NULL AS id_huelga_existencia,\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_PRELIM) AS preg_aud_prelim_celebr,\n" +
"    FECHA_AUDIENCIA_PRELIM AS fecha_audiencia_prelim,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_JUICIO) AS preg_celebra_aud_juicio,\n" +
"    FECHA_AUDIENCIA_JUICIO AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,\n" +
"    NULL AS fecha_audiencia_col_nat_eco,\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,\n" +
"    FECHA_ACTO_PROCESAL AS fecha_ult_act_proc,\n" +
"    CASE WHEN FASE_SOLI_EXPEDIENTE = 99 THEN -1 ELSE FASE_SOLI_EXPEDIENTE END AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejec,\n" +
"    NULL AS id_fase_concl_ejec,\n" +
"    \n" +
"    -- Columna combinada para id_forma_solucion\n" +
"    COALESCE(FORMA_SOLUCIONFE, FORMA_SOLUCIONAP, FORMA_SOLUCIONAJ) AS id_forma_solucion,\n" +
"    \n" +
"    -- Columna combinada para fecha_dicto_solucion_u\n" +
"    COALESCE(FECHA_DICTO_RESOLUCIONFE, FECHA_DICTO_RESOLUCIONAP, FECHA_RESOLUCIONAJ) AS fecha_dicto_solucion,\n" +
"    \n" +
"    NULL AS porcent_solicitado,-- ORDINARIO (NA)\n" +
"    NULL AS porcent_otorgado,-- ORDINARIO (NA)\n" +
"   POSTGRES_NI9(TIPO_SENTENCIAAJ) AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,-- ORDINARIO (NA), HUELGA (FECHA_ESTALLAM_HUELGA) \n" +
"    NULL AS fecha_huelga_levantam,-- ORDINARIO (NA), HUELGA (FECHA_LEVANT_HUELGA)\n" +
"    NULL AS huelga_dias,-- ORDINARIO (NA), HUELGA (DIAS_HUELGA)\n" +
"    NULL AS monto_solucion,-- ORDINARIO (MONTO_SOLUCIONAJ), HUELGA (MONTO_ESTIPULADO)\n" +
"    NULL AS porcent_salarios_caidos,-- ORDINARIO (NA), HUELGA(SALARIOS_CAIDOS),\n" +
"    NULL AS id_sentencia_efecto,-- HUELGA(TIPO_SENTENCIA)\n" +
"    COMENTARIOS AS Comentarios, -- ALL(COMENTARIOS)\n" +
"    -- Columna del periodo tomada directamente de la tabla\n" +
"    PERIODO AS periodo, -- ALL(PERIODO)\n" +
"    'CO:'|| CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||1 AS   ID_UNIQUE\n" +
"\n" +
"FROM \n" +
"    V3_TR_ORDINARIOJL -- V3_TR_HUELGAJL, V3_TR_INDIVIDUALJL\n" +
"\n" +
"-- Filtros para extraer solo la información de los órganos jurisdiccionales especificados\n" +
" -- WHERE CLAVE_ORGANO LIKE '060021' AND PERIODO LIKE 'DIC/24'\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"\n" +
"/* EXPEDIENTE */\n" +
"\n" +
"-- T.2.1_INDIVIDUAL\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    EXPEDIENTE_CLAVE AS id_expediente,\n" +
"    2 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    NULL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    NULL AS fecha_present_incidente,  -- Columna en blanco\n" +
"    NULL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    NULL AS id_tipo_incidente,\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    CASE WHEN TIPO_ASUNTO = 9 THEN -1 ELSE TIPO_ASUNTO END AS id_tipo_asunto,\n" +
"    CASE WHEN NAT_CONFLICTO = 9 THEN -1 ELSE NAT_CONFLICTO END AS id_nat_conflicto,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONTRATO_ESCRITO)  AS preg_trab_contr_escri,\n" +
"    CASE WHEN TIPO_CONTRATO = 9 THEN -1 ELSE TIPO_CONTRATO END AS id_tipo_contrato,\n" +
"    RAMA_INDUS_INVOLUCRADA AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA)AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(SUBCONTRATACION) AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna en blanco\n" +
"    NULL AS preg_prestacion,  -- Columna en blanco\n" +
"    NULL AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(INCOMPETENCIA) AS preg_incompetencia,\n" +
"    CASE WHEN TIPO_INCOMPETENCIA = 9 THEN -1 ELSE TIPO_INCOMPETENCIA END AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    FECHA_PRES_DEMANDA AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,  -- Columna en blanco\n" +
"    NULL AS fecha_admision_promo,  -- Columna en blanco\n" +
"    NULL AS id_promovente,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONSTANCIA_CONS_EXPEDIDA) AS preg_const_conciliac,\n" +
"    CONSTANCIA_CLAVE AS clave_const_conciliac,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(ASUN_EXCEP_CONCILIACION) AS preg_asunto_vinc_concil_p,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PREVE_DEMANDA) AS preg_formulo_demanda,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(DESAHOGO_PREV_DEMANDA) AS preg_desahogo_demanda,\n" +
"    CASE WHEN ESTATUS_DEMANDA = 9 THEN -1 ELSE ESTATUS_DEMANDA END AS id_estatus_demanda,\n" +
"    CASE WHEN CAU_IMPI_ADMI_DEMANDA = 9 THEN -1 ELSE CAU_IMPI_ADMI_DEMANDA END AS id_causa_imp_adm_demanda,\n" +
"    FECHA_ADMI_DEMANDA AS fecha_adm_demanda,\n" +
"    CANTIDAD_ACTORES AS cant_actores,\n" +
"    CANTIDAD_DEMANDADOS AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna en blanco\n" +
"    NULL AS preg_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS id_huelga_licitud,  -- Columna en blanco\n" +
"    NULL AS id_huelga_existencia,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(TRAMITACION_DEPURACION) AS preg_auto_depuracion_tram,\n" +
"    FECHA_DEPURACION AS fecha_auto_depuracion,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_PRELIM) AS preg_aud_prelim_celebr,\n" +
"    FECHA_AUDIENCIA_PRELIM AS fecha_audiencia_prelim,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_JUICIO) AS preg_celebra_aud_juicio,\n" +
"    FECHA_AUDIENCIA_JUICIO AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    FECHA_ACTO_PROCESAL AS fecha_ult_act_proc,\n" +
"    CASE WHEN FASE_SOLI_EXPEDIENTE = 99 THEN -1 ELSE FASE_SOLI_EXPEDIENTE END AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    NULL AS id_fase_concl_ejec,  -- Columna en blanco\n" +
"    \n" +
"    -- Columna combinada para id_forma_solucion\n" +
"    COALESCE(FORMA_SOLUCION_AD, FORMA_SOLUCION_TA, FORMA_SOLUCION_AP, FORMA_SOLUCION_AJ) AS id_forma_solucion,\n" +
"    \n" +
"    -- Columna combinada para fecha_dicto_solucion_u\n" +
"    COALESCE(FECHA_DICTO_RESOLUCION_AD, FECHA_RESOLUCION_TA, FECHA_DICTO_RESOLUCION_AP, FECHA_DICTO_RESOLUCION_AJ) AS fecha_dicto_solucion,\n" +
"    \n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"    \n" +
"    -- Columna combinada para id_tipo_sentencia\n" +
"    POSTGRES_NI9(COALESCE(TIPO_SENTENCIA_AD, TIPO_SENTENCIA_TA, TIPO_SENTENCIA_AJ)) AS id_tipo_sentencia,\n" +
"    \n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"\n" +
"    -- Columna combinada para monto_solucion\n" +
"    COALESCE(MONTO_SOLUCION_AD, MONTO_SOLUCIÓN_TA, MONTO_SOLUCION_AP, MONTO_SOLUCIÓN_AJ) AS monto_solucion,\n" +
"\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    NULL AS id_sentencia_efecto,  -- Columna en blanco\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||2    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_INDIVIDUALJL\n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"/* EXPEDIENTE */\n" +
"\n" +
"-- T.3.1_COLECTIVO\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    3 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    NULL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    NULL AS fecha_present_incidente,  -- Columna en blanco\n" +
"    NULL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    NULL AS id_tipo_incidente,\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    CASE WHEN TIPO_ASUNTO = 9 THEN -1 ELSE TIPO_ASUNTO END AS id_tipo_asunto,\n" +
"    CASE WHEN NAT_CONFLICTO = 9 THEN -1 ELSE NAT_CONFLICTO END AS id_nat_conflicto,\n" +
"    NULL  AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    RAMA_INDUS_INVOLUCRAD AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA)AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna en blanco\n" +
"    NULL AS preg_prestacion,  -- Columna en blanco\n" +
"    NULL AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(INCOMPETENCIA) AS preg_incompetencia,\n" +
"    CASE WHEN TIPO_INCOMPETENCIA = 9 THEN -1 ELSE TIPO_INCOMPETENCIA END AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    FECHA_PRES_DEMANDA AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,  -- Columna en blanco\n" +
"    NULL AS fecha_admision_promo,  -- Columna en blanco\n" +
"    NULL AS id_promovente,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONSTANCIA_CONS_EXPEDIDA) AS preg_const_conciliac,\n" +
"    CONSTANCIA_CLAVE AS clave_const_conciliac,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(ASUN_EXCEP_CONCILIACION) AS preg_asunto_vinc_concil_p,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PREVE_DEMANDA) AS preg_formulo_demanda,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(DESAHOGO_PREV_DEMANDA) AS preg_desahogo_demanda,\n" +
"    CASE WHEN ESTATUS_DEMANDA = 9 THEN -1 ELSE ESTATUS_DEMANDA END AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    FECHA_ADMI_DEMANDA AS fecha_adm_demanda,\n" +
"    CANTIDAD_ACTORES AS cant_actores,\n" +
"    CANTIDAD_DEMANDADOS AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna en blanco\n" +
"    NULL AS preg_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS id_huelga_licitud,  -- Columna en blanco\n" +
"    NULL AS id_huelga_existencia,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUTO_DEPURACION) AS preg_auto_depuracion_tram,\n" +
"    FECHA_DEPURACION AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_JUICIO) AS preg_celebra_aud_juicio,\n" +
"    FECHA_AUDIENCIA_JUICIO AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    FECHA_ACTO_PROCESAL AS fecha_ult_act_proc,\n" +
"    CASE WHEN FASE_SOLI_EXPEDIENTE = 99 THEN -1 ELSE FASE_SOLI_EXPEDIENTE END AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    NULL AS id_fase_concl_ejec,  -- Columna en blanco\n" +
"    \n" +
"    -- Columna combinada para id_forma_solucion\n" +
"    COALESCE(FORMA_SOLUCION_AD, FORMA_SOLUCION_AJ) AS id_forma_solucion,\n" +
"    \n" +
"    -- Columna combinada para fecha_dicto_solucion\n" +
"    COALESCE(FECHA_DICTO_RESOLUCION_AD, FECHA_RESOLUCION_AJ) AS fecha_dicto_solucion,\n" +
"    \n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"    \n" +
"    -- Columna combinada para id_tipo_sentencia\n" +
"    POSTGRES_NI9(COALESCE(TIPO_SENTENCIA_AD, TIPO_SENTENCIA_AJ)) AS id_tipo_sentencia,\n" +
"    \n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"\n" +
"    -- Columna combinada para monto_solucion\n" +
"    COALESCE(MONTO_SOLUCION_AD, MONTO_SOLUCION_AJ) AS monto_solucion,\n" +
"\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    NULL AS id_sentencia_efecto,  -- Columna en blanco\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||3    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_COLECTIVOJL    \n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"\n" +
"\n" +
"SELECT \n" +
"    NULL AS id_expediente,\n" +
"    4 AS id_tipo_expediente,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj,  \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,\n" +
"    NULL AS clave_cuaderno_incid,\n" +
"    NULL AS fecha_present_incidente,\n" +
"    NULL AS fecha_apert_cuader_incid,\n" +
"    NULL AS id_tipo_incidente,\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    CASE WHEN TIPO_ASUNTO = 9 THEN -1 ELSE TIPO_ASUNTO END AS id_tipo_asunto,\n" +
"    NULL AS id_nat_conflicto,\n" +
"    NULL AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    RAMA_INDUS_INVOLUCRAD AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA)AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,\n" +
"    NULL AS preg_prestacion,\n" +
"    NULL AS preg_fecha_celebr_audiencia,\n" +
"    NULL AS fecha_audiencia,\n" +
"    NULL AS motivo_conf_colectivo,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(INCOMPETENCIA) AS preg_incompetencia,\n" +
"    CASE WHEN TIPO_INCOMPETENCIA = 9 THEN -1 ELSE TIPO_INCOMPETENCIA END AS id_tipo_incompetencia,\n" +
"    FECHA_PRESENTA_PETIC AS fecha_pliego_peticion,\n" +
"    NULL AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,\n" +
"    NULL AS fecha_admision_promo,\n" +
"    NULL AS id_promovente,\n" +
"    NULL AS preg_const_conciliac,\n" +
"    NULL AS clave_const_conciliac,\n" +
"    NULL AS preg_asunto_vinc_concil_p,\n" +
"    NULL AS preg_formulo_demanda,\n" +
"    NULL AS preg_desahogo_demanda,\n" +
"    NULL id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    NULL AS fecha_adm_demanda,\n" +
"    CANTIDAD_ACTORES AS cant_actores,\n" +
"    CANTIDAD_DEMANDADOS AS cant_demandados,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(EMPLAZAMIENTO_HUELGA) AS preg_huelga_emplazam,\n" +
"    FECHA_EMPLAZAMIENTO AS fecha_huelga_emplazam,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PREHUELGA) AS preg_prehuelga,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_CONCILIACION) AS preg_audiencia_concil,\n" +
"    FECHA_AUDIENCIA AS fecha_audiencia_concil,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(ESTALLAMIENTO_HUELGA)AS preg_huelga_estalla,\n" +
"    CASE WHEN DECLARA_LICITUD_HUELGA = 9 THEN -1 ELSE DECLARA_LICITUD_HUELGA END AS id_huelga_licitud,\n" +
"    CASE WHEN DECLARA_EXISTEN_HUELGA = 9 THEN -1 ELSE DECLARA_EXISTEN_HUELGA END AS id_huelga_existencia,\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,\n" +
"    NULL AS fecha_audiencia_col_nat_eco,\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,\n" +
"    FECHA_ACTO_PROCESAL AS fecha_ult_act_proc,\n" +
"    CASE WHEN FASE_SOLI_EXPEDIENTE = 99 THEN -1 ELSE FASE_SOLI_EXPEDIENTE END AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,\n" +
"    NULL AS id_fase_concl_ejec,\n" +
"    COALESCE(FORMA_SOLUCION_EMPLAZ, FORMA_SOLUCION_HUELGA) AS id_forma_solucion,\n" +
"    COALESCE(FECHA_RESOLU_EMPLAZ, FECHA_RESOLU_HUELGA) AS fecha_dicto_solucion,\n" +
"    INCREMENTO_SOLICITADO AS porcent_solicitado,\n" +
"    INCREMENTO_OTORGADO AS porcent_otorgado,\n" +
"   POSTGRES_NI9(TIPO_SENTENCIA) AS id_tipo_sentencia,\n" +
"    FECHA_ESTALLAM_HUELGA AS fecha_huelga_estalla,\n" +
"    FECHA_LEVANT_HUELGA AS fecha_huelga_levantam,\n" +
"    DIAS_HUELGA AS huelga_dias,\n" +
"    MONTO_ESTIPULADO AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,\n" +
"    NULL AS id_sentencia_efecto,\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||4    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_HUELGAJL\n" +
"    \n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"\n" +
"/* EXPEDIENTE */\n" +
"\n" +
"-- T.5.1_colec_nat_eco\n" +
"\n" +
"\n" +
"-- Ajuste de valores para los campos especificados en el query original\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    5 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    NULL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    NULL AS fecha_present_incidente,  -- Columna en blanco\n" +
"    NULL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    NULL AS id_tipo_incidente, \n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    CASE WHEN TIPO_ASUNTO = 9 THEN -1 ELSE TIPO_ASUNTO END AS id_tipo_asunto,\n" +
"    CASE WHEN NAT_CONFLICTO = 9 THEN -1 ELSE NAT_CONFLICTO END AS id_nat_conflicto,\n" +
"    NULL AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    RAMA_INVOLUCRAD AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA)AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna en blanco\n" +
"    NULL AS preg_prestacion,  -- Columna en blanco\n" +
"    NULL AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(INCOMPETENCIA) AS preg_incompetencia,\n" +
"    CASE WHEN TIPO_INCOMPETENCIA = 9 THEN -1 ELSE TIPO_INCOMPETENCIA END AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    FECHA_PRES_DEMANDA AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,  -- Columna en blanco\n" +
"    NULL AS fecha_admision_promo,  -- Columna en blanco\n" +
"    NULL AS id_promovente,  -- Columna en blanco\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CONSTANCIA_CONS_EXPEDIDA) AS preg_const_conciliac,\n" +
"    CONSTANCIA_CLAVE AS clave_const_conciliac,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(ASUN_EXCEP_CONCILIACION) AS preg_asunto_vinc_concil_p,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(PREVE_DEMANDA) AS preg_formulo_demanda,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(DESAHOGO_PREV_DEMANDA)AS preg_desahogo_demanda,\n" +
"    CASE WHEN ESTATUS_DEMANDA = 9 THEN -1 ELSE ESTATUS_DEMANDA END AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    FECHA_ADMISION_DEMANDA AS fecha_adm_demanda,\n" +
"    CANTIDAD_ACTORES AS cant_actores,\n" +
"    CANTIDAD_DEMANDADOS AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna en blanco\n" +
"    NULL AS preg_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS id_huelga_licitud,  -- Columna en blanco\n" +
"    NULL AS id_huelga_existencia,  -- Columna en blanco\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(AUDIENCIA_ECONOM) AS preg_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    FECHA_AUDIENCIA_ECONOM AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    FECHA_ACTO_PROCESAL AS fecha_ult_act_proc,\n" +
"    CASE WHEN FASE_SOLI_EXPEDIENTE = 99 THEN -1 ELSE FASE_SOLI_EXPEDIENTE END AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    NULL AS id_fase_concl_ejec,  -- Columna en blanco\n" +
"    CASE WHEN FORMA_SOLUCION = 9 THEN -1 ELSE FORMA_SOLUCION END AS id_forma_solucion,\n" +
"    FECHA_RESOLUCION AS fecha_dicto_solucion,\n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"     POSTGRES_NI9(TIPO_SENTENCIA) AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"    NULL AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    \n" +
"    -- Columna combinada para id_sentencia_efecto\n" +
"    COALESCE(AUMENTO_PERSONAL, DISMINUCION_PERSONAL, AUMENTO_JORNADALAB, DISMINUCION_JORNADALAB, AUMENTO_SEMANA, DISMINUCION_SEMANA, AUMENTO_SALARIOS, DISMINUCION_SALARIOS) AS id_sentencia_efecto,\n" +
"    \n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||5    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_COLECT_ECONOMJL\n" +
"    \n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"-- T.6.1_PARAPROCESAL\n" +
"SELECT \n" +
"    NULL AS id_expediente,\n" +
"    6 AS id_tipo_expediente, \n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,\n" +
"    NULL AS clave_cuaderno_incid,  \n" +
"    NULL AS fecha_present_incidente,  \n" +
"    NULL AS fecha_apert_cuader_incid,  \n" +
"    NULL AS id_tipo_incidente,  \n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    NULL AS id_tipo_asunto,\n" +
"    NULL id_nat_conflicto,\n" +
"    NULL AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    RAMA_INVOLUCRAD AS rama_involuc,\n" +
"    POSTGRES_SECTORSUBS(SECTOR_RAMA,SUBSECTOR_RAMA)AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  \n" +
"    NULL AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,\n" +
"    NULL AS preg_prestacion,\n" +
"    NULL AS preg_fecha_celebr_audiencia,\n" +
"    NULL AS fecha_audiencia,  \n" +
"    NULL AS motivo_conf_colectivo,  \n" +
"    NULL AS preg_incompetencia,\n" +
"    NULL AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  \n" +
"    NULL AS fecha_present_demanda,\n" +
"    FECHA_PRESENTA_SOLI AS fecha_present_promo,  \n" +
"    FECHA_ADMISION_SOLI AS fecha_admision_promo,  \n" +
"    NULL AS id_promovente,\n" +
"    NULL AS preg_const_conciliac,\n" +
"    NULL AS clave_const_conciliac,\n" +
"    NULL AS preg_asunto_vinc_concil_p,\n" +
"    NULL AS preg_formulo_demanda,\n" +
"    NULL AS preg_desahogo_demanda,\n" +
"    NULL AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    NULL AS fecha_adm_demanda,\n" +
"    NULL AS cant_actores,\n" +
"    NULL AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,\n" +
"    NULL AS fecha_huelga_emplazam,  \n" +
"    NULL AS preg_prehuelga,\n" +
"    NULL AS preg_audiencia_concil,\n" +
"    NULL AS fecha_audiencia_concil,  \n" +
"    NULL AS preg_huelga_estalla,\n" +
"    NULL AS id_huelga_licitud,\n" +
"    NULL AS id_huelga_existencia,\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  \n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    FECHA_CONCLUSION_EXPE AS fecha_concluy_exped,  \n" +
"    NULL AS fecha_ult_act_proc,\n" +
"    NULL AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  \n" +
"    NULL AS id_fase_concl_ejec,  \n" +
"    NULL AS id_forma_solucion,\n" +
"    NULL AS fecha_dicto_solucion,\n" +
"    NULL AS porcent_solicitado,  \n" +
"    NULL AS porcent_otorgado,  \n" +
"    NULL AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,  \n" +
"    NULL AS fecha_huelga_levantam,  \n" +
"    NULL AS huelga_dias,  \n" +
"    NULL AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,  \n" +
"    NULL AS id_sentencia_efecto,\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||6    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_PARAPROCESALJL\n" +
"    \n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"-- TERCERIAS\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    7 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    CLAVE_INCIDENTAL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    FECHA_INCIDENTE AS fecha_present_incidente,  -- Columna en blanco\n" +
"    FECHA_APERTURA_INCIDENTAL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    CASE WHEN TIPO_INCIDENTE = 9 THEN -1 ELSE TIPO_INCIDENTE END AS id_tipo_incidente,  -- Columna con transformación\n" +
"    NULL AS fecha_apertura_exped,\n" +
"    NULL AS id_tipo_asunto,\n" +
"    NULL AS id_nat_conflicto,\n" +
"    NULL AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    NULL AS rama_involuc,\n" +
"    NULL AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    NULL AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna con transformación\n" +
"    NULL AS preg_prestacion,  -- Columna con transformación\n" +
"    POSTGRES_TC_RESPUESTA_SIMPLE(CELEBRACION_AUDIENCIA) AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    FECHA_AUDIENCIA AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    NULL AS preg_incompetencia,\n" +
"    NULL AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    NULL AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,  -- Columna en blanco\n" +
"    NULL AS fecha_admision_promo,  -- Columna en blanco\n" +
"    NULL AS id_promovente,  -- Columna con transformación\n" +
"    NULL AS preg_const_conciliac,\n" +
"    NULL AS clave_const_conciliac,\n" +
"    NULL AS preg_asunto_vinc_concil_p,\n" +
"    NULL AS preg_formulo_demanda,\n" +
"    NULL AS preg_desahogo_demanda,\n" +
"    NULL AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    NULL AS fecha_adm_demanda,\n" +
"    NULL AS cant_actores,\n" +
"    NULL AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna con transformación\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna con transformación\n" +
"    NULL AS preg_audiencia_concil,  -- Columna con transformación\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna con transformación\n" +
"    NULL AS id_huelga_licitud,  -- Columna con transformación\n" +
"    NULL AS id_huelga_existencia,  -- Columna con transformación\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,  -- Columna con transformación\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPEDIENTE = 9 THEN -1 ELSE ESTATUS_EXPEDIENTE END AS id_estatus_exped,\n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    NULL AS fecha_ult_act_proc,\n" +
"    NULL AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    NULL AS id_fase_concl_ejec,  -- Columna en blanco\n" +
"    NULL AS id_forma_solucion,\n" +
"    FECHA_RESOLUCION AS fecha_dicto_solucion,\n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"   POSTGRES_NI9(SENTENCIA_INCIDENTAL)  AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"    NULL AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    NULL AS id_sentencia_efecto,  -- Columna con transformación\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||7    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_TERCERIASJL\n" +
"    \n" +
"UNION ALL\n" +
"\n" +
"\n" +
"/* EXPEDIENTE */\n" +
"\n" +
"-- T.8.1_pref_cred\n" +
"\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    8 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    NULL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    NULL AS fecha_present_incidente,  -- Columna en blanco\n" +
"    NULL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    NULL AS id_tipo_incidente,  -- Columna en blanco\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    NULL AS id_tipo_asunto,\n" +
"    NULL AS id_nat_conflicto,\n" +
"    NULL  AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    NULL AS rama_involuc,\n" +
"    NULL AS id_sector_sbtor,\n" +
"    NULL AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    NULL AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna en blanco\n" +
"    NULL AS preg_prestacion,  -- Columna en blanco\n" +
"    NULL AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    NULL AS preg_incompetencia,\n" +
"    NULL AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    NULL AS fecha_present_demanda,\n" +
"    FECHA_PRESENTACION AS fecha_present_promo,  -- Columna en blanco\n" +
"    FECHA_ADMISION AS fecha_admision_promo,  -- Columna en blanco\n" +
"    CASE WHEN PROMOVENTE = 9 THEN -1 ELSE PROMOVENTE END AS id_promovente,  -- Columna en blanco\n" +
"    NULL AS preg_const_conciliac,\n" +
"    NULL AS clave_const_conciliac,\n" +
"    NULL AS preg_asunto_vinc_concil_p,\n" +
"    NULL AS preg_formulo_demanda,\n" +
"    NULL AS preg_desahogo_demanda,\n" +
"    NULL AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    NULL AS fecha_adm_demanda,\n" +
"    NULL AS cant_actores,\n" +
"    NULL AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna en blanco\n" +
"    NULL AS preg_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS id_huelga_licitud,  -- Columna en blanco\n" +
"    NULL AS id_huelga_existencia,  -- Columna en blanco\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPE = 9 THEN -1 ELSE ESTATUS_EXPE END AS id_estatus_exped, \n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    NULL AS fecha_ult_act_proc,\n" +
"    NULL AS id_fase_sol_exped,\n" +
"    NULL AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    NULL AS id_fase_concl_ejec,  -- Columna en blanco\n" +
"    NULL AS id_forma_solucion,\n" +
"    FECHA_RESOLUCION AS fecha_dicto_solucion,\n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"    NULL AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"    NULL AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    NULL AS id_sentencia_efecto,  -- Columna en blanco\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||8    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_PREF_CREDITOJL\n" +
"    \n" +
"    \n" +
"    \n" +
"UNION ALL \n" +
"\n" +
"\n" +
"/* EXPEDIENTE */\n" +
"\n" +
"-- T.9.1_ejecu\n" +
"\n" +
"\n" +
"SELECT \n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"    NULL AS id_expediente,\n" +
"    9 AS id_tipo_expediente,  -- 1 (Ord), 2(Indiv), 3 (Colec), 4 (Huelg), 5 (Colec Econo), 6 (Parapro), 7 (Tercer), 8 (Credit), 9 (Ejecu), -1 (No iden)\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS id_organoj, \n" +
"    EXPEDIENTE_CLAVE AS clave_expediente,  -- Columna en blanco\n" +
"    NULL AS clave_cuaderno_incid,  -- Columna en blanco\n" +
"    NULL AS fecha_present_incidente,  -- Columna en blanco\n" +
"    NULL AS fecha_apert_cuader_incid,  -- Columna en blanco\n" +
"    NULL AS id_tipo_incidente,  -- Columna en blanco\n" +
"    FECHA_APERTURA_EXPEDIENTE AS fecha_apertura_exped,\n" +
"    NULL AS id_tipo_asunto,\n" +
"    NULL AS id_nat_conflicto,\n" +
"    NULL  AS preg_trab_contr_escri,\n" +
"    NULL AS id_tipo_contrato,\n" +
"    NULL AS rama_involuc,\n" +
"    NULL AS id_sector_sbtor,\n" +
"    FECHA_PRESENTACION AS fecha_pres_ejecu_sent,  -- Columna en blanco\n" +
"    NULL AS id_ent_mpio,\n" +
"    NULL AS preg_outsourcing,\n" +
"    NULL AS preg_apl_cir_vin_mot_conf,  -- Columna en blanco\n" +
"    NULL AS preg_prestacion,  -- Columna en blanco\n" +
"    NULL AS preg_fecha_celebr_audiencia,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia,  -- Columna en blanco\n" +
"    NULL AS motivo_conf_colectivo,  -- Columna en blanco\n" +
"    NULL AS preg_incompetencia,\n" +
"    NULL AS id_tipo_incompetencia,\n" +
"    NULL AS fecha_pliego_peticion,  -- Columna en blanco\n" +
"    NULL AS fecha_present_demanda,\n" +
"    NULL AS fecha_present_promo,  -- Columna en blanco\n" +
"    NULL AS fecha_admision_promo,  -- Columna en blanco\n" +
"    NULL AS id_promovente,  -- Columna en blanco\n" +
"    NULL AS preg_const_conciliac,\n" +
"    NULL AS clave_const_conciliac,\n" +
"    NULL AS preg_asunto_vinc_concil_p,\n" +
"    NULL AS preg_formulo_demanda,\n" +
"    NULL AS preg_desahogo_demanda,\n" +
"    NULL AS id_estatus_demanda,\n" +
"    NULL AS id_causa_imp_adm_demanda,\n" +
"    NULL AS fecha_adm_demanda,\n" +
"    NULL AS cant_actores,\n" +
"    NULL AS cant_demandados,\n" +
"    NULL AS preg_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_emplazam,  -- Columna en blanco\n" +
"    NULL AS preg_prehuelga,  -- Columna en blanco\n" +
"    NULL AS preg_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_concil,  -- Columna en blanco\n" +
"    NULL AS preg_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS id_huelga_licitud,  -- Columna en blanco\n" +
"    NULL AS id_huelga_existencia,  -- Columna en blanco\n" +
"    NULL AS preg_auto_depuracion_tram,\n" +
"    NULL AS fecha_auto_depuracion,\n" +
"    NULL AS preg_aud_prelim_celebr,\n" +
"    NULL AS fecha_audiencia_prelim,\n" +
"    NULL AS preg_celebra_aud_juicio,\n" +
"    NULL AS fecha_aud_juicio,\n" +
"    NULL AS preg_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    NULL AS fecha_audiencia_col_nat_eco,  -- Columna en blanco\n" +
"    CASE WHEN ESTATUS_EXPE = 9 THEN -1 ELSE ESTATUS_EXPE END AS id_estatus_exped, \n" +
"    NULL AS fecha_concluy_exped,  -- Columna en blanco\n" +
"    NULL AS fecha_ult_act_proc,\n" +
"    NULL AS id_fase_sol_exped,\n" +
"    FECHA_CONCLUSION AS fecha_concl_ejecu,  -- Columna en blanco\n" +
"    CASE WHEN FASE_CONCLUSION = 9 THEN -1 ELSE FASE_CONCLUSION END AS id_fase_concl_ejec, \n" +
"    NULL AS id_forma_solucion,\n" +
"    NULL AS fecha_dicto_solucion,\n" +
"    NULL AS porcent_solicitado,  -- Columna en blanco\n" +
"    NULL AS porcent_otorgado,  -- Columna en blanco\n" +
"    NULL AS id_tipo_sentencia,\n" +
"    NULL AS fecha_huelga_estalla,  -- Columna en blanco\n" +
"    NULL AS fecha_huelga_levantam,  -- Columna en blanco\n" +
"    NULL AS huelga_dias,  -- Columna en blanco\n" +
"    NULL AS monto_solucion,\n" +
"    NULL AS porcent_salarios_caidos,  -- Columna en blanco\n" +
"    NULL AS id_sentencia_efecto,  -- Columna en blanco\n" +
"    COMENTARIOS AS Comentarios,\n" +
"    PERIODO AS periodo,\n" +
"    'CO:'||CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||9    ID_UNIQUE\n" +
"FROM \n" +
"    V3_TR_EJECUCIONJL);";
            try {

        Statement stmt = conexion.getConexion().createStatement();
        // realizar filtros
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        consultaFiltro.append("  WHERE  ");
         if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                    consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                    consultaFiltro.append("'" + cveEntidad + "' and " ); 
                    consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
         }
        if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" id_organoj =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
        }
        
         if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
         }
        resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
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
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(34)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(35)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(36)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(37)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(38)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(39)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(40)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(41)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(42)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(43)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(44)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(45)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(46)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(47)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(48)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(49)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(50)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(51)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(52)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(53)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(54)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(55)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(56)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(57)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(58)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(59)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(60)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(61)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(62)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(63)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(64)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(65)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(66)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(67)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(68)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(69)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(70)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(71)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(72)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(73)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(74)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXPEDIENTE " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
    
    

       public void DBO_Tr_Expedientes_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
        
     
      FileWriter file = new FileWriter(sqlVirgen, true);
        conexionDes = conexionDes.Conectar();
        String sql = " select    id_expediente  ,\n" +
"    id_tipo_expediente,\n" +
"    id_organoj ,\n" +
"    clave_expediente, \n" +
"    clave_cuaderno_incid,\n" +
"    to_char( fecha_present_incidente , 'YYYY-MM-DD' ) fecha_present_incidente, \n" +
"    to_char( fecha_apert_cuader_incid , 'YYYY-MM-DD' ) fecha_apert_cuader_incid, \n" +
"    id_tipo_incidente,\n" +
"    to_char( fecha_apertura_exped,  'YYYY-MM-DD' ) fecha_apertura_exped  ,\n" +
"    id_tipo_asunto,\n" +
"    id_nat_conflicto,\n" +
"    preg_trab_contr_escri,\n" +
"    id_tipo_contrato,\n" +
"    rama_involuc,\n" +
"    id_sector_sbtor,\n" +
"    to_char( fecha_pres_ejecu_sent,   'YYYY-MM-DD' )  fecha_pres_ejecu_sent , \n" +
"    id_ent_mpio,\n" +
"    preg_outsourcing,\n" +
"    preg_apl_cir_vin_mot_conf,\n" +
"    preg_prestacion,\n" +
"    preg_fecha_celebr_audiencia ,\n" +
"    to_char( fecha_audiencia ,   'YYYY-MM-DD' ) fecha_audiencia ,-- \n" +
"    motivo_conf_colectivo,\n" +
"    preg_incompetencia,\n" +
"    id_tipo_incompetencia,\n" +
"    to_char( fecha_pliego_peticion,   'YYYY-MM-DD' )  fecha_pliego_peticion , -- \n" +
"    to_char ( fecha_present_demanda ,   'YYYY-MM-DD' ) fecha_present_demanda, \n" +
"    to_char (  fecha_present_promo,   'YYYY-MM-DD' ) fecha_present_promo,   \n" +
"    to_char ( fecha_admision_promo,   'YYYY-MM-DD' ) fecha_admision_promo,  \n" +
"    id_promovente ,\n" +
"    preg_const_conciliac,\n" +
"    clave_const_conciliac,\n" +
"    preg_asunto_vinc_concil_p,\n" +
"    preg_formulo_demanda,\n" +
"    preg_desahogo_demanda,\n" +
"    id_estatus_demanda,\n" +
"    id_causa_imp_adm_demanda,\n" +
"    to_char (  fecha_adm_demanda,   'YYYY-MM-DD' ) fecha_adm_demanda , \n" +
"    cant_actores,\n" +
"    cant_demandados,\n" +
"    preg_huelga_emplazam,\n" +
"    to_char ( fecha_huelga_emplazam,   'YYYY-MM-DD' ) fecha_huelga_emplazam  ,  \n" +
"    preg_prehuelga,\n" +
"    preg_audiencia_concil,\n" +
"     to_char (  fecha_audiencia_concil,   'YYYY-MM-DD' ) fecha_audiencia_concil ,\n" +
"    preg_huelga_estalla,\n" +
"    id_huelga_licitud,\n" +
"    id_huelga_existencia,\n" +
"    preg_auto_depuracion_tram,\n" +
"     to_char ( fecha_auto_depuracion ,   'YYYY-MM-DD' ) fecha_auto_depuracion  ,\n" +
"    preg_aud_prelim_celebr,\n" +
"     to_char (  fecha_audiencia_prelim, 'YYYY-MM-DD' )  fecha_audiencia_prelim   ,\n" +
"    preg_celebra_aud_juicio,\n" +
"    to_char (  fecha_aud_juicio,   'YYYY-MM-DD' )  fecha_aud_juicio   ,\n" +
"    preg_audiencia_col_nat_eco,\n" +
"    to_char ( fecha_audiencia_col_nat_eco, 'YYYY-MM-DD' )  fecha_audiencia_col_nat_eco ,   \n" +
"    id_estatus_exped,\n" +
"    to_char ( fecha_concluy_exped,  'YYYY-MM-DD' )   fecha_concluy_exped   ,\n" +
"    to_char ( fecha_ult_act_proc ,   'YYYY-MM-DD' )   fecha_ult_act_proc   ,       \n" +
"    id_fase_sol_exped,\n" +
"    to_char ( fecha_concl_ejecu,      'YYYY-MM-DD' )   fecha_concl_ejecu  ,-- columna  faltante \n" +
"    ID_FASE_CONCL_EJEC,\n" +
"    id_forma_solucion,\n" +
"    to_char (  fecha_dicto_solucion,     'YYYY-MM-DD' ) fecha_dicto_solucion , \n" +
"     porcent_solicitado,\n" +
"    porcent_otorgado,\n" +
"    id_tipo_sentencia,\n" +
"   to_char (  fecha_huelga_estalla,  'YYYY-MM-DD' ) fecha_huelga_estalla  ,\n" +
"   to_char (   fecha_huelga_levantam,  'YYYY-MM-DD' ) fecha_huelga_levantam  ,\n" +
"    huelga_dias,\n" +
"     monto_solucion,\n" +
"     porcent_salarios_caidos ,\n" +
"       Comentarios from tr_expediente ;";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                  consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
            }
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXPEDIENTE" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXPEDIENTE" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                           insertQuery.append(metaData.getColumnName(i));
                           if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");

                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append(", null , null , null , null );\n");

                    // Escribir en el archivo
                    file.write(insertQuery.toString());


                }
              file.close();
                

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            
        }
        
              
                     
       } 
       
       
     public ArrayList<ArrayList<String>> DBO_Tr_Demandado(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
         arrayList = new ArrayList<>();
        String sql = "SELECT \n" +
"    ID_DEMANDADO.NEXTVAL AS ID_DEMANDADO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_TIPO_DEMANDADO,\n" +
"    ID_DEFENSA,\n" +
"    nombre_sindicato,\n" +
"    reg_asoc_sind,\n" +
"    ID_TIPO_SINDICATO,\n" +
"    pr_sind_pert_org_obr,\n" +
"    ID_ORG_OBR,\n" +
"    cant_trab_invol_h,\n" +
"    cant_trab_invol_m,\n" +
"    cant_trab_invol_ni,\n" +
"    total_trab_invol,\n" +
"    ID_TIPO_PATRON,\n" +
"    RFC,\n" +
"    razon_social,\n" +
"    calle,\n" +
"    n_exterior,\n" +
"    n_interior,\n" +
"    colonia,\n" +
"    CP,\n" +
"    ID_ENT_MPIO,\n" +
"    latitud,\n" +
"    longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    ID_UNIQUE\n" +
"    \n" +
"    FROM(\n" +
"\n" +
"-- TR DEMANDADO ORDINARIO\n" +
"SELECT \n" +
"    NULL AS ID_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    CASE \n" +
"        WHEN DEMANDADO = 9 THEN -1\n" +
"        WHEN DEMANDADO IS NOT NULL THEN DEMANDADO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN DEFENSA_DEM = 9 THEN -1\n" +
"        WHEN DEFENSA_DEM IS NOT NULL THEN DEFENSA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_DEFENSA,\n" +
"    NULL AS nombre_sindicato,\n" +
"    NULL AS reg_asoc_sind,\n" +
"    NULL AS ID_TIPO_SINDICATO,\n" +
"    NULL AS pr_sind_pert_org_obr,\n" +
"    NULL AS ID_ORG_OBR,\n" +
"    NULL AS cant_trab_invol_h,\n" +
"    NULL AS cant_trab_invol_m,\n" +
"    NULL AS cant_trab_invol_ni,\n" +
"    NULL AS total_trab_invol,\n" +
"    CASE \n" +
"        WHEN TIPO = 9 THEN -1\n" +
"        WHEN TIPO IS NOT NULL THEN TIPO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_PATRON,\n" +
"    RFC_PATRON AS RFC,\n" +
"    RAZON_SOCIAL_EMPR AS razon_social,\n" +
"    CALLE AS calle,\n" +
"    N_EXT AS n_exterior,\n" +
"    N_INT AS n_interior,\n" +
"    COLONIA AS colonia,\n" +
"    CP AS CP,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
"    LATITUD_EMPR AS latitud,\n" +
"    LONGITUD_EMPR AS longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    'CO:'||CASE WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||1    ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_PART_DEM_ORDINARIOJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"\n" +
"-- TR DEMANDADO INDIVIDUAL \n" +
"SELECT \n" +
"    NULL AS ID_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    CASE \n" +
"        WHEN DEMANDADO = 9 THEN -1\n" +
"        WHEN DEMANDADO IS NOT NULL THEN DEMANDADO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN DEFENSA_DEM = 9 THEN -1\n" +
"        WHEN DEFENSA_DEM IS NOT NULL THEN DEFENSA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_DEFENSA,\n" +
"    NULL AS nombre_sindicato,\n" +
"    NULL AS reg_asoc_sind,\n" +
"    NULL AS ID_TIPO_SINDICATO,\n" +
"    NULL AS pr_sind_pert_org_obr,\n" +
"    NULL AS ID_ORG_OBR,\n" +
"    NULL AS cant_trab_invol_h,\n" +
"    NULL AS cant_trab_invol_m,\n" +
"    NULL AS cant_trab_invol_ni,\n" +
"    NULL AS total_trab_invol,\n" +
"    CASE \n" +
"        WHEN TIPO = 9 THEN -1\n" +
"        WHEN TIPO IS NOT NULL THEN TIPO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_PATRON,\n" +
"    RFC_PATRON AS RFC,\n" +
"    RAZON_SOCIAL_EMPR AS razon_social,\n" +
"    CALLE AS calle,\n" +
"    N_EXT AS n_exterior,\n" +
"    N_INT AS n_interior,\n" +
"    COLONIA AS colonia,\n" +
"    CP AS CP, \n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
"    LATITUD_EMPR AS latitud,\n" +
"    LONGITUD_EMPR AS longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    'CO:'||CASE WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||2    ID_UNIQUE\n" +
"FROM V3_TR_PART_DEM_INDIVIDUALJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"\n" +
"-- TR DEMANDADO ESPECIAL COLECTIVO \n" +
"SELECT \n" +
"    NULL AS ID_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    CASE \n" +
"        WHEN DEMANDADO = 9 THEN -1\n" +
"        WHEN DEMANDADO IS NOT NULL THEN DEMANDADO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN DEFENSA_DEM = 9 THEN -1\n" +
"        WHEN DEFENSA_DEM IS NOT NULL THEN DEFENSA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_DEFENSA,\n" +
"    NOMBRE_SINDICATO_DEM AS nombre_sindicato,\n" +
"    REG_ASOC_SINDICAL_DEM AS reg_asoc_sind,\n" +
"    CASE \n" +
"        WHEN TIPO_SINDICATO_DEM = 9 THEN -1\n" +
"        WHEN TIPO_SINDICATO_DEM IS NOT NULL THEN TIPO_SINDICATO_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_SINDICATO,\n" +
"    CASE \n" +
"        WHEN ORG_OBRERA_DEM = 9 THEN -1\n" +
"        WHEN ORG_OBRERA_DEM IS NOT NULL THEN ORG_OBRERA_DEM\n" +
"        ELSE NULL\n" +
"    END AS pr_sind_pert_org_obr,\n" +
"    CASE \n" +
"        WHEN NOMBRE_ORG_OBRERA_DEM = 9 THEN -1\n" +
"        WHEN NOMBRE_ORG_OBRERA_DEM IS NOT NULL THEN NOMBRE_ORG_OBRERA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_ORG_OBR,\n" +
"    HOMBRES_DEM AS cant_trab_invol_h,\n" +
"    MUJERES_DEM AS cant_trab_invol_m,\n" +
"    NO_IDENTIFICADO_DEM AS cant_trab_invol_ni,\n" +
"    CANT_TRABAJA_INV_DEM AS total_trab_invol,\n" +
"    CASE \n" +
"        WHEN TIPO_DEM_PAT = 9 THEN -1\n" +
"        WHEN TIPO_DEM_PAT IS NOT NULL THEN TIPO_DEM_PAT\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_PATRON,\n" +
"    RFC_PATRON_DEM AS RFC,\n" +
"    RAZON_SOCIAL_EMPR_DEM AS razon_social,\n" +
"    CALLE AS calle,\n" +
"    N_EXT AS n_exterior,\n" +
"    N_INT AS n_interior,\n" +
"    COLONIA AS colonia,\n" +
"    CP AS CP,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
"    LATITUD_EMPR AS latitud,\n" +
"    LONGITUD_EMPR AS longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    'CO:'||CASE WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||3   ID_UNIQUE\n" +
"    \n" +
"FROM V3_TR_PART_DEM_COLECTIVOJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"-- TR DEMANDADO HUELGA\n" +
"\n" +
"SELECT \n" +
"    NULL AS ID_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    CASE \n" +
"        WHEN DEMANDADO = 9 THEN -1\n" +
"        WHEN DEMANDADO IS NOT NULL THEN DEMANDADO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN DEFENSA_DEM = 9 THEN -1\n" +
"        WHEN DEFENSA_DEM IS NOT NULL THEN DEFENSA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_DEFENSA,\n" +
"    NULL AS nombre_sindicato,\n" +
"    NULL AS reg_asoc_sind,\n" +
"    NULL AS ID_TIPO_SINDICATO,\n" +
"    NULL AS pr_sind_pert_org_obr,\n" +
"    NULL AS ID_ORG_OBR,\n" +
"    NULL AS cant_trab_invol_h,\n" +
"    NULL AS cant_trab_invol_m,\n" +
"    NULL AS cant_trab_invol_ni,\n" +
"    NULL AS total_trab_invol,\n" +
"    CASE \n" +
"        WHEN TIPO = 9 THEN -1\n" +
"        WHEN TIPO IS NOT NULL THEN TIPO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_PATRON,\n" +
"    RFC_PATRON AS RFC,\n" +
"    RAZON_SOCIAL_EMPR AS razon_social,\n" +
"    CALLE AS calle,\n" +
"    N_EXT AS n_exterior,\n" +
"    N_INT AS n_interior,\n" +
"    COLONIA AS colonia,\n" +
"    CP AS CP,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
"    LATITUD_EMPR AS latitud,\n" +
"    LONGITUD_EMPR AS longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    'CO:'||CASE WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||4    ID_UNIQUE\n" +
"    \n" +
"FROM V3_TR_PART_DEM_HUELGAJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"-- TR DEMANDADO ESPECIAL COLECTIVO ECONOMICO\n" +
"\n" +
"SELECT \n" +
"    NULL AS ID_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    CASE \n" +
"        WHEN DEMANDADO = 9 THEN -1\n" +
"        WHEN DEMANDADO IS NOT NULL THEN DEMANDADO\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_DEMANDADO,\n" +
"    CASE \n" +
"        WHEN DEFENSA_DEM = 9 THEN -1\n" +
"        WHEN DEFENSA_DEM IS NOT NULL THEN DEFENSA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_DEFENSA,\n" +
"    NOMBRE_SINDICATO_DEM AS nombre_sindicato,\n" +
"    REG_ASOC_SINDICAL_DEM AS reg_asoc_sind,\n" +
"    CASE \n" +
"        WHEN TIPO_SINDICATO_DEM = 9 THEN -1\n" +
"        WHEN TIPO_SINDICATO_DEM IS NOT NULL THEN TIPO_SINDICATO_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_SINDICATO,\n" +
"    CASE \n" +
"        WHEN ORG_OBRERA_DEM = 9 THEN -1\n" +
"        WHEN ORG_OBRERA_DEM IS NOT NULL THEN ORG_OBRERA_DEM\n" +
"        ELSE NULL\n" +
"    END AS pr_sind_pert_org_obr,\n" +
"    CASE \n" +
"        WHEN NOMBRE_ORG_OBRERA_DEM = 9 THEN -1\n" +
"        WHEN NOMBRE_ORG_OBRERA_DEM IS NOT NULL THEN NOMBRE_ORG_OBRERA_DEM\n" +
"        ELSE NULL\n" +
"    END AS ID_ORG_OBR,\n" +
"    HOMBRES_DEM AS cant_trab_invol_h,\n" +
"    MUJERES_DEM AS cant_trab_invol_m,\n" +
"    NO_IDENTIFICADO_DEM AS cant_trab_invol_ni,\n" +
"    CANT_TRABAJA_INV_DEM AS total_trab_invol,\n" +
"    CASE \n" +
"        WHEN TIPO_DEM_PAT = 9 THEN -1\n" +
"        WHEN TIPO_DEM_PAT IS NOT NULL THEN TIPO_DEM_PAT\n" +
"        ELSE NULL\n" +
"    END AS ID_TIPO_PATRON,\n" +
"    RFC_PATRON_DEM AS RFC,\n" +
"    RAZON_SOCIAL_EMPR_DEM AS razon_social,\n" +
"    CALLE AS calle,\n" +
"    N_EXT AS n_exterior,\n" +
"    N_INT AS n_interior,\n" +
"    COLONIA AS colonia,\n" +
"    CP AS CP,\n" +
"    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
"    LATITUD_EMPR AS latitud,\n" +
"    LONGITUD_EMPR AS longitud,\n" +
"    comentarios,\n" +
"    PERIODO,\n" +
"    -- Columna auxiliar\n" +
"    'CO:'||CASE WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||5    ID_UNIQUE\n" +
"    \n" +
"FROM V3_TR_PART_DEM_COLECT_ECONOMJL\n" +
"\n" +
"); ";
            try {

        Statement stmt = conexion.getConexion().createStatement();
        // realizar filtros
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        consultaFiltro.append("  WHERE  ");
         if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                    consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                    consultaFiltro.append("'" + cveEntidad + "' and " ); 
                    consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
         }
         if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" id_organoj =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
        }
        if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
         } 
         
        resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
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
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_DEMANDADO" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
     
    public void DBO_Tr_Demandado_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
      FileWriter file = new FileWriter(sqlVirgen, true);
        conexionDes = conexionDes.Conectar();
        String sql = "SELECT ID_DEMANDADO ,\n" +
                    "ID_TIPO_DEMANDADO , \n" +
                    "ID_DEFENSA , \n" +
                    "NOMBRE_SINDICATO , \n" +
                    "REG_ASOC_SINDICATO ,\n" +
                    "ID_TIPO_SINDICATO , \n" +
                    "PREG_SIND_PERT_ORG_OBR  ,\n" +
                    "ID_ORG_OBR  , \n" +
                    "CANT_TRAB_INVOL_H  , \n" +
                    "CANT_TRAB_INVOL_M  , \n" +
                    "CANT_TRAB_INVOL_NI , \n" +
                    "TRAB_INVOL_TOT    , \n" +
                    "ID_TIPO_PATRON  , \n" +
                    "RFC  , \n" +
                    "RAZON_SOCIAL ,  \n" +
                    "CALLE ,  \n" +
                    "NUM_EXTERIOR\n  ," +
                    "NUM_INTERIOR\n  , " +
                    "COLONIA  , \n" +
                    "CP , \n" +
                    "ID_ENT_MPIO , \n" +
                    "LATITUD , \n" +
                    "LONGITUD , \n" +
                    "COMENTARIOS  \n" +
                 "FROM TR_DEMANDADO; "; 
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                  consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
            }
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_DEMANDADO" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_DEMANDADO" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                     insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                     insertQuery.append(", null , null , null , null );\n");
                   // insertQuery.append(");\n");
                    // Escribir en el archivo
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
    
     public ArrayList<ArrayList<String>> DBO_Tr_Audiencias(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
         arrayList = new ArrayList<>();
            String sql = "SELECT \n" +
"\n" +
"ID_AUDIENCIA.NEXTVAL AS id_audiencia,\n" +
"\n" +
"ID_ORGANOJ,\n" +
"\n" +
"FECHA_CELEBRACION,\n" +
"\n" +
"CASE WHEN ID_TIPO_AUDIENCIA IS NULL THEN '-1' ELSE ID_TIPO_AUDIENCIA END ID_TIPO_AUDIENCIA,\n" +
"\n" +
"INICIO,\n" +
"\n" +
"CONCLUSION,\n" +
"\n" +
"ID_EXPEDIENTE,\n" +
"\n" +
"COMENTARIOS,\n" +
"\n" +
"PERIODO,\n" +
"\n" +
"ID_UNIQUE FROM ( SELECT \n" +
"\n" +
"    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
"\n" +
"    null AS id_audiencia,\n" +
"\n" +
"    CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END AS id_organoj,\n" +
"\n" +
"  to_char (   FECHA_AUDIEN_CELEBRADA ,   'dd/MM/yyyy' )  AS fecha_celebracion,\n" +
"\n" +
"     COALESCE(POSTGRES_TIPO_AUDIENCIA(ORDINARIO_TA), POSTGRES_TIPO_AUDIENCIA(ESPECIAL_INDIVI_TA), POSTGRES_TIPO_AUDIENCIA(ESPECIAL_COLECT_TA), POSTGRES_TIPO_AUDIENCIA(HUELGA_TA), POSTGRES_TIPO_AUDIENCIA(COL_NATU_ECONOMICA_TA)) \n" +
"\n" +
"     ID_TIPO_AUDIENCIA,\n" +
"\n" +
"    INICIO AS inicio,\n" +
"\n" +
"    CONCLU AS conclusion,\n" +
"\n" +
"    0 AS id_expediente,\n" +
"\n" +
"    COMENTARIOS||'-'||ESP_OTRO_AUDIENCIA AS comentarios,\n" +
"\n" +
"    -- Columna del periodo tomada directamente de la tabla\n" +
"\n" +
"    PERIODO AS periodo,\n" +
"\n" +
"     'CO:'|| CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END||'-EXP:'||EXPEDIENTE_CLAVE||'-PE:'||PERIODO||'-'||'TP:'||TIPO_PROCED    ID_UNIQUE\n" +
"\n" +
"FROM \n" +
"\n" +
"    V3_TR_AUDIENCIASJL  WHERE TIPO_PROCED<>9) ;\n" +
"  ";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("") ){
                   //    consultaFiltro.append("SUBSTR(CLAVE_ORGANO,0 , 2) =  " ); 
                       consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                       consultaFiltro.append("'" + cveEntidad + "' and " ); 
                       consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" &&  !periodo.equals("") ){
                  // consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                   consultaFiltro.append(" id_organoj =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
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
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_AUDIENCIAS" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
     
     public void DBO_Tr_Audiencias_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
            String sql = "SELECT ID_AUDIENCIA , \n" +
            " to_char ( FECHA_CELEBRACION ,   'YYYY-MM-DD' ) FECHA_CELEBRACION , " +
            "ID_TIPO_AUDIENCIA ,\n" +
            "INICIO , \n" +
            "CONCLUSION , \n" +
            "ID_EXPEDIENTE , \n" +
            "COMENTARIOS\n" 
                    + "FROM TR_AUDIENCIA ;";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();  
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_AUDIENCIA" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_AUDIENCIA" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                   insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(", null , null , null , null );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
     
     
       public ArrayList<ArrayList<String>> DBO_Tr_OrganoJ(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
         arrayList = new ArrayList<>();
            String sql = "SELECT *FROM ( SELECT \n" +
            "    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    NOMBRE_ORGANO_JURIS AS nombre_organoj,  -- \n" +
            "    SEDE AS sede_organoj,  -- Columna en blanco\n" +
            "    POSTGRES_ID_ENT_MPIO(MUNICIPIO_CLAVE) AS id_ent_mpio,  -- \n" +
            "    COLONIA_NOMBRE AS colonia,  -- Columna en blanco\n" +
            "    LATITUD_ORG AS latitud,  -- Columna en blanco\n" +
            "    LONGITUD_ORG AS longitud,\n" +
            "    POSTGRES_NI9(CIRCUNS_ORG_JUR) AS id_circunscripcion,\n" +
            "    POSTGRES_JURISDICCION(JURISDICCION) AS id_jurisdiccion,\n" +
            "    HORARIO  AS hr_atencion,\n" +
            "    PERIODO AS periodo,\n" +
                 " 'I' AS estatus \n"   +
            "FROM \n" +
            "    V3_TR_CONTROL_EXPEDIENTEJL ) ; ";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                     //  consultaFiltro.append("SUBSTR(CLAVE_ORGANO,0 , 2) =  " ); 
                       consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                       consultaFiltro.append("'" + cveEntidad + "' and " ); 
                       consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj =  " ); 
                       consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                       consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
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
                        fila.add(resul.getString(12));
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_ORGANOJ " + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
       
     public void DBO_Tr_OrganoJ_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                 
                    String sql = "SELECT ID_ORGANOJ ,\n" +
                            "NOMBRE_ORGANOJ ,\n" +
                            "SEDE_ORGANOJ ,\n" +
                            "ID_ENT_MPIO ,\n" +
                            "COLONIA ,\n" +
                            "LATITUD , \n" +
                            "LONGITUD , \n" +
                            "ID_CIRCUNSCRIPCION , \n" +
                            "ID_JURISDICCION , \n" +
                            "HR_ATENCION \n" +
                           
                    "FROM \n" +
                    "    TR_ORGANOJ ;";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
            } 
             
            
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_ORGANOJ" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_ORGANOJ" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");
                   // insertQuery.append(") VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                   // insertQuery.append(");\n");
                   insertQuery.append(", null , null , null , null );\n");
                   file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
         
         
      public ArrayList<ArrayList<String>> DBO_Tr_General(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
         arrayList = new ArrayList<>();
                String sql = "SELECT    ID_GENERAL.NEXTVAL  AS id_general,\n" +
"ID_ORGANOJ ,\n" +
"JUEZ_INDIVIDUA_H ,\n" +
"JUEZ_INDIVIDUAL_M , \n" +
"JUEZ_COLECTIVO_H ,\n" +
"JUEZ_COLECTIVO_M ,\n" +
"JUEZ_MIXTO_H , \n" +
"JUEZ_MIXTOS_M ,\n" +
"SUBTOTAL_JUEZ_H ,\n" +
"SUBTOTAL_JUEZ_M ,\n" +
"TOTAL_JUECES ,\n" +
"TOTAL_ORDINARIO ,\n" +
"TOTAL_INDIVIDUAL,\n" +
"TOTAL_COLECTIVO,\n" +
"TOTAL_HUELGA ,\n" +
"TOTAL_COL_NAT_ECON ,\n" +
"TOTAL_PARAPROCESAL ,\n" +
"TOTAL_TERCERIAS ,\n" +
"TOTAL_PREF_CRED ,\n" +
"TOTAL_EJECUCION ,\n" +
"PERIODO FROM ( SELECT \n" +
        "    -- Campos actuales que serán utilizados para el nuevo esquema\n" +
      //  "    ID_GENERAL.NEXTVAL  AS id_general,\n" +
        "    null AS id_general,\n" +
        "    CASE \n" +
        "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
        "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
        "        ELSE CLAVE_ORGANO \n" +
        "    END AS id_organoj,\n" +
        "    JUECES_LABORAL_INDIV_HOM AS juez_individua_h,  -- Columna en blanco\n" +
        "    JUECES_LABORAL_INDIV_MUJ AS juez_individual_m,  -- Columna en blanco\n" +
        "    JUECES_LABORAL_COLEC_HOM AS juez_colectivo_h,  -- Columna en blanco\n" +
        "    JUECES_LABORAL_COLEC_MUJ AS juez_colectivo_m,  -- Columna en blanco\n" +
        "    JUECES_LABORAL_MIX_HOM AS juez_mixto_h,  -- Columna en blanco\n" +
        "    JUECES_LABORAL_MIX_MUJ AS juez_mixtos_m,\n" +
        "    JUECES_LABORAL_SUB_HOM AS subtotal_juez_h,\n" +
        "    JUECES_LABORAL_SUB_MUJ AS subtotal_juez_m,\n" +
        "    JUECES_LABORAL_TOTAL  AS total_jueces,\n" +
        "    ORDINARIO AS total_ordinario,\n" +
        "    ESPECIAL_INDIVI AS total_individual,\n" +
        "    ESPECIAL_COLECT AS total_colectivo,\n" +
        "    HUELGA AS total_huelga,  -- Columna en blanco\n" +
        "    COL_NATU_ECONOMICA AS total_col_nat_econ,	\n" +
        "    PARAP_VOLUNTARIO AS total_paraprocesal,\n" +
        "    TERCERIAS AS total_tercerias,  -- Columna en blanco\n" +
        "    PREF_CREDITO AS total_pref_cred,  -- Columna en blanco\n" +
        "    EJECUCION AS total_ejecucion,  -- Columna en blanco\n" +
        "    PERIODO AS periodo\n" +
        "FROM \n" +
        "    V3_TR_CONTROL_EXPEDIENTEJL ) ; ";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                       consultaFiltro.append("SUBSTR(id_organoj,0 , 2) =  " ); 
                       consultaFiltro.append("'" + cveEntidad + "' and " ); 
                       consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == ""  && !periodo.equals("")  ){
                   consultaFiltro.append(" id_organoj =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
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
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_GENERAL " + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
      
      
        public void DBO_Tr_General_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = "SELECT ID_GENERAL ,\n" +
                "ID_ORGANOJ , \n" +
                "JUEZ_INDIVIDUA_H, \n" +
                "JUEZ_INDIVIDUAL_M, \n" +
                "JUEZ_COLECTIVO_H, \n" +
                "JUEZ_COLECTIVO_M, \n" +
                "JUEZ_MIXTO_H, \n" +
                "JUEZ_MIXTOS_M, \n" +
                "SUBTOTAL_JUEZ_H, \n" +
                "SUBTOTAL_JUEZ_M, \n" +
                "TOTAL_JUECES, \n" +
                "TOTAL_ORDINARIO, \n" +
                "TOTAL_INDIVIDUAL, \n" +
                "TOTAL_COLECTIVO, \n" +
                "TOTAL_HUELGA, \n" +
                "TOTAL_COL_NAT_ECON, \n" +
                "TOTAL_PARAPROCESAL, \n" +
                "TOTAL_TERCERIAS, \n" +
                "TOTAL_PREF_CRED, \n" +
                "TOTAL_EJECUCION\n" +
               "FROM \n" +
                "    TR_GENERAL ; ";;  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("SUBSTR(ID_ORGANOJ,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
               if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
               
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }   
          
            
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_GENERAL" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_GENERAL" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                   insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(", null , null , null , null );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
        
        
        
    
    public ArrayList<ArrayList<String>> DBO_Tr_Actor(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
           String sql = "SELECT \n" +
            "    ID_ACTOR.NEXTVAL ID_ACTOR,\n" +
            "    ID_ORGANOJ,\n" +
            "    ID_TIPO_ACTOR,\n" +
            "    ID_DEFENSA,\n" +
            "    ID_SEXO,\n" +
            "    edad,\n" +
            "    ID_OCUPACION,\n" +
            "    NSS,\n" +
            "    CURP,\n" +
            "    RFC,\n" +
            "    ID_JORNADA,\n" +
            "    nombre_sindicato,\n" +
            "    registro_aso_sindical,\n" +
            "    ID_TIPO_SINDICATO,\n" +
            "    PREG_SIND_PERT_ORG_O,\n" +
            "    ID_ORG_OBR,\n" +
            "    cant_trab_invol_h,\n" +
            "    cant_trab_invol_m,\n" +
            "    cant_trab_invol_ni,\n" +
            "    total_trab_invol,\n" +
            "    ID_TIPO_PATRON,\n" +
            "    razon_social,\n" +
            "    calle,\n" +
            "    n_exterior,\n" +
            "    n_interior,\n" +
            "    colonia,\n" +
            "    CP,\n" +
            "    ID_ENT_MPIO,\n" +
            "    POSTGRES_NI9(latitud)latitud,\n" +
            "    POSTGRES_NI9(longitud)longitud,\n" +
            "    comentarios,\n" +
            "    PERIODO,\n" +
            "    ID_UNIQUE\n" +
            "    \n" +
            "FROM (\n" +
            "-- TR_ACTOR_ORDINARIO\n" +
            "\n" +
            "SELECT \n" +
            "  NULL  AS ID_ACTOR,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    CASE \n" +
            "        WHEN ACTOR = 99 THEN -1\n" +
            "        WHEN ACTOR IS NULL THEN NULL\n" +
            "        ELSE ACTOR\n" +
            "    END AS ID_TIPO_ACTOR, --> Confirmar\n" +
            "    CASE \n" +
            "        WHEN DEFENSA_ACT = 9 THEN -1\n" +
            "        WHEN DEFENSA_ACT IS NULL THEN NULL\n" +
            "        ELSE DEFENSA_ACT\n" +
            "    END AS ID_DEFENSA,\n" +
            "    CASE \n" +
            "        WHEN SEXO = 9 THEN -1\n" +
            "        WHEN SEXO IS NULL THEN NULL\n" +
            "        ELSE SEXO\n" +
            "    END AS ID_SEXO,\n" +
            "    CASE \n" +
            "        WHEN EDAD = 99 THEN -1\n" +
            "        WHEN EDAD IS NULL THEN NULL\n" +
            "        ELSE EDAD\n" +
            "    END AS edad,\n" +
            "    CASE \n" +
            "        WHEN OCUPACION = 999 THEN -1\n" +
            "        WHEN OCUPACION IS NULL THEN NULL\n" +
            "        ELSE OCUPACION\n" +
            "    END AS ID_OCUPACION,\n" +
            "    NSS AS NSS,\n" +
            "    CURP AS CURP,\n" +
            "    RFC_TRABAJADOR AS RFC,\n" +
            "    CASE \n" +
            "        WHEN JORNADA = 9 THEN -1\n" +
            "        WHEN JORNADA IS NULL THEN NULL\n" +
            "        ELSE JORNADA\n" +
            "    END AS ID_JORNADA,\n" +
            "    NOMBRE_SINDICATO AS nombre_sindicato,\n" +
            "    REG_ASOC_SINDICAL AS registro_aso_sindical,\n" +
            "    CASE \n" +
            "        WHEN TIPO_SINDICATO = 9 THEN -1\n" +
            "        WHEN TIPO_SINDICATO IS NULL THEN NULL\n" +
            "        ELSE TIPO_SINDICATO\n" +
            "    END AS ID_TIPO_SINDICATO,\n" +
            "    POSTGRES_TC_RESPUESTA_SIMPLE(ORG_OBRERA) AS PREG_SIND_PERT_ORG_O,\n" +
            "    CASE \n" +
            "        WHEN NOMBRE_ORG_OBRERA = 9 THEN -1\n" +
            "        WHEN NOMBRE_ORG_OBRERA IS NULL THEN NULL\n" +
            "        ELSE NOMBRE_ORG_OBRERA\n" +
            "    END AS ID_ORG_OBR,\n" +
            "    HOMBRES AS cant_trab_invol_h,\n" +
            "    MUJERES AS cant_trab_invol_m,\n" +
            "    NO_IDENTIFICADO AS cant_trab_invol_ni,\n" +
            "    CANT_TRABAJA_INV AS total_trab_invol,\n" +
            "    NULL AS ID_TIPO_PATRON,\n" +
            "    NULL AS razon_social,\n" +
            "    NULL AS calle,\n" +
            "    NULL AS n_exterior,\n" +
            "    NULL AS n_interior,\n" +
            "    NULL AS colonia,\n" +
            "    NULL AS CP,\n" +
            "    NULL AS ID_ENT_MPIO,\n" +
            "    NULL AS latitud,\n" +
            "    NULL AS longitud,\n" +
            "    COMENTARIOS AS comentarios,\n" +
            "    PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "    \n" +
            "\n" +
            "FROM V3_TR_PART_ACT_ORDINARIOJL\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "-- TR_ACTOR_INDIVIDUAL\n" +
            "\n" +
            "SELECT \n" +
            "    NULL AS ID_ACTOR,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    CASE \n" +
            "        WHEN ACTOR = 99 THEN -1\n" +
            "        WHEN ACTOR IS NULL THEN NULL\n" +
            "        ELSE ACTOR\n" +
            "    END AS ID_TIPO_ACTOR, --> Confirmar\n" +
            "    CASE \n" +
            "        WHEN DEFENSA_ACT = 9 THEN -1\n" +
            "        WHEN DEFENSA_ACT IS NULL THEN NULL\n" +
            "        ELSE DEFENSA_ACT\n" +
            "    END AS ID_DEFENSA,\n" +
            "    CASE \n" +
            "        WHEN SEXO = 9 THEN -1\n" +
            "        WHEN SEXO IS NULL THEN NULL\n" +
            "        ELSE SEXO\n" +
            "    END AS ID_SEXO,\n" +
            "    CASE \n" +
            "        WHEN EDAD = 99 THEN -1\n" +
            "        WHEN EDAD IS NULL THEN NULL\n" +
            "        ELSE EDAD\n" +
            "    END AS edad,\n" +
            "    CASE \n" +
            "        WHEN OCUPACION = 999 THEN -1\n" +
            "        WHEN OCUPACION IS NULL THEN NULL\n" +
            "        ELSE OCUPACION\n" +
            "    END AS ID_OCUPACION,\n" +
            "    NSS AS NSS,\n" +
            "    CURP AS CURP,\n" +
            "    RFC_TRABAJADOR AS RFC,\n" +
            "    CASE \n" +
            "        WHEN JORNADA = 9 THEN -1\n" +
            "        WHEN JORNADA IS NULL THEN NULL\n" +
            "        ELSE JORNADA\n" +
            "    END AS ID_JORNADA,\n" +
            "    NULL AS nombre_sindicato,\n" +
            "    NULL AS registro_aso_sindical,\n" +
            "    NULL AS ID_TIPO_SINDICATO,\n" +
            "    NULL AS PREG_SIND_PERT_ORG_O,\n" +
            "    NULL AS ID_ORG_OBR,\n" +
            "    NULL AS cant_trab_invol_h,\n" +
            "    NULL AS cant_trab_invol_m,\n" +
            "    NULL AS cant_trab_invol_ni,\n" +
            "    NULL AS total_trab_invol,\n" +
            "    NULL AS ID_TIPO_PATRON,\n" +
            "    NULL AS razon_social,\n" +
            "    NULL AS calle,\n" +
            "    NULL AS n_exterior,\n" +
            "    NULL AS n_interior,\n" +
            "    NULL AS colonia,\n" +
            "    NULL AS CP,\n" +
            "    NULL AS ID_ENT_MPIO,\n" +
            "    NULL AS latitud,\n" +
            "    NULL AS longitud,\n" +
            "    COMENTARIOS AS comentarios,\n" +
            "    PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_PART_ACT_INDIVIDUALJL\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "-- TR_ACTOR_ESP_COLECTIVO\n" +
            "\n" +
            "SELECT \n" +
            "    NULL AS ID_ACTOR,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    CASE \n" +
            "        WHEN ACTOR = 99 THEN -1\n" +
            "        WHEN ACTOR IS NULL THEN NULL\n" +
            "        ELSE ACTOR\n" +
            "    END AS ID_TIPO_ACTOR, --> Confirmar\n" +
            "    CASE \n" +
            "        WHEN DEFENSA_ACT = 9 THEN -1\n" +
            "        WHEN DEFENSA_ACT IS NULL THEN NULL\n" +
            "        ELSE DEFENSA_ACT\n" +
            "    END AS ID_DEFENSA,\n" +
            "    NULL AS ID_SEXO,\n" +
            "    NULL AS edad,\n" +
            "    NULL AS ID_OCUPACION,\n" +
            "    NULL AS NSS,\n" +
            "    NULL AS CURP,\n" +
            "    RFC_PATRON AS RFC,\n" +
            "    NULL AS ID_JORNADA,\n" +
            "    NOMBRE_SINDICATO AS nombre_sindicato,\n" +
            "    REG_ASOC_SINDICAL AS registro_aso_sindical,\n" +
            "    CASE \n" +
            "        WHEN TIPO_SINDICATO = 9 THEN -1\n" +
            "        WHEN TIPO_SINDICATO IS NULL THEN NULL\n" +
            "        ELSE TIPO_SINDICATO\n" +
            "    END AS ID_TIPO_SINDICATO,\n" +
            "    POSTGRES_TC_RESPUESTA_SIMPLE(ORG_OBRERA) AS PREG_SIND_PERT_ORG_O,\n" +
            "    CASE \n" +
            "        WHEN NOMBRE_ORG_OBRERA = 9 THEN -1\n" +
            "        WHEN NOMBRE_ORG_OBRERA IS NULL THEN NULL\n" +
            "        ELSE NOMBRE_ORG_OBRERA\n" +
            "    END AS ID_ORG_OBR,\n" +
            "    HOMBRES AS cant_trab_invol_h,\n" +
            "    MUJERES AS cant_trab_invol_m,\n" +
            "    NO_IDENTIFICADO AS cant_trab_invol_ni,\n" +
            "    CANT_TRABAJA_INV AS total_trab_invol,\n" +
            "    CASE \n" +
            "        WHEN TIPO = 9 THEN -1\n" +
            "        WHEN TIPO IS NULL THEN NULL\n" +
            "        ELSE TIPO\n" +
            "    END AS ID_TIPO_PATRON,\n" +
            "    RAZON_SOCIAL_EMPR AS razon_social,\n" +
            "    CALLE AS calle,\n" +
            "    N_EXT AS n_exterior,\n" +
            "    N_INT AS n_interior,\n" +
            "    COLONIA AS colonia,\n" +
            "    CP AS CP,\n" +
            "    POSTGRES_id_ent_mpio(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO,\n" +
            "    LATITUD_EMPR AS latitud,\n" +
            "    LONGITUD_EMPR AS longitud,\n" +
            "    COMENTARIOS AS comentarios,\n" +
            "    PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_PART_ACT_COLECTIVOJL\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "-- TR_ACTOR_HUELGA\n" +
            "\n" +
            "SELECT \n" +
            "    NULL AS ID_ACTOR,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    CASE \n" +
            "        WHEN ACTOR = 99 THEN -1\n" +
            "        WHEN ACTOR IS NULL THEN NULL\n" +
            "        ELSE ACTOR\n" +
            "    END AS ID_TIPO_ACTOR, --> Confirmar\n" +
            "    CASE \n" +
            "        WHEN DEFENSA_ACT = 9 THEN -1\n" +
            "        WHEN DEFENSA_ACT IS NULL THEN NULL\n" +
            "        ELSE DEFENSA_ACT\n" +
            "    END AS ID_DEFENSA,\n" +
            "    NULL AS ID_SEXO,\n" +
            "    NULL AS edad,\n" +
            "    NULL AS ID_OCUPACION,\n" +
            "    NULL AS NSS,\n" +
            "    NULL AS CURP,\n" +
            "    NULL AS RFC,\n" +
            "    NULL AS ID_JORNADA,\n" +
            "    NOMBRE_SINDICATO AS nombre_sindicato,\n" +
            "    REG_ASOC_SINDICAL AS registro_aso_sindical,\n" +
            "    CASE \n" +
            "        WHEN TIPO_SINDICATO = 9 THEN -1\n" +
            "        WHEN TIPO_SINDICATO IS NULL THEN NULL\n" +
            "        ELSE TIPO_SINDICATO\n" +
            "    END AS ID_TIPO_SINDICATO,\n" +
            "    POSTGRES_TC_RESPUESTA_SIMPLE(ORG_OBRERA) AS PREG_SIND_PERT_ORG_O,\n" +
            "    CASE \n" +
            "        WHEN NOMBRE_ORG_OBRERA = 9 THEN -1\n" +
            "        WHEN NOMBRE_ORG_OBRERA IS NULL THEN NULL\n" +
            "        ELSE NOMBRE_ORG_OBRERA\n" +
            "    END AS ID_ORG_OBR,\n" +
            "    HOMBRES AS cant_trab_invol_h,\n" +
            "    MUJERES AS cant_trab_invol_m,\n" +
            "    NO_IDENTIFICADO AS cant_trab_invol_ni,\n" +
            "    CANT_TRABAJA_INV AS total_trab_invol,\n" +
            "    NULL AS ID_TIPO_PATRON,\n" +
            "    NULL AS razon_social,\n" +
            "    NULL AS calle,\n" +
            "    NULL AS n_exterior,\n" +
            "    NULL AS n_interior,\n" +
            "    NULL AS colonia,\n" +
            "    NULL AS CP,\n" +
            "    NULL AS ID_ENT_MPIO,\n" +
            "    NULL AS latitud,\n" +
            "    NULL AS longitud,\n" +
            "    COMENTARIOS AS comentarios,\n" +
            "    PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_PART_ACT_HUELGAJL\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "-- TR_ACTOR_ESP_COLECTIVO_ECONOMICO\n" +
            "\n" +
            "SELECT \n" +
            "    NULL AS ID_ACTOR,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS id_organoj,\n" +
            "    CASE \n" +
            "        WHEN ACTOR = 99 THEN -1\n" +
            "        WHEN ACTOR IS NULL THEN NULL\n" +
            "        ELSE ACTOR\n" +
            "    END AS ID_TIPO_ACTOR, --> Confirmar\n" +
            "    CASE \n" +
            "        WHEN DEFENSA_ACT = 9 THEN -1\n" +
            "        WHEN DEFENSA_ACT IS NULL THEN NULL\n" +
            "        ELSE DEFENSA_ACT\n" +
            "    END AS ID_DEFENSA,\n" +
            "    NULL AS ID_SEXO,\n" +
            "    NULL AS edad,\n" +
            "    NULL AS ID_OCUPACION,\n" +
            "    NULL AS NSS,\n" +
            "    NULL AS CURP,\n" +
            "    RFC_PATRON AS RFC,\n" +
            "    NULL AS ID_JORNADA,\n" +
            "    NOMBRE_SINDICATO AS nombre_sindicato,\n" +
            "    REG_ASOC_SINDICAL AS registro_aso_sindical,\n" +
            "    CASE \n" +
            "        WHEN TIPO_SINDICATO = 9 THEN -1\n" +
            "        WHEN TIPO_SINDICATO IS NULL THEN NULL\n" +
            "        ELSE TIPO_SINDICATO\n" +
            "    END AS ID_TIPO_SINDICATO,\n" +
            "    POSTGRES_TC_RESPUESTA_SIMPLE(ORG_OBRERA) AS PREG_SIND_PERT_ORG_O,\n" +
            "    CASE \n" +
            "        WHEN NOMBRE_ORG_OBRERA = 9 THEN -1\n" +
            "        WHEN NOMBRE_ORG_OBRERA IS NULL THEN NULL\n" +
            "        ELSE NOMBRE_ORG_OBRERA\n" +
            "    END AS ID_ORG_OBR,\n" +
            "    HOMBRES AS cant_trab_invol_h,\n" +
            "    MUJERES AS cant_trab_invol_m,\n" +
            "    NO_IDENTIFICADO AS cant_trab_invol_ni,\n" +
            "    CANT_TRABAJA_INV AS total_trab_invol,\n" +
            "    CASE \n" +
            "        WHEN TIPO = 9 THEN -1\n" +
            "        WHEN TIPO IS NULL THEN NULL\n" +
            "        ELSE TIPO\n" +
            "    END AS ID_TIPO_PATRON,\n" +
            "    RAZON_SOCIAL_EMPR AS razon_social,\n" +
            "    CALLE AS calle,\n" +
            "    N_EXT AS n_exterior,\n" +
            "    N_INT AS n_interior,\n" +
            "    COLONIA AS colonia,\n" +
            "    CP AS CP,\n" +
            "    POSTGRES_id_ent_mpio(MUNICIPIO_CLAVE_EMPR) AS ID_ENT_MPIO, --> Ajuste para concatenar las claves\n" +
            "    LATITUD_EMPR AS latitud,\n" +
            "    LONGITUD_EMPR AS longitud,\n" +
            "    COMENTARIOS AS comentarios,\n" +
            "    PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_PART_ACT_COLECT_ECONOMJL\n" +
            ");";
        Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                       consultaFiltro.append("SUBSTR(ID_ORGANOJ,0 , 2) =  " ); 
                       consultaFiltro.append("'" + cveEntidad + "' and " ); 
                       consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
        resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
            try {
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
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_ACTOR" + ex);
                throw ex;
            } 
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }  
       
    
    
     public void DBO_Tr_Actor_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
        
      FileWriter file = new FileWriter(sqlVirgen, true);
        conexionDes = conexionDes.Conectar();
        String sql = "SELECT ID_ACTOR ,\n" +
"ID_TIPO_ACTOR, \n" +
"ID_DEFENSA, \n" +
"ID_SEXO, \n" +
"EDAD, \n" +
"ID_OCUPACION, \n" +
"NSS, \n" +
"CURP, \n" +
"RFC, \n" +
"ID_JORNADA , \n" +
"NOMBRE_SINDICATO, \n" +
"REGISTRO_ASO_SINDICAL, \n" +
"ID_TIPO_SINDICATO, \n" +
"PREG_SIND_PERT_ORG_O , \n" +
"ID_ORG_OBR , \n" +
"CANT_TRAB_INVOL_H , \n" +
"CANT_TRAB_INVOL_M , \n" +
"CANT_TRAB_INVOL_NI , \n" +
"TOTAL_TRAB_INVOL , " +
"ID_TIPO_PATRON , " +
"RAZON_SOCIAL , " +
"CALLE , " +
"NUM_EXTERIOR , " +
"NUM_INTERIOR , " +
"COLONIA , " +
"CP , " +
"ID_ENT_MPIO , " +
"LATITUD , " +
"LONGITUD , " +
"COMENTARIOS  FROM TR_ACTOR ;";
         ResultSet rs = null;
        Statement stmt  = null;
        try{
         StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("SUBSTR(ID_ORGANOJ,0 , 2) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            
              if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }  
              
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
          ResultSetMetaData metaData = rs.getMetaData();
          int columnas = metaData.getColumnCount();

            file.write("-- Datos exportados de " + "TR_ACTOR" + "\n");

            while (rs.next()) {
                StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_ACTOR" + " (");

                // Agregar nombres de columnas
                for (int i = 1; i <= columnas; i++) {
                    insertQuery.append(metaData.getColumnName(i));
                    if (i < columnas) insertQuery.append(", ");
                }
                 insertQuery.append(" , fecha_creacion , fecha_modificacion ,  usuario_creacion ,  usuario_modificacion ) VALUES (");
                // Agregar valores
                for (int i = 1; i <= columnas; i++) {
                    String valor = rs.getString(i);
                    insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                    if (i < columnas) insertQuery.append(", ");
                }
                insertQuery.append(", null , null , null , null );\n");
                file.write(insertQuery.toString());
            }
          file.close();     
       }     
        catch(Exception e){
            e.printStackTrace();
         }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        
     }
     
     
      public ArrayList<ArrayList<String>> DBO_Tr_exp_motivo_conf(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
         arrayList = new ArrayList<>();
                String sql = 
"SELECT \n" +
" ID_MOTIVO_CONFLICTO,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_MOTIVO_CONFLICTO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_MOTIVO_CONFLICTO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_MOTIVO_CONFLICTO AS ID_UNIQUE2\n" +
"    FROM(\n" +
"    \n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(DESPIDO, 'DESPIDO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(RESCISION_RL, 'RESCISION_RL') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(TERMINACION_RESCISION_RL, 'TERMINACION_RESCISION_RL') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(VIOLACION_CONTRATO, 'VIOLACION_CONTRATO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(RIESGO_TRABAJO, 'RIESGO_TRABAJO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(REVISION_CONTRATO, 'REVISION_CONTRATO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(PART_UTILIDADES, 'PART_UTILIDADES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(OTRO_MOTIV_CONFLICTO, 'OTRO_MOTIV_CONFLICTO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(INDOLE_TRABAJO, 'INDOLE_TRABAJO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(PRESTACION_FP, 'PRESTACION_FP') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(ARRENDAM_TRAB, 'ARRENDAM_TRAB') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(CAPACITACION, 'CAPACITACION') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(ANTIGUEDAD, 'ANTIGUEDAD') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(PRIMA_ANTIGUEDAD, 'PRIMA_ANTIGUEDAD') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(CONVENIO_TRAB, 'CONVENIO_TRAB') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(DESIGNACION_TRAB_FALLE, 'DESIGNACION_TRAB_FALLE') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(DESIGNACION_TRAB_ACT_DELIC, 'DESIGNACION_TRAB_ACT_DELIC') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(TERMINACION_LAB, 'TERMINACION_LAB') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(RECUPERACION_CARGA, 'RECUPERACION_CARGA') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(GASTOS_TRASLADOS, 'GASTOS_TRASLADOS') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(INDEMNIZACION, 'INDEMNIZACION') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(PAGO_INDEMNIZACION, 'PAGO_INDEMNIZACION') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(DESACUERDO_MEDICOS, 'DESACUERDO_MEDICOS') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(COBRO_PRESTACIONES, 'COBRO_PRESTACIONES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(CONF_SEGURO_SOCIAL, 'CONF_SEGURO_SOCIAL') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(OTRO_CONF, 'OTRO_CONF') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:2' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(DECLARACION_PERDIDA_MAY, 'DECLARACION_PERDIDA_MAY') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(SUSPENSION_TMP, 'SUSPENSION_TMP') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(TERMINACION_TRAB, 'TERMINACION_TRAB') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(CONTRATACION_COLECTIVA, 'CONTRATACION_COLECTIVA') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(OMISIONES_REGLAMENTO, 'OMISIONES_REGLAMENTO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(REDUCCION_PERSONAL, 'REDUCCION_PERSONAL') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(VIOLA_DERECHOS, 'VIOLA_DERECHOS') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(ELECCION_SINDICALES, 'ELECCION_SINDICALES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(SANCION_SINDICALES, 'SANCION_SINDICALES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(OTRO_CONFLICTO, 'OTRO_CONFLICTO') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(MODIF_CONDICIONES, 'MODIF_CONDICIONES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(NUEVAS_CONDICIONES, 'NUEVAS_CONDICIONES') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(SUSPENSION_TEMPORAL, 'SUSPENSION_TEMPORAL') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(TERMINACION_COLECTIVA, 'TERMINACION_COLECTIVA') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_CONF(OTRO_MOTIVO_ECONOM, 'OTRO_MOTIVO_ECONOM') AS ID_MOTIVO_CONFLICTO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
" ) \n" +
") \n" +
") ; ";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                  consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' AND ID_MOTIVO_CONFLICTO IS NOT NULL ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_MOTIVO_CONFLICTO IS NOT NULL ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")  AND ID_MOTIVO_CONFLICTO IS NOT NULL ; "  ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_exp_motivo_conf" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
      
      
        public void DBO_Tr_Exp_Motivo_Conf_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = " SELECT ID_MOTIVO_CONFLICTO , \n" +
                                 "ID_EXPEDIENTE  \n" +
                             " FROM TR_EXP_MOTIVO_CONF ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                  consultaFiltro.append(" substr( id_organoj , 0, 2 ) =  " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
             
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();
                file.write("-- Datos exportados de " + "TR_EXP_MOTIVO_CONF" + "\n");
                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_MOTIVO_CONF" + " (");
                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("); \n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
        
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Circunst(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = " --TR_EXP_CIRCUNST\n" +
            "SELECT \n" +
            " ID_CIRCUNS_MOT_CONF,\n" +
            "    ID_ORGANOJ,\n" +
            "  0  ID_EXPEDIENTE,\n" +
            "    PERIODO,\n" +
            "    ID_UNIQUE\n" +
            "    FROM(\n" +
            "SELECT \n" +
            "UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
            "    ID_CIRCUNS_MOT_CONF,\n" +
            "    ID_ORGANOJ,\n" +
            "    ID_EXPEDIENTE,\n" +
            "    PERIODO,\n" +
            "    ID_UNIQUE\n" +
            "   \n" +
            "    FROM ( SELECT\n" +
            "        ID_CIRCUNS_MOT_CONF,\n" +
            "    ID_ORGANOJ,\n" +
            "    ID_EXPEDIENTE,\n" +
            "    PERIODO,\n" +
            "    ID_UNIQUE,\n" +
            "    ID_UNIQUE||'ID_MOT:'||ID_CIRCUNS_MOT_CONF AS ID_UNIQUE2\n" +
            "    FROM(\n" +
            "    \n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_EMBARAZO, 'DETERM_EMPLEO_EMBARAZO') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_EDAD, 'DETERM_EMPLEO_EDAD') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_GENERO, 'DETERM_EMPLEO_GENERO') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_ORIEN_SEX, 'DETERM_EMPLEO_ORIEN_SEX') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_DISCAPACIDAD, 'DETERM_EMPLEO_DISCAPACIDAD') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_SOCIAL, 'DETERM_EMPLEO_SOCIAL') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_ORIGEN, 'DETERM_EMPLEO_ORIGEN') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_RELIGION, 'DETERM_EMPLEO_RELIGION') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(DETERM_EMPLEO_MIGRA, 'DETERM_EMPLEO_MIGRA') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(OTRO_DISCRIMINACION, 'OTRO_DISCRIMINACION') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(TRATA_LABORAL, 'TRATA_LABORAL') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(TRABAJO_FORZOSO, 'TRABAJO_FORZOSO') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(TRABAJO_INFANTIL, 'TRABAJO_INFANTIL') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(HOSTIGAMIENTO, 'HOSTIGAMIENTO') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            "\n" +
            "\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "\n" +
            "    POSTGRES_TR_EXP_CIRCUNST(ACOSO_SEXUAL, 'ACOSO_SEXUAL') AS ID_CIRCUNS_MOT_CONF,\n" +
            "    CASE \n" +
            "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "        ELSE CLAVE_ORGANO \n" +
            "    END AS ID_ORGANOJ,\n" +
            "    NULL AS ID_EXPEDIENTE,\n" +
            "    PERIODO AS PERIODO,\n" +
            "    'CO:' || \n" +
            "    (\n" +
            "        CASE \n" +
            "            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
            "            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
            "            ELSE CLAVE_ORGANO \n" +
            "        END\n" +
            "    ) \n" +
            "    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
            "\n" +
            "FROM V3_TR_ORDINARIOJL\n" +
            " ) \n" +
            ") \n" +
            ") ";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND ID_CIRCUNS_MOT_CONF IS NOT NULL ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_CIRCUNS_MOT_CONF IS NOT NULL ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_CIRCUNS_MOT_CONF IS NOT NULL ; " ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Circunst" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
      
    public void DBO_Tr_Exp_Circunst_Exportar_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                String sql = "SELECT ID_CIRCUNS_MOT_CONF , \n" +
                "ID_EXPEDIENTE\n" 
                        + "FROM TR_EXP_CIRCUNST ; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
               if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }  
            
          
            stmt = conexionDes.getConexion().createStatement();
            rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_CIRCUNST" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_CIRCUNST" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
    
    
      public ArrayList<ArrayList<String>> DBO_Tr_Exp_Concepto_Reclam(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = " --TR_EXP_CONCEPTO_RECLAM\n" +
"SELECT \n" +
" ID_CONCEPTO_RECLAM,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_CONCEPTO_RECLAM,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_CONCEPTO_RECLAM,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_CONCEPTO_RECLAM AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(PAGO_PRESTACIONES, 'PAGO_PRESTACIONES') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(INDEMNIZACION, 'INDEMNIZACION') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(REINSTALACION, 'REINSTALACION') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(SALARIO_RETENIDO, 'SALARIO_RETENIDO') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(AUMENTO_SALARIO, 'AUMENTO_SALARIO') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(DERECHO_ASCENSO, 'DERECHO_ASCENSO') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(DERECHO_PREFERENCIA, 'DERECHO_PREFERENCIA') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(DERECHO_ANTIGUEDAD, 'DERECHO_ANTIGUEDAD') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_CONCEPTO_RECLAM(OTRO_CONCEPTO, 'OTRO_CONCEPTO') AS ID_CONCEPTO_RECLAM,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND ID_CONCEPTO_RECLAM IS NOT NULL  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_CONCEPTO_RECLAM IS NOT NULL  ;" ); 
            }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_CONCEPTO_RECLAM IS NOT NULL ;" ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Concepto_Reclam" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
      
      
      
        public void DBO_Tr_Exp_Concepto_Reclam_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
          String sql = " SELECT ID_CONCEPTO_RECLAM , \n" +
                            "ID_EXPEDIENTE \n" +
                             " FROM tr_exp_concepto_reclam ; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
             StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
               if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }  
               
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_CONCEPTO_RECLAM" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_CONCEPTO_RECLAM" + " (");
                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                      
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
        
        
       public ArrayList<ArrayList<String>> DBO_Tr_Exp_Prestacion(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "--TR_EXP_PRESTACION\n" +
"SELECT \n" +
" ID_PRESTACION,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_PRESTACION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_PRESTACION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_PRESTACION AS ID_UNIQUE2\n" +
"    FROM(\n" +
"  \n" +
"        SELECT\n" +
"    POSTGRES_TR_EXP_PRESTACION(AGUINALDO, 'AGUINALDO') AS ID_PRESTACION,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_PRESTACION(VACACIONES, 'VACACIONES') AS ID_PRESTACION,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_PRESTACION(PRIMA_VACACIONAL, 'PRIMA_VACACIONAL') AS ID_PRESTACION,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_PRESTACION(PRIMA_ANTIGUEDAD, 'PRIMA_ANTIGUEDAD') AS ID_PRESTACION,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
"\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_PRESTACION(OTRO_TIPO_PREST, 'OTRO_TIPO_PREST') AS ID_PRESTACION,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:1' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "'  AND ID_PRESTACION IS NOT NULL ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_PRESTACION IS NOT NULL  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_PRESTACION IS NOT NULL ;" ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Prestacion" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Prestacion_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = " select ID_PRESTACION , \n" +
                           "ID_EXPEDIENTE \n" +
                             " from TR_EXP_PRESTACION; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
             StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("")  ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == ""   && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
                
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            } 
             
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_PRESTACION" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_PRESTACION" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
         
         
       public ArrayList<ArrayList<String>> DBO_Tr_Exp_Motivo_Huelga(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "-----------------------------------------------------------------------------------------------------\n" +
"-- TR_EXP_MOTIVO_HUELGA\n" +
"-----------------------------------------------------------------------------------------------------\n" +
"\n" +
"SELECT \n" +
" ID_HUELGA_MOTIVO,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_HUELGA_MOTIVO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_HUELGA_MOTIVO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_HUELGA_MOTIVO AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(FIRMA_CONTRATO, 'FIRMA_CONTRATO') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(REVISION_CONTRATO, 'REVISION_CONTRATO') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(INCUMPLIM_CONTRATO, 'INCUMPLIM_CONTRATO') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(REVISION_SALARIO, 'REVISION_SALARIO') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(REPARTO_UTILIDADES, 'REPARTO_UTILIDADES') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(APOYO_OTRA_HUELGA, 'APOYO_OTRA_HUELGA') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(DESEQUILIBRIO_FAC_PROD, 'DESEQUILIBRIO_FAC_PROD') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT\n" +
"\n" +
"    POSTGRES_TR_EXP_MOTIVO_HUELGA(OTRO_MOTIVO, 'OTRO_MOTIVO') AS ID_HUELGA_MOTIVO,\n" +
"    CASE \n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"        ELSE CLAVE_ORGANO \n" +
"    END AS ID_ORGANOJ,\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"    PERIODO AS PERIODO,\n" +
"    'CO:' || \n" +
"    (\n" +
"        CASE \n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"            ELSE CLAVE_ORGANO \n" +
"        END\n" +
"    ) \n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:4' AS ID_UNIQUE\n" +
"\n" +
"FROM V3_TR_HUELGAJL\n" +
"\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("")  ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND ID_HUELGA_MOTIVO IS NOT NULL;" ); 
            }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_HUELGA_MOTIVO IS NOT NULL  ;" ); 
            }
             
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_HUELGA_MOTIVO IS NOT NULL ;" ); 
                  
            }
            
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Motivo_Huelga" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Motivo_Huelga_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
        FileWriter file = new FileWriter(sqlVirgen, true);
          conexionDes = conexionDes.Conectar();
          String sql = " SELECT ID_HUELGA_MOTIVO , " +
                        "ID_EXPEDIENTE \n" +
                        " FROM tr_exp_motivo_huelga ; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            
           if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
            }
          
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_MOTIVO_HUELGA" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_MOTIVO_HUELGA" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append("  ) VALUES (");

                    
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                     insertQuery.append(" );\n");
                     
                    
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
    

     public ArrayList<ArrayList<String>> DBO_Tr_Exp_Suspension(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "-----------------------------------------------------------------------------------------------------\n" +
"-- TR_EXP_SUSPENSION\n" +
"-----------------------------------------------------------------------------------------------------\n" +
"\n" +
"SELECT \n" +
" ID_TIPO_SUSPENSION,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_TIPO_SUSPENSION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_TIPO_SUSPENSION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_TIPO_SUSPENSION AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(NO_IMPUTABLE_ST, 'NO_IMPUTABLE_ST') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"  UNION ALL \n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(INCAPACIDAD_FISICA_ST, 'INCAPACIDAD_FISICA_ST') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(FALTA_MATERIA_PRIM_ST, 'FALTA_MATERIA_PRIM_ST') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(FALTA_MINISTRACION_ST, 'FALTA_MINISTRACION_ST') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(EXCESO_PRODUCCION, 'EXCESO_PRODUCCION') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(INCOSTEABILIDAD, 'INCOSTEABILIDAD') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_SUSPENSION\n" +
"(FALTA_FONDOS, 'FALTA_FONDOS') AS ID_TIPO_SUSPENSION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"  ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""   && !periodo.equals("")  ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "'  AND ID_TIPO_SUSPENSION IS NOT NULL;" ); 
            }
            
             if(!cveOrgano.equals("") &&  cveEntidad == ""   && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_TIPO_SUSPENSION IS NOT NULL  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_TIPO_SUSPENSION IS NOT NULL  ;" ); 
                  
            }
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Suspension" + ex);
                throw ex;    
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Suspension_Insert(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = "   select \n" +
                            " ID_TIPO_SUSPENSION , \n" +
                            " ID_EXPEDIENTE\n" +
                            "\n" +
                             " from TR_EXP_SUSPENSION  ; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
             StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
            
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
             
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_SUSPENSION" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_SUSPENSION" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append("  ) VALUES (");


                    
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
         
         
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Terminacion(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "-----------------------------------------------------------------------------------------------------\n" +
"--TR_EXP_TERMINACION \n" +
"-----------------------------------------------------------------------------------------------------\n" +
"SELECT \n" +
" ID_TIPO_TERMINACION,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_TIPO_TERMINACION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_TIPO_TERMINACION,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_TIPO_TERMINACION AS ID_UNIQUE2\n" +
"    FROM(\n" +
"    \n" +
"        SELECT POSTGRES_TR_EXP_TERMINACION(FUERZA_MAYOR_TC, 'FUERZA_MAYOR_TC') AS ID_TIPO_TERMINACION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"  UNION ALL \n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_TERMINACION(INCAPACIDAD_FISICA_TC, 'INCAPACIDAD_FISICA_TC') AS ID_TIPO_TERMINACION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_TERMINACION(QUIEBRA_LEGAL_TC, 'QUIEBRA_LEGAL_TC') AS ID_TIPO_TERMINACION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_TERMINACION(AGOTAMIENTO_MATERIA_TC, 'AGOTAMIENTO_MATERIA_TC') AS ID_TIPO_TERMINACION,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "'  AND ID_TIPO_TERMINACION IS NOT NULL;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_TIPO_TERMINACION IS NOT NULL  ;" ); 
            }
              if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_TIPO_TERMINACION IS NOT NULL  ;" ); 
                  
            }
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Terminacion" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Terminacion_Insert(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = "  select \n" +
                            " ID_TIPO_TERMINACION ,\n" +
                            "ID_EXPEDIENTE\n" +
                            " from TR_EXP_TERMINACION ; ";  
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("")  ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == ""  && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
             
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_TERMINACION" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_TERMINACION" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append("  ) VALUES (");

                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
         
         
       public ArrayList<ArrayList<String>> DBO_Tr_Exp_Violacion(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "-----------------------------------------------------------------------------------------------------\n" +
"-- TR_EXP_VIOLACION \n" +
"-----------------------------------------------------------------------------------------------------\n" +
"\n" +
"SELECT \n" +
" ID_TIPO_VIOL_DH,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_TIPO_VIOL_DH,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_TIPO_VIOL_DH,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_TIPO_VIOL_DH AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_VIOLACION(LIBERTAD_ASOCIACION, 'LIBERTAD_ASOCIACION') AS ID_TIPO_VIOL_DH,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"\n" +
"  UNION ALL \n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_VIOLACION(LIBERTAD_SINDICAL, 'LIBERTAD_SINDICAL') AS ID_TIPO_VIOL_DH,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_VIOLACION(DERECHO_COLECTIVA, 'DERECHO_COLECTIVA') AS ID_TIPO_VIOL_DH,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_VIOLACION(OTRO_COLECTIVA, 'OTRO_COLECTIVA') AS ID_TIPO_VIOL_DH,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:3' AS ID_UNIQUE\n" +
"  FROM V3_TR_COLECTIVOJL\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""   && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND  ID_TIPO_VIOL_DH IS NOT NULL;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND  ID_TIPO_VIOL_DH IS NOT NULL  ;" ); 
            }
            
              if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")  AND  ID_TIPO_VIOL_DH IS NOT NULL ;" ); 
                  
            }
            
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Violacion" + ex);

            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Violacion_Insert(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = 
                    " select \n" +
                    " \n" +
                    " ID_TIPO_VIOL_DH,\n" +
                    "ID_EXPEDIENTE\n" +
                    " from TR_EXP_VIOLACION; "; 
          ResultSet rs = null;
          Statement stmt  = null;
        try{
           StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
             
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_VIOLACION" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_VIOLACION" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
                     
      public ArrayList<ArrayList<String>> DBO_Tr_Exp_Efecto_Sentencia(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "---TR_EXP_EFECTO_SENTENCIA\n" +
"SELECT \n" +
" ID_EFECTO_SENTENCIA,\n" +
"    ID_ORGANOJ,\n" +
"  0  ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_EFECTO_SENTENCIA,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_EFECTO_SENTENCIA,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_EFECTO_SENTENCIA AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT POSTGRES_TR_EXP_EFECTOS_SENTENCIA(AUMENTO_PERSONAL, 'AUMENTO_PERSONAL') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"\n" +
"  UNION ALL \n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(DISMINUCION_PERSONAL, 'DISMINUCION_PERSONAL') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(AUMENTO_JORNADALAB, 'AUMENTO_JORNADALAB') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(DISMINUCION_JORNADALAB, 'DISMINUCION_JORNADALAB') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(AUMENTO_SEMANA, 'AUMENTO_SEMANA') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(DISMINUCION_SEMANA, 'DISMINUCION_SEMANA') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(AUMENTO_SALARIOS, 'AUMENTO_SALARIOS') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(DISMINUCION_SALARIOS, 'DISMINUCION_SALARIOS') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
"  UNION ALL\n" +
"\n" +
"  SELECT\n" +
"\n" +
"      POSTGRES_TR_EXP_EFECTOS_SENTENCIA(OTRO_TIPO, 'OTRO_TIPO') AS ID_EFECTO_SENTENCIA,\n" +
"      CASE \n" +
"          WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"          THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"          ELSE CLAVE_ORGANO \n" +
"      END AS ID_ORGANOJ,\n" +
"      NULL AS ID_EXPEDIENTE,\n" +
"      PERIODO AS PERIODO,\n" +
"      'CO:' || \n" +
"      (\n" +
"          CASE \n" +
"              WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"              THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"              ELSE CLAVE_ORGANO \n" +
"          END\n" +
"      ) \n" +
"      || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:5' AS ID_UNIQUE\n" +
"\n" +
"  FROM V3_TR_COLECT_ECONOMJL\n" +
"\n" +
" ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND ID_EFECTO_SENTENCIA IS NOT NULL;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_EFECTO_SENTENCIA IS NOT NULL  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ") AND ID_EFECTO_SENTENCIA IS NOT NULL  ;" ); 
                  
            } 
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Efecto_Sentencia" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Efecto_Sentencia_Insert(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
            FileWriter file = new FileWriter(sqlVirgen, true);
              conexionDes = conexionDes.Conectar();
                String sql = " SELECT ID_EFECTO_SENTENCIA ,  \n" +
"ID_EXPEDIENTE   FROM  TR_EXP_EFECTOS_SENTENCIA; "; 
            ResultSet rs = null;
            Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
             
             
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();

                file.write("-- Datos exportados de " + "TR_EXP_EFECTOS_SENTENCIA" + "\n");

                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_EFECTOS_SENTENCIA" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }

                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    } 
                     
                
       public ArrayList<ArrayList<String>> DBO_Tr_Exp_Motivo_Solic(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = "--TR_EXP_MOTIVO_SOLIC\n" +
"\n" +
"SELECT \n" +
" ID_MOTIVO_SOL_PROMO,\n" +
"    ID_ORGANOJ,\n" +
" 0   ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"    FROM(\n" +
"SELECT \n" +
"UNIQUE(ID_UNIQUE2)ID_UNIQUE2,\n" +
"    ID_MOTIVO_SOL_PROMO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE\n" +
"   \n" +
"    FROM ( SELECT\n" +
"        ID_MOTIVO_SOL_PROMO,\n" +
"    ID_ORGANOJ,\n" +
"    ID_EXPEDIENTE,\n" +
"    PERIODO,\n" +
"    ID_UNIQUE,\n" +
"    ID_UNIQUE||'ID_MOT:'||ID_MOTIVO_SOL_PROMO AS ID_UNIQUE2\n" +
"    FROM(\n" +
"        SELECT\n" +
" \n" +
"    POSTGRES_TR_EXP_MOTIVO_SOLIC(MOTIVO_SOLICITUD, 'MOTIVO_SOLICITUD') AS ID_MOTIVO_SOL_PROMO,\n" +
"\n" +
"    CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END AS ID_ORGANOJ,\n" +
"\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"\n" +
"    PERIODO AS PERIODO,\n" +
"\n" +
"    'CO:' || \n" +
"\n" +
"    (\n" +
"\n" +
"        CASE \n" +
"\n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"            ELSE CLAVE_ORGANO \n" +
"\n" +
"        END\n" +
"\n" +
"    ) \n" +
"\n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:6' AS ID_UNIQUE\n" +
" \n" +
"FROM V3_TR_PARAPROCESALJL\n" +
" \n" +
" \n" +
"UNION ALL\n" +
" \n" +
"SELECT\n" +
" \n" +
"    POSTGRES_TR_EXP_MOTIVO_SOLIC(AVISO_ORGANO_JURIS, 'AVISO_ORGANO_JURIS') AS ID_MOTIVO_SOL_PROMO,\n" +
"\n" +
"    CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END AS ID_ORGANOJ,\n" +
"\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"\n" +
"    PERIODO AS PERIODO,\n" +
"\n" +
"    'CO:' || \n" +
"\n" +
"    (\n" +
"\n" +
"        CASE \n" +
"\n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"            ELSE CLAVE_ORGANO \n" +
"\n" +
"        END\n" +
"\n" +
"    ) \n" +
"\n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:8' AS ID_UNIQUE\n" +
" \n" +
"FROM V3_TR_PREF_CREDITOJL\n" +
" \n" +
" \n" +
"UNION ALL\n" +
" \n" +
"SELECT\n" +
" \n" +
"    POSTGRES_TR_EXP_MOTIVO_SOLIC(AVISO_AUTORIDAD_ADMIN, 'AVISO_AUTORIDAD_ADMIN') AS ID_MOTIVO_SOL_PROMO,\n" +
"\n" +
"    CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END AS ID_ORGANOJ,\n" +
"\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"\n" +
"    PERIODO AS PERIODO,\n" +
"\n" +
"    'CO:' || \n" +
"\n" +
"    (\n" +
"\n" +
"        CASE \n" +
"\n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"            ELSE CLAVE_ORGANO \n" +
"\n" +
"        END\n" +
"\n" +
"    ) \n" +
"\n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:8' AS ID_UNIQUE\n" +
" \n" +
"FROM V3_TR_PREF_CREDITOJL\n" +
" \n" +
" \n" +
"UNION ALL\n" +
" \n" +
"SELECT\n" +
" \n" +
"    POSTGRES_TR_EXP_MOTIVO_SOLIC(MOTIVO_SOLICITUD_EJ, 'MOTIVO_SOLICITUD_EJ') AS ID_MOTIVO_SOL_PROMO,\n" +
"\n" +
"    CASE \n" +
"\n" +
"        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"        ELSE CLAVE_ORGANO \n" +
"\n" +
"    END AS ID_ORGANOJ,\n" +
"\n" +
"    NULL AS ID_EXPEDIENTE,\n" +
"\n" +
"    PERIODO AS PERIODO,\n" +
"\n" +
"    'CO:' || \n" +
"\n" +
"    (\n" +
"\n" +
"        CASE \n" +
"\n" +
"            WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
"\n" +
"            THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
"\n" +
"            ELSE CLAVE_ORGANO \n" +
"\n" +
"        END\n" +
"\n" +
"    ) \n" +
"\n" +
"    || '-EXP:' || EXPEDIENTE_CLAVE || '-PE:' || PERIODO || '-TP:9' AS ID_UNIQUE\n" +
" \n" +
"FROM V3_TR_EJECUCIONJL\n" +
" \n" +
" \n" +
"  ) \n" +
") \n" +
");";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" &&  !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' AND ID_MOTIVO_SOL_PROMO IS NOT NULL;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" &&  !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' AND ID_MOTIVO_SOL_PROMO IS NOT NULL  ;" ); 
            }
            
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")  AND ID_MOTIVO_SOL_PROMO IS NOT NULL  ;" ); 
                  
            }
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Motivo_Solic" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Motivo_Solic_Insert(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = " SELECT ID_MOTIVO_SOL_PROMO , \n" +
                "ID_EXPEDIENTE FROM TR_EXP_MOTIVO_SOLIC  ; "; 
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("")  ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
               
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            } 
             
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));

                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();
                file.write("-- Datos exportados de " + "TR_EXP_MOTIVO_SOLIC" + "\n");
                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_MOTIVO_SOLIC" + " (");

                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("  ) VALUES (");
                    // Agregar valores
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }                 
           
                
         
         
           public ArrayList<ArrayList<String>> DBO_Tr_Exp_Actor(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = " SELECT *FROM ( SELECT act.ID_ACTOR,exp.id_organoj,exp.id_expediente,exp.periodo,act.ID_UNIQUE\n" +
"FROM TR_EXPEDIENTE@DESARROLLO2 exp\n" +
"JOIN TR_ACTOR@DESARROLLO2 act \n" +
"ON act.ID_UNIQUE ='CO:'||CAST(exp.id_organoj AS VARCHAR2(255)) ||'-EXP:'|| CAST(exp.CLAVE_EXPEDIENTE AS VARCHAR2(255)) ||'-PE:'|| CAST(exp.periodo AS VARCHAR2(255)) ||'-TP:'|| CAST(exp.id_tipo_expediente AS VARCHAR2(255)) );";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == ""  && !periodo.equals("")  ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
            
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Actor" + ex);
                throw ex;

            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Actor_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = " select \n" +
                    " ACTORES_ID ,\n" +
                    "ID_EXPEDIENTE\n" +
                    " from TR_EXP_ACTOR"; 
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
              consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                  consultaFiltro.append("     substr( id_organoj , 0, 2 )  =   " ); 
                  consultaFiltro.append("'" + cveEntidad + "' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            } 
             
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();
                file.write("-- Datos exportados de " + "TR_EXP_ACTOR" + "\n");
                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXP_ACTOR" + " (");
                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                   insertQuery.append("  ) VALUES (");
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }                 
           
         
         
              public ArrayList<ArrayList<String>> DBO_Tr_Exp_Demandado(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexion = conexion.Conectar();
        arrayList = new ArrayList<>();
        String sql = " --llenar tabla TR_EXP_DEMANDADO\n" +
" SELECT * FROM ( SELECT dem.id_demandado,exp.id_organoj,exp.id_expediente,exp.periodo,dem.ID_UNIQUE\n" +
"FROM TR_EXPEDIENTE@DESARROLLO2.INEGI.GOB.MX exp\n" +
"JOIN TR_DEMANDADO@DESARROLLO2.INEGI.GOB.MX dem \n" +
"ON dem.ID_UNIQUE ='CO:'||CAST(exp.id_organoj AS VARCHAR2(255)) ||'-EXP:'|| CAST(exp.CLAVE_EXPEDIENTE AS VARCHAR2(255)) ||'-PE:'|| CAST(exp.periodo AS VARCHAR2(255)) ||'-TP:'|| CAST(exp.id_tipo_expediente AS VARCHAR2(255)) );";
            try {
            Statement stmt = conexion.getConexion().createStatement();
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("  WHERE  ");
            if(!cveEntidad.equals("") &&  cveOrgano == "" && !periodo.equals("") ){
                consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
              if(!cveOrgano.equals("") &&  cveEntidad == "" && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "' ;" ); 
            }
              
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            }
            resul = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla Tr_Exp_Demandado" + ex);

            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
       
       
         public void DBO_Tr_Exp_Demandado_Inserts(String cveEntidad , String cveOrgano , String periodo , File sqlVirgen ) throws SQLException, IOException {
                FileWriter file = new FileWriter(sqlVirgen, true);
                  conexionDes = conexionDes.Conectar();
                    String sql = " select \n" +
                " ID_DEMANDADO ,\n" +
                "ID_EXPEDIENTE\n" +
                "\n" +
                " from TR_EXP_DEMANDADO; "; 
          ResultSet rs = null;
          Statement stmt  = null;
        try{
            StringBuilder consultaFiltro = new StringBuilder();
            consultaFiltro.append(sql.replace(";", ""));
            consultaFiltro.append("   where  ");
            if(!cveEntidad.equals("") &&  cveOrgano == ""  && !periodo.equals("") ){
                  consultaFiltro.append(" ID_ORGANOJ  like  " ); 
                  consultaFiltro.append("'" + cveEntidad + "%' and " ); 
                  consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
             }
             if(!cveOrgano.equals("") &&  cveEntidad == ""  && !periodo.equals("") ){
                   consultaFiltro.append(" ID_ORGANOJ =  " ); 
                   consultaFiltro.append("'" + cveOrgano  + "' and " ); 
                   consultaFiltro.append("periodo = '" + periodo  + "'  ;" ); 
            }
            if(!cveOrgano.equals("") &&  cveEntidad == "" && periodo.equals("") ){
                 //      consultaFiltro.append(" CLAVE_ORGANO =  " ); 
                       consultaFiltro.append(" id_organoj  IN (" ); 
                       consultaFiltro.append( cveOrgano + ")" ); 
                  
            } 
             stmt = conexionDes.getConexion().createStatement();
             rs = stmt.executeQuery(consultaFiltro.toString().replace(";", ""));
                ResultSetMetaData metaData = rs.getMetaData();
                int columnas = metaData.getColumnCount();
                file.write("-- Datos exportados de " + "TR_EXPED_DEMANDADO" + "\n");
                while (rs.next()) {
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO " + "public.TR_EXPED_DEMANDADO" + " (");
                    // Agregar nombres de columnas
                    for (int i = 1; i <= columnas; i++) {
                        insertQuery.append(metaData.getColumnName(i));
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append("  ) VALUES (");
                    for (int i = 1; i <= columnas; i++) {
                        String valor = rs.getString(i);
                        insertQuery.append(valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'"); // Manejo de NULL y comillas
                        if (i < columnas) insertQuery.append(", ");
                    }
                    insertQuery.append(" );\n");
                    file.write(insertQuery.toString());
                }
              file.close();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
             try {
                    if (rs != null) {
                        rs.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }                 
           
        
          
        
        

  }
    

