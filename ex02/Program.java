package ex02;

public class Program
{
    public static void main(String[] args)
    {
        User A = new User("Anya", 100);
        User B = new User("Boris", 200);
        User C = new User("Charlie", 500);
        User D = new User("Donald", 1000);
        User E = new User("Eugene", 2000);
        User F = new User("Frank", 5000);
        UsersList list = new UsersArrayList();
        list.addUser(A);
        list.addUser(B);
        list.addUser(C);
        list.addUser(D);
        list.addUser(E);
        list.addUser(F);
        list.addUser(C);
        System.out.println("Current number of elements in UsersArrayList is: " + list.retrieveNum());
        System.out.println("Current size of UsersArrayList is: " + list.retrieveArrSize());
        list.addUser(new User("Jason", 3000));
        list.addUser(new User("Katherine", 3000));
        list.addUser(new User("Laura", 3000));
        list.addUser(new User("Michael", 3000));
        list.addUser(new User("Negan", 3000));
        System.out.println("Current number of elements in UsersArrayList is: " + list.retrieveNum());
        System.out.println("Current size of UsersArrayList is: " + list.retrieveArrSize());
        list.getInfo();
        try
        {
            System.out.println("User ID #8's name: " + list.retrieveById(8).getName());
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        try
        {
            System.out.println("User ID #12's name: " + list.retrieveById(12).getName());
        }
        catch (UserNotFoundException e)
        {
            System.err.println(e.what());
        }
        try
        {
            System.out.println("The 8th user was added to UsersArrayList name: " + list.retrieveByIndex(8).getName());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("\033[31mArray index is out of bounds.\033[0m");
        }
        try
        {
            System.out.println("The 12th user was added to UsersArrayList name: " + list.retrieveByIndex(12).getName());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("\033[31mArray index is out of bounds.\033[0m");
        }
    }
}
