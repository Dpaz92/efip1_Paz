package Controllers;

import Controllers.Interfaces.IEntrenadorController;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Models.dto.EntrenadorDTO;

public class EntrenadorController implements IEntrenadorController {
    DataService dataService;
    ISessionService sessionService;

    public EntrenadorController(DataService dataService, ISessionService sessionService) {
        this.dataService = dataService;
        this.sessionService = sessionService;
    }

    @Override
    public Boolean create(EntrenadorDTO entrenador) {
        if (!this.sessionService.isLoggedIn()) {
            return false;
        }
        this.dataService.addEntrenador(entrenador);
        return true;
    }
}
