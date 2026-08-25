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
public class TR_FED_COLECTIVO_ECONOMICO {

    public int IN_FED_COLECTIVO_ECONOMICO() throws Exception {
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
            ArrayList<BeanTR_FED_COLECTIVO_ECONOMICO> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QFed.TMP_TO_TR_FED_COLECTIVO_ECONOMICO();
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanTR_FED_COLECTIVO_ECONOMICO c = new BeanTR_FED_COLECTIVO_ECONOMICO();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 35; j++) {
                        c.NOMBRE_ORGANO_JURIS(filaActual.get(0));
                        c.ID_ORGANOJ(filaActual.get(1));
                        c.CLAVE_EXPEDIENTE(filaActual.get(2));
                        c.FECHA_APERTURA_EXPEDIENTE(filaActual.get(3));
                        c.ID_TIPO_ASUNTO(filaActual.get(4));
                        c.ID_NAT_CONFLICTO(filaActual.get(5));
                        c.RAMA_INVOLUC(filaActual.get(6));
                        c.SECTOR(filaActual.get(7));
                        c.SUBSECTOR(filaActual.get(8));
                        c.ENTIDAD_NOMBRE(filaActual.get(9));
                        c.ENTIDAD_CLAVE(filaActual.get(10));
                        c.MUNICIPIO_NOMBRE(filaActual.get(11));
                        c.MUNICIPIO_CLAVE(filaActual.get(12));
                        c.CANTIDAD_PRESTA_RECLAM(filaActual.get(13));
                        c.PREG_INCOMPETENCIA(filaActual.get(14));
                        c.ID_TIPO_INCOMPETENCIA(filaActual.get(15));
                        c.FECHA_PRESENTACION(filaActual.get(16));
                        c.PREG_CONSTANCIA(filaActual.get(17));
                        c.PREG_EXCEP_CONCILIA(filaActual.get(18));
                        c.PREG_PREVENCION(filaActual.get(19));
                        c.ID_ESTATUS_DEMANDA(filaActual.get(20));
                        c.ID_CAUSA_IMP_DEM(filaActual.get(21));
                        c.FECHA_ADM_DEMANDA(filaActual.get(22));
                        c.CANT_ACTORES(filaActual.get(23));
                        c.CANT_DEMANDADOS(filaActual.get(24));
                        c.PREG_CELEBRA_AUD_ECONOM(filaActual.get(25));
                        c.FECHA_AUD_ECONOM(filaActual.get(26));
                        c.ID_ESTATUS_EXPED(filaActual.get(27));
                        c.FECHA_ULT_ACT_PROC(filaActual.get(28));
                        c.ID_FASE_SOL_EXPED(filaActual.get(29));
                        c.ID_FORMA_SOLUCION(filaActual.get(30));
                        c.FECHA_DICTO_SOLUCION(filaActual.get(31));
                        c.ID_SENTIDO_SENTEN(filaActual.get(32));
                        c.COD_ORG(filaActual.get(33));
                        c.COD_EXPE(filaActual.get(34));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_TR_FED_COLECTIVO_ECONOMICO", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_FED_COLECTIVO_ECONOMICO", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.Colectivo_economico(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "TR_FED_COLECTIVO_ECONOMICO sin registros");
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
