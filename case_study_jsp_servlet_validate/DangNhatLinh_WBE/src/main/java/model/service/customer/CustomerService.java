package model.service.customer;

import model.bean.customer.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> viewAllCustomer();
    Map<String,String> createCustomer(Customer customer);
    Customer selectCustomer(int id);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> findCustomer(String key);
}
