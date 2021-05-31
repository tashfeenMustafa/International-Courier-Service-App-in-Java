package internationalcourierserviceapp.scenes.courierpickupofficers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import users.CourierPickupOfficer;

public class CourierPickupOfficerHomeSceneFXMLDocumentController implements Initializable {

    private CourierPickupOfficer courierPickupOfficer;
    private Parent homeSceneRoot;
    private FXMLLoader loader;
    @FXML private BorderPane courierPickupOfficerHomeSceneBorderPane;
    @FXML private Button viewActiveCouriersButton;
    @FXML private Button viewCompletedCouriers;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUIAndPassCourierPickupOfficer("ViewActiveCouriersSceneFXMLDocument");
        courierPickupOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }    

    @FXML
    private void viewActiveCouriersButtonOnClick(MouseEvent event) {
        loadUIAndPassCourierPickupOfficer("ViewActiveCouriersSceneFXMLDocument");
        ViewActiveCouriersSceneFXMLDocumentController viewActiveCouriersSceneController = loader.getController();
        viewActiveCouriersSceneController.setCourierPickupOfficer(this.courierPickupOfficer);
        courierPickupOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }

    
    private void loadUIAndPassCourierPickupOfficer(String FXMLFile) {
        loader = new FXMLLoader(getClass().getResource(FXMLFile + ".fxml"));
        homeSceneRoot = null;
        try {
            homeSceneRoot = (Parent) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CourierPickupOfficerHomeSceneFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CourierPickupOfficer getCourierPickupOfficer() {
        return courierPickupOfficer;
    }

    public void setCourierPickupOfficer(CourierPickupOfficer courierPickupOfficer) {
        this.courierPickupOfficer = courierPickupOfficer;
        System.out.println(this.courierPickupOfficer.getName());
        //The following both lines are the only addition we need to pass the arguments
        ViewActiveCouriersSceneFXMLDocumentController viewActiveCouriersSceneController = loader.getController();
        viewActiveCouriersSceneController.setCourierPickupOfficer(this.courierPickupOfficer);
    }

    @FXML
    private void viewCompletedCouriersOnClick(MouseEvent event) {
        loadUIAndPassCourierPickupOfficer("ViewCompletedShipmentsSceneFXMLDocument");
        ViewCompletedShipmentsSceneFXMLDocumentController viewCompletedShipmentsSceneController = loader.getController();
        viewCompletedShipmentsSceneController.setCourierPickupOfficer(this.courierPickupOfficer);
        courierPickupOfficerHomeSceneBorderPane.setCenter(homeSceneRoot);
    }
    
}
