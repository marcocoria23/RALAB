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
public class EDQColec_Econom {
 OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche.
  public ArrayList Año_JudicialCampeche(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"	SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	select  id_organoj,id_expediente,to_char(fecha_apertura_exped,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,\n" +
"	SUBSTR(TO_CHAR(fecha_apertura_exped, 'DD-MM-YYYY'),-4,4)  FECHA_APERTURA_EXPEDIENTE,\n" +
"	TO_NUMBER(SUBSTR(TO_CHAR(fecha_apertura_exped, 'DD-MM-YYYY'),-4,4))+1  FECHA_APERTURA_EXPEDIENTES1,\n" +
"	substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(id_expediente,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ','')),-4,4) EXPE_AÑO,\n" +
"	PERIODO\n" +
"	from tr_expediente\n" +
"	where id_tipo_expediente = 5 ) WHERE  FECHA_APERTURA_EXPEDIENTES <>EXPE_AÑO) WHERE SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')\n" +
"	WHERE  FECHA_APERTURA_EXPEDIENTES\n" +
"	NOT BETWEEN     to_date('01/09/'||FECHA_APERTURA_EXPEDIENTE||'')\n" +
"	AND  TO_date('01/08/'||(FECHA_APERTURA_EXPEDIENTES1)||'')";
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
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
 
  //Query de validacion donde el  año de la fecha de apertura sea diferente al año de la clave del expediente dependiendo del año judicial del estado de Campeche comprendiendo los años 2020,2021,2022.
  public ArrayList Año_DIF_Campeche(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"	SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	select  tr_expediente.id_organoj, tr_expediente.CLAVE_EXPEDIENTE,to_char(tr_expediente.fecha_apertura_exped,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,\n" +
"	SUBSTR(TO_CHAR(tr_expediente.fecha_apertura_exped, 'DD-MM-YYYY'),-4,4)\n" +
"	FECHA_APERTURA_EXPEDIENTE,substr(TRIM(replace(replace(replace(replace(replace(replace(replace(replace(tr_expediente.CLAVE_EXPEDIENTE,'-',''),'I',''),'J',''),'L',''),'/',''),'ll',''),'II',''),'I ','')),-4,4) EXPE_AÑO,\n" +
"	PERIODO\n" +
"	from tr_expediente where id_tipo_expediente = 5  ) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO) WHERE SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"') WHERE EXPE_AÑO NOT IN '"+PValidacion.AñoJuridico+"'";
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
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Query de validacion donde el año de la fecha de apertura es diferente al año de la clave del expediente.
public ArrayList Año_Expe_ColecEconomNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	select  tr_expediente.id_organoj,tr_expediente.CLAVE_EXPEDIENTE,to_char(tr_expediente.fecha_apertura_exped,'dd/mm/yyyy') FECHA_APERTURA_EXPEDIENTES ,SUBSTR(TO_CHAR(tr_expediente.fecha_apertura_exped, 'DD-MM-YYYY'),-4,4)\n" +
"	FECHA_APERTURA_EXPEDIENTE,SUBSTR(regexp_replace(tr_expediente.CLAVE_EXPEDIENTE, '[^0-9]', ''),-4,4)  EXPE_AÑO,\n" +
"	PERIODO\n" +
"	from tr_expediente WHERE tr_expediente.id_tipo_expediente = 5) WHERE  FECHA_APERTURA_EXPEDIENTE <>EXPE_AÑO AND EXPE_AÑO NOT IN ('2021','2022','2023','2020','2024','2025')) WHERE SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_apertura_exped,'DD/MM/YYYY')FECHA_APERTURA_EXPEDIENTE,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE\n" +
"	WHERE\n" +
"	tr_expediente.id_tipo_expediente = 5 AND\n" +
"	(fecha_apertura_exped> SYSDATE\n" +
"	AND fecha_apertura_exped <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

public ArrayList FECHA_PRES_DEMANDA_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_present_demanda,'DD/MM/YYYY')FECHA_PRES_DEMANDA,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM tr_expediente\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 AND\n" +
"	(fecha_present_demanda> SYSDATE\n" +
"	AND fecha_present_demanda <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_PRES_DEMANDA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
   return Array;
}


public ArrayList FECHA_ADMISION_DEMANDA_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_adm_demanda,'DD/MM/YYYY')FECHA_ADMISION_DEMANDA,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM tr_expediente\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 AND\n" +
"	(fecha_adm_demanda> SYSDATE\n" +
"	AND fecha_adm_demanda <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_ADMISION_DEMANDA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}


