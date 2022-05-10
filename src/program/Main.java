package program;

import program.encryption.Encrypt;
import program.gui.AuthenticationWindow;
import program.gui.Controller;
import program.gui.View;
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
        System.out.println(Encrypt.encrypt("1"));

    }
}
