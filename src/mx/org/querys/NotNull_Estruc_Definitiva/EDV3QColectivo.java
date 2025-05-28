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
 * @author ANTONIO.CORIA
 */


public class EDV3QColectivo {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;


public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE \n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"(FECHA_APERTURA_EXPED>SYSDATE \n" +
"AND FECHA_APERTURA_EXPED <> '09/09/1899')\n" +
"and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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

public ArrayList FECHA_PRES_DEMANDA_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_PRESENT_DEMANDA,'DD/MM/YYYY')FECHA_PRESENT_DEMANDA,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE \n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"(FECHA_PRESENT_DEMANDA>SYSDATE \n" +
"AND FECHA_PRESENT_DEMANDA <> '09/09/1899')\n" +
"and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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

public ArrayList FECHA_ADMI_DEMANDA_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_ADM_DEMANDA,'DD/MM/YYYY')FECHA_ADM_DEMANDA,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE \n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"(FECHA_ADM_DEMANDA>SYSDATE \n" +
"AND FECHA_ADM_DEMANDA <> '09/09/1899')\n" +
"and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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

public ArrayList FECHA_DEPURACION_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, TO_CHAR(FECHA_AUTO_DEPURACION,'DD/MM/YYYY')FECHA_AUTO_DEPURACION,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM TR_EXPEDIENTE \n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"(FECHA_AUTO_DEPURACION>SYSDATE \n" +
"AND FECHA_AUTO_DEPURACION <> '09/09/1899')\n" +
"and  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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

/*public ArrayList FECHA_AUDIENCIA_JUICIO_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT clave_organo, expediente_clave, periodo, TO_CHAR(FECHA_AUDIENCIA_JUICIO,'DD/MM/YYYY')FECHA_AUDIENCIA_JUICIO,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM V3_TR_COLECTIVOJL \n" +
"WHERE \n" +
"(FECHA_AUDIENCIA_JUICIO>SYSDATE \n" +
"AND FECHA_AUDIENCIA_JUICIO <> '09/09/1899')\n" +
"and  ((substr(clave_organo,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (clave_organo='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_AUDIENCIA_JUICIO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}*/

/*public ArrayList FECHA_DICTO_RESOLUCION_AD_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT clave_organo, expediente_clave, periodo, TO_CHAR(FECHA_DICTO_RESOLUCION_AD,'DD/MM/YYYY')FECHA_DICTO_RESOLUCION_AD,\n" +
"TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM V3_TR_COLECTIVOJL \n" +
"WHERE \n" +
"(FECHA_DICTO_RESOLUCION_AD>SYSDATE \n" +
"AND FECHA_DICTO_RESOLUCION_AD <> '09/09/1899')\n" +
"and  ((substr(clave_organo,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (clave_organo='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
                  resul.getString("periodo"),
                  resul.getString("FECHA_DICTO_RESOLUCION_AD")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}*/

public ArrayList FECHA_RESOLUCION_AJ_FUT(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS,periodo,to_char(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')FECHA_DICTO_SOLUCION\n" +
"FROM TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"ID_ESTATUS_EXPED=1\n" +
"AND ID_FASE_SOL_EXPED=2\n" +
"AND (FECHA_DICTO_SOLUCION > SYSDATE OR FECHA_DICTO_SOLUCION='09/09/1899')\n" +
"AND ((ID_ORGANOJ='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"')OR (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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


/*public ArrayList Duplicidad_expediente(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,TO_CHAR(FECHA_APERTURA_EXPEDIENTE,'DD/MM/YYYY')FECHA_APERTURA_EXPEDIENTE,TO_NUMBER(regexp_replace(expediente_clave, '[^0-9]', ''))expediente_clave2,PERIODO FROM V3_TR_COLECTIVOJL\n" +
"WHERE CLAVE_ORGANO||TO_NUMBER(regexp_replace(expediente_clave, '[^0-9]', ''))||PERIODO\n" +
"IN(\n" +
"SELECT CLAVE_ORGANO||EXPEDIENTE_CLAVE2||PERIODO FROM(\n" +
"SELECT CLAVE_ORGANO,COUNT(expediente_clave2)CUENTAexpediente_clave2,expediente_clave2,PERIODO FROM(\n" +
"select CLAVE_ORGANO,expediente_clave,TO_NUMBER(regexp_replace(expediente_clave, '[^0-9]', ''))expediente_clave2,PERIODO from V3_TR_COLECTIVOJL \n" +
"WHERE (SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"') or (CLAVE_ORGANO='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"')  \n" +
"ORDER BY CLAVE_ORGANO,expediente_clave2)\n" +
"GROUP BY CLAVE_ORGANO,expediente_clave2,PERIODO)WHERE CUENTAexpediente_clave2>1)\n" +
"ORDER BY CLAVE_ORGANO,expediente_clave2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("FECHA_APERTURA_EXPED")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }*/
     

 public ArrayList Fecha_PresentacionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_PRESENT_DEMANDA <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
   public ArrayList Fecha_PresentacionAdmiNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_ADM_DEMANDA,'dd/mm/yyyy')FECHA_ADM_DEMANDA,to_char(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')FECHA_PRESENT_DEMANDA,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_PRESENT_DEMANDA <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_PRESENT_DEMANDA <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
 


//Query de validacion donde la fecha de admisionde la demanda no debe de ser menor a la fecha de apertura del expediente
    public ArrayList Fecha_Admi_DemandaNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_ADM_DEMANDA,'dd/mm/yyyy')FECHA_ADM_DEMANDA,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
                  resul.getString("FECHA_APERTURA_EXPED"),
                  resul.getString("FECHA_ADM_DEMANDA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
      //Query de validacion donde la Fecha de audiencia de juicio no debe de ser menor o igual a la fecha de apertura del expediente
    public ArrayList Fecha_Audiencia_JuicioNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_AUD_JUICIO,'dd/mm/yyyy')FECHA_AUD_JUICIO,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"to_date(FECHA_AUD_JUICIO,'dd/mm/yyyy') <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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

       //Query de validacion donde la Fecha de auto de depuración no debe de ser menor o igual a la fecha de apertura del expediente.
        public ArrayList Fecha_DepuracionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_AUTO_DEPURACION,'dd/mm/yyyy')FECHA_AUTO_DEPURACION,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"    to_date(FECHA_AUTO_DEPURACION,'dd/mm/yyyy') <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
        //Query de validacion donde la Fecha del último acto procesal no debe de ser menor a la fecha de apertura del expediente.
        public ArrayList Fecha_Acto_ProcesalNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_ULT_ACT_PROC,'dd/mm/yyyy')FECHA_ULT_ACT_PROC,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"    to_date(FECHA_ULT_ACT_PROC,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
                        
       //Query de validacion donde la Fecha en la que se dictó la resolución (audiencia de juicio) no debe de ser menor a la fecha de apertura del expediente.
                public ArrayList Fecha_Resolucion_AjNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')FECHA_DICTO_SOLUCION,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
