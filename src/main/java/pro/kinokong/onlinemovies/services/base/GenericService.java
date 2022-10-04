package pro.kinokong.onlinemovies.services.base;

import pro.kinokong.onlinemovies.criteria.base.BaseGenericCriteria;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends BaseGenericService {

    D get(K id);

    List<D> getAll(C criteria);

}
