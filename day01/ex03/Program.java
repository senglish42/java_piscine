package ex03;

public class Program
{
    public static void main(String[] args)
    {
        UsersList list = new UsersArrayList();
        User A = new User("Anya", 100);
        User B = new User("Boris", 200);
        User C = new User("Charlie", 500);
        list.addUser(A);
        list.addUser(B);
        list.addUser(C);
        System.out.println("Current number of elements in UsersArrayList is: " + list.retrieveNum());
        System.out.println("Current size of UsersArrayList is: " + list.retrieveArrSize());
        list.getInfo();
        try
        {
            System.out.println("User ID #1's name: " + list.retrieveById(1).getName());
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        TransactionsList t_list = new TransactionsLinkedList();
        Transaction first = new Transaction(A, B, 30);
        Transaction second = new Transaction(B, C, -50);
        Transaction third = new Transaction(C, A, 100);
        t_list.addTransaction(first);
        t_list.addTransaction(second);
        t_list.addTransaction(third);
        System.out.println("Current size of TransactionLinkedList: " + t_list.getSize());
        System.out.println("First transaction in TransactionLinkedList info: ");
        t_list.getCurrentInfo();
        System.out.println(".................................................");
        System.out.println("Last transaction in TransactionLinkedList info: ");
        t_list.getLastInfo();
        System.out.println(".................................................");
        System.out.println("All transactions in TransactionLinkedList info: ");
        t_list.getListInfo();
        System.out.println(".................................................");
        try
        {
            System.out.println("Trying to remove second transcation from TransactionLinkedList:");
            t_list.removeTransaction(second.getUUID());
            System.out.println("Removal is completed.");
            System.out.println("Current size of TransactionLinkedList: " + t_list.getSize());
        }
        catch (TransactionNotFoundException e)
        {
            e.what();
        }
        try
        {
            System.out.println("Trying to remove second transcation from TransactionLinkedList:");
            t_list.removeTransaction(second.getUUID());
            System.out.println("Removal is completed.");
            System.out.println("Current size of TransactionLinkedList: " + t_list.getSize());
        }
        catch (TransactionNotFoundException e)
        {
            System.out.println(e.what());
        }
        Transaction new_array[] = t_list.toArray();
        for (int count = 0; count < new_array.length; ++count)
        {
            new_array[count].getInfo();
        }
        System.out.println(".................................................");
        A.getTransactions().getListInfo();
        System.out.println(".................................................");
        B.getTransactions().getListInfo();
        System.out.println(".................................................");
        C.getTransactions().getListInfo();
        System.out.println(".................................................");
    }
}
