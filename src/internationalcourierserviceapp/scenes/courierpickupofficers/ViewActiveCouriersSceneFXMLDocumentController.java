package internationalcourierserviceapp.scenes.courierpickupofficers;

import assets.Recipient;
import assets.Shipment;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import users.CourierPickupOfficer;

public class ViewActiveCouriersSceneFXMLDocumentController implements Initializable {

    private CourierPickupOfficer courierPickupOfficer;
    private Shipment selectedCourier;
    private ObservableList<Shipment> activeCouriers;
    @FXML private AnchorPane viewActiveShipmentSceneAnchorPane;
    @FXML private TableView<Shipment> activeShipmentsForCourierOfficerTable;
    @FXML private TableColumn<Shipment, String> nameColumn;
    @FXML private TableColumn<Shipment, String> descriptionColumn;
    @FXML private TableColumn<Shipment, Recipient> recipientDetailsColumn;
    @FXML private TableColumn<Shipment, String> trackingIdColumn;
    @FXML private TableColumn<Shipment, Double> weightColumn;
    @FXML private TableColumn<Shipment, Boolean> assignedWarehouseColumn;
    @FXML private TableColumn<Shipment, Boolean> assignedShippingPortColumn;
    @FXML private TableColumn<Shipment, Double> lengthColumn;
    @FXML private TableColumn<Shipment, Double> widthColumn;
    @FXML private TableColumn<Shipment, Double> heightColumn;
    @FXML private TableColumn<Shipment, LocalTime> pickupTimeColumn;
    @FXML private TableColumn<Shipment, LocalDate> pickupDateColumn;
    @FXML private TableColumn<Shipment, LocalDate> deliveryDateColumn;
    @FXML private TableColumn<?, ?> dimensionColumn;
    @FXML private Button updateTableButton;
    @FXML private Button flagSelectedAsCourierButton;
    @FXML private Button completeShipmentButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        activeCouriers = FXCollections.observableArrayList();
    }    

    public CourierPickupOfficer getCourierPickupOfficer() {
        return courierPickupOfficer;
    }

    public void setCourierPickupOfficer(CourierPickupOfficer courierPickupOfficer) {
        this.courierPickupOfficer = courierPickupOfficer;
    }

    @FXML
    private void selectActiveShipment(MouseEvent event) {
        selectedCourier = activeShipmentsForCourierOfficerTable.getSelectionModel().getSelectedItem();
        if(selectedCourier == null) {
            System.out.println("None selected.");
        }
    }

    @FXML
    private void updateTableButtonOnClick(MouseEvent event) {
        System.out.println("Here 2");
        activeCouriers = courierPickupOfficer.loadActiveShipmentsList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        recipientDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        pickupDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupDate"));
        pickupTimeColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupTime"));
        trackingIdColumn.setCellValueFactory(new PropertyValueFactory<>("trackingID"));
        deliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<>("width"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        assignedWarehouseColumn.setCellValueFactory(new PropertyValueFactory<>("isWarehouseDelivery"));
        assignedShippingPortColumn.setCellValueFactory(new PropertyValueFactory<>("isShippingPortDelivery"));
        activeShipmentsForCourierOfficerTable.setItems(activeCouriers);
    }

    @FXML
    private void flagSelectedAsCourierButtonOnClick(MouseEvent event) {
        selectedCourier.setIsFlagged(Boolean.TRUE);
        courierPickupOfficer.flagCourierAsIllegal(selectedCourier);
        activeCouriers.remove(selectedCourier);
        // update activeShipments.bin file
        // delete current activeShipments.bin file
        // create new file and then write the activeCouriers ObservableArrayList into the file
    }

    @FXML
    private void completeShipmentButtonOnClick(MouseEvent event) {
        selectedCourier.setIsDeliveryComplete(Boolean.TRUE);
        courierPickupOfficer.completeShipment(selectedCourier);
        activeCouriers.remove(selectedCourier);
        // update activeShipments.bin file
        // delete current activeShipments.bin file
        // create new file and then write the activeCouriers ObservableArrayList into the file
    }
    
}
