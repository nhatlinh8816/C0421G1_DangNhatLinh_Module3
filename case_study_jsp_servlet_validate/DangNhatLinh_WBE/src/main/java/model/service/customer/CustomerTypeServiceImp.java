package model.service.customer;

import model.bean.customer.CustomerType;
import model.repository.customer.CustomerTypeRepository;
import model.repository.customer.CustomerTypeRepositoryImp;

import java.util.List;

public class CustomerTypeServiceImp implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImp();

    @Override
    public List<CustomerType> viewAllCustomerType() {
        return customerTypeRepository.viewAllCustomerType();
    }
}
