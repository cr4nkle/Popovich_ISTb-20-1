package program.database;

import program.model.Cashier;
import program.model.Product;

import java.util.ArrayList;
//добавить обработку исключений
public class DataBase extends SqliteHelper{//класс который реализует абстрактный
    private ArrayList<Product> allProductList = new ArrayList<>();
    private ArrayList<Cashier> allCashierList = new ArrayList<>();

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
    public Cashier searchCashier(String name) {
        Cashier cashier = null;
        for (int i = 0; i < allCashierList.size(); i++) {
            if(allCashierList.get(i).getFullName().equalsIgnoreCase(name)){
                cashier = allCashierList.get(i);
            }
        }
        return cashier;
    }

    @Override
    public void setProductArrayList(ArrayList<Product> list) {
        this.allProductList = list;
    }

    @Override
    public void setCashierArrayList(ArrayList<Cashier> list) {
        this.allCashierList = list;
    }

















    /*//конец для 6 лабы
//задать вопрос как лучше сделать и куда это лучше засунуть
    //собственный метод
    public void addProduct(Product product) throws SQLException{//передавать объект и внутри уже разбивать внутри этого метода
        super.statement = super.connection.prepareStatement("INSERT INTO 'products'" +
                "('product_name', " +
                "'price', " +
                "'quantity') "
                + "VALUES (?,?,?);");
        statement.setObject(1, product.getName());
        statement.setObject(2, product.getPrice());
        statement.setObject(3, product.getQuantity());
        statement.execute();
        statement.close();
    }
//не нужно будет
    public static void addCashier(Cashier cashier) throws SQLException{
        statement = connection.prepareStatement("INSERT INTO 'buyers'('name') VALUES (?,?);");
        statement.setObject(1, cashier.getFullName());
        statement.setObject(2, cashier.getPassword());
        statement.execute();
        statement.close();
    }

    public static void deleteProduct(int code) throws SQLException {
        statement = connection.prepareStatement(" DELETE FROM 'products' WHERE 'product_id' = ?;");
        statement.setObject(1, code);
        statement.execute();
        statement.close();
    }

    public void buyProduct(int code, int quantity) throws SQLException {
        statement = connection.prepareStatement(" UPDATE 'products'  SET quantity = ? WHERE 'product_id' = ?;");
        statement.setObject(1, quantity);
        statement.setObject(2, code);
        statement.execute();
        statement.close();
    }

    public ArrayList<Product> getProductList(){
        ArrayList<Product> allProductList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM products");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                allProductList.add(new Product(resSet.getInt("product_id"),
                        resSet.getString("product_name"),
                        resSet.getInt("price"),
                        resSet.getInt("quantity")));
                System.out.println(resSet.getInt("product_id"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allProductList;
    }

    public Product search(int code){
        return allProductList.get(code);
    }
    public static void createReceipt(){
        statement = connection.prepareStatement("INSERT INTO 'buyers'('name') VALUES (?);");
        statement.setObject(1, name);
        statement.execute();
        statement.close();
    }*/


}
