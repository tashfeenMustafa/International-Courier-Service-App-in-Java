package users;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee extends User {
    private String designation;
    private int age;
    private String gender;
    private String streetAddress;
    private double salary;
    private String department;
    private LocalDate joinDate;
    private ArrayList<String> shiftDays;
    private String shiftHours;
    private Boolean isActive;
    
    public Employee() {
        shiftDays = new ArrayList<>();
    }
    
    public Employee(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, String name, String phoneNumber, String emailAddress) {
        super(name, phoneNumber, emailAddress);
        this.designation = designation;
        this.age = age;
        this.gender = gender;
        this.streetAddress = streetAddress;
        this.salary = salary;
        this.department = department;
        this.joinDate = joinDate;
        this.shiftDays = shiftDays;
        this.shiftHours = shiftHours;
    }
    
    public Employee(String designation, int age, String gender, String streetAddress, double salary, String department, LocalDate joinDate, ArrayList<String> shiftDays, String shiftHours, Boolean isActive) {
        this.designation = designation;
        this.age = age;
        this.gender = gender;
        this.streetAddress = streetAddress;
        this.salary = salary;
        this.department = department;
        this.joinDate = joinDate;
        this.shiftDays = shiftDays;
        this.shiftHours = shiftHours;
        this.isActive = isActive;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public ArrayList<String> getShiftDays() {
        return shiftDays;
    }

    public void addShiftDays(String shiftDays) {
        this.shiftDays.add(shiftDays);
    }

    public String getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(String shiftHours) {
        this.shiftHours = shiftHours;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    
}
