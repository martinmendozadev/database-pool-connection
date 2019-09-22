import javax.servlet.http.*;
import java.io.*;
import java.rmi.*;
import java.sql.*;
import java.util.*;

public class altas extends HttpServlet {

  String motivoIng, nombreMas, sexo, especie;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

    PrintWriter out = response.getWriter();

    try {
      response.setContentType("text/html");
      HttpSession sesion = request.getSession(true);

      out.println("<HTML><CENTER>");

      // Se reciben los valores del formulario1
      motivoIng = request.getParameter("motivoIn");
      nombreMas = request.getParameter("nombrem");
      sexo = request.getParameter("hm1");
      especie = request.getParameter("hm2");

      // Se impirme en una pagina
      out.println("<h2> Motivo Ingreso: " + motivoIng + "</h2>");
      out.println("<h2> Nombre Mascota: " + nombreMas + "</h2>");
      out.println("<h2> Sexo Mascota: " + sexo + "</h2>");
      out.println("<h2> Especie: " + especie + "</h2>");

      out.println("</CENTER></HTML>");
    } catch (Exception e) {
      out.println("Ocurrio un error en main:" + e);
    }

    try {

      // paso 1 registro del drive
      out.println("Inicio <br>");
      Class.forName("com.mysql.jdbc.Driver");
      out.println("Driver registrado <br>");

      // paso 2 obtenemos conexion
      String url = "jdbc:mysql://localhost:3306/veterinaria";

      String usuario = "root";
      String password = "";

      out.println("Conectado ..." + url);
      Connection conexion = DriverManager.getConnection(url, usuario, password);
      out.println("<br> Conexion lista");

      // paso 3 contruccion del query
      String query = "insert into datos (motivoIng,nombreMas,sexo,especie) values('" + motivoIng + "','" + nombreMas
          + "','" + sexo + "','" + especie + "','" + peso + "')";
      out.println("<br>" + query);

      // paso 4 canal de comunicacion
      Statement st = conexion.createStatement();

      // paso 5 ejecucion query
      st.executeUpdate(query);
      out.println("<br>Insertado correctamente");

      // paso 6 Cerrar st y la conexcion
      st.close();
      conexion.close();

    } catch (Exception e) {
      out.println("<br>Error en la BD<br>" + e.getMessage());
    }

  }
}