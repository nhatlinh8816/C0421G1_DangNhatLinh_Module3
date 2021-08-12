package model.bean.service;

public class ServiceTypeRent {
    private int serviceTypeRentId;
    private String serviceTypeRentName;

    public ServiceTypeRent(int serviceTypeRentId, String serviceTypeRentName) {
        this.serviceTypeRentId = serviceTypeRentId;
        this.serviceTypeRentName = serviceTypeRentName;
    }

    public ServiceTypeRent() {
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
}
