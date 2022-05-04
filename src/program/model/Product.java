package program.model;

public class Product {
    private int code;
    private String name;
    private int price;
    private int quantity;

    public Product(int code, String name, int price, int quantity){
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
