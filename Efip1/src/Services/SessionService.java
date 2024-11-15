package Services;

import Controllers.Interfaces.ISessionService;
import Models.Usuario;

public class SessionService implements ISessionService {
    private Usuario usuarioLogueado;
    public SessionService() {
    }

    public void saveUserToken(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public Usuario getUserToken() {
        return usuarioLogueado;
    }

    public boolean isLoggedIn() {
        return this.usuarioLogueado != null;
    }

    public boolean deleteUserToken() {
        this.usuarioLogueado = null;
        return true;
    }
}

