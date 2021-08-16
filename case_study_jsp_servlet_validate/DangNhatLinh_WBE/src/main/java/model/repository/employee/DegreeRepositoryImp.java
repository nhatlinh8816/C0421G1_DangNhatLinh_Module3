package model.repository.employee;

import model.bean.employee.Degree;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DegreeRepositoryImp implements DegreeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Degree> viewAllDegree() {
        List<Degree> degreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement("select trinhdo_id, trinhdo_name from trinhdo");
            ResultSet resultSet = preparedStatement.executeQuery();
            Degree degree =null;
            while (resultSet.next()){
                degree = new Degree();
                degree.setDegreeId(resultSet.getInt("trinhdo_id"));
                degree.setDegreeName(resultSet.getString("trinhdo_name"));
                degreeList.add(degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }
}
