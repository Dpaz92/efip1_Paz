package Views.Entrenadores;

import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Views.Comunes.ScreenCleaner;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuEntrenadores {
    DataService dataService;
    ISessionService sessionService;

    public MenuEntrenadores(ISessionService sessionService) throws SQLException, ClassNotFoundException {
        this.sessionService = sessionService;
        this.vista();
    }

    public int vista() throws SQLException, ClassNotFoundException {
        ScreenCleaner.cleanScreen();
        opciones();
        int opcionEntrenadores = opcionEntrenadores();
        while (opcionEntrenadores != 0) {
            switch (opcionEntrenadores) {
                case 1:
                    //Crear entrenador
                    VistaCrearEntrenador vistaCrearEntrenador = new VistaCrearEntrenador(sessionService);
                    opcionEntrenadores = 0;
                    break;
                case 2:
                    //Listar entrenadores
                    VistaListarEntrenador vistaListarEntrenador = new VistaListarEntrenador(sessionService);
                    opcionEntrenadores = 0;
                    break;
                case 3:
                    //Editar entrenador
                    break;
                case 4:
                    //Buscar entrenador
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
        return 9;
    }

    private void opciones() {
        System.out.println("Gestion de entrenadores");
        System.out.println("Que desea realizar?");
        System.out.println("1) Agregar entrenador");
        System.out.println("2) Listar entrenadores");
        System.out.println("3) Editar entrenador");
        System.out.println("3) Buscar entrenador");
        System.out.println("0) Volver atras");
    }

    private int opcionEntrenadores() {
        Scanner entrada = new Scanner(System.in);
        System.out.printf("Seleccione una opcion: ");
        int opcion = entrada.nextInt();
        return opcion;
    }
}
