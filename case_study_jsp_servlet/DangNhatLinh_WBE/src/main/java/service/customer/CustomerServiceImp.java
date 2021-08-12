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

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
