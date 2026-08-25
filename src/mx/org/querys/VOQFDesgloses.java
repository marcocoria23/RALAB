/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys;

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
public class VOQFDesgloses {

    OracleConexionRalFed conexion = new OracleConexionRalFed();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Desglose_Ordinario() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_ORDINARIO\n"
                + "FROM (SELECT SUM(ORDINARIO) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_ORDINARIO FROM TR_FED_ORDINARIO) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_ORDINARIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_Individual() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_INDIVIDUAL\n"
                + "FROM (SELECT SUM(ESPECIAL_INDIVI) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_INDIVIDUAL FROM tr_fed_individual) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_INDIVIDUAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_Colectivo() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_COLECTIVO\n"
                + "FROM (SELECT SUM(ESPECIAL_COLECT) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_COLECTIVO FROM TR_FED_COLECTIVO) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_COLECTIVO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_Huelga() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_HUELGA\n"
                + "FROM (SELECT SUM(HUELGA) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_HUELGA FROM TR_FED_HUELGA) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_HUELGA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_SegSocial() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_SEGURIDAD_SOCIAL\n"
                + "FROM (SELECT SUM(SEGURIDAD_SOCIAL) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_SEGURIDAD_SOCIAL FROM tr_fed_seg_social) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_SEGURIDAD_SOCIAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_ColectivoEconomico() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_COL_NATU_ECONOMICA\n"
                + "FROM (SELECT SUM(COL_NATU_ECONOMICA) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_COL_NATU_ECONOMICA FROM tr_fed_colectivo_economico) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_COL_NATU_ECONOMICA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_Paraprocesal() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_PARAPROC\n"
                + "FROM (SELECT SUM(PARAP_VOLUNTARIO) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_PARAPROC FROM tr_fed_paraprocesal) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_PARAPROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Desglose_Ejecucion() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT c.TOTAL_EXPED, o.TOTAL_EJECUCION\n"
                + "FROM (SELECT SUM(EJECUCION) AS TOTAL_EXPED FROM TR_FED_CONTROL_EXPEDIENTE) c\n"
                + "CROSS JOIN (SELECT COUNT(*) AS TOTAL_EJECUCION FROM tr_fed_ejecucion) o";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TOTAL_EXPED"),
                    resul.getString("TOTAL_EJECUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
