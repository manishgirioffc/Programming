
/**
 * Bike to sell class provides the mechanism for selling a bike
 * 
 * @author (Manish Giri) 
 * @version (7272017)
 */
public class BikeToSell extends Bike
{
    // instance variables - replace the example below with your own
    private int price;
    private int taxAmount;
    private int totalAmount;
    private String sellingDate;
    private boolean sellingStatus;
    
    /**
     * Constructor for objects of class BikeToSell
     */
    public BikeToSell(String bikeDescription,String bikeManufacturer,int price,int taxAmount, Integer BikeId)
    {
            // initialise instance variables
        super(bikeDescription,bikeManufacturer,BikeId);
        this.price = price;
        this.taxAmount = taxAmount;
        sellingStatus= false;
        sellingDate ="";
    }

    /**
     * getPrice - This method return the value of price
     * 
     * @return   int  price 
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * getTaxAmount - This method return the value of taxAmount
     * 
     * @return   int  taxAmount 
     */
    public int getTaxAmount()
    {
        return taxAmount;
    }
    
    /**
     * getTotaAmount - This method return the value of totalAmount
     * 
     * @return   int  totalAmount 
     */
    public int getTotalAmount()
    {
        return totalAmount;
    }
    
    /**
     * getSellingDate - This method return the value of sellingDate
     * 
     * @return   String  sellingDate 
     */
    public String getSellingDate()
    {
        return sellingDate;
    }
    
    /**
     * getSellingStatus - This method return the value of sellingDate
     * 
     * @return   boolean  sellingStatus 
     */
    public boolean getSellingStatus()
    {
        return sellingStatus;
    }
    
    public boolean bikeSellOut(String customerName,String contactNumber, String customerEmail,String ipsellingDate)
    {
        if(!sellingStatus)
        {
            this.setCustomerName(customerName) ;
            this.setContactNumber(contactNumber) ;
            this.setCustomerEmail(customerEmail) ;
            
            this.totalAmount = price+taxAmount ;
            this.sellingStatus = true ;
            this.sellingDate = ipsellingDate;
            return true;
        }
        else
        {
            System.out.println("Sorry! The bike is already sold.");
            System.out.println("The bike was sold on: "+sellingDate);
            return false;
        }
    }
}
