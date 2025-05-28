package LeerQuery;

import Conexion.OracleConexion;
import Screen_laborales.PValidacionProcesar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.querys.federal.FedV1Querys;

/* @author ALEJANDRO.CASTILLO  */

public class QueryRalabProd {
    
    OracleConexion conexion = new OracleConexion();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;   
    
    public ArrayList periodoEntidad(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select unique(PERIODO)PERIODO from V3_TR_CONTROL_EXPEDIENTEJL where  substr(clave_organo,0,2)='"+PValidacionProcesar.clave_entidad+"' order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(FedV1Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
    public ArrayList periodoClaveOrgano(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE PERIODO FROM (  SELECT CASE  \n" +
"                        WHEN LENGTH(CLAVE_ORGANO) < 7  \n" +
"                        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1) \n" +
"                        ELSE CLAVE_ORGANO  \n" +
"                    END AS clave_organo , periodo   from  V3_TR_CONTROL_EXPEDIENTEJL )  WHERE     clave_organo='"+PValidacionProcesar.clave_organo+"' order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(FedV1Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
}
