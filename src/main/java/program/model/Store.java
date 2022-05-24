package program.model;

import program.utility.database.DataBase;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> productList = new ArrayList<>();//список для хранения выбранного товара
    private ArrayList<Cashier> cashierList = new ArrayList<>();
    private int id;

    public Cashier getCashier(String fullName){
        Cashier cashier = null;
        for (int i = 0; i < cashierList.size(); i++) {
            if(cashierList.get(i).getFullName().equalsIgnoreCase(fullName)){
                cashier = new Cashier(cashierList.get(i));
            }
        }
        return cashier;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public int getProductListSize(){
        return this.productList.size();
    }

    public Product getProduct(int index){
        return this.productList.get(index);
    }

    public void deleteAllProduct(){
        this.productList.clear();
    }

    public void deleteProduct(int code){
        for (int i = 0; i < this.productList.size(); i++){
            if (this.productList.get(i).getCode() == code){
                this.productList.remove(i);
            }
        }
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void setCashierList(ArrayList<Cashier> cashierList) {
        this.cashierList = cashierList;
    }

    public void addProduct(Product product){
        product.setQuantity(0);
        this.productList.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
