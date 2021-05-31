/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp;

import builtinclassextensions.AppendableObjectOutputStream;
import internationalcourierserviceapp.scenes.courierpickupofficers.CourierPickupOfficerHomeSceneFXMLDocumentController;
import internationalcourierserviceapp.scenes.customer.CustomerHomeSceneFXMLDocumentController;
import internationalcourierserviceapp.scenes.supplychainofficers.SupplyChainOfficerHomeSceneFXMLDocumentController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.CourierPickupOfficer;
import users.Customer;
import users.SupplyChainOfficer;
import users.User;

/**
 *
 * @author USER
 */
public class LoginAndSignInSceneFXMLDocumentController implements Initializable {

    private User user;
    private Customer customer;
    private CourierPickupOfficer courierPickupOfficer;
    private SupplyChainOfficer supplyChainOfficer;
    @FXML private Text signUpAsACustomerText;
    @FXML private TextField customerSignUpNameTextField;
    @FXML private TextField customerSignUpEmailTextField;
    @FXML private PasswordField customerSignUpPasswordTextField;
    @FXML private PasswordField customerSignUpRetypePasswordTextField;
    @FXML private Button customerSignUpButton;
    @FXML private Label signUpErrorText;
    @FXML private Text userLogInText;
    @FXML private SplitMenuButton selectUserTypeMenu;
    @FXML private MenuItem customerUserTypeMenuItem;
    @FXML private MenuItem courierPickupOfficerMenuItem;
    @FXML private MenuItem shippingPortOfficerMenuItem;
    @FXML private MenuItem warehouseManagementOfficerMenuItem;
    @FXML private Button userLoginButton;
    @FXML private TextField userLoginEmailTextField;
    @FXML private PasswordField userLoginPasswordTextField;
    @FXML private Label logInErrorText;
    @FXML private MenuItem supplyChainOfficerMenuItem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public Customer createCustomer(String name, String email, String password) {
        Customer newCustomer = null;
        
        newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setEmailAddress(email);
        newCustomer.setPassword(password);
        
        File customerDatabaseLoginDetailsFile = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream =  null;
        
        try {
            customerDatabaseLoginDetailsFile = new File("src/databasefiles/customerfiles/customer-login-details.bin");
            if (customerDatabaseLoginDetailsFile.exists()) {
                fileOutputStream = new FileOutputStream(customerDatabaseLoginDetailsFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                
            }
            else {
                fileOutputStream = new FileOutputStream(customerDatabaseLoginDetailsFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(newCustomer);
        }
        catch (IOException ex) {
            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            newCustomer = null;
        }
        finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close(); 
            }
            catch (IOException ex) {
                Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newCustomer;
    }
    
    private Boolean doesCustomerExistInDatabase(String emailAddress) {
        File customerDatabaseLoginDetailsFile = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        
        customerDatabaseLoginDetailsFile = new File("src/databasefiles/customerfiles/customer-login-details.bin");
        
        if (customerDatabaseLoginDetailsFile.exists()) {
            try {
            
                fileInputStream = new FileInputStream(customerDatabaseLoginDetailsFile);
                objectInputStream = new ObjectInputStream(fileInputStream);

                Customer tempCustomer = null;

                while (true) {
                    try {
                        tempCustomer = (Customer) objectInputStream.readObject();

                        if (tempCustomer.getEmailAddress().equals(emailAddress)) {
                            return true;
                        }
                    }
                    catch (EOFException ex) { break; }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            catch (IOException ex) {
                Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    @FXML
    private void onCustomerSignUpButtonClick(ActionEvent event) {
        String name = customerSignUpNameTextField.getText();
        String emailAddress = customerSignUpEmailTextField.getText();
        String password = customerSignUpPasswordTextField.getText();
        String retypePassword = customerSignUpRetypePasswordTextField.getText();
        
        Boolean isCustomerInDatabase = doesCustomerExistInDatabase(emailAddress); 
        
        if (isCustomerInDatabase) {
            signUpErrorText.setText("Customer account already exists.");
        }
        else {
            if (!password.equals(retypePassword)) {
                signUpErrorText.setText("Your passwords don't match.");
            }
            else {
                Customer newCustomer = createCustomer(name, emailAddress, password);
                signUpErrorText.setText("");

                if(newCustomer != null) {
                    // take customer to customer home scene
                    customerSignUpButton.setText("Sign up successful!");
                    Stage stage = null;

                    if(customerSignUpButton == event.getSource()){
                        stage = (Stage) customerSignUpButton.getScene().getWindow();
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/customer/CustomerHomeSceneFXMLDocument.fxml"));
                            Parent root = (Parent) loader.load();

                            //The following both lines are the only addition we need to pass the arguments
                            CustomerHomeSceneFXMLDocumentController customerHomeSceneController = loader.getController();
                            customerHomeSceneController.setCustomer(newCustomer);

                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } 
                else {
                    signUpErrorText.setText("Something went wrong. Try again.");
                }
            }
        }
    }

    @FXML
    private void onCustomerUserTypeMenuItemClick(ActionEvent event) {
        selectUserTypeMenu.setText("Customer");
    }

    @FXML
    private void onCourierPickupOfficerUserTypeMenuItemClick(ActionEvent event) {
        selectUserTypeMenu.setText("Courier Pickup Officer");
    }

    @FXML
    private void onSupplyChainOfficerUserTypeMenuItemClick(ActionEvent event) {
        selectUserTypeMenu.setText("Supply Chain Officer");
    }

    @FXML
    private void onShippingPortOfficerUserTypeMenuItemClick(ActionEvent event) {
        selectUserTypeMenu.setText("Shipping Port Officer");
    }

    @FXML
    private void onWarehouseManagementOfficerUserTypeMenuItemClick(ActionEvent event) {
        selectUserTypeMenu.setText("Warehouse Management Officer");
    }
    
    private Boolean checkEmailAndPassword(String userType, String emailAddress, String password) {
        
        
        switch (userType) {
            case "Customer":
                File userDatabaseLoginDetailsFile = null;
                FileInputStream fileInputStream = null;
                ObjectInputStream objectInputStream = null;
                userDatabaseLoginDetailsFile = new File("src/databasefiles/customerfiles/customer-login-details.bin");
                if (userDatabaseLoginDetailsFile.exists()) { 
                    try {
                        fileInputStream = new FileInputStream(userDatabaseLoginDetailsFile);
                        objectInputStream = new ObjectInputStream(fileInputStream);

                        Customer tempCustomer = null;

                        while (true) {
                            try {
                                tempCustomer = (Customer) objectInputStream.readObject();

                                if (tempCustomer.getEmailAddress().equals(emailAddress)) {
                                    if (tempCustomer.getPassword().equals(password)) {
                                        customer = tempCustomer;
                                        return true;
                                    }
                                }
                            }
                            catch (EOFException ex) { break; }
                            catch (ClassNotFoundException ex) {
                                Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    catch (IOException ex) {
                        Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                break;
            case "Courier Pickup Officer":
                Scanner sc; String str = null; String[] tokens;
                userDatabaseLoginDetailsFile = new File("src/databasefiles/employeesfiles/employee-login-details-file.txt");
            
                try {
                    sc = new Scanner(userDatabaseLoginDetailsFile);
                    
                    if(userDatabaseLoginDetailsFile.exists()) {
                        while(sc.hasNextLine()) {
                            str = sc.nextLine();
                            tokens = str.split(",");
                            
                            if(emailAddress.equals(tokens[2]) && password.equals(tokens[3])) {
                                courierPickupOfficer = new CourierPickupOfficer();
                                courierPickupOfficer.setDepartment(tokens[0]);
                                courierPickupOfficer.setName(tokens[1]);
                                courierPickupOfficer.setEmailAddress(tokens[2]);
                                courierPickupOfficer.setPassword(tokens[3]);
                                return true;
                            }
                        }
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                break;
            case "Supply Chain Officer":
                Scanner scanner; String string = null; String[] stringTokens;
                userDatabaseLoginDetailsFile = new File("src/databasefiles/employeesfiles/employee-login-details-file.txt");
            
                try {
                    scanner = new Scanner(userDatabaseLoginDetailsFile);
                    
                    if(userDatabaseLoginDetailsFile.exists()) {
                        while(scanner.hasNextLine()) {
                            string = scanner.nextLine();
                            stringTokens = string.split(",");
                            
                            if(emailAddress.equals(stringTokens[2]) && password.equals(stringTokens[3])) {
                                supplyChainOfficer = new SupplyChainOfficer();
                                supplyChainOfficer.setDepartment(stringTokens[0]);
                                supplyChainOfficer.setName(stringTokens[1]);
                                supplyChainOfficer.setEmailAddress(stringTokens[2]);
                                supplyChainOfficer.setPassword(stringTokens[3]);
                                return true;
                            }
                        }
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            /*
            case "Shipping Port Officer":
                try {
                    userDatabaseLoginDetailsFile = new File("src/databasefiles/shippingportofficerfiles/shippingportofficer-login-details.bin");
                    fileInputStream = new FileInputStream(userDatabaseLoginDetailsFile);
                    objectInputStream = new ObjectInputStream(fileInputStream);

                    ShippingPortOfficer shippingPortOfficer = null;

                    while (true) {
                        try {
                            shippingPortOfficer = (ShippingPortOfficer) objectInputStream.readObject();

                            if (shippingPortOfficer.getEmailAddress().equals(emailAddress)) {
                                if (shippingPortOfficer.getPassword().equals(password)) {
                                    user = shippingPortOfficer;
                                    return true;
                                }
                            }
                        }
                        catch (EOFException ex) { break; }
                        catch (ClassNotFoundException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Warehouse Management Officer":
                try {
                    userDatabaseLoginDetailsFile = new File("src/databasefiles/warehousemanagementofficerofficerfiles/warehousemanagementofficer-login-details.bin");
                    fileInputStream = new FileInputStream(userDatabaseLoginDetailsFile);
                    objectInputStream = new ObjectInputStream(fileInputStream);

                    WarehouseManagementOfficer warehouseManagementOfficer = null;

                    while (true) {
                        try {
                            warehouseManagementOfficer = (WarehouseManagementOfficer) objectInputStream.readObject();

                            if (warehouseManagementOfficer.getEmailAddress().equals(emailAddress)) {
                                if (warehouseManagementOfficer.getPassword().equals(password)) {
                                    user = warehouseManagementOfficer;
                                    return true;
                                }
                            }
                        }
                        catch (EOFException ex) { break; }
                        catch (ClassNotFoundException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            */

        }
        
        return false;
    }

    @FXML
    private void onLoginButtonClick(MouseEvent event) {
        String userType = selectUserTypeMenu.getText();
        String emailAddress = userLoginEmailTextField.getText();
        String password = userLoginPasswordTextField.getText();
        
        Boolean isUserEmailAndPasswordInDatabase = checkEmailAndPassword(userType, emailAddress, password);
        
        if (isUserEmailAndPasswordInDatabase) {
            // let user login
            userLoginButton.setText("Login successful!");
            Stage stage = null;
            
            switch (userType) {
                case "Customer":
                    if(userLoginButton == event.getSource()){
                        stage = (Stage) userLoginButton.getScene().getWindow();
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/customer/CustomerHomeSceneFXMLDocument.fxml"));
                            Parent root = (Parent) loader.load();

                            //The following both lines are the only addition we need to pass the arguments
                            CustomerHomeSceneFXMLDocumentController customerHomeSceneController = loader.getController();
                            customerHomeSceneController.setCustomer(customer);

                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Courier Pickup Officer":
                    if(userLoginButton == event.getSource()) {
                        stage = (Stage) userLoginButton.getScene().getWindow();
                        
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/courierpickupofficers/CourierPickupOfficerHomeSceneFXMLDocument.fxml"));
                            Parent root = (Parent) loader.load();
                            
                            CourierPickupOfficerHomeSceneFXMLDocumentController courierPickupOfficerHomeSceneController = loader.getController();
                            courierPickupOfficerHomeSceneController.setCourierPickupOfficer(courierPickupOfficer);
                            
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                        catch (IOException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Supply Chain Officer":
                    if(userLoginButton == event.getSource()) {
                        stage = (Stage) userLoginButton.getScene().getWindow();
                        
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/supplychainofficers/SupplyChainOfficerHomeSceneFXMLDocument.fxml"));
                            Parent root = (Parent) loader.load();
                            
                            SupplyChainOfficerHomeSceneFXMLDocumentController supplyChainOfficerHomeSceneController = loader.getController();
                            supplyChainOfficerHomeSceneController.setSupplyChainOfficer(supplyChainOfficer);
                            
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                        catch (IOException ex) {
                            Logger.getLogger(LoginAndSignInSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }
        }
        else {
            logInErrorText.setText("You do not have an account.");
        }
    }
    
}
