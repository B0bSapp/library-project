package com.epam.code.mie.library.mappers;

import java.util.List;

public interface Mapper<T, E> {

  default List<T> toDtoList(List<E> entityList){
    return entityList.stream().map(this::toDto).toList();
  }

  T toDto(E entity);

}
