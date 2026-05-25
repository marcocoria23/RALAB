/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery.beans.Act.to.V3;

import Conexion.OracleDAOFactory;
import LeerQuery.QuerysBdActToV3;
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
 * @author ANTONIO.CORIA
 */
public class V3_TR_CONTROL_EXPEDIENTEJL {

    public void V3_TR_CONTROL_EXPEDIENTEJL() throws Exception {
        QuerysBdActToV3 QControlExp = new QuerysBdActToV3();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        try {
            con = OracleDAOFactory.creaConexion();
            ArrayList<BeanV3_TR_CONTROL_EXPEDIENTE> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.DBO_TO_V3_TR_CONTROL_EXPEDIENTEJL("32", "DIC/25", "");
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_CONTROL_EXPEDIENTE c = new BeanV3_TR_CONTROL_EXPEDIENTE();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 36; j++) {
                        c.SetID_CONTROL(filaActual.get(0));
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(1));
                        c.SetCLAVE_ORGANO(filaActual.get(2));
                        c.SetSEDE(filaActual.get(3));
                        c.SetJUECES_LABORAL_TOTAL(filaActual.get(4));
                        c.SetJUECES_LABORAL_SUB_HOM(filaActual.get(5));
                        c.SetJUECES_LABORAL_SUB_MUJ(filaActual.get(6));
                        c.SetJUECES_LABORAL_INDIV_HOM(filaActual.get(7));
                        c.SetJUECES_LABORAL_INDIV_MUJ(filaActual.get(8));
                        c.SetJUECES_LABORAL_COLEC_HOM(filaActual.get(9));
                        c.SetJUECES_LABORAL_COLEC_MUJ(filaActual.get(10));
                        c.SetJUECES_LABORAL_MIX_HOM(filaActual.get(11));
                        c.SetJUECES_LABORAL_MIX_MUJ(filaActual.get(12));
                        c.SetHORARIO(filaActual.get(13));
                        c.SetENTIDAD_CLAVE(filaActual.get(14));
                        c.SetENTIDAD_NOMBRE(filaActual.get(15));
                        c.SetMUNICIPIO_CLAVE(filaActual.get(16));
                        c.SetMUNICIPIO_NOMBRE(filaActual.get(17));
                        c.SetCOLONIA_NOMBRE(filaActual.get(18));
                        c.SetLATITUD_ORG(filaActual.get(19));
                        c.SetLONGITUD_ORG(filaActual.get(20));
                        c.SetCIRCUNS_ORG_JUR(filaActual.get(21));
                        c.SetOTRO_ESP_CIRCUNS(filaActual.get(22));
                        c.SetJURISDICCION(filaActual.get(23));
                        c.SetORDINARIO(filaActual.get(24));
                        c.SetESPECIAL_INDIVI(filaActual.get(25));
                        c.SetESPECIAL_COLECT(filaActual.get(26));
                        c.SetHUELGA(filaActual.get(27));
                        c.SetCOL_NATU_ECONOMICA(filaActual.get(28));
                        c.SetPARAP_VOLUNTARIO(filaActual.get(29));
                        c.SetTERCERIAS(filaActual.get(30));
                        c.SetPREF_CREDITO(filaActual.get(31));
                        c.SetEJECUCION(filaActual.get(32));
                        c.SetPERIODO(filaActual.get(33));
                        c.SetESTATUS("I");
                        c.SetVERSIONES("V3");
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_CONTROL_EXPEDIENTEJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_CONTROL_EXPEDIENTEJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.CONTROL_EXPEDIENTE(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_CONTROL_EXPEDIENTE sin registros");
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
