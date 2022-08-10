package ex04;

public class User
{
    final private String name;
    final private int id;
    private int balance;
    private TransactionsLinkedList transaction;
    User(String name, int balance)
    {
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
        this.balance = balance;
        this.transaction = new TransactionsLinkedList();
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
    public TransactionsLinkedList getTransaction()   { return this.transaction; }
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
    public TransactionsLinkedList getTransactions()   { return this.transaction; }
}
