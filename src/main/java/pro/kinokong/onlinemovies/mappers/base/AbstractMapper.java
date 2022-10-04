package pro.kinokong.onlinemovies.mappers.base;

import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;
import pro.kinokong.onlinemovies.dtos.base.GenericDto;
import pro.kinokong.onlinemovies.entities.base.BaseGenericEntity;

import java.util.List;

public interface AbstractMapper<
        E extends BaseGenericEntity,
        D extends GenericDto,
        CD extends BaseGenericDto,
        UP extends GenericDto
        > extends BaseGenericMapper {
    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E fromCreateDto(CD createDto);

    E fromUpdateDto(UP updateDto);
}
