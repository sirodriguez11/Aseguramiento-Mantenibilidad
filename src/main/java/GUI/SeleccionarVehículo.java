package GUI;


import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario seleccionar un automóvil para 
 * reservarlo
 * @since 26/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public final class SeleccionarVehículo extends JFrame implements ActionListener {
    String filename;
    String[] TiposLicencias = 
        {"", "A1","A2","A3","A4","B1","B2","B3","B4","C1","C2","D1","D2","D3","E1","E2"};
    String[] TiposCarros = 
        {"", "Compacto", "Pickup", "Intermedio", "SUV", "Mini-van", "Convertible", "Económico"};
    String[] VehículosCompacto={"", "Compacto1", "Compacto2"};
    String[] VehículosPickup={"", "Pickup1", "Pickup2"};
    String[] VehículosIntermedio={"", "Intermedio1", "Intermedio2"};
    String[] VehículosSUV={"", "SUV1", "SUV2"};
    String[] VehículosMinivan={"", "Mini-van1", "Mini-van2"};
    String[] VehículosConvertible={"", "Convertible1", "Convertible2"};
    String[] VehículosEconómico={"", "Económico1", "Económico2"};
    
    
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JComboBox<TEstilo> ComboBoxTipoCarroSeleccionado = new JComboBox<>(Inicio.listaEstilos);
    JComboBox<Vehiculo> ComboBoxVehículoSeleccionado = new JComboBox<>();
    DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getListaVehiculos().toArray());
   
    
    JLabel TextoAñoSeleccionado = new JLabel("");

    JLabel TextoMarcaSeleccionado = new JLabel("");


    JLabel TextoNombreCompleto = new JLabel("Tipo Vehículo");
    JLabel TextoCédula = new JLabel("Vehículo Seleccionado");



    JLabel TextoCostoDiario =new JLabel("Costo Diario");

    JLabel TextoTipodeTransmisión =new JLabel("Transmisión");

    JLabel TextoTipoVehículoSeleccionado = new JLabel("");
    JLabel TextoVehiculoSeleccionado= new JLabel("");
    
    JLabel TextoCostoeleccionado = new JLabel("");

    JLabel TextoTipoTransimisionSeleccionado = new JLabel("");

    JLabel TextoPlacaSeleccionado = new JLabel("Sin placa");
    JLabel TextoImagenSeleccionado = new JLabel("");
     

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
    JButton botonDetallesVehiculo = new JButton("Ver más");
    JButton botonImagen = new JButton("");
 
 
 
    SeleccionarVehículo() {
        
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
        TextoCédula.setBounds(420, 100, 150, 30);
        ComboBoxTipoCarroSeleccionado.setBounds(150, 100, 200, 30);
        ComboBoxVehículoSeleccionado.setBounds(580, 100, 200, 30);
        
        int k = 40;
        
        TextoAñoSeleccionado.setBounds(450, 240-k, 200, 30); 
        TextoMarcaSeleccionado.setBounds(320, 240-k, 200, 30); 
        TextoImagenSeleccionado.setBounds(40, 200-k, 250, 200);
        botonImagen.setBounds(40, 230-k, 250, 140);
        botonAgregarOperador.setBounds(410, 140-k, 150, 30);
        TextoCostoDiario.setBounds(405, 220-k, 150, 30);
        TextoCostoeleccionado.setBounds(610, 240-k, 200, 30);
        TextoTipoTransimisionSeleccionado.setBounds(322, 280-k, 200, 30);
        botonAgregarOperador.setBounds(600, 320-k, 150, 30);
        botonAtras.setBounds(580,30,200, 30);
        botonDetallesVehiculo.setBounds(320,320-k, 150, 30);

    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        TextoMarcaSeleccionado.setFont(new java.awt.Font("Dialog", 1, 25));
        TextoAñoSeleccionado.setFont(new java.awt.Font("Dialog", 1, 25));
        TextoCostoeleccionado.setFont(new java.awt.Font("Dialog", 1, 25));
        
        botonImagen.setVisible(false);
        botonDetallesVehiculo.setVisible(false);
        botonAgregarOperador.setVisible(false);
        
        
        container.add(botonDetallesVehiculo);

        container.add(TextoCostoeleccionado);

        container.add(TextoTipoTransimisionSeleccionado);

        container.add(TextoImagenSeleccionado);
        container.add(botonImagen);
        container.add(botonAgregarOperador);


        container.add(TextoTipodeTransmisión);

        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoTipoVehículoSeleccionado);
        container.add(ComboBoxTipoCarroSeleccionado);
        container.add(ComboBoxVehículoSeleccionado);

        container.add(TextoMarcaSeleccionado);


        container.add(TextoVehiculoSeleccionado);
        container.add(botonAtras);
        ComboBoxVehículoSeleccionado.setEnabled(false);
    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        ComboBoxTipoCarroSeleccionado.addActionListener( this);
        ComboBoxVehículoSeleccionado.addActionListener(this);
        botonDetallesVehiculo.addActionListener(this);
        botonImagen.addActionListener(this);
        
    }
    
    /**
     *
     */
    public void vaciarCampos(){
        botonDetallesVehiculo.setVisible(false);
        botonAgregarOperador.setVisible(false);
        botonImagen.setVisible(false);
        TextoAñoSeleccionado.setText("");

        TextoMarcaSeleccionado.setText("");

        TextoCostoeleccionado.setText("");

        TextoTipoTransimisionSeleccionado.setText("");

        TextoImagenSeleccionado.setText("");

        TablaServiciosAsociados.LimpiarTabla();
        TextoImagenSeleccionado.setIcon(null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonDetallesVehiculo || e.getSource()==botonImagen){
            Inicio.adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");         
            Inicio.frameSeleccionadoVehículo.setEnabled(false);
            Inicio.VentanaDetallesVehículo(true);
        }
        if (e.getSource()==botonAtras){
            vaciarCampos();
            ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
            Inicio.frameRealizarReserva.setEnabled(true);
            Inicio.VentanaSeleccionadoVehículo(false);
          
        }
        if (e.getSource()==botonAgregarOperador){
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            
            if (ComboBoxTipoCarroSeleccionado.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo");
            
            } else if(Auto.getEstado().equals(TEstado.Inactivo)){
                JOptionPane.showMessageDialog(this, "Este vehículo se encuentra inactivo");
            }else {
                JOptionPane.showMessageDialog(this, "Se ha seleccionado un vehículo");
                RealizarReserva.AutoSeleccionado = 
                        (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
                RealizarReserva.TextoPlacaSeleccionada.setText(TextoPlacaSeleccionado.getText());
                ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
                Inicio.frameRealizarReserva.setEnabled(true);
                Inicio.VentanaSeleccionadoVehículo(false);   
                
            }

        }
        

        if(e.getSource()==ComboBoxTipoCarroSeleccionado){
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            JComboBox cb=(JComboBox)e.getSource();

            if((TEstilo)cb.getSelectedItem()==null){       
                vaciarCampos();
                ComboBoxVehículoSeleccionado.setEnabled(false); 
                DefaultComboBoxModel mod= new DefaultComboBoxModel();
                ComboBoxVehículoSeleccionado.setModel(mod);
            }else{
                ComboBoxVehículoSeleccionado.setEnabled(true);
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                System.out.println(ComboBoxTipoCarroSeleccionado.getSelectedItem());
                DefaultComboBoxModel mod = 
                        new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo
                            ((TEstilo)ComboBoxTipoCarroSeleccionado.getSelectedItem(), 
                                    GUI.RealizarReserva.TextFieldFechaInicio.getCalendar(), 
                                        GUI.RealizarReserva.TextFieldFechaFinalizacion.getCalendar(), 
                                            true).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            
            
        }
        if(e.getSource()==ComboBoxVehículoSeleccionado){
            JComboBox cb=(JComboBox)e.getSource();
                TextoVehiculoSeleccionado.setVisible(false);
                Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
                botonDetallesVehiculo.setVisible(false);
            if(cb.getSelectedItem() instanceof Vehiculo){
                botonDetallesVehiculo.setVisible(true);
                botonAgregarOperador.setVisible(true);
                botonImagen.setVisible(true);
                TextoMarcaSeleccionado.setText(Auto.getMarca()+" "+String.valueOf(Auto.getAñoFabricacion()));
                TextoTipoTransimisionSeleccionado.setText("Transmisión  "+Auto.getTipoTransmision().toString());
                TextoCostoeleccionado.setText(String.valueOf("₡"+Auto.getCostoDiario())+"/d");
                TextoPlacaSeleccionado.setText(Auto.getPlaca());
                ImageIcon imagenSeleccionada = new ImageIcon(Auto.getImagen());
                TextoImagenSeleccionado.setIcon(imagenSeleccionada);
                Image imagenSinEscala = imagenSeleccionada.getImage();
                Image imagenEscalada = imagenSinEscala.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
                imagenSeleccionada.setImage(imagenEscalada);
                TextoImagenSeleccionado.setIcon(imagenSeleccionada);
                TextoImagenSeleccionado.setText("Sin fotografía");
                
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
                Detalles.TextoVinSeleccionado.setText(Auto.getNumeroVin());
                
                imagenSeleccionada = new ImageIcon(Auto.getImagen());
                Detalles.TextoImagenSeleccionado.setIcon(imagenSeleccionada);
                imagenSinEscala = imagenSeleccionada.getImage();
                imagenEscalada = imagenSinEscala.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
                imagenSeleccionada.setImage(imagenEscalada);
                Detalles.TextoImagenSeleccionado.setIcon(imagenSeleccionada);
                Detalles.TextoImagenSeleccionado.setText("Sin fotografía");
                
                Object[] filas= {};
                filas = Auto.getListaServiciosRelacionados().toArray();
                System.out.println(Auto.getListaServiciosRelacionados());
                TablaServiciosAsociados.ModificarTablaServiciosAsociados(filas);
                
            }else{       
                vaciarCampos();
            }
        }
        
    }
 
}