package GUI;

import Controlador.AdministradorAplicacion;
import com.itextpdf.text.DocumentException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario realizar acciones de administrador
 * @since 26/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public final class RegistrarOperador extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    
    JTextField TextFieldNombreCompleto = new JTextField();
    JTextField TextFieldCorreo = new JTextField();
    
    JLabel TextoNombreCompleto = new JLabel("Nombre Completo");
    JLabel TextoCorreoElectronico = new JLabel("Correo Electrónico");
    
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
 
 
 
    RegistrarOperador() {
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
        TextoNombreCompleto.setBounds(70, 100, 150, 30);
        TextoCorreoElectronico.setBounds(70, 140, 150, 30);
        
        TextFieldNombreCompleto.setBounds(200, 100, 150, 30);
        TextFieldCorreo.setBounds(200, 140, 150, 30);
        
        botonAgregarOperador.setBounds((200-150/2), 300, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(botonAgregarOperador);
        container.add(TextoNombreCompleto);
        container.add(TextoCorreoElectronico);
        container.add(TextFieldNombreCompleto);
        container.add(TextFieldCorreo);
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldNombreCompleto.setText("");
            TextFieldCorreo.setText("");
            
            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaRegistrarOperador(false);
          
        }
        if (e.getSource()==botonAgregarOperador){
            
            if (!Inicio.adminApp.verificarCorreo(TextFieldCorreo.getText())) {
                JOptionPane.showMessageDialog(this, "El correo ingresado es inválido");    
            }else if(TextFieldCorreo.getText().equals("") || TextFieldNombreCompleto.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingreso incompleto de datos");
            }else {
                String password = AdministradorAplicacion.generarContraseña();
                Inicio.adminApp.registrarOperador(TextFieldCorreo.getText(), password, 
                        TextFieldNombreCompleto.getText(), false, false);
                Inicio.adminApp.cargarInformacionJSON("operadores.json", "Operador");
                try {
                    Inicio.adminApp.mandarCorreoCredenciales(Inicio.adminApp.obtenerOperador
                        (TextFieldCorreo.getText()), password);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegistrarOperador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(RegistrarOperador.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo usuario para Soporte al Cliente!");
                TextFieldNombreCompleto.setText("");
                TextFieldCorreo.setText("");
                Inicio.VentanaMenuPrincipal(true);
                Inicio.VentanaRegistrarOperador(false);    
                
            }
        }
    }
}