/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase hereda de JFrame, permite al usuario agregar una nueva empresa 
 * desplegando una ventana
 * @since 22/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public final class AgregarEmpresa extends JFrame implements ActionListener {
    Container container = getContentPane();
    
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldRazonSocial = new JTextField();
    JTextField TextFieldNumeroCedula= new JTextField();
    JTextField TextFieldTelefono= new JTextField();
    JTextField TextFieldProvincia = new JTextField();
    JTextField TextFieldCanton = new JTextField();
    JTextField TextFieldDistrito = new JTextField();
    JTextField TextFieldSeñas = new JTextField();
    
   
    JLabel TextoRazonSocial = new JLabel("Razón Social");
    JLabel TextoNumeroCedula = new JLabel("Número de Cédula");
    JLabel TextoTelefono = new JLabel("Teléfono");
    JLabel TextoProvincia = new JLabel("Provincia");
    JLabel TextoDetalles = new JLabel("Cantón");
    JLabel TextoTipoDeServicio = new JLabel("Distrito");
    JLabel TextoEmpresaRelacionada = new JLabel("Señas");

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarEmpresa = new JButton("Agregar");
 
    AgregarEmpresa() {
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
        TextoRazonSocial.setBounds(40, 100, 150, 30);
        TextoNumeroCedula.setBounds(40, 140, 150, 30);
        TextoTelefono.setBounds(40, 180, 150, 30);
        TextoProvincia.setBounds(40, 220, 150, 30);
        TextoDetalles.setBounds(40, 260, 150, 30);
        TextoTipoDeServicio.setBounds(40, 300, 150, 30);
        TextoEmpresaRelacionada.setBounds(40, 340, 150, 30);     
        TextFieldRazonSocial.setBounds(200, 100, 150, 30);
        TextFieldNumeroCedula.setBounds(200, 140, 150, 30);
        TextFieldTelefono.setBounds(200, 180, 150, 30);
        TextFieldProvincia.setBounds(200, 220, 150, 30); 
        TextFieldCanton.setBounds(200, 260, 150, 30); 
        TextFieldDistrito.setBounds(200, 300, 150, 30);
        TextFieldSeñas.setBounds(200, 340, 150, 30);
        botonAgregarEmpresa.setBounds(140, 475, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(botonAgregarEmpresa);
        container.add(TextoRazonSocial);
        container.add(TextoNumeroCedula);
        container.add(TextoTelefono);
        container.add(TextoProvincia);
        container.add(TextoDetalles);
        container.add(TextoTipoDeServicio);
        container.add(TextoEmpresaRelacionada);
        container.add(TextFieldRazonSocial);
        container.add(TextFieldProvincia);
        container.add(TextFieldCanton);
        container.add(TextFieldSeñas);
        container.add(TextFieldDistrito);
        container.add(TextFieldNumeroCedula);
        container.add(TextFieldTelefono);
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonAgregarEmpresa.addActionListener(this);   
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==botonAtras){
            TextFieldRazonSocial.setText("");
            TextFieldProvincia.setText("");
            TextFieldCanton.setText("");
            TextFieldSeñas.setText("");
            TextFieldDistrito.setText("");
            TextFieldNumeroCedula.setText("");
            TextFieldTelefono.setText("");

            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaAgregarEmpresa(false); 
          
        }
        String fiTemp;
        String ffTemp;
        
        if (e.getSource()==botonAgregarEmpresa){
           
            if (TextFieldDistrito.getText().equals("") || TextFieldSeñas.getText().equals("") ||
                    TextFieldTelefono.getText().equals("") || TextFieldNumeroCedula.getText().equals("") || 
                        TextFieldSeñas.getText().equals("") || TextFieldCanton.getText().equals("") || 
                            TextFieldRazonSocial.getText().equals("") || TextFieldProvincia.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else if(!Inicio.adminApp.verificarTelefono(TextFieldTelefono.getText())){
                JOptionPane.showMessageDialog(this, "Teléfono inválido ingresado");
            }else {
                Inicio.adminApp.registrarEmpresaServicios(TextFieldRazonSocial.getText(), 
                        TextFieldNumeroCedula.getText(), TextFieldTelefono.getText(), 
                            TextFieldProvincia.getText(), TextFieldCanton.getText(), TextFieldDistrito.getText(), 
                                TextFieldSeñas.getText(), false);
                Inicio.adminApp.cargarInformacionJSON("empresas.json", "Empresa");
                
                DefaultComboBoxModel mod = new DefaultComboBoxModel(Inicio.listaEmpresas.toArray());
                AgregarServicio.TextFieldEmpresaServicio.setModel(mod);
                
                JOptionPane.showMessageDialog
                    (this, "Se ha agregado una nueva empresa de mantenimiento");
                TextFieldRazonSocial.setText("");
                TextFieldProvincia.setText("");
                TextFieldCanton.setText("");
                TextFieldSeñas.setText("");
                Inicio.VentanaMenuAdministrador(true);
                Inicio.VentanaAgregarEmpresa(false);    
                
            }
        }
    }
}