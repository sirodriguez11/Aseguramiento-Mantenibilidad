package GUI;

import Modelo.EmpresaMantenimiento;
import Modelo.Servicio;
import Modelo.TServicio;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase hereda de JFrame, permite al usuario agregar un nuevo servicio a un 
 * vehículo determinado desplegando una ventana
 * @since 22/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public final class AgregarServicio extends JFrame implements ActionListener {

    Container container = getContentPane();
    
    TServicio [] ArrayServicios = {null, TServicio.Correctivo, TServicio.Preventivo};
    
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldIdentificador = new JTextField();
    JTextField TextFieldVehiculoRelacionado = new JTextField();
    com.toedter.calendar.JDateChooser TextFieldFechaInicio= new com.toedter.calendar.JDateChooser();
    com.toedter.calendar.JDateChooser TextFieldFechaFinal= new com.toedter.calendar.JDateChooser();
    JTextField TextFieldMontoPagado = new JTextField();
    JTextField TextFieldDetalles = new JTextField();
    JComboBox<Servicio> TextFieldTipoServicio = new JComboBox<>();
    static JComboBox<EmpresaMantenimiento> TextFieldEmpresaServicio = new JComboBox<>();
    
   
    JLabel TextoIdentificador = new JLabel("Identificador");
    JLabel TextoFechaI = new JLabel("Fecha de Inicio");
    JLabel TextoFechaF = new JLabel("Fecha Final");
    JLabel TextoMontoPagado = new JLabel("Monto Pagado");
    JLabel TextoDetalles = new JLabel("Detalles");
    JLabel TextoTipoDeServicio = new JLabel("Tipo de Servicio");
    JLabel TextoEmpresaRelacionada = new JLabel("Empresa Relacionada");
    JLabel VehículoRelacionado = new JLabel("Placa del vehículo");

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarServicio = new JButton("Agregar");
 
 
 
    AgregarServicio() {
        
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
        
        DefaultComboBoxModel mod = new DefaultComboBoxModel(ArrayServicios);
        TextFieldTipoServicio.setModel(mod);
        mod = new DefaultComboBoxModel(Inicio.listaEmpresas.toArray());
        TextFieldEmpresaServicio.setModel(mod);
        
        TextoIdentificador.setBounds(40, 100, 150, 30);
        TextoFechaI.setBounds(40, 140, 150, 30);
        TextoFechaF.setBounds(40, 180, 150, 30);
        TextoMontoPagado.setBounds(40, 220, 150, 30);
        TextoDetalles.setBounds(40, 260, 150, 30);
        TextoTipoDeServicio.setBounds(40, 300, 150, 30);
        TextoEmpresaRelacionada.setBounds(40, 340, 150, 30);
        VehículoRelacionado.setBounds(40, 380, 150, 30);
        
        TextFieldIdentificador.setBounds(200, 100, 150, 30);
        TextFieldFechaInicio.setBounds(200, 140, 150, 30);
        TextFieldFechaFinal.setBounds(200, 180, 150, 30);
        TextFieldMontoPagado.setBounds(200, 220, 150, 30); 
        TextFieldDetalles.setBounds(200, 260, 150, 30); 
        TextFieldTipoServicio.setBounds(200, 300, 150, 30);
        TextFieldEmpresaServicio.setBounds(200, 340, 150, 30);
        TextFieldVehiculoRelacionado.setBounds(200, 380, 150, 30);
                
        botonAgregarServicio.setBounds(150, 475, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        container.add(TextFieldVehiculoRelacionado);
        container.add(VehículoRelacionado);
        container.add(botonAgregarServicio);
        container.add(TextoIdentificador);
        container.add(TextoFechaI);
        container.add(TextoFechaF);
        container.add(TextoMontoPagado);
        container.add(TextoDetalles);
        container.add(TextoTipoDeServicio);
        container.add(TextoEmpresaRelacionada);
        container.add(TextFieldIdentificador);
        container.add(TextFieldMontoPagado);
        container.add(TextFieldDetalles);
        container.add(TextFieldEmpresaServicio);
        container.add(TextFieldTipoServicio);
        container.add(TextFieldFechaInicio);
        container.add(TextFieldFechaFinal);
        container.add(botonAtras);
    }
 
    /**
     *
     */
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarServicio.addActionListener(this);
        TextFieldEmpresaServicio.addActionListener(this);
        TextFieldTipoServicio.addActionListener(this);
        TextFieldVehiculoRelacionado.addActionListener(this);
        
    }
    
    /**
     * Este método verifica la correctitud en formato de los campos numéricos
     * @return true si los campos numéricos son correctos, false si no lo son
     */
    public boolean numerosCorrectos(){
        try{
            Integer.parseInt(TextFieldIdentificador.getText());
            Double.parseDouble(TextFieldMontoPagado.getText());
            return true;
        }catch(Exception Error){
            return false;
        }
        
    }
    
   
 
    /**
     * Este método limpia todos los campos de texto de la ventana
     */
    public void limpiarCampos(){
        
        TextFieldVehiculoRelacionado.setText("");
        TextFieldIdentificador.setText("");
        TextFieldMontoPagado.setText("");
        TextFieldDetalles.setText("");
        TextFieldTipoServicio.setSelectedIndex(0);
        TextFieldFechaInicio.setDate(null);
        TextFieldFechaFinal.setDate(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==TextFieldTipoServicio){
            DefaultComboBoxModel mod = new DefaultComboBoxModel(Inicio.listaEmpresas.toArray());
            TextFieldEmpresaServicio.setModel(mod);
        }

        if (e.getSource()==botonAtras){
            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaAgregarServicio(false); 
            limpiarCampos();
        }
        
        String fiTemp;
        String ffTemp;
        
        if (e.getSource()==botonAgregarServicio){
            if(TextFieldFechaInicio.getCalendar()!=null){
                int año = TextFieldFechaInicio.getCalendar().get(Calendar.YEAR);
                int mes = TextFieldFechaInicio.getCalendar().get(Calendar.MONTH) + 1;
                int dia = TextFieldFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                fiTemp=dia+"/"+mes+"/"+año;
            }
            
            if(TextFieldFechaFinal.getCalendar()!=null){
                int año = TextFieldFechaFinal.getCalendar().get(Calendar.YEAR);
                int mes = TextFieldFechaFinal.getCalendar().get(Calendar.MONTH) + 1;
                int dia = TextFieldFechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
                fiTemp=dia+"/"+mes+"/"+año;
            }
            try{
                if (TextFieldTipoServicio.getSelectedItem() == null || 
                        TextFieldEmpresaServicio.getSelectedItem() == "" || 
                            TextFieldFechaFinal.getDate() == null || TextFieldFechaInicio.getDate() == null || 
                                TextFieldEmpresaServicio.getSelectedItem()==null || 
                                    TextFieldDetalles.getText().equals("") || TextFieldIdentificador.getText().equals("") || 
                                        TextFieldMontoPagado.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Ingreso incompleto de elementos");
            
                } else if(Inicio.adminApp.obtenerVehiculo(TextFieldVehiculoRelacionado.getText())==null){
                    JOptionPane.showMessageDialog(this, "No se encontró el vehículo con placa "+
                            TextFieldVehiculoRelacionado.getText());
                                TextFieldVehiculoRelacionado.setText("");
                }else if(!numerosCorrectos()){
                    JOptionPane.showMessageDialog(this, "Ingreso incorrecto en los campos numéricos");
                }else {
                    Inicio.adminApp.registrarNuevoServicio(Integer.parseInt(
                            TextFieldIdentificador.getText()), TextFieldFechaInicio.getCalendar(), 
                                TextFieldFechaFinal.getCalendar(), Double.parseDouble(TextFieldMontoPagado.getText()), 
                                    TextFieldDetalles.getText(), (TServicio) TextFieldTipoServicio.getSelectedItem(), 
                                        (EmpresaMantenimiento) TextFieldEmpresaServicio.getSelectedItem(), false);
                    
                    JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo servicio de mantenimiento");
                    
                    Inicio.adminApp.agregarServicioAVehiculo(TextFieldVehiculoRelacionado.getText(), 
                            Inicio.adminApp.obtenerServicio(Integer.parseInt(TextFieldIdentificador.getText())));
                    
                    DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.listaServicios.toArray());
                    GUI.TablaAgregarServiciosAsociados.ServiciosAsociadosDisponibles.setModel(mod);
                    
                    limpiarCampos();

                    Inicio.VentanaMenuAdministrador(true);
                    Inicio.VentanaAgregarServicio(false);    

                }
            }catch(Exception error){
                JOptionPane.showMessageDialog(this, "El monto pagado ingrseado no es válido");
            }
            

        }
    }
}
