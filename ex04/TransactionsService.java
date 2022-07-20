package ex04;

import java.util.UUID;

public class TransactionsService
{
    private UsersList uList;
    private TransactionsList tList;
    public TransactionsService()
    {
        this.uList = new UsersArrayList();
        this.tList = new TransactionsLinkedList();
    }
    public void addUser(User newUser)
    {
        this.uList.addUser(newUser);
    }
    public void addUser(String name, int balance)
    {
        User newUser = new User(name, balance);
        this.uList.addUser(newUser);
    }

    public User getUser(int id) throws UserNotFoundException
    {
        return this.uList.retrieveById(id);
    }

    public int getBalance(int id) throws UserNotFoundException
    {
        return this.uList.retrieveById(id).getBalance();
    }
    public void transact(int id1, int id2, int amount) throws IllegalTransactionException
    {
        if (uList.retrieveById(id1).getBalance() < amount || amount < 0)
            throw new IllegalTransactionException();
        this.tList.addTransaction(new Transaction(this.uList.retrieveById(id1), this.uList.retrieveById(id2), amount));
    }
    Transaction[] getTransactionArray(int id) throws UserNotFoundException
    {
        return uList.retrieveById(id).getTransactions().toArray();
    }
    Transaction[] getTransactionArray(User user)
    {
        return user.getTransactions().toArray();
    }
    void removeTransaction(int u_id, UUID t_id) throws UserNotFoundException, TransactionNotFoundException
    {
        uList.retrieveById(u_id).getTransactions().removeTransaction(t_id);
    }
    public Transaction[] checkValidity() throws TransactionNotFoundException
    {
        TransactionsLinkedList  unpaired = new TransactionsLinkedList();
        Transaction[]           array = tList.toArray();

        for (int i = 0; i < array.length; ++i) {
            if (array[i].getSender().getTransactions().checkTransaction(array[i].getUUID()) == null
                    || array[i].getRecipient().getTransactions().checkTransaction(array[i].getUUID()) == null)
                unpaired.addTransaction(array[i]);
        }
        return unpaired.toArray();
    }
}
