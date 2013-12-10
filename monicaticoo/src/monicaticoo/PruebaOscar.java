/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monicaticoo;

import db_managment.Direct_Control_BD;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Oscar Montes
 */
public class PruebaOscar extends javax.swing.JFrame {
    Direct_Control_BD AdministradorBD;
    /**
     * Creates new form PruebaOscar
     */
    public PruebaOscar(Direct_Control_BD AdministradorBD) {
        //Obtiene el administrador de la base de datos
        this.AdministradorBD=AdministradorBD;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscaArchivo_but = new javax.swing.JButton();
        jTextField_Direccion = new javax.swing.JTextField();
        cargaArchivo_but = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buscaArchivo_but.setText("Buscar Archivo");
        buscaArchivo_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaArchivo_butActionPerformed(evt);
            }
        });

        jTextField_Direccion.setText("Direccion");

        cargaArchivo_but.setText("Cargar Inventario");
        cargaArchivo_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaArchivo_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(buscaArchivo_but)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cargaArchivo_but)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaArchivo_but)
                    .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargaArchivo_but))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Carga el archivo de excel seleccionado.
     * @param evt 
     */
    private void cargaArchivo_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaArchivo_butActionPerformed
        ReadExcel excel = new ReadExcel();
        String[][] inventario=excel.leerArchivoExcel(new File(
                this.jTextField_Direccion.getText()));
        int numFilas=inventario.length;
        for(int row =0 ; row < numFilas;row++){
            this.AdministradorBD.insertProducto(inventario[row]);
        }
    }//GEN-LAST:event_cargaArchivo_butActionPerformed
    /**
     * Ejecuta un buscador para encontrar el archivo de excel.
     * @param evt 
     */
    private void buscaArchivo_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaArchivo_butActionPerformed
        JFileChooser filechooser= new JFileChooser();
        int value = filechooser.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
                File file = filechooser.getSelectedFile();
                this.jTextField_Direccion.setText(String.valueOf(file));
        }
    }//GEN-LAST:event_buscaArchivo_butActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscaArchivo_but;
    private javax.swing.JButton cargaArchivo_but;
    private javax.swing.JTextField jTextField_Direccion;
    // End of variables declaration//GEN-END:variables
}
