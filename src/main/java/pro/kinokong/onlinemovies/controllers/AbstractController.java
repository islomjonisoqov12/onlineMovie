package pro.kinokong.onlinemovies.controllers;

import pro.kinokong.onlinemovies.services.base.BaseGenericService;

public abstract class AbstractController<S extends BaseGenericService> {

    protected final S service;
    protected final static String API = "/api";
    protected final static String VERSION = "/v1";
    public final static String PATH = API + VERSION;


    protected AbstractController(S service) {
        this.service = service;
    }
}
