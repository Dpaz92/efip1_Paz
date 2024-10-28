package Controllers.Interfaces;

import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Models.Usuario;

public interface ILoginService {
    Usuario login(String username, String password) throws UserNotFoundException, InvalidPasswordException;
}
