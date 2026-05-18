/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionDesarrollo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QuerysBdActToV3 {
    OracleConexionDesarrollo conexionDes  = new OracleConexionDesarrollo(); 
    
    ResultSet resul;
    String sql = "";
    ArrayList<ArrayList<String>> arrayList;
    
    
    public ArrayList<ArrayList<String>> DBO_TO_V3_TR_CONTROL_EXPEDIENTEJL(String cveEntidad , String periodo , String cveOrgano ) throws SQLException {
        conexionDes = conexionDes.Conectar();
         arrayList = new ArrayList<>();
       
            String sql = "WITH BASE AS (    \n" +
"    select \n" +
"        GEN.ID_GENERAL,\n" +
"        ORG.NOMBRE_ORGANOJ AS NOMBRE_ORGANO_JURIS,\n" +
"        ORG.ID_ORGANOJ AS CLAVE_ORGANO,\n" +
"        ORG.SEDE_ORGANOJ AS SEDE,\n" +
"        GEN.TOTAL_JUECES AS JUECES_LABORAL_TOTAL,\n" +
"        GEN.SUBTOTAL_JUEZ_H AS JUECES_LABORAL_SUB_HOM,\n" +
"        GEN.SUBTOTAL_JUEZ_M AS JUECES_LABORAL_SUB_MUJ,\n" +
"        GEN.JUEZ_INDIVIDUA_H AS JUECES_LABORAL_INDIV_HOM,\n" +
"        GEN.JUEZ_INDIVIDUAL_M AS JUECES_LABORAL_INDIV_MUJ,\n" +
"        GEN.JUEZ_COLECTIVO_H AS JUECES_LABORAL_COLEC_HOM,\n" +
"        GEN.JUEZ_COLECTIVO_M AS JUECES_LABORAL_COLEC_MUJ,\n" +
"        GEN.JUEZ_MIXTO_H AS JUECES_LABORAL_MIX_HOM,\n" +
"        GEN.JUEZ_MIXTOS_M AS JUECES_LABORAL_MIX_MUJ,\n" +
"        ORG.HR_ATENCION AS HORARIO,\n" +
"        TC_ENT_MPIO.CLAVE_ENTIDAD AS ENTIDAD_CLAVE,\n" +
"        TC_ENT_MPIO.ENTIDAD AS ENTIDAD_NOMBRE,\n" +
"        TC_ENT_MPIO.CLAVE_MUNICIPIO AS MUNICIPIO_CLAVE,\n" +
"        TC_ENT_MPIO.MUNICIPIO AS MUNICIPIO_NOMBRE,\n" +
"        ORG.COLONIA AS COLONIA_NOMBRE,\n" +
"        ORG.LATITUD AS LATITUD_ORG,\n" +
"        ORG.LONGITUD AS LONGITUD_ORG,\n" +
"        ORG.ID_CIRCUNSCRIPCION AS CIRCUNS_ORG_JUR,\n" +
"        ORG.ID_JURISDICCION AS JURISDICCION,\n" +
"        GEN.TOTAL_ORDINARIO AS ORDINARIO,\n" +
"        GEN.TOTAL_INDIVIDUAL AS ESPECIAL_INDIVI,\n" +
"        GEN.TOTAL_COLECTIVO AS ESPECIAL_COLECT,\n" +
"        GEN.TOTAL_HUELGA AS HUELGA,\n" +
"        GEN.TOTAL_COL_NAT_ECON AS COL_NATU_ECONOMICA,\n" +
"        GEN.TOTAL_PARAPROCESAL AS PARAP_VOLUNTARIO,\n" +
"        GEN.TOTAL_TERCERIAS AS TERCERIAS,\n" +
"        GEN.TOTAL_PREF_CRED AS PREF_CREDITO,\n" +
"        GEN.TOTAL_EJECUCION AS EJECUCION,\n" +
"        GEN.PERIODO\n" +
"    FROM TR_GENERAL GEN \n" +
"    INNER JOIN TR_EXPEDIENTE EXP\n" +
"        ON GEN.ID_ORGANOJ = EXP.ID_ORGANOJ\n" +
"        AND GEN.PERIODO = EXP.PERIODO\n" +
"    INNER JOIN TR_ORGANOJ ORG\n" +
"        ON GEN.ID_ORGANOJ = ORG.ID_ORGANOJ\n" +
"        AND GEN.PERIODO = ORG.PERIODO\n" +
"    INNER JOIN TC_ENTIDAD_MPIO TC_ENT_MPIO\n" +
"        ON TC_ENT_MPIO.ID_ENT_MPIO = EXP.ID_ENT_MPIO\n" +
"),\n" +
"ESPECIFIQUE_CIRCUNSTANCIA AS (\n" +
"    SELECT\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO AS ID_ORGANOJ,\n" +
"        PERIODO,\n" +
"        MAX(\n" +
"            CASE \n" +
"                WHEN NEMONICO_CATALOGO = 'TC_CIRCUNSCRIPCION'\n" +
"                 AND ID_OTRO_ESPECIFIQUE = '4'\n" +
"                 AND TRIM(UPPER(PROCEDIMIENTO))='CONTROL'\n" +
"                THEN ESPECIFIQUE\n" +
"            END\n" +
"        ) AS OTRO_ESP_CIRCUNS\n" +
"    FROM TR_ESPECIFIQUE\n" +
"    GROUP BY\n" +
"        CLAVE_EXPEDIENTE,\n" +
"        ORGANO,\n" +
"        PERIODO\n" +
")\n" +
"SELECT \n" +
"    B.ID_GENERAL,\n" +
"    B.NOMBRE_ORGANO_JURIS,\n" +
"    B.CLAVE_ORGANO,\n" +
"    B.SEDE,\n" +
"    B.JUECES_LABORAL_TOTAL,\n" +
"    B.JUECES_LABORAL_SUB_HOM,\n" +
"    B.JUECES_LABORAL_SUB_MUJ,\n" +
"    B.JUECES_LABORAL_INDIV_HOM,\n" +
"    B.JUECES_LABORAL_INDIV_MUJ,\n" +
"    B.JUECES_LABORAL_COLEC_HOM,\n" +
"    B.JUECES_LABORAL_COLEC_MUJ,\n" +
"    B.JUECES_LABORAL_MIX_HOM,\n" +
"    B.JUECES_LABORAL_MIX_MUJ,\n" +
"    B.HORARIO,\n" +
"    B.ENTIDAD_CLAVE,\n" +
"    B.ENTIDAD_NOMBRE,\n" +
"    B.MUNICIPIO_CLAVE,\n" +
"    B.MUNICIPIO_NOMBRE,\n" +
"    B.COLONIA_NOMBRE,\n" +
"    B.LATITUD_ORG,\n" +
"    B.LONGITUD_ORG,\n" +
"    CONVER_V3_GEN_NI_9(B.CIRCUNS_ORG_JUR) AS CIRCUNS_ORG_JUR,\n" +
"    EC.OTRO_ESP_CIRCUNS,\n" +
"    B.JURISDICCION,\n" +
"    B.ORDINARIO,\n" +
"    B.ESPECIAL_INDIVI,\n" +
"    B.ESPECIAL_COLECT,\n" +
"    B.HUELGA,\n" +
"    B.COL_NATU_ECONOMICA,\n" +
"    B.PARAP_VOLUNTARIO,\n" +
"    B.TERCERIAS,\n" +
"    B.PREF_CREDITO,\n" +
"    B.EJECUCION,\n" +
"    B.PERIODO\n" +
"FROM BASE B\n" +
"LEFT JOIN ESPECIFIQUE_CIRCUNSTANCIA EC\n" +
"    ON EC.ID_ORGANOJ = B.CLAVE_ORGANO \n" +
"    AND EC.PERIODO = B.PERIODO\n" +
"WHERE (SUBSTR(B.CLAVE_ORGANO,0,2)='"+cveEntidad+"' AND B.PERIODO='"+periodo+"') OR (B.CLAVE_ORGANO='"+cveOrgano+"' AND B.PERIODO='"+periodo+"')";
            
            try {
            Statement stmt = conexionDes.getConexion().createStatement();
            resul = stmt.executeQuery(sql);
           
                    while (resul.next()) {
                        ArrayList<String> fila = new ArrayList<>();
                        fila.add(resul.getString(1)); // Añadir la primera columna
                        fila.add(resul.getString(2)); // Añadir la segunda columna
                        fila.add(resul.getString(3)); // Añadir la tercera columna
                        fila.add(resul.getString(4)); // Añadir la cuarta columna
                        fila.add(resul.getString(5)); // Añadir la quinta columna
                        fila.add(resul.getString(6)); // Añadir la sexta columna
                        fila.add(resul.getString(7)); // Añadir la séptima columna
                        fila.add(resul.getString(8)); // Añadir la octava columna
                        fila.add(resul.getString(9)); // Añadir la novena columna
                        fila.add(resul.getString(10)); // Añadir la décima columna   
                        fila.add(resul.getString(11)); // Añadir la décima columna   
                        fila.add(resul.getString(12)); // Añadir la décima columna   
                        fila.add(resul.getString(13)); // Añadir la décima columna   
                        fila.add(resul.getString(14)); // Añadir la décima columna   
                        fila.add(resul.getString(15)); // Añadir la décima columna   
                        fila.add(resul.getString(16)); // Añadir la décima columna   
                        fila.add(resul.getString(17)); // Añadir la décima columna   
                        fila.add(resul.getString(18)); // Añadir la décima columna   
                        fila.add(resul.getString(19)); // Añadir la décima columna   
                        fila.add(resul.getString(20)); // Añadir la décima columna   
                        fila.add(resul.getString(21)); // Añadir la décima columna   
                        fila.add(resul.getString(22)); // Añadir la décima columna   
                        fila.add(resul.getString(23)); // Añadir la décima columna   
                        fila.add(resul.getString(24)); // Añadir la décima columna   
                        fila.add(resul.getString(25)); // Añadir la décima columna   
                        fila.add(resul.getString(26)); // Añadir la décima columna   
                        fila.add(resul.getString(27)); // Añadir la décima columna   
                        fila.add(resul.getString(28)); // Añadir la décima columna   
                        fila.add(resul.getString(29)); // Añadir la décima columna   
                        fila.add(resul.getString(30)); // Añadir la décima columna   
                        fila.add(resul.getString(31)); // Añadir la décima columna   
                        fila.add(resul.getString(32)); // Añadir la décima columna   
                        fila.add(resul.getString(33)); // Añadir la décima columna   
                        fila.add(resul.getString(34)); // Añadir la décima columna   
                        arrayList.add(fila); // Agregar la fila a la lista principal
                    }
            } catch (SQLException ex) {
                Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_AUDIENCIAS" + ex);
                throw ex;
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexionDes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
}
