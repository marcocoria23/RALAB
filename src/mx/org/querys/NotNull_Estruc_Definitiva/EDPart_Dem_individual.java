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
 * @author ANDREA.HERNANDEZL
 */
public class EDPart_Dem_individual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;
// YA QUEDO
///Demandado no debe de ser 9=No identificado

    public ArrayList DemandadoNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, R.CLAVE_EXPEDIENTE,R.ID_EXPEDIENTE, P.PERIODO, P.ID_DEMANDADO, R.ID_TIPO_EXPEDIENTE, P.ID_TIPO_DEMANDADO\n"
                + "FROM TR_DEMANDADO P\n"
                + "LEFT JOIN TR_EXP_DEMANDADO Q\n"
                + "  ON P.ID_DEMANDADO = Q.ID_DEMANDADO AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_EXPEDIENTE R\n"
                + "  ON Q.ID_EXPEDIENTE = R.ID_EXPEDIENTE AND Q.ID_ORGANOJ = R.ID_ORGANOJ AND Q.PERIODO = R.PERIODO\n"
                + "WHERE (P.ID_TIPO_DEMANDADO = '-1' OR P.ID_TIPO_DEMANDADO IS NULL)\n"
                + "AND R.ID_TIPO_EXPEDIENTE = 2)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
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
// YA QUEDO
///Cuando Demandado=otro no debe de capturar desde tipo hasta longitud

    public ArrayList Demandado_otro() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT 	 \n" +
"	    subquery.ID_EXPEDIENTE,	 \n" +
"	    exp.CLAVE_EXPEDIENTE,	 \n" +
"	    subquery.ID_DEMANDADO,	 \n" +
"	    subquery.ID_ORGANOJ,	 \n" +
"	    subquery.ID_TIPO_DEMANDADO,	 \n" +
"	    subquery.PERIODO	 \n" +
"	 FROM (	 \n" +
"	    SELECT 	 \n" +
"	        expd.ID_EXPEDIENTE ID_EXPEDIENTE, 	 \n" +
"	        dem.ID_DEMANDADO ID_DEMANDADO, 	 \n" +
"	        dem.ID_ORGANOJ ID_ORGANOJ, 	 \n" +
"	        DECODE(dem.ID_TIPO_DEMANDADO, '5', 'Otro') AS ID_TIPO_DEMANDADO, 	 \n" +
"	        dem.PERIODO PERIODO 	 \n" +
"	    FROM TR_DEMANDADO dem 	 \n" +
"	    JOIN TR_EXP_DEMANDADO expd 	 \n" +
"	        ON dem.ID_ORGANOJ = expd.ID_ORGANOJ 	 \n" +
"	        AND dem.PERIODO = expd.PERIODO 	 \n" +
"	        AND dem.ID_DEMANDADO = expd.ID_DEMANDADO 	 \n" +
"	    WHERE dem.ID_TIPO_DEMANDADO IN (5) AND (	 \n" +
"	        dem.ID_TIPO_PATRON IS NOT NULL OR dem.RFC IS NOT NULL OR dem.RAZON_SOCIAL IS NOT NULL OR 	 \n" +
"	        dem.CALLE IS NOT NULL OR dem.NUM_EXTERIOR IS NOT NULL OR dem.NUM_INTERIOR IS NOT NULL OR  	 \n" +
"	        dem.COLONIA IS NOT NULL OR dem.CP IS NOT NULL OR dem.ID_ENT_MPIO IS NOT NULL OR dem.LATITUD 	 \n" +
"	        IS NOT NULL OR dem.LONGITUD 	 \n" +
"	IS NOT NULL 	 \n" +
"	    ) 	 \n" +
"	    AND (	 \n" +
"	        (SUBSTR(dem.ID_ORGANOJ, 0, 2) = '\" + PValidacion.clave_entidad + \"' AND dem.PERIODO = '\" + PValidacion.periodo + \"')  	 \n" +
"	        OR (dem.ID_ORGANOJ = '\" + PValidacion.clave_organo + \"' AND dem.PERIODO = '\" + PValidacion.periodo + \"')	 \n" +
"	    )  	 \n" +
"	) subquery 	 \n" +
"	JOIN TR_EXPEDIENTE exp 	 \n" +
"	    ON subquery.ID_EXPEDIENTE = exp.ID_EXPEDIENTE 	 \n" +
"	WHERE exp.ID_TIPO_EXPEDIENTE = '2'";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_DEMANDADO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
// YA QUEDO
///Cuando Tipo= persona_Fisica no debe de capturar desde  razón social de la empresa o establecimiento  hasta longitud

    public ArrayList Tipo_persona() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, R.CLAVE_EXPEDIENTE, R.ID_EXPEDIENTE, P.PERIODO, P.ID_DEMANDADO, R.ID_TIPO_EXPEDIENTE, P.ID_TIPO_DEMANDADO, ID_TIPO_PATRON\n"
                + "FROM TR_DEMANDADO P\n"
                + "LEFT JOIN TR_EXP_DEMANDADO Q\n"
                + "  ON P.ID_DEMANDADO = Q.ID_DEMANDADO AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_EXPEDIENTE R\n"
                + "  ON Q.ID_EXPEDIENTE = R.ID_EXPEDIENTE AND Q.ID_ORGANOJ = R.ID_ORGANOJ AND Q.PERIODO = R.PERIODO\n"
                + "WHERE P.ID_TIPO_DEMANDADO IN (1,'-1')\n"
                + "AND P.ID_TIPO_PATRON = 1\n"
                + "AND (\n"
                + "P.RAZON_SOCIAL IS NOT NULL\n"
                + "OR P.CALLE IS NOT NULL\n"
                + "OR P.NUM_EXTERIOR IS NOT NULL\n"
                + "OR P.NUM_INTERIOR IS NOT NULL\n"
                + "OR P.COLONIA IS NOT NULL\n"
                + "OR P.CP IS NOT NULL\n"
                + "OR P.ID_ENT_MPIO IS NOT NULL\n"
                + "OR P.LATITUD IS NOT NULL\n"
                + "OR P.LONGITUD IS NOT NULL)\n"
                + "AND R.ID_TIPO_EXPEDIENTE = 2)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_PATRON")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V3Ordinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
