package org.wahlzeit.model;

public class KleinbaerPhotoException extends RuntimeException {

    public String errorMsg;

    public KleinbaerPhotoException(){
        super();
    }

    public KleinbaerPhotoException(String msg){
        super(msg);
        this.errorMsg = msg;
    }
}
