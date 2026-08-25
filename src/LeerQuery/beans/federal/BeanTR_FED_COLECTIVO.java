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
public class BeanTR_FED_COLECTIVO extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPEDIENTE;
    private String ID_TIPO_ASUNTO;
    private String ID_NAT_CONFLICTO;
    private String RAMA_INVOLUC;
    private String SECTOR;
    private String SUBSECTOR;
    private String ENTIDAD_NOMBRE;
    private String ENTIDAD_CLAVE;
    private String MUNICIPIO_NOMBRE;
    private String MUNICIPIO_CLAVE;
    private String CANTIDAD_PRESTA_RECLAM;
    private String PREG_INCOMPETENCIA;
    private String ID_TIPO_INCOMPETENCIA;
    private String FECHA_PRESENTACION;
    private String PREG_CONSTANCIA;
    private String PREG_EXCEP_CONCILIA;
    private String PREG_PREVENCION;
    private String ID_ESTATUS_DEMANDA;
    private String ID_CAUSA_IMP_DEM;
    private String FECHA_ADM_DEMANDA;
    private String CANT_ACTORES;
    private String CANT_DEMANDADOS;
    private String PREG_TRAMITACION_DEPURACION;
    private String FECHA_DEPURACION;
    private String PREG_CELEBRA_AUD_JUICIO;
    private String FECHA_AUD_JUICIO;
    private String ID_ESTATUS_EXPED;
    private String FECHA_ULT_ACT_PROC;
    private String ID_FASE_SOL_EXPED;
    private String ID_FORMA_SOLUCION;
    private String FECHA_DICTO_SOLUCION;
    private String ID_SENTIDO_SENTEN;
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

    public String getFECHA_APERTURA_EXPEDIENTE() {
        return FECHA_APERTURA_EXPEDIENTE;
    }

    public void setFECHA_APERTURA_EXPEDIENTE(String FECHA_APERTURA_EXPEDIENTE) {
        this.FECHA_APERTURA_EXPEDIENTE = FECHA_APERTURA_EXPEDIENTE;
    }

    public String getID_TIPO_ASUNTO() {
        return ID_TIPO_ASUNTO;
    }

    public void setID_TIPO_ASUNTO(String ID_TIPO_ASUNTO) {
        this.ID_TIPO_ASUNTO = ID_TIPO_ASUNTO;
    }

    public String getID_NAT_CONFLICTO() {
        return ID_NAT_CONFLICTO;
    }

    public void setID_NAT_CONFLICTO(String ID_NAT_CONFLICTO) {
        this.ID_NAT_CONFLICTO = ID_NAT_CONFLICTO;
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

    public String getPREG_CONSTANCIA() {
        return PREG_CONSTANCIA;
    }

    public void setPREG_CONSTANCIA(String PREG_CONSTANCIA) {
        this.PREG_CONSTANCIA = PREG_CONSTANCIA;
    }

    public String getPREG_EXCEP_CONCILIA() {
        return PREG_EXCEP_CONCILIA;
    }

    public void setPREG_EXCEP_CONCILIA(String PREG_EXCEP_CONCILIA) {
        this.PREG_EXCEP_CONCILIA = PREG_EXCEP_CONCILIA;
    }

    public String getPREG_PREVENCION() {
        return PREG_PREVENCION;
    }

    public void setPREG_PREVENCION(String PREG_PREVENCION) {
        this.PREG_PREVENCION = PREG_PREVENCION;
    }

    public String getID_ESTATUS_DEMANDA() {
        return ID_ESTATUS_DEMANDA;
    }

    public void setID_ESTATUS_DEMANDA(String ID_ESTATUS_DEMANDA) {
        this.ID_ESTATUS_DEMANDA = ID_ESTATUS_DEMANDA;
    }

    public String getID_CAUSA_IMP_DEM() {
        return ID_CAUSA_IMP_DEM;
    }

    public void setID_CAUSA_IMP_DEM(String ID_CAUSA_IMP_DEM) {
        this.ID_CAUSA_IMP_DEM = ID_CAUSA_IMP_DEM;
    }

    public String getFECHA_ADM_DEMANDA() {
        return FECHA_ADM_DEMANDA;
    }

    public void setFECHA_ADM_DEMANDA(String FECHA_ADM_DEMANDA) {
        this.FECHA_ADM_DEMANDA = FECHA_ADM_DEMANDA;
    }

    public String getCANT_ACTORES() {
        return CANT_ACTORES;
    }

    public void setCANT_ACTORES(String CANT_ACTORES) {
        this.CANT_ACTORES = CANT_ACTORES;
    }

    public String getCANT_DEMANDADOS() {
        return CANT_DEMANDADOS;
    }

    public void setCANT_DEMANDADOS(String CANT_DEMANDADOS) {
        this.CANT_DEMANDADOS = CANT_DEMANDADOS;
    }

    public String getPREG_TRAMITACION_DEPURACION() {
        return PREG_TRAMITACION_DEPURACION;
    }

    public void setPREG_TRAMITACION_DEPURACION(String PREG_TRAMITACION_DEPURACION) {
        this.PREG_TRAMITACION_DEPURACION = PREG_TRAMITACION_DEPURACION;
    }

    public String getFECHA_DEPURACION() {
        return FECHA_DEPURACION;
    }

    public void setFECHA_DEPURACION(String FECHA_DEPURACION) {
        this.FECHA_DEPURACION = FECHA_DEPURACION;
    }

    public String getPREG_CELEBRA_AUD_JUICIO() {
        return PREG_CELEBRA_AUD_JUICIO;
    }

    public void setPREG_CELEBRA_AUD_JUICIO(String PREG_CELEBRA_AUD_JUICIO) {
        this.PREG_CELEBRA_AUD_JUICIO = PREG_CELEBRA_AUD_JUICIO;
    }

    public String getFECHA_AUD_JUICIO() {
        return FECHA_AUD_JUICIO;
    }

    public void setFECHA_AUD_JUICIO(String FECHA_AUD_JUICIO) {
        this.FECHA_AUD_JUICIO = FECHA_AUD_JUICIO;
    }

    public String getID_ESTATUS_EXPED() {
        return ID_ESTATUS_EXPED;
    }

    public void setID_ESTATUS_EXPED(String ID_ESTATUS_EXPED) {
        this.ID_ESTATUS_EXPED = ID_ESTATUS_EXPED;
    }

    public String getFECHA_ULT_ACT_PROC() {
        return FECHA_ULT_ACT_PROC;
    }

    public void setFECHA_ULT_ACT_PROC(String FECHA_ULT_ACT_PROC) {
        this.FECHA_ULT_ACT_PROC = FECHA_ULT_ACT_PROC;
    }

    public String getID_FASE_SOL_EXPED() {
        return ID_FASE_SOL_EXPED;
    }

    public void setID_FASE_SOL_EXPED(String ID_FASE_SOL_EXPED) {
        this.ID_FASE_SOL_EXPED = ID_FASE_SOL_EXPED;
    }

    public String getID_FORMA_SOLUCION() {
        return ID_FORMA_SOLUCION;
    }

    public void setID_FORMA_SOLUCION(String ID_FORMA_SOLUCION) {
        this.ID_FORMA_SOLUCION = ID_FORMA_SOLUCION;
    }

    public String getFECHA_DICTO_SOLUCION() {
        return FECHA_DICTO_SOLUCION;
    }

    public void setFECHA_DICTO_SOLUCION(String FECHA_DICTO_SOLUCION) {
        this.FECHA_DICTO_SOLUCION = FECHA_DICTO_SOLUCION;
    }

    public String getID_SENTIDO_SENTEN() {
        return ID_SENTIDO_SENTEN;
    }

    public void setID_SENTIDO_SENTEN(String ID_SENTIDO_SENTEN) {
        this.ID_SENTIDO_SENTEN = ID_SENTIDO_SENTEN;
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
            getFECHA_APERTURA_EXPEDIENTE(),
            getID_TIPO_ASUNTO(),
            getID_NAT_CONFLICTO(),
            getRAMA_INVOLUC(),
            getSECTOR(),
            getSUBSECTOR(),
            getENTIDAD_NOMBRE(),
            getENTIDAD_CLAVE(),
            getMUNICIPIO_NOMBRE(),
            getMUNICIPIO_CLAVE(),
            getCANTIDAD_PRESTA_RECLAM(),
            getPREG_INCOMPETENCIA(),
            getID_TIPO_INCOMPETENCIA(),
            getFECHA_PRESENTACION(),
            getPREG_CONSTANCIA(),
            getPREG_EXCEP_CONCILIA(),
            getPREG_PREVENCION(),
            getID_ESTATUS_DEMANDA(),
            getID_CAUSA_IMP_DEM(),
            getFECHA_ADM_DEMANDA(),
            getCANT_ACTORES(),
            getCANT_DEMANDADOS(),
            getPREG_TRAMITACION_DEPURACION(),
            getFECHA_DEPURACION(),
            getPREG_CELEBRA_AUD_JUICIO(),
            getFECHA_AUD_JUICIO(),
            getID_ESTATUS_EXPED(),
            getFECHA_ULT_ACT_PROC(),
            getID_FASE_SOL_EXPED(),
            getID_FORMA_SOLUCION(),
            getFECHA_DICTO_SOLUCION(),
            getID_SENTIDO_SENTEN(),
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

    public void FECHA_APERTURA_EXPEDIENTE(String valor) {
        this.FECHA_APERTURA_EXPEDIENTE = valor;
    }

    public void ID_TIPO_ASUNTO(String valor) {
        this.ID_TIPO_ASUNTO = valor;
    }

    public void ID_NAT_CONFLICTO(String valor) {
        this.ID_NAT_CONFLICTO = valor;
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

    public void PREG_CONSTANCIA(String valor) {
        this.PREG_CONSTANCIA = valor;
    }

    public void PREG_EXCEP_CONCILIA(String valor) {
        this.PREG_EXCEP_CONCILIA = valor;
    }

    public void PREG_PREVENCION(String valor) {
        this.PREG_PREVENCION = valor;
    }

    public void ID_ESTATUS_DEMANDA(String valor) {
        this.ID_ESTATUS_DEMANDA = valor;
    }

    public void ID_CAUSA_IMP_DEM(String valor) {
        this.ID_CAUSA_IMP_DEM = valor;
    }

    public void FECHA_ADM_DEMANDA(String valor) {
        this.FECHA_ADM_DEMANDA = valor;
    }

    public void CANT_ACTORES(String valor) {
        this.CANT_ACTORES = valor;
    }

    public void CANT_DEMANDADOS(String valor) {
        this.CANT_DEMANDADOS = valor;
    }

    public void PREG_TRAMITACION_DEPURACION(String valor) {
        this.PREG_TRAMITACION_DEPURACION = valor;
    }

    public void FECHA_DEPURACION(String valor) {
        this.FECHA_DEPURACION = valor;
    }

    public void PREG_CELEBRA_AUD_JUICIO(String valor) {
        this.PREG_CELEBRA_AUD_JUICIO = valor;
    }

    public void FECHA_AUD_JUICIO(String valor) {
        this.FECHA_AUD_JUICIO = valor;
    }

    public void ID_ESTATUS_EXPED(String valor) {
        this.ID_ESTATUS_EXPED = valor;
    }

    public void FECHA_ULT_ACT_PROC(String valor) {
        this.FECHA_ULT_ACT_PROC = valor;
    }

    public void ID_FASE_SOL_EXPED(String valor) {
        this.ID_FASE_SOL_EXPED = valor;
    }

    public void ID_FORMA_SOLUCION(String valor) {
        this.ID_FORMA_SOLUCION = valor;
    }

    public void FECHA_DICTO_SOLUCION(String valor) {
        this.FECHA_DICTO_SOLUCION = valor;
    }

    public void ID_SENTIDO_SENTEN(String valor) {
        this.ID_SENTIDO_SENTEN = valor;
    }

    public void COD_ORG(String valor) {
        this.COD_ORG = valor;
    }

    public void COD_EXPE(String valor) {
        this.COD_EXPE = valor;
    }

}
