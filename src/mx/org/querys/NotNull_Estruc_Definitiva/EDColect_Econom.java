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
 * @author JOSE.CABRERA
 */
public class EDColect_Econom {
    
    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql;
ArrayList<String[]> Array;
ResultSet resul;






///--Tipo de asunto no debe de ser =9 No_identificado o Null.
public ArrayList Tipo_Asunto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select id_organoj,CLAVE_EXPEDIENTE,DECODE(id_tipo_asunto,'-1','No_identificado') TIPO_ASUNTO,PERIODO\n" +
"	from tr_expediente\n" +
"	WHERE (id_tipo_asunto =-1 )AND (SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	or (id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))\n" +
"	and  id_tipo_expediente = 5"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("TIPO_ASUNTO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///----cuando Suspensión temporal de las relaciones colectivas de trabajo=No no debe capturarse a partir de Exceso de producción con relación a sus condiciones económica hasta Falta de fondos y la imposibilidad de obtenerlos para la prosecución normal de los trabajos
public ArrayList Suspencion_Temporal(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.CLAVE_EXPEDIENTE,P.ID_ORGANOJ,P.ID_EXPEDIENTE_MOTIVO_CONFLICTO,S.ID_TIPO_SUSPENSION FROM(\n" +
"	SELECT tr_expediente.ID_EXPEDIENTE,tr_expediente.ID_ORGANOJ,\n" +
"	tr_expediente.CLAVE_EXPEDIENTE,TR_EXP_MOTIVO_CONF.ID_EXPEDIENTE ID_EXPEDIENTE_MOTIVO_CONFLICTO,\n" +
"	TR_EXP_MOTIVO_CONF.ID_MOTIVO_CONFLICTO,tr_expediente.PERIODO\n" +
"	FROM tr_expediente left join TR_EXP_MOTIVO_CONF on tr_expediente.id_organoj = TR_EXP_MOTIVO_CONF.id_organoj\n" +
"	AND tr_expediente.PERIODO=TR_EXP_MOTIVO_CONF.PERIODO AND tr_expediente.ID_EXPEDIENTE=TR_EXP_MOTIVO_CONF.ID_EXPEDIENTE\n" +
"	WHERE tr_expediente.id_tipo_expediente = 5\n" +
"	AND ID_MOTIVO_CONFLICTO<>39)P LEFT JOIN TR_EXP_SUSPENSION S\n" +
"	ON P.PERIODO=S.PERIODO AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"	WHERE ID_TIPO_SUSPENSION <> '-1' AND \n" +
"	(SUBSTR(p.ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and p.periodo = '"+PValidacion.periodo+"'\n" +
"	or p.ID_ORGANOJ='"+PValidacion.clave_organo+"' and p.periodo = '"+PValidacion.periodo+"')"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_SUSPENSION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Estatus de la demanda no debe de ser 9=No_identificado.
public ArrayList Estatus_demandaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select id_organoj,CLAVE_EXPEDIENTE,DECODE(id_estatus_demanda,'-1','No_identificado') ESTATUS_DEMANDA,\n" +
"	REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO \n" +
"	from tr_expediente\n" +
"	WHERE \n" +
"	id_tipo_expediente = 5 and (id_estatus_demanda =-1 AND (SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' \n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("COMENTARIOS"),
                  resul.getString("ESTATUS_DEMANDA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//-Estatus del expediente no debe de ser 9=No_identificado.
public ArrayList Estatus_expedienteNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select id_organoj,CLAVE_EXPEDIENTE,DECODE(id_estatus_exped,'-1','No_identificado') ESTATUS_EXPEDIENTE,\n" +
"	REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from tr_expediente\n" +
"	WHERE id_tipo_expediente = 5 and (id_estatus_exped = -1 AND (SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"'\n" +
"	and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ESTATUS_EXPEDIENTE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from(\n" +
"	select id_organoj,CLAVE_EXPEDIENTE,preg_incompetencia,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO\n" +
"	from tr_expediente\n" +
"	where\n" +
"	tr_expediente.id_tipo_expediente = 5 and\n" +
"	(SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))\n" +
"	where preg_incompetencia=-1"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_INCOMPETENCIA"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList Tipo_IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from(\n" +
"	SELECT * FROM(\n" +
"	SELECT id_organoj,CLAVE_EXPEDIENTE,DECODE(preg_incompetencia,'2','No') INCOMPETENCIA,\n" +
"	id_tipo_incompetencia,PERIODO FROM tr_expediente WHERE preg_incompetencia=2 and id_tipo_expediente = 5)\n" +
"	WHERE id_tipo_incompetencia IS NOT NULL\n" +
"	)where  SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("INCOMPETENCIA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
public ArrayList PivIncompetencia(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	select id_organoj,CLAVE_EXPEDIENTE,preg_incompetencia,PERIODO from tr_expediente\n" +
"	WHERE fecha_present_demanda IS NOT NULL OR PREG_CONST_CONCILIAC \n" +
"	IS NOT NULL OR CLAVE_CONST_CONCILIAC IS NOT NULL OR\n" +
"	PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL OR PREG_FORMULO_DEMANDA \n" +
"	IS NOT NULL OR PREG_DESAHOGO_DEMANDA IS NOT NULL OR\n" +
"	ID_ESTATUS_DEMANDA IS NOT NULL OR fecha_adm_demanda \n" +
"	IS NOT NULL OR CANT_ACTORES IS NOT NULL OR CANT_DEMANDADOS IS NOT NULL OR\n" +
"	preg_audiencia_col_nat_eco IS NOT NULL OR fecha_audiencia_col_nat_eco \n" +
"	IS NOT NULL OR ID_ESTATUS_EXPED IS NOT NULL OR fecha_ult_act_proc IS NOT NULL OR\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR ID_FORMA_SOLUCION IS NOT NULL OR fecha_dicto_solucion IS NOT NULL OR\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL OR id_tipo_sentencia is not null OR COMENTARIOS IS NOT NULL and \n" +
"	tr_expediente.id_tipo_expediente = 5) \n" +
"	where  SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"') \n" +
"	WHERE preg_incompetencia=1";      
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_INCOMPETENCIA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEMANDA =DESECHADA,ARCHIVO, NO SE DIO TRAMITE A LA DEMANDA APARTIR DE FECHA_ADMI_DEMANDA NO DEBEN DE CONTESTAR
public ArrayList Estatus_Demanda_Desechada(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	SELECT id_organoj,CLAVE_EXPEDIENTE,ID_ESTATUS_DEMANDA,PERIODO FROM tr_expediente WHERE\n" +
"	tr_expediente.id_tipo_expediente = 5 AND (\n" +
"	fecha_adm_demanda IS NOT NULL OR CANT_ACTORES IS NOT NULL OR CANT_DEMANDADOS \n" +
"	IS NOT NULL OR PREG_AUDIENCIA_COL_NAT_ECO IS NOT NULL OR FECHA_AUDIENCIA_COL_NAT_ECO IS NOT NULL OR\n" +
"	ID_ESTATUS_EXPED IS NOT NULL OR FECHA_ULT_ACT_PROC IS NOT NULL OR ID_FASE_SOL_EXPED \n" +
"	IS NOT NULL OR ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR id_tipo_sentencia is not null  )) \n" +
"	where  SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"') \n" +
"	WHERE ID_ESTATUS_DEMANDA IN (2,3,4)";     
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_DEMANDA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Estatus_Expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,ID_ESTATUS_EXPED,PERIODO FROM TR_EXPEDIENTE \n" +
"	WHERE id_tipo_expediente = 5 and\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR ID_TIPO_SENTENCIA IS NOT NULL) \n" +
"	where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')\n" +
"	WHERE ID_ESTATUS_EXPED=2";      
//System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//cuando el estatus del expediente es = solucionado no debe de haber nada en fecha del ultimo acto procesal
public ArrayList Fecha_acto_procesal(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	select id_organoj,CLAVE_EXPEDIENTE,id_estatus_exped,fecha_ult_act_proc,PERIODO\n" +
"	from tr_expediente WHERE id_estatus_exped=1 AND\n" +
"	fecha_ult_act_proc IS NOT NULL\n" +
"	and tr_expediente.id_tipo_expediente = 5)\n" +
"	where  SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'";      
//System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_EXPED"),
                  resul.getString("FECHA_ULT_ACT_PROC")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList Fase_Sol_expNoExiste(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT p.id_organoj,p.CLAVE_EXPEDIENTE,S.DESCRIPCION FASE_SOLI_EXPEDIENTE\n" +
"	FROM tr_expediente P inner join tc_fase_solucion_exp S on p.id_fase_sol_exped = s.id_fase_solucion\n" +
"	WHERE p.id_tipo_expediente = 5\n" +
"	AND id_fase_sol_exped NOT IN(8,-1) AND\n" +
"	(SUBSTR(id_fase_sol_exped,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_fase_sol_exped='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' )"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("FASE_SOLI_EXPEDIENTE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=Tramitación por auto de depuración
public ArrayList Forma_Solucion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"	SELECT * FROM(\n" +
"	SELECT id_organoj,CLAVE_EXPEDIENTE,id_forma_solucion,PERIODO\n" +
"	FROM tr_expediente \n" +
"	WHERE id_TIPO_SENTENCIA is not null\n" +
"	and tr_expediente.id_tipo_expediente = 5)\n" +
"	where  SUBSTR(id_organoj,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'\n" +
"	or id_organoj='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"') \n" +
"	WHERE id_forma_solucion IN (2,3,4,5)"; 
//System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_FORMA_SOLUCION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDColect_Econom.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}
