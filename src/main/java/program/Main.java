package program;

import program.gui.window.ReceiptOutputWindow;
import program.database.DataBase;
import program.gui.window.AuthenticationWindow;
import main.java.program.gui.Controller;
import program.gui.window.View;
import program.model.Cashier;
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
            //dataBase.deleteProduct(450);
            //dataBase.updateProduct(451, 20);
            //dataBase.getCashierID("Сергей");
            //dataBase.addCashier(new Cashier("Сергей", "админ"));
            controller.setDataBase(dataBase);
            dataBase.setProductArrayList(dataBase.getProductList());
            dataBase.setCashierArrayList(dataBase.getCashierList());
            store.setCashierList(dataBase.getCashierList());
            //dataBase.buyProduct(444, 20);
            //System.out.println(dataBase.getReceiptCount());

            dataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Cashier c = new Cashier(1,"ggggg", "kjjkj");
        System.out.println(c.getId());
        System.out.println("*************************\n" +
                           "*    ООО Продуктовый    *\n" +
                           "*       г.Ангарск       *\n" +
                           "*************************\n" +
                           "КАССОВЫЙ ЧЕК:         № 1\n" +
                "");
    }
}
