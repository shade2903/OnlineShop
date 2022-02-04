package com.haiduk.service;

import com.haiduk.converter.UserMapper;
import com.haiduk.domain.User;
import com.haiduk.dto.UserDto;
import com.haiduk.exception.IncorrectDataException;
import com.haiduk.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUserByLogin(String login){
        if(login == null && login.equals("")){
            throw new IncorrectDataException("User is Null");

        }
        return userRepository.getByName(login);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        if(users.size() != 0){
            for(User u : users){
                usersDto.add(userMapper.toDto(u));
            }
        }
        return usersDto;

    }
    public UserDto getUserById(int id){
        return userMapper.toDto(userRepository.getById(id));
    }
    public void save(User user){
        userRepository.save(user);
    }
    public User getUser(int id){
        return userRepository.getById(id);
    }

}
