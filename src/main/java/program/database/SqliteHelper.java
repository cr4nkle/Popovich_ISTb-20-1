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
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
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

    public int getNumber()  {
        int number = 0;
        try{
            resSet = statement.executeQuery("SELECT MAX(purchase_number) FROM Purchases");
            number = resSet.getInt("MAX(purchase_number)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return number;
    }

    public void payment(int number, int code, int id, int quantity, int discount) throws SQLException {
        statement = connection.prepareStatement("INSERT INTO Purchases (purchase_number, " +
                "product_id, " +
                "cashier_id, " +
                "purchase_quantity, " +
                "discount_value) " +
                "VALUES (?,?,?,?,?);");
        statement.setObject(1, number);
        statement.setObject(2, code);
        statement.setObject(3, id);
        statement.setObject(4, quantity);
        statement.setObject(5, discount);
        statement.execute();
        statement.close();
    }

    public void updateProduct(int code, int quantity) throws SQLException {
        statement = connection.prepareStatement("UPDATE Products SET product_quantity = ? WHERE product_id = ?");
        statement.setObject(1, quantity);
        statement.setObject(2, code);
        statement.executeUpdate();
    }

    public ArrayList<Report> getReportList(int id){
        ArrayList<Report> reportArrayList = new ArrayList<Report>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Reports");
            resSet = statement.executeQuery();
            while (resSet.next()) {
                reportArrayList.add(new Product(resSet.getInt("product_id"),
                        resSet.getString("product_name"),
                        resSet.getInt("product_price"),
                        resSet.getInt("quantity")));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return reportArrayList;

    }

    //Class<?>
    public abstract Product searchProduct(int code) throws Exception;
    public abstract Cashier searchCashierByLogin(String login);
}
