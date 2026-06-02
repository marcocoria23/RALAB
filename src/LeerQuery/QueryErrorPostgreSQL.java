/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionDesarrollo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryErrorPostgreSQL {
    
        public static boolean Error = false;

    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    OracleConexionDesarrollo conexion = new  OracleConexionDesarrollo();
    
    public String Total_Reg_insertadosTR(String Tabla, String entidad, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        String campoOrgano = "ID_ORGANOJ";

        if (Tabla.equals("TR_ESPECIFIQUE")) {
            campoOrgano = "ORGANO";
        }

        sql = "SELECT COUNT(*) TOTAL_REG "
                + "FROM " + Tabla + " "
                + "WHERE SUBSTR(" + campoOrgano + ",1,2) = '" + entidad + "' "
                + "AND PERIODO = '" + periodo + "'";

        System.out.println(sql);
        resul = conexion.consultar(sql);

        try {
            if (resul.next()) {
                TotalReg = resul.getString("TOTAL_REG");
                System.out.println("TOTAL_REG = " + TotalReg);
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryErrorPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return TotalReg;
    }

    public String Total_Reg_NITR(String Tabla, String entidad, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) TOTAL_REG "
                + "FROM RALAB_OBSERVACIONES "
                + "WHERE ENTIDADID = '" + entidad + "' "
                + "AND PERIODO = '" + periodo + "' "
                + "AND TABLA = '" + Tabla + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_Reg");
                System.out.println("TABLA = " + Tabla);
    System.out.println("TOTAL_REG_NI = " + TotalReg);
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryErrorPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }

    public ArrayList TErroresInserTRInicio(String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();

        sql = "SELECT ID_TABLA, "
                + "TABLA, "
                + "REPLACE(DESCRIPCION, ',', '') DESCRIPCION "
                + "FROM RALAB_OBSERVACIONES "
                + "WHERE ENTIDADID = '" + entidad + "' "
                + "AND PERIODO = '" + periodo + "' "
                + "ORDER BY TABLA";

        System.out.println(sql);
        resul = conexion.consultar(sql);

        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TABLA"),
                    resul.getString("TABLA"),
                    resul.getString("DESCRIPCION")
                });
            }
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(QueryErrorPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }

    public String Total_Errores_Insert(String entidad, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) TOTAL_ERROR "
                + "FROM RALAB_OBSERVACIONES "
                + "WHERE ENTIDADID = '" + entidad + "' "
                + "AND PERIODO = '" + periodo + "'";

        System.out.println(sql);
        resul = conexion.consultar(sql);

        try {
            if (resul.next()) {
                TotalReg = resul.getString("TOTAL_ERROR");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryErrorPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }
    
}
