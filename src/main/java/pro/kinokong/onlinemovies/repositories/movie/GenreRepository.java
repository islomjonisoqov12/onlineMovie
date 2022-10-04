package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pro.kinokong.onlinemovies.entities.movie.Genre;
import pro.kinokong.onlinemovies.projections.movie.GenreProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

import java.util.List;
@RestResource(exported = false)
@Repository
public interface GenreRepository extends AbstractRepository<Genre, String> {

    boolean existsByName(String name);

    @Query(value = "from genres g where lower(g.name) like :search")
    Page<Genre> findAllGenre(String search, Pageable pageable);

    @Query(nativeQuery = true,
            value = """
            select g.id, g.name, count(distinct movies.id) as "moviesCount"
            from movies
                     join types t on movies.type_id = t.id
                     join movies_genres mg on movies.id = mg.movies_id
                     join genres g on mg.genres_id = g.id
            where t.name = :search
            group by g.id, g.name
            """)
    List<GenreProjection> findAllGenreHome(String search);

}
