package rmi.servidor.clase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ServidorImpl extends UnicastRemoteObject implements Servidor {
    private static ArrayList<Persona> listaPersonas() {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Juan Pérez", "juan.perez@example.com", "Gerente", 3500.00));
        lista.add(new Persona(2, "Ana Torres", "ana.torres@example.com", "Asistente", 2000.00));
        lista.add(new Persona(3, "Luis Gómez", "luis.gomez@example.com", "Contador", 2800.00));
        lista.add(new Persona(4, "María Reyes", "maria.reyes@example.com", "Recepcionista", 1800.00));
        lista.add(new Persona(5, "Carlos León", "carlos.leon@example.com", "Ingeniero", 4000.00));
        lista.add(new Persona(6, "Laura Vélez", "laura.velez@example.com", "Diseñadora", 2700.00));
        lista.add(new Persona(7, "Pedro Ramírez", "pedro.ramirez@example.com", "Ventas", 3200.00));
        lista.add(new Persona(8, "Sofía Acosta", "sofia.acosta@example.com", "Marketing", 3000.00));

        return lista;
    }

    public static String getPesona(int id) {
        return "Nombre: " + listaPersonas().get(id - 1).getNombre() + "\n"
                + "Correo: " + listaPersonas().get(id - 1).getCorreo() + "\n"
                + "Cargo: " + listaPersonas().get(id - 1).getCargo() + "\n"
                + "Sueldo: " + listaPersonas().get(id - 1).getSueldo();
    }

    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws Exception {
        if (id < listaPersonas().size() + 1) {
            return getPesona(id);
        } else {
            return "No existe el empleado con ID: " + id;
        }
    }
}
