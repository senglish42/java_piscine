package ex00;

public class Program
{
    public static void main(String[] args) {
        int num = 479598;
        int count = 0;
        count += num % 10;
        num /= 10;
        count += num % 10;
        num /= 10;
        count += num % 10;
        num /= 10;
        count += num % 10;
        num /= 10;
        count += num % 10;
        num /= 10;
        count += num % 10;
//        for (int div = 0; div < 6; ++div)
//        {
//            count += num % 10;
//            num /= 10;
//        }
        System.out.println(count);
    }
}