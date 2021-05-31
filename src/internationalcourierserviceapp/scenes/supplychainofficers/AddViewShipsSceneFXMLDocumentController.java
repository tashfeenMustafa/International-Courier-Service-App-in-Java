package internationalcourierserviceapp.scenes.supplychainofficers;

import assets.businessproperties.Ships;
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

public class AddViewShipsSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private ObservableList<Ships> allShips;
    @FXML private TableView<Ships> shipTable;
    @FXML private TableColumn<Ships, String> nameColumn;
    @FXML private TableColumn<Ships, String> idColumn;
    @FXML private TableColumn<Ships, String> routeColumn;
    @FXML private TableColumn<Ships, String> assignedShippingPortNameColumn;
    @FXML private TextField nameTextField;
    @FXML private TextField idTextField;
    @FXML private TextField routeTextField;
    @FXML private Button addShipButton;
    @FXML private Button updateShipsTableButton;
    @FXML private ComboBox<String> assignShippingPortComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAndSetShippingPortComboBox();
        allShips = FXCollections.observableArrayList();
    }    
    
    public void loadAndSetShippingPortComboBox() {
        assignShippingPortComboBox.getItems().clear();
        assignShippingPortComboBox.getItems().addAll(
                "Chittagong Shipping Port",
                "Goa Shipping Port",
                "New York Shipping Port",
                "Xinjiang Shipping Port",
                "Sydney Shipping Port",
                "South Africa Shipping Port"
        );
    }

    public SupplyChainOfficer getSupplyChainOfficer() {
        return supplyChainOfficer;
    }

    public void setSupplyChainOfficer(SupplyChainOfficer supplyChainOfficer) {
        this.supplyChainOfficer = supplyChainOfficer;
    }

    @FXML
    private void addShipButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String id = idTextField.getText();
        String route = routeTextField.getText();
        String assignedShippingPortName = assignShippingPortComboBox.getValue();
        
        Ships newShip = new Ships(name, id, route, assignedShippingPortName);
        
        supplyChainOfficer.addShipsToDatabase(newShip);
    }

    @FXML
    private void updateShipsTableButtonOnClick(MouseEvent event) {
        allShips = supplyChainOfficer.getShipsList();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        routeColumn.setCellValueFactory(new PropertyValueFactory<>("route"));
        assignedShippingPortNameColumn.setCellValueFactory(new PropertyValueFactory<>("assignedShippingPortName"));
        
        shipTable.setItems(allShips);
    }
    
}
