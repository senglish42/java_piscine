package ex03;

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Scanner g = new Scanner(System.in);
        int num = -1;
        int prev;
        int count = 0;
        int grade;
        long results = 0;
        int prop = 1;
        while (count != 18)
        {
            prev = num;
            String week = in.nextLine();
            Scanner ch = new Scanner(week);
            String w = ch.next();
            if (w.equals("42"))
                break ;
            if (!w.equals("Week"))
            {
                System.out.print("Please enter a string starting from 'Week'\n");
                continue;
            }
            if (ch.hasNextInt())
                num = ch.nextInt();
            else
                theIllegalArgument(in, g);
            if (ch.hasNextInt())
                theIllegalArgument(in, g);
            ch.close();
            if (num < 1)
                theIllegalArgument(in, g);
            if (prev != -1 && prev >= num)
                theIllegalArgument(in, g);
            grade = find_min(in, g, num);
            if (grade == 0)
                theIllegalArgument(in, g);
            results += grade * prop;
            prop *= 10;
            count++;
        }
        outputResults(results);
        g.close();
        in.close();
    }
    private static int find_min(Scanner in, Scanner g, int week)
    {
        System.out.print("Input marks: ");
        int mark;
        int check = 0;
        int min = 0;
        String grades = g.nextLine();
        Scanner sc = new Scanner(grades);
        if (!sc.hasNextInt())
            theIllegalArgument(in, g);
        while (sc.hasNextInt())
        {
            mark = sc.nextInt();
            if (mark < 1 || mark > 9)
                theIllegalArgument(in, g);
            if (min == 0 || mark < min)
                min = mark;
            check++;
        }
        sc.close();
        if (check != 5)
            theIllegalArgument(in, g);
        return min;
    }
    public static void theIllegalArgument(Scanner in, Scanner g)
    {
        in.close();
        g.close();
        System.err.print("IllegalArgument\n");
        System.exit(-1);
    }

    private static void outputResults(long results)
    {
        int weeks;

        weeks = 0;

        for (long i = results; i > 0; i /= 10) {
            weeks++;
            System.out.print("Week " + weeks + " ");
            for (int n = 0; n < i % 10; ++n) {
                System.out.print('=');
            }
            System.out.println('>');
        }
    }
}
