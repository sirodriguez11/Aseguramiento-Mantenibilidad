/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;

/**
 * Esta clase utilitaria contiene métodos para darle formato a diferentes datos
 * @since 25/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public class Utilitaria {
    
    /**
     * Este método convierte un string de forma día/mes/año a 
     * un tipo de dato Calendar
     * 
     * @param fechaString
     * 
     * @return Calendar
     */
    
    public static Calendar obtenerFecha(String fechaString) {
        String[] datos = fechaString.split(" ");
        Calendar fechaCalendar = Calendar.getInstance();
        fechaCalendar.set(Integer.parseInt(datos[2]), 
                (Integer.parseInt(datos[1]))-1, Integer.parseInt(datos[0]));
        return fechaCalendar;
    }
    
    /**
     * Este método convierte un tipo de dato Calendar a una fecha 
     * en formato string "día/mes/año"
     * 
     * @param fechaCalendar
     * 
     * @return String 
     */
    
    public static String formatoFecha(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+"/"+
                (fechaCalendar.get(Calendar.MONTH)+1)+"/"+fechaCalendar.get(Calendar.YEAR);
    }
    
    /**
     * Este método convierte un tipo de dato Calendar a una fecha 
     * en formato string "día mes año"
     * 
     * @param fechaCalendar
     * 
     * @return String 
     */
    
    public static String formatoFechaJSON(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+" "+(fechaCalendar.get(Calendar.MONTH)+1)+
                " "+fechaCalendar.get(Calendar.YEAR);
    }
    
    /**
     * Este método retorna un mensaje indicando si el estado de un método es exitoso o no
     * 
     * @param estadoMetodo
     *
     * @return String 
     */
    
    public static String verificarMetodo(boolean estadoMetodo) {
        if(estadoMetodo) {
            return "El proceso ha concluido existosamente.";
        } else {
            return "Ha ocurrido un error.";
        }
    }
    
}
