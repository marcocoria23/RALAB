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
public class BeanAudiencias extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String ID_PROCEDIMIENTO;
    private String ID_AUDIENCIA;
    private String ID_TIPO_AUDIENCIA;
    private String FECHA_CELEBRACION;
    private String DURACI_INICIO;
    private String DURACI_CONCLUSION;

    public BeanAudiencias() {
    }

    /**
     *
     * @return
     */
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

    public String getID_PROCEDIMIENTO() {
        return ID_PROCEDIMIENTO;
    }

    public void setID_PROCEDIMIENTO(String ID_PROCEDIMIENTO) {
        this.ID_PROCEDIMIENTO = ID_PROCEDIMIENTO;
    }

    public String getID_AUDIENCIA() {
        return ID_AUDIENCIA;
    }

    public void setID_AUDIENCIA(String ID_AUDIENCIA) {
        this.ID_AUDIENCIA = ID_AUDIENCIA;
    }

    public String getID_TIPO_AUDIENCIA() {
        return ID_TIPO_AUDIENCIA;
    }

    public void setID_TIPO_AUDIENCIA(String ID_TIPO_AUDIENCIA) {
        this.ID_TIPO_AUDIENCIA = ID_TIPO_AUDIENCIA;
    }

    public String getFECHA_CELEBRACION() {
        return FECHA_CELEBRACION;
    }

    public void setFECHA_CELEBRACION(String FECHA_CELEBRACION) {
        this.FECHA_CELEBRACION = FECHA_CELEBRACION;
    }

    public String getDURACI_INICIO() {
        return DURACI_INICIO;
    }

    public void setDURACI_INICIO(String DURACI_INICIO) {
        this.DURACI_INICIO = DURACI_INICIO;
    }

    public String getDURACI_CONCLUSION() {
        return DURACI_CONCLUSION;
    }

    public void setDURACI_CONCLUSION(String DURACI_CONCLUSION) {
        this.DURACI_CONCLUSION = DURACI_CONCLUSION;
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
            getID_PROCEDIMIENTO(),
            getID_AUDIENCIA(),
            getID_TIPO_AUDIENCIA(),
            getFECHA_CELEBRACION(),
            getDURACI_INICIO(),
            getDURACI_CONCLUSION()
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

    public void ID_PROCEDIMIENTO(String valor) {
        this.ID_PROCEDIMIENTO = valor;
    }

    public void ID_AUDIENCIA(String valor) {
        this.ID_AUDIENCIA = valor;
    }

    public void ID_TIPO_AUDIENCIA(String valor) {
        this.ID_TIPO_AUDIENCIA = valor;
    }

    public void FECHA_CELEBRACION(String valor) {
        this.FECHA_CELEBRACION = valor;
    }

    public void DURACI_CONCLUSION(String valor) {
        this.DURACI_CONCLUSION = valor;
    }

    public void DURACI_INICIO(String valor) {
        this.DURACI_INICIO = valor;
    }

}
