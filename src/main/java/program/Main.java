package program;

import program.database.DataRepository;
import program.gui.window.AuthenticationWindow;
import main.java.program.gui.Controller;
import program.gui.window.View;
import program.model.Store;
import program.utility.encryption.Encrypt;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        DataRepository dataBase = DataRepository.getInstance();
        Controller controller = new Controller();
        AuthenticationWindow authenticationWindow = new AuthenticationWindow();
        controller.executeAuthenticationWindow(authenticationWindow);



        System.out.println("*************************\n" +
                           "*    ООО Продуктовый    *\n" +
                           "*       г.Ангарск       *\n" +
                           "*************************\n" +
                           "КАССОВЫЙ ЧЕК:         № 1\n" +
                "");
    }
}