" ID_FASE_SOL_EXPED=2 AND\n" +
"    to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
                
 //Query de validacion donde la Fecha en la que se dictó la resolución (auto depuracion) no debe de ser menor a la fecha de apertura del expediente.
          public ArrayList Fecha_Dicto_Resolucion_ADNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (select SUBSTR(ID_ORGANOJ,0,2)ENTIDAD_CLAVE,ID_ORGANOJ,CLAVE_EXPEDIENTE,to_char(FECHA_DICTO_SOLUCION,'dd/mm/yyyy')FECHA_DICTO_SOLUCION,to_char(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,PERIODO\n" +
"from TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
" ID_FASE_SOL_EXPED=3 AND\n" +
"    to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')) where  periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899'  and ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_APERTURA_EXPED <> '09/09/1899' and periodo = '"+PValidacion.periodo+"'";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("entidad_clave"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("clave_expediente"),
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
  public ArrayList Fecha_Aud_Presentacion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (SELECT SUBSTR(S.ID_ORGANOJ,0,2),P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')\n" +
"FECHA_CELEBRACION,to_char(S.FECHA_PRESENT_DEMANDA,'DD/MM/YYYY') FECHA_PRESENT_DEMANDA, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA\n" +
"FROM TR_AUDIENCIA P,TR_EXPEDIENTE S\n" +
"WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"    AND S.ID_TIPO_EXPEDIENTE=3 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy') \n" +
"                )where periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_PRESENT_DEMANDA <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_PRESENT_DEMANDA <> '09/09/1899' \n" +
"          and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENTIDAD_CLAVE"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
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
  

  
  public ArrayList Fecha_Aud_Apertura(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (SELECT SUBSTR(S.ID_ORGANOJ,0,2),P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')\n" +
"FECHA_CELEBRACION,to_char(S.FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA\n" +
"FROM TR_AUDIENCIA P,TR_EXPEDIENTE S\n" +
"WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"    AND S.ID_TIPO_EXPEDIENTE=3 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') \n" +
"                )where periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_APERTURA_EXPED <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_APERTURA_EXPED <> '09/09/1899' \n" +
"          and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENTIDAD_CLAVE"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
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
  public ArrayList Fecha_Aud_Admision(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (SELECT SUBSTR(S.ID_ORGANOJ,0,2),P.ID_ORGANOJ,S.CLAVE_EXPEDIENTE,to_char(P.FECHA_CELEBRACION,'DD/MM/YYYY')\n" +
"FECHA_CELEBRACION,to_char(S.FECHA_ADM_DEMANDA,'DD/MM/YYYY') FECHA_ADM_DEMANDA, S.ID_TIPO_EXPEDIENTE,P.PERIODO,P.ID_AUDIENCIA\n" +
"FROM TR_AUDIENCIA P,TR_EXPEDIENTE S\n" +
"WHERE P.ID_ORGANOJ=S.ID_ORGANOJ AND P.ID_EXPEDIENTE=S.ID_EXPEDIENTE AND P.PERIODO=S.PERIODO\n" +
"    AND S.ID_TIPO_EXPEDIENTE=3 AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_ADM_DEMANDA,'dd/mm/yyyy') \n" +
"                )where periodo = '"+PValidacion.periodo+"'\n" +
"          and FECHA_CELEBRACION <> '09/09/1899'  and FECHA_ADM_DEMANDA <> '09/09/1899' and  ID_ORGANOJ='"+PValidacion.clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' \n" +
"          and FECHA_CELEBRACION <> '09/09/1899' and  FECHA_ADM_DEMANDA <> '09/09/1899' \n" +
"          and periodo = '"+PValidacion.periodo+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
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