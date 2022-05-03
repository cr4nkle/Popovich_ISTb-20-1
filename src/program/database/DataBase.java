package program.database;

import java.sql.*;

public class DataBase {
    private static Connection connection;
    public static PreparedStatement statement;
    public static ResultSet resSet;
    public static final String PATH_TO_DB_FILE = "store.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;

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

    public static void createDB() throws SQLException, Exception{
        statement = connection.prepareStatement("CREATE TABLE if not exists 'buyers' ('buyer_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'products' "
                + "('product_id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'product_name' text, "
                + "'price' INTEGER, "
                + "'expiration_date' date, "
                + "'fats' INT, "
                + "'protein' INT, "
                + "'carbohydrate' INT, "
                + "'extra' INT);");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if not exists 'sell' ('sell_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'buyer_id' INT, 'product_id' INT);");
        statement.execute();
        System.out.println("Таблицы создана");
        statement.close();
    }





}
