package model.service.employee;

import model.bean.employee.Position;
import model.repository.employee.PositionRepository;
import model.repository.employee.PositionRepositoryImp;

import java.util.List;

public class PositionServiceImp implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImp();
    @Override
    public List<Position> viewAllPosition() {
        return positionRepository.viewAllPosition();
    }
}
