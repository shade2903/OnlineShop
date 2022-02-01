package com.haiduk.service;

import com.haiduk.domain.User;
import com.haiduk.exception.IncorrectDataException;
import com.haiduk.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    private UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login){
        if(login == null && login.equals("")){
            throw new IncorrectDataException("User is Null");

        }
        return userRepository.getByName(login);
    }

}
