package org.wahlzeit.model;

public class KleinbaerPhotoFactoryException extends RuntimeException {

    public String errorMsg;
    public RuntimeException propagatedException;

    public KleinbaerPhotoFactoryException(){
        super();
    }

    public KleinbaerPhotoFactoryException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

    public KleinbaerPhotoFactoryException(String msg, RuntimeException exception){
        super(msg);
        this.errorMsg = msg;
        this.propagatedException = exception;
    }
}
