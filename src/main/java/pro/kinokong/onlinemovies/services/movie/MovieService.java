package pro.kinokong.onlinemovies.services.movie;

import org.springframework.data.domain.Page;
import pro.kinokong.onlinemovies.criteria.MovieCriteria;
import pro.kinokong.onlinemovies.dtos.movie.MovieCreateDto;
import pro.kinokong.onlinemovies.projections.movie.MovieProjection;
import pro.kinokong.onlinemovies.services.base.GenericCrudService;

public interface MovieService extends GenericCrudService<MovieProjection, MovieCreateDto, MovieCreateDto, String, MovieCriteria> {

    boolean existsMovieByTitle(String movieTitle);

    Page<MovieProjection> getAllPageable(MovieCriteria criteria, String userId);
}
