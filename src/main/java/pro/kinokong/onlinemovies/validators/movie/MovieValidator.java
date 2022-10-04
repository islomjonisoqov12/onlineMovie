package pro.kinokong.onlinemovies.validators.movie;

import org.springframework.stereotype.Component;
import pro.kinokong.onlinemovies.dtos.base.GenericDto;
import pro.kinokong.onlinemovies.dtos.movie.MovieCreateDto;
import pro.kinokong.onlinemovies.validators.base.AbstractValidator;

import javax.xml.bind.ValidationException;


@Component
public class MovieValidator extends AbstractValidator<MovieCreateDto, GenericDto, String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(MovieCreateDto movieCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(GenericDto cd) throws ValidationException {

    }
}
