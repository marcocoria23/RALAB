/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author ANDREA.HERNANDEZL
 */
public class TMP_TR_RESGUARDO_EXPEDIENTE {

    public void TMP_TR_RESGUARDO_EXPEDIENTE(ArrayList<ArrayList<String>> fila) throws Exception {
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
            ArrayList<BeanTR_RESGUARDO_EXPEDIENTE> ad = new ArrayList<>();
            QueryLaborales DBOData = new QueryLaborales();
            //fila = DBOData.DBO_Tr_Expedientes(cveEntidad , cveOrgano );
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanTR_RESGUARDO_EXPEDIENTE c = new BeanTR_RESGUARDO_EXPEDIENTE();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 9; j++) {
                        c.setID_RESGUARDO(filaActual.get(0));
                        c.setID_EXPEDIENTE_ORIGINAL(filaActual.get(1));
                        c.setID_ORGANOJ(filaActual.get(2));
                        c.setCLAVE_EXPEDIENTE(filaActual.get(3));
                        c.setID_TIPO_EXPEDIENTE(filaActual.get(4));
                        c.setFECHA_ELIMINACION(filaActual.get(5));
                        c.setUSUARIO_ELIMINACION(filaActual.get(6));
                        c.setTOTAL_REGISTROS(filaActual.get(7));
                        c.setESTADO_RESGUARDO(filaActual.get(8));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_TR_RESGUARDO_EXPEDIENTE", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_RESGUARDO_EXPEDIENTE", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_RESGUARDO_EXPEDIENTE(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "TR_RESGUARDO_EXPEDIENTE sin registros");
                }
            }
        } catch (Exception ex) {
            throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
        } finally {
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
