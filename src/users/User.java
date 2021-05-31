package users;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    
    public User() {
        id = UUID.randomUUID().hashCode();
        name = "Please add a name";
        phoneNumber = "Please add a phone number";
        emailAddress = "Please add an email address";
        password = "";
    }

    public User(String name, String phoneNumber, String emailAddress, String password) {
        id = UUID.randomUUID().hashCode();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }
    
    public User(String name, String email, String password) {
        this.name = name;
        this.emailAddress = email;
        this.password = password;
    }
    
    public int getId() {
        return id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //public abstract void setAddress(Address address) {}
    //public abstract Address getAddress() {}
}
