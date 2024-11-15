package Models;

public class Usuario {
    private int id;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String email;
    private Rol rol;

    public Usuario() {

    }

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
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean login(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol mapRolFromString(String rol) {
        switch (rol) {
            case "administrador":
                return Rol.ADMINISTRADOR;
            case "coordinador":
                return Rol.COORDINADOR;
        }
        return null;
    }
}
