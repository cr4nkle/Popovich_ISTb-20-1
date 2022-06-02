package program.utility.constant;

public class Constant {
    public static final String RUB = " руб.";
    public static final int DISCOUNT_LIMIT = 50;//сдевится в каждом магазине своё значение
    public static final String PATH_TO_DB_FILE = "storeDB.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    public static final String RECEIPT_HEAD = "*************************\n" +
                                                "*    ООО Продуктовый    *\n" +
                                                "*       г.Ангарск       *\n" +
                                                "*************************\n";
    public static final String RECEIPT = "КАССОВЫЙ ЧЕК № ";
    public static final String CASHIER = "КАССИР: ";
    public static final String PRICE = "ЦЕНА: =";
    public static final String DISCOUNT = "СКИДКА ";
    public static final String TOTAL = "ИТОГ: =";
    public static final String CREDIT = "АВАНС: =";
    public static final String CHANGE = "СДАЧА: =";
    public static final String RECEIPT_END = "*************************\n" +
                                                "*  СПАСИБО ЗА ПОКУПКУ!  *\n" +
                                                "*************************\n";
    public static final String QUANTITY = "шт.";
    public static final String SEPARATOR = "-------------------------";

}
