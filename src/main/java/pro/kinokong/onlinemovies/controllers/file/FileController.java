package pro.kinokong.onlinemovies.controllers.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.kinokong.onlinemovies.controllers.AbstractController;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import pro.kinokong.onlinemovies.dtos.file.ImageDto;
import pro.kinokong.onlinemovies.services.file.FileService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static pro.kinokong.onlinemovies.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/file")
public class FileController extends AbstractController<FileService> {
    protected FileController(FileService service) {
        super(service);
    }


    @Secured(value = {"ROLE_ADMIN"})
    @PostMapping
    public String uploadFile(@RequestBody List<@Valid FileDto> dtos){
        return service.save(dtos);
    }

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getVideo(title);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String id) throws IOException {
        return service.getFile(id);
    }

    @PostMapping("/image")
    public ResponseEntity<String> saveFile(@RequestPart MultipartFile file) throws IOException {
        String s = service.saveImage(file);
        return ResponseEntity.ok(s);
    }



}
