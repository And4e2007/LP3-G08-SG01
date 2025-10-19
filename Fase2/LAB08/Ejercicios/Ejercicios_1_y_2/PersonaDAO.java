package Ejercicios_1_y_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private Connection conn;

    public PersonaDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Persona p) throws SQLException {
        String sql = "INSERT INTO personas(nombre, edad, correo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setString(3, p.getCorreo());
            ps.executeUpdate();
            System.out.println("Insertado con exito");
        }
    }

    public void actualizar(Persona p) throws SQLException {
        String sql = "UPDATE personas SET nombre=?, edad=?, correo=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setString(3, p.getCorreo());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            System.out.println("Actualizado con exito");
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM personas WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminidado con exito");
        }
    }

    public List<Persona> listar() throws SQLException {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM personas";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("correo")
                ));
            }
        }
        return lista;
    }
}
