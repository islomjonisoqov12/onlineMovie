package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.kinokong.onlinemovies.entities.movie.Country;
import pro.kinokong.onlinemovies.projections.movie.CQTProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

@RepositoryRestResource(collectionResourceRel = "country", path = "country", excerptProjection = CQTProjection.class)
public interface CountryRepository extends AbstractRepository<Country, String > {

}
