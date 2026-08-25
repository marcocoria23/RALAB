/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery.beans.federal;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class BeanTR_FED_COLECTIVO_PREST_RECL extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String ID_TIPO_PRESTACION_RECLAMADA;
    private String COD_ORG;
    private String COD_EXPE;

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

    public String getID_TIPO_PRESTACION_RECLAMADA() {
        return ID_TIPO_PRESTACION_RECLAMADA;
    }

    public void setID_TIPO_PRESTACION_RECLAMADA(String ID_TIPO_PRESTACION_RECLAMADA) {
        this.ID_TIPO_PRESTACION_RECLAMADA = ID_TIPO_PRESTACION_RECLAMADA;
    }

    public String getCOD_ORG() {
        return COD_ORG;
    }

    public void setCOD_ORG(String COD_ORG) {
        this.COD_ORG = COD_ORG;
    }

    public String getCOD_EXPE() {
        return COD_EXPE;
    }

    public void setCOD_EXPE(String COD_EXPE) {
        this.COD_EXPE = COD_EXPE;
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
            getID_TIPO_PRESTACION_RECLAMADA(),
            getCOD_ORG(),
            getCOD_EXPE()
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

    public void ID_TIPO_PRESTACION_RECLAMADA(String valor) {
        this.ID_TIPO_PRESTACION_RECLAMADA = valor;
    }

    public void COD_ORG(String valor) {
        this.COD_ORG = valor;
    }

    public void COD_EXPE(String valor) {
        this.COD_EXPE = valor;
    }

}
