package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

/**
 *
 * @author Luismi
 */
public class ProcesosBD {

    public static List<Alquiler> obtenerHistorialAlquiler(LocalDate inicio, LocalDate fin) throws SQLException {
        List<Alquiler> lista = new ArrayList<>();
        // Consultamos a la VISTA, así el SQL es simple
        //String sql = "SELECT * FROM vista_alquileres_completa WHERE fechaEntrada BETWEEN ? AND ?";

        String sql = """
        SELECT a.numeroExpediente, a.fechaEntrada, a.tiempoAlquiler, a.estadoCobro,
           c.id AS id_cliente, c.nombre, c.dni, c.telefono, c.email, c.direccionFacturacion,
           v.id AS id_vivienda, v.metrosCuadrados, v.direccion, v.numeroHabitaciones, v.numeroBanos, v.precioMes
        FROM alquileres a
        JOIN clientes c ON a.id_cliente = c.id
        JOIN viviendas v ON a.id_vivienda = v.id
        WHERE a.fechaEntrada BETWEEN ? AND ?
        """;

        try (Connection con = MySQL.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(inicio));
            ps.setDate(2, java.sql.Date.valueOf(fin));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Crea el objeto Cliente con los datos de la consulta
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"), rs.getString("nombre"),
                        rs.getString("dni"), rs.getString("telefono"),
                        rs.getString("email"), rs.getString("direccionFacturacion")
                );

                // Crea el objeto Vivienda con los datos 
                Vivienda vivienda = new Vivienda(
                        rs.getInt("id_vivienda"), rs.getInt("metrosCuadrados"),
                        rs.getString("direccion"), rs.getInt("numeroHabitaciones"),
                        rs.getInt("numeroBanos"), rs.getDouble("precioMes")
                );

                // Crea el Alquiler y se le pasa el cliente y vivienda creados
                Alquiler alquiler = new Alquiler(
                        rs.getString("numeroExpediente"),
                        rs.getDate("fechaEntrada").toLocalDate(),
                        rs.getInt("tiempoAlquiler"),
                        rs.getString("estadoCobro"),
                        cliente,
                        vivienda
                );

                lista.add(alquiler);
            }
        } catch (SQLException e) {
            // Propagamos la excepción para que la vista la maneje
            throw new SQLException("Error al acceder a la base de datos", e);
        }

        return lista;
    }

}
