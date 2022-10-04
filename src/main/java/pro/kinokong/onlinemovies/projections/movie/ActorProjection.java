package pro.kinokong.onlinemovies.projections.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.rest.core.config.Projection;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;
import pro.kinokong.onlinemovies.entities.movie.Actor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Projection(name = "actor", types = {Actor.class})
public interface ActorProjection extends BaseGenericDto {

    String getId();

    String getFullName();

}
