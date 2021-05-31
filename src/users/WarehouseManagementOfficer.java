package users;

import assets.Shipment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class WarehouseManagementOfficer extends Employee {
    
    public WarehouseManagementOfficer(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, String name, String phoneNumber, String emailAddress) {
        super(designation, age, gender, streetAddress, salary, department, joinDate, shiftDays, shiftHours, name, phoneNumber, emailAddress);
    }
    
    public void addStaffToWarehouse(Employee staff){}
    public ObservableList<Employee> getAllStaffOfWarehouse() {
        return null;
    }
    
    public void addToImportantShipments(Shipment shipment) {}
    public ObservableList<Shipment> getAllImportantShipments() {
        return null;
    }
    
    public void addToFragileShipments(Shipment shipment) {}
    public ObservableList<Shipment> getAllFragileShipments() {
        return null;
    }
    
    public void addShipmentToWarehouse(Shipment shipment) {}
    public ObservableList<Shipment> getAllShipmentsInWarehouse() {
        return null;
    }
    
    public void addPartnerToWarehouse(Partner partner) {}
    public ObservableList<Partner> getAllPartnersInWarehouse() {
        return null;
    }
}
