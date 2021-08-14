package repository.employee;

import model.bean.employee.Position;
import repository.BaseRepository;

import java.awt.image.RescaleOp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImp implements PositionRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> viewAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = baseRepository.getConnection().prepareStatement
                    ("select  vitri_id, vitri_name from vitri");
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position = null;
            while (resultSet.next()){
                position = new Position();
                position.setPositionId(resultSet.getInt("vitri_id"));
                position.setPositionName(resultSet.getString("vitri_name"));
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return positionList;
    }
}
