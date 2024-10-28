package Models;

public class Usuario {
    private int id;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String email;
    private Rol rol;

    public Usuario(int id, String email, String contrasena, String nombre, String apellido, Rol rol) {
        this.id = id;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public boolean login(String contrasena) {
        return this.contrasena.equals(contrasena);
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

    public Rol getRol() {
        return rol;
    }
}
