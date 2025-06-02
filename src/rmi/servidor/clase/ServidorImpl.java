package rmi.servidor.clase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) {
        Persona p = Consulta.buscarPorId(id);
        return (p != null)
                ? "Nombre: " + p.getNombre() + "\nCorreo: " + p.getCorreo() + "\nCargo: " + p.getCargo() + "\nSueldo: " + p.getSueldo()
                : "No existe la persona con el ID: " + id;
    }

    @Override
    public ArrayList<Persona> listar() {
        return Consulta.getPersonas();
    }

    @Override
    public boolean agregar(Persona persona) {
        return Consulta.insertarPersona(persona);
    }

    @Override
    public boolean actualizar(int id, Persona persona) {
        return Consulta.actualizarPersona(id, persona);
    }

    @Override
    public boolean eliminar(int id) {
        return Consulta.eliminarPersona(id);
    }
}
