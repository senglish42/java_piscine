package ex02;

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (true)
        {
            System.out.print("Input a number: ");
            int num = in.nextInt();
            int sum = addition(num);
            if (ifPrimary(sum))
                count++;
            if (num == 42)
                break ;
        }
        System.out.println(count);
        in.close();
    }
    static int addition(int num) {
        int count = 0;
        for (int div = 0; div < 6; ++div)
        {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
    static boolean ifPrimary(int num)
    {
        int div = 2;
        int sqrt = (int)Math.sqrt(num);
        if (sqrt * sqrt == num)
            return false;
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
                return false;
        }
        return true;
    }
}
