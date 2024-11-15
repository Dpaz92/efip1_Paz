package Controllers.Interfaces;

import Models.Exceptions.InvalidPasswordException;
import Models.Exceptions.UserNotFoundException;
import Models.Usuario;

import java.sql.SQLException;

public interface ILoginService {
    Usuario login(String username, String password) throws UserNotFoundException, InvalidPasswordException, SQLException, ClassNotFoundException;
}
