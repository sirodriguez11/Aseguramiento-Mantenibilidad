package GUI;

import Modelo.Servicio;
import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TTransmision;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase hereda de JFrame, permite al usuario agregar un nuevo vehículo a la flotilla desplegando una ventana
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, Silvia Melissa Rodríguez Fernández
 */

public final class AgregarVehiculo extends JFrame implements ActionListener {
    String filename = "Sin Fotografía";
    TEstilo[] TiposEstilos = {null, TEstilo.Compacto, TEstilo.PickUp, TEstilo.Intermedio, TEstilo.SUV, 
        TEstilo.MiniVan, TEstilo.Convertible, TEstilo.Económico};
    TTransmision[] TiposTransmision = {null, TTransmision.Automática, TTransmision.Manual};
    String[] TiposSedes = Inicio.listaSedes;
    
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldPlaca = new JTextField();
    JTextField TextFieldColor = new JTextField();
    JTextField TextFieldMarca = new JTextField();
    JTextField TextFieldCapacidad = new JTextField();
    JTextField TextFieldKilometraje = new JTextField();
    JTextField TextFieldCostoDiario = new JTextField();
    JTextField TextFieldCapacidadMaletas = new JTextField();
    JTextField TextFieldAño = new JTextField();
    
    JTextField TextFieldNumeroPuertas = new JTextField();
    JTextField TextFieldVin = new JTextField();
    JTextField TextFieldMPG = new JTextField();
    
    
    JComboBox<String> TextFieldSede = new JComboBox<>(TiposSedes);
    JComboBox<TEstilo> TextFieldEstilo = new JComboBox<>(TiposEstilos);
    JComboBox<TTransmision> TextFieldTransmision = new JComboBox<>(TiposTransmision);
    JButton TextFieldServicio = new JButton("Seleccionar");
   
    JLabel TextoPlaca = new JLabel("Placa");
    JLabel TextoEstilo = new JLabel("Estilo");
    JLabel TextoColor = new JLabel("Color");
    JLabel TextoMarca = new JLabel("Marca");
    JLabel TextoCapacidad = new JLabel("Capacidad");
    JLabel TextoKilometraje = new JLabel("Kilometraje");
    JLabel TextoNumeroPuertas = new JLabel("Numeros de Puertas");
    JLabel TextoNumeroVin = new JLabel("Número VIN");
    JLabel TextoMPG = new JLabel("MPG");
    JLabel TextoSede = new JLabel("Sede");
    JLabel TextoCostoDiario =new JLabel("Costo Diario");
    JLabel TextoCapacidadMaletas =new JLabel("Capacidad de Maletas");
    JLabel TextoTipoTransmision =new JLabel("Tipo de Transmision");
    JLabel TextoAño =new JLabel("Año de Fabricación");
    JLabel TextoServicioAsociado =new JLabel("Servicio");
    JLabel TextoImagen =new JLabel("Imagen");
    JLabel ruta =new JLabel("ruta");

    JLabel TextoTL=new JLabel("");
     
    JButton TextFieldImágen = new JButton("Seleccionar Imagen");
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregar = new JButton("Agregar");
    
    
    ImageIcon img = new ImageIcon("");
    JLabel img2 = new JLabel(img);
    Image yourImage = img.getImage();
    Image newImage = yourImage.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
          
 
 
    AgregarVehiculo() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        img = new ImageIcon(newImage);
        img2.setIcon(img);
 
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
        
