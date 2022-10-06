package pro.kinokong.onlinemovies.controllers.movie;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pro.kinokong.onlinemovies.controllers.AbstractController;
import pro.kinokong.onlinemovies.criteria.MovieCriteria;
import pro.kinokong.onlinemovies.dtos.exception.ExceptionDto;
import pro.kinokong.onlinemovies.dtos.movie.MovieCreateDto;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.payload.ApiResponse;
import pro.kinokong.onlinemovies.projections.movie.MovieProjection;
import pro.kinokong.onlinemovies.services.movie.MovieService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AbstractController.PATH + "/movie")
public class MovieController extends AbstractController<MovieService> {


    protected MovieController(MovieService service) {
        super(service);
    }

    @PostMapping
    public ApiResponse<String> saveMovie(@Valid @RequestBody MovieCreateDto dto) {
        return ApiResponse.<String>builder().content(service.create(dto)).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<MovieProjection> getMovieById(@PathVariable String id) {
        return ApiResponse.<MovieProjection>builder().content(service.get(id)).build();
    }

    @Operation(summary = "sortBy will be id, title, description, createdAt, releaseDate, d.like, dislike, rating ")
    @GetMapping
    public Page<MovieProjection> getMovies(@Valid MovieCriteria criteria, Authentication authentication) {
        String userId = authentication != null? ((User) authentication.getPrincipal()).getId(): "";
        return service.getAllPageable(criteria,userId);
    }

    @GetMapping("/title")
    public ApiResponse<String> checkTitleExists(@RequestParam @NotEmpty @NotBlank String title) {
        boolean existsMovieByTitle = service.existsMovieByTitle(title);
        if (existsMovieByTitle) {
            return ApiResponse.<String>builder().success(true).message("exists").content(title).build();
        } else {
            return ApiResponse.<String>builder().content(title).message("exists").success(false).build();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append("\n");
        });
        errors.delete(errors.length()-1, errors.length());
        return new ResponseEntity<>(new ExceptionDto((request + "").substring(23, request.toString().indexOf(";client")), 400, errors.toString()), HttpStatus.BAD_REQUEST);
    }



}
