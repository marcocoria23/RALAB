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
import mx.org.querys.NotNull.V3Ordinario;

/**
 *
 * @author ANTONIO.CORIA
 */
public class EDV3Colectivo {
 
 OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;



//Tipo de asunto no debe de ser =9 No_identificado
public ArrayList Tipo_Asunto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_TIPO_ASUNTO,'9','No_identificado') ID_TIPO_ASUNTO,PERIODO from TR_EXPEDIENTE\n" +
"WHERE (ID_TIPO_ASUNTO =9 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//--Cuando ¿Se anexó constancia de no conciliación expedida por el Centro Conciliación?=NO no debe de capturar Clave/identificador de la constancia
public ArrayList Cons_Expedida(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_CONST_CONCILIAC,'2','No','9','No identificado') PREG_CONST_CONCILIAC,PERIODO FROM TR_EXPEDIENTE\n" +
"WHERE (PREG_CONST_CONCILIAC IN (2,9) AND PREG_INCOMPETENCIA=1 AND (CLAVE_CONST_CONCILIAC IS NOT NULL) AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//--Cuando Suspensión temporal de las relaciones de trabajo=No o No identificado no debe capturar desde Por causas de fuerza mayor o caso fortuito no imputable al patrón hasta Por falta de ministración por parte del Estado. 
public ArrayList Suspencion_temporal(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT COUNT(ID_TIPO_SUSPENSION)REG,ID_ORGANOJ,CLAVE_EXPEDIENTE,PERIODO FROM(\n" +
"SELECT P.ID_ORGANOJ,P.CLAVE_EXPEDIENTE,P.ID_EXPEDIENTE,P.PERIODO,S.ID_TIPO_SUSPENSION FROM(\n" +
"SELECT unique(P.CLAVE_EXPEDIENTE),P.ID_ORGANOJ,P.ID_EXPEDIENTE,P.PERIODO \n" +
"FROM TR_EXPEDIENTE P\n" +
"INNER JOIN TR_EXP_MOTIVO_CONF S\n" +
"ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO AND P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"WHERE P.ID_TIPO_EXPEDIENTE=3\n" +
"AND S.ID_MOTIVO_CONFLICTO not in (28))P LEFT JOIN TR_EXP_SUSPENSION S\n" +
"ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO AND P.ID_ORGANOJ=S.ID_ORGANOJ)\n" +
"GROUP BY ID_ORGANOJ,CLAVE_EXPEDIENTE,PERIODO)WHERE REG>0 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  "NULL",
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//--cuando Terminacion colectiva de las relaciones de trabajo=No o No identificado, no debe capturarse desde Por causas de fuerza mayor o caso fortuito no imputable al patrón hasta Por agotamiento de la materia objeto de una industria extractiva
public ArrayList Terminacion_Colectiva(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT COUNT(ID_TIPO_TERMINACION)REG,ID_ORGANOJ,CLAVE_EXPEDIENTE,PERIODO FROM(\n" +
"SELECT P.ID_ORGANOJ,P.CLAVE_EXPEDIENTE,P.ID_EXPEDIENTE,P.PERIODO,S.ID_TIPO_TERMINACION FROM(\n" +
"SELECT unique(P.CLAVE_EXPEDIENTE),P.ID_ORGANOJ,P.ID_EXPEDIENTE,P.PERIODO \n" +
"FROM TR_EXPEDIENTE P\n" +
"INNER JOIN TR_EXP_MOTIVO_CONF S\n" +
"ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO AND P.ID_ORGANOJ=S.ID_ORGANOJ\n" +
"WHERE P.ID_TIPO_EXPEDIENTE=3\n" +
"AND S.ID_MOTIVO_CONFLICTO not in (29))P LEFT JOIN TR_EXP_TERMINACION S\n" +
"ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO AND P.ID_ORGANOJ=S.ID_ORGANOJ)\n" +
"GROUP BY ID_ORGANOJ,CLAVE_EXPEDIENTE,PERIODO)WHERE REG>0 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')";  
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  "NULL",
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//--cuando Violaciones a derechos fundamentales en materia colectiva=No o No identificado, no debe capturarse desde Libertad de asociación hasta  Especifique (otro tipo de violaciones a derechos fundamentales en materia colectiva).
public ArrayList Viola_Derechos(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"  SELECT EXPMC.ID_EXPEDIENTE, EXPMC.ID_ORGANOJ, EXPMC.CLAVE_EXPEDIENTE, EXPMC.PERIODO, \n" +
"         EXPMC.ID_MOTIVO_CONFLICTO, EXPMC.ID_TIPO_EXPEDIENTE, EV.ID_TIPO_VIOL_DH\n" +
"  FROM (\n" +
"    SELECT EXP.ID_EXPEDIENTE, EXP.ID_ORGANOJ, EXP.CLAVE_EXPEDIENTE, EXP.PERIODO, \n" +
"           MC.ID_MOTIVO_CONFLICTO, EXP.ID_TIPO_EXPEDIENTE\n" +
"    FROM TR_EXPEDIENTE EXP\n" +
"    LEFT JOIN TR_EXP_MOTIVO_CONF MC\n" +
"      ON EXP.ID_EXPEDIENTE = MC.ID_EXPEDIENTE\n" +
"      AND EXP.ID_ORGANOJ = MC.ID_ORGANOJ\n" +
"      AND EXP.PERIODO = MC.PERIODO\n" +
"    WHERE MC.ID_MOTIVO_CONFLICTO NOT IN (33)\n" +
"  ) EXPMC\n" +
"  LEFT JOIN TR_EXP_VIOLACION EV\n" +
"    ON EXPMC.ID_EXPEDIENTE = EV.ID_EXPEDIENTE\n" +
"    AND EXPMC.ID_ORGANOJ = EV.ID_ORGANOJ\n" +
"    AND EXPMC.PERIODO = EV.PERIODO\n" +
")\n" +
"WHERE ID_TIPO_EXPEDIENTE = 3 \n" +
"  AND ID_TIPO_VIOL_DH <> -1\n" +
"  AND (\n" +
"    (SUBSTR(ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PERIODO = '"+PValidacion.periodo+"')  \n" +
"     OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PERIODO = '"+PValidacion.periodo+"')\n" +
"  )";  
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_VIOL_DH"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//--Estatus de la demanda no debe de ser 9=No_identificado.
public ArrayList Estatus_Demanda(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="    select ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_ESTATUS_DEMANDA,'-1','No_identificado') ID_ESTATUS_DEMANDA,\n" +
"    REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO \n" +
"from TR_EXPEDIENTE\n" +
"WHERE ID_TIPO_EXPEDIENTE=3 AND (ID_ESTATUS_DEMANDA =-1 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_DEMANDA"),
                  resul.getString("COMENTARIOS"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//--Estatus del expediente no debe de ser 9=No_identificado.
public ArrayList Estatus_ExpedienteNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_ESTATUS_EXPED,'-1','No_identificado') ID_ESTATUS_EXPED,REPLACE(COMENTARIOS,',','')\n" +
"COMENTARIOS,PERIODO \n" +
"from TR_EXPEDIENTE\n" +
"WHERE ID_TIPO_EXPEDIENTE=3 AND ( ID_ESTATUS_EXPED =-1 AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from( \n" +
"select ID_ORGANOJ,CLAVE_EXPEDIENTE,PREG_INCOMPETENCIA,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE\n" +
" where   ID_TIPO_EXPEDIENTE=3 AND SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')where PREG_INCOMPETENCIA=-1"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
public ArrayList Tipo_IncompetenciaNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from(\n" +
" SELECT * FROM(\n" +
"SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_INCOMPETENCIA,'-1','No') PREG_INCOMPETENCIA,ID_TIPO_INCOMPETENCIA,PERIODO \n" +
"FROM TR_EXPEDIENTE WHERE PREG_INCOMPETENCIA=2 AND ID_TIPO_EXPEDIENTE=3)\n" +
"WHERE  ID_TIPO_INCOMPETENCIA IS NOT NULL  \n" +
" )where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
public ArrayList PivIncompetencia(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, SUBSTR(ID_ORGANOJ,0,2) ENTIDAD_CLAVE,PERIODO \n" +
"FROM  TR_EXPEDIENTE\n" +
"WHERE \n" +
"  ( ID_TIPO_EXPEDIENTE=3) AND\n" +
"(PREG_INCOMPETENCIA = 1 ) \n" +
"AND ( \n" +
"FECHA_PRESENT_DEMANDA IS NOT NULL OR\n" +
"PREG_CONST_CONCILIAC IS NOT NULL OR\n" +
"CLAVE_CONST_CONCILIAC IS NOT NULL OR\n" +
"PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL OR\n" +
"PREG_FORMULO_DEMANDA IS NOT NULL OR\n" +
"PREG_DESAHOGO_DEMANDA IS NOT NULL OR\n" +
"ID_ESTATUS_DEMANDA IS NOT NULL OR\n" +
"FECHA_ADM_DEMANDA IS NOT NULL OR\n" +
"CANT_ACTORES IS NOT NULL OR\n" +
"CANT_DEMANDADOS IS NOT NULL OR\n" +
"PREG_AUTO_DEPURACION_TRAM IS NOT NULL OR\n" +
"FECHA_AUTO_DEPURACION IS NOT NULL OR\n" +
"PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR\n" +
"FECHA_AUD_JUICIO IS NOT NULL OR\n" +
"ID_ESTATUS_EXPED IS NOT NULL OR\n" +
"FECHA_ULT_ACT_PROC IS NOT NULL OR\n" +
"ID_FASE_SOL_EXPED IS NOT NULL OR\n" +
"ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"FECHA_DICTO_SOLUCION IS NOT NULL OR\n" +
"ID_TIPO_SENTENCIA IS NOT NULL OR\n" +
"MONTO_SOLUCION IS NOT NULL  )) where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando ¿Se formuló prevención a la demanda?=NO o No identificado, no debe de capturar ¿Se desahogó la prevención de la demanda?
public ArrayList Preve_demanda(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_FORMULO_DEMANDA,'2','No','-1','No identificado') PREG_FORMULO_DEMANDA,PERIODO FROM TR_EXPEDIENTE\n" +
"WHERE ID_TIPO_EXPEDIENTE=3 AND (PREG_FORMULO_DEMANDA in (2,-1) AND PREG_INCOMPETENCIA=2 and  (PREG_DESAHOGO_DEMANDA IS NOT NULL)AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEMANDA =DESECHADA,ARCHIVO, NO SE DIO TRAMITE A LA DEMANDA APARTIR DE FECHA_ADMI_DEMANDA NO DEBEN DE CONTESTAR
public ArrayList Estatus_Demanda_Desechada(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, SUBSTR(ID_ORGANOJ,0,2) ENTIDAD_CLAVE,PERIODO,ID_ESTATUS_DEMANDA \n" +
"FROM  TR_EXPEDIENTE\n" +
"WHERE \n" +
"  ( ID_TIPO_EXPEDIENTE=3) AND\n" +
"(ID_ESTATUS_DEMANDA IN  (2,3,4) ) \n" +
"AND ( \n" +
"FECHA_ADM_DEMANDA IS NOT NULL OR\n" +
"CANT_ACTORES IS NOT NULL OR\n" +
"CANT_DEMANDADOS IS NOT NULL OR\n" +
"PREG_AUTO_DEPURACION_TRAM IS NOT NULL OR\n" +
"FECHA_AUTO_DEPURACION IS NOT NULL OR\n" +
"PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR\n" +
"FECHA_AUD_JUICIO IS NOT NULL OR\n" +
"ID_ESTATUS_EXPED IS NOT NULL OR\n" +
"FECHA_ULT_ACT_PROC IS NOT NULL OR\n" +
"ID_FASE_SOL_EXPED IS NOT NULL OR\n" +
"ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"FECHA_DICTO_SOLUCION IS NOT NULL OR\n" +
"ID_TIPO_SENTENCIA IS NOT NULL OR\n" +
"MONTO_SOLUCION IS NOT NULL  )) where  ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"') \n" +
" or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')) \n"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


////Cuando ¿Hubo tramitación por auto de depuración? =No o No identificado, no debe de capturarse Fecha de auto de depuración.
public ArrayList Tram_depuracion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_AUTO_DEPURACION_TRAM,'2','No','-1','No identificado') PREG_AUTO_DEPURACION_TRAM,PERIODO\n" +
"FROM TR_EXPEDIENTE \n" +
"WHERE ID_TIPO_EXPEDIENTE=3  and (PREG_AUTO_DEPURACION_TRAM in (2,-1) and ID_ESTATUS_DEMANDA=1 AND (FECHA_AUTO_DEPURACION IS NOT NULL) AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_AUTO_DEPURACION_TRAM")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


////Cuando ¿Hubo celebración de audiencia de juicio? =No o No identificado, no debe de capturarse Fecha de audiencia de juicio
public ArrayList Audiencia_juicio(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(PREG_CELEBRA_AUD_JUICIO,'2','No','-1','No identificado') PREG_CELEBRA_AUD_JUICIO,PERIODO FROM TR_EXPEDIENTE \n" +
"WHERE  ID_TIPO_EXPEDIENTE=3 AND (PREG_CELEBRA_AUD_JUICIO in (2,-1) and ID_ESTATUS_DEMANDA=1 AND (FECHA_AUD_JUICIO IS NOT NULL) AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("PREG_CELEBRA_AUD_JUICIO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }





//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Estatus_Expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, SUBSTR(ID_ORGANOJ,0,2) ENTIDAD_CLAVE,PERIODO,ID_ESTATUS_EXPED \n" +
"FROM  TR_EXPEDIENTE\n" +
"WHERE \n" +
"  ( ID_TIPO_EXPEDIENTE=3) AND\n" +
"(ID_ESTATUS_EXPED IN  (2) ) \n" +
"AND ( \n" +
"ID_FASE_SOL_EXPED IS NOT NULL OR\n" +
"ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"FECHA_DICTO_SOLUCION IS NOT NULL OR\n" +
"ID_TIPO_SENTENCIA IS NOT NULL OR\n" +
"MONTO_SOLUCION IS NOT NULL  )) where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'";      
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
public ArrayList Fecha_acto_procesal(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"select ID_ORGANOJ,CLAVE_EXPEDIENTE,ID_ESTATUS_EXPED,TO_CHAR(FECHA_ULT_ACT_PROC,'DD/MM/YYYY')FECHA_ULT_ACT_PROC,PERIODO\n" +
"from TR_EXPEDIENTE WHERE  ID_TIPO_EXPEDIENTE=3 AND ID_ESTATUS_EXPED=1 AND\n" +
"FECHA_ULT_ACT_PROC IS NOT NULL) where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' ";      
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList Fase_Sol_expNoExiste(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_TIPO_EXPEDIENTE\n" +
"FROM TR_EXPEDIENTE P, TC_FASE_SOLUCION_EXP S \n" +
"WHERE  P.ID_FASE_SOL_EXPED=S.ID_FASE_SOLUCION \n" +
"AND ID_FASE_SOL_EXPED NOT IN(2,3,-1) AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'  \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' )\n" +
" ) WHERE ID_TIPO_EXPEDIENTE = '3'"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando Fase de solicitud del expediente (FASE_SOLI_EXPEDIENTE) =No identificado, no debe capturar desde Forma de solución (FORMA_SOLUCION_AD) hasta Monto estipulado en la forma de solución (MONTO_SOLUCION_AJ).  O en su caso agregar la fase del expediente si es que hay valor valido en la fecha de resolución.
public ArrayList Fase_Sol_expNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,DECODE(ID_FASE_SOL_EXPED,'-1','No identificado')ID_FASE_SOL_EXPED,PERIODO \n" +
"FROM TR_EXPEDIENTE \n" +
"WHERE ID_TIPO_EXPEDIENTE=3 AND ID_FASE_SOL_EXPED='-1' AND (ID_FORMA_SOLUCION IS NOT NULL OR\n" +
"FECHA_DICTO_SOLUCION IS NOT NULL OR ID_TIPO_SENTENCIA IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR\n" +
"ID_FORMA_SOLUCION IS NOT NULL OR FECHA_DICTO_SOLUCION IS NOT NULL) and \n" +
"                 (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' )"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=TRAMITACION POR AUTODEPURACION NO DEBE DE CAPTURAR SOLUCION (AUDIENCIA DE JUICIO)
/*public ArrayList Fase_Sol_exp_TAP(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT * FROM(\n" +
"SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,FASE_SOLI_EXPEDIENTE,PERIODO FROM V3_TR_COLECTIVOJL WHERE \n" +
"FORMA_SOLUCION_AJ IS NOT NULL OR OTRO_ESP_SOLUCION_AJ IS NOT NULL OR FECHA_RESOLUCION_AJ IS NOT NULL OR \n" +
"TIPO_SENTENCIA_AJ IS NOT NULL OR MONTO_SOLUCION_AJ IS NOT NULL) where  SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' ) WHERE FASE_SOLI_EXPEDIENTE IN (3)"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }*/


//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=AUDIENCIA JUICIO NO DEBE DE CAPTURAR   SOLUCION(TRAMITACION POR AUTO DEPURACION)
/*public ArrayList Fase_Sol_exp_AJ(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT * FROM(\n" +
"SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,FASE_SOLI_EXPEDIENTE,PERIODO FROM V3_TR_COLECTIVOJL WHERE \n" +
"FORMA_SOLUCION_AD IS NOT NULL OR  OTRO_ESP_SOLUCION_AD IS NOT NULL OR\n" +
"FECHA_DICTO_RESOLUCION_AD IS NOT NULL OR  MONTO_SOLUCION_AD IS NOT NULL \n" +
" ) where  SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }*/


public ArrayList SinMotivo_Conflicto(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT COUNT(ID_EXPEDIENTE)ID_EXPEDIENTE,CLAVE_EXPEDIENTE,ID_ORGANOJ,PERIODO,FECHA_APERTURA_EXPED FROM(\n" +
"SELECT\n" +
"    P.ID_ORGANOJ,P.CLAVE_EXPEDIENTE,S.ID_EXPEDIENTE,\n" +
"    TO_CHAR(P.FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,P.PERIODO\n" +
"FROM\n" +
"    TR_EXPEDIENTE P LEFT JOIN TR_EXP_MOTIVO_CONF S\n" +
"ON\n" +
"   P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND\n" +
"   P.ID_ORGANOJ=S.ID_ORGANOJ AND\n" +
"   P.PERIODO=S.PERIODO\n" +
" WHERE  P.ID_TIPO_EXPEDIENTE=3\n" +
"    and(SUBSTR(P.ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and P.periodo = '"+PValidacion.periodo+"' \n" +
" or P.ID_ORGANOJ='"+PValidacion.clave_organo+"' and P.periodo = '"+PValidacion.periodo+"'))GROUP BY CLAVE_EXPEDIENTE,ID_ORGANOJ,PERIODO,FECHA_APERTURA_EXPED)\n" +
" WHERE ID_EXPEDIENTE=0"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
