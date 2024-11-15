package Services;

import Controllers.Interfaces.ILoginService;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Data.IMockData;
import Data.UsuariosRepository;
import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Models.Usuario;

import java.sql.SQLException;

public class LoginService implements ILoginService {
    private UsuariosRepository usuariosRepository;

    public LoginService() {
        this.usuariosRepository = new UsuariosRepository();
    }

    public Usuario login(String email, String contrasena) throws UserNotFoundException, InvalidPasswordException, SQLException, ClassNotFoundException {

        Usuario usuario = this.usuariosRepository.getUsuarioByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException("El email no esta asociado a ningun usuario");
        }

        if (!usuario.login(contrasena)) {
            throw new InvalidPasswordException("Contraseña invalida");
        }

        return usuario;
    }

}
