package com.haiduk.restcontroller;

import com.haiduk.converter.UserMapper;
import com.haiduk.domain.User;
import com.haiduk.dto.UserDto;
import com.haiduk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

@Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;


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
    @PostMapping(value ="",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User>saveUser(@RequestBody User userDto){
        HttpHeaders headers = new HttpHeaders();
        if(userDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        User user = userMapper.fromDto(userDto);
        this.userService.save(userDto);
        return new ResponseEntity<>(userDto,headers,HttpStatus.OK);
    }

}
