
/**
 * Bike class mainly deals with the bike description, manufacturer,
 * customer's name ,number and their email addresses.
 * 
 * @author (Manish Giri) 
 * @version (Sun,23 JULY)
 */
public class Bike
{
    // instance variables - replace the example below with your own
    private String bikeDescription;
    private String bikeManufacturer;
    private String customerName;
    private String contactNumber;
    private String customerEmail;
    private Integer bikeID;

    /**
     * Constructor for objects of class Bike
     */
    public Bike(String bikeDescription,String bikeManufacturer,Integer bikeID)
    {
        // initialise instance variables
        this.bikeDescription = bikeDescription ;
        this.bikeManufacturer = bikeManufacturer ;
        this.bikeID = bikeID;
        customerName ="";
        contactNumber ="";
        customerEmail ="";
    }
    
    /**
     * setCustomerName - This method sets the customer name.
     * 
     * @param  customerName   Name of the customer
     * @return  
     */
    public void setCustomerName(String CustomerName)
    {
      this.customerName = CustomerName;
    }
    
     /**
     * setContactNumber - This method sets the contact number of customers.
     * 
     * @param  contactNumber   Customer's Contact Number
     */
    public  void setContactNumber(String ContactNumber)
    {
      this.contactNumber = ContactNumber;
    }
    
     /**
     * setCustomerEmail - This method sets the email of customers.
     * 
     * @param  customerEmail   Customer's Email
     */
    public void setCustomerEmail(String customerEmail)
    {
      this.customerEmail = customerEmail;
    }
    
    /**
     * getBikeDescription - This method provides the description of bikes.
     * 
     * @return  bikeDescription   String
     */
    public String getBikeDescription()
    {
      return bikeDescription ;
    }
    
    /**
     * getBikeManufacturer - This method provides the name of bike manufacturers.
     * 
     * @return  bikeManufacturer   String
     */
    public String getBikeManufacturer()
    {
      return bikeManufacturer ;
    }
    
    /**
     * getCustomerName - This method provides the name of customers.
     * 
     * @return  customerName   String
     */
    public String getCustomerName()
    {
      return customerName ;
    }
    
     /**
     * getBikeId - This method provides theBikeID.
     * 
     * @return  getBikeId   int
     */
    public Integer getBikeId()
    {
      return bikeID;
    }
    
    
    /**
     * getContactNumber - This method provides the contact numbers of customers.
     * 
     * @return  contactNumber   String
     */
    public String getContactNumber()
    {
      return contactNumber ;
    }
    
    /**
     * getCustomerEmail - This method provides the email's of customers.
     * 
     * @return  customerEmail   String
     */
    public String getCustomerEmail()
    {
      return customerEmail ;
    }
    
    /**
     * display - This method displays the details of the customers and the bikes.
     */
    public void display()
    {
      String nullString = null ;
      String empty = new String();
      System.out.println("Description :"+ bikeDescription);
      System.out.println("Manufacturer :"+ bikeManufacturer);
      

      if(!customerName.equals(""))
      {
          System.out.println("Customer's Name :"+ customerName);
        }
   
      if(!contactNumber.equals(""))
      {
          System.out.println("Customer's Contact Number :"+ contactNumber);
        }
        
      if (!customerEmail.equals(""))
      {
          System.out.println("Customer's Email :"+ customerEmail);
        }  
      
    }
    
}
