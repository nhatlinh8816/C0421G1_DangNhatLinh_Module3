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
    public boolean updateUser(User user) {
        boolean result ;
        if (user.getName().matches("[A-Za-z ]+")
                &&user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")
                &&user.getCountry().matches("[A-Za-z ]+")) {
            result = userRepository.updateUser(user);
        }else {
           result = false;
        }
        return result;
    }

    @Override
    public boolean removeUser(User user) {
        boolean result;
        result = userRepository.removeUser(user);
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
}
