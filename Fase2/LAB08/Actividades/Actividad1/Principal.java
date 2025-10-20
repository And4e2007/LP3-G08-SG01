package Actividad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Principal {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1. Cargar el controlador JDBC
            Class.forName("org.sqlite.JDBC");

            // 2. Conectarse a la base de datos (usa la ruta que tú diste)
            conn = DriverManager.getConnection(
                "jdbc:sqlite:empresa.db"
            );
            System.out.println("Conexión establecida con la base de datos empresa.db");

            // 3. Crear tabla si no existe
            Statement st = conn.createStatement();
            String sqlTabla = "CREATE TABLE IF NOT EXISTS empleados (" +
                              "id INTEGER PRIMARY KEY, " +
                              "nombre TEXT NOT NULL, " +
                              "edad INTEGER)";
            st.execute(sqlTabla);
            System.out.println("Tabla 'empleados' creada/verificada correctamente.");

            // 4. Insertar registros usando PreparedStatement
            String sqlInsert = "INSERT INTO empleados VALUES(?,?,?)";
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Camila");
            psInsert.setInt(3, 24);
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Luis");
            psInsert.setInt(3, 30);
            psInsert.executeUpdate();

            System.out.println("Registros insertados correctamente.");

            // 5. Consultar registros
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");
            System.out.println("\nLista de empleados:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Nombre: " + rs.getString("nombre") +
                                   " | Edad: " + rs.getInt("edad"));
            }

            // 6. Actualizar registro
            String sqlUpdate = "UPDATE empleados SET edad = ? WHERE id = ?";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, 35);
            psUpdate.setInt(2, 2);
            psUpdate.executeUpdate();
            System.out.println("\nRegistro actualizado correctamente.");

            // 7. Eliminar registro
            String sqlDelete = "DELETE FROM empleados WHERE id = ?";
            PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();
            System.out.println("Registro eliminado correctamente.");

            // 8. Manejo de transacciones (commit y rollback)
            conn.setAutoCommit(false);
            System.out.println("\nIniciando transacción...");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO empleados VALUES(3,'Diana',28)");
            stmt.executeUpdate("INSERT INTO empleados VALUES(4,'José',40)");

            // Confirmar la transacción
            conn.commit();
            System.out.println("Transacción confirmada (COMMIT).");

            // Nueva transacción con error para probar rollback
            conn.setAutoCommit(false);
            try {
                stmt.executeUpdate("INSERT INTO empleados VALUES(5,'Pedro',22)");
                stmt.executeUpdate("INSERT INTO empleados VALUES(5,'Carlos',33)"); // ID duplicado
                conn.commit();
            } catch (Exception ex) {
                conn.rollback();
                System.out.println("Transacción revertida (ROLLBACK) por error: " + ex.getMessage());
            }

            // 9. Mostrar datos finales
            rs = stmt.executeQuery("SELECT * FROM empleados");
            System.out.println("\nLista final de empleados:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Nombre: " + rs.getString("nombre") +
                                   " | Edad: " + rs.getInt("edad"));
            }

            // Cerrar conexión
            conn.close();
            System.out.println("\nConexión cerrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Transacción revertida por error general.");
                }
            } catch (Exception ex) {
                System.out.println("Error al revertir transacción: " + ex.getMessage());
            }
        }
    }
}

