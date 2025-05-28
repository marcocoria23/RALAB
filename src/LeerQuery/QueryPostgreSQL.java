package LeerQuery;

import Conexion.ConexionPostgreSQL;
import Conexion.ConexionPostgreSQLBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*@author ALEJANDRO.CASTILLO  */

public class QueryPostgreSQL {
    
    ConexionPostgreSQLBD conexion  = new ConexionPostgreSQLBD(); 
     ConexionPostgreSQL cone  = new ConexionPostgreSQL(); 
    ResultSet resul;
    String sql = "";
    ArrayList<ArrayList<String>> arrayList;
    
    public ArrayList<ArrayList<String>> NombreBDPostgres(String usuario , String contrasenia) throws SQLException{
         Statement stmt =  cone.conectar(usuario, contrasenia).createStatement();
       arrayList = new ArrayList<>();
        String sql =  "SELECT datname \n" +
"FROM pg_database;";   
          try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
      arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_ACTOR " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    public void eliminarTablas(String usuario , String contrasenia,String bd ) throws SQLException{
        try{
                Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement(); 
                sql = "DO $$ \n" +
                "DECLARE \n" +
                "    r RECORD;\n" +
                "BEGIN\n" +
                "    -- Elimina todas las tablas\n" +
                "    FOR r IN (SELECT tablename \n" +
                "              FROM pg_tables \n" +
                "              WHERE schemaname = 'public') \n" +
                "    LOOP\n" +
                "        EXECUTE 'DROP TABLE IF EXISTS public.' || r.tablename || ' CASCADE';\n" +
                "    END LOOP;\n" +
                "END $$;";
            stmt.execute(sql);
            System.out.println("Bloque PL/pgSQL ejecutado correctamente.");
        }
        catch(SQLException ex){
            Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al ejecutar el Bloque " + ex);
            throw ex;
        }
        finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    
    
    public String clavesOrgano ( String usuario , String contrasenia,String bd) throws SQLException {
        StringBuilder consultaFiltro = new StringBuilder();
        try{
        Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement(); 
        String sql = "   select distinct id_organoj from tr_organoj  ";
        resul = stmt.executeQuery(sql);
                while (resul.next()) {
                    consultaFiltro.append(resul.getString(1));
                    consultaFiltro.append(",");
                }
             consultaFiltro.deleteCharAt(consultaFiltro.lastIndexOf(","));
        }
        catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en las claves de Organo " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
          
        return   consultaFiltro.toString();
    }
    
    
    
     public ArrayList<ArrayList<String>> DBO_Tr_Actor(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql =  
"    select \n" +
"ID_ACTOR ,\n" +
"ID_ORGANOJ ,\n" +
"ID_TIPO_ACTOR ,\n" +
"ID_DEFENSA ,\n" +
"ID_SEXO ,\n" +
"EDAD ,\n" +
"ID_OCUPACION ,\n" +
"NSS ,\n" +
"CURP ,\n" +
"RFC ,\n" +
"ID_JORNADA ,\n" +
"NOMBRE_SINDICATO ,\n" +
"REGISTRO_ASO_SINDICAL ,\n" +
"ID_TIPO_SINDICATO ,\n" +
"PREG_SIND_PERT_ORG_O , \n" +
"ID_ORG_OBR , \n" +
"CANT_TRAB_INVOL_H , \n" +
"CANT_TRAB_INVOL_M ,\n" +
"CANT_TRAB_INVOL_NI ,\n" +
"TOTAL_TRAB_INVOL ,\n" +
"ID_TIPO_PATRON ,\n" +
"RAZON_SOCIAL ,\n" +
"CALLE ,\n" +
"NUM_EXTERIOR,\n" +
"NUM_INTERIOR,\n" +
"COLONIA,\n" +
"CP,\n" +
"p.ID_ENT_MPIO,\n" +
"LATITUD,\n" +
"LONGITUD,\n" +
"p.COMENTARIOS,\n" +
"'"+ periodo +"' PERIODO,\n" +
"null ID_UNIQUE\n" +
"\n" +
"from tr_actor  P \n" +
"\n" +
" INNER JOIN tr_exp_actor S ON P.id_actor =S.actores_id\n" +
"   INNER JOIN tr_expediente      E on E.id_expediente = S.id_expediente  ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
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
                     fila.add(resul.getString(11)); // Añadir la primera columna
                    fila.add(resul.getString(12)); // Añadir la segunda columna
                    fila.add(resul.getString(13)); // Añadir la tercera columna
                    fila.add(resul.getString(14)); // Añadir la cuarta columna
                    fila.add(resul.getString(15)); // Añadir la quinta columna
                    fila.add(resul.getString(16)); // Añadir la sexta columna
                    fila.add(resul.getString(17)); // Añadir la séptima columna
                    fila.add(resul.getString(18)); // Añadir la octava columna
                    fila.add(resul.getString(19)); // Añadir la novena columna
                    fila.add(resul.getString(20)); // Añadir la décima columna
                    fila.add(resul.getString(21)); // Añadir la décima columna
                    fila.add(resul.getString(22)); // Añadir la segunda columna
                    fila.add(resul.getString(23)); // Añadir la tercera columna
                    fila.add(resul.getString(24)); // Añadir la cuarta columna
                    fila.add(resul.getString(25)); // Añadir la quinta columna
                    fila.add(resul.getString(26)); // Añadir la sexta columna
                    fila.add(resul.getString(27)); // Añadir la séptima columna
                    fila.add(resul.getString(28)); // Añadir la octava columna
                    fila.add(resul.getString(29)); // Añadir la novena columna
                    fila.add(resul.getString(30)); // Añadir la décima columna
                    fila.add(resul.getString(31)); // Añadir la primera columna
                    fila.add(resul.getString(32)); // Añadir la primera columna
                    fila.add(resul.getString(33)); // Añadir la primera columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_ACTOR " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    
      public ArrayList<ArrayList<String>> DBO_Tr_General(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql =  
"      \n" +
"select \n" +
"ID_GENERAL ,\n" +
"ID_ORGANOJ , \n" +
"JUEZ_INDIVIDUA_H , \n" +
"JUEZ_INDIVIDUAL_M ,\n" +
"JUEZ_COLECTIVO_H ,\n" +
"JUEZ_COLECTIVO_M , \n" +
"JUEZ_MIXTO_H ,\n" +
"JUEZ_MIXTOS_M ,\n" +
"SUBTOTAL_JUEZ_H ,\n" +
"SUBTOTAL_JUEZ_M ,\n" +
"TOTAL_JUECES ,\n" +
"TOTAL_ORDINARIO ,\n" +
"TOTAL_INDIVIDUAL ,\n" +
"TOTAL_COLECTIVO ,\n" +
"TOTAL_HUELGA ,\n" +
"TOTAL_COL_NAT_ECON , \n" +
"TOTAL_PARAPROCESAL , \n" +
"TOTAL_TERCERIAS ,\n" +
"TOTAL_PREF_CRED ,\n" +
"TOTAL_EJECUCION ,\n" +
" '"+  periodo  + "' PERIODO\n" +
"\n" +
"from tr_general   ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
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
                     fila.add(resul.getString(11)); // Añadir la primera columna
                    fila.add(resul.getString(12)); // Añadir la segunda columna
                    fila.add(resul.getString(13)); // Añadir la tercera columna
                    fila.add(resul.getString(14)); // Añadir la cuarta columna
                    fila.add(resul.getString(15)); // Añadir la quinta columna
                    fila.add(resul.getString(16)); // Añadir la sexta columna
                    fila.add(resul.getString(17)); // Añadir la séptima columna
                    fila.add(resul.getString(18)); // Añadir la octava columna
                    fila.add(resul.getString(19)); // Añadir la novena columna
                    fila.add(resul.getString(20)); // Añadir la décima columna
                    fila.add(resul.getString(21)); // Añadir la décima columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_GENERAL " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
      public ArrayList<ArrayList<String>> DBO_Tr_Audiencia(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql =  
        " select \n" +
        "   \n" +
        "   ID_AUDIENCIA,\n" +
        "E.ID_ORGANOJ,\n" +
        " TO_CHAR(TO_DATE(FECHA_CELEBRACION, 'YYYY-MM-DD'), 'DD/MM/YYYY') FECHA_CELEBRACION ,\n" +
        "ID_TIPO_AUDIENCIA,\n" +
        "INICIO,\n" +
        "CONCLUSION,\n" +
        "p.ID_EXPEDIENTE,\n" +
        "p.COMENTARIOS,\n" +
        "'" + periodo  + "' as PERIODO,\n" +
        "null ID_UNIQUE\n" +
        "   \n" +
        "   from tr_audiencia P \n" +
        "   \n" +
        "    INNER JOIN tr_expediente      E on E.id_expediente = P.id_expediente ;\n" +
        "\n" +
        "     ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
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
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_AUDIENCIA " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
     public ArrayList<ArrayList<String>> DBO_Tr_Demandado(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql =  
"      select \n" +
"\n" +
"    p.id_demandado ,\n" +
"    e.ID_ORGANOJ ,\n" +
"    id_tipo_demandado ,\n" +
"    id_defensa ,\n" +
"    nombre_sindicato ,\n" +
"    reg_asoc_sindicato ,\n" +
"    id_tipo_sindicato ,\n" +
"    preg_sind_pert_org_obr ,\n" +
"    id_org_obr ,\n" +
"    cant_trab_invol_h ,\n" +
"    cant_trab_invol_m ,\n" +
"    cant_trab_invol_ni ,\n" +
"    trab_invol_tot ,\n" +
"    id_tipo_patron ,\n" +
"    rfc ,\n" +
"    razon_social ,\n" +
"    calle ,\n" +
"    num_exterior ,\n" +
"    num_interior ,\n" +
"    colonia ,\n" +
"    cp ,\n" +
"    p.id_ent_mpio ,\n" +
"    latitud ,\n" +
"    longitud ,\n" +
"    p.comentarios ,\n" +
"    '" + periodo  + "'  as periodo , null ID_UNIQUE  \n" +
"   \n" +
"   from tr_demandado P \n" +
"   INNER JOIN tr_exped_demandado S ON P.ID_DEMANDADO=S.ID_DEMANDADO\n" +
"   INNER JOIN tr_expediente      E on E.id_expediente = S.id_expediente\n" +
"   ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
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
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_DEMANDADO " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Expediente(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql =  
"   select \n" +
"   id_expediente ,\n" +
"    id_tipo_expediente ,\n" +
"    id_organoj ,\n" +
"    clave_expediente  ,\n" +
"    clave_cuaderno_incid ,\n" +
"    TO_CHAR(TO_DATE(fecha_present_incidente, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_present_incidente ,\n" +
"     TO_CHAR(TO_DATE(fecha_apert_cuader_incid, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_apert_cuader_incid ,\n" +
"    id_tipo_incidente ,\n" +
"      TO_CHAR(TO_DATE(fecha_apertura_exped, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_apertura_exped ,\n" +
"    id_tipo_asunto ,\n" +
"    id_nat_conflicto ,\n" +
"    preg_trab_contr_escri ,\n" +
"    id_tipo_contrato ,\n" +
"    rama_involuc ,\n" +
"    id_sector_sbtor ,\n" +
"    TO_CHAR(TO_DATE(fecha_pres_ejecu_sent, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_pres_ejecu_sent ,\n" +
"    id_ent_mpio ,\n" +
"    preg_outsourcing ,\n" +
"    preg_apl_cir_vin_mot_conf ,\n" +
"    preg_prestacion ,\n" +
"    preg_fecha_celebr_audiencia ,\n" +
"    TO_CHAR(TO_DATE(fecha_audiencia, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_audiencia ,\n" +
"    motivo_conf_colectivo ,\n" +
"    preg_incompetencia ,\n" +
"    id_tipo_incompetencia ,\n" +
"    TO_CHAR(TO_DATE(fecha_pliego_peticion, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_pliego_peticion ,\n" +
"    TO_CHAR(TO_DATE(fecha_present_demanda, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_present_demanda ,\n" +
"    TO_CHAR(TO_DATE(fecha_present_promo, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_present_promo ,\n" +
"    TO_CHAR(TO_DATE(fecha_admision_promo, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_admision_promo  ,\n" +
"    id_promovente ,\n" +
"    preg_const_conciliac ,\n" +
"    clave_const_conciliac ,\n" +
"    preg_asunto_vinc_concil_p ,\n" +
"    preg_formulo_demanda ,\n" +
"    preg_desahogo_demanda ,\n" +
"    id_estatus_demanda ,\n" +
"    id_causa_imp_adm_demanda ,\n" +
"    TO_CHAR(TO_DATE(fecha_adm_demanda, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_adm_demanda ,\n" +
"    cant_actores ,\n" +
"    cant_demandados ,\n" +
"    preg_huelga_emplazam ,\n" +
"     TO_CHAR(TO_DATE(fecha_huelga_emplazam, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_huelga_emplazam ,\n" +
"    preg_prehuelga ,\n" +
"    preg_audiencia_concil ,\n" +
"    TO_CHAR(TO_DATE(fecha_audiencia_concil, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_audiencia_concil  ,\n" +
"    preg_huelga_estalla ,\n" +
"    id_huelga_licitud ,\n" +
"    id_huelga_existencia ,\n" +
"    preg_auto_depuracion_tram ,\n" +
"    TO_CHAR(TO_DATE(fecha_auto_depuracion, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_auto_depuracion ,\n" +
"    preg_aud_prelim_celebr ,\n" +
"     TO_CHAR(TO_DATE(fecha_audiencia_prelim, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_audiencia_prelim ,\n" +
"    preg_celebra_aud_juicio ,\n" +
"    TO_CHAR(TO_DATE(fecha_aud_juicio, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_aud_juicio  ,\n" +
"    preg_audiencia_col_nat_eco ,\n" +
"     TO_CHAR(TO_DATE(fecha_audiencia_col_nat_eco, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_audiencia_col_nat_eco  ,\n" +
"    id_estatus_exped ,\n" +
"    TO_CHAR(TO_DATE(fecha_concluy_exped, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_concluy_exped ,\n" +
"    TO_CHAR(TO_DATE(fecha_ult_act_proc, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_ult_act_proc ,\n" +
"    id_fase_sol_exped ,\n" +
"    TO_CHAR(TO_DATE(fecha_concl_ejecu, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_concl_ejecu ,\n" +
"    id_fase_concl_ejec ,\n" +
"    id_forma_solucion ,\n" +
"     TO_CHAR(TO_DATE(fecha_dicto_solucion, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_dicto_solucion ,\n" +
"    porcent_solicitado ,\n" +
"    porcent_otorgado ,\n" +
"    id_tipo_sentencia ,\n" +
"    TO_CHAR(TO_DATE(fecha_huelga_estalla, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_huelga_estalla ,\n" +
"     TO_CHAR(TO_DATE(fecha_huelga_levantam, 'YYYY-MM-DD'), 'DD/MM/YYYY') fecha_huelga_levantam ," +
"    huelga_dias ,\n" +
"    monto_solucion ,\n" +
"    porcent_salarios_caidos ,\n" +
"    comentarios ,\n" +
"   '" + periodo  + "' as  periodo  \n" +
"   from tr_expediente ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
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
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(34)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(35)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(36)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(37)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(38)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(39)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(40)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(41)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(42)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(43)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(44)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(45)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(46)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(47)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(48)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(49)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(50)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(51)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(52)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(53)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(54)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(55)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(56)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(57)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(58)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(59)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(60)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(61)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(62)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(63)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(64)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(65)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(66)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(67)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(68)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(69)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(70)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(71)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(72)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(73)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(74)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_expediente " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
     public ArrayList<ArrayList<String>> DBO_Tr_OrganoJ(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " select \n" +
"id_organoj ,\n" +
"    nombre_organoj ,\n" +
"    sede_organoj ,\n" +
"    id_ent_mpio ,\n" +
"    colonia ,\n" +
"    latitud ,\n" +
"    longitud ,\n" +
"    id_circunscripcion ,\n" +
"    id_jurisdiccion ,\n" +
"    hr_atencion ,\n" +
"   '" + periodo +"' as  periodo  from tr_organoj  ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la quinta columna
                    fila.add(resul.getString(7)); // Añadir la quinta columna
                    fila.add(resul.getString(8)); // Añadir la quinta columna
                    fila.add(resul.getString(9)); // Añadir la quinta columna
                    fila.add(resul.getString(10)); // Añadir la quinta columna
                    fila.add(resul.getString(11)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla Tr_OrganoJ " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
     public ArrayList<ArrayList<String>> DBO_Tr_Exp_Demandado(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_demandado ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXPED_demandado P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXPED_demandado " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Motivo_Solic(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_motivo_sol_promo ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_motivo_solic P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_motivo_solic " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Efecto_Sentencia(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_efecto_sentencia ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM tr_EXP_EFECTOS_SENTENCIA P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_EXP_EFECTOS_SENTENCIA " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Violacion(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_tipo_viol_dh ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM tr_exp_violacion P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_exp_violacion " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Terminacion(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_tipo_terminacion ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM tr_exp_terminacion P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_exp_terminacion " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Suspension(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_tipo_suspension ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM tr_exp_suspension P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_exp_suspension " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return arrayList;
    }
    
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Motivo_Huelga(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_huelga_motivo ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_motivo_huelga P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_motivo_huelga " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Prestacion(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_prestacion ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_PRESTACION P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_PRESTACION " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
        
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Concepto_Reclam(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_concepto_reclam ,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_CONCEPTO_RECLAM P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_CONCEPTO_RECLAM " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Circunst(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.id_circuns_mot_conf,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_CIRCUNST P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_CIRCUNST " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Motivo_Conflicto(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.ID_MOTIVO_CONFLICTO,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM tr_exp_motivo_conf P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla tr_exp_motivo_conf " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
      
    public ArrayList<ArrayList<String>> DBO_Tr_Exp_Actor(String usuario , String contrasenia  , String periodo,String bd  ) throws SQLException {
       Statement stmt =  conexion.conectar(usuario, contrasenia,bd).createStatement();
       arrayList = new ArrayList<>();
        String sql = " SELECT P.ACTORES_ID,S.ID_ORGANOJ,P.ID_EXPEDIENTE, '" + periodo +"' PERIODO , NULL ID_UNIQUE\n" +
                    "FROM TR_EXP_ACTOR P INNER JOIN TR_EXPEDIENTE S ON P.ID_EXPEDIENTE=S.ID_EXPEDIENTE ; ";
            try {
        StringBuilder consultaFiltro = new StringBuilder();
        consultaFiltro.append(sql.replace(";", ""));
       
        resul = stmt.executeQuery(consultaFiltro.toString());
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(QueryLaborales.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la tabla TR_EXP_ACTOR " + ex);
                throw ex;
            } 
            
            finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
        return arrayList;
    }
    
    
    
}
