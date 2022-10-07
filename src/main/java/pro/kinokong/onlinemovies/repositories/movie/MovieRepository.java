package pro.kinokong.onlinemovies.repositories.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pro.kinokong.onlinemovies.entities.movie.Movie;
import pro.kinokong.onlinemovies.projections.movie.MovieProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

import java.util.Optional;


@RestResource(exported = false)
@Repository
public interface MovieRepository extends AbstractRepository<Movie, String> {

    boolean existsByTitle(String movieTitle);

    @Query(nativeQuery = true, value = """
            select d.* from get_movie(:search, :genres, :actors, :type, :userId) d
            """)
    Page<MovieProjection> findAllMovie(String actors, String genres, String type, String search, String userId, Pageable pageable);


    @Query(nativeQuery = true, value = """
            select m.id,
                   m.title,
                   m.description,
                   release_date                                             as "releaseDate",
                   m.created_at                                             as "createdAt",
                   count(d.movies_id)                                       as "dislike",
                   count(l.movies_id)                                       as "like",
                   coalesce((select count(*) > 0 from likes where likes.like_id = :userId),
                            false)                                                                   as chooseLike,
                   coalesce((select count(*) > 0 from dislikes ds where ds.dislike_id = :userId),
                            false)                                                                   as chooseDislike,
                   coalesce(m.rating_amount / m.rating_count, 0)            as "rating",
                   cast(coalesce((select jsonb_agg(g)
                                  from genres g
                                           join movies_genres mg on g.id = mg.genres_id
                                  where mg.movies_id = :id), '[]') as text) as "genres_list",
                   cast(coalesce((select jsonb_agg(a)
                                  from actors a
                                           join movies_actors ma on a.id = ma.actors_id
                                  where ma.movies_id = :id), '[]') as text) as "actors_list",
                   cast(coalesce((select jsonb_agg(c)
                                  from countries c
                                           join movies_countries mc on c.id = mc.countries_id
                                  where mc.movies_id = :id), '[]') as text) as "countries_list",
                   cast(coalesce((select jsonb_agg(q)
                                  from qualities q
                                           join movies_qualities mq on q.id = mq.qualities_id
                                  where mq.movies_id = :id), '[]') as text) as "qualities_list"
            from movies m
                     left join dislikes d on m.id = d.movies_id
                     left join likes l on m.id = l.movies_id
            where m.id = :id
            group by m.id
            """)
    MovieProjection findMovieById(String id, String userId);

    @Query(value = "from movies m left join m.like left join m.dislike where m.id = :movieId")
    Optional<Movie> findByMovieId(String movieId);
}
