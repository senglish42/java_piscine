package ex04;

public class TransactionNotFoundException extends RuntimeException
{
    public String what()
    {
        return "\033[31mCurrent Transaction UUID can not be found.\033[0m";
    }
    public String toString()
    {
        return this.what();
    }
}
