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
public class EDQNuevosColectivoEconomico {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql, NMunicipio;
    ArrayList<String[]> Array;
    ResultSet resul;

    /* No aplica -----------------


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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

     */
    public ArrayList Colect_EconomEstatusCE(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT 	\n"
                + "    ID_EXPEDIENTE, 	\n"
                + "    ID_ORGANOJ, 	\n"
                + "    CLAVE_EXPEDIENTE,	\n"
                + "    DECODE(ID_ESTATUS_EXPED, '1', 'Solucionado') ID_ESTATUS_EXPED,	\n"
                + "    DECODE(ID_FASE_SOL_EXPED, '8', 'Audiencia dentro del procedimiento colectivo de naturaleza económica') ID_FASE_SOL_EXPED,	\n"
                + "    FECHA_DICTO_SOLUCION,	\n"
                + "    COMENTARIOS  	\n"
                + "FROM TR_EXPEDIENTE 	\n"
                + "WHERE ID_ESTATUS_EXPED=1 	\n"
                + "AND ID_FASE_SOL_EXPED=8 	\n"
                + "AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899') 	\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "' AND ID_TIPO_EXPEDIENTE = 5)	\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + entidad + "' AND PERIODO='" + periodo + "' AND ID_TIPO_EXPEDIENTE = 5))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    /*

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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList  EjecucionEstatus(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n" +
"FROM V3_TR_EJECUCIONJL\n" +
"WHERE ESTATUS_EXPE=1\n" +
"AND (FECHA_CONCLUSION IS NULL OR FECHA_CONCLUSION='09/09/1899')\n" +
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     */
    
    //Si en los campos ¿Hubo celebración de audiencia dentro del procedimiento colectivo de naturaleza económica? (PREG_AUDIENCIA_COL_NAT_ECO) se selecciona la opcion Sí, en el campo Estatus de la demanda (ID_ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList Colect_EconomEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_EXPEDIENTE = 5\n"
                + "AND ID_ESTATUS_DEMANDA <> 1\n"
                + "AND PREG_AUDIENCIA_COL_NAT_ECO = 1\n"
                + "AND ((ID_ORGANOJ='" + claveorgano + "' AND PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Si se encuentra registro en los campos Forma de solución (ID_FORMA_SOLUCION), Fecha en la que se dictó la resolución (FECHA_DICTO_SOLUCION), Tipo de sentencia (ID_TIPO_SENTENCIA), Efectos de la sentencia (ID_SENTENCIA_EFECTO) y Efectos de la sentencia (ID_SENTENCIA_EFECTO), el campo Fase en la que se solucionó el expediente (ID_FASE_SOL_EXPED) debe contener la opcion Audiencia dentro del procedimiento colectivo de naturaleza económica.
    public ArrayList Colect_EconomFaseSolExp(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT EXP.ID_ORGANOJ, EXP.CLAVE_EXPEDIENTE, EXP.COMENTARIOS, EXP.ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE EXP\n"
                + "LEFT JOIN TR_EXP_EFECTOS_SENTENCIA ES\n"
                + "  ON EXP.ID_ORGANOJ = ES.ID_ORGANOJ AND EXP.PERIODO = ES.PERIODO\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 5\n"
                + "and ((ID_FASE_SOL_EXPED IN '-1') OR (ID_FASE_SOL_EXPED IS NULL))\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR ID_EFECTO_SENTENCIA IS NOT NULL)\n"
                + "AND ((EXP.ID_ORGANOJ='" + claveorgano + "' AND EXP.PERIODO='" + periodo + "')\n"
                + "OR (SUBSTR(EXP.ID_ORGANOJ,0,2)='" + entidad + "' AND EXP.PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
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
            Logger.getLogger(EDQNuevosColectivoEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
