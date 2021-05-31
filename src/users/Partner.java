package users;

import assets.Shipment;
import java.util.ArrayList;

class Partner {
    private String partnerName;
    private String partnerIndustry;
    private String partnerBusinessDetails;
    private String partnerOfficeAddress;
    private ArrayList<Shipment> shipments;

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerIndustry() {
        return partnerIndustry;
    }

    public void setPartnerIndustry(String partnerIndustry) {
        this.partnerIndustry = partnerIndustry;
    }

    public String getPartnerBusinessDetails() {
        return partnerBusinessDetails;
    }

    public void setPartnerBusinessDetails(String partnerBusinessDetails) {
        this.partnerBusinessDetails = partnerBusinessDetails;
    }

    public String getPartnerOfficeAddress() {
        return partnerOfficeAddress;
    }

    public void setPartnerOfficeAddress(String partnerOfficeAddress) {
        this.partnerOfficeAddress = partnerOfficeAddress;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }
   
   
}
