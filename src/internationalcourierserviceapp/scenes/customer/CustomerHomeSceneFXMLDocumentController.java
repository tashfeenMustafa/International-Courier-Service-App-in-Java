/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CustomerHomeSceneFXMLDocumentController implements Initializable {
    
    private Customer customer;
    private Parent homeSceneRoot;
    private FXMLLoader loader;
    @FXML private Button createShipmentButton;
    @FXML private Button getRateAndTimeButton;
    @FXML private Button viewAllShipmentsButton;
    @FXML private Button createAddressBookButton;
    @FXML private BorderPane customerHomeSceneBorderPane;
    @FXML private Button yourProfileButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUIAndPassCustomer("CustomerHomeProfileSceneFXMLDocument");
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }    

    @FXML
    private void createShipmentButtonOnClick(MouseEvent event) {
        loadUIAndPassCustomer("CreateShipmentSceneFXMLDocument");
        CreateShipmentSceneFXMLDocumentController createShipmentSceneController = loader.getController();
        createShipmentSceneController.setCustomer(customer);
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void getRateAndTimeButtonOnClick(MouseEvent event) {
        loadUIAndPassCustomer("GetRateAndTimeSceneFXMLDocument");
        GetRateAndTimeSceneFXMLDocumentController getRateAndTimeSceneController = loader.getController();
        getRateAndTimeSceneController.setCustomer(customer);
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void viewAllShipmentsButtonOnClick(MouseEvent event) {
        loadUIAndPassCustomer("ViewAllShipmentsSceneFXMLDocument");
        ViewAllShipmentsSceneFXMLDocumentController viewAllShipmentsSceneController = loader.getController();
        viewAllShipmentsSceneController.setCustomer(customer);
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void createAddressBookButtonOnClick(MouseEvent event) {
        loadUIAndPassCustomer("CreateAddressBookSceneFXMLDocument");
        CreateAddressBookSceneFXMLDocumentController createAddressBookSceneController = loader.getController();
        createAddressBookSceneController.setCustomer(customer);
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }
    
    @FXML
    private void onYourProfileButtonClick(MouseEvent event) {
        loadUIAndPassCustomer("CustomerHomeProfileSceneFXMLDocument");
        CustomerHomeProfileSceneFXMLDocumentController customerHomeProfileSceneController = loader.getController();
        customerHomeProfileSceneController.setCustomer(customer);
        customerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }
    
    private void loadUI(String UI) {
        Parent root = null; 
        try {
            root = FXMLLoader.load(getClass().getResource(UI + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CustomerHomeSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        customerHomeSceneBorderPane.setCenter(root);
    }
    
    private void loadUIAndPassCustomer(String FXMLFile) {
        loader = new FXMLLoader(getClass().getResource(FXMLFile + ".fxml"));
        homeSceneRoot = null;
        try {
            homeSceneRoot = (Parent) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CustomerHomeSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        System.out.println(this.customer.getName());
        //The following both lines are the only addition we need to pass the arguments
        CustomerHomeProfileSceneFXMLDocumentController customerHomeProfileSceneController = loader.getController();
        customerHomeProfileSceneController.setCustomer(customer);
    }

    
}
