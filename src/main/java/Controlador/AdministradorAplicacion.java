/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Utilitaria.formatoFecha;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Modelo.Servicio;
import Modelo.Cliente;
import Modelo.Operador;
import Modelo.Vehiculo;
import Modelo.EmpresaMantenimiento;
import Modelo.Reserva;
import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TLicencia;
import Modelo.TServicio;
import Modelo.TTransmision;

/**
 * Esta clase permite la comunicación entre la interfaz gráfica, las clases de 
 * la capa Modelo y los archivos JSON.
 * @since 24/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo 
 * Sandoval, Silvia Melissa Rodríguez Fernández
 */

public class AdministradorAplicacion {
    
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Operador> listaOperadores = new ArrayList<Operador>();
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
    private ArrayList<EmpresaMantenimiento> listaEmpresasMantenimiento = 
            new ArrayList<EmpresaMantenimiento>();
    private ArrayList<Servicio> listaServicios = new ArrayList<Servicio>();
    private ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
    private HashMap<String, Double> serviciosEspeciales = 
            new HashMap<String, Double>();
    private int numeroFactura;
    
    /**
     * Este método verifica que la cédula del cliente es 
     * única, llama al constructor de la clase Cliente y agrega
     * la instancia a la lista de clientes del administrador.
     * 
     * @param nombreCompleto 
     * @param cedula Es el identificador del cliente.
     * @param direccionExacta
     * @param correoElectronico
     * @param telefono
     * @param numeroLicencia
     * @param fechaEmisionLicencia
     * @param tipoLicencia
     * @param fechaExpiracionLicencia
     * @param imagen
     * @param lectura Indica si el registro de cliente debe omitir la escritura 
     * en el archivo JSON. 
     * 
     * @return true si la cédula es única, false en caso contrario.
     */
    
    public boolean registrarCliente(String nombreCompleto, String cedula, 
            String direccionExacta, String correoElectronico, 
                   String telefono, String numeroLicencia, 
                   Calendar fechaEmisionLicencia, TLicencia tipoLicencia, 
                   Calendar fechaExpiracionLicencia, String imagen, 
                   boolean lectura)
    {
        if(obtenerCliente(cedula) == null) {
            Cliente nuevoCliente = new Cliente(nombreCompleto, cedula, 
            direccionExacta, correoElectronico, telefono, numeroLicencia, 
            fechaEmisionLicencia, tipoLicencia, fechaExpiracionLicencia,imagen);
            listaClientes.add(nuevoCliente);
            
            if(!lectura) {
                agregarInformacionJSON("clientes.json","Cliente");
            }
            return true;
        }
        return false;
    }
    
    /**
     * Este método verifica que la placa del vehículo es 
     * única, llama al constructor de la clase Vehículo y agrega
     * la instancia a la lista de vehículos del administrador.
     * 
     * @param placa Es el identificador del vehículo.
     * @param añoFabricacion 
     * @param estilo
     * @param color
     * @param marca
     * @param capacidad
     * @param kilometraje
     * @param numeroPuertas
     * @param numeroVin
     * @param mpg
     * @param sede
     * @param costoDiario
     * @param capacidadMaletas
     * @param tipoTransmision
     * @param estado
     * @param listaServiciosRelacionados
     * @param imagen
     * @param lectura Indica si el registro de vehículo debe omitir la escritura 
     * en el archivo JSON. 
     * @return true si la placa es única, false en caso contrario.
     */
    
    public boolean registrarVehiculo(String placa, int añoFabricacion, 
            TEstilo estilo, String color, String marca, int capacidad, 
            double kilometraje, int numeroPuertas, String numeroVin, double mpg, 
            String sede, double costoDiario, int capacidadMaletas, 
            TTransmision tipoTransmision, TEstado estado, 
            ArrayList<Servicio> listaServiciosRelacionados, String imagen, 
            boolean lectura)
    {
        if(obtenerVehiculo(placa) == null) {
            Vehiculo nuevoVehiculo = new Vehiculo(placa, añoFabricacion, estilo,
            color, marca, capacidad, kilometraje, numeroPuertas, numeroVin, mpg,
            sede, costoDiario, capacidadMaletas, tipoTransmision, estado, 
            listaServiciosRelacionados, imagen);
            listaVehiculos.add(nuevoVehiculo);
            if(!lectura) {
                agregarInformacionJSON("vehiculos.json", "Vehiculo");
            }
            return true;
        }
        return false;
    }
    
    /**
     * Este método verifica que la cédula jurídica de la 
     * empresa es única, llama al constructor de la clase EmpresaMantenimiento y
     * agrega la instancia a la lista de empresas del administrador.
     * 
     * @param razonSocial
     * @param numeroCedula Es el identificador de la empresa de mantenimiento.
     * @param telefono
     * @param provincia
     * @param canton
     * @param distrito
     * @param señas
     * @param lectura Indica si el registro de empresa debe omitir la escritura 
     * en el archivo JSON. 
     * 
     * @return true si la cédula jurídica es única, false en caso contrario.
     */
    
    public boolean registrarEmpresaServicios(String razonSocial, 
            String numeroCedula, String telefono, String provincia, 
            String canton, String distrito, String señas, boolean lectura)
    {
        if(obtenerEmpresa(numeroCedula) == null) {
            EmpresaMantenimiento nuevaEmpresa = 
            new EmpresaMantenimiento(razonSocial, numeroCedula, telefono, 
            provincia,canton, distrito, señas);
            
            listaEmpresasMantenimiento.add(nuevaEmpresa);
            if(!lectura) {
                agregarInformacionJSON("empresas.json","Empresa");
            }
            return true;
        }
        return false;
    }
    
    /**
     * Este método verifica que el identificador del servicio 
     * es único, llama al constructor de la clase Servicio y
     * agrega la instancia a la lista de servicios del administrador.
     * 
     * @param identificador
     * @param fechaInicio
     * @param fechaFinalizacion
     * @param montoPagado
     * @param detalles
     * @param tipo
     * @param empresaRelacionada
     * @param lectura Indica si el registro de servicio debe omitir la escritura 
     * en el archivo JSON.
     * 
     * @return true si el identificador es único, false en caso contrario.
     */
    
    public boolean registrarNuevoServicio(int identificador, 
            Calendar fechaInicio, Calendar fechaFinalizacion, 
            double montoPagado, String detalles, TServicio tipo, 
            EmpresaMantenimiento empresaRelacionada, boolean lectura)
    {
        if(obtenerServicio(identificador) == null) {
            Servicio nuevoServicio = new Servicio(identificador, fechaInicio, 
            fechaFinalizacion, montoPagado, detalles, tipo, empresaRelacionada);
            
            listaServicios.add(nuevoServicio);
            
            if(!lectura) {
                agregarInformacionJSON("servicios.json","Servicio");
            }
            return true;
        }
        return false;
    }
    
    /**
     * Este método verifica que el correo electrónico del 
     * operador es único, llama al constructor de la clase 
     * Operador y agrega la instancia a la lista de operadores del administrador
     * 
     * @param correoElectronico Es el identificador de operador.
     * @param contraseña
     * @param nombreCompleto
     * @param estado
     * @param lectura Indica si el registro de operador debe omitir la escritura
     * en el archivo JSON. 
     * 
     * @return true si el correo es único, false en caso contrario.
     */
    
    public boolean registrarOperador(String correoElectronico, 
            String contraseña, String nombreCompleto, boolean estado, 
            boolean lectura)
    {
        if(obtenerOperador(correoElectronico) == null) {
            Operador nuevoOperador = new Operador(correoElectronico, contraseña,
            nombreCompleto, estado);
            listaOperadores.add(nuevoOperador);
            if(!lectura) {
                agregarInformacionJSON("operadores.json","Operador");
            }
            return true;
        }
        return false;
    }
    
