package pro.kinokong.onlinemovies.mappers.movie;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import pro.kinokong.onlinemovies.dtos.base.GenericDto;
import pro.kinokong.onlinemovies.dtos.movie.MovieCreateDto;
import pro.kinokong.onlinemovies.entities.movie.*;
import pro.kinokong.onlinemovies.mappers.base.AbstractMapper;

import java.util.List;
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovieMapper extends AbstractMapper<Movie, GenericDto, MovieCreateDto, GenericDto> {

    @Mappings({
            @Mapping(target = "qualities", source = "qualities"),
            @Mapping(target = "genres", source = "genres"),
            @Mapping(target = "countries", source = "countries"),
            @Mapping(target = "actors", source = "actors"),
            @Mapping(target = "type", source = "type")
    })
    Movie fromCreateDtoToEntity(MovieCreateDto dto, List<Genre> genres, List<Actor> actors, List<Quality> qualities, List<Country> countries, Type type);
}
