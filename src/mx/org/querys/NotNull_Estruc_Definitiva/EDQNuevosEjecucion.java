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



/**
 *
 * @author JOSE.CABRERA
 */
public class EDQNuevosEjecucion {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql,NMunicipio;
ArrayList<String[]> Array;
ResultSet resul;   


/* NO APLICA 


public ArrayList  OrdinarioEstatusFE(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS \n" +
"FROM V3_TR_ORDINARIOJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=9\n" +
"AND (FECHA_DICTO_RESOLUCIONFE IS NULL OR FECHA_DICTO_RESOLUCIONFE='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
  

public ArrayList  OrdinarioEstatusAP(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT *\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=1\n" +
"AND (FECHA_DICTO_RESOLUCIONAP IS NULL OR FECHA_DICTO_RESOLUCIONAP='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  OrdinarioEstatusAJ(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT *\n" +
"FROM V3_TR_ORDINARIOJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=2\n" +
"AND (FECHA_RESOLUCIONAJ IS NULL OR FECHA_DICTO_RESOLUCIONAP='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  IndividualEstatusAD(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=3\n" +
"AND (FECHA_DICTO_RESOLUCION_AD IS NULL OR FECHA_DICTO_RESOLUCION_AD='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

  public ArrayList  IndividualEstatusTA(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=4\n" +
"AND (FECHA_RESOLUCION_TA IS NULL OR FECHA_RESOLUCION_TA='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList  IndividualEstatusAP(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=1\n" +
"AND (FECHA_DICTO_RESOLUCION_AP IS NULL OR FECHA_DICTO_RESOLUCION_AP='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

 
public ArrayList  IndividualEstatusAJ(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_INDIVIDUALJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=2\n" +
"AND (FECHA_DICTO_RESOLUCION_AJ IS NULL OR FECHA_DICTO_RESOLUCION_AJ='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList  ColectivoEstatusAD(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=3\n" +
"AND (FECHA_DICTO_RESOLUCION_AD IS NULL OR FECHA_DICTO_RESOLUCION_AD='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  ColectivoEstatusAJ(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_COLECTIVOJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=2\n" +
"AND (FECHA_RESOLUCION_AJ IS NULL OR FECHA_RESOLUCION_AJ='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList  HuelgaEstatusEH(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"    FROM V3_TR_HUELGAJL\n" +
"    WHERE ESTATUS_EXPEDIENTE=1\n" +
"    AND FASE_SOLI_EXPEDIENTE=5\n" +
"    AND (FECHA_RESOLU_EMPLAZ IS NULL OR FECHA_RESOLU_EMPLAZ='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  HuelgaEstatusPH(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_HUELGAJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=6\n" +
"AND (FECHA_RESOLU_EMPLAZ IS NULL OR FECHA_RESOLU_EMPLAZ='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  HuelgaEstatusH(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_HUELGAJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=7\n" +
"AND (FECHA_RESOLU_HUELGA IS NULL OR FECHA_RESOLU_HUELGA='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList  Colect_EconomEstatusCE(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_COLECT_ECONOMJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND FASE_SOLI_EXPEDIENTE=8\n" +
"AND (FECHA_RESOLUCION IS NULL OR FECHA_RESOLUCION='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList  ParaprocesalEstatus(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_PARAPROCESALJL\n" +
"WHERE ESTATUS_EXPEDIENTE=1\n" +
"AND (FECHA_CONCLUSION_EXPE IS NULL OR FECHA_CONCLUSION_EXPE='09/09/1899')\n" +
"AND ((CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"')OR (SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

*/

public ArrayList  EjecucionEstatus(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ, 	\n" +
"	    CLAVE_EXPEDIENTE,	\n" +
"	    DECODE(ID_ESTATUS_EXPED, '1', 'Solucionado') ID_ESTATUS_EXPED,	\n" +
"	    FECHA_CONCL_EJECU,	\n" +
"	    COMENTARIOS  	\n" +
"	FROM TR_EXPEDIENTE 	\n" +
"	WHERE ID_ESTATUS_EXPED=1 	\n" +
"	AND (FECHA_CONCL_EJECU IS NULL OR FECHA_CONCL_EJECU='09/09/1899') 	\n" +
"	AND ((ID_ORGANOJ='"+claveorgano+"' AND PERIODO='"+periodo+"' AND ID_TIPO_EXPEDIENTE = 9)	\n" +
"	OR (SUBSTR(ID_ORGANOJ,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' AND ID_TIPO_EXPEDIENTE = 9))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQNuevosEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
