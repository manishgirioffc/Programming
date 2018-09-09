import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * SellBikeUI class contains the graphical user interface of the bike  selling page of the company
 * 
 * @author (Manish) 
 * @version (7272017)
 */
public class SellBikeUI implements ActionListener
{
    // instance variables - replcace the example below with your own
    private JFrame frame;
    
    private JLabel lblRentBike;
    private JLabel lblBikeId;
    private JLabel lblDescription;
    private JLabel lblCustomerName;
    private JLabel lblContact;
    private JLabel lblSellDate;
    private JLabel lblPrice;
    private JLabel lblTotalAmount;
    private JLabel lblCompany;
    private JLabel lblEmail;
    private JLabel lblTaxRate;
    
    private JButton btnCheck;
    private JButton btnClear;
    private JButton btnConfirm;
    
    private JTextField txtBikeId;
    private JTextField txtDescription;
    private JTextField txtCustomerName;
    private JTextField txtContact;
    private JTextField txtSellDate;
    private JTextField txtPrice;
    private JTextField txtTotalAmount;
    private JTextField txtCompany;
    private JTextField txtEmail;
    private JTextField txtTaxRate;
    
    private BikeToSell bike;

    /**
     * Constructor for objects of class SellBike
     */
    public SellBikeUI()
    {
        // initialise instance variables
        SellBikeWindow();
    }


    /**
     * SellBikeWindow - This method creates the required labels and buttons
     *                  for this class.  
     */
    public void SellBikeWindow()
    {
        frame = new JFrame("Everest Motors : Sell Bike");
        
        lblRentBike = new JLabel("Sell Bike");
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
        
        lblSellDate = new JLabel("Sell Date");
        frame.add(lblSellDate);
        lblSellDate.setBounds(40,320,150,40);
        
        lblPrice = new JLabel("Price");
        frame.add(lblPrice);
        lblPrice.setBounds(40,380,150,40);
        
        lblTotalAmount = new JLabel("Total Amount");
        frame.add(lblTotalAmount);
        lblTotalAmount.setBounds(40,440,150,40);
        
        lblCompany = new JLabel("Company");
        frame.add(lblCompany);
        lblCompany.setBounds(350,80,150,40);
        
        lblEmail = new JLabel("E-mail");
        frame.add(lblEmail);
        lblEmail.setBounds(350,140,150,40);
        
        lblTaxRate = new JLabel("TaxRate");
        frame.add(lblTaxRate);
        lblTaxRate.setBounds(350,200,150,40);
        
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
        
        txtSellDate= new JTextField("");
        frame.add(txtSellDate);
        txtSellDate.setBounds(150,325,170,30);
        
        txtPrice = new JTextField("");
        frame.add(txtPrice);
        txtPrice.setBounds(150,385,170,30);
        txtPrice.setEditable(false);
        
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
        
        txtTaxRate = new JTextField("");
        frame.add(txtTaxRate);
        txtTaxRate.setBounds(420,205,170,30);
        txtTaxRate.setEditable(false);
        
        btnCheck = new JButton("Check");
        frame.add(btnCheck);
        btnCheck.setBounds(360,445,120,35);
        btnCheck.addActionListener(this);
               
        btnClear = new JButton("Clear");
        frame.add(btnClear);
        btnClear.setBounds(360,490,120,35);
        btnClear.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        frame.add(btnConfirm);
        btnConfirm.setBounds(490,490,120,35);
        btnConfirm.addActionListener(this);
        
        frame.setLayout(null);
        frame.setSize(650,600);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnCheck)
        {  
            try
            {
                boolean bikeFound = false;
                boolean bikeAvailableStatus = false;
                for (int i = 0; i < BikeRentalUI.list.size(); i++) 
                {
                    if(BikeToSell.class.isInstance(BikeRentalUI.list.get(i)))
                    {                               
                        if(BikeRentalUI.list.get(i).getBikeId() == Integer.parseInt(txtBikeId.getText()))
                        {
                           bike = (BikeToSell) BikeRentalUI.list.get(i);
                           if(!bike.getSellingStatus())
                           {
                            txtCompany.setText(bike.getBikeManufacturer());   
                            txtDescription.setText(bike.getBikeDescription());   
                            txtPrice.setText(Integer.toString(bike.getPrice()));
                            txtTaxRate.setText(Integer.toString(bike.getTaxAmount()));
                            txtTotalAmount.setText(Integer.toString(bike.getPrice()+bike.getTaxAmount()));
                            bikeAvailableStatus = true;
                           }
                            bikeFound = true; 
                            break;
                        }                       
                    }
                   
                }
                
                 if(bikeFound && !bikeAvailableStatus)
                 {
                 JOptionPane.showMessageDialog(frame,"The bike you searched for is not available for sale");

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
            txtSellDate.setText("");
            txtPrice.setText("");
            txtTotalAmount.setText("");
            txtCompany.setText("");
            txtEmail.setText("");
            txtTaxRate.setText("");
        }
        else if(e.getSource()==btnConfirm)
        {
            try
           {
               if(!txtBikeId.getText().equals("") && !txtCustomerName.getText().equals("") && !txtContact.getText().equals("") && !txtEmail.getText().equals("") && !txtSellDate.getText().equals(""))
               {
                  for (int i = 0; i < BikeRentalUI.list.size(); i++) 
                  {
                      if(BikeToSell.class.isInstance(BikeRentalUI.list.get(i)))
                      {         
                            if(BikeRentalUI.list.get(i).getBikeId() == Integer.parseInt(txtBikeId.getText()))
                                {
                                     bike = (BikeToSell) BikeRentalUI.list.get(i);
                                     boolean bikeSellStatus=bike.bikeSellOut(txtCustomerName.getText(),txtContact.getText(),txtEmail.getText(),txtSellDate.getText());
                                     if(!bikeSellStatus)
                                     {
                                         JOptionPane.showMessageDialog(frame,"The bike was sold on : "+bike.getSellingDate());
                                     }else {
                                        
                                        JOptionPane.showMessageDialog(frame,"The bike has been sucessfully sold.");
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
