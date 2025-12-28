
package controlador;

import db.ProcesosBD;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Alquiler;
import modelo.InformeAlquiler;

/**
 *
 * @author Luismi
 */
public class AlquilerControlador {
    
    
    //Método que devuelve un lista de registros completos para crear el informe
    public List<InformeAlquiler> obtenerInformeAlquiler(LocalDate inicio, LocalDate fin) throws SQLException{
        
        //Crea lista del modelo alquiler con el resultado de la base datos 
        List<Alquiler> alquileres = ProcesosBD.obtenerHistorialAlquiler(inicio, fin);
        
        //Crea lista del modelo informeAlquiler a partir de la lista de alquiler crada anteriormente
        List<InformeAlquiler> listaInformes = new ArrayList<>();
        
        for (Alquiler a : alquileres) {
            InformeAlquiler informe = new InformeAlquiler(a);
            listaInformes.add(informe);
        }
        return listaInformes;
    }
    
}
