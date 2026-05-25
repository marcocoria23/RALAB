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
public class V3_TR_HUELGAJL {

    public void V3_TR_HUELGAJL() throws Exception {
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
            ArrayList<BeanV3_TR_HUELGA> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_HUELGAJL("32", "DIC/25", "");
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_HUELGA c = new BeanV3_TR_HUELGA();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 54; j++) {
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.SetCLAVE_ORGANO(filaActual.get(1));
                        c.SetEXPEDIENTE_CLAVE(filaActual.get(2));
                        c.SetFECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.SetTIPO_ASUNTO(filaActual.get(4));
                        c.SetRAMA_INDUS_INVOLUCRAD(filaActual.get(5));
                        c.SetSECTOR_RAMA(filaActual.get(6));
                        c.SetSUBSECTOR_RAMA(filaActual.get(7));
                        c.SetENTIDAD_CLAVE(filaActual.get(8));
                        c.SetENTIDAD_NOMBRE(filaActual.get(9));
                        c.SetMUNICIPIO_CLAVE(filaActual.get(10));
                        c.SetMUNICIPIO_NOMBRE(filaActual.get(11));
                        c.SetFIRMA_CONTRATO(filaActual.get(12));
                        c.SetREVISION_CONTRATO(filaActual.get(13));
                        c.SetINCUMPLIM_CONTRATO(filaActual.get(14));
                        c.SetREVISION_SALARIO(filaActual.get(15));
                        c.SetREPARTO_UTILIDADES(filaActual.get(16));
                        c.SetAPOYO_OTRA_HUELGA(filaActual.get(17));
                        c.SetDESEQUILIBRIO_FAC_PROD(filaActual.get(18));
                        c.SetOTRO_MOTIVO(filaActual.get(19));
                        c.SetESPECIFIQUE_MOTIVO(filaActual.get(20));
                        c.SetINCOMPETENCIA(filaActual.get(21));
                        c.SetTIPO_INCOMPETENCIA(filaActual.get(22));
                        c.SetESPECIFIQUE_INCOMP(filaActual.get(23));
                        c.SetFECHA_PRESENTA_PETIC(filaActual.get(24));
                        c.SetCANTIDAD_ACTORES(filaActual.get(25));
                        c.SetCANTIDAD_DEMANDADOS(filaActual.get(26));
                        c.SetEMPLAZAMIENTO_HUELGA(filaActual.get(27));
                        c.SetFECHA_EMPLAZAMIENTO(filaActual.get(28));
                        c.SetPREHUELGA(filaActual.get(29));
                        c.SetAUDIENCIA_CONCILIACION(filaActual.get(30));
                        c.SetFECHA_AUDIENCIA(filaActual.get(31));
                        c.SetESTALLAMIENTO_HUELGA(filaActual.get(32));
                        c.SetDECLARA_LICITUD_HUELGA(filaActual.get(33));
                        c.SetDECLARA_EXISTEN_HUELGA(filaActual.get(34));
                        c.SetESTATUS_EXPEDIENTE(filaActual.get(35));
                        c.SetFECHA_ACTO_PROCESAL(filaActual.get(36));
                        c.SetFASE_SOLI_EXPEDIENTE(filaActual.get(37));
                        c.SetFORMA_SOLUCION_EMPLAZ(filaActual.get(38));
                        c.SetESPECIFI_FORMA_EMPLAZ(filaActual.get(39));
                        c.SetFECHA_RESOLU_EMPLAZ(filaActual.get(40));
                        c.SetINCREMENTO_SOLICITADO(filaActual.get(41));
                        c.SetINCREMENTO_OTORGADO(filaActual.get(42));
                        c.SetFORMA_SOLUCION_HUELGA(filaActual.get(43));
                        c.SetESPECIFI_FORMA_HUELGA(filaActual.get(44));
                        c.SetFECHA_RESOLU_HUELGA(filaActual.get(45));
                        c.SetTIPO_SENTENCIA(filaActual.get(46));
                        c.SetFECHA_ESTALLAM_HUELGA(filaActual.get(47));
                        c.SetFECHA_LEVANT_HUELGA(filaActual.get(48));
                        c.SetDIAS_HUELGA(filaActual.get(49));
                        c.SetMONTO_ESTIPULADO(filaActual.get(50));
                        c.SetSALARIOS_CAIDOS(filaActual.get(51));
                        c.SetCOMENTARIOS(filaActual.get(52));
                        c.SetPERIODO(filaActual.get(53));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_HUELGAJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_HUELGAJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Huelga(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_HUELGAJL sin registros");
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
