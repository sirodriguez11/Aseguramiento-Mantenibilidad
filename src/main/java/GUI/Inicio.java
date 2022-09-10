package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.formdev.flatlaf.FlatDarculaLaf;

import Controlador.AdministradorAplicacion;

import Modelo.EmpresaMantenimiento;
import Modelo.Operador;
import Modelo.Reserva;
import Modelo.Servicio;
import Modelo.TEstilo;
import Modelo.Vehiculo;

/**
 * Esta clase es el núcleo del programa, aquí se ubica el main y se crean las ventanas.
 * @since 22/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, 
 * Silvia Melissa Rodríguez Fernández
 *
 */
public class Inicio {

    // Se define el administrador principal del programa
    public static AdministradorAplicacion adminApp = new AdministradorAplicacion();

    // En este bloque se encuentran las listas principales que contendrán los datos del sistema
    static ArrayList<Operador> listaOperadores = Inicio.adminApp.getListaOperadores();
    static ArrayList<Vehiculo> listaVehiculos  = Inicio.adminApp.getListaVehiculos();
    static String[] listaSedes = {"", "Zapote", "Cartago", "Heredia", "Uruca" };
    public static ArrayList<Reserva> listaReservas   = Inicio.adminApp.getListaReservas();
    static ArrayList<Servicio> listaServicios  = Inicio.adminApp.getListaServicios();
    static ArrayList<EmpresaMantenimiento> listaEmpresas = 
            Inicio.adminApp.getListaEmpresasMantenimiento();
    static TEstilo[] listaEstilos = {null, TEstilo.Compacto, TEstilo.PickUp, 
        TEstilo.Intermedio, TEstilo.SUV, TEstilo.MiniVan, TEstilo.Convertible,
        TEstilo.Económico};
    
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    // En este bloque se instancian las ventanas principales del programa
    static ImageIcon img;
    static LoginFrame frameLogin;
    static MenuPrincipal frameMenuPrincipal;
    static RegistrarOperador frameRegistrarOperador;
    static RegistrarCliente frameRegistrarCliente;
    static RealizarReserva frameRealizarReserva;
    static ConsultarReserva frameConsultarReserva;
    static MenuAdministrador frameMenuAdministrador;
    static AgregarVehiculo frameAgregarVehiculo;
    static AgregarServicio frameAgregarServicio;
    static AgregarEmpresa frameAgregarEmpresa;
    static Reservas frameRes;
    static EditarVehiculo frameEditarVehiculo;
    static SeleccionarVehículo frameSeleccionadoVehículo;
    static Detalles frameDetallesVehículo;
    static ConfirmarReserva frameConfirmarReserva;

