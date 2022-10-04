package pro.kinokong.onlinemovies.services.movie;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pro.kinokong.onlinemovies.criteria.Criteria;
import pro.kinokong.onlinemovies.dtos.movie.CreateDto;
import pro.kinokong.onlinemovies.dtos.movie.UpdateDto;
import pro.kinokong.onlinemovies.entities.movie.Genre;
import pro.kinokong.onlinemovies.exceptions.ResourceFoundException;
import pro.kinokong.onlinemovies.projections.movie.GenreProjection;
import pro.kinokong.onlinemovies.repositories.movie.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository repository;

    public GenreServiceImpl(GenreRepository repository) {
        this.repository = repository;
    }


    @Override
    public String create(CreateDto dto) {
        if (existsGenreByName(dto.getName())) {
            throw new ResourceFoundException("genre exists");
        }
        Genre genre = new Genre();
        genre.setName(dto.getName());
        repository.save(genre);
        return genre.getId();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(UpdateDto dto) {
        Genre genre = new Genre(dto.getId(), dto.getName());
        repository.save(genre);
    }

    @Override
    public GenreProjection get(String id) {
        return null;
    }

    @Override
    public List<GenreProjection> getAll(Criteria criteria) {
        return repository.findAllGenreHome(criteria.search);
    }

    @Override
    public boolean existsGenreByName(String name){
        if (name==null) {
            return false;
        }
        return repository.existsByName(name);
    }

    @Override
    public Page<Genre> getGenresPageable(Criteria criteria){
        return repository.findAllGenre(criteria.getSearch(), criteria.getPageable());
    }

    @Override
    public Genre getGenreById(String id){
        if (id == null) {
            return null;
        }
        return repository.findById(id).orElseGet(() -> null);
    }

}
