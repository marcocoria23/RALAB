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
public class V3_TR_COLECT_ECONOMJL {

    public void V3_TR_COLECT_ECONOMJL(String Cve_Entidad, String Periodo, String Cve_ClaveOrgano) throws Exception {
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
            ArrayList<BeanV3_TR_COLECT_ECONOM> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_COLECT_ECONOMJL(Cve_Entidad, Periodo, Cve_ClaveOrgano);
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_COLECT_ECONOM c = new BeanV3_TR_COLECT_ECONOM();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 56; j++) {
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.SetCLAVE_ORGANO(filaActual.get(1));
                        c.SetEXPEDIENTE_CLAVE(filaActual.get(2));
                        c.SetFECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.SetTIPO_ASUNTO(filaActual.get(4));
                        c.SetNAT_CONFLICTO(filaActual.get(5));
                        c.SetRAMA_INVOLUCRAD(filaActual.get(6));
                        c.SetSECTOR_RAMA(filaActual.get(7));
                        c.SetSUBSECTOR_RAMA(filaActual.get(8));
                        c.SetENTIDAD_CLAVE(filaActual.get(9));
                        c.SetENTIDAD_NOMBRE(filaActual.get(10));
                        c.SetMUNICIPIO_CLAVE(filaActual.get(11));
                        c.SetMUNICIPIO_NOMBRE(filaActual.get(12));
                        c.SetMODIF_CONDICIONES(filaActual.get(13));
                        c.SetNUEVAS_CONDICIONES(filaActual.get(14));
                        c.SetSUSPENSION_TEMPORAL(filaActual.get(15));
                        c.SetTERMINACION_COLECTIVA(filaActual.get(16));
                        c.SetOTRO_MOTIVO_ECONOM(filaActual.get(17));
                        c.SetESPECIFIQUE_ECONOM(filaActual.get(18));
                        c.SetEXCESO_PRODUCCION(filaActual.get(19));
                        c.SetINCOSTEABILIDAD(filaActual.get(20));
                        c.SetFALTA_FONDOS(filaActual.get(21));
                        c.SetINCOMPETENCIA(filaActual.get(22));
                        c.SetTIPO_INCOMPETENCIA(filaActual.get(23));
                        c.SetESPECIFIQUE_INCOMP(filaActual.get(24));
                        c.SetFECHA_PRES_DEMANDA(filaActual.get(25));
                        c.SetCONSTANCIA_CONS_EXPEDIDA(filaActual.get(26));
                        c.SetCONSTANCIA_CLAVE(filaActual.get(27));
                        c.SetASUN_EXCEP_CONCILIACION(filaActual.get(28));
                        c.SetPREVE_DEMANDA(filaActual.get(29));
                        c.SetDESAHOGO_PREV_DEMANDA(filaActual.get(30));
                        c.SetESTATUS_DEMANDA(filaActual.get(31));
                        c.SetFECHA_ADMISION_DEMANDA(filaActual.get(32));
                        c.SetCANTIDAD_ACTORES(filaActual.get(33));
                        c.SetCANTIDAD_DEMANDADOS(filaActual.get(34));
                        c.SetAUDIENCIA_ECONOM(filaActual.get(35));
                        c.SetFECHA_AUDIENCIA_ECONOM(filaActual.get(36));
                        c.SetESTATUS_EXPEDIENTE(filaActual.get(37));
                        c.SetFECHA_ACTO_PROCESAL(filaActual.get(38));
                        c.SetFASE_SOLI_EXPEDIENTE(filaActual.get(39));
                        c.SetFORMA_SOLUCION(filaActual.get(40));
                        c.SetESPECIFIQUE_FORMA(filaActual.get(41));
                        c.SetFECHA_RESOLUCION(filaActual.get(42));
                        c.SetTIPO_SENTENCIA(filaActual.get(43));
                        c.SetAUMENTO_PERSONAL(filaActual.get(44));
                        c.SetDISMINUCION_PERSONAL(filaActual.get(45));
                        c.SetAUMENTO_JORNADALAB(filaActual.get(46));
                        c.SetDISMINUCION_JORNADALAB(filaActual.get(47));
                        c.SetAUMENTO_SEMANA(filaActual.get(48));
                        c.SetDISMINUCION_SEMANA(filaActual.get(49));
                        c.SetAUMENTO_SALARIOS(filaActual.get(50));
                        c.SetDISMINUCION_SALARIOS(filaActual.get(51));
                        c.SetOTRO_TIPO(filaActual.get(52));
                        c.SetESPECIFIQUE_TIPO(filaActual.get(53));
                        c.SetCOMENTARIOS(filaActual.get(54));
                        c.SetPERIODO(filaActual.get(55));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_COLECT_ECONOMJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_COLECT_ECONOMJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Colect_Econom(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_COLECT_ECONOM sin registros");
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
