import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * RentBikeUI class contains the graphical user interface of rental 
 * page of the bike company
 * 
 * 
 * @author (Manish Giri) 
 * @version (7232017)
 */
public class RentBikeUI implements ActionListener
{
    // instance variables 
    private JFrame frame;
    
    private JLabel lblRentBike;
    private JLabel lblBikeId;
    private JLabel lblDescription;
    private JLabel lblCustomerName;
    private JLabel lblContact;
    private JLabel lblHireDate;
    private JLabel lblDailyRate;
    private JLabel lblTotalAmount;
    private JLabel lblCompany;
    private JLabel lblEmail;
    private JLabel lblDays;
    
    private JButton btnCheck;
    private JButton btnCalculateRent;
    private JButton btnClear;
    private JButton btnConfirm;
    
    private JTextField txtBikeId;
    private JTextField txtDescription;
    private JTextField txtCustomerName;
    private JTextField txtContact;
    private JTextField txtHireDate;
    private JTextField txtDailyRate;
    private JTextField txtTotalAmount;
    private JTextField txtCompany;
    private JTextField txtEmail;
    private JTextField txtDays;
    
    private BikeToRent bike;    
    /**
     * Constructor for objects of class RentBike
     */
    public RentBikeUI()
    {
        // initialise instance variables
        RentBikeWindow();       
    }

    /**
     * RentBikeWindow - This method creates the required labels and buttons
     *                  sfor this class.  
     */
    public void RentBikeWindow()
    {
        frame = new JFrame("Everest Motors : Rent Bike");
        
        lblRentBike = new JLabel("Rent Bike");
        frame.add(lblRentBike);
        lblRentBike.setBounds(250,30,200,30);
        
        lblBikeId = new JLabel("Bike ID");
        frame.add(lblBikeId);
        lblBikeId.setBounds(40,80,150,40);
        
        lblDescription = new JLabel("Description");
        frame.add(lblDescription);
        lblDescription.setBounds(40,140,150,40);
        
        lblCustomerName = new JLabel("Customer's Name");
        frame.add(lblCustomerName);
        lblCustomerName.setBounds(40,200,150,40);
        
        lblContact = new JLabel("Contact Number");
        frame.add(lblContact);
        lblContact.setBounds(40,260,150,40);
        
        lblHireDate = new JLabel("Hire Date");
        frame.add(lblHireDate);
        lblHireDate.setBounds(40,320,150,40);
        
        lblDailyRate = new JLabel("Daily Rate");
        frame.add(lblDailyRate);
        lblDailyRate.setBounds(40,380,150,40);
        
        lblTotalAmount = new JLabel("Total Amount");
        frame.add(lblTotalAmount);
        lblTotalAmount.setBounds(40,440,150,40);
        
        lblCompany = new JLabel("Company");
        frame.add(lblCompany);
        lblCompany.setBounds(350,80,150,40);
        
        lblEmail = new JLabel("E-mail");
        frame.add(lblEmail);
        lblEmail.setBounds(350,140,150,40);
        
        lblDays = new JLabel("No. of Days");
        frame.add(lblDays);
        lblDays.setBounds(350,200,150,40);
        
        txtBikeId = new JTextField("");
        frame.add(txtBikeId);
        txtBikeId .setBounds(150,85,170,30);
        
        txtDescription = new JTextField("");
        frame.add(txtDescription);
        txtDescription.setBounds(150,145,170,30);
        txtDescription.setEditable(false);
        
        txtCustomerName= new JTextField("");
        frame.add(txtCustomerName);
        txtCustomerName.setBounds(150,205,170,30);
        
        txtContact= new JTextField("");
        frame.add(txtContact);
        txtContact.setBounds(150,265,170,30);
        
        txtHireDate= new JTextField("");
        frame.add(txtHireDate);
        txtHireDate.setBounds(150,325,170,30);
        
        txtDailyRate = new JTextField("");
        frame.add(txtDailyRate);
        txtDailyRate.setBounds(150,385,170,30);
        txtDailyRate.setEditable(false);
        
        txtTotalAmount = new JTextField("");
        frame.add(txtTotalAmount);
        txtTotalAmount.setBounds(150,445,170,30);
        txtTotalAmount.setEditable(false);
        
        txtCompany = new JTextField("");
        frame.add(txtCompany);
        txtCompany.setBounds(420,85,170,30);
        txtCompany.setEditable(false);
         
        txtEmail= new JTextField("");
        frame.add(txtEmail);
        txtEmail.setBounds(420,145,170,30);
        
        txtDays = new JTextField("");
        frame.add(txtDays);
        txtDays.setBounds(420,205,170,30);
               
        btnCheck = new JButton("Check");
        frame.add(btnCheck);
        btnCheck.setBounds(360,390,110,35);
        btnCheck.addActionListener(this);
        
        btnCalculateRent = new JButton("Calculate Rent");
        frame.add(btnCalculateRent);
        btnCalculateRent.setBounds(480,390,110,35);
        btnCalculateRent.addActionListener(this);
        
        btnClear = new JButton("Clear");
        frame.add(btnClear);
        btnClear.setBounds(360,440,110,35);
        btnClear.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        frame.add(btnConfirm);
        btnConfirm.setBounds(480,440,110,35);
        btnConfirm.addActionListener(this);
               
        frame.setLayout(null);
        frame.setSize(650,550);
        frame.setVisible(true);
    }
    
