package Views.Entrenadores;

import Data.DataService;
import Models.dto.EntrenadorDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaListarEntrenador {
    private DataService dataService;

    public VistaListarEntrenador(DataService dataService) {
        this.dataService = dataService;
        this.vista();
        Scanner scanner = new Scanner(System.in);
        int wait = scanner.nextInt();
    }

    public void vista() {
        System.out.println("Listado de Entrenadores");
        ArrayList<EntrenadorDTO> entrenadorDTOArrayList = dataService.getEntrenadoresData().getEntrenadores();
        for (EntrenadorDTO entrenadorDTO : entrenadorDTOArrayList) {
            entrenadorDTO.printDetails();
        }
    }
}
