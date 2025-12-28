package modelo;

/**
 *
 * @author Luismi
 */
public class Vivienda {
    
    private int id;
    private int metrosCuadrados;
    private String direccion;
    private int numeroHabitaciones;
    private int numeroBanos;
    private double precioMes;

    public Vivienda(int id, int metrosCuadrados, String direccion, int numeroHabitaciones, int numeroBanos, double precioMes) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.direccion = direccion;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanos = numeroBanos;
        this.precioMes = precioMes;
    }

    @Override
    public String toString() {
        return "Vivienda{" + "id=" + id + ", metrosCuadrados=" + metrosCuadrados + ", direccion=" + direccion + ", numeroHabitaciones=" + numeroHabitaciones + ", numeroBanos=" + numeroBanos + ", precioMes=" + precioMes + '}';
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    
    
}
