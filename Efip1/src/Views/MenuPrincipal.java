package Views;

import Controllers.Interfaces.ISessionService;
import Controllers.UsuariosController;
import Data.DataService;
import Views.Comunes.ScreenCleaner;
import Views.Entrenadores.MenuEntrenadores;

import java.util.Scanner;

public class MenuPrincipal {
    DataService dataService;
    ISessionService sessionService;
    UsuariosController usuariosController;

    public MenuPrincipal(DataService dataService, ISessionService sessionService) {
        this.dataService = dataService;
        this.sessionService = sessionService;
        this.usuariosController = new UsuariosController(dataService, sessionService);
        this.principal();
    }

    public void principal() {
        titulo();
        menu();
        int moduloSeleccionado = seleccionDeMenu();
        while (moduloSeleccionado != 0) {
            switch (moduloSeleccionado) {
                case 1:
                    //Entrenadores
                    MenuEntrenadores menuEntrenadores = new MenuEntrenadores(dataService);
                    moduloSeleccionado = menuEntrenadores.vista();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    ScreenCleaner.cleanScreen();
                    menu();
                    moduloSeleccionado = seleccionDeMenu();
                    break;
            }
        }
        boolean hasLogout = this.usuariosController.logout();
        if (hasLogout) {
            ScreenCleaner.cleanScreen();
            System.out.println("Has cerrado sesion con exito, presiona enter");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }

    private void titulo() {
        System.out.println("Sistema de grabacion de partidos de Royal Uccle Sports");
        System.out.println("");
    }

    private void menu() {
        System.out.println("Seleccione un modulo:");
        System.out.println("1) Entrenadores");
        System.out.println("2) Equipos");
        System.out.println("3) Partidos");
        System.out.println("4) Administrar usuarios");
        System.out.println("0) Cerrar sesion");
    }

    public int seleccionDeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese su opcion:");
        int seleccion = sc.nextInt();
        return seleccion;
    }
}
