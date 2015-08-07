import java.text.NumberFormat;

public class LineItem
{
    private Product product;
    private int quantity;
    private double total;

    public LineItem(String code, int quantity)
    {
        product = ProductDB.getProduct(code);
        this.quantity = quantity;
        total = product.getPrice()*quantity;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getTotal()
    {
        return total;
    }

    public void calculateTotal()
    {
        total = quantity * product.getPrice();
    }
    
    public String toString()
    {
    	return product.toString()  + String.format("%10s",quantity) + String.format("%14s",this.getFormattedTotal());
    }

    public String getFormattedTotal()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(total);
    }
}