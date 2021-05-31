package assets.businesslocations;

import java.io.Serializable;

public class ShippingPort implements Serializable {
    private String name;
    private String streetAddress;
    private String assignedShippingPortOfficerName;

    public ShippingPort(String name, String streetAddress, String assignedShippingPortOfficerName) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.assignedShippingPortOfficerName = assignedShippingPortOfficerName;
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

    public String getAssignedShippingPortOfficerName() {
        return assignedShippingPortOfficerName;
    }

    public void setAssignedShippingPortOfficerName(String assignedShippingPortOfficerName) {
        this.assignedShippingPortOfficerName = assignedShippingPortOfficerName;
    }

}
