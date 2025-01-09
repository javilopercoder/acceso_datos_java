package Tarea4.src.main.java.com.example;

public class Libro {
    private String titulo;
    private String ISBN;
    private int añoPublicacion;
    private Autor autor;
    private Editorial editorial;

    public Libro(String titulo, String ISBN, int añoPublicacion, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.autor = autor;
        this.editorial = editorial;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Año de Publicación: " + añoPublicacion);
        System.out.println("Autor: " + autor.getNombreCompleto());
        System.out.println("Editorial: " + editorial.getNombre());
    }
}