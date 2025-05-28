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
public class EDV3Part_Dem_colectivo {
   
 OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;



///Demandado no debe de ser 9=No identificado
public ArrayList DemandadoNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, -1, 'No identificado') AS ID_TIPO_DEMANDADO, \n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO\n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (-1) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_DEMANDADO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando Demandado=otro no debe de capturar desde Nombre del sindicato hasta longitud
public ArrayList Demandado_Otro(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, '5', 'Otro') AS ID_TIPO_DEMANDADO, \n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO \n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (5) AND (\n" +
"        dem.nombre_sindicato IS NOT NULL OR  dem.REG_ASOC_SINDICATO IS NOT NULL OR dem.ID_TIPO_SINDICATO IS NOT NULL OR \n" +
"        dem.PREG_SIND_PERT_ORG_OBR IS NOT NULL OR dem.ID_ORG_OBR IS NOT NULL OR dem.cant_trab_invol_h IS NOT NULL OR \n" +
"        dem.cant_trab_invol_m IS NOT NULL OR dem.cant_trab_invol_ni IS NOT NULL OR dem.ID_TIPO_PATRON IS NOT NULL OR \n" +
"        dem.RFC IS NOT NULL OR dem.razon_social IS NOT NULL OR dem.CALLE IS NOT NULL OR dem.NUM_EXTERIOR IS NOT NULL OR \n" +
"        dem.NUM_INTERIOR IS NOT NULL OR dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL OR dem.ID_ENT_MPIO IS NOT NULL OR \n" +
"        dem.LATITUD IS NOT NULL OR dem.LONGITUD IS NOT NULL \n" +
"    ) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_DEMANDADO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 



//Cuando Demandado=Sindicato no debe de capturar desde tipo hasta longitud
public ArrayList Demandado_Sindicato(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, '2','Sindicato') AS ID_TIPO_DEMANDADO, \n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO \n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (2) AND (\n" +
"        dem.ID_TIPO_PATRON IS NOT NULL OR dem.RFC IS NOT NULL OR dem.razon_social IS NOT NULL OR  \n" +
"        dem.CALLE IS NOT NULL OR dem.NUM_EXTERIOR IS NOT NULL OR dem.NUM_INTERIOR IS NOT NULL OR \n" +
"        dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL OR dem.ID_ENT_MPIO IS NOT NULL OR dem.LATITUD \n" +
"        IS NOT NULL OR dem.LONGITUD IS NOT NULL \n" +
"    ) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_DEMANDADO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 




//Cuando Demandado=Coalicion_de_trabajadores solo debe  capturar Cantidad de trabajadores involucrados,Hombres,Mujeres,No_identificado			
public ArrayList Demandado_Coalicion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, '3','Coalicion_de_trabajadores') AS ID_TIPO_DEMANDADO, \n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO \n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (3) AND (\n" +
"        dem.nombre_sindicato IS NOT NULL OR  dem.REG_ASOC_SINDICATO IS NOT NULL OR dem.ID_TIPO_SINDICATO IS NOT NULL OR \n" +
"        dem.PREG_SIND_PERT_ORG_OBR IS NOT NULL OR dem.ID_ORG_OBR IS NOT NULL OR dem.ID_TIPO_PATRON IS NOT NULL OR \n" +
"        dem.RFC IS NOT NULL OR dem.razon_social IS NOT NULL OR dem.CALLE IS NOT NULL OR dem.NUM_EXTERIOR IS NOT NULL OR \n" +
"        dem.NUM_INTERIOR IS NOT NULL OR dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL OR dem.ID_ENT_MPIO IS NOT NULL OR \n" +
"        dem.LATITUD IS NOT NULL OR dem.LONGITUD IS NOT NULL \n" +
"    ) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_DEMANDADO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 



//Cuando Demandado=Patron no debe de capturar desde Nombre del sindicato hasta No_identificado		
public ArrayList Demandado_Patron(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, '1','Patron') AS ID_TIPO_DEMANDADO, \n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO \n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (1) AND (\n" +
"        dem.nombre_sindicato IS NOT NULL OR  dem.REG_ASOC_SINDICATO IS NOT NULL OR dem.ID_TIPO_SINDICATO IS NOT NULL OR \n" +
"        dem.PREG_SIND_PERT_ORG_OBR IS NOT NULL OR dem.ID_ORG_OBR IS NOT NULL OR dem.cant_trab_invol_h IS NOT NULL OR \n" +
"        dem.cant_trab_invol_m IS NOT NULL OR dem.cant_trab_invol_ni IS NOT NULL\n" +
"    ) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_DEMANDADO"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//Cuando Demandado=Patron y tipo=persona_Fisica no debe de capturar desde Razon social hasta Longitud	
public ArrayList persona_fisica(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT \n" +
"    subquery.ID_EXPEDIENTE,\n" +
"    exp.CLAVE_EXPEDIENTE,\n" +
"    subquery.ID_DEMANDADO,\n" +
"    subquery.ID_ORGANOJ,\n" +
"    subquery.ID_TIPO_DEMANDADO,\n" +
"    subquery.ID_TIPO_PATRON,\n" +
"    subquery.PERIODO\n" +
" FROM (\n" +
"    SELECT \n" +
"        expd.ID_EXPEDIENTE ID_EXPEDIENTE, \n" +
"        dem.ID_DEMANDADO ID_DEMANDADO, \n" +
"        dem.ID_ORGANOJ ID_ORGANOJ, \n" +
"        DECODE(dem.ID_TIPO_DEMANDADO, '1','Patron') AS ID_TIPO_DEMANDADO, \n" +
"        DECODE(dem.ID_TIPO_PATRON, '1','persona_Fisica') AS ID_TIPO_PATRON,\n" +
"        dem.PERIODO PERIODO \n" +
"    FROM TR_DEMANDADO dem \n" +
"    JOIN TR_EXP_DEMANDADO expd \n" +
"        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ \n" +
"        AND dem.PERIODO = expd.PERIODO \n" +
"        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO \n" +
"    WHERE dem.ID_TIPO_DEMANDADO IN (1) AND dem.ID_TIPO_SINDICATO IN (1) AND (\n" +
"        razon_social IS NOT NULL OR CALLE IS NOT NULL OR NUM_EXTERIOR IS NOT NULL OR \n" +
"        NUM_INTERIOR IS NOT NULL OR COLONIA IS NOT NULL OR CP IS NOT NULL OR ID_ENT_MPIO \n" +
"        IS NOT NULL OR LATITUD IS NOT NULL OR LONGITUD IS NOT NULL\n" +
"    ) \n" +
"    AND (\n" +
"        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  \n" +
"        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')\n" +
"    )  \n" +
") subquery \n" +
"JOIN TR_EXPEDIENTE exp \n" +
"    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE \n" +
"WHERE exp.ID_TIPO_EXPEDIENTE = '3'"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_PATRON"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



}
