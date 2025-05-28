/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

/**
 *
 * @author JOSE.CABRERA
 */

import Conexion.OracleConexionDesarrollo;
import Conexion.OracleConexionNE;
import Screen_laborales.PEstatus;
import Screen_laborales.PValidacion;
import Screen_laborales.Errores_InsertTMP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class EDQueryGenerales {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql,NMunicipio;
ArrayList<String[]> Array;
ResultSet resul;   

 //Query  para el despliegue del periodo unico mandandolo a llamar a la pantalla con nombre PValidacion.
public ArrayList PeriodoNE(String clave_organo,String entidad){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(PERIODO)PERIODO from TR_ORGANOJ where ID_ORGANOJ='"+clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+entidad+"' order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList PeriodoNEstatus(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(PERIODO)PERIODO from TR_ORGANOJ where ID_ORGANOJ='"+PEstatus.Clave_organo+"' or substr(ID_ORGANOJ,0,2)='"+PEstatus.Entidad+"' order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     //Query  para el despliegue de la clave de organo unica estas claves se mandan a llamar a la pantalla con nombre PValidacion.
     public ArrayList Clave_organoNE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(ID_ORGANOJ)ID_ORGANOJ from TR_ORGANOJ order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
 public ArrayList Clave_organoAcumula(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(ID_ORGANOJ)ID_ORGANOJ from TR_ORGANOJ where substr(ID_ORGANOJ,0,2) in ('03','04','07','08','10','27','32') order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }    
     
   public ArrayList Clave_organoNEstatus(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(ID_ORGANOJ)ID_ORGANOJ from TR_ORGANOJ where substr(ID_ORGANOJ,0,2)='"+PEstatus.Entidad+"' order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
      //Query  para el despliegue de la entidad=substr(clave_organo,0,2) mandandolo a llamar a la pantalla con nombre PValidacion. 
   public ArrayList EntidadNE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(substr(ID_ORGANOJ,0,2)) Entidad from TR_ORGANOJ order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("Entidad")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
   
 /* NO APLICA --
 public ArrayList Contacto(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID, ENTIDAD_CLAVE, ENTIDAD_NOMBRE, JEFE_DEPARTAMENTO, ENLACE from CONTACTOS_RALABJL order by 2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID"),
                  resul.getString("ENTIDAD_CLAVE"),
                  resul.getString("ENTIDAD_NOMBRE"),
                  resul.getString("JEFE_DEPARTAMENTO"),
                  resul.getString("ENLACE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
 
*/
 
   /* // ERRORES INSERT A TABLAS TMP CON RESPECTO A CADA TABLA. YA NO APLICA EN ESTRUCTURA DEFINITIVA --
 public ArrayList TErroresInser(String Tabla,String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA ,\n" +
"CLAVE_ORGANO ,CLAVE_EXPEDIENTE ,ID ,replace(EXCEPCION,',','') EXCEPCION,USUARIO ,FECHA_HORA,PERIODO from V3_ERRORES_INSERT_RALABTMP\n" +
"WHERE TABLA='"+Tabla+"' AND SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' OR\n" +
" TABLA='"+Tabla+"' AND CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"'  ORDER BY TABLA,CLAVE_ORGANO,CLAVE_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID"),
                  resul.getString("EXCEPCION"),
                  resul.getString("USUARIO"),
                  resul.getString("FECHA_HORA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
 
*/ 
 /* // REGRESA TODOS LOS ERRORES DE INSERT EN TMP EN ESTE CON RESPECTO A TODAS LAS TABLAS-- NO APLICA EN ESTRUCTURA DEFINITIVA
 public ArrayList TAllErroresInser(String Tabla,String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA ,\n" +
"CLAVE_ORGANO ,CLAVE_EXPEDIENTE ,ID ,replace(EXCEPCION,',','') EXCEPCION,USUARIO ,FECHA_HORA,PERIODO from V3_ERRORES_INSERT_RALABTMP\n" +
"WHERE  SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' OR\n" +
"CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"'  ORDER BY TABLA,CLAVE_ORGANO,CLAVE_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID"),
                  resul.getString("EXCEPCION"),
                  resul.getString("USUARIO"),
                  resul.getString("FECHA_HORA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
*/ 

/* ELIMINA LOS ERRORES DE INSERT EN LAS TABLAS TMP. NO APLICA EN ESTRUCTURA DEFINITIVA --    
 public void EliminaRegERRORES_INSERT_RALAB(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
     
      sql="DELETE FROM V3_ERRORES_INSERT_RALABTMP WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'"
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'";
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
       
}
*/ 
 
 /* ELIMINA REGISTROS DE TABLA TMP. NO APLICA PARA ESTRUCTURA DENINITIVA --
 public void EliminaRegTMPRalab(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
     
   
      sql="DELETE FROM "+Tabla+" WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' ";
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:"+Tabla);
        }
       
}
*/ 
   
  /* TABLAS EN LAS QUE SE PRESENTO ERROR DE INSERT. NO APLICA EN ESTRUCTURA DEFINITIVA --
 public ArrayList TablaErroresInsert(String entidad,String claveorgano,String periodo){
     conexion.Conectar();
      Array = new ArrayList(); 
      sql="SELECT UNIQUE(TABLA) TABLA FROM V3_ERRORES_INSERT_RALABTMP WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
      
}
*/ 
   
/* CANTIDAD DE REGISTROS NO INSERTADOS CON RESPECTO A UNA TABLA TMP. NO APLICA EN ESTRUCTURA DEFINITIVA --
 public String Total_Reg_NI(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_Reg FROM V3_ERRORES_INSERT_RALABTMP WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'"
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_Reg");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;
       
}
*/ 
 
 /* CANTIDAD DE REGISTROS NO INSERTADOS CON RESPECTO A  TAODAS LAS TABLAS TMP. NO APLICA EN ESTRUCTURA DEFINITIVA --
 public String AllTotal_Reg_NI(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_Reg FROM V3_ERRORES_INSERT_RALABTMP WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_Reg");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;
       
}
*/
 
   /* TOTAL DE REGISTROS INSERTADOS -- NO APLICA EN ED. 
 public String Total_Reg_insertados(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_Reg FROM "+Tabla+" WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'  ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_Reg");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALABTMP");
        }
      return TotalReg;
       
} 
 */
   
   /*
    //Query  para el despliegue de la descripcion del municipio.
  public String Nombre_Municipio(){
     conexion.Conectar();
      sql="select Descripcion from tc_municipiojl where municipio_id="+PValidacion.clave_organo.substring(0, 5)+"";
      System.out.println(PValidacion.clave_organo.substring(0, 5));
      resul=conexion.consultar(sql);
      try {
          if (resul.next()) {
              NMunicipio=resul.getString("Descripcion");
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return NMunicipio;
 }
*/
  
  /* NO APLICA EN NUEVA ESTRUCTURA ED 
  public void Limpia_V3_ERRORES_INSERT_RALABTR(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
      sql="DELETE FROM V3_ERRORES_INSERT_RALABTR WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' AND TABLA="+Tabla+" "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' AND TABLA="+Tabla+"  ";
      System.out.println(sql);
     try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:"+Tabla);
        }
}
 */
   /*
  public void Limpia_V3_ERRORES_INSERT_RALAB_INICIO(String entidad,String claveorgano,String periodo){
 conexion.Conectar();
      sql="DELETE FROM V3_ERRORES_INSERT_RALABTR WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'  ";
      System.out.println(sql);
     try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:"+Tabla);
        }
}
  */
  /* NO APLICA EN NUEVA ESTRUCTURA ED. 
  public ArrayList TErroresInserTR(String Tabla,String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA ,\n" +
"CLAVE_ORGANO ,CLAVE_EXPEDIENTE ,ID ,replace(EXCEPCION,',','') EXCEPCION,USUARIO ,FECHA_HORA,PERIODO from V3_ERRORES_INSERT_RALABTR \n" +
"WHERE TABLA='"+Tabla+"' AND SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' OR\n" +
" TABLA='"+Tabla+"' AND CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"'  ORDER BY CLAVE_ORGANO,CLAVE_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID"),
                  resul.getString("EXCEPCION"),
                  resul.getString("USUARIO"),
                  resul.getString("FECHA_HORA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  */
  
  
  
  /* NO APLICA EN NUEVA ESTRUCTURA ED. 
  public ArrayList TErroresInserTRInicio(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA ,\n" +
"CLAVE_ORGANO ,CLAVE_EXPEDIENTE ,ID ,replace(EXCEPCION,',','') EXCEPCION,USUARIO ,FECHA_HORA,PERIODO from V3_ERRORES_INSERT_RALABTR \n" +
"WHERE   SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' OR\n" +
" CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"'  ORDER BY TABLA,CLAVE_ORGANO,CLAVE_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID"),
                  resul.getString("EXCEPCION"),
                  resul.getString("USUARIO"),
                  resul.getString("FECHA_HORA"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  */
   
   /* NO APLICA EN NUEVA ESTRUCTURA ED. 
  public String Total_Reg_insertadosTR(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_Reg FROM "+Tabla+" WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'  ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_Reg");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALABTMP");
        }
      return TotalReg;
       
} 
  */ 
   
   /* NO APLICA EN ESTRUCTURA ED
  public String Total_Reg_NITR(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_Reg FROM V3_ERRORES_INSERT_RALABTR WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'"
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' AND TABLA='"+Tabla+"'";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_Reg");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;
       
} 

*/ 
  
  /* NO APLICA EN NUEVA ESTRUCTURA ED
  public String Total_Reg_TMP(String Tabla,String entidad,String claveorgano,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM " +Tabla.replace("V3_TR", "V3_TMP")+"  WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"'";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegTMP");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
} 
  */
  
  /* NO APLICA EN ESTRUCTURA DEFINITIVA ED
  public String Total_Reg_Acum(String Tabla,String claveorgano,String periodo2,String periodo){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT count(*)Total_RegAcum FROM  "+Tabla+" \n" +
"WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo2+"'\n" +
"AND EXPEDIENTE_CLAVE NOT IN (SELECT EXPEDIENTE_CLAVE FROM "+Tabla+" WHERE CLAVE_ORGANO='"+claveorgano+"'\n" +
" AND PERIODO='"+periodo+"') ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegAcum");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
} 
  
 */
  
   /* NO APLICA EN ESTRUCTURA ED
  public void CleanerBD(String Tabla,String entidad,String claveorgano,String periodo){
   conexion.Conectar();
      sql="DELETE FROM " +Tabla+ " WHERE CLAVE_ORGANO='"+claveorgano+"' AND PERIODO='"+periodo+"' "
              + " OR SUBSTR(CLAVE_ORGANO,0,2)='"+entidad+"' AND PERIODO='"+periodo+"' ";
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
     }
       
}
*/
  
  
  public String Total_Organos(String entidad){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT count(unique(ID_ORGANOJ))Total_organos FROM TR_ORGANOJ\n" +
"WHERE SUBSTR(ID_ORGANOJ,0,2)='"+entidad+"'" ;
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_organos");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQueryGenerales.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
} 
  
}