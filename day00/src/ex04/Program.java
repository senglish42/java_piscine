package ex04;

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int num[] = new int[65535];
        int max = 0;
        int min = 0;
        int size = 0;
        String str;
        str = in.next();
        in.close();
        char ch[] = str.toCharArray();
        for (int count = 0; count < ch.length; ++count)
            ++num[(int) ch[count]];
        for (int count = 0; count < num.length; ++count)
        {
            if (num[count] != 0)
            {
                if (num[count] > 999)
                    theIllegalArgument();
                ++size;
                if (min == 0 || num[count] < min)
                    min = num[count];
                if (num[count] > max)
                    max = num[count];
            }
        }
        int sym[][] = new int[size][12];
        int cnt = 0;
        for (int count = 0; count < num.length; ++count)
        {
            if (num[count] != 0)
            {
                int fill = 0;
                int ratio = (int)(((double)num[count] / max) * 10);
                for(; fill < 10 - ratio; ++fill)
                    sym[cnt][fill] = 32;
                for(; ratio-- > 0; ++fill)
                    sym[cnt][fill] = 35;
                sym[cnt][fill] = count;
                sym[cnt][++fill] = num[count];
                ++cnt;
            }
        }
        int sort[][] = new int[size][12];
        int last = -1;
        int upper = 0;
        for (int loop = 0; loop < size; ++loop)
        {
            for (int count = 0; count < size; ++count)
            {
                if (last != -1)
                {
                    boolean isSort = false;
                    for (int check = 0; check < loop; ++check)
                    {
                        if (sym[count][10] == sort[check][10])
                        {
                            isSort = true;
                            break;
                        }
                    }
                    if (isSort)
                        continue;
                }
                if (sym[count][11] > upper)
                {
                    upper = sym[count][11];
                    last = sym[count][10];
                    for (int fill = 0; fill < 12; ++fill)
                        sort[loop][fill] = sym[count][fill];
                }
                else if (sym[count][11] == upper)
                {
                    if (last != -1 && loop - 1 >= 0 && sort[loop - 1][10] < sym[count][10] && last == sort[loop - 1][10])
                    {
                        last = sym[count][10];
                        for (int fill = 0; fill < 12; ++fill)
                            sort[loop][fill] = sym[count][fill];
                    }
                    else if (sym[count][10] < last)
                    {
                        last = sym[count][10];
                        for (int fill = 0; fill < 12; ++fill)
                            sort[loop][fill] = sym[count][fill];
                    }
                }
                else if (loop > 0 && upper != sort[loop][11])
                {
                    upper = sym[count][11];
                    last = sym[count][10];
                    for (int fill = 0; fill < 12; ++fill)
                        sort[loop][fill] = sym[count][fill];
                }
            }
        }
        for (int count = 0; count < 10; ++count)
        {
            if (sort.length == count)
                break;
            if (sort[count][11] == max)
            {
                if (max >= 0 && max <= 9)
                    System.out.printf("  %d", max);
                else if (max >= 10 && max <= 99)
                    System.out.printf(" %d", max);
                else
                    System.out.printf("%d", max);
            }
            else
                System.out.print("   ");
        }
        System.out.print("\n");
        for (int out = 0; out < 11; ++out)
        {
            for (int count = 0; count < 10; ++count)
            {
                if (sort.length == count)
                    break;
                if (sort[count][out] == 32 && sort[count][out + 1] != 32)
                {
                    if (sort[count][11] >= 0 && sort[count][11] <= 9)
                        System.out.printf("  %d", sort[count][11]);
                    else if (sort[count][11] >= 10 && sort[count][11] <= 99)
                        System.out.printf(" %d", sort[count][11]);
                    else
                        System.out.printf("%d", sort[count][11]);
                }
                else
                    System.out.printf("  %c", (char) sort[count][out]);
            }
            System.out.print("\n");
        }
    }
    public static void theIllegalArgument()
    {
        System.err.print("IllegalArgument\n");
        System.exit(-1);
    }
}
