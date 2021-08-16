package repository.customer;

import model.bean.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> viewAllCustomer();
    boolean createCustomer(Customer customer);
    Customer selectCustomer(int id);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> findCustomer(String key);
}
