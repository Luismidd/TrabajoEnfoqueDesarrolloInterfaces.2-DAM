
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luismi
 */
public final class MySQL {
    
    private static String url = "jdbc:mysql://localhost:3306/bdinmobiliaria"; // Nombre de tu DB
    private static String user = "root"; // Tu usuario
    private static String password = ""; // Tu contraseña
    
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.setLoginTimeout(10);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Falta el driver JDBC (com.mysql.cj.jdbc.Driver).", e);
        }
    }
    
    private MySQL() {}
    
    
    
    // Conectar a la base de datos
    public static Connection getConnection(){
        
        try {
            return DriverManager.getConnection(url, user, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
