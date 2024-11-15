package Views;

import Controllers.Interfaces.ILoginService;
import Controllers.Interfaces.ISessionService;
import Controllers.UsuariosController;
import Data.DataService;
import Models.Exceptions.InvalidEmailException;
import Services.EmailValidator;
import Services.LoginService;

import java.util.Scanner;

public class LoginVista {
    private UsuariosController usuariosController;
    private ISessionService sessionService;

    public LoginVista(ISessionService sessionService) {
        this.sessionService = sessionService;
        this.usuariosController = new UsuariosController(sessionService);
        this.displayLogin();
    }

    private void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciar sesion al sistema de Royal Uccle Sports");
        while (!sessionService.isLoggedIn()) {
            try {
                String email;
                try {
                    System.out.println("Ingrese su email:");
                    email = scanner.nextLine();
                    EmailValidator emailValidator = new EmailValidator();
                    emailValidator.validate(email);
                } catch (InvalidEmailException e) {
                    System.out.println("Formato de email invalido");
                    continue;
                }
                System.out.println("Ingrese su password:");
                String password = scanner.nextLine();
                this.usuariosController.login(email, password);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        System.out.println("Inicio de sesion exitoso, presione enter");
        scanner.nextLine();
    }
}
