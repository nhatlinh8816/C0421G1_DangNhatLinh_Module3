package repository.customer;

import model.bean.customer.CustomerType;
import repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImp implements CustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<CustomerType> viewAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select loaikhach_id, loaikhach_name from loaikhach");
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()){
                customerType = new CustomerType();
                customerType.setIdCustomerType(resultSet.getInt("loaikhach_id"));
                customerType.setNameCustomerType(resultSet.getString("loaikhach_name"));
                customerTypeList.add(customerType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}
