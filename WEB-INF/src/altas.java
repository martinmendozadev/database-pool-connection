//Iportamos nuestro paquetes a utilizar
import java.io.*;
import java.rmi.ServerException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.annotation.Resource;

public class altas extends HttpServlet {

  //Variables globales para almacenar valores del formulario
  String motivoIng, nombreMas, sexo, especie;

   //Establecemos el DataSource
  @Resource(name = "jdbc/veterinaria")
  private DataSource miPool;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

    //Establecemos nuestro out
    PrintWriter out = response.getWriter();

    //Variables de Conexión
    Connection miConexion = null;
    Statement miStatement = null;

    try {
      //Formato de salida
      response.setContentType("text/html");

      //Iniciamos a crear nuestro HTML
      out.println("<HTML><CENTER>");

      //Se reciben los valores del formulario1
      motivoIng = request.getParameter("motivoIn");
      nombreMas = request.getParameter("nombrem");
      sexo = request.getParameter("hm1");
      especie = request.getParameter("hm2");

      //Se impirme en etiquetas H2 los datos introducidos en el formulario.
      out.println("<h2> Motivo Ingreso: " + motivoIng + "</h2>");
      out.println("<h2> Nombre Mascota: " + nombreMas + "</h2>");
      out.println("<h2> Sexo Mascota: " + sexo + "</h2>");
      out.println("<h2> Especie: " + especie + "</h2>");

      //Cerramos nuestro documento HTML
      out.println("</CENTER></HTML>");

    } catch (Exception e) {
      //En caso de algún error nuestro Catch se ejecuta
      out.println("Ocurrio un error en main:\n" + e);
    }

    try {
      /*Iniciamos la conexión a la BD*/

      //Paso 1 Obtenemos conexión
      miConexion = miPool.getConnection();
      out.println("<br>Conexion a BD establecida");

      //Paso 2 Construimos nuestro Query
      String miSql = "insert into datos (motivoIng,nombreMas,sexo,especie) values('" + motivoIng + "','" + nombreMas+ "','" + sexo + "','" + especie +"')";
      out.println("<br>" + miSql);

      //Paso 3 Establecemos el canal de comunicación
      miStatement = miConexion.createStatement();
      out.println("<br>Canal a BD establecido");

      //Paso 4 Ejecución del query
      miStatement.executeUpdate(miSql);
      out.println("<br>Query ejecutado correctamente");

    } catch (Exception e) {
      //En caso de error se ejecuta el catch
      out.println("<br>Error en la BD<br>" + e.getMessage());
    }

  }
}