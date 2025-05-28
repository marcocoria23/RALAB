/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.querys.NotNull_Estruc_Definitiva;

import Conexion.OracleConexionDesarrollo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Screen_laborales.PValidacion;
import mx.org.querys.V1querys;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EDQHuelga {

    OracleConexionDesarrollo conexion = new OracleConexionDesarrollo();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList FECHA_APERTURA_EXPEDIENTE_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE, \n"
                + "  TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (FECHA_APERTURA_EXPED > SYSDATE OR FECHA_APERTURA_EXPED = '09/09/1899')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_APERTURA_EXPED")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_PRESENTA_PETIC_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_PLIEGO_PETICION,'DD/MM/YYYY')FECHA_PLIEGO_PETICION,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND (FECHA_PLIEGO_PETICION > SYSDATE\n"
                + "AND FECHA_PLIEGO_PETICION <> TO_DATE('09/09/1899', 'DD/MM/YYYY'))\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_PLIEGO_PETICION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_EMPLAZAMIENTO_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_HUELGA_EMPLAZAM,'DD/MM/YYYY')FECHA_HUELGA_EMPLAZAM,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (FECHA_HUELGA_EMPLAZAM > SYSDATE\n"
                + "AND FECHA_HUELGA_EMPLAZAM = '09/09/1899')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_HUELGA_EMPLAZAM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_AUDIENCIA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_AUDIENCIA,'DD/MM/YYYY')FECHA_AUDIENCIA,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND (FECHA_AUDIENCIA        > SYSDATE\n"
                + "AND FECHA_AUDIENCIA          <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_AUDIENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ACTO_PROCESAL_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE, \n"
                + "  TO_CHAR(FECHA_ULT_ACT_PROC,'DD/MM/YYYY')FECHA_ULT_ACT_PROC,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND (FECHA_ULT_ACT_PROC    > SYSDATE\n"
                + "AND FECHA_ULT_ACT_PROC      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_RESOLU_EMPLAZ_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED,\n"
                + "  TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4 AND ID_FASE_SOL_EXPED = 6\n"
                + "AND (FECHA_DICTO_SOLUCION    > SYSDATE\n"
                + "AND FECHA_DICTO_SOLUCION      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_RESOLU_HUELGA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE, \n"
                + "  TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4 AND ID_FASE_SOL_EXPED = 7\n"
                + "AND (FECHA_DICTO_SOLUCION    > SYSDATE\n"
                + "AND FECHA_DICTO_SOLUCION      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_ESTALLAM_HUELGA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_HUELGA_ESTALLA,'DD/MM/YYYY')FECHA_HUELGA_ESTALLA,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "AND (FECHA_HUELGA_ESTALLA  > SYSDATE\n"
                + "AND FECHA_HUELGA_ESTALLA    <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_HUELGA_ESTALLA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList FECHA_LEVANT_HUELGA_FUT() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_HUELGA_LEVANTAM,'DD/MM/YYYY')FECHA_HUELGA_LEVANTAM,\n"
                + "  TO_CHAR(SYSDATE,'DD/MM/YYYY')\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4 AND ID_FASE_SOL_EXPED = 7\n"
                + "AND (FECHA_HUELGA_LEVANTAM    > SYSDATE\n"
                + "AND FECHA_HUELGA_LEVANTAM      <> '09/09/1899')\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2) = '"+PValidacion.clave_entidad+"' \n"
                + "OR PERIODO = '"+PValidacion.periodo+"' )\n"
                + "OR (ID_ORGANOJ = '"+PValidacion.clave_organo+"'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "' ))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("periodo"),
                    resul.getString("FECHA_HUELGA_LEVANTAM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Duplicidad_expediente() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY')FECHA_APERTURA_EXPED,\n"
                + "  TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_ORGANOJ\n"
                + "  ||TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))\n"
                + "  ||PERIODO IN\n"
                + "  (SELECT ID_ORGANOJ\n"
                + "    ||CLAVE_EXPEDIENTE2\n"
                + "    ||PERIODO\n"
                + "  FROM\n"
                + "    (SELECT ID_ORGANOJ,\n"
                + "      COUNT(CLAVE_EXPEDIENTE2)CUENTACLAVE_EXPEDIENTE2,\n"
                + "      CLAVE_EXPEDIENTE2,\n"
                + "      PERIODO\n"
                + "    FROM\n"
                + "      (SELECT ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        TO_NUMBER(regexp_replace(CLAVE_EXPEDIENTE, '[^0-9]', ''))CLAVE_EXPEDIENTE2,\n"
                + "        PERIODO\n"
                + "      FROM TR_EXPEDIENTE\n"
                + "      WHERE (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "      AND PERIODO                    ='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 4)\n"
                + "      OR (ID_ORGANOJ               ='" + PValidacion.clave_organo + "'\n"
                + "      AND PERIODO                    ='" + PValidacion.periodo + "' AND ID_TIPO_EXPEDIENTE = 4)\n"
                + "      ORDER BY ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE2 )\n"
                + "    GROUP BY ID_ORGANOJ,\n"
                + "      CLAVE_EXPEDIENTE2,\n"
                + "      PERIODO )\n"
                + "  WHERE CUENTACLAVE_EXPEDIENTE2>1 )\n"
                + "ORDER BY ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE2";
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
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_PresentacionNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM\n"
                + "  (SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'dd/mm/yyyy')FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_PLIEGO_PETICION,'dd/mm/yyyy')FECHA_PLIEGO_PETICION\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy') < to_date(FECHA_PLIEGO_PETICION,'dd/mm/yyyy')\n"
                + "  AND ID_TIPO_EXPEDIENTE = 4\n"
                + "  AND FECHA_PLIEGO_PETICION  <> '09/09/1899')\n"
                + "WHERE (PERIODO  = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_PLIEGO_PETICION  <> '09/09/1899'\n"
                + "AND ID_ORGANOJ ='" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_PLIEGO_PETICION  <> '09/09/1899'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_PLIEGO_PETICION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la fecha de emplazamiento no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_EmplazamientoNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "Select * FROM\n"
                + "(SELECT SUBSTR(ID_ORGANOJ,0,2), ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "  TO_CHAR(FECHA_HUELGA_EMPLAZAM,'DD/MM/YYYY') FECHA_HUELGA_EMPLAZAM\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE (PERIODO = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_HUELGA_EMPLAZAM <> '09/09/1899'\n"
                + "AND ID_ORGANOJ = '" + PValidacion.clave_organo + "')\n"
                + "OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_HUELGA_EMPLAZAM <> '09/09/1899'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "')\n"
                + ") WHERE to_date(FECHA_HUELGA_EMPLAZAM,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_HUELGA_EMPLAZAM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha del emplazamiento a huelga  no debe de ser menor o igual a la fecha de apertura del expediente.
    public ArrayList Fecha_AudienciaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_AUDIENCIA,'DD/MM/YYYY') FECHA_AUDIENCIA\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE (PERIODO = '" + PValidacion.periodo + "'\n"
                + "  AND FECHA_AUDIENCIA <> '09/09/1899'\n"
                + "  AND ID_ORGANOJ = '" + PValidacion.clave_organo + "')\n"
                + "  OR (SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "  AND FECHA_AUDIENCIA <> '09/09/1899'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "')\n"
                + "  )\n"
                + "WHERE to_date(FECHA_AUDIENCIA,'dd/mm/yyyy') <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_AUDIENCIA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha del ultimo acto procesal no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Acto_ProcesalNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT SUBSTR(ID_ORGANOJ,0,2), ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_ULT_ACT_PROC,'DD/MM/YYYY') FECHA_ULT_ACT_PROC\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE (PERIODO = '" + PValidacion.periodo + "'\n"
                + "  AND FECHA_ULT_ACT_PROC <> '09/09/1899'\n"
                + "  AND ID_ORGANOJ = '" + PValidacion.clave_organo + "')\n"
                + "  OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND FECHA_ULT_ACT_PROC <> '09/09/1899'\n"
                + "  AND PERIODO = '" + PValidacion.periodo + "'))\n"
                + "WHERE to_date(FECHA_ULT_ACT_PROC,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4 ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_ULT_ACT_PROC")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha en la que se dictó la resolución (Emplazamiento/Prehuelga) no debe de ser menor o igual a la fecha de apertura del expediente PUEDE SER MAYOR O IGUAL A LA FECHA DE APERTURA  CUANDO LA FASE EN LA QUE SE SOLUCIONO EL EXPEDIENTE NO SEA emplazamiento a huelga” o “prehuelga”  Y LA FORMA DE SOLUCION NO SEA NO DAR TRAMITE AL ESCRITO DE EMPLAZAMIENTO POR NO CUMPLIR CON LOS REQUISITOS ESTABLECIDOS
    public ArrayList Fecha_Resolu_EmplazNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT *\n"
                + "  FROM\n"
                + "    (SELECT SUBSTR(ID_ORGANOJ,0,2), ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_FASE_SOL_EXPED, ID_FORMA_SOLUCION, ID_TIPO_EXPEDIENTE,\n"
                + "      TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "      TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION\n"
                + "    FROM TR_EXPEDIENTE\n"
                + "    WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "    AND FECHA_DICTO_SOLUCION   <> '09/09/1899'\n"
                + "    AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "    OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "    AND FECHA_DICTO_SOLUCION   <> '09/09/1899'\n"
                + "    AND PERIODO                = '" + PValidacion.periodo + "'))\n"
                + "  WHERE to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "  and ID_FASE_SOL_EXPED = 7\n"
                + "  and ID_FORMA_SOLUCION in (6,7,8,1,2,9)\n"
                + "  and ID_TIPO_EXPEDIENTE = 4)";
        //where FASE_SOLI_EXPEDIENTE not in (5,6) and FORMA_SOLUCION_EMPLAZ not in (1) System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha en la que se dictó la resolución (Huelga) no debe de ser menor a la fecha de apertura del expediente.
    public ArrayList Fecha_Resolu_HuelgaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT SUBSTR(ID_ORGANOJ,0,2), ID_ORGANOJ, CLAVE_EXPEDIENTE,  PERIODO, ID_TIPO_EXPEDIENTE, ID_FASE_SOL_EXPED,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY') FECHA_DICTO_SOLUCION\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "  AND FECHA_DICTO_SOLUCION   <> '09/09/1899'\n"
                + "  AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "  OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND FECHA_DICTO_SOLUCION   <> '09/09/1899'\n"
                + "  AND PERIODO                = '" + PValidacion.periodo + "' ))\n"
                + "WHERE to_date(FECHA_DICTO_SOLUCION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4\n"
                + "AND ID_FASE_SOL_EXPED = 7 ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_DICTO_SOLUCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha de estallamiento de la huelga no debe de ser menor o igual a la fecha de apertura del expediente.
    public ArrayList Fecha_Estallam_HuelgaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "  SELECT SUBSTR(ID_ORGANOJ,0,2), ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_FASE_SOL_EXPED, ID_TIPO_EXPEDIENTE,\n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_HUELGA_ESTALLA,'DD/MM/YYYY') FECHA_HUELGA_ESTALLA\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE (PERIODO              = '" + PValidacion.periodo + "'\n"
                + "  AND FECHA_HUELGA_ESTALLA <> '09/09/1899'\n"
                + "  AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "')\n"
                + "  OR (SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND FECHA_HUELGA_ESTALLA <> '09/09/1899'\n"
                + "  AND PERIODO                = '" + PValidacion.periodo + "'))\n"
                + "WHERE to_date(FECHA_HUELGA_ESTALLA,'dd/mm/yyyy') <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_FASE_SOL_EXPED = 7 AND ID_TIPO_EXPEDIENTE = 4  ";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_HUELGA_ESTALLA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Query de validacion donde la Fecha de levantamiento de la huelga no debe de ser menor o igual a la fecha de apertura del expediente.
    public ArrayList Fecha_Levant_HuelgaNE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT SUBSTR(ID_ORGANOJ,0,2) AS entidad_clave, ID_ORGANOJ, CLAVE_EXPEDIENTE, periodo, ID_TIPO_EXPEDIENTE, \n"
                + "    TO_CHAR(FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED,\n"
                + "    TO_CHAR(FECHA_HUELGA_LEVANTAM,'DD/MM/YYYY') FECHA_HUELGA_LEVANTAM\n"
                + "  FROM TR_EXPEDIENTE\n"
                + "  WHERE periodo              = '" + PValidacion.periodo + "'\n"
                + "  AND FECHA_HUELGA_LEVANTAM   <> '09/09/1899'\n"
                + "  AND ID_ORGANOJ           ='" + PValidacion.clave_organo + "'\n"
                + "  OR SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "  AND FECHA_HUELGA_LEVANTAM   <> '09/09/1899'\n"
                + "  AND periodo                = '" + PValidacion.periodo + "'\n"
                + "  )\n"
                + "WHERE to_date(FECHA_HUELGA_LEVANTAM,'dd/mm/yyyy') <= to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy')\n"
                + "AND ID_TIPO_EXPEDIENTE = 4";
        //System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("entidad_clave"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("FECHA_HUELGA_LEVANTAM")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

// LA FECHA DE AUDIENCIA CELEBRARA NO DEBE SER MENOR A LA FECHA DE PRESENTACION DE LA DEMANDA
    public ArrayList Fecha_Aud_Presentacion() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM\n"
                + "  (SELECT SUBSTR(P.ID_ORGANOJ,0,2) AS ENTIDAD_CLAVE,\n"
                + "    P.ID_ORGANOJ,\n"
                + "    S.CLAVE_EXPEDIENTE,\n"
                + "    TO_CHAR(P.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,\n"
                + "    TO_CHAR(S.FECHA_PRESENT_DEMANDA,'DD/MM/YYYY') FECHA_PRESENT_DEMANDA,\n"
                + "    S.ID_TIPO_EXPEDIENTE ,\n"
                + "    P.PERIODO,\n"
                + "    P.ID_AUDIENCIA\n"
                + "  FROM TR_AUDIENCIA P,\n"
                + "    TR_EXPEDIENTE S\n"
                + "  WHERE P.ID_ORGANOJ                          =S.ID_ORGANOJ\n"
                + "  AND S.CLAVE_EXPEDIENTE                      =S.CLAVE_EXPEDIENTE\n"
                + "  AND P.PERIODO                               =S.PERIODO\n"
                + "  AND P.ID_EXPEDIENTE                         = S.ID_EXPEDIENTE\n"
                + "  AND S.ID_TIPO_EXPEDIENTE                    = 4\n"
                + "  AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_PRESENT_DEMANDA,'dd/mm/yyyy')\n"
                + "  )\n"
                + "WHERE periodo              = '" + PValidacion.periodo + "'\n"
                + "AND FECHA_CELEBRACION     <> '09/09/1899'\n"
                + "AND FECHA_PRESENT_DEMANDA <> '09/09/1899'\n"
                + "AND ID_ORGANOJ             ='" + PValidacion.clave_organo + "'\n"
                + "OR SUBSTR(ID_ORGANOJ,0,2)  ='" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_CELEBRACION     <> '09/09/1899'\n"
                + "AND FECHA_PRESENT_DEMANDA <> '09/09/1899'\n"
                + "AND periodo                = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD_CLAVE"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_PRESENT_DEMANDA"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Fecha_Aud_Apertura() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT  P.ID_ORGANOJ, P.CLAVE_EXPEDIENTE, P.PERIODO, P.ID_TIPO_EXPEDIENTE,\n"
                + "  TO_CHAR(S.FECHA_CELEBRACION,'DD/MM/YYYY')FECHA_CELEBRACION,\n"
                + "  TO_CHAR(P.FECHA_APERTURA_EXPED,'DD/MM/YYYY') FECHA_APERTURA_EXPED\n"
                + "FROM TR_EXPEDIENTE P\n"
                + "LEFT JOIN TR_AUDIENCIA S\n"
                + "  ON P.ID_ORGANOJ = S.ID_ORGANOJ AND P.PERIODO = S.PERIODO AND P.ID_EXPEDIENTE = S.ID_AUDIENCIA\n"
                + "WHERE P.ID_TIPO_EXPEDIENTE = 4\n"
                + "AND to_date(FECHA_CELEBRACION,'dd/mm/yyyy') < to_date(FECHA_APERTURA_EXPED,'dd/mm/yyyy'))\n"
                + "WHERE PERIODO =  '" + PValidacion.periodo + "'\n"
                + "AND FECHA_CELEBRACION <> '09/09/1899'\n"
                + "AND FECHA_APERTURA_EXPED <> '09/09/1899'\n"
                + "AND ID_ORGANOJ = '" + PValidacion.clave_organo + "'\n"
                + "OR SUBSTR(ID_ORGANOJ,0,2) = '" + PValidacion.clave_entidad + "'\n"
                + "AND FECHA_CELEBRACION <> '09/09/1899'\n"
                + "AND FECHA_APERTURA_EXPED <> '09/09/1899'\n"
                + "AND PERIODO = '" + PValidacion.periodo + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD_CLAVE"),
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("FECHA_CELEBRACION"),
                    resul.getString("FECHA_APERTURA_EXPED"),
                    resul.getString("ID_AUDIENCIA")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Huelga() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ,\n"
                + "  CLAVE_EXPEDIENTE,\n"
                + "  DECODE(ID_ESTATUS_EXPED,1,'Solucionado')ID_ESTATUS_EXPED,\n"
                + "  DECODE(ID_FASE_SOL_EXPED,7,'Huelga')ID_FASE_SOL_EXPED,\n"
                + "  DECODE(PREG_HUELGA_EMPLAZAM,'1','SI','2','NO')PREG_HUELGA_EMPLAZAM,\n"
                + "  DECODE(PREG_PREHUELGA,'1','SI','2','NO')PREG_PREHUELGA,\n"
                + "  DECODE(PREG_HUELGA_ESTALLA,'1','SI','2','NO')PREG_HUELGA_ESTALLA,\n"
                + "  TO_CHAR(FECHA_HUELGA_ESTALLA,'DD/MM/YYYY')FECHA_HUELGA_ESTALLA,\n"
                + "  TO_CHAR(FECHA_HUELGA_EMPLAZAM,'DD/MM/YYYY')FECHA_HUELGA_EMPLAZAM ,\n"
                + "  TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION,\n"
                + "  TO_CHAR(FECHA_HUELGA_LEVANTAM,'DD/MM/YYYY')FECHA_HUELGA_LEVANTAM,\n"
                + "  PERIODO\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ((( ID_FASE_SOL_EXPED=7\n"
                + "AND ID_ESTATUS_EXPED        =1)\n"
                + "AND (PREG_HUELGA_EMPLAZAM    <>1\n"
                + "OR PREG_PREHUELGA                 <>1\n"
                + "OR PREG_HUELGA_ESTALLA      <>1\n"
                + "OR FECHA_DICTO_SOLUCION       IN (NULL,'09/09/1899')\n"
                + "OR FECHA_HUELGA_ESTALLA     IN (NULL,'09/09/1899')\n"
                + "OR FECHA_HUELGA_LEVANTAM       IN (NULL,'09/09/1899')))\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "')))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_FASE_SOL_EXPED"),
                    resul.getString("PREG_HUELGA_EMPLAZAM"),
                    resul.getString("PREG_PREHUELGA"),
                    resul.getString("PREG_HUELGA_ESTALLA"),
                    resul.getString("FECHA_ESTALLAM_HUELGA"),
                    resul.getString("FECHA_HUELGA_EMPLAZAM"),
                    resul.getString("FECHA_RESOLU_HUELGA"),
                    resul.getString("FECHA_LEVANT_HUELGA"),
                    resul.getString("PERIODO")

                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList EMPLAZAMIENTO_HUELGA() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO,\n"
                + "  DECODE(ID_ESTATUS_EXPED,1,'Solucionado')ID_ESTATUS_EXPED,\n"
                + "  DECODE(ID_FASE_SOL_EXPED,5,'Emplazamiento a huelga')ID_FASE_SOL_EXPED,\n"
                + "  DECODE(PREG_HUELGA_EMPLAZAM,'1','SI','2','NO')PREG_HUELGA_EMPLAZAM,\n"
                + "  DECODE(PREG_PREHUELGA,'1','SI','2','NO')PREG_PREHUELGA,\n"
                + "  DECODE(PREG_HUELGA_ESTALLA,'1','SI','2','NO')PREG_HUELGA_ESTALLA ,\n"
                + "  TO_CHAR(FECHA_HUELGA_EMPLAZAM,'DD/MM/YYYY')FECHA_HUELGA_EMPLAZAM,\n"
                + "  TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ((( ID_FASE_SOL_EXPED = 5\n"
                + "AND ID_ESTATUS_EXPED        =1)\n"
                + "AND (PREG_HUELGA_ESTALLA    <>2\n"
                + "OR PREG_PREHUELGA                 <>2))\n"
                + "AND PREG_HUELGA_EMPLAZAM IN (1,2)\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND PERIODO                   ='" + PValidacion.periodo + "'))) ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_FASE_SOL_EXPED"),
                    resul.getString("PREG_HUELGA_EMPLAZAM"),
                    resul.getString("PREG_PREHUELGA"),
                    resul.getString("PREG_HUELGA_ESTALLA"),
                    resul.getString("FECHA_HUELGA_EMPLAZAM"),
                    resul.getString("FECHA_DICTO_SOLUCION"),
                    resul.getString("PERIODO")

                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList PREHUELGA() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ORGANOJ, CLAVE_EXPEDIENTE, PERIODO, ID_TIPO_EXPEDIENTE,\n"
                + "  DECODE(ID_ESTATUS_EXPED,1,'Solucionado')ID_ESTATUS_EXPED,\n"
                + "  DECODE(ID_FASE_SOL_EXPED,6,'PREG_PREHUELGA')ID_FASE_SOL_EXPED,\n"
                + "  DECODE(PREG_HUELGA_EMPLAZAM,'1','SI','2','NO')PREG_HUELGA_EMPLAZAM,\n"
                + "  DECODE(PREG_PREHUELGA,'1','SI','2','NO')PREG_PREHUELGA,\n"
                + "  DECODE(PREG_HUELGA_ESTALLA,'1','SI','2','NO')PREG_HUELGA_ESTALLA ,\n"
                + "  TO_CHAR(FECHA_HUELGA_EMPLAZAM,'DD/MM/YYYY')FECHA_HUELGA_EMPLAZAM,\n"
                + "  TO_CHAR(FECHA_DICTO_SOLUCION,'DD/MM/YYYY')FECHA_DICTO_SOLUCION\n"
                + "FROM TR_EXPEDIENTE\n"
                + "WHERE ID_TIPO_EXPEDIENTE = 4\n"
                + "and ((( ID_FASE_SOL_EXPED = 6\n"
                + "AND ID_ESTATUS_EXPED        =1)\n"
                + "AND (PREG_HUELGA_ESTALLA    <>2\n"
                + "OR PREG_PREHUELGA                 <>1\n"
                + "OR PREG_HUELGA_EMPLAZAM      <>1))\n"
                + "AND ((SUBSTR(ID_ORGANOJ,0,2)='" + PValidacion.clave_entidad + "'\n"
                + "AND periodo                   ='" + PValidacion.periodo + "')\n"
                + "OR (ID_ORGANOJ              ='" + PValidacion.clave_organo + "'\n"
                + "AND periodo                   ='" + PValidacion.periodo + "')))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ORGANOJ"),
                    resul.getString("CLAVE_EXPEDIENTE"),
                    resul.getString("ID_ESTATUS_EXPED"),
                    resul.getString("ID_FASE_SOL_EXPED"),
                    resul.getString("PREG_HUELGA_EMPLAZAM"),
                    resul.getString("PREG_PREHUELGA"),
                    resul.getString("PREG_HUELGA_ESTALLA"),
                    resul.getString("FECHA_HUELGA_EMPLAZAM"),
                    resul.getString("FECHA_DICTO_SOLUCION"),
                    resul.getString("PERIODO")
                });

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
