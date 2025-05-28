
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
public class TMP_TR_DEMANDADO {
    
    
      public void TMP_TR_DEMANDADO( ArrayList<ArrayList<String>> fila ) throws Exception {
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
            ArrayList<BeanTR_DEMANDADO> ad = new ArrayList<>();
          
            if (fila != null){
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_DEMANDADO c = new BeanTR_DEMANDADO();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 27; j++) {
            c.SetID_DEMANDADO(filaActual.get(0));
            c.SetID_ORGANOJ(filaActual.get(1));
            c.SetID_TIPO_DEMANDADO(filaActual.get(2));
            c.SetID_DEFENSA(filaActual.get(3));
            c.SetNOMBRE_SINDICATO(filaActual.get(4));
            c.SetREG_ASOC_SINDICATO(filaActual.get(5));
            c.SetID_TIPO_SINDICATO(filaActual.get(6));
            c.SetPREG_SIND_PERT_ORG_OBR(filaActual.get(7));
            c.SetID_ORG_OBR(filaActual.get(8));
            c.SetCANT_TRAB_INVOL_H(filaActual.get(9));
            c.SetCANT_TRAB_INVOL_M(filaActual.get(10));
            c.SetCANT_TRAB_INVOL_NI(filaActual.get(11));
            c.SetTRAB_INVOL_TOT(filaActual.get(12));
            c.SetID_TIPO_PATRON(filaActual.get(13));
            c.SetRFC(filaActual.get(14));
            c.SetRAZON_SOCIAL(filaActual.get(15));
            c.SetCALLE(filaActual.get(16));
            c.SetNUM_EXTERIOR(filaActual.get(17));
            c.SetNUM_INTERIOR(filaActual.get(18));
            c.SetCOLONIA(filaActual.get(19));
            c.SetCP(filaActual.get(20));
            c.SetID_ENT_MPIO(filaActual.get(21));
            c.SetLATITUD(filaActual.get(22));
            c.SetLONGITUD(filaActual.get(23));
            c.SetCOMENTARIOS(filaActual.get(24));
            c.SetPERIODO(filaActual.get(25));
            c.SetID_UNIQUE(filaActual.get(26));

                }
                ad.add(c);
                CFilas++;
            }
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_DEMANDADO", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_DEMANDADO", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_DEMANDADO(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                JOptionPane.showMessageDialog(null, "TR_DEMANDADO sin registros");
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
