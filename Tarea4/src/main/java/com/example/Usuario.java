package Tarea4.src.main.java.com.example;

public class Usuario {
    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private String email;

    public Usuario(String nombre, String apellido, String numeroIdentificacion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("ID: " + numeroIdentificacion);
        System.out.println("Email: " + email);
    }
}