package model.repository.service;

import model.bean.service.ServiceType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImp implements ServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceType> viewAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select loai_dichvu_id,loai_dichvu_name from loai_dichvu");
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceType serviceType = null;
            while (resultSet.next()){
                serviceType = new ServiceType();
                serviceType.setServiceTypeId(resultSet.getInt("loai_dichvu_id"));
                serviceType.setServiceTypeName(resultSet.getString("loai_dichvu_name"));
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
