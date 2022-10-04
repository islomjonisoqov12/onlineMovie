package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.kinokong.onlinemovies.entities.movie.Quality;
import pro.kinokong.onlinemovies.projections.movie.CQTProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

@RepositoryRestResource(collectionResourceRel = "qualities", path = "qualities", excerptProjection = CQTProjection.class)
public interface QualityRepository extends AbstractRepository<Quality, String > {

}
