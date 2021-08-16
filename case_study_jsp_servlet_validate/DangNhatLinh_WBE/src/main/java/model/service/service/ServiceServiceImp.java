package model.service.service;

import model.bean.service.Service;
import model.repository.service.ServiceRepository;
import model.repository.service.ServiceRepositoryImp;

import java.util.List;

public class ServiceServiceImp implements ServiceService {
    ServiceRepository serviceRepository = new ServiceRepositoryImp();
    @Override
    public List<Service> viewAllService() {
        return serviceRepository.viewAllService();
    }

    @Override
    public boolean createService(Service service) {
        return serviceRepository.createService(service);
    }
}
