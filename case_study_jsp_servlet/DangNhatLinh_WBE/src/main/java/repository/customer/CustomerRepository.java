package repository.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> viewAllCustomer();
}
