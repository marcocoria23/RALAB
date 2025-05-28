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
public class EDPart_Act_ordinario {
 OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;


///Actor no debe ser No identificado
public ArrayList ActorNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_ACTOR,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_ACTOR,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expa.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        act.ID_ACTOR ID_ACTOR, 	\n" +
"	        act.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(act.ID_TIPO_ACTOR, -1, 'No identificado') AS ID_TIPO_ACTOR, 	\n" +
"	        act.PERIODO PERIODO 	\n" +
"	    FROM TR_ACTOR act 	\n" +
"	    JOIN TR_EXP_ACTOR expa 	\n" +
"	        ON act.ID_ORGANOJ = expa.ID_ORGANOJ 	\n" +
"	        AND act.PERIODO = expa.PERIODO 	\n" +
"	        AND act.ID_ACTOR = expa.ACTORES_ID 	\n" +
"	    WHERE act.ID_TIPO_ACTOR IN (-1) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(act.ID_ORGANOJ, 0, 2) =  '"+PValidacion.clave_entidad+"' AND act.PERIODO = '"+PValidacion.periodo+"'  	\n" +
"	        OR (act.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND act.PERIODO = '"+PValidacion.periodo+"')	\n" +
"	    )  	\n" +
"	)) subquery 	\n" +
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
                  resul.getString("ID_TIPO_ACTOR"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




///CUANDO ACTOR = Trabajador  no debe capturar desde Nombre del sindicato hasta No_identificado.
public ArrayList Actor_Trabajador(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_ACTOR,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_ACTOR,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expa.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        act.ID_ACTOR ID_ACTOR, 	\n" +
"	        act.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(act.ID_TIPO_ACTOR, 1, 'Trabajador') AS ID_TIPO_ACTOR, 	\n" +
"	        act.PERIODO PERIODO 	\n" +
"	    FROM TR_ACTOR act 	\n" +
"	    JOIN TR_EXP_ACTOR expa 	\n" +
"	        ON act.ID_ORGANOJ = expa.ID_ORGANOJ 	\n" +
"	        AND act.PERIODO = expa.PERIODO 	\n" +
"	        AND act.ID_ACTOR = expa.ACTORES_ID 	\n" +
"	    WHERE act.ID_TIPO_ACTOR IN (1) AND (	\n" +
"	        act.NOMBRE_SINDICATO IS NOT NULL OR act.REGISTRO_ASO_SINDICAL IS NOT NULL OR 	\n" +
"	        act.ID_TIPO_SINDICATO IS NOT NULL OR act.PREG_SIND_PERT_ORG_O IS NOT NULL OR 	\n" +
"	        act.ID_ORG_OBR IS NOT NULL  OR act.CANT_TRAB_INVOL_H IS NOT NULL OR  	\n" +
"	        act.CANT_TRAB_INVOL_M IS NOT NULL OR act.CANT_TRAB_INVOL_NI IS NOT NULL 	\n" +
"	    ) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(act.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND act.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (act.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND act.PERIODO = '"+PValidacion.periodo+"')	\n" +
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
                  resul.getString("ID_TIPO_ACTOR"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

///CUANDO ACTOR = Trabajador  no debe capturar desde Nombre del sindicato hasta No_identificado.
public ArrayList Actor_Sindicato(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_ACTOR,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_ACTOR,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expa.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        act.ID_ACTOR ID_ACTOR, 	\n" +
"	        act.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(act.ID_TIPO_ACTOR, 3, 'Sindicato') AS ID_TIPO_ACTOR, 	\n" +
"	        act.PERIODO PERIODO 	\n" +
"	    FROM TR_ACTOR act 	\n" +
"	    JOIN TR_EXP_ACTOR expa 	\n" +
"	        ON act.ID_ORGANOJ = expa.ID_ORGANOJ 	\n" +
"	        AND act.PERIODO = expa.PERIODO 	\n" +
"	        AND act.ID_ACTOR = expa.ACTORES_ID 	\n" +
"	    WHERE act.ID_TIPO_ACTOR IN (3) AND (	\n" +
"	        act.ID_SEXO IS NOT NULL OR act.EDAD IS NOT NULL OR 	\n" +
"	        act.ID_OCUPACION IS NOT NULL OR act.NSS IS NOT NULL OR 	\n" +
"	        act.CURP IS NOT NULL OR RFC IS NOT NULL OR 	\n" +
"	        act.ID_JORNADA IS NOT NULL 	\n" +
"	    ) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(act.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND act.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (act.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND act.PERIODO = '"+PValidacion.periodo+"')	\n" +
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
                  resul.getString("ID_TIPO_ACTOR"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



///CUANDO ACTOR = Trabajador  no debe capturar desde Nombre del sindicato hasta No_identificado.
public ArrayList Actor_Coalicion(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT 	\n" +
"	    subquery.ID_EXPEDIENTE,	\n" +
"	    exp.CLAVE_EXPEDIENTE,	\n" +
"	    subquery.ID_ACTOR,	\n" +
"	    subquery.ID_ORGANOJ,	\n" +
"	    subquery.ID_TIPO_ACTOR,	\n" +
"	    subquery.PERIODO	\n" +
"	 FROM (	\n" +
"	    SELECT 	\n" +
"	        expa.ID_EXPEDIENTE ID_EXPEDIENTE, 	\n" +
"	        act.ID_ACTOR ID_ACTOR, 	\n" +
"	        act.ID_ORGANOJ ID_ORGANOJ, 	\n" +
"	        DECODE(act.ID_TIPO_ACTOR, 4, 'Coalicion_de_trabajadores') AS ID_TIPO_ACTOR, 	\n" +
"	        act.PERIODO PERIODO 	\n" +
"	    FROM TR_ACTOR act 	\n" +
"	    JOIN TR_EXP_ACTOR expa 	\n" +
"	        ON act.ID_ORGANOJ = expa.ID_ORGANOJ 	\n" +
"	        AND act.PERIODO = expa.PERIODO 	\n" +
"	        AND act.ID_ACTOR = expa.ACTORES_ID 	\n" +
"	    WHERE act.ID_TIPO_ACTOR IN (4) AND (	\n" +
"	        act.ID_SEXO IS NOT NULL OR act.EDAD IS NOT NULL OR 	\n" +
"	        act.ID_OCUPACION IS NOT NULL OR act.NSS IS NOT NULL OR 	\n" +
"	        act.CURP IS NOT NULL OR RFC IS NOT NULL OR 	\n" +
"	        act.ID_JORNADA IS NOT NULL 	\n" +
"	    ) 	\n" +
"	    AND (	\n" +
"	        (SUBSTR(act.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' AND act.PERIODO = '"+PValidacion.periodo+"')  	\n" +
"	        OR (act.ID_ORGANOJ = '"+PValidacion.clave_organo+"' AND act.PERIODO = '"+PValidacion.periodo+"')	\n" +
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
                  resul.getString("ID_TIPO_ACTOR"),
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(EDPart_Act_ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}