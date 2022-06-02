package program.database;

import program.model.*;
import program.utility.constant.Constant;

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


    public void closeDB(){
        try {
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

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
        int temp = 0;
        try{
            statement = connection.prepareStatement("SELECT seq FROM sqlite_sequence WHERE name=?");
            statement.setObject(1,"Purchases");
            resSet = statement.executeQuery();
            temp = resSet.getInt("seq");
            statement = connection.prepareStatement("SELECT purchase_number FROM Purchases WHERE purchase_id=?");
            statement.setObject(1, temp);
            resSet = statement.executeQuery();
            number = resSet.getInt("purchase_number");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return number;
    }

    public void payment(int number, int code, int id, int quantity, int discount){
        try {
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
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(int code, int quantity){
        try {
            statement = connection.prepareStatement("UPDATE Products SET quantity = ? WHERE product_id = ?");
            statement.setObject(1, quantity);
            statement.setObject(2, code);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Report> getReportList(int id){
        ArrayList<Report> reportArrayList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Reports WHERE cashier_id = ?");
            statement.setObject(1, id);
            resSet = statement.executeQuery();
            while (resSet.next()) {
                reportArrayList.add(new Report(resSet.getString("cashier_name"),
                        resSet.getString("product_name"),
                        resSet.getInt("price"),
                        resSet.getInt("quantity"),
                        resSet.getInt("discount_value"),
                        resSet.getInt("total_price")));
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
