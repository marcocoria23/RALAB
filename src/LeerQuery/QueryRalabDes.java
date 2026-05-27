
package LeerQuery;

import Conexion.ConORACLEFactory;
import Conexion.OracleConexionDesarrollo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEJANDRO.CASTILLO
 */
public class QueryRalabDes {
    
    public static boolean Error=false;
    
     String sql;
    ArrayList<String[]> Array;
    ResultSet resul;   
    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    
     public void merge_id_expediente(String entidad ,String cveOrgano , String periodo) throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
        // st = con.prepareCall("{call MERGE_ID_EXPEDIENTE()}");
            st = con.prepareCall("{call MERGE_ID_EXPEDIENTE(?,?,?)}");
            st.setString(1, entidad);
            st.setString(2, cveOrgano);
            st.setString(3, periodo ); 
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
    }
    
    public void disable_tr_exp_pk_ralalb() throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
         st = con.prepareCall("{call DISABLE_TR_EXP_PK_RALAB()}");
            
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
    }
    
    public void enable_tr_exp_pk_ralalb() throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
         st = con.prepareCall("{call ENABLE_TR_EXP_PK_RALAB()}");
            
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
    }
    
    public void eliminarRegistros(String entidad ,String cveOrgano , String periodo ) throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
         st = con.prepareCall("{call ELIMINA_TR(?,?,?)}");
            st.setString(1, entidad);
            st.setString(2, cveOrgano);
            st.setString(3, periodo );
            
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
    }
    
    
    public void eliminarRegistrosPostgres(String clavesOrgano  , String periodo ) throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
         st = con.prepareCall("{call ELIMINA_TR_POSTGRES(?,?)}");
            st.setString(1, clavesOrgano);
            st.setString(2, periodo );
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
    }
    
    public int consultarRalabObservaciones(String entidad ,String cveOrgano , String periodo ) throws SQLException{
        Connection con = null;
        ResultSet resul = null;
        ArrayList<String> fila = new ArrayList<>();
        try {
            con = ConORACLEFactory.creaConexion();
            Statement stmt = con.createStatement();
            if(cveOrgano.equals(""))
            resul = stmt.executeQuery("select *from ralab_observaciones where SUBSTR(entidadid,0 , 2) ='" + entidad + "' and periodo = '" + periodo   + "' ");
            else if (entidad.equals("") )
            resul = stmt.executeQuery("select *from ralab_observaciones where entidadid ='" + cveOrgano + "' and periodo = '" + periodo   + "' ");
           else if (entidad.equals("")  )
            resul = stmt.executeQuery("select *from ralab_observaciones where entidadid  in  ( " + cveOrgano + "  ) ");
            while (resul.next()) {
                    fila.add(resul.getString(1));
                    break;
             }
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                 if (resul != null) {
                        resul.close();
                    }
                
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
        return fila.size();
    }
    
      public ArrayList periodo(String Cve_entidad,String Cve_Organo){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(PERIODO) AS PERIODO FROM TR_ORGANOJ WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+Cve_entidad+"' OR ID_ORGANOJ='"+Cve_Organo+"')order by 1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PERIODO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QueryRalabDes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
      public void act_esp_procedure (String entidad ,String cveOrgano , String periodo) throws SQLException {
         CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        try {
        // st = con.prepareCall("{call MERGE_ID_EXPEDIENTE()}");
            st = con.prepareCall("{call ACT_ESP(?,?,?)}");
            st.setString(1, entidad);
            st.setString(2, cveOrgano);
            st.setString(3, periodo ); 
            st.execute();
          }
          catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
          } 
        finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                Error=true;
                JOptionPane.showMessageDialog(null, "Error al eliminar info TR"+ex);
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
      }
      }
    
    
}
