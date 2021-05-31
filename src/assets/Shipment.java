package assets;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
import users.CourierPickupOfficer;

public class Shipment implements Serializable {
    private String name;
    private String description;
    private double weight;
    private double length;
    private double height;
    private double width;
    private Recipient recipient;
    private int associatedCustomerID;
    private LocalDate estimatedDeliveryDate;
    private LocalDate estimatedPickupDate;
    private LocalTime estimatedPickupTime;
    private Boolean isPickupConfirmed;
    private double shippingCost;
    private String trackingID;
    private String currentLocation;
    private Boolean isDeliveryComplete;
    private Boolean isWarehouseDelivery;
    private Boolean isShippingPortDelivery;
    private Boolean isFlagged;
    
    public Shipment() {
        trackingID = UUID.randomUUID().toString();
        name = "";
        description = "";
        weight = 0.0;
        length = 0.0;
        height = 0.0;
        width = 0.0;
        associatedCustomerID = 0;
        estimatedDeliveryDate = null;
        estimatedPickupDate = null;
        estimatedPickupTime = null;
        isPickupConfirmed = false;
        shippingCost = 0.0;
        currentLocation = null;
        isDeliveryComplete = false;
        isWarehouseDelivery = false;
        isShippingPortDelivery = false;
    }

    public Shipment(String name, String description, double weight, double length, double height, double width, Recipient recipient, int associatedCustomerID, LocalDate estimatedPickupDate, LocalTime estimatedPickupTime) {
        this();
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.recipient = recipient;
        this.associatedCustomerID = associatedCustomerID;
        this.estimatedPickupDate = estimatedPickupDate;
        this.estimatedPickupTime = estimatedPickupTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public int getAssociatedCustomerID() {
        return associatedCustomerID;
    }

    public void setAssociatedCustomerID(int associatedCustomerID) {
        this.associatedCustomerID = associatedCustomerID;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDate getEstimatedPickupDate() {
        return estimatedPickupDate;
    }

    public void setEstimatedPickupDate(LocalDate estimatedPickupDate) {
        this.estimatedPickupDate = estimatedPickupDate;
    }

    public LocalTime getEstimatedPickupTime() {
        return estimatedPickupTime;
    }

    public void setEstimatedPickupTime(LocalTime estimatedPickupTime) {
        this.estimatedPickupTime = estimatedPickupTime;
    }
    
    public String getPickupDateTime() {
        String pickupDateTime = estimatedPickupDate.toString() + ", " + estimatedPickupTime.toString();
        return pickupDateTime;
    }

    public Boolean getIsPickupConfirmed() {
        return isPickupConfirmed;
    }

    public void setIsPickupConfirmed(Boolean isPickupConfirmed) {
        this.isPickupConfirmed = isPickupConfirmed;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getIsDeliveryComplete() {
        return isDeliveryComplete;
    }

    public void setIsDeliveryComplete(Boolean isDeliveryComplete) {
        this.isDeliveryComplete = isDeliveryComplete;
    }

    public Boolean getIsWarehouseDelivery() {
        return isWarehouseDelivery;
    }

    public void setIsWarehouseDelivery(Boolean isWarehouseDelivery) {
        this.isWarehouseDelivery = isWarehouseDelivery;
    }

    public Boolean getIsShippingPortDelivery() {
        return isShippingPortDelivery;
    }

    public void setIsShippingPortDelivery(Boolean isShippingPortDelivery) {
        this.isShippingPortDelivery = isShippingPortDelivery;
    }
    
    public void updateCurrentLocation() {
        if(!isPickupConfirmed) {
            setCurrentLocation("With Customer");
        }
        else if (isWarehouseDelivery) {
            setCurrentLocation("On route to warehouse");
        }
        else if(isShippingPortDelivery) {
            setCurrentLocation("On route to shippingPort");
        }
        else if(isDeliveryComplete) {
            setCurrentLocation("Delivered");
        }
    }
    
    public void calculateEstimatedDeliveryDateTime() {
        estimatedDeliveryDate = estimatedPickupDate.plusDays(20);
    }
    
    public void calculateShippingCost() {
        double minimumFee = 25.0;
        double pickupCharge = 40.0;
        double deliveryCharge = 50.0;
        shippingCost = minimumFee + pickupCharge + deliveryCharge;
    }

    public Boolean getIsFlagged() {
        return isFlagged;
    }

    public void setIsFlagged(Boolean isFlagged) {
        this.isFlagged = isFlagged;
    }
    
}
