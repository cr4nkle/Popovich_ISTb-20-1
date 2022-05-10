package program.model;

import java.util.ArrayList;

public class Store {
    //dataRepository сделать полем и вытаскивать от туда данные в списки ниже
    private ArrayList<Product> productList = new ArrayList<>();//список для хранения выбранного товара
    private ArrayList<Cashier> cashierList = new ArrayList<>();
    public void add(){
        this.cashierList.add(new Cashier("Sergey", "c4ca4238a0b92382dcc509a6f75849b"));
    }
    
    public Cashier getCashier(String fullName){
        Cashier cashier = null;
        for (int i = 0; i < cashierList.size(); i++) {
            if(cashierList.get(i).getFullName().equalsIgnoreCase(fullName)){
                cashier = new Cashier(cashierList.get(i));
            }
        }
        return cashier;
    }
}
