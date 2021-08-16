package model.service.employee;

import model.bean.employee.Degree;
import model.repository.employee.DegreeRepository;
import model.repository.employee.DegreeRepositoryImp;

import java.util.List;

public class DegreeServiceImp implements DegreeService {
    DegreeRepository degreeRepository = new DegreeRepositoryImp();

    @Override
    public List<Degree> viewAllDegree() {
        return degreeRepository.viewAllDegree();
    }
}
