package model.bean.service;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int numberPerson;
    private int typeOfRentId;
    private int typeOfServiceId;
    private String standard;
    private String description;
    private double poolArea;
    private int floor;

    public Service(int id, String name, int area, double cost, int numberPerson, int typeOfRentId, int typeOfServiceId, String standard, String description, double poolArea, int floor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberPerson = numberPerson;
        this.typeOfRentId = typeOfRentId;
        this.typeOfServiceId = typeOfServiceId;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Service(String name, int area, double cost, int numberPerson, int typeOfRentId, int typeOfServiceId, String standard, String description, double poolArea, int floor) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberPerson = numberPerson;
        this.typeOfRentId = typeOfRentId;
        this.typeOfServiceId = typeOfServiceId;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public int getTypeOfRentId() {
        return typeOfRentId;
    }

    public void setTypeOfRentId(int typeOfRentId) {
        this.typeOfRentId = typeOfRentId;
    }

    public int getTypeOfServiceId() {
        return typeOfServiceId;
    }

    public void setTypeOfServiceId(int typeOfServiceId) {
        this.typeOfServiceId = typeOfServiceId;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
