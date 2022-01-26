package com.haiduk.converter;

import com.haiduk.domain.User;
import com.haiduk.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class UserMapper {
    private OrderMapper orderMapper;

//    @Autowired
    public UserMapper(OrderMapper orderMapper){

    }

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;

    }


    public User toEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
