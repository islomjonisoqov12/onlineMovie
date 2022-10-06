package pro.kinokong.onlinemovies.projections.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import pro.kinokong.onlinemovies.entities.movie.*;
import pro.kinokong.onlinemovies.projections.base.GenericProjection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Projection(name = "movie", types = Movie.class)
public interface MovieProjection extends GenericProjection {
    String getId();

    String getTitle();

    String getDescription();

    LocalDateTime getCreatedAt();

    LocalDate getReleaseDate();

    Integer getDislike();

    Integer getLike();

    Double getRating();

    boolean getChooseDislike();

    boolean getChooseLike();

    @Value(value = "#{@movieServiceImpl.fromJsonToObjectList(target.genres_list)}")
    List getGenres();

    @Value(value = "#{@movieServiceImpl.fromJsonToObjectList(target.actors_list)}")
    List getActors();

    @Value(value = "#{@movieServiceImpl.fromJsonToObjectList(target.countries_list)}")
    List getCountries();

    @Value(value = "#{@movieServiceImpl.fromJsonToObjectList(target.qualities_list)}")
    List getQualities();
}
