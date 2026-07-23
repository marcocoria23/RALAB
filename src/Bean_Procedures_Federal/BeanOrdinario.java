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
public class BeanOrdinario extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPED;
    private String ID_TIPO_ASUNTO;
    private String ID_NAT_CONFLICTO;
    private String RAMA_INVOLUC;
    private String SECTOR;
    private String SUBSECTOR;
    private String CLAVE_ENTIDAD_ORG;
    private String CLAVE_ENTIDAD_PAT;
    private String CLAVE_ENTIDAD_MUN;
    private String PREG_SUBCONTRATACION;
    private String PREG_SALARIOS_VEN;
    private String PREG_REINSTALACION;
    private String PREG_PAGO_INDEM;
    private String PREG_TERMINA_RELA_LAB;
    private String PREG_DEPOSITO_INDEM;
    private String PREG_RESPONS_CONFLIC;
    private String PREG_NULIDAD_RENUN;
    private String PREG_RESOSITO_RESPO;
    private String PREG_RELA_TRAB;
    private String PREG_NULIDAD_LIQUI;
    private String PREG_RATIF_CONVEN;
    private String PREG_RESPONS_PATRON;
    private String PREG_VACACIONES;
    private String PREG_PRIMA_VACACIONAL;
    private String PREG_AGUINALDO;
    private String PREG_SALARIO;
    private String PREG_PRIMA_ANTIGUEDAD;
    private String PREG_HORAS_EXTRA;
    private String PREG_RECONO_ANTIGUEDAD;
    private String PREG_DIAS_DESCANSO;
    private String PREG_DERECHO_PREF;
    private String PREG_BONOS;
    private String PREG_GRATIFICA;
    private String PREG_OCUPACION_VACAN;
    private String PREG_COMISIONES;
    private String PREG_DESCUENTO;
    private String PREG_ASCENSO;
    private String PREG_DESCANSO;
    private String PREG_RECIBO_PAGO;
    private String PREG_AFILACION;
    private String PREG_ESCUELAS;
    private String PREG_PROPINA;
    private String PREG_INVENCIONES;
    private String PREG_RELACION_TRAB;
    private String PREG_DIVERSO_DOC;
    private String PREG_BASE_ANTIGUEDAD;
    private String PREG_RENIVELACION;
    private String PREG_SUSTI_PATRON;
    private String PREG_MUERTE;
    private String PREG_INCRE_PENSION;
    private String PREG_RETIRO;
    private String PREG_VIDA;
    private String PREG_ENFERMEDADES;
    private String PREG_VEJEZ;
    private String PREG_RETORNO_PUESTO;
    private String PREG_PAGO_SALARIO;
    private String PREG_TRAB_CONS;
    private String PREG_ANT_PRE;
    private String PREG_LABORES_PEL;
    private String PREG_DESCANSO_SEMANAS;
    private String PREG_PRORROGA;
    private String PREG_ALIMENTACION;
    private String PREG_ACTOS;
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

    public String getCLAVE_ENTIDAD_MUN() {
        return CLAVE_ENTIDAD_MUN;
    }

    public void setCLAVE_ENTIDAD_MUN(String CLAVE_ENTIDAD_MUN) {
        this.CLAVE_ENTIDAD_MUN = CLAVE_ENTIDAD_MUN;
    }

    public String getPREG_SUBCONTRATACION() {
        return PREG_SUBCONTRATACION;
    }

    public void setPREG_SUBCONTRATACION(String PREG_SUBCONTRATACION) {
        this.PREG_SUBCONTRATACION = PREG_SUBCONTRATACION;
    }

    public String getPREG_SALARIOS_VEN() {
        return PREG_SALARIOS_VEN;
    }

    public void setPREG_SALARIOS_VEN(String PREG_SALARIOS_VEN) {
        this.PREG_SALARIOS_VEN = PREG_SALARIOS_VEN;
    }

    public String getPREG_REINSTALACION() {
        return PREG_REINSTALACION;
    }

    public void setPREG_REINSTALACION(String PREG_REINSTALACION) {
        this.PREG_REINSTALACION = PREG_REINSTALACION;
    }

    public String getPREG_PAGO_INDEM() {
        return PREG_PAGO_INDEM;
    }

    public void setPREG_PAGO_INDEM(String PREG_PAGO_INDEM) {
        this.PREG_PAGO_INDEM = PREG_PAGO_INDEM;
    }

    public String getPREG_TERMINA_RELA_LAB() {
        return PREG_TERMINA_RELA_LAB;
    }

    public void setPREG_TERMINA_RELA_LAB(String PREG_TERMINA_RELA_LAB) {
        this.PREG_TERMINA_RELA_LAB = PREG_TERMINA_RELA_LAB;
    }

    public String getPREG_DEPOSITO_INDEM() {
        return PREG_DEPOSITO_INDEM;
    }

    public void setPREG_DEPOSITO_INDEM(String PREG_DEPOSITO_INDEM) {
        this.PREG_DEPOSITO_INDEM = PREG_DEPOSITO_INDEM;
    }

    public String getPREG_RESPONS_CONFLIC() {
        return PREG_RESPONS_CONFLIC;
    }

    public void setPREG_RESPONS_CONFLIC(String PREG_RESPONS_CONFLIC) {
        this.PREG_RESPONS_CONFLIC = PREG_RESPONS_CONFLIC;
    }

    public String getPREG_NULIDAD_RENUN() {
        return PREG_NULIDAD_RENUN;
    }

    public void setPREG_NULIDAD_RENUN(String PREG_NULIDAD_RENUN) {
        this.PREG_NULIDAD_RENUN = PREG_NULIDAD_RENUN;
    }

    public String getPREG_RESOSITO_RESPO() {
        return PREG_RESOSITO_RESPO;
    }

    public void setPREG_RESOSITO_RESPO(String PREG_RESOSITO_RESPO) {
        this.PREG_RESOSITO_RESPO = PREG_RESOSITO_RESPO;
    }

    public String getPREG_RELA_TRAB() {
        return PREG_RELA_TRAB;
    }

    public void setPREG_RELA_TRAB(String PREG_RELA_TRAB) {
        this.PREG_RELA_TRAB = PREG_RELA_TRAB;
    }

    public String getPREG_NULIDAD_LIQUI() {
        return PREG_NULIDAD_LIQUI;
    }

    public void setPREG_NULIDAD_LIQUI(String PREG_NULIDAD_LIQUI) {
        this.PREG_NULIDAD_LIQUI = PREG_NULIDAD_LIQUI;
    }

    public String getPREG_RATIF_CONVEN() {
        return PREG_RATIF_CONVEN;
    }

    public void setPREG_RATIF_CONVEN(String PREG_RATIF_CONVEN) {
        this.PREG_RATIF_CONVEN = PREG_RATIF_CONVEN;
    }

    public String getPREG_RESPONS_PATRON() {
        return PREG_RESPONS_PATRON;
    }

    public void setPREG_RESPONS_PATRON(String PREG_RESPONS_PATRON) {
        this.PREG_RESPONS_PATRON = PREG_RESPONS_PATRON;
    }

    public String getPREG_VACACIONES() {
        return PREG_VACACIONES;
    }

    public void setPREG_VACACIONES(String PREG_VACACIONES) {
        this.PREG_VACACIONES = PREG_VACACIONES;
    }

    public String getPREG_PRIMA_VACACIONAL() {
        return PREG_PRIMA_VACACIONAL;
    }

    public void setPREG_PRIMA_VACACIONAL(String PREG_PRIMA_VACACIONAL) {
        this.PREG_PRIMA_VACACIONAL = PREG_PRIMA_VACACIONAL;
    }

    public String getPREG_AGUINALDO() {
        return PREG_AGUINALDO;
    }

    public void setPREG_AGUINALDO(String PREG_AGUINALDO) {
        this.PREG_AGUINALDO = PREG_AGUINALDO;
    }

    public String getPREG_SALARIO() {
        return PREG_SALARIO;
    }

    public void setPREG_SALARIO(String PREG_SALARIO) {
        this.PREG_SALARIO = PREG_SALARIO;
    }

    public String getPREG_PRIMA_ANTIGUEDAD() {
        return PREG_PRIMA_ANTIGUEDAD;
    }

    public void setPREG_PRIMA_ANTIGUEDAD(String PREG_PRIMA_ANTIGUEDAD) {
        this.PREG_PRIMA_ANTIGUEDAD = PREG_PRIMA_ANTIGUEDAD;
    }

    public String getPREG_HORAS_EXTRA() {
        return PREG_HORAS_EXTRA;
    }

    public void setPREG_HORAS_EXTRA(String PREG_HORAS_EXTRA) {
        this.PREG_HORAS_EXTRA = PREG_HORAS_EXTRA;
    }

    public String getPREG_RECONO_ANTIGUEDAD() {
        return PREG_RECONO_ANTIGUEDAD;
    }

    public void setPREG_RECONO_ANTIGUEDAD(String PREG_RECONO_ANTIGUEDAD) {
        this.PREG_RECONO_ANTIGUEDAD = PREG_RECONO_ANTIGUEDAD;
    }

    public String getPREG_DIAS_DESCANSO() {
        return PREG_DIAS_DESCANSO;
    }

    public void setPREG_DIAS_DESCANSO(String PREG_DIAS_DESCANSO) {
        this.PREG_DIAS_DESCANSO = PREG_DIAS_DESCANSO;
    }

    public String getPREG_DERECHO_PREF() {
        return PREG_DERECHO_PREF;
    }

    public void setPREG_DERECHO_PREF(String PREG_DERECHO_PREF) {
        this.PREG_DERECHO_PREF = PREG_DERECHO_PREF;
    }

    public String getPREG_BONOS() {
        return PREG_BONOS;
    }

    public void setPREG_BONOS(String PREG_BONOS) {
        this.PREG_BONOS = PREG_BONOS;
    }

    public String getPREG_GRATIFICA() {
        return PREG_GRATIFICA;
    }

    public void setPREG_GRATIFICA(String PREG_GRATIFICA) {
        this.PREG_GRATIFICA = PREG_GRATIFICA;
    }

    public String getPREG_OCUPACION_VACAN() {
        return PREG_OCUPACION_VACAN;
    }

    public void setPREG_OCUPACION_VACAN(String PREG_OCUPACION_VACAN) {
        this.PREG_OCUPACION_VACAN = PREG_OCUPACION_VACAN;
    }

    public String getPREG_COMISIONES() {
        return PREG_COMISIONES;
    }

    public void setPREG_COMISIONES(String PREG_COMISIONES) {
        this.PREG_COMISIONES = PREG_COMISIONES;
    }

    public String getPREG_DESCUENTO() {
        return PREG_DESCUENTO;
    }

    public void setPREG_DESCUENTO(String PREG_DESCUENTO) {
        this.PREG_DESCUENTO = PREG_DESCUENTO;
    }

    public String getPREG_ASCENSO() {
        return PREG_ASCENSO;
    }

    public void setPREG_ASCENSO(String PREG_ASCENSO) {
        this.PREG_ASCENSO = PREG_ASCENSO;
    }

    public String getPREG_DESCANSO() {
        return PREG_DESCANSO;
    }

    public void setPREG_DESCANSO(String PREG_DESCANSO) {
        this.PREG_DESCANSO = PREG_DESCANSO;
    }

    public String getPREG_RECIBO_PAGO() {
        return PREG_RECIBO_PAGO;
    }

    public void setPREG_RECIBO_PAGO(String PREG_RECIBO_PAGO) {
        this.PREG_RECIBO_PAGO = PREG_RECIBO_PAGO;
    }

    public String getPREG_AFILACION() {
        return PREG_AFILACION;
    }

    public void setPREG_AFILACION(String PREG_AFILACION) {
        this.PREG_AFILACION = PREG_AFILACION;
    }

    public String getPREG_ESCUELAS() {
        return PREG_ESCUELAS;
    }

    public void setPREG_ESCUELAS(String PREG_ESCUELAS) {
        this.PREG_ESCUELAS = PREG_ESCUELAS;
    }

    public String getPREG_PROPINA() {
        return PREG_PROPINA;
    }

    public void setPREG_PROPINA(String PREG_PROPINA) {
        this.PREG_PROPINA = PREG_PROPINA;
    }

    public String getPREG_INVENCIONES() {
        return PREG_INVENCIONES;
    }

    public void setPREG_INVENCIONES(String PREG_INVENCIONES) {
        this.PREG_INVENCIONES = PREG_INVENCIONES;
    }

    public String getPREG_RELACION_TRAB() {
        return PREG_RELACION_TRAB;
    }

    public void setPREG_RELACION_TRAB(String PREG_RELACION_TRAB) {
        this.PREG_RELACION_TRAB = PREG_RELACION_TRAB;
    }

    public String getPREG_DIVERSO_DOC() {
        return PREG_DIVERSO_DOC;
    }

    public void setPREG_DIVERSO_DOC(String PREG_DIVERSO_DOC) {
        this.PREG_DIVERSO_DOC = PREG_DIVERSO_DOC;
    }

    public String getPREG_BASE_ANTIGUEDAD() {
        return PREG_BASE_ANTIGUEDAD;
    }

    public void setPREG_BASE_ANTIGUEDAD(String PREG_BASE_ANTIGUEDAD) {
        this.PREG_BASE_ANTIGUEDAD = PREG_BASE_ANTIGUEDAD;
    }

    public String getPREG_RENIVELACION() {
        return PREG_RENIVELACION;
    }

    public void setPREG_RENIVELACION(String PREG_RENIVELACION) {
        this.PREG_RENIVELACION = PREG_RENIVELACION;
    }

    public String getPREG_SUSTI_PATRON() {
        return PREG_SUSTI_PATRON;
    }

    public void setPREG_SUSTI_PATRON(String PREG_SUSTI_PATRON) {
        this.PREG_SUSTI_PATRON = PREG_SUSTI_PATRON;
    }

    public String getPREG_MUERTE() {
        return PREG_MUERTE;
    }

    public void setPREG_MUERTE(String PREG_MUERTE) {
        this.PREG_MUERTE = PREG_MUERTE;
    }

    public String getPREG_INCRE_PENSION() {
        return PREG_INCRE_PENSION;
    }

    public void setPREG_INCRE_PENSION(String PREG_INCRE_PENSION) {
        this.PREG_INCRE_PENSION = PREG_INCRE_PENSION;
    }

    public String getPREG_RETIRO() {
        return PREG_RETIRO;
    }

    public void setPREG_RETIRO(String PREG_RETIRO) {
        this.PREG_RETIRO = PREG_RETIRO;
    }

    public String getPREG_VIDA() {
        return PREG_VIDA;
    }

    public void setPREG_VIDA(String PREG_VIDA) {
        this.PREG_VIDA = PREG_VIDA;
    }

    public String getPREG_ENFERMEDADES() {
        return PREG_ENFERMEDADES;
    }

    public void setPREG_ENFERMEDADES(String PREG_ENFERMEDADES) {
        this.PREG_ENFERMEDADES = PREG_ENFERMEDADES;
    }

    public String getPREG_VEJEZ() {
        return PREG_VEJEZ;
    }

    public void setPREG_VEJEZ(String PREG_VEJEZ) {
        this.PREG_VEJEZ = PREG_VEJEZ;
    }

    public String getPREG_RETORNO_PUESTO() {
        return PREG_RETORNO_PUESTO;
    }

    public void setPREG_RETORNO_PUESTO(String PREG_RETORNO_PUESTO) {
        this.PREG_RETORNO_PUESTO = PREG_RETORNO_PUESTO;
    }

    public String getPREG_PAGO_SALARIO() {
        return PREG_PAGO_SALARIO;
    }

    public void setPREG_PAGO_SALARIO(String PREG_PAGO_SALARIO) {
        this.PREG_PAGO_SALARIO = PREG_PAGO_SALARIO;
    }

    public String getPREG_TRAB_CONS() {
        return PREG_TRAB_CONS;
    }

    public void setPREG_TRAB_CONS(String PREG_TRAB_CONS) {
        this.PREG_TRAB_CONS = PREG_TRAB_CONS;
    }

    public String getPREG_ANT_PRE() {
        return PREG_ANT_PRE;
    }

    public void setPREG_ANT_PRE(String PREG_ANT_PRE) {
        this.PREG_ANT_PRE = PREG_ANT_PRE;
    }

    public String getPREG_LABORES_PEL() {
        return PREG_LABORES_PEL;
    }

    public void setPREG_LABORES_PEL(String PREG_LABORES_PEL) {
        this.PREG_LABORES_PEL = PREG_LABORES_PEL;
    }

    public String getPREG_DESCANSO_SEMANAS() {
        return PREG_DESCANSO_SEMANAS;
    }

    public void setPREG_DESCANSO_SEMANAS(String PREG_DESCANSO_SEMANAS) {
        this.PREG_DESCANSO_SEMANAS = PREG_DESCANSO_SEMANAS;
    }

    public String getPREG_PRORROGA() {
        return PREG_PRORROGA;
    }

    public void setPREG_PRORROGA(String PREG_PRORROGA) {
        this.PREG_PRORROGA = PREG_PRORROGA;
    }

    public String getPREG_ALIMENTACION() {
        return PREG_ALIMENTACION;
    }

    public void setPREG_ALIMENTACION(String PREG_ALIMENTACION) {
        this.PREG_ALIMENTACION = PREG_ALIMENTACION;
    }

    public String getPREG_ACTOS() {
        return PREG_ACTOS;
    }

    public void setPREG_ACTOS(String PREG_ACTOS) {
        this.PREG_ACTOS = PREG_ACTOS;
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
            getSECTOR(),
            getSUBSECTOR(),
            getCLAVE_ENTIDAD_ORG(),
            getCLAVE_ENTIDAD_PAT(),
            getCLAVE_ENTIDAD_MUN(),
            getPREG_SUBCONTRATACION(),
            getPREG_SALARIOS_VEN(),
            getPREG_REINSTALACION(),
            getPREG_PAGO_INDEM(),
            getPREG_TERMINA_RELA_LAB(),
            getPREG_DEPOSITO_INDEM(),
            getPREG_RESPONS_CONFLIC(),
            getPREG_NULIDAD_RENUN(),
            getPREG_RESOSITO_RESPO(),
            getPREG_RELA_TRAB(),
            getPREG_NULIDAD_LIQUI(),
            getPREG_RATIF_CONVEN(),
            getPREG_RESPONS_PATRON(),
            getPREG_VACACIONES(),
            getPREG_PRIMA_VACACIONAL(),
            getPREG_AGUINALDO(),
            getPREG_SALARIO(),
            getPREG_PRIMA_ANTIGUEDAD(),
            getPREG_HORAS_EXTRA(),
            getPREG_RECONO_ANTIGUEDAD(),
            getPREG_DIAS_DESCANSO(),
            getPREG_DERECHO_PREF(),
            getPREG_BONOS(),
            getPREG_GRATIFICA(),
            getPREG_OCUPACION_VACAN(),
            getPREG_COMISIONES(),
            getPREG_DESCUENTO(),
            getPREG_ASCENSO(),
            getPREG_DESCANSO(),
            getPREG_RECIBO_PAGO(),
            getPREG_AFILACION(),
            getPREG_ESCUELAS(),
            getPREG_PROPINA(),
            getPREG_INVENCIONES(),
            getPREG_RELACION_TRAB(),
            getPREG_DIVERSO_DOC(),
            getPREG_BASE_ANTIGUEDAD(),
            getPREG_RENIVELACION(),
            getPREG_SUSTI_PATRON(),
            getPREG_MUERTE(),
            getPREG_INCRE_PENSION(),
            getPREG_RETIRO(),
            getPREG_VIDA(),
            getPREG_ENFERMEDADES(),
            getPREG_VEJEZ(),
            getPREG_RETORNO_PUESTO(),
            getPREG_PAGO_SALARIO(),
            getPREG_TRAB_CONS(),
            getPREG_ANT_PRE(),
            getPREG_LABORES_PEL(),
            getPREG_DESCANSO_SEMANAS(),
            getPREG_PRORROGA(),
            getPREG_ALIMENTACION(),
            getPREG_ACTOS(),
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

    public void SECTOR(String valor) {
        this.SECTOR = valor;
    }

    public void SUBSECTOR(String valor) {
        this.SUBSECTOR = valor;
    }

    public void CLAVE_ENTIDAD_ORG(String valor) {
        this.CLAVE_ENTIDAD_ORG = valor;
    }

    public void CLAVE_ENTIDAD_PAT(String valor) {
        this.CLAVE_ENTIDAD_PAT = valor;
    }

    public void CLAVE_ENTIDAD_MUN(String valor) {
        this.CLAVE_ENTIDAD_MUN = valor;
    }

    public void PREG_SUBCONTRATACION(String valor) {
        this.PREG_SUBCONTRATACION = valor;
    }

    public void PREG_SALARIOS_VEN(String valor) {
        this.PREG_SALARIOS_VEN = valor;
    }

    public void PREG_REINSTALACION(String valor) {
        this.PREG_REINSTALACION = valor;
    }

    public void PREG_PAGO_INDEM(String valor) {
        this.PREG_PAGO_INDEM = valor;
    }

    public void PREG_TERMINA_RELA_LAB(String valor) {
        this.PREG_TERMINA_RELA_LAB = valor;
    }

    public void PREG_DEPOSITO_INDEM(String valor) {
        this.PREG_DEPOSITO_INDEM = valor;
    }

    public void PREG_RESPONS_CONFLIC(String valor) {
        this.PREG_RESPONS_CONFLIC = valor;
    }

    public void PREG_NULIDAD_RENUN(String valor) {
        this.PREG_NULIDAD_RENUN = valor;
    }

    public void PREG_RESOSITO_RESPO(String valor) {
        this.PREG_RESOSITO_RESPO = valor;
    }

    public void PREG_RELA_TRAB(String valor) {
        this.PREG_RELA_TRAB = valor;
    }

    public void PREG_NULIDAD_LIQUI(String valor) {
        this.PREG_NULIDAD_LIQUI = valor;
    }

    public void PREG_RATIF_CONVEN(String valor) {
        this.PREG_RATIF_CONVEN = valor;
    }

    public void PREG_RESPONS_PATRON(String valor) {
        this.PREG_RESPONS_PATRON = valor;
    }

    public void PREG_VACACIONES(String valor) {
        this.PREG_VACACIONES = valor;
    }

    public void PREG_PRIMA_VACACIONAL(String valor) {
        this.PREG_PRIMA_VACACIONAL = valor;
    }

    public void PREG_AGUINALDO(String valor) {
        this.PREG_AGUINALDO = valor;
    }

    public void PREG_SALARIO(String valor) {
        this.PREG_SALARIO = valor;
    }

    public void PREG_PRIMA_ANTIGUEDAD(String valor) {
        this.PREG_PRIMA_ANTIGUEDAD = valor;
    }

    public void PREG_HORAS_EXTRA(String valor) {
        this.PREG_HORAS_EXTRA = valor;
    }

    public void PREG_RECONO_ANTIGUEDAD(String valor) {
        this.PREG_RECONO_ANTIGUEDAD = valor;
    }

    public void PREG_DIAS_DESCANSO(String valor) {
        this.PREG_DIAS_DESCANSO = valor;
    }

    public void PREG_DERECHO_PREF(String valor) {
        this.PREG_DERECHO_PREF = valor;
    }

    public void PREG_BONOS(String valor) {
        this.PREG_BONOS = valor;
    }

    public void PREG_GRATIFICA(String valor) {
        this.PREG_GRATIFICA = valor;
    }

    public void PREG_OCUPACION_VACAN(String valor) {
        this.PREG_OCUPACION_VACAN = valor;
    }

    public void PREG_COMISIONES(String valor) {
        this.PREG_COMISIONES = valor;
    }

    public void PREG_DESCUENTO(String valor) {
        this.PREG_DESCUENTO = valor;
    }

    public void PREG_ASCENSO(String valor) {
        this.PREG_ASCENSO = valor;
    }

    public void PREG_DESCANSO(String valor) {
        this.PREG_DESCANSO = valor;
    }

    public void PREG_RECIBO_PAGO(String valor) {
        this.PREG_RECIBO_PAGO = valor;
    }

    public void PREG_AFILACION(String valor) {
        this.PREG_AFILACION = valor;
    }

    public void PREG_ESCUELAS(String valor) {
        this.PREG_ESCUELAS = valor;
    }

    public void PREG_PROPINA(String valor) {
        this.PREG_PROPINA = valor;
    }

    public void PREG_INVENCIONES(String valor) {
        this.PREG_INVENCIONES = valor;
    }

    public void PREG_RELACION_TRAB(String valor) {
        this.PREG_RELACION_TRAB = valor;
    }

    public void PREG_DIVERSO_DOC(String valor) {
        this.PREG_DIVERSO_DOC = valor;
    }

    public void PREG_BASE_ANTIGUEDAD(String valor) {
        this.PREG_BASE_ANTIGUEDAD = valor;
    }

    public void PREG_RENIVELACION(String valor) {
        this.PREG_RENIVELACION = valor;
    }

    public void PREG_SUSTI_PATRON(String valor) {
        this.PREG_SUSTI_PATRON = valor;
    }

    public void PREG_MUERTE(String valor) {
        this.PREG_MUERTE = valor;
    }

    public void PREG_INCRE_PENSION(String valor) {
        this.PREG_INCRE_PENSION = valor;
    }

    public void PREG_RETIRO(String valor) {
        this.PREG_RETIRO = valor;
    }

    public void PREG_VIDA(String valor) {
        this.PREG_VIDA = valor;
    }

    public void PREG_ENFERMEDADES(String valor) {
        this.PREG_ENFERMEDADES = valor;
    }

    public void PREG_VEJEZ(String valor) {
        this.PREG_VEJEZ = valor;
    }

    public void PREG_RETORNO_PUESTO(String valor) {
        this.PREG_RETORNO_PUESTO = valor;
    }

    public void PREG_PAGO_SALARIO(String valor) {
        this.PREG_PAGO_SALARIO = valor;
    }

    public void PREG_TRAB_CONS(String valor) {
        this.PREG_TRAB_CONS = valor;
    }

    public void PREG_ANT_PRE(String valor) {
        this.PREG_ANT_PRE = valor;
    }

    public void PREG_LABORES_PEL(String valor) {
        this.PREG_LABORES_PEL = valor;
    }

    public void PREG_DESCANSO_SEMANAS(String valor) {
        this.PREG_DESCANSO_SEMANAS = valor;
    }

    public void PREG_PRORROGA(String valor) {
        this.PREG_PRORROGA = valor;
    }

    public void PREG_ALIMENTACION(String valor) {
        this.PREG_ALIMENTACION = valor;
    }

    public void PREG_ACTOS(String valor) {
        this.PREG_ACTOS = valor;
    }

    public void PREG_INCOMPETENCIA(String valor) {
        this.PREG_INCOMPETENCIA = valor;
    }

    public void ID_TIPO_INCOMPETENCIA(String valor) {
        this.ID_TIPO_INCOMPETENCIA = valor;
    }

    public void PREG_CONSTANCIA(String valor) {
        this.PREG_CONSTANCIA = valor;
    }

    public void FECHA_PRESENTACION(String valor) {
        this.FECHA_PRESENTACION = valor;
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
