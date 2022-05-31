package program.database;

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

    public void initDB(){
        try{
            connection = DriverManager.getConnection(Constant.URL);
            if(connection != null){
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getDriverName());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void create() throws SQLException {
        statement = connection.prepareStatement("CREATE TABLE Test (" +
                "id INTEGER NOT NULL, " +
                "t TEXT NOT NULL, " +
                "time TIME DEFAULT (time('now', 'localtime')) NOT NULL, " +
                "PRIMARY KEY(id AUTOINCREMENT)" +
                ");");
        statement.execute();
        statement.close();
    }

    public void add(String t) throws SQLException {
        statement = connection.prepareStatement("INSERT INTO Test (t) VALUES (?)");
        statement.setObject(1, t);
        statement.executeUpdate();
        statement.close();
    }

    public void closeDB() throws SQLException{
        connection.close();
    }

    public ArrayList<Product> getProductList(){
        ArrayList<Product> allProductList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Products");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                allProductList.add(new Product(resSet.getInt("product_id"),
                        resSet.getString("product_name"),
                        resSet.getInt("product_price"),
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
            statement = connection.prepareStatement("SELECT * FROM Cashiers ");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                allCashierList.add(new Cashier(resSet.getInt("cashier_id"),
                        resSet.getString("cashier_name"),
                        resSet.getString("login"),
                        resSet.getString("password")));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allCashierList;
    }

    public void payment(int id, int totalPrice) throws SQLException {//работает исправно
        statement = connection.prepareStatement("INSERT INTO 'receipts'('cashier_id', 'total_price') VALUES (?,?);");
        statement.setObject(1, id);
        statement.setObject(2, totalPrice);
        statement.execute();
        statement.close();
    }

    public  int getReceiptCount() throws SQLException {//работает
        statement = connection.prepareStatement("SELECT COUNT(receipts_id) from 'receipts';");
        resSet = statement.executeQuery();
        return resSet.getInt("COUNT(receipts_id)");
    }

    public void deleteProduct(int id) throws SQLException {
        statement = connection.prepareStatement("DELETE FROM products WHERE product_id = ?");
        statement.setObject(1, id);
        statement.executeUpdate();
//        try (PreparedStatement statement = this.connection.prepareStatement(
//                "DELETE FROM products WHERE product_id = ?")) {
//            statement.setObject(1, id);
//            // Выполняем запрос
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void updateProduct(int id, int quantity) throws SQLException {
        statement = connection.prepareStatement("UPDATE products SET quantity = ? WHERE product_id = ?");
        statement.setObject(1, quantity);
        statement.setObject(2, id);
        statement.executeUpdate();
    }

    //Class<?>
    public abstract Product searchProduct(int code) throws Exception;
    public abstract Cashier searchCashierByLogin(String login);
    public abstract void setProductArrayList(ArrayList<Product> list);
    public abstract void setCashierArrayList(ArrayList<Cashier> list);
}
