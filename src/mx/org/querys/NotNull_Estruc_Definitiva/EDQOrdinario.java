/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

/**
 *
 * @author ANTONIO.CORIA
 */

import Conexion.OracleConexionDesarrollo;
import Conexion.OracleConexionNE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Screen_laborales.PValidacion;

public class EDQOrdinario {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql, cuenta = "";
    ArrayList<String[]> Array;
    ResultSet resul;

    //Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche.
    //Se quito query
    /*public ArrayList Año_JudicialCampeche() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + " SELECT * FROM( \n"
                + "        SELECT * FROM( \n"
                + "        select  clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,\n"
                + "        SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4)  FECHA_APERTURA_EXPEDIENTE,\n"
                + "TO_NUMBER(SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4))+1  FECHA_APERTURA_EXPEDIENTES1,\n"
                + "        substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(expediente_clave,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ','')),-4,4) EXPE_AÑO, \n"
                + "        PERIODO \n"
                + "        from V3_TR_ordinariojl ) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO) WHERE SUBSTR(CLAVE_ORGANO,0,2)='" + PValidacion.clave_entidad + "' and periodo = '" + PValidacion.periodo + "'  \n"
                + "        or clave_organo='" + PValidacion.clave_organo + "' and periodo = '" + PValidacion.periodo + "')  \n"
                + "        WHERE  FECHA_APERTURA_EXPEDIENTES  \n"
                + "        NOT BETWEEN     to_date('01/09/'||FECHA_APERTURA_EXPEDIENTE||'')\n"
                + "         AND  TO_date('01/08/'||(FECHA_APERTURA_EXPEDIENTES1)||'') ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("FECHA_APERTURA_EXPEDIENTES"),});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }*/

    //Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche comprendiendo los años 2020,2021,2022.
   /* public ArrayList Año_DIF_Campeche() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + " SELECT * FROM( \n"
                + "        SELECT * FROM( \n"
                + "        select  clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4)  \n"
                + "        FECHA_APERTURA_EXPEDIENTE,substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(replace(expediente_clave,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ',''),'l','')),-4,4) EXPE_AÑO, \n"
                + "        PERIODO \n"
                + "        from V3_TR_ordinariojl ) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO) WHERE SUBSTR(CLAVE_ORGANO,0,2)='" + PValidacion.clave_entidad + "' and periodo = '" + PValidacion.periodo + "'  \n"
                + "        or clave_organo='" + PValidacion.clave_organo + "' and periodo = '" + PValidacion.periodo + "') WHERE EXPE_AÑO NOT IN " + PValidacion.AñoJuridico + " ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("FECHA_APERTURA_EXPEDIENTES"),});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }*/

    //Query de validacion donde el año de la fecha de apertura es diferente al año de la clave del expediente.
    public ArrayList Año_Expe_OrdinarioNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(\n" +
"               SELECT * FROM(\n" +
"               select  ID_TIPO_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,SUBSTR(TO_CHAR(FECHA_APERTURA_EXPED, 'DD-MM-YYYY'),-4,4) \n" +
"               FECHA_APERTURA_EXPEDIENTE,SUBSTR(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''),-4,4)  EXPE_AÑO,\n" +
"               PERIODO\n" +
"               from TR_EXPEDIENTE ) WHERE  FECHA_APERTURA_EXPEDIENTE <> EXPE_AÑO AND EXPE_AÑO NOT IN ('2021','2022','2023','2020','2024','2025')) WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) \n" +
"               or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPEDIENTES"),});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,	\n" +
"                TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  	\n" +
"                WHERE 	\n" +
"                (FECHA_APERTURA_EXPED> SYSDATE 	\n" +
"                AND FECHA_APERTURA_EXPED <> '09/09/1899')	\n" +
"                and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_PRES_DEMANDA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_PRESENT_DEMANDA,'DD/MM/YYYY')FECHA_PRESENT_DEMANDA,\n" +
"                 TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n" +
"                 WHERE \n" +
"                 (FECHA_PRESENT_DEMANDA> SYSDATE \n" +
"                 AND FECHA_PRESENT_DEMANDA <> '09/09/1899')\n" +
"                 and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ADMI_DEMANDA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT  ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_ADM_DEMANDA,'DD/MM/YYYY')FECHA_ADM_DEMANDA,\n"
                + "                 TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  \n"
                + "                 WHERE \n"
                + "                 (FECHA_ADM_DEMANDA> SYSDATE \n"
                + "                 AND FECHA_ADM_DEMANDA <> '09/09/1899')\n"
                + "                 and  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and periodo='" + PValidacion.periodo + "' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_AUDIENCIA_PRELIM_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_AUDIENCIA_PRELIM,'DD/MM/YYYY')FECHA_AUDIENCIA_PRELIM,	\n" +
