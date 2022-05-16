package program.utility.database;

import program.model.Cashier;
import program.model.Product;

import java.sql.*;
import java.util.ArrayList;
//добавить обработку исключений
public class DataBase {//класс который реализует абстрактный
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resSet;
    public static final String PATH_TO_DB_FILE = "storeDB.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    //private ArrayList<Product> allProductList = new ArrayList<>();
    private static ArrayList<Cashier> allCashierList = new ArrayList<>();

// для 6 лабы
    public static void initDB() throws SQLException{
        connection = DriverManager.getConnection(URL);
        if(connection != null){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
        }
    }

    public static void closeDB() throws SQLException{
        connection.close();
    }
//либо заменить продукт айди либо сделать уникальность
    public static void createDB() throws SQLException, Exception{
        statement = connection.prepareStatement("CREATE TABLE if not exists 'cashiers' " +
                "('cashier_id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'full_name' text, " +
                "'password' text);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'products' "
                + "('product_id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'product_name' text, "
                + "'price' INT, "
                + "'quantity' INT);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'receipts' " +
                "('receipts_id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'cashier_id' INT, " +
                "'product_id' INT, " +
                "'total_price' INT, " +
                "FOREIGN KEY (cashier_id) REFERENCES cashiers(cashier_id), " +
                "FOREIGN KEY (product_id) REFERENCES cashiers(product_id));");
        statement.execute();
        System.out.println("Таблицы создана");
        statement.close();
    }
    //конец для 6 лабы
//задать вопрос как лучше сделать и куда это лучше засунуть
    public static void addProduct(Product product) throws SQLException{//передавать объект и внутри уже разбивать внутри этого метода
        statement = connection.prepareStatement("INSERT INTO 'products'" +
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

    public static void buyProduct(int code, int quantity) throws SQLException {
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
            System.out.println(e.getMessage() + "h");
        }

        return allProductList;
    }

    /*public static void createReceipt(){
        statement = connection.prepareStatement("INSERT INTO 'buyers'('name') VALUES (?);");
        statement.setObject(1, name);
        statement.execute();
        statement.close();
    }*/


}
