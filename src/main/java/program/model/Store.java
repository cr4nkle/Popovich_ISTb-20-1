package program.model;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> basketList = new ArrayList<>();//список для хранения выбранного товара
    private Cashier cashier;
    private ArrayList<Cashier> cashierList = new ArrayList<>();
    private int id;//убрать

    public Cashier getCashier(String fullName){
        Cashier cashier = null;
        for (int i = 0; i < cashierList.size(); i++) {
            if(cashierList.get(i).getFullName().equalsIgnoreCase(fullName)){
                cashier = new Cashier(cashierList.get(i));
            }
        }
        return cashier;
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

    public void setBasketList(ArrayList<Product> basketList) {
        this.basketList = basketList;
    }

    public void setCashierList(ArrayList<Cashier> cashierList) {
        this.cashierList = cashierList;
    }

    public void addProduct(Product product){
        product.setQuantity(0);
        this.basketList.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
