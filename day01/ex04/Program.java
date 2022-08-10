package ex04;

import java.util.UUID;

public class Program
{
    public static void main(String[] args)
    {
        TransactionsService tServ = new TransactionsService();
        User A = new User("Amalia", 500);
        tServ.addUser(A);
        tServ.addUser("Borya", 200);
        tServ.addUser("Charlie", 1000);
        try
        {
            for (int count = 0; count < 5; ++count)
                System.out.println(tServ.getUser(count).getName() + " balance: " + tServ.getBalance(count));
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        try
        {
            tServ.transact(0, 1, 50);
            tServ.transact(1, 2, 100);
            tServ.transact(2, 0, 300);
            tServ.transact(0, 2, -2000);
            tServ.transact(0, 1, 5000);
        }
        catch (IllegalTransactionException e)
        {
            System.err.println(e.what());
        }
        try
        {
            for (int count = 0; count < 5; ++count)
                System.out.println(tServ.getUser(count).getName() + " balance: " + tServ.getBalance(count));
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        try
        {
            Transaction array[];
            for (int count = 0; count < 5; ++count)
            {
                array = tServ.getTransactionArray(count);
                for (int elem = 0; elem < array.length; ++elem)
                {
                    array[elem].getInfo();
                    System.out.println("...........................................");
                }
            }
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("\033[31mThe index of array is out of bounds.\033[0m");
        }
        try
        {
            tServ.removeTransaction(0, tServ.getTransactionArray(tServ.getUser(0))[0].getUUID());
            System.out.println("First transaction of user " + tServ.getUser(0).getName() + " had been removed.");
            tServ.removeTransaction(1, tServ.getTransactionArray(1)[0].getUUID());
            System.out.println("First transaction of user " + tServ.getUser(1).getName() + " had been removed.");
            tServ.removeTransaction(2, UUID.randomUUID());
            tServ.removeTransaction(5, UUID.randomUUID());
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("\033[31mThe index of array is out of bounds.\033[0m");
        }
        catch (TransactionNotFoundException e)
        {
            System.err.println(e.what());
        }
        try
        {
            Transaction array[] = tServ.checkValidity();
            if (array.length < 1)
                System.out.println("Array of unpaied transactions doesn't exist.");
            else {
                System.out.println("..........................................");
                System.out.println("    Array of unpaied transactions info:");
                System.out.println("..........................................");
            }
            for (int count = 0; count < array.length; ++count)
            {
                array[count].getInfo();
                System.out.println("..........................................");
            }
        }
        catch (TransactionNotFoundException e)
        {
            System.err.println(e.what());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("\033[31mThe index of array is out of bounds.\033[0m");
        }
    }
}
