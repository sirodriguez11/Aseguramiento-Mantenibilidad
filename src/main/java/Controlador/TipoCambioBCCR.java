/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;

/**
 * Esta clase retorna el tipo de cambio de compra y de venta.
 * @since 24/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public class TipoCambioBCCR {
    
    private int indicador = 0;
    private String fechaInicio;
    private String fechaFinal;
    private String url;
    private final String nombre = "TECProyecto1POO";
    private final String subNiveles = "N";
    private final String correo = "mhidalgos0708@gmail.com";
    private final String token = "SMOIMLILAI";
    private final String HOST = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
    private final String VALUE_TAG = "NUM_VALOR";
    
    public TipoCambioBCCR(){
        setFecha();
    }
 
    /**
     * @return double con el valor del tipo de cambio de compra
     */
    
    public double getCompra(){
        setCompra();
        double valor = Double.parseDouble(getValue());
        return valor;
    }
    
    /**
     * @return double con el valor del tipo de cambio de venta
     */
  
    public double getVenta(){
        setVenta();
        double valor = Double.parseDouble(getValue());
        return valor;
    }
    
    /**
     * 
     */
  
    private String getValue(){
        try {
            setUrl(); 
            String data = MetodoGET.getHTML(url);
            XMLParser xml = new XMLParser(data);
            return xml.getValue(VALUE_TAG);
        } catch (Exception e) {
            System.out.println("Error al obtener el valor del BCCR.");
            return "0";
        }
    }
    
    /**
     * 
     */
  
    private void setUrl(){
        String params = "Indicador="+indicador+"&FechaInicio="+fechaInicio+
                "&FechaFinal="+fechaFinal+"&Nombre="+nombre+"&SubNiveles="+
                    subNiveles+"&CorreoElectronico="+correo+"&Token="+token;
        this.url = HOST+"?"+params;
    }
    
    /**
     * 
     */
  
    private void setFecha(){
        Calendar fecha = Calendar.getInstance();
        String formatoFecha = fecha.get(Calendar.DATE)+"/"+
                (fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
        this.fechaInicio = formatoFecha;
        this.fechaFinal = formatoFecha;
    }
    
    /**
     * 
     */
  
    private void setCompra(){
        this.indicador = 317;
    }
    
    /**
     * 
     */
  
    private void setVenta(){
        this.indicador = 318;
    }
    
}
