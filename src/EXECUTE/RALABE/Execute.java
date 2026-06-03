/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXECUTE.RALABE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Execute {
    
    public  void ejecutarExeDesdeResources(String Ruta,JProgressBar jProgressBar1 ) {
      jProgressBar1.setVisible(true);
        jProgressBar1.setIndeterminate(true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                String rutaExe = System.getProperty("user.home" )
                        + Ruta;

                File exe = new File(rutaExe);

                if (!exe.exists()) {
                    throw new FileNotFoundException("No se encontró el EXE en: " + rutaExe);
                }

                new ProcessBuilder(exe.getAbsolutePath()).start();

                return null;
            }

            @Override
            protected void done() {
                jProgressBar1.setIndeterminate(false);
                jProgressBar1.setVisible(false);
            }
        };

        worker.execute();
}
}
