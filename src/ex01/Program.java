package ex01;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        in.close();
        if (num < 1)
            theIllegalArgument();
        int count = 1;
        int div = 2;
        int sqrt = (int)Math.sqrt(num);
        if (sqrt * sqrt == num)
            printFalse(count);
        for (; div <= sqrt; div++)
        {
            int new_div = 2;
            while (new_div != div)
            {
                if (div % new_div == 0)
                    break;
                new_div++;
            }
            if (new_div != div)
                continue ;
            if (num % div == 0)
                printFalse(count);
            ++count;
        }
        printTrue(count);
    }
    public static void theIllegalArgument()
    {
        System.err.print("IllegalArgument\n");
        System.exit(-1);
    }
    public static void printFalse(int count)
    {
        System.out.print("false ");
        System.out.println(count);
        System.exit(0);
    }
    public static void printTrue(int count)
    {
        System.out.println("true ");
        System.out.println(count);
        System.exit(0);
    }
}