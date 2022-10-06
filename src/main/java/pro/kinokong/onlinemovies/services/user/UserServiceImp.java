package pro.kinokong.onlinemovies.services.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import pro.kinokong.onlinemovies.criteria.base.BaseGenericCriteria;
import pro.kinokong.onlinemovies.dtos.user.UserCreateDto;
import pro.kinokong.onlinemovies.dtos.user.UserDto;
import pro.kinokong.onlinemovies.dtos.user.UserUpdateDto;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.exceptions.BadRequestException;
import pro.kinokong.onlinemovies.exceptions.ResourceNotFoundException;
import pro.kinokong.onlinemovies.mappers.user.UserMapper;
import pro.kinokong.onlinemovies.repositories.user.UserRepository;
import pro.kinokong.onlinemovies.services.base.AbstractService;
import pro.kinokong.onlinemovies.validators.user.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<
        UserRepository,
        UserMapper,
        UserValidator
        > implements UserService{

    protected UserServiceImp(UserMapper mapper, UserValidator validator, UserRepository repository, PasswordEncoder passwordEncoder) {
        super(mapper, validator, repository);
        this.passwordEncoder = passwordEncoder;
    }
    private final PasswordEncoder passwordEncoder;

    @Override
    public String create(UserCreateDto dto) {
        User user = mapper.fromCreateDto(dto);
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            repository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new BadRequestException("bad request exception");
        }
        return user.getId();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(UserUpdateDto dto) {

    }

    @Override
    public UserDto get(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAll(BaseGenericCriteria criteria) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user not found by username"));
    }
}
