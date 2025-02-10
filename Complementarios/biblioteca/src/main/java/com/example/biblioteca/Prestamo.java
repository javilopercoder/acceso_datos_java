package com.example.biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private LocalDate fechaDevolucion; // null mientras no se devuelva

    // Cantidad de euros por día de retraso.
    private static final double MULTA_POR_DIA = 1.0;

    public Prestamo(Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucionEsperada) {
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Si la fecha de devolución excede la fecha esperada, se cobra MULTA_POR_DIA
     * multiplicado por el número de días de retraso.
     */
    public double calcularMulta() {
        LocalDate fechaParaCalcular = (fechaDevolucion != null) ? fechaDevolucion : LocalDate.now();
        long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucionEsperada, fechaParaCalcular);
        return (diasRetraso > 0) ? diasRetraso * MULTA_POR_DIA : 0.0;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro.getTitulo() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucionEsperada=" + fechaDevolucionEsperada +
                ", fechaDevolucion=" + fechaDevolucion +
                ", multaActual=" + calcularMulta() +
                '}';
    }
}