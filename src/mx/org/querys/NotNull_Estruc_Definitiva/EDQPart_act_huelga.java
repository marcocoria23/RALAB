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


/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQPart_act_huelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    // PENDIENTE
//Query de validacion para saber si Actor y Demandado no se encuntra desagregados.
    public ArrayList ExpeNDesglose() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (SELECT 	 \n" +
"	    ID_EXPEDIENTE,	 \n" +
"	    ID_ORGANOJ, 	 \n" +
"	    CLAVE_EXPEDIENTE, 	 \n" +
"	    DECODE(PREG_INCOMPETENCIA, 2, 'NO') AS PREG_INCOMPETENCIA, 	 \n" +
"	    DECODE(ID_ESTATUS_DEMANDA, 1, 'ADMITIDA') AS ID_ESTATUS_DEMANDA,  	 \n" +
"	    CANT_ACTORES, 	 \n" +
"	    CANT_DEMANDADOS,\n" +
"        ID_FASE_SOL_EXPED \n" +
"	FROM ( 	 \n" +
"	    SELECT * 	 \n" +
"	    FROM TR_EXPEDIENTE  	 \n" +
"	    WHERE  	 \n" +
"	        (SUBSTR(ID_ORGANOJ, 0, 2) = '" + PValidacion.clave_entidad + "'  	 \n" +
"	        AND PERIODO = '" + PValidacion.periodo + "'  	 \n" +
"	        AND PREG_INCOMPETENCIA = 2  	  \n" +
"	        AND ID_TIPO_EXPEDIENTE = 4)  	 \n" +
"	        OR  	 \n" +
"	        (ID_ORGANOJ = '" + PValidacion.clave_organo + "'  	 \n" +
"	        AND PERIODO = '" + PValidacion.periodo + "'  	 \n" +
"	        AND PREG_INCOMPETENCIA = 2  	 \n" +
"	        AND ID_TIPO_EXPEDIENTE = 4) 	 \n" +
"	) 	 \n" +
"	WHERE CANT_ACTORES > 0  	 \n" +
"	AND CLAVE_EXPEDIENTE NOT IN ( 	 \n" +
"	    SELECT DISTINCT EXP.CLAVE_EXPEDIENTE  	 \n" +
"	    FROM TR_ACTOR A  	 \n" +
"	    JOIN TR_EXP_ACTOR EA  	 \n" +
"	        ON A.ID_ACTOR = EA.ACTORES_ID	 \n" +
"	        AND A.ID_ORGANOJ = EA.ID_ORGANOJ  	 \n" +
"	        AND A.PERIODO = EA.PERIODO  	 \n" +
"	    JOIN TR_EXPEDIENTE EXP  	 \n" +
"	        ON EA.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE  	 \n" +
"	        AND EA.ID_ORGANOJ = EXP.ID_ORGANOJ  	 \n" +
"	        AND EA.PERIODO = EXP.PERIODO  	 \n" +
"	    WHERE  	 \n" +
"	        (SUBSTR(A.ID_ORGANOJ, 0, 2) = '" + PValidacion.clave_entidad + "'  	 \n" +
"	        AND A.PERIODO = '" + PValidacion.periodo + "'	 \n" +
"	        AND EXP.ID_TIPO_EXPEDIENTE = 4)  	 \n" +
"	        OR  	 \n" +
"	        (A.ID_ORGANOJ = '" + PValidacion.clave_organo + "'  	 \n" +
"	        AND A.PERIODO = '" + PValidacion.periodo + "'	 \n" +
"	        AND EXP.ID_TIPO_EXPEDIENTE = 4)  	 \n" +
"	)) WHERE ID_FASE_SOL_EXPED <> 5";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_INCOMPETENCIA"),
                    resul.getString("CANT_ACTORES"),
                    resul.getString("CANT_DEMANDADOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQPart_act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion para saber si Cuando el expediente es incompetencia = SI, Cantidad de Actores y Cantidad de demandados es No aplica por ende no se debe de desglosar actores ni demandados.
    public ArrayList IncompetenciaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (  	 \n" +
"	    SELECT 	 \n" +
"	        SEC.ID_EXPEDIENTE,	 \n" +
"	        PRIN.ID_ORGANOJ,	 \n" +
"	        PRIN.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_PART,	 \n" +
"	        SEC.CLAVE_EXPEDIENTE CLAVE_EXPEDIENTE_ORDINARIO,	 \n" +
"	        DECODE(SEC.PREG_INCOMPETENCIA, '1', 'Sí', '2', 'NO') PREG_INCOMPETENCIA 	 \n" +
"	    FROM ( 	 \n" +
"	        SELECT  	 \n" +
"	            UNIQUE(EXP.CLAVE_EXPEDIENTE) CLAVE_EXPEDIENTE,	 \n" +
"	            EXP.ID_TIPO_EXPEDIENTE,	 \n" +
"	            A.ID_ORGANOJ,	 \n" +
"	            A.PERIODO	 \n" +
"	        FROM TR_ACTOR A	 \n" +
"	        JOIN TR_EXP_ACTOR EA ON A.ID_ACTOR = EA.ACTORES_ID 	 \n" +
"	                             AND A.ID_ORGANOJ = EA.ID_ORGANOJ 	 \n" +
"	                             AND A.PERIODO = EA.PERIODO	 \n" +
"	        JOIN TR_EXPEDIENTE EXP ON EA.ID_EXPEDIENTE = EXP.ID_EXPEDIENTE 	 \n" +
"	                               AND EA.ID_ORGANOJ = EXP.ID_ORGANOJ	 \n" +
"	                               AND EA.PERIODO = EXP.PERIODO	 \n" +
"	        WHERE 	 \n" +
"	            (SUBSTR(A.ID_ORGANOJ, 0, 2) = '" + PValidacion.clave_entidad + "' 	 \n" +
"	             AND A.PERIODO = '" + PValidacion.periodo + "' 	 \n" +
"	             AND EXP.ID_TIPO_EXPEDIENTE = '4')	 \n" +
"	        OR 	 \n" +
"	            (A.ID_ORGANOJ = '" + PValidacion.clave_organo + "' 	 \n" +
"	             AND A.PERIODO = '" + PValidacion.periodo + "' 	 \n" +
"	             AND EXP.ID_TIPO_EXPEDIENTE = '4')	 \n" +
"	    ) PRIN 	 \n" +
"	    LEFT JOIN TR_EXPEDIENTE SEC  	 \n" +
"	    ON PRIN.ID_TIPO_EXPEDIENTE = SEC.ID_TIPO_EXPEDIENTE 	 \n" +
"	    AND PRIN.ID_ORGANOJ = SEC.ID_ORGANOJ  	 \n" +
"	    AND PRIN.CLAVE_EXPEDIENTE = SEC.CLAVE_EXPEDIENTE  	 \n" +
"	    AND PRIN.PERIODO = SEC.PERIODO  	 \n" +
"	) 	 \n" +
"	WHERE PREG_INCOMPETENCIA = 'Sí'";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE_HUELGA"),
                    resul.getString("PREG_INCOMPETENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQPart_act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///Query de validacion para saber si La cantidad de Actores  es diferente a el desglose de Actores.
    public ArrayList Dif_ActoresNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_EXPEDIENTE, S.ID_ACTOR, P.ID_TIPO_EXPEDIENTE, COUNT(DISTINCT S.ID_ACTOR) AS ACTORES_REGISTRADOS, P.CANT_ACTORES\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_ACTOR Q\n"
                + "ON P.ID_EXPEDIENTE = Q.ID_EXPEDIENTE AND P.ID_ORGANOJ = Q.ID_ORGANOJ AND P.PERIODO = Q.PERIODO\n"
                + "LEFT JOIN TR_ACTOR S\n"
                + "  ON Q.ACTORES_ID = S.ID_ACTOR AND Q.ID_ORGANOJ = S.ID_ORGANOJ AND Q.PERIODO = S.PERIODO\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 6\n"
                + "GROUP BY P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_EXPEDIENTE, S.ID_ACTOR, P.ID_TIPO_EXPEDIENTE, P.CANT_ACTORES\n"
                + "HAVING COUNT(DISTINCT S.ID_ACTOR) <> P.CANT_ACTORES  )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "    AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "    OR (ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "    AND PERIODO = '" + PValidacion.periodo + "')";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("CANT_ACTORES"),
                    resul.getString("ACTORES_REGISTRADOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDQPart_act_huelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
