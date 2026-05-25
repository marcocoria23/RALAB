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
public class V3_TR_INDIVIDUAL {

    public void V3_TR_INDIVIDUALJL() throws Exception {
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
            ArrayList<BeanV3_TR_INDIVIDUAL> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_INDIVIDUAL("32", "DIC/25", "");
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_INDIVIDUAL c = new BeanV3_TR_INDIVIDUAL();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 79; j++) {
                        c.SetNOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.SetCLAVE_ORGANO(filaActual.get(1));
                        c.SetEXPEDIENTE_CLAVE(filaActual.get(2));
                        c.SetFECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.SetTIPO_ASUNTO(filaActual.get(4));
                        c.SetNAT_CONFLICTO(filaActual.get(5));
                        c.SetCONTRATO_ESCRITO(filaActual.get(6));
                        c.SetTIPO_CONTRATO(filaActual.get(7));
                        c.SetRAMA_INDUS_INVOLUCRADA(filaActual.get(8));
                        c.SetSECTOR_RAMA(filaActual.get(9));
                        c.SetSUBSECTOR_RAMA(filaActual.get(10));
                        c.SetENTIDAD_CLAVE(filaActual.get(11));
                        c.SetENTIDAD_NOMBRE(filaActual.get(12));
                        c.SetMUNICIPIO_CLAVE(filaActual.get(13));
                        c.SetMUNICIPIO_NOMBRE(filaActual.get(14));
                        c.SetSUBCONTRATACION(filaActual.get(15));
                        c.SetINDOLE_TRABAJO(filaActual.get(16));
                        c.SetPRESTACION_FP(filaActual.get(17));
                        c.SetARRENDAM_TRAB(filaActual.get(18));
                        c.SetCAPACITACION(filaActual.get(19));
                        c.SetANTIGUEDAD(filaActual.get(20));
                        c.SetPRIMA_ANTIGUEDAD(filaActual.get(21));
                        c.SetCONVENIO_TRAB(filaActual.get(22));
                        c.SetDESIGNACION_TRAB_FALLE(filaActual.get(23));
                        c.SetDESIGNACION_TRAB_ACT_DELIC(filaActual.get(24));
                        c.SetTERMINACION_LAB(filaActual.get(25));
                        c.SetRECUPERACION_CARGA(filaActual.get(26));
                        c.SetGASTOS_TRASLADOS(filaActual.get(27));
                        c.SetINDEMNIZACION(filaActual.get(28));
                        c.SetPAGO_INDEMNIZACION(filaActual.get(29));
                        c.SetDESACUERDO_MEDICOS(filaActual.get(30));
                        c.SetCOBRO_PRESTACIONES(filaActual.get(31));
                        c.SetCONF_SEGURO_SOCIAL(filaActual.get(32));
                        c.SetOTRO_CONF(filaActual.get(33));
                        c.SetOTRO_ESP_CONF(filaActual.get(34));
                        c.SetINCOMPETENCIA(filaActual.get(35));
                        c.SetTIPO_INCOMPETENCIA(filaActual.get(36));
                        c.SetOTRO_ESP_INCOMP(filaActual.get(37));
                        c.SetFECHA_PRES_DEMANDA(filaActual.get(38));
                        c.SetCONSTANCIA_CONS_EXPEDIDA(filaActual.get(39));
                        c.SetCONSTANCIA_CLAVE(filaActual.get(40));
                        c.SetASUN_EXCEP_CONCILIACION(filaActual.get(41));
                        c.SetPREVE_DEMANDA(filaActual.get(42));
                        c.SetDESAHOGO_PREV_DEMANDA(filaActual.get(43));
                        c.SetESTATUS_DEMANDA(filaActual.get(44));
                        c.SetCAU_IMPI_ADMI_DEMANDA(filaActual.get(45));
                        c.SetFECHA_ADMI_DEMANDA(filaActual.get(46));
                        c.SetCANTIDAD_ACTORES(filaActual.get(47));
                        c.SetCANTIDAD_DEMANDADOS(filaActual.get(48));
                        c.SetTRAMITACION_DEPURACION(filaActual.get(49));
                        c.SetFECHA_DEPURACION(filaActual.get(50));
                        c.SetAUDIENCIA_PRELIM(filaActual.get(51));
                        c.SetFECHA_AUDIENCIA_PRELIM(filaActual.get(52));
                        c.SetAUDIENCIA_JUICIO(filaActual.get(53));
                        c.SetFECHA_AUDIENCIA_JUICIO(filaActual.get(54));
                        c.SetESTATUS_EXPEDIENTE(filaActual.get(55));
                        c.SetFECHA_ACTO_PROCESAL(filaActual.get(56));
                        c.SetFASE_SOLI_EXPEDIENTE(filaActual.get(57));
                        c.SetFORMA_SOLUCION_AD(filaActual.get(58));
                        c.SetOTRO_ESP_SOLUCION_AD(filaActual.get(59));
                        c.SetFECHA_DICTO_RESOLUCION_AD(filaActual.get(60));
                        c.SetTIPO_SENTENCIA_AD(filaActual.get(61));
                        c.SetMONTO_SOLUCION_AD(filaActual.get(62));
                        c.SetFORMA_SOLUCION_TA(filaActual.get(63));
                        c.SetOTRO_ESP_SOLUCION_TA(filaActual.get(64));
                        c.SetFECHA_RESOLUCION_TA(filaActual.get(65));
                        c.SetTIPO_SENTENCIA_TA(filaActual.get(66));
                        c.SetMONTO_SOLUCIÓN_TA(filaActual.get(67));
                        c.SetFORMA_SOLUCION_AP(filaActual.get(68));
                        c.SetOTRO_ESP_SOLUCION_AP(filaActual.get(69));
                        c.SetFECHA_DICTO_RESOLUCION_AP(filaActual.get(70));
                        c.SetMONTO_SOLUCION_AP(filaActual.get(71));
                        c.SetFORMA_SOLUCION_AJ(filaActual.get(72));
                        c.SetOTRO_ESP_SOLUCION_AJ(filaActual.get(73));
                        c.SetFECHA_DICTO_RESOLUCION_AJ(filaActual.get(74));
                        c.SetTIPO_SENTENCIA_AJ(filaActual.get(75));
                        c.SetMONTO_SOLUCIÓN_AJ(filaActual.get(76));
                        c.SetCOMENTARIOS(filaActual.get(77));
                        c.SetPERIODO(filaActual.get(78));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_INDIVIDUALJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_INDIVIDUALJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Individual(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_AUDIENCIAS sin registros");
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
