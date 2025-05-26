package rmi.servidor.clase;

import java.rmi.Remote;

public interface Servidor extends Remote {

    // Consultar un registro por ID
    public String consultar(int id) throws Exception;
}
