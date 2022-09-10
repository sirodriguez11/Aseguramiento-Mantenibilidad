package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
/**
 * Esta clase hereda de JFrame, esta ventana permite al usuario ingresar al sistema con sus 
 * credenciales
 * @since 22/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 * 
 */

public final class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("Nombre de Usuario");
    JLabel passwordLabel = new JLabel("Contraseña");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Iniciar Sesión");
    JButton resetButton = new JButton("Resetear");
    JCheckBox showPassword = new JCheckBox("Mostrar Contraseña");
    
    ImageIcon icon = new ImageIcon("src\\main\\java\\img\\loginP.jpg");
    JLabel Picture = new JLabel(icon);
    Image imagenSinResize = icon.getImage();
    Image ImagenFinal = imagenSinResize.getScaledInstance(250, 450, Image.SCALE_SMOOTH);
    
 
 
    LoginFrame() {

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        icon = new ImageIcon(ImagenFinal);
        Picture.setIcon(icon);
 
    }
 
    /**
     *
     */
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    /**
     *
     */
    public void setLocationAndSize() {
        
        userLabel.setBounds(50, 150, 150, 30);
        passwordLabel.setBounds(50, 220, 150, 30);
        userTextField.setBounds(210, 150, 150, 30);
        passwordField.setBounds(210, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds((200-150/2), 300, 150, 30);
        resetButton.setBounds((200-150/2), 340, 150, 30);
        Picture.setBounds(450, 0, 250, 450);
 
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        
        container.add(Picture);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    /**
     *
     */
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

            boolean passcheck = false;
            
            String usrText = userTextField.getText();
            String pwdText = passwordField.getText();
            
            for (int i = 0; i < Inicio.listaOperadores.size(); i++) {
                    if(usrText.equals(Inicio.listaOperadores.get(i).getUsername()) && 
                            pwdText.equals(Inicio.listaOperadores.get(i).getContraseña())){
                        passcheck=true;
                        JOptionPane.showMessageDialog(this, "Inicio de Sesión Aceptado");
                        passwordField.setText("");
                        userTextField.setText("");
                        Inicio.VentanaMenuPrincipal(true);
                        Inicio.VentanaLogin(false);
                        Inicio.listaOperadores.get(i).setEstado(true);
                        MenuPrincipal.NombreUsuario.setText(Inicio.listaOperadores.get(i).getNombreCompleto());
                    }
                }
            if (!passcheck){
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña inválidos");
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}