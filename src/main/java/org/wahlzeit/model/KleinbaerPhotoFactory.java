/*
 *   Classname: KleinbaerPhotoFactory
 *
 *   Version: 1.0 [created while doing 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

/**
 * KleinbaerPhotoFactory creates KleinbaerPhotos
 */
public class KleinbaerPhotoFactory extends PhotoFactory{

    private static final Logger log = Logger.getLogger(KleinbaerPhotoFactory.class.getName());

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static KleinbaerPhotoFactory instance = null;

    /***
     *
     */
    public KleinbaerPhotoFactory(){
        super();
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize(){
        getInstance();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized KleinbaerPhotoFactory getInstance(){
        if(instance == null){
            log.config(LogBuilder.createSystemMessage().addAction("setting generic KleinbaerPhotoFacotry").toString());
            setInstance(new KleinbaerPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory
     */
    protected static synchronized void setInstance(KleinbaerPhotoFactory photoFactory){
        if(instance != null){
            throw new IllegalStateException("attempt to initalize KleinbaerPhotoFacotry twice");
        }

        instance = photoFactory;
    }

    /**
     * @methodtype factory
     * @return creates a KleinbaerPhoto
     */
    @Override
    public KleinbaerPhoto createPhoto(){
        return new KleinbaerPhoto();
    }

    /**
     * @methodtype factory
     * @param id to be used for the KleinbaerPhoto
     * @return a newly created KleinbaerPhoto
     */
    @Override
    public KleinbaerPhoto createPhoto(PhotoId id){
        return new KleinbaerPhoto(id);
    }

}
