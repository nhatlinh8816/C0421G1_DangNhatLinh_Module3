package service.customer;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import repository.customer.CustomerTypeRepository;
import repository.customer.CustomerTypeRepositoryImp;

import java.util.List;

public class CustomerTypeServiceImp implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImp();

    @Override
    public List<CustomerType> viewAllCustomerType() {
        return customerTypeRepository.viewAllCustomerType();
    }
}
