import java.text.NumberFormat;
import java.util.ArrayList;

public class Invoice
{
    private ArrayList<LineItem> lineItems = new ArrayList<>();

    public Invoice()
    {

    }

    // the get accessor for the line item collection
    public ArrayList<LineItem> getLineItems()
    {
        return lineItems;
    }

    //adds a line item
    public void addItem(LineItem lineItem)
    {
        lineItems.add(lineItem);
    }

    //gets the invoice total
    public double getInvoiceTotal()
    {
        double invoiceTotal = 0;
        for (LineItem lineItem : lineItems)
        {
            invoiceTotal += lineItem.getTotal();
        }
        
        return invoiceTotal;
    }
    
    public String toString()
    {
    	String output= "";
    	
    	for (LineItem line : lineItems)
    	{
    		output += (line + "\n");
    	}
    	return output;
    }

    public String getFormattedTotal()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getInvoiceTotal());
    }
   
}