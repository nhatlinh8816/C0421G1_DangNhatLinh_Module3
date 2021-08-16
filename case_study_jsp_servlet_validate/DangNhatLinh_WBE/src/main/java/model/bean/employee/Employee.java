package model.bean.employee;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeDOB;
    private String employeeIdentify;
    private double employeeSalary;
    private String employeePhoneNumber;
    private String employeeEmail;
    private String employeeAddress;
    private int employeePosition;
    private int employeeDegree;
    private int employeeDivision;
    private String employeeUserName;

    public Employee(int employeeId, String employeeName, String employeeDOB, String employeeIdentify, double employeeSalary, String employeePhoneNumber, String employeeEmail, String employeeAddress, int employeePosition, int employeeDegree, int employeeDivision, String employeeUserName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDOB = employeeDOB;
        this.employeeIdentify = employeeIdentify;
        this.employeeSalary = employeeSalary;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeDegree = employeeDegree;
        this.employeeDivision = employeeDivision;
        this.employeeUserName = employeeUserName;
    }

    public Employee(String employeeName, String employeeDOB, String employeeIdentify, double employeeSalary, String employeePhoneNumber, String employeeEmail, String employeeAddress, int employeePosition, int employeeDegree, int employeeDivision, String employeeUserName) {
        this.employeeName = employeeName;
        this.employeeDOB = employeeDOB;
        this.employeeIdentify = employeeIdentify;
        this.employeeSalary = employeeSalary;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeDegree = employeeDegree;
        this.employeeDivision = employeeDivision;
        this.employeeUserName = employeeUserName;
    }

    public Employee() {
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(String employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public String getEmployeeIdentify() {
        return employeeIdentify;
    }

    public void setEmployeeIdentify(String employeeIdentify) {
        this.employeeIdentify = employeeIdentify;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(int employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeDegree() {
        return employeeDegree;
    }

    public void setEmployeeDegree(int employeeDegree) {
        this.employeeDegree = employeeDegree;
    }

    public int getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(int employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

}
