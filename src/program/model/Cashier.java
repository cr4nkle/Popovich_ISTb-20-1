package program.model;

public class Cashier {
    private String fullName;
    private String password;

    public Cashier(String fullName, String password){
        this.fullName = fullName;
        this.password = password;
    }

    public Cashier(Cashier cashier){
        this.fullName = cashier.fullName;
        this.password = cashier.password;
    }

    public String getFullName(){
        return this.fullName;
    }

    public String getPassword() {
        return this.password;
    }
}
