package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.repository.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}