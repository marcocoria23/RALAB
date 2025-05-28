package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/* @author ALEJANDRO.CASTILLO  */

public class ConexionPostgreSQL {
    
    
   private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    
    
   private Connection conexion; 
     
    public Connection getConexion() { 
        return conexion; 
    }    
    public void setConexion(Connection conexion) { 
        this.conexion = conexion; 
    }  
  
    public Connection conectar(String usuario , String contraseña) {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, usuario , contraseña);
            System.out.println("✅ Conexión exitosa a PostgreSQL");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a PostgreSQL");
            JOptionPane.showMessageDialog(null, "❌ Error al conectar a PostgreSQL", "Conexion", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        setConexion(conexion);
        return conexion;
    }
    
     public void close() throws SQLException{
        System.out.println("Conexion Cerrada");
        conexion.close();
    }
    

   
}
