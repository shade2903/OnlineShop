package com.haiduk.converter;

import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.dto.ProductDto;
import com.haiduk.dto.UserDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements MapperConverter<User,UserDto> {
    private MapperFacade mapperFacade;
    @Autowired
    public UserMapper(MapperFacade mapperFacade){
        this.mapperFacade = mapperFacade;
    }
@Override
    public UserDto toDto(User entity) {

        return mapperFacade.map(entity, UserDto.class);
    }
@Override
    public User fromDto(UserDto dto) {
        return mapperFacade.map(dto, User.class);
    }


}
