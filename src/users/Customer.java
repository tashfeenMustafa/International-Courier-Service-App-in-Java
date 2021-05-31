package users;

import assets.Address;
import assets.Shipment;
import builtinclassextensions.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class Customer extends User {
    private String passportID;
    private int loginCount;
    
    public Customer() {
        passportID = "Please add a passport ID.";
        loginCount = 0;
    }

    public Customer(String passportID, int loginCount) {
        this.passportID = passportID;
        this.loginCount = loginCount;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }
    
    public Boolean hasPrimaryAddress() {
        return false;
    }
    
    public Address getsPrimaryAddress() {
        Address address = null;
        return address;
    }
    
    public void savePhoneNumberToDatabase() {
        // used to save phone number in customer-phonenumber.txt
        File customerPhoneNumbersFile = null;
        FileWriter fileWriter = null;
        
        try {
            customerPhoneNumbersFile = new File("src/databasefiles/customerfiles/customer-phonenumber.txt");
            
            if(customerPhoneNumbersFile.exists()) {
                fileWriter = new FileWriter(customerPhoneNumbersFile, true);
            }
            else {
                fileWriter = new FileWriter(customerPhoneNumbersFile);
            }
            
            fileWriter.write(this.getId() + ", " + this.getPhoneNumber());
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if(fileWriter != null) fileWriter.close();
            }
            catch(IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void savePassportIdToDatabase() {
        // this.savePassportIdToDatabase() is used to save passport id in customer-passportinfo.txt
        File customerPassportIdsFile = null;
        FileWriter fileWriter = null;
        
        try {
            customerPassportIdsFile = new File("src/databasefiles/customerfiles/customer-passportinfo.txt");
            
            if(customerPassportIdsFile.exists()) {
                fileWriter = new FileWriter(customerPassportIdsFile, true);
            }
            else {
                fileWriter = new FileWriter(customerPassportIdsFile);
            }
            
            fileWriter.write(this.getId() + ", " + passportID);
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if(fileWriter != null) fileWriter.close();
            }
            catch(IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void saveCustomerAddressToDatabase(Address address) {
        // save address to customer-addresses.txt
        File customerAddressesFile = null;
        FileWriter fileWriter = null;
        
        try {
            customerAddressesFile = new File("src/databasefiles/customerfiles/customer-addresses.txt");
            
            if(customerAddressesFile.exists()) {
                fileWriter = new FileWriter(customerAddressesFile, true);
            }
            else {
                fileWriter = new FileWriter(customerAddressesFile);
            }
            
            fileWriter.write(address.toString());
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if(fileWriter != null) fileWriter.close();
            }
            catch(IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void saveToAddressBook(Address address) {
        // save address in customer-addressbook.bin
        File addressBookFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            addressBookFile = new File("src/databasefiles/customerfiles/customer-addressbook.bin");
            if (addressBookFile.exists()) {
                fileOutputStream = new FileOutputStream(addressBookFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(addressBookFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(address);
        }
        catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Address> getAddressBookList() {
        ObservableList<Address> addressBook = FXCollections.observableArrayList();
        
        File addressBookFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            addressBookFile = new File("src/databasefiles/customerfiles/customer-addressbook.bin");
            fileInputStream = new FileInputStream(addressBookFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Address tempAddress = null;
            
            while(true) {
                try {
                    tempAddress = (Address) objectInputStream.readObject();
                    if(tempAddress.getAssociatedCustomerID() == this.getId()) {
                        addressBook.add(tempAddress);
                    }
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
       return addressBook;
    } 
    
    public void createActiveShipment(Shipment shipment) {
        // save shipment object in active-shipments.bin
        File activeShipmentFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            activeShipmentFile = new File("src/databasefiles/customerfiles/customer-activeShipments.bin");
            if (activeShipmentFile.exists()) {
                fileOutputStream = new FileOutputStream(activeShipmentFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(activeShipmentFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(shipment);
        }
        catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Shipment> getActiveShipmentsList() {
        ObservableList<Shipment> activeShipments = FXCollections.observableArrayList();
        
        File activeShipmentFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            activeShipmentFile = new File("src/databasefiles/customerfiles/customer-activeShipments.bin");
            fileInputStream = new FileInputStream(activeShipmentFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Shipment tempShipment = null;
            
            while(true) {
                try {
                    tempShipment = (Shipment) objectInputStream.readObject();
                    if(tempShipment.getAssociatedCustomerID() == this.getId()) {
                        activeShipments.add(tempShipment);
                    }
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return activeShipments;
    }
    
    public void createDraftShipment(Shipment shipment) {
        // save shipment object in active-shipments.bin
        File draftShipmentFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            draftShipmentFile = new File("src/databasefiles/customerfiles/customer-draftShipments.bin");
            if (draftShipmentFile.exists()) {
                fileOutputStream = new FileOutputStream(draftShipmentFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(draftShipmentFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(shipment);
        }
        catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Shipment> getDraftShipmentsList() {
        ObservableList<Shipment> draftShipments = FXCollections.observableArrayList();
        
        File draftShipmentFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            draftShipmentFile = new File("src/databasefiles/customerfiles/customer-draftShipments.bin");
            fileInputStream = new FileInputStream(draftShipmentFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Shipment tempShipment = null;
            
            while(true) {
                try {
                    tempShipment = (Shipment) objectInputStream.readObject();
                    if(tempShipment.getAssociatedCustomerID() == this.getId()) {
                        draftShipments.add(tempShipment);
                    }
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return draftShipments;
    }
    
    public ObservableList<Shipment> getCompletedShipmentsList() {
        ObservableList<Shipment> completedShipments = FXCollections.observableArrayList();
        
        File completedShipmentFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            completedShipmentFile = new File("src/databasefiles/customerfiles/customer-completedShipments.bin");
            fileInputStream = new FileInputStream(completedShipmentFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Shipment tempShipment = null;
            
            while(true) {
                try {
                    tempShipment = (Shipment) objectInputStream.readObject();
                    if(tempShipment.getAssociatedCustomerID() == this.getId()) {
                        completedShipments.add(tempShipment);
                    }
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return completedShipments;
    }
}
