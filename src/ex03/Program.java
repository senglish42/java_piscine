package ex03;

import java.util.Locale;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[18];
        int num = -1;
        int prev;
        while (true)
        {
            prev = num;
            String[] week = in.nextLine().split(" ");
            if (week[0].equals("42"))
                break ;
            if (!week[0].toLowerCase().equals("week"))
            {
                System.out.print("Please enter a string starting from 'week'\n");
                continue;
            }
            num = Integer.parseInt (week[1]);
            if (num < 1 || num > 18)
                theIllegalArgument(in);
            if (prev != -1 && prev >= num)
                theIllegalArgument(in);
            System.out.print("Input marks: ");
            String fill[] = in.nextLine().split(" ");
            if (fill.length < 5)
                theIllegalArgument(in);
            for (int convert = 0; convert < fill.length; ++convert)
            {
                int mark = Integer.parseInt(fill[convert]);
                if (mark < 1 || mark > 9)
                    theIllegalArgument(in);
                if (convert == 0 || mark < arr[num - 1])
                    arr[num - 1] = Integer.parseInt(fill[convert]);
            }
        }
        for (int count = 0; count < 18; ++count)
        {
            if (arr[count] != 0)
            {
                System.out.printf("Week %d ", count + 1);
                for (int grade = 0; grade < arr[count]; ++grade)
                    System.out.print("=");
                System.out.print(">\n");
            }
        }
    }
    public static void theIllegalArgument(Scanner in)
    {
        in.close();
        System.err.print("IllegalArgument\n");
        System.exit(-1);
    }
}
