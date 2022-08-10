package edu.school21.printer;

import edu.school21.renderer.Renderer;
import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private final Renderer rend;
    PrinterWithDateTimeImpl(Renderer rend) {
        this.rend = rend;
    }
    @Override
    public void print(String str) {
        LocalDateTime ldt = LocalDateTime.now();
        this.rend.getMsg(str + ' ' + ldt);
    }
    @Override
    public void setPrefix(String str) {}
}
