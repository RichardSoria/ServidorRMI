package rmi.servidor.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Consulta {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mi_base_de_datos.db"; // archivo en el directorio actual

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("✔ Conexión establecida a SQLite");
            }
        } catch (SQLException e) {
            System.out.println("✘ Error de conexión: " + e.getMessage());
        }
    }
}

