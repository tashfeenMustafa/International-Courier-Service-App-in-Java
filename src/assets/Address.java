package assets;

import java.io.Serializable;

public class Address implements Serializable {
    private int associatedCustomerID;
    private String title;
    private String country;
    private String cityOrTown;
    private String districtOrState;
    private String streetAddress;
    private String postalCode;

    public Address() {
        associatedCustomerID = 0;
        title = "";
        country = "";
        cityOrTown = "";
        districtOrState = "";
        streetAddress = "";
        postalCode = "";
    }

    public Address(int associatedCustomerID, String country, String cityOrTown, String districtOrState, String streetAddress, String postalCode) {
        this.associatedCustomerID = associatedCustomerID;
        this.country = country;
        this.cityOrTown = cityOrTown;
        this.districtOrState = districtOrState;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }

    public Address(String title, String country, String cityOrTown, String districtOrState, String streetAddress, String postalCode) {
        this.title = title;
        this.country = country;
        this.cityOrTown = cityOrTown;
        this.districtOrState = districtOrState;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }

    public Address(int associatedCustomerID, String title, String country, String cityOrTown, String districtOrState, String streetAddress, String postalCode) {
        this.associatedCustomerID = associatedCustomerID;
        this.title = title;
        this.country = country;
        this.cityOrTown = cityOrTown;
        this.districtOrState = districtOrState;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getAssociatedCustomerID() {
        return associatedCustomerID;
    }

    public void setAssociatedCustomerID(int associatedCustomerID) {
        this.associatedCustomerID = associatedCustomerID;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getDistrictOrState() {
        return districtOrState;
    }

    public void setDistrictOrState(String districtOrState) {
        this.districtOrState = districtOrState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return associatedCustomerID  + "," + title + "," + country + "," + cityOrTown + "," + districtOrState + "," + streetAddress + "," + postalCode;
    }
    
}
