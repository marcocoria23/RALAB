/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys;

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
public class V0Querys_Fed {

    OracleConexionRalFed conexion = new OracleConexionRalFed();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Clave_organoTMP() {
        conexion.ConectarFed();
        Array = new ArrayList();

        sql = "SELECT DISTINCT CLAVE_ORGANO \n"
                + "FROM TMP_FED_CONTROL_EXPEDIENTE \n"
                + "ORDER BY CLAVE_ORGANO";

        System.out.println(sql);
        resul = conexion.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V0Querys_Fed.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }

}
