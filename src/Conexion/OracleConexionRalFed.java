/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class OracleConexionRalFed {

    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    //CONEXION A ORACLE ESQUEMA PRODUCTIVO
    public OracleConexionRalFed ConectarFed() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx";
            conexion = DriverManager.getConnection(BaseDeDatos, "ral_ijf_2024", "ral_ijf_2024");
            if (conexion != null) {
                System.out.println("Conexion Federal exitosa!");
            } else {
                System.out.println("Conexion Federal fallida!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return this;
    }

    public boolean escribirFed(String sql) {
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            //getConexion().commit(); 
            sentencia.close();

        } catch (SQLException e) {
            System.out.print("ERROR SQL" + e);
            return false;
        }
        return true;
    }

    public ResultSet consultarFed(String sql) {
        ResultSet rst = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rst = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("error sql " + e);
            return null;
        }
        return rst;
    }

    public void close() throws SQLException {
        System.out.println("Conexion Cerrada");
        conexion.close();
    }

}
