package program.utility.database;

import program.model.Cashier;
import program.model.Product;
import program.utility.constant.Constant;
import program.utility.encryption.Encrypt;

import java.sql.*;
import java.util.ArrayList;

public abstract class SqliteHelper {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resSet;

    public void initDB() throws SQLException{
        connection = DriverManager.getConnection(Constant.URL);
        if(connection != null){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
        }
    }

    public void closeDB() throws SQLException{
        connection.close();
    }
    //либо заменить продукт айди либо сделать уникальность
    public void createDB() throws SQLException, Exception{
        statement = connection.prepareStatement("CREATE TABLE if not exists 'cashiers' " +
                "('cashier_id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'full_name' text, " +
                "'password' text);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'products' "
                + "('product_id' INTEGER PRIMARY KEY UNIQUE CHECK('product_id' >0), "
                + "'product_name' text, "
                + "'price' INT, "
                + "'quantity' INT);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'receipts' " +
                "('receipts_id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'cashier_id' INT NULL , " +
                "'total_price' INT, " +
                "FOREIGN KEY (cashier_id) REFERENCES cashiers(cashier_id));");
        statement.execute();
        statement.close();
    }

    public void updateProduct(int code, int quantity) throws SQLException {//не работает
        statement = connection.prepareStatement("INSERT INTO 'products_id' ('quantity') VALUES (?) WHERE 'products_id' = code");
        statement.setObject(1, quantity);
        statement.setObject(2, code);
//        statement = connection.prepareStatement(" UPDATE 'products'  SET 'quantity' = ? WHERE 'product_id' = ?;");
//        statement.setObject(1, quantity);
//        statement.setObject(2, code);
//        statement.executeUpdate();
//        statement.close();
    }

    public ArrayList<Product> getProductList(){//подумать как сделать более универсально
        ArrayList<Product> allProductList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM products");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                allProductList.add(new Product(resSet.getInt("product_id"),
                        resSet.getString("product_name"),
                        resSet.getInt("price"),
                        resSet.getInt("quantity")));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allProductList;
    }

    public ArrayList<Cashier> getCashierList(){
        ArrayList<Cashier> allCashierList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM cashiers");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                allCashierList.add(new Cashier(resSet.getInt("cashier_id"),
                        resSet.getString("full_name"),
                        resSet.getString("password")));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allCashierList;
    }

    public void addProduct(Product product) throws SQLException{
        statement = connection.prepareStatement("INSERT INTO 'products' " +
                "('product_id', " +
                "'product_name', " +
                "'price', " +
                "'quantity') "
                + "VALUES (?,?,?,?);");
        statement.setObject(1, product.getCode());
        statement.setObject(2, product.getName());
        statement.setObject(3, product.getPrice());
        statement.setObject(4, product.getQuantity());
        statement.execute();
        statement.close();
    }

    public void addCashier(Cashier cashier) throws SQLException{
        statement = connection.prepareStatement("INSERT INTO 'cashiers'('full_name', 'password') VALUES (?,?);");
        statement.setObject(1, cashier.getFullName());
        statement.setObject(2, Encrypt.encrypt(cashier.getPassword()));
        statement.execute();
        statement.close();
    }

//    public void payment(int id, int totalPrice) throws SQLException {
//        statement = connection.prepareStatement("INSERT INTO 'receipts'('cashier_id', 'total_price') VALUES (?,?);");
//        statement.setObject(1, id);
//        statement.setObject(2, totalPrice);
//        statement.execute();
//        statement.close();
//    }

    public int getCashierID(String full_name) throws SQLException {//выдаёт ошибку resultset closed
        statement = connection.prepareStatement("SELECT 'cashier_id' FROM 'cashiers' WHERE 'full_name' = ?;");
        statement.setObject(1, full_name);
        resSet = statement.executeQuery();
        return resSet.getInt("cashier_id");
    }

    public  int getReceiptCount() throws SQLException {//работает
        statement = connection.prepareStatement("SELECT COUNT(receipts_id) from 'receipts';");
        resSet = statement.executeQuery();
        return resSet.getInt("COUNT(receipts_id)");
    }

    //Class<?>
    public abstract Product searchProduct(int code) throws Exception;
    public abstract Cashier searchCashier(String name);
    public abstract void setProductArrayList(ArrayList<Product> list);
    public abstract void setCashierArrayList(ArrayList<Cashier> list);
}
