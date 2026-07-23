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
public class BeanIndividual extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPED;
    private String ID_TIPO_ASUNTO;
    private String ID_NAT_CONFLICTO;
    private String RAMA_INVOLUC;
    private String CLAVE_ENTIDAD_ORG;
    private String CLAVE_ENTIDAD_PAT;
    private String CLAVE_MUN_PAT;
    private String PREG_SUBCONTRATACION;
    private String PREG_SUSPENSION_TRABAJADOR;
    private String PREG_SUSPENSION_PATRON;
    private String PREG_INDEMNIZACION_PATRON;
    private String PREG_AUTORIZACION_LABORAR;
    private String PREG_RECONOCIMIENTO_TRABAJO;
    private String PREG_CAPACITACION;
    private String PREG_ADIESTRAMIENTO;
    private String PREG_NULIDAD_CLAUSULA_CONTRA;
    private String PREG_CONDICIONES_TRABAJO;
    private String PREG_HORAS_EXTRA;
    private String PREG_HABITACION;
    private String PREG_CREDITOS;
    private String PREG_CAPACITACION_ADIESTRAMI;
    private String PREG_PRIMA_ANTIGUEDAD;
    private String PREG_REGLAMENTO_INTER_TRABAJO;
    private String PREG_RENTA_MAX_HAB_TRABAJADOR;
    private String PREG_OBLIGA_DERIV_RENTA_HAB;
    private String PREG_COBRO_PRESTA_SALARIO;
    private String PREG_ALOJAMIENTO;
    private String PREG_SALARIO_BASE_COTIZACION;
    private String PREG_INCAPACI_PERMA_PARCIAL;
    private String PREG_MUERTE;
    private String PREG_PENSION_ASCENDENCIA;
    private String PREG_PENSION_GARANTIZADA;
    private String PREG_INCRE_PENSION;
    private String PREG_INDEMNIZACION_GLOBAL;
    private String PREG_ASISTENCIA_MEDICA;
    private String PREG_APARATOS_PROT_ORTOP;
    private String PREG_RIESGOS_SALARIO_BASE;
    private String PREG_RIESGOS_PAGO_INDEMNIZA;
    private String PREG_RIESGO_OPOSICION_DESIG;
    private String PREG_DESIGNACION_FALLECIDO;
    private String PREG_DESIGNACION_DESAPARECIDO;
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
    private String PREG_AUD_PRELIM_CELEBR;
    private String FECHA_AUDIENCIA_PRELIM;
    private String PREG_CELEBRA_AUD_JUICIO;
    private String FECHA_AUD_JUICIO;
    private String ID_ESTATUS_EXPED;
    private String FECHA_ULT_ACT_PROC;
    private String ID_FASE_SOL_EXPED;
    private String ID_FORMA_SOLUCION;
    private String FECHA_DICTO_SOLUCION;
    private String FECHA_SENTENCIA;
    private String ID_SENTIDO_SENTEN;

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

    public String getFECHA_APERTURA_EXPED() {
        return FECHA_APERTURA_EXPED;
    }

    public void setFECHA_APERTURA_EXPED(String FECHA_APERTURA_EXPED) {
        this.FECHA_APERTURA_EXPED = FECHA_APERTURA_EXPED;
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

    public String getCLAVE_ENTIDAD_ORG() {
        return CLAVE_ENTIDAD_ORG;
    }

    public void setCLAVE_ENTIDAD_ORG(String CLAVE_ENTIDAD_ORG) {
        this.CLAVE_ENTIDAD_ORG = CLAVE_ENTIDAD_ORG;
    }

    public String getCLAVE_ENTIDAD_PAT() {
        return CLAVE_ENTIDAD_PAT;
    }

    public void setCLAVE_ENTIDAD_PAT(String CLAVE_ENTIDAD_PAT) {
        this.CLAVE_ENTIDAD_PAT = CLAVE_ENTIDAD_PAT;
    }

    public String getCLAVE_MUN_PAT() {
        return CLAVE_MUN_PAT;
    }

    public void setCLAVE_MUN_PAT(String CLAVE_MUN_PAT) {
        this.CLAVE_MUN_PAT = CLAVE_MUN_PAT;
    }

    public String getPREG_SUBCONTRATACION() {
        return PREG_SUBCONTRATACION;
    }

    public void setPREG_SUBCONTRATACION(String PREG_SUBCONTRATACION) {
        this.PREG_SUBCONTRATACION = PREG_SUBCONTRATACION;
    }

    public String getPREG_SUSPENSION_TRABAJADOR() {
        return PREG_SUSPENSION_TRABAJADOR;
    }

    public void setPREG_SUSPENSION_TRABAJADOR(String PREG_SUSPENSION_TRABAJADOR) {
        this.PREG_SUSPENSION_TRABAJADOR = PREG_SUSPENSION_TRABAJADOR;
    }

    public String getPREG_SUSPENSION_PATRON() {
        return PREG_SUSPENSION_PATRON;
    }

    public void setPREG_SUSPENSION_PATRON(String PREG_SUSPENSION_PATRON) {
        this.PREG_SUSPENSION_PATRON = PREG_SUSPENSION_PATRON;
    }

    public String getPREG_INDEMNIZACION_PATRON() {
        return PREG_INDEMNIZACION_PATRON;
    }

    public void setPREG_INDEMNIZACION_PATRON(String PREG_INDEMNIZACION_PATRON) {
        this.PREG_INDEMNIZACION_PATRON = PREG_INDEMNIZACION_PATRON;
    }

    public String getPREG_AUTORIZACION_LABORAR() {
        return PREG_AUTORIZACION_LABORAR;
    }

    public void setPREG_AUTORIZACION_LABORAR(String PREG_AUTORIZACION_LABORAR) {
        this.PREG_AUTORIZACION_LABORAR = PREG_AUTORIZACION_LABORAR;
    }

    public String getPREG_RECONOCIMIENTO_TRABAJO() {
        return PREG_RECONOCIMIENTO_TRABAJO;
    }

    public void setPREG_RECONOCIMIENTO_TRABAJO(String PREG_RECONOCIMIENTO_TRABAJO) {
        this.PREG_RECONOCIMIENTO_TRABAJO = PREG_RECONOCIMIENTO_TRABAJO;
    }

    public String getPREG_CAPACITACION() {
        return PREG_CAPACITACION;
    }

    public void setPREG_CAPACITACION(String PREG_CAPACITACION) {
        this.PREG_CAPACITACION = PREG_CAPACITACION;
    }

    public String getPREG_ADIESTRAMIENTO() {
        return PREG_ADIESTRAMIENTO;
    }

    public void setPREG_ADIESTRAMIENTO(String PREG_ADIESTRAMIENTO) {
        this.PREG_ADIESTRAMIENTO = PREG_ADIESTRAMIENTO;
    }

    public String getPREG_NULIDAD_CLAUSULA_CONTRA() {
        return PREG_NULIDAD_CLAUSULA_CONTRA;
    }

    public void setPREG_NULIDAD_CLAUSULA_CONTRA(String PREG_NULIDAD_CLAUSULA_CONTRA) {
        this.PREG_NULIDAD_CLAUSULA_CONTRA = PREG_NULIDAD_CLAUSULA_CONTRA;
    }

    public String getPREG_CONDICIONES_TRABAJO() {
        return PREG_CONDICIONES_TRABAJO;
    }

    public void setPREG_CONDICIONES_TRABAJO(String PREG_CONDICIONES_TRABAJO) {
        this.PREG_CONDICIONES_TRABAJO = PREG_CONDICIONES_TRABAJO;
    }

    public String getPREG_HORAS_EXTRA() {
        return PREG_HORAS_EXTRA;
    }

    public void setPREG_HORAS_EXTRA(String PREG_HORAS_EXTRA) {
        this.PREG_HORAS_EXTRA = PREG_HORAS_EXTRA;
    }

    public String getPREG_HABITACION() {
        return PREG_HABITACION;
    }

    public void setPREG_HABITACION(String PREG_HABITACION) {
        this.PREG_HABITACION = PREG_HABITACION;
    }

    public String getPREG_CREDITOS() {
        return PREG_CREDITOS;
    }

    public void setPREG_CREDITOS(String PREG_CREDITOS) {
        this.PREG_CREDITOS = PREG_CREDITOS;
    }

    public String getPREG_CAPACITACION_ADIESTRAMI() {
        return PREG_CAPACITACION_ADIESTRAMI;
    }

    public void setPREG_CAPACITACION_ADIESTRAMI(String PREG_CAPACITACION_ADIESTRAMI) {
        this.PREG_CAPACITACION_ADIESTRAMI = PREG_CAPACITACION_ADIESTRAMI;
    }

    public String getPREG_PRIMA_ANTIGUEDAD() {
        return PREG_PRIMA_ANTIGUEDAD;
    }

    public void setPREG_PRIMA_ANTIGUEDAD(String PREG_PRIMA_ANTIGUEDAD) {
        this.PREG_PRIMA_ANTIGUEDAD = PREG_PRIMA_ANTIGUEDAD;
    }

    public String getPREG_REGLAMENTO_INTER_TRABAJO() {
        return PREG_REGLAMENTO_INTER_TRABAJO;
    }

    public void setPREG_REGLAMENTO_INTER_TRABAJO(String PREG_REGLAMENTO_INTER_TRABAJO) {
        this.PREG_REGLAMENTO_INTER_TRABAJO = PREG_REGLAMENTO_INTER_TRABAJO;
    }

    public String getPREG_RENTA_MAX_HAB_TRABAJADOR() {
        return PREG_RENTA_MAX_HAB_TRABAJADOR;
    }

    public void setPREG_RENTA_MAX_HAB_TRABAJADOR(String PREG_RENTA_MAX_HAB_TRABAJADOR) {
        this.PREG_RENTA_MAX_HAB_TRABAJADOR = PREG_RENTA_MAX_HAB_TRABAJADOR;
    }

    public String getPREG_OBLIGA_DERIV_RENTA_HAB() {
        return PREG_OBLIGA_DERIV_RENTA_HAB;
    }

    public void setPREG_OBLIGA_DERIV_RENTA_HAB(String PREG_OBLIGA_DERIV_RENTA_HAB) {
        this.PREG_OBLIGA_DERIV_RENTA_HAB = PREG_OBLIGA_DERIV_RENTA_HAB;
    }

    public String getPREG_COBRO_PRESTA_SALARIO() {
        return PREG_COBRO_PRESTA_SALARIO;
    }

    public void setPREG_COBRO_PRESTA_SALARIO(String PREG_COBRO_PRESTA_SALARIO) {
        this.PREG_COBRO_PRESTA_SALARIO = PREG_COBRO_PRESTA_SALARIO;
    }

    public String getPREG_ALOJAMIENTO() {
        return PREG_ALOJAMIENTO;
    }

    public void setPREG_ALOJAMIENTO(String PREG_ALOJAMIENTO) {
        this.PREG_ALOJAMIENTO = PREG_ALOJAMIENTO;
    }

    public String getPREG_SALARIO_BASE_COTIZACION() {
        return PREG_SALARIO_BASE_COTIZACION;
    }

    public void setPREG_SALARIO_BASE_COTIZACION(String PREG_SALARIO_BASE_COTIZACION) {
        this.PREG_SALARIO_BASE_COTIZACION = PREG_SALARIO_BASE_COTIZACION;
    }

    public String getPREG_INCAPACI_PERMA_PARCIAL() {
        return PREG_INCAPACI_PERMA_PARCIAL;
    }

    public void setPREG_INCAPACI_PERMA_PARCIAL(String PREG_INCAPACI_PERMA_PARCIAL) {
        this.PREG_INCAPACI_PERMA_PARCIAL = PREG_INCAPACI_PERMA_PARCIAL;
    }

    public String getPREG_MUERTE() {
        return PREG_MUERTE;
    }

    public void setPREG_MUERTE(String PREG_MUERTE) {
        this.PREG_MUERTE = PREG_MUERTE;
    }

    public String getPREG_PENSION_ASCENDENCIA() {
        return PREG_PENSION_ASCENDENCIA;
    }

    public void setPREG_PENSION_ASCENDENCIA(String PREG_PENSION_ASCENDENCIA) {
        this.PREG_PENSION_ASCENDENCIA = PREG_PENSION_ASCENDENCIA;
    }

    public String getPREG_PENSION_GARANTIZADA() {
        return PREG_PENSION_GARANTIZADA;
    }

    public void setPREG_PENSION_GARANTIZADA(String PREG_PENSION_GARANTIZADA) {
        this.PREG_PENSION_GARANTIZADA = PREG_PENSION_GARANTIZADA;
    }

    public String getPREG_INCRE_PENSION() {
        return PREG_INCRE_PENSION;
    }

    public void setPREG_INCRE_PENSION(String PREG_INCRE_PENSION) {
        this.PREG_INCRE_PENSION = PREG_INCRE_PENSION;
    }

    public String getPREG_INDEMNIZACION_GLOBAL() {
        return PREG_INDEMNIZACION_GLOBAL;
    }

    public void setPREG_INDEMNIZACION_GLOBAL(String PREG_INDEMNIZACION_GLOBAL) {
        this.PREG_INDEMNIZACION_GLOBAL = PREG_INDEMNIZACION_GLOBAL;
    }

    public String getPREG_ASISTENCIA_MEDICA() {
        return PREG_ASISTENCIA_MEDICA;
    }

    public void setPREG_ASISTENCIA_MEDICA(String PREG_ASISTENCIA_MEDICA) {
        this.PREG_ASISTENCIA_MEDICA = PREG_ASISTENCIA_MEDICA;
    }

    public String getPREG_APARATOS_PROT_ORTOP() {
        return PREG_APARATOS_PROT_ORTOP;
    }

    public void setPREG_APARATOS_PROT_ORTOP(String PREG_APARATOS_PROT_ORTOP) {
        this.PREG_APARATOS_PROT_ORTOP = PREG_APARATOS_PROT_ORTOP;
    }

    public String getPREG_RIESGOS_SALARIO_BASE() {
        return PREG_RIESGOS_SALARIO_BASE;
    }

    public void setPREG_RIESGOS_SALARIO_BASE(String PREG_RIESGOS_SALARIO_BASE) {
        this.PREG_RIESGOS_SALARIO_BASE = PREG_RIESGOS_SALARIO_BASE;
    }

    public String getPREG_RIESGOS_PAGO_INDEMNIZA() {
        return PREG_RIESGOS_PAGO_INDEMNIZA;
    }

    public void setPREG_RIESGOS_PAGO_INDEMNIZA(String PREG_RIESGOS_PAGO_INDEMNIZA) {
        this.PREG_RIESGOS_PAGO_INDEMNIZA = PREG_RIESGOS_PAGO_INDEMNIZA;
    }

    public String getPREG_RIESGO_OPOSICION_DESIG() {
        return PREG_RIESGO_OPOSICION_DESIG;
    }

    public void setPREG_RIESGO_OPOSICION_DESIG(String PREG_RIESGO_OPOSICION_DESIG) {
        this.PREG_RIESGO_OPOSICION_DESIG = PREG_RIESGO_OPOSICION_DESIG;
    }

    public String getPREG_DESIGNACION_FALLECIDO() {
        return PREG_DESIGNACION_FALLECIDO;
    }

    public void setPREG_DESIGNACION_FALLECIDO(String PREG_DESIGNACION_FALLECIDO) {
        this.PREG_DESIGNACION_FALLECIDO = PREG_DESIGNACION_FALLECIDO;
    }

    public String getPREG_DESIGNACION_DESAPARECIDO() {
        return PREG_DESIGNACION_DESAPARECIDO;
    }

    public void setPREG_DESIGNACION_DESAPARECIDO(String PREG_DESIGNACION_DESAPARECIDO) {
        this.PREG_DESIGNACION_DESAPARECIDO = PREG_DESIGNACION_DESAPARECIDO;
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

    public String getPREG_AUD_PRELIM_CELEBR() {
        return PREG_AUD_PRELIM_CELEBR;
    }

    public void setPREG_AUD_PRELIM_CELEBR(String PREG_AUD_PRELIM_CELEBR) {
        this.PREG_AUD_PRELIM_CELEBR = PREG_AUD_PRELIM_CELEBR;
    }

    public String getFECHA_AUDIENCIA_PRELIM() {
        return FECHA_AUDIENCIA_PRELIM;
    }

    public void setFECHA_AUDIENCIA_PRELIM(String FECHA_AUDIENCIA_PRELIM) {
        this.FECHA_AUDIENCIA_PRELIM = FECHA_AUDIENCIA_PRELIM;
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

    public String getFECHA_SENTENCIA() {
        return FECHA_SENTENCIA;
    }

    public void setFECHA_SENTENCIA(String FECHA_SENTENCIA) {
        this.FECHA_SENTENCIA = FECHA_SENTENCIA;
    }

    public String getID_SENTIDO_SENTEN() {
        return ID_SENTIDO_SENTEN;
    }

    public void setID_SENTIDO_SENTEN(String ID_SENTIDO_SENTEN) {
        this.ID_SENTIDO_SENTEN = ID_SENTIDO_SENTEN;
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
            getFECHA_APERTURA_EXPED(),
            getID_TIPO_ASUNTO(),
            getID_NAT_CONFLICTO(),
            getRAMA_INVOLUC(),
            getCLAVE_ENTIDAD_ORG(),
            getCLAVE_ENTIDAD_PAT(),
            getCLAVE_MUN_PAT(),
            getPREG_SUBCONTRATACION(),
            getPREG_SUSPENSION_TRABAJADOR(),
            getPREG_SUSPENSION_PATRON(),
            getPREG_INDEMNIZACION_PATRON(),
            getPREG_AUTORIZACION_LABORAR(),
            getPREG_RECONOCIMIENTO_TRABAJO(),
            getPREG_CAPACITACION(),
            getPREG_ADIESTRAMIENTO(),
            getPREG_NULIDAD_CLAUSULA_CONTRA(),
            getPREG_CONDICIONES_TRABAJO(),
            getPREG_HORAS_EXTRA(),
            getPREG_HABITACION(),
            getPREG_CREDITOS(),
            getPREG_CAPACITACION_ADIESTRAMI(),
            getPREG_PRIMA_ANTIGUEDAD(),
            getPREG_REGLAMENTO_INTER_TRABAJO(),
            getPREG_RENTA_MAX_HAB_TRABAJADOR(),
            getPREG_OBLIGA_DERIV_RENTA_HAB(),
            getPREG_COBRO_PRESTA_SALARIO(),
            getPREG_ALOJAMIENTO(),
            getPREG_SALARIO_BASE_COTIZACION(),
            getPREG_INCAPACI_PERMA_PARCIAL(),
            getPREG_MUERTE(),
            getPREG_PENSION_ASCENDENCIA(),
            getPREG_PENSION_GARANTIZADA(),
            getPREG_INCRE_PENSION(),
            getPREG_INDEMNIZACION_GLOBAL(),
            getPREG_ASISTENCIA_MEDICA(),
            getPREG_APARATOS_PROT_ORTOP(),
            getPREG_RIESGOS_SALARIO_BASE(),
            getPREG_RIESGOS_PAGO_INDEMNIZA(),
            getPREG_RIESGO_OPOSICION_DESIG(),
            getPREG_DESIGNACION_FALLECIDO(),
            getPREG_DESIGNACION_DESAPARECIDO(),
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
            getPREG_AUD_PRELIM_CELEBR(),
            getFECHA_AUDIENCIA_PRELIM(),
            getPREG_CELEBRA_AUD_JUICIO(),
            getFECHA_AUD_JUICIO(),
            getID_ESTATUS_EXPED(),
            getFECHA_ULT_ACT_PROC(),
            getID_FASE_SOL_EXPED(),
            getID_FORMA_SOLUCION(),
            getFECHA_DICTO_SOLUCION(),
            getFECHA_SENTENCIA(),
            getID_SENTIDO_SENTEN()
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

    public void FECHA_APERTURA_EXPED(String valor) {
        this.FECHA_APERTURA_EXPED = valor;
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

    public void CLAVE_ENTIDAD_ORG(String valor) {
        this.CLAVE_ENTIDAD_ORG = valor;
    }

    public void CLAVE_ENTIDAD_PAT(String valor) {
        this.CLAVE_ENTIDAD_PAT = valor;
    }

    public void CLAVE_MUN_PAT(String valor) {
        this.CLAVE_MUN_PAT = valor;
    }

    public void PREG_SUBCONTRATACION(String valor) {
        this.PREG_SUBCONTRATACION = valor;
    }

    public void PREG_SUSPENSION_TRABAJADOR(String valor) {
        this.PREG_SUSPENSION_TRABAJADOR = valor;
    }

    public void PREG_SUSPENSION_PATRON(String valor) {
        this.PREG_SUSPENSION_PATRON = valor;
    }

    public void PREG_INDEMNIZACION_PATRON(String valor) {
        this.PREG_INDEMNIZACION_PATRON = valor;
    }

    public void PREG_AUTORIZACION_LABORAR(String valor) {
        this.PREG_AUTORIZACION_LABORAR = valor;
    }

    public void PREG_RECONOCIMIENTO_TRABAJO(String valor) {
        this.PREG_RECONOCIMIENTO_TRABAJO = valor;
    }

    public void PREG_CAPACITACION(String valor) {
        this.PREG_CAPACITACION = valor;
    }

    public void PREG_ADIESTRAMIENTO(String valor) {
        this.PREG_ADIESTRAMIENTO = valor;
    }

    public void PREG_NULIDAD_CLAUSULA_CONTRA(String valor) {
        this.PREG_NULIDAD_CLAUSULA_CONTRA = valor;
    }

    public void PREG_CONDICIONES_TRABAJO(String valor) {
        this.PREG_CONDICIONES_TRABAJO = valor;
    }

    public void PREG_HORAS_EXTRA(String valor) {
        this.PREG_HORAS_EXTRA = valor;
    }

    public void PREG_HABITACION(String valor) {
        this.PREG_HABITACION = valor;
    }

    public void PREG_CREDITOS(String valor) {
        this.PREG_CREDITOS = valor;
    }

    public void PREG_CAPACITACION_ADIESTRAMI(String valor) {
        this.PREG_CAPACITACION_ADIESTRAMI = valor;
    }

    public void PREG_PRIMA_ANTIGUEDAD(String valor) {
        this.PREG_PRIMA_ANTIGUEDAD = valor;
    }

    public void PREG_REGLAMENTO_INTER_TRABAJO(String valor) {
        this.PREG_REGLAMENTO_INTER_TRABAJO = valor;
    }

    public void PREG_RENTA_MAX_HAB_TRABAJADOR(String valor) {
        this.PREG_RENTA_MAX_HAB_TRABAJADOR = valor;
    }

    public void PREG_OBLIGA_DERIV_RENTA_HAB(String valor) {
        this.PREG_OBLIGA_DERIV_RENTA_HAB = valor;
    }

    public void PREG_COBRO_PRESTA_SALARIO(String valor) {
        this.PREG_COBRO_PRESTA_SALARIO = valor;
    }

    public void PREG_ALOJAMIENTO(String valor) {
        this.PREG_ALOJAMIENTO = valor;
    }

    public void PREG_SALARIO_BASE_COTIZACION(String valor) {
        this.PREG_SALARIO_BASE_COTIZACION = valor;
    }

    public void PREG_INCAPACI_PERMA_PARCIAL(String valor) {
        this.PREG_INCAPACI_PERMA_PARCIAL = valor;
    }

    public void PREG_MUERTE(String valor) {
        this.PREG_MUERTE = valor;
    }

    public void PREG_PENSION_ASCENDENCIA(String valor) {
        this.PREG_PENSION_ASCENDENCIA = valor;
    }

    public void PREG_PENSION_GARANTIZADA(String valor) {
        this.PREG_PENSION_GARANTIZADA = valor;
    }

    public void PREG_INCRE_PENSION(String valor) {
        this.PREG_INCRE_PENSION = valor;
    }

    public void PREG_INDEMNIZACION_GLOBAL(String valor) {
        this.PREG_INDEMNIZACION_GLOBAL = valor;
    }

    public void PREG_ASISTENCIA_MEDICA(String valor) {
        this.PREG_ASISTENCIA_MEDICA = valor;
    }

    public void PREG_APARATOS_PROT_ORTOP(String valor) {
        this.PREG_APARATOS_PROT_ORTOP = valor;
    }

    public void PREG_RIESGOS_SALARIO_BASE(String valor) {
        this.PREG_RIESGOS_SALARIO_BASE = valor;
    }

    public void PREG_RIESGOS_PAGO_INDEMNIZA(String valor) {
        this.PREG_RIESGOS_PAGO_INDEMNIZA = valor;
    }

    public void PREG_RIESGO_OPOSICION_DESIG(String valor) {
        this.PREG_RIESGO_OPOSICION_DESIG = valor;
    }

    public void PREG_DESIGNACION_FALLECIDO(String valor) {
        this.PREG_DESIGNACION_FALLECIDO = valor;
    }

    public void PREG_DESIGNACION_DESAPARECIDO(String valor) {
        this.PREG_DESIGNACION_DESAPARECIDO = valor;
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

    public void PREG_AUD_PRELIM_CELEBR(String valor) {
        this.PREG_AUD_PRELIM_CELEBR = valor;
    }

    public void FECHA_AUDIENCIA_PRELIM(String valor) {
        this.FECHA_AUDIENCIA_PRELIM = valor;
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

    public void FECHA_SENTENCIA(String valor) {
        this.FECHA_SENTENCIA = valor;
    }

    public void ID_SENTIDO_SENTEN(String valor) {
        this.ID_SENTIDO_SENTEN = valor;
    }

}
