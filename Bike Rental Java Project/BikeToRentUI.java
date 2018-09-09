import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.* ;

/**
 * BikeToRentUI class contains the graphical user interface of rental 
 * page of the bike company
 * 
 * 
 * @author (Manish Giri) 
 * @version (Sun,23 JULY)
 */
public class BikeToRentUI implements ActionListener
{
    // instance variables
    private JFrame frame;
    
    private JLabel lblAddBikeToRent;
    private JLabel lblBikeId;
    private JLabel lblDescription;
    private JLabel lblDailyRate;
    private JLabel lblCompany;
    
    private JTextField txtBikeId;
    private JTextField txtDescription;
    private JTextField txtDailyRate;
    private JTextField txtCompany;
    
    private JButton btnClear;
    private JButton btnConfirm;
    
    private BikeToRent bikeToRent;
    private BikeRentalUI bikeUI;
    /**
     * Constructor for objects of class AddBikeToRentUI
     */
    public BikeToRentUI()
    {
        // initialise instance variables
        BikeToRentWindow();
    }
    
    /**
     * BikeToRentWindow - This method creates the required labels and buttons
     *                    for this class. 
     */
    public void BikeToRentWindow()
    {
        frame = new JFrame("Everest Motors: Add Rent Bike");
        
        lblAddBikeToRent = new JLabel("Add Bike To Rent");
        frame.add(lblAddBikeToRent);
        lblAddBikeToRent.setBounds(250,30,200,30);
        
        lblBikeId = new JLabel("Bike ID");
        frame.add(lblBikeId);
        lblBikeId.setBounds(40,80,150,40);
             
        lblDescription = new JLabel("Description");
        frame.add(lblDescription);
        lblDescription.setBounds(40,140,150,40);
                
        lblDailyRate = new JLabel("Daily Rate");
        frame.add(lblDailyRate);
        lblDailyRate.setBounds(40,200,150,40);
                
        lblCompany = new JLabel("Company");
        frame.add(lblCompany);
        lblCompany.setBounds(290,80,150,40);
 
        txtBikeId = new JTextField("");
        frame.add(txtBikeId);
        txtBikeId.setBounds(115,85,170,30);
        txtBikeId.setEditable(false);
        int a = BikeRentalUI.list.size()+1;
        txtBikeId.setText(Integer.toString(a));
        
        
        txtDescription = new JTextField("");
        frame.add(txtDescription);
        txtDescription.setBounds(115,145,170,30);
        
        txtDailyRate = new JTextField("");
        frame.add(txtDailyRate);
        txtDailyRate.setBounds(115,205,170,30);
        
        txtCompany = new JTextField("");
        frame.add(txtCompany);
        txtCompany.setBounds(360,85,170,30);
        
        btnClear = new JButton("Clear");
        frame.add(btnClear);
        btnClear.setBounds(330,205,110,35);
        btnClear.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        frame.add(btnConfirm);
        btnConfirm.setBounds(450,205,110,35);
        btnConfirm.addActionListener(this); 
        
        frame.setLayout(null);
        frame.setSize(600,300);
        frame.setVisible(true);
    }
    
     /**
     * actionPerformed - This method links all the classes with the buttons 
     *                   created on the Graphical User Interface.
     */  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnConfirm)
        { 
          try
          {
            if(!txtDescription.getText().equals("") && !txtCompany.getText().equals("") && !txtDailyRate.getText().equals(""))
            {
                BikeRentalUI.addBikeToRent(txtDescription.getText(),txtCompany.getText(),Integer.parseInt(txtDailyRate.getText()),Integer.parseInt(txtBikeId.getText()));
                JOptionPane.showMessageDialog(frame,"The bike has been successfully added for rent.");
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
        else if(e.getSource()==btnClear)
        {
            txtDescription.setText("");
            txtDailyRate.setText("");
            txtCompany.setText("");
        }
    }
}

