package pro.kinokong.onlinemovies.repositories.user;

import org.springframework.data.rest.core.annotation.RestResource;
import pro.kinokong.onlinemovies.entities.user.User;
import pro.kinokong.onlinemovies.repositories.base.AbstractRepository;

import java.util.Optional;

@RestResource(exported = false)
public interface UserRepository extends AbstractRepository<User, String> {
    Optional<User> findByUsername(String username);
}
