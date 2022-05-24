package program.model;

import program.utility.encryption.Encrypt;

public class Cashier {
    public int id;
    private String fullName;
    private String password;

    public Cashier(int id, String fullName, String password){// для бд
        this.id = id;
        this.fullName = fullName;
        this.password = password;//сразу шифрует может быть лишним
    }

    public Cashier(String fullName, String password){
        this.fullName = fullName;
        this.password = password;//сразу шифрует может быть лишним
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

    public int getId() {
        return id;
    }
}
