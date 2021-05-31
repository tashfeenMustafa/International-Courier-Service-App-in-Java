package assets.businessproperties;

import java.io.Serializable;

public class Freight implements Serializable {
    private String serialNumber;
    private double weight;
    private double length;
    private double height;
    private double width;
    private String assignedShipID;
    private String assignedShippingPortName;

    public Freight(String serialNumber, double weight, double length, double height, double width, String assignedShipID, String assignedShippingPortName) {
        this.serialNumber = serialNumber;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.assignedShipID = assignedShipID;
        this.assignedShippingPortName = assignedShippingPortName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getAssignedShipID() {
        return assignedShipID;
    }

    public void setAssignedShipID(String assignedShipID) {
        this.assignedShipID = assignedShipID;
    }

    public String getAssignedShippingPortName() {
        return assignedShippingPortName;
    }

    public void setAssignedShippingPortName(String assignedShippingPortName) {
        this.assignedShippingPortName = assignedShippingPortName;
    }

}
