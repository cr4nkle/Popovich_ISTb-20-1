package program.model;

import program.utility.database.DataBase;

import java.util.ArrayList;

public class Store {
    //dataRepository сделать полем и вытаскивать от туда данные в списки ниже
    private ArrayList<Product> productList = new ArrayList<>();//список для хранения выбранного товара
    private ArrayList<Cashier> cashierList = new ArrayList<>();

    /*public void add(){
        this.cashierList.add(new Cashier("админ", "админ"));
        this.productList.add(new Product(444,"milk",59,78));
        this.productList.add(new Product(445,"juice",59,70));
        this.productList.add(new Product(446,"bread",50,5));
    }*/
    
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

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

}
