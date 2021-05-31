/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internationalcourierserviceapp.scenes.supplychainofficers;

import internationalcourierserviceapp.scenes.courierpickupofficers.CourierPickupOfficerHomeSceneFXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import users.SupplyChainOfficer;

public class SupplyChainOfficerHomeSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private Parent homeSceneRoot;
    private FXMLLoader loader;
    @FXML private BorderPane supplyChainOfficerHomeSceneBorderPane;
    @FXML private Button addAndViewEmployeeButton;
    @FXML private Button addAndViewFreightsButton;
    @FXML private Button addAndViewWarehouseButton;
    @FXML private Button addAndViewShippingPortButton;
    @FXML private Button addAndViewShipsButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUIAndPassSupplyChainOfficer("AddViewEmployeeSceneFXMLDocument");
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }    

    public SupplyChainOfficer getSupplyChainOfficer() {
        return supplyChainOfficer;
    }

    public void setSupplyChainOfficer(SupplyChainOfficer supplyChainOfficer) {
        this.supplyChainOfficer = supplyChainOfficer;
        System.out.println(this.supplyChainOfficer.getName());
        //The following both lines are the only addition we need to pass the arguments
        AddViewEmployeeSceneFXMLDocumentController addViewEmployeeSceneController = loader.getController();
        addViewEmployeeSceneController.setSupplyChainOfficer(this.supplyChainOfficer);
    }
    
    private void loadUIAndPassSupplyChainOfficer(String FXMLFile) {
        loader = new FXMLLoader(getClass().getResource(FXMLFile + ".fxml"));
        homeSceneRoot = null;
        try {
            homeSceneRoot = (Parent) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CourierPickupOfficerHomeSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addAndViewEmployeeButtonOnClick(MouseEvent event) {
        loadUIAndPassSupplyChainOfficer("AddViewEmployeeSceneFXMLDocument");
        AddViewEmployeeSceneFXMLDocumentController addViewEmployeeSceneController = loader.getController();
        addViewEmployeeSceneController.setSupplyChainOfficer(supplyChainOfficer);
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void addAndViewFreightsButtonOnClick(MouseEvent event) {
        loadUIAndPassSupplyChainOfficer("AddViewFreightSceneFXMLDocument");
        AddViewFreightSceneFXMLDocumentController addViewFreightSceneController = loader.getController();
        addViewFreightSceneController.setSupplyChainOfficer(supplyChainOfficer);
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void addAndViewWarehouseButtonOnClick(MouseEvent event) {
        loadUIAndPassSupplyChainOfficer("AddViewWarehouseSceneFXMLDocument");
        AddViewWarehouseSceneFXMLDocumentController addViewWarehouseSceneController = loader.getController();
        addViewWarehouseSceneController.setSupplyChainOfficer(supplyChainOfficer);
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void addAndViewShippingPortButtonOnClick(MouseEvent event) {
        loadUIAndPassSupplyChainOfficer("AddViewShippingPortSceneFXMLDocument");
        AddViewShippingPortSceneFXMLDocumentController addViewShippingPortSceneController = loader.getController();
        addViewShippingPortSceneController.setSupplyChainOfficer(supplyChainOfficer);
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    @FXML
    private void addAndViewShipsButtonOnClick(MouseEvent event) {
        loadUIAndPassSupplyChainOfficer("AddViewShipsSceneFXMLDocument");
        AddViewShipsSceneFXMLDocumentController addViewShipsSceneController = loader.getController();
        addViewShipsSceneController.setSupplyChainOfficer(supplyChainOfficer);
        supplyChainOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }
    
}
