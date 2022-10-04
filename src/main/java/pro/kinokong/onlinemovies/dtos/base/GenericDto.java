package pro.kinokong.onlinemovies.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto implements BaseGenericDto {

    @NotNull(message = "title cannot be null") @NotBlank(message = "title cannot be null") @NotEmpty(message = "title cannot be empty")
    private String id;
}
