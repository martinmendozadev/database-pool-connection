import java.util.ArrayList;
import java.io.*;
import java.sql.*;
import java.rmi.*;
import java.util.*;

public class ModeloPaciente {

    Connection miConexion = null;
    Statement miStatement = null;
    ResultSet miResulset = null;

    public ModeloPaciente() {

    }

    public List<paciente> getPacientes() throws Exception {
        List<paciente> pacientes = new ArrayList<>();

        try {
            // Query lo Creamos y ejecutamos
            String query = "SELECT*FROM datos";
            miStatement = miConexion.createStatement();
            miResulset = miStatement.executeQuery(query);

            // Lectura del Query
            while (miResulset.next()) {
                int id = miResulset.getInt(1);
                String motivoIng = miResulset.getString(2);
                String nombreMas = miResulset.getString(3);
                String sexo = miResulset.getString(4);
                String especie = miResulset.getString(5);

                paciente temPac = new paciente(id, motivoIng, nombreMas, sexo, especie);
                pacientes.add(temPac);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return pacientes;
    }
}