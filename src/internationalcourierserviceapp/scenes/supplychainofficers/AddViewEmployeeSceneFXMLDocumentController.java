package internationalcourierserviceapp.scenes.supplychainofficers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import users.Employee;
import users.SupplyChainOfficer;

public class AddViewEmployeeSceneFXMLDocumentController implements Initializable {

    private SupplyChainOfficer supplyChainOfficer;
    private ObservableList<Employee> allEmployees;
    @FXML private TextField nameTextField;
    @FXML private TextField designationTextField;
    @FXML private TextField ageTextField;
    @FXML private RadioButton maleRadioButton;
    @FXML private RadioButton femaleRadioButton;
    @FXML private RadioButton transRadioButton;
    @FXML private TextField contactNumberTextField;
    @FXML private TextField emailAddressTextField;
    @FXML private TextField streetAddressTextField;
    @FXML private TextField shiftHoursTextField;
    @FXML private CheckBox saturdayCheckBox;
    @FXML private CheckBox sundayCheckBox;
    @FXML private CheckBox mondayCheckBox;
    @FXML private CheckBox tuesdayCheckBox;
    @FXML private CheckBox wednesdayCheckBox;
    @FXML private CheckBox thursdayCheckBox;
    @FXML private CheckBox fridayCheckBox;
    @FXML private DatePicker joinDateDatePicker;
    @FXML private TextField salaryTextField;
    @FXML private ComboBox<String> departmentComboBox;
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> designationColumn;
    @FXML private TableColumn<Employee, Integer> ageColumn;
    @FXML private TableColumn<Employee, String> genderColumn;
    @FXML private TableColumn<Employee, String> contactNumberColumn;
    @FXML private TableColumn<Employee, String> emailColumn;
    @FXML private TableColumn<Employee, String> streetAddressColumn;
    @FXML private TableColumn<Employee, String> shiftHourColumn;
    @FXML private TableColumn<Employee, ArrayList<String>> shiftDaysColumn;
    @FXML private TableColumn<Employee, LocalDate> joinDateColumn;
    @FXML private TableColumn<Employee, Double> salaryColumn;
    @FXML private TableColumn<Employee, String> departmentColumn;
    @FXML private Button updateTable;
    @FXML private Button addEmployeeButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAndSetComboBoxItems();
        allEmployees = FXCollections.observableArrayList();
    }    
    
    public void loadAndSetComboBoxItems() {
        departmentComboBox.getItems().clear();
        departmentComboBox.getItems().addAll(
                "Supply Chain",
                "Warehousing",
                "Couriers",
                "Shipping",
                "HR",
                "IT Maintenance"
        );
    }
    
    public SupplyChainOfficer getSupplyChainOfficer() {
        return supplyChainOfficer;
    }

    public void setSupplyChainOfficer(SupplyChainOfficer supplyChainOfficer) {
        this.supplyChainOfficer = supplyChainOfficer;
    }

    @FXML
    private void maleRadioButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void femaleRadioButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void transRadioButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void saturdayCheckBoxOnClick(MouseEvent event) {
    }

    @FXML
    private void updateTableOnClick(MouseEvent event) {
        allEmployees = supplyChainOfficer.getEmployeesList();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));
        shiftHourColumn.setCellValueFactory(new PropertyValueFactory<>("shiftHours"));
        shiftDaysColumn.setCellValueFactory(new PropertyValueFactory<>("shiftDays"));
        joinDateColumn.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        
        employeeTable.setItems(allEmployees);
    }

    @FXML
    private void addEmployeeButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String designation = designationTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        String gender = getGender();
        String contactNumber = contactNumberTextField.getText();
        String email = emailAddressTextField.getText();
        String streetAddress = streetAddressTextField.getText();
        String shiftHours = shiftHoursTextField.getText();
        ArrayList<String> shiftDays = getShiftDays();
        LocalDate joinDate = joinDateDatePicker.getValue();
        double salary = Double.parseDouble(salaryTextField.getText());
        String department = departmentComboBox.getValue();
        
        Employee addEmployee = new Employee(designation, age, gender, streetAddress, salary, department, joinDate, shiftDays, shiftHours, name, contactNumber, email);
        supplyChainOfficer.addEmployeeToDatabase(addEmployee);
    }
    
    String getGender() {
        if(maleRadioButton.isSelected()) {
            return maleRadioButton.getText();
        }
        else if(femaleRadioButton.isSelected()) {
            return femaleRadioButton.getText();
        }
        else if(transRadioButton.isSelected()){
            return transRadioButton.getText();
        }
        return "No Gender";
    }
    
    ArrayList<String> getShiftDays() {
        ArrayList<String> shiftDays = new ArrayList<>();
        
        if(saturdayCheckBox.isSelected()) {
            shiftDays.add(saturdayCheckBox.getText());
        }
        else if(sundayCheckBox.isSelected()) {
            shiftDays.add(sundayCheckBox.getText());
        }
        else if(mondayCheckBox.isSelected()) {
            shiftDays.add(mondayCheckBox.getText());
        }
        else if(tuesdayCheckBox.isSelected()) {
            shiftDays.add(tuesdayCheckBox.getText());
        }
        else if(wednesdayCheckBox.isSelected()) {
            shiftDays.add(wednesdayCheckBox.getText());
        }
        else if(thursdayCheckBox.isSelected()) {
            shiftDays.add(thursdayCheckBox.getText());
        }
        else if(fridayCheckBox.isSelected()) {
            shiftDays.add(fridayCheckBox.getText());
        }
        
        return shiftDays;
    }
}
