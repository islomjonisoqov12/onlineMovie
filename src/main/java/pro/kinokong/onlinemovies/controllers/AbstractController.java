package pro.kinokong.onlinemovies.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import pro.kinokong.onlinemovies.dtos.exception.ExceptionDto;
import pro.kinokong.onlinemovies.services.base.BaseGenericService;

public abstract class AbstractController<S extends BaseGenericService> {

    protected final S service;
    protected final static String API = "/api";
    protected final static String VERSION = "/v1";
    public final static String PATH = API + VERSION;


    protected AbstractController(S service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append("\n");
        });
        errors.delete(errors.length()-1, errors.length());
        return new ResponseEntity<>(new ExceptionDto((request + "").substring(23, request.toString().indexOf(";client")), 400, errors.toString()), HttpStatus.BAD_REQUEST);
    }
}
