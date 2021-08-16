package model.repository.service;

import model.bean.service.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> viewAllService();
    boolean createService(Service service);
}
