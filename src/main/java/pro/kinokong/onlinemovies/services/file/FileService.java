package pro.kinokong.onlinemovies.services.file;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import pro.kinokong.onlinemovies.services.base.BaseGenericService;
import reactor.core.publisher.Mono;

import java.util.List;


public interface FileService extends BaseGenericService {

    String save(List<FileDto> dtos);

    Mono<Resource> getVideo(String title);
}
