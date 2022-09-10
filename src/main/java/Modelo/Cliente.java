/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Utilitaria;
import java.util.Calendar;

/**
 * Esta clase representa a los clientes que se van a registrar en el sistema.
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public class Cliente {
    private String nombreCompleto;
    private String cedula;
    private String direccionExacta;
    private String correoElectronico;
    private String telefono;
    private String numeroLicencia;
    private Calendar fechaEmisionLicencia;
    private TLicencia tipoLicencia;
    private Calendar fechaExpiracionLicencia;
    private String imagen;
    
    public void Cliente(){};

    public Cliente(String nombreCompleto, String cedula, String direccionExacta, 
            String correoElectronico, String telefono, String numeroLicencia, 
                Calendar fechaEmisionLicencia, TLicencia tipoLicencia, 
                    Calendar fechaExpiracionLicencia, String imagen){
        
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.direccionExacta = direccionExacta;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.numeroLicencia = numeroLicencia;
        this.fechaEmisionLicencia = fechaEmisionLicencia;
        this.tipoLicencia = tipoLicencia;
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
        this.imagen = imagen;
    }
    
    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Calendar getFechaEmisionLicencia() {
        return fechaEmisionLicencia;
    }

    public void setFechaEmisionLicencia(Calendar fechaEmisionLicencia) {
        this.fechaEmisionLicencia = fechaEmisionLicencia;
    }

    public TLicencia getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(TLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Calendar getFechaExpiracionLicencia() {
        return fechaExpiracionLicencia;
    }

    public void setFechaExpiracionLicencia(Calendar fechaExpiracionLicencia) {
        this.fechaExpiracionLicencia = fechaExpiracionLicencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombreCompleto + "\nCédula: " + cedula + "\nLicencia " + numeroLicencia + 
                " ("+tipoLicencia +") " + "("+ Utilitaria.formatoFecha(fechaEmisionLicencia) + 
                    " - " + Utilitaria.formatoFecha(fechaExpiracionLicencia) +")" + "\nCorreo: " + 
                        correoElectronico +"\nDirección: "+direccionExacta;
    }
    
}

