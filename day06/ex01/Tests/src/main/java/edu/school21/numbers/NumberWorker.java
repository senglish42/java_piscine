package edu.school21.numbers;

public class NumberWorker
{
    public boolean isPrime(int num) throws IllegalNumberException
    {
        if (num <= 1)
            throw new IllegalNumberException("Number is <= 1.");
        if (num == 2 || num == 3)
            return true;
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
    public int sumDigit(int num)
    {
        int count = 0;
        while (num > 0)
        {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}
