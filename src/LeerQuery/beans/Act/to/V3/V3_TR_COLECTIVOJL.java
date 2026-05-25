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
public class V3_TR_COLECTIVOJL {

    public void V3_TR_COLECTIVOJL() throws Exception {
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
            ArrayList<BeanV3_TR_COLECTIVO> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_COLECTIVO("32", "DIC/25", "");
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_COLECTIVO c = new BeanV3_TR_COLECTIVO();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 69; j++) {
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.SetCLAVE_ORGANO(filaActual.get(1));
                        c.SetEXPEDIENTE_CLAVE(filaActual.get(2));
                        c.SetFECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.SetTIPO_ASUNTO(filaActual.get(4));
                        c.SetNAT_CONFLICTO(filaActual.get(5));
                        c.SetRAMA_INDUS_INVOLUCRAD(filaActual.get(6));
                        c.SetSECTOR_RAMA(filaActual.get(7));
                        c.SetSUBSECTOR_RAMA(filaActual.get(8));
                        c.SetENTIDAD_CLAVE(filaActual.get(9));
                        c.SetENTIDAD_NOMBRE(filaActual.get(10));
                        c.SetMUNICIPIO_CLAVE(filaActual.get(11));
                        c.SetMUNICIPIO_NOMBRE(filaActual.get(12));
                        c.SetDECLARACION_PERDIDA_MAY(filaActual.get(13));
                        c.SetSUSPENSION_TMP(filaActual.get(14));
                        c.SetTERMINACION_TRAB(filaActual.get(15));
                        c.SetCONTRATACION_COLECTIVA(filaActual.get(16));
                        c.SetOMISIONES_REGLAMENTO(filaActual.get(17));
                        c.SetREDUCCION_PERSONAL(filaActual.get(18));
                        c.SetVIOLA_DERECHOS(filaActual.get(19));
                        c.SetELECCION_SINDICALES(filaActual.get(20));
                        c.SetSANCION_SINDICALES(filaActual.get(21));
                        c.SetOTRO_CONFLICTO(filaActual.get(22));
                        c.SetOTRO_ESP_CONFLICTO(filaActual.get(23));
                        c.SetNO_IMPUTABLE_ST(filaActual.get(24));
                        c.SetINCAPACIDAD_FISICA_ST(filaActual.get(25));
                        c.SetFALTA_MATERIA_PRIM_ST(filaActual.get(26));
                        c.SetFALTA_MINISTRACION_ST(filaActual.get(27));
                        c.SetFUERZA_MAYOR_TC(filaActual.get(28));
                        c.SetINCAPACIDAD_FISICA_TC(filaActual.get(29));
                        c.SetQUIEBRA_LEGAL_TC(filaActual.get(30));
                        c.SetAGOTAMIENTO_MATERIA_TC(filaActual.get(31));
                        c.SetLIBERTAD_ASOCIACION(filaActual.get(32));
                        c.SetLIBERTAD_SINDICAL(filaActual.get(33));
                        c.SetDERECHO_COLECTIVA(filaActual.get(34));
                        c.SetOTRO_COLECTIVA(filaActual.get(35));
                        c.SetOTRO_ESP_COLECTIVA(filaActual.get(36));
                        c.SetINCOMPETENCIA(filaActual.get(37));
                        c.SetTIPO_INCOMPETENCIA(filaActual.get(38));
                        c.SetOTRO_ESP_INCOMP(filaActual.get(39));
                        c.SetFECHA_PRES_DEMANDA(filaActual.get(40));
                        c.SetCONSTANCIA_CONS_EXPEDIDA(filaActual.get(41));
                        c.SetCONSTANCIA_CLAVE(filaActual.get(42));
                        c.SetASUN_EXCEP_CONCILIACION(filaActual.get(43));
                        c.SetPREVE_DEMANDA(filaActual.get(44));
                        c.SetDESAHOGO_PREV_DEMANDA(filaActual.get(45));
                        c.SetESTATUS_DEMANDA(filaActual.get(46));
                        c.SetFECHA_ADMI_DEMANDA(filaActual.get(47));
                        c.SetCANTIDAD_ACTORES(filaActual.get(48));
                        c.SetCANTIDAD_DEMANDADOS(filaActual.get(49));
                        c.SetAUTO_DEPURACION(filaActual.get(50));
                        c.SetFECHA_DEPURACION(filaActual.get(51));
                        c.SetAUDIENCIA_JUICIO(filaActual.get(52));
                        c.SetFECHA_AUDIENCIA_JUICIO(filaActual.get(53));
                        c.SetESTATUS_EXPEDIENTE(filaActual.get(54));
                        c.SetFECHA_ACTO_PROCESAL(filaActual.get(55));
                        c.SetFASE_SOLI_EXPEDIENTE(filaActual.get(56));
                        c.SetFORMA_SOLUCION_AD(filaActual.get(57));
                        c.SetOTRO_ESP_SOLUCION_AD(filaActual.get(58));
                        c.SetFECHA_DICTO_RESOLUCION_AD(filaActual.get(59));
                        c.SetTIPO_SENTENCIA_AD(filaActual.get(60));
                        c.SetMONTO_SOLUCION_AD(filaActual.get(61));
                        c.SetFORMA_SOLUCION_AJ(filaActual.get(62));
                        c.SetOTRO_ESP_SOLUCION_AJ(filaActual.get(63));
                        c.SetFECHA_RESOLUCION_AJ(filaActual.get(64));
                        c.SetTIPO_SENTENCIA_AJ(filaActual.get(65));
                        c.SetMONTO_SOLUCION_AJ(filaActual.get(66));
                        c.SetCOMENTARIOS(filaActual.get(67));
                        c.SetPERIODO(filaActual.get(68));

                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_COLECTIVOJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_COLECTIVOJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Colectivo(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_COLECTIVO sin registros");
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
