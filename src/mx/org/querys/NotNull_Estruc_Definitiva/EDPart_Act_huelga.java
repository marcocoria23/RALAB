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
import mx.org.querys.NotNull.V3Ordinario;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDPart_Act_huelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

///Actor no debe ser No identificado
    public ArrayList ActorNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_EXPEDIENTE, P.ID_TIPO_EXPEDIENTE, ID_TIPO_ACTOR\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_ACTOR S\n"
                + "  ON P.ID_ORGANOJ = S.ID_ORGANOJ AND P.ID_EXPEDIENTE = S.ID_EXPEDIENTE AND P.PERIODO = S.PERIODO\n"
                + "LEFT JOIN TR_ACTOR Q\n"
                + "  ON S.ACTORES_ID = Q.ID_ACTOR AND S.ID_ORGANOJ = Q.ID_ORGANOJ AND S.PERIODO = Q.PERIODO\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 4\n"
                + "AND Q.ID_TIPO_ACTOR = '-1' )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')";
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
            Logger.getLogger(EDPart_Act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//CUANDO ACTOR = Otro  no debe capturar desde Nombre del sindicato hasta No_identificado.
    public ArrayList Actor_Otro() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_TIPO_EXPEDIENTE, S.ID_TIPO_ACTOR, S.NOMBRE_SINDICATO\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_ACTOR Q\n"
                + "  ON P.ID_EXPEDIENTE = Q.ID_EXPEDIENTE AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_ACTOR S\n"
                + "  ON Q.ACTORES_ID = S.ID_ACTOR AND Q.ID_ORGANOJ = S.ID_ORGANOJ AND Q.PERIODO = S.PERIODO\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 4\n"
                + "AND S.ID_TIPO_ACTOR = 7\n"
                + "AND (NOMBRE_SINDICATO IS NOT NULL\n"
                + "OR REGISTRO_ASO_SINDICAL IS NOT NULL\n"
                + "OR ID_TIPO_SINDICATO IS NOT NULL\n"
                + "OR PREG_SIND_PERT_ORG_O IS NOT NULL\n"
                + "OR ID_ORG_OBR IS NOT NULL\n"
                + "OR CANT_TRAB_INVOL_H IS NOT NULL\n"
                + "OR CANT_TRAB_INVOL_M IS NOT NULL\n"
                + "OR CANT_TRAB_INVOL_NI IS NOT NULL ))\n"
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
                    resul.getString("ID_TIPO_ACTOR"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//-CUANDO ACTOR = Mayoria_de_Trabajadores  no debe capturar desde Nombre del sindicato hasta Especifique (otra organización obrera)
    public ArrayList Actor_Mayoria() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO ,P.ID_EXPEDIENTE, P.ID_TIPO_EXPEDIENTE, ID_TIPO_ACTOR\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_ACTOR Q\n"
                + "  ON P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.ID_EXPEDIENTE = Q.ID_EXPEDIENTE AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_ACTOR S\n"
                + "  ON Q.ACTORES_ID = S.ID_ACTOR AND Q.ID_ORGANOJ = S.ID_ORGANOJ AND Q.PERIODO = S.PERIODO\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 4\n"
                + "AND S.ID_TIPO_ACTOR = 5 )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')";
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
            Logger.getLogger(EDPart_Act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
