package Tarea4.src.main.java.com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Autor y Editorial
        Autor autor = new Autor("J.R.R.", "Tolkien", "1892-01-03", "Británico");
        Editorial editorial = new Editorial("George Allen & Unwin", "83 Marylebone High St, Londres", "+34666666666", "contacto@allen-unwin.com");

        // Crear un nuevo Libro
        Libro libro = new Libro("El Señor de los Anillos: La Comunidad del Anillo", "978-0-618-00222-8", 1954, autor, editorial);

        // Crear un Usuario
        Usuario usuario = new Usuario("Ana", "García", "12345678B", "ana.garcia@mail.com");

        // Crear un Préstamo
        Prestamo prestamo = new Prestamo(libro, usuario, LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 15));

        // Mostrar información
        libro.mostrarInfo();
        autor.mostrarInfo();
        editorial.mostrarInfo();
        usuario.mostrarInfo();
        System.out.println("Duración del préstamo: " + prestamo.calcularDuracion() + " días");
    }
}