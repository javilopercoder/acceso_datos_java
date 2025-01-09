package Tarea4.src.main.java.com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long calcularDuracion() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + libro);
        System.out.println("Usuario: " + usuario);
        System.out.println("Duración del préstamo: " + calcularDuracion() + " días");
    }
}