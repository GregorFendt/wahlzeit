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
    protected KleinbaerPhotoFactory(){
        //do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize(){
        KleinbaerPhotoFactory.getInstance();
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
        assertInstanceIsNull();

        instance = photoFactory;
    }

    /**
     * @methodtype factory
     * @return creates a KleinbaerPhoto
     */
    public KleinbaerPhoto createPhoto(){
        KleinbaerPhoto photo = null;
        return new KleinbaerPhoto();
    }

    /**
     * @methodtype factory
     * @param id to be used for the KleinbaerPhoto
     * @return a newly created KleinbaerPhoto
     */
    public KleinbaerPhoto createPhoto(PhotoId id){
        return new KleinbaerPhoto(id);
    }

    public KleinbaerPhoto createPhoto(Kleinbaer.kleinbaerengenus genus){
        KleinbaerPhoto photo =  new KleinbaerPhoto(new Kleinbaer(genus));
        return photo;
    }


    public KleinbaerPhoto loadPhoto(PhotoId id){
        return null;
    }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that the KleinbaerPhotoFactory instance is null
     * @methodtype assertion
     * @throws KleinbaerPhotoFactoryException if KleinbaerPhotoFactory instance is null
     */
    static private void assertInstanceIsNull(){
        if(instance != null){
            throw new KleinbaerPhotoException("KleinbaerPhotoFactory instance mustn't be initialized twice!");
        }
    }

}
