/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.query.federal;

import Conexion.OracleConexionRalFed;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class RF_Fechas_Colectivo {

    OracleConexionRalFed conexion = new OracleConexionRalFed();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Fed_Colec_Fechas_Futuras() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "\n"
                + "    rtrim(\n"
                + "        CASE\n"
                + "            WHEN fecha_presentacion > sysdate THEN\n"
                + "                'FECHA_PRESENTACION ('\n"
                + "                || to_char(fecha_presentacion, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        ||\n"
                + "        CASE\n"
                + "            WHEN fecha_apertura_expediente > sysdate THEN\n"
                + "                'FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                || to_char(fecha_apertura_expediente, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        ||\n"
                + "        CASE\n"
                + "            WHEN fecha_adm_demanda > sysdate THEN\n"
                + "                'FECHA_ADM_DEMANDA ('\n"
                + "                || to_char(fecha_adm_demanda, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        ||\n"
                + "        CASE\n"
                + "            WHEN fecha_depuracion > sysdate THEN\n"
                + "                'FECHA_DEPURACION ('\n"
                + "                || to_char(fecha_adm_demanda, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        ||\n"
                + "        CASE\n"
                + "            WHEN fecha_aud_juicio > sysdate THEN\n"
                + "                'FECHA_AUD_JUICIO ('\n"
                + "                || to_char(fecha_aud_juicio, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        ||\n"
                + "        CASE\n"
                + "            WHEN fecha_ult_act_proc > sysdate THEN\n"
                + "                'FECHA_ULT_ACT_PROC ('\n"
                + "                || to_char(fecha_ult_act_proc, 'DD/MM/YYYY')\n"
                + "                || ') es mayor al día de hoy, '\n"
                + "            ELSE ''\n"
                + "        END\n"
                + "        || CASE\n"
                + "        WHEN fecha_dicto_solucion > sysdate THEN\n"
                + "            'FECHA_DICTO_SOLUCION ('\n"
                + "            || to_char(fecha_dicto_solucion, 'DD/MM/YYYY')\n"
                + "            || ') es mayor al día de hoy, '\n"
                + "        ELSE ''\n"
                + "    END,\n"
                + "        ', ') AS campos_con_error\n"
                + "FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "WHERE\n"
                + "    FECHA_PRESENTACION> SYSDATE OR\n"
                + "FECHA_APERTURA_EXPEDIENTE> SYSDATE OR\n"
                + "FECHA_ADM_DEMANDA> SYSDATE OR\n"
                + "FECHA_DEPURACION> SYSDATE OR\n"
                + "FECHA_AUD_JUICIO> SYSDATE OR\n"
                + "FECHA_ULT_ACT_PROC> SYSDATE OR\n"
                + "FECHA_DICTO_SOLUCION> SYSDATE \n"
                + "\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FPresentacion() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "               FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + " \n"
                + "        NULLIF(fecha_presentacion, DATE '1899-09-09')\n"
                + "            AS fecha_presentacion_valida,\n"
                + "        NULLIF(fecha_apertura_expediente, DATE '1899-09-09')\n"
                + "            AS fecha_apertura_expediente_valida,\n"
                + "        NULLIF(fecha_adm_demanda, DATE '1899-09-09')\n"
                + "            AS fecha_adm_demanda_valida,\n"
                + "            NULLIF(fecha_depuracion, DATE '1899-09-09')\n"
                + "            AS fecha_depuracion_valida,\n"
                + "        NULLIF(fecha_aud_juicio, DATE '1899-09-09')\n"
                + "            AS fecha_aud_juicio_valida,\n"
                + "        NULLIF(fecha_ult_act_proc, DATE '1899-09-09')\n"
                + "            AS fecha_ult_act_proc_valida, \n"
                + "        NULLIF(fecha_dicto_solucion, DATE '1899-09-09')\n"
                + "            AS fecha_dicto_solucion_valida\n"
                + "    FROM tr_fed_COLECTIVO\n"
                + "),\n"
                + "validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "                FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + " \n"
                + "        RTRIM(\n"
                + "            CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_apertura_expediente_valida\n"
                + "                THEN\n"
                + "                    'FECHA_APERTURA_EXPEDIENTE (' ||\n"
                + "                    TO_CHAR(fecha_apertura_expediente, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_adm_demanda_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_adm_demanda_valida\n"
                + "                THEN\n"
                + "                    'FECHA_ADM_DEMANDA (' ||\n"
                + "                    TO_CHAR(fecha_adm_demanda, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_depuracion_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_depuracion_valida\n"
                + "                THEN\n"
                + "                    'FECHA_DEPURACION (' ||\n"
                + "                    TO_CHAR(fecha_depuracion, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "             ||\n"
                + "            \n"
                + "            CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_aud_juicio_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_aud_juicio_valida\n"
                + "                THEN\n"
                + "                    'FECHA_AUD_JUICIO (' ||\n"
                + "                    TO_CHAR(fecha_aud_juicio, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "||\n"
                + "            CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_ult_act_proc_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_ult_act_proc_valida\n"
                + "                THEN\n"
                + "                    'FECHA_ULT_ACT_PROC (' ||\n"
                + "                    TO_CHAR(fecha_ult_act_proc, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "           \n"
                + "            ||\n"
                + "            CASE\n"
                + "                WHEN fecha_presentacion_valida IS NOT NULL\n"
                + "                 AND fecha_dicto_solucion_valida IS NOT NULL\n"
                + "                 AND fecha_presentacion_valida >\n"
                + "                     fecha_dicto_solucion_valida\n"
                + "                THEN\n"
                + "                    'FECHA_DICTO_SOLUCION (' ||\n"
                + "                    TO_CHAR(fecha_dicto_solucion, 'DD/MM/YYYY') ||\n"
                + "                    ') es menor que FECHA_PRESENTACION (' ||\n"
                + "                    TO_CHAR(fecha_presentacion, 'DD/MM/YYYY') ||\n"
                + "                    '), '\n"
                + "                ELSE ''\n"
                + "            END,\n"
                + "            ', '\n"
                + "        ) AS campos_con_error\n"
                + "    FROM fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "          FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM validacion\n"
                + "WHERE campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FApertura_Expe() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        nullif(fecha_presentacion, DATE '1899-09-09')        AS fecha_presentacion_valida,\n"
                + "        nullif(fecha_apertura_expediente, DATE '1899-09-09') AS fecha_apertura_expediente_valida,\n"
                + "        nullif(fecha_adm_demanda, DATE '1899-09-09')         AS fecha_adm_demanda_valida,\n"
                + "        nullif(fecha_depuracion, DATE '1899-09-09')          AS fecha_depuracion_valida,\n"
                + "        nullif(fecha_aud_juicio, DATE '1899-09-09')          AS fecha_aud_juicio_valida,\n"
                + "        nullif(fecha_ult_act_proc, DATE '1899-09-09')        AS fecha_ult_act_proc_valida,\n"
                + "        nullif(fecha_dicto_solucion, DATE '1899-09-09')      AS fecha_dicto_solucion_valida\n"
                + "    FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "), validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        rtrim(\n"
                + "            CASE\n"
                + "                WHEN\n"
                + "                    fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                    AND fecha_adm_demanda_valida IS NOT NULL\n"
                + "                    AND fecha_apertura_expediente_valida > fecha_adm_demanda_valida\n"
                + "                THEN\n"
                + "                    'FECHA_ADM_DEMANDA ('\n"
                + "                    || to_char(fecha_adm_demanda, 'DD/MM/YYYY')\n"
                + "                    || ') es menor que FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                    || to_char(FECHA_APERTURA_EXPEDIENTE, 'DD/MM/YYYY')\n"
                + "                    || '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE\n"
                + "                WHEN\n"
                + "                    fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                    AND fecha_depuracion_valida IS NOT NULL\n"
                + "                    AND fecha_apertura_expediente_valida > fecha_depuracion_valida\n"
                + "                THEN\n"
                + "                    'FECHA_DEPURACION ('\n"
                + "                    || to_char(fecha_depuracion, 'DD/MM/YYYY')\n"
                + "                    || ') es menor que FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                    || to_char(FECHA_APERTURA_EXPEDIENTE, 'DD/MM/YYYY')\n"
                + "                    || '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            \n"
                + "            CASE\n"
                + "                WHEN\n"
                + "                    fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                    AND fecha_aud_juicio_valida IS NOT NULL\n"
                + "                    AND fecha_apertura_expediente_valida > fecha_aud_juicio_valida\n"
                + "                THEN\n"
                + "                    'FECHA_AUD_JUICIO ('\n"
                + "                    || to_char(fecha_aud_juicio, 'DD/MM/YYYY')\n"
                + "                    || ') es menor que FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                    || to_char(FECHA_APERTURA_EXPEDIENTE, 'DD/MM/YYYY')\n"
                + "                    || '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE\n"
                + "                WHEN\n"
                + "                    fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                    AND fecha_ult_act_proc_valida IS NOT NULL\n"
                + "                    AND fecha_apertura_expediente_valida > fecha_ult_act_proc_valida\n"
                + "                THEN\n"
                + "                    'FECHA_ULT_ACT_PROC ('\n"
                + "                    || to_char(fecha_ult_act_proc, 'DD/MM/YYYY')\n"
                + "                    || ') es menor que FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                    || to_char(FECHA_APERTURA_EXPEDIENTE, 'DD/MM/YYYY')\n"
                + "                    || '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            || CASE\n"
                + "            WHEN\n"
                + "                fecha_apertura_expediente_valida IS NOT NULL\n"
                + "                AND fecha_dicto_solucion_valida IS NOT NULL\n"
                + "                AND fecha_apertura_expediente_valida > fecha_dicto_solucion_valida\n"
                + "            THEN\n"
                + "                'FECHA_DICTO_SOLUCION ('\n"
                + "                || to_char(fecha_dicto_solucion, 'DD/MM/YYYY')\n"
                + "                || ') es menor que FECHA_APERTURA_EXPEDIENTE ('\n"
                + "                || to_char(FECHA_APERTURA_EXPEDIENTE, 'DD/MM/YYYY')\n"
                + "                || '), '\n"
                + "            ELSE ''\n"
                + "        END,\n"
                + "            ', ') AS campos_con_error\n"
                + "    FROM\n"
                + "        fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "        FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM\n"
                + "    validacion\n"
                + "WHERE\n"
                + "    campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FAdmision_Demanda() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        nullif(fecha_presentacion, DATE '1899-09-09')        AS fecha_presentacion_valida,\n"
                + "        nullif(fecha_apertura_expediente, DATE '1899-09-09') AS fecha_apertura_expediente_valida,\n"
                + "        nullif(fecha_adm_demanda, DATE '1899-09-09')         AS fecha_adm_demanda_valida,\n"
                + "        nullif(fecha_depuracion, DATE '1899-09-09')          AS fecha_depuracion_valida,\n"
                + "        nullif(fecha_aud_juicio, DATE '1899-09-09')          AS fecha_aud_juicio_valida,\n"
                + "        nullif(fecha_ult_act_proc, DATE '1899-09-09')        AS fecha_ult_act_proc_valida,\n"
                + "        nullif(fecha_dicto_solucion, DATE '1899-09-09')      AS fecha_dicto_solucion_valida\n"
                + "    FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "), validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        rtrim(\n"
                + "            CASE WHEN fecha_adm_demanda_valida IS NOT NULL AND fecha_depuracion_valida IS NOT NULL AND fecha_adm_demanda_valida > fecha_depuracion_valida\n"
                + "                THEN 'FECHA_DEPURACION ('|| to_char(fecha_depuracion, 'DD/MM/YYYY')|| ') es menor que FECHA_ADM_DEMANDA (' || to_char(fecha_adm_demanda, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE WHEN fecha_adm_demanda_valida IS NOT NULL AND fecha_aud_juicio_valida IS NOT NULL AND fecha_adm_demanda_valida > fecha_aud_juicio_valida\n"
                + "                THEN 'FECHA_AUD_JUICIO ('|| to_char(fecha_aud_juicio, 'DD/MM/YYYY')|| ') es menor que FECHA_ADM_DEMANDA ('|| to_char(fecha_adm_demanda, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE WHEN fecha_adm_demanda_valida IS NOT NULL AND fecha_ult_act_proc_valida IS NOT NULL AND fecha_adm_demanda_valida > fecha_ult_act_proc_valida\n"
                + "                THEN 'FECHA_ULT_ACT_PROC ('|| to_char(fecha_ult_act_proc, 'DD/MM/YYYY')|| ') es menor que FECHA_ADM_DEMANDA ('|| to_char(fecha_adm_demanda, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            || \n"
                + "            CASE WHEN fecha_adm_demanda_valida IS NOT NULL AND fecha_dicto_solucion_valida IS NOT NULL AND fecha_adm_demanda_valida > fecha_dicto_solucion_valida\n"
                + "            THEN 'FECHA_DICTO_SOLUCION ('|| to_char(fecha_dicto_solucion, 'DD/MM/YYYY')|| ') es menor que FECHA_ADM_DEMANDA ('|| to_char(fecha_adm_demanda, 'DD/MM/YYYY')|| '), '\n"
                + "            ELSE ''\n"
                + "        END,\n"
                + "            ', ') AS campos_con_error\n"
                + "    FROM\n"
                + "        fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "        FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM\n"
                + "    validacion\n"
                + "WHERE\n"
                + "    campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FDepuracion() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "           FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        nullif(fecha_presentacion, DATE '1899-09-09')        AS fecha_presentacion_valida,\n"
                + "        nullif(fecha_apertura_expediente, DATE '1899-09-09') AS fecha_apertura_expediente_valida,\n"
                + "        nullif(fecha_adm_demanda, DATE '1899-09-09')         AS fecha_adm_demanda_valida,\n"
                + "        nullif(fecha_depuracion, DATE '1899-09-09')          AS fecha_depuracion_valida,\n"
                + "        nullif(fecha_aud_juicio, DATE '1899-09-09')          AS fecha_aud_juicio_valida,\n"
                + "        nullif(fecha_ult_act_proc, DATE '1899-09-09')        AS fecha_ult_act_proc_valida,\n"
                + "        nullif(fecha_dicto_solucion, DATE '1899-09-09')      AS fecha_dicto_solucion_valida\n"
                + "    FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "), validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        rtrim(\n"
                + "            \n"
                + "            \n"
                + "            CASE WHEN fecha_depuracion_valida IS NOT NULL AND fecha_aud_juicio_valida IS NOT NULL AND fecha_depuracion_valida > fecha_aud_juicio_valida\n"
                + "                THEN 'FECHA_AUD_JUICIO ('|| to_char(fecha_aud_juicio, 'DD/MM/YYYY')|| ') es menor que FECHA_DEPURACION ('|| to_char(fecha_depuracion, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            ||\n"
                + "            CASE WHEN fecha_depuracion_valida IS NOT NULL AND fecha_ult_act_proc_valida IS NOT NULL AND fecha_depuracion_valida > fecha_ult_act_proc_valida\n"
                + "                THEN 'FECHA_ULT_ACT_PROC ('|| to_char(fecha_ult_act_proc, 'DD/MM/YYYY')|| ') es menor que FECHA_DEPURACION ('|| to_char(fecha_depuracion, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            || \n"
                + "            CASE WHEN fecha_depuracion_valida IS NOT NULL AND fecha_dicto_solucion_valida IS NOT NULL AND fecha_depuracion_valida > fecha_dicto_solucion_valida\n"
                + "            THEN 'FECHA_DICTO_SOLUCION ('|| to_char(fecha_dicto_solucion, 'DD/MM/YYYY')|| ') es menor que FECHA_DEPURACION ('|| to_char(fecha_depuracion, 'DD/MM/YYYY')|| '), '\n"
                + "            ELSE ''\n"
                + "        END,\n"
                + "            ', ') AS campos_con_error\n"
                + "    FROM\n"
                + "        fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "        FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM\n"
                + "    validacion\n"
                + "WHERE\n"
                + "    campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FAudiencia_Juicio() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "          FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        nullif(fecha_presentacion, DATE '1899-09-09')        AS fecha_presentacion_valida,\n"
                + "        nullif(fecha_apertura_expediente, DATE '1899-09-09') AS fecha_apertura_expediente_valida,\n"
                + "        nullif(fecha_adm_demanda, DATE '1899-09-09')         AS fecha_adm_demanda_valida,\n"
                + "        nullif(fecha_depuracion, DATE '1899-09-09')          AS fecha_depuracion_valida,\n"
                + "        nullif(fecha_aud_juicio, DATE '1899-09-09')          AS fecha_aud_juicio_valida,\n"
                + "        nullif(fecha_ult_act_proc, DATE '1899-09-09')        AS fecha_ult_act_proc_valida,\n"
                + "        nullif(fecha_dicto_solucion, DATE '1899-09-09')      AS fecha_dicto_solucion_valida\n"
                + "    FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "), validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        rtrim(\n"
                + "            \n"
                + "            \n"
                + "           \n"
                + "            CASE WHEN fecha_aud_juicio_valida IS NOT NULL AND fecha_ult_act_proc_valida IS NOT NULL AND fecha_aud_juicio_valida > fecha_ult_act_proc_valida\n"
                + "                THEN 'FECHA_ULT_ACT_PROC ('|| to_char(fecha_ult_act_proc, 'DD/MM/YYYY')|| ') es menor que FECHA_AUD_JUICIO ('|| to_char(fecha_aud_juicio, 'DD/MM/YYYY')|| '), '\n"
                + "                ELSE ''\n"
                + "            END\n"
                + "            || \n"
                + "            CASE WHEN fecha_aud_juicio_valida IS NOT NULL AND fecha_dicto_solucion_valida IS NOT NULL AND fecha_aud_juicio_valida > fecha_dicto_solucion_valida\n"
                + "            THEN 'FECHA_DICTO_SOLUCION ('|| to_char(fecha_dicto_solucion, 'DD/MM/YYYY')|| ') es menor que FECHA_AUD_JUICIO ('|| to_char(fecha_aud_juicio, 'DD/MM/YYYY')|| '), '\n"
                + "            ELSE ''\n"
                + "        END,\n"
                + "            ', ') AS campos_con_error\n"
                + "    FROM\n"
                + "        fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "        FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM\n"
                + "    validacion\n"
                + "WHERE\n"
                + "    campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_Colec_FUltimo_Acto_Procesal() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "WITH fechas AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "           FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        nullif(fecha_presentacion, DATE '1899-09-09')        AS fecha_presentacion_valida,\n"
                + "        nullif(fecha_apertura_expediente, DATE '1899-09-09') AS fecha_apertura_expediente_valida,\n"
                + "        nullif(fecha_adm_demanda, DATE '1899-09-09')         AS fecha_adm_demanda_valida,\n"
                + "        nullif(fecha_depuracion, DATE '1899-09-09')          AS fecha_depuracion_valida,\n"
                + "        nullif(fecha_aud_juicio, DATE '1899-09-09')          AS fecha_aud_juicio_valida,\n"
                + "        nullif(fecha_ult_act_proc, DATE '1899-09-09')        AS fecha_ult_act_proc_valida,\n"
                + "        nullif(fecha_dicto_solucion, DATE '1899-09-09')      AS fecha_dicto_solucion_valida\n"
                + "    FROM\n"
                + "        tr_fed_COLECTIVO\n"
                + "), validacion AS (\n"
                + "    SELECT\n"
                + "        nombre_organo_juris,\n"
                + "        id_organoj,\n"
                + "        clave_expediente,\n"
                + "            FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "        rtrim(\n"
                + "             \n"
                + "            CASE WHEN fecha_ult_act_proc IS NOT NULL AND fecha_dicto_solucion_valida IS NOT NULL AND fecha_ult_act_proc > fecha_dicto_solucion_valida\n"
                + "            THEN 'FECHA_DICTO_SOLUCION ('|| to_char(fecha_dicto_solucion, 'DD/MM/YYYY')|| ') es menor que FECHA_ULT_ACT_PROC ('|| to_char(fecha_ult_act_proc, 'DD/MM/YYYY')|| '), '\n"
                + "            ELSE ''\n"
                + "        END,\n"
                + "            ', ') AS campos_con_error\n"
                + "    FROM\n"
                + "        fechas\n"
                + ")\n"
                + "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "        FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "FECHA_DEPURACION,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "    campos_con_error\n"
                + "FROM\n"
                + "    validacion\n"
                + "WHERE\n"
                + "    campos_con_error IS NOT NULL\n"
                + "ORDER BY\n"
                + "    nombre_organo_juris,\n"
                + "    clave_expediente";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("campos_con_error")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Colectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
