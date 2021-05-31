/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GetRateAndTimeSceneFXMLDocumentController implements Initializable {

    private Customer customer;
    @FXML private Pane getRateAndTimeScenePane;
    @FXML private Label senderCountryLabel;
    @FXML private TextField senderCountryTextField;
    @FXML private Label recipientCountryLabel;
    @FXML private TextField recipientCountryTextField;
    @FXML private Button getRateAndTimeQuoteButton;
    @FXML private Text displayRateAndTimeQuoteText;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private void onGetRateAndTimeQuoteButtonClick(MouseEvent event) {
        // loads and reads from rate-and-quote.txt file(this file can be updated by Shipping Port Officer and compares with the sender and recipient country names
        // if the country names are there, then rate and price is shown
        // if not, message is shown that country currently not supported
        String senderCountry = senderCountryTextField.getText();
        String recipientCountry = recipientCountryTextField.getText();
        
        File rateAndQuoteTextFile = null;
        
        Scanner sc; String str; String[] tokens;
        
        try {
            rateAndQuoteTextFile = new File("src/databasefiles/customerfiles/appfiles/rate-and-quote.txt");
            sc = new Scanner(rateAndQuoteTextFile);
            
            if(rateAndQuoteTextFile.exists()) {
                
                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");
                    System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + tokens[3]);
                    String price;
                    String days;
                    if (senderCountry.equals(tokens[0]) && recipientCountry.equals(tokens[1])) {
                        price = tokens[2];
                        days = tokens[3];
                        
                        displayRateAndTimeQuoteText.setText("$" + price + " and " + days + " days.");
                        break;
                    }
                    
                }
                if(!sc.hasNextLine()) {
                    displayRateAndTimeQuoteText.setText("We don't operate in one of these countries yet.");
                }
                
            }
        }
        catch(IOException ex) {
            Logger.getLogger(GetRateAndTimeSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
