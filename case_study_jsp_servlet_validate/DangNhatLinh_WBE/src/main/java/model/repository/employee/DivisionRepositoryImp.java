package model.repository.employee;

import model.bean.employee.Division;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImp implements DivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Division> viewAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("select bophan_id, bophan_name from bophan");
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division = null;
            while (resultSet.next()){
                division = new Division();
                division.setDivisionId(resultSet.getInt("bophan_id"));
                division.setDivisionName(resultSet.getString("bophan_name"));
                divisionList.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return divisionList;
    }
}
