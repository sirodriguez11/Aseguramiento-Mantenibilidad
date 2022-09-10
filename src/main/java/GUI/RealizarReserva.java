package GUI;

import Controlador.Utilitaria;
import Modelo.Cliente;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario realizar reservas
 * @since 25/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public final class RealizarReserva extends JFrame implements ActionListener {

    /**
     *
     */
    static public Cliente clienteRelacionado;
    
    Container container = getContentPane();
    
    /**
     *
     */
    static public ArrayList<String> ServiciosOpcionales = new ArrayList<String>();
        
    static Vehiculo AutoSeleccionado;
    
    Cliente [] ListaClientes = {};
    
    /**
     *
     */
    static public JComboBox<String> TextFieldSedeRecogida = new JComboBox<>(Inicio.listaSedes);

    /**
     *
     */
    static public JComboBox<String> TextFieldSedeEntrega = new JComboBox<>(Inicio.listaSedes);

    /**
     *
     */
    static public com.toedter.calendar.JDateChooser TextFieldFechaInicio= 
            new com.toedter.calendar.JDateChooser();

    /**
     *
     */
    static public com.toedter.calendar.JDateChooser TextFieldFechaFinalizacion= 
            new com.toedter.calendar.JDateChooser();

    /**
     *
     */
    static public JTextField TextFieldBuscarCliente = new JTextField();
    
    JButton botonSeleccionarvehiculo= new JButton("Seleccionar");
    
    /**
     *
     */
    static public JCheckBox SO1= new JCheckBox();

    /**
     *
     */
    static public JCheckBox SO2= new JCheckBox();

    /**
     *
     */
    static public JCheckBox SO3= new JCheckBox();

    /**
     *
     */
    static public JCheckBox SO4= new JCheckBox();

    /**
     *
     */
    static public JCheckBox SO5= new JCheckBox();
    
    JLabel TextoNombreCompleto = new JLabel("Sede Recogida");
    JLabel TextoCédula = new JLabel("Sede Entrega");
    JLabel TextoDirección = new JLabel("Fecha Inicio");
    JLabel TextoCorreo = new JLabel("Fecha Finalización");
    JLabel TextoFechaEmisionLicencia = new JLabel("Vehículo Seleccionado");
    JLabel TextoTipoLicencia = new JLabel("Cliente Relacionado");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Servicios Opcionales");
    JLabel TextoSedeRecogida = new JLabel ("");
    JLabel TextoSedeEntrega = new JLabel("");
    
    static public JLabel TextoNombreCliente = new JLabel("Nombre del cliente");
    static public JLabel TextoCedulaCliente = new JLabel("Cédula del cliente");
    static public JLabel TextoLicencia = new JLabel("Datos de la licencia del cliente");
    static public JLabel TextoCorreoCliente = new JLabel("Correo del cliente");
    static public JLabel TextoDireccionCliente = new JLabel("Dirección del cliente");
    static public JLabel TextoSO1=new JLabel("Wifi Ilimitado");
    static public JLabel TextoSO2=new JLabel("Asistencia carretera");
    static public JLabel TextoSO3=new JLabel("GPS");
    static public JLabel TextoSO4=new JLabel("Asiento niño ");
    static public JLabel TextoSO5=new JLabel("Seguro");
    static public JLabel TextoPlaca=new JLabel("Placa Vehículo Seleccionado:");
    static public JLabel TextoPlacaSeleccionada=new JLabel("No se ha seleccionado el vehículo");
    static public JLabel TextoClienteSeleccionar = new JLabel("Cliente seleccionado:");
    static public JLabel TextoTL=new JLabel("No se ha seleccionado Cliente");

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Revisar Reserva");
    JButton botonBuscarCliente = new JButton("Buscar");
    
    JPanel rectangle = new JPanel();
    Color color = new Color(58, 58, 58);
    
    ImageIcon img = new ImageIcon("");
    JLabel img2 = new JLabel(img);
    
    Image yourImage = img.getImage();
    Image newImage = yourImage.getScaledInstance(190, 120, Image.SCALE_SMOOTH);
 
    RealizarReserva() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        img2.setText("Licencia del Cliente");
 
    }
 
    /**
     *
     */
    public void setLayoutManager() {
        container.setLayout(null);
        rectangle.setBackground(color);
    }
 
    /**
     *
     */
    public void setLocationAndSize() {
        int k= 40;
        TextoNombreCompleto.setBounds(40, 100+k, 150, 30);
        TextoCédula.setBounds(40, 140+k, 150, 30);
        TextoDirección.setBounds(40, 180+k, 150, 30);
        TextoCorreo.setBounds(40, 220+k, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 260+k, 150, 30);
        TextoPlaca.setBounds(40, 300+k, 200, 30);
        
        TextoFechaExpiracionLicencia.setBounds(40, 420+k, 150, 30);
        TextoSedeRecogida.setBounds(370, 100, 150, 30);

        
        TextoTipoLicencia.setBounds(40, 100, 150, 30);
        
        TextoSedeEntrega.setBounds(370, 140+k, 150, 30);
        
        TextFieldSedeRecogida.setBounds((325-150/2), 100+k, 150, 30);
        TextFieldSedeEntrega.setBounds((325-150/2), 140+k, 150, 30);
        TextFieldFechaInicio.setBounds((325-150/2), 180+k, 150, 30); 
        TextFieldFechaFinalizacion.setBounds((325-150/2), 220+k, 150, 30); 
        botonSeleccionarvehiculo.setBounds((325-150/2), 260+k, 150, 30); 
        TextoPlacaSeleccionada.setBounds((325-150/2), 300+k, 250, 30);
        
        
        TextFieldBuscarCliente.setBounds((325-150/2), 100, 150, 30); 
        botonBuscarCliente.setBounds((325-150/2)+175, 100, 100, 30); 
        
        rectangle.setBounds((325-150/2)+175, 140, 500, 200); 
        
        TextoNombreCliente.setBounds((325-150/2)+185, 140, 250, 30); 
        TextoCedulaCliente.setBounds((325-150/2)+185, 180, 250, 30); 
        TextoCorreoCliente.setBounds((325-150/2)+185, 220, 250, 30); 
        TextoDireccionCliente.setBounds((325-150/2)+185, 260, 250, 30); 
        TextoLicencia.setBounds((325-150/2)+185, 300, 250, 30); 
        
        img2.setBounds(700, 160, 210, 150);
        
        SO1.setBounds(370, 420, 20, 30);
        SO2.setBounds(370, 460, 20, 30);
        SO3.setBounds(370, 500, 20, 30);
        SO4.setBounds(370+160, 420, 20, 30);
        SO5.setBounds(370+160, 460, 20, 30);
        
        TextoSO1.setBounds(200, 420, 150, 30);
        TextoSO2.setBounds(200, 460, 150, 30);
        TextoSO3.setBounds(200, 500, 150, 30);
        TextoSO4.setBounds(420, 420, 150, 30);
        TextoSO5.setBounds(420, 460, 150, 30);
        
        botonAgregarOperador.setBounds(700, 460, 210, 30);
        botonAtras.setBounds(700, 30, 210, 30);

    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        container.add(TextoNombreCliente);
        container.add(TextoCedulaCliente);
        container.add(TextoLicencia);
        container.add(TextoCorreoCliente);
        container.add(TextoDireccionCliente);
        container.add(img2);
        container.add(rectangle);
        container.add(botonAgregarOperador);
        container.add(botonBuscarCliente);
        container.add(TextoSO1);
        container.add(TextoSO2);
        container.add(TextoSO3);
        container.add(TextoSO4);
        container.add(TextoSO5);
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoDirección);
        container.add(TextoCorreo);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoSedeRecogida);
        container.add(TextoSedeEntrega);
        container.add(TextFieldSedeRecogida);
        container.add(TextFieldSedeEntrega);
        container.add(TextFieldFechaInicio);
        container.add(TextFieldFechaFinalizacion);
        container.add(botonSeleccionarvehiculo);
        container.add(TextFieldBuscarCliente);
        container.add(SO1);
        container.add(SO2);
        container.add(SO3);
        container.add(SO4);
        container.add(SO5);
        container.add(TextoTL);
        container.add(botonAtras);
        container.add(TextoPlaca);
        container.add(TextoPlacaSeleccionada);
        container.add(TextoClienteSeleccionar);
    }
 
    /**
     *
     */
    public void addActionEvent() {
        
        botonBuscarCliente.addActionListener(this);
        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        TextFieldSedeRecogida.addActionListener(this);
        TextFieldBuscarCliente.addActionListener(this);
        TextFieldSedeEntrega.addActionListener(this);
        botonSeleccionarvehiculo.addActionListener(this);
        
    }
 
    /**
     * Este método limpia los campos de texto para un nuevo uso
     */
    public void limpiarDatosCliente(){
        ImageIcon imagenSeleccionada = new ImageIcon("");
        img2.setIcon(imagenSeleccionada);
        TextoNombreCliente.setText("Nombre del cliente");
        TextoCedulaCliente.setText("Cédula del cliente");
        TextoLicencia.setText("Datos de la licencia del cliente");
        TextoCorreoCliente.setText("Correo del cliente");
        TextoDireccionCliente.setText("Dirección del cliente");
        img2.setText("Licencia del cliente");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonBuscarCliente){
            if (!"".equals(TextFieldBuscarCliente.getText())) {
                if (Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText())!=null) {
                    
                    clienteRelacionado = Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText());
                    System.out.println(clienteRelacionado);
                    TextoNombreCliente.setText(clienteRelacionado.getNombreCompleto());
                    TextoCedulaCliente.setText("Cédula: "+clienteRelacionado.getCedula());
                    TextoLicencia.setText("Licencia " + clienteRelacionado.getNumeroLicencia() + 
                            " ("+clienteRelacionado.getTipoLicencia() +") " + "("+ 
                                Utilitaria.formatoFecha(clienteRelacionado.getFechaEmisionLicencia()) 
                                    + " - " + Utilitaria.formatoFecha(clienteRelacionado.getFechaExpiracionLicencia()) +")");
                    TextoCorreoCliente.setText("Correo: " + clienteRelacionado.getCorreoElectronico());
                    TextoDireccionCliente.setText("Dirección: "+clienteRelacionado.getDireccionExacta());
                    
                    ImageIcon imagenSeleccionada = new ImageIcon(clienteRelacionado.getImagen());
                    img2.setIcon(imagenSeleccionada);
                    Image imagenSinEscala = imagenSeleccionada.getImage();
                    Image imagenEscalada = imagenSinEscala.getScaledInstance(190, 120, Image.SCALE_SMOOTH);
                    imagenSeleccionada.setImage(imagenEscalada);
                    img2.setIcon(imagenSeleccionada);
                    img2.setText("");
                    
                }else{
                    JOptionPane.showMessageDialog(this, "No se encontró el cliente solicitado");
                    limpiarDatosCliente();
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese una identificación para buscar un cliente");
                
                limpiarDatosCliente();
            }
            
          
        }
        if (e.getSource()==botonAtras){
            TextFieldSedeRecogida.setSelectedIndex(0);
            TextFieldSedeEntrega.setSelectedIndex(0);
            TextFieldFechaInicio.setDate(null);
            TextFieldFechaFinalizacion.setDate(null);
            
            TextFieldBuscarCliente.setText("");
            SO1.setSelected(false);
            SO2.setSelected(false);
            SO3.setSelected(false);
            SO4.setSelected(false);
            SO5.setSelected(false);
            TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
            TextoTL.setText("No se ha seleccionado Cliente");
            
            limpiarDatosCliente();
            
            
            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaRealizarReserva(false);
          
        }
        if (e.getSource()==botonAgregarOperador){

            String direccionTemporal;
            String correoTemporal;
            
            if(TextFieldFechaInicio.getCalendar()!=null){
               int año = TextFieldFechaInicio.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaInicio.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                direccionTemporal=dia+"/"+mes+"/"+año;
            }
            if(TextFieldFechaFinalizacion.getCalendar()!=null){
               int año = TextFieldFechaFinalizacion.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaFinalizacion.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaFinalizacion.getCalendar().get(Calendar.DAY_OF_MONTH);
                correoTemporal=dia+"/"+mes+"/"+año;
            }
       
            if (TextoPlacaSeleccionada.getText().equals("No se ha seleccionado el vehículo") || 
                    TextFieldSedeRecogida.getSelectedItem().equals(null) ||
                        TextFieldSedeEntrega.getSelectedItem().equals(null) ||TextFieldFechaInicio.getDate()==null ||
                            TextFieldFechaFinalizacion.getDate()==null || TextFieldBuscarCliente.getText().equals("") ||
                                clienteRelacionado == null ||TextoTL.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else if (TextFieldFechaInicio.getDate()==null || TextFieldFechaFinalizacion.getDate()==null){
                JOptionPane.showMessageDialog(this, "Ingrese fechas de inicio y finalización");
                
            }else if (TextFieldFechaInicio.getCalendar().compareTo(TextFieldFechaFinalizacion.getCalendar())==1){
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior o igual a la de finalización");
            
            }else {
                if(SO1.isSelected()){
                    ServiciosOpcionales.add("WiFi limitado");
                }if(SO2.isSelected()){
                    ServiciosOpcionales.add("Asistencia en carretera");
                }if(SO3.isSelected()){
                    ServiciosOpcionales.add("GPS");
                }if(SO4.isSelected()){
                    ServiciosOpcionales.add("Asiento para niño");
                }if (SO5.isSelected()){
                    ServiciosOpcionales.add("Cobertura por daños a terceros");
                }
                
            HashMap diccionario = Inicio.adminApp.generarServiciosEspeciales(ServiciosOpcionales);
            
            Set keys = diccionario.keySet();
            Object[][] O = new Object[][]{{"WiFi", keys.contains("WiFi limitado") ? "Sí" : "No"},
                {"GPS", keys.contains("GPS") ? "Sí" : "No"},
                    {"Seguro", keys.contains("Cobertura por daños a terceros") ? "Sí" : "No"},
                        {"Asistencia", keys.contains("Asistencia en carretera") ? "Sí" : "No"},
                            {"Asiento Niños", keys.contains("Asiento para niño") ? "Sí" : "No"}};
        
            Inicio.frameConfirmarReserva.ContenidoTextoID.setText(String.valueOf(Inicio.listaReservas.size()));
            
            Inicio.frameConfirmarReserva.ContenidoTextoRecogida.setText
                (TextFieldSedeRecogida.getSelectedItem().toString());
            Inicio.frameConfirmarReserva.ContenidoTextoEntrega.setText
                (TextFieldSedeEntrega.getSelectedItem().toString());
            Inicio.frameConfirmarReserva.ContenidoTextoInicio.setText
                (Utilitaria.formatoFecha(TextFieldFechaInicio.getCalendar()));
            Inicio.frameConfirmarReserva.ContenidoTextoFinal.setText
                (Utilitaria.formatoFecha(TextFieldFechaFinalizacion.getCalendar()));
            Inicio.frameConfirmarReserva.ContenidoTextoSolicitud.setText
                (Utilitaria.formatoFecha(Calendar.getInstance()));
            Inicio.frameConfirmarReserva.ContenidoTextoOperador.setText
                (Inicio.adminApp.getOperadorActivo().toString());
            
            Vehiculo Auto = Inicio.adminApp.obtenerVehiculo(TextoPlacaSeleccionada.getText());
            Cliente Persona = Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText());
            
            Inicio.frameConfirmarReserva.ContenidoTextoCliente.setText(
                    Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText()).toString());
            TablaServiciosReserva.frameTablaServiciosPorReserva.agregarServicios(O);
            Detalles.TextoPlacaSeleccionado.setText(Auto.getPlaca());
            Detalles.TextoAñoSeleccionado.setText(String.valueOf(Auto.getAñoFabricacion()));
            Detalles.TextoColorSeleccionado.setText(Auto.getColor());
            Detalles.TextoMarcaSeleccionado.setText(Auto.getMarca());
            Detalles.TextoKilometrajeSeleccionado.setText(String.valueOf(Auto.getKilometraje()));
            Detalles.TextoKCapacidadSeleccionado.setText(String.valueOf(Auto.getCapacidad()));
            Detalles.TextoPuertasSeleccionado.setText(String.valueOf(Auto.getNumeroPuertas()));
            Detalles.TextoMPGSeleccionado.setText(String.valueOf(Auto.getMpg())); 
            Detalles.TextoSedeSeleccionado.setText(Auto.getSede());
            Detalles.TextoCostoeleccionado.setText(String.valueOf(Auto.getCostoDiario())+"/d");
            Detalles.TextoCapacidadSeleccionado.setText(String.valueOf(Auto.getCapacidad()));
            Detalles.TextoTipoTransimisionSeleccionado.setText(Auto.getTipoTransmision().toString());
            Detalles.TextoEstadoSeleccionado.setText(Auto.getEstado().toString());
            Detalles.TextoVinSeleccionado.setText(Auto.getNumeroVin().toString());

            ImageIcon imagenSeleccionada = new ImageIcon(Auto.getImagen());
            Detalles.TextoImagenSeleccionado.setIcon(imagenSeleccionada);
            Image imagenSinEscala = imagenSeleccionada.getImage();
            Image imagenEscalada = imagenSinEscala.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
            imagenSeleccionada.setImage(imagenEscalada);
            Detalles.TextoImagenSeleccionado.setIcon(imagenSeleccionada);
            Detalles.TextoImagenSeleccionado.setText("Sin fotografía");

            Object[] filas= {};
            filas = Auto.getListaServiciosRelacionados().toArray();
            System.out.println(Auto.getListaServiciosRelacionados());
            TablaServiciosAsociados.ModificarTablaServiciosAsociados(filas);

            DatosCliente.frameDatosCliente.textNombreCliente.setText("Nombre: "+Persona.getNombreCompleto());
            DatosCliente.frameDatosCliente.textCedula.setText("Cédula: "+Persona.getCedula());
            DatosCliente.frameDatosCliente.textoCorreo.setText("Correo: "+Persona.getCorreoElectronico());
            DatosCliente.frameDatosCliente.textoDireccion.setText("Correo: "+Persona.getDireccionExacta());
            DatosCliente.frameDatosCliente.textoLicencia.setText("Licencia: "+ Persona.getNumeroLicencia() + 
                    " ("+Persona.getTipoLicencia() +") " + "("+ 
                        Utilitaria.formatoFecha(Persona.getFechaEmisionLicencia()) + " - " + 
                            Utilitaria.formatoFecha(Persona.getFechaExpiracionLicencia()) +")");

            imagenSeleccionada = new ImageIcon(Persona.getImagen());
            DatosCliente.frameDatosCliente.img2.setIcon(imagenSeleccionada);
            imagenSinEscala = imagenSeleccionada.getImage();
            imagenEscalada = imagenSinEscala.getScaledInstance(160, 90, Image.SCALE_SMOOTH);
            imagenSeleccionada.setImage(imagenEscalada);
            DatosCliente.frameDatosCliente.img2.setIcon(imagenSeleccionada);
            DatosCliente.frameDatosCliente.img2.setText("Sin fotografía");
            
            Inicio.VentanaConfirmarReserva(true);
            Inicio.VentanaRealizarReserva(false);

            }
        }
        
        if(e.getSource()==TextFieldSedeRecogida){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeRecogida.setVisible(false);
            TextoSedeRecogida.setText((String)cb.getSelectedItem());
        }
        
        if(e.getSource()==TextFieldSedeEntrega){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeEntrega.setVisible(false);
            TextoSedeEntrega.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==botonSeleccionarvehiculo){
            if (TextFieldFechaInicio.getDate()==null || TextFieldFechaFinalizacion.getDate()==null){
                JOptionPane.showMessageDialog
                    (this, "Ingrese fechas de inicio y finalización para seleccionar un vehículo");
            }else if(TextFieldFechaInicio.getCalendar().compareTo(TextFieldFechaFinalizacion.getCalendar())==1){
                JOptionPane.showMessageDialog
                    (this, "La fecha de inicio debe ser anterior o igual a la de finalización");
            }else{
                Inicio.VentanaSeleccionadoVehículo(true);
                Inicio.frameRealizarReserva.setEnabled(false);
                
            }
        }
    }
}