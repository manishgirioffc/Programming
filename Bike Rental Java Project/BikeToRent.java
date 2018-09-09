
/**
 * BikeToRent class provides the mechanism for the process to rent a bike
 * 
 * @author (Manish Giri) 
 * @version (0728201)
 */
public class BikeToRent extends Bike
{
    // instance variables 
    private  String bikeHireDate;
    private  int numberOfDays;
    private  int dailyRate;
    private  int totalRentalCost;
    private  boolean bikeLoanStatus;
    
    /**
     * Constructor for objects of class BikeToRent
     */
    public BikeToRent(String bikeDescription,String bikeManufacturer,int dailyRate, Integer bikeId)
    {
        // initialise instance variables
        super(bikeDescription,bikeManufacturer,bikeId) ;
        this.dailyRate = dailyRate ;
        this.totalRentalCost = 0 ;
        this.numberOfDays = 0 ;
        this.bikeLoanStatus = false ;
        this.bikeHireDate = "";
    }
    
    public String getBikeHireDate()
    {
        return bikeHireDate ;
    }
    
    public int getNumberOfDays()
    {
        return numberOfDays ;
    }
    
    public int getDailyRate()
    {
        return dailyRate ;
    }
    
    public int getTotalRentalCost()
    {
        return totalRentalCost ;
    }
    
    public boolean getBikeLoanStatus()
    {
        return bikeLoanStatus ;
    }
    
    public void setBikeLoanStatus(boolean bikeLoanStatus)
    {
        this.bikeLoanStatus = bikeLoanStatus ;
    }
        
    public boolean rentOutBike(String customerName,String contactNumber,String customerEmail,String ipbikeHireDate,int ipnumberOfDays)
    {
        if(!bikeLoanStatus)
        {
            this.setCustomerName(customerName) ;
            this.setContactNumber(contactNumber) ;
            this.setCustomerEmail(customerEmail) ;
            
            this.bikeHireDate = ipbikeHireDate ;
            this.numberOfDays = ipnumberOfDays ;
            
            this.bikeLoanStatus = true ;
            this.totalRentalCost = dailyRate * numberOfDays ;
            return true;
            
        }
        else
        {
            return false;        
        }
    }
    
    public void makeBikeAvailable()
    {
        if (!bikeLoanStatus){
            System.out.println("Oh! The bike is already available.");
        }
        else{
            setCustomerName("") ;
            setContactNumber("") ;
            setCustomerEmail("") ;
      
            this.numberOfDays = 0 ;
            this.bikeHireDate = "" ;
            bikeLoanStatus = false ;
        }
    }
}
