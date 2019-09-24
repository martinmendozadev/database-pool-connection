import java.io.*;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.*;
import java.rmi.*;
import java.util.*;

public class mostrar extends HttpServlet {

    // Establecer el DataSource
    @Resource(name = "jdbc/veterinaria")
    private DataSource miPool;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {

        PrintWriter salida = response.getWriter();
        response.setContentType("text/plain");

        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResulset = null;

        try {
            miConexion = miPool.getConnection();

            // Query lo Creamos y ejecutamos
            String miSql = "select*from datos";
            miStatement = miConexion.createStatement();
            miResulset = miStatement.executeQuery(miSql);

            // Lectura del Query
            while (miResulset.next()) {
                String fecha = miResulset.getString(1);
                salida.println(fecha);
            }

        } catch (Exception e) {
            salida.println(e.getMessage());
        }
    }
}