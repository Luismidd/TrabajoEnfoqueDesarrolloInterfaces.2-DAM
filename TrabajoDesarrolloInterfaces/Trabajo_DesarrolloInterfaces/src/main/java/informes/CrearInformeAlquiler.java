package informes;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import modelo.InformeAlquiler;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Luismi
 */
public class CrearInformeAlquiler {

    // 
    public static void mostrarInforme(List<InformeAlquiler> listaInforme) throws JRException, FileNotFoundException {

        if (listaInforme == null || listaInforme.isEmpty()) {
            throw new IllegalArgumentException("No hay alquileres para mostrar");
        }

        // Cargar plantilla desde resources
        InputStream jrxml = CrearInformeAlquiler.class
                .getResourceAsStream("/informes/plantillaInformeAlquiler.jrxml");

        if (jrxml == null) {
            throw new FileNotFoundException("No se encuentra el archivo plantillaInformeAlquiler.jrxml");
        }

        // Compilar plantilla
        JasperReport report = JasperCompileManager.compileReport(jrxml);

        // Fuente de datos 
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaInforme);

        // Parámetros
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", "Histórico de alquileres");

        // Generar informe
        JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);

        // Mostrar informe
        JasperViewer viewer = new JasperViewer(print, false);

        // Ajustar ventana a pantalla completa
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        viewer.setSize(screenSize.width, screenSize.height);
        viewer.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Ajustar el zoom para que el contenido quepa en pantalla
        viewer.setZoomRatio(0.3f); // 1f = 100%
        viewer.setVisible(true);

    }
}
