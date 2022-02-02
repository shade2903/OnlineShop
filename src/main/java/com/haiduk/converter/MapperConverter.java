package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.dto.OrderDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

public interface MapperConverter<E,T> {

    public T toDto(E entity);

    public E fromDto(T dto);

}
