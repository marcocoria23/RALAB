
package LeerQuery.beans;

import Conexion.ConORACLEFactory;
import LeerQuery.QueryLaborales;
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
public class TMP_TR_GENERAL {
    
    public void TMP_TR_GENERAL( ArrayList<ArrayList<String>> fila ) throws Exception {
        ARRAY array_to_pass;
        //ArrayList<ArrayList<String>> fila;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
       try {
            con = ConORACLEFactory.creaConexion();
            ArrayList<BeanTR_GENERAL> ad = new ArrayList<>();         
            if (fila != null){
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_GENERAL c = new BeanTR_GENERAL();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 21; j++) {
                    c.SetID_GENERAL(filaActual.get(0));
                    c.SetID_ORGANOJ(filaActual.get(1));
                    c.SetJUEZ_INDIVIDUA_H(filaActual.get(2));
                    c.SetJUEZ_INDIVIDUAL_M(filaActual.get(3));
                    c.SetJUEZ_COLECTIVO_H(filaActual.get(4));
                    c.SetJUEZ_COLECTIVO_M(filaActual.get(5));
                    c.SetJUEZ_MIXTO_H(filaActual.get(6));
                    c.SetJUEZ_MIXTOS_M(filaActual.get(7));
                    c.SetSUBTOTAL_JUEZ_H(filaActual.get(8));
                    c.SetSUBTOTAL_JUEZ_M(filaActual.get(9));
                    c.SetTOTAL_JUECES(filaActual.get(10));
                    c.SetTOTAL_ORDINARIO(filaActual.get(11));
                    c.SetTOTAL_INDIVIDUAL(filaActual.get(12));
                    c.SetTOTAL_COLECTIVO(filaActual.get(13));
                    c.SetTOTAL_HUELGA(filaActual.get(14));
                    c.SetTOTAL_COL_NAT_ECON(filaActual.get(15));
                    c.SetTOTAL_PARAPROCESAL(filaActual.get(16));
                    c.SetTOTAL_TERCERIAS(filaActual.get(17));
                    c.SetTOTAL_PREF_CRED(filaActual.get(18));
                    c.SetTOTAL_EJECUCION(filaActual.get(19));
                    c.SetPERIODO(filaActual.get(20));

                }
                ad.add(c);
                CFilas++;
            }
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_GENERAL", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_GENERAL", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_GENERAL(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                JOptionPane.showMessageDialog(null, "TR_GENERAL sin registros");
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
