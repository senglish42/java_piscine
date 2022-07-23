package edu.school21.printer.logic;

import edu.school21.printer.app.Program;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Logic
{
    public static char[][] make2DArray(String str, char a, char b)
    {
        BufferedImage image = getImage(str);
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
    public static int getWidth(String str)
    {
        return getImage(str).getWidth();
    }
    public static int getHeight(String str)
    {
        return getImage(str).getWidth();
    }
    private static BufferedImage getImage(String str)
    {
        BufferedImage image = null;
        try
        {
            URL url = File.class.getResource(str);
            if (url == null)
                Program.error("Error: File not found.");
            else
                image = ImageIO.read(url);
        }
        catch (IOException e)
        {
            Program.error("Error: File not found.");
        }
        return image;
    }
}
