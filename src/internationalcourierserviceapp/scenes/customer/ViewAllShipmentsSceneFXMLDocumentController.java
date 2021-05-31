/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.customer;

import assets.Recipient;
import assets.Shipment;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ViewAllShipmentsSceneFXMLDocumentController implements Initializable {
    
    private Customer customer;
    private Shipment draftToActiveShipment;
    private ObservableList<Shipment> activeShipments;
    private ObservableList<Shipment> draftShipments;
    private ObservableList<Shipment> completedShipments;
    @FXML private Pane allShipmentsScenePane;
    @FXML private TabPane allShipmentsSceneTabPane;
    @FXML private Tab viewActiveShipmentsTab;
    @FXML private Tab viewDraftShipmentsTab;
    @FXML private Tab viewCompletedShipmentsTab;
    @FXML private AnchorPane viewActiveShipmentsAnchorPane;
    @FXML private TableView<Shipment> activeShipmentsTable;
    @FXML private TableColumn<Shipment, String> shipmentNameColumn;
    @FXML private TableColumn<Shipment, String> shipmentDescriptionColumn;
    @FXML private TableColumn<Shipment, Recipient> recipientDetailsColumn;
    @FXML private TableColumn<Shipment, LocalDate> pickupDateTimeColumn;
    @FXML private TableColumn<Shipment, LocalTime> pickupTimeColumn;
    @FXML private TableColumn<Shipment, String> shipmentTrackingIDColumn;
    @FXML private TableColumn<Shipment, LocalDate> deliveryDateColumn;
    @FXML private TableColumn<Shipment, String> shipmentLocationColumn;
    @FXML private TableColumn<Shipment, Double> shippingCostColumn;
    @FXML private Button loadActiveShipmentsButton;
    @FXML private TableView<Shipment> draftShipmentsTable;
    @FXML private TableColumn<Shipment, String> draftShipmentNameColumn;
    @FXML private TableColumn<Shipment, String> draftShipmentDescriptionColumn;
    @FXML private TableColumn<Shipment, Recipient> draftShipmentRecipientDetailsColumn;
    @FXML private TableColumn<Shipment, String> draftShipmentTrackingIDColumn;
    @FXML private TableColumn<Shipment, LocalDate> draftShipmentDeliveryDateColumn;
    @FXML private TableColumn<Shipment, LocalDate> draftShipmentPickupDateColumn;
    @FXML private TableColumn<Shipment, Double> draftShipmentShippingCostColumn;
    @FXML private TableView<Shipment> completedShipmentsTable;
    @FXML private TableColumn<Shipment, String> completedShipmentsNameColumn;
    @FXML private TableColumn<Shipment, String> completedShipmentsDescriptionColumn;
    @FXML private TableColumn<Shipment, Recipient> completedShipmentsRecipientDetailsColumn;
    @FXML private TableColumn<Shipment, String> completedShipmentsTrackingIDColumn;
    @FXML private TableColumn<Shipment, LocalDate> completedShipmentsDeliveryDateColumn;
    @FXML private TableColumn<Shipment, LocalDate> completedShipmentsPickupDateColumn;
    @FXML private TableColumn<Shipment, Double> completedShipmentsShippingCostColumn;
    @FXML private Button loadDraftShipmentsButton;
    @FXML private Button loadCompletedShipmentsButton;
    @FXML private Button changeDraftToActiveShipmentButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        activeShipments = FXCollections.observableArrayList();
        draftShipments = FXCollections.observableArrayList();
        completedShipments = FXCollections.observableArrayList();
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private void viewActiveShipmentsTabOnSelection(Event event) {
        
    }

    @FXML
    private void loadActiveShipmentsButtonOnClick(MouseEvent event) {
        activeShipments = customer.getActiveShipmentsList();
        shipmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        shipmentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        recipientDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        pickupDateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupDate"));
        shipmentTrackingIDColumn.setCellValueFactory(new PropertyValueFactory<>("trackingID"));
        deliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        shipmentLocationColumn.setCellValueFactory(new PropertyValueFactory<>("currentLocation"));
        shippingCostColumn.setCellValueFactory(new PropertyValueFactory<>("shippingCost"));
        pickupTimeColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupTime"));
        activeShipmentsTable.setItems(activeShipments);
    }

    @FXML
    private void loadDraftShipmentsButtonOnClick(MouseEvent event) {
        draftShipments = customer.getDraftShipmentsList();
        draftShipmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        draftShipmentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        draftShipmentRecipientDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        draftShipmentPickupDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupDate"));
        draftShipmentTrackingIDColumn.setCellValueFactory(new PropertyValueFactory<>("trackingID"));
        draftShipmentDeliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        draftShipmentShippingCostColumn.setCellValueFactory(new PropertyValueFactory<>("shippingCost"));
        draftShipmentsTable.setItems(draftShipments);
    }

    @FXML
    private void loadCompletedShipmentsButtonOnClick(MouseEvent event) {
        completedShipments = customer.getCompletedShipmentsList();
        completedShipmentsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        completedShipmentsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        completedShipmentsRecipientDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        completedShipmentsPickupDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedPickupDate"));
        completedShipmentsTrackingIDColumn.setCellValueFactory(new PropertyValueFactory<>("trackingID"));
        completedShipmentsDeliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        completedShipmentsShippingCostColumn.setCellValueFactory(new PropertyValueFactory<>("shippingCost"));
        completedShipmentsTable.setItems(completedShipments);
    }


    @FXML
    private void displaySelectedInDraftShipments(MouseEvent event) {
        draftToActiveShipment = draftShipmentsTable.getSelectionModel().getSelectedItem();
        if(draftToActiveShipment == null) {
            // show nothing selected;
            System.out.println("Nothing selected");
        }
    }

    @FXML
    private void changeDraftToActiveShipmentButtonOnClick(MouseEvent event) {
        draftToActiveShipment.setIsPickupConfirmed(Boolean.TRUE);
        draftToActiveShipment.setIsWarehouseDelivery(Boolean.TRUE);
        draftToActiveShipment.updateCurrentLocation();
        activeShipments.add(draftToActiveShipment);
        // update activeShipments.bin file
        customer.createActiveShipment(draftToActiveShipment);
        draftShipments.remove(draftToActiveShipment);
        // update draftShipments.bin file
        // delete current draftShipments.bin file
        // create new file and then write the draftShipments ObservableArrayList into the file
    }
    
    
    
}
