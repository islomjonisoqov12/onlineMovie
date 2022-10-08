package pro.kinokong.onlinemovies.services.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.kinokong.onlinemovies.dtos.file.FileDto;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    final String path = "./src/main/resources/upload";
    final String imagePath = "./src/main/resources/images";

    @Autowired
    private ResourceLoader resourceLoader;
    private static final String FORMAT = "classpath:upload/%s";

    @Override
    public String save(List<FileDto> dtos) {
//        String fileName = UUID.randomUUID().toString();
        mkDir(path);
        String fileName = UUID.randomUUID().toString();
        for (FileDto dto : dtos) {
            try {
                String originalFilename = dto.getFile().getOriginalFilename();
                String filePath = path +"/"+ fileName + dto.getQualityId() + originalFilename;
                dto.getFile().transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return fileName;
    }

    @Override
    public Mono<Resource> getVideo(String title) {
        File file = new File(path);
        if (file.listFiles()==null) {
            throw new ResourceNotFoundException("movie not found");
        }
        File file2 = Arrays.stream(file.listFiles()).filter(file1 -> file1.getName().startsWith(title)).findFirst().orElseThrow(() -> new ResourceNotFoundException("movie not found"));
        return Mono.fromSupplier(() -> resourceLoader.
                getResource(String.format(FORMAT, file2.getName())));
    }

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        String s = UUID.randomUUID().toString();
        mkDir(imagePath);
        File newFile = new File(imagePath+"/"+s+file.getOriginalFilename());
        file.transferTo(newFile.toPath());
        return s;
    }

    @Override
    public List<String> saveImages(MultipartFile[] files) {
        List<String> names = new ArrayList<>();
        mkDir(imagePath);
        for (MultipartFile file : files) {
            String id = UUID.randomUUID().toString();
            File newFile = new File(imagePath+"/"+id+file.getOriginalFilename());
            try {
                file.transferTo(newFile.toPath());
                names.add(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return names;
    }

    @Override
    public ResponseEntity<ByteArrayResource> getFile(String id) throws IOException {
        File folder = new File(imagePath);
        if (folder.listFiles() == null) {
            throw new ResourceNotFoundException("file not found");
        }
        File first = Arrays.stream(folder.listFiles()).filter(file -> file.getName().startsWith(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("file not found"));
        return ResponseEntity.ok()
                .body(new ByteArrayResource(Files.readAllBytes(first.toPath())));
    }


    public void mkDir(String url) {
        File directory = new File(url);
        if (!directory.exists()) {
            boolean mkdir = directory.mkdir();
        }
    }
}
