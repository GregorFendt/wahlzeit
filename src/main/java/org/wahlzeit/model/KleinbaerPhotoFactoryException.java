package org.wahlzeit.model;

public class KleinbaerPhotoFactoryException extends RuntimeException {

    public String errorMsg;

    public KleinbaerPhotoFactoryException(){
        super();
    }

    public KleinbaerPhotoFactoryException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

}
