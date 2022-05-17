package program;

import program.model.Cashier;
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
        AuthenticationWindow authenticationWindow = new AuthenticationWindow(view);
        Controller controller = new Controller(view, store);
        controller.execute();
        controller.executeAuthenticationWindow(authenticationWindow);
        /*try{
            DataBase.initDB();
            DataBase.createDB();
            DataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
        try {
            dataBase.initDB();
            //dataBase.createDB();
            //dataBase.addProduct(new Product(444, "хлеб", 20, 100));
            //dataBase.addProduct(new Product(445, "молоко", 30, 100));
            //dataBase.addProduct(new Product(446, "кефир", 40, 100));
            //DataBase.deleteProduct(1);
            //DataBase.buyProduct(1, 20);
            dataBase.
            //dataBase.addCashier(new Cashier("Сергей", "админ"));
            controller.setDataBase(dataBase);
            dataBase.setProductArrayList(dataBase.getProductList());
            dataBase.setCashierArrayList(dataBase.getCashierList());
            store.setCashierList(dataBase.getCashierList());
            dataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
