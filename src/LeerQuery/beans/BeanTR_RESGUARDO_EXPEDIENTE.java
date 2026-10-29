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
public class BeanTR_RESGUARDO_EXPEDIENTE extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_RESGUARDO;
    private String ID_EXPEDIENTE_ORIGINAL;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String ID_TIPO_EXPEDIENTE;
    private String FECHA_ELIMINACION;
    private String USUARIO_ELIMINACION;
    private String TOTAL_REGISTROS;
    private String ESTADO_RESGUARDO;

    public String getID_RESGUARDO() {
        return ID_RESGUARDO;
    }

    public void setID_RESGUARDO(String ID_RESGUARDO) {
        this.ID_RESGUARDO = ID_RESGUARDO;
    }

    public String getID_EXPEDIENTE_ORIGINAL() {
        return ID_EXPEDIENTE_ORIGINAL;
    }

    public void setID_EXPEDIENTE_ORIGINAL(String ID_EXPEDIENTE_ORIGINAL) {
        this.ID_EXPEDIENTE_ORIGINAL = ID_EXPEDIENTE_ORIGINAL;
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

    public String getID_TIPO_EXPEDIENTE() {
        return ID_TIPO_EXPEDIENTE;
    }

    public void setID_TIPO_EXPEDIENTE(String ID_TIPO_EXPEDIENTE) {
        this.ID_TIPO_EXPEDIENTE = ID_TIPO_EXPEDIENTE;
    }

    public String getFECHA_ELIMINACION() {
        return FECHA_ELIMINACION;
    }

    public void setFECHA_ELIMINACION(String FECHA_ELIMINACION) {
        this.FECHA_ELIMINACION = FECHA_ELIMINACION;
    }

    public String getUSUARIO_ELIMINACION() {
        return USUARIO_ELIMINACION;
    }

    public void setUSUARIO_ELIMINACION(String USUARIO_ELIMINACION) {
        this.USUARIO_ELIMINACION = USUARIO_ELIMINACION;
    }

    public String getTOTAL_REGISTROS() {
        return TOTAL_REGISTROS;
    }

    public void setTOTAL_REGISTROS(String TOTAL_REGISTROS) {
        this.TOTAL_REGISTROS = TOTAL_REGISTROS;
    }

    public String getESTADO_RESGUARDO() {
        return ESTADO_RESGUARDO;
    }

    public void setESTADO_RESGUARDO(String ESTADO_RESGUARDO) {
        this.ESTADO_RESGUARDO = ESTADO_RESGUARDO;
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
            getID_RESGUARDO(),
            getID_EXPEDIENTE_ORIGINAL(),
            getID_ORGANOJ(),
            getCLAVE_EXPEDIENTE(),
            getID_TIPO_EXPEDIENTE(),
            getFECHA_ELIMINACION(),
            getUSUARIO_ELIMINACION(),
            getTOTAL_REGISTROS(),
            getESTADO_RESGUARDO()
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
