/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Esta clase envía correos electrónicos con un archivo adjunto.
 * @since 29/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public class EnviarEmail {
    
    /**
     * Construye y envía un correo electrónico con los datos recibidos como parámetros.
     * 
     * @param correo Es la dirección de correo electrónico del receptor.
     * @param asunto Asunto del correo a enviar
     * @param texto Contenido del correo a enviar
     * @param archivo Es la dirección del archivo adjunto.
     * 
     * @return true si el correo se envía correctamente, false en caso contrario.
     */
    
    public static boolean enviarCorreo(String correo, String asunto, String texto, String archivo){
	//Autenticar información
	final String username = "pruebaproyecto1poo@gmail.com";
	final String password = "PruebaPOO";
	String fromEmail = "pruebaproyecto1poo@gmail.com";
	String toEmail = correo;
		
	Properties properties = new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");
		
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username,password);
            }
	});
	//Mensaje
	MimeMessage msg = new MimeMessage(session);
                
	try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject(asunto);

            Multipart emailContent = new MimeMultipart();

            //Texto
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(texto);

            //Archivo
            MimeBodyPart PdfAttachment = new MimeBodyPart();
            PdfAttachment.attachFile(archivo);

            //Adjuntar texto y archivo
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(PdfAttachment);	

            //Adjuntar contenido
            msg.setContent(emailContent);

            Transport.send(msg);
	} catch (MessagingException e) {
            return false;
	} catch (IOException e){
            return false;
        }
        return true;
    }
    
}