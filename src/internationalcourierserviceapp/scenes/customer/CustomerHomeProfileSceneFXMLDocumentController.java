/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import assets.Address;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CustomerHomeProfileSceneFXMLDocumentController implements Initializable {
    
    private Customer customer;
    @FXML private Label customerNameLabel;
    @FXML private Label customerEmailLabel;
    @FXML private Label customerPhoneNumberLabel;
    @FXML private Label customerAddressLabel;
    @FXML private Text customerEmailPlaceholderText;
    @FXML private Text customerNamePlaceholderText;
    @FXML private Text customerIdPlaceholderText;
    @FXML private Label customerIdLabel;
    @FXML private GridPane customerProfileSceneGridPane;
    @FXML private Button savePhoneNumberButton;
    @FXML private TextField phoneNumberTextField;
    @FXML private Button saveAddressButton;
    @FXML private TextField countryNameTextField;
    @FXML private TextField cityOrTownTextField;
    @FXML private TextField districtOrStateTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private TextField postalCodeTextField;
    @FXML private TextField passportIdTextField;
    @FXML private Button savePassportIdButton;
    @FXML private Text placeholderText;
    @FXML private Label countryLabel;
    @FXML private Label cityLabel;
    @FXML private Label districtLabel;
    @FXML private Label streetAddressLabel;
    @FXML private Label postalCodeLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void initializeCustomerData() {
        customerIdPlaceholderText.setText(Integer.toString(customer.getId()));
        customerNamePlaceholderText.setText(customer.getName());
        customerEmailPlaceholderText.setText(customer.getEmailAddress());
        
        // check if customer has phonenumber, passportId, and address stored by loading
        // each file and seeing it the data exists.
        // if they do, remove the textfields and replace them with text that shows the respective
        // customer data
        File phoneNumbersFile = null;
        File passportIDFile = null;
        File addressesFile = null;
        
        Scanner sc; String str = null;
        String[] tokens;
        
        try {
            phoneNumbersFile = new File("src/databasefiles/customerfiles/customer-phonenumber.txt");
            sc = new Scanner(phoneNumbersFile);
            
            if(phoneNumbersFile.exists()) {
                while(sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");
                    
                    if(Integer.toString(customer.getId()).equals(tokens[0])) {
                        customerProfileSceneGridPane.getChildren().remove(phoneNumberTextField);
                        customerProfileSceneGridPane.getChildren().remove(savePhoneNumberButton);
                        customer.setPhoneNumber(tokens[1]);
                        Text customerPhoneNumberText = new Text();
                        customerPhoneNumberText.setText(customer.getPhoneNumber());
                        customerProfileSceneGridPane.add(customerPhoneNumberText, 1, 3);
                    }
                }
            }
        }
        catch(IOException ex) {
            
        }
        
        try {
            passportIDFile = new File("src/databasefiles/customerfiles/customer-passportinfo.txt");
            sc = new Scanner(passportIDFile);
            
            if(passportIDFile.exists()) {
                while(sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");
                    
                    if(Integer.toString(customer.getId()).equals(tokens[0])) {
                        customerProfileSceneGridPane.getChildren().remove(passportIdTextField);
                        customer.setPassportID(tokens[1]);
                        Text customerPassportIdText = new Text();
                        customerPassportIdText.setText(customer.getPassportID());
                        customerProfileSceneGridPane.add(customerPassportIdText, 1, 5);
                        customerProfileSceneGridPane.getChildren().remove(savePassportIdButton);
                    }
                }
            }
        }
        catch(IOException ex) {
            
        }
        
        try {
            addressesFile = new File("src/databasefiles/customerfiles/customer-addresses.txt");
            sc = new Scanner(addressesFile);
            
            if(addressesFile.exists()) {
                while(sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");
                    
                    if(Integer.toString(customer.getId()).equals(tokens[0])) {
                        placeholderText.setText("");
                        customerProfileSceneGridPane.getChildren().remove(countryNameTextField);
                        customerProfileSceneGridPane.getChildren().remove(countryLabel);
                        customerProfileSceneGridPane.getChildren().remove(cityOrTownTextField);
                        customerProfileSceneGridPane.getChildren().remove(cityLabel);
                        customerProfileSceneGridPane.getChildren().remove(districtOrStateTextField);
                        customerProfileSceneGridPane.getChildren().remove(districtLabel);
                        customerProfileSceneGridPane.getChildren().remove(streetAddressTextField);
                        customerProfileSceneGridPane.getChildren().remove(streetAddressLabel);
                        customerProfileSceneGridPane.getChildren().remove(postalCodeTextField);
                        customerProfileSceneGridPane.getChildren().remove(postalCodeLabel);
                        customerProfileSceneGridPane.getChildren().remove(saveAddressButton);
                        Text countryNameText = new Text();
                        countryNameText.setText(Arrays.toString(tokens));
                        customerProfileSceneGridPane.add(countryNameText, 1, 8);
                    }
                }
            }
        }
        catch(IOException ex) {
            
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        initializeCustomerData();
    }

    @FXML
    private void savePhoneNumberButtonOnClick(MouseEvent event) {
        String phoneNumber = phoneNumberTextField.getText();
        this.customer.setPhoneNumber(phoneNumber);
        this.customer.savePhoneNumberToDatabase();
        
        customerProfileSceneGridPane.getChildren().remove(phoneNumberTextField);
        Text customerPhoneNumberText = new Text();
        customerPhoneNumberText.setText(phoneNumber);
        customerProfileSceneGridPane.add(customerPhoneNumberText, 1, 3);
        customerProfileSceneGridPane.getChildren().remove(savePhoneNumberButton);
    }

    @FXML
    private void saveAddressButtonOnClick(MouseEvent event) {
        String country, cityOrTown, districtOrState, streetAddress, postalCode;
        country = countryNameTextField.getText();
        cityOrTown = cityOrTownTextField.getText();
        districtOrState = districtOrStateTextField.getText();
        streetAddress = streetAddressTextField.getText();
        postalCode = postalCodeTextField.getText();
        
        Address customerAddress = new Address(this.customer.getId(), country, cityOrTown, districtOrState, streetAddress, postalCode);
        
        this.customer.saveCustomerAddressToDatabase(customerAddress);
        
        customerProfileSceneGridPane.getChildren().remove(countryNameTextField);
        Text countryNameText = new Text();
        countryNameText.setText(country);
        customerProfileSceneGridPane.add(countryNameText, 1, 8);
        
        customerProfileSceneGridPane.getChildren().remove(cityOrTownTextField);
        Text cityOrTownText = new Text();
        cityOrTownText.setText(cityOrTown);
        customerProfileSceneGridPane.add(cityOrTownText, 1, 9);
        
        customerProfileSceneGridPane.getChildren().remove(districtOrStateTextField);
        Text districtOrStateText = new Text();
        districtOrStateText.setText(districtOrState);
        customerProfileSceneGridPane.add(districtOrStateText, 1, 10);
        
        customerProfileSceneGridPane.getChildren().remove(streetAddressTextField);
        Text streetAddressText = new Text();
        streetAddressText.setText(streetAddress);
        customerProfileSceneGridPane.add(streetAddressText, 1, 11);
        
        customerProfileSceneGridPane.getChildren().remove(postalCodeTextField);
        Text postalCodeText = new Text();
        postalCodeText.setText(postalCode);
        customerProfileSceneGridPane.add(postalCodeText, 1, 12);
        
        placeholderText.setText("");
        customerProfileSceneGridPane.getChildren().remove(saveAddressButton);
    }

    @FXML
    private void savePassportIdButtonOnClick(ActionEvent event) {
        String passportId = passportIdTextField.getText();
        this.customer.setPassportID(passportId);
        this.customer.savePassportIdToDatabase();
        
        customerProfileSceneGridPane.getChildren().remove(passportIdTextField);
        Text customerPassportIdText = new Text();
        customerPassportIdText.setText(passportId);
        customerProfileSceneGridPane.add(customerPassportIdText, 1, 5);
        customerProfileSceneGridPane.getChildren().remove(savePassportIdButton);
    }
    
}
