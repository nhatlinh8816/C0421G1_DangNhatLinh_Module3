package model.service.customer;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepository;
import model.repository.customer.CustomerRepositoryImp;
import model.service.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImp();
    @Override
    public List<Customer> viewAllCustomer() {
        return customerRepository.viewAllCustomer();
    }

    @Override
    public Map<String, String> createCustomer(Customer customer) {
        Map<String, String> stringMap = new HashMap<>();
        if (Validate.validateName(customer.getNameCustomer())!=null){
            stringMap.put("name",Validate.validateName(customer.getNameCustomer()));
        }else {
            customerRepository.createCustomer(customer);
        }
        return stringMap;
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

    @Override
    public List<Customer> findCustomer(String key) {
        return customerRepository.findCustomer(key);
    }
}
