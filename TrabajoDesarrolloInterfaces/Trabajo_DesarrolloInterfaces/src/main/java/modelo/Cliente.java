package modelo;

/**
 *
 * @author Luismi
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String direccionFacturacion;

    public Cliente(int id, String nombre, String dni, String telefono, String email, String direccionFacturacion) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccionFacturacion = direccionFacturacion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", email=" + email + ", direccionFacturacion=" + direccionFacturacion + '}';
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }
    
    
    
}
