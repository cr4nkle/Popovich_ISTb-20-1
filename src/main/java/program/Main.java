package program;

import program.database.DataRepository;
import program.gui.window.AuthenticationWindow;
import main.java.program.gui.Controller;
import program.gui.window.View;
import program.model.Store;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        DataRepository dataBase = DataRepository.getInstance();
        AuthenticationWindow authenticationWindow = new AuthenticationWindow();
        View view = new View();
        Store store = Store.getInstance();


        Controller controller = new Controller(view, store);
        controller.execute();
        controller.executeAuthenticationWindow(authenticationWindow);
       try {
           //dataBase.initDB();
////          dataBase.createDB();
////            dataBase.addProduct(new Product(444, "хлеб", 20, 100));
////            dataBase.addCashier(new Cashier("Михаил", "1234"));
////            controller.setDataBase(dataBase);
//            //dataBase.updateProduct(444, 160);
//            //dataBase.deleteProduct(450);
//            //dataBase.payment(1,10);
 //           controller.setDataBase(dataBase);
//            dataBase.setProductArrayList(dataBase.getProductList());
//            dataBase.setCashierArrayList(dataBase.getCashierList());
        store.setCashierList(dataBase.getCashierList());
//            System.out.println("Номер чека" + " " + dataBase.getReceiptCount());
//
           dataBase.closeDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        try{
//            dataBase.initDB();
//            //dataBase.create();
//            for (int i = 0; i < 10; i++){
//                dataBase.add("m");
//            }
//            dataBase.closeDB();
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        System.out.println("*************************\n" +
                           "*    ООО Продуктовый    *\n" +
                           "*       г.Ангарск       *\n" +
                           "*************************\n" +
                           "КАССОВЫЙ ЧЕК:         № 1\n" +
                "");
    }
}
