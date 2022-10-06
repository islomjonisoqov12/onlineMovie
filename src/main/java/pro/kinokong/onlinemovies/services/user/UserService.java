package pro.kinokong.onlinemovies.services.user;


import org.springframework.security.core.userdetails.UserDetailsService;
import pro.kinokong.onlinemovies.criteria.base.BaseGenericCriteria;
import pro.kinokong.onlinemovies.dtos.user.UserCreateDto;
import pro.kinokong.onlinemovies.dtos.user.UserDto;
import pro.kinokong.onlinemovies.dtos.user.UserUpdateDto;
import pro.kinokong.onlinemovies.services.base.GenericCrudService;

public interface UserService extends GenericCrudService<
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        String,
        BaseGenericCriteria
        > , UserDetailsService {

}
