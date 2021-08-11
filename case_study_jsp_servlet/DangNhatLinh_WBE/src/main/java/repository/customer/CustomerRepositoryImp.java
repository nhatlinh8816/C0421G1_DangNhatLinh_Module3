package repository.customer;

import model.bean.Customer;
import repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImp implements CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> viewAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("select khachhang_id,loaikhach_loaikhach_id,`khachhang_name`,`khachhang_gender`,`khachhang_code`,`khachhang_date_of_birth`,`khachhang_cmnd`,`khachhang_phone_number`,`khachhang_email`,`khachhang_address` from khachhang;");
            ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        while (resultSet.next()){
            customer = new Customer();
            customer.setIdCustomer(resultSet.getInt("khachhang_id"));
            customer.setTypeCustomer(resultSet.getInt("loaikhach_loaikhach_id"));
            customer.setNameCustomer(resultSet.getString("khachhang_name"));
            customer.setGenderCustomer(resultSet.getInt("khachhang_gender"));
            customer.setCodeCustomer(resultSet.getString("khachhang_code"));
            customer.setDateOfBirthCustomer(resultSet.getString("khachhang_date_of_birth"));
            customer.setIdentifyCodeCustomer(resultSet.getString("khachhang_cmnd"));
            customer.setPhoneNumberCustomer(resultSet.getString("khachhang_phone_number"));
            customer.setEmailCustomer(resultSet.getString("khachhang_email"));
            customer.setAddressCustomer(resultSet.getString("khachhang_address"));
            customerList.add(customer);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        int createRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("insert  into khachhang(khachhang_id,loaikhach_loaikhach_id,`khachhang_name`,`khachhang_gender`,`khachhang_code`,`khachhang_date_of_birth`,`khachhang_cmnd`,`khachhang_phone_number`,`khachhang_email`,`khachhang_address`)" +
                            "value (?,?,?,?,?,?,?,?,?,?,?)");
//            preparedStatement.setString(1,customer.getIdCustomer()+"");
            preparedStatement.setString(1,customer.getTypeCustomer()+"");
            preparedStatement.setString(2,customer.getNameCustomer()+"");
            preparedStatement.setString(3,customer.getGenderCustomer()+"");
            preparedStatement.setString(4,customer.getCodeCustomer()+"");
            preparedStatement.setString(5,customer.getDateOfBirthCustomer()+"");
            preparedStatement.setString(6,customer.getIdentifyCodeCustomer()+"");
            preparedStatement.setString(7,customer.getPhoneNumberCustomer()+"");
            preparedStatement.setString(8,customer.getEmailCustomer()+"");
            preparedStatement.setString(9,customer.getAddressCustomer()+"");
            System.out.println(customer);
            createRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createRow>0? true:false;
    }
}
