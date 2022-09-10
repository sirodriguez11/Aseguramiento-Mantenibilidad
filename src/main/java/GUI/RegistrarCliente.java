package GUI;

import Modelo.TLicencia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario registrar clientes
 * @since 25/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public final class RegistrarCliente extends JFrame implements ActionListener {
    
    String filename;
    TLicencia[] TiposLicencias = {TLicencia.A1, TLicencia.A2, TLicencia.A3, TLicencia.A4, 
        TLicencia.B1, TLicencia.B2, TLicencia.B3, TLicencia.B4, TLicencia.C1, TLicencia.C2, 
            TLicencia.D1, TLicencia.D2, TLicencia.D3, TLicencia.E1, TLicencia.E2};
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldNombreCompleto = new JTextField();
    JTextField TextFieldCédula = new JTextField();
    JTextField TextFieldDirección = new JTextField();
    JTextField TextFieldCorreo = new JTextField();
    JTextField TextFieldTeléfono = new JTextField();
    JTextField TextFieldNumeroLicencia = new JTextField();
    
    JComboBox<TLicencia> TextFieldTipoLicencia = new JComboBox<>(TiposLicencias);
    
    com.toedter.calendar.JDateChooser TextFieldFechaEmisionLicencia= 
            new com.toedter.calendar.JDateChooser();
    com.toedter.calendar.JDateChooser TextFieldFechaExpiracionLicencia= 
            new com.toedter.calendar.JDateChooser();
    
    JLabel TextoNombreCompleto = new JLabel("Nombre Completo");
    JLabel TextoCédula = new JLabel("Cédula");
    JLabel TextoDirección = new JLabel("Dirección Exacta");
    JLabel TextoCorreo = new JLabel("Correo Electrónico");
    JLabel TextoTeléfono = new JLabel("Teléfono (incluya +506)");
    JLabel TextoNumeroLicencia = new JLabel("Número de Licencia");
    JLabel TextoFechaEmisionLicencia = new JLabel("FechaEmisionLicencia");
    JLabel TextoTipoLicencia = new JLabel("Tipo Licencia:");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Fecha Expiracion Licencia");
    JLabel TextoImágen = new JLabel("Imagen");
    JLabel TextoURL =new JLabel("No se ha seleccionado imagen");
    JLabel TextoTL=new JLabel("");
     
    JButton TextFieldImágen = new JButton("Seleccionar Imagen");
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
 
    RegistrarCliente() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
 
    /**
     *
     */
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    /**
     *
     */
    public void setLocationAndSize() {
        TextoNombreCompleto.setBounds(40, 100, 150, 30);
        TextoCédula.setBounds(40, 140, 150, 30);
        TextoDirección.setBounds(40, 180, 150, 30);
        TextoCorreo.setBounds(40, 220, 150, 30);
        TextoTeléfono.setBounds(40, 260, 150, 30);
        TextoNumeroLicencia.setBounds(40, 300, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 340, 150, 30);
        TextoTipoLicencia.setBounds(40, 380, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420, 150, 30);
        TextoImágen.setBounds(40, 460, 150, 30);
        TextoURL.setBounds(40, 500, 300, 30);
        TextoTL.setBounds(120, 380, 150, 30);
        
        
        TextFieldNombreCompleto.setBounds(200, 100, 150, 30);
        TextFieldCédula.setBounds(200, 140, 150, 30);
        TextFieldDirección.setBounds(200, 180, 150, 30); 
        TextFieldCorreo.setBounds(200, 220, 150, 30); 
        TextFieldTeléfono.setBounds(200, 260, 150, 30); 
        TextFieldNumeroLicencia.setBounds(200, 300, 150, 30); 
        TextFieldFechaEmisionLicencia.setBounds(200, 340, 150, 30); 
        TextFieldTipoLicencia.setBounds(200, 380, 150, 30); 
        TextFieldFechaExpiracionLicencia.setBounds(200, 420, 150, 30); 
        TextFieldImágen.setBounds(200, 460, 150, 30); 
        
       botonAgregarOperador.setBounds((200-150/2), 550, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
 
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(botonAgregarOperador);
        
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoDirección);
        container.add(TextoCorreo);
        container.add(TextoTeléfono);
        container.add(TextoNumeroLicencia);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoImágen);
       
        container.add(TextFieldNombreCompleto);
        container.add(TextFieldCédula);
        container.add(TextFieldDirección);
        container.add(TextFieldCorreo);
        container.add(TextFieldTeléfono);
        container.add(TextFieldNumeroLicencia);
        container.add(TextFieldFechaEmisionLicencia);
        container.add(TextFieldTipoLicencia);
        container.add(TextFieldFechaExpiracionLicencia);
        container.add(TextFieldImágen);
        container.add(TextoURL);
        container.add(TextoTL);
        
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        TextFieldImágen.addActionListener(this);
        TextFieldTipoLicencia.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldNombreCompleto.setText("");
            TextFieldCédula.setText("");
            TextFieldDirección.setText("");
            TextFieldCorreo.setText("");
            TextFieldTeléfono.setText("");
            TextFieldNumeroLicencia.setText("");
            TextFieldFechaEmisionLicencia.setDate(null);
            TextFieldTipoLicencia.setSelectedIndex(0);
            TextFieldFechaExpiracionLicencia.setDate(null);
            TextoURL.setText("No se ha seleccionado imagen");
            
            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaRegistrarCliente(false);
          
        }
        if (e.getSource()==botonAgregarOperador){

            String fechaemisionlicenciaTemporal;
            String fechaexpiracionlicenciaTemporal;


            if(TextFieldFechaEmisionLicencia.getCalendar()!=null){
                int año = TextFieldFechaEmisionLicencia.getCalendar().get(Calendar.YEAR);
                int mes = TextFieldFechaEmisionLicencia.getCalendar().get(Calendar.MONTH) + 1;
                int dia = TextFieldFechaEmisionLicencia.getCalendar().get(Calendar.DAY_OF_MONTH);
                fechaemisionlicenciaTemporal=dia+"/"+mes+"/"+año;
            }
            
            if(TextFieldFechaExpiracionLicencia.getCalendar()!=null){
               int año = TextFieldFechaExpiracionLicencia.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaExpiracionLicencia.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaExpiracionLicencia.getCalendar().get(Calendar.DAY_OF_MONTH);
                fechaexpiracionlicenciaTemporal=dia+"/"+mes+"/"+año;
            }
            
            if (TextFieldFechaExpiracionLicencia.getDate() == null || 
                    TextFieldNombreCompleto.getText().equals("") || TextFieldCédula.getText().equals("") ||
                        TextFieldDirección.getText().equals("") ||TextFieldCorreo.getText().equals("") ||
                            TextFieldTeléfono.getText().equals("") ||TextFieldNumeroLicencia.getText().equals("") || 
                                filename.equals("No se ha seleccionado imagen") || 
                                    TextFieldFechaEmisionLicencia.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Ingreso incompleto de elementos");
            }else if (!Inicio.adminApp.verificarCorreo(TextFieldCorreo.getText())){
                JOptionPane.showMessageDialog(this, "Correo inválido");
            }else if (!Inicio.adminApp.verificarTelefono(TextFieldTeléfono.getText())){
                JOptionPane.showMessageDialog(this, "Número telefónico inválido");
            }else if(Inicio.adminApp.obtenerCliente(TextFieldCédula.getText())!=null){
                JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese número de identificación");
            }else {   
                Inicio.adminApp.registrarCliente(TextFieldNombreCompleto.getText(), TextFieldCédula.getText(), 
                        TextFieldDirección.getText(), TextFieldCorreo.getText(), TextFieldTeléfono.getText(), 
                            TextFieldNumeroLicencia.getText(), TextFieldFechaEmisionLicencia.getCalendar(), 
                                (TLicencia) TextFieldTipoLicencia.getSelectedItem(), 
                                    TextFieldFechaExpiracionLicencia.getCalendar(), filename, false);
                Inicio.adminApp.cargarInformacionJSON("clientes.json", "Cliente");
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo Cliente");
                TextFieldNombreCompleto.setText("");
                TextFieldCédula.setText("");
                TextFieldDirección.setText("");
                TextFieldCorreo.setText("");
                TextFieldTeléfono.setText("");
                TextFieldNumeroLicencia.setText("");
                TextFieldFechaEmisionLicencia.setDate(null);
                TextFieldTipoLicencia.setSelectedIndex(0);
                TextFieldFechaExpiracionLicencia.setDate(null);
                TextoURL.setText("No se ha seleccionado imagen");
                TextoTL.setText("");
                Inicio.VentanaMenuPrincipal(true);
                Inicio.VentanaRegistrarCliente(false);
                
            }   
        }

        if(e.getSource()==TextFieldImágen){
            int accion = explorer.showOpenDialog(Inicio.frameRegistrarCliente);
            if (accion == JFileChooser.APPROVE_OPTION){            
                filename = explorer.getSelectedFile().toString();
                TextoURL.setText(filename);
            }else{
                filename = "Error, no se encuentra el archivo";
            }
        }
    }
}