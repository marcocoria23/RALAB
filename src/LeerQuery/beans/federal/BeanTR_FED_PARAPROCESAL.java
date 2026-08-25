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
public class BeanTR_FED_PARAPROCESAL extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPEDIENTE;
    private String RAMA_INVOLUC;
    private String SECTOR;
    private String SUBSECTOR;
    private String CANTIDAD_PRESTA_RECLAM;
    private String PREG_INCOMPETENCIA;
    private String ID_TIPO_INCOMPETENCIA;
    private String FECHA_PRESENTACION;
    private String ID_ESTATUS_SOLI;
    private String FECHA_ADM_SOLICITUD;
    private String ID_PROMOVENTE;
    private String ID_ESTATUS_EXPED;
    private String FECHA_DICTO_SOLUCION;
    private String COD_EXPE;
    private String COD_ORG;

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

    public String getSECTOR() {
        return SECTOR;
    }

    public void setSECTOR(String SECTOR) {
        this.SECTOR = SECTOR;
    }

    public String getSUBSECTOR() {
        return SUBSECTOR;
    }

    public void setSUBSECTOR(String SUBSECTOR) {
        this.SUBSECTOR = SUBSECTOR;
    }

    public String getCANTIDAD_PRESTA_RECLAM() {
        return CANTIDAD_PRESTA_RECLAM;
    }

    public void setCANTIDAD_PRESTA_RECLAM(String CANTIDAD_PRESTA_RECLAM) {
        this.CANTIDAD_PRESTA_RECLAM = CANTIDAD_PRESTA_RECLAM;
    }

    public String getPREG_INCOMPETENCIA() {
        return PREG_INCOMPETENCIA;
    }

    public void setPREG_INCOMPETENCIA(String PREG_INCOMPETENCIA) {
        this.PREG_INCOMPETENCIA = PREG_INCOMPETENCIA;
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

    public String getFECHA_ADM_SOLICITUD() {
        return FECHA_ADM_SOLICITUD;
    }

    public void setFECHA_ADM_SOLICITUD(String FECHA_ADM_SOLICITUD) {
        this.FECHA_ADM_SOLICITUD = FECHA_ADM_SOLICITUD;
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

    public String getCOD_EXPE() {
        return COD_EXPE;
    }

    public void setCOD_EXPE(String COD_EXPE) {
        this.COD_EXPE = COD_EXPE;
    }

    public String getCOD_ORG() {
        return COD_ORG;
    }

    public void setCOD_ORG(String COD_ORG) {
        this.COD_ORG = COD_ORG;
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
            getSECTOR(),
            getSUBSECTOR(),
            getCANTIDAD_PRESTA_RECLAM(),
            getPREG_INCOMPETENCIA(),
            getID_TIPO_INCOMPETENCIA(),
            getFECHA_PRESENTACION(),
            getID_ESTATUS_SOLI(),
            getFECHA_ADM_SOLICITUD(),
            getID_PROMOVENTE(),
            getID_ESTATUS_EXPED(),
            getFECHA_DICTO_SOLUCION(),
            getCOD_EXPE(),
            getCOD_ORG()
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

    public void SECTOR(String valor) {
        this.SECTOR = valor;
    }

    public void SUBSECTOR(String valor) {
        this.SUBSECTOR = valor;
    }

    public void CANTIDAD_PRESTA_RECLAM(String valor) {
        this.CANTIDAD_PRESTA_RECLAM = valor;
    }

    public void PREG_INCOMPETENCIA(String valor) {
        this.PREG_INCOMPETENCIA = valor;
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

    public void FECHA_ADM_SOLICITUD(String valor) {
        this.FECHA_ADM_SOLICITUD = valor;
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

    public void COD_EXPE(String valor) {
        this.COD_EXPE = valor;
    }

    public void COD_ORG(String valor) {
        this.COD_ORG = valor;
    }

}
