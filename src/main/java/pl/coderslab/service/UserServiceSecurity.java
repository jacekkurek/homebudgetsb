package pl.coderslab.service;


import pl.coderslab.entity.User;

public interface UserServiceSecurity {

    User findByName(String name);

    void saveUser(User user);

}