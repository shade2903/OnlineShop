package com.haiduk.converter;

public interface MapperConverter<E,T> {
    E toDto(T entity);
    T toEntity(E dto);
}
