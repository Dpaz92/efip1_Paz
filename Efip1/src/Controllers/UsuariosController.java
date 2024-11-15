package Controllers;

import Controllers.Interfaces.ILoginService;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Data.UsuariosRepository;
import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Services.LoginService;

import java.sql.SQLException;

public class UsuariosController {
    private ISessionService sessionService;
    private ILoginService loginService;

    public UsuariosController(ISessionService sessionService) {
        this.loginService = new LoginService();
        this.sessionService = sessionService;
    }

    public boolean login(String email, String contrasena) throws UserNotFoundException, InvalidPasswordException {
        try {
            if (sessionService.isLoggedIn()) {
                return true;
            }

            var user = loginService.login(email, contrasena);
            if (user == null) {
                return false;
            }

            sessionService.saveUserToken(user);
            return true;
        } catch (UserNotFoundException | InvalidPasswordException | SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    };

    public boolean logout() {
        var result = this.sessionService.deleteUserToken();
        return result;
    }
}
