package GUI;

import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TTransmision;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
/**
 * Esta clase hereda de JFrame, permite al usuario editar los datos de un vehículo en una ventana
 * @since 21/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */

public final class EditarVehiculo extends JFrame implements ActionListener {
    String Placa;
    String filename = "Sin fotografía";
    TEstilo[] TiposEstilos = {null, TEstilo.Compacto, TEstilo.PickUp, 
        TEstilo.Intermedio, TEstilo.SUV, TEstilo.MiniVan, TEstilo.Convertible, TEstilo.Económico};
    TTransmision[] TiposTransmision = {null, TTransmision.Automática, TTransmision.Manual};
    String[] TiposSedes = Inicio.listaSedes;
    TEstado[] Estados={null, TEstado.Activo, TEstado.Mantenimiento, TEstado.Inactivo};
    
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    HashMap diccionario = new HashMap();
    
    JComboBox<TEstilo> ComboBoxTipoCarroSeleccionado = new JComboBox<>(Inicio.listaEstilos);
    JComboBox<TEstilo> ComboBoxEstilos = new JComboBox<TEstilo>(Inicio.listaEstilos);
    JComboBox<Vehiculo> ComboBoxVehículoSeleccionado = new JComboBox<>();
    JComboBox<TEstado> TextFieldEstado = new JComboBox<>(Estados);
    JComboBox<TTransmision> TextFieldTransmision = new JComboBox<>(TiposTransmision);
    JComboBox<String> TextFieldSede = new JComboBox<>(TiposSedes);
    
    JTextField TextFieldAñoFabricacion = new JTextField("");
    JTextField TextFieldColorSeleccionado = new JTextField("");
    JTextField TextFieldMarcaSeleccionada = new JTextField("");
    JTextField TextFieldKilometraje = new JTextField("");
    JTextField TextFieldCapacidadPersonas= new JTextField("");
    JTextField TextFieldNumeroPuertas= new JTextField("");
    JTextField TextFieldMPG = new JTextField("");
    JTextField TextFieldCostoDiario = new JTextField("");
    JTextField TextFieldCapacidadMaletas = new JTextField("");
    JTextField TextFieldVin = new JTextField("");
    
    
    JLabel TextoNombreCompleto = new JLabel("Filtro por tipo");
    JLabel TextoCédula = new JLabel("Vehículo Seleccionado");
    JLabel TextoServiciosRelacionados = new JLabel("Servicios Relacionados");
    JLabel TextoCorreo = new JLabel("Año de Fabricación");
    JLabel TextoTeléfono = new JLabel("Color");
    JLabel TextoNumeroLicencia = new JLabel("Marca");
    JLabel TextoFechaEmisionLicencia = new JLabel("Capacidad Personas");
    JLabel TextoTipoLicencia = new JLabel("Kilometraje");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Numero de Puertas");
    JLabel TextoImágen = new JLabel("Numero Vin");
    JLabel TextoURL =new JLabel("MPG");
    JLabel TextoEstilo =new JLabel("Estilo");
    JLabel TextoSede =new JLabel("Sede");
    JLabel TextoCostoDiario =new JLabel("Costo Diario");
    JLabel TextoCapacidaddeMaletas =new JLabel("Capacidad de Maletas");
    JLabel TextoTipodeTransmisión =new JLabel("Tipo de Transmisión");
    JLabel TextoEstado =new JLabel("Estado");
    JLabel TextoImagen =new JLabel("Imagen");
    JLabel TextoTL=new JLabel("");
    JLabel TextoTipoVehículoSeleccionado = new JLabel("");
    JLabel TextoVehiculoSeleccionado= new JLabel(""); 
    JButton botonAtras = new JButton("Atrás");
    JButton botonConfirmar = new JButton("Confirmar");
    JButton botonModificarServicios = new JButton("Modificar");
    JButton TextFieldImágen = new JButton("Seleccionar Imagen");
    
