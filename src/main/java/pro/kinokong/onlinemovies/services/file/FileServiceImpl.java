package pro.kinokong.onlinemovies.services.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    final String path = "./src/main/resources/upload";
    @Autowired
    private ResourceLoader resourceLoader;
    private static final String FORMAT="classpath:upload/%s.mp4";

    @Override
    public String save(List<FileDto> dtos) {
//        String fileName = UUID.randomUUID().toString();
        String fileName = "71d66afb-7bbc-4639-85ce-23cc7e7ca42e";
        for (FileDto dto : dtos) {
            try {
                String originalFilename = dto.getFile().getOriginalFilename();
                String fileK = originalFilename.substring(originalFilename.lastIndexOf('.'));
                String filePath = path + fileName + dto.getQualityId() + fileK;
                dto.getFile().transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return fileName;
    }

    @Override
    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()->resourceLoader.
                getResource(String.format(FORMAT,title)))   ;
    }
}
