package rmi.servidor.clase;


import lombok.Getter;

public class Persona {
    @Getter private int id;
    @Getter private String nombre;
    @Getter private String correo;
    @Getter private String cargo;
    @Getter private double sueldo;

    public Persona(int id, String nombre, String correo, String cargo, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
}
