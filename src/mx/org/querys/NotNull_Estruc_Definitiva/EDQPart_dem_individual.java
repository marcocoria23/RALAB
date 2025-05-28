/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexionDesarrollo;
import Conexion.OracleConexionNE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Screen_laborales.PValidacion;
import mx.org.querys.V1querys;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQPart_dem_individual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

//Query de validacion para saber si Actor y Demandado no se encuntra desagregados.
    public ArrayList ExpeNDesglose() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_INCOMPETENCIA,2,'NO') PREG_INCOMPETENCIA,\n"
                + "  DECODE(ID_ESTATUS_DEMANDA,1,'ADMITIDA') ID_ESTATUS_DEMANDA,\n"
                + "  CANT_ACTORES,\n"
                + "  CANT_DEMANDADOS\n"
                + "FROM (SELECT * FROM (SELECT * FROM TR_EXPEDIENTE\n"
                + "    WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "    AND PERIODO = '" + PValidacion.periodo + "'\n"
                + "    AND PREG_INCOMPETENCIA = 2 AND ID_ESTATUS_DEMANDA = 1\n"
                + "    OR ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "    AND PERIODO = '" + PValidacion.periodo + "'\n"
                + "    AND PREG_INCOMPETENCIA = 2 AND ID_ESTATUS_DEMANDA = 1 )\n"
                + "  WHERE CANT_DEMANDADOS > 0 )\n"
                + "WHERE CLAVE_EXPEDIENTE NOT IN\n"
                + "  (SELECT CLAVE_EXPEDIENTE FROM TR_EXPEDIENTE\n"
                + "  WHERE SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "'\n"
                + "  OR ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "' ) ";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("PREG_INCOMPETENCIA"),
                    resul.getString("ID_ESTATUS_DEMANDA"),
                    resul.getString("CANT_ACTORES"),
                    resul.getString("CANT_DEMANDADOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Query de validacion para saber si Cuando el expediente es incompetencia = SI, Cantidad de Actores y Cantidad de demandados es No aplica por ende no se debe de desglosar actores ni demandados.
    public ArrayList IncompetenciaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (  	\n" +
"	    SELECT 	\n" +
"	        SEC.ID_EXPEDIENTE,	\n" +
"	        PRIN.ID_ORGANOJ,	\n" +
"	        PRIN.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_PART,	\n" +
"	        SEC.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_INDIVIDUAL,	\n" +
"	        DECODE(SEC.PREG_INCOMPETENCIA, '1', 'Sí', '2', 'NO') PREG_INCOMPETENCIA 	\n" +
"	    FROM ( 	\n" +
"	        SELECT  	\n" +
"	            UNIQUE(EXP.CLAVE_EXPEDIENTE) CLAVE_EXPEDIENTE,	\n" +
"	            EXP.ID_TIPO_EXPEDIENTE,	\n" +
"	            A.ID_ORGANOJ,	\n" +
"	            A.PERIODO	\n" +
"	        FROM TR_DEMANDADO A	\n" +
"	        JOIN TR_EXP_DEMANDADO EA ON A.ID_DEMANDADO = EA.ID_DEMANDADO 	\n" +
"	                             AND A.ID_ORGANOJ = EA.ID_ORGANOJ 	\n" +
"	                             AND A.PERIODO = EA.PERIODO	\n" +
"	        JOIN TR_EXPEDIENTE EXP ON EA.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE 	\n" +
"	                               AND EA.ID_ORGANOJ = EXP.ID_ORGANOJ	\n" +
"	                               AND EA.PERIODO = EXP.PERIODO	\n" +
"	        WHERE 	\n" +
"	            (SUBSTR(A.ID_ORGANOJ, 0, 2) = '"+PValidacion.clave_entidad+"' 	\n" +
"	             AND A.PERIODO = '"+PValidacion.periodo+"' 	\n" +
"	             AND EXP.ID_TIPO_EXPEDIENTE = '2')	\n" +
"	        OR 	\n" +
"	            (A.ID_ORGANOJ = '"+PValidacion.clave_organo+"' 	\n" +
"	             AND A.PERIODO = '"+PValidacion.periodo+"' 	\n" +
"	             AND EXP.ID_TIPO_EXPEDIENTE = '2')	\n" +
"	    ) PRIN 	\n" +
"	    LEFT JOIN TR_EXPEDIENTE SEC  	\n" +
"	    ON PRIN.ID_TIPO_EXPEDIENTE = SEC.ID_TIPO_EXPEDIENTE 	\n" +
"	    AND PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ  	\n" +
"	    AND PRIN.CLAVE_EXPEDIENTE = SEC.CLAVE_EXPEDIENTE  	\n" +
"	    AND PRIN.PERIODO = SEC.PERIODO  	\n" +
"	) 	\n" +
"	WHERE PREG_INCOMPETENCIA = 'Sí'";
        resul = conexion.consultar(sql);
        //System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE_INDIVIDUAL"),
                    resul.getString("PREG_INCOMPETENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion para saber si  el estatus de la demanda=DESECHADA,ARCHIVO,NO SE DIO TRAMITE AL ESCRITO DE DEMANDA. Cantidad de Actores y Cantidad de demandados es No aplica por ende no se debe de desglosar actores ni demandados.";
    public ArrayList Estatus_demandaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT PRIN.ID_ORGANOJ,\n"
                + "    PRIN.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_PART,\n"
                + "    SEC.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_INDIVIDUAL,\n"
                + "    DECODE(sec.ID_ESTATUS_DEMANDA,'1','Admitida','2','Desechada','3','Archivo','4','No se dio trámite al escrito de demanda') ID_ESTATUS_DEMANDA,\n"
                + "    ID_TIPO_EXPEDIENTE\n"
                + "  FROM\n"
                + "    (SELECT UNIQUE(CLAVE_EXPEDIENTE)CLAVE_EXPEDIENTE,\n"
                + "      ID_ORGANOJ,\n"
                + "      PERIODO\n"
                + "    FROM TR_EXPEDIENTE\n"
                + "    WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "    AND PERIODO                   ='" + PValidacion.periodo + "'\n"
                + "    OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "    AND PERIODO                   ='" + PValidacion.periodo + "'\n"
                + "    )PRIN\n"
                + "  LEFT JOIN TR_EXPEDIENTE SEC\n"
                + "  ON PRIN.ID_ORGANOJ     =SEC.ID_ORGANOJ\n"
                + "  AND PRIN.CLAVE_EXPEDIENTE=SEC.CLAVE_EXPEDIENTE\n"
                + "  AND PRIN.PERIODO         =SEC.PERIODO\n"
                + "  )\n"
                + "WHERE ID_ESTATUS_DEMANDA IN ('Desechada','Archivo','No se dio trámite al escrito de demanda')\n"
                + "AND ID_TIPO_EXPEDIENTE = 2  ";
        resul = conexion.consultar(sql);
        //System.out.println(sql);     
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("EXPEDIENTE_CLAVE_INDIVIDUAL"),
                    resul.getString("ID_ESTATUS_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion para saber si La cantidad de Demandados  es diferente a el desglose de Demandados.
    public ArrayList Dif_demandadosNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM ( \n"
                + "    SELECT \n"
                + "        PRIN.ID_ORGANOJ,\n"
                + "        PRIN.CLAVE_EXPEDIENTE, \n"
                + "        COALESCE(sec.CANT_DEMANDADOS, 0) AS CANT_DEMANDADOS, \n"
                + "        COALESCE(PRIN.DESGLOSE_DEMANDADO, 0) AS DESGLOSE_DEMANDADOS, \n"
                + "        COALESCE(TO_CHAR(sec.PREG_INCOMPETENCIA), 'NULLO') AS PREG_INCOMPETENCIA,\n"
                + "        COALESCE(TO_CHAR(sec.ID_ESTATUS_DEMANDA), 'NULLO') AS ID_ESTATUS_DEMANDA,\n"
                + "        PRIN.PERIODO, PRIN.ID_TIPO_EXPEDIENTE\n"
                + "    FROM ( \n"
                + "        SELECT DISTINCT \n"
                + "            A.ID_ORGANOJ,\n"
                + "            EXP.CLAVE_EXPEDIENTE,\n"
                + "            A.PERIODO, \n"
                + "            COUNT(A.ID_DEMANDADO) AS DESGLOSE_DEMANDADO,\n"
                + "            EXP.ID_TIPO_EXPEDIENTE\n"
                + "        FROM TR_DEMANDADO A\n"
                + "        JOIN TR_EXP_DEMANDADO EA \n"
                + "            ON A.ID_DEMANDADO = EA.ID_DEMANDADO \n"
                + "            AND A.ID_ORGANOJ = EA.ID_ORGANOJ \n"
                + "            AND A.PERIODO = EA.PERIODO\n"
                + "        JOIN TR_EXPEDIENTE EXP \n"
                + "            ON EA.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE \n"
                + "            AND EA.ID_ORGANOJ = EXP.ID_ORGANOJ\n"
                + "            AND EA.PERIODO = EXP.PERIODO\n"
                + "        WHERE \n"
                + "            (SUBSTR(A.ID_ORGANOJ, 0, 2) = '" + PValidacion.clave_entidad + "' \n"
                + "             AND A.ID_DEMANDADO NOT LIKE '%-%' \n"
                + "             AND A.PERIODO = '" + PValidacion.periodo + "'\n"
                + "             AND EXP.ID_TIPO_EXPEDIENTE = '1')\n"
                + "        OR \n"
                + "            (A.ID_ORGANOJ = '" + PValidacion.clave_organo + "' \n"
                + "             AND A.ID_DEMANDADO NOT LIKE '%-%' \n"
                + "             AND A.PERIODO = '" + PValidacion.periodo + "'\n"
                + "             AND EXP.ID_TIPO_EXPEDIENTE = '1')\n"
                + "        GROUP BY \n"
                + "            A.ID_ORGANOJ, \n"
                + "            EXP.CLAVE_EXPEDIENTE, \n"
                + "            A.PERIODO, \n"
                + "            EXP.ID_TIPO_EXPEDIENTE\n"
                + "    ) PRIN \n"
                + "    LEFT JOIN TR_EXPEDIENTE SEC \n"
                + "        ON PRIN.ID_TIPO_EXPEDIENTE = SEC.ID_TIPO_EXPEDIENTE\n"
                + "        AND PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ \n"
                + "        AND PRIN.CLAVE_EXPEDIENTE = SEC.CLAVE_EXPEDIENTE \n"
                + "        AND PRIN.PERIODO = SEC.PERIODO\n"
                + ") \n"
                + "WHERE PREG_INCOMPETENCIA <> '1' \n"
                + "AND ID_ESTATUS_DEMANDA NOT IN ('2', '3', '4') \n"
                + "AND CANT_DEMANDADOS <> DESGLOSE_DEMANDADOS\n"
                + "AND ID_TIPO_EXPEDIENTE = 2";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("CANT_DEMANDADOS"),
                    resul.getString("DESGLOSE_DEMANDADO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
