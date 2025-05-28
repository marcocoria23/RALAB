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

/**
 *
 * @author ANTONIO.CORIA
 */
public class EDControl_expediente {
     OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

///Horario debe de estar completo ejemplo: 08:30 a 16:30
public ArrayList Horario(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="  select  REPLACE(NOMBRE_ORGANOJ,',','')NOMBRE_ORGANOJ,ID_ORGANOJ,HR_ATENCION,PERIODO from TR_ORGANOJ\n" +
"    where (LENGTH(TRIM(REPLACE(HR_ATENCION,' ','')))<6)  AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("HR_ATENCION"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDControl_expediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList SubJuecesHom(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CASE WHEN SUMHOM IS NULL THEN 0 ELSE SUMHOM END SUMHOM,CASE WHEN SUBTOTAL_JUEZ_H IS NULL THEN 0 ELSE SUBTOTAL_JUEZ_H END SUBTOTAL_JUEZ_H,periodo FROM(\n" +
"SELECT  ID_ORGANOJ, (TO_NUMBER(TRIM(JUEZ_MIXTO_H))+TO_NUMBER(TRIM(JUEZ_INDIVIDUA_H))+TO_NUMBER(TRIM(JUEZ_COLECTIVO_H)))  SUMHOM,\n" +
"SUBTOTAL_JUEZ_H,periodo \n" +
"FROM TR_GENERAL)WHERE TO_NUMBER(SUMHOM)<>TO_NUMBER(SUBTOTAL_JUEZ_H)  AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("SUMHOM"),
                  resul.getString("SUBTOTAL_JUEZ_H")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDControl_expediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList SubJuecesMuj(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CASE WHEN SUMHOM IS NULL THEN 0 ELSE SUMHOM END SUMHOM,CASE WHEN SUBTOTAL_JUEZ_M IS NULL THEN 0 ELSE SUBTOTAL_JUEZ_M END SUBTOTAL_JUEZ_M,periodo FROM(\n" +
"SELECT  ID_ORGANOJ, (TO_NUMBER(TRIM(JUEZ_MIXTOS_M))+TO_NUMBER(TRIM(JUEZ_INDIVIDUAL_M))+TO_NUMBER(TRIM(JUEZ_COLECTIVO_M)))  SUMHOM,\n" +
"SUBTOTAL_JUEZ_M,periodo \n" +
"FROM TR_GENERAL)WHERE TO_NUMBER(SUMHOM)<>TO_NUMBER(SUBTOTAL_JUEZ_M)  AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("SUMHOM"),
                  resul.getString("SUBTOTAL_JUEZ_M")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDControl_expediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList TotalJueces(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CASE WHEN SUMHM IS NULL THEN 0 ELSE SUMHM END SUMHM,CASE WHEN TOTAL_JUECES IS NULL THEN 0 ELSE TOTAL_JUECES END TOTAL_JUECES,periodo FROM(\n" +
"SELECT  ID_ORGANOJ, (TO_NUMBER(TRIM(SUBTOTAL_JUEZ_H))+TO_NUMBER(TRIM(SUBTOTAL_JUEZ_M))) SUMHM,\n" +
"TOTAL_JUECES,periodo\n" +
"FROM TR_GENERAL)WHERE TO_NUMBER(SUMHM)<>TO_NUMBER(TOTAL_JUECES)  AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' and periodo = '"+PValidacion.periodo+"' \n" +
" or ID_ORGANOJ='"+PValidacion.clave_organo+"' and periodo = '"+PValidacion.periodo+"')"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("SUMHM"),
                  resul.getString("TOTAL_JUECES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDControl_expediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



}

