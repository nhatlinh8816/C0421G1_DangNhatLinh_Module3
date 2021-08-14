package service.employee;

import model.bean.employee.Degree;
import repository.employee.DegreeRepository;
import repository.employee.DegreeRepositoryImp;

import java.util.List;

public class DegreeServiceImp implements DegreeService {
    DegreeRepository degreeRepository = new DegreeRepositoryImp();

    @Override
    public List<Degree> viewAllDegree() {
        return degreeRepository.viewAllDegree();
    }
}
