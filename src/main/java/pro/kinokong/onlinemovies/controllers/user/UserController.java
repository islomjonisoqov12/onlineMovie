package pro.kinokong.onlinemovies.controllers.user;

import pro.kinokong.onlinemovies.controllers.AbstractController;
import pro.kinokong.onlinemovies.services.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractController<UserService> {
    public UserController(UserService service) {
        super(service);
    }
}
