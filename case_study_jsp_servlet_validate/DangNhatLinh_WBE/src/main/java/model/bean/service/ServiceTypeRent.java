package model.bean.service;

public class ServiceTypeRent {
    private int serviceTypeRentId;
    private String serviceTypeRentName;
    private double serviceTypeRentCost;

    public ServiceTypeRent() {
    }

    public ServiceTypeRent(int serviceTypeRentId, String serviceTypeRentName, double serviceTypeRentCost) {
        this.serviceTypeRentId = serviceTypeRentId;
        this.serviceTypeRentName = serviceTypeRentName;
        this.serviceTypeRentCost = serviceTypeRentCost;
    }

    public int getServiceTypeRentId() {
        return serviceTypeRentId;
    }

    public void setServiceTypeRentId(int serviceTypeRentId) {
        this.serviceTypeRentId = serviceTypeRentId;
    }

    public String getServiceTypeRentName() {
        return serviceTypeRentName;
    }

    public void setServiceTypeRentName(String serviceTypeRentName) {
        this.serviceTypeRentName = serviceTypeRentName;
    }

    public double getServiceTypeRentCost() {
        return serviceTypeRentCost;
    }

    public void setServiceTypeRentCost(double serviceTypeRentCost) {
        this.serviceTypeRentCost = serviceTypeRentCost;
    }
}
