package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario acceder a las funciones del programa 
 * con botones
 * @since 22/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public class MenuPrincipal extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    
    JButton botonReserva = new JButton("Realizar Reserva");
    JButton botonConsultarReserva = new JButton("Consultar Reserva");
    JButton botonAdministracion = new JButton("Administración");
    JButton botonRegistrarCliente = new JButton("Registar Cliente");
    JButton botonRegistrarOperador = new JButton("Registar Operador");
    JButton botonCerrarSesion = new JButton("Salir de la sesión");
    
    static JLabel NombreUsuario = new JLabel("Usuario");
    
    JPanel rectangle = new JPanel();
    Color color = new Color(58, 58, 58); 
    
    ImageIcon icon = new ImageIcon("src\\main\\java\\img\\profile.png");
    JLabel Picture = new JLabel(icon);
    Image imagenSinResize = icon.getImage();
    Image ImagenFinal = imagenSinResize.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    
    ImageIcon icon2 = new ImageIcon("src\\main\\java\\img\\RR.jpg");
    JLabel Picture2 = new JLabel(icon2);

    
 
    MenuPrincipal() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        rectangle.setBackground(color);
        rectangle.setPreferredSize( new Dimension(50, 50) );
        
        icon = new ImageIcon(ImagenFinal);
        Picture.setIcon(icon);
        
 
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
        int k = -30;
        int ancho = 25;
        int alto =10;
        int SV =-5;
        NombreUsuario.setBounds(80, 15, 300, 35);
        botonReserva.setBounds((200-150/2)+k, 100+SV, 150+ancho, 30+alto);
        botonConsultarReserva.setBounds((200-150/2)+k, 160+SV, 150+ancho, 30+alto);
        botonAdministracion.setBounds((200-150/2)+k, 220+SV, 150+ancho, 30+alto);
        botonRegistrarCliente.setBounds((200-150/2)+k, 280+SV, 150+ancho, 30+alto);
        botonRegistrarOperador.setBounds((200-150/2)+k,340+SV,150+ancho,30+alto);
        botonCerrarSesion.setBounds(500,15, 150, 35);
        
        rectangle.setBounds(0,0, 800, 70);
        Picture.setBounds(15,10, 50, 50);
        Picture2.setBounds(325, 20, 400, 450);
        
        
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        NombreUsuario.setFont(new java.awt.Font("Dialog", 1, 19));
        container.add(NombreUsuario);
        container.add(botonReserva);
        container.add(botonConsultarReserva);
        container.add(botonAdministracion);
        container.add(botonRegistrarCliente);
        container.add(botonRegistrarOperador);
        container.add(botonCerrarSesion);
        container.add(Picture);
        container.add(Picture2);
        container.add(rectangle);
        
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonReserva.addActionListener(this);
        botonConsultarReserva.addActionListener(this);
        botonAdministracion.addActionListener(this);
        botonRegistrarCliente.addActionListener(this);
        botonRegistrarOperador.addActionListener(this);
        botonCerrarSesion.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReserva) {
            Inicio.VentanaRealizarReserva(true);
            Inicio.VentanaMenuPrincipal(false);
        }
        if (e.getSource() == botonConsultarReserva) {
            Inicio.VentanaConsultarReserva(true);
            Inicio.VentanaMenuPrincipal(false);
        }
        if (e.getSource() == botonAdministracion) {
            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaMenuPrincipal(false);
        }
        
        if (e.getSource()==botonRegistrarCliente){
            
            Inicio.VentanaRegistrarCliente(true);
            Inicio.VentanaMenuPrincipal(false);
        }
        
        if (e.getSource()==botonRegistrarOperador){
            
            Inicio.VentanaRegistrarOperador(true);
            Inicio.VentanaMenuPrincipal(false);
        }
        if (e.getSource()==botonCerrarSesion){
            Inicio.VentanaLogin(true);
            Inicio.VentanaMenuPrincipal(false);
            for (int i = 0; i < Inicio.listaOperadores.size(); i++) {
                if(Inicio.listaOperadores.get(i).isEstado()){
                    Inicio.listaOperadores.get(i).setEstado(false);
                }
            }
        }
    }
}