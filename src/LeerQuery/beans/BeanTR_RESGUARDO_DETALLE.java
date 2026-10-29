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
public class BeanTR_RESGUARDO_DETALLE extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_DETALLE;
    private String ID_RESGUARDO;
    private String NOMBRE_TABLA;
    private String CLAVE_ORIGINAL;
    private String ORDEN_VISUALIZACION;
    private String DATOS;
    private String FECHA_RESGUARDO;

    public String getSQLTypeName() {
        return SQLTypeName;
    }

    public void setSQLTypeName(String SQLTypeName) {
        this.SQLTypeName = SQLTypeName;
    }

    public String getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(String ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public String getID_RESGUARDO() {
        return ID_RESGUARDO;
    }

    public void setID_RESGUARDO(String ID_RESGUARDO) {
        this.ID_RESGUARDO = ID_RESGUARDO;
    }

    public String getNOMBRE_TABLA() {
        return NOMBRE_TABLA;
    }

    public void setNOMBRE_TABLA(String NOMBRE_TABLA) {
        this.NOMBRE_TABLA = NOMBRE_TABLA;
    }

    public String getCLAVE_ORIGINAL() {
        return CLAVE_ORIGINAL;
    }

    public void setCLAVE_ORIGINAL(String CLAVE_ORIGINAL) {
        this.CLAVE_ORIGINAL = CLAVE_ORIGINAL;
    }

    public String getORDEN_VISUALIZACION() {
        return ORDEN_VISUALIZACION;
    }

    public void setORDEN_VISUALIZACION(String ORDEN_VISUALIZACION) {
        this.ORDEN_VISUALIZACION = ORDEN_VISUALIZACION;
    }

    public String getDATOS() {
        return DATOS;
    }

    public void setDATOS(String DATOS) {
        this.DATOS = DATOS;
    }

    public String getFECHA_RESGUARDO() {
        return FECHA_RESGUARDO;
    }

    public void setFECHA_RESGUARDO(String FECHA_RESGUARDO) {
        this.FECHA_RESGUARDO = FECHA_RESGUARDO;
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
            getID_DETALLE(),
            getID_RESGUARDO(),
            getNOMBRE_TABLA(),
            getCLAVE_ORIGINAL(),
            getORDEN_VISUALIZACION(),
            getDATOS(),
            getFECHA_RESGUARDO()
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