public ArrayList FECHA_AUDIENCIA_ECONOM_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_audiencia_col_nat_eco,'DD/MM/YYYY')FECHA_AUDIENCIA_ECONOM,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 AND\n" +
"	(fecha_audiencia_col_nat_eco> SYSDATE\n" +
"	AND fecha_audiencia_col_nat_eco <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_AUDIENCIA_ECONOM")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

public ArrayList FECHA_ACTO_PROCESAL_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_ult_act_proc,'DD/MM/YYYY')FECHA_ACTO_PROCESAL,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM tr_expediente\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 and\n" +
"	(fecha_ult_act_proc> SYSDATE\n" +
"	AND fecha_ult_act_proc <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' )\n" +
"	or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_ACTO_PROCESAL")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

public ArrayList FECHA_RESOLUCION_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj, CLAVE_EXPEDIENTE, periodo, TO_CHAR(fecha_dicto_solucion,'DD/MM/YYYY')FECHA_RESOLUCION,\n" +
"	TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM tr_expediente\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 and\n" +
"	(fecha_dicto_solucion> SYSDATE\n" +
"	AND fecha_dicto_solucion <> '09/09/1899')\n" +
"	and  ((substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (id_organoj='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_RESOLUCION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}


public ArrayList Duplicidad_expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT id_organoj,CLAVE_EXPEDIENTE,TO_CHAR(fecha_apertura_exped,'DD/MM/YYYY')FECHA_APERTURA_EXPEDIENTE,\n" +
"	TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))expediente_clave2,PERIODO\n" +
"	FROM tr_expediente\n" +
"	where id_tipo_expediente = 5 and\n" +
"	id_organoj||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))||PERIODO\n" +
"	IN(\n" +
"	SELECT id_organoj||EXPEDIENTE_CLAVE2||PERIODO FROM(\n" +
"	SELECT id_organoj,COUNT(expediente_clave2)CUENTAexpediente_clave2,expediente_clave2,PERIODO FROM(\n" +
"	select id_organoj, CLAVE_EXPEDIENTE,TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))expediente_clave2,PERIODO from tr_expediente\n" +
"	WHERE id_tipo_expediente = 5 and\n" +
"	(SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"') \n" +
"	or (id_organoj='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"')\n" +
"	ORDER BY id_organoj,expediente_clave2)\n" +
"	GROUP BY id_organoj,expediente_clave2,PERIODO)WHERE CUENTAexpediente_clave2>1)\n" +
"	ORDER BY id_organoj,expediente_clave2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

  public ArrayList Fecha_PresentacionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,to_char(fecha_apertura_exped,'dd/mm/yyyy')FECHA_APERTURA_EXPEDIENTE,\n" +
"	to_char(fecha_present_demanda,'dd/mm/yyyy')fecha_pres_demanda,PERIODO\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	WHERE to_date(fecha_apertura_exped,'dd/mm/yyyy') < to_date(fecha_present_demanda,'dd/mm/yyyy')\n" +
"	AND tr_expediente.id_tipo_expediente = 5)\n" +
"	where  periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_pres_demanda <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"'\n" +
"	or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_pres_demanda <> '09/09/1899' AND periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                  resul.getString("fecha_pres_demanda")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
  
  
   //ls fecha de admision de la demanda no debe de ser menor a la fecha depresentacion de la demanda
   public ArrayList Fecha_PresentacionAdmiNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,to_char(fecha_adm_demanda,'dd/mm/yyyy')FECHA_ADMISION_DEMANDA,\n" +
"	to_char(fecha_present_demanda,'dd/mm/yyyy')fecha_pres_demanda,PERIODO\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	WHERE to_date(fecha_adm_demanda,'dd/mm/yyyy') < to_date(fecha_present_demanda,'dd/mm/yyyy')\n" +
"	AND tr_expediente.id_tipo_expediente = 5) where  periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_pres_demanda <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"' or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_pres_demanda <> '09/09/1899' AND periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_ADMISION_DEMANDA"),
                  resul.getString("fecha_pres_demanda")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



 //Query de validacion donde la fecha de admision no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Admision_DemandaNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,fecha_apertura_exped,to_char(fecha_adm_demanda,'DD/MM/YYYY') Fecha_Admision_Demanda ,periodo\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	where  periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_adm_demanda <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"' or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_adm_demanda <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	AND tr_expediente.id_tipo_expediente = 5) where  to_date(Fecha_Admision_Demanda,'dd/mm/yyyy')  < to_date(fecha_apertura_exped,'dd/mm/yyyy')";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("fecha_apertura_exped"),
                  resul.getString("Fecha_Admision_Demanda")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      //Query de validacion donde la Fecha de audiencia dentro del procedimiento colectivo de naturaleza económica  no debe de ser menor o igual a la fecha de apertura del expediente
    public ArrayList Fecha_audiencia_EconomNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,to_char(fecha_apertura_exped,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE,\n" +
"	to_char(fecha_audiencia_col_nat_eco,'DD/MM/YYYY') Fecha_audiencia_Econom ,periodo\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	where periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_audiencia_col_nat_eco <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"' or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_audiencia_col_nat_eco <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	AND tr_expediente.id_tipo_expediente = 5 ) where to_date(Fecha_audiencia_Econom,'dd/mm/yyyy')  <= to_date(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy')";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                  resul.getString("Fecha_audiencia_Econom")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
     //Query de validacion donde la Fecha del último acto procesal no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_acto_procesalNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,to_char(fecha_apertura_exped,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE,\n" +
