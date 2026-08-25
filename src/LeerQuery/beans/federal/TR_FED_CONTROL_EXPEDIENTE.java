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
public class TR_FED_CONTROL_EXPEDIENTE {

    public int IN_FED_CONTROL_EXPEDIENTE() throws Exception {
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
            ArrayList<BeanTR_FED_CONTROL_EXPEDIENTE> ad = new ArrayList<>();
            ArrayList<ArrayList<String>> fila = QFed.TMP_TO_TR_FED_CONTROL_EXPEDIENTE();
            if (fila != null) {
                for (int i = 0; i < fila.size(); i++) {
                    BeanTR_FED_CONTROL_EXPEDIENTE c = new BeanTR_FED_CONTROL_EXPEDIENTE();
                    ArrayList<String> filaActual = fila.get(i);
                    for (int j = 0; j < 31; j++) {
                        c.ID_CONTROL(filaActual.get(0));
                        c.NOMBRE_ORGANO_JURIS(filaActual.get(1));
                        c.ID_ORGANOJ(filaActual.get(2));
                        c.SEDE(filaActual.get(3));
                        c.JUECES_LABORAL_TOTAL(filaActual.get(4));
                        c.JUECES_LABORAL_TOT_HOM(filaActual.get(5));
                        c.JUECES_LABORAL_TOT_MUJ(filaActual.get(6));
                        c.HORARIO(filaActual.get(7));
                        c.ENTIDAD_NOMBRE(filaActual.get(8));
                        c.ENTIDAD_CLAVE(filaActual.get(9));
                        c.MUNICIPIO_NOMBRE(filaActual.get(10));
                        c.MUNICIPIO_CLAVE(filaActual.get(11));
                        c.DOMICILIO(filaActual.get(12));
                        c.LATITUD(filaActual.get(13));
                        c.LONGITUD(filaActual.get(14));
                        c.CIRCUNS_ORG_JUR(filaActual.get(15));
                        c.JURISDICCION(filaActual.get(16));
                        c.ORDINARIO(filaActual.get(17));
                        c.ESPECIAL_INDIVI(filaActual.get(18));
                        c.ESPECIAL_COLECT(filaActual.get(19));
                        c.HUELGA(filaActual.get(20));
                        c.SEGURIDAD_SOCIAL(filaActual.get(21));
                        c.COL_NATU_ECONOMICA(filaActual.get(22));
                        c.PARAP_VOLUNTARIO(filaActual.get(23));
                        c.EJECUCION(filaActual.get(24));
                        c.FECHA_ALTA(filaActual.get(25));
                        c.FECHA_BAJA(filaActual.get(26));
                        c.ACTIVO(filaActual.get(27));
                        c.OBSERVACIONES(filaActual.get(28));
                        c.COD_ORG(filaActual.get(29));
                        c.ORGANO_JUR_REG(filaActual.get(30));
                    }
                    ad.add(c);
                    CFilas++;
                }
                if (CFilas > 0) {
                    sd = StructDescriptor.createDescriptor("OBJ_TR_FED_CONTROL_EXPEDIENTE", con);
                    structs = new STRUCT[ad.size()];
                    System.out.println("entro 1");
                    System.out.println("tamaño " + ad.size());
                    for (int i = 0; i < ad.size(); i++) {
                        structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                    }
                    System.out.println("entro 2");
                    descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_FED_CONTROL_EXPEDIENTE", con);
                    System.out.println("entro 3");
                    array_to_pass = new ARRAY(descriptor, con, structs);
                    System.out.println("entro 4");
                    st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.Control_expediente(?))}");
                    System.out.println("entro 5");
                    st.registerOutParameter(1, OracleTypes.INTEGER);
                    System.out.println("entro 6");
                    st.setArray(2, array_to_pass);
                    System.out.println("entro 7");
                    st.execute();
                    System.out.println("entro 8");
                } else {
                    JOptionPane.showMessageDialog(null, "TR_FED_CONTROL_EXPEDIENTE sin registros");
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
