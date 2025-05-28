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
 * @author ANTONIO.CORIA
 */
public class EDQDesgloses {

OracleConexionDesarrollo conexion = new OracleConexionDesarrollo ();
String sql;
ArrayList<String[]> Array;
ResultSet resul;    

// Diferencia entre el total de expedientes ordinario vs el desglose de expedientes en procedimiento ordinario.
public ArrayList Desglose_OrdinarioNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_ORDINARIO,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN  \n" +
"LEFT JOIN TR_EXPEDIENTE SEC \n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO \n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 1\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_ORDINARIO\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_ORDINARIO"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes individual vs el desglose de expedientes en procedimiento individual.
public ArrayList Desglose_IndividualNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_INDIVIDUAL,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 2\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_INDIVIDUAL\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_INDIVIDUAL"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes colectivo vs el desglose de expedientes en procedimiento colectivo.
public ArrayList Desglose_ColectivoNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_COLECTIVO,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 3\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_COLECTIVO\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_COLECTIVO"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
 
// Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento Huelga.
public ArrayList Desglose_HuelgaNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_HUELGA,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 4\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_HUELGA\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_HUELGA"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento Colectivo econom.
  public ArrayList Desglose_Colec_EconomNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_COL_NAT_ECON,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN  \n" +
"LEFT JOIN TR_EXPEDIENTE SEC \n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO \n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 5\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_COL_NAT_ECON\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_COL_NAT_ECON"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento paraprocesal.
  public ArrayList Desglose_ParaprocesalNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_PARAPROCESAL,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 6\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_PARAPROCESAL\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_PARAPROCESAL"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento tercerias.
  public ArrayList Desglose_TerceriasNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_TERCERIAS,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN  \n" +
"LEFT JOIN TR_EXPEDIENTE SEC \n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO \n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 7\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_TERCERIAS\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_TERCERIAS"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento preferencia credito.
  public ArrayList Desglose_Pref_CreditoNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_PREF_CRED,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN  \n" +
"LEFT JOIN TR_EXPEDIENTE SEC \n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO \n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 8\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ,1,2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_PREF_CRED \n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_PREF_CRED"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento ejecucion.
  public ArrayList Desglose_EjecucionNE(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_EJECUCION,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 9\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodo+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_EJECUCION\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_EJECUCION"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

  
  
  
  public ArrayList Desglose_OrdinarioNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_ORDINARIO,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 1\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_ORDINARIO\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_ORDINARIO"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes individual vs el desglose de expedientes en procedimiento individual.
public ArrayList Desglose_IndividualNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_INDIVIDUAL,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 2\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_INDIVIDUAL\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_INDIVIDUAL"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes colectivo vs el desglose de expedientes en procedimiento colectivo.
public ArrayList Desglose_ColectivoNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_COLECTIVO,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 3\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_COLECTIVO\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_COLECTIVO"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
 
// Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento Huelga.
public ArrayList Desglose_HuelgaNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_HUELGA,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 4\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_HUELGA\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_HUELGA"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento Colectivo econom.
  public ArrayList Desglose_Colec_EconomNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_COL_NAT_ECON,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 5\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_COL_NAT_ECON\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_COL_NAT_ECON"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento paraprocesal.
  public ArrayList Desglose_ParaprocesalNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_PARAPROCESAL,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 6\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_PARAPROCESAL\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_PARAPROCESAL"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento tercerias.
  public ArrayList Desglose_TerceriasNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_TERCERIAS,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 7\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_TERCERIAS\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_TERCERIAS"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento preferencia credito.
  public ArrayList Desglose_Pref_CreditoNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_PREF_CRED,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 8\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_PREF_CRED\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_PREF_CRED"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
  // Diferencia entre el total de expedientes huelga vs el desglose de expedientes en procedimiento ejecucion.
  public ArrayList Desglose_EjecucionNEAnt(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    PRIN.ID_ORGANOJ AS ID_ORGANOJ,\n" +
"    PRIN.TOTAL_EJECUCION,\n" +
"    COUNT(SEC.CLAVE_EXPEDIENTE) AS TOTAL_EXPE\n" +
"FROM TR_GENERAL PRIN \n" +
"LEFT JOIN TR_EXPEDIENTE SEC\n" +
"    ON PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n" +
"    AND PRIN.PERIODO = SEC.PERIODO\n" +
"    AND SEC.ID_TIPO_EXPEDIENTE = 9\n" +
"WHERE \n" +
"    (SUBSTR(PRIN.ID_ORGANOJ, 1, 2) = '"+PValidacion.clave_entidad+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"') \n" +
"    OR (PRIN.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND PRIN.PERIODO = '"+PValidacion.periodoAnt+"')\n" +
"GROUP BY PRIN.ID_ORGANOJ, PRIN.TOTAL_EJECUCION\n" +
"ORDER BY PRIN.ID_ORGANOJ";
      //System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("TOTAL_EJECUCION"),
                  resul.getString("Total_expe")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDQDesgloses.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
