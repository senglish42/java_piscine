package edu.school21.program;

import edu.school21.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerErrUpPref", Printer.class);
        printer.setPrefix("hi");
        printer.print ("Hello!") ;
    }
}
