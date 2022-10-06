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
    private String description;
    @NotEmpty(message = "quantities cannot be empty")
    private List<String> qualityIds;
    @NotEmpty(message = "genres cannot be empty")
    private List<String> genreIds;
    @NotEmpty(message = "countries cannot be empty")
    private List<String> countryIds;
    private List<String> actorIds;
    private String videoLink;
    private String thriller;

    @NotNull(message = "image cannot be null") @NotBlank(message = "image cannot be blank") @NotEmpty(message = "image cannot be empty")
    private String image;

    @NotNull(message = "isThriller cannot be null")
    private Boolean isThriller;

    public String getThriller() {
        if(thriller==null){
            return null;
        }
        return thriller.trim();
    }

    public String getVideoLink() {
        if(videoLink==null){
            return null;
        }
        return videoLink.trim();
    }

    public String getDescription() {
        if(description==null){
            return null;
        }
        return description.trim();
    }
}
