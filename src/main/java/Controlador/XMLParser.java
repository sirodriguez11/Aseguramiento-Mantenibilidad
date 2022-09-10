/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Esta clase retorna el valor que contiene una etiqueta de XML
 * @since 24/10/2020
 * @version 1.0
 * @author Hans Araya Tutorial
 */

public class XMLParser {
    
    private final String xml;
    private final Element rootElement;
    
    public XMLParser(String data) throws SAXException, IOException, 
            ParserConfigurationException{
        data =  replaceChars(data);
        this.xml = data;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(this.xml)));
        this.rootElement = document.getDocumentElement();
    }
  
    /**
     * Este método retorna el valor contenido en la etiqueta del tipo de cambio
     * 
     * @param tag
     * 
     * @SuppressWarnings("UseSpecificCatch")
     * @return String
     */
    
    public String getValue(String tag){
        try {
            NodeList list = this.rootElement.getElementsByTagName(tag);
            if (list != null && list.getLength() > 0) {
                NodeList subList = list.item(0).getChildNodes();
                if (subList != null && subList.getLength() > 0) {
                    return subList.item(0).getNodeValue();
                }
            }
        } catch (Exception e) {
            return "0";
        }
        return "0";
    }
  
    private String replaceChars(String string){
        string = string.replace("&lt;", "<");
        string = string.replace("&gt;", ">");
        return string;
    }
    
}
