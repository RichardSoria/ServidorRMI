package rmi.servidor.clase;

import java.rmi.Remote;
import java.util.List;

public interface Servidor extends Remote {

    // Consultar un registro por ID
    public String consultar(int id) throws Exception;
    List<Persona> listar() throws Exception;
    boolean agregar(Persona persona) throws Exception;
    boolean actualizar(int id, Persona persona) throws Exception;
    boolean eliminar(int id) throws Exception;

}
