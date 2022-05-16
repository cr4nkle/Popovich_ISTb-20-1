package program;

import program.model.Product;
import program.utility.database.DataBase;
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
        DataBase dataBase = new DataBase();
        //store.add();
        //AuthenticationWindow authenticationWindow = new AuthenticationWindow(view);
        Controller controller = new Controller(view, store);
        controller.execute();
        //controller.executeAuthenticationWindow(authenticationWindow);
        /*try{
            DataBase.initDB();
            DataBase.createDB();
            DataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
        try {
            dataBase.initDB();
            //DataBase.addProduct(new Product(1, "хлеб", 30, 100));
            //DataBase.deleteProduct(1);
            //DataBase.buyProduct(1, 20);
            controller.setDataBase(dataBase);
            store.setCashierList(dataBase.getCashierList());
            dataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
