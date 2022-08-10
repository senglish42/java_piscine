package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Logic
{
    public static char[][] make2DArray(Path absPath, char a, char b) throws IOException
    {
        BufferedImage image = getImage(absPath);
        int w = image.getWidth();
        int h = image.getHeight();
        char[][] array = new char[w][h];
        for (int countX = 0; countX < w; ++countX)
        {
            for (int countY = 0; countY < h; ++countY)
            {
                int color = image.getRGB(countX, countY);
                if (color == Color.BLACK.getRGB())
                    array[countX][countY] = a;
                else if (color == Color.WHITE.getRGB())
                    array[countX][countY] = b;
                else
                    array[countX][countY] = 32;
            }
        }
        return array;
    }
    public static int getWidth(Path absPath)
    {
        return getImage(absPath).getWidth();
    }
    public static int getHeight(Path absPath)
    {
        return getImage(absPath).getWidth();
    }
    private static BufferedImage getImage(Path absPath)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new FileInputStream(absPath.toString()));
        }
        catch (IOException e)
        {
            System.err.println("Error: File not found.");
            System.exit(-1);
        }
        return image;
    }
}
