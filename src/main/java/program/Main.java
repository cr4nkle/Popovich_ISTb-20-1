package program;

import program.database.DataRepository;
import program.gui.window.AuthenticationWindow;
import main.java.program.gui.Controller;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        AuthenticationWindow authenticationWindow = new AuthenticationWindow();
        controller.executeAuthenticationWindow(authenticationWindow);
    }
}
