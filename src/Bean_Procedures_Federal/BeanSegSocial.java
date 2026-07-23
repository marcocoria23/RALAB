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
public class BeanSegSocial extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String ID_ORGANOJ;
    private String CLAVE_EXPEDIENTE;
    private String FECHA_APERTURA_EXPEDIENTE;
    private String ID_TIPO_ASUNTO;
    private String ID_NAT_CONFLICTO;
    private String RAMA_INVOLUC;
    private String ENTIDAD_CLAVE_ORG;
    private String ENTIDAD_CLAVE;
    private String MUNICIPIO_CLAVE;
    private String PREG_PRIMADOMINICAL;
    private String PREG_COMISIONES;
    private String PREG_PRESTACIONESENESPECIE;
    private String PREG_GRATIFICACIONES;
    private String PREG_BONOS;
    private String PREG_CREDITOS;
    private String PREG_RECONOCIMIENTODEANTIGUEDA;
    private String PREG_INSCRIPCIONENELIMSS;
    private String PREG_INSCRIPCIONENINFONAVIT;
    private String PREG_BAJAENELIMSS;
    private String PREG_BAJAENELINFONAVIT;
    private String PREG_CUOTASOBREROPATRONALES;
    private String PREG_RIESGOSDETRABAJO;
    private String PREG_PREVENCIONDERIESGOSDETRAB;
    private String PREG_ENFERMEDADES;
    private String PREG_MATERNIDAD;
    private String PREG_INVALIDEZ;
    private String PREG_VIDA;
    private String PREG_RETIRO;
    private String PREG_CESANTIAENEDADAVANZADA;
    private String PREG_VEJEZ;
    private String PREG_GUARDERIA;
    private String PREG_PRESTACIONESSOCIALES;
    private String PREG_SALARIOBASEDECOTIZACION;
    private String PREG_INCAPACIDADTEMPORAL;
    private String PREG_INCAPACIDADPERMANENTETOTA;
    private String PREG_INCAPACIDADPERMANENTEPARC;
    private String PREG_MUERTE;
    private String PREG_PENSIONPORINVALIDEZ;
    private String PREG_PENSIONPORVIUDEZ;
    private String PREG_PENSIONPORORFANDAD;
    private String PREG_PENSIONPORASCENDENCIA;
    private String PREG_PENSIONGARANTIZADA;
    private String PREG_INCREMENTODEPENSION;
    private String PREG_INDEMNIZACIONGLOBAL;
    private String PREG_RECONOCIMIENTODEBENEFICIA;
    private String PREG_ASISTENCIAMEDICAQUIRURGIC;
    private String PREG_SERVICIODEHOSPITALIZACION;
    private String PREG_APARATOSDEPROTESISYORTOPE;
    private String PREG_REHABILITACION;
    private String PREG_ASISTENCIAOBSTETRICA;
    private String PREG_CANASTILLA;
    private String PREG_SUBSIDIOENDINERO;
    private String PREG_CONSERVACIONDEDERECHO;
    private String PREG_ASIGNACIONESFAMILIARES;
    private String PREG_AYUDAASISTENCIAL;
    private String PREG_RETIRODEFONDOSDELACUENTAI;
    private String PREG_APORTACIONESVOLUNTARIASAL;
    private String PREG_CONTINUACIONVOLUNTARIAALR;
    private String PREG_INCORPORACIONVOLUNTARIAAL;
    private String PREG_APORTACIONESALINFONAVIT;
    private String PREG_DESCUENTOSDESTINADOSALPAG;
    private String PREG_RIESGOSDETRABAJOSALARIOB;
    private String PREG_DESIGNACIONDEBENEFICIARIO;
    private String PREG_ADMINISTRADORASDEFONDOSPA;
    private String PREG_PRESTDESEGURIDADSODEC;
    private String PREG_PRESTDESEGURIDADSOLEY;
    private String PREG_LIBERACIONDECREDITOHIPOTE;
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

    public String getENTIDAD_CLAVE_ORG() {
        return ENTIDAD_CLAVE_ORG;
    }

    public void setENTIDAD_CLAVE_ORG(String ENTIDAD_CLAVE_ORG) {
        this.ENTIDAD_CLAVE_ORG = ENTIDAD_CLAVE_ORG;
    }

    public String getENTIDAD_CLAVE() {
        return ENTIDAD_CLAVE;
    }

    public void setENTIDAD_CLAVE(String ENTIDAD_CLAVE) {
        this.ENTIDAD_CLAVE = ENTIDAD_CLAVE;
    }

    public String getMUNICIPIO_CLAVE() {
        return MUNICIPIO_CLAVE;
    }

    public void setMUNICIPIO_CLAVE(String MUNICIPIO_CLAVE) {
        this.MUNICIPIO_CLAVE = MUNICIPIO_CLAVE;
    }

    public String getPREG_PRIMADOMINICAL() {
        return PREG_PRIMADOMINICAL;
    }

    public void setPREG_PRIMADOMINICAL(String PREG_PRIMADOMINICAL) {
        this.PREG_PRIMADOMINICAL = PREG_PRIMADOMINICAL;
    }

    public String getPREG_COMISIONES() {
        return PREG_COMISIONES;
    }

    public void setPREG_COMISIONES(String PREG_COMISIONES) {
        this.PREG_COMISIONES = PREG_COMISIONES;
    }

    public String getPREG_PRESTACIONESENESPECIE() {
        return PREG_PRESTACIONESENESPECIE;
    }

    public void setPREG_PRESTACIONESENESPECIE(String PREG_PRESTACIONESENESPECIE) {
        this.PREG_PRESTACIONESENESPECIE = PREG_PRESTACIONESENESPECIE;
    }

    public String getPREG_GRATIFICACIONES() {
        return PREG_GRATIFICACIONES;
    }

    public void setPREG_GRATIFICACIONES(String PREG_GRATIFICACIONES) {
        this.PREG_GRATIFICACIONES = PREG_GRATIFICACIONES;
    }

    public String getPREG_BONOS() {
        return PREG_BONOS;
    }

    public void setPREG_BONOS(String PREG_BONOS) {
        this.PREG_BONOS = PREG_BONOS;
    }

    public String getPREG_CREDITOS() {
        return PREG_CREDITOS;
    }

    public void setPREG_CREDITOS(String PREG_CREDITOS) {
        this.PREG_CREDITOS = PREG_CREDITOS;
    }

    public String getPREG_RECONOCIMIENTODEANTIGUEDA() {
        return PREG_RECONOCIMIENTODEANTIGUEDA;
    }

    public void setPREG_RECONOCIMIENTODEANTIGUEDA(String PREG_RECONOCIMIENTODEANTIGUEDA) {
        this.PREG_RECONOCIMIENTODEANTIGUEDA = PREG_RECONOCIMIENTODEANTIGUEDA;
    }

    public String getPREG_INSCRIPCIONENELIMSS() {
        return PREG_INSCRIPCIONENELIMSS;
    }

    public void setPREG_INSCRIPCIONENELIMSS(String PREG_INSCRIPCIONENELIMSS) {
        this.PREG_INSCRIPCIONENELIMSS = PREG_INSCRIPCIONENELIMSS;
    }

    public String getPREG_INSCRIPCIONENINFONAVIT() {
        return PREG_INSCRIPCIONENINFONAVIT;
    }

    public void setPREG_INSCRIPCIONENINFONAVIT(String PREG_INSCRIPCIONENINFONAVIT) {
        this.PREG_INSCRIPCIONENINFONAVIT = PREG_INSCRIPCIONENINFONAVIT;
    }

    public String getPREG_BAJAENELIMSS() {
        return PREG_BAJAENELIMSS;
    }

    public void setPREG_BAJAENELIMSS(String PREG_BAJAENELIMSS) {
        this.PREG_BAJAENELIMSS = PREG_BAJAENELIMSS;
    }

    public String getPREG_BAJAENELINFONAVIT() {
        return PREG_BAJAENELINFONAVIT;
    }

    public void setPREG_BAJAENELINFONAVIT(String PREG_BAJAENELINFONAVIT) {
        this.PREG_BAJAENELINFONAVIT = PREG_BAJAENELINFONAVIT;
    }

    public String getPREG_CUOTASOBREROPATRONALES() {
        return PREG_CUOTASOBREROPATRONALES;
    }

    public void setPREG_CUOTASOBREROPATRONALES(String PREG_CUOTASOBREROPATRONALES) {
        this.PREG_CUOTASOBREROPATRONALES = PREG_CUOTASOBREROPATRONALES;
    }

    public String getPREG_RIESGOSDETRABAJO() {
        return PREG_RIESGOSDETRABAJO;
    }

    public void setPREG_RIESGOSDETRABAJO(String PREG_RIESGOSDETRABAJO) {
        this.PREG_RIESGOSDETRABAJO = PREG_RIESGOSDETRABAJO;
    }

    public String getPREG_PREVENCIONDERIESGOSDETRAB() {
        return PREG_PREVENCIONDERIESGOSDETRAB;
    }

    public void setPREG_PREVENCIONDERIESGOSDETRAB(String PREG_PREVENCIONDERIESGOSDETRAB) {
        this.PREG_PREVENCIONDERIESGOSDETRAB = PREG_PREVENCIONDERIESGOSDETRAB;
    }

    public String getPREG_ENFERMEDADES() {
        return PREG_ENFERMEDADES;
    }

    public void setPREG_ENFERMEDADES(String PREG_ENFERMEDADES) {
        this.PREG_ENFERMEDADES = PREG_ENFERMEDADES;
    }

    public String getPREG_MATERNIDAD() {
        return PREG_MATERNIDAD;
    }

    public void setPREG_MATERNIDAD(String PREG_MATERNIDAD) {
        this.PREG_MATERNIDAD = PREG_MATERNIDAD;
    }

    public String getPREG_INVALIDEZ() {
        return PREG_INVALIDEZ;
    }

    public void setPREG_INVALIDEZ(String PREG_INVALIDEZ) {
        this.PREG_INVALIDEZ = PREG_INVALIDEZ;
    }

    public String getPREG_VIDA() {
        return PREG_VIDA;
    }

    public void setPREG_VIDA(String PREG_VIDA) {
        this.PREG_VIDA = PREG_VIDA;
    }

    public String getPREG_RETIRO() {
        return PREG_RETIRO;
    }

    public void setPREG_RETIRO(String PREG_RETIRO) {
        this.PREG_RETIRO = PREG_RETIRO;
    }

    public String getPREG_CESANTIAENEDADAVANZADA() {
        return PREG_CESANTIAENEDADAVANZADA;
    }

    public void setPREG_CESANTIAENEDADAVANZADA(String PREG_CESANTIAENEDADAVANZADA) {
        this.PREG_CESANTIAENEDADAVANZADA = PREG_CESANTIAENEDADAVANZADA;
    }

    public String getPREG_VEJEZ() {
        return PREG_VEJEZ;
    }

    public void setPREG_VEJEZ(String PREG_VEJEZ) {
        this.PREG_VEJEZ = PREG_VEJEZ;
    }

    public String getPREG_GUARDERIA() {
        return PREG_GUARDERIA;
    }

    public void setPREG_GUARDERIA(String PREG_GUARDERIA) {
        this.PREG_GUARDERIA = PREG_GUARDERIA;
    }

    public String getPREG_PRESTACIONESSOCIALES() {
        return PREG_PRESTACIONESSOCIALES;
    }

    public void setPREG_PRESTACIONESSOCIALES(String PREG_PRESTACIONESSOCIALES) {
        this.PREG_PRESTACIONESSOCIALES = PREG_PRESTACIONESSOCIALES;
    }

    public String getPREG_SALARIOBASEDECOTIZACION() {
        return PREG_SALARIOBASEDECOTIZACION;
    }

    public void setPREG_SALARIOBASEDECOTIZACION(String PREG_SALARIOBASEDECOTIZACION) {
        this.PREG_SALARIOBASEDECOTIZACION = PREG_SALARIOBASEDECOTIZACION;
    }

    public String getPREG_INCAPACIDADTEMPORAL() {
        return PREG_INCAPACIDADTEMPORAL;
    }

    public void setPREG_INCAPACIDADTEMPORAL(String PREG_INCAPACIDADTEMPORAL) {
        this.PREG_INCAPACIDADTEMPORAL = PREG_INCAPACIDADTEMPORAL;
    }

    public String getPREG_INCAPACIDADPERMANENTETOTA() {
        return PREG_INCAPACIDADPERMANENTETOTA;
    }

    public void setPREG_INCAPACIDADPERMANENTETOTA(String PREG_INCAPACIDADPERMANENTETOTA) {
        this.PREG_INCAPACIDADPERMANENTETOTA = PREG_INCAPACIDADPERMANENTETOTA;
    }

    public String getPREG_INCAPACIDADPERMANENTEPARC() {
        return PREG_INCAPACIDADPERMANENTEPARC;
    }

    public void setPREG_INCAPACIDADPERMANENTEPARC(String PREG_INCAPACIDADPERMANENTEPARC) {
        this.PREG_INCAPACIDADPERMANENTEPARC = PREG_INCAPACIDADPERMANENTEPARC;
    }

    public String getPREG_MUERTE() {
        return PREG_MUERTE;
    }

    public void setPREG_MUERTE(String PREG_MUERTE) {
        this.PREG_MUERTE = PREG_MUERTE;
    }

    public String getPREG_PENSIONPORINVALIDEZ() {
        return PREG_PENSIONPORINVALIDEZ;
    }

    public void setPREG_PENSIONPORINVALIDEZ(String PREG_PENSIONPORINVALIDEZ) {
        this.PREG_PENSIONPORINVALIDEZ = PREG_PENSIONPORINVALIDEZ;
    }

    public String getPREG_PENSIONPORVIUDEZ() {
        return PREG_PENSIONPORVIUDEZ;
    }

    public void setPREG_PENSIONPORVIUDEZ(String PREG_PENSIONPORVIUDEZ) {
        this.PREG_PENSIONPORVIUDEZ = PREG_PENSIONPORVIUDEZ;
    }

    public String getPREG_PENSIONPORORFANDAD() {
        return PREG_PENSIONPORORFANDAD;
    }

    public void setPREG_PENSIONPORORFANDAD(String PREG_PENSIONPORORFANDAD) {
        this.PREG_PENSIONPORORFANDAD = PREG_PENSIONPORORFANDAD;
    }

    public String getPREG_PENSIONPORASCENDENCIA() {
        return PREG_PENSIONPORASCENDENCIA;
    }

    public void setPREG_PENSIONPORASCENDENCIA(String PREG_PENSIONPORASCENDENCIA) {
        this.PREG_PENSIONPORASCENDENCIA = PREG_PENSIONPORASCENDENCIA;
    }

    public String getPREG_PENSIONGARANTIZADA() {
        return PREG_PENSIONGARANTIZADA;
    }

    public void setPREG_PENSIONGARANTIZADA(String PREG_PENSIONGARANTIZADA) {
        this.PREG_PENSIONGARANTIZADA = PREG_PENSIONGARANTIZADA;
    }

    public String getPREG_INCREMENTODEPENSION() {
        return PREG_INCREMENTODEPENSION;
    }

    public void setPREG_INCREMENTODEPENSION(String PREG_INCREMENTODEPENSION) {
        this.PREG_INCREMENTODEPENSION = PREG_INCREMENTODEPENSION;
    }

    public String getPREG_INDEMNIZACIONGLOBAL() {
        return PREG_INDEMNIZACIONGLOBAL;
    }

    public void setPREG_INDEMNIZACIONGLOBAL(String PREG_INDEMNIZACIONGLOBAL) {
        this.PREG_INDEMNIZACIONGLOBAL = PREG_INDEMNIZACIONGLOBAL;
    }

    public String getPREG_RECONOCIMIENTODEBENEFICIA() {
        return PREG_RECONOCIMIENTODEBENEFICIA;
    }

    public void setPREG_RECONOCIMIENTODEBENEFICIA(String PREG_RECONOCIMIENTODEBENEFICIA) {
        this.PREG_RECONOCIMIENTODEBENEFICIA = PREG_RECONOCIMIENTODEBENEFICIA;
    }

    public String getPREG_ASISTENCIAMEDICAQUIRURGIC() {
        return PREG_ASISTENCIAMEDICAQUIRURGIC;
    }

    public void setPREG_ASISTENCIAMEDICAQUIRURGIC(String PREG_ASISTENCIAMEDICAQUIRURGIC) {
        this.PREG_ASISTENCIAMEDICAQUIRURGIC = PREG_ASISTENCIAMEDICAQUIRURGIC;
    }

    public String getPREG_SERVICIODEHOSPITALIZACION() {
        return PREG_SERVICIODEHOSPITALIZACION;
    }

    public void setPREG_SERVICIODEHOSPITALIZACION(String PREG_SERVICIODEHOSPITALIZACION) {
        this.PREG_SERVICIODEHOSPITALIZACION = PREG_SERVICIODEHOSPITALIZACION;
    }

    public String getPREG_APARATOSDEPROTESISYORTOPE() {
        return PREG_APARATOSDEPROTESISYORTOPE;
    }

    public void setPREG_APARATOSDEPROTESISYORTOPE(String PREG_APARATOSDEPROTESISYORTOPE) {
        this.PREG_APARATOSDEPROTESISYORTOPE = PREG_APARATOSDEPROTESISYORTOPE;
    }

    public String getPREG_REHABILITACION() {
        return PREG_REHABILITACION;
    }

    public void setPREG_REHABILITACION(String PREG_REHABILITACION) {
        this.PREG_REHABILITACION = PREG_REHABILITACION;
    }

    public String getPREG_ASISTENCIAOBSTETRICA() {
        return PREG_ASISTENCIAOBSTETRICA;
    }

    public void setPREG_ASISTENCIAOBSTETRICA(String PREG_ASISTENCIAOBSTETRICA) {
        this.PREG_ASISTENCIAOBSTETRICA = PREG_ASISTENCIAOBSTETRICA;
    }

    public String getPREG_CANASTILLA() {
        return PREG_CANASTILLA;
    }

    public void setPREG_CANASTILLA(String PREG_CANASTILLA) {
        this.PREG_CANASTILLA = PREG_CANASTILLA;
    }

    public String getPREG_SUBSIDIOENDINERO() {
        return PREG_SUBSIDIOENDINERO;
    }

    public void setPREG_SUBSIDIOENDINERO(String PREG_SUBSIDIOENDINERO) {
        this.PREG_SUBSIDIOENDINERO = PREG_SUBSIDIOENDINERO;
    }

    public String getPREG_CONSERVACIONDEDERECHO() {
        return PREG_CONSERVACIONDEDERECHO;
    }

    public void setPREG_CONSERVACIONDEDERECHO(String PREG_CONSERVACIONDEDERECHO) {
        this.PREG_CONSERVACIONDEDERECHO = PREG_CONSERVACIONDEDERECHO;
    }

    public String getPREG_ASIGNACIONESFAMILIARES() {
        return PREG_ASIGNACIONESFAMILIARES;
    }

    public void setPREG_ASIGNACIONESFAMILIARES(String PREG_ASIGNACIONESFAMILIARES) {
        this.PREG_ASIGNACIONESFAMILIARES = PREG_ASIGNACIONESFAMILIARES;
    }

    public String getPREG_AYUDAASISTENCIAL() {
        return PREG_AYUDAASISTENCIAL;
    }

    public void setPREG_AYUDAASISTENCIAL(String PREG_AYUDAASISTENCIAL) {
        this.PREG_AYUDAASISTENCIAL = PREG_AYUDAASISTENCIAL;
    }

    public String getPREG_RETIRODEFONDOSDELACUENTAI() {
        return PREG_RETIRODEFONDOSDELACUENTAI;
    }

    public void setPREG_RETIRODEFONDOSDELACUENTAI(String PREG_RETIRODEFONDOSDELACUENTAI) {
        this.PREG_RETIRODEFONDOSDELACUENTAI = PREG_RETIRODEFONDOSDELACUENTAI;
    }

    public String getPREG_APORTACIONESVOLUNTARIASAL() {
        return PREG_APORTACIONESVOLUNTARIASAL;
    }

    public void setPREG_APORTACIONESVOLUNTARIASAL(String PREG_APORTACIONESVOLUNTARIASAL) {
        this.PREG_APORTACIONESVOLUNTARIASAL = PREG_APORTACIONESVOLUNTARIASAL;
    }

    public String getPREG_CONTINUACIONVOLUNTARIAALR() {
        return PREG_CONTINUACIONVOLUNTARIAALR;
    }

    public void setPREG_CONTINUACIONVOLUNTARIAALR(String PREG_CONTINUACIONVOLUNTARIAALR) {
        this.PREG_CONTINUACIONVOLUNTARIAALR = PREG_CONTINUACIONVOLUNTARIAALR;
    }

    public String getPREG_INCORPORACIONVOLUNTARIAAL() {
        return PREG_INCORPORACIONVOLUNTARIAAL;
    }

    public void setPREG_INCORPORACIONVOLUNTARIAAL(String PREG_INCORPORACIONVOLUNTARIAAL) {
        this.PREG_INCORPORACIONVOLUNTARIAAL = PREG_INCORPORACIONVOLUNTARIAAL;
    }

    public String getPREG_APORTACIONESALINFONAVIT() {
        return PREG_APORTACIONESALINFONAVIT;
    }

    public void setPREG_APORTACIONESALINFONAVIT(String PREG_APORTACIONESALINFONAVIT) {
        this.PREG_APORTACIONESALINFONAVIT = PREG_APORTACIONESALINFONAVIT;
    }

    public String getPREG_DESCUENTOSDESTINADOSALPAG() {
        return PREG_DESCUENTOSDESTINADOSALPAG;
    }

    public void setPREG_DESCUENTOSDESTINADOSALPAG(String PREG_DESCUENTOSDESTINADOSALPAG) {
        this.PREG_DESCUENTOSDESTINADOSALPAG = PREG_DESCUENTOSDESTINADOSALPAG;
    }

    public String getPREG_RIESGOSDETRABAJOSALARIOB() {
        return PREG_RIESGOSDETRABAJOSALARIOB;
    }

    public void setPREG_RIESGOSDETRABAJOSALARIOB(String PREG_RIESGOSDETRABAJOSALARIOB) {
        this.PREG_RIESGOSDETRABAJOSALARIOB = PREG_RIESGOSDETRABAJOSALARIOB;
    }

    public String getPREG_DESIGNACIONDEBENEFICIARIO() {
        return PREG_DESIGNACIONDEBENEFICIARIO;
    }

    public void setPREG_DESIGNACIONDEBENEFICIARIO(String PREG_DESIGNACIONDEBENEFICIARIO) {
        this.PREG_DESIGNACIONDEBENEFICIARIO = PREG_DESIGNACIONDEBENEFICIARIO;
    }

    public String getPREG_ADMINISTRADORASDEFONDOSPA() {
        return PREG_ADMINISTRADORASDEFONDOSPA;
    }

    public void setPREG_ADMINISTRADORASDEFONDOSPA(String PREG_ADMINISTRADORASDEFONDOSPA) {
        this.PREG_ADMINISTRADORASDEFONDOSPA = PREG_ADMINISTRADORASDEFONDOSPA;
    }

    public String getPREG_PRESTDESEGURIDADSODEC() {
        return PREG_PRESTDESEGURIDADSODEC;
    }

    public void setPREG_PRESTDESEGURIDADSODEC(String PREG_PRESTDESEGURIDADSODEC) {
        this.PREG_PRESTDESEGURIDADSODEC = PREG_PRESTDESEGURIDADSODEC;
    }

    public String getPREG_PRESTDESEGURIDADSOLEY() {
        return PREG_PRESTDESEGURIDADSOLEY;
    }

    public void setPREG_PRESTDESEGURIDADSOLEY(String PREG_PRESTDESEGURIDADSOLEY) {
        this.PREG_PRESTDESEGURIDADSOLEY = PREG_PRESTDESEGURIDADSOLEY;
    }

    public String getPREG_LIBERACIONDECREDITOHIPOTE() {
        return PREG_LIBERACIONDECREDITOHIPOTE;
    }

    public void setPREG_LIBERACIONDECREDITOHIPOTE(String PREG_LIBERACIONDECREDITOHIPOTE) {
        this.PREG_LIBERACIONDECREDITOHIPOTE = PREG_LIBERACIONDECREDITOHIPOTE;
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
            getFECHA_APERTURA_EXPEDIENTE(),
            getID_TIPO_ASUNTO(),
            getID_NAT_CONFLICTO(),
            getRAMA_INVOLUC(),
            getENTIDAD_CLAVE_ORG(),
            getENTIDAD_CLAVE(),
            getMUNICIPIO_CLAVE(),
            getPREG_PRIMADOMINICAL(),
            getPREG_COMISIONES(),
            getPREG_PRESTACIONESENESPECIE(),
            getPREG_GRATIFICACIONES(),
            getPREG_BONOS(),
            getPREG_CREDITOS(),
            getPREG_RECONOCIMIENTODEANTIGUEDA(),
            getPREG_INSCRIPCIONENELIMSS(),
            getPREG_INSCRIPCIONENINFONAVIT(),
            getPREG_BAJAENELIMSS(),
            getPREG_BAJAENELINFONAVIT(),
            getPREG_CUOTASOBREROPATRONALES(),
            getPREG_RIESGOSDETRABAJO(),
            getPREG_PREVENCIONDERIESGOSDETRAB(),
            getPREG_ENFERMEDADES(),
            getPREG_MATERNIDAD(),
            getPREG_INVALIDEZ(),
            getPREG_VIDA(),
            getPREG_RETIRO(),
            getPREG_CESANTIAENEDADAVANZADA(),
            getPREG_VEJEZ(),
            getPREG_GUARDERIA(),
            getPREG_PRESTACIONESSOCIALES(),
            getPREG_SALARIOBASEDECOTIZACION(),
            getPREG_INCAPACIDADTEMPORAL(),
            getPREG_INCAPACIDADPERMANENTETOTA(),
            getPREG_INCAPACIDADPERMANENTEPARC(),
            getPREG_MUERTE(),
            getPREG_PENSIONPORINVALIDEZ(),
            getPREG_PENSIONPORVIUDEZ(),
            getPREG_PENSIONPORORFANDAD(),
            getPREG_PENSIONPORASCENDENCIA(),
            getPREG_PENSIONGARANTIZADA(),
            getPREG_INCREMENTODEPENSION(),
            getPREG_INDEMNIZACIONGLOBAL(),
            getPREG_RECONOCIMIENTODEBENEFICIA(),
            getPREG_ASISTENCIAMEDICAQUIRURGIC(),
            getPREG_SERVICIODEHOSPITALIZACION(),
            getPREG_APARATOSDEPROTESISYORTOPE(),
            getPREG_REHABILITACION(),
            getPREG_ASISTENCIAOBSTETRICA(),
            getPREG_CANASTILLA(),
            getPREG_SUBSIDIOENDINERO(),
            getPREG_CONSERVACIONDEDERECHO(),
            getPREG_ASIGNACIONESFAMILIARES(),
            getPREG_AYUDAASISTENCIAL(),
            getPREG_RETIRODEFONDOSDELACUENTAI(),
            getPREG_APORTACIONESVOLUNTARIASAL(),
            getPREG_CONTINUACIONVOLUNTARIAALR(),
            getPREG_INCORPORACIONVOLUNTARIAAL(),
            getPREG_APORTACIONESALINFONAVIT(),
            getPREG_DESCUENTOSDESTINADOSALPAG(),
            getPREG_RIESGOSDETRABAJOSALARIOB(),
            getPREG_DESIGNACIONDEBENEFICIARIO(),
            getPREG_ADMINISTRADORASDEFONDOSPA(),
            getPREG_PRESTDESEGURIDADSODEC(),
            getPREG_PRESTDESEGURIDADSOLEY(),
            getPREG_LIBERACIONDECREDITOHIPOTE(),
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

    public void ENTIDAD_CLAVE_ORG(String valor) {
        this.ENTIDAD_CLAVE_ORG = valor;
    }

    public void ENTIDAD_CLAVE(String valor) {
        this.ENTIDAD_CLAVE = valor;
    }

    public void MUNICIPIO_CLAVE(String valor) {
        this.MUNICIPIO_CLAVE = valor;
    }

    public void PREG_PRIMADOMINICAL(String valor) {
        this.PREG_PRIMADOMINICAL = valor;
    }

    public void PREG_COMISIONES(String valor) {
        this.PREG_COMISIONES = valor;
    }

    public void PREG_PRESTACIONESENESPECIE(String valor) {
        this.PREG_PRESTACIONESENESPECIE = valor;
    }

    public void PREG_GRATIFICACIONES(String valor) {
        this.PREG_GRATIFICACIONES = valor;
    }

    public void PREG_BONOS(String valor) {
        this.PREG_BONOS = valor;
    }

    public void PREG_CREDITOS(String valor) {
        this.PREG_CREDITOS = valor;
    }

    public void PREG_RECONOCIMIENTODEANTIGUEDA(String valor) {
        this.PREG_RECONOCIMIENTODEANTIGUEDA = valor;
    }

    public void PREG_INSCRIPCIONENELIMSS(String valor) {
        this.PREG_INSCRIPCIONENELIMSS = valor;
    }

    public void PREG_INSCRIPCIONENINFONAVIT(String valor) {
        this.PREG_INSCRIPCIONENINFONAVIT = valor;
    }

    public void PREG_BAJAENELIMSS(String valor) {
        this.PREG_BAJAENELIMSS = valor;
    }

    public void PREG_BAJAENELINFONAVIT(String valor) {
        this.PREG_BAJAENELINFONAVIT = valor;
    }

    public void PREG_CUOTASOBREROPATRONALES(String valor) {
        this.PREG_CUOTASOBREROPATRONALES = valor;
    }

    public void PREG_RIESGOSDETRABAJO(String valor) {
        this.PREG_RIESGOSDETRABAJO = valor;
    }

    public void PREG_PREVENCIONDERIESGOSDETRAB(String valor) {
        this.PREG_PREVENCIONDERIESGOSDETRAB = valor;
    }

    public void PREG_ENFERMEDADES(String valor) {
        this.PREG_ENFERMEDADES = valor;
    }

    public void PREG_MATERNIDAD(String valor) {
        this.PREG_MATERNIDAD = valor;
    }

    public void PREG_INVALIDEZ(String valor) {
        this.PREG_INVALIDEZ = valor;
    }

    public void PREG_VIDA(String valor) {
        this.PREG_VIDA = valor;
    }

    public void PREG_RETIRO(String valor) {
        this.PREG_RETIRO = valor;
    }

    public void PREG_CESANTIAENEDADAVANZADA(String valor) {
        this.PREG_CESANTIAENEDADAVANZADA = valor;
    }

    public void PREG_VEJEZ(String valor) {
        this.PREG_VEJEZ = valor;
    }

    public void PREG_GUARDERIA(String valor) {
        this.PREG_GUARDERIA = valor;
    }

    public void PREG_PRESTACIONESSOCIALES(String valor) {
        this.PREG_PRESTACIONESSOCIALES = valor;
    }

    public void PREG_SALARIOBASEDECOTIZACION(String valor) {
        this.PREG_SALARIOBASEDECOTIZACION = valor;
    }

    public void PREG_INCAPACIDADTEMPORAL(String valor) {
        this.PREG_INCAPACIDADTEMPORAL = valor;
    }

    public void PREG_INCAPACIDADPERMANENTETOTA(String valor) {
        this.PREG_INCAPACIDADPERMANENTETOTA = valor;
    }

    public void PREG_INCAPACIDADPERMANENTEPARC(String valor) {
        this.PREG_INCAPACIDADPERMANENTEPARC = valor;
    }

    public void PREG_MUERTE(String valor) {
        this.PREG_MUERTE = valor;
    }

    public void PREG_PENSIONPORINVALIDEZ(String valor) {
        this.PREG_PENSIONPORINVALIDEZ = valor;
    }

    public void PREG_PENSIONPORVIUDEZ(String valor) {
        this.PREG_PENSIONPORVIUDEZ = valor;
    }

    public void PREG_PENSIONPORORFANDAD(String valor) {
        this.PREG_PENSIONPORORFANDAD = valor;
    }

    public void PREG_PENSIONPORASCENDENCIA(String valor) {
        this.PREG_PENSIONPORASCENDENCIA = valor;
    }

    public void PREG_PENSIONGARANTIZADA(String valor) {
        this.PREG_PENSIONGARANTIZADA = valor;
    }

    public void PREG_INCREMENTODEPENSION(String valor) {
        this.PREG_INCREMENTODEPENSION = valor;
    }

    public void PREG_INDEMNIZACIONGLOBAL(String valor) {
        this.PREG_INDEMNIZACIONGLOBAL = valor;
    }

    public void PREG_RECONOCIMIENTODEBENEFICIA(String valor) {
        this.PREG_RECONOCIMIENTODEBENEFICIA = valor;
    }

    public void PREG_ASISTENCIAMEDICAQUIRURGIC(String valor) {
        this.PREG_ASISTENCIAMEDICAQUIRURGIC = valor;
    }

    public void PREG_SERVICIODEHOSPITALIZACION(String valor) {
        this.PREG_SERVICIODEHOSPITALIZACION = valor;
    }

    public void PREG_APARATOSDEPROTESISYORTOPE(String valor) {
        this.PREG_APARATOSDEPROTESISYORTOPE = valor;
    }

    public void PREG_REHABILITACION(String valor) {
        this.PREG_REHABILITACION = valor;
    }

    public void PREG_ASISTENCIAOBSTETRICA(String valor) {
        this.PREG_ASISTENCIAOBSTETRICA = valor;
    }

    public void PREG_CANASTILLA(String valor) {
        this.PREG_CANASTILLA = valor;
    }

    public void PREG_SUBSIDIOENDINERO(String valor) {
        this.PREG_SUBSIDIOENDINERO = valor;
    }

    public void PREG_CONSERVACIONDEDERECHO(String valor) {
        this.PREG_CONSERVACIONDEDERECHO = valor;
    }

    public void PREG_ASIGNACIONESFAMILIARES(String valor) {
        this.PREG_ASIGNACIONESFAMILIARES = valor;
    }

    public void PREG_AYUDAASISTENCIAL(String valor) {
        this.PREG_AYUDAASISTENCIAL = valor;
    }

    public void PREG_RETIRODEFONDOSDELACUENTAI(String valor) {
        this.PREG_RETIRODEFONDOSDELACUENTAI = valor;
    }

    public void PREG_APORTACIONESVOLUNTARIASAL(String valor) {
        this.PREG_APORTACIONESVOLUNTARIASAL = valor;
    }

    public void PREG_CONTINUACIONVOLUNTARIAALR(String valor) {
        this.PREG_CONTINUACIONVOLUNTARIAALR = valor;
    }

    public void PREG_INCORPORACIONVOLUNTARIAAL(String valor) {
        this.PREG_INCORPORACIONVOLUNTARIAAL = valor;
    }

    public void PREG_APORTACIONESALINFONAVIT(String valor) {
        this.PREG_APORTACIONESALINFONAVIT = valor;
    }

    public void PREG_DESCUENTOSDESTINADOSALPAG(String valor) {
        this.PREG_DESCUENTOSDESTINADOSALPAG = valor;
    }

    public void PREG_RIESGOSDETRABAJOSALARIOB(String valor) {
        this.PREG_RIESGOSDETRABAJOSALARIOB = valor;
    }

    public void PREG_DESIGNACIONDEBENEFICIARIO(String valor) {
        this.PREG_DESIGNACIONDEBENEFICIARIO = valor;
    }

    public void PREG_ADMINISTRADORASDEFONDOSPA(String valor) {
        this.PREG_ADMINISTRADORASDEFONDOSPA = valor;
    }

    public void PREG_PRESTDESEGURIDADSODEC(String valor) {
        this.PREG_PRESTDESEGURIDADSODEC = valor;
    }

    public void PREG_PRESTDESEGURIDADSOLEY(String valor) {
        this.PREG_PRESTDESEGURIDADSOLEY = valor;
    }

    public void PREG_LIBERACIONDECREDITOHIPOTE(String valor) {
        this.PREG_LIBERACIONDECREDITOHIPOTE = valor;
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
