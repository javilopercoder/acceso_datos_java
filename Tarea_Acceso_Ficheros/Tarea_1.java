import java.io.*;

public class Tarea_1 {
    public static void main(String[] args) {
        String asignatura = "Nombre de la asignatura: Acceso a Datos";
        String estudiante = "Nombre del estudiante: Javier López";

        try {
            FileWriter writer = new FileWriter("datos.txt");
            writer.write(asignatura + "\n");
            writer.write(estudiante + "\n");
            writer.close();
            System.out.println("Datos escritos en el fichero 'datos.txt'.");

            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String line;
            System.out.println("Contenido del fichero:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
