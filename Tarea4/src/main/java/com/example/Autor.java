package Tarea4.src.main.java.com.example;
public class Autor {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;

    public Autor(String nombre, String apellido, String fechaNacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Nacionalidad: " + nacionalidad);
    }
}