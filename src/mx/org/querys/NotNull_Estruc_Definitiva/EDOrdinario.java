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
import mx.org.querys.V1querys;


/**
 *
 * @author JOSE.CABRERA
 */
public class EDOrdinario {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;







///Tipo de asunto no debe de ser =9 No_identificado
public ArrayList Tipo_asuntoNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,decode(ID_TIPO_ASUNTO,'-1','No_identificado')ID_TIPO_ASUNTO,PERIODO from TR_EXPEDIENTE 	\n" +
"	WHERE ((ID_TIPO_ASUNTO =-1 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_ASUNTO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///--Cuando Tipo de asunto = Colectivo no debe de capturar ¿El trabajador contó con contrato escrito? ni Tipo de contrato
public ArrayList Tipo_asunto_ColectNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_TIPO_ASUNTO,'2','Colectivo') ID_TIPO_ASUNTO,PERIODO FROM TR_EXPEDIENTE  	\n" +
"	WHERE (ID_TIPO_ASUNTO=2 AND ( PREG_TRAB_CONTR_ESCRI IS NOT NULL OR  ID_TIPO_CONTRATO IS NOT NULL ) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_ASUNTO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



///--Cuando ¿El trabajador contó con contrato escrito? = No o No identificado, no debe de capturar tipo de contrato
public ArrayList Contrato_escritoNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_TRAB_CONTR_ESCRI,'2','No','-1','No identificado') PREG_TRAB_CONTR_ESCRI,PERIODO FROM TR_EXPEDIENTE  	\n" +
"	WHERE (ID_TIPO_ASUNTO=1 AND PREG_TRAB_CONTR_ESCRI IN (2,-1) and ( ID_TIPO_CONTRATO IS NOT NULL ) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_TRAB_CONTR_ESCRI"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///--Cuando Tipo de asunto=Colectivo no debe capturarse desde ¿El conflicto laboral se encuentra vinculado al esquema de subcontratación (outsourcing)? hasta  Especifique (otro tipo de prestaciones)
public ArrayList Ta_Colectivo(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    e.ID_EXPEDIENTE,	\n" +
"	    e.ID_ORGANOJ, 	\n" +
"	    e.CLAVE_EXPEDIENTE, 	\n" +
"	    DECODE(e.ID_TIPO_ASUNTO, '2', 'Colectivo') AS PREG_TRAB_CONTR_ESCRI, 	\n" +
"	    e.PERIODO	\n" +
"	FROM TR_EXPEDIENTE e	\n" +
"	WHERE e.ID_TIPO_ASUNTO = 2	\n" +
"	AND (	\n" +
"	    EXISTS (SELECT 1 FROM TR_EXP_MOTIVO_CONF mc WHERE mc.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND mc.ID_ORGANOJ = e.ID_ORGANOJ AND mc.PERIODO = e.PERIODO)	\n" +
"	    OR EXISTS (SELECT 1 FROM TR_EXP_CIRCUNST c WHERE c.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND c.ID_ORGANOJ = e.ID_ORGANOJ AND c.PERIODO = e.PERIODO)	\n" +
"	    OR EXISTS (SELECT 1 FROM TR_EXP_CONCEPTO_RECLAM cr WHERE cr.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND cr.ID_ORGANOJ = e.ID_ORGANOJ AND cr.PERIODO = e.PERIODO)	\n" +
"	    OR EXISTS (SELECT 1 FROM TR_EXP_PRESTACION p WHERE p.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND p.ID_ORGANOJ = e.ID_ORGANOJ AND p.PERIODO = e.PERIODO)	\n" +
"	)	\n" +
"	AND (	\n" +
"	    (SUBSTR(e.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	    OR (e.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	)"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_TRAB_CONTR_ESCRI"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




///--cuando ¿Aplican circunstancias vinculadas al motivo del conflicto? = No o No identificado, no debe capturarse a partir Discriminación en el empleo y ocupación por embarazo hasta Acoso sexual
public ArrayList Mot_conflicto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    e.ID_EXPEDIENTE,	\n" +
"	    e.ID_ORGANOJ, 	\n" +
"	    e.CLAVE_EXPEDIENTE, 	\n" +
"	    DECODE(e.PREG_APL_CIR_VIN_MOT_CONF, '2', 'No', '-1', 'No identificado') AS PREG_APL_CIR_VIN_MOT_CONF, 	\n" +
"	    e.PERIODO	\n" +
"	FROM TR_EXPEDIENTE e	\n" +
"	WHERE e.PREG_APL_CIR_VIN_MOT_CONF IN (2, -1)	\n" +
"	AND e.ID_TIPO_ASUNTO = 1	\n" +
"	AND (	\n" +
"	    EXISTS (SELECT 1 FROM TR_EXP_CIRCUNST c WHERE c.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND c.ID_ORGANOJ = e.ID_ORGANOJ AND c.PERIODO = e.PERIODO)	\n" +
"	)	\n" +
"	AND (	\n" +
"	    (SUBSTR(e.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	    OR (e.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	)"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_APL_CIR_VIN_MOT_CONF"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando Pago de prestaciones=No o no identificado, No debe capturarse desde Aguinaldo hasta   Especifique (otro tipo de prestaciones).uando ¿Aplican circunstancias vinculadas al motivo del conflicto? = No no debe capturarse a partir Discriminación en el empleo y ocupación por embarazo hasta Acoso sexual
public ArrayList Pago_prestaciones(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    e.ID_EXPEDIENTE,	\n" +
"	    e.ID_ORGANOJ, 	\n" +
"	    e.CLAVE_EXPEDIENTE, 	\n" +
"	    DECODE(e.PREG_PRESTACION,'2','No','-1','No identificado') PREG_PRESTACION, 	\n" +
"	    e.PERIODO	\n" +
"	FROM TR_EXPEDIENTE e	\n" +
"	WHERE e.PREG_PRESTACION IN (2, -1)	\n" +
"	AND e.ID_TIPO_ASUNTO = 1	\n" +
"	AND (	\n" +
"	    EXISTS (SELECT 1 FROM TR_EXP_PRESTACION p WHERE p.ID_EXPEDIENTE = e.ID_EXPEDIENTE AND p.ID_ORGANOJ = e.ID_ORGANOJ AND e.PERIODO = p.PERIODO)	\n" +
"	)	\n" +
"	AND (	\n" +
"	    (SUBSTR(e.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	    OR (e.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND e.PERIODO = '"+PValidacion.periodo+"' AND e.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	)"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_PRESTACION"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando ¿Se anexó constancia de no conciliación expedida por el Centro Conciliación?=NO o No identificado, no debe de capturar Clave/identificador de la constancia
public ArrayList Cons_expedida(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_CONST_CONCILIAC,'2','No','-1','No identificado') PREG_CONST_CONCILIAC,PERIODO FROM TR_EXPEDIENTE 	\n" +
"	WHERE (PREG_CONST_CONCILIAC in (2,-1) AND PREG_INCOMPETENCIA=2 and  (CLAVE_CONST_CONCILIAC IS NOT NULL)AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_CONST_CONCILIAC"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando ¿Se formuló prevención a la demanda?=NO o No identificado, no debe de capturar ¿Se desahogó la prevención de la demanda?
public ArrayList Preve_demanda(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_FORMULO_DEMANDA,'2','No','-1','No identificado') PREG_FORMULO_DEMANDA,PERIODO FROM TR_EXPEDIENTE 	\n" +
"	WHERE (PREG_FORMULO_DEMANDA in (2,-1) AND PREG_INCOMPETENCIA=2 and  (PREG_DESAHOGO_DEMANDA IS NOT NULL) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_FORMULO_DEMANDA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }






//Cuando ¿Se anexó constancia de no conciliación expedida por el Centro Conciliación?=NO no debe de capturar Clave/identificador de la constancia
public ArrayList Estatus_demaNi(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_ESTATUS_DEMANDA,'-1','No_identificado') ID_ESTATUS_DEMANDA,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE 	\n" +
"	WHERE (ID_ESTATUS_DEMANDA =-1 AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_DEMANDA"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//-Cuando Estatus de la demanda =Admitida o No identificado , debe de capturarse Causas que impiden la admisión de la demanda
public ArrayList Impiden_admision_demanda(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_ESTATUS_DEMANDA,'1','Admitida','-1','No identificado') ID_ESTATUS_DEMANDA,PERIODO FROM TR_EXPEDIENTE 	\n" +
"	WHERE (ID_ESTATUS_DEMANDA IN (1,-1) AND PREG_INCOMPETENCIA = 2 AND (id_causa_imp_adm_demanda IS NOT NULL) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_DEMANDA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando ¿Hubo celebración de audiencia preliminar?=NO o No identificado, no debe de capturar Fecha de audiencia preliminar.
public ArrayList audiencia_preliminar(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_AUD_PRELIM_CELEBR,'2','No','-1','No identificado') PREG_AUD_PRELIM_CELEBR,PERIODO FROM TR_EXPEDIENTE 	\n" +
"	WHERE (PREG_AUD_PRELIM_CELEBR in (2,-1) AND PREG_INCOMPETENCIA=2 and  (FECHA_AUDIENCIA_PRELIM IS NOT NULL) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_AUD_PRELIM_CELEBR"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando ¿Hubo celebración de audiencia de juicio?=NO o No identificado, no debe de capturar Fecha de audiencia de juicio
public ArrayList audiencia_juicio(){
      conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_CELEBRA_AUD_JUICIO,'2','No','-1','No identificado')PREG_CELEBRA_AUD_JUICIO,PERIODO FROM TR_EXPEDIENTE 	\n" +
"	WHERE (PREG_CELEBRA_AUD_JUICIO in (2,-1) AND PREG_INCOMPETENCIA=2 and  (FECHA_AUD_JUICIO IS NOT NULL) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_CELEBRA_AUD_JUICIO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//-Estatus del expediente no debe de ser 9=No_identificado.
public ArrayList Estatus_ExpedienteNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_ESTATUS_EXPED,'-1','No_identificado') ID_ESTATUS_EXPED,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE 	\n" +
"	WHERE (ID_ESTATUS_EXPED =-1 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1	\n" +
"	 or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_EXPED"),
                  resul.getString("COMENTARIOS"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from( 	\n" +
"	select ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,PREG_INCOMPETENCIA,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE 	\n" +
"	 where  (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))where PREG_INCOMPETENCIA=-1"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_INCOMPETENCIA"),
                  resul.getString("COMENTARIOS"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList Tipo_IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select 	\n" +
"	    ID_EXPEDIENTE, \n" +
"           ID_ORGANOJ, 	\n" +
"	    CLAVE_EXPEDIENTE, 	\n" +
"	    PREG_INCOMPETENCIA,	\n" +
"	    ID_TIPO_INCOMPETENCIA,	\n" +
"	    PERIODO	\n" +
"	 from( 	\n" +
"	 SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, DECODE(PREG_INCOMPETENCIA,'2','No') PREG_INCOMPETENCIA, ID_TIPO_INCOMPETENCIA,PERIODO FROM TR_EXPEDIENTE WHERE PREG_INCOMPETENCIA=2) 	\n" +
"	WHERE ID_TIPO_INCOMPETENCIA IS NOT NULL   	\n" +
"	 )where  (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_INCOMPETENCIA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
public ArrayList PivIncompetencia(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,PREG_INCOMPETENCIA,PERIODO	\n" +
"	FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	select ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,ID_TIPO_EXPEDIENTE,PREG_INCOMPETENCIA,PERIODO from TR_EXPEDIENTE 	\n" +
"	WHERE  FECHA_PRESENT_DEMANDA IS NOT NULL OR  	\n" +
"	PREG_CONST_CONCILIAC IS NOT NULL OR  CLAVE_CONST_CONCILIAC IS NOT NULL 	\n" +
"	OR PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL OR  	\n" +
"	PREG_FORMULO_DEMANDA IS NOT NULL OR 	\n" +
"	PREG_DESAHOGO_DEMANDA IS NOT NULL OR 	\n" +
"	ID_ESTATUS_DEMANDA IS NOT NULL OR 	\n" +
"	id_causa_imp_adm_demanda IS NOT NULL OR 	\n" +
"	FECHA_ADM_DEMANDA IS NOT NULL OR  CANT_ACTORES IS NOT NULL OR 	\n" +
"	CANT_DEMANDADOS IS NOT NULL OR  PREG_FECHA_CELEBR_AUDIENCIA IS NOT NULL OR  	\n" +
"	FECHA_AUDIENCIA_PRELIM IS NOT NULL OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	FECHA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	ID_ESTATUS_EXPED IS NOT NULL OR  FECHA_ULT_ACT_PROC IS NOT NULL OR 	\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR   	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR   	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))WHERE PREG_INCOMPETENCIA=1"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_INCOMPETENCIA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Favor de verificar Incompetencia ya que contiene dato apartir de Tipo de incompetencia (TIPO_INCOMPETENCIA)
public ArrayList PivIncompetencia_Noidentificado(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, PREG_INCOMPETENCIA, COMENTARIOS, PERIODO	\n" +
"	FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	select ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE 	\n" +
"	WHERE ID_TIPO_INCOMPETENCIA IS NOT NULL OR FECHA_PRESENT_DEMANDA IS NOT NULL OR  	\n" +
"	PREG_CONST_CONCILIAC IS NOT NULL OR  CLAVE_CONST_CONCILIAC IS NOT NULL 	\n" +
"	OR PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL OR  	\n" +
"	PREG_FORMULO_DEMANDA IS NOT NULL OR 	\n" +
"	PREG_DESAHOGO_DEMANDA IS NOT NULL OR 	\n" +
"	ID_ESTATUS_DEMANDA IS NOT NULL OR 	\n" +
"	id_causa_imp_adm_demanda IS NOT NULL OR 	\n" +
"	FECHA_ADM_DEMANDA IS NOT NULL OR  CANT_ACTORES IS NOT NULL OR 	\n" +
"	CANT_DEMANDADOS IS NOT NULL OR  PREG_FECHA_CELEBR_AUDIENCIA IS NOT NULL OR  	\n" +
"	FECHA_AUDIENCIA_PRELIM IS NOT NULL OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	FECHA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	ID_ESTATUS_EXPED IS NOT NULL OR  FECHA_ULT_ACT_PROC IS NOT NULL OR 	\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR 	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1 )))WHERE PREG_INCOMPETENCIA=-1"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("COMENTARIOS"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//ESTATUS DEMANDA =DESECHADA,ARCHIVO, NO SE DIO TRAMITE A LA DEMANDA APARTIR DE FECHA_ADMI_DEMANDA NO DEBEN DE CONTESTAR
public ArrayList Estatus_Demanda_Desechada(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_ESTATUS_DEMANDA,PERIODO	\n" +
"	FROM( SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_ESTATUS_DEMANDA,PERIODO FROM TR_EXPEDIENTE WHERE  	\n" +
"	FECHA_ADM_DEMANDA IS NOT NULL OR  CANT_ACTORES IS NOT NULL OR 	\n" +
"	CANT_DEMANDADOS IS NOT NULL OR  PREG_FECHA_CELEBR_AUDIENCIA IS NOT NULL OR  	\n" +
"	FECHA_AUDIENCIA_PRELIM IS NOT NULL OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	FECHA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	ID_ESTATUS_EXPED IS NOT NULL OR  FECHA_ULT_ACT_PROC IS NOT NULL OR 	\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR  	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)))WHERE ID_ESTATUS_DEMANDA IN (2,3,4)"; 
      System.out.println(sql);
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//Favor de Verificar Estatus_demanda ya que contiene informacion a apartir de Fecha de Admision de la demanda (FECHA_ADMI_DEMANDA).
public ArrayList Estatus_Demanda_NoIdentificada(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_ESTATUS_DEMANDA,PERIODO	\n" +
"	 FROM( SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_ESTATUS_DEMANDA,PERIODO FROM TR_EXPEDIENTE WHERE  	\n" +
"	FECHA_ADM_DEMANDA IS NOT NULL OR  CANT_ACTORES IS NOT NULL OR 	\n" +
"	CANT_DEMANDADOS IS NOT NULL OR  PREG_FECHA_CELEBR_AUDIENCIA IS NOT NULL OR  	\n" +
"	FECHA_AUDIENCIA_PRELIM IS NOT NULL OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	FECHA_AUD_JUICIO IS NOT NULL OR  	\n" +
"	ID_ESTATUS_EXPED IS NOT NULL OR  FECHA_ULT_ACT_PROC IS NOT NULL OR 	\n" +
"	ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR  	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))) WHERE ID_ESTATUS_DEMANDA IN (-1)"; 
      System.out.println(sql);
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Estatus_Expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_ESTATUS_EXPED,PERIODO	\n" +
"	FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED,PERIODO FROM TR_EXPEDIENTE WHERE ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR  	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))) WHERE ID_ESTATUS_EXPED=2";      
 System.out.println(sql);
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Estatus_Expediente_Noidentificado(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_ESTATUS_EXPED,PERIODO	\n" +
"	 FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED,PERIODO FROM TR_EXPEDIENTE WHERE ID_FASE_SOL_EXPED IS NOT NULL OR  	\n" +
"	FECHA_ULT_ACT_PROC IS NOT NULL OR 	\n" +
"	ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR  	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))) WHERE ID_ESTATUS_EXPED=-1";      
 System.out.println(sql);
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Fecha_acto_procesal(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_ULT_ACT_PROC, PERIODO 	\n" +
"	FROM( 	\n" +
"	select ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_ULT_ACT_PROC, PERIODO 	\n" +
"	from TR_EXPEDIENTE WHERE ID_ESTATUS_EXPED=1 AND 	\n" +
"	FECHA_ULT_ACT_PROC IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))";      
System.out.println(sql);
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList Fase_Sol_expNoExiste(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, S.DESCRIPCION ID_FASE_SOL_EXPED 	\n" +
"	FROM TR_EXPEDIENTE P, TC_FASE_SOLUCION_EXP S 	\n" +
"	WHERE  P.ID_FASE_SOL_EXPED = S.ID_FASE_SOLUCION	\n" +
"	AND ID_FASE_SOL_EXPED NOT IN (1,2,9,-1) AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1) 	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'  AND ID_TIPO_EXPEDIENTE = 1))"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_FASE_SOL_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Cuando Fase de solicitud del expediente (FASE_SOLI_EXPEDIENTE) =No identificado, no debe capturar desde Forma de solución (FORMA_SOLUCIONFE) hasta Monto estipulado en la forma de solución (MONTO_SOLUCIONAJ).  O en su caso agregar la fase del expediente si es que hay valor valido en la fecha de resolución.
public ArrayList Fase_Sol_expNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, DECODE(ID_FASE_SOL_EXPED,'-1','No identificado')ID_FASE_SOL_EXPED, PERIODO FROM TR_EXPEDIENTE  	\n" +
"	WHERE ID_FASE_SOL_EXPED='-1' AND (ID_FORMA_SOLUCION IS NOT NULL OR  	\n" +
"	FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR  	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) and 	\n" +
"	                 ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1)  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_FASE_SOL_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=FASE ESCRITA NO DEBE DE CAPTURAR APARTIR DE SOLUCION(AUDIENCIA PRELIMINAR) SOLUCION (AUDIENCIA DE JUICIO)
public ArrayList Fase_Sol_exp_FE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_FASE_SOL_EXPED,PERIODO	\n" +
"	FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED,PERIODO FROM TR_EXPEDIENTE WHERE    	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))) WHERE ID_FASE_SOL_EXPED IN (9) 	\n" +
"	"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_FASE_SOL_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }





//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=AUDIENCIA PRELIMINAR NO DEBE DE CAPTURAR   SOLUCION(FASE ESCRITA) SOLUCION (AUDIENCIA DE JUICIO)
public ArrayList Fase_Sol_exp_AP(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT 	\n" +
"	    ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_FASE_SOL_EXPED,PERIODO	\n" +
"	FROM( 	\n" +
"	SELECT * FROM( 	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED,PERIODO FROM TR_EXPEDIENTE WHERE    	\n" +
"	ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  AND ID_TIPO_EXPEDIENTE = 1)	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = 1))) WHERE ID_FASE_SOL_EXPED IN (1) 	\n" +
"	)"; 
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_FASE_SOL_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


/*  No aplica 
//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=AUDIENCIA JUICIO NO DEBE DE CAPTURAR   SOLUCION(FASE ESCRITA) SOLUCION (AUDIENCIA PRELIMINAR)
public ArrayList Fase_Sol_exp_AJ(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT * FROM(\n" +
"SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,FASE_SOLI_EXPEDIENTE,PERIODO FROM V3_TR_ORDINARIOJL WHERE \n" +
"FORMA_SOLUCIONAP IS NOT NULL OR  OTRO_ESP_SOLUCIONAP IS NOT NULL OR\n" +
"FECHA_DICTO_RESOLUCIONAP IS NOT NULL OR  MONTO_SOLUCION_AP IS NOT NULL OR\n" +
"FORMA_SOLUCIONFE IS NOT NULL OR  OTRO_ESP_SOLUCIONFE IS NOT NULL OR \n" +
"FECHA_DICTO_RESOLUCIONFE IS NOT NULL OR MONTO_SOLUCION_FE IS NOT NULL ) where  SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' ) WHERE FASE_SOLI_EXPEDIENTE IN (2)"; 
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
*/ 

public ArrayList SinMotivo_Conflicto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * 	\n" +
"	FROM (	\n" +
"	SELECT  	\n" +
"	    exp.ID_EXPEDIENTE,	\n" +
"	    exp.ID_ORGANOJ, 	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    TO_CHAR(exp.FECHA_APERTURA_EXPED, 'dd/mm/yyyy') AS FECHA_APERTURA_EXPED,	\n" +
"	    DECODE(exp.PREG_APL_CIR_VIN_MOT_CONF, '1', 'Sí', '2', 'No', '-1', 'No identificado') AS PREG_APL_CIR_VIN_MOT_CONF, 	\n" +
"	    COALESCE(TO_CHAR(mc.ID_MOTIVO_CONFLICTO), 'Sin motivo especificado') AS ID_MOTIVO_CONFLICTO,	\n" +
"	    exp.PERIODO	\n" +
"	FROM TR_EXPEDIENTE exp	\n" +
"	LEFT JOIN TR_EXP_MOTIVO_CONF mc 	\n" +
"	    ON mc.ID_EXPEDIENTE = exp.ID_EXPEDIENTE 	\n" +
"	    AND mc.ID_ORGANOJ = exp.ID_ORGANOJ 	\n" +
"	    AND mc.PERIODO = exp.PERIODO	\n" +
"	WHERE 	\n" +
"	    exp.PREG_APL_CIR_VIN_MOT_CONF = '1'	\n" +
"	AND (	\n" +
"	    (SUBSTR(exp.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND exp.PERIODO = '"+PValidacion.periodo+"' AND exp.ID_TIPO_EXPEDIENTE = 1)	\n" +
"	    OR (exp.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND exp.PERIODO = '"+PValidacion.periodo+"' AND exp.ID_TIPO_EXPEDIENTE = 1))	\n" +
"	    ) WHERE ID_MOTIVO_CONFLICTO = 'Sin motivo especificado'"; 
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
            Logger.getLogger(EDOrdinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
