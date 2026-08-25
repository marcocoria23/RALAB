/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerQuery;

import Conexion.OracleConexionRalFed;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryTmpToTrFED {

    OracleConexionRalFed conexionFed = new OracleConexionRalFed();

    ResultSet resul;
    String sql = "";
    ArrayList<ArrayList<String>> arrayList;

    // TR_FED_AUDIENCIAS
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_AUDIENCIAS() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "CAST_TC_FED_AUD_TIPO_PROCE (ID_PROCEDIMIENTO,'TR_FED_AUDIENCIAS', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_PROCEDIMIENTO')ID_PROCEDIMIENTO,\n"
                + "ID_AUDIENCIA,\n"
                + "CAST_TC_FED_AUD_TIPO_AUDIEN (ID_TIPO_AUDIENCIA,'TR_FED_AUDIENCIAS', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_AUDIENCIA')ID_TIPO_AUDIENCIA,\n"
                + "FECHA_CELEBRACION,\n"
                + "DURACI_INICIO,\n"
                + "DURACI_CONCLUSION,\n"
                + "-2 COD_ORG,\n"
                + "-2 COD_EXPE\n"
                + "FROM TMP_FED_AUDIENCIAS";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna  
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_AUDIENCIAS" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    // TR_FED_COLECTIVO 
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_COLECTIVO() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO,\n"
                + "CAST_TC_FED_NAT_CONFLICTO(ID_NAT_CONFLICTO, 'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_NAT_CONFLICTO')ID_NAT_CONFLICTO,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "CAST_TC_FED_SECTOR_RAMA(RAMA_INVOLUC,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SECTOR') SECTOR,\n"
                + "CAST_TC_FED_SUBSECTOR_RAMA(RAMA_INVOLUC,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUBSECTOR')  SUBSECTOR,\n"
                + "ENTIDAD_PATRON ENTIDAD_NOMBRE_PAT,\n"
                + "CAST_TC_FED_ENTIDADES(ENTIDAD_PATRON,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ENTIDAD_CLAVE') ENTIDAD_PATRON,\n"
                + "MUNICIPIO_PATRON MUNICIPIO_NOMBRE_PAT,\n"
                + "CAST_TC_FED_MUNICIPIO(ENTIDAD_PATRON,MUNICIPIO_PATRON,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'MUNICIPIO_CLAVE')MUNICIPIO_PATRON,\n"
                + "NULL AS CANTIDAD_PRESTA_RECLAM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCOMPETENCIA,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CONSTANCIA,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONSTANCIA')PREG_CONSTANCIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_EXCEP_CONCILIA,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EXCEP_CONCILIA')PREG_EXCEP_CONCILIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_PREVENCION,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PREVENCION')PREG_PREVENCION,\n"
                + "CAST_TC_FED_ESTATUS_DEMANDA(ID_ESTATUS_DEMANDA,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_DEMANDA')ID_ESTATUS_DEMANDA,\n"
                + "CAST_TC_FED_CAU_IMPI_ADMI_DEM(ID_CAUSA_IMP_DEM,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_CAUSA_IMP_DEM')ID_CAUSA_IMP_DEM,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "CAST_CANTIDAD(CANT_ACTORES)CANT_ACTORES, \n"
                + "CAST_CANTIDAD(CANT_DEMANDADOS)CANT_DEMANDADOS,\n"
                + "CAST_TC_FED_SIMPLE(PREG_TRAMITACION_DEPURACION,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TRAMITACION_DEPURACION')PREG_TRAMITACION_DEPURACION,\n"
                + "FECHA_DEPURACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CELEBRA_AUD_JUICIO,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CELEBRA_AUD_JUICIO')PREG_CELEBRA_AUD_JUICIO,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "CAST_TC_FED_FASE_EXPEDIENTE(ID_FASE_SOL_EXPED,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED,\n"
                + "CAST_TC_FED_FORMA_SOLUCION(ID_FORMA_SOLUCION,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_TIPO_SENTENCIA(ID_SENTIDO_SENTEN,'TR_FED_COLECTIVO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_SENTIDO_SENTEN')ID_SENTIDO_SENTEN,\n"
                + "-2 COD_ORG,\n"
                + "-2 COD_EXPE\n"
                + "FROM TMP_FED_COLECTIVO";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna  
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                fila.add(resul.getString(32));
                fila.add(resul.getString(33));
                fila.add(resul.getString(34));
                fila.add(resul.getString(35));
                fila.add(resul.getString(36));
                fila.add(resul.getString(37));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_AUDIENCIAS" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_COLECTIVO_ECONOMICO
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_COLECTIVO_ECONOMICO() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT \n"
                + "NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO,\n"
                + "CAST_TC_FED_NAT_CONFLICTO(ID_NAT_CONFLICTO, 'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_NAT_CONFLICTO')ID_NAT_CONFLICTO,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "CAST_TC_FED_SECTOR_RAMA(RAMA_INVOLUC,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SECTOR') SECTOR,\n"
                + "CAST_TC_FED_SUBSECTOR_RAMA(RAMA_INVOLUC,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUBSECTOR')  SUBSECTOR,\n"
                + "ENTIDAD_PATRON ENTIDAD_NOMBRE_PAT,\n"
                + "CAST_TC_FED_ENTIDADES(ENTIDAD_PATRON,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ENTIDAD_CLAVE') ENTIDAD_PATRON,\n"
                + "MUNICIPIO_PATRON MUNICIPIO_NOMBRE_PAT,\n"
                + "CAST_TC_FED_MUNICIPIO(ENTIDAD_PATRON,MUNICIPIO_PATRON,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'MUNICIPIO_CLAVE')MUNICIPIO_PATRON,\n"
                + "NULL AS CANTIDAD_PRESTA_RECLAM,  ----------------- REALIZAR CONTEO\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCOMPETENCIA,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CONSTANCIA,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONSTANCIA')PREG_CONSTANCIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_EXCEP_CONCILIA,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EXCEP_CONCILIA')PREG_EXCEP_CONCILIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_PREVENCION,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PREVENCION')PREG_PREVENCION,\n"
                + "CAST_TC_FED_ESTATUS_DEMANDA(ID_ESTATUS_DEMANDA,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_DEMANDA')ID_ESTATUS_DEMANDA,\n"
                + "CAST_TC_FED_CAU_IMPI_ADMI_DEM(ID_CAUSA_IMP_DEM,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_CAUSA_IMP_DEM')ID_CAUSA_IMP_DEM,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "CAST_CANTIDAD(CANT_ACTORES)CANT_ACTORES, \n"
                + "CAST_CANTIDAD(CANT_DEMANDADOS)CANT_DEMANDADOS,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CELEBRA_AUD_ECONOM,'TR_FED_COLECTIVO_ECONOMICO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CELEBRA_AUD_ECONOM') PREG_CELEBRA_AUD_ECONOM,\n"
                + "FECHA_AUD_ECONOM,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "CAST_TC_FED_FASE_EXPEDIENTE(ID_FASE_SOL_EXPED,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED,\n"
                + "CAST_TC_FED_FORMA_SOLUCION(ID_FORMA_SOLUCION,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_TIPO_SENTENCIA(ID_SENTIDO_SENTEN,'TR_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_SENTIDO_SENTEN')ID_SENTIDO_SENTEN\n"
                + ",-2 COD_ORG\n"
                + ",-2 COD_EXPE\n"
                + "FROM TMP_FED_COLECTIVO_ECONOMICO";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna  
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                fila.add(resul.getString(32));
                fila.add(resul.getString(33));
                fila.add(resul.getString(34));
                fila.add(resul.getString(35));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_AUDIENCIAS" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_COLECTIVO_ECONOMICO_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_COLECTIVO_ECONOMICO_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT *\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        ID_TIPO AS ID_TIPO_COLECTIVO_ECONOMICO,\n"
                + "        -2 COD_ORG,\n"
                + "        -2 COD_EXPE\n"
                + "    FROM (\n"
                + "        SELECT\n"
                + "            NOMBRE_ORGANO_JURIS,\n"
                + "            ID_ORGANOJ,\n"
                + "            CLAVE_EXPEDIENTE,\n"
                + "            CAST_TC_FED_SIMPLE(\n"
                + "                NUEVAS_COND_TRABAJO,\n"
                + "                'TMP_FED_COLECTIVO_ECONOMICO',\n"
                + "                ID_ORGANOJ,\n"
                + "                CLAVE_EXPEDIENTE,\n"
                + "                'NUEVAS_COND_TRABAJO'\n"
                + "            ) AS NUEVAS_COND_TRABAJO,\n"
                + "            CAST_TC_FED_SIMPLE(\n"
                + "                AVISO_SUSP_COLECTIVA,\n"
                + "                'TMP_FED_COLECTIVO_ECONOMICO',\n"
                + "                ID_ORGANOJ,\n"
                + "                CLAVE_EXPEDIENTE,\n"
                + "                'AVISO_SUSP_COLECTIVA'\n"
                + "            ) AS AVISO_SUSP_COLECTIVA\n"
                + "        FROM TMP_FED_COLECTIVO_ECONOMICO\n"
                + "    )\n"
                + "    UNPIVOT (\n"
                + "        VALOR FOR ID_TIPO IN (\n"
                + "            NUEVAS_COND_TRABAJO AS 1,\n"
                + "            AVISO_SUSP_COLECTIVA AS 2\n"
                + "        )\n"
                + "    )\n"
                + "    WHERE VALOR = 1\n"
                + "    UNION ALL\n"
                + "    SELECT *  FROM (\n"
                + "        SELECT\n"
                + "            NOMBRE_ORGANO_JURIS,\n"
                + "            ID_ORGANOJ,\n"
                + "            CLAVE_EXPEDIENTE,\n"
                + "            CASE\n"
                + "                WHEN CAST_TC_FED_SIMPLE( NUEVAS_COND_TRABAJO, 'TMP_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'NUEVAS_COND_TRABAJO') in (2,9)\n"
                + "                AND CAST_TC_FED_SIMPLE( AVISO_SUSP_COLECTIVA, 'TMP_FED_COLECTIVO_ECONOMICO', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'AVISO_SUSP_COLECTIVA') in (2,9)\n"
                + "                THEN 9\n"
                + "                ELSE -2\n"
                + "            END AS ID_TIPO_COLECTIVO_ECONOMICO,\n"
                + "            -2 COD_ORG,\n"
                + "            -2 COD_EXPE\n"
                + "        FROM TMP_FED_COLECTIVO_ECONOMICO))WHERE ID_TIPO_COLECTIVO_ECONOMICO<>-2";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_COLECTIVO_ECONOMICO_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_COLECTIVO_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_COLECTIVO_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT * FROM(\n"
                + "SELECT\n"
                + "    NOMBRE_ORGANO_JURIS,\n"
                + "    ID_ORGANOJ,\n"
                + "    CLAVE_EXPEDIENTE,\n"
                + "    ID_TIPO AS ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "    -2 COD_ORG,\n"
                + "    -2 COD_EXPE\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "     CAST_TC_FED_SIMPLE (TIRULARIDAD,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'TIRULARIDAD')TIRULARIDAD,\n"
                + "CAST_TC_FED_SIMPLE (VIOLA_DERECHOS,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'VIOLA_DERECHOS')VIOLA_DERECHOS,\n"
                + "CAST_TC_FED_SIMPLE (CUOTAS,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CUOTAS')CUOTAS,\n"
                + "CAST_TC_FED_SIMPLE (CAN_REG_SINDICATO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CAN_REG_SINDICATO')CAN_REG_SINDICATO,\n"
                + "CAST_TC_FED_SIMPLE (IMPUGNA_SINDICALES,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'IMPUGNA_SINDICALES')IMPUGNA_SINDICALES,\n"
                + "CAST_TC_FED_SIMPLE (DERECHO_VOTAR,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DERECHO_VOTAR')DERECHO_VOTAR,\n"
                + "CAST_TC_FED_SIMPLE (DERECHO_SER_VOTADO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DERECHO_SER_VOTADO')DERECHO_SER_VOTADO,\n"
                + "CAST_TC_FED_SIMPLE (DECLARA_PERDIDA_CONTRATO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DECLARA_PERDIDA_CONTRATO')DECLARA_PERDIDA_CONTRATO,\n"
                + "CAST_TC_FED_SIMPLE (REDUCCION_PERSONAL,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REDUCCION_PERSONAL')REDUCCION_PERSONAL,\n"
                + "CAST_TC_FED_SIMPLE (REVISION_REGLAMENTO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REVISION_REGLAMENTO')REVISION_REGLAMENTO,\n"
                + "CAST_TC_FED_SIMPLE (TERMINACION_COLECTIVA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'TERMINACION_COLECTIVA')TERMINACION_COLECTIVA,\n"
                + "CAST_TC_FED_SIMPLE (DECLARACION_PERDIDA_MAYORIA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DECLARACION_PERDIDA_MAYORIA')DECLARACION_PERDIDA_MAYORIA,\n"
                + "CAST_TC_FED_SIMPLE (SUSPENSIÓN_COLECTIVA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUSPENSIÓN_COLECTIVA')SUSPENSIÓN_COLECTIVA,\n"
                + "CAST_TC_FED_SIMPLE (REVISION_CAUSA_SUSPEN,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REVISION_CAUSA_SUSPEN')REVISION_CAUSA_SUSPEN\n"
                + "    FROM TMP_FED_COLECTIVO\n"
                + ")\n"
                + "UNPIVOT (\n"
                + "    VALOR FOR ID_TIPO IN (\n"
                + "        TIRULARIDAD AS 1,\n"
                + " VIOLA_DERECHOS AS 2,\n"
                + " CUOTAS AS 3,\n"
                + " CAN_REG_SINDICATO AS 4,\n"
                + " IMPUGNA_SINDICALES AS 5,\n"
                + " DERECHO_VOTAR AS 6,\n"
                + " DERECHO_SER_VOTADO AS 7,\n"
                + " DECLARA_PERDIDA_CONTRATO AS 8,\n"
                + " REDUCCION_PERSONAL AS 9,\n"
                + " REVISION_REGLAMENTO AS 10,\n"
                + " TERMINACION_COLECTIVA AS 11,\n"
                + " DECLARACION_PERDIDA_MAYORIA AS 12,\n"
                + " SUSPENSIÓN_COLECTIVA AS 13,\n"
                + " REVISION_CAUSA_SUSPEN AS 14\n"
                + "    )\n"
                + ")WHERE VALOR=1 \n"
                + "UNION ALL\n"
                + "select * from(\n"
                + "SELECT NOMBRE_ORGANO_JURIS,ID_ORGANOJ,CLAVE_EXPEDIENTE,\n"
                + "CASE WHEN CAST_TC_FED_SIMPLE (TIRULARIDAD,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'TIRULARIDAD')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (VIOLA_DERECHOS,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'VIOLA_DERECHOS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (CUOTAS,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CUOTAS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (CAN_REG_SINDICATO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CAN_REG_SINDICATO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (IMPUGNA_SINDICALES,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'IMPUGNA_SINDICALES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (DERECHO_VOTAR,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DERECHO_VOTAR')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (DERECHO_SER_VOTADO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DERECHO_SER_VOTADO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (DECLARA_PERDIDA_CONTRATO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DECLARA_PERDIDA_CONTRATO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (REDUCCION_PERSONAL,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REDUCCION_PERSONAL')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (REVISION_REGLAMENTO,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REVISION_REGLAMENTO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (TERMINACION_COLECTIVA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'TERMINACION_COLECTIVA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (DECLARACION_PERDIDA_MAYORIA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'DECLARACION_PERDIDA_MAYORIA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (SUSPENSIÓN_COLECTIVA,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUSPENSIÓN_COLECTIVA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (REVISION_CAUSA_SUSPEN,'TR_FED_COLECTIVO_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'REVISION_CAUSA_SUSPEN')IN ('2','9') THEN 99\n"
                + "        ELSE -2\n"
                + "         END ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "         -2 COD_ORG,\n"
                + "        -2 COD_EXPE\n"
                + "    FROM TMP_FED_COLECTIVO))WHERE ID_TIPO_PRESTACION_RECLAMADA<>-2";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna 
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_COLECTIVO_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    // TR_FED_CONTROL_EXPEDIENTE
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_CONTROL_EXPEDIENTE() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT\n"
                + "    ID AS ID_CONTROL,\n"
                + "    NOMBRE_ORGANO_JURIS,\n"
                + "    ID_ORGANO AS ID_ORGANOJ,\n"
                + "    SEDE,\n"
                + "    JUECES_LABORAL_TOTAL,\n"
                + "    JUECES_LABORAL_TOT_HOM,\n"
                + "    JUECES_LABORAL_TOT_MUJ,\n"
                + "    HORARIO,\n"
                + "    ENTIDAD_NOMBRE,\n"
                + "    ENTIDAD_CLAVE,\n"
                + "    MUNICIPIO_NOMBRE,\n"
                + "    MUNICIPIO_CLAVE,\n"
                + "    DOMICILIO,\n"
                + "    LATITUD,\n"
                + "    LONGITUD,\n"
                + "    CIRCUNS_ORG_JUR,\n"
                + "    JURISDICCION,\n"
                + "    ORDINARIO,\n"
                + "    ESPECIAL_INDIVI,\n"
                + "    ESPECIAL_COLECT,\n"
                + "    HUELGA,\n"
                + "    SEGURIDAD_SOCIAL,\n"
                + "    COL_NATU_ECONOMICA,\n"
                + "    PARAP_VOLUNTARIO,\n"
                + "    EJECUCION,\n"
                + "    FECHA_ALTA,\n"
                + "    FECHA_BAJA,\n"
                + "    ACTIVO,\n"
                + "    OBSERVACIONES,\n"
                + "    -2 AS COD_ORG,\n"
                + "    -2 AS ORGANO_JUR_REG\n"
                + "FROM TMP_FED_CONTROL_EXPEDIENTE";
        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna  
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_CONTROL_EXPEDIENTE" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_EJECUCION
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_EJECUCION() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_SIMPLE(PREG_MOTIV_CONVENI_CELE,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MOTIV_CONVENI_CELE')PREG_MOTIV_CONVENI_CELE,\n"
                + "CAST_TC_FED_SIMPLE(PREG_MOTIV_MEDIA_PROMOC,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MOTIV_MEDIA_PROMOC')PREG_MOTIV_MEDIA_PROMOC,\n"
                + "CAST_TC_FED_SIMPLE(PREG_MOTIV_LAUDO_ARBIT,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MOTIV_LAUDO_ARBIT')PREG_MOTIV_LAUDO_ARBIT,\n"
                + "CAST_TC_FED_SIMPLE(PREG_MOTIV_RESOL_COLEC_NAT_ECO,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MOTIV_RESOL_COLEC_NAT_ECO')PREG_MOTIV_RESOL_COLEC_NAT_ECO,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_FASE_CONCLUSION_EJE(ID_FASE_CONCLU_EXPED,'TR_FED_EJECUCION', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_CONCLU_EXPED')ID_FASE_CONCLU_EXPED,\n"
                + "-2 COD_ORG,\n"
                + "-2 COD_EXPE\n"
                + "FROM TMP_FED_EJECUCION";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_EJECUCION" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_HUELGA
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_HUELGA() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_PRESENTACION,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "CAST_TC_FED_SECTOR_RAMA(RAMA_INVOLUC,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SECTOR') SECTOR,\n"
                + "CAST_TC_FED_SUBSECTOR_RAMA(RAMA_INVOLUC,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUBSECTOR')  SUBSECTOR,\n"
                + "ENTIDAD_CLAVE ENTIDAD_NOMBRE,\n"
                + "CAST_TC_FED_ENTIDADES(ENTIDAD_CLAVE,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ENTIDAD_CLAVE') ENTIDAD_CLAVE,\n"
                + "MUNICIPIO_CLAVE MUNICIPIO_NOMBRE,\n"
                + "CAST_TC_FED_MUNICIPIO(ENTIDAD_CLAVE,MUNICIPIO_CLAVE,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'MUNICIPIO_CLAVE')MUNICIPIO_CLAVE,\n"
                + "NULL AS CANTIDAD_PRESTA_RECLAM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCOMPETENCIA,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "CAST_CANTIDAD(CANT_ACTORES)CANT_ACTORES, \n"
                + "CAST_CANTIDAD(CANT_DEMANDADOS)CANT_DEMANDADOS,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "CAST_TC_FED_FASE_EXPEDIENTE(ID_FASE_SOL_EXPED,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED,\n"
                + "CAST_TC_FED_FORMA_SOLUCION_HUELGA(ID_FORMA_SOLUCION,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_ESTALLAMIENTO,'TR_FED_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_ESTALLAMIENTO,\n"
                + "FECHA_ESTALLAMIENTO\n"
                + ",-2 COD_ORG\n"
                + ",-2 COD_EXPE\n"
                + "FROM TMP_FED_HUELGA";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_HUELGA" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_HUELGA_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_HUELGA_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT * FROM(\n"
                + "SELECT\n"
                + "    NOMBRE_ORGANO_JURIS,\n"
                + "    ID_ORGANOJ,\n"
                + "    CLAVE_EXPEDIENTE,\n"
                + "    ID_TIPO AS ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "    -2 COD_ORG,\n"
                + "    -2 COD_EXPE\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "   CAST_TC_FED_SIMPLE (PREG_FIRMADECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_FIRMADECONTRATO')PREG_FIRMADECONTRATO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_REVISIONDECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REVISIONDECONTRATO')PREG_REVISIONDECONTRATO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_REVISIONDESALARIOS,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REVISIONDESALARIOS')PREG_REVISIONDESALARIOS,\n"
                + "CAST_TC_FED_SIMPLE (PREG_CUMPLIMIENTODECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CUMPLIMIENTODECONTRATO')PREG_CUMPLIMIENTODECONTRATO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_EQUILIBRIODELOSFACTORES,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EQUILIBRIODELOSFACTORES')PREG_EQUILIBRIODELOSFACTORES,\n"
                + "CAST_TC_FED_SIMPLE (PREG_HUELGA,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HUELGA')PREG_HUELGA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PARTICIPACIONDEUTILIDADES,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PARTICIPACIONDEUTILIDADES')PREG_PARTICIPACIONDEUTILIDADES\n"
                + "    FROM TMP_FED_HUELGA\n"
                + ")\n"
                + "UNPIVOT (\n"
                + "    VALOR FOR ID_TIPO IN (\n"
                + "      PREG_FIRMADECONTRATO AS 1,\n"
                + " PREG_REVISIONDECONTRATO AS 2,\n"
                + " PREG_REVISIONDESALARIOS AS 3,\n"
                + " PREG_CUMPLIMIENTODECONTRATO AS 4,\n"
                + " PREG_EQUILIBRIODELOSFACTORES AS 5,\n"
                + " PREG_HUELGA AS 6,\n"
                + " PREG_PARTICIPACIONDEUTILIDADES AS 7\n"
                + "    )\n"
                + ")WHERE VALOR=1 \n"
                + "UNION ALL\n"
                + "select * from(\n"
                + "SELECT NOMBRE_ORGANO_JURIS,ID_ORGANOJ,CLAVE_EXPEDIENTE,\n"
                + "CASE WHEN CAST_TC_FED_SIMPLE (PREG_FIRMADECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_FIRMADECONTRATO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_REVISIONDECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REVISIONDECONTRATO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_REVISIONDESALARIOS,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REVISIONDESALARIOS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_CUMPLIMIENTODECONTRATO,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CUMPLIMIENTODECONTRATO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_EQUILIBRIODELOSFACTORES,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EQUILIBRIODELOSFACTORES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_HUELGA,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HUELGA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PARTICIPACIONDEUTILIDADES,'TR_FED_PREST_RECL_HUELGA', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PARTICIPACIONDEUTILIDADES')IN ('2','9') THEN 9\n"
                + "        ELSE -2\n"
                + "         END ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "         -2 COD_ORG,\n"
                + "        -2 COD_EXPE\n"
                + "    FROM TMP_FED_HUELGA))WHERE ID_TIPO_PRESTACION_RECLAMADA<>-2";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_HUELGA_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_INDIVIDUAL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_INDIVIDUAL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT \n"
                + "NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPED,\n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO,\n"
                + "CAST_TC_FED_NAT_CONFLICTO(ID_NAT_CONFLICTO, 'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_NAT_CONFLICTO')ID_NAT_CONFLICTO,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "CAST_TC_FED_SECTOR_RAMA(RAMA_INVOLUC,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SECTOR') SECTOR,\n"
                + "CAST_TC_FED_SUBSECTOR_RAMA(RAMA_INVOLUC,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUBSECTOR')  SUBSECTOR,\n"
                + "CLAVE_ENTIDAD_PAT,\n"
                + "CAST_TC_FED_ENTIDADES (CLAVE_ENTIDAD_PAT,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CLAVE_ENTIDAD_PAT')CLAVE_ENTIDAD_PAT, \n"
                + "CLAVE_MUN_PAT,\n"
                + "CAST_TC_FED_MUNICIPIO (CLAVE_ENTIDAD_PAT,CLAVE_MUN_PAT,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CLAVE_ENTIDAD_MUN')CLAVE_ENTIDAD_MUN, \n"
                + "CAST_TC_FED_SIMPLE(PREG_SUBCONTRATACION,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUBCONTRATACION')PREG_SUBCONTRATACION,\n"
                + "NULL  CANTIDAD_PRESTA_RECLAM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCOMPETENCIA,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CONSTANCIA,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONSTANCIA')PREG_CONSTANCIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_EXCEP_CONCILIA,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EXCEP_CONCILIA')PREG_EXCEP_CONCILIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_PREVENCION,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PREVENCION')PREG_PREVENCION,\n"
                + "CAST_TC_FED_ESTATUS_DEMANDA(ID_ESTATUS_DEMANDA,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_DEMANDA')ID_ESTATUS_DEMANDA,\n"
                + "CAST_TC_FED_CAU_IMPI_ADMI_DEM(ID_CAUSA_IMP_DEM,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_CAUSA_IMP_DEM')ID_CAUSA_IMP_DEM,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "CAST_CANTIDAD(CANT_ACTORES)CANT_ACTORES, \n"
                + "CAST_CANTIDAD(CANT_DEMANDADOS)CANT_DEMANDADOS, \n"
                + "CAST_TC_FED_SIMPLE(PREG_TRAMITACION_DEPURACION,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TRAMITACION_DEPURACION')PREG_TRAMITACION_DEPURACION,\n"
                + "FECHA_DEPURACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_AUD_PRELIM_CELEBR,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AUD_PRELIM_CELEBR')PREG_AUD_PRELIM_CELEBR,\n"
                + "FECHA_AUDIENCIA_PRELIM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CELEBRA_AUD_JUICIO,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CELEBRA_AUD_JUICIO')PREG_CELEBRA_AUD_JUICIO,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "CAST_TC_FED_FASE_EXPEDIENTE(ID_FASE_SOL_EXPED,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED,\n"
                + "CAST_TC_FED_FORMA_SOLUCION(ID_FORMA_SOLUCION,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_TIPO_SENTENCIA(ID_SENTIDO_SENTEN,'TR_FED_INDIVIDUAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_SENTIDO_SENTEN')ID_SENTIDO_SENTEN\n"
                + ",-2 COD_ORG\n"
                + ",-2 COD_EXPE\n"
                + "FROM TMP_FED_INDIVIDUAL";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                fila.add(resul.getString(32));
                fila.add(resul.getString(33));
                fila.add(resul.getString(34));
                fila.add(resul.getString(35));
                fila.add(resul.getString(36));
                fila.add(resul.getString(37));
                fila.add(resul.getString(38));
                fila.add(resul.getString(39));
                fila.add(resul.getString(40));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_INDIVIDUAL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_INDIVIDUAL_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_INDIVIDUAL_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT * FROM(\n"
                + "SELECT\n"
                + "    NOMBRE_ORGANO_JURIS,\n"
                + "    ID_ORGANOJ,\n"
                + "    CLAVE_EXPEDIENTE,\n"
                + "    ID_TIPO AS ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "    -2 COD_ORG,\n"
                + "    -2 COD_EXPE\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        CAST_TC_FED_SIMPLE (PREG_SUSPENSION_TRABAJADOR,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUSPENSION_TRABAJADOR')PREG_SUSPENSION_TRABAJADOR,\n"
                + " CAST_TC_FED_SIMPLE (PREG_SUSPENSION_PATRON,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUSPENSION_PATRON')PREG_SUSPENSION_PATRON,\n"
                + " CAST_TC_FED_SIMPLE (PREG_INDEMNIZACION_PATRON,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INDEMNIZACION_PATRON')PREG_INDEMNIZACION_PATRON,\n"
                + " CAST_TC_FED_SIMPLE (PREG_AUTORIZACION_LABORAR,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AUTORIZACION_LABORAR')PREG_AUTORIZACION_LABORAR,\n"
                + " CAST_TC_FED_SIMPLE (PREG_RECONOCIMIENTO_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RECONOCIMIENTO_TRABAJO')PREG_RECONOCIMIENTO_TRABAJO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_CAPACITACION,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CAPACITACION')PREG_CAPACITACION,\n"
                + " CAST_TC_FED_SIMPLE (PREG_ADIESTRAMIENTO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ADIESTRAMIENTO')PREG_ADIESTRAMIENTO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_NULIDAD_CLAUSULA_CONTRA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_NULIDAD_CLAUSULA_CONTRA')PREG_NULIDAD_CLAUSULA_CONTRA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_CONDICIONES_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONDICIONES_TRABAJO')PREG_CONDICIONES_TRABAJO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_HORAS_EXTRA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HORAS_EXTRA')PREG_HORAS_EXTRA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_HABITACION,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HABITACION')PREG_HABITACION,\n"
                + " CAST_TC_FED_SIMPLE (PREG_CREDITOS,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CREDITOS')PREG_CREDITOS,\n"
                + " CAST_TC_FED_SIMPLE (PREG_CAPACITACION_ADIESTRAMI,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CAPACITACION_ADIESTRAMI')PREG_CAPACITACION_ADIESTRAMI,\n"
                + " CAST_TC_FED_SIMPLE (PREG_PRIMA_ANTIGUEDAD,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRIMA_ANTIGUEDAD')PREG_PRIMA_ANTIGUEDAD,\n"
                + " CAST_TC_FED_SIMPLE (PREG_REGLAMENTO_INTER_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REGLAMENTO_INTER_TRABAJO')PREG_REGLAMENTO_INTER_TRABAJO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_RENTA_MAX_HAB_TRABAJADOR,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RENTA_MAX_HAB_TRABAJADOR')PREG_RENTA_MAX_HAB_TRABAJADOR,\n"
                + " CAST_TC_FED_SIMPLE (PREG_OBLIGA_DERIV_RENTA_HAB,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_OBLIGA_DERIV_RENTA_HAB')PREG_OBLIGA_DERIV_RENTA_HAB,\n"
                + " CAST_TC_FED_SIMPLE (PREG_COBRO_PRESTA_SALARIO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_COBRO_PRESTA_SALARIO')PREG_COBRO_PRESTA_SALARIO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_ALOJAMIENTO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ALOJAMIENTO')PREG_ALOJAMIENTO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_SALARIO_BASE_COTIZACION,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SALARIO_BASE_COTIZACION')PREG_SALARIO_BASE_COTIZACION,\n"
                + " CAST_TC_FED_SIMPLE (PREG_INCAPACI_PERMA_PARCIAL,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCAPACI_PERMA_PARCIAL')PREG_INCAPACI_PERMA_PARCIAL,\n"
                + " CAST_TC_FED_SIMPLE (PREG_MUERTE,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MUERTE')PREG_MUERTE,\n"
                + " CAST_TC_FED_SIMPLE (PREG_PENSION_ASCENDENCIA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PENSION_ASCENDENCIA')PREG_PENSION_ASCENDENCIA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_PENSION_GARANTIZADA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PENSION_GARANTIZADA')PREG_PENSION_GARANTIZADA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_INCRE_PENSION,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCRE_PENSION')PREG_INCRE_PENSION,\n"
                + " CAST_TC_FED_SIMPLE (PREG_INDEMNIZACION_GLOBAL,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INDEMNIZACION_GLOBAL')PREG_INDEMNIZACION_GLOBAL,\n"
                + " CAST_TC_FED_SIMPLE (PREG_ASISTENCIA_MEDICA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ASISTENCIA_MEDICA')PREG_ASISTENCIA_MEDICA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_APARATOS_PROT_ORTOP,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_APARATOS_PROT_ORTOP')PREG_APARATOS_PROT_ORTOP,\n"
                + " CAST_TC_FED_SIMPLE (PREG_RIESGOS_SALARIO_BASE,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RIESGOS_SALARIO_BASE')PREG_RIESGOS_SALARIO_BASE,\n"
                + " CAST_TC_FED_SIMPLE (PREG_RIESGOS_PAGO_INDEMNIZA,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RIESGOS_PAGO_INDEMNIZA')PREG_RIESGOS_PAGO_INDEMNIZA,\n"
                + " CAST_TC_FED_SIMPLE (PREG_RIESGO_OPOSICION_DESIG,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RIESGO_OPOSICION_DESIG')PREG_RIESGO_OPOSICION_DESIG,\n"
                + " CAST_TC_FED_SIMPLE (PREG_DESIGNACION_FALLECIDO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESIGNACION_FALLECIDO')PREG_DESIGNACION_FALLECIDO,\n"
                + " CAST_TC_FED_SIMPLE (PREG_DESIGNACION_DESAPARECIDO,'TR_FED_INDIVIDUAL_PREST_RECL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESIGNACION_DESAPARECIDO')PREG_DESIGNACION_DESAPARECIDO\n"
                + "    FROM TMP_FED_INDIVIDUAL\n"
                + ")\n"
                + "UNPIVOT (\n"
                + "    VALOR FOR ID_TIPO IN (\n"
                + "        PREG_SUSPENSION_TRABAJADOR AS 1,\n"
                + "PREG_SUSPENSION_PATRON AS 2,\n"
                + "PREG_INDEMNIZACION_PATRON AS 3,\n"
                + "PREG_AUTORIZACION_LABORAR AS 4,\n"
                + "PREG_RECONOCIMIENTO_TRABAJO AS 5,\n"
                + "PREG_CAPACITACION AS 6,\n"
                + "PREG_ADIESTRAMIENTO AS 7,\n"
                + "PREG_NULIDAD_CLAUSULA_CONTRA AS 8,\n"
                + "PREG_CONDICIONES_TRABAJO AS 9,\n"
                + "PREG_HORAS_EXTRA AS 10,\n"
                + "PREG_HABITACION AS 11,\n"
                + "PREG_CREDITOS AS 12,\n"
                + "PREG_CAPACITACION_ADIESTRAMI AS 13,\n"
                + "PREG_PRIMA_ANTIGUEDAD AS 14,\n"
                + "PREG_REGLAMENTO_INTER_TRABAJO AS 15,\n"
                + "PREG_RENTA_MAX_HAB_TRABAJADOR AS 16,\n"
                + "PREG_OBLIGA_DERIV_RENTA_HAB AS 17,\n"
                + "PREG_COBRO_PRESTA_SALARIO AS 18,\n"
                + "PREG_ALOJAMIENTO AS 19,\n"
                + "PREG_SALARIO_BASE_COTIZACION AS 20,\n"
                + "PREG_INCAPACI_PERMA_PARCIAL AS 21,\n"
                + "PREG_MUERTE AS 22,\n"
                + "PREG_PENSION_ASCENDENCIA AS 23,\n"
                + "PREG_PENSION_GARANTIZADA AS 24,\n"
                + "PREG_INCRE_PENSION AS 25,\n"
                + "PREG_INDEMNIZACION_GLOBAL AS 26,\n"
                + "PREG_ASISTENCIA_MEDICA AS 27,\n"
                + "PREG_APARATOS_PROT_ORTOP AS 28,\n"
                + "PREG_RIESGOS_SALARIO_BASE AS 29,\n"
                + "PREG_RIESGOS_PAGO_INDEMNIZA AS 30,\n"
                + "PREG_RIESGO_OPOSICION_DESIG AS 31,\n"
                + "PREG_DESIGNACION_FALLECIDO AS 32,\n"
                + "PREG_DESIGNACION_DESAPARECIDO AS 33\n"
                + "    )\n"
                + ")WHERE VALOR=1 \n"
                + "UNION ALL\n"
                + "select * from(\n"
                + "SELECT NOMBRE_ORGANO_JURIS,ID_ORGANOJ,CLAVE_EXPEDIENTE,\n"
                + "CASE WHEN  CAST_TC_FED_SIMPLE(PREG_SUSPENSION_TRABAJADOR,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SUSPENSION_TRABAJADOR') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_SUSPENSION_PATRON,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SUSPENSION_PATRON') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_INDEMNIZACION_PATRON,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INDEMNIZACION_PATRON') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_AUTORIZACION_LABORAR,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_AUTORIZACION_LABORAR') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_RECONOCIMIENTO_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RECONOCIMIENTO_TRABAJO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_CAPACITACION,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CAPACITACION') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_ADIESTRAMIENTO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ADIESTRAMIENTO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_NULIDAD_CLAUSULA_CONTRA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_NULIDAD_CLAUSULA_CONTRA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_CONDICIONES_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CONDICIONES_TRABAJO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_HORAS_EXTRA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_HORAS_EXTRA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_HABITACION,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_HABITACION') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_CREDITOS,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CREDITOS') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_CAPACITACION_ADIESTRAMI,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CAPACITACION_ADIESTRAMI') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_PRIMA_ANTIGUEDAD,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PRIMA_ANTIGUEDAD') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_REGLAMENTO_INTER_TRABAJO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_REGLAMENTO_INTER_TRABAJO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_RENTA_MAX_HAB_TRABAJADOR,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RENTA_MAX_HAB_TRABAJADOR') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_OBLIGA_DERIV_RENTA_HAB,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_OBLIGA_DERIV_RENTA_HAB') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_COBRO_PRESTA_SALARIO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_COBRO_PRESTA_SALARIO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_ALOJAMIENTO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ALOJAMIENTO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_SALARIO_BASE_COTIZACION,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SALARIO_BASE_COTIZACION') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCAPACI_PERMA_PARCIAL,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCAPACI_PERMA_PARCIAL') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_MUERTE,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_MUERTE') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_PENSION_ASCENDENCIA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSION_ASCENDENCIA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_PENSION_GARANTIZADA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSION_GARANTIZADA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCRE_PENSION,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCRE_PENSION') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_INDEMNIZACION_GLOBAL,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INDEMNIZACION_GLOBAL') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_ASISTENCIA_MEDICA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ASISTENCIA_MEDICA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_APARATOS_PROT_ORTOP,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_APARATOS_PROT_ORTOP') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_RIESGOS_SALARIO_BASE,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RIESGOS_SALARIO_BASE') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_RIESGOS_PAGO_INDEMNIZA,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RIESGOS_PAGO_INDEMNIZA') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_RIESGO_OPOSICION_DESIG,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RIESGO_OPOSICION_DESIG') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_DESIGNACION_FALLECIDO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DESIGNACION_FALLECIDO') in (2,9) AND\n"
                + "CAST_TC_FED_SIMPLE(PREG_DESIGNACION_DESAPARECIDO,'TR_FED_INDIVIDUAL_PREST_RECL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DESIGNACION_DESAPARECIDO') in (2,9)\n"
                + "THEN 99\n"
                + "        ELSE -2\n"
                + "         END ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "         -2 COD_ORG,\n"
                + "        -2 COD_EXPE\n"
                + "    FROM TMP_FED_INDIVIDUAL))WHERE ID_TIPO_PRESTACION_RECLAMADA<>-2";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna 
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_INDIVIDUAL_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_ORDINARIO
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_ORDINARIO() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT \n"
                + "NOMBRE_ORGANO_JURIS, \n"
                + "ID_ORGANOJ, \n"
                + "CLAVE_EXPEDIENTE, \n"
                + "FECHA_APERTURA_EXPED, \n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO, \n"
                + "CAST_TC_FED_NAT_CONFLICTO (ID_NAT_CONFLICTO,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_NAT_CONFLICTO')ID_NAT_CONFLICTO, \n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL(RAMA_INVOLUC,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC') RAMA_INVOLUC, \n"
                + "CAST_TC_FED_SECTOR_RAMA(RAMA_INVOLUC,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SECTOR') SECTOR,\n"
                + "CAST_TC_FED_SUBSECTOR_RAMA(RAMA_INVOLUC,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'SUBSECTOR')  SUBSECTOR,\n"
                + "CLAVE_ENTIDAD_PAT,\n"
                + "CAST_TC_FED_ENTIDADES (CLAVE_ENTIDAD_PAT,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CLAVE_ENTIDAD_PAT')CLAVE_ENTIDAD_PAT, \n"
                + "CLAVE_ENTIDAD_MUN,\n"
                + "CAST_TC_FED_MUNICIPIO (CLAVE_ENTIDAD_PAT,CLAVE_ENTIDAD_MUN,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'CLAVE_ENTIDAD_MUN')CLAVE_ENTIDAD_MUN, \n"
                + "CAST_TC_FED_SIMPLE (PREG_SUBCONTRATACION,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUBCONTRATACION')PREG_SUBCONTRATACION, \n"
                + "NULL CANTIDAD_PRESTA_RECLAM, ---------------------- GENERAR CONTEO\n"
                + "CAST_TC_FED_SIMPLE (PREG_INCOMPETENCIA,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA, \n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA (ID_TIPO_INCOMPETENCIA,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA, \n"
                + "FECHA_PRESENTACION, \n"
                + "CAST_TC_FED_SIMPLE (PREG_CONSTANCIA,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONSTANCIA')PREG_CONSTANCIA, \n"
                + "CAST_TC_FED_SIMPLE (PREG_EXCEP_CONCILIA,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EXCEP_CONCILIA')PREG_EXCEP_CONCILIA, \n"
                + "CAST_TC_FED_SIMPLE (PREG_PREVENCION,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PREVENCION')PREG_PREVENCION, \n"
                + "CAST_TC_FED_ESTATUS_DEMANDA (ID_ESTATUS_DEMANDA,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_DEMANDA')ID_ESTATUS_DEMANDA, \n"
                + "CAST_TC_FED_CAU_IMPI_ADMI_DEM (ID_CAUSA_IMP_DEM,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_CAUSA_IMP_DEM')ID_CAUSA_IMP_DEM, \n"
                + "FECHA_ADM_DEMANDA, \n"
                + "CAST_CANTIDAD(CANT_ACTORES)CANT_ACTORES, \n"
                + "CAST_CANTIDAD(CANT_DEMANDADOS)CANT_DEMANDADOS, \n"
                + "CAST_TC_FED_SIMPLE (PREG_AUD_PRELIM_CELEBR,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AUD_PRELIM_CELEBR')PREG_AUD_PRELIM_CELEBR, \n"
                + "FECHA_AUDIENCIA_PRELIM, \n"
                + "CAST_TC_FED_SIMPLE (PREG_CELEBRA_AUD_JUICIO,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CELEBRA_AUD_JUICIO')PREG_CELEBRA_AUD_JUICIO, \n"
                + "FECHA_AUD_JUICIO, \n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE (ID_ESTATUS_EXPED,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED, \n"
                + "FECHA_ULT_ACT_PROC, \n"
                + "CAST_TC_FED_FASE_EXPEDIENTE (ID_FASE_SOL_EXPED,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED, \n"
                + "CAST_TC_FED_FORMA_SOLUCION (ID_FORMA_SOLUCION,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION, \n"
                + "FECHA_DICTO_SOLUCION, \n"
                + "FECHA_SENTENCIA, \n"
                + "CAST_TC_FED_TIPO_SENTENCIA (ID_SENTIDO_SENTEN,'TR_FED_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_SENTIDO_SENTEN')ID_SENTIDO_SENTEN,\n"
                + "-2 COD_ORG,\n"
                + "-2 COD_EXPE\n"
                + "FROM TMP_FED_ORDINARIO";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna   
                fila.add(resul.getString(11)); // Añadir la décima columna  
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                fila.add(resul.getString(32));
                fila.add(resul.getString(33));
                fila.add(resul.getString(34));
                fila.add(resul.getString(35));
                fila.add(resul.getString(36));
                fila.add(resul.getString(37));
                fila.add(resul.getString(38));
                fila.add(resul.getString(39));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_ORDINARIO" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_ORDINARIO_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_ORDINARIO_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT * FROM(\n"
                + "SELECT\n"
                + "    NOMBRE_ORGANO_JURIS,\n"
                + "    ID_ORGANOJ,\n"
                + "    CLAVE_EXPEDIENTE,\n"
                + "    ID_TIPO AS ID_TIPO_PRESTACION_RECLAMADA,\n"
                + "    -2 COD_ORG,\n"
                + "    -2 COD_EXPE\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "       CAST_TC_FED_SIMPLE (PREG_SALARIOS_VEN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SALARIOS_VEN')PREG_SALARIOS_VEN,\n"
                + "CAST_TC_FED_SIMPLE (PREG_REINSTALACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REINSTALACION')PREG_REINSTALACION,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PAGO_INDEM,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PAGO_INDEM')PREG_PAGO_INDEM,\n"
                + "CAST_TC_FED_SIMPLE (PREG_TERMINA_RELA_LAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TERMINA_RELA_LAB')PREG_TERMINA_RELA_LAB,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DEPOSITO_INDEM,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DEPOSITO_INDEM')PREG_DEPOSITO_INDEM,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESPONS_CONFLIC,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESPONS_CONFLIC')PREG_RESPONS_CONFLIC,\n"
                + "CAST_TC_FED_SIMPLE (PREG_NULIDAD_RENUN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_NULIDAD_RENUN')PREG_NULIDAD_RENUN,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESOSITO_RESPO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESOSITO_RESPO')PREG_RESOSITO_RESPO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RELA_TRAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RELA_TRAB')PREG_RELA_TRAB,\n"
                + "CAST_TC_FED_SIMPLE (PREG_NULIDAD_LIQUI,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_NULIDAD_LIQUI')PREG_NULIDAD_LIQUI,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RATIF_CONVEN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RATIF_CONVEN')PREG_RATIF_CONVEN,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESPONS_PATRON,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESPONS_PATRON')PREG_RESPONS_PATRON,\n"
                + "CAST_TC_FED_SIMPLE (PREG_VACACIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VACACIONES')PREG_VACACIONES,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRIMA_VACACIONAL,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRIMA_VACACIONAL')PREG_PRIMA_VACACIONAL,\n"
                + "CAST_TC_FED_SIMPLE (PREG_AGUINALDO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AGUINALDO')PREG_AGUINALDO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_SALARIO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SALARIO')PREG_SALARIO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRIMA_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRIMA_ANTIGUEDAD')PREG_PRIMA_ANTIGUEDAD,\n"
                + "CAST_TC_FED_SIMPLE (PREG_HORAS_EXTRA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HORAS_EXTRA')PREG_HORAS_EXTRA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RECONO_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RECONO_ANTIGUEDAD')PREG_RECONO_ANTIGUEDAD,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DIAS_DESCANSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DIAS_DESCANSO')PREG_DIAS_DESCANSO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DERECHO_PREF,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DERECHO_PREF')PREG_DERECHO_PREF,\n"
                + "CAST_TC_FED_SIMPLE (PREG_BONOS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_BONOS')PREG_BONOS,\n"
                + "CAST_TC_FED_SIMPLE (PREG_GRATIFICA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_GRATIFICA')PREG_GRATIFICA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_OCUPACION_VACAN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_OCUPACION_VACAN')PREG_OCUPACION_VACAN,\n"
                + "CAST_TC_FED_SIMPLE (PREG_COMISIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_COMISIONES')PREG_COMISIONES,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCUENTO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCUENTO')PREG_DESCUENTO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ASCENSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ASCENSO')PREG_ASCENSO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCANSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCANSO')PREG_DESCANSO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RECIBO_PAGO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RECIBO_PAGO')PREG_RECIBO_PAGO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_AFILACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AFILACION')PREG_AFILACION,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ESCUELAS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ESCUELAS')PREG_ESCUELAS,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PROPINA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PROPINA')PREG_PROPINA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_INVENCIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INVENCIONES')PREG_INVENCIONES,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RELACION_TRAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RELACION_TRAB')PREG_RELACION_TRAB,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DIVERSO_DOC,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DIVERSO_DOC')PREG_DIVERSO_DOC,\n"
                + "CAST_TC_FED_SIMPLE (PREG_BASE_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_BASE_ANTIGUEDAD')PREG_BASE_ANTIGUEDAD,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RENIVELACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RENIVELACION')PREG_RENIVELACION,\n"
                + "CAST_TC_FED_SIMPLE (PREG_SUSTI_PATRON,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUSTI_PATRON')PREG_SUSTI_PATRON,\n"
                + "CAST_TC_FED_SIMPLE (PREG_MUERTE,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MUERTE')PREG_MUERTE,\n"
                + "CAST_TC_FED_SIMPLE (PREG_INCRE_PENSION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCRE_PENSION')PREG_INCRE_PENSION,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RETIRO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RETIRO')PREG_RETIRO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_VIDA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VIDA')PREG_VIDA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ENFERMEDADES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ENFERMEDADES')PREG_ENFERMEDADES,\n"
                + "CAST_TC_FED_SIMPLE (PREG_VEJEZ,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VEJEZ')PREG_VEJEZ,\n"
                + "CAST_TC_FED_SIMPLE (PREG_RETORNO_PUESTO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RETORNO_PUESTO')PREG_RETORNO_PUESTO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PAGO_SALARIO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PAGO_SALARIO')PREG_PAGO_SALARIO,\n"
                + "CAST_TC_FED_SIMPLE (PREG_TRAB_CONS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TRAB_CONS')PREG_TRAB_CONS,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ANT_PRE,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ANT_PRE')PREG_ANT_PRE,\n"
                + "CAST_TC_FED_SIMPLE (PREG_LABORES_PEL,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_LABORES_PEL')PREG_LABORES_PEL,\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCANSO_SEMANAS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCANSO_SEMANAS')PREG_DESCANSO_SEMANAS,\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRORROGA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRORROGA')PREG_PRORROGA,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ALIMENTACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ALIMENTACION')PREG_ALIMENTACION,\n"
                + "CAST_TC_FED_SIMPLE (PREG_ACTOS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ACTOS')PREG_ACTOS\n"
                + "    FROM TMP_FED_ORDINARIO\n"
                + ")\n"
                + "UNPIVOT (\n"
                + "    VALOR FOR ID_TIPO IN (\n"
                + "         PREG_SALARIOS_VEN AS 1,\n"
                + " PREG_REINSTALACION AS 2,\n"
                + " PREG_PAGO_INDEM AS 3,\n"
                + " PREG_TERMINA_RELA_LAB AS 4,\n"
                + " PREG_DEPOSITO_INDEM AS 5,\n"
                + " PREG_RESPONS_CONFLIC AS 6,\n"
                + " PREG_NULIDAD_RENUN AS 7,\n"
                + " PREG_RESOSITO_RESPO AS 8,\n"
                + " PREG_RELA_TRAB AS 9,\n"
                + " PREG_NULIDAD_LIQUI AS 10,\n"
                + " PREG_RATIF_CONVEN AS 11,\n"
                + " PREG_RESPONS_PATRON AS 12,\n"
                + " PREG_VACACIONES AS 13,\n"
                + " PREG_PRIMA_VACACIONAL AS 14,\n"
                + " PREG_AGUINALDO AS 15,\n"
                + " PREG_SALARIO AS 16,\n"
                + " PREG_PRIMA_ANTIGUEDAD AS 17,\n"
                + " PREG_HORAS_EXTRA AS 18,\n"
                + " PREG_RECONO_ANTIGUEDAD AS 19,\n"
                + " PREG_DIAS_DESCANSO AS 20,\n"
                + " PREG_DERECHO_PREF AS 21,\n"
                + " PREG_BONOS AS 22,\n"
                + " PREG_GRATIFICA AS 23,\n"
                + " PREG_OCUPACION_VACAN AS 24,\n"
                + " PREG_COMISIONES AS 25,\n"
                + " PREG_DESCUENTO AS 26,\n"
                + " PREG_ASCENSO AS 27,\n"
                + " PREG_DESCANSO AS 28,\n"
                + " PREG_RECIBO_PAGO AS 29,\n"
                + " PREG_AFILACION AS 30,\n"
                + " PREG_ESCUELAS AS 31,\n"
                + " PREG_PROPINA AS 32,\n"
                + " PREG_INVENCIONES AS 33,\n"
                + " PREG_RELACION_TRAB AS 34,\n"
                + " PREG_DIVERSO_DOC AS 35,\n"
                + " PREG_BASE_ANTIGUEDAD AS 36,\n"
                + " PREG_RENIVELACION AS 37,\n"
                + " PREG_SUSTI_PATRON AS 38,\n"
                + " PREG_MUERTE AS 39,\n"
                + " PREG_INCRE_PENSION AS 40,\n"
                + " PREG_RETIRO AS 41,\n"
                + " PREG_VIDA AS 42,\n"
                + " PREG_ENFERMEDADES AS 43,\n"
                + " PREG_VEJEZ AS 44,\n"
                + " PREG_RETORNO_PUESTO AS 45,\n"
                + " PREG_PAGO_SALARIO AS 46,\n"
                + " PREG_TRAB_CONS AS 47,\n"
                + " PREG_ANT_PRE AS 48,\n"
                + " PREG_LABORES_PEL AS 49,\n"
                + " PREG_DESCANSO_SEMANAS AS 50,\n"
                + " PREG_PRORROGA AS 51,\n"
                + " PREG_ALIMENTACION AS 52,\n"
                + " PREG_ACTOS AS 53\n"
                + "    )\n"
                + ")WHERE VALOR=1 \n"
                + "UNION ALL\n"
                + "select * from(\n"
                + "SELECT NOMBRE_ORGANO_JURIS,ID_ORGANOJ,CLAVE_EXPEDIENTE,\n"
                + "CASE WHEN CAST_TC_FED_SIMPLE (PREG_SALARIOS_VEN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SALARIOS_VEN')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_REINSTALACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_REINSTALACION')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PAGO_INDEM,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PAGO_INDEM')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_TERMINA_RELA_LAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TERMINA_RELA_LAB')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DEPOSITO_INDEM,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DEPOSITO_INDEM')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESPONS_CONFLIC,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESPONS_CONFLIC')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_NULIDAD_RENUN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_NULIDAD_RENUN')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESOSITO_RESPO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESOSITO_RESPO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RELA_TRAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RELA_TRAB')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_NULIDAD_LIQUI,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_NULIDAD_LIQUI')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RATIF_CONVEN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RATIF_CONVEN')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RESPONS_PATRON,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RESPONS_PATRON')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_VACACIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VACACIONES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRIMA_VACACIONAL,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRIMA_VACACIONAL')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_AGUINALDO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AGUINALDO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_SALARIO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SALARIO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRIMA_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRIMA_ANTIGUEDAD')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_HORAS_EXTRA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_HORAS_EXTRA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RECONO_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RECONO_ANTIGUEDAD')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DIAS_DESCANSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DIAS_DESCANSO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DERECHO_PREF,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DERECHO_PREF')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_BONOS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_BONOS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_GRATIFICA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_GRATIFICA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_OCUPACION_VACAN,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_OCUPACION_VACAN')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_COMISIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_COMISIONES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCUENTO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCUENTO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ASCENSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ASCENSO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCANSO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCANSO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RECIBO_PAGO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RECIBO_PAGO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_AFILACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AFILACION')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ESCUELAS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ESCUELAS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PROPINA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PROPINA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_INVENCIONES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INVENCIONES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RELACION_TRAB,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RELACION_TRAB')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DIVERSO_DOC,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DIVERSO_DOC')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_BASE_ANTIGUEDAD,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_BASE_ANTIGUEDAD')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RENIVELACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RENIVELACION')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_SUSTI_PATRON,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_SUSTI_PATRON')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_MUERTE,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_MUERTE')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_INCRE_PENSION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCRE_PENSION')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RETIRO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RETIRO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_VIDA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VIDA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ENFERMEDADES,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ENFERMEDADES')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_VEJEZ,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_VEJEZ')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_RETORNO_PUESTO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_RETORNO_PUESTO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PAGO_SALARIO,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PAGO_SALARIO')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_TRAB_CONS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_TRAB_CONS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ANT_PRE,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ANT_PRE')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_LABORES_PEL,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_LABORES_PEL')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_DESCANSO_SEMANAS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_DESCANSO_SEMANAS')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_PRORROGA,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PRORROGA')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ALIMENTACION,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ALIMENTACION')IN ('2','9') AND\n"
                + "CAST_TC_FED_SIMPLE (PREG_ACTOS,'TR_FED_PREST_RECL_ORDINARIO', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_ACTOS')IN ('2','9') THEN 99\n"
                + "        ELSE -2\n"
                + "         END ID_TIPO_PRESTACION_RECLAMADA,-2 COD_ORG,-2 COD_EXPE FROM TMP_FED_ORDINARIO))WHERE ID_TIPO_PRESTACION_RECLAMADA<>-2";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_ORDINARIO_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_PARAPROCESAL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_PARAPROCESAL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "NULL SECTOR,\n"
                + "NULL SUBSECTOR,\n"
                + "NULL AS CANTIDAD_PRESTA_RECLAM,\n"
                + "CAST_TC_FED_SIMPLE(INCOMPETENCIA,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_ESTATUS_SOLICITUD(ID_ESTATUS_SOLI,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_SOLI')ID_ESTATUS_SOLI,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "CAST_TC_FED_PROMOVENTE(ID_PROMOVENTE,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_SOLI')ID_PROMOVENTE,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_PARAPROCESAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_DICTO_SOLUCION\n"
                + ",-2 COD_ORG\n"
                + ",-2 COD_EXPE\n"
                + "FROM TMP_FED_PARAPROCESAL";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_PARAPROCESAL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_PARAPROCESAL_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_PARAPROCESAL_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT *\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        ID_TIPO AS ID_TIPO_PARAPROCESAL,\n"
                + "        -2 COD_ORG,\n"
                + "        -2 COD_EXPE\n"
                + "    FROM (\n"
                + "        SELECT\n"
                + "            NOMBRE_ORGANO_JURIS,\n"
                + "            ID_ORGANOJ,\n"
                + "            CLAVE_EXPEDIENTE,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_NOTIFICACIONDELAVISODEREC,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_NOTIFICACIONDELAVISODEREC'\n"
                + "            ) AS PREG_NOTIFICACIONDELAVISODEREC,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_OTORGAMIENTOYCANCELACIOND,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_OTORGAMIENTOYCANCELACIOND'\n"
                + "            ) AS PREG_OTORGAMIENTOYCANCELACIOND,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_SUSPENSIONDELREPARTOADICI,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SUSPENSIONDELREPARTOADICI'\n"
                + "            ) AS PREG_SUSPENSIONDELREPARTOADICI,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_AUTORIZACIONDEPERSONASMAY,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_AUTORIZACIONDEPERSONASMAY'\n"
                + "            ) AS PREG_AUTORIZACIONDEPERSONASMAY,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_EXPEDICIONDECONSTANCIASDE,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_EXPEDICIONDECONSTANCIASDE'\n"
                + "            ) AS PREG_EXPEDICIONDECONSTANCIASDE,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_RECEPCIONDEDINEROPORVIRTU,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RECEPCIONDEDINEROPORVIRTU'\n"
                + "            ) AS PREG_RECEPCIONDEDINEROPORVIRTU,\n"
                + "            CAST_TC_FED_SIMPLE(PREG_DEPOSITODELAINDEMNIZACION,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DEPOSITODELAINDEMNIZACION'\n"
                + "            ) AS PREG_DEPOSITODELAINDEMNIZACION\n"
                + "        FROM TMP_FED_PARAPROCESAL\n"
                + "    )\n"
                + "    UNPIVOT (\n"
                + "        VALOR FOR ID_TIPO IN (\n"
                + "            PREG_NOTIFICACIONDELAVISODEREC AS 1,\n"
                + "            PREG_OTORGAMIENTOYCANCELACIOND AS 2,\n"
                + "            PREG_SUSPENSIONDELREPARTOADICI AS 3,\n"
                + "            PREG_AUTORIZACIONDEPERSONASMAY AS 4,\n"
                + "            PREG_EXPEDICIONDECONSTANCIASDE AS 5,\n"
                + "            PREG_RECEPCIONDEDINEROPORVIRTU AS 6,\n"
                + "            PREG_DEPOSITODELAINDEMNIZACION AS 7\n"
                + "        )\n"
                + "    )\n"
                + "    WHERE VALOR = 1\n"
                + "\n"
                + "    UNION ALL\n"
                + "\n"
                + "    SELECT *\n"
                + "    FROM (\n"
                + "        SELECT\n"
                + "            NOMBRE_ORGANO_JURIS,\n"
                + "            ID_ORGANOJ,\n"
                + "            CLAVE_EXPEDIENTE,\n"
                + "            CASE WHEN CAST_TC_FED_SIMPLE(PREG_NOTIFICACIONDELAVISODEREC,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_NOTIFICACIONDELAVISODEREC') in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_OTORGAMIENTOYCANCELACIOND,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_OTORGAMIENTOYCANCELACIOND')  in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_SUSPENSIONDELREPARTOADICI,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SUSPENSIONDELREPARTOADICI')  in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_AUTORIZACIONDEPERSONASMAY,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_AUTORIZACIONDEPERSONASMAY')  in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_EXPEDICIONDECONSTANCIASDE,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_EXPEDICIONDECONSTANCIASDE')  in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_RECEPCIONDEDINEROPORVIRTU,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RECEPCIONDEDINEROPORVIRTU')  in (2,9)\n"
                + "            AND CAST_TC_FED_SIMPLE(PREG_DEPOSITODELAINDEMNIZACION,'TMP_FED_PARAPROCESAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DEPOSITODELAINDEMNIZACION')  in (2,9) \n"
                + "            THEN 9 ELSE -2\n"
                + "            END AS ID_TIPO_PARAPROCESAL,\n"
                + "            -2 COD_ORG,\n"
                + "            -2 COD_EXPE\n"
                + "        FROM TMP_FED_PARAPROCESAL\n"
                + "    )\n"
                + "    WHERE ID_TIPO_PARAPROCESAL <> -2\n"
                + ")";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna 
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_PARAPROCESAL_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_SEG_SOCIAL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_SEG_SOCIAL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "SELECT \n"
                + "NOMBRE_ORGANO_JURIS,\n"
                + "ID_ORGANOJ,\n"
                + "CLAVE_EXPEDIENTE,\n"
                + "FECHA_APERTURA_EXPEDIENTE,\n"
                + "CAST_TC_FED_TIPO_ASUNTO (ID_TIPO_ASUNTO,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_ASUNTO')ID_TIPO_ASUNTO,\n"
                + "CAST_TC_FED_NAT_CONFLICTO(ID_NAT_CONFLICTO, 'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_NAT_CONFLICTO')ID_NAT_CONFLICTO,\n"
                + "CAST_TC_FED_RAMA_INDUSTRIAL (RAMA_INVOLUC,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'RAMA_INVOLUC')RAMA_INVOLUC,\n"
                + "NULL SECTOR,\n"
                + "NULL SUBSECTOR,\n"
                + "ENTIDAD_CLAVE ENTIDAD_NOMBRE,\n"
                + "CAST_TC_FED_ENTIDADES(ENTIDAD_CLAVE,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ENTIDAD_CLAVE') ENTIDAD_CLAVE,\n"
                + "MUNICIPIO_CLAVE MUNICIPIO_NOMBRE,\n"
                + "CAST_TC_FED_MUNICIPIO(ENTIDAD_CLAVE,MUNICIPIO_CLAVE,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'MUNICIPIO_CLAVE')MUNICIPIO_CLAVE,\n"
                + "NULL AS CANTIDAD_PRESTA_RECLAM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_INCOMPETENCIA,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_INCOMPETENCIA')PREG_INCOMPETENCIA,\n"
                + "CAST_TC_FED_TIPO_INCOMPETENCIA(ID_TIPO_INCOMPETENCIA,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_TIPO_INCOMPETENCIA')ID_TIPO_INCOMPETENCIA,\n"
                + "FECHA_PRESENTACION,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CONSTANCIA,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CONSTANCIA')PREG_CONSTANCIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_EXCEP_CONCILIA,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_EXCEP_CONCILIA')PREG_EXCEP_CONCILIA,\n"
                + "CAST_TC_FED_SIMPLE(PREG_PREVENCION,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_PREVENCION')PREG_PREVENCION,\n"
                + "CAST_TC_FED_ESTATUS_DEMANDA(ID_ESTATUS_DEMANDA,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_DEMANDA')ID_ESTATUS_DEMANDA,\n"
                + "CAST_TC_FED_CAU_IMPI_ADMI_DEM(ID_CAUSA_IMP_DEM,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_CAUSA_IMP_DEM')ID_CAUSA_IMP_DEM,\n"
                + "FECHA_ADM_DEMANDA,\n"
                + "CASE WHEN CANT_ACTORES='No identificado' THEN '-1' ELSE CANT_ACTORES END CANT_ACTORES,\n"
                + "CASE WHEN CANT_DEMANDADOS='No identificado' THEN '-1' ELSE CANT_DEMANDADOS END CANT_DEMANDADOS,\n"
                + "CAST_TC_FED_SIMPLE(PREG_AUD_PRELIM_CELEBR,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_AUD_PRELIM_CELEBR')PREG_AUD_PRELIM_CELEBR,\n"
                + "FECHA_AUDIENCIA_PRELIM,\n"
                + "CAST_TC_FED_SIMPLE(PREG_CELEBRA_AUD_JUICIO,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'PREG_CELEBRA_AUD_JUICIO')PREG_CELEBRA_AUD_JUICIO,\n"
                + "FECHA_AUD_JUICIO,\n"
                + "CAST_TC_FED_ESTATUS_EXPEDIENTE(ID_ESTATUS_EXPED,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_ESTATUS_EXPED')ID_ESTATUS_EXPED,\n"
                + "FECHA_ULT_ACT_PROC,\n"
                + "CAST_TC_FED_FASE_EXPEDIENTE(ID_FASE_SOL_EXPED,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FASE_SOL_EXPED')ID_FASE_SOL_EXPED,\n"
                + "CAST_TC_FED_FORMA_SOLUCION(ID_FORMA_SOLUCION,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_FORMA_SOLUCION')ID_FORMA_SOLUCION,\n"
                + "FECHA_DICTO_SOLUCION,\n"
                + "CAST_TC_FED_TIPO_SENTENCIA(ID_SENTIDO_SENTEN,'TR_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE,'ID_SENTIDO_SENTEN')ID_SENTIDO_SENTEN,\n"
                + "-2 COD_EXPE,\n"
                + "-2 COD_ORG\n"
                + "FROM TMP_FED_SEG_SOCIAL";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1));
                fila.add(resul.getString(2));
                fila.add(resul.getString(3));
                fila.add(resul.getString(4));
                fila.add(resul.getString(5));
                fila.add(resul.getString(6));
                fila.add(resul.getString(7));
                fila.add(resul.getString(8));
                fila.add(resul.getString(9));
                fila.add(resul.getString(10));
                fila.add(resul.getString(11));
                fila.add(resul.getString(12));
                fila.add(resul.getString(13));
                fila.add(resul.getString(14));
                fila.add(resul.getString(15));
                fila.add(resul.getString(16));
                fila.add(resul.getString(17));
                fila.add(resul.getString(18));
                fila.add(resul.getString(19));
                fila.add(resul.getString(20));
                fila.add(resul.getString(21));
                fila.add(resul.getString(22));
                fila.add(resul.getString(23));
                fila.add(resul.getString(24));
                fila.add(resul.getString(25));
                fila.add(resul.getString(26));
                fila.add(resul.getString(27));
                fila.add(resul.getString(28));
                fila.add(resul.getString(29));
                fila.add(resul.getString(30));
                fila.add(resul.getString(31));
                fila.add(resul.getString(32));
                fila.add(resul.getString(33));
                fila.add(resul.getString(34));
                fila.add(resul.getString(35));
                fila.add(resul.getString(36));
                fila.add(resul.getString(37));
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_SEG_SOCIAL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    //TR_FED_SEG_SOCIAL_PREST_RECL
    public ArrayList<ArrayList<String>> TMP_TO_TR_FED_SEG_SOCIAL_PREST_RECL() throws SQLException {
        conexionFed.ConectarFed();
        arrayList = new ArrayList<>();

        String sql = "WITH BASE AS (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRIMADOMINICAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PRIMADOMINICAL') AS PREG_PRIMADOMINICAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_COMISIONES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_COMISIONES') AS PREG_COMISIONES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTACIONESENESPECIE, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PRESTACIONESENESPECIE') AS PREG_PRESTACIONESENESPECIE,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_GRATIFICACIONES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_GRATIFICACIONES') AS PREG_GRATIFICACIONES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BONOS, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_BONOS') AS PREG_BONOS,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CREDITOS, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CREDITOS') AS PREG_CREDITOS,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RECONOCIMIENTODEANTIGUEDA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RECONOCIMIENTODEANTIGUEDA') AS PREG_RECONOCIMIENTODEANTIGUEDA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INSCRIPCIONENELIMSS, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INSCRIPCIONENELIMSS') AS PREG_INSCRIPCIONENELIMSS,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INSCRIPCIONENINFONAVIT, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INSCRIPCIONENINFONAVIT') AS PREG_INSCRIPCIONENINFONAVIT,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BAJAENELIMSS, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_BAJAENELIMSS') AS PREG_BAJAENELIMSS,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BAJAENELINFONAVIT, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_BAJAENELINFONAVIT') AS PREG_BAJAENELINFONAVIT,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CUOTASOBREROPATRONALES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CUOTASOBREROPATRONALES') AS PREG_CUOTASOBREROPATRONALES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RIESGOSDETRABAJO, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RIESGOSDETRABAJO') AS PREG_RIESGOSDETRABAJO,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PREVENCIONDERIESGOSDETRAB, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PREVENCIONDERIESGOSDETRAB') AS PREG_PREVENCIONDERIESGOSDETRAB,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ENFERMEDADES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_ENFERMEDADES') AS PREG_ENFERMEDADES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_MATERNIDAD, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_MATERNIDAD') AS PREG_MATERNIDAD,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INVALIDEZ, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INVALIDEZ') AS PREG_INVALIDEZ,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_VIDA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_VIDA') AS PREG_VIDA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RETIRO, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RETIRO') AS PREG_RETIRO,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CESANTIAENEDADAVANZADA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CESANTIAENEDADAVANZADA') AS PREG_CESANTIAENEDADAVANZADA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_VEJEZ, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_VEJEZ') AS PREG_VEJEZ,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_GUARDERIA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_GUARDERIA') AS PREG_GUARDERIA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTACIONESSOCIALES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PRESTACIONESSOCIALES') AS PREG_PRESTACIONESSOCIALES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SALARIOBASEDECOTIZACION, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_SALARIOBASEDECOTIZACION') AS PREG_SALARIOBASEDECOTIZACION,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADTEMPORAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INCAPACIDADTEMPORAL') AS PREG_INCAPACIDADTEMPORAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADPERMANENTETOTA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INCAPACIDADPERMANENTETOTA') AS PREG_INCAPACIDADPERMANENTETOTA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADPERMANENTEPARC, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INCAPACIDADPERMANENTEPARC') AS PREG_INCAPACIDADPERMANENTEPARC,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_MUERTE, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_MUERTE') AS PREG_MUERTE,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORINVALIDEZ, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PENSIONPORINVALIDEZ') AS PREG_PENSIONPORINVALIDEZ,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORVIUDEZ, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PENSIONPORVIUDEZ') AS PREG_PENSIONPORVIUDEZ,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORORFANDAD, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PENSIONPORORFANDAD') AS PREG_PENSIONPORORFANDAD,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORASCENDENCIA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PENSIONPORASCENDENCIA') AS PREG_PENSIONPORASCENDENCIA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONGARANTIZADA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PENSIONGARANTIZADA') AS PREG_PENSIONGARANTIZADA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCREMENTODEPENSION, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INCREMENTODEPENSION') AS PREG_INCREMENTODEPENSION,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INDEMNIZACIONGLOBAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INDEMNIZACIONGLOBAL') AS PREG_INDEMNIZACIONGLOBAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RECONOCIMIENTODEBENEFICIA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RECONOCIMIENTODEBENEFICIA') AS PREG_RECONOCIMIENTODEBENEFICIA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASISTENCIAMEDICAQUIRURGIC, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_ASISTENCIAMEDICAQUIRURGIC') AS PREG_ASISTENCIAMEDICAQUIRURGIC,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SERVICIODEHOSPITALIZACION, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_SERVICIODEHOSPITALIZACION') AS PREG_SERVICIODEHOSPITALIZACION,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APARATOSDEPROTESISYORTOPE, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_APARATOSDEPROTESISYORTOPE') AS PREG_APARATOSDEPROTESISYORTOPE,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_REHABILITACION, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_REHABILITACION') AS PREG_REHABILITACION,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASISTENCIAOBSTETRICA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_ASISTENCIAOBSTETRICA') AS PREG_ASISTENCIAOBSTETRICA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CANASTILLA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CANASTILLA') AS PREG_CANASTILLA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SUBSIDIOENDINERO, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_SUBSIDIOENDINERO') AS PREG_SUBSIDIOENDINERO,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CONSERVACIONDEDERECHO, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CONSERVACIONDEDERECHO') AS PREG_CONSERVACIONDEDERECHO,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASIGNACIONESFAMILIARES, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_ASIGNACIONESFAMILIARES') AS PREG_ASIGNACIONESFAMILIARES,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_AYUDAASISTENCIAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_AYUDAASISTENCIAL') AS PREG_AYUDAASISTENCIAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RETIRODEFONDOSDELACUENTAI, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RETIRODEFONDOSDELACUENTAI') AS PREG_RETIRODEFONDOSDELACUENTAI,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APORTACIONESVOLUNTARIASAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_APORTACIONESVOLUNTARIASAL') AS PREG_APORTACIONESVOLUNTARIASAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CONTINUACIONVOLUNTARIAALR, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_CONTINUACIONVOLUNTARIAALR') AS PREG_CONTINUACIONVOLUNTARIAALR,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCORPORACIONVOLUNTARIAAL, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_INCORPORACIONVOLUNTARIAAL') AS PREG_INCORPORACIONVOLUNTARIAAL,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APORTACIONESALINFONAVIT, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_APORTACIONESALINFONAVIT') AS PREG_APORTACIONESALINFONAVIT,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_DESCUENTOSDESTINADOSALPAG, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_DESCUENTOSDESTINADOSALPAG') AS PREG_DESCUENTOSDESTINADOSALPAG,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RIESGOSDETRABAJOSALARIOB, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_RIESGOSDETRABAJOSALARIOB') AS PREG_RIESGOSDETRABAJOSALARIOB,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_DESIGNACIONDEBENEFICIARIO, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_DESIGNACIONDEBENEFICIARIO') AS PREG_DESIGNACIONDEBENEFICIARIO,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ADMINISTRADORASDEFONDOSPA, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_ADMINISTRADORASDEFONDOSPA') AS PREG_ADMINISTRADORASDEFONDOSPA,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTDESEGURIDADSODEC, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PRESTDESEGURIDADSODEC') AS PREG_PRESTDESEGURIDADSODEC,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTDESEGURIDADSOLEY, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_PRESTDESEGURIDADSOLEY') AS PREG_PRESTDESEGURIDADSOLEY,\n"
                + "        CAST_TC_FED_SIMPLE(PREG_LIBERACIONDECREDITOHIPOTE, 'TMP_FED_SEG_SOCIAL', ID_ORGANOJ, CLAVE_EXPEDIENTE, 'PREG_LIBERACIONDECREDITOHIPOTE') AS PREG_LIBERACIONDECREDITOHIPOTE,\n"
                + "        -2 COD_ORG,\n"
                + "            -2 COD_EXPE\n"
                + "    FROM TMP_FED_SEG_SOCIAL\n"
                + ")\n"
                + "SELECT *\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        NOMBRE_ORGANO_JURIS,\n"
                + "        ID_ORGANOJ,\n"
                + "        CLAVE_EXPEDIENTE,\n"
                + "        ID_TIPO AS ID_TIPO_SEG_SOCIAL,\n"
                + "        -2 COD_ORG,\n"
                + "            -2 COD_EXPE\n"
                + "    FROM BASE\n"
                + "    UNPIVOT (\n"
                + "        VALOR FOR ID_TIPO IN (\n"
                + "            PREG_PRIMADOMINICAL AS 1,\n"
                + "            PREG_COMISIONES AS 2,\n"
                + "            PREG_PRESTACIONESENESPECIE AS 3,\n"
                + "            PREG_GRATIFICACIONES AS 4,\n"
                + "            PREG_BONOS AS 5,\n"
                + "            PREG_CREDITOS AS 6,\n"
                + "            PREG_RECONOCIMIENTODEANTIGUEDA AS 7,\n"
                + "            PREG_INSCRIPCIONENELIMSS AS 8,\n"
                + "            PREG_INSCRIPCIONENINFONAVIT AS 9,\n"
                + "            PREG_BAJAENELIMSS AS 10,\n"
                + "            PREG_BAJAENELINFONAVIT AS 11,\n"
                + "            PREG_CUOTASOBREROPATRONALES AS 12,\n"
                + "            PREG_RIESGOSDETRABAJO AS 13,\n"
                + "            PREG_PREVENCIONDERIESGOSDETRAB AS 14,\n"
                + "            PREG_ENFERMEDADES AS 15,\n"
                + "            PREG_MATERNIDAD AS 16,\n"
                + "            PREG_INVALIDEZ AS 17,\n"
                + "            PREG_VIDA AS 18,\n"
                + "            PREG_RETIRO AS 19,\n"
                + "            PREG_CESANTIAENEDADAVANZADA AS 20,\n"
                + "            PREG_VEJEZ AS 21,\n"
                + "            PREG_GUARDERIA AS 22,\n"
                + "            PREG_PRESTACIONESSOCIALES AS 23,\n"
                + "            PREG_SALARIOBASEDECOTIZACION AS 24,\n"
                + "            PREG_INCAPACIDADTEMPORAL AS 25,\n"
                + "            PREG_INCAPACIDADPERMANENTETOTA AS 26,\n"
                + "            PREG_INCAPACIDADPERMANENTEPARC AS 27,\n"
                + "            PREG_MUERTE AS 28,\n"
                + "            PREG_PENSIONPORINVALIDEZ AS 29,\n"
                + "            PREG_PENSIONPORVIUDEZ AS 30,\n"
                + "            PREG_PENSIONPORORFANDAD AS 31,\n"
                + "            PREG_PENSIONPORASCENDENCIA AS 32,\n"
                + "            PREG_PENSIONGARANTIZADA AS 33,\n"
                + "            PREG_INCREMENTODEPENSION AS 34,\n"
                + "            PREG_INDEMNIZACIONGLOBAL AS 35,\n"
                + "            PREG_RECONOCIMIENTODEBENEFICIA AS 36,\n"
                + "            PREG_ASISTENCIAMEDICAQUIRURGIC AS 37,\n"
                + "            PREG_SERVICIODEHOSPITALIZACION AS 38,\n"
                + "            PREG_APARATOSDEPROTESISYORTOPE AS 39,\n"
                + "            PREG_REHABILITACION AS 40,\n"
                + "            PREG_ASISTENCIAOBSTETRICA AS 41,\n"
                + "            PREG_CANASTILLA AS 42,\n"
                + "            PREG_SUBSIDIOENDINERO AS 43,\n"
                + "            PREG_CONSERVACIONDEDERECHO AS 44,\n"
                + "            PREG_ASIGNACIONESFAMILIARES AS 45,\n"
                + "            PREG_AYUDAASISTENCIAL AS 46,\n"
                + "            PREG_RETIRODEFONDOSDELACUENTAI AS 47,\n"
                + "            PREG_APORTACIONESVOLUNTARIASAL AS 48,\n"
                + "            PREG_CONTINUACIONVOLUNTARIAALR AS 49,\n"
                + "            PREG_INCORPORACIONVOLUNTARIAAL AS 50,\n"
                + "            PREG_APORTACIONESALINFONAVIT AS 51,\n"
                + "            PREG_DESCUENTOSDESTINADOSALPAG AS 52,\n"
                + "            PREG_RIESGOSDETRABAJOSALARIOB AS 53,\n"
                + "            PREG_DESIGNACIONDEBENEFICIARIO AS 54,\n"
                + "            PREG_ADMINISTRADORASDEFONDOSPA AS 55,\n"
                + "            PREG_PRESTDESEGURIDADSODEC AS 56,\n"
                + "            PREG_PRESTDESEGURIDADSOLEY AS 57,\n"
                + "            PREG_LIBERACIONDECREDITOHIPOTE AS 58\n"
                + "        )\n"
                + "    )\n"
                + "    WHERE VALOR = '1'\n"
                + "\n"
                + "   UNION ALL\n"
                + "\n"
                + "    SELECT *\n"
                + "    FROM (\n"
                + "        SELECT\n"
                + "            NOMBRE_ORGANO_JURIS,\n"
                + "            ID_ORGANOJ,\n"
                + "            CLAVE_EXPEDIENTE,\n"
                + "            CASE WHEN \n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRIMADOMINICAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'INICAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_COMISIONES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_COMISIONES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTACIONESENESPECIE,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PRESTACIONESENESPECIE') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_GRATIFICACIONES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_GRATIFICACIONES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BONOS,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_BONOS') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CREDITOS,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CREDITOS') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RECONOCIMIENTODEANTIGUEDA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RECONOCIMIENTODEANTIGUEDA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INSCRIPCIONENELIMSS,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INSCRIPCIONENELIMSS') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INSCRIPCIONENINFONAVIT,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INSCRIPCIONENINFONAVIT') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BAJAENELIMSS,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_BAJAENELIMSS') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_BAJAENELINFONAVIT,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_BAJAENELINFONAVIT') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CUOTASOBREROPATRONALES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CUOTASOBREROPATRONALES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RIESGOSDETRABAJO,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RIESGOSDETRABAJO') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PREVENCIONDERIESGOSDETRAB,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PREVENCIONDERIESGOSDETRAB') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ENFERMEDADES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ENFERMEDADES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_MATERNIDAD,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_MATERNIDAD') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INVALIDEZ,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INVALIDEZ') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_VIDA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_VIDA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RETIRO,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RETIRO') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CESANTIAENEDADAVANZADA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CESANTIAENEDADAVANZADA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_VEJEZ,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_VEJEZ') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_GUARDERIA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_GUARDERIA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTACIONESSOCIALES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PRESTACIONESSOCIALES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SALARIOBASEDECOTIZACION,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SALARIOBASEDECOTIZACION') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADTEMPORAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCAPACIDADTEMPORAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADPERMANENTETOTA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCAPACIDADPERMANENTETOTA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCAPACIDADPERMANENTEPARC,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCAPACIDADPERMANENTEPARC') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_MUERTE,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_MUERTE') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORINVALIDEZ,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSIONPORINVALIDEZ') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORVIUDEZ,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSIONPORVIUDEZ') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORORFANDAD,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSIONPORORFANDAD') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONPORASCENDENCIA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSIONPORASCENDENCIA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PENSIONGARANTIZADA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PENSIONGARANTIZADA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCREMENTODEPENSION,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCREMENTODEPENSION') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INDEMNIZACIONGLOBAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INDEMNIZACIONGLOBAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RECONOCIMIENTODEBENEFICIA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RECONOCIMIENTODEBENEFICIA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASISTENCIAMEDICAQUIRURGIC,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ASISTENCIAMEDICAQUIRURGIC') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SERVICIODEHOSPITALIZACION,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SERVICIODEHOSPITALIZACION') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APARATOSDEPROTESISYORTOPE,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_APARATOSDEPROTESISYORTOPE') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_REHABILITACION,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_REHABILITACION') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASISTENCIAOBSTETRICA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ASISTENCIAOBSTETRICA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CANASTILLA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CANASTILLA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_SUBSIDIOENDINERO,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_SUBSIDIOENDINERO') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CONSERVACIONDEDERECHO,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CONSERVACIONDEDERECHO') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ASIGNACIONESFAMILIARES,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ASIGNACIONESFAMILIARES') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_AYUDAASISTENCIAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_AYUDAASISTENCIAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RETIRODEFONDOSDELACUENTAI,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RETIRODEFONDOSDELACUENTAI') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APORTACIONESVOLUNTARIASAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_APORTACIONESVOLUNTARIASAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_CONTINUACIONVOLUNTARIAALR,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_CONTINUACIONVOLUNTARIAALR') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_INCORPORACIONVOLUNTARIAAL,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_INCORPORACIONVOLUNTARIAAL') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_APORTACIONESALINFONAVIT,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_APORTACIONESALINFONAVIT') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_DESCUENTOSDESTINADOSALPAG,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DESCUENTOSDESTINADOSALPAG') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_RIESGOSDETRABAJOSALARIOB,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_RIESGOSDETRABAJOSALARIOB') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_DESIGNACIONDEBENEFICIARIO,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_DESIGNACIONDEBENEFICIARIO') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_ADMINISTRADORASDEFONDOSPA,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_ADMINISTRADORASDEFONDOSPA') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTDESEGURIDADSODEC,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PRESTDESEGURIDADSODEC') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_PRESTDESEGURIDADSOLEY,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_PRESTDESEGURIDADSOLEY') in (2,9) AND\n"
                + "        CAST_TC_FED_SIMPLE(PREG_LIBERACIONDECREDITOHIPOTE,'TMP_FED_SEG_SOCIAL',ID_ORGANOJ,CLAVE_EXPEDIENTE,'PREG_LIBERACIONDECREDITOHIPOTE') in (2,9) \n"
                + "        THEN 99\n"
                + "ELSE -2\n"
                + "            END AS ID_TIPO_SEG_SOCIAL,\n"
                + "            -2 COD_ORG,\n"
                + "            -2 COD_EXPE\n"
                + "        FROM TMP_FED_SEG_SOCIAL\n"
                + "    ))";

        try {
            Statement stmt = conexionFed.getConexion().createStatement();
            System.out.println("ASqllll " + sql);
            resul = stmt.executeQuery(sql);

            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna 
                arrayList.add(fila); // Agregar la fila a la lista principal
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerysBdActToV3.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al leer la tabla TR_FED_SEG_SOCIAL_PREST_RECL" + ex);
            throw ex;
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexionFed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
