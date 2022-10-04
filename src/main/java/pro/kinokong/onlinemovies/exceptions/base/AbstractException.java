package pro.kinokong.onlinemovies.exceptions.base;

public class AbstractException extends RuntimeException implements BaseGenericException{

    public AbstractException(String message) {
        super(message);
    }
}
