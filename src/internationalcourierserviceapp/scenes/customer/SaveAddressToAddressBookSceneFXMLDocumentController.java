package internationalcourierserviceapp.scenes.customer;

import assets.Address;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import users.Customer;

public class SaveAddressToAddressBookSceneFXMLDocumentController implements Initializable {

    private Customer customer;
    @FXML private TextField titleTextField;
    @FXML private TextField countryTextField;
    @FXML private TextField cityOrTownTextField;
    @FXML private TextField districtOrStateTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private TextField postalCodeTextField;
    @FXML private Button saveNewAddressToDatabaseButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    public Customer getCustomer() {
        return customer;
    }

    public void initData(Customer customer) {
        this.customer = customer;
        System.out.println(this.customer.getName());
    }

    @FXML
    private void saveNewAddressToDatabaseButtonOnClick(MouseEvent event) {
        String title = titleTextField.getText();
        String country = countryTextField.getText();
        String cityOrTown = cityOrTownTextField.getText();
        String districtOrState = districtOrStateTextField.getText();
        String streetAddress = streetAddressTextField.getText();
        String postalCode = postalCodeTextField.getText();
        Address newAddress = new Address();
        newAddress.setAssociatedCustomerID(customer.getId());
        newAddress.setTitle(title);
        newAddress.setCountry(country);
        newAddress.setCityOrTown(cityOrTown);
        newAddress.setDistrictOrState(districtOrState);
        newAddress.setStreetAddress(streetAddress);
        newAddress.setPostalCode(postalCode);
        System.out.println(newAddress);
    
        customer.saveToAddressBook(newAddress);
    }
    
}
