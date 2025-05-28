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
import mx.org.querys.V1querys;

/**
 *
 * @author ANTONIO.CORIA
 */
public class EDQNuevosColectivo {
OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
String sql,NMunicipio;
ArrayList<String[]> Array;
ResultSet resul;   



public ArrayList  ColectivoEstatusAD(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS\n" +
"FROM TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"ID_ESTATUS_EXPED=1\n" +
"AND ID_FASE_SOL_EXPED=3\n" +
"AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n" +
"AND ((ID_ORGANOJ='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"')OR (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"'))";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ORGANOJ"),
                  resul.getString("CLAVE_EXPEDIENTE"),
                  resul.getString("COMENTARIOS")
                });
          }
     } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


public ArrayList  ColectivoEstatusAJ(String claveorgano,String entidad,String periodo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ORGANOJ,CLAVE_EXPEDIENTE,COMENTARIOS\n" +
"FROM TR_EXPEDIENTE\n" +
"WHERE \n" +
"ID_TIPO_EXPEDIENTE=3 AND\n" +
"ID_ESTATUS_EXPED=1\n" +
"AND ID_FASE_SOL_EXPED=2\n" +
"AND (FECHA_DICTO_SOLUCION IS NULL OR FECHA_DICTO_SOLUCION='09/09/1899')\n" +
"AND ((ID_ORGANOJ='"+PValidacion.clave_organo+"' AND PERIODO='"+PValidacion.periodo+"')OR (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND PERIODO='"+PValidacion.periodo+"'))";
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
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

    
}
