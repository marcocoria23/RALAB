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
import Screen_laborales.PValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EDEjecucion {
   OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql;
ArrayList<String[]> Array;
ResultSet resul;



//Estatus del expediente no debe de ser 9=No_identificado.
public ArrayList Estatus_expedienteNi(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select 	\n" +
"	    ID_EXPEDIENTE, 	\n" +
"	    ID_ORGANOJ,	\n" +
"	    CLAVE_EXPEDIENTE,	\n" +
"	    DECODE(ID_ESTATUS_EXPED,'-1','No_identificado') ID_ESTATUS_EXPED,	\n" +
"	    REPLACE(COMENTARIOS,',','')COMENTARIOS,	\n" +
"	    PERIODO 	\n" +
"	from TR_EXPEDIENTE 	\n" +
"	WHERE (ID_ESTATUS_EXPED ='-1' AND ((SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9')  	\n" +
"	 or (ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"' AND ID_TIPO_EXPEDIENTE = '9')))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_ESTATUS_EXPED"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList FaseConclucion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from ( 	\n" +
"	select * from(	\n" +
"	SELECT ID_EXPEDIENTE, ID_ORGANOJ,CLAVE_EXPEDIENTE,ID_ESTATUS_EXPED,FECHA_CONCL_EJECU, ID_FASE_CONCL_EJEC, PERIODO FROM TR_EXPEDIENTE WHERE  	\n" +
"	FECHA_CONCL_EJECU IS NOT NULL OR ID_FASE_CONCL_EJEC IS NOT NULL AND ID_TIPO_EXPEDIENTE = '9')   	\n" +
"	 where  SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"'	\n" +
"	 or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')where ID_ESTATUS_EXPED=2"; 
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
            Logger.getLogger(EDEjecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
}