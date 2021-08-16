package model.repository.employee;

import model.bean.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> viewAllEmployee();
}
