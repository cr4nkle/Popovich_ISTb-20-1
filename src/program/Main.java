package program;

import program.utility.encryption.Encrypt;
import program.gui.window.AuthenticationWindow;
import program.gui.Controller;
import program.gui.window.View;
import program.model.Store;

public class Main {

    public static void main(String[] args) {
	// write your code here
        View view = new View();
        Store store = new Store();
        store.add();
        AuthenticationWindow authenticationWindow = new AuthenticationWindow(view);
        Controller controller = new Controller(view, store);
        controller.execute();
        controller.executeAuthenticationWindow(authenticationWindow);
    }
}
