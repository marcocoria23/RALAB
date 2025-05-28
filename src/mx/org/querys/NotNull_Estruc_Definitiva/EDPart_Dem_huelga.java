/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

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
public class EDPart_Dem_huelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

///Demandado no debe de ser 9=No identificado
    public ArrayList DemandadoNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_TIPO_EXPEDIENTE, S.ID_TIPO_DEMANDADO\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_DEMANDADO Q\n"
                + "  ON P.ID_EXPEDIENTE = Q.ID_EXPEDIENTE AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_DEMANDADO S\n"
                + "  ON Q.ID_DEMANDADO = S.ID_DEMANDADO AND Q.ID_ORGANOJ = S.ID_ORGANOJ AND Q.PERIODO = S.PERIODO\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_TIPO_DEMANDADO = '-1' )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_DEMANDADO"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDPart_Dem_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Cuando Tipo=Persona fisica no debe de capturar desde Razon social hasta longitud
    public ArrayList Persona_fisica() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_TIPO_EXPEDIENTE, S.ID_TIPO_PATRON, S.RAZON_SOCIAL\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_DEMANDADO Q\n"
                + "  ON P.ID_EXPEDIENTE = Q.ID_EXPEDIENTE AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_DEMANDADO S\n"
                + "  ON Q.ID_DEMANDADO = S.ID_DEMANDADO AND Q.ID_ORGANOJ = S.ID_ORGANOJ AND Q.PERIODO = S.PERIODO\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 4\n"
                + "AND S.ID_TIPO_PATRON = 1\n"
                + "AND (S.RAZON_SOCIAL IS NOT NULL\n"
                + "OR S.CALLE IS NOT NULL\n"
                + "OR S.NUM_EXTERIOR IS NOT NULL\n"
                + "OR S.NUM_INTERIOR IS NOT NULL\n"
                + "OR S.COLONIA IS NOT NULL\n"
                + "OR S.CP IS NOT NULL\n"
                + "OR S.ID_ENT_MPIO IS NOT NULL\n"
                + "OR S.LATITUD IS NOT NULL\n"
                + "OR S.LONGITUD IS NOT NULL  ))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_PATRON"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDPart_Dem_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
