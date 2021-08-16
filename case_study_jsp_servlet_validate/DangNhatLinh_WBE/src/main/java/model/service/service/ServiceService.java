package model.service.service;

import model.bean.service.Service;

import java.util.List;

public interface ServiceService {
    List<Service> viewAllService();
    boolean createService(Service service);
}
