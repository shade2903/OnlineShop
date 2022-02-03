package com.haiduk.restcontroller;

import com.haiduk.converter.UserMapper;
import com.haiduk.domain.User;
import com.haiduk.dto.UserDto;
import com.haiduk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

@Autowired
    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserDto>> getAllUser(){
    List<UserDto> users = userService.getUsers();
    if(users.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<UserDto> getUserById(@PathVariable int id){

        return new  ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.OK);

    }

}
