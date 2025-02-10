package com.example.biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private int id;
    private String genero;

    public Libro(String titulo, String autor, int id, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id=" + id +
                ", genero='" + genero + '\'' +
                '}';
    }
}