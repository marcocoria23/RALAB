/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionRalFed;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.org.querys.V0Querys_Fed;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryRalFed {

    public static boolean Error = false;
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    OracleConexionRalFed conexionRalFed = new OracleConexionRalFed();

    public void elimina_Federal_TMP() throws SQLException {
        CallableStatement st = null;
        Connection con = null;

        try {
            // Se inicializa y obtiene la conexión usando los métodos de tu clase
            conexionRalFed.ConectarFed();
            con = conexionRalFed.getConexion();

            if (con != null) {
                // Llamada al procedimiento almacenado que creaste en Oracle
                st = con.prepareCall("{call ELIMINAR_TMP_FED}");
                st.execute();
                System.out.println("Procedimiento ELIMINAR_TMP_FED ejecutado con éxito.");
            } else {
                throw new SQLException("No se pudo establecer la conexión con la base de datos Federal.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "\nFavor de contactar al administrador (Error en Procedimiento Federal)");
            throw e;
        } finally {
            // Cerramos el CallableStatement
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
            }

            // Cerramos la conexión de manera segura usando tu método close()
            try {
                if (con != null && !con.isClosed()) {
                    conexionRalFed.close();
                }
            } catch (SQLException ex) {
                Error = true;
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión Federal: " + ex);
                throw new SQLException("[elimina_Federal_TMP]: " + ex.getLocalizedMessage());
            }
        }
    }

    public ArrayList<String[]> TRegistrosTMPFederal() {
        conexionRalFed.ConectarFed();
        Array = new ArrayList<>();
        sql = "SELECT COUNT(*) TOTAL FROM TMP_FED_CONTROL_EXPEDIENTE \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_AUDIENCIAS \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_ORDINARIO \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_INDIVIDUAL \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_COLECTIVO \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_HUELGA \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_SEG_SOCIAL \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_COLECTIVO_ECONOMICO \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_PARAPROCESAL \n"
                + "UNION ALL \n"
                + "SELECT COUNT(*) FROM TMP_FED_EJECUCION";

        System.out.println(sql);
        resul = conexionRalFed.consultarFed(sql);
        try {

            while (resul.next()) {

                Array.add(new String[]{
                    resul.getString(1)
                });
            }
            conexionRalFed.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Array;
    }

    public ArrayList<String[]> TAllErroresInserFed() {

        conexionRalFed.ConectarFed();
        Array = new ArrayList<>();

        sql = "SELECT TABLA, CLAVE_ORGANO AS ID_ORGANOJ, CLAVE_EXPEDIENTE, ID, REPLACE(EXCEPCION,',','') EXCEPCION, USUARIO, FECHA_HORA \n"
                + "FROM OBSERVACIONES_RALABF "
                + "WHERE TABLA LIKE 'TMP_FED_%'\n"
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

    public ArrayList TErroresInserFed(String Tabla) {
        conexionRalFed.ConectarFed();
        Array = new ArrayList();

        sql = "SELECT TABLA,CLAVE_ORGANO AS ID_ORGANOJ,CLAVE_EXPEDIENTE,ID,REPLACE(EXCEPCION, ',', '') EXCEPCION,USUARIO,FECHA_HORA\n"
                + "FROM OBSERVACIONES_RALABF\n"
                + "WHERE TABLA = '" + Tabla + "' \n"
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
            Logger.getLogger(V0Querys_Fed.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }

    public String Total_Reg_insertadosFed(String Tabla) {
        conexionRalFed.ConectarFed();
        String TotalReg = "";

        sql = "SELECT COUNT(*) Total_Reg FROM " + Tabla;
        System.out.println(sql);
        resul = conexionRalFed.consultarFed(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_Reg");
            }
            conexionRalFed.close();
        } catch (SQLException ex) {
            Logger.getLogger(V0Querys_Fed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TotalReg;
    }

    public String AllTotal_Reg_NI_Fed() {
        conexionRalFed.ConectarFed();
        String totalReg = "";

        sql = "select count(*) TOTAL_REG  from observaciones_ralabf WHERE TABLA LIKE 'TMP_FED_%'";
        System.out.println(sql);
        resul = conexionRalFed.consultarFed(sql);
        try {
            if (resul.next()) {
                totalReg = resul.getString("TOTAL_REG");
            }
            conexionRalFed.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryRalFed.class.getName()).log(Level.SEVERE, null, ex);

        }

        return totalReg;
    }
    

}
