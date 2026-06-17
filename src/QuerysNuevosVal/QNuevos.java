/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuerysNuevosVal;

import Conexion.OracleConexionNE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.querys.V1querys;

public class QNuevos {

    OracleConexionNE conexion = new OracleConexionNE();
    String sql, NMunicipio;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList OrdinarioEstatusFE(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS \n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=9\n"
                + "AND (FECHA_DICTO_RESOLUCIONFE IS NULL OR FECHA_DICTO_RESOLUCIONFE='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList OrdinarioEstatusAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=1\n"
                + "AND (FECHA_DICTO_RESOLUCIONAP IS NULL OR FECHA_DICTO_RESOLUCIONAP='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList OrdinarioEstatusAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT *\n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=2\n"
                + "AND (FECHA_RESOLUCIONAJ IS NULL OR FECHA_DICTO_RESOLUCIONAP='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=3\n"
                + "AND (FECHA_DICTO_RESOLUCION_AD IS NULL OR FECHA_DICTO_RESOLUCION_AD='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusTA(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=4\n"
                + "AND (FECHA_RESOLUCION_TA IS NULL OR FECHA_RESOLUCION_TA='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=1\n"
                + "AND (FECHA_DICTO_RESOLUCION_AP IS NULL OR FECHA_DICTO_RESOLUCION_AP='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList IndividualEstatusAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=2\n"
                + "AND (FECHA_DICTO_RESOLUCION_AJ IS NULL OR FECHA_DICTO_RESOLUCION_AJ='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList ColectivoEstatusAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=3\n"
                + "AND (FECHA_DICTO_RESOLUCION_AD IS NULL OR FECHA_DICTO_RESOLUCION_AD='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList ColectivoEstatusAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=2\n"
                + "AND (FECHA_RESOLUCION_AJ IS NULL OR FECHA_RESOLUCION_AJ='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList HuelgaEstatusEH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "    FROM V3_TR_HUELGAJL\n"
                + "    WHERE ESTATUS_EXPEDIENTE=1\n"
                + "    AND FASE_SOLI_EXPEDIENTE=5\n"
                + "    AND (FECHA_RESOLU_EMPLAZ IS NULL OR FECHA_RESOLU_EMPLAZ='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList HuelgaEstatusPH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=6\n"
                + "AND (FECHA_RESOLU_EMPLAZ IS NULL OR FECHA_RESOLU_EMPLAZ='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList HuelgaEstatusH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=7\n"
                + "AND (FECHA_RESOLU_HUELGA IS NULL OR FECHA_RESOLU_HUELGA='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Colect_EconomEstatusCE(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_COLECT_ECONOMJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND FASE_SOLI_EXPEDIENTE=8\n"
                + "AND (FECHA_RESOLUCION IS NULL OR FECHA_RESOLUCION='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList ParaprocesalEstatus(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_PARAPROCESALJL\n"
                + "WHERE ESTATUS_EXPEDIENTE=1\n"
                + "AND (FECHA_CONCLUSION_EXPE IS NULL OR FECHA_CONCLUSION_EXPE='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList EjecucionEstatus(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " SELECT CLAVE_ORGANO,EXPEDIENTE_CLAVE,COMENTARIOS\n"
                + "FROM V3_TR_EJECUCIONJL\n"
                + "WHERE ESTATUS_EXPE=1\n"
                + "AND (FECHA_CONCLUSION IS NULL OR FECHA_CONCLUSION='09/09/1899')\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "')OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si en los campos ¿Hubo celebración de audiencia preliminar? (AUDIENCIA_PRELIM) y ¿Hubo celebración de audiencia de juicio? (AUDIENCIA_JUICIO) se selecciona la opcion Sí, en el campo Estatus de la demanda (ID_ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList OrdinarioEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, ESTATUS_DEMANDA\n"
                + "FROM V3_TR_ORDINARIOJL \n"
                + "WHERE ESTATUS_DEMANDA <> 1\n"
                + "AND (AUDIENCIA_PRELIM = 1 OR AUDIENCIA_JUICIO = 1)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Si en los campos ¿Hubo tramitación  por auto de depuración? (TRAMITACION_DEPURACION), ¿Hubo celebración de audiencia preliminar? (AUDIENCIA_PRELIM) y ¿Hubo celebración de audiencia de juicio? (AUDIENCIA_JUICIO) se selecciona la opcion Sí, en el campo Estatus de la demanda (ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList IndividualEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, ESTATUS_DEMANDA\n"
                + "FROM V3_TR_INDIVIDUALJL \n"
                + "WHERE ESTATUS_DEMANDA <> 1\n"
                + "AND (TRAMITACION_DEPURACION = 1 OR AUDIENCIA_PRELIM = 1 OR AUDIENCIA_JUICIO = 1)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si en los campos ¿Hubo tramitación  por auto de depuración? (AUTO_DEPURACION)) y ¿Hubo celebración de audiencia de juicio? (AUDIENCIA_JUICIO) se selecciona la opcion Sí, en el campo Estatus de la demanda (ID_ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList ColectivoEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, ESTATUS_DEMANDA\n"
                + "FROM V3_TR_COLECTIVOJL \n"
                + "WHERE ESTATUS_DEMANDA <> 1\n"
                + "AND (AUTO_DEPURACION = 1 OR AUDIENCIA_JUICIO = 1)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si en los campos ¿Hubo celebración de audiencia dentro del procedimiento colectivo de naturaleza económica? (AUDIENCIA_ECONOM) se selecciona la opcion Sí, en el campo Estatus de la demanda (ESTATUS_DEMANDA) debe contener la opción Admitida. 
    public ArrayList Colectivo_EconomEstatusDemanda(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, ESTATUS_DEMANDA\n"
                + "FROM V3_TR_COLECT_ECONOMJL \n"
                + "WHERE ESTATUS_DEMANDA <> 1\n"
                + "AND AUDIENCIA_ECONOM = 1\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCIONFE), Fecha en la que se dictó la resolución (FECHA_DICTO_RESOLUCIONFE) y Monto estipulado en la forma de solución(MONTO_SOLUCION_FE) de la Fase escrita, el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Fase escrita.
    public ArrayList OrdinarioFaseSolExpFE(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCIONFE IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCIONFE IS NOT NULL\n"
                + "OR MONTO_SOLUCION_FE IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCIONAP), Fecha en la que se dictó la resolución (FECHA_DICTO_RESOLUCIONAP) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AP), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia Preliminar.
    public ArrayList OrdinarioFaseSolExpAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCIONAP IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCIONAP IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AP IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCIONAJ), Fecha en la que se dictó la resolución (FECHA_RESOLUCIONAJ) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AJ), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia de Juicio.
    public ArrayList OrdinarioFaseSolExpAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_ORDINARIOJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCIONAJ IS NOT NULL\n"
                + "OR FECHA_RESOLUCIONAJ IS NOT NULL\n"
                + "OR MONTO_SOLUCIONAJ IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //  Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_AP), Fecha en la que se dictó la resolución (FECHA_DICTO_RESOLUCION_AP) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AP), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia Prelimiar.
    public ArrayList IndividualFaseSolExpAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_AP IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCION_AP IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AP IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_AJ), Fecha en la que se dictó la resolución (FECHA_DICTO_RESOLUCION_AJ) y Monto estipulado en la forma de solución(MONTO_SOLUCIÓN_AJ), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia de Juicio.
    public ArrayList IndividualFaseSolExpAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_AJ IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCION_AJ IS NOT NULL\n"
                + "OR TIPO_SENTENCIA_AJ IS NOT NULL\n"
                + "OR MONTO_SOLUCIÓN_AJ IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_AD), Fecha en la que se dictó la resolución (FECHA_DICTO_RESOLUCION_AD) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AP), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Tramitación por auto de depuración.
    public ArrayList IndividualFaseSolExpAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_AD IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCION_AD IS NOT NULL\n"
                + "OR TIPO_SENTENCIA_AD IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AD IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_TA), Fecha en la que se dictó la resolución (FECHA_RESOLUCION_TA) y Monto estipulado en la forma de solución(MONTO_SOLUCIÓN_TA), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Tramitación sin audiencias.
    public ArrayList IndividualFaseSolExpTA(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_TA IS NOT NULL\n"
                + "OR FECHA_RESOLUCION_TA IS NOT NULL\n"
                + "OR TIPO_SENTENCIA_TA IS NOT NULL\n"
                + "OR MONTO_SOLUCIÓN_TA IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_AJ), Fecha en la que se dictó la resolución (FECHA_RESOLUCION_AJ) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AJ), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia de Juicio.
    public ArrayList ColectivoFaseSolExpAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_AJ IS NOT NULL\n"
                + "OR FECHA_RESOLUCION_AJ IS NOT NULL\n"
                + "OR TIPO_SENTENCIA_AJ IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AJ IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_TA), Fecha en la que se dictó la resolución (FECHA_RESOLUCION_TA) y Monto estipulado en la forma de solución(MONTO_SOLUCIÓN_TA), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Tramitación sin audiencias.
    public ArrayList ColectivoFaseSolExpAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_AD IS NOT NULL\n"
                + "OR FECHA_DICTO_RESOLUCION_AD IS NOT NULL\n"
                + "OR TIPO_SENTENCIA_AD IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AD IS NOT NULL\n"
                + "OR MONTO_SOLUCION_AD IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_EMPLAZ), Fecha en la que se dictó la resolución (FECHA_RESOLU_EMPLAZ) y Monto estipulado en la forma de solución(INCREMENTO_OTORGADO), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Emplazamiento a Huelga ó Huelga.
    public ArrayList HuelgaFaseSolExpEmplaz(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_HUELGAJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_EMPLAZ IS NOT NULL\n"
                + "OR FECHA_RESOLU_EMPLAZ IS NOT NULL\n"
                + "OR INCREMENTO_SOLICITADO IS NOT NULL\n"
                + "OR INCREMENTO_OTORGADO IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_HUELGA), Fecha en la que se dictó la resolución (FECHA_RESOLU_HUELGA),Tipo de sentencia (Tipo_sentencia),Fecha de estallamiento a huelga,fecha de levantamiento a huelga,porcentaje por salarios caido y Monto estipulado, el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Huelga.
    public ArrayList HuelgaFaseSolExpHu(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_HUELGAJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION_HUELGA IS NOT NULL\n"
                + "OR FECHA_RESOLU_HUELGA IS NOT NULL\n"
                + "OR TIPO_SENTENCIA IS NOT NULL\n"
                + "OR FECHA_ESTALLAM_HUELGA IS NOT NULL\n"
                + "OR FECHA_LEVANT_HUELGA IS NOT NULL\n"
                + "OR MONTO_ESTIPULADO IS NOT NULL\n"
                + "OR SALARIOS_CAIDOS IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION), Fecha en la que se dictó la resolución (FECHA_RESOLUCION), Monto estipulado en la forma de solución(MONTO_SOLUCION_AP), etc., el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Audiencia dentro del procedimiento colectivo de naturaleza económica.
    public ArrayList Colectivo_EconomFaseSolExpAPC(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CLAVE_ORGANO, EXPEDIENTE_CLAVE, COMENTARIOS, FASE_SOLI_EXPEDIENTE\n"
                + "FROM V3_TR_COLECT_ECONOMJL\n"
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 99) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
                + "AND (FORMA_SOLUCION IS NOT NULL\n"
                + "OR FECHA_RESOLUCION IS NOT NULL\n"
                + "OR TIPO_SENTENCIA IS NOT NULL\n"
                + "OR AUMENTO_PERSONAL IS NOT NULL\n"
                + "OR DISMINUCION_PERSONAL IS NOT NULL\n"
                + "OR AUMENTO_JORNADALAB IS NOT NULL\n"
                + "OR DISMINUCION_JORNADALAB IS NOT NULL\n"
                + "OR AUMENTO_SEMANA IS NOT NULL\n"
                + "OR DISMINUCION_SEMANA IS NOT NULL\n"
                + "OR AUMENTO_SALARIOS IS NOT NULL\n"
                + "OR DISMINUCION_SALARIOS IS NOT NULL)\n"
                + "AND ((CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "') OR (SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) es solucionado (1), la fase de solución del expediente (FASE_SOLI_EXPEDIENTE) debe ser = Tramitación sin audiencias (3).
    public ArrayList Individual_FaseSolTSA(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                + "       1, 'Audiencia preliminar',\n"
                + "       2, 'Audiencia de juicio',\n"
                + "       3, 'Tramitación por auto de depuración',\n"
                + "       4, 'Tramitación sin audiencias',\n"
                + "       5, 'Emplazamiento a huelga',\n"
                + "       6, 'Prehuelga',\n"
                + "       7, 'Huelga',\n"
                + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                + "       9, 'Fase escrita',\n"
                + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                + "    COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 2\n"
                + "    AND AUDIENCIA_JUICIO = 2\n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FASE_SOLI_EXPEDIENTE NOT IN (9,99)\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = Sí (1) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fase de solución del expediente (FASE_SOLI_EXPEDIENTE) debe ser = Tramitación por auto de depuración (4).
    public ArrayList Individual_FaseSolTPAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                + "       1, 'Audiencia preliminar',\n"
                + "       2, 'Audiencia de juicio',\n"
                + "       3, 'Tramitación por auto de depuración',\n"
                + "       4, 'Tramitación sin audiencias',\n"
                + "       5, 'Emplazamiento a huelga',\n"
                + "       6, 'Prehuelga',\n"
                + "       7, 'Huelga',\n"
                + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                + "       9, 'Fase escrita',\n"
                + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                + "    COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 1\n"
                + "  AND AUDIENCIA_PRELIM = 2\n"
                + "  AND AUDIENCIA_JUICIO = 2\n"
                + "  AND ESTATUS_EXPEDIENTE = 1\n"
                + "  AND FASE_SOLI_EXPEDIENTE NOT IN (4,99)\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = si (1) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser igual o mayor a la fecha de auto de depuración (FECHA_DEPURACION).
    public ArrayList Individual_FechaACP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, FECHA_ACTO_PROCESAL, FECHA_DEPURACION, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 1\n"
                + "  AND AUDIENCIA_PRELIM = 2\n"
                + "  AND AUDIENCIA_JUICIO = 2\n"
                + "  AND ESTATUS_EXPEDIENTE = 2\n"
                + "  AND FECHA_ACTO_PROCESAL < FECHA_DEPURACION\n"
                + "  AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "  AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = si (1) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fecha de solución en fase auto depuración (FECHA_DICTO_RESOLUCION_AD) debe ser igual o mayor a la Fecha de auto de depuración (FECHA_DEPURACION).
    public ArrayList Individual_FechaDRAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, FECHA_DICTO_RESOLUCION_AD, FECHA_DEPURACION, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 1 \n"
                + "    AND AUDIENCIA_PRELIM = 2\n"
                + "    AND AUDIENCIA_JUICIO = 2 \n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FECHA_DICTO_RESOLUCION_AD < FECHA_DEPURACION\n"
                + "    AND FECHA_DICTO_RESOLUCION_AD <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaDRAD = resul.getString("FECHA_DICTO_RESOLUCION_AD");
                if (fechaDRAD != null && fechaDRAD.length() >= 10) {
                    String[] partesFecha = fechaDRAD.substring(0, 10).split("-");
                    fechaDRAD = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaDRAD,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = Si (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fase de solución del expediente (FASE_SOLI_EXPEDIENTE) debe ser = audiencia preliminar (1).
    public ArrayList Individual_FaseSolAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                + "       1, 'Audiencia preliminar',\n"
                + "       2, 'Audiencia de juicio',\n"
                + "       3, 'Tramitación por auto de depuración',\n"
                + "       4, 'Tramitación sin audiencias',\n"
                + "       5, 'Emplazamiento a huelga',\n"
                + "       6, 'Prehuelga',\n"
                + "       7, 'Huelga',\n"
                + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                + "       9, 'Fase escrita',\n"
                + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                + "    COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2 \n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FASE_SOLI_EXPEDIENTE NOT IN (1,99)\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = si (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solucion (2), la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser igual o mayor a la fecha de audiencia preliminar (FECHA_AUDIENCIA_PRELIM).
    public ArrayList Individual_FechaUAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, \n"
                + "FECHA_ACTO_PROCESAL, FECHA_AUDIENCIA_PRELIM,  FECHA_DEPURACION, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2 \n"
                + "        AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND (FECHA_ACTO_PROCESAL < FECHA_AUDIENCIA_PRELIM \n"
                + "            OR FECHA_ACTO_PROCESAL < FECHA_DEPURACION)\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_PRELIM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = si (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE ) = Solucionado (1), la fecha de solución en fase preliminar (FECHA_DICTO_RESOLUCION_AP) debe ser igual o mayor a la fecha de audiencia preliminar (FECHA_AUDIENCIA_PRELIM).
    public ArrayList Individual_FechaDRAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, \n"
                + "FECHA_DICTO_RESOLUCION_AP, FECHA_DEPURACION,  FECHA_AUDIENCIA_PRELIM, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2 \n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND (FECHA_DICTO_RESOLUCION_AP < FECHA_AUDIENCIA_PRELIM )\n"
                + "    AND FECHA_DICTO_RESOLUCION_AP <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_PRELIM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaDRAP = resul.getString("FECHA_DICTO_RESOLUCION_AP");
                if (fechaDRAP != null && fechaDRAP.length() >= 10) {
                    String[] partesFecha = fechaDRAP.substring(0, 10).split("-");
                    fechaDRAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaDRAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = Si (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = SI (1) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fase de solución del expediente (FASE_SOLI_EXPEDIENTE) debe ser = audiencia de juicio (2).
    public ArrayList Individual_FaseSolAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                + "       1, 'Audiencia preliminar',\n"
                + "       2, 'Audiencia de juicio',\n"
                + "       3, 'Tramitación por auto de depuración',\n"
                + "       4, 'Tramitación sin audiencias',\n"
                + "       5, 'Emplazamiento a huelga',\n"
                + "       6, 'Prehuelga',\n"
                + "       7, 'Huelga',\n"
                + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                + "       9, 'Fase escrita',\n"
                + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                + "    COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 1 \n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND fase_soli_expediente not in (2,99)\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = Sí (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = si (1) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser mayor a la fecha de audiencia preliminar (FECHA_AUDIENCIA_PRELIM ) y  mayor o igual a la fecha de audiencia de juicio (FECHA_AUDIENCIA_JUICIO). 
    public ArrayList Individual_FechaUAPAPAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, \n"
                + "FECHA_ACTO_PROCESAL, FECHA_AUDIENCIA_PRELIM,  FECHA_DEPURACION, FECHA_AUDIENCIA_JUICIO, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 1 \n"
                + "    AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND (FECHA_ACTO_PROCESAL <= FECHA_AUDIENCIA_PRELIM \n"
                + "            OR FECHA_ACTO_PROCESAL < FECHA_AUDIENCIA_JUICIO)\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_PRELIM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_JUICIO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (TRAMITACION_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia preliminar (AUDIENCIA_PRELIM)? = Sí (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = si (1) y estatus del expediente (ESTATUS_EXPEDIENTE ) = Solucionado (1), la fecha de solución en fase audiencia de juicio (FECHA_DICTO_RESOLUCION_AJ) debe ser mayor a la fecha de audiencia preliminar (FECHA_AUDIENCIA_PRELIM) y mayor o igual a la fecha de audiencia de juicio (FECHA_AUDIENCIA_JUICIO).
    public ArrayList Individual_FechaDRAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, TRAMITACION_DEPURACION, AUDIENCIA_PRELIM, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, \n"
                + "FECHA_DICTO_RESOLUCION_AJ, FECHA_DEPURACION,  FECHA_AUDIENCIA_PRELIM, FECHA_AUDIENCIA_JUICIO, COMENTARIOS\n"
                + "FROM V3_TR_INDIVIDUALJL\n"
                + "WHERE TRAMITACION_DEPURACION = 2\n"
                + "    AND AUDIENCIA_PRELIM = 1\n"
                + "    AND AUDIENCIA_JUICIO = 1 \n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND ( FECHA_DICTO_RESOLUCION_AJ <= FECHA_AUDIENCIA_PRELIM \n"
                + "            OR FECHA_ACTO_PROCESAL < FECHA_AUDIENCIA_JUICIO)\n"
                + "    AND FECHA_DICTO_RESOLUCION_AJ <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_PRELIM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_JUICIO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaDRAJ = resul.getString("FECHA_DICTO_RESOLUCION_AJ");
                if (fechaDRAJ != null && fechaDRAJ.length() >= 10) {
                    String[] partesFecha = fechaDRAJ.substring(0, 10).split("-");
                    fechaDRAJ = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaDRAJ,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION)? = Sí (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fase de solución del expediente debe ser (FASE_SOLI_EXPEDIENTE) = Tramitación por auto de depuración (3).
    public ArrayList Colectivo_FaseSolTPAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, EXPEDIENTE_CLAVE, PERIODO, AUTO_DEPURACION, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                + "       1, 'Audiencia preliminar',\n"
                + "       2, 'Audiencia de juicio',\n"
                + "       3, 'Tramitación por auto de depuración',\n"
                + "       4, 'Tramitación sin audiencias',\n"
                + "       5, 'Emplazamiento a huelga',\n"
                + "       6, 'Prehuelga',\n"
                + "       7, 'Huelga',\n"
                + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                + "       9, 'Fase escrita',\n"
                + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                + "    COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE AUTO_DEPURACION = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2\n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FASE_SOLI_EXPEDIENTE NOT IN (3,99)\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION)? = Sí (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2), la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser igual o mayor a la Fecha de auto de depuración (FECHA_DEPURACION).
    public ArrayList Colectivo_FechaAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, PERIODO,EXPEDIENTE_CLAVE, AUTO_DEPURACION, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, FECHA_ACTO_PROCESAL, FECHA_DEPURACION, COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE AUTO_DEPURACION = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2\n"
                + "    AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND FECHA_ACTO_PROCESAL < FECHA_DEPURACION\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION)? = Sí (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = No (2) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fecha de solución en fase Tramitación por auto de depuración (FECHA_DICTO_RESOLUCION_AD) debe ser mayor o igual a la Fecha de auto de depuración (FECHA_DEPURACION).
    public ArrayList Colectivo_FechaDRAD(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, PERIODO,EXPEDIENTE_CLAVE, AUTO_DEPURACION, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, FECHA_DICTO_RESOLUCION_AD, FECHA_DEPURACION, COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE AUTO_DEPURACION = 1\n"
                + "    AND AUDIENCIA_JUICIO = 2\n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FECHA_DICTO_RESOLUCION_AD < FECHA_DEPURACION\n"
                + "    AND FECHA_DICTO_RESOLUCION_AD <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_DEPURACION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaDRAD = resul.getString("FECHA_DICTO_RESOLUCION_AD");
                if (fechaDRAD != null && fechaDRAD.length() >= 10) {
                    String[] partesFecha = fechaDRAD.substring(0, 10).split("-");
                    fechaDRAD = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaDRAD,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    /// Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION) = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = Sí (1) y estatus del expediente (ESTATUS_EXPEDIENTE) = Solucionado (1), la fase de solución del expediente (FASE_SOLI_EXPEDIENTE) debe ser = Audiencia de Juicio (2).
    public ArrayList Colectivo_FaseSoliAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
            Array = new ArrayList();
            sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, PERIODO,EXPEDIENTE_CLAVE, AUTO_DEPURACION, AUDIENCIA_JUICIO, ESTATUS_EXPEDIENTE, DECODE(FASE_SOLI_EXPEDIENTE,\n"
                    + "       1, 'Audiencia preliminar',\n"
                    + "       2, 'Audiencia de juicio',\n"
                    + "       3, 'Tramitación por auto de depuración',\n"
                    + "       4, 'Tramitación sin audiencias',\n"
                    + "       5, 'Emplazamiento a huelga',\n"
                    + "       6, 'Prehuelga',\n"
                    + "       7, 'Huelga',\n"
                    + "       8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica',\n"
                    + "       9, 'Fase escrita',\n"
                    + "       99, 'No identificado') AS FASE_SOLI_EXPEDIENTE,\n"
                    + "    COMENTARIOS\n"
                    + "FROM V3_TR_COLECTIVOJL\n"
                    + "WHERE AUTO_DEPURACION = 2\n"
                    + "    AND AUDIENCIA_JUICIO = 1\n"
                    + "    AND ESTATUS_EXPEDIENTE = 1\n"
                    + "    AND FASE_SOLI_EXPEDIENTE NOT IN (2,99)\n"
                    + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
            System.out.println(sql);
            resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    resul.getString("FASE_SOLI_EXPEDIENTE"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION)? = No (1) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = Sí (1) y estatus del expediente (ESTATUS_EXPEDIENTE) es igual a solucionado (1) la fecha en la que se dictó la resolución de audiencia de juicio (FECHA_RESOLUCION_AJ) debe ser igual o mayor a la fecha de audiencia de juicio (FECHA_AUDIENCIA_JUICIO).
    public ArrayList Colectivo_FechaResolAJ(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, PERIODO,EXPEDIENTE_CLAVE, AUTO_DEPURACION, AUDIENCIA_JUICIO, FECHA_DEPURACION, FECHA_AUDIENCIA_JUICIO, COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL\n"
                + "WHERE AUTO_DEPURACION = 2\n"
                + "    AND AUDIENCIA_JUICIO = 1\n"
                + "    AND ESTATUS_EXPEDIENTE=1\n"
                + "    AND FECHA_RESOLUCION_AJ < FECHA_AUDIENCIA_JUICIO\n"
                + "    AND FECHA_AUDIENCIA_JUICIO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_RESOLUCION_AJ <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaDRAJ = resul.getString("FECHA_RESOLUCION_AJ");
                if (fechaDRAJ != null && fechaDRAJ.length() >= 10) {
                    String[] partesFecha = fechaDRAJ.substring(0, 10).split("-");
                    fechaDRAJ = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaDRAJ,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo tramitación por auto de depuración (AUTO_DEPURACION)? = No (2) y ¿Hubo celebración de audiencia de juicio (AUDIENCIA_JUICIO)? = Sí (1) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser igual o mayor a la fecha de audiencia de Juicio (AUDIENCIA_JUICIO).
    public ArrayList Colectivo_FechaActoProc(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, PERIODO, EXPEDIENTE_CLAVE, AUTO_DEPURACION, AUDIENCIA_JUICIO, FECHA_ACTO_PROCESAL, FECHA_DEPURACION, FECHA_AUDIENCIA_JUICIO, COMENTARIOS\n"
                + "FROM V3_TR_COLECTIVOJL  \n"
                + "WHERE AUTO_DEPURACION = 2\n"
                + "    AND AUDIENCIA_JUICIO = 1\n"
                + "    AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND (FECHA_ACTO_PROCESAL < FECHA_DEPURACION)\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_JUICIO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo emplazamiento a huelga (EMPLAZAMIENTO_HUELGA)? = si (1) y estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser mayor o igual a la fecha de emplazamiento a huelga (FECHA_EMPLAZAMIENTO).
    public ArrayList Huelga_FechaAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, EMPLAZAMIENTO_HUELGA, ESTATUS_EXPEDIENTE, FECHA_ACTO_PROCESAL, FECHA_EMPLAZAMIENTO, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE EMPLAZAMIENTO_HUELGA = 1\n"
                + "    AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND FECHA_ACTO_PROCESAL < FECHA_EMPLAZAMIENTO\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_EMPLAZAMIENTO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo prehuelga? (PREHUELGA) = si (1), la fecha de audiencia de conciliación (FECHA_AUDIENCIA) debe ser mayor a la fecha de emplazamiento a huelga (FECHA_EMPLAZAMIENTO).
    public ArrayList Huelga_FechaAudi(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, EXPEDIENTE_CLAVE,  PERIODO, PREHUELGA, FECHA_AUDIENCIA, FECHA_EMPLAZAMIENTO, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE PREHUELGA = 1\n"
                + "    AND FECHA_AUDIENCIA <= FECHA_EMPLAZAMIENTO\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_EMPLAZAMIENTO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAudi = resul.getString("FECHA_AUDIENCIA");
                if (fechaAudi != null && fechaAudi.length() >= 10) {
                    String[] partesFecha = fechaAudi.substring(0, 10).split("-");
                    fechaAudi = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAudi,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo prehuelga (PREHUELGA)? = Sí (1), y el estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2), la fecha de audiencia de conciliación (FECHA_AUDIENCIA) debe ser menor o igual a la fecha del ultimo acto procesal (FECHA_ACTO_PROCESAL).
    public ArrayList Huelga_FechaAudi2(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, EXPEDIENTE_CLAVE, PERIODO, PREHUELGA, FECHA_AUDIENCIA, FECHA_EMPLAZAMIENTO, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE PREHUELGA = 1\n"
                + "AND ESTATUS_EXPEDIENTE=2\n"
                + "    AND FECHA_AUDIENCIA > FECHA_ACTO_PROCESAL\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAudi = resul.getString("FECHA_AUDIENCIA");
                if (fechaAudi != null && fechaAudi.length() >= 10) {
                    String[] partesFecha = fechaAudi.substring(0, 10).split("-");
                    fechaAudi = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAudi,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando hubo estallamiento a huelga (ESTALLAMIENTO_HUELGA) = si (1), y el estatus del expediente (ESTATUS_EXPEDIENTE) es igual a solucionado (1) la fecha de estallamiento a huelga (FECHA_ESTALLAM_HUELGA) debe ser mayor a la fecha de audiencia de conciliación (FECHA_AUDIENCIA) y a la fecha de emplazamiento (FECHA_EMPLAZAMIENTO).
    public ArrayList Huelga_FechaEstallaH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, PREHUELGA, FECHA_ESTALLAM_HUELGA, FECHA_AUDIENCIA, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE ESTALLAMIENTO_HUELGA = 1\n"
                + "AND ESTATUS_EXPEDIENTE=1 \n"
                + "    AND (FECHA_ESTALLAM_HUELGA <= FECHA_AUDIENCIA\n"
                + "    OR FECHA_ESTALLAM_HUELGA <= FECHA_EMPLAZAMIENTO\n"
                + "    )\n"
                + "    AND FECHA_ESTALLAM_HUELGA <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_EMPLAZAMIENTO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaEstall = resul.getString("FECHA_ESTALLAM_HUELGA");
                if (fechaEstall != null && fechaEstall.length() >= 10) {
                    String[] partesFecha = fechaEstall.substring(0, 10).split("-");
                    fechaEstall = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaEstall,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // Cuando ¿Hubo emplazamiento a huelga (EMPLAZAMIENTO_HUELGA)? = Sí (1) ,¿Hubo prehuelga (PREHUELGA)? = Sí (1), ¿Hubo estallamiento de la huelga (ESTALLAMIENTO_HUELGA)? = si (1), y el estatus del expediente (ESTATUS_EXPEDIENTE) = en proceso de solución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser mayor a la fecha del emplazamiento a huelga (FECHA_EMPLAZAMIENTO) y a la Fecha de audiencia de conciliación (FECHA_AUDIENCIA).
    public ArrayList Huelga_FechaAPAEH(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, PREHUELGA, FECHA_ESTALLAM_HUELGA, FECHA_AUDIENCIA, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE  EMPLAZAMIENTO_HUELGA=1\n"
                + "AND PREHUELGA=1\n"
                + "AND ESTALLAMIENTO_HUELGA = 1\n"
                + "AND ESTATUS_EXPEDIENTE=2 \n"
                + "    AND (FECHA_ACTO_PROCESAL <= FECHA_AUDIENCIA\n"
                + "    OR FECHA_ACTO_PROCESAL <= FECHA_EMPLAZAMIENTO\n"
                + "    )\n"
                + "    AND FECHA_AUDIENCIA <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_EMPLAZAMIENTO <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    // La fecha de estallamiento a huelga (FECHA_ESTALLAM_HUELGA) no puede ser Null ni NO identificado.
    public ArrayList Huelga_FechaEstallaH2(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, FECHA_ESTALLAM_HUELGA, COMENTARIOS\n"
                + "FROM V3_TR_HUELGAJL \n"
                + "WHERE  ESTALLAMIENTO_HUELGA = 1\n"
                + "AND ESTATUS_EXPEDIENTE = 1   \n"
                + "    AND (FECHA_ESTALLAM_HUELGA IS NULL\n"
                + "    OR FECHA_ESTALLAM_HUELGA = TO_DATE('09/09/1899','DD/MM/YYYY') ) \n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaEstall = resul.getString("FECHA_ESTALLAM_HUELGA");
                if (fechaEstall != null && fechaEstall.length() >= 10) {
                    String[] partesFecha = fechaEstall.substring(0, 10).split("-");
                    fechaEstall = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaEstall,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Cuando ¿Hubo celebración de audiencia dentro del procedimiento colectivo de naturaleza económica (AUDIENCIA_ECONOM)? = Si (1) y el estatus del expediente (ESTATUS_EXPEDIENTE) = En proceso de resolución (2) la fecha del último acto procesal (FECHA_ACTO_PROCESAL) debe ser igual o mayor a la Fecha de audiencia dentro del procedimiento colectivo de naturaleza económica (FECHA_AUDIENCIA_ECONOM).
    public ArrayList ColectEconom_FechaAP(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO,EXPEDIENTE_CLAVE, PERIODO, AUDIENCIA_ECONOM, ESTATUS_EXPEDIENTE, FECHA_ACTO_PROCESAL, FECHA_AUDIENCIA_ECONOM, COMENTARIOS\n"
                + "FROM V3_TR_COLECT_ECONOMJL\n"
                + "WHERE AUDIENCIA_ECONOM = 1\n"
                + "    AND ESTATUS_EXPEDIENTE = 2\n"
                + "    AND FECHA_ACTO_PROCESAL < FECHA_AUDIENCIA_ECONOM\n"
                + "        AND FECHA_ACTO_PROCESAL <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_ECONOM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaAP = resul.getString("FECHA_ACTO_PROCESAL");
                if (fechaAP != null && fechaAP.length() >= 10) {
                    String[] partesFecha = fechaAP.substring(0, 10).split("-");
                    fechaAP = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaAP,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // uando ¿Hubo celebración de audiencia dentro del procedimiento colectivo de naturaleza económica (AUDIENCIA_ECONOM)? = Si (1) y el estatus del expediente (ESTATUS_EXPEDIENTE) = concluido (1) la fecha de resolución (FECHA_RESOLUCION) debe ser mayor o igual a la fecha de audiencia dentro del procedimiento colectivo de naturaleza económica (FECHA_AUDIENCIA_ECONOM).
    public ArrayList ColectEconom_FechaResol(String claveorgano, String entidad, String periodo) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT SUBSTR(CLAVE_ORGANO,0,2) AS ENTIDAD, CLAVE_ORGANO, EXPEDIENTE_CLAVE, PERIODO, AUDIENCIA_ECONOM, ESTATUS_EXPEDIENTE, FECHA_RESOLUCION, FECHA_AUDIENCIA_ECONOM, COMENTARIOS\n"
                + "FROM V3_TR_COLECT_ECONOMJL\n"
                + "WHERE AUDIENCIA_ECONOM = 1\n"
                + "    AND ESTATUS_EXPEDIENTE = 1\n"
                + "    AND FECHA_RESOLUCION < FECHA_AUDIENCIA_ECONOM\n"
                + "        AND FECHA_RESOLUCION <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND FECHA_AUDIENCIA_ECONOM <> TO_DATE('09/09/1899','DD/MM/YYYY')\n"
                + "    AND ((SUBSTR(CLAVE_ORGANO,0,2)='" + entidad + "' AND PERIODO='" + periodo + "') OR (CLAVE_ORGANO='" + claveorgano + "' AND PERIODO='" + periodo + "'))";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                String fechaRAD = resul.getString("FECHA_RESOLUCION");
                if (fechaRAD != null && fechaRAD.length() >= 10) {
                    String[] partesFecha = fechaRAD.substring(0, 10).split("-");
                    fechaRAD = partesFecha[2] + "/" + partesFecha[1] + "/" + partesFecha[0]; // DD/MM/YYYY
                }
                Array.add(new String[]{
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("EXPEDIENTE_CLAVE"),
                    fechaRAD,
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(V1querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
}
