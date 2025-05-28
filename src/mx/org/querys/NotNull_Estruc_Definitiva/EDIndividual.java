/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexion;
import Conexion.OracleConexionDesarrollo;
import Screen_laborales.PValidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDIndividual {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

///Tipo de asunto no debe de ser =9 No_identificado
    public ArrayList Tipo_Asunto() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE,\n"
                + "  DECODE(ID_TIPO_ASUNTO,'-1','No_identificado') ID_TIPO_ASUNTO,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (ID_TIPO_ASUNTO = 9\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' AND periodo = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ  ='" + PValidacion.clave_organo + "' AND periodo = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_ASUNTO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Cuando ¿El trabajador contó con contrato escrito? = No o No identificado, no debe de capturar tipo de contrato
    public ArrayList Contrato_Escrito() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_TRAB_CONTR_ESCRI,'2','No','9','No identificado') PREG_TRAB_CONTR_ESCRI,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PREG_TRAB_CONTR_ESCRI     IN (2,9)\n"
                + "AND ( ID_TIPO_CONTRATO         IS NOT NULL )\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"' AND periodo = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ ='" + PValidacion.clave_organo + "' AND periodo = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_TRAB_CONTR_ESCRI")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Se anexó constancia de no conciliación expedida por el Centro Conciliación?=NO O NO IDENTIFICADO no debe de capturar Clave/identificador de la constancia
    public ArrayList Centro_conciliacion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_CONST_CONCILIAC,'2','No','9','No identificado') PREG_CONST_CONCILIAC,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PREG_CONST_CONCILIAC IN (2,9)\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (CLAVE_CONST_CONCILIAC IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2) ='"+PValidacion.clave_entidad+"' AND periodo = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ ='" + PValidacion.clave_organo + "' AND periodo = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_CONST_CONCILIAC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Se formuló prevención a la demanda?=NO O NO IDENTIFICADO no debe de capturar ¿Se desahogó la prevención de la demanda?
    public ArrayList Preve_demanda() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_FORMULO_DEMANDA,'2','No','-1','No identificado') PREG_FORMULO_DEMANDA,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PREG_FORMULO_DEMANDA IN (2,-1)\n"
                + "AND ID_TIPO_INCOMPETENCIA = 2\n"
                + "AND (PREG_DESAHOGO_DEMANDA IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2)= '"+PValidacion.clave_entidad+"'\n"
                + "AND periodo = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_FORMULO_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Estatus de la demanda no debe de ser 9=No_identificado.
    public ArrayList Estatus_Demanda() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,ID_ESTATUS_DEMANDA,\n"
                + "  --DECODE(ID_ESTATUS_DEMANDA,'-1','No_identificado') ID_ESTATUS_DEMANDA,\n"
                + "  REPLACE(COMENTARIOS,',','')COMENTARIOS,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (ID_ESTATUS_DEMANDA = -1 AND  ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (ID_ORGANOJ\n"
                + "  ||CLAVE_EXPEDIENTE NOT IN ('12035106/2022'))\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"'\n"
                + "AND periodo                  = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "')) ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_DEMANDA"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando Estatus de la demanda =Admitida no debe de capturarse Causas que impiden la admisión de la demanda
    public ArrayList Estatus_Demanda_admitida() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(ID_ESTATUS_DEMANDA,'1','Admitida') ID_ESTATUS_DEMANDA,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (ID_ESTATUS_DEMANDA = 1 AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (ID_CAUSA_IMP_ADM_DEMANDA  IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "'))  ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo tramitación por auto de depuración? =No o No identificado, no debe de capturarse Fecha de auto de depuración.
    public ArrayList Tram_depuracion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_AUTO_DEPURACION_TRAM,'2','No','-1','No identificado') PREG_AUTO_DEPURACION_TRAM,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PREG_AUTO_DEPURACION_TRAM IN (2,-1)\n"
                + "AND ID_ESTATUS_DEMANDA = 1 \n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (FECHA_AUTO_DEPURACION IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2) ='"+PValidacion.clave_entidad+"'\n"
                + "AND periodo = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo = '" + PValidacion.periodo + "')) ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_AUTO_DEPURACION_TRAM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo celebración de audiencia preliminar? =No o No identificado, no debe de capturarse Fecha de audiencia preliminar.
    public ArrayList Audiencia_preliminar() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_FECHA_CELEBR_AUDIENCIA, FECHA_AUDIENCIA_PRELIM\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND PREG_FECHA_CELEBR_AUDIENCIA IN (2,-1)\n"
                + "AND FECHA_AUDIENCIA_PRELIM IS NOT NULL )\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "AND PERIODO                  = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_FECHA_CELEBR_AUDIENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo celebración de audiencia de juicio? =No o No identificado, no debe de capturarse Fecha de audiencia de juicio.
    public ArrayList Audiencia_juicio() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(PREG_CELEBRA_AUD_JUICIO,'2','No','-1','No identificado') PREG_CELEBRA_AUD_JUICIO,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PREG_CELEBRA_AUD_JUICIO IN (2,-1)\n"
                + "AND ID_ESTATUS_DEMANDA = 1\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (FECHA_AUD_JUICIO IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"'\n"
                + "AND PERIODO = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_CELEBRA_AUD_JUICIO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Estatus del expediente no debe de ser 9=No_identificado.
    public ArrayList Estatus_ExpedienteNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(ID_ESTATUS_EXPED,'-1','No identificado') ID_ESTATUS_EXPED,\n"
                + "  REPLACE(COMENTARIOS,',','')COMENTARIOS,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (ID_ESTATUS_EXPED = -1\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "AND periodo                  = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "'))  ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
    public ArrayList IncompetenciaNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT ID_ORGANOJ,\n"
                + "    CLAVE_EXPEDIENTE,\n"
                + "    PREG_INCOMPETENCIA,\n"
                + "    REPLACE(COMENTARIOS,',','')COMENTARIOS,\n"
                + "    PERIODO\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "  OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "  )\n"
                + "WHERE PREG_INCOMPETENCIA = -1";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_INCOMPETENCIA"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
    public ArrayList Tipo_IncompetenciaNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT *\n"
                + "  FROM\n"
                + "    (SELECT ID_ORGANOJ,\n"
                + "      CLAVE_EXPEDIENTE,\n"
                + "      DECODE(PREG_INCOMPETENCIA,'2','No') PREG_INCOMPETENCIA,\n"
                + "      ID_TIPO_INCOMPETENCIA,\n"
                + "      PERIODO\n"
                + "    FROM TR_EXPEDIENTE\n"
                + "    WHERE PREG_INCOMPETENCIA = 2\n"
                + "    )\n"
                + "  WHERE ID_TIPO_INCOMPETENCIA = -1 \n"
                + "  )\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                   = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_INCOMPETENCIA"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
    public ArrayList PivIncompetencia() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA, ID_TIPO_INCOMPETENCIA\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE PREG_INCOMPETENCIA = 1\n"
                + "AND ID_TIPO_INCOMPETENCIA = 4\n"
                + "AND ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "AND (FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL \n"
                + "OR MONTO_SOLUCION IS NOT NULL))\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "  OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "'";
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_INCOMPETENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Favor de verificar Incompetencia ya que contiene dato apartir de Tipo de incompetencia (TIPO_INCOMPETENCIA)
    public ArrayList PivIncompetencia_Noindentificado() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA, ID_TIPO_INCOMPETENCIA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE PREG_INCOMPETENCIA = -1\n"
                + "AND ID_TIPO_INCOMPETENCIA = 4\n"
                + "AND (ID_TIPO_EXPEDIENTE IS NOT NULL\n"
                + "OR FECHA_PRESENT_DEMANDA IS NOT NULL\n"
                + "OR PREG_CONST_CONCILIAC IS NOT NULL\n"
                + "OR CLAVE_CONST_CONCILIAC IS NOT NULL\n"
                + "OR PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL\n"
                + "OR PREG_FORMULO_DEMANDA IS NOT NULL\n"
                + "OR PREG_DESAHOGO_DEMANDA IS NOT NULL\n"
                + "OR ID_ESTATUS_DEMANDA IS NOT NULL\n"
                + "OR ID_CAUSA_IMP_ADM_DEMANDA IS NOT NULL\n"
                + "OR FECHA_ADM_DEMANDA IS NOT NULL\n"
                + "OR CANT_ACTORES IS NOT NULL\n"
                + "OR CANT_DEMANDADOS IS NOT NULL\n"
                + "OR PREG_AUTO_DEPURACION_TRAM IS NOT NULL\n"
                + "OR FECHA_AUTO_DEPURACION IS NOT NULL\n"
                + "OR PREG_AUD_PRELIM_CELEBR IS NOT NULL\n"
                + "OR FECHA_AUDIENCIA_PRELIM IS NOT NULL\n"
                + "OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL\n"
                + "OR FECHA_AUD_JUICIO IS NOT NULL \n"
                + "OR ID_ESTATUS_EXPED IS NOT NULL\n"
                + "OR FECHA_ULT_ACT_PROC IS NOT NULL\n"
                + "OR ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL ))\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "  OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND periodo                   = '" + PValidacion.periodo + "' ";
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREG_INCOMPETENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ESTATUS DEMANDA =DESECHADA,ARCHIVO, NO SE DIO TRAMITE A LA DEMANDA APARTIR DE FECHA_ADMI_DEMANDA NO DEBEN DE CONTESTAR
    public ArrayList Estatus_Demanda_Desechada() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_DEMANDA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_DEMANDA IN (2,3,4)\n"
                + "AND (ID_CAUSA_IMP_ADM_DEMANDA IS NULL \n"
                + "OR FECHA_ADM_DEMANDA IS NOT NULL\n"
                + "OR CANT_ACTORES IS NOT NULL\n"
                + "OR CANT_DEMANDADOS IS NOT NULL\n"
                + "OR PREG_AUTO_DEPURACION_TRAM IS NOT NULL\n"
                + "OR FECHA_AUTO_DEPURACION IS NOT NULL\n"
                + "OR PREG_AUD_PRELIM_CELEBR IS NOT NULL\n"
                + "OR FECHA_AUDIENCIA_PRELIM IS NOT NULL\n"
                + "OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL\n"
                + "OR FECHA_AUD_JUICIO IS NOT NULL\n"
                + "OR ID_ESTATUS_EXPED IS NOT NULL\n"
                + "OR FECHA_ULT_ACT_PROC IS NOT NULL\n"
                + "OR ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL ))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ESTATUS DEMANDA =DESECHADA,ARCHIVO, NO SE DIO TRAMITE A LA DEMANDA APARTIR DE FECHA_ADMI_DEMANDA NO DEBEN DE CONTESTAR
    public ArrayList Estatus_Demanda_Noidentificada() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_DEMANDA, FECHA_ADM_DEMANDA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_DEMANDA IN (-1)\n"
                + "AND (FECHA_ADM_DEMANDA IS NOT NULL\n"
                + "OR CANT_ACTORES IS NOT NULL\n"
                + "OR CANT_DEMANDADOS IS NOT NULL\n"
                + "OR PREG_AUTO_DEPURACION_TRAM IS NOT NULL\n"
                + "OR FECHA_AUTO_DEPURACION IS NOT NULL\n"
                + "OR PREG_AUD_PRELIM_CELEBR IS NOT NULL\n"
                + "OR FECHA_AUDIENCIA_PRELIM IS NOT NULL\n"
                + "OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL\n"
                + "OR FECHA_AUD_JUICIO IS NOT NULL\n"
                + "OR ID_ESTATUS_EXPED IS NOT NULL\n"
                + "OR FECHA_ULT_ACT_PROC IS NOT NULL\n"
                + "OR ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL ))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_DEMANDA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
    public ArrayList Estatus_Expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED,\n"
                + "ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION, FECHA_DICTO_SOLUCION, ID_TIPO_SENTENCIA, MONTO_SOLUCION\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_EXPED = 2\n"
                + "AND (ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL ))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_EXPEDIENTE")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
//QUEDA 
//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE

    public ArrayList Estatus_Expediente_Noidentificado() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_EXPED = '-1'\n"
                + "AND (ID_FASE_SOL_EXPED IS NOT NULL\n"
                + "OR FECHA_ULT_ACT_PROC IS NOT NULL\n"
                + "OR ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL))\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "AND PERIODO                   = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   = '" + PValidacion.periodo + "' ";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_EXPEDIENTE")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//cuando el estatus del expediente es = solucionado no debe de haber nada en fecha del ultimo acto procesal
    public ArrayList Fecha_acto_procesal() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_ULT_ACT_PROC\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_ESTATUS_EXPED = 1\n"
                + "AND FECHA_ULT_ACT_PROC IS NOT NULL)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_TIPO_EXPEDIENTE"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fase_Sol_expNoExiste() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_FASE_SOL_EXPED, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_ULT_ACT_PROC\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_FASE_SOL_EXPED NOT IN (1,2,3,4, -1))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Cuando Fase de solicitud del expediente (FASE_SOLI_EXPEDIENTE) =No identificado, no debe capturar desde Forma de solución (FORMA_SOLUCION_AD) hasta Monto estipulado en la forma de solución (MONTO_SOLUCION_AJ).  O en su caso agregar la fase del expediente si es que hay valor valido en la fecha de resolución.
    public ArrayList Fase_Sol_expNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_FASE_SOL_EXPED = -1\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL))\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) ='" + PValidacion.clave_entidad + "'\n"
                + "AND periodo                   = '" + PValidacion.periodo + "'\n"
                + "OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                   = '" + PValidacion.periodo + "' )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=Tramitación por auto de depuración
    public ArrayList Fase_Sol_exp_TD() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n" +
