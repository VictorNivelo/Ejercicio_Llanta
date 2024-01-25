/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Dao.GrafosEjemplo.EscuelaDao;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
import Vista.Arreglos.Tabla.ModeloTablaEscuela;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Victor
 */
public class VistaRegistroEscuela extends javax.swing.JFrame {

    ModeloTablaEscuela mte = new ModeloTablaEscuela();
    EscuelaDao escuelaControlDao = new EscuelaDao();
    ListaDinamica<Escuela> listaE = new ListaDinamica<>();
    private File Fportada;
    private File Fescudo;
    private String rutaImagenGuardadaPortada;
    private String rutaImagenGuardadaEscudo;

    /**
     * Creates new form VistaRegistroEscuela
     */
    public VistaRegistroEscuela() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private File CargarFoto() throws Exception{
        File obj = null;
        JFileChooser choosser = new JFileChooser();

        choosser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png", "jpeg");
        choosser.addChoosableFileFilter(filter);

        Integer resp = choosser.showOpenDialog(this);
        if(resp == JFileChooser.APPROVE_OPTION){
            obj = choosser.getSelectedFile();
            System.out.println("ok");
        }
        else{
            System.out.println("no");
        }
        return obj;
    }
    
    public static void copiarArchivo(File origen, File destino) throws Exception {
        Files.copy(origen.toPath(),(destino).toPath(),StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static String extension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
    
    public static double coordGpsToKm(double lat1, double lon1, double lat2, double lon2) {
        double lat1rad = Math.toRadians(lat1);
        double lon1rad = Math.toRadians(lon1);
        double lat2rad = Math.toRadians(lat2);
        double lon2rad = Math.toRadians(lon2);

        double difLatitud = lat1rad - lat2rad;
        double difLongitud = lon1rad - lon2rad;

        double a = Math.pow(Math.sin(difLatitud / 2), 2)  + Math.cos(lat1rad)
                * Math.cos(lat2rad)* Math.pow(Math.sin(difLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double radioTierraKm = 6378.0;
        double distancia = radioTierraKm * c;

        return distancia;
    }

    private void CargarTabla() {
        mte.setEscuela(escuelaControlDao.getLista());
        tblEscuela.setModel(mte);
        tblEscuela.updateUI();
    }
    
    private void Limpiar() throws ListaVacia {
        txtNombre.setText("");
        txtEscudo.setText("");
        txtPortada.setText("");
        txtLongitud.setText("");
        txtLatitud.setText("");
        escuelaControlDao.setEscuelaDao(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblEscuela.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                escuelaControlDao.setEscuelaDao(mte.getEscuela().getInfo(fila));
                
                txtNombre.setText(escuelaControlDao.getEscuelaDao().getNombre());
                txtEscudo.setText(escuelaControlDao.getEscuelaDao().getEscudo());
                txtPortada.setText(escuelaControlDao.getEscuelaDao().getPortada());
                txtLongitud.setText(escuelaControlDao.getEscuelaDao().getCordenadaEscuela().getLongitud().toString());
                txtLatitud.setText(escuelaControlDao.getEscuelaDao().getCordenadaEscuela().getLatitud().toString());
                
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor ingrese el nombre de la escuela");
        }
        else if(txtPortada.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la portada de la escuela");
        }
        else if(txtEscudo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese el escudo de la escuela");
        }
        else if(txtLongitud.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la longitud de la escuela");
        }
        else if(txtLatitud.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la latitud de la escuela");
        }
        else{
            //Datos de meteria
            Integer IdPersona = listaE.getLongitud() + 1;
            String NombreAsignatura = txtNombre.getText();
            String Escudo = txtEscudo.getText();
            String Portada = txtPortada.getText();
            String Longitud = txtPortada.getText();
            String Latitud = txtPortada.getText();
            
            escuelaControlDao.getEscuelaDao().setId(IdPersona);
            escuelaControlDao.getEscuelaDao().setNombre(NombreAsignatura);
            escuelaControlDao.getEscuelaDao().setEscudo(Escudo);
            escuelaControlDao.getEscuelaDao().setPortada(Portada);
//            escuelaControlDao.getEscuelaDao().setHorarioMateria(UtilVista.obtenerHorarioControl(cbxHorario));
            
            if (escuelaControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "ESCUELA GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                escuelaControlDao.setEscuelaDao(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE GUARDAR", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            Limpiar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPortada = new javax.swing.JTextField();
        txtEscudo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        txtLatitud = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnCargarE = new javax.swing.JButton();
        btnCargarP = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEscuela = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESCUELA");

        jLabel2.setText("Nombre");

        jLabel3.setText("Portada");

        jLabel4.setText("Escudo");

        txtPortada.setEditable(false);
        txtPortada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPortadaMouseClicked(evt);
            }
        });

        txtEscudo.setEditable(false);
        txtEscudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEscudoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("COODERNADAS");

        jLabel6.setText("Longitud");

        jLabel7.setText("Latitud");

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCargarE.setText("CARGAR");
        btnCargarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarEActionPerformed(evt);
            }
        });

        btnCargarP.setText("CARGAR");
        btnCargarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarPActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("INFORMACION");

        tblEscuela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEscuela);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("LISTA  DE ESCUELAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(22, 22, 22)
                                                .addComponent(txtEscudo))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCargarE)
                                            .addComponent(btnCargarP)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLongitud)
                                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPortada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEscudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPortadaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() >= 2){
            Foto f = new Foto();
            f.mostrarImagen(rutaImagenGuardadaPortada);
            f.setVisible(true);

        }
    }//GEN-LAST:event_txtPortadaMouseClicked

    private void txtEscudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEscudoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() >= 2){
            Foto f = new Foto();
            f.mostrarImagen(rutaImagenGuardadaEscudo);
            f.setVisible(true);

        }
    }//GEN-LAST:event_txtEscudoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor ingrese el nombre de la escuela");
        }
        else if(txtPortada.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la portada de la escuela");
        }
        else if(txtEscudo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese el escudo de la escuela");
        }
        else if(txtLongitud.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la longitud de la escuela");
        }
        else if(txtLatitud.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor ingrese la latitud de la escuela");
        }
        else{

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCargarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarEActionPerformed
        // TODO add your handling code here:
        try {
            Fescudo = CargarFoto();
            if (Fescudo != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String nombreUnico = "imagen_" + sdf.format(new Date()) + "." + extension(Fescudo.getName());

                File destino = new File("Foto/" + nombreUnico);
                copiarArchivo(Fescudo, destino);

                rutaImagenGuardadaEscudo = destino.getAbsolutePath();

                txtEscudo.setText(rutaImagenGuardadaEscudo);

            }
        }
        catch (Exception e) {
            System.out.println("error");
        }
    }//GEN-LAST:event_btnCargarEActionPerformed

    private void btnCargarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarPActionPerformed
        // TODO add your handling code here:
        try {
            Fportada = CargarFoto();
            if (Fportada != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String nombreUnico = "imagen_" + sdf.format(new Date()) + "." + extension(Fportada.getName());

                File destino = new File("Foto/" + nombreUnico);
                copiarArchivo(Fportada, destino);

                rutaImagenGuardadaPortada = destino.getAbsolutePath();

                txtPortada.setText(rutaImagenGuardadaPortada);

                //sicidsf
                //                txtPortada.setText(Fportada.getAbsolutePath());
                //
                //                File destino = new File("Foto/x.jpg");
                //                copiarArchivo(Fportada, destino);
                //
                //                rutaImagenGuardada = destino.getAbsolutePath();
                //                txtPortada.setText(rutaImagenGuardada);
                //codigo antui
                //            Fportada = CargarFoto();
                //            if(Fportada != null){
                    //                txtPortada.setText(Fportada.getAbsolutePath());
                }
            }
            catch (Exception e) {
                System.out.println("error");
            }
    }//GEN-LAST:event_btnCargarPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistroEscuela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarE;
    private javax.swing.JButton btnCargarP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEscuela;
    private javax.swing.JTextField txtEscudo;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPortada;
    // End of variables declaration//GEN-END:variables
}
