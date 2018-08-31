package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save (User user){
        return userRepository.save(user);
    }

    public User findOne (Long id){
        return userRepository.findOne(id);
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


}