    /**
     * Este método define las características de la ventana de agregar empresa y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es
     * visible o no en determinado momento
     */
    public static void VentanaAgregarEmpresa(boolean visibilidad) {
        frameAgregarEmpresa.setTitle("Rent a Car - Agregar Empresa");
        frameAgregarEmpresa.setVisible(visibilidad);
        frameAgregarEmpresa.setBounds(560, 140, 400, 600);
        center(frameAgregarEmpresa);
        frameAgregarEmpresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarEmpresa.setResizable(false);
        frameAgregarEmpresa.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de agregar servicio y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es
     * visible o no en determinado momento
     */
    public static void VentanaAgregarServicio(boolean visibilidad) {
        frameAgregarServicio.setTitle("Rent a Car - Menú Administrador - Agregar Servicio");
        frameAgregarServicio.setVisible(visibilidad);
        frameAgregarServicio.setBounds(560, 140, 400, 600);
        center(frameAgregarServicio);
        frameAgregarServicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarServicio.setResizable(false);
        frameAgregarServicio.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de agregar vehículo y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es
     * visible o no en determinado momento
     */
    public static void VentanaAgregarVehiculo(boolean visibilidad) {
        frameAgregarVehiculo.setTitle("Rent a Car - Menú Administrador - Agregar Vehículo");
        frameAgregarVehiculo.setVisible(visibilidad);
        frameAgregarVehiculo.setBounds(400, 100, 750, 650);
        center(frameAgregarVehiculo);
        frameAgregarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarVehiculo.setResizable(false);
        frameAgregarVehiculo.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de confirmar reserva y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es
     * visible o no en determinado momento
     */
    public static void VentanaConfirmarReserva(boolean visibilidad) {
        frameConfirmarReserva.setTitle("Rent a Car - Consultar");
        frameConfirmarReserva.setVisible(visibilidad);
        frameConfirmarReserva.setBounds(500, 50, 600, 700);
        center(frameConfirmarReserva);
        frameConfirmarReserva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameConfirmarReserva.setResizable(true);
        frameConfirmarReserva.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de consultar reserva y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaConsultarReserva(boolean visibilidad) {
        frameConsultarReserva.setTitle("Rent a Car - Consultar Reserva");
        frameConsultarReserva.setVisible(visibilidad);
        frameConsultarReserva.setBounds(450, 200, 650, 450);
        center(frameConsultarReserva);
        frameConsultarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConsultarReserva.setResizable(false);
        frameConsultarReserva.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana que posee los detalles del vehículo y su 
     * visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaDetallesVehículo(boolean visibilidad) {
        frameDetallesVehículo.setTitle("Rent a Car - Detalles del Vehículo");
        frameDetallesVehículo.setVisible(visibilidad);
        frameDetallesVehículo.setBounds(200, 30, 850, 650);
        center(frameDetallesVehículo);
        frameDetallesVehículo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDetallesVehículo.setResizable(false);
        frameDetallesVehículo.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de editar vehículo y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaEditarVehiculo(boolean visibilidad) {
        frameEditarVehiculo.setTitle("Rent a Car - Menú Administrador - Editar Vehículo");
        frameEditarVehiculo.setVisible(visibilidad);
        frameEditarVehiculo.setBounds(200, 30, 850, 650);
        center(frameEditarVehiculo);
        frameEditarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarVehiculo.setResizable(false);
        frameEditarVehiculo.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de login y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaLogin(boolean visibilidad) {
        frameLogin.setTitle("Rent a Car - Inicio de Sesión");
        frameLogin.setVisible(visibilidad);
        frameLogin.setBounds(410, 190, 700, 450);
        center(frameLogin);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana del menú de administrador y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaMenuAdministrador(boolean visibilidad) {
        frameMenuAdministrador.setTitle("Rent a Car - Menú Administrador");
        frameMenuAdministrador.setVisible(visibilidad);
        frameMenuAdministrador.setBounds(450, 200, 650, 400);
        center(frameMenuAdministrador);
        frameMenuAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuAdministrador.setResizable(false);
        frameMenuAdministrador.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de menú principal y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaMenuPrincipal(boolean visibilidad) {
        frameMenuPrincipal.setTitle(" Plataforma Rent a Car");
        frameMenuPrincipal.setVisible(visibilidad);
        frameMenuPrincipal.setBounds(410, 190, 700, 450);
        center(frameMenuPrincipal);
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.setResizable(false);
        frameMenuPrincipal.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de realizar reserva y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaRealizarReserva(boolean visibilidad) {
        frameRealizarReserva.setTitle("Rent a Car - Realizar Reserva");
        frameRealizarReserva.setVisible(visibilidad);
        frameRealizarReserva.setBounds(500, 30, 950, 650);
        center(frameRealizarReserva);
        frameRealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRealizarReserva.setResizable(false);
        frameRealizarReserva.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de registrar cliente y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaRegistrarCliente(boolean visibilidad) {
        frameRegistrarCliente.setTitle("Rent a Car - Registrar Cliente");
        frameRegistrarCliente.setVisible(visibilidad);
        frameRegistrarCliente.setBounds(500, 30, 400, 650);
        center(frameRegistrarCliente);
        frameRegistrarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarCliente.setResizable(false);
        frameRegistrarCliente.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de registrar operador y su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaRegistrarOperador(boolean visibilidad) {
        frameRegistrarOperador.setTitle("Rent a Car - Registrar Operador");
        frameRegistrarOperador.setVisible(visibilidad);
        frameRegistrarOperador.setBounds(500, 30, 400, 450);
        center(frameRegistrarOperador);
        frameRegistrarOperador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarOperador.setResizable(false);
        frameRegistrarOperador.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana que contiene los datos de la reserva y 
     * su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaReserva(boolean visibilidad) {
        frameRes.setTitle("Rent a Car - Consultar");
        frameRes.setVisible(visibilidad);
        frameRes.setBounds(500, 50, 600, 700);
        center(frameRes);
        frameRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRes.setResizable(true);
        frameRes.setIconImage(img.getImage());
    }

    /**
     * Este método define las características de la ventana de los datos del vehículo seleccionado y 
     * su visibilidad
     * @param visibilidad Recibe como parámetro un valor booleano que define si la ventana es 
     * visible o no en determinado momento
     */
    public static void VentanaSeleccionadoVehículo(boolean visibilidad) {
        frameSeleccionadoVehículo.setTitle("Rent a Car - Seleccionando Vehículo");
        frameSeleccionadoVehículo.setVisible(visibilidad);
        frameSeleccionadoVehículo.setBounds(200, 30, 850, 450);
        center(frameSeleccionadoVehículo);
        frameSeleccionadoVehículo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSeleccionadoVehículo.setResizable(false);
        frameSeleccionadoVehículo.setIconImage(img.getImage());
    }

    /**
     * Centra las ventanas en la pantalla sin importar la resolución en la que se corra el programa
     * @param J Este parámetro es de tipo JFrame y se utiliza para saber cuál ventana centrar
     */
    public static void center(JFrame J) {
        J.setLocation(dim.width / 2 - J.getSize().width / 2, dim.height / 2 - J.getSize().height / 2);
    }

    /**
     * Método main()
     * @param a
     */
    public static void main(String[] a) {
        
        FlatDarculaLaf.install();    // Se carga el tema oscuro

        // Bloque para cargar la información de los archivos JSON
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        adminApp.cargarInformacionJSON("reservas.json", "Reserva");
        adminApp.inicializarServiciosEspeciales();

        // Se inicializan las ventanas e imagenes
        img = new ImageIcon("src\\main\\java\\img\\A.png");
        frameLogin = new LoginFrame();
        frameMenuPrincipal = new MenuPrincipal();
        frameRegistrarOperador = new RegistrarOperador();
        frameRegistrarCliente = new RegistrarCliente();
        frameRealizarReserva = new RealizarReserva();
        frameConsultarReserva = new ConsultarReserva();
        frameMenuAdministrador = new MenuAdministrador();
        frameAgregarVehiculo = new AgregarVehiculo();
        frameAgregarServicio = new AgregarServicio();
        frameAgregarEmpresa = new AgregarEmpresa();
        frameRes = new Reservas();
        frameConfirmarReserva = new ConfirmarReserva();
        frameEditarVehiculo = new EditarVehiculo();
        frameSeleccionadoVehículo = new SeleccionarVehículo();
        frameDetallesVehículo = new Detalles();
        VentanaLogin(true);
        
    }
}

