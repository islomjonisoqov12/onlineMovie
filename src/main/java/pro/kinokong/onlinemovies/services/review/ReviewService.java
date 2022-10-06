package pro.kinokong.onlinemovies.services.review;

import org.springframework.data.domain.Page;
import pro.kinokong.onlinemovies.criteria.base.GenericCriteria;
import pro.kinokong.onlinemovies.dtos.review.ReviewCreatedDto;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.projections.review.ReviewProjection;
import pro.kinokong.onlinemovies.services.base.BaseGenericService;

import java.util.List;

public interface ReviewService extends BaseGenericService {

    void makeLike(User userId, String movieId, boolean isLike);

    String leavePost(ReviewCreatedDto dto, User currentUser);

    List<ReviewProjection> getCommentPage(GenericCriteria criteria, String movieId);
}
