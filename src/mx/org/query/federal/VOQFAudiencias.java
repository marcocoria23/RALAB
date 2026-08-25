/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.query.federal;

import Conexion.OracleConexionRalFed;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class VOQFAudiencias {

    OracleConexionRalFed conexion = new OracleConexionRalFed();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Aud_Ordinario() {
        conexion.ConectarFed();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        A.NOMBRE_ORGANO_JURIS,\n"
                + "        A.ID_ORGANOJ,\n"
                + "        A.CLAVE_EXPEDIENTE,\n"
                + "        A.ID_PROCEDIMIENTO,\n"
                + "        A.ID_AUDIENCIA,\n"
                + "        A.ID_TIPO_AUDIENCIA,\n"
                + "        CASE\n"
                + "            WHEN A.ID_PROCEDIMIENTO = 1\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_ORDINARIO O\n"
                + "                     WHERE O.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND O.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "\n"
                + "            WHEN A.ID_PROCEDIMIENTO = 2\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_INDIVIDUAL c\n"
                + "                     WHERE c.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND c.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "            \n"
                + "            WHEN A.ID_PROCEDIMIENTO = 3\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_COLECTIVO d\n"
                + "                     WHERE d.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND d.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "            \n"
                + "                        WHEN A.ID_PROCEDIMIENTO = 4\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_HUELGA e\n"
                + "                     WHERE e.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND e.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "            \n"
                + "                        WHEN A.ID_PROCEDIMIENTO = 5\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_SEG_SOCIAL f\n"
                + "                     WHERE f.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND f.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "            \n"
                + "                        WHEN A.ID_PROCEDIMIENTO = 6\n"
                + "                 AND EXISTS (\n"
                + "                     SELECT 1\n"
                + "                     FROM TR_FED_COLECTIVO_ECONOMICO g\n"
                + "                     WHERE g.ID_ORGANOJ = A.ID_ORGANOJ\n"
                + "                       AND g.CLAVE_EXPEDIENTE = A.CLAVE_EXPEDIENTE\n"
                + "                 )\n"
                + "            THEN 'ENCONTRADO'\n"
                + "\n"
                + "            WHEN A.ID_PROCEDIMIENTO IN (1, 2,3,4,5,6)\n"
                + "            THEN 'NO ENCONTRADO'\n"
                + "\n"
                + "            ELSE 'PROCEDIMIENTO SIN TABLA CONFIGURADA'\n"
                + "        END AS ESTATUS_BUSQUEDA\n"
                + "    FROM TR_FED_AUDIENCIAS A\n"
                + ")\n"
                + "WHERE ESTATUS_BUSQUEDA = 'NO ENCONTRADO'";
        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ESTATUS_BUSQUEDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VOQFAudiencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
