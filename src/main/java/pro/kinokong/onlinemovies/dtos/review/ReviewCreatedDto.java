package pro.kinokong.onlinemovies.dtos.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.kinokong.onlinemovies.dtos.base.BaseGenericDto;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreatedDto implements BaseGenericDto {

    @NotNull(message = "comment cannot be null") @NotBlank(message = "comment cannot be blank") @NotEmpty(message = "comment cannot be empty")
    private String comment;

    @NotNull(message = "movie cannot be null") @NotBlank(message = "movie cannot be blank") @NotEmpty(message = "movie cannot be empty")
    private String movieId;

    private String replyCommentId;

    public String getComment() {
        if(comment==null){
            return null;
        }
        return comment.trim();
    }
}
