package users;

import assets.businessproperties.Freight;
import assets.businessproperties.Ships;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class ShippingPortOfficer extends Employee {
   
    public ShippingPortOfficer(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, String name, String phoneNumber, String emailAddress) {
        super(designation, age, gender, streetAddress, salary, department, joinDate, shiftDays, shiftHours, name, phoneNumber, emailAddress);
    }
   
    public void addPartnerToShippingPort(Partner partner){}
    public ObservableList<Employee> getAllEmployees(){
        return null;
    }
    
    public void addFreightToPartner(Freight freight, Partner partner) {}
    public ObservableList<Freight> getAllFreightsUnderPartner(Partner partner) {
        return null;
    }
    
    public void addShipToPartner(Ships ship, Partner partner) {}
    public ObservableList<Ships> getAllShipsUnderPartner(Partner partner) {
        return null;
    }
    
    public void addRateAndQuoteForCountries(String country1, String country2) {}
}
