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

/**
 *
 * @author JOSE.CABRERA
 */
public class EDQEjecucion {
    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

/* No aplica 

//Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche.
  public ArrayList Año_JudicialCampeche(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
" SELECT * FROM( \n" +
"        SELECT * FROM( \n" +
"        select  clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,\n" +
"        SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4)  FECHA_APERTURA_EXPEDIENTE,\n" +
"TO_NUMBER(SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4))+1  FECHA_APERTURA_EXPEDIENTES1,\n" +
"        substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(expediente_clave,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ','')),-4,4) EXPE_AÑO, \n" +
"        PERIODO \n" +
"        from V3_TR_ejecucionjl ) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO) WHERE SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  \n" +
"        or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')  \n" +
"        WHERE  FECHA_APERTURA_EXPEDIENTES  \n" +
"        NOT BETWEEN     to_date('01/09/'||FECHA_APERTURA_EXPEDIENTE||'')\n" +
"         AND  TO_date('01/08/'||(FECHA_APERTURA_EXPEDIENTES1)||'') ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTES"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
 
  //Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche comprendiendo los años 2020,2021,2022.
  public ArrayList Año_DIF_Campeche(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
" SELECT * FROM( \n" +
"        SELECT * FROM( \n" +
"        select  clave_organo,expediente_clave,to_char(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,SUBSTR(TO_CHAR(FECHA_APERTURA_EXPEDIENTE, 'DD-MM-YYYY'),-4,4)  \n" +
"        FECHA_APERTURA_EXPEDIENTE,substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(expediente_clave,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ','')),-4,4) EXPE_AÑO, \n" +
"        PERIODO \n" +
"        from V3_TR_ejecucionjl ) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO AND EXPE_AÑO NOT IN ('2021','2022','2023','2020','2024','2025')) WHERE SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  \n" +
"        or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"') WHERE EXPE_AÑO NOT IN "+PValidacion.AñoJuridico+" ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTES"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
*/

  //Query de validacion donde el año de la fecha de apertura es diferente al año de la clave del expediente.
   public ArrayList Año_Expe_EjecucionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE,	\n" +
"	    ID_ORGANOJ,	\n" +
"	    CLAVE_EXPEDIENTE, 	\n" +
"	    FECHA_APERTURA_EXPEDIENTES, 	\n" +
"	    FECHA_APERTURA_EXPED, 	\n" +
"	    EXPE_AÑO, 	\n" +
"	    PERIODO	\n" +
"	FROM( 	\n" +
"	        SELECT * FROM( 	\n" +
"	        select  ID_EXPEDIENTE, ID_ORGANOJ, ID_TIPO_EXPEDIENTE, CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,SUBSTR(TO_CHAR(FECHA_APERTURA_EXPED, 'DD-MM-YYYY'),-4,4)  	\n" +
"	        FECHA_APERTURA_EXPED,SUBSTR(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''),-4,4)  EXPE_AÑO, 	\n" +
"	        PERIODO 	\n" +
"	        from TR_EXPEDIENTE ) WHERE  FECHA_APERTURA_EXPED <> EXPE_AÑO) WHERE ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9')  	\n" +
"	        or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9'))";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTES"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
   
      public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ, 	\n" +
"	    CLAVE_EXPEDIENTE, 	\n" +
"	    periodo, 	\n" +
"	    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED, 	\n" +
"	    TO_CHAR(SYSDATE,'DD/MM/YYYY') 	\n" +
"	    FROM TR_EXPEDIENTE  	\n" +
"	WHERE  	\n" +
"	    (FECHA_APERTURA_EXPED>SYSDATE  	\n" +
"	    AND FECHA_APERTURA_EXPED <> '09/09/1899') 	\n" +
"	    and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9') or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
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
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}
   
 public ArrayList FECHA_PRESENTACION_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ, 	\n" +
"	    CLAVE_EXPEDIENTE, periodo, 	\n" +
"	    TO_CHAR(FECHA_PRES_EJECU_SENT,'DD/MM/YYYY')FECHA_PRES_EJECU_SENT, 	\n" +
"	    TO_CHAR(SYSDATE,'DD/MM/YYYY') 	\n" +
"	FROM TR_EXPEDIENTE  	\n" +
"	WHERE  	\n" +
"	(FECHA_PRES_EJECU_SENT>SYSDATE  	\n" +
"	AND FECHA_PRES_EJECU_SENT <> '09/09/1899') 	\n" +
"	and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9') 	\n" +
"	    or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_PRES_EJECU_SENT")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

public ArrayList FECHA_CONCLUSION_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ, 	\n" +
"	    CLAVE_EXPEDIENTE, 	\n" +
"	    periodo, 	\n" +
"	    TO_CHAR(FECHA_CONCL_EJECU,'DD/MM/YYYY')FECHA_CONCL_EJECU, 	\n" +
"	    TO_CHAR(SYSDATE,'DD/MM/YYYY') 	\n" +
"	FROM TR_EXPEDIENTE  	\n" +
"	WHERE  	\n" +
"	(FECHA_CONCL_EJECU>SYSDATE  	\n" +
"	AND FECHA_CONCL_EJECU <> '09/09/1899') 	\n" +
"	and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9') 	\n" +
"	or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_CONCL_EJECU")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

   
   
   
   public ArrayList Duplicidad_expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ,	\n" +
