package pro.kinokong.onlinemovies.repositories.review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import pro.kinokong.onlinemovies.entities.review.Review;
import pro.kinokong.onlinemovies.projections.review.ReviewProjection;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestResource(exported = false)
public interface ReviewRepository extends AbstractRepository<Review, String> {

    @Query(nativeQuery = true, value = """
            select r.id,
                   r.content,
                   (select full_name from users u where u.id = r.crated_by) as owner,
                   r.created_at as "createdAt",
                   cast((select jsonb_build_object('id', p.id, 'content', p.content) from reviews p where p.id = r.parent_id) as text) as parent_o
            from reviews r where r.movie_id = :movieId limit :size offset :size*:page
            """)
    List<ReviewProjection> findCommentPage(String movieId, int page, int size);
}
