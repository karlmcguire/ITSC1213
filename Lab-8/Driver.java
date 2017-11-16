import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("invoicedata.txt"));   
        Invoice[] invoices = new Invoice[10];
        
        String[] tokens = new String[4];
    
        for(int i = 0; input.hasNext(); i++) {
            tokens = input.nextLine().split(",");
            invoices[i] = new Invoice(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Boolean.parseBoolean(tokens[3]));
        }

        for(int i = 0; i < invoices.length; i++) {
            System.out.println("----------------------------");
            System.out.print("(" + i + ")");    
            System.out.println(invoices[i]);
        }

        System.out.println("=============================");
        System.out.println("Comparing first to last: ");
        if(invoices[0].compareTo(invoices[9]) > 0)
            System.out.println("\t" + invoices[0].getAmount() + " > " + invoices[9].getAmount());
        else if(invoices[0].compareTo(invoices[9]) < 0)
            System.out.println("\t" + invoices[0].getAmount() + " < " + invoices[9].getAmount());
        else if(invoices[0].compareTo(invoices[9]) == 0)
            System.out.println("\t" + invoices[0].getAmount() + " == " + invoices[9].getAmount());
    
    
        System.out.println("=============================");
        System.out.println("Second and fifth equal?: ");
        if(invoices[1].equals(invoices[4]))
            System.out.println("\t" + invoices[1].getInvoiceID() + "(2) == " + invoices[4].getInvoiceID() + "(5)");
        else
            System.out.println("\t" + invoices[1].getInvoiceID() + "(2) != " + invoices[4].getInvoiceID() + "(5)");
    }
}