"	                TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  	\n" +
"	                WHERE 	\n" +
"	                (FECHA_AUDIENCIA_PRELIM> SYSDATE 	\n" +
"	                AND FECHA_AUDIENCIA_PRELIM <> '09/09/1899')	\n" +
"	                and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_AUDIENCIA_JUICIO_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_AUD_JUICIO,'DD/MM/YYYY')FECHA_AUD_JUICIO,	\n" +
"	                 TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  	\n" +
"	                 WHERE 	\n" +
"	                 (FECHA_AUD_JUICIO> SYSDATE 	\n" +
"	                 AND FECHA_AUD_JUICIO <> '09/09/1899')	\n" +
"	                 and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ACTO_PROCESAL_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_ULT_ACT_PROC,'DD/MM/YYYY')FECHA_ULT_ACT_PROC,	\n" +
"	                 TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  	\n" +
"	                 WHERE 	\n" +
"	                 (FECHA_ULT_ACT_PROC> SYSDATE 	\n" +
"	                 AND FECHA_ULT_ACT_PROC <> '09/09/1899')	\n" +
"	                 and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_DICTO_RESOLUCIONFE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,	\n" +
"	                 TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  TR_EXPEDIENTE  	\n" +
"	                 WHERE 	\n" +
"	                 (FECHA_DICTO_SOLUCION> SYSDATE 	\n" +
"	                 AND FECHA_DICTO_SOLUCION <> '09/09/1899')	\n" +
"	                 and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1))";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
/* ---- NO APLICAN 
    
    public ArrayList FECHA_DICTO_RESOLUCIONAP_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT clave_organo, expediente_clave, periodo, TO_CHAR(FECHA_DICTO_RESOLUCIONAP,'DD/MM/YYYY')FECHA_DICTO_RESOLUCIONAP,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  V3_TR_ORDINARIOJL  \n"
                + "WHERE \n"
                + "(FECHA_DICTO_RESOLUCIONAP> SYSDATE \n"
                + "AND FECHA_DICTO_RESOLUCIONAP <> '09/09/1899')\n"
                + "and  ((substr(clave_organo,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ) or  (clave_organo='" + PValidacion.clave_organo + "'  and periodo='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_RESOLUCIONAP")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_RESOLUCIONAJ_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT clave_organo, expediente_clave, periodo, TO_CHAR(FECHA_RESOLUCIONAJ,'DD/MM/YYYY')FECHA_RESOLUCIONAJ,\n"
                + "TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM  V3_TR_ORDINARIOJL  \n"
                + "WHERE \n"
                + "(FECHA_RESOLUCIONAJ> SYSDATE \n"
                + "AND FECHA_RESOLUCIONAJ <> '09/09/1899')\n"
                + "and  ((substr(clave_organo,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ) or  (clave_organo='" + PValidacion.clave_organo + "'  and periodo='" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_RESOLUCIONAJ")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
*/

    public ArrayList Duplicidad_expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED , TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', '')) CLAVE_EXPEDIENTE2, PERIODO FROM TR_EXPEDIENTE	\n" +
