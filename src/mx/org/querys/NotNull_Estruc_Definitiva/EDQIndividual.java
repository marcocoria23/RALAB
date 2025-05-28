/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexionDesarrollo;
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
public class EDQIndividual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') \n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE \n"
                + "(FECHA_APERTURA_EXPED> SYSDATE \n"
                + "AND FECHA_APERTURA_EXPED <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
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

    public ArrayList FECHA_PRES_DEMANDA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_PRESENT_DEMANDA,'DD/MM/YYYY')FECHA_PRESENT_DEMANDA,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_PRESENT_DEMANDA> SYSDATE \n"
                + "AND FECHA_PRESENT_DEMANDA <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_PRESENT_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ADMI_DEMANDA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_ADM_DEMANDA,'DD/MM/YYYY')FECHA_ADM_DEMANDA,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_ADM_DEMANDA> SYSDATE \n"
                + "AND FECHA_ADM_DEMANDA <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and periodo='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_ADM_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_DEPURACION_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_AUTO_DEPURACION,'DD/MM/YYYY')FECHA_AUTO_DEPURACION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_AUTO_DEPURACION> SYSDATE \n"
                + "AND FECHA_AUTO_DEPURACION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_AUTO_DEPURACION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_AUDIENCIA_PRELIM_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_AUDIENCIA_PRELIM,'DD/MM/YYYY')FECHA_AUDIENCIA_PRELIM,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_AUDIENCIA_PRELIM> SYSDATE \n"
                + "AND FECHA_AUDIENCIA_PRELIM <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_AUDIENCIA_PRELIM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_AUDIENCIA_JUICIO_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_AUD_JUICIO,'DD/MM/YYYY')FECHA_AUD_JUICIO,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_AUD_JUICIO> SYSDATE \n"
                + "AND FECHA_AUD_JUICIO <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_AUD_JUICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ACTO_PROCESAL_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_ULT_ACT_PROC,'DD/MM/YYYY')FECHA_ULT_ACT_PROC,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_ULT_ACT_PROC> SYSDATE \n"
                + "AND FECHA_ULT_ACT_PROC <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_DICTO_RESOLUCION_AD_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_DICTO_SOLUCION> SYSDATE \n"
                + "AND FECHA_DICTO_SOLUCION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_RESOLUCION_TA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_DICTO_SOLUCION> SYSDATE \n"
                + "AND FECHA_DICTO_SOLUCION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_DICTO_RESOLUCION_AP_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_DICTO_SOLUCION> SYSDATE \n"
                + "AND FECHA_DICTO_SOLUCION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_DICTO_RESOLUCION_AJ_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "WHERE \n"
                + "(FECHA_DICTO_SOLUCION> SYSDATE \n"
                + "AND FECHA_DICTO_SOLUCION <> '09/09/1899')\n"
                + "and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and PERIODO='" + PValidacion.periodo + "' ) \n"
                + "or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and PERIODO='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
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
        sql = "SELECT * FROM (SELECT ID_TIPO_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,PERIODO \n" +
"                 FROM TR_EXPEDIENTE WHERE ID_TIPO_EXPEDIENTE = 2) \n" +
"                 WHERE ID_ORGANOJ||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))||PERIODO\n" +
"                 IN(\n" +
"                 SELECT ID_ORGANOJ||CLAVE_EXPEDIENTE2||PERIODO FROM(\n" +
"                 SELECT ID_ORGANOJ,COUNT(CLAVE_EXPEDIENTE2)CUENTACLAVE_EXPEDIENTE2,CLAVE_EXPEDIENTE2,PERIODO FROM(\n" +
"                 select ID_ORGANOJ,CLAVE_EXPEDIENTE,TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,PERIODO from TR_EXPEDIENTE \n" +
"                 WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' AND PERIODO='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 2) or (ID_ORGANOJ='" + PValidacion.clave_organo + "' AND PERIODO='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 2)  \n" +
"                 ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2)\n" +
"                 GROUP BY ID_ORGANOJ,CLAVE_EXPEDIENTE2,PERIODO)WHERE CUENTACLAVE_EXPEDIENTE2>1)\n" +
"                 ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2";
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
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave,ID_ORGANOJ, CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA,PERIODO\n"
                + "from TR_EXPEDIENTE\n"
                + "WHERE to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')) where  PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and PERIODO = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_PRESENT_DEMANDA")
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
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_ADM_DEMANDA,'dd/mm/yyyy')FECHA_ADM_DEMANDA,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA,PERIODO \n"
                + "from TR_EXPEDIENTE \n"
                + "WHERE to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')) where  PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and PERIODO = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_ADM_DEMANDA"),
                    resul.getString("FECHA_PRESENT_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la fecha de admision no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Admi_demandaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_ADM_DEMANDA,'DD/MM/YYYY') FECHA_ADM_DEMANDA ,PERIODO,COMENTARIOS\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_ADM_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_ADM_DEMANDA <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ADM_DEMANDA"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha de auto de depuración no debe de ser menor o igual  a la fecha de apertura del expediente
    public ArrayList Fecha_DepuracionNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_AUTO_DEPURACION,'DD/MM/YYYY') FECHA_AUTO_DEPURACION  ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_AUTO_DEPURACION <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_AUTO_DEPURACION <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_AUTO_DEPURACION,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUTO_DEPURACION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha de audiencia preliminar no debe de ser menor o igual a la fecha de apertura del expediente
    public ArrayList Fecha_Audiencia_PrelimNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_AUDIENCIA_PRELIM,'DD/MM/YYYY') FECHA_AUDIENCIA_PRELIM  ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_AUDIENCIA_PRELIM <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_AUDIENCIA_PRELIM <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_AUDIENCIA_PRELIM,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUDIENCIA_PRELIM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha de audiencia de juicio no debe de ser menor o igual a la fecha de apertura del expediente
    public ArrayList Fecha_Audiencia_JuicioNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_AUD_JUICIO,'DD/MM/YYYY') FECHA_AUD_JUICIO ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_AUD_JUICIO <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_AUD_JUICIO <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "') where  to_date(FECHA_AUD_JUICIO,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUD_JUICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha del último acto procesal no debe de ser menor  a la fecha de apertura del expediente
    public ArrayList Fecha_Acto_procesalNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_ULT_ACT_PROC,'DD/MM/YYYY') FECHA_ULT_ACT_PROC ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_ULT_ACT_PROC <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_ULT_ACT_PROC <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_ULT_ACT_PROC,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la  Fecha en la que se dictó la resolución (auto depuracion) no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Dicto_Resolucion_AdNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION  ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la  Fecha en la que se dictó la resolución (Tramitación sin audiencias) no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Resolucion_TaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION  ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la  Fecha en la que se dictó la resolución  (Audiencia preliminar) no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Resolucion_ApNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION ,PERIODO\n"
                + "from TR_EXPEDIENTE where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la  Fecha en la que se dictó la resolución  (Audiencia de juicio) no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Resolucion_AjNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION ,PERIODO\n"
                + "from TR_EXPEDIENTE where  PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'  and ID_ORGANOJ='" + PValidacion.clave_entidad + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_DICTO_SOLUCION <> '09/09/1899'\n"
                + "and PERIODO = '" + PValidacion.periodo + "' ) where  to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

// LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
    public ArrayList Fecha_Aud_Presentacion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT SUBSTR(P.ID_ORGANOJ,0,2) AS ENTIDAD_CLAVE,\n"
                + "    P.ID_ORGANOJ,\n"
                + "    S.CLAVE_EXPEDIENTE,\n"
                + "    TO_CHAR(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,\n"
                + "    TO_CHAR(S.FECHA_PRESENT_DEMANDA,'DD/MM/YYYY') FECHA_PRESENT_DEMANDA,\n"
                + "    S.ID_TIPO_EXPEDIENTE ,\n"
                + "    P.PERIODO,\n"
                + "    P.ID_AUDIENCIA\n"
                + "  FROM TR_AUDIENCIA P,\n"
                + "    TR_EXPEDIENTE S\n"
                + "  WHERE P.ID_ORGANOJ                          =S.ID_ORGANOJ\n"
                + "  AND S.CLAVE_EXPEDIENTE                      =S.CLAVE_EXPEDIENTE\n"
                + "  AND P.PERIODO                               =S.PERIODO\n"
                + "  AND P.ID_EXPEDIENTE                         = S.ID_EXPEDIENTE\n"
                + "  AND S.ID_TIPO_EXPEDIENTE                    = 2\n"
                + "  AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')\n"
                + "  )\n"
                + "WHERE periodo              = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_CELEBRACION     <> '09/09/1899'\n"
                + "AND FECHA_PRESENT_DEMANDA <> '09/09/1899'\n"
                + "AND ID_ORGANOJ             ='" + PValidacion.clave_entidad + "'\n"
                + "OR SUBSTR(ID_ORGANOJ,0,2)  ='" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_CELEBRACION     <> '09/09/1899'\n"
                + "AND FECHA_PRESENT_DEMANDA <> '09/09/1899'\n"
                + "AND periodo                = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD_CLAVE"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_PRESENT_DEMANDA"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_Aud_Apertura() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (SELECT SUBSTR(P.ID_ORGANOJ,0,2) AS ENTIDAD_CLAVE,P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,to_char(S.FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA\n"
                + "FROM TR_AUDIENCIA P,TR_EXPEDIENTE S\n"
                + "WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO \n"
                + "AND S.ID_TIPO_EXPEDIENTE = 2 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') \n"
                + " )where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_APERTURA_EXPED <> '09/09/1899' and  ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_APERTURA_EXPED <> '09/09/1899' \n"
                + "and PERIODO = '" + PValidacion.periodo + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD_CLAVE"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ORDINARIO LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
    public ArrayList Fecha_Aud_Admision() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (SELECT SUBSTR(P.ID_ORGANOJ,0,2) AS ENTIDAD_CLAVE, \n"
                + "  P.ID_ORGANOJ, S.CLAVE_EXPEDIENTE,\n"
                + "  to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,\n"
                + "  to_char(S.FECHA_ADM_DEMANDA,'DD/MM/YYYY') FECHA_ADM_DEMANDA, \n"
                + "  S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA\n"
                + "FROM TR_AUDIENCIA P,TR_EXPEDIENTE S\n"
                + "WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n"
                + "AND S.ID_TIPO_EXPEDIENTE = 2 \n"
                + "AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') \n"
                + " )where PERIODO = '" + PValidacion.periodo + "'\n"
                + "and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_ADM_DEMANDA <> '09/09/1899' and  ID_ORGANOJ='" + PValidacion.clave_organo + "' or substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_ADM_DEMANDA <> '09/09/1899' \n"
                + "and PERIODO = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD_CLAVE"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_ADM_DEMANDA"),
                    resul.getString("ID_AUDIENCIA")

                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
