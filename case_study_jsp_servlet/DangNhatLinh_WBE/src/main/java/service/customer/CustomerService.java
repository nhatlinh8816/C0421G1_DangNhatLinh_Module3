package service.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> viewAllCustomer();
    boolean createCustomer(Customer customer);
    Customer selectCustomer(int id);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
}
