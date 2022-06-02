package program.model;

public class Report {
    private String cashierName;
    private String productName;
    private int price;
    private int quantity;
    private int discount;
    private int totalPrice;

    public Report(String cashierName, String productName,int price, int quantity, int discount, int totalPrice){
        this.cashierName = cashierName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

}
