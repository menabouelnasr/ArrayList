import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Formatter;

public class InvoiceApp
{
   // public static GenericQue<Invoice> invoices
     //   = new GenericQue<>();

    public static Invoice invoice = new Invoice();

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String args[])
    {
        System.out.println("Welcome to the invoice application.\n");
        String anotherItem = "y";
  

	        while (anotherItem.equalsIgnoreCase("y"))
	        {
	            //validates the code
	            String productCode = Validator.getString(keyboard,"Enter product code: ");
	            int quantity = Validator.getInt(keyboard, "Enter quantity:     ", 0, 1000);
	            invoice.addItem(new LineItem(productCode, quantity));
	
	            //validates if the user wants to enter another item
	            anotherItem = Validator.getString(keyboard, "Another line item? (y/n): ");
	            System.out.println();
	        }
	        System.out.println("Code          Description                 Price       Quantity     Total");
			System.out.println("-------------------------------------------------------------------------");
	        System.out.println(invoice);
	        System.out.println(" \n                                                 Invoice Total = "+ invoice.getFormattedTotal());
        
    }

}
