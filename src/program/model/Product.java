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

    public Product(Product product){
        this.code = product.code;
        this.name = product.name;
        this.price = product.price;
        this.quantity = product.quantity;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
