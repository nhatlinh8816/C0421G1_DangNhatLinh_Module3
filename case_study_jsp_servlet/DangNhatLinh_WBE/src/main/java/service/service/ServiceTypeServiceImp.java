package service.service;

import model.bean.service.ServiceType;
import repository.service.ServiceTypeRepository;
import repository.service.ServiceTypeRepositoryImp;

import java.util.List;

public class ServiceTypeServiceImp implements ServiceTypeService {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImp();
    @Override
    public List<ServiceType> viewAll() {
        return serviceTypeRepository.viewAll();
    }
}
