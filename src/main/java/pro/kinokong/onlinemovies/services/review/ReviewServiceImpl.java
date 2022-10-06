package pro.kinokong.onlinemovies.services.review;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pro.kinokong.onlinemovies.criteria.base.GenericCriteria;
import pro.kinokong.onlinemovies.dtos.review.ReviewCreatedDto;
import pro.kinokong.onlinemovies.entities.movie.Movie;
import pro.kinokong.onlinemovies.entities.review.Review;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.exceptions.ResourceNotFoundException;
import pro.kinokong.onlinemovies.projections.review.ReviewProjection;
import pro.kinokong.onlinemovies.repositories.movie.MovieRepository;
import pro.kinokong.onlinemovies.repositories.review.ReviewRepository;
import pro.kinokong.onlinemovies.repositories.user.UserRepository;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final MovieRepository movieRepository;
    private final ReviewRepository repository;
    private final UserRepository userRepository;

    public ReviewServiceImpl(MovieRepository movieRepository, ReviewRepository repository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void makeLike(User user, String movieId, boolean isLike) {
        Movie movie = movieRepository.findByMovieId(movieId).orElseThrow(() -> new ResourceNotFoundException("movie not found"));
        if (isLike) {
            if (!movie.getLike().remove(user)) {
                movie.getDislike().remove(user);
                movie.getLike().add(user);
            }
        } else {
            if (!movie.getDislike().remove(user)) {
                movie.getLike().remove(user);
                movie.getDislike().add(user);
            }
        }
        movieRepository.save(movie);
    }

    @Override
    public String leavePost(ReviewCreatedDto dto, User currentUser){
        Movie movie = movieRepository.findById(dto.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Movie Not Found"));
        Review review = null;
        if(dto.getReplyCommentId()==null){
            review = new Review(dto.getComment(), movie, null);
        }else {
            Review replyComment = repository.findById(dto.getReplyCommentId()).orElseThrow(() -> new ResourceNotFoundException("Reply comment not found"));
            review = new Review(dto.getComment(), movie, replyComment);
        }
        review.setCratedBy(currentUser.getId());
        repository.save(review);
        return review.getId();
    }

    @Override
    public List<ReviewProjection> getCommentPage(GenericCriteria criteria, String movieId){
        return repository.findCommentPage(movieId, criteria.getPage(), criteria.getSize());
    }



}
