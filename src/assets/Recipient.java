package assets;

import java.io.Serializable;

public class Recipient implements Serializable {
    private String name;
    private String phoneNumber;
    private Address address;
    
    public Recipient() {
        name = "";
        phoneNumber = "";
        address = null;
    }

    public Recipient(String name, String phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "," + phoneNumber + "," + address.toString();
    }

}
