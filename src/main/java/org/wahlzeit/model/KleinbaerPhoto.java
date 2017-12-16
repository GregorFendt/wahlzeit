/*
 *   Classname: KleinbaerPhoto
 *
 *   Version: 1.0 [created while doing 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */
package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

/**
 * KleinbaerPhoto represents a Photo of a Kleinbaer {@link Kleinbaer}
 */
@Entity
@Subclass

public class KleinbaerPhoto extends Photo {

    /**
     *  The Kleinbaer in the Photo
     */
    private Kleinbaer kleinbaer;

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(){
        super();
    }

    /**
     * @methodtype initialization
     * @param kleinbaer which is in the Photo
     */
    public KleinbaerPhoto(Kleinbaer kleinbaer){
        super();

       assertKleinbaerNotNull(kleinbaer);
        this.kleinbaer = kleinbaer;
    }

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(PhotoId id){
        super(id);
    }

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(Kleinbaer kleinbaer, PhotoId id){
        super(id);
        assertKleinbaerNotNull(kleinbaer);
        this.kleinbaer = kleinbaer;
    }

    /**
     * @methodtype get
     * @return the Kleinbaer.class which is in the photo
     */
    public Kleinbaer getKleinbaer(){
        assertKleinbaerNotNull(kleinbaer);

        return kleinbaer;
    }

    /**
     * @methodtype set
     * @param kleinbaer is newly set for the photo
     */
    public void setKleinbaer(Kleinbaer kleinbaer){
        assertKleinbaerNotNull(kleinbaer);

        this.kleinbaer = kleinbaer;
    }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that the given Kleinbaer-class is not null
     * @methodtype assertion
     * @throws KleinbaerPhotoException if given Kleinbaer-class is null
     */
    private void assertKleinbaerNotNull(Kleinbaer kleinbaer){
        if(kleinbaer == null){
            throw new KleinbaerPhotoException("Kleinbaer-class mustn't be null");
        }
    }

}
