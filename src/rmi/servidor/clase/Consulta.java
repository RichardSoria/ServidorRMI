package rmi.servidor.clase;

import java.sql.*;
import java.util.ArrayList;

public class Consulta {

    private static final String DB_URL = "jdbc:sqlite:db/empleados.db";

    public static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM empleado")) {

            while (rs.next()) {
                Persona p = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("cargo"),
                        rs.getDouble("sueldo")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static Persona buscarPorId(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM empleado WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Persona(id, rs.getString("nombre"), rs.getString("correo"),
                        rs.getString("cargo"), rs.getDouble("sueldo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean insertarPersona(Persona p) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO empleado(nombre, correo, cargo, sueldo) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getCargo());
            ps.setDouble(4, p.getSueldo());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean actualizarPersona(int id, Persona p) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("UPDATE empleado SET nombre = ?, correo = ?, cargo = ?, sueldo = ? WHERE id = ?")) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getCargo());
            ps.setDouble(4, p.getSueldo());
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean eliminarPersona(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM empleado WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
