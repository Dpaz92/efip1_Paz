package Models;

import Models.dto.EntrenadorDTO;

public class Entrenador {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int creadoPorUsuarioId;

    public Entrenador(int id, String nombre, String apellido, String email, int creadoPorUsuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.creadoPorUsuarioId = creadoPorUsuarioId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public EntrenadorDTO toDTO() {
        EntrenadorDTO entrenadorDTO = new EntrenadorDTO(this);
        return entrenadorDTO;
    }
}
