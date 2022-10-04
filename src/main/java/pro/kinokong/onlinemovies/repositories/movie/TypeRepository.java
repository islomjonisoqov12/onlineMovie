package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.kinokong.onlinemovies.entities.movie.Type;
import pro.kinokong.onlinemovies.projections.movie.CQTProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

@RepositoryRestResource(collectionResourceRel = "types", path = "types", excerptProjection = CQTProjection.class)
public interface TypeRepository extends AbstractRepository<Type, String> {

}
