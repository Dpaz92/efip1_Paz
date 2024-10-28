package Data;

import Models.Rol;
import Models.Usuario;

import java.util.ArrayList;

public class UsuariosData extends Data {
    private ArrayList<Usuario> usuarios;

    public UsuariosData() {
        this.usuarios = new ArrayList<>();
        this.addUsuario(new Usuario(1, "admin@uccle.com", "admin", "admin", "uccle", Rol.ADMINISTRADOR));
    }

    public void setType() {
        super.type = DataType.USUARIOS;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario(String email) {
        return this.usuarios.stream().filter(usuario -> email.equals(usuario.getEmail())).findAny().orElse(null);
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
