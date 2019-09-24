import java.io.*;
import java.rmi.*;
import java.sql.*;
import java.util.*;

public class conexion {

    String motivoIng, nombreMas, sexo, especie;
    String query;

    public conexion(String query) throws ServerException, IOException {

        try {
            // paso 1 registro del drive
            Class.forName("com.mysql.jdbc.Driver");

            // paso 2 obtenemos conexion
            String url = "jdbc:mysql://localhost:3306/veterinaria";

            String usuario = "root";
            String password = "";

            // Contruccion del objeto conection
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            // paso 3 contruccion del query
            this.query = query;

            // paso 4 canal de comunicacion

            Statement st = conexion.createStatement();

            // paso 5 ejecucion query
            st.executeUpdate(query);

            // paso 6 Cerrar st y la conexcion
            st.close();
            conexion.close();
        } catch (Exception e) {
            // out.println("<br>Error en la BD<br>"+e.getMessage());
        }
    }
}