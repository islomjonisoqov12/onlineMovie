package pro.kinokong.onlinemovies.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pro.kinokong.onlinemovies.criteria.base.GenericCriteria;
import pro.kinokong.onlinemovies.dtos.review.ReviewCreatedDto;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.payload.ApiResponse;
import pro.kinokong.onlinemovies.projections.review.ReviewProjection;
import pro.kinokong.onlinemovies.services.review.ReviewService;

import javax.validation.Valid;

import java.util.List;

import static pro.kinokong.onlinemovies.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH)
public class ReviewController extends AbstractController<ReviewService>{


    protected ReviewController(ReviewService service) {
        super(service);
    }

    @PostMapping("/make-like/{movieId}")
    public ResponseEntity<Boolean> makeLike(@PathVariable String movieId, @RequestParam boolean isLike, Authentication authentication){
        User user = ((User) authentication.getPrincipal());
        service.makeLike(user, movieId, isLike);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/review/{movieId}")
    public ResponseEntity<ApiResponse<List<ReviewProjection>>> getReview(GenericCriteria criteria, @PathVariable String movieId){
        List<ReviewProjection> commentPage = service.getCommentPage(criteria, movieId);
        return ResponseEntity.ok(ApiResponse.<List<ReviewProjection>>builder().content(commentPage).build());
    }

    @PostMapping("/review")
    public ResponseEntity<ApiResponse<String>> saveReview(@Valid @RequestBody ReviewCreatedDto dto, Authentication authentication){
        User currentUser = (User) authentication.getPrincipal();
        String s = service.leavePost(dto, currentUser);
        return ResponseEntity.ok(ApiResponse.<String>builder().content(s).build());
    }
}
