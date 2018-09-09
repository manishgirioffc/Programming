import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ReturnRentBikeUI class contains the graphical user interface of the bike  selling page of the company
 * 
 * @author (Manish) 
 * @version (7272017)
 */
public class ReturnRentBikeUI implements ActionListener
{
    // instance variables 
    private JFrame frame;
    
    private JLabel lblReturnRentBike;
    private JLabel lblBikeId;
    
    private JTextField txtBikeId;
    
    private JButton btnClear;
    private JButton btnConfirm;
    private BikeToRent bike;

    /**
     * Constructor for objects of class ReturnRentBike
     */
    public ReturnRentBikeUI()
    {
        ReturnRentBikeWindow();
    }
    public void ReturnRentBikeWindow()
    {
        // initialise instance variables
        frame = new JFrame("Everest Motors : Return Rent Bike");
        
        lblReturnRentBike = new JLabel("Return Rent Bike");
        frame.add(lblReturnRentBike);
        lblReturnRentBike.setBounds(180,30,200,30);
        
        lblBikeId = new JLabel("Bike ID");
        frame.add(lblBikeId);
        lblBikeId.setBounds(70,110,150,40);
        
        txtBikeId = new JTextField("");
        frame.add(txtBikeId);
        txtBikeId .setBounds(130,110,210,40);
        
        btnClear = new JButton("Clear");
        frame.add(btnClear);
        btnClear.setBounds(130,170,100,40);
        btnClear.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        frame.add(btnConfirm);
        btnConfirm.setBounds(240,170,100,40);
        btnConfirm.addActionListener(this);
        
        frame.setLayout(null);
        frame.setSize(450,290);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnClear)
        {
            txtBikeId.setText("");
        }
        else if(e.getSource()==btnConfirm)
        {
            if(!txtBikeId.getText().equals(""))
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
                      if(bike.getBikeLoanStatus())
                      {
                       bike.makeBikeAvailable();  
                       bikeRentStatus = true;  
                       JOptionPane.showMessageDialog(frame,"The bike was on rent now its sucessfully freed for you.");
                      }
                      bikeFound = true; 
                      break;
                  }                       
              }
             }
             
               if(bikeFound && !bikeRentStatus)
             {
                 JOptionPane.showMessageDialog(frame,"The bike you searched  is not currently on rent");
             }
             else
             {
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
            else
            {
                 JOptionPane.showMessageDialog(frame,"The field cannot be empty inorder to continue");
            }
        }
    }
}
