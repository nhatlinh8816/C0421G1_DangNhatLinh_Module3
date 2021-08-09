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
    public boolean updateUser(int id, String newName, String newEmail, String newCountry) {
        boolean result ;
        if (newName.matches("[A-Za-z ]+")
                &&newEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")
                &&newCountry.matches("[A-Za-z ]+")) {
            result = userRepositoryImp.updateUser(id, newName, newEmail, newCountry);
        }else {
           result = false;
        }
        return result;
    }

    @Override
    public boolean removeUser(int id) {
        boolean result;
        result = userRepositoryImp.removeUser(id);
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

    @Override
    public String addUserTransaction() {
        return userRepositoryImp.addUserTransaction();
    }
}
