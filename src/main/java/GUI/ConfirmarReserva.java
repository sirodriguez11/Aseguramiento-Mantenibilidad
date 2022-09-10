/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.Vehiculo;

import com.itextpdf.text.DocumentException;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * Esta clase hereda de JFrame, despliega los datos de la reserva y permite al usuario 
 * confirmarla en una ventana
 * @since 28/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public final class ConfirmarReserva extends JFrame implements ActionListener {
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
    JButton botonOk = new JButton("Realizar Reserva");
 
    ConfirmarReserva() {
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
        botonAtras.setBounds(450, 50-k, 100, 30);
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
        
        if (e.getSource()==botonAtras){    
            Inicio.VentanaConfirmarReserva(false);
            Inicio.VentanaRealizarReserva(true);
              
        }
        
        if (e.getSource()==DetallesCliente){   
            DatosCliente.frameDatosCliente.setVisible(true);
        }
        
        if (e.getSource()==botonOk){
            
            if(GUI.RealizarReserva.SO1.isSelected()){
                GUI.RealizarReserva.ServiciosOpcionales.add("WiFi limitado");
            }if(GUI.RealizarReserva.SO2.isSelected()){
                GUI.RealizarReserva.ServiciosOpcionales.add("Asistencia en carretera");
            }if(GUI.RealizarReserva.SO3.isSelected()){
                GUI.RealizarReserva.ServiciosOpcionales.add("GPS");
            }if(GUI.RealizarReserva.SO4.isSelected()){
                GUI.RealizarReserva.ServiciosOpcionales.add("Asiento para niño");
            }if (GUI.RealizarReserva.SO5.isSelected()){
                GUI.RealizarReserva.ServiciosOpcionales.add("Cobertura por daños a terceros");
            }

            HashMap diccionario = Inicio.adminApp.generarServiciosEspeciales(GUI.RealizarReserva.ServiciosOpcionales);

            Inicio.adminApp.realizarReserva((String) GUI.RealizarReserva.TextFieldSedeRecogida.getSelectedItem(),
                (String) GUI.RealizarReserva.TextFieldSedeEntrega.getSelectedItem(), 
                    GUI.RealizarReserva.TextFieldFechaInicio.getCalendar(), 
                        GUI.RealizarReserva.TextFieldFechaFinalizacion.getCalendar(), 
                            Calendar.getInstance(), Inicio.adminApp.getOperadorActivo(), 
                                Inicio.adminApp.obtenerVehiculo(GUI.RealizarReserva.TextoPlacaSeleccionada.getText()), 
                                    GUI.RealizarReserva.clienteRelacionado, diccionario, false);
            
            try {
                String archivo;
                archivo = Inicio.adminApp.crearPDF(Inicio.adminApp.obtenerReserva(Inicio.listaReservas.size()-1));
                Controlador.EnviarEmail.enviarCorreo(Inicio.adminApp.obtenerCliente(GUI.RealizarReserva.
                        TextFieldBuscarCliente.getText()).getCorreoElectronico(), 
                            "Comprobante de Reserva - Rent A Car", "Gracias por reservar con nosotros!", archivo);
            } catch (DocumentException ex) {
                Logger.getLogger(ConfirmarReserva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConfirmarReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Se ha agregado una nueva Reserva");
            GUI.RealizarReserva.TextFieldSedeRecogida.setSelectedIndex(0);
            GUI.RealizarReserva.TextFieldSedeEntrega.setSelectedIndex(0);
            GUI.RealizarReserva.TextFieldFechaInicio.setDate(null);
            GUI.RealizarReserva.TextFieldFechaFinalizacion.setDate(null);

            GUI.RealizarReserva.TextFieldBuscarCliente.setText("");

            GUI.RealizarReserva.SO1.setSelected(false);
            GUI.RealizarReserva.SO2.setSelected(false);
            GUI.RealizarReserva.SO3.setSelected(false);
            GUI.RealizarReserva.SO4.setSelected(false);
            GUI.RealizarReserva.SO5.setSelected(false);

            GUI.RealizarReserva.TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
            GUI.RealizarReserva.TextoTL.setText("No se ha seleccionado Cliente");

            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaRealizarReserva(false); 
            Inicio.VentanaConfirmarReserva(false);
                
            
          
        }
        if(e.getSource()==ContenidoTextoServicio){
            TablaServiciosReserva.frameTablaServiciosPorReserva.setVisible(true);
        }
    }
}
