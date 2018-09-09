import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * BikeToSellUI class contains the graphical user interface of rental 
 * page of the bike company
 * 
 * 
 * @author (Manish Giri) 
 * @version (Sun,24 JULY)
 */
public class BikeToSellUI implements ActionListener
{
    // instance variables 
    private JFrame frame;
    private JLabel lblAddBikeToSell;
    private JLabel lblBikeId;
    private JLabel lblDescription;
    private JLabel lblPrice;
    private JLabel lblTaxRate;
    private JLabel lblCompany;
 
    private JButton btnClear;
    private JButton btnConfirm;
    
    private JTextField txtBikeId;
    private JTextField txtDescription;
    private JTextField txtPrice;
    private JTextField txtTaxRate;
    private JTextField txtCompany;


    /**
     * Constructor for objects of class AddBikeToSellUI
     */
    public BikeToSellUI() 
    {
        // initialise instance variables
       AddBikeToSellWindow();
    }

    /**
     * RentBikeWindow - This method creates the required labels and buttons
     *                  sfor this class.  
     */
    public void AddBikeToSellWindow()
    {
        // put your code here
        frame = new JFrame("Everest Motors : Add Bike To Sell");
        
        lblAddBikeToSell = new JLabel("Add Bike To Sell");
        frame.add(lblAddBikeToSell);
        lblAddBikeToSell.setBounds(250,30,200,30);
        
        lblBikeId = new JLabel("Bike ID");
        frame.add(lblBikeId);
        lblBikeId.setBounds(40,80,150,40);
        
        lblDescription = new JLabel("Description");
        frame.add(lblDescription);
        lblDescription.setBounds(40,140,150,40);
        
        lblPrice = new JLabel("Price");
        frame.add(lblPrice);
        lblPrice.setBounds(40,200,150,40);
        
        lblTaxRate = new JLabel("TaxRate");
        frame.add(lblTaxRate);
        lblTaxRate.setBounds(40,260,150,40);
        
        lblCompany = new JLabel("Company");
        frame.add(lblCompany);
        lblCompany.setBounds(350,80,150,40);
        
        txtBikeId = new JTextField("");
        frame.add(txtBikeId);
        txtBikeId.setBounds(150,85,170,30);
        txtBikeId.setEditable(false);
        int a = BikeRentalUI.list.size()+1;
        txtBikeId.setText(Integer.toString(a));
        
        txtDescription = new JTextField("");
        frame.add(txtDescription);
        txtDescription.setBounds(150,145,170,30);
        
        txtPrice= new JTextField("");
        frame.add(txtPrice);
        txtPrice.setBounds(150,205,170,30);
        
        txtTaxRate= new JTextField("");
        frame.add(txtTaxRate);
        txtTaxRate.setBounds(150,265,170,30);
        
        txtCompany = new JTextField("");
        frame.add(txtCompany);
        txtCompany.setBounds(420,85,170,30);
        
        btnClear = new JButton("Clear");
        frame.add(btnClear);
        btnClear.setBounds(360,265,110,35);
        btnClear.addActionListener(this);
        
        btnConfirm = new JButton("Confirm");
        frame.add(btnConfirm);
        btnConfirm.setBounds(480,265,110,35);
        btnConfirm.addActionListener(this); 
        
        frame.setLayout(null);
        frame.setSize(650,380);
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
               if(!txtDescription.getText().equals("") && !txtCompany.getText().equals("") && !txtPrice.getText().equals("") && !txtTaxRate.getText().equals("") && !txtBikeId.getText().equals(""))
               {     
                   BikeRentalUI.addBikeToSell(txtDescription.getText(),txtCompany.getText(),Integer.parseInt(txtPrice.getText()),Integer.parseInt(txtTaxRate.getText()),Integer.parseInt(txtBikeId.getText()));
                   JOptionPane.showMessageDialog(frame,"The bike has been succesfully added for sale"); 
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"You cannot leave the fields empty to continue");
                }
           }
           catch(NumberFormatException nfe)
           {
               JOptionPane.showMessageDialog(frame,"Error Message\nPlease enter a valid number","Error",JOptionPane.ERROR_MESSAGE);
           }
           
        }
        else if(e.getSource() == btnClear)
        {
            txtDescription.setText("");
            txtPrice.setText("");
            txtTaxRate.setText("");
            txtCompany.setText("");
        }
    }
}
