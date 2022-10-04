package pro.kinokong.onlinemovies.projections.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.rest.core.config.Projection;
import pro.kinokong.onlinemovies.entities.movie.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Projection(name = "actor", types = {Country.class, Genre.class, Quality.class, Type.class})
public interface CQTProjection {

    String getId();

    String getName();
}
