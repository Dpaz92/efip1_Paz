package Controllers;

import Controllers.Interfaces.ILoginService;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Services.LoginService;

public class UsuariosController {
    private ISessionService sessionService;
    private ILoginService loginService;
    private DataService dataService;

    public UsuariosController(DataService dataService, ISessionService sessionService) {
        this.loginService = new LoginService(dataService);
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
        } catch (UserNotFoundException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    };

    public boolean logout() {
        var result = this.sessionService.deleteUserToken();
        return result;
    }
}
