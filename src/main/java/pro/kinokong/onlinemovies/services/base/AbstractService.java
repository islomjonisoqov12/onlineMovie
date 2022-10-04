package pro.kinokong.onlinemovies.services.base;

import pro.kinokong.onlinemovies.mappers.base.BaseGenericMapper;
import pro.kinokong.onlinemovies.repositories.base.BaseGenericRepository;
import pro.kinokong.onlinemovies.validators.base.BaseGenericValidator;

public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper,
        V extends BaseGenericValidator
        > implements BaseGenericService {

    protected final M mapper;
    protected final V validator;
    protected final R repository;

    protected AbstractService(M mapper, V validator, R repository) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
    }

}
