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
public class EDV3Part_Act_colectivo {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql;
ArrayList<String[]> Array;
ResultSet resul;


///Actor no debe ser No identificado
public ArrayList ActorNI(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM ( \n"
              + "SELECT P.ID_ORGANOJ,P.CLAVE_EXPEDIENTE,DECODE(P1.ID_TIPO_ACTOR,'-1','No identificado')ID_TIPO_ACTOR,P.PERIODO\n"
              + "FROM TR_EXPEDIENTE P, TR_ACTOR P1,TR_EXP_ACTOR P2\n"
              + "WHERE  P.ID_ORGANOJ=P2.ID_ORGANOJ\n"
              + "AND P.PERIODO=P2.PERIODO\n"
              + "AND P.ID_EXPEDIENTE=P2.ID_EXPEDIENTE\n"
              + "AND P1.ID_ORGANOJ=P2.ID_ORGANOJ\n"
              + "AND P1.PERIODO=P2.PERIODO\n"
              + "AND P1.ID_ACTOR=P2.ACTORES_ID\n"
              + "AND P.ID_TIPO_EXPEDIENTE=3\n"
              + "AND P1.ID_TIPO_ACTOR='-1') WHERE  ((substr(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'  and periodo='" + PValidacion.periodo + "' ) or  (ID_ORGANOJ='" + PValidacion.clave_organo + "'  and periodo='" + PValidacion.periodo + "' ))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//CUANDO ACTOR = Sindicato  no debe capturar desde Tipo hasta Longitud
public ArrayList Actor_Sindicato(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM( \n"
              + "SELECT P.ID_ORGANOJ,P.CLAVE_EXPEDIENTE,DECODE(P1.ID_TIPO_ACTOR,'3','Sindicato')ID_TIPO_ACTOR,P.PERIODO\n" +
"FROM TR_EXPEDIENTE P, TR_ACTOR P1,TR_EXP_ACTOR P2\n" +
"WHERE  P.ID_ORGANOJ=P2.ID_ORGANOJ\n" +
"AND P.PERIODO=P2.PERIODO\n" +
"AND P.ID_EXPEDIENTE=P2.ID_EXPEDIENTE\n" +
"AND P1.ID_ORGANOJ=P2.ID_ORGANOJ\n" +
"AND P1.PERIODO=P2.PERIODO\n" +
"AND P1.ID_ACTOR=P2.ACTORES_ID\n" +
"AND P.ID_TIPO_EXPEDIENTE=3\n" +
"AND P1.ID_TIPO_ACTOR='3'\n" +
"AND (ID_TIPO_PATRON IS NOT NULL OR RFC IS NOT NULL OR RAZON_SOCIAL IS NOT NULL OR CALLE IS NOT NULL OR\n" +
"NUM_EXTERIOR IS NOT NULL OR NUM_INTERIOR IS NOT NULL OR COLONIA IS NOT NULL OR CP IS NOT NULL OR\n" +
"P1.ID_ENT_MPIO IS NOT NULL OR \n" +
"LATITUD IS NOT NULL OR LONGITUD IS NOT NULL)) WHERE  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))"; 
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
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//CUANDO ACTOR = Patron no debe de capturar desde Nombre del sindicato hasta No_identificado.
public ArrayList Actor_Patron(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM ("
              + "SELECT AC.ID_ORGANOJ,EXP.CLAVE_EXPEDIENTE,DECODE(ID_TIPO_ACTOR,'2','Patron') ID_TIPO_ACTOR,AC.PERIODO \n" +
"FROM TR_ACTOR AC INNER JOIN \n" +
"TR_EXP_ACTOR EXPACTOR\n" +
"ON AC.ID_ACTOR=EXPACTOR.ACTORES_ID\n" +
"INNER JOIN TR_EXPEDIENTE EXP\n" +
"ON EXPACTOR.ID_EXPEDIENTE=EXP.ID_EXPEDIENTE\n" +
"WHERE   EXP.ID_TIPO_EXPEDIENTE=3 AND (AC.ID_TIPO_ACTOR IN (2)  AND (AC.NOMBRE_SINDICATO IS NOT NULL OR  AC.REGISTRO_ASO_SINDICAL IS NOT NULL OR AC.ID_TIPO_SINDICATO IS NOT NULL OR\n" +
"AC.PREG_SIND_PERT_ORG_O IS NOT NULL OR AC.ID_ORG_OBR IS NOT NULL  OR \n" +
"AC.CANT_TRAB_INVOL_H IS NOT NULL OR AC.CANT_TRAB_INVOL_M IS NOT NULL OR AC.CANT_TRAB_INVOL_NI IS NOT NULL) AND (SUBSTR(AC.ID_ORGANOJ,0,2)='+PValidacion.clave_entidad+' and AC.periodo = '+PValidacion.periodo+' \n" +
" or AC.ID_ORGANOJ='+PValidacion.ID_ORGANOJ+' and AC.periodo = '+PValidacion.periodo+'))) WHERE  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("ID_TIPO_ACTOR")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//CUANDO Tipo= persona_Fisica  no debe de capturar desde Razon social hasta Longitud.
public ArrayList Persona_Fisica(){
      conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM ("
              + "SELECT AC.ID_ORGANOJ,EXP.CLAVE_EXPEDIENTE,DECODE(ID_TIPO_ACTOR,'2','Patron') ID_TIPO_ACTOR,AC.PERIODO \n" +
"FROM TR_ACTOR AC INNER JOIN \n" +
"TR_EXP_ACTOR EXPACTOR\n" +
"ON AC.ID_ACTOR=EXPACTOR.ACTORES_ID\n" +
"INNER JOIN TR_EXPEDIENTE EXP\n" +
"ON EXPACTOR.ID_EXPEDIENTE=EXP.ID_EXPEDIENTE\n" +
"WHERE EXP.ID_TIPO_EXPEDIENTE=3 AND (AC.ID_TIPO_ACTOR IN (2) and (AC.ID_TIPO_PATRON IN (1)) AND (RAZON_SOCIAL IS NOT NULL OR CALLE IS NOT NULL OR\n" +
"NUM_EXTERIOR IS NOT NULL OR NUM_INTERIOR IS NOT NULL OR COLONIA IS NOT NULL OR CP IS NOT NULL OR   \n" +
"LATITUD IS NOT NULL OR LONGITUD IS NOT NULL) AND (SUBSTR(AC.ID_ORGANOJ,0,2)='+PValidacion.clave_entidad+' and AC.periodo = '+PValidacion.periodo+' \n" +
" or AC.ID_ORGANOJ='+PValidacion.ID_ORGANOJ+' and AC.periodo = '+PValidacion.periodo+'))) WHERE  ((substr(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'  and periodo='"+PValidacion.periodo+"' ) or  (ID_ORGANOJ='"+PValidacion.clave_organo+"'  and periodo='"+PValidacion.periodo+"' ))"; 
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("TIPO"),
                  resul.getString("ID_TIPO_ACTOR")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    



    
}