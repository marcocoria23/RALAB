/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionRalFed;
import Conexion.OracleDAOFactoryFED;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryProcedureTR_Fed {

    public static boolean Error = false;
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    OracleConexionRalFed conexionRalFed = new OracleConexionRalFed();

    public void elimina_tr_fed() throws SQLException {
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactoryFED.creaConexion();

        try {
            st = con.prepareCall("{call ELIMINA_TR_FED}");
            st.execute();
            System.out.println("Procedimiento ELIMINAR_TR_FED ejecutado con éxito.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e + "Favor de contactar al administrador");
        } finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                boolean Error = true;
                JOptionPane.showMessageDialog(null,"Error al eliminar info TR" + ex);
                throw new SQLException(
                        "[actualiza]: " + ex.getLocalizedMessage()
                );
            }
        }
    }

    public ArrayList<String[]> TAllErroresInserFed() {
        conexionRalFed.ConectarFed();
        Array = new ArrayList<>();

        sql = "SELECT TABLA, CLAVE_ORGANO AS ID_ORGANOJ, CLAVE_EXPEDIENTE, ID, "
                + "REPLACE(EXCEPCION,',','') EXCEPCION, USUARIO, FECHA_HORA "
                + "FROM OBSERVACIONES_RALABF "
                + "WHERE TABLA LIKE 'TR_FED_%' "
                + "ORDER BY TABLA, CLAVE_ORGANO, CLAVE_EXPEDIENTE";

        System.out.println(sql);
        resul = conexionRalFed.consultarFed(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TABLA"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID"),
                    resul.getString("EXCEPCION"),
                    resul.getString("USUARIO"),
                    resul.getString("FECHA_HORA")
                });
            }
            conexionRalFed.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryRalFed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    /*
     * Cuenta los registros de una tabla.
     */
    private int cuenta(Connection con, String tabla) throws SQLException {
        String sqlConteo = "SELECT COUNT(*) FROM " + tabla;
        try (
                Statement stmt = con.createStatement(); ResultSet rsConteo = stmt.executeQuery(sqlConteo)) {
            if (rsConteo.next()) {
                return rsConteo.getInt(1);
            }
        }

        return 0;
    }

    public ArrayList<Integer> conteoTR_Federal(JProgressBar progressBar)throws SQLException {
        String[] tablas = {
            "TR_FED_AUDIENCIAS",
            "TR_FED_COLECTIVO",
            "TR_FED_COLECTIVO_ECONOMICO",
            "TR_FED_COLECTIVO_ECONOMICO_PREST_RECL",
            "TR_FED_COLECTIVO_PREST_RECL",
            "TR_FED_CONTROL_EXPEDIENTE",
            "TR_FED_EJECUCION",
            "TR_FED_HUELGA",
            "TR_FED_HUELGA_PREST_RECL",
            "TR_FED_INDIVIDUAL",
            "TR_FED_INDIVIDUAL_PREST_RECL",
            "TR_FED_ORDINARIO",
            "TR_FED_ORDINARIO_PREST_RECL",
            "TR_FED_PARAPROCESAL",
            "TR_FED_PARAPROCESAL_PREST_RECL",
            "TR_FED_SEG_SOCIAL",
            "TR_FED_SEG_SOCIAL_PREST_RECL"
        };

        Connection con = null;
        ArrayList<Integer> resultado = new ArrayList<>();
        try {
            con = OracleDAOFactoryFED.creaConexion();
            for (String tabla : tablas) {
                int total = cuenta(con, tabla);
                resultado.add(total);
                int valorActual = progressBar.getValue();
                if (valorActual < 100) {
                    int nuevoValor = Math.min(valorActual + 5,100);
                    progressBar.setValue(nuevoValor);
                }
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ignore) {
                }
            }
        }

        return resultado;
    }
    public ArrayList<Integer> conteoTMP_Federal(JProgressBar progressBar)
            throws SQLException {

        String[] tablas = {
            "TMP_FED_AUDIENCIAS",
            "TMP_FED_COLECTIVO",
            "TMP_FED_COLECTIVO_ECONOMICO",
            "TMP_FED_CONTROL_EXPEDIENTE",
            "TMP_FED_EJECUCION",
            "TMP_FED_HUELGA",
            "TMP_FED_INDIVIDUAL",
            "TMP_FED_ORDINARIO",
            "TMP_FED_PARAPROCESAL",
            "TMP_FED_SEG_SOCIAL"
        };
        Connection con = null;
        ArrayList<Integer> resultado = new ArrayList<>();
        try {
            con = OracleDAOFactoryFED.creaConexion();
            for (String tabla : tablas) {
                int total = cuenta(con, tabla);
                resultado.add(total);
                int valorActual = progressBar.getValue();
                if (valorActual < 100) {
                    int nuevoValor = Math.min(valorActual + 5,100);
                    progressBar.setValue(nuevoValor);
                }
            }

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return resultado;
    }
    public ArrayList<Integer> conteoTR_Federal() throws SQLException {

        String[] tablas = {
            "TR_FED_AUDIENCIAS",
            "TR_FED_COLECTIVO",
            "TR_FED_COLECTIVO_ECONOMICO",
            "TR_FED_COLECTIVO_ECONOMICO_PREST_RECL",
            "TR_FED_COLECTIVO_PREST_RECL",
            "TR_FED_CONTROL_EXPEDIENTE",
            "TR_FED_EJECUCION",
            "TR_FED_HUELGA",
            "TR_FED_HUELGA_PREST_RECL",
            "TR_FED_INDIVIDUAL",
            "TR_FED_INDIVIDUAL_PREST_RECL",
            "TR_FED_ORDINARIO",
            "TR_FED_ORDINARIO_PREST_RECL",
            "TR_FED_PARAPROCESAL",
            "TR_FED_PARAPROCESAL_PREST_RECL",
            "TR_FED_SEG_SOCIAL",
            "TR_FED_SEG_SOCIAL_PREST_RECL"
        };
        Connection con = null;
        ArrayList<Integer> resultado = new ArrayList<>();
        try {
            con = OracleDAOFactoryFED.creaConexion();
            for (String tabla : tablas) {
                resultado.add(cuenta(con, tabla));
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return resultado;
    }

    public ArrayList<Integer> conteoTMP_Federal() throws SQLException {

        String[] tablas = {
            "TMP_FED_AUDIENCIAS",
            "TMP_FED_COLECTIVO",
            "TMP_FED_COLECTIVO_ECONOMICO",
            "TMP_FED_CONTROL_EXPEDIENTE",
            "TMP_FED_EJECUCION",
            "TMP_FED_HUELGA",
            "TMP_FED_INDIVIDUAL",
            "TMP_FED_ORDINARIO",
            "TMP_FED_PARAPROCESAL",
            "TMP_FED_SEG_SOCIAL"
        };

        Connection con = null;
        ArrayList<Integer> resultado = new ArrayList<>();
        try {
            con = OracleDAOFactoryFED.creaConexion();
            for (String tabla : tablas) {
                resultado.add(cuenta(con, tabla));
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return resultado;
    }

}
