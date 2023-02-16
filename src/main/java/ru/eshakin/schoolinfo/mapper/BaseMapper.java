package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.model.BaseModel;
import ru.eshakin.schoolinfo.model.dto.BaseDto;

import java.util.List;

public interface BaseMapper<E extends BaseModel, D extends BaseDto> {

    E toEntity(D dto);

    List<E> toEntities(List<D> dtos);

    D toDto(E entity);

    List<D> toDtos(List<E> entities);

}
