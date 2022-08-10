package ex04;

public class IllegalTransactionException extends RuntimeException
{
    public String what()
    {
        return "\033[31mIllegal transaction exception.\033[0m";
    }
    public String toString()
    {
        return this.what();
    }
}
