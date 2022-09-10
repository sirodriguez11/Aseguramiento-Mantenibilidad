/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 * Esta clase modela los servicios que se van a almacenar y crear en el sistema
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public class Servicio {
    private int identificador;
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;
    private double montoPagado;
    private String detalles; 
    private TServicio tipo;
    private EmpresaMantenimiento empresaRelacionada;

    public Servicio() {}

    public Servicio(int identificador, Calendar fechaInicio, Calendar fechaFinalizacion, 
            double montoPagado, String detalles, TServicio tipo, EmpresaMantenimiento empresaRelacionada){
        this.identificador = identificador;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.montoPagado = montoPagado;
        this.detalles = detalles;
        this.tipo = tipo;
        this.empresaRelacionada = empresaRelacionada;
    }
    
    

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public TServicio getTipo() {
        return tipo;
    }

    public void setTipo(TServicio tipo) {
        this.tipo = tipo;
    }

    public EmpresaMantenimiento getEmpresaRelacionada() {
        return empresaRelacionada;
    }

    public void setEmpresaRelacionada(EmpresaMantenimiento empresaRelacionada) {
        this.empresaRelacionada = empresaRelacionada;
    }

    @Override
    public String toString() {
        return "Servicio " + tipo + " número " + identificador + " (" + 
                fechaInicio.get(Calendar.DAY_OF_MONTH) + "/" + (fechaInicio.get(Calendar.MONTH)+1) +
                    "/" + fechaInicio.get(Calendar.YEAR) +" - " + 
                        fechaFinalizacion.get(Calendar.DAY_OF_MONTH) + "/" + 
                            (fechaFinalizacion.get(Calendar.MONTH)+1) + "/" + 
                                fechaFinalizacion.get(Calendar.YEAR)+")";
    }


    
    
    
    
}