"	to_char(fecha_ult_act_proc,'DD/MM/YYYY') Fecha_acto_procesal ,periodo\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	where periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_ult_act_proc <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"' or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_ult_act_proc <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"' AND tr_expediente.id_tipo_expediente = 5) where to_date(Fecha_acto_procesal,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy')";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                  resul.getString("Fecha_acto_procesal")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
    //Query de validacion donde la Fecha en la que se dictó la resolución no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_resolucionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select CLAVE_ENTIDAD,id_organoj,CLAVE_EXPEDIENTE,to_char(fecha_apertura_exped,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE,\n" +
"	to_char(fecha_dicto_solucion,'DD/MM/YYYY') Fecha_resolucion ,periodo\n" +
"	from tr_expediente INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = tr_expediente.id_ent_mpio\n" +
"	where periodo = '"+PValidacion.periodo+"'\n" +
"	and fecha_dicto_solucion <> '09/09/1899'  and id_organoj='"+PValidacion.clave_organo+"' or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and fecha_dicto_solucion <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	AND tr_expediente.id_tipo_expediente = 5 ) where to_date(Fecha_resolucion,'dd/mm/yyyy')  < to_date(FECHA_APERTURA_EXPEDIENTE,'dd/mm/yyyy')";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                  resul.getString("Fecha_resolucion")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

    
// LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
  public ArrayList Fecha_Aud_Presentacion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (\n" +
"	SELECT CLAVE_ENTIDAD,P.id_organoj,S.CLAVE_EXPEDIENTE,to_char(p.fecha_celebracion,'DD/MM/YYYY')FECHA_AUDIEN_CELEBRADA,\n" +
"	to_char(S.fecha_present_demanda,'DD/MM/YYYY') FECHA_PRES_DEMANDA, s.id_tipo_expediente,P.PERIODO,P.ID_AUDIENCIA\n" +
"	FROM tr_audiencia P inner join tr_expediente S on p.ID_EXPEDIENTE = s.ID_EXPEDIENTE and\n" +
"	s.PERIODO=P.PERIODO AND  P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"	INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = s.id_ent_mpio\n" +
"	WHERE P.id_organoj=S.id_organoj AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"	AND to_date(fecha_celebracion,'dd/mm/yyyy') < to_date(fecha_present_demanda,'dd/mm/yyyy')\n" +
"	AND s.id_tipo_expediente = 5)where periodo = '"+PValidacion.periodo+"'\n" +
"	and FECHA_AUDIEN_CELEBRADA <> '09/09/1899'  and FECHA_PRES_DEMANDA <> '09/09/1899' and  id_organoj='"+PValidacion.clave_organo+"'\n" +
"	or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and FECHA_AUDIEN_CELEBRADA <> '09/09/1899' and  FECHA_PRES_DEMANDA <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_AUDIEN_CELEBRADA"),
                  resul.getString("FECHA_PRES_DEMANDA"),
                  resul.getString("ID_AUDIENCIA")
                });            
  
   }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  

  
  public ArrayList Fecha_Aud_Apertura(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="	select * from (\n" +
"	SELECT CLAVE_ENTIDAD,P.id_organoj,S.CLAVE_EXPEDIENTE,to_char(p.fecha_celebracion,'DD/MM/YYYY')FECHA_AUDIEN_CELEBRADA,\n" +
"	to_char(S.fecha_apertura_exped,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE, s.id_tipo_expediente,P.PERIODO,P.ID_AUDIENCIA\n" +
"	FROM tr_audiencia P inner join tr_expediente S on p.ID_EXPEDIENTE = s.ID_EXPEDIENTE and \n" +
"	s.PERIODO=P.PERIODO AND  P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"	INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = s.id_ent_mpio\n" +
"	WHERE P.id_organoj=S.id_organoj AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"	AND to_date(fecha_celebracion,'dd/mm/yyyy') < to_date(fecha_apertura_exped,'dd/mm/yyyy')\n" +
"	AND s.id_tipo_expediente = 5\n" +
"	)where periodo = '"+PValidacion.periodo+"'\n" +
"	and FECHA_AUDIEN_CELEBRADA <> '09/09/1899'  and FECHA_APERTURA_EXPEDIENTE <> '09/09/1899' and  id_organoj='"+PValidacion.clave_organo+"'\n" +
"	or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and FECHA_AUDIEN_CELEBRADA <> '09/09/1899' and  FECHA_APERTURA_EXPEDIENTE <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ENTIDAD"),
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_AUDIEN_CELEBRADA"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE"),
                  resul.getString("ID_AUDIENCIA")
                });            
  
   }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  
  
  
  
  //ORDINARIO LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
  public ArrayList Fecha_Aud_Admision(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (\n" +
"	SELECT CLAVE_ENTIDAD,P.id_organoj,S.CLAVE_EXPEDIENTE,to_char(p.fecha_celebracion,'DD/MM/YYYY')FECHA_AUDIEN_CELEBRADA,\n" +
"	to_char(S.fecha_apertura_exped,'DD/MM/YYYY') FECHA_APERTURA_EXPEDIENTE, s.id_tipo_expediente,P.PERIODO,P.ID_AUDIENCIA\n" +
"	FROM tr_audiencia P inner join tr_expediente S on p.ID_EXPEDIENTE = s.ID_EXPEDIENTE and\n" +
"	s.PERIODO=P.PERIODO AND  P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"	INNER JOIN tc_entidad_mpio ON tc_entidad_mpio.id_ent_mpio = s.id_ent_mpio\n" +
"	WHERE P.id_organoj=S.id_organoj AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"	AND to_date(fecha_celebracion,'dd/mm/yyyy') < to_date(fecha_apertura_exped,'dd/mm/yyyy')\n" +
"	AND s.id_tipo_expediente = 5\n" +
"	)where periodo = '"+PValidacion.periodo+"'\n" +
"	and FECHA_AUDIEN_CELEBRADA <> '09/09/1899'  and FECHA_APERTURA_EXPEDIENTE <> '09/09/1899' and  id_organoj='"+PValidacion.clave_organo+"'\n" +
"	or substr(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and FECHA_AUDIEN_CELEBRADA <> '09/09/1899' and  FECHA_APERTURA_EXPEDIENTE <> '09/09/1899'\n" +
"	and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENTIDAD_CLAVE"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_AUDIEN_CELEBRADA"),
                  resul.getString("FECHA_ADMISION_DEMANDA"),
                  resul.getString("ID_AUDIENCIA")
                });            
  
   }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }              
  
  
  public ArrayList SinMotivo_Conflicto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"	TR_EXPEDIENTE.id_organoj,TR_EXPEDIENTE.CLAVE_EXPEDIENTE,TO_CHAR(fecha_apertura_exped,'dd/mm/yyyy')FECHA_APERTURA_EXPEDIENTE,TR_EXP_MOTIVO_CONF.ID_MOTIVO_CONFLICTO\n" +
"	FROM\n" +
"	TR_EXPEDIENTE LEFT JOIN tr_exp_motivo_conf ON tr_expediente.ID_EXPEDIENTE = tr_exp_motivo_conf.ID_EXPEDIENTE\n" +
"	AND tr_expediente.PERIODO=tr_exp_motivo_conf.PERIODO AND  tr_expediente.ID_ORGANOJ=tr_exp_motivo_conf.ID_ORGANOJ\n" +
"	WHERE\n" +
"	id_tipo_expediente = 5 and\n" +
"	TR_EXP_MOTIVO_CONF.ID_MOTIVO_CONFLICTO is null\n" +
"	and(SUBSTR(TR_EXPEDIENTE.id_organoj,0,2)='"+PValidacion.clave_entidad+"' and TR_EXPEDIENTE.periodo = '"+PValidacion.periodo+"'\n" +
"	or TR_EXPEDIENTE.id_organoj='"+PValidacion.clave_organo+"' and TR_EXPEDIENTE.periodo = '"+PValidacion.periodo+"')"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("id_organoj"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FECHA_APERTURA_EXPEDIENTE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQColec_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    

}
