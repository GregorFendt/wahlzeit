/*
 *   Classname: KleinbaerPhotoFactory
 *
 *   Version: 1.0 [created while doing 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */package org.wahlzeit.model;

/**
 * KleinbaerPhotoFactory creates KleinbaerPhotos
 */
public class KleinbaerPhotoFactory extends PhotoFactory{

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
