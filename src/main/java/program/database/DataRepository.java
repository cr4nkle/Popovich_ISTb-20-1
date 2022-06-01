package program.database;

import program.model.Cashier;
import program.model.Product;
import java.util.ArrayList;

//добавить обработку исключений
public class DataRepository extends SqliteHelper{//класс который реализует абстрактный
    private ArrayList<Product> allProductList = new ArrayList<>();
    private ArrayList<Cashier> allCashierList = new ArrayList<>();
    private static DataRepository INSTANCE;

    private DataRepository(){
        initDB();
        this.allProductList = getProductList();
        this.allCashierList = getCashierList();
    }

    public static synchronized DataRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DataRepository();
        }
        return INSTANCE;
    }

    @Override
    public Product searchProduct(int code) throws Exception {//приравнивает ссылки
        Product product = null;
        for (int i = 0; i < allProductList.size(); i++) {
            if(allProductList.get(i).getCode() == code){
                product = allProductList.get(i);//мб проблема вот тут из за неправильной ссылки
            }
        }
        if (product == null)
            throw new Exception("Вы ввели неверный код!!");
        return product;
    }

    public Product copyProduct(int code) throws Exception {//создаёт новую ссылку на объект
        Product product = null;
        for (int i = 0; i < allProductList.size(); i++) {
            if(allProductList.get(i).getCode() == code){
                product = new Product(allProductList.get(i));//мб проблема вот тут из за неправильной ссылки
            }
        }
        if (product == null)
            throw new Exception("Вы ввели неверный код!!");
        return product;
    }

    @Override
    public Cashier searchCashierByLogin(String login) {
        Cashier cashier = null;
        for (int i = 0; i < allCashierList.size(); i++) {
            if(allCashierList.get(i).getLogin().equals(login)){
                cashier = allCashierList.get(i);
            }
        }
        return cashier;
    }

}
