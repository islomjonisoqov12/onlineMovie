package pro.kinokong.onlinemovies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.kinokong.onlinemovies.exceptions.base.AbstractException;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceFoundException extends AbstractException {
    public ResourceFoundException(String message) {
        super(message);
    }
}
