package pro.kinokong.onlinemovies.dtos.movie;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieCreateDto implements BaseGenericDto {

    @NotNull(message = "title cannot be null") @NotBlank(message = "title cannot be blank") @NotEmpty(message = "title cannot be empty")
    private String title;
    @NotNull(message = "type cannot be null") @NotBlank(message = "type cannot be blank") @NotEmpty(message = "type cannot be empty")
    private String typeId;
    @NotNull(message = "release date cannot be null")
    private LocalDate releaseDate;
    @NotNull(message = "duration cannot be null")
    private Integer duration;
    @NotBlank(message = "description cannot be blank") @NotEmpty(message = "description cannot be empty")
    private String description;
    @NotEmpty(message = "quantities cannot be empty")
    private List<String> qualityIds;
    @NotEmpty(message = "genres cannot be empty")
    private List<String> genreIds;
    @NotEmpty(message = "countries cannot be empty")
    private List<String> countryIds;
    private List<String> actorIds;
    @NotBlank(message = "video link cannot be blank") @NotEmpty(message = "video link cannot be empty")
    private String videoLink;
    @NotBlank(message = "thriller link cannot be blak") @NotEmpty(message = "thriller link cannot be empty")
    private String thriller;
    @NotNull(message = "isThriller cannot be null")
    private Boolean isThriller;


}
