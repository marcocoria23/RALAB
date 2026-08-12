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
public class RF_Fechas_Incompetencias {

    OracleConexionRalFed conexion = new OracleConexionRalFed();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Fed_FIColectivo() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    preg_constancia,\n"
                + "    preg_excep_concilia,\n"
                + "    preg_prevencion,\n"
                + "    id_estatus_demanda,\n"
                + "    id_causa_imp_dem,\n"
                + "    fecha_adm_demanda,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    preg_tramitacion_depuracion,\n"
                + "    fecha_depuracion,\n"
                + "    preg_celebra_aud_juicio,\n"
                + "    fecha_aud_juicio,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    id_sentido_senten,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_colectivo\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR preg_constancia IS NOT NULL\n"
                + "        OR preg_excep_concilia IS NOT NULL\n"
                + "        OR preg_prevencion IS NOT NULL\n"
                + "        OR id_estatus_demanda IS NOT NULL\n"
                + "        OR id_causa_imp_dem IS NOT NULL\n"
                + "        OR fecha_adm_demanda IS NOT NULL\n"
                + "        OR cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR preg_tramitacion_depuracion IS NOT NULL\n"
                + "        OR fecha_depuracion IS NOT NULL\n"
                + "        OR preg_celebra_aud_juicio IS NOT NULL\n"
                + "        OR fecha_aud_juicio IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR id_sentido_senten IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FIColectivo_Economico() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    preg_constancia,\n"
                + "    preg_excep_concilia,\n"
                + "    preg_prevencion,\n"
                + "    id_estatus_demanda,\n"
                + "    id_causa_imp_dem,\n"
                + "    fecha_adm_demanda,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    preg_celebra_aud_econom,\n"
                + "    fecha_aud_econom,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    id_sentido_senten,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_colectivo_economico\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR preg_constancia IS NOT NULL\n"
                + "        OR preg_excep_concilia IS NOT NULL\n"
                + "        OR preg_prevencion IS NOT NULL\n"
                + "        OR id_estatus_demanda IS NOT NULL\n"
                + "        OR id_causa_imp_dem IS NOT NULL\n"
                + "        OR fecha_adm_demanda IS NOT NULL\n"
                + "        OR cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR preg_celebra_aud_econom IS NOT NULL\n"
                + "        OR fecha_aud_econom IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR id_sentido_senten IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FIHuelga() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    preg_estallamiento,\n"
                + "    fecha_estallamiento,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_huelga\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR preg_estallamiento IS NOT NULL\n"
                + "        OR fecha_estallamiento IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FIIndividual() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    preg_constancia,\n"
                + "    preg_excep_concilia,\n"
                + "    preg_prevencion,\n"
                + "    id_estatus_demanda,\n"
                + "    id_causa_imp_dem,\n"
                + "    fecha_adm_demanda,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    preg_tramitacion_depuracion,\n"
                + "    fecha_depuracion,\n"
                + "    preg_aud_prelim_celebr,\n"
                + "    fecha_audiencia_prelim,\n"
                + "    preg_celebra_aud_juicio,\n"
                + "    fecha_aud_juicio,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    id_sentido_senten,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_individual\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR preg_constancia IS NOT NULL\n"
                + "        OR preg_excep_concilia IS NOT NULL\n"
                + "        OR preg_prevencion IS NOT NULL\n"
                + "        OR id_estatus_demanda IS NOT NULL\n"
                + "        OR id_causa_imp_dem IS NOT NULL\n"
                + "        OR fecha_adm_demanda IS NOT NULL\n"
                + "        OR cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR preg_tramitacion_depuracion IS NOT NULL\n"
                + "        OR fecha_depuracion IS NOT NULL\n"
                + "        OR preg_aud_prelim_celebr IS NOT NULL\n"
                + "        OR fecha_audiencia_prelim IS NOT NULL\n"
                + "        OR preg_celebra_aud_juicio IS NOT NULL\n"
                + "        OR fecha_aud_juicio IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR id_sentido_senten IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FIOrdinario() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    preg_constancia,\n"
                + "    preg_excep_concilia,\n"
                + "    preg_prevencion,\n"
                + "    id_estatus_demanda,\n"
                + "    id_causa_imp_dem,\n"
                + "    fecha_adm_demanda,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    preg_aud_prelim_celebr,\n"
                + "    fecha_audiencia_prelim,\n"
                + "    preg_celebra_aud_juicio,\n"
                + "    fecha_aud_juicio,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    fecha_sentencia,\n"
                + "    id_sentido_senten,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_ordinario\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR preg_constancia IS NOT NULL\n"
                + "        OR preg_excep_concilia IS NOT NULL\n"
                + "        OR preg_prevencion IS NOT NULL\n"
                + "        OR id_estatus_demanda IS NOT NULL\n"
                + "        OR id_causa_imp_dem IS NOT NULL\n"
                + "        OR fecha_adm_demanda IS NOT NULL\n"
                + "        OR cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR preg_aud_prelim_celebr IS NOT NULL\n"
                + "        OR fecha_audiencia_prelim IS NOT NULL\n"
                + "        OR preg_celebra_aud_juicio IS NOT NULL\n"
                + "        OR fecha_aud_juicio IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR fecha_sentencia IS NOT NULL\n"
                + "        OR id_sentido_senten IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FIParaprocesal() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    id_estatus_soli,\n"
                + "    fecha_adm_solicitud,\n"
                + "    id_promovente,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_dicto_solucion,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_paraprocesal\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR id_estatus_soli IS NOT NULL\n"
                + "        OR fecha_adm_solicitud IS NOT NULL\n"
                + "        OR id_promovente IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fed_FISeg_Social() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT\n"
                + "    nombre_organo_juris,\n"
                + "    id_organoj,\n"
                + "    clave_expediente,\n"
                + "    fecha_apertura_expediente,\n"
                + "    preg_incompetencia,\n"
                + "    id_tipo_incompetencia,\n"
                + "    fecha_presentacion,\n"
                + "    preg_constancia,\n"
                + "    preg_excep_concilia,\n"
                + "    preg_prevencion,\n"
                + "    id_estatus_demanda,\n"
                + "    id_causa_imp_dem,\n"
                + "    fecha_adm_demanda,\n"
                + "    cant_actores,\n"
                + "    cant_demandados,\n"
                + "    preg_aud_prelim_celebr,\n"
                + "    fecha_audiencia_prelim,\n"
                + "    preg_celebra_aud_juicio,\n"
                + "    fecha_aud_juicio,\n"
                + "    id_estatus_exped,\n"
                + "    fecha_ult_act_proc,\n"
                + "    id_fase_sol_exped,\n"
                + "    id_forma_solucion,\n"
                + "    fecha_dicto_solucion,\n"
                + "    id_sentido_senten,\n"
                + "    'Si el campo PREG_INCOMPETENCIA tiene SI=1, a partir del campo posterior a ID_TIPO_INCOMPETENCIA no debe traer ningún dato' AS observacion\n"
                + "FROM tr_fed_seg_social\n"
                + "WHERE preg_incompetencia = 1\n"
                + "  AND (\n"
                + "        fecha_presentacion IS NOT NULL\n"
                + "        OR preg_constancia IS NOT NULL\n"
                + "        OR preg_excep_concilia IS NOT NULL\n"
                + "        OR preg_prevencion IS NOT NULL\n"
                + "        OR id_estatus_demanda IS NOT NULL\n"
                + "        OR id_causa_imp_dem IS NOT NULL\n"
                + "        OR fecha_adm_demanda IS NOT NULL\n"
                + "        OR cant_actores IS NOT NULL\n"
                + "        OR cant_demandados IS NOT NULL\n"
                + "        OR preg_aud_prelim_celebr IS NOT NULL\n"
                + "        OR fecha_audiencia_prelim IS NOT NULL\n"
                + "        OR preg_celebra_aud_juicio IS NOT NULL\n"
                + "        OR fecha_aud_juicio IS NOT NULL\n"
                + "        OR id_estatus_exped IS NOT NULL\n"
                + "        OR fecha_ult_act_proc IS NOT NULL\n"
                + "        OR id_fase_sol_exped IS NOT NULL\n"
                + "        OR id_forma_solucion IS NOT NULL\n"
                + "        OR fecha_dicto_solucion IS NOT NULL\n"
                + "        OR id_sentido_senten IS NOT NULL\n"
                + "      )";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("id_organoj"),
                    resul.getString("clave_expediente"),
                    resul.getString("observacion")});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RF_Fechas_Incompetencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
