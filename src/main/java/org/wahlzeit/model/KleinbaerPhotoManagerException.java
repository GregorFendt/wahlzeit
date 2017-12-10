package org.wahlzeit.model;

public class KleinbaerPhotoManagerException extends RuntimeException {
    public String errorMsg;
    public RuntimeException propagatedException;

    public KleinbaerPhotoManagerException(){
        super();
    }

    public KleinbaerPhotoManagerException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

    public KleinbaerPhotoManagerException(String msg, RuntimeException exception){
        super(msg);
        this.errorMsg = msg;
        this.propagatedException = exception;
    }
}
