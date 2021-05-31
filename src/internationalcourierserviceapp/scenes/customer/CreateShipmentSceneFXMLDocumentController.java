/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import assets.Address;
import assets.Recipient;
import assets.Shipment;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreateShipmentSceneFXMLDocumentController implements Initializable {

    private Customer customer;
    @FXML private BorderPane createShipmentViewBorderPane;
    @FXML private Button confirmShipmentButton;
    @FXML private Button saveAsDraftButton;
    @FXML private Button cancelShipmentButton;
    @FXML private TextField shipmentNameTextField;
    @FXML private TextField shipmentDescriptionTextField;
    @FXML private TextField shipmentWeightTextField;
    @FXML private TextField shipmentLengthTextField;
    @FXML private TextField shipmentWidthTextField;
    @FXML private TextField shipmentHeightTextField;
    @FXML private TextField recipientAddressTitleTextField;
    @FXML private TextField recipientNameTextField;
    @FXML private TextField recipientPhoneTextField;
    @FXML private TextField recipientCountryTextField;
    @FXML private TextField recipientStreetAddressTextField;
    @FXML private TextField recipientPostalCodeTextField;
    @FXML private DatePicker shipmentDatePicker;
    @FXML private TextField shipmentTimePicker;
    @FXML private TextField recipientCityOrTownTextField;
    @FXML private TextField recipientDistrictOrStateTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void onConfirmShipmentButtonClick(MouseEvent event) {
        String shipmentName = shipmentNameTextField.getText();
        String shipmentDescription = shipmentDescriptionTextField.getText();
        double shipmentWeight = Double.parseDouble(shipmentWeightTextField.getText());
        double shipmentLength =  Double.parseDouble(shipmentLengthTextField.getText());
        double shipmentWidth =  Double.parseDouble(shipmentWidthTextField.getText());
        double shipmentHeight =  Double.parseDouble(shipmentHeightTextField.getText());
        LocalDate shipmentPickupDate = shipmentDatePicker.getValue();
        LocalTime shipmentPickupTime = LocalTime.parse(shipmentTimePicker.getText());
        
        String recipientName = recipientNameTextField.getText();
        String recipientPhone = recipientPhoneTextField.getText();
        
        String recipientAddressTitle = recipientAddressTitleTextField.getText();
        String recipientCountry = recipientCountryTextField.getText();
        String recipientCityOrTown = recipientCityOrTownTextField.getText();
        String recipientDistrictOrState = recipientDistrictOrStateTextField.getText();
        String recipientStreetAddress = recipientStreetAddressTextField.getText();
        String recipientPostalCode = recipientPostalCodeTextField.getText();
        Address recipientAddress = new Address(recipientAddressTitle, recipientCountry, recipientCityOrTown, recipientDistrictOrState, recipientStreetAddress, recipientPostalCode);
    
        Recipient recipient = new Recipient(recipientName, recipientPhone, recipientAddress);
        Shipment shipment = new Shipment(shipmentName, shipmentDescription, shipmentWeight, shipmentLength, shipmentHeight, shipmentWidth, recipient, customer.getId(), shipmentPickupDate, shipmentPickupTime);
        shipment.setIsPickupConfirmed(Boolean.TRUE);
        shipment.setIsWarehouseDelivery(Boolean.TRUE);
        shipment.updateCurrentLocation();
        shipment.calculateEstimatedDeliveryDateTime();
        shipment.calculateShippingCost();
        
        customer.createActiveShipment(shipment);
        confirmShipmentButton.setText("Sucessful!");
        
        shipmentNameTextField.setText("");
        shipmentDescriptionTextField.setText("");
        shipmentWeightTextField.setText("");
        shipmentLengthTextField.setText("");
        shipmentWidthTextField.setText("");
        shipmentHeightTextField.setText("");
        shipmentDatePicker.setValue(null);
        shipmentTimePicker.setText("");
        
        recipientNameTextField.setText("");
        recipientPhoneTextField.setText("");
        
        recipientAddressTitleTextField.setText("");
        recipientCountryTextField.setText("");
        recipientCityOrTownTextField.setText("");
        recipientDistrictOrStateTextField.setText("");
        recipientStreetAddressTextField.setText("");
        recipientPostalCodeTextField.setText("");
    }

    @FXML
    private void onSaveAsDraftButtonClick(MouseEvent event) {
        String shipmentName = shipmentNameTextField.getText();
        String shipmentDescription = shipmentDescriptionTextField.getText();
        double shipmentWeight = Double.parseDouble(shipmentWeightTextField.getText());
        double shipmentLength =  Double.parseDouble(shipmentLengthTextField.getText());
        double shipmentWidth =  Double.parseDouble(shipmentWidthTextField.getText());
        double shipmentHeight =  Double.parseDouble(shipmentHeightTextField.getText());
        LocalDate shipmentPickupDate = shipmentDatePicker.getValue();
        LocalTime shipmentPickupTime = LocalTime.parse(shipmentTimePicker.getText());
        
        String recipientName = recipientNameTextField.getText();
        String recipientPhone = recipientPhoneTextField.getText();
        
        String recipientAddressTitle = recipientAddressTitleTextField.getText();
        String recipientCountry = recipientCountryTextField.getText();
        String recipientCityOrTown = recipientCityOrTownTextField.getText();
        String recipientDistrictOrState = recipientDistrictOrStateTextField.getText();
        String recipientStreetAddress = recipientStreetAddressTextField.getText();
        String recipientPostalCode = recipientPostalCodeTextField.getText();
        Address recipientAddress = new Address(recipientAddressTitle, recipientCountry, recipientCityOrTown, recipientDistrictOrState, recipientStreetAddress, recipientPostalCode);
    
        Recipient recipient = new Recipient(recipientName, recipientPhone, recipientAddress);
        Shipment shipment = new Shipment(shipmentName, shipmentDescription, shipmentWeight, shipmentLength, shipmentHeight, shipmentWidth, recipient, customer.getId(), shipmentPickupDate, shipmentPickupTime);
        shipment.setIsPickupConfirmed(Boolean.TRUE);
        shipment.setIsWarehouseDelivery(Boolean.TRUE);
        shipment.updateCurrentLocation();
        shipment.calculateShippingCost();
        shipment.calculateEstimatedDeliveryDateTime();
        
        customer.createDraftShipment(shipment);
        saveAsDraftButton.setText("Sucessful!");
        
        shipmentNameTextField.setText("");
        shipmentDescriptionTextField.setText("");
        shipmentWeightTextField.setText("");
        shipmentLengthTextField.setText("");
        shipmentWidthTextField.setText("");
        shipmentHeightTextField.setText("");
        shipmentDatePicker.setValue(null);
        shipmentTimePicker.setText("");
        
        recipientNameTextField.setText("");
        recipientPhoneTextField.setText("");
        
        recipientAddressTitleTextField.setText("");
        recipientCountryTextField.setText("");
        recipientCityOrTownTextField.setText("");
        recipientDistrictOrStateTextField.setText("");
        recipientStreetAddressTextField.setText("");
        recipientPostalCodeTextField.setText("");
    }

    @FXML
    private void onCancelShipmentButtonClick(MouseEvent event) {
        cancelShipmentButton.setText("Sucessful!");
        
        shipmentNameTextField.setText("");
        shipmentDescriptionTextField.setText("");
        shipmentWeightTextField.setText("");
        shipmentLengthTextField.setText("");
        shipmentWidthTextField.setText("");
        shipmentHeightTextField.setText("");
        shipmentDatePicker.setValue(null);
        shipmentTimePicker.setText("");
        
        recipientNameTextField.setText("");
        recipientPhoneTextField.setText("");
        
        recipientAddressTitleTextField.setText("");
        recipientCountryTextField.setText("");
        recipientCityOrTownTextField.setText("");
        recipientDistrictOrStateTextField.setText("");
        recipientStreetAddressTextField.setText("");
        recipientPostalCodeTextField.setText("");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
