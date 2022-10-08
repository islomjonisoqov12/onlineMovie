package pro.kinokong.onlinemovies.controllers.movie;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pro.kinokong.onlinemovies.controllers.AbstractController;
import pro.kinokong.onlinemovies.criteria.Criteria;
import pro.kinokong.onlinemovies.dtos.movie.CreateDto;
import pro.kinokong.onlinemovies.entities.movie.Genre;
import pro.kinokong.onlinemovies.payload.ApiResponse;
import pro.kinokong.onlinemovies.projections.movie.GenreProjection;
import pro.kinokong.onlinemovies.services.movie.GenreService;

import javax.validation.Valid;
import java.util.List;

import static pro.kinokong.onlinemovies.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/genre")
public class GenreController extends AbstractController<GenreService> {

    protected GenreController(GenreService service) {
        super(service);
    }

    @PostMapping
    public ApiResponse<String> saveGenre(@Valid @RequestBody CreateDto dto) {
        String id = service.create(dto);
        return ApiResponse.<String>builder().content(id).build();
    }

    @GetMapping
    public Page<Genre> getAllGenres(@Valid Criteria criteria) {
        return service.getGenresPageable(criteria);
    }

    @GetMapping("/home")
    public ApiResponse<List<GenreProjection>> getGenres(String type) {
        Criteria criteria = new Criteria();
        criteria.setSearch(type);
        return ApiResponse.<List<GenreProjection>>builder().content(service.getAll(criteria)).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<Genre> getById(@PathVariable String id) {
        return ApiResponse.<Genre>builder().content(service.getGenreById(id)).build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteById(@PathVariable String id) {
        service.delete(id);
        return ApiResponse.<String>builder().content("successfully deleted").build();
    }


}
