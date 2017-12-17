package org.wahlzeit.model;

public class KleinbaerPhotoManagerException extends RuntimeException {
    public String errorMsg;

    public KleinbaerPhotoManagerException(){
        super();
    }

    public KleinbaerPhotoManagerException(String msg){
        super(msg);
        this.errorMsg = msg;
    }
}
