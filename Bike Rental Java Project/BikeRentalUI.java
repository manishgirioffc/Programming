import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList ;
/**
 * BIKEUI class contains the graphical user interface of the main 
 * bike company.
 * 
 * @author (Manish Giri) 
 * @version (Sun,23 JULY)
 */
public class BikeRentalUI implements ActionListener
{
    // instance variables
    private JFrame frame;
    private JLabel lblBikeCompany;
    private JButton btnAddBikeToRent;
    private JButton btnAddBikeToSell;
    private JButton btnRentBike;
    private JButton btnSellBike;
    private JButton btnReturn;
    private JButton btnDisplay;
    public static ArrayList<Bike> list = new ArrayList<Bike>();
    /**
     * 
     * Constructor for objects of class BikeUI
     */
    public BikeRentalUI()
    { 
        // initialise instance variables
        makeFrame();
    }
    
    /**
     * makeFrame - This method creates the required labels and buttons
     *             for this class. 
     */
    public void makeFrame()
    {
        frame = new JFrame("Bike Company");
        
        lblBikeCompany = new JLabel("Bike Company");
        frame.add(lblBikeCompany);
        lblBikeCompany.setBounds(150,30,200,30);
        
        btnAddBikeToRent= new JButton("Add Bike To Rent");
        frame.add(btnAddBikeToRent);
        btnAddBikeToRent.setBounds(40,80,150,40);
        btnAddBikeToRent.addActionListener(this);
        
        btnAddBikeToSell= new JButton("Add Bike To Sell");
        frame.add(btnAddBikeToSell);
        btnAddBikeToSell.setBounds(230,80,150,40);
        btnAddBikeToSell.addActionListener(this);
        
        btnRentBike= new JButton("Rent Bike");
        frame.add(btnRentBike);
        btnRentBike.setBounds(40,140,150,40);
        btnRentBike.addActionListener(this);
        
        btnSellBike= new JButton("Sell Bike");
        frame.add(btnSellBike);
        btnSellBike.setBounds(230,140,150,40);
        btnSellBike.addActionListener(this);
        
        btnReturn= new JButton("Return");
        frame.add(btnReturn);
        btnReturn.setBounds(40,200,150,40);
        btnReturn.addActionListener(this);
        
        btnDisplay= new JButton("Display");
        frame.add(btnDisplay);
        btnDisplay.setBounds(230,200,150,40);
        btnDisplay.addActionListener(this);
        
        frame.setLayout(null);
        frame.setSize(450,300);
        frame.setVisible(true);
    }
    
    /**
     * main - This is the main method of the class. 
     */  
    public static void main(String args[])
    {
        new BikeRentalUI();
    }
    
    /**
     * actionPerformed - This method links all the classes with the buttons 
     *                   created on the Graphical User Interface.
     */  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnAddBikeToRent)
        {
            new BikeToRentUI();
        }
        
        if(e.getSource()==btnRentBike)
        {
            new RentBikeUI();
        }
        
        if (e.getSource()==btnSellBike)
        {
            new SellBikeUI();
        }
        
        if(e.getSource()==btnAddBikeToSell)
        {
            new BikeToSellUI();
        }
        
        if(e.getSource()==btnReturn)
        {
            new ReturnRentBikeUI();
        }
        
        if(e.getSource()==btnDisplay)
        {
            display();
        }
    }
    
    public static void addBikeToRent(String bikeDescription, String bikeManufacturer, int dailyRate, Integer bikeID) {
        list.add(new BikeToRent(bikeDescription,bikeManufacturer,dailyRate,bikeID));
            
    } 
    
    public static void addBikeToSell(String bikeDescription,String bikeManufacturer,int price,int taxAmount,Integer bikeID) {
        list.add(new BikeToSell(bikeDescription,bikeManufacturer,price,taxAmount,bikeID));
    
    } 
    
    private void display()
    {
        
            for (int i = 0; i < list.size(); i++) 
             {
                 list.get(i).display();
             }
        
    }

}