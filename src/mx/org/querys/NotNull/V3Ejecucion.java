/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.querys.NotNull;

import Conexion.OracleConexion;
import Screen_laborales.PValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANTONIO.CORIA
 */
public class V3Ejecucion {
   OracleConexion conexion = new OracleConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;



//Estatus del expediente no debe de ser 9=No_identificado.
public ArrayList Estatus_expedienteNi(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select CLAVE_ORGANO,EXPEDIENTE_CLAVE,DECODE(ESTATUS_EXPE,'9','No_identificado') ESTATUS_EXPE,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from V3_TR_EJECUCIONJL\n" +
"WHERE (ESTATUS_EXPE =9 AND (SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"'))"; 
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("ESTATUS_EXPE"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



public ArrayList FaseConclucion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="select * from ( \n"+
"select * from(\n"+
"SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,ESTATUS_EXPE,PERIODO FROM V3_TR_EJECUCIONJL WHERE \n" +
"FECHA_CONCLUSION IS NOT NULL OR FASE_CONCLUSION IS NOT NULL )  \n" +
" where  SUBSTR(CLAVE_ORGANO,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or clave_organo='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')where ESTATUS_EXPE=2"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("EXPEDIENTE_CLAVE"),
                  resul.getString("ESTATUS_EXPE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
}
