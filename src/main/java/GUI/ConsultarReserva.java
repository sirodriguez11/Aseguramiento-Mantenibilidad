package GUI;

import Controlador.Utilitaria;
import Modelo.Cliente;
import Modelo.Reserva;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;

/**
 * Esta clase hereda de JFrame, despliega los datos de la reserva desplegando una ventana
 * @since 27/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 */

public final class ConsultarReserva extends JFrame implements ActionListener {
    String[] Operadores = {"", "Operador1", "Operador2"};
    String [] SedesTotales = {"","Zapote","Cartago"};
    Container container = getContentPane();
    
    final JFrame frame = new JFrame();
        
    
    JButton TextFieldRecogida = new JButton("Ir a filtro");
    JButton TextFieldVehiculo = new JButton("Ir a filtro");
    JTextField TextFieldIDReserva = new JTextField();
    
    JButton TextFieldInicioReserva= new JButton("Ir a filtro");
    JButton TextFieldOperadores = new JButton("Ir a filtro");
    
    JLabel TextoFiltro = new JLabel("Filtro:");
    JLabel TextoPuntoRecogida = new JLabel("Punto de recogida del vehículo");
    JLabel TextoPlacaVehiculo = new JLabel("Placa del vehículo");
    JLabel TextoInicioReserva = new JLabel("Fecha de inicio de la reserva");
    JLabel TextoOperadorRealizador = new JLabel("Operador que realizó la reserva");
    JLabel TextoIDReserva = new JLabel("ID de reserva");
    
    JLabel TextoSedeRecogida = new JLabel ("");
    JLabel TextoOperadorSeleccionado=new JLabel("");
    
    JButton botonAtras = new JButton("Atrás");
    JButton botonConsultarReserva = new JButton("Consultar");
 
 
 
