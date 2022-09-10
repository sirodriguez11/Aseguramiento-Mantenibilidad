/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.Vehiculo;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario ver detalles de una reserva solo 
 * para verificar, no confirmar una reserva
 * @since 30/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public final class Reservas extends JFrame implements ActionListener {
    JScrollPane scroll = new JScrollPane();
    JLabel label = new JLabel();
    Container container = getContentPane();
    
    Vehiculo Auto;
    
    final JFileChooser explorer = new JFileChooser();
    
    JLabel ContenidoTextoRecogida = new JLabel();
    JLabel ContenidoTextoEntrega= new JLabel();
    JLabel ContenidoTextoInicio= new JLabel();
    JLabel ContenidoTextoFinal = new JLabel();
    JLabel ContenidoTextoSolicitud = new JLabel();
    JLabel ContenidoTextoOperador = new JLabel();
    JLabel ContenidoTextoVehiculo = new JLabel();
    JLabel ContenidoTextoCliente = new JLabel();
    JButton ContenidoTextoServicio = new JButton("Ver");  
    JButton DetallesVehiculo = new JButton("Ver");
    JButton DetallesCliente = new JButton("Ver");
    JLabel TextoID = new JLabel("Factura");
    JLabel ContenidoTextoID = new JLabel(); 
    JLabel TextoSedeRecogida = new JLabel("Sede de Recogida");
    JLabel TextoSedeEntrega = new JLabel("Sede de Entrega");
    JLabel TextoInicio = new JLabel("Fecha de Inicio");
    JLabel TextoFinalizacion = new JLabel("Fecha Final");
    JLabel TextoSolicitud = new JLabel("Fecha de Solicitud");
    JLabel TextoOperador = new JLabel("Operador");
    JLabel TextoVehiculo = new JLabel("Vehiculo Seleccionado");
    JLabel TextoCliente = new JLabel("Cliente Relacionado");
    JLabel TextoServicio = new JLabel("Servicios Opcionales");
    

    JButton botonAtras = new JButton("Atrás");
    JButton botonOk = new JButton("Ok");
 
    Reservas() {
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
        int k = 10;
        TextoID.setBounds(40, 50-k, 250, 30);
        TextoSedeRecogida.setBounds(40, 100-k, 150, 30);
        TextoSedeEntrega.setBounds(40, 140-k, 150, 30);
        TextoInicio.setBounds(40, 180-k, 150, 30);
        TextoFinalizacion.setBounds(40, 220-k, 150, 30);
        TextoSolicitud.setBounds(40, 260-k, 150, 30);
        TextoOperador.setBounds(40, 300-k, 150, 30);
        TextoVehiculo.setBounds(40, 340-k, 150, 30);  
        TextoCliente.setBounds(40, 380-k, 150, 30);  
        TextoServicio.setBounds(40, 420-k, 150, 30);
        
        DetallesVehiculo.setBounds(200, 340-k, 150, 30);
        DetallesCliente.setBounds(200, 380-k, 150, 30);
        
        
        ContenidoTextoID.setBounds(200, 50-k, 150, 30);
        ContenidoTextoRecogida.setBounds(200, 100-k, 150, 30);
        ContenidoTextoEntrega.setBounds(200, 140-k, 150, 30);
        ContenidoTextoInicio.setBounds(200, 180-k, 150, 30);
        ContenidoTextoFinal.setBounds(200, 220-k, 150, 30); 
        ContenidoTextoSolicitud.setBounds(200, 260-k, 150, 30); 
        ContenidoTextoOperador.setBounds(200, 300-k, 300, 30);
        ContenidoTextoVehiculo.setBounds(200, 340-k, 300, 30);
        ContenidoTextoCliente.setBounds(200, 380-k, 300, 30);
        ContenidoTextoServicio.setBounds(200, 420-k, 150, 30);
        
        botonOk.setBounds(220, 550-k, 150, 30);
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        TextoID.setFont(new java.awt.Font("Dialog", 1, 25));
        ContenidoTextoID.setFont(new java.awt.Font("Dialog", 1, 25));
        container.add(label);
        container.add(TextoID);
        container.add(ContenidoTextoID);
        container.add(botonOk);
        container.add(TextoSedeRecogida);
        container.add(TextoSedeEntrega);
        container.add(TextoInicio);
        container.add(TextoFinalizacion);
        container.add(TextoSolicitud);
        container.add(TextoOperador);
        container.add(TextoVehiculo);
        container.add(TextoCliente);  
        container.add(TextoServicio);  
        
        container.add(ContenidoTextoRecogida);
        container.add(ContenidoTextoFinal);
        container.add(ContenidoTextoSolicitud);
        container.add(DetallesVehiculo);
        container.add(ContenidoTextoOperador);
        container.add(ContenidoTextoEntrega);
        container.add(ContenidoTextoInicio);
        container.add(botonAtras);
        container.add(DetallesCliente);
        container.add(ContenidoTextoServicio);
        
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonOk.addActionListener(this);   
        DetallesVehiculo.addActionListener(this);  
        DetallesCliente.addActionListener(this);  
        ContenidoTextoServicio.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==DetallesVehiculo){
            
            Inicio.VentanaDetallesVehículo(true);

        }
        if (e.getSource()==DetallesCliente){
            
            DatosCliente.frameDatosCliente.setVisible(true);
            

        }
        
        if (e.getSource()==botonOk){
            ContenidoTextoID.setText("");
            ContenidoTextoRecogida.setText("");
            ContenidoTextoFinal.setText("");
            ContenidoTextoSolicitud.setText("");
            ContenidoTextoVehiculo.setText("");
            ContenidoTextoOperador.setText("");
            ContenidoTextoEntrega.setText("");
            ContenidoTextoInicio.setText("");

            Inicio.VentanaConsultarReserva(true);
            Inicio.VentanaReserva(false); 
          
        }
        if(e.getSource()==ContenidoTextoServicio){
            TablaServiciosReserva.frameTablaServiciosPorReserva.setVisible(true);
        }
            
        
       //Coding Part of showPassword JCheckBox
    }
}
