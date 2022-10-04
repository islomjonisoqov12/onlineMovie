package pro.kinokong.onlinemovies.repositories.review;

import org.springframework.data.rest.core.annotation.RestResource;
import pro.kinokong.onlinemovies.entities.review.Review;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;
@RestResource(exported = false)
public interface ReviewRepository extends AbstractRepository<Review, String> {
}