    /**
     * Este método llama al constructor de la clase Reserva, 
     * agrega la instancia a la lista de reservas del administrador e incrementa
     * el número de factura consecutivo.
     * 
     * @param sedeRecogida
     * @param sedeEntrega
     * @param fechaInicio
     * @param fechaFinalizacion
     * @param fechaSolicitud
     * @param operador
     * @param vehiculoSeleccionado
     * @param clienteRelacionado
     * @param serviciosOpcionales
     * @param lectura Indica si el registro de reserva debe omitir la escritura 
     * en el archivo JSON. 
     * 
     * @return true una vez completada la reserva.
     */
    
    public boolean realizarReserva(String sedeRecogida, String sedeEntrega, 
            Calendar fechaInicio, Calendar fechaFinalizacion, 
            Calendar fechaSolicitud, Operador operador, 
            Vehiculo vehiculoSeleccionado, Cliente clienteRelacionado, 
            HashMap serviciosOpcionales, boolean lectura)
    {
        Reserva nuevaReserva = new Reserva(sedeRecogida, sedeEntrega, 
                fechaInicio, fechaFinalizacion, fechaSolicitud, operador,
                vehiculoSeleccionado, clienteRelacionado, serviciosOpcionales, 
                numeroFactura);
        listaReservas.add(nuevaReserva);
        System.out.println(nuevaReserva);
        if(!lectura) {
            agregarInformacionJSON("reservas.json","Reserva");
        }
        numeroFactura++;
        return true;
    }
    
    /**
     * Este método busca el vehículo registrado con la placa en la lista de 
     * vehículos del administrador.
     * 
     * @param pId Es la placa de un vehículo.
     * 
     * @return Vehiculo si la placa está en la lista de vehículos del 
     * administrador, null en caso contrario.
     */
    
    public Vehiculo obtenerVehiculo(String pID)
    {
        Vehiculo elVehiculo;
        for(int i = 0; i < listaVehiculos.size(); i++)
        {
            elVehiculo = listaVehiculos.get(i);
            if(elVehiculo.getPlaca().equals(pID))
            {
                return elVehiculo;
            }
        }
        return null;
    }
    
    /**
     * Este método busca el correo en la lista de operadores del administrador.
     * 
     * @param pCorreo Es el correo de un operador.
     * 
     * @return Operador si el correo está en la lista de operadores del 
     * administrador, null en caso contrario.
     */
    
    public Operador obtenerOperador(String pCorreo)
    {
        Operador elOperador;
        for(int i = 0; i < listaOperadores.size(); i++)
        {
            elOperador = listaOperadores.get(i);
            if(elOperador.getCorreoElectronico().equals(pCorreo))
            {
                return elOperador;
            }
        }
        return null;
    }
    
    /**
     * Este método busca la cédula en la lista de clientes del administrador.
     * 
     * @param pId Es la cédula de un cliente.
     * 
     * @return Cliente si la cédula está en la lista de clientes del 
     * administrador, null en caso contrario.
     */
    
    public Cliente obtenerCliente(String pId)
    {
        Cliente elCliente;
        for(int i = 0; i < listaClientes.size(); i++)
        {
            elCliente = listaClientes.get(i);
            if(elCliente.getCedula().equals(pId))
            {
                return elCliente;
            }
        }
        return null;
    }
    
    /**
     * Este método busca el identificador en la lista de servicios del 
     * administrador.
     * 
     * @param pId Es el identificador de un servicio.
     * 
     * @return Servicio si el identificador está en la lista de servicios del 
     * administrador, null en caso contrario.
     */
    
    public Servicio obtenerServicio(int pId)
    {
        Servicio elServicio;
        for(int i = 0; i < listaServicios.size(); i++)
        {
            elServicio = listaServicios.get(i);
            if(elServicio.getIdentificador()== pId)
            {
                return elServicio;
            }
        }
        return null;
    }
    
    /**
     * Este método busca el número de factura en la lista de reservas del 
     * administrador.
     * 
     * @param pId Es el número de factura de una reserva.
     * 
     * @return Reserva si el número está en la lista de reservas del 
     * administrador, null en caso contrario.
     */
    