    ConsultarReserva() {
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
        int k = 90;
        int t = 50;
        
        TextoFiltro.setBounds(40+k, 20+t, 200, 30);
        TextoIDReserva.setBounds(40+k, 60+t, 200, 30);
        TextoPuntoRecogida.setBounds(40+k, 100+t, 200, 30);
        TextoPlacaVehiculo.setBounds(40+k, 140+t, 200, 30);
        TextoInicioReserva.setBounds(40+k, 180+t, 200, 30);
        TextoOperadorRealizador.setBounds(40+k, 220+t, 200, 30);
        
        TextFieldIDReserva.setBounds((325-150/2)+k, 60+t, 150, 30);
        TextFieldRecogida.setBounds((325-150/2)+k, 100+t, 150, 30);
        TextFieldVehiculo.setBounds((325-150/2)+k, 140+t, 150, 30);
        TextFieldInicioReserva.setBounds((325-150/2)+k, 180+t, 150, 30); 
        TextFieldOperadores.setBounds((325-150/2)+k, 220+t, 150, 30); 
        
        botonConsultarReserva.setBounds((325-150/2), 350, 150, 30);
        botonAtras.setBounds((325-150/2)+k, 30, 150, 30);
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(TextoFiltro);
        container.add(TextoIDReserva);
        container.add(TextFieldIDReserva);
        container.add(botonConsultarReserva);
        container.add(TextoPuntoRecogida);
        container.add(TextoPlacaVehiculo);
        container.add(TextoInicioReserva);
        container.add(TextoOperadorRealizador);
        container.add(TextoSedeRecogida);
        container.add(TextFieldRecogida);
        container.add(TextFieldVehiculo);
        container.add(TextFieldInicioReserva);
        container.add(TextFieldOperadores);
        container.add(TextoOperadorSeleccionado);
        
        container.add(botonAtras);

    }
    
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonConsultarReserva.addActionListener(this);
        TextFieldRecogida.addActionListener(this);
        TextFieldOperadores.addActionListener(this);
        TextFieldVehiculo.addActionListener(this);
        TextFieldIDReserva.addActionListener(this);
        TextFieldInicioReserva.addActionListener(this);

    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==botonAtras){

            TextoOperadorSeleccionado.setText("No se ha seleccionado Cliente");
            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaConsultarReserva(false);
         
        }
        if(e.getSource()==TextFieldOperadores){
            FiltroOperador.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldRecogida){
            FiltroPuntoRecogida.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldVehiculo){
            FiltroPlaca.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldInicioReserva){
            FiltroFecha.frameRegistrarOperador.setVisible(true);
                FiltroFecha.frameRegistrarOperador.setLocation(GUI.Inicio.dim.width/2-
                        FiltroFecha.frameRegistrarOperador.getSize().width/2, 
                            GUI.Inicio.dim.height/2-
                                    FiltroFecha.frameRegistrarOperador.getSize().height/2);
        
        }
        
        if (e.getSource()==botonConsultarReserva){
            if (TextFieldIDReserva.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");

                }
            try{
                Reserva Resultado = Inicio.adminApp.obtenerReserva(Integer.parseInt(TextFieldIDReserva.getText()));

                if (Resultado!=null){
                    try{
                        Inicio.frameRes.ContenidoTextoID.setText(Integer.toString(Resultado.getNumeroFactura()));
                    }catch(Exception error){
                        JOptionPane.showMessageDialog(this, "Error, el número de factura no puede llevar caracteres alfabéticos");
                    }
                    
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                    DatosCliente.frameDatosCliente.setLocation(dim.width/2-
                            DatosCliente.frameDatosCliente.getSize().width/2, 
                                dim.height/2-DatosCliente.frameDatosCliente.getSize().height/2);

                    Inicio.VentanaConsultarReserva(false); 
                    
                    Inicio.VentanaReserva(true);
                    
                    Inicio.frameRes.ContenidoTextoID.setText(String.valueOf(Resultado.getNumeroFactura()));
                    Inicio.frameRes.ContenidoTextoRecogida.setText(Resultado.getSedeRecogida());
                    Inicio.frameRes.ContenidoTextoEntrega.setText(Resultado.getSedeEntrega());
                    Inicio.frameRes.ContenidoTextoInicio.setText(Resultado.getFechaInicio().get(Calendar.DAY_OF_MONTH)
                            + "/" + (Resultado.getFechaInicio().get(Calendar.MONTH)+1) + "/" + 
                                Resultado.getFechaInicio().get(Calendar.YEAR));
                    Inicio.frameRes.ContenidoTextoFinal.setText(Resultado.getFechaFinalizacion().get(Calendar.DAY_OF_MONTH)
                            + "/" + (Resultado.getFechaFinalizacion().get(Calendar.MONTH)+1) + 
                                "/" + Resultado.getFechaFinalizacion().get(Calendar.YEAR));
                    Inicio.frameRes.ContenidoTextoSolicitud.setText(Resultado.getFechaSolicitud().get(Calendar.DAY_OF_MONTH) 
                            + "/" + (Resultado.getFechaSolicitud().get(Calendar.MONTH)+1) + 
                                "/" + Resultado.getFechaSolicitud().get(Calendar.YEAR));
                    Inicio.frameRes.ContenidoTextoOperador.setText(Resultado.getOperador().toString());
                    Vehiculo Auto = Resultado.getVehiculoSeleccionado();
                    Cliente Persona = Resultado.getClienteRelacionado();
                    Inicio.frameRes.ContenidoTextoCliente.setText(Resultado.getClienteRelacionado().toString());
                    TablaServiciosReserva.frameTablaServiciosPorReserva.agregarServicios(Resultado.getArrayServicios());
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
                            " ("+Persona.getTipoLicencia() +") " + "("+ Utilitaria.formatoFecha
                                (Persona.getFechaEmisionLicencia()) + " - " + 
                                       Utilitaria.formatoFecha(Persona.getFechaExpiracionLicencia()) +")");
                    
                    imagenSeleccionada = new ImageIcon(Persona.getImagen());
                    DatosCliente.frameDatosCliente.img2.setIcon(imagenSeleccionada);
                    imagenSinEscala = imagenSeleccionada.getImage();
                    imagenEscalada = imagenSinEscala.getScaledInstance(160, 90, Image.SCALE_SMOOTH);
                    imagenSeleccionada.setImage(imagenEscalada);
                    DatosCliente.frameDatosCliente.img2.setIcon(imagenSeleccionada);
                    DatosCliente.frameDatosCliente.img2.setText("Sin fotografía");

                    
                }else{
                    JOptionPane.showMessageDialog(this, "No existe una reserva con esa factura");
                    TextFieldIDReserva.setText("");
                }

            } catch (Exception error){
                JOptionPane.showMessageDialog(this, "Error, el número de factura no puede llevar "
                        + "caracteres alfabéticos");
            }
        }
        
        
        
    }
 
}