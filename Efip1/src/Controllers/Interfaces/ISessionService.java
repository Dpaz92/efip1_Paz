package Controllers.Interfaces;

import Models.Usuario;

public interface ISessionService {
    void saveUserToken(Usuario usuario);
    Usuario getUserToken();
    boolean isLoggedIn();
    boolean deleteUserToken();
}
