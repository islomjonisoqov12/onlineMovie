package pro.kinokong.onlinemovies.services.movie;

import com.google.gson.Gson;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pro.kinokong.onlinemovies.criteria.MovieCriteria;
import pro.kinokong.onlinemovies.dtos.movie.MovieCreateDto;
import pro.kinokong.onlinemovies.entities.movie.*;
import pro.kinokong.onlinemovies.exceptions.BadRequestException;
import pro.kinokong.onlinemovies.exceptions.ResourceFoundException;
import pro.kinokong.onlinemovies.exceptions.ResourceNotFoundException;
import pro.kinokong.onlinemovies.mappers.movie.MovieMapper;
import pro.kinokong.onlinemovies.projections.movie.MovieProjection;
import pro.kinokong.onlinemovies.repositories.movie.*;
import pro.kinokong.onlinemovies.services.base.AbstractService;
import pro.kinokong.onlinemovies.validators.movie.MovieValidator;

import java.util.ArrayList;

import java.util.List;
@Service
public class MovieServiceImpl extends AbstractService<MovieRepository, MovieMapper, MovieValidator> implements MovieService {

    protected MovieServiceImpl(MovieMapper mapper, MovieValidator validator, MovieRepository repository, GenreRepository genreRepository, ActorRepository actorRepository, QualityRepository qualityRepository, CountryRepository countryRepository, TypeRepository typeRepository, Gson gson) {
        super(mapper, validator, repository);
        this.genreRepository = genreRepository;
        this.actorRepository = actorRepository;
        this.qualityRepository = qualityRepository;
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
        this.gson = gson;
    }

    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;
    private final QualityRepository qualityRepository;
    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;
    private final Gson gson;




    @Override
    public String create(MovieCreateDto dto) {
        if(existsMovieByTitle(dto.getTitle())){
            throw new ResourceFoundException("movie title already exists");
        }
        if (dto.getVideoLink()==null && dto.getThriller()==null && !dto.getIsThriller()) {
            throw new BadRequestException("video link or thriller link must not be null");
        }
        List<Genre> genres = genreRepository.findAllById(dto.getGenreIds());
        List<Actor> actors = new ArrayList<>();
        if (dto.getActorIds() != null && dto.getActorIds().size()>0) {
            actors= actorRepository.findAllById(dto.getActorIds());
        }
        Type type = typeRepository.findById(dto.getTypeId()).orElseThrow(() -> new ResourceNotFoundException("type not found"));
        List<Quality> qualities = qualityRepository.findAllById(dto.getQualityIds());
        List<Country> countries = countryRepository.findAllById(dto.getCountryIds());
        Movie movie = mapper.fromCreateDtoToEntity(dto, genres, actors, qualities, countries, type);
        repository.save(movie);
        return movie.getId();
    }

    @Override
    public void delete(String id) {
        try {
            repository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(MovieCreateDto dto) {

    }

    @Override
    public MovieProjection get(String id) {
        return repository.findMovieById(id);
    }

    @Override
    public List<MovieProjection> getAll(MovieCriteria criteria) {
        return null;
    }

    @Override
    public boolean existsMovieByTitle(String movieTitle){
        if (movieTitle==null) {
            return false;
        }
        return repository.existsByTitle(movieTitle);
    }

    @Override
    public Page<MovieProjection> getAllPageable(MovieCriteria criteria) {
        return repository.findAllMovie(criteria.getActorsForSearch(), criteria.getGenresForSearch(), criteria.getTypeForSearch(), criteria.getSearchFormatted(), criteria.getPageable(true));
    }


    public List fromJsonToObject(String jsonObj) {
        if (jsonObj==null){
            return null;
        }
        return gson.fromJson(jsonObj, List.class);
    }
}
