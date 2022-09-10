/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Esta clase se conecta a una url y retorna el contenido del sitio.
 * 
 * @since 24/10/2020
 * @version 1.0
 * @author Hans Araya Tutorial
 */

public class MetodoGET {
    
    /**
     * Este método se conecta a una url y retorna el contenido del sitio.
     * 
     * @param leerURL
     * @SuppressWarnings("ConvertToTryWithResources")
     * @return String con el contenido del sitio
     */
    
    protected static String getHTML(String leerURL) throws Exception {
        
        //Conexión
        
        StringBuilder result = new StringBuilder();
        URL url = new URL(leerURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
    
        //Retorna el contenido del sitio
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        in.close();
        return result.toString();
    }
    
}
