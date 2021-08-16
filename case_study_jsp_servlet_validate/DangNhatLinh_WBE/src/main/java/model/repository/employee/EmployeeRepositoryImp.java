package model.repository.employee;

import model.bean.employee.Employee;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImp implements EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Employee> viewAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("select nhanvien_id, nhanvien_name, nhanvien_date_of_birth, " +
                            "nhanvien_cmnd, nhanvien_salary, nhanvien_phone_number, nhanvien_email, " +
                            "nhanvien_address, vitri_vitri_id, trinhdo_trinhdo_id, bophan_bophan_id, user_user_name from nhanvien ");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("nhanvien_id"));
                employee.setEmployeeName(resultSet.getString("nhanvien_name"));
                employee.setEmployeeDOB(resultSet.getString("nhanvien_date_of_birth"));
                employee.setEmployeeIdentify(resultSet.getString("nhanvien_cmnd"));
                employee.setEmployeeSalary(resultSet.getDouble("nhanvien_salary"));
                employee.setEmployeePhoneNumber(resultSet.getString("nhanvien_phone_number"));
                employee.setEmployeeEmail(resultSet.getString("nhanvien_email"));
                employee.setEmployeeAddress(resultSet.getString("nhanvien_address"));
                employee.setEmployeePosition(resultSet.getInt("vitri_vitri_id"));
                employee.setEmployeeDegree(resultSet.getInt("trinhdo_trinhdo_id"));
                employee.setEmployeeDivision(resultSet.getInt("bophan_bophan_id"));
                employee.setEmployeeUserName(resultSet.getString("user_user_name"));
                employeeList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
