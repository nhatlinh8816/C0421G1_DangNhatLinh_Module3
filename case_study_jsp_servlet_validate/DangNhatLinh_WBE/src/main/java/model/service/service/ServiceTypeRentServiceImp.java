package model.service.service;

import model.bean.service.ServiceTypeRent;
import model.repository.service.ServiceTypeRentRepository;
import model.repository.service.ServiceTypeRentRepositoryImp;

import java.util.List;

public class ServiceTypeRentServiceImp implements ServiceTypeRentService {
    ServiceTypeRentRepository serviceTypeRentRepository = new ServiceTypeRentRepositoryImp();
    @Override
    public List<ServiceTypeRent> viewAll() {
        return serviceTypeRentRepository.viewAll();
    }
}
