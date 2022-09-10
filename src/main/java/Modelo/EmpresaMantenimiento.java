package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase representa a las empresas que se van a registrar en el sistema.
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */
public class EmpresaMantenimiento {
    private String razonSocial;
    private String numeroCedula;
    private String telefono;
    private String provincia;
    private String canton;
    private String distrito;
    private String señas;

    public EmpresaMantenimiento() {}

    public EmpresaMantenimiento(String razonSocial, String numeroCedula, String telefono, 
            String provincia, String canton, String distrito, String señas) {
        this.razonSocial = razonSocial;
        this.numeroCedula = numeroCedula;
        this.telefono = telefono;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.señas = señas;
    }
    
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getSeñas() {
        return señas;
    }

    public void setSeñas(String señas) {
        this.señas = señas;
    }

    @Override
    public String toString() {
        return razonSocial + " cédula " + numeroCedula + ", " + provincia;
    }
    
    
    
}
