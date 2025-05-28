
package Screen_laborales;

import LeerQuery.QueryRalabProd;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/*  @author ANTONIO.CORIA
 */
public class PConPerProcesar extends javax.swing.JFrame {

    ArrayList<String[]> ArrayPeriodo;
    QueryRalabProd queryRalabProd = new QueryRalabProd();
    public static String periodo="";
     
    public PConPerProcesar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tperiodo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        Tperiodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periodo"
            }
        ));
        Tperiodo.setColumnSelectionAllowed(true);
        Tperiodo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tperiodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TperiodoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TperiodoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tperiodo);
        Tperiodo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
      
     if(PValidacionProcesar.clave_entidad != null ){
        ArrayPeriodo=queryRalabProd.periodoEntidad();
        DefaultTableModel TablaPeriodo = (DefaultTableModel) Tperiodo.getModel();     
        Object[] fila = new Object[ArrayPeriodo.size()];      
        for(int j=0; j<ArrayPeriodo.size(); j++){
        String Periodo=Arrays.toString(ArrayPeriodo.get(j));
        fila[0]=Periodo.replace("[", "").replace("]", "");
        TablaPeriodo.addRow(fila);
        Class<?> col_class = Tperiodo.getColumnClass(0);
        Tperiodo.setDefaultEditor(col_class, null); 
        }  
      
      }
      if(PValidacionProcesar.clave_organo != null ){
        ArrayPeriodo=queryRalabProd.periodoClaveOrgano();
        DefaultTableModel TablaPeriodo = (DefaultTableModel) Tperiodo.getModel();     
        Object[] fila = new Object[ArrayPeriodo.size()];      
        for(int j=0; j<ArrayPeriodo.size(); j++){
        String Periodo=Arrays.toString(ArrayPeriodo.get(j));
        fila[0]=Periodo.replace("[", "").replace("]", "");
        TablaPeriodo.addRow(fila);
        Class<?> col_class = Tperiodo.getColumnClass(0);
        Tperiodo.setDefaultEditor(col_class, null); 
        }  
      
      }
    
    }//GEN-LAST:event_formWindowOpened

   
    
    private void TperiodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TperiodoMouseClicked
        // TODO add your handling code here 
    }//GEN-LAST:event_TperiodoMouseClicked

    private void TperiodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TperiodoMousePressed
         int selectedRowIndex = Tperiodo.getSelectedRow();
         DefaultTableModel model = (DefaultTableModel)Tperiodo.getModel();
         
          
    }//GEN-LAST:event_TperiodoMousePressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PConPerProcesar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tperiodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