    public Reserva obtenerReserva(int pId)
    {
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            if(laReserva.getNumeroFactura() == pId)
            {
                return laReserva;
            }
        }
        return null;
    }
    
    /**
     * Este método busca la cédula jurídica en la lista de empresas del 
     * administrador.
     * 
     * @param pId Es la cédula jurídica de una empresa de mantenimiento.
     * 
     * @return EmpresaMantenimiento si la cédula está en la lista de empresas
     * del administrador, null en caso contrario.
     */
    
    public EmpresaMantenimiento obtenerEmpresa(String pId)
    {
        EmpresaMantenimiento laEmpresa;
        for(int i = 0; i < listaEmpresasMantenimiento.size(); i++)
        {
            laEmpresa = listaEmpresasMantenimiento.get(i);
            if(laEmpresa.getNumeroCedula().equals(pId))
            {
                return laEmpresa;
            }
        }
        return null;
    }
    
    /**
     * Este método retorna el número de factura actual.
     * 
     * @return int con el atributo numeroFactura.
     */
    
    public int getNumeroFactura() {
        return numeroFactura;
    }
    
    /**
     * Este método retorna el diccionario de servicios especiales.
     * @return HashMap con el atributo serviciosEspeciales.
     */
    
    public HashMap getServiciosEspeciales() {
        return serviciosEspeciales;
    }
    
    /**
     * Este método agrega los nombres y precios de los servicios especiales en 
     * el diccionario del atributo
     * serviciosEspeciales.
     */
    
    public void inicializarServiciosEspeciales() {
        serviciosEspeciales.put("WiFi limitado", 15.0);
        serviciosEspeciales.put("Asistencia en carretera", 3.99);
        serviciosEspeciales.put("GPS", 13.99);
        serviciosEspeciales.put("Asiento para niño", 6.99);
        serviciosEspeciales.put("Cobertura por daños a terceros", 12.99);
    }
    
    /**
     * Este método coloca los nombres de los
     * servicios especiales y sus respectivos precios, obtenidos del atributo
     * serviciosEspeciales, en un nuevo diccionario.
     * 
     * @param serviciosSeleccionados Es un ArrayList con los nombres de los 
     * servicios especiales seleccionados. 
     * @return HashMap de servicios especiales seleccionados durante la 
     * realización de una reserva.
     */
    
    public HashMap generarServiciosEspeciales(ArrayList<String> SEspeciales) {
        HashMap<String, Double> servicios = new HashMap<>();
        for(int i = 0; i < SEspeciales.size(); i++) {
            String nombreServicio = SEspeciales.get(i);
            servicios.put(nombreServicio, 
            serviciosEspeciales.get(nombreServicio));
        }
        return servicios;
    }
    
    /**
     * Este método recorre la lista de vehículos del administrador. Si el estado
     * del vehículo actual es activo y la lista de servicios relacionados está 
     * vacía, agrega el vehículo al ArrayList. Si el estado del vehículo
     * actual es activo y ningún lapso de tiempo de los servicios relacionados 
     * coincide con el comprendido en los
     * parámetros, entonces agrega el vehículo al ArrayList.
     * 
     * @param fInicio Es la fecha inicio de una reserva.
     * @param fFinal Es la fecha final de una reserva.
     * 
     * @return ArrayList de los vehículos cuyos servicios no coinciden con las 
     * fechas de la reserva.
     */
    
    public ArrayList<Vehiculo> filtrarTipoVehiculoSegunFecha(Calendar fInicio, 
            Calendar fFinal){
        ArrayList<Vehiculo> vehiculosSegunTipo = new ArrayList();
        Vehiculo elVehiculo;
        for(int i = 0; i < listaVehiculos.size(); i++)
        {
            elVehiculo = listaVehiculos.get(i);
            ArrayList<Servicio> listaServicios = 
            elVehiculo.getListaServiciosRelacionados();
            if(elVehiculo.getEstado() == TEstado.Activo)
            {
                if(listaServicios.isEmpty()){
                    vehiculosSegunTipo.add(elVehiculo);
                }
                else{
                    for(int j = 0; j < listaServicios.size(); j++){
                        Servicio elServicio = listaServicios.get(j);
                        if(fInicio.before(elServicio.getFechaInicio())&& 
                           fFinal.after(elServicio.getFechaFinalizacion())){}
                        else if(fFinal.after(elServicio.getFechaInicio())&& 
                           fFinal.before(elServicio.getFechaFinalizacion())){}
                        else if(fInicio.after(elServicio.getFechaInicio())&& 
                           fInicio.before(elServicio.getFechaFinalizacion())){}
                        else if(fInicio.after(elServicio.getFechaInicio())&& 
                           fFinal.before(elServicio.getFechaFinalizacion())){}
                        else{
                            vehiculosSegunTipo.add(elVehiculo);
                        }
                    }
                }
            }
        }
        return vehiculosSegunTipo;
    }
    
    /**
     * Este método recorre la lista de vehículos 
     * y agrega a un nuevo ArrayList aquellos vehículos que poseen el
     * mismo estilo indicado.
     * 
     * @param estilo
     * @param listaActVehiculos Lista de vehículos retornada por el método 
     * filtrarTipoVehiculoSegúnFecha. 
     * 
     * @return ArrayList de los vehículos que poseen el estilo recibido.
     */
    
    public ArrayList<Vehiculo> filtrarTipoVehiculoSegunEstilo(TEstilo estilo, 
        ArrayList<Vehiculo> listaActVehiculos)
    {
        ArrayList<Vehiculo> vehiculosSegunEstilo = new ArrayList();
        Vehiculo elVehiculo;
        for(int i = 0; i < listaActVehiculos.size(); i++)
        {
            elVehiculo = listaActVehiculos.get(i);
            if(elVehiculo.getEstilo() == estilo)
            {
                vehiculosSegunEstilo.add(elVehiculo);
            }
        }
        return vehiculosSegunEstilo;
    }
    
    /**
     * Este método recorre la lista de reservas y agrega a un nuevo ArrayList 
     * aquellas reservas que poseen el mismo operador indicado.
     * 
     * @param pNombreCompleto Nombre del operador que realiza la reserva
     * 
     * @return ArrayList de las reservas realizadas por el operador recibido.
     */
    
    public ArrayList<Reserva> filtrarReservaOperador(String pNombreCompleto)
    {
        ArrayList<Reserva> reservasSegunOperador = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            Operador elOperador = laReserva.getOperador();
            if(elOperador.getNombreCompleto().equals(pNombreCompleto))
            {
                reservasSegunOperador.add(laReserva);
            }
        }
        return reservasSegunOperador;
    }
    
    /**
     * Este método recorre la lista de reservas y agrega a un nuevo ArrayList 
     * aquellas reservas que poseen la misma sede de recogida indicada.
     * 
     * @param pSedeRecogida String con el nombre de la sede incluida en la reserva
     * 
     * @return ArrayList de las reservas que poseen la sede de recogida recibida
     */
    
    public ArrayList<Reserva> filtrarReservaRecogida(String pSedeRecogida)
    {
        ArrayList<Reserva> reservasSegunRecogida = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            if(laReserva.getSedeRecogida().equals(pSedeRecogida))
            {
                reservasSegunRecogida.add(laReserva);
            }
        }
        return reservasSegunRecogida;
    }
    
    /**
     * Este método recorre la lista de reservas y agrega a un nuevo ArrayList 
     * aquellas reservas que poseen el mismo vehículo indicado.
     * 
     * @param pPlaca Vehículo asociado con la reserva a buscar
     * 
     * @return ArrayList de las reservas que poseen el vehículo recibido.
     */
    
    public ArrayList<Reserva> filtrarReservaVehiculo(String pPlaca)
    {
        ArrayList<Reserva> reservasSegunVehiculo = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            Vehiculo elVehiculo= laReserva.getVehiculoSeleccionado();
            if(elVehiculo.getPlaca().equals(pPlaca))
            {
                reservasSegunVehiculo.add(laReserva);
            }
        }
        return reservasSegunVehiculo;
    }
    
    /**
     * 
     * Este método recorre la lista de reservas y agrega a un nuevo ArrayList 
     * aquellas reservas que poseen la misma fecha de inicio indicada.
     * 
     * @param pFInicio Calendar con la fecha de inicio de las reservas que se
     * pretenden obtener
     * 
     * @return ArrayList con las reservas que cumplen la fecha de inicio
     * indicada como parámetro
     */
    
    public ArrayList<Reserva> filtrarReservaInicio(Calendar pFInicio)
    {
        ArrayList<Reserva> reservasSegunInicio = new ArrayList<Reserva>();
        for(Reserva R: listaReservas)
        {
            if(R.getFechaInicio().get(Calendar.DAY_OF_YEAR)==pFInicio.get(Calendar.DAY_OF_YEAR) &&
                    R.getFechaInicio().get(Calendar.YEAR)==pFInicio.get(Calendar.YEAR))
            {
                reservasSegunInicio.add(R);
            }
        }
        return reservasSegunInicio;
    }
   
    /**
     * Este método genera una contraseña colocando un caracter especial al 
     * inicio, números aleatorios hasta la mitad de la longitud de la contraseña,
     * letras minúsculas y mayúsculas alternadas en los caracteres restantes.
     * 
     * @return String con una contraseña única.
     */
    
    public static String generarContraseña()
    {
        Random random = new Random();
        int[] posiblesLongitudes = {8, 9, 10, 11, 12};
        char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numeros = "0123456789".toCharArray();
        char[] caracteresEspeciales = "!#$?@^~".toCharArray();
        int mayusLong = mayusculas.length;
        int minusLong = minusculas.length;
        int numerosLong = numeros.length;
        int especialesLong = caracteresEspeciales.length;       

        String contraseña = "";
        int size = posiblesLongitudes[random.nextInt(5)];
        int numero = (int)(Math.random()*2);
        for(int i = 0; i < size; i++)
        {
            if (i == 0)
            {
                contraseña += caracteresEspeciales[random.nextInt(especialesLong)];
            }
            else if(i < size/2)
            {
                contraseña += numeros[random.nextInt(numerosLong)];
            }
            else
            {
                if(numero == 1)
                {
                    if(i % 2 == 0)
                    {
                        contraseña += mayusculas[random.nextInt(mayusLong)];
                    }
                    else
                    {
                        contraseña += minusculas[random.nextInt(minusLong)];
                    }
                }
                else
                {
                    if(i % 2 != 0)
                    {
                        contraseña += mayusculas[random.nextInt(mayusLong)];
                    }
                    else
                    {
                        contraseña += minusculas[random.nextInt(minusLong)];
                    }
                }
            }
        }
        return contraseña;
    }
    
    /**
     * Este método verifica que la placa tenga la longitud, estructura y 
     * contenido adecuados. Si la longitud es de 6 caracteres, entonces la placa
     * debe contener únicamente números. Si la longitud es de 7 caracteres, 
     * entonces la placa debe tener tres letras, un guión y tres números.
     * 
     * @param placa String con la placa relacionada a las reservas que se desean
     * obtener
     * 
     * @return true si la placa cumple con los requisitos, false en caso 
     * contrario.
     */
    
    public boolean verificarPlaca(String placa)
    {
        if(placa.length() != 6 && placa.length() != 7)
        {
            return false;
        }
        else if(placa.length() == 6)
        {
            Pattern patron = Pattern.compile("0-9");
            Matcher comparador = patron.matcher(placa);        
            return comparador.find();
        }
        else
        {
            if(placa.charAt(3) != '-')
            {
                return false;
            }
            else
            {
                Pattern patron2 = Pattern.compile("[a-zA-Z][-][0-9]");
                Matcher comparador = patron2.matcher(placa);        
                return comparador.find();
            }
        }
    }
    
    /**
     * Este método verifica que la estructura del correo electrónico es válida.
     * 
     * @param correo String con el correo relacionado a las reservas que se 
     * desean obtener
     * 
     * @return true si el correo cumple con los requisitos, false en caso 
     * contrario.
     */
    
    public boolean verificarCorreo(String correo)
    {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)"
                       + "*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher comparador = patron.matcher(correo);
        return comparador.find();
    }
    
    /**
     * Este método verifica que la estructura del número telefónico es válida. 
     * Debe tener una longitud de 12 caracteres, los primeros cuatro deben ser 
     * el código telefónico de Costa Rica +506, el siguiente caracter debe ser 
     * 2, 6, 7 u 8, y los caracteres restantes deben ser numéricos.
     * 
     * @param Telefono String con el teléfono asociado a la reservas que se
     * desean obtener
     * 
     * @return true si el número telefónico cumple con los requisitos, false en
     * caso contrario.
     */
    
    public boolean verificarTelefono(String Telefono)
    {
        if (Telefono.length() != 12)
        {
            return false;
        }
        if(Telefono.charAt(0) != '+' && Telefono.charAt(1) != '5' && 
                Telefono.charAt(2) != '0'&& Telefono.charAt(3) != '6')
        {
            return false;
        }
        if(Telefono.charAt(4) != '2' && Telefono.charAt(4) != '8' 
          && Telefono.charAt(4) != '6' && Telefono.charAt(4) != '7')
            
        {
            return false;
        }
        for(int i = 5; i < 12; i++)
        {
            if(Telefono.charAt(i) != '1' && Telefono.charAt(i) != '2' && 
                    Telefono.charAt(i) != '3' &&
               Telefono.charAt(i) != '4' && Telefono.charAt(i) != '5' && 
                    Telefono.charAt(i) != '6' &&
               Telefono.charAt(i) != '7' && Telefono.charAt(i) != '8' && 
                    Telefono.charAt(i) != '9' &&
               Telefono.charAt(i) != '0')
            {
                return false;
            }
        }
        return true;       
    }
    
    /**
     * Este método lee el archivo y llama al método registrarDato para agregar 
     * los elementos del objeto indicado
     * en la lista del administrador que corresponde.
     * 
     * @param archivo Es el nombre del archivo JSON.
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * 
     * @return true si la lectura del archivo JSON finalizó correctamente, 
     * false en caso contrario.
     */
    
    public boolean cargarInformacionJSON(String archivo, String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(archivo)) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaDatosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaDatosJSON.size(); i++) {
                JSONObject objetoDato = (JSONObject) listaDatosJSON.get(i);
                JSONObject dato = (JSONObject) objetoDato.get(nombreObjeto);
                registrarDato(dato, nombreObjeto);
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Este método llama al método Registrar del objeto indicado. Los parámetros
     * de dicho método se obtienen de dato, los atributos son convertidos de 
     * strings JSON a los tipos de datos que solían tener previamente a la 
     * escritura del archivo JSON.
     * 
     * @param dato Es el objeto de JSON leído del archivo.
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * 
     */
    
    public void registrarDato(JSONObject dato, String nombreObjeto) {
        switch(nombreObjeto) {
            case "Cliente":
                registrarCliente((dato.get("Nombre")).toString(), 
                (dato.get("Cedula")).toString(), 
                (dato.get("Direccion")).toString(), 
                (dato.get("Correo")).toString(), 
                (dato.get("Telefono")).toString(), 
                (dato.get("Numero licencia")).toString(), 
                Utilitaria.obtenerFecha((dato.get("Fecha emision licencia")).toString()),
                TLicencia.valueOf((dato.get("Tipo licencia")).toString()), 
                Utilitaria.obtenerFecha((dato.get("Fecha expiracion licencia")).toString()), 
                (dato.get("Imagen")).toString(), true);
                
                break;
                
            case "Operador":
                registrarOperador((dato.get("Correo")).toString(), 
                        (dato.get("Contraseña")).toString(), 
                        (dato.get("Nombre")).toString(), 
                        Boolean.parseBoolean((dato.get("Estado")).toString()), 
                        true);
                break;
                
            case "Vehiculo":
                ArrayList<Servicio> listaServiciosRelacionados = new ArrayList<>();
                JSONArray servicios = (JSONArray) dato.get("Lista servicios relacionados");
                for(int i = 0; i < servicios.size(); i++) {
                    JSONObject servicioJSON = (JSONObject) servicios.get(i);
                    int identificador = Integer.parseInt((servicioJSON.get("Identificador")).toString());
                    registrarDato(servicioJSON, "Servicio");
                    listaServiciosRelacionados.add(obtenerServicio(identificador));
                }
                registrarVehiculo((dato.get("Placa")).toString(), 
                    Integer.parseInt((dato.get("Año fabricación")).toString()),
                        TEstilo.valueOf((dato.get("Estilo")).toString()), (dato.get("Color")).toString(), 
                            (dato.get("Marca")).toString(), Integer.parseInt((dato.get("Capacidad")).toString()), 
                                Double.parseDouble((dato.get("Kilometraje")).toString()),
                                    Integer.parseInt((dato.get("Numero puertas")).toString()), 
                                        (dato.get("Numero vin")).toString(), Double.parseDouble((dato.get("Mpg")).toString()), 
                                            (dato.get("Sede")).toString(), Double.parseDouble((dato.get("Costo diario")).toString()), 
                                                Integer.parseInt((dato.get("Capacidad maletas")).toString()), 
                                                    TTransmision.valueOf((dato.get("Transmision")).toString()), 
                                                        TEstado.valueOf(( dato.get("Estado")).toString()), 
                                                            listaServiciosRelacionados, (dato.get("Imagen")).toString(), true);
                break;
                
            case "Empresa":
                registrarEmpresaServicios((dato.get("Razon social")).toString(), 
                        (dato.get("Cedula")).toString(), 
                        (dato.get("Telefono")).toString(), 
                        (dato.get("Provincia")).toString(), 
                        (dato.get("Canton")).toString(), 
                        (dato.get("Distrito")).toString(),
                        (dato.get("Señas")).toString(), true);
                break;
                
            case "Servicio":
                JSONArray empresas = (JSONArray) dato.get("Empresa relacionada");
                JSONObject empresaJSON = (JSONObject) empresas.get(0);
                String cedulaJuridica = (empresaJSON.get("Cedula")).toString();
                registrarDato(empresaJSON, "Empresa");
                EmpresaMantenimiento empresa = obtenerEmpresa(cedulaJuridica);
                registrarNuevoServicio(Integer.parseInt((dato.get("Identificador")).toString()), 
                        Utilitaria.obtenerFecha((dato.get("Fecha inicio")).toString()),
                            Utilitaria.obtenerFecha((dato.get("Fecha final")).toString()), 
                                Double.parseDouble((dato.get("Monto pagado")).toString()),
                                       (dato.get("Detalles")).toString(), TServicio.valueOf((dato.get("Tipo")).toString()),
                                            empresa, true);
                break;
                
            case "Reserva":
                HashMap<String, Double> dicServiciosOpcionales = new HashMap<>();
                JSONArray serviciosOpcionales = (JSONArray) dato.get("Servicios opcionales");
                for(int i = 0; i < serviciosOpcionales.size(); i++) {
                    JSONObject par = (JSONObject) serviciosOpcionales.get(i);
                    dicServiciosOpcionales.put((par.get("Key")).toString(), Double.parseDouble((par.get("Value")).toString()));
                }
                realizarReserva((dato.get("Sede recogida")).toString(), (dato.get("Sede entrega")).toString(),
                    Utilitaria.obtenerFecha((dato.get("Fecha inicio")).toString()),
                        Utilitaria.obtenerFecha((dato.get("Fecha final")).toString()), 
                            Utilitaria.obtenerFecha((dato.get("Fecha solicitud")).toString()), 
                                obtenerOperador(buscarObjeto(dato, "Operador", "Correo")),
                                    obtenerVehiculo(buscarObjeto(dato, "Vehiculo", "Placa")), 
                                        obtenerCliente(buscarObjeto(dato, "Cliente", "Cedula")), 
                                            dicServiciosOpcionales, true);
                break;
                
            default:
                break;
        }
    }
    
    /**
     * Este método lee el archivo JSON y almacena su contenido en un arreglo de 
     * objetos JSON. Si el archivo está vacío, crea un nuevo arreglo. Se llama 
     * al método agregarDato para construir el objeto JSON con los datos del 
     * registro más reciente. Este objeto es empacado, agregado al arreglo y 
     * escrito en el archivo JSON.
     * 
     * @param nombreArchivo Nombre del archivo en el cual se cargará la
     * información
     * 
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * 
     * @return true si la escritura del archivo JSON finalizó correctamente.
     */
    
    public boolean agregarInformacionJSON(String nombreArchivo, 
            String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listaDatosJSON;
        try (FileReader reader = new FileReader(nombreArchivo)) {
            if(listaTieneDatos(nombreObjeto)) {
                Object objetos = jsonParser.parse(reader);
                listaDatosJSON = (JSONArray) objetos;
            } else {
                listaDatosJSON = new JSONArray();
            }
            JSONObject datoActualJSON = new JSONObject();
            datoActualJSON = agregarDato(datoActualJSON, nombreObjeto, true, 0);
            JSONObject paquete = new JSONObject();
            paquete.put(nombreObjeto, datoActualJSON);
            listaDatosJSON.add(paquete);
            try (FileWriter archivo = new FileWriter(nombreArchivo)) {
                archivo.write(listaDatosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
   
    /**
     * Este método emplea los métodos accesores de las clases de la capa modelo 
     * para construir un objeto JSON con los datos del objeto indicado.
     * 
     * @param dato Es el objeto de JSON leído del archivo.
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * @param ultimo Indica si se debe revisar el último elemento registrado de 
     * una lista.
     * @param indice Es utilizado para registrar la lista de servicios 
     * relacionados.
     * 
     * @return JSONObject del último registro indicado.
     */
    
    public JSONObject agregarDato(JSONObject dato, String nombreObjeto, 
            boolean ultimo, int indice) {
        switch(nombreObjeto) {
            case "Cliente":
                Cliente ultimoCliente;
                if(ultimo) {
                    ultimoCliente = listaClientes.get(listaClientes.size()-1);
                } else {
                    ultimoCliente = 
                    (listaReservas.get(listaReservas.size()-1)).getClienteRelacionado();
                }
                dato.put("Nombre", ultimoCliente.getNombreCompleto());
                dato.put("Cedula", ultimoCliente.getCedula());
                dato.put("Direccion", ultimoCliente.getDireccionExacta());
                dato.put("Correo", ultimoCliente.getCorreoElectronico());
                dato.put("Telefono", ultimoCliente.getTelefono());
                dato.put("Numero licencia", ultimoCliente.getNumeroLicencia());
                dato.put("Fecha emision licencia", 
                Utilitaria.formatoFechaJSON(ultimoCliente.getFechaEmisionLicencia()));
                dato.put("Tipo licencia", (ultimoCliente.getTipoLicencia()).toString());
                dato.put("Fecha expiracion licencia", 
                Utilitaria.formatoFechaJSON(ultimoCliente.getFechaExpiracionLicencia()));
                dato.put("Imagen", ultimoCliente.getImagen());
                break;
            case "Operador":
                Operador ultimoOperador;
                if(ultimo) {
                    ultimoOperador = listaOperadores.get(listaOperadores.size()-1);
                } else {
                    ultimoOperador = (listaReservas.get(listaReservas.size()-1)).getOperador();
                }
                dato.put("Correo", ultimoOperador.getCorreoElectronico());
                dato.put("Contraseña", ultimoOperador.getContraseña());
                dato.put("Nombre", ultimoOperador.getNombreCompleto());
                dato.put("Estado", String.valueOf(ultimoOperador.isEstado()));
                break;
            case "Vehiculo":
                Vehiculo ultimoVehiculo;
                if(ultimo) {
                    ultimoVehiculo = listaVehiculos.get(listaVehiculos.size()-1);
                } else {
                    ultimoVehiculo = 
                        listaReservas.get(listaReservas.size()-1).getVehiculoSeleccionado();
                }
                ArrayList<Servicio> listaServiciosRegistrados = 
                        ultimoVehiculo.getListaServiciosRelacionados();
                JSONObject servicioJSON = new JSONObject();
                JSONArray listaServiciosJSON = new JSONArray();
                for(int i = 0; i < listaServiciosRegistrados.size(); i++) {
                    servicioJSON = agregarDato(servicioJSON, "Servicio", false, i);
                    listaServiciosJSON.add(servicioJSON);
                }
                dato.put("Placa", ultimoVehiculo.getPlaca());
                dato.put("Año fabricación", Integer.toString(ultimoVehiculo.getAñoFabricacion()));
                dato.put("Estilo", (ultimoVehiculo.getEstilo()).toString());
                dato.put("Color", ultimoVehiculo.getColor());
                dato.put("Marca", ultimoVehiculo.getMarca());
                dato.put("Capacidad", Integer.toString(ultimoVehiculo.getCapacidad()));
                dato.put("Kilometraje", Double.toString(ultimoVehiculo.getKilometraje()));
                dato.put("Numero puertas", Integer.toString(ultimoVehiculo.getNumeroPuertas()));
                dato.put("Numero vin", ultimoVehiculo.getNumeroVin());
                dato.put("Mpg", Double.toString(ultimoVehiculo.getMpg()));
                dato.put("Sede", ultimoVehiculo.getSede());
                dato.put("Costo diario", Double.toString(ultimoVehiculo.getCostoDiario()));
                dato.put("Capacidad maletas", 
                        Integer.toString(ultimoVehiculo.getCapacidadMaletas()));
                dato.put("Transmision", (ultimoVehiculo.getTipoTransmision()).toString());
                dato.put("Estado", (ultimoVehiculo.getEstado()).toString());
                dato.put("Lista servicios relacionados", listaServiciosJSON);
                dato.put("Imagen", ultimoVehiculo.getImagen());
                break;
            case "Empresa":
                EmpresaMantenimiento ultimaEmpresa;
                if(ultimo) {
                    ultimaEmpresa = 
                        listaEmpresasMantenimiento.get(listaEmpresasMantenimiento.size()-1);
                } else {
                    ultimaEmpresa = 
                        (listaServicios.get(listaServicios.size()-1)).getEmpresaRelacionada();
                }
                dato.put("Razon social", ultimaEmpresa.getRazonSocial());
                dato.put("Cedula", ultimaEmpresa.getNumeroCedula());
                dato.put("Telefono", ultimaEmpresa.getTelefono());
                dato.put("Provincia", ultimaEmpresa.getProvincia());
                dato.put("Canton", ultimaEmpresa.getCanton());
                dato.put("Distrito", ultimaEmpresa.getDistrito());
                dato.put("Señas", ultimaEmpresa.getSeñas());
                break;
            case "Servicio":
                Servicio ultimoServicio;
                if(ultimo) {
                    ultimoServicio = listaServicios.get(listaServicios.size()-1);
                } else {
                    Vehiculo ultimoVehiculoRegistrado = listaVehiculos.get(listaVehiculos.size()-1);
                    ultimoServicio = 
                            ultimoVehiculoRegistrado.getListaServiciosRelacionados().get(indice);
                }
                JSONObject empresaJSON = new JSONObject();
                JSONArray listaEmpresasJSON = new JSONArray();
                dato.put("Identificador", Integer.toString(ultimoServicio.getIdentificador()));
                dato.put("Fecha inicio", 
                        Utilitaria.formatoFechaJSON(ultimoServicio.getFechaInicio()));
                dato.put("Fecha final", 
                        Utilitaria.formatoFechaJSON(ultimoServicio.getFechaFinalizacion()));
                dato.put("Monto pagado", Double.toString(ultimoServicio.getMontoPagado()));
                dato.put("Detalles", ultimoServicio.getDetalles());
                dato.put("Tipo", (ultimoServicio.getTipo()).toString());
                empresaJSON = agregarDato(empresaJSON, "Empresa", false, 0);
                listaEmpresasJSON.add(empresaJSON);
                dato.put("Empresa relacionada", listaEmpresasJSON);
                break;
            case "Reserva":
                Reserva ultimaReserva = listaReservas.get(listaReservas.size()-1);
                JSONArray operadorJSON = prepararArrayObjetos("Operador");
                JSONArray vehiculoJSON = prepararArrayObjetos("Vehiculo");
                JSONArray clienteJSON = prepararArrayObjetos("Cliente");
                HashMap<String, Double> serviciosOpcionales = 
                        ultimaReserva.getServiciosOpcionales();
                JSONArray serviciosOpcionalesJSON = new JSONArray();
                for (String i : serviciosOpcionales.keySet()) {
                    JSONObject par = new JSONObject();
                    par.put("Key", i);
                    par.put("Value", serviciosOpcionales.get(i));
                    serviciosOpcionalesJSON.add(par);
                }
                dato.put("Sede recogida", ultimaReserva.getSedeRecogida());
                dato.put("Sede entrega", ultimaReserva.getSedeEntrega());
                dato.put("Fecha inicio", 
                        Utilitaria.formatoFechaJSON(ultimaReserva.getFechaInicio()));
                dato.put("Fecha final", 
                        Utilitaria.formatoFechaJSON(ultimaReserva.getFechaFinalizacion()));
                dato.put("Fecha solicitud", 
                        Utilitaria.formatoFechaJSON(ultimaReserva.getFechaSolicitud()));
                dato.put("Operador", operadorJSON);
                dato.put("Vehiculo", vehiculoJSON);
                dato.put("Cliente", clienteJSON);
                dato.put("Servicios opcionales", serviciosOpcionalesJSON);
                break;
            default:
                break;
        }
        return dato;
    }
    
    /**
     * Este método verifica que el tamaño de las listas es mayor que uno.
     * 
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * 
     * @return true si la lista indicada tiene más de un elemento.
     */
    
    public boolean listaTieneDatos(String nombreObjeto) {
        switch(nombreObjeto) {
            case "Operador":
                return listaOperadores.size() > 1;
            case "Empresa":
                return listaEmpresasMantenimiento.size() > 1;
            case "Cliente":
                return listaClientes.size() > 1;
            case "Servicio":
                return listaServicios.size() > 1;
            case "Vehiculo":
                return listaVehiculos.size() > 1;
            case "Reserva":
                return listaReservas.size() > 1;
        }
        return false;
    }
    
    /**
     * Este método llama al método registrarDato para registrar las partes de
     * un todo. También busca el valor del 
     * identificador de la parte para colocarla en el registro del todo.
     * 
     * @param dato Es el objeto de JSON leído del archivo.
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * @param id Indica el nombre del identificador.
     * 
     * @return String identificador de la parte indicada.
     */
    
    public String buscarObjeto(JSONObject dato, String nombreObjeto, String id){
        JSONArray listaObjetos = (JSONArray) dato.get(nombreObjeto);
        JSONObject objetoJSON = (JSONObject) listaObjetos.get(0);
        registrarDato(objetoJSON, nombreObjeto);
        return (objetoJSON.get(id)).toString();
    }
    
    /**
     * Este método coloca partes de un todo en el archivo JSON que le 
     * corresponde y lo agrega a un arreglo de 
     * objetos JSON para que el todo también puede agregarlo en su archivo JSON.
     * 
     * @param nombreObjeto Es el nombre que representa la clase en el archivo 
     * JSON.
     * 
     * @return JSONArray de un objeto indicado.
     */
    
    public JSONArray prepararArrayObjetos(String nombreObjeto) {
        JSONObject objetoJSON = new JSONObject();
        JSONArray arrayObjeto = new JSONArray();
        objetoJSON = agregarDato(objetoJSON, nombreObjeto, false, 0);
        arrayObjeto.add(objetoJSON);
        return arrayObjeto;
    }
    
    /**
     * Recorre los vehículos del archivo hasta encontrar la placa indicada. 
     * Recorre todos los pares del diccionario
     * agregando sus llaves y valores en el objeto Vehiculo seleccionado. 
     * Llama al método setDatoEdicion.
     * 
     * @param placa Placa del vehículo a editar
     * @param edicion Es el diccionario que contiene todas las modificaciones.
     * 
     * @return true si la edición del vehículo finaliza correctamente, 
     * false en caso contrario.
     */
    
    public boolean editarVehiculoJSON(String placa, HashMap edicion) {
        JSONParser jsonParser = new JSONParser();
        //Línea para comprobar la actualización de la lista de vehículos
        Vehiculo vehiculoActual = obtenerVehiculo(placa);
        
        try (FileReader reader = new FileReader("vehiculos.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaVehiculosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaVehiculosJSON.size(); i++) {
                JSONObject vehiculoActualJSON = (JSONObject) listaVehiculosJSON.get(i);
                JSONObject vehiculo = (JSONObject) vehiculoActualJSON.get("Vehiculo");
                for(int j = 0; j < edicion.keySet().size(); j++) {
                    if((vehiculo.get("Placa")).toString().equals(placa)) {
                        vehiculo.put(edicion.keySet().toArray()[j], 
                                edicion.get(edicion.keySet().toArray()[j]));
                    }
                    //Línea para comprobar la actualización de la lista de vehículos
                    setDatoEdicion(vehiculoActual, (edicion.keySet().toArray()[j]).toString(), 
                                   (edicion.get(edicion.keySet().toArray()[j])).toString());
                    
                }
            }
        try (FileWriter archivo = new FileWriter("vehiculos.json")) {
                archivo.write(listaVehiculosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Este método recorre el arreglo de vehículos que posee el archivo JSON 
     * hasta encontrar el vehículo con la placa indicada. Construye un arreglo 
     * de objetos JSON con la empresa relacionada al servicioActual para 
     * agregarlo junto con los datos atómicos del servicioActual a un objeto 
     * JSON. El servicio es agregado al arreglo de servicios relacionados del 
     * vehículo actual.
     * 
     * @param placa String con la placa del vehículo al cual se le va a agregar un servicio
     * @param servicioActual Servicio a agregar
     * 
     * @return true si se agrega el servicio al vehículo correctamente, 
     * false en caso contrario.
     */
    
    public boolean agregarServicioAVehiculo(String placa, Servicio servicioActual){
        Vehiculo vehiculoActual = obtenerVehiculo(placa);
        boolean servicioAgregado = vehiculoActual.agregarServicio(servicioActual);
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("vehiculos.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaVehiculosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaVehiculosJSON.size(); i++) {
                JSONObject vehiculoActualJSON = (JSONObject) listaVehiculosJSON.get(i);
                JSONObject vehiculo = (JSONObject) vehiculoActualJSON.get("Vehiculo");
                if((vehiculo.get("Placa")).toString().equals(placa)) {
                    EmpresaMantenimiento empresaActual = servicioActual.getEmpresaRelacionada();
                    JSONObject objetoEmpresa = new JSONObject();
                    JSONArray empresasRelacionadas = new JSONArray();
                    
                    objetoEmpresa.put("Razon social", empresaActual.getRazonSocial());
                    objetoEmpresa.put("Cedula", empresaActual.getNumeroCedula());
                    objetoEmpresa.put("Telefono", empresaActual.getTelefono());
                    objetoEmpresa.put("Provincia", empresaActual.getProvincia());
                    objetoEmpresa.put("Canton", empresaActual.getCanton());
                    objetoEmpresa.put("Distrito", empresaActual.getDistrito());
                    objetoEmpresa.put("Señas", empresaActual.getSeñas());
                    
                    empresasRelacionadas.add(objetoEmpresa);
                    
                    JSONArray serviciosRelacionados;
                    serviciosRelacionados = (JSONArray)vehiculo.get("Lista servicios relacionados");
                    
                    if(servicioAgregado) {
                        JSONObject servicioNuevo = new JSONObject();
                        servicioNuevo.put("Identificador", 
                                Integer.toString(servicioActual.getIdentificador()));
                        servicioNuevo.put("Fecha inicio", 
                                Utilitaria.formatoFechaJSON(servicioActual.getFechaInicio()));
                        servicioNuevo.put("Fecha final", 
                                Utilitaria.formatoFechaJSON(servicioActual.getFechaFinalizacion()));
                        servicioNuevo.put("Monto pagado", 
                                Double.toString(servicioActual.getMontoPagado()));
                        servicioNuevo.put("Detalles", 
                                servicioActual.getDetalles());
                        servicioNuevo.put("Tipo", 
                                (servicioActual.getTipo()).toString());
                        servicioNuevo.put("Empresa relacionada", empresasRelacionadas);
                        serviciosRelacionados.add(servicioNuevo);
                    }
                }
            }
        try (FileWriter archivo = new FileWriter("vehiculos.json")) {
                archivo.write(listaVehiculosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Este método llama al método accesor set del atributo indicado.
     * 
     * @param vehiculoActual Vehiculo el cual se va a editar
     * @param nombreDato Dato a actualizar
     * @param datoActualizadob Nuevo dato a actualizar
     * 
     */
    
    public void setDatoEdicion(Vehiculo vehiculoActual, String nombreDato, 
            String datoActualizado) {
        switch(nombreDato) {
            case "Año fabricación":
                vehiculoActual.setAñoFabricacion(Integer.parseInt(datoActualizado));
                break;
            case "Estilo":
                vehiculoActual.setEstilo(TEstilo.valueOf(datoActualizado));
                break;
            case "Color":
                vehiculoActual.setColor(datoActualizado);
                break;
            case "Marca":
                vehiculoActual.setMarca(datoActualizado);
                break;
            case "Capacidad":
                vehiculoActual.setCapacidad(Integer.parseInt(datoActualizado));
                break;
            case "Kilometraje":
                vehiculoActual.setKilometraje(Double.parseDouble(datoActualizado));
                break;
            case "Numero puertas":
                vehiculoActual.setNumeroPuertas(Integer.parseInt(datoActualizado));
                break;
            case "Numero vin":
                vehiculoActual.setNumeroVin(datoActualizado);
                break;
            case "Mpg":
                vehiculoActual.setMpg(Double.parseDouble(datoActualizado));
                break;
            case "Sede":
                vehiculoActual.setSede(datoActualizado);
                break;
            case "Costo diario":
                vehiculoActual.setCostoDiario(Double.parseDouble(datoActualizado));
                break;
            case "Capacidad maletas":
                vehiculoActual.setCapacidadMaletas(Integer.parseInt(datoActualizado));
                break;
            case "Transmision":
                vehiculoActual.setTipoTransmision(TTransmision.valueOf(datoActualizado));
                break;
            case "Estado":
                vehiculoActual.setEstado(TEstado.valueOf(datoActualizado));
                break;
            case "Imagen":
                vehiculoActual.setImagen(datoActualizado);
                break;
            default:
                break;
        }
    }
    
    /**
     * En este método se hace uso de la librería ItectPDF para generar un formato para una factura.
     * Para ello se definen párrafos con datos fijos que describen el valor que correspode, 
     * y esos valores se toman del parámetro ingresado, que hace referencia a una reserva hecha.
     * 
     * @param laReserva
     * 
     * @return String que contiene el nombre del archivo generado
     */

    public String crearPDF(Reserva laReserva) throws FileNotFoundException, 
            DocumentException, IOException{
        
        TipoCambioBCCR servicioTipoCambio = new TipoCambioBCCR();
        String nombre= "Reserva" + laReserva.getNumeroFactura() + ".pdf";
        Document documento = new Document();
        
        FileOutputStream ficheroPDF = new FileOutputStream(nombre);

        PdfWriter.getInstance(documento, ficheroPDF);
        
        documento.open();
       
        Paragraph titulo = new Paragraph("Rent A Car",
                FontFactory.getFont("arial",
                22,
                Font.BOLD,
                BaseColor.BLUE));
   
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        Paragraph p1; 
        p1 = new Paragraph("\nFecha de solicitud: " + formatoFecha(laReserva.getFechaSolicitud()));
        Paragraph p2;
        p2 = new Paragraph("Número de factura: " + laReserva.getNumeroFactura());
        Paragraph p25;
        p25 = new Paragraph("Tipo de cambio del dólar: " + servicioTipoCambio.getVenta());
        p1.setAlignment(Paragraph.ALIGN_RIGHT);
        p2.setAlignment(Paragraph.ALIGN_RIGHT);
        p25.setAlignment(Paragraph.ALIGN_RIGHT);
        
        Operador varOperador = laReserva.getOperador();
        Paragraph p3 = new Paragraph("\nNombre del operador que le atendió: "
                + varOperador.getNombreCompleto());
        
        Paragraph p4 = new Paragraph("\nDatos del cliente");
        Paragraph p5 = new Paragraph("Nombre completo: " + 
                laReserva.getClienteRelacionado().getNombreCompleto());
        Paragraph p6 = new Paragraph("Número de teléfono: " + 
                laReserva.getClienteRelacionado().getCedula());
        Paragraph p7 = new Paragraph("Correo electrónico: " + 
                laReserva.getClienteRelacionado().getCorreoElectronico());
        Paragraph p8 = new Paragraph("Dirección exacta: " + 
                laReserva.getClienteRelacionado().getDireccionExacta());
      
        Paragraph p9 = new Paragraph("\nDatos de la reserva");
        Paragraph p10 = new Paragraph("Sede donde se entrega el vehículo: " + 
                laReserva.getSedeEntrega());
        Paragraph p11 = new Paragraph("Sede donde se recoge el vehículo: " + 
                laReserva.getSedeRecogida());
        Paragraph p12 = new Paragraph("Fecha de inicio de la renta: " + 
                formatoFecha(laReserva.getFechaInicio()));
        Paragraph p13 = new Paragraph("Fecha de finalización de la renta: " + 
                formatoFecha(laReserva.getFechaFinalizacion()));
        Paragraph p14 = new Paragraph("Duración de la reserva: " + 
                laReserva.getDuracion() + " día(s)");
        Paragraph p15 = new Paragraph("\nDatos del vehículo");
        Paragraph p16 = new Paragraph("Estilo: " + 
                laReserva.getVehiculoSeleccionado().getEstilo() + 
                "\nMarca: " + laReserva.getVehiculoSeleccionado().getMarca() + 
                "\nAño de fabricación: " + 
                laReserva.getVehiculoSeleccionado().getAñoFabricacion() + 
                "\nNúmero de placa: " + 
                laReserva.getVehiculoSeleccionado().getPlaca() + 
                "\nCosto diario: " + 
                laReserva.getVehiculoSeleccionado().getCostoDiario());
        
        
        documento.add(p1);
        documento.add(p2);
        documento.add(p25);
        documento.add(p3);
        documento.add(p4);
        documento.add(p5);
        documento.add(p6);
        documento.add(p7);
        documento.add(p8);
        documento.add(p9);
        documento.add(p10);
        documento.add(p11);
        documento.add(p12);
        documento.add(p13);
        documento.add(p14);
        documento.add(p15);
        documento.add(p16);
        
        Paragraph p17 = new Paragraph("\nServicios especiales solicitados:\n\n");
        documento.add(p17);
        HashMap servicios = laReserva.getServiciosOpcionales();
        for(int i = 0; i < servicios.keySet().size(); i++)
        {            
            String key = servicios.keySet().toArray()[i].toString();
            Paragraph se = new Paragraph(key);
            Paragraph costo = new Paragraph("USD " + servicios.get(key).toString());
            costo.setAlignment(Paragraph.ALIGN_RIGHT);
            documento.add(se);
            documento.add(costo);
        }
        Paragraph p18 = new Paragraph("\nMonto de la reserva la cantidad de días seleccionados: ");
        Paragraph p19 = new Paragraph("CRC " + laReserva.getCostoRenta());
        p19.setAlignment(Paragraph.ALIGN_RIGHT);
        documento.add(p18);
        documento.add(p19);
        Paragraph p20 = new Paragraph("\nTotal de servicios especiales: ");
        Paragraph pD = new Paragraph("USD " + laReserva.getCostoSODolares());
        Paragraph p21 = new Paragraph("CRC " + laReserva.getCostoSO());
        p21.setAlignment(Paragraph.ALIGN_RIGHT);
        pD.setAlignment(Paragraph.ALIGN_RIGHT);
        documento.add(p20);   
        documento.add(p21);
        documento.add(pD);
        Paragraph p22 = new Paragraph("\nMonto Total: ");
        Paragraph p23 = new Paragraph("CRC " + laReserva.getCostoTotal());
        Paragraph p24 = new Paragraph("USD " + 
                laReserva.getCostoTotal()/servicioTipoCambio.getVenta());
        p23.setAlignment(Paragraph.ALIGN_RIGHT);
        p24.setAlignment(Paragraph.ALIGN_RIGHT);
        documento.add(p22);   
        documento.add(p23); 
        documento.add(p24); 

        documento.close();
        
        return nombre;
    }
    
    /**
     * Este método verifica las credenciales de un operador
     * @param username String con el nombre de usuario que intenta el ingreso al sistema
     * @param password String con la contraseña de usuario que intenta el ingreso al sistema
     * @return true si la combinación de usuario y contraseña existe, false si no
     */
    
    public boolean verificarCredenciales(String username, String password)
    {
        Operador elOperador;
        for(int i = 0; i < listaOperadores.size(); i++)
        {
            elOperador = listaOperadores.get(i);
            if(elOperador.getUsername().equals(username))
            {
                if(elOperador.getContraseña().equals(password))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Este método envía un correo con las credenciales de un operador recién registrado a su correo
     * @param elOperador Operador que representa el operador de servicio al cliente que ha sido 
     * registrado en el momento
     * @param pass Contraseña generada por generarContraseña()
     * @see #generarContraseña() 
     * @return Llamada al método de EnviarEmail
     */
    
    public boolean mandarCorreoCredenciales(Operador elOperador, String pass) 
            throws FileNotFoundException, DocumentException{
        String password = pass;
        String nombre = "Credenciales" + elOperador.getNombreCompleto()+ ".pdf";
        String ruta = "src\\main\\java\\img\\" + nombre;
        Document documento = new Document();        
        FileOutputStream ficheroPDF = new FileOutputStream(ruta);        
        PdfWriter.getInstance(documento, ficheroPDF);      
        documento.open();
        Paragraph p1 = new Paragraph("Credenciales para poder acceder al sistema:"
                                    + "\nUsername:" + elOperador.getUsername()
                                    + "\nContraseña:" + password);
        documento.add(p1);
        documento.close();        
        return EnviarEmail.enviarCorreo(elOperador.getCorreoElectronico(),
                "Envio de credenciales", "Se adjunta un pdf con los credenciales", ruta);
    }
    
    /**
     * Este método devuelve la lista de operadores contenida en el administrador
     * @return ArrayList con los operadores del sistema
     */

    public ArrayList<Operador> getListaOperadores() {
        return listaOperadores;
    }
    
    /**
     * Este método devuelve la lista de vehículos contenida en el administrador
     * @return ArrayList con los vehículos del sistema
     */

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    
    /**
     * Este método se encarga de obtener todos los vehículos de cierto tipo, 
     * tomando en cuenta si se encuentra reservados
     * los vehículos dentro de estas o si se encuentran en una sede específica
     * 
     * @param tipo TEstilo que indica el tipo de vehículo a buscar
     * @param ConSede Valor booleano que indica si se busca tomando en cuenta la 
     * sede actual o no
     * @param Desde Calendar con la fecha desde donde se realiza la reserva
     * @param Hasta Calendar con la fecha hasta donde se realiza la reserva
     * @return ArrayList con todos los vehículos que cumplen las condiciones de 
     * entrada
     */
    
    public ArrayList<Vehiculo> getVehiculosTipo(TEstilo tipo, Calendar Desde, 
            Calendar Hasta, boolean ConSede) {
        ArrayList<Vehiculo> temp = new ArrayList<>();
        temp.add(null);
        if (ConSede) {
            for (Vehiculo V: listaVehiculos) {
                if (V.getEstado().equals(TEstado.Activo) && V.getEstilo().equals(tipo) 
                    && !V.isRentadoEnElRango(Desde, Hasta) && 
                        V.getSede().equals(GUI.RealizarReserva.
                                TextFieldSedeRecogida.getSelectedItem())){
                    temp.add(V);
                }
            }
            return temp;
        }else{
            for (Vehiculo V: listaVehiculos) {
                if (V.getEstilo().equals(tipo)  && !V.isRentadoEnElRango(Desde, Hasta)) {
                    temp.add(V);
                }
            }
            return temp;
        }
 
        
    }
    
    /**
     * Este método devuelve la lista de clientes contenida en el administrador
     * @return ArrayList con los clientes del sistema
     */

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    /**
     * Este método obtiene el operador activo actualmente en la sesión
     * @return Objeto Operador si se encuentra alguno activo, null si no existe
     */
    
    public Operador getOperadorActivo(){
        for (Operador O: listaOperadores) {
            if (O.isEstado()) {
                return O;
            }
        }
        return null;
        
    }
    
    /**
     * Este método devuelve la lista de reservas contenida en el administrador
     * @return ArrayList con las reservas del sistema
     */

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }
    
    /**
     * Este método filtra las reservas disponibles según su número de factura
     * @param NFactura Entero que representa el número de reserva a buscar
     * @return Reserva indicada si existe, null si no.
     */
    
    public Reserva filtrarReservaPorNumeroDeFactura(int NFactura){
        for (Reserva R:listaReservas) {
            if (R.getNumeroFactura()==NFactura){
                return R;
            }
        }return null;
    }
    
    /**
     * Este método devuelve la lista de servicios contenida en el administrador
     * @return ArrayList con los servicios del sistema
     */

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }
    
    /**
     * Este método devuelve la lista de empresas contenida en el administrador
     * @return ArrayList con las empresas del sistema
     */

    public ArrayList<EmpresaMantenimiento> getListaEmpresasMantenimiento() {
        return listaEmpresasMantenimiento;
    }
    
}
