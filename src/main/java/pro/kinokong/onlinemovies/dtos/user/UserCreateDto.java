package pro.kinokong.onlinemovies.dtos.user;

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
public class UserCreateDto implements BaseGenericDto {

    @NotNull(message = "full name cannot be null") @NotBlank(message = "full name cannot be blank") @NotEmpty(message = "full name cannot be empty")
    String fullName;

    @NotNull(message = "username cannot be null") @NotBlank(message = "username cannot be blank") @NotEmpty(message = "username cannot be empty")
    String username;

    @NotNull(message = "password cannot be null") @NotBlank(message = "password cannot be blank") @NotEmpty(message = "password cannot be empty")
    String password;

    @NotNull(message = "email cannot be null") @NotBlank(message = "email cannot be blank") @NotEmpty(message = "email cannot be empty")
    String email;
}
