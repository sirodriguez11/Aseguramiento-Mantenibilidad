package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
 
/**
 * Esta clase hereda de JFrame, despliega los datos de un cliente en una ventana
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */

public final class Detalles extends JFrame implements ActionListener {
    String filename;
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getListaVehiculos().toArray());
   

    public static JLabel TextoPlacaSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoAñoSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoColorSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoMarcaSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoKilometrajeSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoKCapacidadSeleccionado= new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoPuertasSeleccionado= new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoDirección = new JLabel("Placa");
    public static JLabel TextoCorreo = new JLabel("Año de Fabricación");
    public static JLabel TextoTeléfono = new JLabel("Color");
    public static JLabel TextoNumeroLicencia = new JLabel("Marca");
    public static JLabel TextoFechaEmisionLicencia = new JLabel("Capacidad Personas");
    public static JLabel TextoTipoLicencia = new JLabel("Kilometraje");
    public static JLabel TextoFechaExpiracionLicencia = new JLabel("Numero de Puertas");
    public static JLabel TextoImágen = new JLabel("Numero Vin");
    public static JLabel TextoURL =new JLabel("MPG");
    public static JLabel TextoSede =new JLabel("Sede");
    public static JLabel TextoCostoDiario =new JLabel("Costo Diario");
    public static JLabel TextoCapacidaddeMaletas =new JLabel("Capacidad de Maletas");
    public static JLabel TextoTipodeTransmisión =new JLabel("Tipo de Transmisión");
    public static JLabel TextoEstado =new JLabel("Estado");
    public static JLabel TextoListadeServicios =new JLabel("Lista de Servicios");
    public static JLabel TextoImagen =new JLabel("Imagen");
    public static JLabel TextoTL=new JLabel("");
    public static JLabel TextoTipoVehículoSeleccionado = new JLabel("");
    public static JLabel TextoVehiculoSeleccionado= new JLabel("");
    public static JLabel TextoMPGSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoSedeSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoCostoeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoCapacidadSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoTipoTransimisionSeleccionado = 
            new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoEstadoSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JButton botonVerServicios = new JButton("Ver");
    public static JLabel TextoImagenSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JLabel TextoVinSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    public static JButton botonAtras = new JButton("Atrás");
 
 
 
    Detalles() {
        
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
        int k = -50;
        TextoDirección.setBounds(40, 180+k, 150, 30);
        TextoCorreo.setBounds(40, 220+k, 150, 30);
        TextoTeléfono.setBounds(40, 260+k, 150, 30);
        TextoNumeroLicencia.setBounds(40, 300+k, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 340+k, 150, 30);
        TextoTipoLicencia.setBounds(40, 380+k, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420+k, 150, 30);
        TextoImágen.setBounds(40, 460+k, 150, 30);
        TextoURL.setBounds(40, 500+k, 300, 30);
        TextoTL.setBounds(120, 380+k, 150, 30);
        TextoPlacaSeleccionado.setBounds(200, 180+k, 200, 30); 
        TextoAñoSeleccionado.setBounds(200, 220+k, 200, 30); 
        TextoColorSeleccionado.setBounds(200, 260+k, 200, 30); 
        TextoMarcaSeleccionado.setBounds(200, 300+k, 200, 30); 
        TextoKCapacidadSeleccionado.setBounds(200, 340+k, 200, 30); 
        TextoKilometrajeSeleccionado.setBounds(200, 380+k, 200, 30); 
        TextoPuertasSeleccionado.setBounds(200, 420+k, 200, 30); 
        TextoVinSeleccionado.setBounds(200, 460+k, 200, 30);   
        TextoSede.setBounds(410, 180+k, 150, 30);
        TextoCostoDiario.setBounds(410, 220+k, 150, 30);
        TextoCapacidaddeMaletas.setBounds(410, 260+k, 150, 30);
        TextoTipodeTransmisión.setBounds(410, 300+k, 150, 30);
        TextoEstado.setBounds(410, 340+k, 150, 30);
        TextoListadeServicios.setBounds(410, 380+k, 150, 30);
        TextoImagen.setBounds(410, 420+k, 150, 30);       
        TextoMPGSeleccionado.setBounds(200, 500+k, 200, 30);
        TextoSedeSeleccionado.setBounds(570, 180+k, 200, 30);
        TextoCostoeleccionado.setBounds(570, 220+k, 200, 30);
        TextoCapacidadSeleccionado.setBounds(570, 260+k, 200, 30);
        TextoTipoTransimisionSeleccionado.setBounds(570, 300+k, 200, 30);
        TextoEstadoSeleccionado.setBounds(570, 340+k, 200, 30);
        botonVerServicios.setBounds(570, 380+k, 200, 30);
        TextoImagenSeleccionado.setBounds(530, 410+k, 250, 200);
        botonAtras.setBounds(570,30, 200, 30);

    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        container.add(TextoMPGSeleccionado);
        container.add(TextoSedeSeleccionado);
        container.add(TextoCostoeleccionado);
        container.add(TextoCapacidadSeleccionado);
        container.add(TextoTipoTransimisionSeleccionado);
        container.add(TextoEstadoSeleccionado);
        container.add(botonVerServicios);
        container.add(TextoImagenSeleccionado);
        container.add(TextoSede);
        container.add(TextoCostoDiario);
        container.add(TextoCapacidaddeMaletas);
        container.add(TextoTipodeTransmisión);
        container.add(TextoEstado);
        container.add(TextoListadeServicios);
        container.add(TextoImagen);
        container.add(TextoDirección);
        container.add(TextoCorreo);
        container.add(TextoTeléfono);
        container.add(TextoNumeroLicencia);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoImágen);
        container.add(TextoTipoVehículoSeleccionado);

        container.add(TextoPlacaSeleccionado);
        container.add(TextoAñoSeleccionado);
        container.add(TextoColorSeleccionado);
        container.add(TextoMarcaSeleccionado);
        container.add(TextoKCapacidadSeleccionado);
        container.add(TextoKilometrajeSeleccionado);
        container.add(TextoPuertasSeleccionado);
        container.add(TextoVinSeleccionado);
        container.add(TextoURL);
        container.add(TextoTL);
        container.add(TextoVehiculoSeleccionado);
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonVerServicios.addActionListener(this);
        
    }
    
    /**
     *
     */
    public void vaciarCampos(){
        TextoPlacaSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoAñoSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoColorSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoMarcaSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoKilometrajeSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoKCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoPuertasSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoMPGSeleccionado.setText("No se ha seleccionado Vehículo"); 
        TextoSedeSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoCostoeleccionado.setText("No se ha seleccionado Vehículo");
        TextoCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoTipoTransimisionSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoEstadoSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoImagenSeleccionado.setText("No se ha seleccionado Vehículo");
        TextoVinSeleccionado.setText("No se ha seleccionado Vehículo");
        TablaServiciosAsociados.LimpiarTabla();
        TextoImagenSeleccionado.setIcon(null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==botonAtras){
            Inicio.frameSeleccionadoVehículo.setEnabled(true);
            Inicio.VentanaDetallesVehículo(false);
        }
        
        if(e.getSource()==botonVerServicios){
            
            Inicio.frameSeleccionadoVehículo.setEnabled(false);
            TablaServiciosAsociados.correrVentanilla();
        }

    }
 
}