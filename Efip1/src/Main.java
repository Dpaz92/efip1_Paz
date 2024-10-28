import Controllers.Interfaces.ISessionService;
import Data.DataService;
import Services.VideoUploaderListener;
import Services.SessionService;
import Views.*;
import Views.Comunes.ScreenCleaner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        DataService dataService = new DataService();
        ISessionService sessionService = new SessionService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        int appType = 3;
        while (appType != 0) {
            switch (appType) {
                case 1:
                    VideoUploaderListener videoUploaderListener = new VideoUploaderListener();

                    while (!br.ready()) {}
                    videoUploaderListener.stop();
                    ScreenCleaner.cleanScreen();
                    appType = 3;
                    break;
                case 2:
                    while (!sessionService.isLoggedIn()) {
                        LoginVista login = new LoginVista(dataService, sessionService);

                        while (sessionService.isLoggedIn()) {
                            MenuPrincipal menuPrincipal = new MenuPrincipal(dataService, sessionService);
                        }
                        appType = 3;
                        ScreenCleaner.cleanScreen();
                        break;
                    }
                    break;
                default:
                    System.out.println("Elige la app:");
                    System.out.println("1) Background");
                    System.out.println("2) Dashboard");
                    try {
                        appType = scanner.nextInt();
                        if (appType != 1 && appType != 2) {
                            throw new InputMismatchException();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Debe ingresar un valor valido");
                        scanner.nextLine();
                        appType = 3;
                    }
                    break;
            }
        }
    }
}
