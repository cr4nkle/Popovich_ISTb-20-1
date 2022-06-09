package program.model;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> basketList = new ArrayList<>();//список для хранения выбранного товара
    private Cashier cashier;
    private static Store INSTANCE;

    private Store(){

    }

    public static synchronized Store getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Store();
        }
        return INSTANCE;
    }

    public ArrayList<Product> getBasketList() {
        return basketList;
    }

    public int getProductListSize(){
        return this.basketList.size();
    }

    public Product getProduct(int index){
        return this.basketList.get(index);
    }

    public void deleteAllProduct(){
        this.basketList.clear();
    }

    public void deleteProduct(int code){
        for (int i = 0; i < this.basketList.size(); i++){
            if (this.basketList.get(i).getCode() == code){
                this.basketList.remove(i);
            }
        }
    }

    public int getCashierID(){
        return this.cashier.getId();
    }

    public void addProduct(Product product){
        product.setQuantity(0);
        this.basketList.add(product);
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
}
