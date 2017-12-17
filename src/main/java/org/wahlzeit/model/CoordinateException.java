package org.wahlzeit.model;

public class CoordinateException extends RuntimeException {

    public String errorMsg;

    public CoordinateException(){
        super();
    }

    public CoordinateException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

}
