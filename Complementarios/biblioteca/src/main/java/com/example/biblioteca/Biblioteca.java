package com.example.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    // Lista de libros en el catálogo.
    private List<Libro> libros;

    // Lista de clientes registrados.
    private List<Cliente> clientes;

    public Biblioteca() {
        // Iniciamos ambas listas vacías.
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Agrega un nuevo libro al catálogo.
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Registra un nuevo cliente en la biblioteca.
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // (1) Devuelve todos los libros escritos por cierto autor.
    public List<Libro> buscarLibrosPorAutor(String autor) {
        return libros.stream()
                    .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                    .collect(Collectors.toList());
    }

    // (8) Devuelve los libros que pertenecen a un género específico.
    public List<Libro> buscarLibrosPorGenero(String genero) {
        return libros.stream()
                    .filter(l -> l.getGenero().equalsIgnoreCase(genero))
                    .collect(Collectors.toList());
    }

    // (2) Muestra en pantalla los libros que no estén prestados (nadie los tiene).
    public void mostrarLibrosDisponibles() {
        System.out.println("\nLibros disponibles para préstamo:");
        for (Libro l : libros) {
            if (estaDisponible(l.getId())) {
                System.out.println(" - " + l.getTitulo() + " (ID: " + l.getId() + 
                                ", Género: " + l.getGenero() + ")");
            }
        }
    }

    // (3) Indica si un libro está libre (nadie lo ha tomado o ya fue devuelto).
    public boolean estaDisponible(int idLibro) {
        // Recorremos los clientes y sus préstamos; si algún préstamo
        // con ese ID de libro no tiene fecha de devolución, no está disponible.
        for (Cliente c : clientes) {
            for (Prestamo p : c.getPrestamos()) {
                if (p.getLibro().getId() == idLibro && p.getFechaDevolucion() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    // (5) Muestra quiénes tienen libros prestados aún sin devolver.
    public void mostrarClientesConLibrosPrestados() {
        System.out.println("\nClientes con libros prestados (sin devolver):");
        for (Cliente c : clientes) {
            // Seleccionamos los préstamos que todavía no fueron devueltos.
            List<Prestamo> activos = c.getPrestamos().stream()
                                    .filter(p -> p.getFechaDevolucion() == null)
                                    .collect(Collectors.toList());
            if (!activos.isEmpty()) {
                System.out.println(" - " + c.getNombre() + " (ID=" + c.getId() + ") tiene:");
                for (Prestamo p : activos) {
                    System.out.println("    * " + p.getLibro().getTitulo() + 
                                    " (ID=" + p.getLibro().getId() + ")");
                }
            }
        }
    }

    // (6) Permite la devolución de un libro identificando cliente y libro por su ID.
    // Calcula la multa si hay retraso y la muestra en pantalla.
    public void devolverLibro(int idCliente, int idLibro) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            double multa = cliente.devolverLibro(idLibro, LocalDate.now());
            System.out.println("El libro (ID=" + idLibro + ") ha sido devuelto por " + 
                            cliente.getNombre() + ".");
            if (multa > 0) {
                System.out.println("Se ha generado una multa de " + multa + "€ por retraso.");
            }
        } else {
            System.out.println("No se encontró el cliente con ID=" + idCliente);
        }
    }

    // Método interno para buscar un cliente por su ID.
    private Cliente buscarClientePorId(int idCliente) {
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                return c;
            }
        }
        return null;
    }

    // Getters por si se necesitan en otro lugar.
    public List<Libro> getLibros() {
        return libros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}