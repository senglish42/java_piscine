package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

public class Program
{
    private static final String IMAGE_PATH = "/resources/image.bmp";
    public static void main(String[] args)
    {
        parseInput(args);
        char a = getChar(args[0]);
        char b = getChar(args[1]);
        char[][] array = Logic.make2DArray(IMAGE_PATH, a, b);
        printOut(array, Logic.getWidth(IMAGE_PATH), Logic.getHeight(IMAGE_PATH));
    }
    static char getChar(String str)
    {
        char c = str.charAt(0);
        if (c < 32 || c > 126)
            error("Argument is invisible.");
        return c;
    }
    static void parseInput(String[] args)
    {
        if (args.length != 2)
            error("Your program should contain 2 arguments.");
        if (args[0].length() != 1 || args[1].length() != 1)
            error("The first and the second arguments size should be one char.");
    }
    public static void error(String msg)
    {
        System.err.println("Error: " + msg);
        System.exit(-1);
    }
    static void printOut(char[][] array, int width, int height)
    {
        for (int countW = 0; countW < width; ++countW)
        {
            for (int countH = 0; countH < height; ++countH)
            {
                System.out.print(array[countH][countW]);
            }
            System.out.println();
        }
    }
}
