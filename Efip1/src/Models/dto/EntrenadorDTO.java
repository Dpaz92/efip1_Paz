package Models.dto;

import Models.Entrenador;

public class EntrenadorDTO {
    public String nombre;
    public String apellido;
    public String email;

    public void printDetails() {
        if (nombre != null) {
            System.out.println("Nombre: " + nombre);
        }
        if (apellido != null) {
            System.out.println("Apellido: " + apellido);
        }
        if (email != null) {
            System.out.println("Email: " + email);
        }
    }

    public EntrenadorDTO() {}

    public EntrenadorDTO(Entrenador entrenador) {
        this.nombre = entrenador.getNombre();
        this.apellido = entrenador.getApellido();
        this.email = entrenador.getEmail();
    }
}
