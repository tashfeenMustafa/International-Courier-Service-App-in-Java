package users;

import assets.businesslocations.ShippingPort;
import assets.businesslocations.Warehouse;
import assets.businessproperties.Freight;
import assets.businessproperties.Ships;
import builtinclassextensions.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupplyChainOfficer extends Employee {

    public SupplyChainOfficer() {
        
    }
    
    public SupplyChainOfficer(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, String name, String phoneNumber, String emailAddress) {
        super(designation, age, gender, streetAddress, salary, department, joinDate, shiftDays, shiftHours, name, phoneNumber, emailAddress);
    }

    public ObservableList<Employee> getEmployeesList() {
        ObservableList<Employee> allEmployees = FXCollections.observableArrayList();
        
        File employeesDetailsFiles = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            employeesDetailsFiles = new File("src/databasefiles/employeesfiles/employee-details.bin");
            fileInputStream = new FileInputStream(employeesDetailsFiles);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Employee newEmployee = null;
            
            while(true) {
                try {
                    newEmployee = (Employee) objectInputStream.readObject();
                    allEmployees.add(newEmployee);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allEmployees;
    }
    
    public void addEmployeeToDatabase(Employee employee) {
        File employeesDetailsFiles = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            employeesDetailsFiles = new File("src/databasefiles/employeesfiles/employee-details.bin");
            if (employeesDetailsFiles.exists()) {
                fileOutputStream = new FileOutputStream(employeesDetailsFiles, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(employeesDetailsFiles);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(employee);
        }
        catch (IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Freight> getFreightsList() {
        ObservableList<Freight> allFreights = FXCollections.observableArrayList();
        
        File freightsDetailsFiles = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            freightsDetailsFiles = new File("src/databasefiles/employeesfiles/freights-details.bin");
            fileInputStream = new FileInputStream(freightsDetailsFiles);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Freight newFreight = null;
            
            while(true) {
                try {
                    newFreight = (Freight) objectInputStream.readObject();
                    allFreights.add(newFreight);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allFreights;
    }
    
    public void addFreightToDatabase(Freight freight) {
        File freightsDetailsFiles = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            freightsDetailsFiles = new File("src/databasefiles/employeesfiles/freights-details.bin");
            if (freightsDetailsFiles.exists()) {
                fileOutputStream = new FileOutputStream(freightsDetailsFiles, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(freightsDetailsFiles);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(freight);
        }
        catch (IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Warehouse> getWarehouseList() {
        ObservableList<Warehouse> allWarehouses = FXCollections.observableArrayList();
        
        File warehouseDetailsFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            warehouseDetailsFile = new File("src/databasefiles/employeesfiles/warehouse-details.bin");
            fileInputStream = new FileInputStream(warehouseDetailsFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Warehouse newWarehouse = null;
            
            while(true) {
                try {
                    newWarehouse = (Warehouse) objectInputStream.readObject();
                    allWarehouses.add(newWarehouse);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allWarehouses;
    }
    
    public void addWarehouseToDatabase(Warehouse warehouse) {
        File warehouseDetailsFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            warehouseDetailsFile = new File("src/databasefiles/employeesfiles/warehouse-details.bin");
            if (warehouseDetailsFile.exists()) {
                fileOutputStream = new FileOutputStream(warehouseDetailsFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(warehouseDetailsFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(warehouse);
        }
        catch (IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<ShippingPort> getShippingPortList() {
        ObservableList<ShippingPort> allShippingPorts = FXCollections.observableArrayList();
        
        File shippingPortDetailsFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            shippingPortDetailsFile = new File("src/databasefiles/employeesfiles/shipping-port-details.bin");
            fileInputStream = new FileInputStream(shippingPortDetailsFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            ShippingPort shippingPort = null;
            
            while(true) {
                try {
                    shippingPort = (ShippingPort) objectInputStream.readObject();
                    allShippingPorts.add(shippingPort);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allShippingPorts;
    }
    
    public void addShippingPortToDatabase(ShippingPort shippingPort) {
        File shippingPortDetailsFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            shippingPortDetailsFile = new File("src/databasefiles/employeesfiles/shipping-port-details.bin");
            if (shippingPortDetailsFile.exists()) {
                fileOutputStream = new FileOutputStream(shippingPortDetailsFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(shippingPortDetailsFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(shippingPort);
        }
        catch (IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ObservableList<Ships> getShipsList() {
        ObservableList<Ships> allShips = FXCollections.observableArrayList();
        
        File shipsDetailsFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            shipsDetailsFile = new File("src/databasefiles/employeesfiles/ships-details.bin");
            fileInputStream = new FileInputStream(shipsDetailsFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            Ships ship = null;
            
            while(true) {
                try {
                    ship = (Ships) objectInputStream.readObject();
                    allShips.add(ship);
                }
                catch(IOException ex) {
                    break;
                }
                catch(ClassNotFoundException ex) {
                    Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(objectInputStream != null) try {
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allShips;
    }
    
    public void addShipsToDatabase(Ships ships) {
        File shipsDetailsFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        try {
            shipsDetailsFile = new File("src/databasefiles/employeesfiles/ships-details.bin");
            if (shipsDetailsFile.exists()) {
                fileOutputStream = new FileOutputStream(shipsDetailsFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(shipsDetailsFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(ships);
        }
        catch (IOException ex) {
            Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(SupplyChainOfficer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
