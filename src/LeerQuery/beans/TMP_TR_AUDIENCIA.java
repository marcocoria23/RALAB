package LeerQuery.beans;

import Conexion.ConORACLEFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ALEJANDRO.CASTILLO
 */
public class TMP_TR_AUDIENCIA {
    
      public void TMP_TR_AUDIENCIA( ArrayList<ArrayList<String>> fila ) throws Exception {
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
       try {
            con = ConORACLEFactory.creaConexion();
            ArrayList<BeanTR_AUDIENCIA> ad = new ArrayList<>();
            if (fila != null){
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_AUDIENCIA c = new BeanTR_AUDIENCIA();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 10; j++) {
                    c.SetID_AUDIENCIA(filaActual.get(0));
                    c.SetID_ORGANOJ(filaActual.get(1));
                    c.SetFECHA_CELEBRACION(filaActual.get(2));
                    c.SetID_TIPO_AUDIENCIA(filaActual.get(3));
                    c.SetINICIO(filaActual.get(4));
                    c.SetCONCLUSION(filaActual.get(5));
                    c.SetID_EXPEDIENTE(filaActual.get(6));
                    c.SetCOMENTARIOS(filaActual.get(7));
                    c.SetPERIODO(filaActual.get(8));
                    c.SetID_UNIQUE(filaActual.get(9));
                }
                ad.add(c);
                CFilas++;
            }
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_AUDIENCIA", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_AUDIENCIA", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_AUDIENCIA(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                JOptionPane.showMessageDialog(null, "TR_AUDIENCIA sin registros");
            }
            }
        } 
        catch(Exception ex){
           throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());   
        }
       finally {
            try {
                array_to_pass = null;
                structs = null;
                descriptor = null;
                if (con != null) {
                    System.out.println("cierraaa");
                    // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-TMP_PLE_MEDS1_1");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
        }
    }
    
}
