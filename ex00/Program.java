package ex00;

public class Program
{
    public static void main(String[] args) {
    User A = new User("Anya", 1, 250);
    User B = new User("Borya", 2, 100);
    User C = new User("Charlie", 3, 500);
    User D = new User("Donald", 4, 1000);
    Transaction first = new Transaction(A, B, 50);
    outputInfo(A, B, first);
    Transaction second = new Transaction(C, D, 200);
    outputInfo(C, D, second);
    Transaction third = new Transaction(A, C, -300);
    outputInfo(A, C, third);
    Transaction fourth = new Transaction(B, D, -100);
    outputInfo(B, D, fourth);
    }
    static public void outputInfo(User first, User second, Transaction transaction)
    {
        transaction.getInfo();
        first.getInfo();
        second.getInfo();
        System.out.print(".......................................\n");
    }
}
