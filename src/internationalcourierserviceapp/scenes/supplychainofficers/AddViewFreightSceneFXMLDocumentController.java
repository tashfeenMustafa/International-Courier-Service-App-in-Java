package internationalcourierserviceapp.scenes.supplychainofficers;

import assets.businessproperties.Freight;
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

public class AddViewFreightSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private ObservableList<Freight> allFreights;
    @FXML private TableView<Freight> freightTable;
    @FXML private TableColumn<Freight, String> serialNumberColumn;
    @FXML private TableColumn<Freight, Double> weightColumn;
    @FXML private TableColumn<Freight, Double> lengthColumn;
    @FXML private TableColumn<Freight, Double> heightColumn;
    @FXML private TableColumn<Freight, Double> widthColumn;
    @FXML private TableColumn<Freight, String> assignedShipIdColumn;
    @FXML private TableColumn<Freight, String> assignedShippingPortNameColumn;
    @FXML private TextField serialNumberTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField lengthTextField;
    @FXML private TextField heightTextField;
    @FXML private TextField widthTextField;
    @FXML private ComboBox<String> assignShipIdComboBox;
    @FXML private ComboBox<String> assignShippingPortComboBox;
    @FXML private Button addFreightButton;
    @FXML private Button loadTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAndSetShipIdComboBox();
        loadAndSetShippingPortComboBox();
        allFreights = FXCollections.observableArrayList();
    }  
    
    public void loadAndSetShipIdComboBox() {
        assignShipIdComboBox.getItems().clear();
        assignShipIdComboBox.getItems().addAll(
                "ISO390128",
                "ISO212625",
                "ISO102093",
                "ISO556271",
                "ISO784126",
                "ISO315025"
        );
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
    private void addFreightButtonOnClick(MouseEvent event) {
        String serialNumber = serialNumberTextField.getText();
        double weight = Double.parseDouble(weightTextField.getText());
        double length = Double.parseDouble(lengthTextField.getText());
        double height = Double.parseDouble(heightTextField.getText());
        double width = Double.parseDouble(widthTextField.getText());
        String assignedShipID = assignShipIdComboBox.getValue();
        String assignedShippingPortName = assignShippingPortComboBox.getValue();
        
        Freight freight = new Freight(serialNumber, weight, length, height, width, assignedShipID, assignedShippingPortName);
        
        supplyChainOfficer.addFreightToDatabase(freight);
    }

    @FXML
    private void loadTableOnClick(MouseEvent event) {
        allFreights = supplyChainOfficer.getFreightsList();
        
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<>("width"));
        assignedShipIdColumn.setCellValueFactory(new PropertyValueFactory<>("assignedShipID"));
        assignedShippingPortNameColumn.setCellValueFactory(new PropertyValueFactory<>("assignedShippingPortName"));
        
        freightTable.setItems(allFreights);
    }
    
}
