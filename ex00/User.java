package ex00;

public class User
{
    private String name;
    private int id;
    private int balance;
    User(String name, int id, int balance)
    {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }
    public int getBalance()
    {
        return this.balance;
    }
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public void getInfo()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Balance: " + this.balance);
    }
    public void setBalance(int balance)
    {
        this.balance = balance > 0 ? balance : 0;
    }
    public void cutBalance(int balance)
    {
        int check = this.balance - balance;
        this.balance = check > 0 ? check : 0;
    }
    public void addBalance(int balance)
    {
        this.balance += balance;
    }
}
