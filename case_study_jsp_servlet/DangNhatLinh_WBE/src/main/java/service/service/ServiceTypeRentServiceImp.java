package service.service;

import model.bean.service.ServiceTypeRent;
import repository.service.ServiceTypeRentRepository;
import repository.service.ServiceTypeRentRepositoryImp;

import java.util.List;

public class ServiceTypeRentServiceImp implements ServiceTypeRentService {
    ServiceTypeRentRepository serviceTypeRentRepository = new ServiceTypeRentRepositoryImp();
    @Override
    public List<ServiceTypeRent> viewAll() {
        return serviceTypeRentRepository.viewAll();
    }
}
