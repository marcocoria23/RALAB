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
public class BeanParaprocesal extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPEDIENTE;
    private String RAMA_INVOLUC;
    private String PREG_NOTIFICACIONDELAVISODEREC;
    private String PREG_OTORGAMIENTOYCANCELACIOND;
    private String PREG_SUSPENSIONDELREPARTOADICI;
    private String PREG_AUTORIZACIONDEPERSONASMAY;
    private String PREG_EXPEDICIONDECONSTANCIASDE;
    private String PREG_RECEPCIONDEDINEROPORVIRTU;
    private String PREG_DEPOSITODELAINDEMNIZACION;
    private String INCOMPETENCIA;
    private String ID_TIPO_INCOMPETENCIA;
    private String FECHA_PRESENTACION;
    private String ID_ESTATUS_SOLI;
    private String FECHA_ADM_DEMANDA;
    private String ID_PROMOVENTE;
    private String ID_ESTATUS_EXPED;
    private String FECHA_DICTO_SOLUCION;

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

    public String getRAMA_INVOLUC() {
        return RAMA_INVOLUC;
    }

    public void setRAMA_INVOLUC(String RAMA_INVOLUC) {
        this.RAMA_INVOLUC = RAMA_INVOLUC;
    }

    public String getPREG_NOTIFICACIONDELAVISODEREC() {
        return PREG_NOTIFICACIONDELAVISODEREC;
    }

    public void setPREG_NOTIFICACIONDELAVISODEREC(String PREG_NOTIFICACIONDELAVISODEREC) {
        this.PREG_NOTIFICACIONDELAVISODEREC = PREG_NOTIFICACIONDELAVISODEREC;
    }

    public String getPREG_OTORGAMIENTOYCANCELACIOND() {
        return PREG_OTORGAMIENTOYCANCELACIOND;
    }

    public void setPREG_OTORGAMIENTOYCANCELACIOND(String PREG_OTORGAMIENTOYCANCELACIOND) {
        this.PREG_OTORGAMIENTOYCANCELACIOND = PREG_OTORGAMIENTOYCANCELACIOND;
    }

    public String getPREG_SUSPENSIONDELREPARTOADICI() {
        return PREG_SUSPENSIONDELREPARTOADICI;
    }

    public void setPREG_SUSPENSIONDELREPARTOADICI(String PREG_SUSPENSIONDELREPARTOADICI) {
        this.PREG_SUSPENSIONDELREPARTOADICI = PREG_SUSPENSIONDELREPARTOADICI;
    }

    public String getPREG_AUTORIZACIONDEPERSONASMAY() {
        return PREG_AUTORIZACIONDEPERSONASMAY;
    }

    public void setPREG_AUTORIZACIONDEPERSONASMAY(String PREG_AUTORIZACIONDEPERSONASMAY) {
        this.PREG_AUTORIZACIONDEPERSONASMAY = PREG_AUTORIZACIONDEPERSONASMAY;
    }

    public String getPREG_EXPEDICIONDECONSTANCIASDE() {
        return PREG_EXPEDICIONDECONSTANCIASDE;
    }

    public void setPREG_EXPEDICIONDECONSTANCIASDE(String PREG_EXPEDICIONDECONSTANCIASDE) {
        this.PREG_EXPEDICIONDECONSTANCIASDE = PREG_EXPEDICIONDECONSTANCIASDE;
    }

    public String getPREG_RECEPCIONDEDINEROPORVIRTU() {
        return PREG_RECEPCIONDEDINEROPORVIRTU;
    }

    public void setPREG_RECEPCIONDEDINEROPORVIRTU(String PREG_RECEPCIONDEDINEROPORVIRTU) {
        this.PREG_RECEPCIONDEDINEROPORVIRTU = PREG_RECEPCIONDEDINEROPORVIRTU;
    }

    public String getPREG_DEPOSITODELAINDEMNIZACION() {
        return PREG_DEPOSITODELAINDEMNIZACION;
    }

    public void setPREG_DEPOSITODELAINDEMNIZACION(String PREG_DEPOSITODELAINDEMNIZACION) {
        this.PREG_DEPOSITODELAINDEMNIZACION = PREG_DEPOSITODELAINDEMNIZACION;
    }

    public String getINCOMPETENCIA() {
        return INCOMPETENCIA;
    }

    public void setINCOMPETENCIA(String INCOMPETENCIA) {
        this.INCOMPETENCIA = INCOMPETENCIA;
    }

    public String getID_TIPO_INCOMPETENCIA() {
        return ID_TIPO_INCOMPETENCIA;
    }

    public void setID_TIPO_INCOMPETENCIA(String ID_TIPO_INCOMPETENCIA) {
        this.ID_TIPO_INCOMPETENCIA = ID_TIPO_INCOMPETENCIA;
    }

    public String getFECHA_PRESENTACION() {
        return FECHA_PRESENTACION;
    }

    public void setFECHA_PRESENTACION(String FECHA_PRESENTACION) {
        this.FECHA_PRESENTACION = FECHA_PRESENTACION;
    }

    public String getID_ESTATUS_SOLI() {
        return ID_ESTATUS_SOLI;
    }

    public void setID_ESTATUS_SOLI(String ID_ESTATUS_SOLI) {
        this.ID_ESTATUS_SOLI = ID_ESTATUS_SOLI;
    }

    public String getFECHA_ADM_DEMANDA() {
        return FECHA_ADM_DEMANDA;
    }

    public void setFECHA_ADM_DEMANDA(String FECHA_ADM_DEMANDA) {
        this.FECHA_ADM_DEMANDA = FECHA_ADM_DEMANDA;
    }

    public String getID_PROMOVENTE() {
        return ID_PROMOVENTE;
    }

    public void setID_PROMOVENTE(String ID_PROMOVENTE) {
        this.ID_PROMOVENTE = ID_PROMOVENTE;
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
            getRAMA_INVOLUC(),
            getPREG_NOTIFICACIONDELAVISODEREC(),
            getPREG_OTORGAMIENTOYCANCELACIOND(),
            getPREG_SUSPENSIONDELREPARTOADICI(),
            getPREG_AUTORIZACIONDEPERSONASMAY(),
            getPREG_EXPEDICIONDECONSTANCIASDE(),
            getPREG_RECEPCIONDEDINEROPORVIRTU(),
            getPREG_DEPOSITODELAINDEMNIZACION(),
            getINCOMPETENCIA(),
            getID_TIPO_INCOMPETENCIA(),
            getFECHA_PRESENTACION(),
            getID_ESTATUS_SOLI(),
            getFECHA_ADM_DEMANDA(),
            getID_PROMOVENTE(),
            getID_ESTATUS_EXPED(),
            getFECHA_DICTO_SOLUCION()
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

    public void RAMA_INVOLUC(String valor) {
        this.RAMA_INVOLUC = valor;
    }

    public void PREG_NOTIFICACIONDELAVISODEREC(String valor) {
        this.PREG_NOTIFICACIONDELAVISODEREC = valor;
    }

    public void PREG_OTORGAMIENTOYCANCELACIOND(String valor) {
        this.PREG_OTORGAMIENTOYCANCELACIOND = valor;
    }

    public void PREG_SUSPENSIONDELREPARTOADICI(String valor) {
        this.PREG_SUSPENSIONDELREPARTOADICI = valor;
    }

    public void PREG_AUTORIZACIONDEPERSONASMAY(String valor) {
        this.PREG_AUTORIZACIONDEPERSONASMAY = valor;
    }

    public void PREG_EXPEDICIONDECONSTANCIASDE(String valor) {
        this.PREG_EXPEDICIONDECONSTANCIASDE = valor;
    }

    public void PREG_RECEPCIONDEDINEROPORVIRTU(String valor) {
        this.PREG_RECEPCIONDEDINEROPORVIRTU = valor;
    }

    public void PREG_DEPOSITODELAINDEMNIZACION(String valor) {
        this.PREG_DEPOSITODELAINDEMNIZACION = valor;
    }

    public void INCOMPETENCIA(String valor) {
        this.INCOMPETENCIA = valor;
    }

    public void ID_TIPO_INCOMPETENCIA(String valor) {
        this.ID_TIPO_INCOMPETENCIA = valor;
    }

    public void FECHA_PRESENTACION(String valor) {
        this.FECHA_PRESENTACION = valor;
    }

    public void ID_ESTATUS_SOLI(String valor) {
        this.ID_ESTATUS_SOLI = valor;
    }

    public void FECHA_ADM_DEMANDA(String valor) {
        this.FECHA_ADM_DEMANDA = valor;
    }

    public void ID_PROMOVENTE(String valor) {
        this.ID_PROMOVENTE = valor;
    }

    public void ID_ESTATUS_EXPED(String valor) {
        this.ID_ESTATUS_EXPED = valor;
    }

    public void FECHA_DICTO_SOLUCION(String valor) {
        this.FECHA_DICTO_SOLUCION = valor;
    }

}
