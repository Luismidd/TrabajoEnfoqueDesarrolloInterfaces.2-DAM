
package modelo;

import java.time.LocalDate;


/**
 *
 * @author Luismi
 */
public class InformeAlquiler {
    
    //Datos alquiler
    private String numeroExpediente;
    private LocalDate fechaEntrada;
    private int tiempoAlquiler;
    private String estadoCobro;

    //Datos de vivienda
    private int idVivienda;
    private String direccionVivienda;
    private int metrosCuadrados;
    private int numeroHabitaciones;
    private int numeroBanos;
    private double precioMes;

    //Datos de cliente
    private String dniCliente;
    private String nombreCliente;
    private String direccionFacturacion;
    private String email;
    private String telefono;

   
    
     //Constructor que recibe un Alquiler para generar un objeto de modelo de datos para el informe
    public InformeAlquiler(Alquiler a) {
        this.numeroExpediente = a.getNumeroExpediente();
        this.fechaEntrada = a.getFechaEntrada();
        this.tiempoAlquiler = a.getTiempoAlquiler();
        this.estadoCobro = a.getEstadoCobro();

        this.idVivienda = a.getVivienda().getId();
        this.direccionVivienda = a.getVivienda().getDireccion();
        this.numeroHabitaciones = a.getVivienda().getNumeroHabitaciones();
        this.numeroBanos = a.getVivienda().getNumeroBanos();
        this.precioMes = a.getVivienda().getPrecioMes();
        this.metrosCuadrados = a.getVivienda().getMetrosCuadrados();

        this.dniCliente = a.getCliente().getDni();
        this.nombreCliente = a.getCliente().getNombre();
        this.direccionFacturacion = a.getCliente().getDireccionFacturacion();
        this.email = a.getCliente().getEmail();
        this.telefono = a.getCliente().getTelefono();
    }
    
    //get y set
    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getTiempoAlquiler() {
        return tiempoAlquiler;
    }

    public void setTiempoAlquiler(int tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    public String getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(String estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDireccionVivienda() {
        return direccionVivienda;
    }

    public void setDireccionVivienda(String direccionVivienda) {
        this.direccionVivienda = direccionVivienda;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroBanos() {
        return numeroBanos;
    }

    public void setNumeroBanos(int numeroBanos) {
        this.numeroBanos = numeroBanos;
    }

    public double getPrecioMes() {
        return precioMes;
    }

    public void setPrecioMes(double precioMes) {
        this.precioMes = precioMes;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
