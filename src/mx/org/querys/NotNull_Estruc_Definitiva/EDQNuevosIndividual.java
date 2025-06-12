/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexionDesarrollo;
import Conexion.OracleConexionNE;
import Screen_laborales.PValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.querys.V1querys;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQNuevosIndividual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql, NMunicipio;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList IndividualEstatusAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED=1\n"
                + "AND ID_FASE_SOL_EXPED=3\n"
                + "AND ID_TIPO_EXPEDIENTE=2\n"
                + "AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n"
                + "AND ((ID_ORGANOJ='+claveorgano+' AND PERIODO='+periodo+') OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusTA(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 4\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 1\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 2\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "                OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Si en los campos ¿Hubo tramitación  por auto de depuración? (PREG_AUTO_DEPURACION_TRAM), ¿Hubo celebración de audiencia preliminar?(PREG_AUD_PRELIM_CELEBR) y ¿Hubo celebración de audiencia de juicio? (PREG_CELEBRA_AUD_JUICIO) se selecciona la opcion Sí, en el campo Estatus de la demanda (ID_ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList IndividualEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_DEMANDA <> 1\n"
                + "AND (PREG_AUD_PRELIM_CELEBR = 1 OR PREG_CELEBRA_AUD_JUICIO = 1 OR PREG_AUTO_DEPURACION_TRAM = 1)\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Si se encuentra registro en los campos Forma de solución (ID_FORMA_SOLUCION), Fecha en la que se dictó la resolución (FECHA_DICTO_SOLUCION), Tipo sentencia (ID_TIPO_SENTENCIA) y Monto estipulado en la forma de solución(MONTO_SOLUCION), el campo Fase en la que se solucionó el expediente (ID_FASE_SOL_EXPED) debe seleccionar alguna de estas opciones Audiencia preliminar, Audiencia de juicio, Tramitación por auto de depuración ó Tramitación sin audiencias.
    public ArrayList IndividualFaseSolExp(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ((ID_FASE_SOL_EXPED IN '-1') OR (ID_FASE_SOL_EXPED IS NULL)) \n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL)\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