"	                 WHERE ID_ORGANOJ||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))||PERIODO	\n" +
"	                 IN(	\n" +
"	                 SELECT ID_ORGANOJ||CLAVE_EXPEDIENTE2||PERIODO FROM(	\n" +
"	                 SELECT ID_ORGANOJ,COUNT(CLAVE_EXPEDIENTE2)CUENTACLAVE_EXPEDIENTE2,CLAVE_EXPEDIENTE2,PERIODO FROM(	\n" +
"	                 select ID_ORGANOJ,CLAVE_EXPEDIENTE,TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,PERIODO from TR_EXPEDIENTE 	\n" +
"	                 WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1) or (ID_ORGANOJ='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	                 ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2)	\n" +
"	                 GROUP BY ID_ORGANOJ,CLAVE_EXPEDIENTE2,PERIODO)WHERE CUENTACLAVE_EXPEDIENTE2>1)	\n" +
"	                 ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2";
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
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_PresentacionNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,ID_TIPO_EXPEDIENTE, CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA, PERIODO	\n" +
"	                 from TR_EXPEDIENTE	\n" +
"	                 WHERE to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')) where  (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_PRESENT_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ls fecha de admision de la demanda no debe de ser menor a la fecha depresentacion de la demanda
    public ArrayList Fecha_PresentacionAdmiNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,ID_TIPO_EXPEDIENTE, CLAVE_EXPEDIENTE,to_char(FECHA_ADM_DEMANDA,'dd/mm/yyyy')FECHA_ADM_DEMANDA,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA,PERIODO 	\n" +
"	                 from TR_EXPEDIENTE 	\n" +
"	                 WHERE to_date(FECHA_ADM_DEMANDA) < to_date(FECHA_PRESENT_DEMANDA)) where  (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_PRESENT_DEMANDA <> '09/09/1899' and FECHA_ADM_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_PRESENT_DEMANDA <> '09/09/1899' and FECHA_ADM_DEMANDA <> '09/09/1899' and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_ADM_DEMANDA"),
                    resul.getString("FECHA_PRESENT_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha del último acto procesal no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Acto_ProcesalNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_ULT_ACT_PROC,'DD/MM/YYYY')FECHA_ULT_ACT_PROC,periodo	\n" +
"	                 from TR_EXPEDIENTE where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_ULT_ACT_PROC <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_ULT_ACT_PROC <> '09/09/1899'	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)) where  to_date(FECHA_ULT_ACT_PROC,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha de admision de la demanda no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Admi_demandaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_ADM_DEMANDA,'DD/MM/YYYY')FECHA_ADM_DEMANDA,periodo	\n" +
"	                 from TR_EXPEDIENTE where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_ADM_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_ADM_DEMANDA <> '09/09/1899'	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)) where  to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ADM_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha de audiencia de juicio no debe de ser menor o igual a la fecha de apertura del expediente.
    public ArrayList Fecha_Audiencia_JuicioNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_AUD_JUICIO,'DD/MM/YYYY')FECHA_AUD_JUICIO,periodo	\n" +
"	                 from TR_EXPEDIENTE where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_AUD_JUICIO <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_AUD_JUICIO <> '09/09/1899'	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)) where  to_date(FECHA_AUD_JUICIO,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUD_JUICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha de audiencia preliminar no debe de ser menor o igual a la fecha de apertura del expediente.
    public ArrayList Fecha_Audiencia_PrelimNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_AUDIENCIA_PRELIM,'DD/MM/YYYY') FECHA_AUDIENCIA_PRELIM  ,periodo	\n" +
