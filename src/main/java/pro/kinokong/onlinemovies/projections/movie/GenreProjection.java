package pro.kinokong.onlinemovies.projections.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface GenreProjection extends BaseGenericDto {

    String getId();

    String getName();

    String getMoviesCount();


}
