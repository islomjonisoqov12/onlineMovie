package pro.kinokong.onlinemovies.dtos.movie;

import pro.kinokong.onlinemovies.dtos.base.GenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto extends GenericDto {

    @NotNull(message = "title cannot be null") @NotBlank(message = "title cannot be blank") @NotEmpty(message = "title cannot be empty")
    String name;
}
