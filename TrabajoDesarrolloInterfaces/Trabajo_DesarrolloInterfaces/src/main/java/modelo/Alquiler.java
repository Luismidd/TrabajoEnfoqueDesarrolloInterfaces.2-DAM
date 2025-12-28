package modelo;

import java.time.LocalDate;

/**
 *
 * @author Luismi
 */
public class Alquiler {
    
    private String numeroExpediente;
    private LocalDate fechaEntrada;
    private int tiempoAlquiler;
    private String estadoCobro;
    
    private Cliente cliente;
    private Vivienda vivienda;

    public Alquiler(String numeroExpediente, LocalDate fechaEntrada, int tiempoAlquiler, String estadoCobro, Cliente cliente, Vivienda vivienda) {
        this.numeroExpediente = numeroExpediente;
        this.fechaEntrada = fechaEntrada;
        this.tiempoAlquiler = tiempoAlquiler;
        this.estadoCobro = estadoCobro;
        this.cliente = cliente;
        this.vivienda = vivienda;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "numeroExpediente=" + numeroExpediente + ", fechaEntrada=" + fechaEntrada + ", tiempoAlquiler=" + tiempoAlquiler + ", estadoCobro=" + estadoCobro + ", cliente=" + cliente + ", vivienda=" + vivienda + '}';
    }
    
    

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }
    
    
    
    
}
