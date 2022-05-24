package program.utility;

public class CancelBuffer {
    private int quantity;
    private float totalPrice;

    public CancelBuffer(int quantity, float totalPrice){
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

}
