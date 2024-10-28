package Views.Entrenadores;

import Controllers.EntrenadorController;
import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Models.dto.EntrenadorDTO;
import Views.Comunes.ScreenCleaner;

import java.util.Objects;
import java.util.Scanner;

public class VistaCrearEntrenador {
    private EntrenadorDTO entrenadorDTO = new EntrenadorDTO();
    private DataService dataService;
    private ISessionService sessionService;
    private EntrenadorController entrenadorController;

    public VistaCrearEntrenador(DataService dataService, ISessionService sessionService) {
        this.dataService = dataService;
        this.entrenadorController = new EntrenadorController(dataService, sessionService);
        this.vista();
    }

    public void vista() {
        int paso = 0;
        while (paso != 10) {
            ScreenCleaner.cleanScreen();
            this.titulo();
            this.info();
            switch (paso) {
                case 0:
                    paso = this.paso0();
                    break;
                case 1:
                    paso = this.paso1();
                    break;
                case 2:
                    paso = this.paso2();
                    break;
                case 3:
                    paso = this.paso3();
                    break;
                case 4:
                    //guardar
                    paso = this.save();
                    break;
                case 9:
                    //cancelar
                    paso = this.cancel();
                    break;
                default:
                    //salir
                    break;
            }
        }
    }

    private void titulo() {
        System.out.println("CREAR ENTRENADOR");
    }

    private void info() {
        entrenadorDTO.printDetails();
    }

    private int paso0() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = sc.nextLine();
        entrenadorDTO.nombre = nombre;
        return 1;
    }

    private int paso1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese apellido o 0 para retroceder:");
        String apellido = sc.nextLine();
        if (isReturn(apellido)) {
            return 0;
        }
        entrenadorDTO.apellido = apellido;
        return 2;

    }

    private int paso2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese email o 0 para retroceder:");
        String email = sc.nextLine();
        if (isReturn(email)) {
            return 1;
        }
        entrenadorDTO.email = email;
        return 3;
    }

    private int paso3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Confirmacion de datos (Y/N):");
        String confirmacion = sc.nextLine();
        if (isConfirmation(confirmacion)) {
            return 4;
        }
        return 9;
    }

    private int save() {

        return 10;
    }

    private int cancel() {
        return 10;
    }

    private boolean isReturn(String input) {
        return Objects.equals(input, "0");
    }

    private boolean isConfirmation(String input) {
        return Objects.equals(input, "Y") || Objects.equals(input, "y");
    }
}