"                 SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION\n" +
"                 FROM TR_EXPEDIENTE\n" +
"                 WHERE ID_TIPO_EXPEDIENTE = 2\n" +
"                 AND ID_FASE_SOL_EXPED IN (3)\n" +
"                 AND ID_FORMA_SOLUCION IS NOT NULL\n" +
"                 AND FECHA_DICTO_SOLUCION IS NOT NULL \n" +
"                 AND(\n" +
"                 ID_TIPO_SENTENCIA IS NOT NULL\n" +
"                 OR MONTO_SOLUCION IS NOT NULL\n" +
"                 ))\n" +
"                 WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n" +
"                   AND PERIODO                   = '"+PValidacion.periodo+"'\n" +
"                   OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n" +
"                   AND PERIODO                   = '" + PValidacion.periodo + "'";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=Tramitación sin audiencias
    public ArrayList Fase_Sol_exp_TA() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_FASE_SOL_EXPED IN (4)\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL))\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"'\n"
                + "  OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "'";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=AUDIENCIA PRELIMINAR
    public ArrayList Fase_Sol_exp_AP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n" +
"                 SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION, ID_TIPO_SENTENCIA\n" +
"                 FROM TR_EXPEDIENTE\n" +
"                 WHERE ID_TIPO_EXPEDIENTE = 2\n" +
"                 AND ID_FASE_SOL_EXPED IN (1)\n" +
"                 AND ID_FORMA_SOLUCION IS NOT NULL \n" +
"                 AND FECHA_DICTO_SOLUCION IS NOT NULL\n" +
"                 AND ID_TIPO_SENTENCIA IS NOT NULL \n" +
"                 )\n" +
"                 WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n" +
"                   AND PERIODO                   = '"+PValidacion.periodo+"'\n" +
"                   OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n" +
"                   AND PERIODO                   = '" + PValidacion.periodo + "'";
//System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
/* NO APLICA 
//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=AUDIENCIA DE JUICIO
   
    public ArrayList Fase_Sol_exp_AJ() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_FASE_SOL_EXPED IN (2)\n"
                + "AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_DICTO_SOLUCION IS NOT NULL\n"
                + "OR ID_TIPO_SENTENCIA IS NOT NULL\n"
                + "OR MONTO_SOLUCION IS NOT NULL))\n"
                + "WHERE SUBSTR(ID_ORGANOJ,0,2)='"+PValidacion.clave_entidad+"'\n"
                + "  AND PERIODO                   = '"+PValidacion.periodo+"'\n"
                + "  OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "'";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
*/

    public ArrayList SinMotivo_Conflicto() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT COUNT(ID_EXPEDIENTE) AS ID_EXPEDIENTE, CLAVE_EXPEDIENTE, ID_ORGANOJ, PERIODO, ID_MOTIVO_CONFLICTO\n"
                + "FROM (\n"
                + "SELECT E.ID_EXPEDIENTE, E.ID_TIPO_EXPEDIENTE, E.ID_ORGANOJ, E.PERIODO, E.CLAVE_EXPEDIENTE, MC.ID_MOTIVO_CONFLICTO,TO_CHAR(E.FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA\n"
                + "FROM TR_EXPEDIENTE E\n"
                + "LEFT JOIN TR_EXP_MOTIVO_CONF MC\n"
                + "ON E.ID_ORGANOJ = MC.ID_ORGANOJ AND E.ID_EXPEDIENTE = MC.ID_EXPEDIENTE AND E.PERIODO = MC.PERIODO\n"
                + "WHERE E.ID_TIPO_EXPEDIENTE = 2\n"
                + "AND ID_MOTIVO_CONFLICTO IS NULL)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' AND PERIODO = '"+PValidacion.periodo+"'\n"
                + "OR ID_ORGANOJ='" + PValidacion.clave_organo + "' and periodo = '" + PValidacion.periodo + "')\n"
                + "GROUP BY ID_EXPEDIENTE, CLAVE_EXPEDIENTE, ID_ORGANOJ, PERIODO, ID_MOTIVO_CONFLICTO )\n"
                + "WHERE ID_EXPEDIENTE = 0";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