        img2.setText("Sin Fotografía");
        TextoPlaca.setBounds(40, 100, 150, 30);
        TextoEstilo.setBounds(40, 140, 150, 30);
        TextoColor.setBounds(40, 180, 150, 30);
        TextoMarca.setBounds(40, 220, 150, 30);
        TextoCapacidad.setBounds(40, 260, 150, 30);
        TextoKilometraje.setBounds(40, 300, 150, 30);
        TextoNumeroPuertas.setBounds(40, 340, 150, 30);
        TextoNumeroVin.setBounds(40, 380, 150, 30);
        TextoMPG.setBounds(40, 420, 150, 30);
        TextoSede.setBounds(400, 100, 150, 30);
        TextoCostoDiario.setBounds(400, 140, 150, 30);
        TextoTL.setBounds(120, 380, 150, 30);
        TextoCapacidadMaletas.setBounds(400, 180, 150, 30);
        TextoTipoTransmision.setBounds(400, 220, 150, 30);
        TextoAño.setBounds(400, 260, 150, 30);
        TextoServicioAsociado.setBounds(400, 300, 150, 30);
        TextoImagen.setBounds(400, 300, 150, 30);
        
           
        TextFieldPlaca.setBounds(200, 100, 150, 30);
        TextFieldEstilo.setBounds(200, 140, 150, 30);
        TextFieldColor.setBounds(200, 180, 150, 30); 
        TextFieldMarca.setBounds(200, 220, 150, 30); 
        TextFieldCapacidad.setBounds(200, 260, 150, 30); 
        TextFieldKilometraje.setBounds(200, 300, 150, 30); 
        TextFieldNumeroPuertas.setBounds(200, 340, 150, 30); 
        TextFieldVin.setBounds(200, 380, 150, 30); 
        TextFieldMPG.setBounds(200, 420, 150, 30); 
        TextFieldSede.setBounds(550, 100, 150, 30);
        TextFieldCostoDiario.setBounds(550, 140, 150, 30);
        TextFieldCapacidadMaletas.setBounds(550, 180, 150, 30);
        TextFieldTransmision.setBounds(550, 220, 150, 30);
        TextFieldAño.setBounds(550, 260, 150, 30);
        TextFieldServicio.setBounds(550, 300, 150, 30);
        TextFieldImágen.setBounds(550, 300, 150, 30);
        img2.setBounds(425, 360, 256, 144);
        
        botonAgregar.setBounds(200, 510, 150, 30);
        botonAtras.setBounds(495,30, 205, 30);
 
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        container.add(TextoAño);
        container.add(TextFieldAño);
        container.add(botonAgregar);
        container.add(img2);
        container.add(TextoPlaca);
        container.add(TextoEstilo);
        container.add(TextoColor);
        container.add(TextoMarca);
        container.add(TextoCapacidad);
        container.add(TextoKilometraje);
        container.add(TextoNumeroPuertas);
        container.add(TextoNumeroVin);
        container.add(TextoMPG);
        container.add(TextoSede);
        container.add(TextoCapacidadMaletas);
        container.add(TextoTipoTransmision);
        container.add(TextoImagen);
        
       
        container.add(TextFieldPlaca);
        container.add(TextFieldEstilo);
        container.add(TextFieldColor);
        container.add(TextFieldMarca);
        container.add(TextFieldCapacidad);
        container.add(TextFieldKilometraje);
        container.add(TextFieldNumeroPuertas);
        container.add(TextFieldVin);
        container.add(TextFieldMPG);
        container.add(TextFieldImágen);
        container.add(TextoCostoDiario);
        container.add(TextoTL);
        container.add(TextFieldSede);
        container.add(TextFieldCostoDiario);
        container.add(TextFieldCapacidadMaletas);
        container.add(TextFieldTransmision);
        
