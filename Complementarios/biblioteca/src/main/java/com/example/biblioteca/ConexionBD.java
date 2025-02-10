package com.example.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para obtener la conexión a la base de datos SQLite.
 * Si no existe el archivo 'biblioteca.db', se creará automáticamente.
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:sqlite:biblioteca.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}