package Screen_laborales;

import Conexion.OracleConexion;
import java.util.ArrayList;
import LeerQuery.QueryLaborales;
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
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/* @author ALEJANDRO.CASTILLO */
public class PValidacionProcesar extends javax.swing.JFrame {

   public static String clave_entidad="", periodo = "", clave_organo;//variables publicas
   private  boolean generarArchivo = false;   

    public PValidacionProcesar() {
        initComponents();
        this.setLocationRelativeTo(null);//JFRAME LOCALIZACION AL CENTRO DE LA PANTALLA
        this.getContentPane().setBackground(Color.WHITE);//JFRAME COLOR POR DEFAULT BLANCO
        PAgrupamiento.setVisible(true);//PANEL AGRUPAMIENTO VISIBLE = FALSE
        Jentidad.setVisible(false);
        Centidad.setVisible(false);
        Jorgano.setVisible(false);
        CorganoJur.setVisible(false);
        LEntidad.setVisible(false);
        jButton1.setVisible(false);
        ClaveOrgano.setVisible(false);
        EtiquetaOrg.setVisible(false);
        jLabel4.setVisible(false);
        Textoperiodo1.setVisible(false);
        jButton2.setVisible(false);
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
        Rclave_organo = new javax.swing.JRadioButton();
        Rclave_entidad = new javax.swing.JRadioButton();
        Centidad = new javax.swing.JComboBox();
        Jentidad = new javax.swing.JLabel();
        Jorgano = new javax.swing.JLabel();
        CorganoJur = new javax.swing.JComboBox();
        LEntidad = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        EtiquetaOrg = new javax.swing.JLabel();
        ClaveOrgano = new javax.swing.JTextField();
        Rclave_organo1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Textoperiodo1 = new javax.swing.JTextField();
        seleccionar = new javax.swing.JCheckBox();
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PAgrupamiento.setBackground(new java.awt.Color(255, 255, 255));
        PAgrupamiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Procesar consultas"));

        Rclave_organo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rclave_organo);
        Rclave_organo.setText("Clave Organo");
        Rclave_organo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rclave_organoActionPerformed(evt);
            }
        });

        Rclave_entidad.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rclave_entidad);
        Rclave_entidad.setText("Clave Entidad");
        Rclave_entidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rclave_entidadActionPerformed(evt);
            }
        });

        Centidad.setName(""); // NOI18N
        Centidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CentidadItemStateChanged(evt);
            }
        });
        Centidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CentidadActionPerformed(evt);
            }
        });

        Jentidad.setText("Entidad:");

        Jorgano.setText("Organo Jurisdiccional:");

        CorganoJur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CorganoJurItemStateChanged(evt);
            }
        });
        CorganoJur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorganoJurActionPerformed(evt);
            }
        });

        LEntidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/Insertar.png"))); // NOI18N
        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        EtiquetaOrg.setText("Capturar la clave de organo:");

        Rclave_organo1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rclave_organo1);
        Rclave_organo1.setText("Capturar las claves de organo");
        Rclave_organo1.setEnabled(false);
        Rclave_organo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rclave_organo1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/consultar.png"))); // NOI18N
        jButton2.setToolTipText("Seleccione para despliegue de periodos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Periodo:");

        Textoperiodo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Textoperiodo1MousePressed(evt);
            }
        });
        Textoperiodo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Textoperiodo1KeyPressed(evt);
            }
        });

        seleccionar.setLabel("Generar el archivo SQL");

        javax.swing.GroupLayout PAgrupamientoLayout = new javax.swing.GroupLayout(PAgrupamiento);
        PAgrupamiento.setLayout(PAgrupamientoLayout);
        PAgrupamientoLayout.setHorizontalGroup(
            PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Jentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Rclave_entidad)
                                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(Rclave_organo)))
                                .addGap(18, 18, 18)
                                .addComponent(Rclave_organo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seleccionar))
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addComponent(Centidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(EtiquetaOrg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClaveOrgano, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGap(571, 571, 571)
                        .addComponent(LEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Textoperiodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(Jorgano)
                                .addGap(2, 2, 2)
                                .addComponent(CorganoJur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        PAgrupamientoLayout.setVerticalGroup(
            PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAgrupamientoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rclave_entidad)
                    .addComponent(Rclave_organo)
                    .addComponent(Rclave_organo1)
                    .addComponent(seleccionar))
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(LEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAgrupamientoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Centidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jentidad)
                            .addComponent(EtiquetaOrg)
                            .addComponent(ClaveOrgano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addGroup(PAgrupamientoLayout.createSequentialGroup()
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Textoperiodo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PAgrupamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jorgano)
                            .addComponent(CorganoJur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        seleccionar.getAccessibleContext().setAccessibleName("");

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
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PAgrupamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(221, 221, 221))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
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
      PMenu menu = new PMenu();
      menu.setVisible(true);
      
      
    }//GEN-LAST:event_formWindowClosing

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        QueryLaborales queryLaboral    = new QueryLaborales();
        TMP_TR_EXPEDIENTES tmp_tr_expedientes = new TMP_TR_EXPEDIENTES();
        TMP_TR_DEMANDADO tmp_tr_demandado = new TMP_TR_DEMANDADO();
        TMP_TR_AUDIENCIA tmp_tr_audiencia = new TMP_TR_AUDIENCIA();
        TMP_TR_ORGANOJ tmp_tr_organoj = new TMP_TR_ORGANOJ();
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
        procesando carga= new procesando();
        QueryRalabDes queryRalabDes  = new  QueryRalabDes();
        PConPerProcesar per = new PConPerProcesar();
        per.setVisible(false);
        generarArchivo =seleccionar.isSelected();
        if (Rclave_entidad.isSelected()){
           String cveEntidad = (String) Centidad.getSelectedItem();
           String periodo    = Textoperiodo1.getText(); 
            if(!cveEntidad.equals("") && !periodo.equals("")){
                   new Thread(() -> {
                   Valores();
                   try{
                       carga.setVisible(true);
                       File sqlVirgen = new File("src/sql/Base_virgen_2_27022025 1.sql");
                       File sqlVirgenTemporal  = new File("src/sql/Base_virgen_2_27022025 1_temporal.sql");
                       Files.copy(sqlVirgen.toPath(), sqlVirgenTemporal.toPath(), StandardCopyOption.REPLACE_EXISTING);
                       if(!cveEntidad.equals("")  && !periodo.equals("")){
                         queryRalabDes.eliminarRegistros(cveEntidad, "", periodo);
                         // ---- 1.- TR_ORGANOJ
                         ArrayList<ArrayList<String>> listaRegistrosOrganoJ  =  queryLaboral.DBO_Tr_OrganoJ(cveEntidad, periodo , "");
                         if(!listaRegistrosOrganoJ.isEmpty())
                         tmp_tr_organoj.TMP_TR_ORGANOJ(listaRegistrosOrganoJ);
                         //-----  2.-  TR_EXPEDIENTE
                         ArrayList<ArrayList<String>> listaRegistrosExpe  =  queryLaboral.DBO_Tr_Expedientes(cveEntidad, periodo , "");
                         if(!listaRegistrosExpe.isEmpty())
                         tmp_tr_expedientes.TMP_TR_EXPEDIENTES(listaRegistrosExpe );
                         //TR_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosDema  =  queryLaboral.DBO_Tr_Demandado(cveEntidad, periodo , "");
                         if(!listaRegistrosDema.isEmpty())
                         tmp_tr_demandado.TMP_TR_DEMANDADO(listaRegistrosDema); 
                         // TR_AUDIENCIA
                         ArrayList<ArrayList<String>> listaRegistrosAudiencia  =  queryLaboral.DBO_Tr_Audiencias(cveEntidad, periodo , "");
                         if(!listaRegistrosAudiencia.isEmpty())
                         tmp_tr_audiencia.TMP_TR_AUDIENCIA(listaRegistrosAudiencia);
                         //----TR_GENERAL
                         ArrayList<ArrayList<String>> listaRegistrosGeneral  =  queryLaboral.DBO_Tr_General(cveEntidad, periodo , "");
                         if(!listaRegistrosGeneral.isEmpty() )
                         tmp_tr_general.TMP_TR_GENERAL(listaRegistrosGeneral);
                         // ---TR_ACTOR 
                         ArrayList<ArrayList<String>> listaRegistrosActor  =  queryLaboral.DBO_Tr_Actor(cveEntidad, periodo , "");
                         if(!listaRegistrosActor.isEmpty())
                         tmp_tr_actor.TMP_TR_ACTOR(listaRegistrosActor);
                         // correr el proceso ENABLE 
                         // tabla Tr_Exp_Motivo_Conf
                         queryRalabDes.disable_tr_exp_pk_ralalb();
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoConf =  queryLaboral.DBO_Tr_exp_motivo_conf(cveEntidad, periodo , "");
                         if(!listaRegistrosExpMotivoConf.isEmpty())
                         tmp_tr_exp_motivo_conf.TMP_TR_EXP_MOTIVO_CONF(listaRegistrosExpMotivoConf);
                         //TR_EXP_CIRCUNST
                         ArrayList<ArrayList<String>> listaRegistrosExpCircunst =  queryLaboral.DBO_Tr_Exp_Circunst(cveEntidad, periodo , "");
                         if( !listaRegistrosExpCircunst.isEmpty() )
                         tmp_tr_exp_circunts.TMP_TR_EXP_CIRCUNST(listaRegistrosExpCircunst);
                         //TR_EXP_CONCEPTO_RECLAM
                         ArrayList<ArrayList<String>> listaRegistrosExpConceptoReclam =  queryLaboral.DBO_Tr_Exp_Concepto_Reclam(cveEntidad, periodo , "");
                         if( !listaRegistrosExpConceptoReclam.isEmpty())
                         tmp_tr_exp_concepto_reclam.TMP_TR_EXP_CONCEPTO_RECLAM(listaRegistrosExpConceptoReclam);
                         //TR_EXP_PRESTACION
                         ArrayList<ArrayList<String>> listaRegistrosExpPrestacion =  queryLaboral.DBO_Tr_Exp_Prestacion(cveEntidad, periodo , "");//--
                         if( ! listaRegistrosExpPrestacion.isEmpty())
                         tmp_tr_exp_prestacion.TMP_TR_EXP_PRESTACION(listaRegistrosExpPrestacion);
                        //TR_EXP_MOTIVO_HUELGA
                        ArrayList<ArrayList<String>> listaRegistrosExpMotivoHuelga =  queryLaboral.DBO_Tr_Exp_Motivo_Huelga(cveEntidad, periodo , "");
                        if( ! listaRegistrosExpMotivoHuelga.isEmpty() )
                        tmp_tr_exp_motivo_huelga.TMP_TR_EXP_MOTIVO_HUELGA(listaRegistrosExpMotivoHuelga);
                        //TR_EXP_SUSPENSION
                        ArrayList<ArrayList<String>> listaRegistrosExpSuspension =  queryLaboral.DBO_Tr_Exp_Suspension(cveEntidad, periodo , "");
                        if( ! listaRegistrosExpSuspension.isEmpty() )
                        tmp_tr_exp_suspension.TMP_TR_EXP_SUSPENSION(listaRegistrosExpSuspension);
                         //TR_EXP_TERMINACION 
                        ArrayList<ArrayList<String>> listaRegistrosExpTerminacion =  queryLaboral.DBO_Tr_Exp_Terminacion(cveEntidad, periodo , "");
                        if( !listaRegistrosExpTerminacion.isEmpty() )
                        tmp_tr_exp_terminacion.TMP_TR_EXP_TERMINACION(listaRegistrosExpTerminacion);
                         //TR_EXP_VIOLACION   
                        ArrayList<ArrayList<String>> listaRegistrosExpViolacion =  queryLaboral.DBO_Tr_Exp_Violacion(cveEntidad, periodo , "");
                        if( !listaRegistrosExpViolacion.isEmpty() )
                        tmp_tr_exp_violacion.TMP_TR_EXP_VIOLACION(listaRegistrosExpViolacion);
                        // TR_EXP_EFECTO_SENTENCIA
                        ArrayList<ArrayList<String>> listaRegistrosExpEfectoSentencia =  queryLaboral.DBO_Tr_Exp_Efecto_Sentencia(cveEntidad, periodo , "");
                        if( !listaRegistrosExpEfectoSentencia.isEmpty() )
                        tmp_tr_exp_efecto_sentencia.TMP_TR_EXP_EFECTO_SENTENCIA(listaRegistrosExpEfectoSentencia);
                        //--TR_EXP_MOTIVO_SOLIC
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoSolic =  queryLaboral.DBO_Tr_Exp_Motivo_Solic(cveEntidad, periodo , "");
                        if( !listaRegistrosExpMotivoSolic.isEmpty()  )
                         tmp_tr_exp_motivo_solic.TMP_TR_EXP_MOTIVO_SOLIC(listaRegistrosExpMotivoSolic);
                         //TR_EXP_ACTOR
                           ArrayList<ArrayList<String>> listaRegistrosExpActor =  queryLaboral.DBO_Tr_Exp_Actor(cveEntidad, periodo , "");
                         if( !listaRegistrosExpActor.isEmpty() )
                           tmp_tr_exp_actor.TMP_TR_EXP_ACTOR(listaRegistrosExpActor);
                          //TR_EXP_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosExpDemandado =  queryLaboral.DBO_Tr_Exp_Demandado(cveEntidad, periodo , "");
                         if( !listaRegistrosExpDemandado.isEmpty() )
                         tmp_tr_exp_demandado.TMP_TR_EXP_DEMANDADO(listaRegistrosExpDemandado);
                         queryRalabDes.merge_id_expediente(cveEntidad, "", periodo);
                         queryRalabDes.enable_tr_exp_pk_ralalb();   
                         int registrosObservaciones =  queryRalabDes.consultarRalabObservaciones(cveEntidad, "", periodo);
                          if(registrosObservaciones==0){
                            if(generarArchivo){ // entrar al generar el archivo    
                                    queryLaboral.DBO_Tr_OrganoJ_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Expedientes_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal ); 
                                    queryLaboral.DBO_Tr_Demandado_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Audiencias_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_General_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Actor_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal); 
                                    queryLaboral.DBO_Tr_Exp_Motivo_Conf_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal); 
                                    queryLaboral.DBO_Tr_Exp_Circunst_Exportar_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Concepto_Reclam_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Prestacion_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Motivo_Huelga_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Suspension_Insert(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Terminacion_Insert(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Violacion_Insert(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Efecto_Sentencia_Insert(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Motivo_Solic_Insert(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Actor_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    queryLaboral.DBO_Tr_Exp_Demandado_Inserts(cveEntidad, "" , periodo , sqlVirgenTemporal);
                                    JFileChooser fileChooser = new JFileChooser();
                                    fileChooser.setDialogTitle("Guardar archivo de texto");
                                    String nombreArchivo = "MIG-DEFAULT LIBERADO.sql";
                                    if (Rclave_entidad.isSelected()) {
                                        nombreArchivo = "MIG-" + Centidad.getSelectedItem().toString() + " LIBERADO.sql";

                                    } else if (Rclave_organo.isSelected()) {
                                        nombreArchivo = "MIG-" + CorganoJur.getSelectedItem().toString() + " LIBERADO.sql";

                                    } else if (Rclave_organo1.isSelected()) {
                                        nombreArchivo = "MIG-" + ClaveOrgano.getText() + " LIBERADO.sql";

                                    }
                                    fileChooser.setSelectedFile(new File(nombreArchivo));
                                    int seleccionUsuario = fileChooser.showSaveDialog(null);
                                    if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                                        File archivo = fileChooser.getSelectedFile();
                                        try {
                                            Files.copy(sqlVirgenTemporal.toPath(), archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                            JOptionPane.showMessageDialog(null, "Se guardó el archivo: " + archivo.getName(), "Información", JOptionPane.INFORMATION_MESSAGE);

                                        } catch (IOException e) {
                                            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                                            e.printStackTrace();
                                        }
                                        carga.setVisible(false);
                                    } 
                                   else {
                                     JOptionPane.showMessageDialog(null, "No se guardó ningún archivo.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                     carga.setVisible(false);
                                    }
                              }
                              if(!generarArchivo)
                                JOptionPane.showMessageDialog(null, "Se genero el proceso, sin el archivo sql", "Mensaje", JOptionPane.INFORMATION_MESSAGE);  
                                carga.setVisible(false);
                         }
                        else
                          JOptionPane.showMessageDialog(null, "Existen registros en la tabla de observaciones, favor de verificar ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);  
                         carga.setVisible(false);
                       } 
                       else 
                          JOptionPane.showMessageDialog(null, "Se debe capturar el periodo y la clave de entidad, favor de verificar ", "Mensaje", JOptionPane.ERROR_MESSAGE);  
                   }
                   catch(Exception ex){
                      JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                      carga.setVisible(false);

                   }
              }).start();
            } 
            else 
              JOptionPane.showMessageDialog(null, "Para procesar la información, se debe ingresar la entidad y el periodo, favor de verificar ", "Mensaje", JOptionPane.ERROR_MESSAGE);  
             
         }
        //derechos de autor la webona
         if(   Rclave_organo.isSelected() ){
            String clavOrgano = (String)  CorganoJur.getSelectedItem();
            String periodo    = Textoperiodo1.getText(); 
            if(!clavOrgano.equals("") && !periodo.equals("")){
                   new Thread(() -> {
                   Valores();
                   try{
                       carga.setVisible(true);
                       File sqlVirgen = new File("src/sql/Base_virgen_2_27022025 1.sql");
                       File sqlVirgenTemporal  = new File("src/sql/Base_virgen_2_27022025 1_temporal.sql");
                       Files.copy(sqlVirgen.toPath(), sqlVirgenTemporal.toPath(), StandardCopyOption.REPLACE_EXISTING);
                       if(!clavOrgano.equals("")  && !periodo.equals("")){
                         queryRalabDes.eliminarRegistros("", clavOrgano , periodo);
                         // ---- 1.- TR_ORGANOJ
                         ArrayList<ArrayList<String>> listaRegistrosOrganoJ  =  queryLaboral.DBO_Tr_OrganoJ("", periodo , clavOrgano );
                         if(!listaRegistrosOrganoJ.isEmpty())
                         tmp_tr_organoj.TMP_TR_ORGANOJ(listaRegistrosOrganoJ);
                         //-----  2.-  TR_EXPEDIENTE
                         ArrayList<ArrayList<String>> listaRegistrosExpe  =  queryLaboral.DBO_Tr_Expedientes("", periodo , clavOrgano );
                         if(!listaRegistrosExpe.isEmpty())
                         tmp_tr_expedientes.TMP_TR_EXPEDIENTES(listaRegistrosExpe );
                         //TR_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosDema  =  queryLaboral.DBO_Tr_Demandado("", periodo , clavOrgano );
                         if(!listaRegistrosDema.isEmpty())
                         tmp_tr_demandado.TMP_TR_DEMANDADO(listaRegistrosDema); 
                         // TR_AUDIENCIA
                         ArrayList<ArrayList<String>> listaRegistrosAudiencia  =  queryLaboral.DBO_Tr_Audiencias("", periodo , clavOrgano );
                         if(!listaRegistrosAudiencia.isEmpty())
                         tmp_tr_audiencia.TMP_TR_AUDIENCIA(listaRegistrosAudiencia);
                         //----TR_GENERAL
                         ArrayList<ArrayList<String>> listaRegistrosGeneral  =  queryLaboral.DBO_Tr_General("", periodo , clavOrgano );
                         if(!listaRegistrosGeneral.isEmpty() )
                         tmp_tr_general.TMP_TR_GENERAL(listaRegistrosGeneral);
                         // ---TR_ACTOR 
                         ArrayList<ArrayList<String>> listaRegistrosActor  =  queryLaboral.DBO_Tr_Actor("", periodo , clavOrgano );
                         if(!listaRegistrosActor.isEmpty())
                         tmp_tr_actor.TMP_TR_ACTOR(listaRegistrosActor);
                         // tabla Tr_Exp_Motivo_Conf
                         queryRalabDes.disable_tr_exp_pk_ralalb();       // correr el proceso ENABLE 
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoConf =  queryLaboral.DBO_Tr_exp_motivo_conf("", periodo , clavOrgano );
                         if(!listaRegistrosExpMotivoConf.isEmpty())
                         tmp_tr_exp_motivo_conf.TMP_TR_EXP_MOTIVO_CONF(listaRegistrosExpMotivoConf);
                         //TR_EXP_CIRCUNST
                         ArrayList<ArrayList<String>> listaRegistrosExpCircunst =  queryLaboral.DBO_Tr_Exp_Circunst("", periodo , clavOrgano );
                         if( !listaRegistrosExpCircunst.isEmpty() )
                         tmp_tr_exp_circunts.TMP_TR_EXP_CIRCUNST(listaRegistrosExpCircunst);
                         //TR_EXP_CONCEPTO_RECLAM
                         ArrayList<ArrayList<String>> listaRegistrosExpConceptoReclam =  queryLaboral.DBO_Tr_Exp_Concepto_Reclam("", periodo , clavOrgano );
                         if( !listaRegistrosExpConceptoReclam.isEmpty())
                         tmp_tr_exp_concepto_reclam.TMP_TR_EXP_CONCEPTO_RECLAM(listaRegistrosExpConceptoReclam);
                         //TR_EXP_PRESTACION
                         ArrayList<ArrayList<String>> listaRegistrosExpPrestacion =  queryLaboral.DBO_Tr_Exp_Prestacion("", periodo , clavOrgano);
                         if( ! listaRegistrosExpPrestacion.isEmpty())
                         tmp_tr_exp_prestacion.TMP_TR_EXP_PRESTACION(listaRegistrosExpPrestacion);
                        //TR_EXP_MOTIVO_HUELGA
                        ArrayList<ArrayList<String>> listaRegistrosExpMotivoHuelga =  queryLaboral.DBO_Tr_Exp_Motivo_Huelga("", periodo , clavOrgano );
                        if( ! listaRegistrosExpMotivoHuelga.isEmpty() )
                        tmp_tr_exp_motivo_huelga.TMP_TR_EXP_MOTIVO_HUELGA(listaRegistrosExpMotivoHuelga);
                        //TR_EXP_SUSPENSION
                        ArrayList<ArrayList<String>> listaRegistrosExpSuspension =  queryLaboral.DBO_Tr_Exp_Suspension("", periodo , clavOrgano );
                        if( ! listaRegistrosExpSuspension.isEmpty() )
                        tmp_tr_exp_suspension.TMP_TR_EXP_SUSPENSION(listaRegistrosExpSuspension);
                         //TR_EXP_TERMINACION 
                        ArrayList<ArrayList<String>> listaRegistrosExpTerminacion =  queryLaboral.DBO_Tr_Exp_Terminacion("", periodo , clavOrgano );
                        if( !listaRegistrosExpTerminacion.isEmpty() )
                        tmp_tr_exp_terminacion.TMP_TR_EXP_TERMINACION(listaRegistrosExpTerminacion);
                         //TR_EXP_VIOLACION   
                        ArrayList<ArrayList<String>> listaRegistrosExpViolacion =  queryLaboral.DBO_Tr_Exp_Violacion("", periodo , clavOrgano);
                        if( !listaRegistrosExpViolacion.isEmpty() )
                        tmp_tr_exp_violacion.TMP_TR_EXP_VIOLACION(listaRegistrosExpViolacion);
                        // TR_EXP_EFECTO_SENTENCIA
                        ArrayList<ArrayList<String>> listaRegistrosExpEfectoSentencia =  queryLaboral.DBO_Tr_Exp_Efecto_Sentencia("", periodo , clavOrgano);
                        if( !listaRegistrosExpEfectoSentencia.isEmpty() )
                        tmp_tr_exp_efecto_sentencia.TMP_TR_EXP_EFECTO_SENTENCIA(listaRegistrosExpEfectoSentencia);
                        //--TR_EXP_MOTIVO_SOLIC
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoSolic =  queryLaboral.DBO_Tr_Exp_Motivo_Solic("", periodo , clavOrgano);
                        if( !listaRegistrosExpMotivoSolic.isEmpty()  )
                         tmp_tr_exp_motivo_solic.TMP_TR_EXP_MOTIVO_SOLIC(listaRegistrosExpMotivoSolic);
                         //TR_EXP_ACTOR
                           ArrayList<ArrayList<String>> listaRegistrosExpActor =  queryLaboral.DBO_Tr_Exp_Actor("", periodo , clavOrgano);
                         if( !listaRegistrosExpActor.isEmpty() )
                           tmp_tr_exp_actor.TMP_TR_EXP_ACTOR(listaRegistrosExpActor);
                          //TR_EXP_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosExpDemandado =  queryLaboral.DBO_Tr_Exp_Demandado("", periodo , clavOrgano);
                         if( !listaRegistrosExpDemandado.isEmpty() )
                         tmp_tr_exp_demandado.TMP_TR_EXP_DEMANDADO(listaRegistrosExpDemandado);
                            queryRalabDes.merge_id_expediente(null,  clavOrgano , periodo);
                         queryRalabDes.enable_tr_exp_pk_ralalb();   
                         int registrosObservaciones =  queryRalabDes.consultarRalabObservaciones("",  clavOrgano, periodo);
                         if(registrosObservaciones==0){
                           if(generarArchivo){ // entrar al generar el archivo sql       
                             queryLaboral.DBO_Tr_OrganoJ_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Expedientes_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal ); 
                             queryLaboral.DBO_Tr_Demandado_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Audiencias_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_General_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Actor_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal); 
                             queryLaboral.DBO_Tr_Exp_Motivo_Conf_Inserts("", clavOrgano , periodo , sqlVirgenTemporal); 
                             queryLaboral.DBO_Tr_Exp_Circunst_Exportar_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Concepto_Reclam_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Prestacion_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Motivo_Huelga_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Suspension_Insert("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Terminacion_Insert("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Violacion_Insert("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Efecto_Sentencia_Insert("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Motivo_Solic_Insert("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Actor_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Demandado_Inserts("", clavOrgano , periodo , sqlVirgenTemporal);
                             JFileChooser fileChooser = new JFileChooser();
                             fileChooser.setDialogTitle("Guardar archivo de texto");
                             String nombreArchivo = "MIG-DEFAULT LIBERADO.sql";
                             if (Rclave_entidad.isSelected()) {
                                 nombreArchivo = "MIG-" + Centidad.getSelectedItem().toString() + " LIBERADO.sql";
                             } else if (Rclave_organo.isSelected()) {
                                 nombreArchivo = "MIG-" + CorganoJur.getSelectedItem().toString() + " LIBERADO.sql";
                             } else if (Rclave_organo1.isSelected()) {
                                 nombreArchivo = "MIG-" + ClaveOrgano.getText() + " LIBERADO.sql";
                             }
                             fileChooser.setSelectedFile(new File(nombreArchivo));
                             int seleccionUsuario = fileChooser.showSaveDialog(null);
                             if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                                 File archivo = fileChooser.getSelectedFile();
                                 try {
                                     Files.copy(sqlVirgenTemporal.toPath(), archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                     JOptionPane.showMessageDialog(null, "Se guardó el archivo: " + archivo.getName(), "Información", JOptionPane.INFORMATION_MESSAGE);
                                 } 
                                 catch (IOException e) {
                                     JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                                     e.printStackTrace();
                                 }
                                 carga.setVisible(false);
                             } 
                             else {
                                 JOptionPane.showMessageDialog(null, "No se guardó ningún archivo.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                 carga.setVisible(false);
                             }
                           }
                           if(!generarArchivo)
                            JOptionPane.showMessageDialog(null, "Se genero el proceso, sin el archivo sql", "Mensaje", JOptionPane.INFORMATION_MESSAGE);  
                            carga.setVisible(false);
                         }
                         else
                           JOptionPane.showMessageDialog(null, "Existen registros en la tabla de observaciones, favor de verificar ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);  
                           carga.setVisible(false);
                         }
                   }
                   catch(Exception ex){
                      JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                      carga.setVisible(false);

                   }
              }).start();
            } 
            else 
              JOptionPane.showMessageDialog(null, "Para procesar la información, se debe ingresar la entidad y el periodo, favor de verificar ", "Mensaje", JOptionPane.ERROR_MESSAGE);  
        }
          if(   Rclave_organo1.isSelected() ){
               if(!ClaveOrgano.getText().equals("") ){
                String[] clavOrgano =   ClaveOrgano.getText().split(",");
                StringBuilder clavesOrgano = new StringBuilder ();       
                for(String clave : clavOrgano){
                clavesOrgano.append("'"+clave.trim()+"'");
                    try {
                        queryRalabDes.eliminarRegistros("", clave , "");
                    } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                       carga.setVisible(false);
                    }
                clavesOrgano.append(",");
                }
                clavesOrgano.deleteCharAt(clavesOrgano.toString().lastIndexOf(","));
                String filtro = clavesOrgano.toString();
                   new Thread(() -> {
                   Valores();
                   try{
                       carga.setVisible(true);
                       File sqlVirgen = new File("src/sql/Base_virgen_2_27022025 1.sql");
                       File sqlVirgenTemporal  = new File("src/sql/Base_virgen_2_27022025 1_temporal.sql");
                       Files.copy(sqlVirgen.toPath(), sqlVirgenTemporal.toPath(), StandardCopyOption.REPLACE_EXISTING);
                       if(!clavOrgano.equals("")){
                         // ---- 1.- TR_ORGANOJ
                         ArrayList<ArrayList<String>> listaRegistrosOrganoJ  =  queryLaboral.DBO_Tr_OrganoJ("", "" , filtro );
                         if(!listaRegistrosOrganoJ.isEmpty())
                         tmp_tr_organoj.TMP_TR_ORGANOJ(listaRegistrosOrganoJ);
                         //-----  2.-  TR_EXPEDIENTE
                         ArrayList<ArrayList<String>> listaRegistrosExpe  =  queryLaboral.DBO_Tr_Expedientes("", "" , filtro );
                         if(!listaRegistrosExpe.isEmpty())
                         tmp_tr_expedientes.TMP_TR_EXPEDIENTES(listaRegistrosExpe );
                         //TR_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosDema  =  queryLaboral.DBO_Tr_Demandado("", "" , filtro );
                         if(!listaRegistrosDema.isEmpty())
                         tmp_tr_demandado.TMP_TR_DEMANDADO(listaRegistrosDema); 
                         // TR_AUDIENCIA
                         ArrayList<ArrayList<String>> listaRegistrosAudiencia  =  queryLaboral.DBO_Tr_Audiencias("", "" , filtro );
                         if(!listaRegistrosAudiencia.isEmpty())
                         tmp_tr_audiencia.TMP_TR_AUDIENCIA(listaRegistrosAudiencia);
                         //----TR_GENERAL
                         ArrayList<ArrayList<String>> listaRegistrosGeneral  =  queryLaboral.DBO_Tr_General("", "" , filtro );
                         if(!listaRegistrosGeneral.isEmpty() )
                         tmp_tr_general.TMP_TR_GENERAL(listaRegistrosGeneral);
                         // ---TR_ACTOR 
                         ArrayList<ArrayList<String>> listaRegistrosActor  =  queryLaboral.DBO_Tr_Actor("", "" , filtro );
                         if(!listaRegistrosActor.isEmpty())
                         tmp_tr_actor.TMP_TR_ACTOR(listaRegistrosActor);
                         // tabla Tr_Exp_Motivo_Conf
                         queryRalabDes.disable_tr_exp_pk_ralalb();   // correr el proceso ENABLE 
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoConf =  queryLaboral.DBO_Tr_exp_motivo_conf("", "" , filtro );
                         if(!listaRegistrosExpMotivoConf.isEmpty())
                         tmp_tr_exp_motivo_conf.TMP_TR_EXP_MOTIVO_CONF(listaRegistrosExpMotivoConf);
                         //TR_EXP_CIRCUNST
                         ArrayList<ArrayList<String>> listaRegistrosExpCircunst =  queryLaboral.DBO_Tr_Exp_Circunst("", "" , filtro );
                         if( !listaRegistrosExpCircunst.isEmpty() )
                         tmp_tr_exp_circunts.TMP_TR_EXP_CIRCUNST(listaRegistrosExpCircunst);
                         //TR_EXP_CONCEPTO_RECLAM
                         ArrayList<ArrayList<String>> listaRegistrosExpConceptoReclam =  queryLaboral.DBO_Tr_Exp_Concepto_Reclam("",  "" , filtro );
                         if( !listaRegistrosExpConceptoReclam.isEmpty())
                         tmp_tr_exp_concepto_reclam.TMP_TR_EXP_CONCEPTO_RECLAM(listaRegistrosExpConceptoReclam);
                         //TR_EXP_PRESTACION
                         ArrayList<ArrayList<String>> listaRegistrosExpPrestacion =  queryLaboral.DBO_Tr_Exp_Prestacion("", "" , filtro);
                         if( ! listaRegistrosExpPrestacion.isEmpty())
                         tmp_tr_exp_prestacion.TMP_TR_EXP_PRESTACION(listaRegistrosExpPrestacion);
                        //TR_EXP_MOTIVO_HUELGA
                        ArrayList<ArrayList<String>> listaRegistrosExpMotivoHuelga =  queryLaboral.DBO_Tr_Exp_Motivo_Huelga("", "" , filtro );
                        if( ! listaRegistrosExpMotivoHuelga.isEmpty() )
                        tmp_tr_exp_motivo_huelga.TMP_TR_EXP_MOTIVO_HUELGA(listaRegistrosExpMotivoHuelga);
                        //TR_EXP_SUSPENSION
                        ArrayList<ArrayList<String>> listaRegistrosExpSuspension =  queryLaboral.DBO_Tr_Exp_Suspension("", "" , filtro );
                        if( ! listaRegistrosExpSuspension.isEmpty() )
                        tmp_tr_exp_suspension.TMP_TR_EXP_SUSPENSION(listaRegistrosExpSuspension);
                         //TR_EXP_TERMINACION 
                        ArrayList<ArrayList<String>> listaRegistrosExpTerminacion =  queryLaboral.DBO_Tr_Exp_Terminacion("", "" , filtro );
                        if( !listaRegistrosExpTerminacion.isEmpty() )
                        tmp_tr_exp_terminacion.TMP_TR_EXP_TERMINACION(listaRegistrosExpTerminacion);
                         //TR_EXP_VIOLACION   
                        ArrayList<ArrayList<String>> listaRegistrosExpViolacion =  queryLaboral.DBO_Tr_Exp_Violacion("", "" , filtro);
                        if( !listaRegistrosExpViolacion.isEmpty() )
                        tmp_tr_exp_violacion.TMP_TR_EXP_VIOLACION(listaRegistrosExpViolacion);
                        // TR_EXP_EFECTO_SENTENCIA
                        ArrayList<ArrayList<String>> listaRegistrosExpEfectoSentencia =  queryLaboral.DBO_Tr_Exp_Efecto_Sentencia("", "" , filtro);
                        if( !listaRegistrosExpEfectoSentencia.isEmpty() )
                        tmp_tr_exp_efecto_sentencia.TMP_TR_EXP_EFECTO_SENTENCIA(listaRegistrosExpEfectoSentencia);
                        //--TR_EXP_MOTIVO_SOLIC
                         ArrayList<ArrayList<String>> listaRegistrosExpMotivoSolic =  queryLaboral.DBO_Tr_Exp_Motivo_Solic("", "" , filtro);
                        if( !listaRegistrosExpMotivoSolic.isEmpty()  )
                         tmp_tr_exp_motivo_solic.TMP_TR_EXP_MOTIVO_SOLIC(listaRegistrosExpMotivoSolic);
                         //TR_EXP_ACTOR
                           ArrayList<ArrayList<String>> listaRegistrosExpActor =  queryLaboral.DBO_Tr_Exp_Actor("", "" , filtro);
                         if( !listaRegistrosExpActor.isEmpty() )
                           tmp_tr_exp_actor.TMP_TR_EXP_ACTOR(listaRegistrosExpActor);
                          //TR_EXP_DEMANDADO
                         ArrayList<ArrayList<String>> listaRegistrosExpDemandado =  queryLaboral.DBO_Tr_Exp_Demandado("", "" , filtro );
                         if( !listaRegistrosExpDemandado.isEmpty() )
                         tmp_tr_exp_demandado.TMP_TR_EXP_DEMANDADO(listaRegistrosExpDemandado);
                         for(String clave : clavOrgano){
                              queryRalabDes.merge_id_expediente(null,  clave , null);
                         }
                         queryRalabDes.enable_tr_exp_pk_ralalb();   
                         int registrosObservaciones =  queryRalabDes.consultarRalabObservaciones("",  filtro , ""); // modificar la consulta 
                         if(registrosObservaciones==0){
                             queryLaboral.DBO_Tr_OrganoJ_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Expedientes_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal ); 
                             queryLaboral.DBO_Tr_Demandado_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Audiencias_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_General_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Actor_Exportar_Inserts("", filtro , "" , sqlVirgenTemporal); 
                             queryLaboral.DBO_Tr_Exp_Motivo_Conf_Inserts("", filtro , periodo , sqlVirgenTemporal); 
                             queryLaboral.DBO_Tr_Exp_Circunst_Exportar_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Concepto_Reclam_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Prestacion_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Motivo_Huelga_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Suspension_Insert("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Terminacion_Insert("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Violacion_Insert("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Efecto_Sentencia_Insert("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Motivo_Solic_Insert("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Actor_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             queryLaboral.DBO_Tr_Exp_Demandado_Inserts("", filtro , periodo , sqlVirgenTemporal);
                             JFileChooser fileChooser = new JFileChooser();
                             fileChooser.setDialogTitle("Guardar archivo de texto");
                             String nombreArchivo = "MIG-DEFAULT LIBERADO.sql";
                             if (Rclave_entidad.isSelected()) {
                                 nombreArchivo = "MIG-" + Centidad.getSelectedItem().toString() + " LIBERADO.sql";
                             } else if (Rclave_organo.isSelected()) {
                                 nombreArchivo = "MIG-" + CorganoJur.getSelectedItem().toString() + " LIBERADO.sql";
                             } else if (Rclave_organo1.isSelected()) {
                                 nombreArchivo = "MIG-" + ClaveOrgano.getText() + " LIBERADO.sql";
                             }
                             fileChooser.setSelectedFile(new File(nombreArchivo));
                             int seleccionUsuario = fileChooser.showSaveDialog(null);
                             if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
                                 File archivo = fileChooser.getSelectedFile();
                                 try {
                                     // Copiar el archivo
                                     Files.copy(sqlVirgenTemporal.toPath(), archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                     JOptionPane.showMessageDialog(null, "Se guardó el archivo: " + archivo.getName(), "Información", JOptionPane.INFORMATION_MESSAGE);
                                 } catch (IOException e) {
                                     JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                                     e.printStackTrace();
                                 }
                                 carga.setVisible(false);
                             } else {
                                 JOptionPane.showMessageDialog(null, "No se guardó ningún archivo.", "Información", JOptionPane.INFORMATION_MESSAGE);
                             }
                         }
                        else
                          JOptionPane.showMessageDialog(null, "Existen registros en la tabla de observaciones, favor de verificar ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);  
                           carga.setVisible(false);
                         
                         }
                   }
                   catch(Exception ex){
                      JOptionPane.showMessageDialog(null, "Error en el proceso favor de verificar." +    ex.getMessage());
                      carga.setVisible(false);

                   }
              }).start();
            } 
            else 
              JOptionPane.showMessageDialog(null, "Para procesar la información, debes ingresar las claves de organos.", "Mensaje", JOptionPane.ERROR_MESSAGE);  
          }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CorganoJurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorganoJurActionPerformed
        // TODO add your handling code here:

        /* if (CorganoJur.getSelectedItem().toString().substring(0, 2).equals("04"))
        {

        }else{

        }*/
    }//GEN-LAST:event_CorganoJurActionPerformed

    private void CorganoJurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CorganoJurItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CorganoJurItemStateChanged

    private void CentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CentidadActionPerformed
        // TODO add your handling code here:
        /* if (Centidad.getSelectedItem().toString().equals("04"))
        {

        }else{

        }*/
    }//GEN-LAST:event_CentidadActionPerformed

    private void CentidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CentidadItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_CentidadItemStateChanged

    private void Rclave_entidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rclave_entidadActionPerformed
        if (Rclave_entidad.isSelected())
        {
            LEntidad.setVisible(false);
            jButton1.setVisible(true);
            Jorgano.setVisible(false);
            CorganoJur.setVisible(false);
            Jentidad.setVisible(true);
            Centidad.setVisible(true);
            Textoperiodo1.setVisible(true);
            jLabel4.setVisible(true);
            jButton2.setVisible(true);
            EtiquetaOrg.setVisible(false);
            ClaveOrgano.setVisible(false);
            Centidad.addItem("01");
            Centidad.addItem("02");
            Centidad.addItem("03");
            Centidad.addItem("04");
            Centidad.addItem("05");
            Centidad.addItem("06");
            Centidad.addItem("07");
            Centidad.addItem("08");
            Centidad.addItem("09");
            Centidad.addItem("10");
            Centidad.addItem("11");
            Centidad.addItem("11");
            Centidad.addItem("12");
            Centidad.addItem("13");
            Centidad.addItem("14");
            Centidad.addItem("15");
            Centidad.addItem("16");
            Centidad.addItem("17");
            Centidad.addItem("18");
            Centidad.addItem("19");
            Centidad.addItem("20");
            Centidad.addItem("21");
            Centidad.addItem("22");
            Centidad.addItem("23");
            Centidad.addItem("24");
            Centidad.addItem("25");
            Centidad.addItem("26");
            Centidad.addItem("27");
            Centidad.addItem("28");
            Centidad.addItem("29");
            Centidad.addItem("30");
            Centidad.addItem("31");
            Centidad.addItem("32");
        }
    }//GEN-LAST:event_Rclave_entidadActionPerformed

    private void Rclave_organoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rclave_organoActionPerformed
        if(Rclave_organo.isSelected())
        {
            LEntidad.setVisible(false);
            Jentidad.setVisible(false);
            Centidad.setVisible(false);
            Jorgano.setVisible(true);
            CorganoJur.setVisible(true);
            jButton1.setVisible(true);
            jLabel4.setVisible(true);
            jButton2.setVisible(true);
            Textoperiodo1.setVisible(true);
            EtiquetaOrg.setVisible(false);
            ClaveOrgano.setVisible(false);
            // actualizar el combo de clave organo 
           try{
                OracleConexion conexion = new  OracleConexion();
                conexion.Conectar();
                ResultSet rs = conexion.consultar(" select distinct  CASE \n" +
                "        WHEN LENGTH(CLAVE_ORGANO) < 7 \n" +
                "        THEN SUBSTR(CLAVE_ORGANO, 1, LENGTH(CLAVE_ORGANO) - 1) || '0' || SUBSTR(CLAVE_ORGANO, -1, 1)\n" +
                "        ELSE CLAVE_ORGANO \n" +
                "    END AS clave_organo  from v3_tr_control_expedientejl ORDER BY CLAVE_ORGANO ");
                while (rs.next()) {
                    CorganoJur.addItem(rs.getString("CLAVE_ORGANO"));
                }
               
           }
           catch(SQLException e){
              e.printStackTrace();
           }
        }
    }//GEN-LAST:event_Rclave_organoActionPerformed

    private void Rclave_organo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rclave_organo1ActionPerformed
          if(Rclave_organo1.isSelected())
        {
            LEntidad.setVisible(false);
            Jentidad.setVisible(false);
            Centidad.setVisible(false);
            Jorgano.setVisible(false);
            CorganoJur.setVisible(false);
            jButton1.setVisible(false);
            EtiquetaOrg.setVisible(true);
            ClaveOrgano.setVisible(true);
            jButton1.setVisible(true);
            jLabel4.setVisible(false);
            Textoperiodo1.setVisible(false);
            jButton2.setVisible(false);
        }
        
    }//GEN-LAST:event_Rclave_organo1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Valores();
        PConPerProcesar per = new PConPerProcesar();
        per.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Textoperiodo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Textoperiodo1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Textoperiodo1MousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
        
        
    }//GEN-LAST:event_formKeyPressed

    private void Textoperiodo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Textoperiodo1KeyPressed
        // TODO add your handling code here:
        
          // TODO add your handling code here:
         if (evt.isControlDown()) {
                    // Pegar el texto en el JTextField
                    System.out.println("Texto pegado: " + Textoperiodo1.getText());
                    // Cerrar la ventana
//                    PConPerProcesar periodo = new PConPerProcesar();
//                    
//                      periodo.dispose();  //Remove JFrame 1
//      periodo.setVisible(true) //Show other frame
                    
                    
            }
         
         
         
         
         
         
    }//GEN-LAST:event_Textoperiodo1KeyPressed

    //asignacion de valores publicos clave_entidad,clave_organo,periodo para ser usados en clases V1Validaciones,V2Validaciones,V3Validaciones
    public void Valores(){
        if(Rclave_entidad.isSelected()){
           clave_entidad=Centidad.getSelectedItem().toString();
        } 
        if(Rclave_organo.isSelected()){
            clave_organo =  (String)  CorganoJur.getSelectedItem();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PValidacionProcesar().setVisible(true);
            }
        });
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Centidad;
    private javax.swing.JTextField ClaveOrgano;
    private javax.swing.JComboBox CorganoJur;
    private javax.swing.JLabel EtiquetaOrg;
    private javax.swing.JLabel Jentidad;
    private javax.swing.JLabel Jorgano;
    private javax.swing.JLabel LEntidad;
    public static javax.swing.JLabel Lable;
    public javax.swing.JPanel PAgrupamiento;
    private javax.swing.JRadioButton Rclave_entidad;
    private javax.swing.JRadioButton Rclave_organo;
    private javax.swing.JRadioButton Rclave_organo1;
    public javax.swing.JTextField Textoperiodo1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox seleccionar;
    // End of variables declaration//GEN-END:variables
}
