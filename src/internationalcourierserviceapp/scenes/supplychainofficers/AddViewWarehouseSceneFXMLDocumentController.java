package internationalcourierserviceapp.scenes.supplychainofficers;

import assets.businesslocations.Warehouse;
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

public class AddViewWarehouseSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private ObservableList<Warehouse> allWarehouses;
    @FXML private TableView<Warehouse> warehouseTable;
    @FXML private TableColumn<Warehouse, String> nameColumn;
    @FXML private TableColumn<Warehouse, String> streetAddressColumn;
    @FXML private TableColumn<Warehouse, String> assignedWarehouseOfficerColumn;
    @FXML private Button updateTableColumn;
    @FXML private TextField nameTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private ComboBox<String> assignWarehouseManagementOfficerComboBox;
    @FXML private Button addWarehouseButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAndSetWarehouseManagementComboBox();
        allWarehouses = FXCollections.observableArrayList();
    }    

    public void loadAndSetWarehouseManagementComboBox() {
        assignWarehouseManagementOfficerComboBox.getItems().clear();
        assignWarehouseManagementOfficerComboBox.getItems().addAll(
                "John Adams",
                "Steve Irwin",
                "James Gordon",
                "Nitin Patel",
                "Shahrukh Rahman",
                "Asif Karim"
        );
    }   
    
    public SupplyChainOfficer getSupplyChainOfficer() {
        return supplyChainOfficer;
    }

    public void setSupplyChainOfficer(SupplyChainOfficer supplyChainOfficer) {
        this.supplyChainOfficer = supplyChainOfficer;
    }

    @FXML
    private void updateTableColumnOnClick(MouseEvent event) {
        allWarehouses = supplyChainOfficer.getWarehouseList();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        assignedWarehouseOfficerColumn.setCellValueFactory(new PropertyValueFactory<>("assignedWarehouseManagementOfficerName"));
        
        warehouseTable.setItems(allWarehouses);
    }

    @FXML
    private void addWarehouseButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String streetAddress = streetAddressTextField.getText();
        String assignedWarehouseManagementOfficerName = assignWarehouseManagementOfficerComboBox.getValue();
    
        Warehouse warehouse = new Warehouse(name, streetAddress, assignedWarehouseManagementOfficerName);
        
        supplyChainOfficer.addWarehouseToDatabase(warehouse);
    }
    
    
}
