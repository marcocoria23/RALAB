package Screen_laborales;

import Conexion.ConexionPostgreSQL;
import LeerQuery.QueryPostgreSQL;
import LeerQuery.QueryRalabDes;
import LeerQuery.beans.TMP_TR_ACTOR;
import LeerQuery.beans.TMP_TR_AUDIENCIA;
import LeerQuery.beans.TMP_TR_DEMANDADO;
import LeerQuery.beans.TMP_TR_EXPEDIENTES;
import LeerQuery.beans.TMP_TR_EXP_ACTOR;
import LeerQuery.beans.TMP_TR_EXP_CIRCUNST;
import LeerQuery.beans.TMP_TR_EXP_CONCEPTO_RECLAM;
import LeerQuery.beans.TMP_TR_EXP_DEMANDADO;
import LeerQuery.beans.TMP_TR_EXP_EFECTO_SENTENCIA;
import LeerQuery.beans.TMP_TR_EXP_MOTIVO_CONF;
import LeerQuery.beans.TMP_TR_EXP_MOTIVO_HUELGA;
import LeerQuery.beans.TMP_TR_EXP_MOTIVO_SOLIC;
import LeerQuery.beans.TMP_TR_EXP_PRESTACION;
import LeerQuery.beans.TMP_TR_EXP_SUSPENSION;
import LeerQuery.beans.TMP_TR_EXP_TERMINACION;
import LeerQuery.beans.TMP_TR_EXP_VIOLACION;
import LeerQuery.beans.TMP_TR_GENERAL;
import LeerQuery.beans.TMP_TR_ORGANOJ;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/*
 * @author ALEJANDRO.CASTILLO
 */
public class PConexionPostgreSQL extends javax.swing.JFrame {
    
    public static String clave_entidad="";//variables publicas
     
