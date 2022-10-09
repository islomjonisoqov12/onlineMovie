package pro.kinokong.onlinemovies.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.kinokong.onlinemovies.entities.movie.Actor;

@Component
public class RepresentationModelProcessorImp implements Converter<Actor, Actor> {

    @Override
    public Actor convert(Actor source) {
        return source;
    }

}