     /**
     * actionPerformed - This method links all the classes with the buttons 
     *                   created on the Graphical User Interface.
     */  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnCheck)
        {
            try
            {
             boolean bikeFound = false;
             boolean bikeRentStatus = false;
             for (int i = 0; i < BikeRentalUI.list.size(); i++) 
             {
              if(BikeToRent.class.isInstance(BikeRentalUI.list.get(i)))
              {                               
                  if(BikeRentalUI.list.get(i).getBikeId() == Integer.parseInt(txtBikeId.getText()))
                  {
                      bike = (BikeToRent) BikeRentalUI.list.get(i);
                      if(!bike.getBikeLoanStatus())
                      {
                      txtCompany.setText(bike.getBikeManufacturer());   
                      txtDescription.setText(bike.getBikeDescription());   
                      txtDailyRate.setText(Integer.toString(bike.getDailyRate()));
                      txtTotalAmount.setText(Integer.toString(bike.getTotalRentalCost())); 
                      bikeRentStatus = true;  
                    }
      
                      bikeFound = true; 
                      break;
                  }                       
              }
             }
             
             if(bikeFound && !bikeRentStatus)
             {
                 JOptionPane.showMessageDialog(frame,"The bike you searched for is not available for rent");
             }
             
             if(!bikeFound)
                {
                   JOptionPane.showMessageDialog(frame,"The bike you searched for is not available");
                }
            }
             catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(frame,"Error Message\nPlease enter a valid number","Error",JOptionPane.ERROR_MESSAGE);
            
            }
        
        }
        else if(e.getSource()==btnClear)
        {
            txtBikeId.setText("");
            txtDescription.setText("");
            txtCustomerName.setText("");
            txtContact.setText("");
            txtHireDate.setText("");
            txtDailyRate.setText("");
            txtTotalAmount.setText("");
            txtCompany.setText("");
            txtEmail.setText("");
            txtDays.setText("");
        }
        else if(e.getSource()==btnCalculateRent)
        {
            try
            {
                if (!txtDailyRate.getText().equals("") && !txtDays.getText().equals(""))
                {
                    int rate = Integer.parseInt(txtDailyRate.getText());
                    int noOfDays = Integer.parseInt(txtDays.getText());
                    txtTotalAmount.setText(Integer.toString(rate*noOfDays));
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"You cannot leave the fields Daily Rate and No Of Days empty to calculate");
                }
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(frame,"Error Message\nPlease enter a valid number","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==btnConfirm)
        {
           try
           {
               if(!txtBikeId.getText().equals("") && !txtCustomerName.getText().equals("") && !txtContact.getText().equals("") && !txtEmail.getText().equals("") && !txtDays.getText().equals("") && !txtHireDate.getText().equals(""))
               {
                  for (int i = 0; i < BikeRentalUI.list.size(); i++) 
                  {
                      if(BikeToRent.class.isInstance(BikeRentalUI.list.get(i)))
                      {         
                            if(BikeRentalUI.list.get(i).getBikeId() == Integer.parseInt(txtBikeId.getText()))
                                {
                                     bike = (BikeToRent) BikeRentalUI.list.get(i);
                                     boolean bikeRentStatus=bike.rentOutBike(txtCustomerName.getText(),txtContact.getText(),txtEmail.getText(),txtHireDate.getText(),Integer.parseInt(txtDays.getText()));
                                     JOptionPane.showMessageDialog(frame,"The bike has been sucessfully rented.");
                                     if(!bikeRentStatus)
                                     {
                                         JOptionPane.showMessageDialog(frame,"The bike was hired on : "+bike.getBikeHireDate()+" for : "+bike.getNumberOfDays()+" days.");
                                     }
                                     break;
                                }
                      }
                    }
               }
               else
               {
                   JOptionPane.showMessageDialog(frame,"You cannot leave the fields empty inorder to continue");
                }
           }
           catch(NumberFormatException nfe)
           {
               JOptionPane.showMessageDialog(frame,"Error Message\nPlease enter a valid number","Error",JOptionPane.ERROR_MESSAGE);
           }
        }
    }
}
