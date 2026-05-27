/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexion;
import Conexion.OracleConexionDesarrollo;
import Conexion.OracleDAOFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryProcedureActToV3 {

    public static boolean Error = false;

    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    OracleConexion conexion = new  OracleConexion();

    public void elimina_v3(String Cve_Entidad, String Cve_ClaveOrgano, String Periodo) throws SQLException {
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactory.creaConexion();
        try {
            st = con.prepareCall("{call ELIMINA_V3_TR(?,?,?)}");
            st.setString(1, Cve_Entidad);
            st.setString(2, Cve_ClaveOrgano);
            st.setString(3, Periodo);
            st.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
        } finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error = true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR" + ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
        }
    }

    public String Total_Reg_insertadosTR(String Tabla, String entidad, String claveorgano, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_Reg FROM " + Tabla + " WHERE CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "' "
                + " OR SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'  ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_Reg");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryProcedureActToV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }

    public String Total_Reg_NITR(String Tabla, String entidad, String claveorgano, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_Reg FROM V3_ERRORES_INSERT_SQL_TO_V3 WHERE CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "' AND TABLA='" + Tabla + "'"
                + " OR SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "' AND TABLA='" + Tabla + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_Reg");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryProcedureActToV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }

    public ArrayList TErroresInserTRInicio(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();

        sql = "select ID_TABLA,\n"
                + "TABLA,\n"
                + "replace(DESCRIPCION,',','') DESCRIPCION\n"
                + "from V3_ERRORES_INSERT_SQL_TO_V3 \n"
                + "WHERE SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "' OR\n"
                + "CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "' \n"
                + "ORDER BY TABLA,CLAVE_ORGANO";

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
            Logger.getLogger(QueryProcedureActToV3.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }

    public String Total_Errores_Insert(String entidad, String claveorgano, String periodo) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) TOTAL_ERROR "
                + "FROM V3_ERRORES_INSERT_SQL_TO_V3 "
                + "WHERE CLAVE_ORGANO='" + claveorgano + "' "
                + "AND PERIODO='" + periodo + "' "
                + "OR SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' "
                + "AND PERIODO='" + periodo + "'";

        System.out.println(sql);
        resul = conexion.consultar(sql);

        try {
            if (resul.next()) {
                TotalReg = resul.getString("TOTAL_ERROR");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryProcedureActToV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }

}
