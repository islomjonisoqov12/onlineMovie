package pro.kinokong.onlinemovies.services.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import pro.kinokong.onlinemovies.services.base.BaseGenericService;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;


public interface FileService extends BaseGenericService {

    String save(List<FileDto> dtos);

    Mono<Resource> getVideo(String title);

    String saveImage(MultipartFile file) throws IOException;

    List<String> saveImages(MultipartFile[] files);

    ResponseEntity<ByteArrayResource> getFile(String id) throws IOException;
}
