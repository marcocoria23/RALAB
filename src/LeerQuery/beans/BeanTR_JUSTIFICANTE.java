/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery.beans;

import Bean_Procedures.Bean;
import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class BeanTR_JUSTIFICANTE extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_JUSTIFICANTE;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String TIPO_PROCEDIMIENTO;
    private String VARIABLE;
    private String JUSTIFICACION;
    private String FECHA_CAMBIO;
    private String USUARIO;

    public String getID_JUSTIFICANTE() {
        return ID_JUSTIFICANTE;
    }

    public void setID_JUSTIFICANTE(String ID_JUSTIFICANTE) {
        this.ID_JUSTIFICANTE = ID_JUSTIFICANTE;
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

    public String getTIPO_PROCEDIMIENTO() {
        return TIPO_PROCEDIMIENTO;
    }

    public void setTIPO_PROCEDIMIENTO(String TIPO_PROCEDIMIENTO) {
        this.TIPO_PROCEDIMIENTO = TIPO_PROCEDIMIENTO;
    }

    public String getVARIABLE() {
        return VARIABLE;
    }

    public void setVARIABLE(String VARIABLE) {
        this.VARIABLE = VARIABLE;
    }

    public String getJUSTIFICACION() {
        return JUSTIFICACION;
    }

    public void setJUSTIFICACION(String JUSTIFICACION) {
        this.JUSTIFICACION = JUSTIFICACION;
    }

    public String getFECHA_CAMBIO() {
        return FECHA_CAMBIO;
    }

    public void setFECHA_CAMBIO(String FECHA_CAMBIO) {
        this.FECHA_CAMBIO = FECHA_CAMBIO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    @Override
    public Object[] getLlave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAtributos(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        Object[] array = {
            getID_JUSTIFICANTE(),
            getID_ORGANOJ(),
            getCLAVE_EXPEDIENTE(),
            getTIPO_PROCEDIMIENTO(),
            getVARIABLE(),
            getJUSTIFICACION(),
            getFECHA_CAMBIO(),
            getUSUARIO()
        };
        return array;
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

}
