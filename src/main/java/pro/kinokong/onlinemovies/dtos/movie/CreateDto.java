package pro.kinokong.onlinemovies.dtos.movie;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDto implements BaseGenericDto {

    @NotNull(message = "name cannot be null") @NotBlank(message = "name cannot be blank") @NotEmpty(message = "name cannot be empty")
    private String name;
}
