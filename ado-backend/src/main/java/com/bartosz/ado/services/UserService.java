package com.bartosz.ado.services;

import com.bartosz.ado.models.User;
import com.bartosz.ado.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository usrRep){
        this.userRepository = usrRep;
    }

    public User findById(Integer id_user) {
        return userRepository.findById(id_user).orElseThrow();
    }

}
