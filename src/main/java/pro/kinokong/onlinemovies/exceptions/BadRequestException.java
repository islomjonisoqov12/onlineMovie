package pro.kinokong.onlinemovies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.kinokong.onlinemovies.exceptions.base.AbstractException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends AbstractException {

    public BadRequestException(String message) {
        super(message);
    }
}
