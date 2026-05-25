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
public class V3_TR_ORDINARIOJL {

    public void V3_TR_ORDINARIOJL() throws Exception {
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
            ArrayList<BeanV3_TR_ORDINARIO> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QControlExp.V3_TR_ORDINARIOJL("32", "DIC/25", "");
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanV3_TR_ORDINARIO c = new BeanV3_TR_ORDINARIO();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 95; j++) {
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
                        c.SetDESPIDO(filaActual.get(16));
                        c.SetRESCISION_RL(filaActual.get(17));
                        c.SetTERMINACION_RESCISION_RL(filaActual.get(18));
                        c.SetVIOLACION_CONTRATO(filaActual.get(19));
                        c.SetRIESGO_TRABAJO(filaActual.get(20));
                        c.SetREVISION_CONTRATO(filaActual.get(21));
                        c.SetPART_UTILIDADES(filaActual.get(22));
                        c.SetOTRO_MOTIV_CONFLICTO(filaActual.get(23));
                        c.SetOTRO_ESP_CONFLICTO(filaActual.get(24));
                        c.SetCIRCUNS_MOTIVO_CONFL(filaActual.get(25));
                        c.SetDETERM_EMPLEO_EMBARAZO(filaActual.get(26));
                        c.SetDETERM_EMPLEO_EDAD(filaActual.get(27));
                        c.SetDETERM_EMPLEO_GENERO(filaActual.get(28));
                        c.SetDETERM_EMPLEO_ORIEN_SEX(filaActual.get(29));
                        c.SetDETERM_EMPLEO_DISCAPACIDAD(filaActual.get(30));
                        c.SetDETERM_EMPLEO_SOCIAL(filaActual.get(31));
                        c.SetDETERM_EMPLEO_ORIGEN(filaActual.get(32));
                        c.SetDETERM_EMPLEO_RELIGION(filaActual.get(33));
                        c.SetDETERM_EMPLEO_MIGRA(filaActual.get(34));
                        c.SetOTRO_DISCRIMINACION(filaActual.get(35));
                        c.SetOTRO_ESP_DISCRIMI(filaActual.get(36));
                        c.SetTRATA_LABORAL(filaActual.get(37));
                        c.SetTRABAJO_FORZOSO(filaActual.get(38));
                        c.SetTRABAJO_INFANTIL(filaActual.get(39));
                        c.SetHOSTIGAMIENTO(filaActual.get(40));
                        c.SetACOSO_SEXUAL(filaActual.get(41));
                        c.SetPAGO_PRESTACIONES(filaActual.get(42));
                        c.SetINDEMNIZACION(filaActual.get(43));
                        c.SetREINSTALACION(filaActual.get(44));
                        c.SetSALARIO_RETENIDO(filaActual.get(45));
                        c.SetAUMENTO_SALARIO(filaActual.get(46));
                        c.SetDERECHO_ASCENSO(filaActual.get(47));
                        c.SetDERECHO_PREFERENCIA(filaActual.get(48));
                        c.SetDERECHO_ANTIGUEDAD(filaActual.get(49));
                        c.SetOTRO_CONCEPTO(filaActual.get(50));
                        c.SetOTRO_ESP_RECLAMADO(filaActual.get(51));
                        c.SetAGUINALDO(filaActual.get(52));
                        c.SetVACACIONES(filaActual.get(53));
                        c.SetPRIMA_VACACIONAL(filaActual.get(54));
                        c.SetPRIMA_ANTIGUEDAD(filaActual.get(55));
                        c.SetOTRO_TIPO_PREST(filaActual.get(56));
                        c.SetOTRO_ESP_PRESTAC(filaActual.get(57));
                        c.SetMOTIVO_CONFLICTO_COLECT(filaActual.get(58));
                        c.SetINCOMPETENCIA(filaActual.get(59));
                        c.SetTIPO_INCOMPETENCIA(filaActual.get(60));
                        c.SetOTRO_ESP_INCOMP(filaActual.get(61));
                        c.SetFECHA_PRES_DEMANDA(filaActual.get(62));
                        c.SetCONSTANCIA_CONS_EXPEDIDA(filaActual.get(63));
                        c.SetCONSTANCIA_CLAVE(filaActual.get(64));
                        c.SetASUN_EXCEP_CONCILIACION(filaActual.get(65));
                        c.SetPREVE_DEMANDA(filaActual.get(66));
                        c.SetDESAHOGO_PREV_DEMANDA(filaActual.get(67));
                        c.SetESTATUS_DEMANDA(filaActual.get(68));
                        c.SetCAU_IMP_ADM_DEMANDA(filaActual.get(69));
                        c.SetFECHA_ADMI_DEMANDA(filaActual.get(70));
                        c.SetCANTIDAD_ACTORES(filaActual.get(71));
                        c.SetCANTIDAD_DEMANDADOS(filaActual.get(72));
                        c.SetAUDIENCIA_PRELIM(filaActual.get(73));
                        c.SetFECHA_AUDIENCIA_PRELIM(filaActual.get(74));
                        c.SetAUDIENCIA_JUICIO(filaActual.get(75));
                        c.SetFECHA_AUDIENCIA_JUICIO(filaActual.get(76));
                        c.SetESTATUS_EXPEDIENTE(filaActual.get(77));
                        c.SetFECHA_ACTO_PROCESAL(filaActual.get(78));
                        c.SetFASE_SOLI_EXPEDIENTE(filaActual.get(79));
                        c.SetFORMA_SOLUCIONFE(filaActual.get(80));
                        c.SetOTRO_ESP_SOLUCIONFE(filaActual.get(81));
                        c.SetFECHA_DICTO_RESOLUCIONFE(filaActual.get(82));
                        c.SetMONTO_SOLUCION_FE(filaActual.get(83));
                        c.SetFORMA_SOLUCIONAP(filaActual.get(84));
                        c.SetOTRO_ESP_SOLUCIONAP(filaActual.get(85));
                        c.SetFECHA_DICTO_RESOLUCIONAP(filaActual.get(86));
                        c.SetMONTO_SOLUCION_AP(filaActual.get(87));
                        c.SetFORMA_SOLUCIONAJ(filaActual.get(88));
                        c.SetOTRO_ESP_SOLUCIONAJ(filaActual.get(89));
                        c.SetFECHA_RESOLUCIONAJ(filaActual.get(90));
                        c.SetTIPO_SENTENCIAAJ(filaActual.get(91));
                        c.SetMONTO_SOLUCIONAJ(filaActual.get(92));
                        c.SetCOMENTARIOS(filaActual.get(93));
                        c.SetPERIODO(filaActual.get(94));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_V3_TR_ORDINARIOJL", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_V3_TR_ORDINARIOJL", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADORV3.Ordinario(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "V3_TR_ORDINARIO sin registros");
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
