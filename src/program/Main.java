package program;

import program.encryption.Encrypt;
import program.gui.Controller;
import program.gui.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        View view = new View();
        Controller controller = new Controller();
        controller.execute(view);
        System.out.println(Encrypt.encrypt("1"));

    }
}
