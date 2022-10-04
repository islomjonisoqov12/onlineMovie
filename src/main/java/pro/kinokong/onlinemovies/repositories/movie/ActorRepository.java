package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pro.kinokong.onlinemovies.entities.movie.Actor;
import pro.kinokong.onlinemovies.projections.movie.ActorProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;


@RepositoryRestResource(collectionResourceRel = "actors", path = "actors", excerptProjection = ActorProjection.class)
public interface ActorRepository extends AbstractRepository<Actor, String> {

}
