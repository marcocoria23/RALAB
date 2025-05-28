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

/**
 *
 * @author JOSE.CABRERA
 */
public class EDPart_Dem_ordinario {
     OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;





///Demandado no debe de ser 9=No identificado
public ArrayList DemandadoNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_DEMANDADO,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_DEMANDADO,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expd.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        dem.ID_DEMANDADO ID_DEMANDADO, 	\n" +
"	        dem.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(dem.ID_TIPO_DEMANDADO, -1, 'No identificado') AS ID_TIPO_DEMANDADO, 	\n" +
"	        dem.PERIODO PERIODO 	\n" +
"	    FROM TR_DEMANDADO dem 	\n" +
"	    JOIN TR_EXP_DEMANDADO expd 	\n" +
"	        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ 	\n" +
"	        AND dem.PERIODO = expd.PERIODO 	\n" +
"	        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO	\n" +
"	    WHERE dem.ID_TIPO_DEMANDADO IN (-1) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')	\n" +
"	    )  	\n" +
"	) subquery 	\n" +
"	JOIN TR_EXPEDIENTE exp 	\n" +
"	    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE 	\n" +
"	WHERE exp.ID_TIPO_EXPEDIENTE = '1'"; 
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
            Logger.getLogger(EDPart_Dem_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



///Cuando Demandado=otro no debe de capturar desde tipo hasta longitud
public ArrayList Demandado_Otro(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_DEMANDADO,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_DEMANDADO,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expd.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        dem.ID_DEMANDADO ID_DEMANDADO, 	\n" +
"	        dem.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(dem.ID_TIPO_DEMANDADO, '5', 'Otro') AS ID_TIPO_DEMANDADO, 	\n" +
"	        dem.PERIODO PERIODO 	\n" +
"	    FROM TR_DEMANDADO dem 	\n" +
"	    JOIN TR_EXP_DEMANDADO expd 	\n" +
"	        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ 	\n" +
"	        AND dem.PERIODO = expd.PERIODO 	\n" +
"	        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO 	\n" +
"	    WHERE dem.ID_TIPO_DEMANDADO IN (5) AND (	\n" +
"	        dem.ID_TIPO_PATRON IS NOT NULL OR dem.RFC IS NOT NULL OR dem.RAZON_SOCIAL IS NOT NULL OR 	\n" +
"	        dem.CALLE IS NOT NULL OR dem.NUM_EXTERIOR IS NOT NULL OR dem.NUM_INTERIOR IS NOT NULL OR  	\n" +
"	        dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL OR dem.ID_ENT_MPIO IS NOT NULL OR dem.LATITUD 	\n" +
"	        IS NOT NULL OR dem.LONGITUD 	\n" +
"	IS NOT NULL 	\n" +
"	    ) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')	\n" +
"	    )  	\n" +
"	) subquery 	\n" +
"	JOIN TR_EXPEDIENTE exp 	\n" +
"	    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE 	\n" +
"	WHERE exp.ID_TIPO_EXPEDIENTE = '1'"; 
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
            Logger.getLogger(EDPart_Dem_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando Demandado=otro no debe de capturar desde tipo hasta longitud
public ArrayList Tipo_pf(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_DEMANDADO,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_PATRON,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expd.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        dem.ID_DEMANDADO ID_DEMANDADO, 	\n" +
"	        dem.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(dem.ID_TIPO_PATRON, '1', 'Persona Fisica') AS ID_TIPO_PATRON, 	\n" +
"	        dem.PERIODO PERIODO 	\n" +
"	    FROM TR_DEMANDADO dem 	\n" +
"	    JOIN TR_EXP_DEMANDADO expd 	\n" +
"	        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ 	\n" +
"	        AND dem.PERIODO = expd.PERIODO 	\n" +
"	        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO 	\n" +
"	    WHERE dem.ID_TIPO_DEMANDADO IN (1,-1) AND	\n" +
"	        ID_TIPO_PATRON = 1	\n" +
"	        AND (	\n" +
"	            dem.RAZON_SOCIAL IS NOT NULL OR dem.CALLE IS NOT NULL 	\n" +
"	            OR dem.NUM_EXTERIOR IS NOT NULL OR dem.NUM_INTERIOR IS NOT NULL 	\n" +
"	            OR dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL 	\n" +
"	            OR dem.ID_ENT_MPIO IS NOT NULL OR dem.LATITUD 	\n" +
"	            IS NOT NULL OR dem.LONGITUD IS NOT NULL	\n" +
"	            ) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND dem.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (dem.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND dem.PERIODO = '"+PValidacion.periodo+"')	\n" +
"	    )  	\n" +
"	) subquery 	\n" +
"	JOIN TR_EXPEDIENTE exp 	\n" +
"	    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE 	\n" +
"	WHERE exp.ID_TIPO_EXPEDIENTE = '1'"; 
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
            Logger.getLogger(EDPart_Dem_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}