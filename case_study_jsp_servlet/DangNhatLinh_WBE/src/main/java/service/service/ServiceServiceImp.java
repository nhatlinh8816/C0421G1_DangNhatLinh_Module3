package service.service;

import model.bean.service.Service;
import repository.service.ServiceRepository;
import repository.service.ServiceRepositoryImp;

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
