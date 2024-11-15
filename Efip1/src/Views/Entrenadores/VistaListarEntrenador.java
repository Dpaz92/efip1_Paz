package Views.Entrenadores;

import Controllers.EntrenadorController;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Data.EntrenadoresRepository;
import Models.Entrenador;
import Models.dto.EntrenadorDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaListarEntrenador {
    EntrenadorController entrenadorController;

    public VistaListarEntrenador(ISessionService sessionService) throws SQLException, ClassNotFoundException {
        this.entrenadorController = new EntrenadorController(sessionService);
        this.vista();
        Scanner scanner = new Scanner(System.in);
        int wait = scanner.nextInt();
    }

    public void vista() throws SQLException, ClassNotFoundException {
        System.out.println("Listado de Entrenadores");
        ArrayList<Entrenador> entrenadorArrayList = entrenadorController.listar();
        for (Entrenador entrenador : entrenadorArrayList) {
            entrenador.printDetails();
        }
        System.out.println("\n0 para volver");
    }
}
