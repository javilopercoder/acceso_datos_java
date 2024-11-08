import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionMySQL {
    public static void main(String[] args) {
        // Configuración de conexión
        String url = "jdbc:mysql://localhost:3306/users";
        String usuario = "tu_usuario"; // Cambia "tu_usuario" por el nombre de usuario de MySQL
        String contrasena = "tu_contraseña"; // Cambia "tu_contrasena" por la contraseña de MySQL

        try {
            // Establecer conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos");

            // Crear sentencia y ejecutar consulta
            String consulta = "SELECT * FROM usuarios";
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(consulta);

            // Mostrar resultados
            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                int edad = resultados.getInt("edad");
                String correo = resultados.getString("correo");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido +
                        ", Edad: " + edad + ", Correo: " + correo);
            }

            // Cerrar conexión
            resultados.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
