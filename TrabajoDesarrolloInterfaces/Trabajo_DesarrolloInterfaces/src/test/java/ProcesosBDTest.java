import controlador.AlquilerControlador;
import java.time.LocalDate;
import java.util.List;
import modelo.InformeAlquiler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luismi
 */
public class ProcesosBDTest {
    
    /**
     * Caso 1: Rango de fechas con registros en la base de datos.
     * Se verifica que se obtenga una lista no nula, no vacía
     * y que los campos principales de cada alquiler estén correctamente cargados.
     */
    @Test
    public void testObtenerAlquileresConRegistros() throws Exception {
        LocalDate inicio = LocalDate.of(2025, 1, 1);
        LocalDate fin = LocalDate.of(2025, 12, 31);

        AlquilerControlador controller = new AlquilerControlador();
        List<InformeAlquiler> lista = controller.obtenerInformeAlquiler(inicio, fin);

        // verifica que la lista no debe ser nula
        assertNotNull(lista, "La lista no debe ser nula");

        // Verifica que sea falso que la lista esté vacía, verifica que la lista tenga un registro al menos
        assertFalse(lista.isEmpty(), "Debe haber alquileres en el rango");

        // Verificamos los campos principales del primer alquiler
        InformeAlquiler primerAlquiler = lista.get(0);
        assertNotNull(primerAlquiler.getNumeroExpediente(), "Debe tener número de expediente");
        assertNotNull(primerAlquiler.getDniCliente(), "Debe tener cliente asociado");
        assertNotNull(primerAlquiler.getIdVivienda(), "Debe tener vivienda asociada");
    }

    /**
     * Caso 2: Rango de fechas sin registros.
     * Se verifica que la lista devuelta no sea nula y esté vacía.
     */
    @Test
    public void testObtenerAlquileresSinRegistros() throws Exception {
        LocalDate inicio = LocalDate.of(1900, 1, 1);
        LocalDate fin = LocalDate.of(1900, 12, 31);

        AlquilerControlador controller = new AlquilerControlador();
        List<InformeAlquiler> lista = controller.obtenerInformeAlquiler(inicio, fin);

        // Verifica que la lista no debe ser nula
        assertNotNull(lista, "La lista no debe ser nula");

        // verifica que la lista esté vacía
        assertTrue(lista.isEmpty(), "No debe haber alquileres en este rango");
    }
}
