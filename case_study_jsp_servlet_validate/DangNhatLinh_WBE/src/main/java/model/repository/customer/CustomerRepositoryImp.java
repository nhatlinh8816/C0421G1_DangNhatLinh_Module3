package model.repository.customer;

import model.bean.customer.Customer;
import model.repository.BaseRepository;

import java.sql.CallableStatement;
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
            customer.setGenderCustomer(resultSet.getBoolean("khachhang_gender"));
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
                    ("insert  into khachhang(loaikhach_loaikhach_id,`khachhang_name`,`khachhang_gender`,`khachhang_code`,`khachhang_date_of_birth`,`khachhang_cmnd`,`khachhang_phone_number`,`khachhang_email`,`khachhang_address`)" +
                            "value (?,?,?,?,?,?,?,?,?)");
//            preparedStatement.setString(1,customer.getIdCustomer()+"");
            preparedStatement.setString(1,customer.getTypeCustomer()+"");
            preparedStatement.setString(2,customer.getNameCustomer()+"");
            preparedStatement.setBoolean(3,customer.isGenderCustomer());
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

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select khachhang_id,loaikhach_loaikhach_id,`khachhang_name`,`khachhang_gender`,`khachhang_code`," +
                    "`khachhang_date_of_birth`,`khachhang_cmnd`,`khachhang_phone_number`,`khachhang_email`,`khachhang_address` from khachhang where khachhang_id = ?");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("khachhang_id"));
                customer.setTypeCustomer(resultSet.getInt("loaikhach_loaikhach_id"));
                customer.setNameCustomer(resultSet.getString("khachhang_name"));
                customer.setGenderCustomer(resultSet.getBoolean("khachhang_gender"));
                customer.setCodeCustomer(resultSet.getString("khachhang_code"));
                customer.setDateOfBirthCustomer(resultSet.getString("khachhang_date_of_birth"));
                customer.setIdentifyCodeCustomer(resultSet.getString("khachhang_cmnd"));
                customer.setPhoneNumberCustomer(resultSet.getString("khachhang_phone_number"));
                customer.setEmailCustomer(resultSet.getString("khachhang_email"));
                customer.setAddressCustomer(resultSet.getString("khachhang_address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        int updateRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                        ("update khachhang set loaikhach_loaikhach_id = ?,khachhang_name = ?,khachhang_gender = ?,khachhang_code = ?,khachhang_date_of_birth = ?,khachhang_cmnd = ?,khachhang_phone_number = ?,khachhang_email = ?,`khachhang_address` = ?  where khachhang_id = ?");
            preparedStatement.setString(1,customer.getTypeCustomer()+"");
            preparedStatement.setString(2,customer.getNameCustomer());
            preparedStatement.setBoolean(3,customer.isGenderCustomer());
            preparedStatement.setString(4,customer.getCodeCustomer());
            preparedStatement.setString(5,customer.getDateOfBirthCustomer());
            preparedStatement.setString(6,customer.getIdentifyCodeCustomer());
            preparedStatement.setString(7,customer.getPhoneNumberCustomer());
            preparedStatement.setString(8,customer.getEmailCustomer());
            preparedStatement.setString(9,customer.getAddressCustomer());
            preparedStatement.setString(10,customer.getIdCustomer()+"");
            updateRow =preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateRow>0? true:false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        int deleteRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("delete from khachhang where khachhang_id = ? ");
            preparedStatement.setInt(1,id);
            deleteRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteRow>0? true:false;
    }

    @Override
    public List<Customer> findCustomer(String key) {
        List<Customer> customerListByKey = new ArrayList<>();
        try {
            CallableStatement callableStatement
                    = baseRepository.getConnection().prepareCall("call find_customer_by_name(?);");
            callableStatement.setString(1,key);
            ResultSet resultSet = callableStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()){
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("khachhang_id"));
                customer.setTypeCustomer(resultSet.getInt("loaikhach_loaikhach_id"));
                customer.setNameCustomer(resultSet.getString("khachhang_name"));
                customer.setGenderCustomer(resultSet.getBoolean("khachhang_gender"));
                customer.setCodeCustomer(resultSet.getString("khachhang_code"));
                customer.setDateOfBirthCustomer(resultSet.getString("khachhang_date_of_birth"));
                customer.setIdentifyCodeCustomer(resultSet.getString("khachhang_cmnd"));
                customer.setPhoneNumberCustomer(resultSet.getString("khachhang_phone_number"));
                customer.setEmailCustomer(resultSet.getString("khachhang_email"));
                customer.setAddressCustomer(resultSet.getString("khachhang_address"));
                customerListByKey.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerListByKey;
    }




}
