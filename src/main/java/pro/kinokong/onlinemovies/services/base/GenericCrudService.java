package pro.kinokong.onlinemovies.services.base;

import pro.kinokong.onlinemovies.criteria.base.BaseGenericCriteria;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;
import pro.kinokong.onlinemovies.dtos.base.GenericDto;

import java.io.Serializable;

public interface GenericCrudService<
        D extends BaseGenericDto,
        CD extends BaseGenericDto,
        UD extends BaseGenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends GenericService<D, K, C> {
    K create(CD dto);

    void delete(K id);

    void update(UD dto);
}
