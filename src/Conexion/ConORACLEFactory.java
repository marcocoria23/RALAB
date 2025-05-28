package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEJANDRO.CASTILLO
 */
public class ConORACLEFactory {
  
        public static Connection creaConexion(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConORACLEFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@cengob_bd.inegi.gob.mx:1521/cengob.inegi.gob.mx","rel_2021","rel_2021");
        } catch (SQLException ex) {
            Logger.getLogger(ConORACLEFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;        
    }

    
    
}
