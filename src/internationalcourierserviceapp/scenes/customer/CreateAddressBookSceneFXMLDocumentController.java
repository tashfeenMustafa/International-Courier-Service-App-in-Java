/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import assets.Address;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import users.Customer;

public class CreateAddressBookSceneFXMLDocumentController implements Initializable {

    private Customer customer;
    @FXML private AnchorPane addressBookAnchorPane;
    @FXML private Button saveNewAddressButton;
    @FXML private TableView<Address> addressBookTableView;
    @FXML private TableColumn<Address, String> titleColumn;
    @FXML private TableColumn<Address, String> countryColumn;
    @FXML private TableColumn<Address, String> cityOrTownColumn;
    @FXML private TableColumn<Address, String> districtOrStateColumn;
    @FXML private TableColumn<Address, String> streetAddressColumn;
    @FXML private TableColumn<Address, String> postalCodeColumn;
    private ObservableList<Address> addressBook;
    @FXML private Button updateAdressBookTableButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addressBook = FXCollections.observableArrayList();
    }    


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        System.out.println("in create addressbook: " + this.customer.getEmailAddress());
    }

    @FXML
    private void updateAdressBookTableButtonOnClick(ActionEvent event) {
        addressBook = customer.getAddressBookList();
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        cityOrTownColumn.setCellValueFactory(new PropertyValueFactory<>("cityOrTown"));
        districtOrStateColumn.setCellValueFactory(new PropertyValueFactory<>("districtOrState"));
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        
        addressBookTableView.setItems(addressBook);
    }

    @FXML
    private void saveNewAddressButtonOnClick(MouseEvent event) throws IOException {
        Stage stage = null;
        
        if(saveNewAddressButton == event.getSource()) {
            try {
                stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SaveAddressToAddressBookSceneFXMLDocument.fxml"));
                
                Parent root = (Parent) loader.load();
                
                Scene scene = new Scene(root, 618, 424);
                
                SaveAddressToAddressBookSceneFXMLDocumentController saveAddressToAddressBookSceneController = loader.getController();
                System.out.println(saveAddressToAddressBookSceneController);
                saveAddressToAddressBookSceneController.initData(customer);
  
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CreateAddressBookSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
