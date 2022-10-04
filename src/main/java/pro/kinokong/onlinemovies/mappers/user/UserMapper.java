package pro.kinokong.onlinemovies.mappers.user;

import org.mapstruct.NullValuePropertyMappingStrategy;
import pro.kinokong.onlinemovies.dtos.user.UserCreateDto;
import pro.kinokong.onlinemovies.dtos.user.UserDto;
import pro.kinokong.onlinemovies.dtos.user.UserUpdateDto;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.mappers.base.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDto, UserCreateDto, UserUpdateDto> {

}
