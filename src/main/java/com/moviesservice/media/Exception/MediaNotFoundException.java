package com.moviesservice.media.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Movie/Series")
public class MediaNotFoundException extends RuntimeException {

//    public MediaNotFoundException(String id) {
//
//        super("Media" + " id " + id + " not found");
//
//    }
//
//    public MediaNotFoundException(String flag) {
//        super("Media" + " id " + flag + " not found");
//    }

    public MediaNotFoundException(String id) {
        super("Media" + " id " + id + " not found");
    }

//    public MediaNotFoundException(String entity, Long id) {
//        super(entity + " id " + id + " not found");
//    }
}