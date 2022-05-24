package program;

import program.utility.barcode.Barcode;
import program.utility.database.DataBase;
import program.gui.window.AuthenticationWindow;
import main.java.program.gui.Controller;
import program.gui.window.View;
import program.model.Store;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        View view = new View();
        Store store = new Store();
        DataBase dataBase = new DataBase();
        AuthenticationWindow authenticationWindow = new AuthenticationWindow(view);
        Controller controller = new Controller(view, store);
        controller.execute();
        controller.executeAuthenticationWindow(authenticationWindow);
        try {
            dataBase.initDB();
//            dataBase.createDB();
//            dataBase.addProduct(new Product(444, "хлеб", 20, 100));
//            dataBase.addProduct(new Product(445, "молоко", 30, 100));
//            dataBase.addProduct(new Product(446, "кефир", 40, 100));
            //dataBase.deleteProduct(445);
            //dataBase.updateProduct(44, 20);
            //dataBase.addCashier(new Cashier("Сергей", "админ"));
            controller.setDataBase(dataBase);
            dataBase.setProductArrayList(dataBase.getProductList());
            dataBase.setCashierArrayList(dataBase.getCashierList());
            store.setCashierList(dataBase.getCashierList());
            //dataBase.buyProduct(444, 20);
            dataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
