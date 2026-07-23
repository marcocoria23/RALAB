/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean_Procedures_Federal;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class BeanEjecucion extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPEDIENTE;
    private String PREG_MOTIV_CONVENI_CELE;
    private String PREG_MOTIV_MEDIA_PROMOC;
    private String PREG_MOTIV_LAUDO_ARBIT;
    private String PREG_MOTIV_RESOL_COLEC_NAT_ECO;
    private String FECHA_PRESENTACION;
    private String ID_ESTATUS_EXPED;
    private String FECHA_DICTO_SOLUCION;
    private String ID_FASE_CONCLU_EXPED;

    public String getNOMBRE_ORGANO_JURIS() {
        return NOMBRE_ORGANO_JURIS;
    }

    public void setNOMBRE_ORGANO_JURIS(String NOMBRE_ORGANO_JURIS) {
        this.NOMBRE_ORGANO_JURIS = NOMBRE_ORGANO_JURIS;
    }

    public String getID_ORGANOJ() {
        return ID_ORGANOJ;
    }

    public void setID_ORGANOJ(String ID_ORGANOJ) {
        this.ID_ORGANOJ = ID_ORGANOJ;
    }

    public String getCLAVE_EXPEDIENTE() {
        return CLAVE_EXPEDIENTE;
    }

    public void setCLAVE_EXPEDIENTE(String CLAVE_EXPEDIENTE) {
        this.CLAVE_EXPEDIENTE = CLAVE_EXPEDIENTE;
    }

    public String getFECHA_APERTURA_EXPEDIENTE() {
        return FECHA_APERTURA_EXPEDIENTE;
    }

    public void setFECHA_APERTURA_EXPEDIENTE(String FECHA_APERTURA_EXPEDIENTE) {
        this.FECHA_APERTURA_EXPEDIENTE = FECHA_APERTURA_EXPEDIENTE;
    }

    public String getPREG_MOTIV_CONVENI_CELE() {
        return PREG_MOTIV_CONVENI_CELE;
    }

    public void setPREG_MOTIV_CONVENI_CELE(String PREG_MOTIV_CONVENI_CELE) {
        this.PREG_MOTIV_CONVENI_CELE = PREG_MOTIV_CONVENI_CELE;
    }

    public String getPREG_MOTIV_MEDIA_PROMOC() {
        return PREG_MOTIV_MEDIA_PROMOC;
    }

    public void setPREG_MOTIV_MEDIA_PROMOC(String PREG_MOTIV_MEDIA_PROMOC) {
        this.PREG_MOTIV_MEDIA_PROMOC = PREG_MOTIV_MEDIA_PROMOC;
    }

    public String getPREG_MOTIV_LAUDO_ARBIT() {
        return PREG_MOTIV_LAUDO_ARBIT;
    }

    public void setPREG_MOTIV_LAUDO_ARBIT(String PREG_MOTIV_LAUDO_ARBIT) {
        this.PREG_MOTIV_LAUDO_ARBIT = PREG_MOTIV_LAUDO_ARBIT;
    }

    public String getPREG_MOTIV_RESOL_COLEC_NAT_ECO() {
        return PREG_MOTIV_RESOL_COLEC_NAT_ECO;
    }

    public void setPREG_MOTIV_RESOL_COLEC_NAT_ECO(String PREG_MOTIV_RESOL_COLEC_NAT_ECO) {
        this.PREG_MOTIV_RESOL_COLEC_NAT_ECO = PREG_MOTIV_RESOL_COLEC_NAT_ECO;
    }

    public String getFECHA_PRESENTACION() {
        return FECHA_PRESENTACION;
    }

    public void setFECHA_PRESENTACION(String FECHA_PRESENTACION) {
        this.FECHA_PRESENTACION = FECHA_PRESENTACION;
    }

    public String getID_ESTATUS_EXPED() {
        return ID_ESTATUS_EXPED;
    }

    public void setID_ESTATUS_EXPED(String ID_ESTATUS_EXPED) {
        this.ID_ESTATUS_EXPED = ID_ESTATUS_EXPED;
    }

    public String getFECHA_DICTO_SOLUCION() {
        return FECHA_DICTO_SOLUCION;
    }

    public void setFECHA_DICTO_SOLUCION(String FECHA_DICTO_SOLUCION) {
        this.FECHA_DICTO_SOLUCION = FECHA_DICTO_SOLUCION;
    }

    public String getID_FASE_CONCLU_EXPED() {
        return ID_FASE_CONCLU_EXPED;
    }

    public void setID_FASE_CONCLU_EXPED(String ID_FASE_CONCLU_EXPED) {
        this.ID_FASE_CONCLU_EXPED = ID_FASE_CONCLU_EXPED;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return SQLTypeName;
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getLlave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        Object[] array = {
            getNOMBRE_ORGANO_JURIS(),
            getID_ORGANOJ(),
            getCLAVE_EXPEDIENTE(),
            getFECHA_APERTURA_EXPEDIENTE(),
            getPREG_MOTIV_CONVENI_CELE(),
            getPREG_MOTIV_MEDIA_PROMOC(),
            getPREG_MOTIV_LAUDO_ARBIT(),
            getPREG_MOTIV_RESOL_COLEC_NAT_ECO(),
            getFECHA_PRESENTACION(),
            getID_ESTATUS_EXPED(),
            getFECHA_DICTO_SOLUCION(),
            getID_FASE_CONCLU_EXPED()
        };
        return array;
    }

    @Override
    public void setAtributos(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String ots(Object obj) {
        String val = null;
        if (obj != null) {
            val = obj.toString();
        }
        return val;
    }

    private Integer oti(Object obj) {
        Integer num = null;
        if (obj != null) {
            try {
                num = (Integer) obj;
            } catch (Exception ex) {
                System.out.println("Error en casteo de numero [" + obj + "]");
            }
        }
        return num;
    }

    public void NOMBRE_ORGANO_JURIS(String valor) {
        this.NOMBRE_ORGANO_JURIS = valor;
    }

    public void ID_ORGANOJ(String valor) {
        this.ID_ORGANOJ = valor;
    }

    public void CLAVE_EXPEDIENTE(String valor) {
        this.CLAVE_EXPEDIENTE = valor;
    }

    public void FECHA_APERTURA_EXPEDIENTE(String valor) {
        this.FECHA_APERTURA_EXPEDIENTE = valor;
    }

    public void PREG_MOTIV_CONVENI_CELE(String valor) {
        this.PREG_MOTIV_CONVENI_CELE = valor;
    }

    public void PREG_MOTIV_MEDIA_PROMOC(String valor) {
        this.PREG_MOTIV_MEDIA_PROMOC = valor;
    }

    public void PREG_MOTIV_LAUDO_ARBIT(String valor) {
        this.PREG_MOTIV_LAUDO_ARBIT = valor;
    }

    public void PREG_MOTIV_RESOL_COLEC_NAT_ECO(String valor) {
        this.PREG_MOTIV_RESOL_COLEC_NAT_ECO = valor;
    }

    public void FECHA_PRESENTACION(String valor) {
        this.FECHA_PRESENTACION = valor;
    }

    public void ID_ESTATUS_EXPED(String valor) {
        this.ID_ESTATUS_EXPED = valor;
    }

    public void FECHA_DICTO_SOLUCION(String valor) {
        this.FECHA_DICTO_SOLUCION = valor;
    }

    public void ID_FASE_CONCLU_EXPED(String valor) {
        this.ID_FASE_CONCLU_EXPED = valor;
    }

}
