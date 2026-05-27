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
public class V3_TR_PART_ACT_INDIVIDUALJL {
  
    public void V3_TR_PART_ACT_INDIVIDUALJL(String Cve_Entidad, String Periodo, String Cve_ClaveOrgano) throws Exception {
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
            ArrayList<BeanV3_TR_PART_ACT_INDIVIDUAL> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_PART_ACT_INDIVITUAL(Cve_Entidad, Periodo, Cve_ClaveOrgano);
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_PART_ACT_INDIVIDUAL c = new BeanV3_TR_PART_ACT_INDIVIDUAL();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 15; j++) {
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(0));
c.SetCLAVE_ORGANO(filaActual.get(1));
c.SetEXPEDIENTE_CLAVE(filaActual.get(2));
c.SetID_ACTOR(filaActual.get(3));
c.SetACTOR(filaActual.get(4));
c.SetDEFENSA_ACT(filaActual.get(5));
c.SetSEXO(filaActual.get(6));
c.SetEDAD(filaActual.get(7));
c.SetOCUPACION(filaActual.get(8));
c.SetNSS(filaActual.get(9));
c.SetCURP(filaActual.get(10));
c.SetRFC_TRABAJADOR(filaActual.get(11));
c.SetJORNADA(filaActual.get(12));
c.SetCOMENTARIOS(filaActual.get(13));
c.SetPERIODO(filaActual.get(14));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_PART_ACT_INDIVIDUALJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_PART_ACT_INDIVIDUALJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Part_Act_Individual(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_PART_ACT_INDIVIDUAL sin registros");
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
