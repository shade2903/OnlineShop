package com.haiduk.converter;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyConverter<E,T> {
    @Autowired
    private MapperFacade mapperFacade;
    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }


    public Class<T> getDomainClass(){
        return T;
    }

    abstract Class<E> getEntityClass();

    public T toDto(E entity) {

        return mapperFacade.map(entity, getDomainClass());
    }

    public E fromDto(T dto) {
        return mapperFacade.map(dto, getEntityClass());
    }






}
