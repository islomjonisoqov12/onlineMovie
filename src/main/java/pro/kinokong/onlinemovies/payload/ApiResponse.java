package pro.kinokong.onlinemovies.payload;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T content;
    private boolean success ;
    private String message ;

    @Builder
    public ApiResponse(T content, Boolean success, String message) {
        this.content = content ;
        this.success = success == null || success;
        this.message = message == null ? "success": message;
    }
}
