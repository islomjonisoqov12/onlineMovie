package pro.kinokong.onlinemovies.dtos.file;

import org.springframework.web.multipart.MultipartFile;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDto implements BaseGenericDto {

    @NotNull(message = "qualityId cannot be null") @NotBlank(message = "qualityId cannot be blank") @NotEmpty(message = "qualityId cannot be empty")
    String qualityId;

    @NotNull(message = "file cannot be null")
    MultipartFile file;
}
