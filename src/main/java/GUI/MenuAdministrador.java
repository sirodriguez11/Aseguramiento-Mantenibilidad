package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario realizar acciones de administrador
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */

public final class MenuAdministrador extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    
    JButton botonAgregarVehiculo = 
            new JButton("<html><center>Agregar Vehículo<br>a flotilla</center></html>");
    JButton botonEditarVehiculo = 
            new JButton("<html><center>Editar información<br>de vehículo</center></html>");
    JButton botonRegistrarEmpresaServicios = 
            new JButton("<html><center>Registrar nueva<br>empresa de servicios</center></html>");
    JButton botonRegistrarServicioMantenimiento = 
            new JButton("<html><center>Registrar nuevo<br>servicio de mantenimiento</center></html>");
    JButton botonAtras = new JButton("Atrás");
 
    MenuAdministrador() {
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
        int k = -5;
        botonAgregarVehiculo.setBounds((200-150/2)+k, 100, 150, 70);
        botonRegistrarEmpresaServicios.setBounds((200-150/2)+k, 190, 150, 70);
        botonRegistrarServicioMantenimiento.setBounds(350, 190, 150, 70);
        botonEditarVehiculo.setBounds(350, 100, 150, 70);
        botonAtras.setBounds(450, 30, 150, 30);
        
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(botonAgregarVehiculo);
        container.add(botonRegistrarEmpresaServicios);
        container.add(botonRegistrarServicioMantenimiento);
        container.add(botonEditarVehiculo);
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonAgregarVehiculo.addActionListener(this);
        botonRegistrarEmpresaServicios.addActionListener(this);
        botonRegistrarServicioMantenimiento.addActionListener(this);
        botonEditarVehiculo.addActionListener(this);
        botonAtras.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrarServicioMantenimiento) {
            Inicio.VentanaAgregarServicio(true);
            Inicio.VentanaMenuAdministrador(false);
        }

        if (e.getSource() == botonRegistrarEmpresaServicios) {
            Inicio.VentanaAgregarEmpresa(true);
            Inicio.VentanaMenuAdministrador(false);
        }
        
        if (e.getSource() == botonAgregarVehiculo) {
            Inicio.VentanaAgregarVehiculo(true);
            Inicio.VentanaMenuAdministrador(false);
        }
        
        if (e.getSource()==botonEditarVehiculo){
            
            Inicio.VentanaEditarVehiculo(true);
            Inicio.VentanaMenuAdministrador(false);
        }
        
        if (e.getSource()==botonAtras){
            Inicio.VentanaMenuAdministrador(false);
            Inicio.VentanaMenuPrincipal(true);
        }
    }
 
}