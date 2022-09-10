/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Utilitaria;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import Controlador.TipoCambioBCCR;

/**
 * Esta clase modela las reservas que se van a almacenar y crear en el sistema
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */

public class Reserva {
    private String sedeRecogida;
    private String sedeEntrega;
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;
    private Calendar fechaSolicitud;
    private Operador operador;
    private Vehiculo vehiculoSeleccionado;
    private Cliente clienteRelacionado;
    private HashMap serviciosOpcionales;
    private int numeroFactura;

    public Reserva() {
    }

    public Reserva(String sedeRecogida, String sedeEntrega, Calendar fechaInicio, 
            Calendar fechaFinalizacion, Calendar fechaSolicitud, Operador operador, 
                Vehiculo vehiculoSeleccionado, Cliente clienteRelacionado, HashMap serviciosOpcionales, 
                    int numeroFactura) {
        this.sedeRecogida = sedeRecogida;
        this.sedeEntrega = sedeEntrega;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.fechaSolicitud = fechaSolicitud;
        this.operador = operador;
        this.vehiculoSeleccionado = vehiculoSeleccionado;
        this.clienteRelacionado = clienteRelacionado;
        this.serviciosOpcionales = serviciosOpcionales;
        this.numeroFactura = numeroFactura;
    }
    
    public String getSedeRecogida() {
        return sedeRecogida;
    }

    public void setSedeRecogida(String sedeRecogida) {
        this.sedeRecogida = sedeRecogida;
    }

    public String getSedeEntrega() {
        return sedeEntrega;
    }

    public void setSedeEntrega(String sedeEntrega) {
        this.sedeEntrega = sedeEntrega;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }

    public Cliente getClienteRelacionado() {
        return clienteRelacionado;
    }

    public void setClienteRelacionado(Cliente clienteRelacionado) {
        this.clienteRelacionado = clienteRelacionado;
    }

    public HashMap getServiciosOpcionales() {
        return serviciosOpcionales;
    }

    public void setServiciosOpcionales(HashMap serviciosOpcionales) {
        this.serviciosOpcionales = serviciosOpcionales;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Calendar fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     *  Este método se utiliza para obtener la duración de una reserva y colocarla en el pdf de 
     * la reserva
     * @return Entero con la duración de días de la reserva
     */
    public int getDuracion()
    {
        Calendar copia = Calendar.getInstance();
        copia.set(Calendar.YEAR, fechaInicio.get(Calendar.YEAR));
        copia.set(Calendar.MONTH, fechaInicio.get(Calendar.MONTH));
        copia.set(Calendar.DAY_OF_MONTH, fechaInicio.get(Calendar.DAY_OF_MONTH));
        int days = 0;
        while (copia.compareTo(fechaFinalizacion) < 0) 
        {
            copia.add(Calendar.DAY_OF_MONTH, 1); // suma un día al calendario 1
            days++;
        }
        
        if (days == 0)
            days++;
        return days;
    }
    
    /**
     * Este método calcula el costo de la reserva tomando en cuenta solo el vehículo para ser 
     * colocado posteriormente en el pdf de la reserva
     * @return Double con el costo de la reserva sin servicios opcionales
     */
    public double getCostoRenta()
    {
        double costo = getDuracion() * vehiculoSeleccionado.getCostoDiario();
        return costo;
    }

    /**
     * Este método calcula el total del precio de los servicios opcionales seleccionados en una 
     * reserva en dólares según el HashMap de servicios
     * del objeto
     * @return Double del precio total en dólares de los sevicios opcionales seleccionados en una reserva
     */
    public double getCostoSODolares()
    {
        double se = 0;
        for(int i = 0; i < serviciosOpcionales.keySet().size(); i++)
        {            
            String key = serviciosOpcionales.keySet().toArray()[i].toString();
            serviciosOpcionales.get(key).toString();
            se += (Double)(serviciosOpcionales.get(key));
        }        
        return se * getDuracion();
    }

    /**
     * Este método calcula el total del precio de los servicios opcionales seleccionados en una 
     * reserva en colones según el HashMap de servicios
     * del objeto
     * @return Double con el costo en colones de los servicios opcionales seleccionados en la 
     * reserva actual
     */
    public double getCostoSO()
    {
        TipoCambioBCCR servicioTipoCambio = new TipoCambioBCCR();
        double se = 0;
        for(int i = 0; i < serviciosOpcionales.keySet().size(); i++)
        {            
            String key = serviciosOpcionales.keySet().toArray()[i].toString();
            serviciosOpcionales.get(key).toString();
            se += ((Double)serviciosOpcionales.get(key) * servicioTipoCambio.getVenta());
        }        
        return se * getDuracion();
    }

    /**
     * Este método obtiene el costo total de toda la reserva actual incluyendo servicios especiales 
     * y costo de renta del vehículo
     * @return Double con el costo total de la reserva
     */
    public double getCostoTotal()
    {
        return getCostoSO() + getCostoRenta();
    }
    
    /**
     * En este método se obtienen los servicios opcionales contenidos en la reserva y si están, se 
     * indican como un sí en la tabla,
     * si no, se coloca un no.
     * @return Array conteniendo llaves con los servicios opcionales y si están contenidos como su 
     * valor
     */
    public Object[][] getArrayServicios(){
        Set keys = serviciosOpcionales.keySet();
        Object[][] O = new Object[][]{{"WiFi", keys.contains("WiFi limitado") ? "Sí" : "No"},
            {"GPS", keys.contains("GPS") ? "Sí" : "No"},
                {"Seguro", keys.contains("Cobertura por daños a terceros") ? "Sí" : "No"},
                    {"Asistencia", keys.contains("Asistencia en carretera") ? "Sí" : "No"},
                        {"Asiento Niños", keys.contains("Asiento para niño") ? "Sí" : "No"}};
        return O;
    }
    
    @Override
    public String toString() {
        return "Reserva número "+ numeroFactura + " (" + Utilitaria.formatoFecha(fechaInicio) + " - " + Utilitaria.formatoFecha(fechaFinalizacion) + ')';
    }
    
    
    
    
}
