package service.customer;

import model.bean.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImp;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImp();
    @Override
    public List<Customer> viewAllCustomer() {
        return customerRepository.viewAllCustomer();
    }

    @Override
    public boolean createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }
}
