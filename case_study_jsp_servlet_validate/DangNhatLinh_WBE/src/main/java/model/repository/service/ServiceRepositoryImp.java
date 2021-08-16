package model.repository.service;

import model.bean.service.Service;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImp implements ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Service> viewAllService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("select dichvu_id, dichvu_name, dichvu_area, dichvu_chiphithue, dichvu_number_person,kieuthue_kieuthue_id,loai_dichvu_loai_dichvu_id, dichvu_tieuchuan, trangthai, dichvu_pool_area, dichvu_floor from dichvu ");
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;
            while (resultSet.next()){
                service = new Service();
                service.setId(resultSet.getInt("dichvu_id"));
                service.setName(resultSet.getString("dichvu_name"));
                service.setArea(resultSet.getInt("dichvu_area"));
                service.setCost(resultSet.getInt("dichvu_chiphithue"));
                service.setNumberPerson(resultSet.getInt("dichvu_number_person"));
                service.setTypeOfRentId(resultSet.getInt("kieuthue_kieuthue_id"));
                service.setTypeOfServiceId(resultSet.getInt("loai_dichvu_loai_dichvu_id"));
                service.setStandard(resultSet.getString("dichvu_tieuchuan"));
                service.setDescription(resultSet.getString("trangthai"));
                service.setPoolArea(resultSet.getDouble("dichvu_pool_area"));
                service.setFloor(resultSet.getInt("dichvu_floor"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean createService(Service service) {
        int createRow = 0;
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("insert into dichvu(dichvu_name, dichvu_area, dichvu_chiphithue, dichvu_number_person, kieuthue_kieuthue_id,loai_dichvu_loai_dichvu_id, dichvu_tieuchuan, trangthai, dichvu_pool_area, dichvu_floor) value (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getArea());
            preparedStatement.setDouble(3,service.getCost());
            preparedStatement.setInt(4,service.getNumberPerson());
            preparedStatement.setInt(5,service.getTypeOfRentId());
            preparedStatement.setInt(6,service.getTypeOfServiceId());
            preparedStatement.setString(7,service.getStandard());
            preparedStatement.setString(8,service.getDescription());
            preparedStatement.setDouble(9,service.getPoolArea());
            preparedStatement.setInt(10,service.getFloor());
            createRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createRow>0?true:false;
    }
}
