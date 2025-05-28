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
public class TMP_TR_EXP_CONCEPTO_RECLAM {
    
     public void TMP_TR_EXP_CONCEPTO_RECLAM( ArrayList<ArrayList<String>> fila ) throws Exception {
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
       try {
            con = ConORACLEFactory.creaConexion();
            ArrayList<BeanTR_EXP_CONCEPTO_RECLAM> ad = new ArrayList<>();
            if (fila != null){
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_EXP_CONCEPTO_RECLAM c = new BeanTR_EXP_CONCEPTO_RECLAM();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 5; j++) {
                    c.SetID_CONCEPTO_RECLAM(filaActual.get(0));
                    c.SetID_ORGANOJ(filaActual.get(1));
                    c.SetID_EXPEDIENTE(filaActual.get(2));
                    c.SetPERIODO(filaActual.get(3));
                    c.SetID_UNIQUE(filaActual.get(4));
                }
                ad.add(c);
                CFilas++;
            }
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_EXP_CONCEPTO_RECLAM", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_EXP_CONCEPTO_RECLAM", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_EXP_CONCEPTO_RECLAM(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                JOptionPane.showMessageDialog(null, "TR_EXP_CONCEPTO_RECLAM sin registros");
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
