package service;

import model.bean.User;
import model.repositories.IUserRepository;
import model.repositories.UserRepository;

import java.util.List;

public class UserService implements IUserRepository {
    IUserRepository userRepository = new UserRepository();
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> display() {
        return userRepository.display();
    }

    @Override
    public  void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

}
