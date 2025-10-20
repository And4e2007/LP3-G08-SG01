package Ejercicios_1_y_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion { 
    public static Connection Conectar() {
        try {
            // Cargar el driver JDBC
            Class.forName("org.sqlite.JDBC");

            // Crear/abrir la base de datos
            Connection con = DriverManager.getConnection("jdbc:sqlite:Ejemplo1_2.db");

            if (con != null) {
                System.out.println("Se creó y/o abrió la base de datos correctamente");
            }

            // Crear la tabla si no existe
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS personas ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "edad INTEGER, "
                    + "correo TEXT)");

            return con; // retorna la conexión válida

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}
