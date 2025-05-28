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
public class EDPart_Act_Individual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

///Actor no debe ser No identificado
    public ArrayList ActorNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT T1.ID_ORGANOJ, T1.PERIODO, T1.ID_ACTOR, T1.ID_TIPO_ACTOR, T1.ID_UNIQUE, T3.CLAVE_EXPEDIENTE\n"
                + "FROM TR_ACTOR T1\n"
                + "LEFT JOIN TR_EXP_ACTOR T2\n"
                + "ON T1.ID_ORGANOJ = T2.ID_ORGANOJ AND T1.ID_ACTOR = T2.ACTORES_ID AND T1.PERIODO = T2.PERIODO\n"
                + "LEFT JOIN TR_EXPEDIENTE T3\n"
                + "ON T2.ID_ORGANOJ = T3.ID_ORGANOJ AND T2.ID_EXPEDIENTE = T3.ID_EXPEDIENTE AND T2.PERIODO = T3.PERIODO\n"
                + "WHERE (T1.ID_TIPO_ACTOR = '-1' OR T1.ID_TIPO_ACTOR IS NULL)\n"
                + "AND T3.ID_TIPO_EXPEDIENTE = 2)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)=  '" + PValidacion.clave_entidad + "' AND periodo='" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ='" + PValidacion.clave_organo + "' AND periodo='" + PValidacion.periodo + "' )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_ACTOR"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_Individual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///CUANDO ACTOR = Beneficiario u Otro  no debe capturar desde Sexo hasta jornada
    public ArrayList Actor_otro() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT T1.ID_ORGANOJ, T1.PERIODO, T1.ID_ACTOR, T1.ID_TIPO_ACTOR, T1.ID_UNIQUE, T3.CLAVE_EXPEDIENTE\n"
                + "FROM TR_ACTOR T1\n"
                + "LEFT JOIN TR_EXP_ACTOR T2\n"
                + "ON T1.ID_ORGANOJ = T2.ID_ORGANOJ AND T1.ID_ACTOR = T2.ACTORES_ID AND T1.PERIODO = T2.PERIODO\n"
                + "LEFT JOIN TR_EXPEDIENTE T3\n"
                + "ON T2.ID_ORGANOJ = T3.ID_ORGANOJ AND T2.ID_EXPEDIENTE = T3.ID_EXPEDIENTE AND T2.PERIODO = T3.PERIODO\n"
                + "WHERE T1.ID_TIPO_ACTOR IN (6,7)\n"
                + "AND (ID_SEXO IS NOT NULL\n"
                + "OR EDAD IS NOT NULL\n"
                + "OR ID_OCUPACION IS NOT NULL\n"
                + "OR NSS IS NOT NULL\n"
                + "OR CURP IS NOT NULL\n"
                + "OR RFC IS NOT NULL\n"
                + "OR ID_JORNADA IS NOT NULL)\n"
                + "AND T3.ID_TIPO_EXPEDIENTE = 2)\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "AND PERIODO = '"+PValidacion.periodo+"')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_ACTOR")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_Individual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
