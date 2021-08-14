package service.employee;

import model.bean.employee.Division;
import repository.employee.DivisionRepository;
import repository.employee.DivisionRepositoryImp;

import java.util.List;

public class DivisionServiceImp implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImp();
    @Override
    public List<Division> viewAllDivision() {
        return divisionRepository.viewAllDivision();
    }
}
