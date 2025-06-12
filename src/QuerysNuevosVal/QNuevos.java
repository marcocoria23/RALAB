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
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 9) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
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
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 9) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
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
                + "WHERE ((FASE_SOLI_EXPEDIENTE IN 9) OR (FASE_SOLI_EXPEDIENTE IS NULL))\n"
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
                + "OR MONTO_SOLUCION_AD IS NOT NULL)\n"
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
    
    // Si se encuentra registro en los campos Forma de solución (FORMA_SOLUCION_HUELGA), Fecha en la que se dictó la resolución (FECHA_RESOLU_HUELGA) y Monto estipulado en la forma de solución(MONTO_SOLUCION_AP), el campo Fase en la que se solucionó el expediente (FASE_SOLI_EXPEDIENTE) debe contener la opción Huelga.
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
                + "OR DIAS_HUELGA IS NOT NULL\n"
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
}
