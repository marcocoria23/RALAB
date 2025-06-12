/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexionDesarrollo;
import Conexion.OracleConexionNE;
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
public class EDQNuevosHuelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql, NMunicipio;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList HuelgaEstatusEH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO,ID_ESTATUS_EXPED,ID_FASE_SOL_EXPED,FECHA_DICTO_SOLUCION, ID_TIPO_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 5\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND FECHA_DICTO_SOLUCION IS NULL\n"
                + "AND ((ID_ORGANOJ = '" + claveorgano + "' AND PERIODO = '" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + entidad + "' AND PERIODO = '" + periodo + "'))";
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

    public ArrayList HuelgaEstatusPH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO,ID_ESTATUS_EXPED,ID_FASE_SOL_EXPED,FECHA_DICTO_SOLUCION, ID_TIPO_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 6\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND FECHA_DICTO_SOLUCION IS NULL\n"
                + "AND ((ID_ORGANOJ = '" + claveorgano + "' AND PERIODO = '" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + entidad + "' AND PERIODO = '" + periodo + "'))";
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

    public ArrayList HuelgaEstatusH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO,ID_ESTATUS_EXPED,ID_FASE_SOL_EXPED,FECHA_DICTO_SOLUCION, ID_TIPO_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ESTATUS_EXPED = 1\n"
                + "AND ID_FASE_SOL_EXPED = 7\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND FECHA_DICTO_SOLUCION IS NULL\n"
                + "AND ((ID_ORGANOJ = '" + claveorgano + "' AND PERIODO = '" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + entidad + "' AND PERIODO = '" + periodo + "'))";
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

    //Si se encuentra registro en los campos Forma de solución (ID_FORMA_SOLUCION), Fecha en la que se dictó la resolución (FECHA_DICTO_SOLUCION), Porcentaje solicitado (PORCENT_SOLICITADO) y Porcentaje otorgado (PORCENT_OTORGADO), el campo Fase en la que se solucionó el expediente (ID_FASE_SOL_EXPED) debe contener la opcion Emplazamiento a huelga ó Prehuelga.
    public ArrayList HuelgaFaseSolExp(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS, ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ((ID_FASE_SOL_EXPED IN '-1') OR (ID_FASE_SOL_EXPED IS NULL))\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR PORCENT_SOLICITADO IS NOT NULL\n"
                + "OR PORCENT_OTORGADO IS NOT NULL)\n"
                + "AND ((ID_ORGANOJ = '" + claveorgano + "' AND PERIODO = '" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + entidad + "' AND PERIODO = '" + periodo + "'))";
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

    //Si se encuentra registro en los campos Forma de solución (ID_FORMA_SOLUCION), Fecha en la que se dictó la resolución (FECHA_DICTO_SOLUCION), Tipo sentencia (ID_TIPO_SENTENCIA), Tipo de sentencia (ID_TIPO_SENTENCIA), Fecha de estallamiento de la huelga (FECHA_HUELGA_ESTALLA), etc., el campo Fase en la que se solucionó el expediente (ID_FASE_SOL_EXPED) debe contener la opción de Huelga.
    public ArrayList HuelgaFaseSolExpHu(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS, ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4 \n"
                + "AND ((ID_FASE_SOL_EXPED IN '-1') OR (ID_FASE_SOL_EXPED IS NULL))\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR FECHA_HUELGA_ESTALLA IS NOT NULL\n"
                + "OR FECHA_HUELGA_LEVANTAM IS NOT NULL\n"
                + "OR HUELGA_DIAS IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL\n"
                + "OR PORCENT_SALARIOS_CAIDOS IS NOT NULL )\n"
                + "AND ((ID_ORGANOJ = '"+ claveorgano +"' AND PERIODO = '"+periodo+"')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '"+ entidad +"' AND PERIODO = '"+periodo+"'))";
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
