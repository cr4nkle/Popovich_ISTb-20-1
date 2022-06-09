package program.model;

public class Cashier {
    private int id;
    private String name;
    private String login;
    private String password;

    public Cashier(int id, String name, String login, String password){
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Cashier(Cashier cashier){
        this.id = cashier.id;
        this.name = cashier.name;
        this.login = cashier.login;
        this.password = cashier.password;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
