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
public class BeanControlExpediente extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANO;
    private String SEDE;
    private String JUECES_LABORAL_TOTAL;
    private String JUECES_LABORAL_TOT_HOM;
    private String JUECES_LABORAL_TOT_MUJ;
    private String HORARIO;
    private String ENTIDAD_NOMBRE;
    private String ENTIDAD_CLAVE;
    private String MUNICIPIO_NOMBRE;
    private String MUNICIPIO_CLAVE;
    private String DOMICILIO;
    private String LATITUD;
    private String LONGITUD;
    private String CIRCUNS_ORG_JUR;
    private String JURISDICCION;
    private String ORDINARIO;
    private String ESPECIAL_INDIVI;
    private String ESPECIAL_COLECT;
    private String HUELGA;
    private String SEGURIDAD_SOCIAL;
    private String COL_NATU_ECONOMICA;
    private String PARAP_VOLUNTARIO;
    private String EJECUCION;
    private String FECHA_ALTA;
    private String FECHA_BAJA;
    private String ACTIVO;
    private String OBSERVACIONES;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNOMBRE_ORGANO_JURIS() {
        return NOMBRE_ORGANO_JURIS;
    }

    public void setNOMBRE_ORGANO_JURIS(String NOMBRE_ORGANO_JURIS) {
        this.NOMBRE_ORGANO_JURIS = NOMBRE_ORGANO_JURIS;
    }

    public String getID_ORGANO() {
        return ID_ORGANO;
    }

    public void setID_ORGANO(String ID_ORGANO) {
        this.ID_ORGANO = ID_ORGANO;
    }

    public String getSEDE() {
        return SEDE;
    }

    public void setSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    public String getJUECES_LABORAL_TOTAL() {
        return JUECES_LABORAL_TOTAL;
    }

    public void setJUECES_LABORAL_TOTAL(String JUECES_LABORAL_TOTAL) {
        this.JUECES_LABORAL_TOTAL = JUECES_LABORAL_TOTAL;
    }

    public String getJUECES_LABORAL_TOT_HOM() {
        return JUECES_LABORAL_TOT_HOM;
    }

    public void setJUECES_LABORAL_TOT_HOM(String JUECES_LABORAL_TOT_HOM) {
        this.JUECES_LABORAL_TOT_HOM = JUECES_LABORAL_TOT_HOM;
    }

    public String getJUECES_LABORAL_TOT_MUJ() {
        return JUECES_LABORAL_TOT_MUJ;
    }

    public void setJUECES_LABORAL_TOT_MUJ(String JUECES_LABORAL_TOT_MUJ) {
        this.JUECES_LABORAL_TOT_MUJ = JUECES_LABORAL_TOT_MUJ;
    }

    public String getHORARIO() {
        return HORARIO;
    }

    public void setHORARIO(String HORARIO) {
        this.HORARIO = HORARIO;
    }

    public String getENTIDAD_NOMBRE() {
        return ENTIDAD_NOMBRE;
    }

    public void setENTIDAD_NOMBRE(String ENTIDAD_NOMBRE) {
        this.ENTIDAD_NOMBRE = ENTIDAD_NOMBRE;
    }

    public String getENTIDAD_CLAVE() {
        return ENTIDAD_CLAVE;
    }

    public void setENTIDAD_CLAVE(String ENTIDAD_CLAVE) {
        this.ENTIDAD_CLAVE = ENTIDAD_CLAVE;
    }

    public String getMUNICIPIO_NOMBRE() {
        return MUNICIPIO_NOMBRE;
    }

    public void setMUNICIPIO_NOMBRE(String MUNICIPIO_NOMBRE) {
        this.MUNICIPIO_NOMBRE = MUNICIPIO_NOMBRE;
    }

    public String getMUNICIPIO_CLAVE() {
        return MUNICIPIO_CLAVE;
    }

    public void setMUNICIPIO_CLAVE(String MUNICIPIO_CLAVE) {
        this.MUNICIPIO_CLAVE = MUNICIPIO_CLAVE;
    }

    public String getDOMICILIO() {
        return DOMICILIO;
    }

    public void setDOMICILIO(String DOMICILIO) {
        this.DOMICILIO = DOMICILIO;
    }

    public String getLATITUD() {
        return LATITUD;
    }

    public void setLATITUD(String LATITUD) {
        this.LATITUD = LATITUD;
    }

    public String getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(String LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    public String getCIRCUNS_ORG_JUR() {
        return CIRCUNS_ORG_JUR;
    }

    public void setCIRCUNS_ORG_JUR(String CIRCUNS_ORG_JUR) {
        this.CIRCUNS_ORG_JUR = CIRCUNS_ORG_JUR;
    }

    public String getJURISDICCION() {
        return JURISDICCION;
    }

    public void setJURISDICCION(String JURISDICCION) {
        this.JURISDICCION = JURISDICCION;
    }

    public String getORDINARIO() {
        return ORDINARIO;
    }

    public void setORDINARIO(String ORDINARIO) {
        this.ORDINARIO = ORDINARIO;
    }

    public String getESPECIAL_INDIVI() {
        return ESPECIAL_INDIVI;
    }

    public void setESPECIAL_INDIVI(String ESPECIAL_INDIVI) {
        this.ESPECIAL_INDIVI = ESPECIAL_INDIVI;
    }

    public String getESPECIAL_COLECT() {
        return ESPECIAL_COLECT;
    }

    public void setESPECIAL_COLECT(String ESPECIAL_COLECT) {
        this.ESPECIAL_COLECT = ESPECIAL_COLECT;
    }

    public String getHUELGA() {
        return HUELGA;
    }

    public void setHUELGA(String HUELGA) {
        this.HUELGA = HUELGA;
    }

    public String getSEGURIDAD_SOCIAL() {
        return SEGURIDAD_SOCIAL;
    }

    public void setSEGURIDAD_SOCIAL(String SEGURIDAD_SOCIAL) {
        this.SEGURIDAD_SOCIAL = SEGURIDAD_SOCIAL;
    }

    public String getCOL_NATU_ECONOMICA() {
        return COL_NATU_ECONOMICA;
    }

    public void setCOL_NATU_ECONOMICA(String COL_NATU_ECONOMICA) {
        this.COL_NATU_ECONOMICA = COL_NATU_ECONOMICA;
    }

    public String getPARAP_VOLUNTARIO() {
        return PARAP_VOLUNTARIO;
    }

    public void setPARAP_VOLUNTARIO(String PARAP_VOLUNTARIO) {
        this.PARAP_VOLUNTARIO = PARAP_VOLUNTARIO;
    }

    public String getEJECUCION() {
        return EJECUCION;
    }

    public void setEJECUCION(String EJECUCION) {
        this.EJECUCION = EJECUCION;
    }

    public String getFECHA_ALTA() {
        return FECHA_ALTA;
    }

    public void setFECHA_ALTA(String FECHA_ALTA) {
        this.FECHA_ALTA = FECHA_ALTA;
    }

    public String getFECHA_BAJA() {
        return FECHA_BAJA;
    }

    public void setFECHA_BAJA(String FECHA_BAJA) {
        this.FECHA_BAJA = FECHA_BAJA;
    }

    public String getACTIVO() {
        return ACTIVO;
    }

    public void setACTIVO(String ACTIVO) {
        this.ACTIVO = ACTIVO;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
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
            getID(),
            getNOMBRE_ORGANO_JURIS(),
            getID_ORGANO(),
            getSEDE(),
            getJUECES_LABORAL_TOTAL(),
            getJUECES_LABORAL_TOT_HOM(),
            getJUECES_LABORAL_TOT_MUJ(),
            getHORARIO(),
            getENTIDAD_NOMBRE(),
            getENTIDAD_CLAVE(),
            getMUNICIPIO_NOMBRE(),
            getMUNICIPIO_CLAVE(),
            getDOMICILIO(),
            getLATITUD(),
            getLONGITUD(),
            getCIRCUNS_ORG_JUR(),
            getJURISDICCION(),
            getORDINARIO(),
            getESPECIAL_INDIVI(),
            getESPECIAL_COLECT(),
            getHUELGA(),
            getSEGURIDAD_SOCIAL(),
            getCOL_NATU_ECONOMICA(),
            getPARAP_VOLUNTARIO(),
            getEJECUCION(),
            getFECHA_ALTA(),
            getFECHA_BAJA(),
            getACTIVO(),
            getOBSERVACIONES()
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

    public void ID(String valor) {
        this.ID = valor;
    }

    public void NOMBRE_ORGANO_JURIS(String valor) {
        this.NOMBRE_ORGANO_JURIS = valor;
    }

    public void ID_ORGANO(String valor) {
        this.ID_ORGANO = valor;
    }

    public void SEDE(String valor) {
        this.SEDE = valor;
    }

    public void JUECES_LABORAL_TOTAL(String valor) {
        this.JUECES_LABORAL_TOTAL = valor;
    }

    public void JUECES_LABORAL_TOT_HOM(String valor) {
        this.JUECES_LABORAL_TOT_HOM = valor;
    }

    public void JUECES_LABORAL_TOT_MUJ(String valor) {
        this.JUECES_LABORAL_TOT_MUJ = valor;
    }

    public void HORARIO(String valor) {
        this.HORARIO = valor;
    }

    public void ENTIDAD_NOMBRE(String valor) {
        this.ENTIDAD_NOMBRE = valor;
    }

    public void ENTIDAD_CLAVE(String valor) {
        this.ENTIDAD_CLAVE = valor;
    }

    public void MUNICIPIO_NOMBRE(String valor) {
        this.MUNICIPIO_NOMBRE = valor;
    }

    public void MUNICIPIO_CLAVE(String valor) {
        this.MUNICIPIO_CLAVE = valor;
    }

    public void DOMICILIO(String valor) {
        this.DOMICILIO = valor;
    }

    public void LATITUD(String valor) {
        this.LATITUD = valor;
    }

    public void LONGITUD(String valor) {
        this.LONGITUD = valor;
    }

    public void CIRCUNS_ORG_JUR(String valor) {
        this.CIRCUNS_ORG_JUR = valor;
    }

    public void JURISDICCION(String valor) {
        this.JURISDICCION = valor;
    }

    public void ORDINARIO(String valor) {
        this.ORDINARIO = valor;
    }

    public void ESPECIAL_INDIVI(String valor) {
        this.ESPECIAL_INDIVI = valor;
    }

    public void ESPECIAL_COLECT(String valor) {
        this.ESPECIAL_COLECT = valor;
    }

    public void HUELGA(String valor) {
        this.HUELGA = valor;
    }

    public void SEGURIDAD_SOCIAL(String valor) {
        this.SEGURIDAD_SOCIAL = valor;
    }

    public void COL_NATU_ECONOMICA(String valor) {
        this.COL_NATU_ECONOMICA = valor;
    }

    public void PARAP_VOLUNTARIO(String valor) {
        this.PARAP_VOLUNTARIO = valor;
    }

    public void EJECUCION(String valor) {
        this.EJECUCION = valor;
    }

    public void FECHA_ALTA(String valor) {
        this.FECHA_ALTA = valor;
    }

    public void FECHA_BAJA(String valor) {
        this.FECHA_BAJA = valor;
    }

    public void ACTIVO(String valor) {
        this.ACTIVO = valor;
    }

    public void OBSERVACIONES(String valor) {
        this.OBSERVACIONES = valor;
    }

}
