package org.wahlzeit.model;

public class KleinbaerException extends RuntimeException {

    public String errorMsg;

    public KleinbaerException(){
        super();
    }

    public KleinbaerException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

}
