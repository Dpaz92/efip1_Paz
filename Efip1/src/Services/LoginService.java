package Services;

import Controllers.Interfaces.ILoginService;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Data.IMockData;
import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Models.Usuario;

public class LoginService implements ILoginService {
    private DataService dataService;

    public LoginService(DataService dataService) {
        this.dataService = dataService;
    }

    public Usuario login(String email, String contrasena) throws UserNotFoundException, InvalidPasswordException {

        Usuario usuario = this.dataService.getUsuario(email);
        if (usuario == null) {
            throw new UserNotFoundException("El email no esta asociado a ningun usuario");
        }

        if (!usuario.login(contrasena)) {
            throw new InvalidPasswordException("Contraseña invalida");
        }

        return usuario;
    }

}
