package com.example.biblioteca;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Se crea una instancia de 'Biblioteca' (en memoria).
        Biblioteca biblioteca = new Biblioteca();

        // Creamos varios libros, indicando también su género.
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", 1, "Fantasía");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 2, "Realismo mágico");
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 3, "Fantasía");

        // Los agregamos al catálogo de la biblioteca.
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Creamos clientes (Juan y María).
        Cliente cliente1 = new Cliente("Juan", 101);
        Cliente cliente2 = new Cliente("María", 102);

        // Registramos esos clientes en la biblioteca.
        biblioteca.agregarCliente(cliente1);
        biblioteca.agregarCliente(cliente2);

        // Simulamos la fecha de hoy y una fecha de devolución esperada (2 semanas más).
        LocalDate hoy = LocalDate.now();
        LocalDate fechaDevolucionEsperada = hoy.plusDays(14);

        // Prestamos el libro 1 a Juan (si está disponible).
        if (biblioteca.estaDisponible(1)) {
            cliente1.prestarLibro(libro1, hoy, fechaDevolucionEsperada);
        }
        // Prestamos el libro 2 a María (si está disponible).
        if (biblioteca.estaDisponible(2)) {
            cliente2.prestarLibro(libro2, hoy, fechaDevolucionEsperada);
        }

        // Mostramos los libros que cada uno tiene prestados.
        System.out.println("\nLibros prestados por " + cliente1.getNombre() + ":");
        cliente1.mostrarLibrosPrestados();
        System.out.println("\nLibros prestados por " + cliente2.getNombre() + ":");
        cliente2.mostrarLibrosPrestados();

        // (1) Buscar libros por autor 'J.R.R. Tolkien'.
        System.out.println("\n=== Buscar libros por autor 'J.R.R. Tolkien' ===");
        for (Libro l : biblioteca.buscarLibrosPorAutor("J.R.R. Tolkien")) {
            System.out.println(" - " + l.getTitulo() + " (ID: " + l.getId() + ")");
        }

        // (2) Mostrar todos los libros disponibles.
        biblioteca.mostrarLibrosDisponibles();

        // (3) Verificar si un libro (ejemplo: ID=3) está disponible en este momento.
        System.out.println("\n¿Está disponible el libro con ID=3? " + biblioteca.estaDisponible(3));

        // (4) Volvemos a mostrar qué libros tiene Juan.
        System.out.println("\nMostrando libros prestados por " + cliente1.getNombre() + " nuevamente:");
        cliente1.mostrarLibrosPrestados();

        // (5) Mostrar todos los clientes que tengan libros aún sin devolver.
        biblioteca.mostrarClientesConLibrosPrestados();

        // Prestamos el libro 3 también a Juan (si está disponible).
        if (biblioteca.estaDisponible(3)) {
            cliente1.prestarLibro(libro3, hoy, fechaDevolucionEsperada);
            System.out.println("\nJuan también toma prestado 'Harry Potter'.");
        }

        // (6) Simulamos la devolución del libro1 por parte de Juan, con retraso de 5 días.
        System.out.println("\nJuan devuelve el libro 1 con +5 días de retraso...");
        LocalDate fechaDevConRetraso = fechaDevolucionEsperada.plusDays(5);
        double multa = cliente1.devolverLibro(libro1, fechaDevConRetraso);
        System.out.println("Libro 1 devuelto. Multa aplicada: " + multa + " €");

        // (7) La gestión de multas está demostrada justo arriba.
        // (8) Búsqueda por género: 'Fantasía'.
        System.out.println("\n=== Libros de género 'Fantasía': ===");
        for (Libro lib : biblioteca.buscarLibrosPorGenero("Fantasía")) {
            System.out.println(" - " + lib.getTitulo() + " (ID=" + lib.getId() + ")");
        }

        // Finalmente, volvemos a mostrar quién sigue con libros sin devolver.
        biblioteca.mostrarClientesConLibrosPrestados();
        System.out.println("\nFin de la demostración.");
    }
}