package Models;

import Models.dto.EntrenadorDTO;

public class Entrenador {
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    public Entrenador(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Entrenador() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public EntrenadorDTO toDTO() {
        EntrenadorDTO entrenadorDTO = new EntrenadorDTO(this);
        return entrenadorDTO;
    }

    public void printDetails() {
        System.out.print(id + ")");
        if (nombre != null) {
            System.out.print(" Nombre: " + nombre);
        }
        if (apellido != null) {
            System.out.print(" Apellido: " + apellido);
        }
        if (email != null) {
            System.out.print(" Email: " + email);
        }
    }
}
