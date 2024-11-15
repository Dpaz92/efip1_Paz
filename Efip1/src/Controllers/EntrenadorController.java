package Controllers;

import Controllers.Interfaces.IEntrenadorController;
import Controllers.Interfaces.ISessionService;
import Data.EntrenadoresRepository;
import Models.Entrenador;
import Models.dto.EntrenadorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrenadorController implements IEntrenadorController {
    ISessionService sessionService;

    public EntrenadorController(ISessionService sessionService) {

        this.sessionService = sessionService;
    }

    @Override
    public Boolean create(EntrenadorDTO entrenador) {
        if (!this.sessionService.isLoggedIn()) {
            return false;
        }

        EntrenadoresRepository entrenadoresRepository = new EntrenadoresRepository();
        try {
            return entrenadoresRepository.Insertar(entrenador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Entrenador> listar() throws SQLException, ClassNotFoundException {
        EntrenadoresRepository entrenadoresRepository = new EntrenadoresRepository();
        return entrenadoresRepository.Listar();
    }
}