    ImageIcon img = new ImageIcon("");
    JLabel img2 = new JLabel(img);
    Image yourImage = img.getImage();
    Image newImage = yourImage.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
    
    EditarVehiculo() {    
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setFields(false);
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
        int a=80;
        int b;
        
        img2.setText("Sin Fotografía");
        TextoNombreCompleto.setBounds(40, 30, 150, 30);
        TextoCédula.setBounds(40, 100, 150, 30);
        TextoServiciosRelacionados.setBounds(40, 180-a, 150, 30);
        TextoCorreo.setBounds(40, 220-a, 150, 30);
        TextoTeléfono.setBounds(40, 260-a, 150, 30);
        TextoNumeroLicencia.setBounds(40, 300-a, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 340-a, 150, 30);
        TextoTipoLicencia.setBounds(40, 380-a, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420-a, 150, 30);
        TextoImágen.setBounds(40, 460-a, 150, 30);
        TextoURL.setBounds(40, 500-a, 300, 30);
        TextoEstilo.setBounds(40, 540-a, 300, 30);
        TextoTL.setBounds(120, 380-a, 150, 30);
        ComboBoxTipoCarroSeleccionado.setBounds(200, 30, 200, 30);
        ComboBoxVehículoSeleccionado.setBounds(200, 100, 200, 30);
        TextFieldAñoFabricacion.setBounds(200, 220-a, 200, 30); 
        TextFieldColorSeleccionado.setBounds(200, 260-a, 200, 30); 
        TextFieldMarcaSeleccionada.setBounds(200, 300-a, 200, 30); 
        TextFieldCapacidadPersonas.setBounds(200, 340-a, 200, 30); 
        TextFieldKilometraje.setBounds(200, 380-a, 200, 30); 
        TextFieldNumeroPuertas.setBounds(200, 420-a, 200, 30); 
        TextFieldVin.setBounds(200, 460-a, 200, 30);
        TextFieldMPG.setBounds(200, 500-a, 200, 30);
        ComboBoxEstilos.setBounds(200, 540-a, 200, 30);
        
        int k = 15;
        int h = -80;
        
        TextoSede.setBounds(410+k, 180+h, 150, 30);
        TextoCostoDiario.setBounds(410+k, 220+h, 150, 30);
        TextoCapacidaddeMaletas.setBounds(410+k, 260+h, 150, 30);
        TextoTipodeTransmisión.setBounds(410+k, 300+h, 150, 30);
        TextoEstado.setBounds(410+k, 340+h, 150, 30);
        TextoImagen.setBounds(410+k, 380+h, 150, 30);
        
        TextFieldSede.setBounds(570+k, 180+h, 200, 30);
        TextFieldCostoDiario.setBounds(570+k, 220+h, 200, 30);
        TextFieldCapacidadMaletas.setBounds(570+k, 260+h, 200, 30);
        TextFieldTransmision.setBounds(570+k, 300+h, 200, 30);
        TextFieldEstado.setBounds(570+k, 340+h, 200, 30);
        TextFieldImágen.setBounds(570+k, 380+h, 200, 30); 
        botonConfirmar.setBounds(490, 520, 256, 30);
        botonAtras.setBounds(585,30, 200, 30);
        img2.setBounds(490, 350, 256, 144);
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        container.add(TextoEstilo);
        container.add(ComboBoxEstilos);
        container.add(img2);
        container.add(img2);
        container.add(TextFieldImágen);
        container.add(TextFieldMPG);
        container.add(TextFieldSede);
        container.add(TextFieldCostoDiario);
        container.add(TextFieldCapacidadMaletas);
        container.add(TextFieldTransmision);
        container.add(TextFieldEstado);
        container.add(botonConfirmar);
        container.add(TextoSede);
        container.add(TextoCostoDiario);
        container.add(TextoCapacidaddeMaletas);
        container.add(TextoTipodeTransmisión);
        container.add(TextoEstado);
        container.add(TextoImagen);
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoCorreo);
        container.add(TextoTeléfono);
        container.add(TextoNumeroLicencia);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoImágen);
        container.add(TextoTipoVehículoSeleccionado);
        container.add(ComboBoxTipoCarroSeleccionado);
        container.add(ComboBoxVehículoSeleccionado);
        container.add(botonModificarServicios);
        container.add(TextFieldAñoFabricacion);
        container.add(TextFieldColorSeleccionado);
        container.add(TextFieldMarcaSeleccionada);
        container.add(TextFieldCapacidadPersonas);
        container.add(TextFieldKilometraje);
        container.add(TextFieldNumeroPuertas);
        container.add(TextFieldVin);
        container.add(TextoURL);
        container.add(TextoTL);
        container.add(TextoVehiculoSeleccionado);
        container.add(botonAtras);
        ComboBoxVehículoSeleccionado.setEnabled(false);
    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonConfirmar.addActionListener(this);
        TextFieldImágen.addActionListener(this);
        ComboBoxTipoCarroSeleccionado.addActionListener( this);
        ComboBoxVehículoSeleccionado.addActionListener(this);
        botonModificarServicios.addActionListener(this);
        
    }
    
    /**
     * Este método permite que se pueda escribir en los campos para editar los datos del vehículo o no
     * @param cond Cond debe ser un valor booleano true o false
     */
    public void setFields(boolean cond){
        
        TextFieldEstado.setEnabled(cond);
        TextFieldAñoFabricacion.setEnabled(cond);
        TextFieldColorSeleccionado.setEnabled(cond);
        TextFieldMarcaSeleccionada.setEnabled(cond);
        TextFieldKilometraje.setEnabled(cond);
        TextFieldCapacidadPersonas.setEnabled(cond);
        TextFieldNumeroPuertas.setEnabled(cond);
        TextFieldMPG.setEnabled(cond); 
        TextFieldSede.setEnabled(cond);
        TextFieldCostoDiario.setEnabled(cond);
        TextFieldCapacidadMaletas.setEnabled(cond);
        TextFieldTransmision.setEnabled(cond);
        img2.setEnabled(cond);
        TextFieldVin.setEnabled(cond);
        botonModificarServicios.setEnabled(cond);
        TextFieldImágen.setEnabled(cond);
        ComboBoxEstilos.setEnabled(cond);
    }
    
    /**
     * Este método limpia los campos para editar los datos del vehículo, los limpia
     */
    public void resetearCampos(){
        
        DefaultComboBoxModel mod= new DefaultComboBoxModel();
        ComboBoxVehículoSeleccionado.setModel(mod);
        TextFieldAñoFabricacion.setText("");
        TextFieldColorSeleccionado.setText("");
        TextFieldMarcaSeleccionada.setText("");
        TextFieldKilometraje.setText("");
        TextFieldCapacidadPersonas.setText("");
        TextFieldNumeroPuertas.setText("");
        TextFieldMPG.setText(""); 
        ComboBoxEstilos.setSelectedIndex(0);
        TextFieldSede.setSelectedIndex(0);
        TextFieldCostoDiario.setText("");
        TextFieldCapacidadMaletas.setText("");
        TextFieldTransmision.setSelectedIndex(0);
        TextFieldEstado.setSelectedIndex(0);
        img2.setText("Sin Fotografía");
        TextFieldVin.setText("");
        img2.setIcon(null);
        setFields(false);
    }
    
    /**
     * Este método permite obtener el índice en el que la ComboBox del índice debe estar a la 
     * hora de cargar la información de la sede de un vehículo
     * @param V Parámetro de tipo vehículo
     * @return Número entero
     */
    public int obtenerIndiceSedes(Vehiculo V){
        int index=0;
        for (String S: TiposSedes) {
            if (V.getSede().equals(S)) {
                return index;
            }
            index++;
        }return 0;
    }

    /**
     * Este método verifica si los campos numéricos tienen datos válidos
     * @return true si los campos numéricos tienen un formato correcto, false si no
     */
    public boolean camposNumericosCorrectos(){
        try{
            int a;
            double b;
            a=Integer.parseInt(TextFieldAñoFabricacion.getText());
            a=Integer.parseInt(TextFieldCapacidadMaletas.getText());
            b=Double.parseDouble(TextFieldKilometraje.getText());
            a=Integer.parseInt(TextFieldNumeroPuertas.getText());
            a=Integer.parseInt(TextFieldCapacidadPersonas.getText());
            b=Double.parseDouble(TextFieldCostoDiario.getText());
            b=Double.parseDouble(TextFieldMPG.getText());
            return true;
        }catch(Exception error){
            return false;
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==botonModificarServicios){
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            Auto.getListaServiciosRelacionados().forEach(S -> {
                TablaAgregarServiciosAsociados.model.addRow(new Object[]{S});
                TablaAgregarServiciosAsociados.cantServicios ++;
            });
            Inicio.frameEditarVehiculo.setEnabled(false);
            TablaAgregarServiciosAsociados.editando = true;
            TablaAgregarServiciosAsociados.frameTablaEditarServiciosVehiculo.setVisible(true);

        }
        
        if (e.getSource()==botonAtras){
            ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
            ComboBoxVehículoSeleccionado.setEnabled(false);
            setFields(false);
            resetearCampos();
            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaEditarVehiculo(false);
          
        }
        
        if (e.getSource()==botonConfirmar){
            
            
            if (ComboBoxVehículoSeleccionado.getSelectedIndex()==0 || 
                    ComboBoxTipoCarroSeleccionado.getSelectedIndex()==0 || 
                    TextFieldAñoFabricacion.equals("") || img2.equals("Sin Fotografía") || 
                        TextFieldTransmision.getSelectedItem()==null || TextFieldEstado.getSelectedItem()==null || 
                            TextFieldSede.getSelectedItem().equals("") || TextFieldMPG.getText().equals("") || 
                                TextFieldVin.getText().equals("") || TextFieldNumeroPuertas.getText().equals("") ||
                                    TextFieldCapacidadMaletas.getText().equals("") || TextFieldCostoDiario.getText().equals("") ||
                                        TextFieldKilometraje.getText().equals("") || TextFieldCapacidadPersonas.getText().equals("") || 
                                            TextFieldMarcaSeleccionada.getText().equals("") || TextFieldColorSeleccionado.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Ingreso inválido, estado incompleto de elementos");
            } else if(!camposNumericosCorrectos()){
                JOptionPane.showMessageDialog(this, "Ingreso incorrecto en los campos numéricos");
            }else {
                diccionario.put("Transmision", String.valueOf(TextFieldTransmision.getSelectedItem()));
                diccionario.put("Mpg", TextFieldMPG.getText());
                diccionario.put("Numero vin", TextFieldVin.getText());
                diccionario.put("Color", TextFieldColorSeleccionado.getText());
                diccionario.put("Año fabricación", TextFieldAñoFabricacion.getText());
                diccionario.put("Capacidad maletas", TextFieldCapacidadMaletas.getText());
                diccionario.put("Imagen", filename);
                diccionario.put("Capacidad", TextFieldCapacidadPersonas.getText());
                diccionario.put("Estilo", String.valueOf(ComboBoxEstilos.getSelectedItem()));
                diccionario.put("Numero puertas", TextFieldNumeroPuertas.getText());
                diccionario.put("Estado", String.valueOf(TextFieldEstado.getSelectedItem()));
                diccionario.put("Costo diario", TextFieldCostoDiario.getText());
                diccionario.put("Sede", String.valueOf(TextFieldSede.getSelectedItem()));
                diccionario.put("Marca", TextFieldMarcaSeleccionada.getText());
                diccionario.put("Kilometraje", TextFieldKilometraje.getText());


                Inicio.adminApp.editarVehiculoJSON(Placa, diccionario);
                Inicio.adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
                
                JOptionPane.showMessageDialog(this, "Se han guardado los cambios");
                ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
                Inicio.VentanaMenuAdministrador(true);
                Inicio.VentanaEditarVehiculo(false);   

            }
        }
        
        if(e.getSource()==TextFieldKilometraje){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==ComboBoxTipoCarroSeleccionado){
            if(ComboBoxVehículoSeleccionado.getSelectedIndex()==0){
                ComboBoxVehículoSeleccionado.setEnabled(false);
                resetearCampos();
            }else{
                ComboBoxVehículoSeleccionado.setEnabled(true); 
                ComboBoxVehículoSeleccionado.removeAllItems();
                if (ComboBoxTipoCarroSeleccionado.getSelectedItem()!=null) {
                    System.out.println(ComboBoxTipoCarroSeleccionado.getSelectedItem());
                    DefaultComboBoxModel mod= new DefaultComboBoxModel
                        (Inicio.adminApp.getVehiculosTipo((TEstilo)ComboBoxTipoCarroSeleccionado.getSelectedItem(), 
                                Calendar.getInstance(), Calendar.getInstance(), false).toArray());
                    ComboBoxVehículoSeleccionado.setModel(mod);
                }
                
            }
            
        }
            
        if(e.getSource()==ComboBoxVehículoSeleccionado){
            System.out.println("ACCION");

            TextoVehiculoSeleccionado.setVisible(false);
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            if(ComboBoxVehículoSeleccionado.getSelectedItem() instanceof Vehiculo){
                setFields(true);
                
                Placa = Auto.getPlaca();
                TextFieldEstado.setSelectedIndex(0);
                TextFieldAñoFabricacion.setText(String.valueOf(Auto.getAñoFabricacion()));
                TextFieldColorSeleccionado.setText(Auto.getColor());
                TextFieldMarcaSeleccionada.setText(Auto.getMarca());
                TextFieldKilometraje.setText(String.valueOf(Auto.getKilometraje()));
                TextFieldCapacidadPersonas.setText(String.valueOf(Auto.getCapacidad()));
                TextFieldNumeroPuertas.setText(String.valueOf(Auto.getNumeroPuertas()));
                TextFieldMPG.setText(String.valueOf(Auto.getMpg()));
                ComboBoxEstilos.setSelectedItem(Auto.getEstilo());
                TextFieldSede.setSelectedIndex(obtenerIndiceSedes(Auto));
                TextFieldCostoDiario.setText(String.valueOf(Auto.getCostoDiario()));
                TextFieldCapacidadMaletas.setText(String.valueOf(Auto.getCapacidad()));
                TextFieldTransmision.setSelectedItem(Auto.getTipoTransmision());
                TextFieldEstado.setSelectedItem(Auto.getEstado());
                TextFieldVin.setText(Auto.getNumeroVin());
                filename = Auto.getImagen();
                ImageIcon imagenSeleccionada = new ImageIcon(filename);
                img2.setIcon(imagenSeleccionada);
                Image imagenSinEscala = imagenSeleccionada.getImage();
                Image imagenEscalada = imagenSinEscala.getScaledInstance(256, 144, Image.SCALE_SMOOTH);
                imagenSeleccionada.setImage(imagenEscalada);
                img2.setIcon(imagenSeleccionada);
                
            }else{       
                resetearCampos();
            }
            
        }
     
        if(e.getSource()==TextFieldImágen){
           /* FileNameExtensionFilter filter = new FileNameExtensionFilter(".jpg", "JPG Files");
            FileNameExtensionFilter filter2 = new FileNameExtensionFilter(".png", "PNG Files");
            FileNameExtensionFilter filter3 = new FileNameExtensionFilter(".jiff", "JIFF Files");
            explorer.addChoosableFileFilter(filter);
            explorer.addChoosableFileFilter(filter2);
            explorer.addChoosableFileFilter(filter3);*/
            int accion = explorer.showOpenDialog(Inicio.frameEditarVehiculo);
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
    }
}