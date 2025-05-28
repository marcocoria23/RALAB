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
public class EDHuelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

//Tipo de asunto no debe de ser =9 No_identificado o Null.
    public ArrayList Tipo_Asunto() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  DECODE(ID_TIPO_ASUNTO,'9','No_identificado') ID_TIPO_ASUNTO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_ASUNTO = 9 AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND periodo = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo = '" + PValidacion.periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("TIPO_ASUNTO"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo emplazamiento a huelga? =No o No identificado, no debe de capturarse Fecha del emplazamiento a huelga.
    public ArrayList Emplaz_huelga() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, FECHA_HUELGA_EMPLAZAM,\n"
                + "  DECODE(PREG_HUELGA_EMPLAZAM,'2','No','9','No identificado') PREG_HUELGA_EMPLAZAM\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE PREG_HUELGA_EMPLAZAM IN (2,9)\n"
                + "AND ID_TIPO_EXPEDIENTE = 4  \n"
                + "AND FECHA_HUELGA_EMPLAZAM IS NOT NULL\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                  = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("EMPLAZAMIENTO_HUELGA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo prehuelga? =No o No identificado, no debe de capturarse ¿Hubo audiencia de conciliación? ni Fecha de audiencia de conciliación.
    public ArrayList Preghuelga() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_PREHUELGA, \n"
                + "  PREG_AUDIENCIA_CONCIL, FECHA_AUDIENCIA_CONCIL\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND PREG_PREHUELGA IN (2,9)\n"
                + "AND PREG_AUDIENCIA_CONCIL IS NOT NULL\n"
                + "AND FECHA_AUDIENCIA_CONCIL IS NOT NULL)\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("PREHUELGA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo audiencia de conciliación? =No o No identificado, no debe de capturarse Fecha de audiencia de conciliación.
    public ArrayList Aud_conciliacion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  PREG_AUDIENCIA_CONCIL, FECHA_AUDIENCIA_CONCIL\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND PREG_AUDIENCIA_CONCIL IN (2,9)\n"
                + "AND FECHA_AUDIENCIA_CONCIL IS NOT NULL)\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("AUDIENCIA_CONCILIACION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Cuando ¿Hubo estallamiento de la huelga?=No o No identificado, no debe de capturarse Declaración de licitud de la huelga,Declaración de existencia de la huelga.
    public ArrayList Estallamiento_huelga() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (       \n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  PREG_HUELGA_ESTALLA, ID_HUELGA_LICITUD, ID_HUELGA_EXISTENCIA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND PREG_HUELGA_ESTALLA IN (2,9)\n"
                + "AND (ID_HUELGA_LICITUD IS NOT NULL OR ID_HUELGA_EXISTENCIA IS NOT NULL))\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ESTALLAMIENTO_HUELGA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//--Estatus del expediente no debe de ser 9=No_identificado.
    public ArrayList Estatus_ExpedienteNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (       \n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_ESTATUS_EXPED = '-1')\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("COMENTARIOS"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
    public ArrayList IncompetenciaNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (       \n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND PREG_INCOMPETENCIA = '-1')\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("INCOMPETENCIA"),
                    resul.getString("COMENTARIOS"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

///INCOMPETENCIA NO DEBE SER = NO IDENTIFICADA
    public ArrayList Tipo_IncompetenciaNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (       \n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA, ID_TIPO_INCOMPETENCIA\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND PREG_INCOMPETENCIA = 2\n"
                + "AND ID_TIPO_INCOMPETENCIA IS NOT NULL)\n"
                + "WHERE ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("INCOMPETENCIA"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//INCOMPETENCIA =SI NO DEBE DE CAPTURAR DESPUES DE ESPECIFIQUE OTRO INCOMPETENCIA
    public ArrayList PivIncompetencia() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT * FROM (\n"
                + "  SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA\n"
                + "    FROM TR_EXPEDIENTE\n"
                + "    WHERE FECHA_PLIEGO_PETICION IS NOT NULL\n"
                + "    OR CANT_ACTORES        IS NOT NULL\n"
                + "    OR CANT_DEMANDADOS     IS NOT NULL\n"
                + "    OR PREG_HUELGA_EMPLAZAM    IS NOT NULL\n"
                + "    OR FECHA_HUELGA_EMPLAZAM     IS NOT NULL\n"
                + "    OR PREG_PREHUELGA               IS NOT NULL\n"
                + "    OR PREG_AUDIENCIA_CONCIL  IS NOT NULL\n"
                + "    OR FECHA_AUDIENCIA_CONCIL         IS NOT NULL\n"
                + "    OR PREG_HUELGA_ESTALLA    IS NOT NULL\n"
                + "    OR ID_HUELGA_LICITUD  IS NOT NULL\n"
                + "    OR ID_HUELGA_EXISTENCIA  IS NOT NULL\n"
                + "    OR ID_ESTATUS_EXPED      IS NOT NULL\n"
                + "    OR FECHA_ULT_ACT_PROC  IS NOT NULL\n"
                + "    OR ID_FASE_SOL_EXPED    IS NOT NULL\n"
                + "    OR ID_FORMA_SOLUCION   IS NOT NULL\n"
                + "    OR FECHA_DICTO_SOLUCION     IS NOT NULL\n"
                + "    OR PORCENT_SOLICITADO IS NOT NULL\n"
                + "    OR PORCENT_OTORGADO     IS NOT NULL\n"
                + "    OR ID_FORMA_SOLUCION   IS NOT NULL\n"
                + "    OR (ID_FASE_SOL_EXPED IS NULL AND FECHA_DICTO_SOLUCION IS NOT NULL)\n"
                + "    OR ID_TIPO_SENTENCIA          IS NOT NULL\n"
                + "    OR FECHA_HUELGA_ESTALLA IS NOT NULL\n"
                + "    OR FECHA_HUELGA_LEVANTAM     IS NOT NULL\n"
                + "    OR MONTO_SOLUCION        IS NOT NULL\n"
                + "    OR PORCENT_SALARIOS_CAIDOS         IS NOT NULL )\n"
                + "  WHERE (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "  OR (ID_ORGANOJ ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "'))\n"
                + "WHERE PREG_INCOMPETENCIA = 4";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("INCOMPETENCIA"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Favor de verificar
    public ArrayList PivIncompetencia_Noidentificado() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT \n"
                + "    ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, PREG_INCOMPETENCIA, COMENTARIOS, PERIODO\n"
                + "FROM( \n"
                + "SELECT * FROM( \n"
                + "select ID_EXPEDIENTE, ID_ORGANOJ, CLAVE_EXPEDIENTE, ID_TIPO_EXPEDIENTE, PREG_INCOMPETENCIA,REPLACE(COMENTARIOS,',','')COMENTARIOS,PERIODO from TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_INCOMPETENCIA IS NOT NULL OR FECHA_PRESENT_DEMANDA IS NOT NULL OR  \n"
                + "PREG_CONST_CONCILIAC IS NOT NULL OR  CLAVE_CONST_CONCILIAC IS NOT NULL \n"
                + "OR PREG_ASUNTO_VINC_CONCIL_P IS NOT NULL OR  \n"
                + "PREG_FORMULO_DEMANDA IS NOT NULL OR \n"
                + "PREG_DESAHOGO_DEMANDA IS NOT NULL OR \n"
                + "ID_ESTATUS_DEMANDA IS NOT NULL OR \n"
                + "id_causa_imp_adm_demanda IS NOT NULL OR \n"
                + "FECHA_ADM_DEMANDA IS NOT NULL OR  CANT_ACTORES IS NOT NULL OR \n"
                + "CANT_DEMANDADOS IS NOT NULL OR  PREG_FECHA_CELEBR_AUDIENCIA IS NOT NULL OR  \n"
                + "FECHA_AUDIENCIA_PRELIM IS NOT NULL OR PREG_CELEBRA_AUD_JUICIO IS NOT NULL OR  \n"
                + "FECHA_AUD_JUICIO IS NOT NULL OR  \n"
                + "ID_ESTATUS_EXPED IS NOT NULL OR  FECHA_ULT_ACT_PROC IS NOT NULL OR \n"
                + "ID_FASE_SOL_EXPED IS NOT NULL OR  \n"
                + "ID_FORMA_SOLUCION IS NOT NULL OR  \n"
                + "FECHA_DICTO_SOLUCION IS NOT NULL OR MONTO_SOLUCION IS NOT NULL OR \n"
                + "ID_TIPO_SENTENCIA IS NOT NULL) where  ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' and periodo = '" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 4) \n"
                + " or (ID_ORGANOJ = '" + PValidacion.clave_organo + "' and periodo = '" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 1 )))WHERE PREG_INCOMPETENCIA=-1";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("INCOMPETENCIA"),
                    resul.getString("PERIODO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ESTATUS DEL EXPEDIENTE = EN PROCESO DE RESOLUCION APARTIR DE FORMA_SOLUCIONFE NO DEBE DE CONTESTARSE
    public ArrayList Estatus_Expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, ID_FASE_SOL_EXPED\n"
                + "    FROM TR_EXPEDIENTE\n"
                + "    WHERE ID_FASE_SOL_EXPED IN (6,7)\n"
                + "    AND ( ID_FORMA_SOLUCION   IS NOT NULL\n"
                + "    OR FECHA_DICTO_SOLUCION   IS NOT NULL\n"
                + "    OR PORCENT_SOLICITADO IS NOT NULL\n"
                + "    OR PORCENT_OTORGADO   IS NOT NULL\n"
                + "    OR ID_TIPO_SENTENCIA     IS NOT NULL\n"
                + "    OR FECHA_HUELGA_ESTALLA IS NOT NULL\n"
                + "    OR FECHA_HUELGA_LEVANTAM IS NOT NULL\n"
                + "    OR MONTO_SOLUCION IS NOT NULL\n"
                + "    OR PORCENT_SALARIOS_CAIDOS IS NOT NULL)\n"
                + "    )\n"
                + "  WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "  AND ID_ESTATUS_EXPED = 2\n"
                + "  AND (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "')\n"
                + "  OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "  AND PERIODO                   = '" + PValidacion.periodo + "' )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_acto_procesal() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_ESTATUS_EXPED, FECHA_ULT_ACT_PROC\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE ID_TIPO_EXPEDIENTE = 4 \n"
                + "  AND ID_ESTATUS_EXPED = 1\n"
                + "  AND FECHA_ULT_ACT_PROC IS NOT NULL )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) = '"+ PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   = '" + PValidacion.periodo +"'\n"
                + "OR ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   = '" + PValidacion.periodo + "' )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fase_Sol_expNoExiste() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED IN (1,2,3,4,8,9) )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2) ='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   = '" + PValidacion.periodo + "' )";
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
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Cuando Fase de solicitud del expediente (FASE_SOLI_EXPEDIENTE) =No identificado, no debe capturar desde Forma de solución (FORMA_SOLUCION_EMPLAZ) hasta Porcentaje por salarios caídos (SALARIOS_CAIDOS). O en su caso agregar la fase del expediente si es que hay valor valido en la fecha de resolución.
    public ArrayList Fase_Sol_expNI() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED   = '-1'\n"
                + "    AND ( ID_FORMA_SOLUCION   IS NOT NULL\n"
                + "    OR FECHA_DICTO_SOLUCION   IS NOT NULL\n"
                + "    OR PORCENT_SOLICITADO IS NOT NULL\n"
                + "    OR PORCENT_OTORGADO   IS NOT NULL\n"
                + "    OR ID_TIPO_SENTENCIA     IS NOT NULL\n"
                + "    OR FECHA_HUELGA_ESTALLA IS NOT NULL\n"
                + "    OR FECHA_HUELGA_LEVANTAM IS NOT NULL\n"
                + "    OR MONTO_SOLUCION IS NOT NULL\n"
                + "    OR PORCENT_SALARIOS_CAIDOS IS NOT NULL)\n"
                + "AND (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "' )";
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
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=EMPLAZAMIENTO A HUELGA NO DEBE DE CAPTURAR RUBRO Solución (Huelga)
    public ArrayList Fase_Sol_exp_EMPH() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION,\n"
                + "    FECHA_DICTO_SOLUCION,ID_TIPO_SENTENCIA,FECHA_HUELGA_ESTALLA,FECHA_HUELGA_LEVANTAM,MONTO_SOLUCION,PORCENT_SALARIOS_CAIDOS\n"
                + "    FROM TR_EXPEDIENTE \n"
                + "    WHERE ID_FASE_SOL_EXPED = 7\n"
                + "    AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "    OR FECHA_DICTO_SOLUCION      IS NOT NULL\n"
                + "    OR ID_TIPO_SENTENCIA           IS NOT NULL\n"
                + "    OR FECHA_HUELGA_ESTALLA    IS NOT NULL\n"
                + "    OR FECHA_HUELGA_LEVANTAM      IS NOT NULL\n"
                + "    OR MONTO_SOLUCION         IS NOT NULL\n"
                + "    OR PORCENT_SALARIOS_CAIDOS          IS NOT NULL)\n"
                + "    )\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED = 5 )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "' )";
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
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---CUANDO FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE=Huelga  NO DEBE DE CAPTURAR   Solución (Emplazamiento/Prehuelga)
    public ArrayList Fase_Sol_exp_Huelga() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION,\n"
                + "    FECHA_DICTO_SOLUCION\n"
                + "    FROM TR_EXPEDIENTE \n"
                + "    WHERE ID_FASE_SOL_EXPED = 6\n"
                + "    AND (ID_FORMA_SOLUCION IS NOT NULL\n"
                + "    OR FECHA_DICTO_SOLUCION      IS NOT NULL\n"
                + "    OR PORCENT_SOLICITADO IS NOT NULL\n"
                + "    OR PORCENT_OTORGADO    IS NOT NULL )\n"
                + "    )\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED = 7 )\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='"+ PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                  = '" + PValidacion.periodo + "' )";
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
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//---Cuando el expediente No se admitio a tramite la fase de solicitud debe ser emplazamiento a huelga o prehuelga.
    public ArrayList Fase_Sol_Desechamiento() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED, COMENTARIOS\n"
                + "FROM TR_EXPEDIENTE \n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED = 7 \n"
                + "AND (COMENTARIOS = 'NO SE ADMITIÓ A TRÁMITE LA SOLICITUD')) \n"
                + "WHERE ((SUBSTR(ID_ORGANOJ, 1, 2) = '"+ PValidacion.clave_entidad + "' AND PERIODO = '" + PValidacion.periodo +"')\n"
                + "OR (ID_ORGANOJ = '" + PValidacion.clave_organo + "' AND PERIODO = '" + PValidacion.periodo + "') )";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_FASE_SOL_EXPED"),
                    resul.getString("ID_TIPO_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList SinMotivo_Conflicto() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT P.ID_ORGANOJ,  P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_TIPO_EXPEDIENTE, ID_HUELGA_MOTIVO\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_EXP_MOTIVO_HUELGA S\n"
                + "  ON P.ID_EXPEDIENTE = S.ID_EXPEDIENTE AND P.ID_ORGANOJ = S.ID_ORGANOJ AND P.PERIODO = S.PERIODO\n"
                + "WHERE P. ID_TIPO_EXPEDIENTE = 4\n"
                + "AND S.ID_HUELGA_MOTIVO IS NULL)\n"
                + "WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "' \n"
                + "and PERIODO = '" + PValidacion.periodo + "' )\n"
                + "OR (ID_ORGANOJ='" + PValidacion.clave_organo + "' \n"
                + "and PERIODO = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_HUELGA_MOTIVO")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(EDHuelga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
