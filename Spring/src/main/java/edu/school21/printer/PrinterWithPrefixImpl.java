package edu.school21.printer;

import edu.school21.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private final Renderer rend;
    private String prefix = "";
    PrinterWithPrefixImpl(Renderer rend) {
        this.rend = rend;
    }
    @Override
    public void print(String str)
    {
        this.rend.getMsg(prefix + str);
    }
    @Override
    public void setPrefix(String str) {
        this.prefix = str + ' ';
    }
}
