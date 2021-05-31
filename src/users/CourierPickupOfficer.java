package users;

import assets.Shipment;
import builtinclassextensions.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CourierPickupOfficer extends Employee {

    public CourierPickupOfficer() {
        
    }
    
    public CourierPickupOfficer(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, String name, String phoneNumber, String emailAddress) {
        super(designation, age, gender, streetAddress, salary, department, joinDate, shiftDays, shiftHours, name, phoneNumber, emailAddress);
    }

    public ObservableList<Shipment> loadActiveShipmentsList() {
        // load activeShipments from //customer-activeShipments.bin
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
                    activeShipments.add(tempShipment);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return activeShipments;
    }
    
    public void completeShipment(Shipment shipment) {
        File completedShipmentsFiles = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            completedShipmentsFiles = new File("src/databasefiles/customerfiles/customer-completedShipments.bin");
            if (completedShipmentsFiles.exists()) {
                fileOutputStream = new FileOutputStream(completedShipmentsFiles, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(completedShipmentsFiles);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(shipment);
        }
        catch (IOException ex) {
            Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void flagCourierAsIllegal(Shipment courier) {
        File illegalCourierFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            illegalCourierFile = new File("src/databasefiles/employeesfiles/illegal-couriers.bin");
            if (illegalCourierFile.exists()) {
                fileOutputStream = new FileOutputStream(illegalCourierFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(illegalCourierFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(courier);
        }
        catch (IOException ex) {
            Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Shipment> loadCompletedShipmentsList() {
        // load activeShipments from //customer-activeShipments.bin
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
                    completedShipments.add(tempShipment);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(CourierPickupOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return completedShipments;
    }
}
