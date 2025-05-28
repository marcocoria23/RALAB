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
import mx.org.querys.V1querys;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQAudiencias {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList FECHA_AUDIEN_CELEBRADA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, ID_EXPEDIENTE, periodo, TO_CHAR(FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_AUDIENCIA\n"
                + "WHERE \n"
                + "(FECHA_CELEBRACION > SYSDATE \n"
                + "AND FECHA_CELEBRACION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ) or  (ID_ORGANOJ='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_CELEBRACION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FORMATO_INICIO() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from(select \n"
                + "TR_AUDIENCIA.ID_ORGANOJ,\n"
                + "  TR_AUDIENCIA.ID_EXPEDIENTE,\n"
                + " TR_AUDIENCIA.ID_AUDIENCIA,\n"
                + " tc_procedimiento.descripcion TIPO_PROCED,\n"
                + " INICIO,\n"
                + " CASE WHEN LENGTH(regexp_replace(INICIO, '[^0-9]', ''))=4 THEN SUBSTR(regexp_replace(INICIO, '[^0-9]', ''),0,2) \n"
                + " WHEN LENGTH(regexp_replace(INICIO, '[^0-9]', ''))=3 THEN SUBSTR(regexp_replace(INICIO, '[^0-9]', ''),0,1) END CAM_INICIO, \n"
                + " TR_AUDIENCIA.PERIODO \n"
                + " from TR_AUDIENCIA INNER JOIN TR_EXPEDIENTE ON TR_AUDIENCIA.ID_EXPEDIENTE = TR_EXPEDIENTE.ID_EXPEDIENTE\n"
                + "INNER JOIN TC_PROCEDIMIENTO ON tc_procedimiento.id_tipo_procedimiento = TR_EXPEDIENTE.id_tipo_expediente) WHERE ((INICIO NOT LIKE '%:%' or REPLACE(length(TRIM(INICIO)),' ','')<5 or CAM_INICIO IN ('1','01','2','02','3','03','4','04','5','05','6','06')) AND\n"
                + " (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO='" + PValidacion.periodo + "')) OR ((INICIO NOT LIKE '%:%' or REPLACE(length(TRIM(INICIO)),' ','')<5 or CAM_INICIO IN ('1','01','2','02','3','03','4','04','5','05','6','06')) AND\n"
                + " (ID_ORGANOJ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO='" + PValidacion.periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("ID_AUDIENCIA"),
                    resul.getString("TIPO_PROCED"),
                    resul.getString("INICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FORMATO_CONCLU() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n" +
"    SELECT \n" +
"        TR_AUDIENCIA.ID_ORGANOJ,\n" +
"        TR_AUDIENCIA.ID_EXPEDIENTE,\n" +
"        TR_AUDIENCIA.ID_AUDIENCIA,\n" +
"        TC_PROCEDIMIENTO.DESCRIPCION AS TIPO_PROCED,\n" +
"        CONCLUSION,\n" +
"        CASE \n" +
"            WHEN LENGTH(REGEXP_REPLACE(CONCLUSION, '[^0-9]', '')) = 4 THEN SUBSTR(REGEXP_REPLACE(CONCLUSION, '[^0-9]', ''), 1, 2)\n" +
"            WHEN LENGTH(REGEXP_REPLACE(CONCLUSION, '[^0-9]', '')) = 3 THEN SUBSTR(REGEXP_REPLACE(CONCLUSION, '[^0-9]', ''), 1, 1)\n" +
"        END AS CAM_CONCLU,\n" +
"        TR_AUDIENCIA.PERIODO\n" +
"    FROM TR_AUDIENCIA\n" +
"    INNER JOIN TR_EXPEDIENTE ON TR_AUDIENCIA.ID_EXPEDIENTE = TR_EXPEDIENTE.ID_EXPEDIENTE\n" +
"    INNER JOIN TC_PROCEDIMIENTO ON TC_PROCEDIMIENTO.ID_TIPO_PROCEDIMIENTO = TR_EXPEDIENTE.ID_TIPO_EXPEDIENTE\n" +
")\n" +
"WHERE \n" +
"(\n" +
"    (CONCLUSION NOT LIKE '%:%' OR LENGTH(TRIM(CONCLUSION)) < 5 OR CAM_CONCLU IN ('1','01','2','02','3','03','4','04','5','05','6','06'))\n" +
"    AND (SUBSTR(ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PERIODO = '"+PValidacion.periodo+"')\n" +
")\n" +
"OR \n" +
"(\n" +
"    (CONCLUSION NOT LIKE '%:%' OR LENGTH(TRIM(CONCLUSION)) < 5 OR CAM_CONCLU IN ('1','01','2','02','3','03','4','04','5','05','6','06'))\n" +
"    AND (ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PERIODO = '"+PValidacion.periodo+"')\n" +
")";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("ID_AUDIENCIA"),
                    resul.getString("TIPO_PROCED"),
                    resul.getString("CONCLUSION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList SEGUNDOS_INICIO() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "TR_AUDIENCIA.ID_ORGANOJ,\n"
                + "  TR_AUDIENCIA.ID_EXPEDIENTE,\n"
                + " TR_AUDIENCIA.ID_AUDIENCIA,\n"
                + "  tc_procedimiento.descripcion TIPO_PROCED,\n"
                + " TR_AUDIENCIA.INICIO,\n"
                + " TR_AUDIENCIA.PERIODO\n"
                + " from TR_AUDIENCIA INNER JOIN TR_EXPEDIENTE ON TR_AUDIENCIA.ID_EXPEDIENTE = TR_EXPEDIENTE.ID_EXPEDIENTE"
                + " INNER JOIN TC_PROCEDIMIENTO ON tc_procedimiento.id_tipo_procedimiento = TR_EXPEDIENTE.id_tipo_expediente"
                + " WHERE ((SUBSTR(regexp_replace(TR_AUDIENCIA.INICIO, '[^0-9]', ''),-2)>59) AND (SUBSTR(TR_AUDIENCIA.ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "') AND (TR_AUDIENCIA.INICIO NOT IN ('99:99')) ) OR \n"
                + "((SUBSTR(regexp_replace(TR_AUDIENCIA.INICIO, '[^0-9]', ''),-2)>59) AND (TR_AUDIENCIA.ID_ORGANOJ='" + PValidacion.clave_organo + "' AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "') AND (TR_AUDIENCIA.INICIO NOT IN ('99:99')) )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("ID_AUDIENCIA"),
                    resul.getString("TIPO_PROCED"),
                    resul.getString("INICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList SEGUNDOS_CONCLU() { //aqui vamos
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "TR_AUDIENCIA.ID_ORGANOJ,\n"
                + "  TR_AUDIENCIA.ID_EXPEDIENTE,\n"
                + " TR_AUDIENCIA.ID_AUDIENCIA,\n"
                + "  tc_procedimiento.descripcion TIPO_PROCED, \n"
                + " TR_AUDIENCIA.CONCLUSION,\n"
                + " TR_AUDIENCIA.PERIODO\n"
                + " from TR_AUDIENCIA INNER JOIN TR_EXPEDIENTE ON TR_AUDIENCIA.ID_EXPEDIENTE = TR_EXPEDIENTE.ID_EXPEDIENTE"
                + " INNER JOIN TC_PROCEDIMIENTO ON tc_procedimiento.id_tipo_procedimiento = TR_EXPEDIENTE.id_tipo_expediente"
                + " WHERE ((SUBSTR(regexp_replace(CONCLUSION, '[^0-9]', ''),-2)>59) AND (SUBSTR(TR_AUDIENCIA.ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "') AND (CONCLUSION NOT IN ('99:99'))) OR \n"
                + "((SUBSTR(regexp_replace(CONCLUSION, '[^0-9]', ''),-2)>59) AND (TR_AUDIENCIA.ID_ORGANOJ='" + PValidacion.clave_organo + "' AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "') AND (CONCLUSION NOT IN ('99:99')))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("ID_AUDIENCIA"),
                    resul.getString("TIPO_PROCED"),
                    resul.getString("CONCLUSION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList CONCLU_MENOR() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM("
                + "select \n"
                + "TR_AUDIENCIA.ID_ORGANOJ,\n"
                + "TR_AUDIENCIA.ID_EXPEDIENTE,\n"
                + "TR_AUDIENCIA.ID_AUDIENCIA,\n"
                + "tc_procedimiento.descripcion TIPO_PROCED, \n"
                + "TR_AUDIENCIA.PERIODO,\n"
                + "case when length(INICIO)<5 then '0'||inicio else INICIO end inicio,\n"
                + "case when length(CONCLUSION)<5 then '0'||CONCLUSION else CONCLUSION end CONCLUSION \n"
                + " from TR_AUDIENCIA INNER JOIN TR_EXPEDIENTE ON TR_AUDIENCIA.ID_EXPEDIENTE = TR_EXPEDIENTE.ID_EXPEDIENTE"
                + " INNER JOIN TC_PROCEDIMIENTO ON tc_procedimiento.id_tipo_procedimiento = TR_EXPEDIENTE.id_tipo_expediente"
                + " WHERE (TO_TIMESTAMP(CONCLUSION,'HH24:MI') < TO_TIMESTAMP(inicio,'HH24:MI') and (SUBSTR(regexp_replace(CONCLUSION, '[^0-9]', ''),-2)<60) and (SUBSTR(regexp_replace(INICIO, '[^0-9]', ''),-2)<60) AND SUBSTR(TR_AUDIENCIA.ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "' AND CONCLUSION like ('%:%') and inicio like ('%:%')) OR (TR_AUDIENCIA.ID_ORGANOJ='" + PValidacion.clave_organo + "' AND TR_AUDIENCIA.PERIODO='" + PValidacion.periodo + "' AND  (SUBSTR(regexp_replace(CONCLUSION, '[^0-9]', ''),-2)<60) and (SUBSTR(regexp_replace(INICIO, '[^0-9]', ''),-2)<60) AND TO_TIMESTAMP(CONCLUSION,'HH24:MI') < TO_TIMESTAMP(inicio,'HH24:MI') AND CONCLUSION like ('%:%') and inicio like ('%:%'))  \n"
                + " ) WHERE INICIO NOT IN ('99:99') OR CONCLUSION NOT IN ('99:99')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("ID_EXPEDIENTE"),
                    resul.getString("ID_AUDIENCIA"),
                    resul.getString("TIPO_PROCED"),
                    resul.getString("INICIO"),
                    resul.getString("CONCLUSION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
