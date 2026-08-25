/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery.beans.federal;

import Conexion.OracleDAOFactoryFED;
import LeerQuery.QueryTmpToTrFED;
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
public class TR_FED_PARAPROCESAL {

    public int IN_FED_PARAPROCESAL() throws Exception {
        QueryTmpToTrFED QFed = new QueryTmpToTrFED();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        try {
            con = OracleDAOFactoryFED.creaConexion();
            ArrayList<BeanTR_FED_PARAPROCESAL> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QFed.TMP_TO_TR_FED_PARAPROCESAL();
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanTR_FED_PARAPROCESAL c = new BeanTR_FED_PARAPROCESAL();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 18; j++) {
                        c.NOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.ID_ORGANOJ(filaActual.get(1));
                        c.CLAVE_EXPEDIENTE(filaActual.get(2));
                        c.FECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.RAMA_INVOLUC(filaActual.get(4));
                        c.SECTOR(filaActual.get(5));
                        c.SUBSECTOR(filaActual.get(6));
                        c.CANTIDAD_PRESTA_RECLAM(filaActual.get(7));
                        c.PREG_INCOMPETENCIA(filaActual.get(8));
                        c.ID_TIPO_INCOMPETENCIA(filaActual.get(9));
                        c.FECHA_PRESENTACION(filaActual.get(10));
                        c.ID_ESTATUS_SOLI(filaActual.get(11));
                        c.FECHA_ADM_SOLICITUD(filaActual.get(12));
                        c.ID_PROMOVENTE(filaActual.get(13));
                        c.ID_ESTATUS_EXPED(filaActual.get(14));
                        c.FECHA_DICTO_SOLUCION(filaActual.get(15));
                        c.COD_EXPE(filaActual.get(16));
                        c.COD_ORG(filaActual.get(17));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_TR_FED_PARAPROCESAL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_FED_PARAPROCESAL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.Paraprocesal(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "TR_FED_PARAPROCESAL sin registros");
                }
            }
            return CFilas;
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
