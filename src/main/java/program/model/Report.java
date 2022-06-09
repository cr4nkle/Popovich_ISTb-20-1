package program.model;

public class Report {
    private String cashierName;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;

    public Report(String cashierName, String productName,int price, int quantity, int totalPrice){
        this.cashierName = cashierName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getCashierName() {
        return cashierName;
    }

    public String getProductName() {
        return productName;
    }
}
