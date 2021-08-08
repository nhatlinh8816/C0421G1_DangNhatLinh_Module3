package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImp;

import java.util.List;

public class UserService implements UserServiceImp{
    UserRepositoryImp userRepositoryImp = new UserRepository();
    @Override
    public List<User> viewAllUser() {
        return userRepositoryImp.viewALlUser();
    }

    @Override
    public void createUser(User user) {
        userRepositoryImp.createUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepositoryImp.selectUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        boolean result ;
        if (user.getName().matches("[A-Za-z ]+")
                &&user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")
                &&user.getCountry().matches("[A-Za-z ]+")) {
            result = userRepositoryImp.updateUser(user);
        }else {
           result = false;
        }
        return result;
    }

    @Override
    public boolean removeUser(User user) {
        boolean result;
        result = userRepositoryImp.removeUser(user);
        return result;
    }

    @Override
    public List<User> viewALlUserByCountry(String country) {
        return userRepositoryImp.viewALlUserByCountry(country);
    }

    @Override
    public List<User> viewALlUserOrderByName() {
        return userRepositoryImp.viewALlUserOrderByName();
    }
}
