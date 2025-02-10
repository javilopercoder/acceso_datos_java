package com.example.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int id;
    // Aquí guardamos los préstamos (cada préstamo incluye el libro, fechas y cálculo de multa)
    private ArrayList<Prestamo> prestamos;

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.prestamos = new ArrayList<>();
    }

    // (4) Muestra los libros que el cliente aún no devolvió.
    public void mostrarLibrosPrestados() {
        System.out.println(nombre + " tiene los siguientes libros (sin devolver):");
        for (Prestamo p : prestamos) {
            if (p.getFechaDevolucion() == null) {
                System.out.println(" - " + p.getLibro().getTitulo() + 
                                " (ID: " + p.getLibro().getId() + ")");
            }
        }
    }

    // Permite prestar un libro creando un nuevo objeto Prestamo y agregándolo a la lista.
    public void prestarLibro(Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucionEsperada) {
        Prestamo p = new Prestamo(libro, fechaPrestamo, fechaDevolucionEsperada);
        prestamos.add(p);
    }

    // (6) Devuelve un libro recibiendo un objeto Libro.
    // Retorna la multa calculada (0 si no hay retraso).
    public double devolverLibro(Libro libro, LocalDate fechaDevolucion) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getId() == libro.getId() && p.getFechaDevolucion() == null) {
                p.setFechaDevolucion(fechaDevolucion);
                return p.calcularMulta();
            }
        }
        return 0.0;
    }

    // Versión sobrecargada para usar el ID en lugar del libro en sí.
    public double devolverLibro(int idLibro, LocalDate fechaDevolucion) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getId() == idLibro && p.getFechaDevolucion() == null) {
                p.setFechaDevolucion(fechaDevolucion);
                return p.calcularMulta();
            }
        }
        return 0.0;
    }

    // Devuelve la lista completa de préstamos por si la biblioteca la necesita.
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Getters básicos.
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}