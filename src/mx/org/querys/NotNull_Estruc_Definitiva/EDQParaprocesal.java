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
import Screen_laborales.PValidacion;
import mx.org.querys.V1querys;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQParaprocesal {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND (FECHA_APERTURA_EXPED > SYSDATE\n"
                + "AND FECHA_APERTURA_EXPED   <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)   ='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                      ='" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ                 ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                      ='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_APERTURA_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_PRESENTA_SOLI_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_PRESENT_PROMO,'DD/MM/YYYY')FECHA_PRESENT_PROMO,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND (FECHA_PRESENT_PROMO    > SYSDATE\n"
                + "AND FECHA_PRESENT_PROMO      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_PRESENT_PROMO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ADMISION_SOLI_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_ADMISION_PROMO,'DD/MM/YYYY')FECHA_ADMISION_PROMO,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND (FECHA_ADMISION_PROMO    > SYSDATE AND FECHA_ADMISION_PROMO      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_ADMISION_PROMO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_CONCLUSION_EXPE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, \n"
                + "  TO_CHAR(FECHA_CONCLUY_EXPED,'DD/MM/YYYY')FECHA_CONCLUY_EXPED,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND (FECHA_CONCLUY_EXPED  > SYSDATE\n"
                + "AND FECHA_CONCLUY_EXPED    <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "' )) ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_CONCLUY_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Duplicidad_expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n" +
"                   TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n" +
"                   TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2\n" +
"                 FROM TR_EXPEDIENTE\n" +
"                 WHERE ID_ORGANOJ||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))||PERIODO IN\n" +
"                   (SELECT ID_ORGANOJ||CLAVE_EXPEDIENTE2||PERIODO\n" +
"                   FROM\n" +
"                     (SELECT ID_ORGANOJ,\n" +
"                       COUNT(CLAVE_EXPEDIENTE2)CUENTACLAVE_EXPEDIENTE2,\n" +
"                       CLAVE_EXPEDIENTE2, PERIODO\n" +
"                     FROM\n" +
"                       (SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE,\n" +
"                         TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,\n" +
"                         PERIODO\n" +
"                       FROM TR_EXPEDIENTE\n" +
"                       WHERE (((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n" +
"                       AND PERIODO                    ='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = '6' ))\n" +
"                       OR ((ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n" +
"                       AND PERIODO                    ='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = '6' )))\n" +
"                       ORDER BY ID_ORGANOJ, CLAVE_EXPEDIENTE2 )\n" +
"                     GROUP BY ID_ORGANOJ, CLAVE_EXPEDIENTE2, PERIODO )\n" +
"                   WHERE CUENTACLAVE_EXPEDIENTE2 > 1 )\n" +
"                 ORDER BY ID_ORGANOJ, CLAVE_EXPEDIENTE2";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_PresentacionNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_PRESENT_PROMO,'dd/mm/yyyy')FECHA_PRESENT_PROMO\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "  AND to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PRESENT_PROMO,'dd/mm/yyyy')\n"
                + "  )\n"
                + "WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_PRESENT_PROMO   <> '09/09/1899'\n"
                + "AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_PRESENT_PROMO   <> '09/09/1899'\n"
                + "AND PERIODO                = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_PRESENT_PROMO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ls fecha de admision de la demanda no debe de ser menor a la fecha depresentacion de la demanda
    public ArrayList Fecha_PresentacionAdmiNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_ADMISION_PROMO,'dd/mm/yyyy')FECHA_ADMISION_PROMO,\n"
                + "    TO_CHAR(FECHA_PRESENT_PROMO,'dd/mm/yyyy')FECHA_PRESENT_PROMO\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "  AND to_date(FECHA_ADMISION_PROMO,'dd/mm/yyyy') < to_date(FECHA_PRESENT_PROMO,'dd/mm/yyyy'))\n"
                + "WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_PRESENT_PROMO   <> '09/09/1899'\n"
                + "AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_PRESENT_PROMO   <> '09/09/1899'\n"
                + "AND PERIODO                = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_ADMISION_PROMO"),
                    resul.getString("FECHA_PRESENT_PROMO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la fecha de admision no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Admision_SoliNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_ADMISION_PROMO,'DD/MM/YYYY') FECHA_ADMISION_PROMO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND to_date(FECHA_ADMISION_PROMO,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND (FECHA_ADMISION_PROMO   <> '09/09/1899' AND FECHA_ADMISION_PROMO   <> '09/09/1899'))\n"
                + "WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ADMISION_PROMO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la fecha de conclusion del expediente no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Conclusion_ExpeNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, comentarios,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_CONCLUY_EXPED,'DD/MM/YYYY') FECHA_CONCLUY_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 6\n"
                + "AND to_date(FECHA_CONCLUY_EXPED,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND (FECHA_CONCLUY_EXPED   <> '09/09/1899' AND FECHA_CONCLUY_EXPED   <> '09/09/1899'))\n"
                + "WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_CONCLUY_EXPED"),
                    resul.getString("comentarios")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
