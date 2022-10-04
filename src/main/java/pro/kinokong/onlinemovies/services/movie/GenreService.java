package pro.kinokong.onlinemovies.services.movie;

import org.springframework.data.domain.Page;
import pro.kinokong.onlinemovies.criteria.Criteria;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;
import pro.kinokong.onlinemovies.dtos.movie.CreateDto;
import pro.kinokong.onlinemovies.dtos.movie.UpdateDto;
import pro.kinokong.onlinemovies.entities.movie.Genre;
import pro.kinokong.onlinemovies.projections.movie.GenreProjection;
import pro.kinokong.onlinemovies.services.base.GenericCrudService;

import javax.validation.constraints.NotNull;

public interface GenreService extends GenericCrudService<GenreProjection, CreateDto, UpdateDto, String, Criteria> {

    boolean existsGenreByName(@NotNull String name);

    Page<Genre> getGenresPageable(Criteria criteria);

    Genre getGenreById(String id);

}
