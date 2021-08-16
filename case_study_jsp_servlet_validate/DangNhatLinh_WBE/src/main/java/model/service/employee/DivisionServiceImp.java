package model.service.employee;

import model.bean.employee.Division;
import model.repository.employee.DivisionRepository;
import model.repository.employee.DivisionRepositoryImp;

import java.util.List;

public class DivisionServiceImp implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImp();
    @Override
    public List<Division> viewAllDivision() {
        return divisionRepository.viewAllDivision();
    }
}
