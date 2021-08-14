package service.employee;

import model.bean.employee.Position;
import repository.employee.PositionRepository;
import repository.employee.PositionRepositoryImp;

import java.util.List;

public class PositionServiceImp implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImp();
    @Override
    public List<Position> viewAllPosition() {
        return positionRepository.viewAllPosition();
    }
}
