/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Esta clase modela a los operadores de servicio al cliente del sistema
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public class Operador {
    private String correoElectronico;
    private String contraseña;
    private String nombreCompleto;
    private boolean estado;

    public Operador() {} 

    public Operador(String correoElectronico, String contraseña, String nombreCompleto, boolean estado){
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Este método permite crear un nombre de usuario a partir del correo electrónico contenido 
     * en un objeto Operador
     * @return String con el nombre de usuario que tendrá el operador
     */
    public String getUsername(){
        String[] username = correoElectronico.split("@", 2); 
        return username[0];
    }

    @Override
    public String toString() {
        return nombreCompleto + " (" + correoElectronico +")";
    }
    
}
