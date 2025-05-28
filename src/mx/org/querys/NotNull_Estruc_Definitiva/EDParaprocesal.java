/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexion;
import Conexion.OracleConexionDesarrollo;
import Screen_laborales.PValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDParaprocesal {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

//Estatus del expediente no debe de ser 9=No_identificado.
    public ArrayList Estatus_expedienteNi() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND ID_ESTATUS_EXPED = '-1')\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "' AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_entidad + "' AND PERIODO = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDParaprocesal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
    public ArrayList IncompetenciaNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_TIPO_INCOMPETENCIA, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND ID_TIPO_INCOMPETENCIA = '-1')\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "' AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_entidad + "' AND PERIODO = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_INCOMPETENCIA"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDParaprocesal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
    public ArrayList PivIncompetencia() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_TIPO_INCOMPETENCIA, FECHA_PRESENT_PROMO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND ID_TIPO_INCOMPETENCIA = 1\n"
                + "AND (FECHA_PRESENT_PROMO IS NOT NULL\n"
                + "OR FECHA_ADMISION_PROMO IS NOT NULL\n"
                + "OR ID_PROMOVENTE IS NOT NULL\n"
                + "OR ID_ESTATUS_EXPED IS NOT NULL\n"
                + "OR FECHA_CONCLUY_EXPED IS NOT NULL))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "  OR (ID_ORGANOJ ='" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')";
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_INCOMPETENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDParaprocesal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Estatus_Expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_CONCLUY_EXPED\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND ID_ESTATUS_EXPED = 2\n"
                + "AND FECHA_CONCLUY_EXPED IS NOT NULL)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "  OR (ID_ORGANOJ ='" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDParaprocesal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
