package com.haiduk.converter;

import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.dto.ProductDto;
import com.haiduk.dto.UserDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends MapperConverterClass<User,UserDto>{


    @Override
    Class<UserDto> getDomainClass() {
        return UserDto.class;
    }

    @Override
    Class<User> getEntityClass() {
        return User.class;
    }
}
