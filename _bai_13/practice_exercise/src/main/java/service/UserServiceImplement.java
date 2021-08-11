package service;

import model.User;
import repository.UserRepositoryImplement;
import repository.UserRepository;

import java.util.List;

public class UserServiceImplement implements UserService {
    UserRepository userRepository = new UserRepositoryImplement();
    @Override
    public List<User> viewAllUser() {
        return userRepository.viewALlUser();
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public boolean updateUser(int id, String newName, String newEmail, String newCountry) {
        boolean result ;
        if (newName.matches("[A-Za-z ]+")
                &&newEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")
                &&newCountry.matches("[A-Za-z ]+")) {
            result = userRepository.updateUser(id, newName, newEmail, newCountry);
        }else {
           result = false;
        }
        return result;
    }

    @Override
    public boolean removeUser(int id) {
        boolean result;
        result = userRepository.removeUser(id);
        return result;
    }

    @Override
    public List<User> viewALlUserByCountry(String country) {
        return userRepository.viewALlUserByCountry(country);
    }

    @Override
    public List<User> viewALlUserOrderByName() {
        return userRepository.viewALlUserOrderByName();
    }

    @Override
    public String addUserTransaction() {
        return userRepository.addUserTransaction();
    }
}
