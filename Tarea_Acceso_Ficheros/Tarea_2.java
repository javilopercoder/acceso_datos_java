import java.io.*;
import java.util.Scanner;

public class Tarea_2 {
    public static void main(String[] args) {
        String filename;
        
        if (args.length > 0) {
            filename = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nombre del archivo: ");
            filename = scanner.nextLine();
            scanner.close();
        }
        
        int wordCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // dividir por espacios en blanco
                wordCount += words.length;
            }
            reader.close();
            System.out.println("El archivo tiene " + wordCount + " palabras en total.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
