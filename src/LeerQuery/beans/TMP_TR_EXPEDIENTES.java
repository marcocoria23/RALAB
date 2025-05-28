package LeerQuery.beans;

import Conexion.ConORACLEFactory;
import LeerQuery.QueryLaborales;
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
 * @author ALEJANDRO.CASTILLO
 */
public class TMP_TR_EXPEDIENTES {
    
    
    public void TMP_TR_EXPEDIENTES( ArrayList<ArrayList<String>> fila ) throws Exception {
        ARRAY array_to_pass;
        //ArrayList<ArrayList<String>> fila;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
       try {
            con = ConORACLEFactory.creaConexion();
            ArrayList<BeanTR_EXPEDIENTE> ad = new ArrayList<>();
            QueryLaborales DBOData = new QueryLaborales();
            //fila = DBOData.DBO_Tr_Expedientes(cveEntidad , cveOrgano );
            if (fila != null){
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_EXPEDIENTE c = new BeanTR_EXPEDIENTE();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 74; j++) {
                    c.SetID_EXPEDIENTE(filaActual.get(0));
                    c.SetID_TIPO_EXPEDIENTE(filaActual.get(1));
                    c.SetID_ORGANOJ(filaActual.get(2));
                    c.SetCLAVE_EXPEDIENTE(filaActual.get(3));
                    c.SetCLAVE_CUADERNO_INCID(filaActual.get(4));
                    c.SetFECHA_PRESENT_INCIDENTE(filaActual.get(5));
                    c.SetFECHA_APERT_CUADER_INCID(filaActual.get(6));
                    c.SetID_TIPO_INCIDENTE(filaActual.get(7));
                    c.SetFECHA_APERTURA_EXPED(filaActual.get(8));
                    c.SetID_TIPO_ASUNTO(filaActual.get(9));
                    c.SetID_NAT_CONFLICTO(filaActual.get(10));
                    c.SetPREG_TRAB_CONTR_ESCRI(filaActual.get(11));
                    c.SetID_TIPO_CONTRATO(filaActual.get(12));
                    c.SetRAMA_INVOLUC(filaActual.get(13));
                    c.SetID_SECTOR_SBTOR(filaActual.get(14));
                    c.SetFECHA_PRES_EJECU_SENT(filaActual.get(15));
                    c.SetID_ENT_MPIO(filaActual.get(16));
                    c.SetPREG_OUTSOURCING(filaActual.get(17));
                    c.SetPREG_APL_CIR_VIN_MOT_CONF(filaActual.get(18));
                    c.SetPREG_PRESTACION(filaActual.get(19));
                    c.SetPREG_FECHA_CELEBR_AUDIENCIA(filaActual.get(20));
                    c.SetFECHA_AUDIENCIA(filaActual.get(21));
                    c.SetMOTIVO_CONF_COLECTIVO(filaActual.get(22));
                    c.SetPREG_INCOMPETENCIA(filaActual.get(23));
                    c.SetID_TIPO_INCOMPETENCIA(filaActual.get(24));
                    c.SetFECHA_PLIEGO_PETICION(filaActual.get(25));
                    c.SetFECHA_PRESENT_DEMANDA(filaActual.get(26));
                    c.SetFECHA_PRESENT_PROMO(filaActual.get(27));
                    c.SetFECHA_ADMISION_PROMO(filaActual.get(28));
                    c.SetID_PROMOVENTE(filaActual.get(29));
                    c.SetPREG_CONST_CONCILIAC(filaActual.get(30));
                    c.SetCLAVE_CONST_CONCILIAC(filaActual.get(31));
                    c.SetPREG_ASUNTO_VINC_CONCIL_P(filaActual.get(32));
                    c.SetPREG_FORMULO_DEMANDA(filaActual.get(33));
                    c.SetPREG_DESAHOGO_DEMANDA(filaActual.get(34));
                    c.SetID_ESTATUS_DEMANDA(filaActual.get(35));
                    c.SetID_CAUSA_IMP_ADM_DEMANDA(filaActual.get(36));
                    c.SetFECHA_ADM_DEMANDA(filaActual.get(37));
                    c.SetCANT_ACTORES(filaActual.get(38));
                    c.SetCANT_DEMANDADOS(filaActual.get(39));
                    c.SetPREG_HUELGA_EMPLAZAM(filaActual.get(40));
                    c.SetFECHA_HUELGA_EMPLAZAM(filaActual.get(41));
                    c.SetPREG_PREHUELGA(filaActual.get(42));
                    c.SetPREG_AUDIENCIA_CONCIL(filaActual.get(43));
                    c.SetFECHA_AUDIENCIA_CONCIL(filaActual.get(44));
                    c.SetPREG_HUELGA_ESTALLA(filaActual.get(45));
                    c.SetID_HUELGA_LICITUD(filaActual.get(46));
                    c.SetID_HUELGA_EXISTENCIA(filaActual.get(47));
                    c.SetPREG_AUTO_DEPURACION_TRAM(filaActual.get(48));
                    c.SetFECHA_AUTO_DEPURACION(filaActual.get(49));
                    c.SetPREG_AUD_PRELIM_CELEBR(filaActual.get(50));
                    c.SetFECHA_AUDIENCIA_PRELIM(filaActual.get(51));
                    c.SetPREG_CELEBRA_AUD_JUICIO(filaActual.get(52));
                    c.SetFECHA_AUD_JUICIO(filaActual.get(53));
                    c.SetPREG_AUDIENCIA_COL_NAT_ECO(filaActual.get(54));
                    c.SetFECHA_AUDIENCIA_COL_NAT_ECO(filaActual.get(55));
                    c.SetID_ESTATUS_EXPED(filaActual.get(56));
                    c.SetFECHA_CONCLUY_EXPED(filaActual.get(57));
                    c.SetFECHA_ULT_ACT_PROC(filaActual.get(58));
                    c.SetID_FASE_SOL_EXPED(filaActual.get(59));
                    c.SetFECHA_CONCL_EJECU(filaActual.get(60));
                    c.SetID_FASE_CONCL_EJEC(filaActual.get(61));
                    c.SetID_FORMA_SOLUCION(filaActual.get(62));
                    c.SetFECHA_DICTO_SOLUCION(filaActual.get(63));
                    c.SetPORCENT_SOLICITADO(filaActual.get(64));
                    c.SetPORCENT_OTORGADO(filaActual.get(65));
                    c.SetID_TIPO_SENTENCIA(filaActual.get(66));
                    c.SetFECHA_HUELGA_ESTALLA(filaActual.get(67));
                    c.SetFECHA_HUELGA_LEVANTAM(filaActual.get(68));
                    c.SetHUELGA_DIAS(filaActual.get(69));
                    c.SetMONTO_SOLUCION(filaActual.get(70));
                    c.SetPORCENT_SALARIOS_CAIDOS(filaActual.get(71));
                    c.SetCOMENTARIOS(filaActual.get(72));
                    c.SetPERIODO(filaActual.get(73));
                }
                ad.add(c);
                CFilas++;
            }
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_EXPEDIENTE", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_EXPEDIENTE", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_TR.TR_EXPEDIENTE(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                JOptionPane.showMessageDialog(null, "TR_EXPEDIENTE sin registros");
            }
            }
        } 
        catch(Exception ex){
           throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());   
        }
       finally {
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
