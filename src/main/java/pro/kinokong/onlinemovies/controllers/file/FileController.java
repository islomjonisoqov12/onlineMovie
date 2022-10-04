package pro.kinokong.onlinemovies.controllers.file;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.kinokong.onlinemovies.controllers.AbstractController;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import pro.kinokong.onlinemovies.services.file.FileService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

import static pro.kinokong.onlinemovies.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/file")
public class FileController extends AbstractController<FileService> {
    protected FileController(FileService service) {
        super(service);
    }


    @PostMapping
    public String uploadFile(@RequestBody List<@Valid FileDto> dtos){
        return service.save(dtos);
    }

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getVideo(title);
    }



}