"	    CLAVE_EXPEDIENTE,	\n" +
"	    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,	\n" +
"	    TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,	\n" +
"	    PERIODO 	\n" +
"	    FROM TR_EXPEDIENTE 	\n" +
"	WHERE ID_ORGANOJ||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))||PERIODO 	\n" +
"	IN( 	\n" +
"	SELECT ID_ORGANOJ||CLAVE_EXPEDIENTE2||PERIODO FROM( 	\n" +
"	SELECT ID_ORGANOJ,COUNT(CLAVE_EXPEDIENTE2)CUENTACLAVE_EXPEDIENTE2,CLAVE_EXPEDIENTE2,PERIODO FROM( 	\n" +
"	select ID_ORGANOJ,CLAVE_EXPEDIENTE,TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,PERIODO from TR_EXPEDIENTE  	\n" +
"	WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9') 	\n" +
"	    or (ID_ORGANOJ='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9')   	\n" +
"	ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2) 	\n" +
"	GROUP BY ID_ORGANOJ,CLAVE_EXPEDIENTE2,PERIODO)WHERE CUENTACLAVE_EXPEDIENTE2>1) 	\n" +
"	ORDER BY ID_ORGANOJ,CLAVE_EXPEDIENTE2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
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
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
   
   
    public ArrayList Fecha_PresentacionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ESTATUS_EXPED,	\n" +
"	    ID_ORGANOJ,	\n" +
"	    CLAVE_EXPEDIENTE,	\n" +
"	    FECHA_APERTURA_EXPED,	\n" +
"	    FECHA_PRES_EJECU_SENT,	\n" +
"	    PERIODO	\n" +
"	from 	\n" +
"	    (	\n" +
"	    select 	\n" +
"	        ID_EXPEDIENTE, 	\n" +
"	        ID_ESTATUS_EXPED,	\n" +
"	        ID_ORGANOJ,	\n" +
"	        CLAVE_EXPEDIENTE,	\n" +
"	        ID_TIPO_EXPEDIENTE,	\n" +
"	        to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,	\n" +
"	        to_char(FECHA_PRES_EJECU_SENT,'dd/mm/yyyy')FECHA_PRES_EJECU_SENT,	\n" +
"	        PERIODO 	\n" +
"	from TR_EXPEDIENTE 	\n" +
"	WHERE to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PRES_EJECU_SENT,'dd/mm/yyyy')) 	\n" +
"	    where  ((periodo = '"+PValidacion.periodo+"' and FECHA_PRES_EJECU_SENT <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' AND ID_TIPO_EXPEDIENTE = '9') 	\n" +
"	    or (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and FECHA_PRES_EJECU_SENT <> '09/09/1899'  and periodo = '"+PValidacion.periodo+"'  AND ID_TIPO_EXPEDIENTE = '9'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ESTATUS_EXPED"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPED"),
                  resul.getString("FECHA_PRES_EJECU_SENT")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
   
//Query de validacion donde la fecha de conclusion no debe de ser menor a la fecha de apertura del expediente.
public ArrayList Fecha_ConclusionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select	\n" +
"	    ID_EXPEDIENTE,	\n" +
"	    ID_ESTATUS_EXPED,	\n" +
"	    ID_ORGANOJ,	\n" +
"	    CLAVE_EXPEDIENTE,	\n" +
"	    FECHA_APERTURA_EXPED,	\n" +
"	    FECHA_CONCL_EJECU,	\n" +
"	    periodo	\n" +
"	from (	\n" +
"	    select 	\n" +
"	        ID_EXPEDIENTE,	\n" +
"	        ID_TIPO_EXPEDIENTE,	\n" +
"	        ID_ESTATUS_EXPED,	\n" +
"	        ID_ORGANOJ,	\n" +
"	        CLAVE_EXPEDIENTE,	\n" +
"	        to_char(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,	\n" +
"	        to_char(FECHA_CONCL_EJECU,'DD/MM/YYYY') FECHA_CONCL_EJECU,	\n" +
"	        periodo 	\n" +
"	          from TR_EXPEDIENTE 	\n" +
"	            where 	\n" +
"	                ((periodo = '"+PValidacion.periodo+"' and FECHA_CONCL_EJECU <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' AND ID_TIPO_EXPEDIENTE = '9') 	\n" +
"	                or 	\n" +
"	                (substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and FECHA_CONCL_EJECU <> '09/09/1899' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9')) 	\n" +
"	) 	\n" +
"	where  to_date(FECHA_CONCL_EJECU,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ESTATUS_EXPED"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPED"),
                  resul.getString("FECHA_CONCL_EJECU")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}
