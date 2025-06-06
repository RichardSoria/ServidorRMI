package rmi.servidor.test;

import rmi.servidor.clase.Consulta;
import rmi.servidor.clase.Persona;
import rmi.servidor.clase.ServidorImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Test {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        ServidorImpl servidor = new ServidorImpl();
        String rmiObjectName = "rmi://localhost/Datos";
        Naming.rebind(rmiObjectName, servidor);
        System.out.println("Servidor RMI iniciado y esperando peticiones...");
    }
}