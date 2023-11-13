/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.PersonaControlador;
import Controlador.Tda.listas.Exepciones.EstaVacia;
import Controlador.Tda.listas.ListaDinamica;
import Vista.Arreglos.Tabla.ModeloTablaPersona;
import Vista.Arreglos.Util.UtilVista;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JOptionPane;
import Modelo.Cuenta;
import Modelo.Persona;
import Modelo.Rol;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class VistaRegistrarUsuario extends javax.swing.JFrame {
    
    private PersonaControlador personaControl = new PersonaControlador(25);
    private ModeloTablaPersona mtp = new ModeloTablaPersona();
    private ListaDinamica<Persona> ListaD = new ListaDinamica<>();


    /**
     * Creates new form VistaRegistrarUsuario
     */
    public VistaRegistrarUsuario(){
        initComponents();
        this.setLocationRelativeTo(null);   
        UtilVista.CargarComboRoles(cbxRol);
        CargarTabla();
    }
    
    private void CargarTabla(){
        mtp.setPersonas(personaControl.getMatrizPersona());
        cbxTipoIdentificacion.setSelectedIndex(-1);
        cbxRol.setSelectedIndex(-1);
        tblUsuarios.setModel(mtp);
        tblUsuarios.updateUI();
        
    }
    
    private void Limpiar() {
        txtApellido.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtNumeroIdentificacion.setText("");
        cbxRol.setSelectedIndex(-1);
        cbxTipoIdentificacion.setSelectedIndex(-1);
        txtCorreo.setText("");
        txtContrasena.setText("");
        personaControl.setPersona(null);
        CargarTabla();

    }
    
    private Boolean Validar(){
        return (!txtApellido.getText().trim().isEmpty() && !txtDireccion.getText().trim().isEmpty() && !txtNombre.getText().trim().isEmpty());
        
    }
    
    private void Guardar(){
        if(Validar()){
            String Correo = txtCorreo.getText();
            String Contraseña = txtContrasena.getText();
            Boolean EstadoCuenta = true;
            Integer IdPersona = ListaD.getLongitud()+1;
            
            Cuenta CuentaUsuario = new Cuenta(IdPersona, Correo, Contraseña, EstadoCuenta);
            
            personaControl.getPersona().setPersonaCuenta(CuentaUsuario);
            personaControl.getPersona().setTipoDNI(cbxTipoIdentificacion.getSelectedItem().toString());
            personaControl.getPersona().setDNI(txtNumeroIdentificacion.getText());
            personaControl.getPersona().setNombre(txtNombre.getText());
            personaControl.getPersona().setApellido(txtApellido.getText());
            personaControl.getPersona().setDireccion(txtDireccion.getText());
            personaControl.getPersona().setRolPersona(UtilVista.ObtenerRolControlador(cbxRol));
            
            if(personaControl.Guardar()){
                JOptionPane.showMessageDialog(null, "Datos guardados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                personaControl.setPersona(null);
                CargarTabla();
                
//                personaControlador.Imprimir();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo guardar", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Limpiar();
    }
    
    private void guardarListaEnJson(ListaDinamica<Persona> listaPersonas, String archivoJson) {
        try (Writer writer = new FileWriter(archivoJson)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaPersonas, writer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static ListaDinamica<Persona> cargarListaDesdeJson(String archivoJson) throws EstaVacia{
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoJson))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            java.lang.reflect.Type listaType = new TypeToken<ListaDinamica<Persona>>() {}.getType();

            ListaDinamica<Persona> listaPersonas = gson.fromJson(reader, listaType);

            return listaPersonas;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    public void CargarDatosCitasAtender() throws EstaVacia{
//        ListaDinamica<Persona> pas = new ListaDinamica<>();
//        Gson gson = new Gson();
//
//        FileReader reader;
//
//        try {reader = new FileReader("ListaUsuarios.json");
//            ListaDinamica<Persona> listaPacientesCargada = gson.fromJson(reader, new TypeToken<ListaDinamica<Persona>>() {}.getType());
//            
//            for (int i = 0; i < listaPacientesCargada.getLongitud(); i++) {
//                Persona paciente = (Persona) listaPacientesCargada.ObtenerInfo(i);
//                pas.Agregar(paciente);
//            }
//            
//        } 
//        catch (FileNotFoundException e) {
//            System.out.println(e);
//        }
//
//        for (int i = pas.getLongitud() - 1; i >= 0; i--) {
//            Persona persona = (Persona) pas.ObtenerInfo(i);
//
//            Object[] fila = {
//                persona.getId_Persona(),
//                persona.getRolPersona().getNombre_rol(),
//                persona.getTipoDNI(),
//                persona.getDNI(),
//                persona.getNombre(),
//                persona.getApellido(),
//                persona.getDireccion(),
//                persona.getPersonaCuenta().getCorreo(),
//                persona.getPersonaCuenta().getEstadoCuenta()
//            };
//
//            mtp.setPersonas(fila);
//
//            mtp.fireTableRowsInserted(mtp.getRowCount() - 1, mtp.getRowCount() - 1);
//            
//            tblUsuarios.setModel(mtp);
//            tblUsuarios.updateUI();
//        }
//    }
//    
//    private static void guardarDatosJson(String json) {
//        try (FileWriter fileWriter = new FileWriter("ListaUsuarios.json")) {
//            fileWriter.write(json);
//        } 
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    

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
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroIdentificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        btnRegistrarNuevoUsuario = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoIdentificacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRAR USUARIO");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR USUARIO");

        jLabel3.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel5.setText("Numero Identificacion");

        txtNumeroIdentificacion.setToolTipText("");
        txtNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroIdentificacionKeyTyped(evt);
            }
        });

        jLabel6.setText("Dirreccion");

        jLabel7.setText("Correo");

        jLabel8.setText("Contraseña");

        btnRegistrarNuevoUsuario.setText("REGISTRAR USUARIO");
        btnRegistrarNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNuevoUsuarioActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel2.setText("Rol");

        jLabel9.setText("Tipo de identificacion");

        cbxTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Pasaporte" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroIdentificacion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxRol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarNuevoUsuario)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrarNuevoUsuario))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNuevoUsuarioActionPerformed
        // TODO add your handling code here:"
        if(cbxRol.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "El tipo de rol no esta seleccionado","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else if(cbxTipoIdentificacion.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "El tipo de identificacion no esta seleccionado","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtNumeroIdentificacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo de identificacion esta vacio","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo de nombre esta vacio","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtApellido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo de apellido esta vacio","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo de direccion esta vacio","CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Integer IdPersona = ListaD.getLongitud()+1;
            String TipoDNIP = cbxTipoIdentificacion.getSelectedItem().toString();
            String NumeroDNIP = txtNumeroIdentificacion.getText();
            String NombreP = txtNombre.getText();
            String ApellidoP = txtApellido.getText();
            String DireccionP = txtDireccion.getText();
            Rol rol = UtilVista.ObtenerRolControlador(cbxRol);
            
            String Correo = txtCorreo.getText();
            String Contraseña = txtContrasena.getText();
            Boolean EstadoCuenta = true;
            
            Cuenta CuentaUsuario = new Cuenta(IdPersona, Correo, Contraseña, EstadoCuenta);
            
            
            Persona personaGuardar = new Persona(IdPersona, TipoDNIP, NumeroDNIP, NombreP, ApellidoP, DireccionP, CuentaUsuario, rol);
            
            ListaD.Agregar(personaGuardar);
            
            guardarListaEnJson(ListaD, "ListaUsuarios.json");
            
            System.out.println(ListaD);

            Guardar();

        }
        
//        VistaAlmacen abrir = new VistaAlmacen();
//        abrir.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarNuevoUsuarioActionPerformed

    private void txtNumeroIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdentificacionKeyTyped
        // TODO add your handling code here:
        
        int key = evt.getKeyChar();
        boolean delete = key == 8;
        
        Character c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || delete)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de numeros", "TEXTO NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        if(txtNumeroIdentificacion.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroIdentificacionKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        boolean delete = key == 8;

        if (!(minusculas || mayusculas || espacio ||delete)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de letras", "TEXTO NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        boolean delete = key == 8;

        if (!(minusculas || mayusculas || espacio ||delete)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de letras", "TEXTO NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

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
            java.util.logging.Logger.getLogger(VistaRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarNuevoUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JComboBox<String> cbxTipoIdentificacion;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroIdentificacion;
    // End of variables declaration//GEN-END:variables
}
