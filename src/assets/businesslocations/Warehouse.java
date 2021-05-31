package assets.businesslocations;

import java.io.Serializable;

public class Warehouse implements Serializable {
    private String name;
    private String streetAddress;
    private String assignedWarehouseManagementOfficerName;

    public Warehouse(String name, String streetAddress, String assignedWarehouseManagementOfficerName) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.assignedWarehouseManagementOfficerName = assignedWarehouseManagementOfficerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAssignedWarehouseManagementOfficerName() {
        return assignedWarehouseManagementOfficerName;
    }

    public void setAssignedWarehouseManagementOfficerName(String assignedWarehouseManagementOfficerName) {
        this.assignedWarehouseManagementOfficerName = assignedWarehouseManagementOfficerName;
    }
    
}