"	                 from TR_EXPEDIENTE where  (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_AUDIENCIA_PRELIM <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_AUDIENCIA_PRELIM <> '09/09/1899'	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)) where  to_date(FECHA_AUDIENCIA_PRELIM,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUDIENCIA_PRELIM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha en la que se dictó la resolución (Fase escrita) no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Dicto_ResolucionFE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select ID_EXPEDIENTE, ID_ENT_MPIO,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,to_char(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION  ,periodo	\n" +
"	                 from TR_EXPEDIENTE where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_DICTO_SOLUCION <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_DICTO_SOLUCION <> '09/09/1899'	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)) where  to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    /* NO APLICA
    //Query de validacion donde la Fecha en la que se dictó la resolución (Audiencia preliminar) no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Dicto_ResolucionAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select entidad_clave,clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE,to_char(FECHA_DICTO_RESOLUCIONAP,'DD/MM/YYYY') FECHA_DICTO_RESOLUCIONAP  ,periodo\n"
                + "from V3_TR_ordinariojl where periodo = '" + PValidacion.periodo + "'\n"
                + "and FECHA_DICTO_RESOLUCIONAP <> '09/09/1899'  and clave_organo='" + PValidacion.clave_organo + "' or substr(clave_organo,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_DICTO_RESOLUCIONAP <> '09/09/1899'\n"
                + "and periodo = '" + PValidacion.periodo + "' ) where  to_date(FECHA_DICTO_RESOLUCIONAP,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                    resul.getString("FECHA_DICTO_RESOLUCIONAP")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion donde la Fecha en la que se dictó la resolución (Audiencia de juicio) no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_ResolucionAJ() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (select entidad_clave,clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE,to_char(FECHA_RESOLUCIONAJ,'DD/MM/YYYY') FECHA_RESOLUCIONAJ  ,periodo\n"
                + "from V3_TR_ordinariojl where periodo = '" + PValidacion.periodo + "'\n"
                + "and FECHA_RESOLUCIONAJ <> '09/09/1899'  and clave_organo='" + PValidacion.clave_organo + "' or substr(clave_organo,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and FECHA_RESOLUCIONAJ <> '09/09/1899'\n"
                + "and periodo = '" + PValidacion.periodo + "' ) where  to_date(FECHA_RESOLUCIONAJ,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("clave_organo"),
                    resul.getString("expediente_clave"),
                    resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                    resul.getString("FECHA_RESOLUCIONAJ")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
*/ 
    
   //ORDINARIO LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE APERTURA DEL EXPEDIENTE
    // LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
    public ArrayList Fecha_Aud_Presentacion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (SELECT S.ID_ENT_MPIO,P.ID_ORGANOJ,P.ID_EXPEDIENTE, S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,to_char(S.FECHA_PRESENT_DEMANDA,'DD/MM/YYYY') FECHA_PRESENT_DEMANDA, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA	\n" +
"	                 FROM TR_AUDIENCIA P, TR_EXPEDIENTE S	\n" +
"	                 WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO	\n" +
"	                 AND S.ID_TIPO_EXPEDIENTE=1 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy') 	\n" +
"	                  )where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_PRESENT_DEMANDA <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_PRESENT_DEMANDA <> '09/09/1899' 	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_PRESENT_DEMANDA"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_Aud_Apertura() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (SELECT P.ID_EXPEDIENTE, S.ID_ENT_MPIO,P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,to_char(S.FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA	\n" +
"	                 FROM TR_AUDIENCIA P,TR_EXPEDIENTE S	\n" +
"	                 WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO	\n" +
"	                 AND S.ID_TIPO_EXPEDIENTE=1 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') 	\n" +
"	                  )where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_APERTURA_EXPED <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_APERTURA_EXPED <> '09/09/1899' 	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ORDINARIO LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
    public ArrayList Fecha_Aud_Admision() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (SELECT P.ID_EXPEDIENTE, S.ID_ENT_MPIO,P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,to_char(S.FECHA_ADM_DEMANDA,'DD/MM/YYYY') FECHA_ADM_DEMANDA, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA	\n" +
"	                 FROM TR_AUDIENCIA P,TR_EXPEDIENTE S	\n" +
"	                 WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO	\n" +
"	                 AND S.ID_TIPO_EXPEDIENTE=1 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') 	\n" +
"	                  )where (periodo = '"+PValidacion.periodo+"'	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_ADM_DEMANDA <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' and ID_TIPO_EXPEDIENTE = 1) or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' 	\n" +
"	                 and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_ADM_DEMANDA <> '09/09/1899' 	\n" +
"	                 and periodo = '"+PValidacion.periodo+"' and ID_TIPO_EXPEDIENTE = 1)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENT_MPIO"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_ADM_DEMANDA"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
