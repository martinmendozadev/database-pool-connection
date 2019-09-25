import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.rmi.ServerException;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

public class ControladorPacientes extends HttpServlet {

    private ModeloPaciente modeloPacientes;

    public void init() throws ServletException {
        try {

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {

        PrintWriter salida = response.getWriter();
        response.setContentType("text/plain");
        List<paciente> pacientes;

        try {
            pacientes.modeloPacientes.getPacientes();
            request.setAtrribute("LISTAPACIENTES", pacientes);

            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaPaciente.jsp");

            miDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}