    public PConexionPostgreSQL() {
        initComponents();
        this.setLocationRelativeTo(null);//JFRAME LOCALIZACION AL CENTRO DE LA PANTALLA
        this.getContentPane().setBackground(Color.WHITE);//JFRAME COLOR POR DEFAULT BLANCO
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jComboBox3 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        PAgrupamiento = new javax.swing.JPanel();
        LEntidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Textoperiodo1 = new javax.swing.JTextField();
        ProcesarPostgresql = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contrasenia = new javax.swing.JPasswordField();
        EliminarBD = new javax.swing.JButton();
        ActualizarBD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        CBD = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Lable = new javax.swing.JLabel();

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setTitle("Procesar consultas");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PAgrupamiento.setBackground(new java.awt.Color(255, 255, 255));
        PAgrupamiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Conexion PostgreSQL"));

        LEntidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel4.setText("Periodo:");

        ProcesarPostgresql.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/insert to bd.png"))); // NOI18N
        ProcesarPostgresql.setText("Procesar oracle");
        ProcesarPostgresql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesarPostgresqlActionPerformed(evt);
            }
        });

        jLabel3.setText("Usuario:");

        usuario.setText("postgres");

        jLabel5.setText("Contraseña:");

        contrasenia.setText("admin");

        EliminarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/limpiar.png"))); // NOI18N
        EliminarBD.setText("Eliminar tablas BD PostgreSQL");
        EliminarBD.setName(""); // NOI18N
        EliminarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBDActionPerformed(evt);
            }
        });

        ActualizarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/INSERTAR BD.png"))); // NOI18N
        ActualizarBD.setText("Procesar Script PostgreSQL");
        ActualizarBD.setName(""); // NOI18N
        ActualizarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarBDActionPerformed(evt);
            }
        });

        jLabel6.setText("Base Datos:");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PAgrupamientoLayout = new javax.swing.GroupLayout(PAgrupamiento);
        PAgrupamiento.setLayout(PAgrupamientoLayout);
        PAgrupamientoLayout.setHorizontalGroup(
            PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(Textoperiodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                .addComponent(LEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EliminarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usuario)
                                    .addComponent(contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(ProcesarPostgresql))
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBD, 0, 150, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ActualizarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PAgrupamientoLayout.setVerticalGroup(
            PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Textoperiodo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAgrupamientoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(LEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminarBD)
                    .addComponent(ActualizarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ProcesarPostgresql)
                .addGap(38, 38, 38))
        );

        ActualizarBD.getAccessibleContext().setAccessibleName("Procesar Script Postgresql");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/Logo Laborales.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PAgrupamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Lable, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Lable, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PAgrupamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(227, 227, 227))
        );

        PAgrupamiento.getAccessibleContext().setAccessibleName("Procesar consultas\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       PMenu men = new PMenu();
       men.setVisible(true);
      
        
    }//GEN-LAST:event_formWindowClosing
  
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here
       
        
    }//GEN-LAST:event_formWindowOpened

    
    
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       PConPer per= new PConPer();
       per.setVisible(false); 
    }//GEN-LAST:event_formWindowClosed

    
    private void ProcesarPostgresqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesarPostgresqlActionPerformed
       QueryPostgreSQL queryPostgreSQL   = new QueryPostgreSQL();
       TMP_TR_ORGANOJ tmp_tr_organoj = new TMP_TR_ORGANOJ();
       TMP_TR_EXPEDIENTES tmp_tr_expedientes = new TMP_TR_EXPEDIENTES();
       TMP_TR_DEMANDADO tmp_tr_demandado = new TMP_TR_DEMANDADO();
       TMP_TR_AUDIENCIA tmp_tr_audiencia = new TMP_TR_AUDIENCIA();
       TMP_TR_GENERAL tmp_tr_general = new TMP_TR_GENERAL();
       TMP_TR_ACTOR   tmp_tr_actor = new TMP_TR_ACTOR();
        TMP_TR_EXP_MOTIVO_CONF   tmp_tr_exp_motivo_conf = new TMP_TR_EXP_MOTIVO_CONF();
        TMP_TR_EXP_CIRCUNST   tmp_tr_exp_circunts = new TMP_TR_EXP_CIRCUNST();
        TMP_TR_EXP_CONCEPTO_RECLAM   tmp_tr_exp_concepto_reclam = new TMP_TR_EXP_CONCEPTO_RECLAM();
        TMP_TR_EXP_PRESTACION   tmp_tr_exp_prestacion = new TMP_TR_EXP_PRESTACION();
        TMP_TR_EXP_MOTIVO_HUELGA   tmp_tr_exp_motivo_huelga = new TMP_TR_EXP_MOTIVO_HUELGA();
        TMP_TR_EXP_SUSPENSION   tmp_tr_exp_suspension = new TMP_TR_EXP_SUSPENSION();
        TMP_TR_EXP_TERMINACION   tmp_tr_exp_terminacion = new TMP_TR_EXP_TERMINACION();
        TMP_TR_EXP_VIOLACION   tmp_tr_exp_violacion = new TMP_TR_EXP_VIOLACION();
        TMP_TR_EXP_EFECTO_SENTENCIA   tmp_tr_exp_efecto_sentencia = new TMP_TR_EXP_EFECTO_SENTENCIA();
        TMP_TR_EXP_MOTIVO_SOLIC   tmp_tr_exp_motivo_solic = new TMP_TR_EXP_MOTIVO_SOLIC();
        TMP_TR_EXP_ACTOR    tmp_tr_exp_actor  = new TMP_TR_EXP_ACTOR();
        TMP_TR_EXP_DEMANDADO   tmp_tr_exp_demandado = new TMP_TR_EXP_DEMANDADO();       
        String periodo    = Textoperiodo1.getText();
        procesando procesar= new procesando();
        if(!periodo.equals("")){
                new Thread(() -> {
                    try{
                        if(!periodo.equals("")){
                           procesar.setVisible(true);
                           String clavOrgano = queryPostgreSQL.clavesOrgano(usuario.getText(), contrasenia.getText(),CBD.getSelectedItem().toString());
                           QueryRalabDes queryRalabDes  = new  QueryRalabDes();
                           queryRalabDes.eliminarRegistrosPostgres(clavOrgano, periodo);
                            //1.- TR_ORGANOJ
                            ArrayList<ArrayList<String>> listaTrOrganoJ  = queryPostgreSQL.DBO_Tr_OrganoJ(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrOrganoJ.isEmpty())
                                tmp_tr_organoj.TMP_TR_ORGANOJ(listaTrOrganoJ);
                            //-----  2.-  TR_EXPEDIENTE
                            ArrayList<ArrayList<String>> listaTrExpediente   = queryPostgreSQL.DBO_Tr_Expediente(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpediente.isEmpty())
                               tmp_tr_expedientes.TMP_TR_EXPEDIENTES(listaTrExpediente);
                            // 3.- TR_DEMANDADO
                            ArrayList<ArrayList<String>> listaTrDemandado   = queryPostgreSQL.DBO_Tr_Demandado(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrDemandado.isEmpty())
                               tmp_tr_demandado.TMP_TR_DEMANDADO(listaTrDemandado);
                            // 4- TR_AUDIENCIA
                            ArrayList<ArrayList<String>> listaTrAudiencia   = queryPostgreSQL.DBO_Tr_Audiencia(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrAudiencia.isEmpty())
                               tmp_tr_audiencia.TMP_TR_AUDIENCIA(listaTrAudiencia);
                            // 5.-TR_GENERAL
                             ArrayList<ArrayList<String>> listaTrGeneral    = queryPostgreSQL.DBO_Tr_General(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrGeneral.isEmpty())
                               tmp_tr_general.TMP_TR_GENERAL(listaTrGeneral);
                            //6- TR_ACTOR
                            ArrayList<ArrayList<String>> listaTrActor    = queryPostgreSQL.DBO_Tr_Actor(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                             if(!listaTrActor.isEmpty())
                               tmp_tr_actor.TMP_TR_ACTOR(listaTrActor);
                            //1.- Tr_Exp_Motivo_Conf  
                            ArrayList<ArrayList<String>> listaTrExpMotivoConf  = queryPostgreSQL.DBO_Tr_Exp_Motivo_Conflicto(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                             if(!listaTrExpMotivoConf.isEmpty())
                               tmp_tr_exp_motivo_conf.TMP_TR_EXP_MOTIVO_CONF(listaTrExpMotivoConf);
                            //2.- TR_EXP_CIRCUNST
                            ArrayList<ArrayList<String>> listaTrExpCircunst = queryPostgreSQL.DBO_Tr_Exp_Circunst(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                             if(!listaTrExpCircunst.isEmpty())
                               tmp_tr_exp_circunts.TMP_TR_EXP_CIRCUNST(listaTrExpCircunst);
                            //3.- TR_EXP_CONCEPTO_RECLAM
                            ArrayList<ArrayList<String>> listaTrExpConceptoReclam = queryPostgreSQL.DBO_Tr_Exp_Concepto_Reclam(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpConceptoReclam.isEmpty())
                             tmp_tr_exp_concepto_reclam.TMP_TR_EXP_CONCEPTO_RECLAM(listaTrExpConceptoReclam);
                            //4.- TR_EXP_PRESTACION
                            ArrayList<ArrayList<String>> listaTrExpPrestacion = queryPostgreSQL.DBO_Tr_Exp_Prestacion(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpPrestacion.isEmpty())
                             tmp_tr_exp_prestacion.TMP_TR_EXP_PRESTACION(listaTrExpPrestacion);
                              //5.- TR_EXP_MOTIVO_HUELGA
                            ArrayList<ArrayList<String>> listaTrExpMotivoHuelga = queryPostgreSQL.DBO_Tr_Exp_Motivo_Huelga(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                         if(!listaTrExpMotivoHuelga.isEmpty())
                             tmp_tr_exp_motivo_huelga.TMP_TR_EXP_MOTIVO_HUELGA(listaTrExpMotivoHuelga);
                            //6.- TR_EXP_SUSPENSION 
                             ArrayList<ArrayList<String>> listaTrExpSuspension = queryPostgreSQL.DBO_Tr_Exp_Suspension(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                           if(!listaTrExpSuspension.isEmpty())
                             tmp_tr_exp_suspension.TMP_TR_EXP_SUSPENSION(listaTrExpSuspension);
                            // 7.- TR_EXP_TERMINACION
                             ArrayList<ArrayList<String>> listaTrExpTerminacion = queryPostgreSQL.DBO_Tr_Exp_Terminacion(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                             if(!listaTrExpTerminacion.isEmpty())
                             tmp_tr_exp_terminacion.TMP_TR_EXP_TERMINACION(listaTrExpTerminacion);
                          // 8.- TR_EXP_VIOLACION -  
                             ArrayList<ArrayList<String>> listaTrExpViolacion = queryPostgreSQL.DBO_Tr_Exp_Violacion(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpViolacion.isEmpty())
                             tmp_tr_exp_violacion.TMP_TR_EXP_VIOLACION(listaTrExpViolacion);
                            //9.- TR_EXP_EFECTO_SENTENCIA - falta
                            ArrayList<ArrayList<String>> listaTrEfectoSentencia = queryPostgreSQL.DBO_Tr_Exp_Efecto_Sentencia(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                          if(!listaTrEfectoSentencia.isEmpty())
                             tmp_tr_exp_efecto_sentencia.TMP_TR_EXP_EFECTO_SENTENCIA(listaTrEfectoSentencia);
                            //10--TR_EXP_MOTIVO_SOLIC
                               ArrayList<ArrayList<String>> listaTrExpMotivoSolic = queryPostgreSQL.DBO_Tr_Exp_Motivo_Solic(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpMotivoSolic.isEmpty())
                             tmp_tr_exp_motivo_solic.TMP_TR_EXP_MOTIVO_SOLIC(listaTrExpMotivoSolic);
                               //11.- Tr_Exp_Actor
                            ArrayList<ArrayList<String>> listaTrExpActor  = queryPostgreSQL.DBO_Tr_Exp_Actor(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                            if(!listaTrExpActor.isEmpty())
                             tmp_tr_exp_actor.TMP_TR_EXP_ACTOR(listaTrExpActor);  
                             //12.- TR_EXP_DEMANDADO
                             ArrayList<ArrayList<String>> listaTrExpDemandado  = queryPostgreSQL.DBO_Tr_Exp_Demandado(usuario.getText(), contrasenia.getText(), periodo,CBD.getSelectedItem().toString());
                             if(!listaTrExpDemandado.isEmpty())
                             tmp_tr_exp_demandado.TMP_TR_EXP_DEMANDADO(listaTrExpDemandado);  
                             int registrosObservaciones =  queryRalabDes.consultarRalabObservaciones("",  clavOrgano, periodo);
                              if(registrosObservaciones==0){ // verificar si existen errores en la tabla de observaciones 
                                  JOptionPane.showMessageDialog(null, "Se finalizo el proceso base datos PostgreSQL a Oracle "  , "Información", JOptionPane.INFORMATION_MESSAGE);
                              }
                              else
                               JOptionPane.showMessageDialog(null, "Existen errores, se debe verificar en la tabla de observaciones"  , "Error", JOptionPane.ERROR_MESSAGE); 
                            procesar.setVisible(false);  
                        }
                    } // try 
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                        procesar.setVisible(false);
                    } // catch 
                }).start();
            }
        else{
            JOptionPane.showMessageDialog(null, "Para procesar la información, se debe ingresar la entidad y el periodo, favor de verificar ", "Mensaje", JOptionPane.ERROR_MESSAGE);
            procesar.setVisible(false);
        }
    }//GEN-LAST:event_ProcesarPostgresqlActionPerformed

    private void EliminarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBDActionPerformed
       QueryPostgreSQL queryPostgreSql = new QueryPostgreSQL();
        procesando procesar= new procesando();
        new Thread(() -> {
                    try{
                        procesar.setVisible(true);
                        queryPostgreSql.eliminarTablas(usuario.getText(), contrasenia.getText(),CBD.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null, "Se eliminaron las tablas en la base de datos PostgreSQL local"  , "Información", JOptionPane.INFORMATION_MESSAGE);
                        procesar.setVisible(false);
                    } // try 
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                        procesar.setVisible(false);
                    } // catch 
                }).start();
    }//GEN-LAST:event_EliminarBDActionPerformed

    private void ActualizarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarBDActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo SQL");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        ConexionPostgreSQL conexion  = new ConexionPostgreSQL(); 
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos SQL", "sql"));
        procesando procesar = new procesando();
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String scriptFile  = fileChooser.getSelectedFile().getAbsolutePath();
           try  {
                procesar.setVisible(true);
                StringBuilder script = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader(scriptFile)); 
                    String line;
                    while ((line = br.readLine()) != null) {
                        script.append(line).append("\n");
                    }
                    Statement stmt =  conexion.conectar(usuario.getText(), contrasenia.getText()).createStatement();
                    stmt.execute(script.toString());
                    JOptionPane.showMessageDialog(null, "Se generaron las tablas en la base de datos PostgreSQL local"  , "Información", JOptionPane.INFORMATION_MESSAGE);
                    procesar.setVisible(false);
            } catch (Exception e) {
                System.err.println("Error de conexión a la base de datos: " + e.getMessage());
               JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos:"  , "Información", JOptionPane.ERROR_MESSAGE);
               procesar.setVisible(false);
            }
             finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ActualizarBDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    QueryPostgreSQL queryPostgreSQL   = new QueryPostgreSQL();
       ArrayList<ArrayList<String>> ArrayBD;
        ArrayBD = new ArrayList<>();
        try {   
            ArrayBD=queryPostgreSQL.NombreBDPostgres(usuario.getText(),contrasenia.getText());
        } catch (SQLException ex) {
            Logger.getLogger(PConexionPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        CBD.removeAllItems();
         for (int i=0;i<ArrayBD.size();i++){
          String[] datos = ArrayBD.get(i).toArray(new String[0]);
         String Organo = Arrays.toString(datos).replace("[", "").replace("]", "");
          CBD.addItem(Organo.replace("[","").replace("]",""));
         }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PConexionPostgreSQL().setVisible(true);
            }
        });
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarBD;
    private javax.swing.JComboBox<String> CBD;
    private javax.swing.JButton EliminarBD;
    private javax.swing.JLabel LEntidad;
    public static javax.swing.JLabel Lable;
    public javax.swing.JPanel PAgrupamiento;
    private javax.swing.JButton ProcesarPostgresql;
    public javax.swing.JTextField Textoperiodo1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPasswordField contrasenia;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
