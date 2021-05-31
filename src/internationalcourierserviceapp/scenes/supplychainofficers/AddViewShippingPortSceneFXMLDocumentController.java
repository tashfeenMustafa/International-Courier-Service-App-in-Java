package internationalcourierserviceapp.scenes.supplychainofficers;

import assets.businesslocations.ShippingPort;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import users.SupplyChainOfficer;

public class AddViewShippingPortSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private ObservableList<ShippingPort> allShippingPorts;
    @FXML private TableView<ShippingPort> shippingPortTable;
    @FXML private TableColumn<ShippingPort, String> nameColumn;
    @FXML private TableColumn<ShippingPort, String> streetAddressColumn;
    @FXML private TableColumn<ShippingPort, String> assignedShippingPortOfficerColumn;
    @FXML private Button loadTableButton;
    @FXML private TextField nameTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private ComboBox<String> assignShippingPortOfficerComboBox;
    @FXML private Button addShippingPortButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAndSetShippingPortOfficerNameComboBox();
        allShippingPorts = FXCollections.observableArrayList();
    }    
    
    public void loadAndSetShippingPortOfficerNameComboBox() {
        assignShippingPortOfficerComboBox.getItems().clear();
        assignShippingPortOfficerComboBox.getItems().addAll(
                "Robert Fuller",
                "Tanvir Kabir",
                "Tasneem Begum"
        );
    }

    public SupplyChainOfficer getSupplyChainOfficer() {
        return supplyChainOfficer;
    }

    public void setSupplyChainOfficer(SupplyChainOfficer supplyChainOfficer) {
        this.supplyChainOfficer = supplyChainOfficer;
    }

    @FXML
    private void loadTableButtonOnClick(MouseEvent event) {
        allShippingPorts = supplyChainOfficer.getShippingPortList();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        assignedShippingPortOfficerColumn.setCellValueFactory(new PropertyValueFactory<>("assignedShippingPortOfficerName"));
        
        shippingPortTable.setItems(allShippingPorts);
    }

    @FXML
    private void addShippingPortButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String streetAddress = streetAddressTextField.getText();
        String assignedShippingPortOfficerName = assignShippingPortOfficerComboBox.getValue();
        
        ShippingPort shippingPort = new ShippingPort(name, streetAddress, assignedShippingPortOfficerName);
        supplyChainOfficer.addShippingPortToDatabase(shippingPort);
    }
    
}
