package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program
{
    public static void main(String[] args) throws IOException
    {
        parseInput(args);
        char a = getChar(args[0]);
        char b = getChar(args[1]);
        Path path = Paths.get(args[2]);
        Path absPath = path.toAbsolutePath();
        char[][] array = Logic.make2DArray(absPath, a, b);
        printOut(array, Logic.getWidth(absPath), Logic.getHeight(absPath));
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
        if (args.length != 3)
            error("Your program should contain 3 arguments.");
        if (args[0].length() != 1 || args[1].length() != 1)
            error("The first and the second arguments size should be one char.");
    }
    static void error(String msg)
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