        container.add(botonAtras);

    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregar.addActionListener(this);
        TextFieldImágen.addActionListener(this);
        TextFieldVin.addActionListener(this);
        TextFieldServicio.addActionListener(this);
        
    }
    
    /**
     * Este métodp limpia los campos de texto al ser invocado
     */
    public void limpiarCampos(){
        
        TextFieldPlaca.setText("");
        TextFieldVin.setText("");
        TextFieldColor.setText("");
        TextFieldMarca.setText("");
        TextFieldCapacidad.setText("");
        TextFieldKilometraje.setText("");
        TextFieldNumeroPuertas.setText("");
        TextFieldAño.setText("");
        TextFieldCapacidadMaletas.setText("");
        TextFieldEstilo.setSelectedIndex(0);
        TextFieldTransmision.setSelectedIndex(0);
        TextFieldSede.setSelectedIndex(0);
        ImageIcon imagenSeleccionada = new ImageIcon();
        img2.setIcon(imagenSeleccionada);
        TextFieldMPG.setText("");
        TextFieldCostoDiario.setText("");
        TextoTL.setText("");
        TablaAgregarServiciosAsociados.LimpiarTabla(); 
        Inicio.VentanaMenuAdministrador(true);
        Inicio.VentanaAgregarVehiculo(false); 
        
    }
 
    /**
     *  Este método verifica si en los campos numéricos hay entradas válidas
     * @return true si los campos numéricos son válidos, false si no lo son
     */
    public boolean camposNumericosCorrectos(){
        try{

            Integer.parseInt(TextFieldAño.getText());
            Integer.parseInt(TextFieldCapacidadMaletas.getText());
            Double.parseDouble(TextFieldKilometraje.getText());
            Integer.parseInt(TextFieldNumeroPuertas.getText());
            Integer.parseInt(TextFieldCapacidad.getText());
            Double.parseDouble(TextFieldCostoDiario.getText());
            Double.parseDouble(TextFieldMPG.getText());
            return true;
            
        }catch(Exception error){
            return false;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==botonAtras){
            limpiarCampos();
        }
        
        if (e.getSource()==botonAgregar){
            
            if (filename.equals("Sin Fotografía") || TextFieldTransmision.getSelectedItem()==null || 
                    TextFieldEstilo.getSelectedItem()==null || TextFieldSede.getSelectedItem().equals("") || 
                        TextFieldMPG.getText().equals("") || TextFieldVin.getText().equals("") || 
                            TextFieldNumeroPuertas.getText().equals("") || TextFieldCapacidadMaletas.getText().equals("") || 
                                TextFieldCostoDiario.getText().equals("") || TextFieldKilometraje.getText().equals("") || 
                                       TextFieldCapacidad.getText().equals("") || TextFieldMarca.getText().equals("") || 
                                            TextFieldPlaca.getText().equals("") || TextFieldColor.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingreso incompleto de elementos");

            }else if(!Inicio.adminApp.verificarPlaca(TextFieldPlaca.getText())){
                JOptionPane.showMessageDialog(this, "La placa ingresada no es válida");
            }else if(!camposNumericosCorrectos()){
                JOptionPane.showMessageDialog(this, "Ingreso incorrecto en los campos numéricos");
            }else{
                Inicio.adminApp.registrarVehiculo(TextFieldPlaca.getText(), 
                        Integer.parseInt(TextFieldAño.getText()), (TEstilo) TextFieldEstilo.getSelectedItem(), 
                            TextFieldColor.getText(), TextFieldMarca.getText(), Integer.parseInt(TextFieldCapacidad.getText()),
                                Double.parseDouble(TextFieldKilometraje.getText()), Integer.parseInt(TextFieldNumeroPuertas.getText()), 
                                    TextFieldVin.getText(), Double.parseDouble(TextFieldMPG.getText()), 
                                        (String) TextFieldSede.getSelectedItem(), Double.parseDouble(TextFieldCostoDiario.getText()), 
                                            Integer.parseInt(TextFieldCapacidadMaletas.getText()), 
                                                (TTransmision)TextFieldTransmision.getSelectedItem(), TEstado.Activo, new ArrayList<Servicio>(),
                                                    filename, false);
                Inicio.adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo vehículo");
                limpiarCampos();   
                
            }

        }
        if(e.getSource()==TextFieldImágen){
            int accion = explorer.showOpenDialog(Inicio.frameRegistrarCliente);
            if (accion == JFileChooser.APPROVE_OPTION){  
                
                filename = explorer.getSelectedFile().toString();
                ImageIcon imagenSeleccionada = new ImageIcon(filename);
                img2.setIcon(imagenSeleccionada);
                Image imagenSinEscala = imagenSeleccionada.getImage();
                Image imagenEscalada = imagenSinEscala.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
                imagenSeleccionada.setImage(imagenEscalada);
                img2.setIcon(imagenSeleccionada);
                
            }else{
                filename = "Error, no se encuentra el archivo";
            }
        }
        
        if(e.getSource()==TextFieldEstilo){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
        
        if(e.getSource()==TextFieldServicio){
            Inicio.frameAgregarServicio.setEnabled(false);
            TablaAgregarServiciosAsociados.editando = false;
            TablaAgregarServiciosAsociados.frameTablaEditarServiciosVehiculo.setVisible(true);
        }
    }
}
