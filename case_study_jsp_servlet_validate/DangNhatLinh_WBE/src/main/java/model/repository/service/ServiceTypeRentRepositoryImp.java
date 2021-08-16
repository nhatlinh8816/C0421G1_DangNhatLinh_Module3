package model.repository.service;

import model.bean.service.ServiceTypeRent;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRentRepositoryImp implements  ServiceTypeRentRepository{
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceTypeRent> viewAll() {
        List<ServiceTypeRent> serviceTypeRentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select kieuthue_id, kieuthue_name, kieuthue_gia from kieuthue");
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceTypeRent serviceTypeRent = null;
            while (resultSet.next()){
                serviceTypeRent = new ServiceTypeRent();
                serviceTypeRent.setServiceTypeRentId(resultSet.getInt("kieuthue_id"));
                serviceTypeRent.setServiceTypeRentName(resultSet.getString("kieuthue_name"));
                serviceTypeRent.setServiceTypeRentCost(resultSet.getDouble("kieuthue_gia"));
                serviceTypeRentList.add(serviceTypeRent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return serviceTypeRentList;
    }
}
